# AiLauncher (com.stepos.ailauncher) 逆向分析报告

- 样本：`analysis/apks/AiLauncher.apk`（versionName 1.0.0_20261002_221513, compileSdk 36）
- 代码：`analysis/decompiled/AiLauncher/sources/`（jadx --no-res；`resources/AndroidManifest.xml` 为已解码文本，可直接阅读）
- 助手产品名：**Amoo**（`@mipmap/appicon_amoo`、字符串「需要先授予 Amoo Agent 访问权限。」）
- 本文所有相对路径均以 `analysis/decompiled/AiLauncher/` 为根。

---

## 1. AiLauncher 是什么

AiLauncher 是 StepOS 的**主智能体前端 + 本地任务执行中枢**，不是传统"桌面 Launcher"（那是 StepOSLauncher.apk）。它同时承担四个角色：

1. **对话前端（chat UI）**：`sources/com/stepos/ailauncher/chat/`、`sources/com/stepos/agentframework/chatui/`（AgentChatActivity、ChatMainActivity、锁屏聊天 LockScreenChatActivity、卡片 CardOpenSlideActivity、任务气泡/审批气泡等）。
2. **云脑协议端点**：内置 `agentframework` 框架，通过 `adapter/openclaw/OpenClawCoreAgentClient` 与 `adapter/agentbus/AgentBusCoreAgentClient` 两套客户端把用户消息发给 OpenClaw/AgentBus，并接收云端下发的 ToolCall 执行请求、回传工具结果（云脑-端手的"手"就在这里）。
3. **本地快车道（SLA）**：`com/stepos/ailauncher/sla/`（SlaGate/SlaRouter/SlaAtomicDispatcher），用端侧小模型（aiengine 的 `ISla.recognize`）与云端竞速执行 ~65 个系统级原子操作（闹钟/短信/设置/拨号/天气…）。
4. **MCP 服务端**：`com/stepos/ailauncher/agent/ability/VoiceAbilityService` 自己就是一个 MCP 工具服务（`com.stepos.mcp.sdk.TOOLS_SERVICE`），向云端暴露 `assistant_show_risk_statement`（授权/风险确认卡）等 4 个工具。

### 1.1 Manifest 关键组件（`resources/AndroidManifest.xml`）

**入口/服务**
- `com.stepos.ailauncher.GlobalApplication`（app）
- `chat.activity.ChatMainActivity` / `chat.AgentChatActivity`（`com.stepos.ailauncher.action.OPEN_CHAT`）
- `chat.activity.StepAssistantActivity`（`action.STEP_ASSISTANT`）
- `AIHOmeBarService`（`com.stepos.ailauncher.ISysUI2AILauncher`，SysUI 联动）
- `chat.wake.WakeService` + `StartBroadcastReceiver`：POWER_KEY_WAKE / AI_KEY_WAKE / LOCK_SCREEN_WAKE / NAVIGATION_WAKE / VOICE_WAKE / HEADSET_LONG_PRESS_WAKE / SHARE_WAKE 等全面唤醒入口
- `chat.voice.support.VoiceService` / `VoiceAssistantSupportService`（自定权限 `com.stepos.ailauncher.permission.VOICE_ASSISTANT`）
- `speech.asr.MicForegroundService`（前台麦克风服务）
- `container.AssistantService`（`com.android.launcher3.WINDOW_OVERLAY`，权限 `android.permission.INTERNAL_SYSTEM_WINDOW`）
- `notification.service.LiveNotificationService`（`com.android.systemui.LIVE_NOTIFICATION_SERVICE`，实时任务通知/卡片）
- `agent.ability.VoiceAbilityService`（MCP 工具服务，权限 `com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES`）
- `chat.wake.homebar.HomeBarLongPressGuideActivity`、锁屏链路 `chat.lockscreen.*`

**任务/空间**
- `task.detail.TaskDetailActivity` / `task.detail.ArtifactDetailActivity`（任务详情与产物）
- `task.space.AgentFileEditActivity` / `RepairWebActivity` / `RepairActivity` / `AmooMemoryActivity`（任务空间文件编辑、"修复"、Amoo 记忆）
- `taskstore.provider.TaskInfoCardProvider`（自定权限 `com.stepos.ailauncher.taskstore.permission.ACCESS_TASK_INFO`，向系统 UI 供任务卡片）
- `taskstore.livenotification.TaskLiveNotificationDismissReceiver`
- `agentframework.chatui.TaskRobotExecutePreviewActivity`（taskrobot 执行预览，见 §5）

**OOBE / 授权 / 政策**
- `oobe.AgreementActivity`、`RecordWakeWordActivity`、`SdkInitNameActivity`、`SdkInitSoulActivity`（人格初始化）、`AgentConfigActivity`、`WakeAnywhereActivity`
- `chat.activity.PermissionDialogActivity`（Android 运行时权限代理弹窗）
- `chat.activity.ExpressAuthDialogActivity`、`chat.activity.ConfiguringAgentActivity`
- `chat.activity.LocalPolicyActivity` / `PolicySheetActivity`、`policy.sdk.activity.PolicyHtmlViewerActivity` / `PolicyPermissionDesActivity`
- `mcpservice.risk.KeyguardUnlockActivity`（解锁场景确认）、`mcpservice.risk.notification.RiskStatementActionReceiver`（`com.stepos.ailauncher.mcpservice.risk.ACTION_USER_CHOICE`）
- `common.permission.PermissionProxyActivity`

**生态**
- `agent.aispace.*`：Agent 市场 / 已连接 agent / 扫码连接（`ScanQrActivity`、`ConnectExternalAgentActivity`）、飞书 `FeishuConnectActivity`、企微 `WecomConnectActivity`
- `agent.skill.*`：已安装技能 / 核心技能 / 技能详情
- `foundation.appui.card.provider.appauther.AppAutherRedirectActivity`（OAuth 回跳）、`alipay.AlipayXuiLiveClickReceiver`（支付宝 XUI 卡片）
- `perfbinder.service.PerfBinderProvider`（**exported=true 无权限保护**，authorities `com.stepos.ailauncher.PERF_BINDER_IPC_CALL`，值得关注的暴露面）

**关键权限（平台级特权）**：`MANAGE_EXTERNAL_STORAGE`、`DELETE_PACKAGES`、`MANAGE_ACTIVITY_TASKS`、`WRITE_SECURE_SETTINGS`、`INTERNAL_SYSTEM_WINDOW`、`START_ACTIVITIES_FROM_BACKGROUND`、`REAL_GET_TASKS`、`ACCESS_SURFACE_FLINGER`（虚拟屏取图）、`SYSTEM_ALERT_WINDOW`、`CAPTURE_AUDIO_OUTPUT`/`CAPTURE_AUDIO_HOTWORD`、以及跨 app 授权：`com.stepos.ability.permission.SCREEN_OPS`、`com.stepos.ability.permission.ACCESS_AGENT_SERVICE`、`com.stepos.ability.permission.ACCESS_VOICE_CONSENT`、`com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES`、`com.zeroclaw.android.permission.ZEROCLAW_IPC`、`com.stepos.agentcache.permission.WRITE_AGENT_CACHE`、`com.zyql.aios.stepclaw.permission.RECEIVE_TRASH_HOOK_RUN_FINISHED` 等 —— 典型的**系统签名特权应用**。

---

## 2. 智能体任务循环

### 2.1 消息发送（云脑侧）

`agentframework/chatcore/SessionHandler.java`（3956 行）是会话中枢；发送走 `chatcore/send/SendPipeline.java`：

1. `AuditStage`（`send/AuditStage.java`）：先做**内容审核**（`chatcore/audit/ContentAuditClient.auditPromptText`），命中则 `handleRunBlocked` / `RunBlockedEvent`、`RevertedSessionGuard` 回滚会话（`SessionHandler$handleBackgroundModeration$1`、`$finalizeAfterAuditRevert$5`）。
2. `SlaArbiter`（SendPipeline 字段 `slaArbiter`，即 `chatcore/send/j.java`）：与 SLA 快车道竞速（见 §3）。
3. `commitToCloud`（`SendPipeline$commitToCloud$1`）：经 `adapter/ApiManager` → `OpenClawCoreAgentClient`（ApiType.OPENCLAW）或 `AgentBusCoreAgentClient`（ApiType.AGENTBUS）发送。
   - 两条通路的物理承载相同：`com.zyql.agentfront.sdk.client.AgentFrontClient` binder 绑定 `com.zyql.agentfront/com.zyql.agentfront.service.MessageBridgeService`（`sources/com/zyql/agentfront/sdk/client/AgentFrontClient.java:492`），AgentBus 通过 `adapter/agentbus/ClawChannelAgentBusBinding.java` 复用同一条 Claw 通道。`com.zyql.agentfront` 不在本批反编译 APK 中（独立桥接应用，通向 ClawX 的 OpenClaw Gateway）。
   - 另有 `chatcore/safehint/SafeHintClient.isRisky(userInput, modelOutput)` 二次风险提示。

### 2.2 工具调用回传（云端 → 端侧）

云端大脑通过 push 下发 `ToolCallRequest`（`com/zyql/agentfront/bean/ToolCallRequest.java`，含 toolCallId / conversationId / toolName / arguments / traceId）：

- `OpenClawCoreAgentClient$g.c()`（onPushToolCall）→ `F0()` handleToolCall（`adapter/openclaw/OpenClawCoreAgentClient.java:377,501`）→ 通知 `pushMessageListener`（由 `ApiManager.j0()` 注入，最终接到 SessionHandler/AgentSession）。
- 消息类型 `chatcore/session/AgentMessageType.java`：TOOL / TASK / TASK_PLAN / TASK_UPDATE / TOOL_SHOW / TOOL_RESULT / MODERATION / **INQUIRY**（云端向用户提问/审批）。
- 普通工具（含 ability 提供的 19 个 mdi_* 屏幕自动化工具）大多由 **ClawX chroot 里的 OpenClaw Gateway 直接以 MCP 调 ability**（AiLauncher 不经手）；AiLauncher 经手的是需要 UI 呈现/交互的部分：
  - **GUI/虚拟屏任务**：`chatcore/intent/RobotManager.B(startType, arguments, modelId="doubao-1.5-ui-tars", startMode, surface, …)` → `AgentServiceClient.r0(taskId, GuiTaskConfig)` 提交给 ability（`chatcore/intent/RobotManager.java:72-117`）。
  - **非 GUI 原子操作**：`SlaAtomicDispatcher.k(function, text, params, extras, traceId, toolCallId)` → `AgentServiceClient` `submitTask`（`sla/SlaAtomicDispatcher.java:356`）。
  - **需要用户确认**：云端调用 AiLauncher 自己的 MCP 工具 `assistant_show_risk_statement`（§4）。
- 执行结果通过 `AgentServiceClient.o0(ToolResultRequest)` 回云（`OpenClawCoreAgentClient.F0`）。
- 任务事件回流：`chatcore/intent/TaskDispatcher$taskListener$1`（ITaskListener.Stub，注册到 ability）接收 `onTaskEvent(Task)` / `onToolCallEvent(ToolCallStart/Progress/Result)` / `onInfoRequested`（ability 主动向用户要输入，本版本 listener 为空实现"ignored: no infoListener set"）/ `onPackageConflict`。
- 云端提问（INQUIRY）：`chatui/ApprovalFrameRegistry`（askUserFrame，粘性去重）→ 用户点击 → `SessionHandler.A3(sessionId, requestId, decision, reason, askUserQuestion)`（`chatcore/SessionHandler.java:1036`）→ `adapter/agentbus/AgentBusTaskOpsKt$answerInquiry$2`（TaskInteractRequest）回答云端。

### 2.3 决策位置

**决策（规划/选工具）在云端大脑**（OpenClaw/AgentBus 侧的 LLM），AiLauncher 只做：发送、呈现、本地 SLA 竞速兜底、工具执行与结果回传。`SlaGate` 的 `Winner` 枚举（PENDING/SLA/BACKEND/CANCELLED）就是"端侧小模型 vs 云端"的竞速裁决。

---

## 3. SLA / 权限执行（核心问题）

### 3.1 结论先行

- **云端路径（OpenClaw/AgentBus 驱动的 mdi_* 等工具）**：AiLauncher **不查询** AgentSafetyCenter。授权交互由云端 agent **主动调用 AiLauncher 的 MCP 工具 `assistant_show_risk_statement`** 弹卡完成（§4）；是否调用是云端提示词/策略的责任，端侧对该路径无强制 SLA 闸门。
- **本地 SLA 快车道**：AiLauncher 作为**调用方**在派发前**主动查询**：`AgentServiceClient.L(functions)` → binder `IAgentServiceManager.checkSlaPermissionV1(functions)`（`sources/com/stepos/ability/IAgentServiceManager.java:152,251`）→ **ability 内的 SLA 权限引擎（o4/d.java）读取 AgentSafetyCenter 的 ledger/权限快照**，返回 `SlaPermissionResult(verdict, canExecute, denyReason, deniedFunction, reason, errorCode, details[含 redline], extra)`（`sources/com/stepos/ability/bean/SlaPermissionResult.java`）。
- 即：**判定逻辑在执行方（ability→AgentSafetyCenter），执行/遵守在调用方（AiLauncher）**；真正的硬边界只有 binder 级的 signature 权限 `com.stepos.ability.permission.ACCESS_AGENT_SERVICE`（谁有能力调工具），策略级检查（谁能做什么）仍是 honor-system（ mdi handler 内部不强制，与 ability 侧分析一致）。

### 3.2 调用链证据

`sla/SlaGate.java`（及 jadx --show-bad-code 重反编译 /tmp/sla2、/tmp/sla3）：

- `SlaGate.F(functions)` = checkSlaPermissionSafe：`J()` → `AgentServiceClient.f22085a.L(list)`（`SlaGate.java:1536-1586`，失败 250ms 重试 `LEDGER_CHECK_RETRY_MS`）→ `AgentServiceClient$checkSlaPermission$2` → `serviceManager.checkSlaPermissionV1(functions)`；binder 失败返回 `verdict=2, canExecute=false, errorCode=280004`。
- 主派发路径 `SlaGate$Race$listener$1$onSlaOutput$5.invokeSuspend`（重反编译）逐字日志分支：
  - `canExecute=true` → `"台账预检通过 functions=…"` → 逐动作 `SlaAtomicDispatcher.k()` → ability `submitTask`（多动作间若 race 被顶掉则 `"本轮在多动作间被顶掉 -> 停止剩余派发"`）。
  - `canExecute=false` 且不满足离线旁路 → `"台账拒绝 verdict=… -> 回云端"`（`race.h0()` routeToBackend，云端将走自己的 risk statement 流程）。
  - `canExecute=false` 且 `u.c(context, perm)` 成立 → `"台账不可用且无网 -> 放行本地执行 verdict=…"`（**offlineLedgerBypass，fail-open**）。
  - 查询抛异常 → `"台账检查抛异常 -> 回云端"`，或开关 `u.d()`（enabled && localDispatch）打开时 `"-> 放行本地执行"`。
  - 查询返回时本轮已失效 → `"台账检查结束时本轮已失效 -> 跳过全部派发"`。
- 解锁重放路径 `SlaGate.R()`（replayCachedDecisionAfterLedger，`/tmp/sla2/.../SlaGate.java:1855-2115`）：锁屏期间 SLA 判定被缓存（`E()` cacheForUnlock，`SLA_SCREEN_LOCKED` 只允许锁屏白名单功能），解锁后同样先 `F()` 查台账再派发；拒绝 → `P(proceed,…, "ledger-deny")` 回云。
- `Race.q0(decision, actionCount, awaitLedger=true)`（`SlaGate.java:297,884`）：SLA 胜出后置 `ledgerPending`，`f0()/p0()` 在台账检查完成前挂起结果配信 —— 权限检查是本地派发的**前置阻塞条件**。

### 3.3 旁路策略（`sla/u.java` + `sla/C3474c.java`）

```java
// u.a: verdict==2 或 denyReason∈{5,6,7} 视为"台账不可用"类
// u.b: enabled && localDispatch && offlineLedgerBypass && offline && !anyRedline && u.a(...)
// u.c(context, perm): 读网状态 + 遍历 details 找 redline
```

*English version:*

```java
// u.a: verdict==2 or denyReason∈{5,6,7} is treated as the "ledger unavailable" class
// u.b: enabled && localDispatch && offlineLedgerBypass && offline && !anyRedline && u.a(...)
// u.c(context, perm): read network state + iterate over details to find redline
```

- 四个全局开关默认全 true：`enabled / localDispatch / cloudFirstWhenOnline / offlineLedgerBypass`（`C3474c`）。
- **风险点**：断网 + 台账不可用 + 非 redline 功能 → **放行本地执行**（fail-open）；`redline` 标志（`SlaFunctionDetail.getRedline()`）是唯一硬排除项。

### 3.4 AiLauncher 侧的本地闸门（不依赖 AgentSafetyCenter）

- `sla/v.java`：端侧 SLA 只允许 ~65 个函数名白名单（alarm_clock_* / dialer_* / sms_* / settings_* / phone_note_* / weatherInfo / open_flash_light 等）；`slaUnsupported = {request_cloud_assist, request_gui_assist}` 强制回云；锁屏时仅 `lockScreenAllowed` 子集（约 50 项，多为只读 settings_get_* / 短信/闹钟/天气）可执行，否则 `SLA_SCREEN_LOCKED` 缓存待解锁重放。
- `sla/t.java`：INSTALL_GUARD —— 安装类函数若目标 app 已安装则拦截派发并伪造成功结果（防止重复安装/钓鱼安装）。
- `SlaAtomicDispatcher.n()/p()`：IPC 层检查自持权限 `com.stepos.ability.permission.ACCESS_AGENT_SERVICE`；若 ability 版本旧未声明该权限则"按有权限放行"。
- `SlaGate` 全链路 trace：`G.java`（sla_start / sla_judge_result(hit|fallback_openclaw) / sla_execute_result）+ `E5.a` 二级埋点（`ledgerDeny`、`ledgerBypass(offline)`、`replayLedgerBypass(checkThrown)` 等）。

---

## 4. 授权卡 / 确认 UI

### 4.1 MCP 工具 `assistant_show_risk_statement`（`agent/ability/VoiceAbilityService.java:419-526,722-748`）

VoiceAbilityService（继承 `com.stepos.mcp.sdk.java.service.AbsMCPService`，MCP over binder，服务权限 `ACCESS_MCP_SERVICES`）注册 4 个工具：

| 工具 | 作用 |
|---|---|
| `assistant_change_voice_id` | 切换 TTS 音色 |
| `assistant_get_voice_list` | 音色列表 |
| **`assistant_show_risk_statement`** | 风险/授权确认卡（阻塞等待用户选择） |
| `ailauncher_load_tripartite_common_card` | 加载三方通用卡片（XUI 模板刷新） |

*English version:*

| Tool | Purpose |
|---|---|
| `assistant_change_voice_id` | Switch TTS voice |
| `assistant_get_voice_list` | Voice list |
| **`assistant_show_risk_statement`** | Risk/authorization confirmation card (blocks while waiting for the user's choice) |
| `ailauncher_load_tripartite_common_card` | Load third-party generic card (XUI template refresh) |

`assistant_show_risk_statement` 参数：`level`（默认 medium）、`title`、`description`、`tags`（**必须 2~3 个按钮**）、`scene`（仅支持 `unlock`）、`timeoutMs`（默认 600000，钳制 30s~30min）；`sessionId/toolCallId/timeoutMs` 优先取 `_meta`。

按钮 tag（`c0()`，`VoiceAbilityService.java:750-774`）与 AgentSafetyCenter 的权限模式一一对应：
- `allow_once` →「仅此允许」（`R$string.perm_allow_once_agent`）
- `always_allow` →「总是允许」（Style.EMPHASIS）
- `reject` →「拒绝」（Style.REJECT）

用户选择结果以 MCP CallToolResult JSON 回给云端：`{"trace_id":…, "choice":"ALLOW_ONCE"|"ALWAYS_ALLOW"|"REJECT", "title":…, "level":…}`；超时/用户取消 → `isError=true` "user cancelled risk statement"。**也就是说 ask 模式的授权闭环 = 云端大脑调工具 + AiLauncher 弹 UI + 结果作为工具结果回云**；"总是允许"的选择由云端/台账侧记账（AgentSafetyCenter ledger 模式 allow/ask_always/ask_on_sensitive 与之呼应）。

### 4.2 呈现位置与协调

- `agent/ability/RiskCardHandoffCoordinator.java`（865 行）+ `chat/risk/RiskInlineHostPolicy.java`：三种宿主——聊天内联卡（inline）、**灵动岛**（island，需 SYSTEM_ALERT_WINDOW，无悬浮窗权限时降级，日志 "No overlay permission, cannot show dynamic island"）、弹窗 dialog；会话不在前台/已切走时 handoff 与重试（RetryTick: SwitchToInline/KeepRetrying/Stop）；锁屏聊天（LockScreenChatActivity）走 `mcpservice/risk/KeyguardUnlockActivity`（scene=unlock，设备已解锁则直接短路返回 `ALREADY_UNLOCKED`）；通知内选择经 `RiskStatementActionReceiver`（`ACTION_USER_CHOICE`）。
- 会话任务已全部终态时跳过 UI 直接返回（`sessionTasksAllTerminal`）。
- 埋点包装：`agent/ability/i.java`（dialog_permission_request_show / dialog_island_permission_show / click_permission_dialog / click_island_permission，click_result=allow|allow_once|deny）。

### 4.3 其他确认/授权 UI

- **INQUIRY 审批气泡**：`chatui/ApprovalFrameRegistry`（messageId→requestId→askUserFrame，粘性），`ApiManager.i0 sendApproval`，AgentBus `answerInquiry`。
- **Android 运行时权限**：`chat/activity/PermissionDialogActivity.java`（801 行，防重叠/防后台误弹/Recents 监控）+ `common/permission/`（PermScene: MICROPHONE/NOTIFICATION/PHONE_STATE/CAMERA/MEDIA，PermissionProxyActivity、PermissionHost/PermissionLaunchPolicy）。
- **账号/合规**：`chat/manager/AuthManager.java`（1759 行：登录、隐私协议、agent 开启、ExpressAuth、语音训练授权 VOICE_CONSENT_URI）；`foundation/credential`（AuthSessionDto）、`account/oauth`、飞书/企微授权连接页。

---

## 5. taskrobot 是什么

"taskrobot" = **虚拟屏 GUI 机器人（UI-TARS 类）在聊天内的嵌入式执行视图**：

- `agentframework/chatui/appui/taskrobot/RobotAppUIHostView.java`：宿主 View，内部 `b`（SurfaceView）或 `f`（TextureView）产出 `android.view.Surface`，字段 `pureVirtualScreen` 区分"纯虚拟屏/镜像"；Surface 变化回调 `RobotAppUIHostView$c/$d` → `RobotManager.I(taskId, toolCallId, surface)`（updateGuiAgent）→ `AgentServiceClient.r0(taskId, GuiTaskConfig)`。
- `chatcore/intent/RobotManager.java`：单例机器人管理器。`B()` 启动 GUI agent（默认模型 **doubao-1.5-ui-tars**）；`K() userTakeOver` / `G() unTakeOverGui`（用户接管/交还）、`q() fullScreenGui` / `o() dismissFullScreenOverlay` / `w() resumeFullScreenOverlay` / `D() stopTask`；`z()` 把机器人截图 Bitmap 存文件（saveRobotCaptureImageToFile）。
- `chatui/TaskRobotExecutePreviewActivity`（manifest 939 行）：全屏执行预览。
- `chatcore/intent/TaskRobotAction.java` + `robotAction/robotCommand` StateFlow：UI 双向动作通道。
- AgentSafetyCenter queries 中的 `com.stepos.taskrobot.settingsprovider`：该包不在本批反编译列表中（既不在 AiLauncher 也不在 ability），应为独立/未提取的 taskrobot 设置提供器（推测为 GUI 机器人的开关/偏好 SettingsProvider），AiLauncher 侧只承担 UI 宿主与控制。

## 6. 虚拟屏（MDI）任务完整生命周期

1. **发起**：云端下发 ToolCallRequest（GUI 类工具）→ SessionHandler → `RobotManager.B(startType, arguments, modelId, startMode, surface…)` 或 `TaskDispatcher.s(taskId, config, callback)`。
2. **配置下发**：`GuiTaskConfig(toolCallId, Surface, conversionId, guiTaskType, startMode, params, modelName, commonConfig)`（`ability/sdk/client/GuiTaskConfig.java`）经 binder `IAgentServiceManager`（submitTask / toolUpdateTask / updateTask）交给 ability；ability 以 system uid 创建 VirtualDisplay 并把目标 app 渲染进该 Surface（mdi_click/mdi_set_text/mdi_snapshot 即在此屏上执行，AiLauncher 持 `ACCESS_SURFACE_FLINGER`/`SCREEN_OPS` 配合）。
3. **执行中回调**（`TaskDispatcher$taskListener$1`）：
   - `onTaskEvent(Task)`，`TaskStatus`：CREATED→PENDING→RUNNING→(PAUSED)→COMPLETED/FAILED/CANCELLED/REMOVED，以及 **TAKE_OVER（用户接管）/ LLM_TAKE_OVER（大模型接管）/ RECOVER_FROM_TAKEOVER / SCREEN_SHOT（截图帧，bitmap 存档）/ EXPLAIN（解释快照 ExplainSnapshot）**；
   - `onToolCallEvent(ToolCallStart/Progress/Result)`（步骤级，`ability/bean/ToolCallEvent.java`）；
   - `onInfoRequested(taskId, requestId, inputType, message, payloadJson, timeoutMs, chatSessionId)`：ability 请求用户补充输入的通道（本版本 AiLauncher 未挂接 listener）；`onPackageConflict` 包冲突 → `confirmPackageConflict/cancelPackageConflict`；`onRequestRelaunch` 要求重启任务。
4. **用户干预**：userTakeOver (`l0`) / unTakeOverGui (`p0`) / fullScreenGui (`Q`) / resume (`d0`) / cancel (`G`)。
5. **收尾**：COMPLETED/FAILED/CANCELLED → `SlaAtomicDispatcher`/`TaskDispatcher` 组装结果 JSON（含 toolCallEvents）→ `AgentFrontClient.o0(ToolResultRequest)` 回云；孤儿 GUI 状态落库 `TaskDispatcher$persistOrphanGuiTaskStatus$1/$2`；`TaskInfoCardProvider` + `LiveNotificationService` 在系统 UI 呈实时任务卡。
6. **本地 SLA 路径**同样落 ability：`SlaAtomicDispatcher.k()` → `pending` Future + 60s 晚到清理 + `ITaskListener.onTaskEvent` 完成 Future（`SlaAtomicDispatcher.java:64-232`）。

## 7. 其他值得注意的安全设计 / 风险点

**设计亮点**
- 双通道内容审核前置（AuditStage + SafeHintClient），审核失败会回滚会话（RevertedSessionGuard）。
- SLA 全链路 trace_id 贯穿（E5.a / G 埋点），权限决策（ledgerDeny/ledgerBypass）有审计痕迹。
- 锁屏白名单 + 解锁重放缓存（防锁屏误执行）；INSTALL_GUARD 防重复安装。
- 组件普遍用自定义 signature 权限收口（VOICE_ASSISTANT、INTERNAL_BROADCAST、ACCESS_TASK_INFO、ACCESS_SETTINGS、ACCESS_MCP_SERVICES）。
- ability 侧 `checkAppWhitelistV1` / `isAppOccupiedV1`（app 白名单与占用检查）供前端调用。

**风险点**
1. **SLA offline fail-open**：`offlineLedgerBypass`（断网+台账不可用即放行，仅 redline 排除）——离线状态下权限模型退化为端侧白名单。
2. **云端工具路径无端侧强制闸门**：`assistant_show_risk_statement` 只是"工具"，恶意/被提示注入的云端规划若不调用它，mdi_* 直接经 ability 执行（ability handler 内亦无强制检查）——整条链路的策略执行依赖调用方自觉 + gateway 侧约束。
3. `SlaAtomicDispatcher.p()`：目标权限未被任何包声明时"按有权限放行"（兼容旧版本的 fail-open）。
4. `PerfBinderProvider` exported=true 且无权限保护。
5. 大量系统级权限集中于该 app（WRITE_SECURE_SETTINGS、MANAGE_ACTIVITY_TASKS、REAL_GET_TASKS、CAPTURE_AUDIO_OUTPUT…），一旦 AiLauncher 被侵入即等同系统 shell 级能力。
6. 三方生态面广：扫码连外部 agent、飞书/企微 OAuth、Alipay/Didi XUI 实况卡——凭证与卡片注入面较大（`foundation/credential`、`appauther` 回跳）。

---

## 附：关键文件索引
- SLA：`sources/com/stepos/ailauncher/sla/{SlaGate,SlaRouter,SlaAtomicDispatcher,v,u,w,t,C3474c,G}.java`
- 权限查询 AIDL：`sources/com/stepos/ability/IAgentServiceManager.java`（`checkSlaPermissionV1`=TRNSACTION 26）、`sources/com/stepos/ability/bean/SlaPermissionResult.java`、`sources/com/stepos/ability/sdk/client/AgentServiceClient.java:528`
- MCP 授权卡：`sources/com/stepos/ailauncher/agent/ability/VoiceAbilityService.java`、`mcpservice/risk/*`、`chat/risk/RiskInlineHostPolicy.java`
- 云端通路：`sources/com/stepos/agentframework/adapter/{openclaw/OpenClawCoreAgentClient,agentbus/AgentBusCoreAgentClient,ApiManager}.java`、`sources/com/zyql/agentfront/sdk/client/AgentFrontClient.java`
- 任务循环：`sources/com/stepos/agentframework/chatcore/{SessionHandler,send/SendPipeline}.java`、`chatcore/intent/{RobotManager,TaskDispatcher}.java`
- 虚拟屏：`sources/com/stepos/ability/sdk/client/GuiTaskConfig.java`、`agentframework/chatui/appui/taskrobot/RobotAppUIHostView.java`
- Manifest：`resources/AndroidManifest.xml`
