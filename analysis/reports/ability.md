# StepOS 能力中心 com.stepos.ability 逆向分析报告

- 分析对象：`com.stepos.ability`（能力中心，versionName 1.1.2_20261003_004257，versionCode 101002）
- 反编译位置：`analysis/decompiled/ability/`（sources/ 为 jadx Java 源码，resources/ 含 AndroidManifest.xml 与 res/raw）
- 分析重点：智能体工具面 + 安全策略
- 关键源码根：`sources/com/stepos/`（包名保留，类名部分混淆）、`sources/com/mdisdk/`（MDI 自动化 SDK）、`sources/o4/`、`sources/s4/`、`sources/M/`（SLA 权限策略引擎混淆后的实现）

---

## 0. 总体定位

`com.stepos.ability` 是 StepOS 智能体的**能力/工具实现中枢**，它同时承担四个角色：

1. **MCP 工具服务器**：对外（系统内签名应用 + 持 api_key 的第三方应用）提供 19 个 `mdi_*` UI 自动化工具（`TaskRobotMCPService` + 自建 HTTP MCP Server + `McpHandshakeProvider`）。
2. **任务/能力管理服务**：`AgentService`（AIDL）提供任务提交、能力查询、SLA 权限检查、授权卡结果回传等接口。
3. **UI 自动化执行引擎**：内嵌 MDI SDK（虚拟显示屏 + `InputManager.injectInputEvent` 反射注入 + UI 树快照），可以在**用户无感知的虚拟屏**上完整操作任意 App。
4. **SLA 权限策略客户端**：从 `com.stepos.agentsafetycenter`（AgentSafetyCenter）拉取"函数→scope 映射（Ledger）"与"权限模式表"，做 fail-closed 的函数级权限判定（含 redline 红线）。

**系统级身份**：manifest 声明 `android:sharedUserId="android.uid.system"`，即以 **system UID** 运行，这是它能 `INJECT_EVENTS`、`READ_FRAME_BUFFER`、`CAPTURE_SECURE_VIDEO_OUTPUT`、`REAL_GET_TASKS` 的前提。

---

## 1. AndroidManifest.xml 分析

文件：`resources/AndroidManifest.xml`

### 1.1 身份与签名

```xml
android:sharedUserId="android.uid.system"
android:package="com.stepos.ability"
```

### 1.2 自定义权限（共 8 个）

| 权限 | protectionLevel | 用途 |
|---|---|---|
| `com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES` | system\|signature | 绑定 MCP 工具服务（AIDL 通道） |
| `com.stepos.ability.permission.ACCESS_AGENT_SERVICE` | knownSigner\|system\|signature（knownCerts=@array/agent_service_known_certs） | 绑定 AgentService（能力中枢 AIDL） |
| `com.stepos.ability.permission.ACCESS_VOICE_CONSENT` | signature | 语音唤醒授权读写 |
| `com.stepos.ability.permission.CONTROL_VOICE_WAKEUP` | signature | 语音唤醒状态控制 |
| `com.stepos.taskrobot.permission.ACCESS_SETTINGS` | signature | TaskRobot 设置 provider |
| `com.stepos.ability.permission.SCREEN_OPS` | signature | 主屏 UI 文本读写服务（ScreenOps） |
| `com.stepos.taskrobot.vdbroadcast.permission.VD_TASK` | signature | 虚拟屏任务广播 |
| `com.stepos.ability.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | signature | 系统生成 |

*English version:*

| Permission | protectionLevel | Purpose |
|---|---|---|
| `com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES` | system\|signature | Bind to the MCP tool service (AIDL channel) |
| `com.stepos.ability.permission.ACCESS_AGENT_SERVICE` | knownSigner\|system\|signature (knownCerts=@array/agent_service_known_certs) | Bind to AgentService (capability hub AIDL) |
| `com.stepos.ability.permission.ACCESS_VOICE_CONSENT` | signature | Read/write voice wakeup authorization |
| `com.stepos.ability.permission.CONTROL_VOICE_WAKEUP` | signature | Control voice wakeup state |
| `com.stepos.taskrobot.permission.ACCESS_SETTINGS` | signature | TaskRobot settings provider |
| `com.stepos.ability.permission.SCREEN_OPS` | signature | Main-screen UI text read/write service (ScreenOps) |
| `com.stepos.taskrobot.vdbroadcast.permission.VD_TASK` | signature | Virtual display task broadcast |
| `com.stepos.ability.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | signature | System-generated |

### 1.3 exported 组件清单

| 组件 | 类型 | 权限保护 | 说明 |
|---|---|---|---|
| `com.stepos.ability.mcpserver.handshake.McpHandshakeProvider` | provider | **无（代码内自防）** | authorities `com.stepos.ability.mcp`，MCP 客户端握手入口（下发端口+nonce，绑定 api_key↔uid） |
| `com.stepos.ability.service.AgentService` | service | ACCESS_AGENT_SERVICE | 能力中枢 AIDL（BIND_AGENT_SERVICE） |
| `com.stepos.taskrobot.ability.TaskRobotMCPService` | service（`:mcp` 进程） | ACCESS_MCP_SERVICES | MCP 工具 AIDL（TOOLS_SERVICE），meta-data 指向 `@raw/mcp_tools`、`@raw/tools_ext` |
| `com.stepos.ability.screenops.service.ScreenOpsServiceImpl` | service | SCREEN_OPS | 主屏文本读写（com.screenops.BIND_SERVICE） |
| `com.stepos.ability.screenops.service.RegistrationReceiver` | receiver | SCREEN_OPS | 屏幕规则注册/注销 |
| `com.stepos.taskrobot.vdbroadcast.VdTaskReceiver` | receiver（`:mcp`） | VD_TASK | START_TASK / CANCEL_TASK 广播启动自动化任务 |
| `com.stepos.taskrobot.settingsprovider.SettingsContentProvider` | provider | ACCESS_SETTINGS | 设置/白名单缓存 |
| `com.stepos.ability.voicewakeup.VoiceWakeupStateProvider` | provider | CONTROL_VOICE_WAKEUP | 语音唤醒状态 |
| `com.stepos.ability.voicewakeup.VoicePermissionProvider` | provider | ACCESS_VOICE_CONSENT | `content://com.stepos.ability.voicewakeup.permission/consent` 语音授权状态 |
| `com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity` | activity | ACCESS_VOICE_CONSENT | 语音唤醒设置页 |
| `com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity` | activity | ACCESS_VOICE_CONSENT | 唤醒词选择页 |
| `com.stepos.agentframework.adapter.bff.DemoAct` | activity | **无** | BFF 调试 Activity（空实现，仅 demo 回调；暴露面小但属多余 exported） |
| `androidx.profileinstaller.ProfileInstallReceiver` | receiver | android.permission.DUMP | 系统库自带 |

*English version:*

| Component | Type | Permission protection | Description |
|---|---|---|---|
| `com.stepos.ability.mcpserver.handshake.McpHandshakeProvider` | provider | **None (self-defended in code)** | authorities `com.stepos.ability.mcp`, MCP client handshake entry (hands out port+nonce, binds api_key↔uid) |
| `com.stepos.ability.service.AgentService` | service | ACCESS_AGENT_SERVICE | Capability hub AIDL (BIND_AGENT_SERVICE) |
| `com.stepos.taskrobot.ability.TaskRobotMCPService` | service (`:mcp` process) | ACCESS_MCP_SERVICES | MCP tool AIDL (TOOLS_SERVICE), meta-data points to `@raw/mcp_tools`, `@raw/tools_ext` |
| `com.stepos.ability.screenops.service.ScreenOpsServiceImpl` | service | SCREEN_OPS | Main-screen text read/write (com.screenops.BIND_SERVICE) |
| `com.stepos.ability.screenops.service.RegistrationReceiver` | receiver | SCREEN_OPS | Screen rule registration/unregistration |
| `com.stepos.taskrobot.vdbroadcast.VdTaskReceiver` | receiver (`:mcp`) | VD_TASK | START_TASK / CANCEL_TASK broadcasts to start automation tasks |
| `com.stepos.taskrobot.settingsprovider.SettingsContentProvider` | provider | ACCESS_SETTINGS | Settings/whitelist cache |
| `com.stepos.ability.voicewakeup.VoiceWakeupStateProvider` | provider | CONTROL_VOICE_WAKEUP | Voice wakeup state |
| `com.stepos.ability.voicewakeup.VoicePermissionProvider` | provider | ACCESS_VOICE_CONSENT | `content://com.stepos.ability.voicewakeup.permission/consent` voice authorization state |
| `com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity` | activity | ACCESS_VOICE_CONSENT | Voice wakeup settings page |
| `com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity` | activity | ACCESS_VOICE_CONSENT | Wakeup word selection page |
| `com.stepos.agentframework.adapter.bff.DemoAct` | activity | **None** | BFF debug Activity (empty implementation, demo callbacks only; small exposure but a redundant export) |
| `androidx.profileinstaller.ProfileInstallReceiver` | receiver | android.permission.DUMP | Bundled with the system library |

**注意：本 APK 自身没有声明任何 AccessibilityService**（无障碍能力不在此 manifest 内；屏幕感知/视图树来自外部 `com.zyql.screenperception.api`，输入注入走 MDI 的 InputManager 反射）。但声明了 `uses-permission android.permission.BIND_ACCESSIBILITY_SERVICE`（用于绑定他人服务）。

### 1.4 高权限 uses-permission（安全敏感）

- `android.permission.INJECT_EVENTS` — **注入触摸/按键事件**（UI 自动化的根基）
- `android.permission.READ_FRAME_BUFFER` / `ACCESS_SURFACE_FLINGER` / `CAPTURE_VIDEO_OUTPUT` / `CAPTURE_SECURE_VIDEO_OUTPUT` — **截屏（含安全屏）**
- `android.permission.REAL_GET_TASKS` / `GET_TASKS` — 获取真实任务栈
- `android.permission.SYSTEM_ALERT_WINDOW`、`REQUEST_INSTALL_PACKAGES`、`RECORD_AUDIO`、`MANAGE_EXTERNAL_STORAGE`、`READ_MEDIA_*`、`MANAGE_MEDIA`
- `com.zyql.permission.BIND_SCREEN_SERVICE / BIND_VIEW_TREE_SERVICE / BIND_FUSION_SERVICE / BIND_CAPTURE_OCR_SERVICE` — 绑定 zyql 屏幕感知全家桶
- `com.stepos.agentsafetycenter.permission.READ_AGENT_PERMISSIONS`、`READ_AGENT_LEDGER` — **读取 AgentSafetyCenter 权限与账本**
- `com.zeroclaw.android.permission.ZEROCLAW_IPC`、`com.stepos.agentcache.permission.WRITE_AGENT_CACHE`、`com.stepos.permission.DataService` 等生态内权限

### 1.5 queries 可见性

显式查询 `com.stepos.agentsafetycenter`、`com.zyql.screenperception.api`、`com.zyql.ability`、`com.zyql.agentfront`、`stepai.android.mindx.sdk`、`com.stepos.agentpack`、`com.stepos.dataservice`、`com.zeroclaw.android`、`com.stepos.ailauncher.state.provider` 等，勾勒出完整智能体生态拓扑。

---

## 2. MCP 工具清单（19 个）

定义文件：
- `resources/res/raw/mcp_tools.json`（工具名、中文描述、inputSchema）
- `resources/res/raw/tools_ext.json`（分类 classification 与 timeout，全部 60s）
- 注册代码：`sources/com/stepos/taskrobot/ability/TaskRobotMcpTool.java`（枚举，静态块注册 19 个工具）→ `TaskRobotMCPService.initToolHandlers()`（`sources/com/stepos/taskrobot/ability/TaskRobotMCPService.java`）调用 `mcpServer.addToolHandler(name, handler)`

### MDI/Task（2）
| 工具 | 功能 |
|---|---|
| `mdi_task_create` | 创建自动化任务，自动创建并绑定**虚拟显示屏**作为执行环境；同名复用或重建 |
| `mdi_task_finish` | 结束任务并释放虚拟屏等资源（ignoreActions 控制是否立即中断） |

*English version:*

| Tool | Function |
|---|---|
| `mdi_task_create` | Creates an automation task, automatically creating and binding a **virtual display** as the execution environment; reuses or rebuilds for the same name |
| `mdi_task_finish` | Ends the task and releases the virtual display and other resources (ignoreActions controls whether to interrupt immediately) |

### MDI/App（3）
| 工具 | 功能 |
|---|---|
| `mdi_open_app` | 在虚拟屏上启动指定包名应用 |
| `mdi_move_app` | 把应用跨屏移动到指定 DisplayId（虚拟屏 ↔ 主屏） |
| `mdi_top_app` | 查询指定屏的栈顶应用包名 |

*English version:*

| Tool | Function |
|---|---|
| `mdi_open_app` | Launches the app with the given package name on the virtual display |
| `mdi_move_app` | Moves an app across displays to the specified DisplayId (virtual display ↔ main screen) |
| `mdi_top_app` | Queries the top-of-stack app package name on the specified display |

### MDI/Input（10）
| 工具 | 功能 |
|---|---|
| `mdi_click` | 点击：x/y 坐标或按 contentDesc/text 在 UI 树定位元素后点击 |
| `mdi_tap` | 与 mdi_click 完全重复（官方描述自述"建议合并"） |
| `mdi_long_click` | 长按（默认 1000ms） |
| `mdi_swipe` | 滑动手势（起止坐标+时长+步数） |
| `mdi_fling` | 快速惯性滑动（速度矢量） |
| `mdi_scale` | 双指缩放/捏合 |
| `mdi_set_text` | 向指定坐标的输入框（EditText）写入文本 |
| `mdi_key_event` | 注入任意 KeyCode 按键事件 |
| `mdi_back` / `mdi_home` | 返回键 / Home 键 |
| `mdi_wait` | 等待（上限 30s） |

*English version:*

| Tool | Function |
|---|---|
| `mdi_click` | Click: by x/y coordinates, or locate the element in the UI tree by contentDesc/text and click it |
| `mdi_tap` | Fully duplicates mdi_click (the official description itself notes "recommend merging") |
| `mdi_long_click` | Long press (default 1000ms) |
| `mdi_swipe` | Swipe gesture (start/end coordinates + duration + steps) |
| `mdi_fling` | Fast inertial fling (velocity vector) |
| `mdi_scale` | Two-finger zoom/pinch |
| `mdi_set_text` | Writes text into the input field (EditText) at the given coordinates |
| `mdi_key_event` | Injects an arbitrary KeyCode key event |
| `mdi_back` / `mdi_home` | Back key / Home key |
| `mdi_wait` | Wait (up to 30s) |

### MDI/Vision（2）
| 工具 | 功能 |
|---|---|
| `mdi_capture` | 对虚拟屏上目标应用**截图**，返回 PNG base64（可识别界面） |
| `mdi_snapshot` | 获取**UI 视图树快照**（扁平化文本树：控件类型/坐标/文本） |

*English version:*

| Tool | Function |
|---|---|
| `mdi_capture` | Takes a **screenshot** of the target app on the virtual display, returns PNG base64 (the UI can be recognized) |
| `mdi_snapshot` | Gets a **UI view tree snapshot** (flattened text tree: widget type/coordinates/text) |

### MDI/Sys（1）
| 工具 | 功能 |
|---|---|
| `mdi_ime_enable` | 控制虚拟屏 IME 所有权开关 |

*English version:*

| Tool | Function |
|---|---|
| `mdi_ime_enable` | Toggles IME ownership on the virtual display |

工具描述本身用中文写明用户话术示例（"点一下确定按钮"等），面向语音/LLM 调用。

实现核心：`sources/com/stepos/taskrobot/ability/a.java`（MdiAbility，混淆类）持有 `com.mdisdk.TaskManager` 任务池；`Z5/a.java` 为任务包装。过期任务清理：10 分钟（600000ms）无活动自动 finish（`a.a()`），受保护任务（`protectedTasks` 集合 `d`）跳过清理。

---

## 3. 工具执行链路与安全门控

### 3.1 通道一：系统内 AIDL（TaskRobotMCPService）

```
签名/系统应用 --bind TOOLS_SERVICE--> TaskRobotMCPService (:mcp 进程)
    └ AbsMCPService.MCPServiceBinder.register/request
        └ enforceCallerHasPermission():  // sources/com/stepos/mcp/sdk/java/service/AbsMCPService.java:86
             checkCallingPermission("com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES") != 0 → SecurityException
```

*English version:*

```
Signed/system app --bind TOOLS_SERVICE--> TaskRobotMCPService (:mcp process)
    └ AbsMCPService.MCPServiceBinder.register/request
        └ enforceCallerHasPermission():  // sources/com/stepos/mcp/sdk/java/service/AbsMCPService.java:86
             checkCallingPermission("com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES") != 0 → SecurityException
```

**门控点**：每次 `register/request/unregister` 都做调用方权限检查（system|signature 级权限）。**通过后 mdi_* 工具 handler 内部只有参数校验（缺参返回 20001/20101 错误码），没有任何 SLA/用户确认检查**（见 `TaskRobotMcpTool.java` 各 AnonymousClass 的 invokeSuspend）。

### 3.2 通道二：本地 HTTP MCP Server + api_key 握手（面向第三方应用）

组件：`com/stepos/ability/mcpserver/`（McpServerInit、endpoint/、executor/、security/、handshake/）

1. **握手**（`McpHandshakeProvider`，`content://com.stepos.ability.mcp/handshake`，exported 无清单级权限）：
   - 拒绝 uid < 10000（非 app uid）；
   - `HandshakeGate` 限流（每 uid）；
   - 服务未 Running 拒绝；
   - query 参数 `api_key` → `AppIdentityResolver` 用 `getPackagesForUid` 解析调用方包名 → `CallerIdentityRegistry` 建立 **api_key ↔ (package, uid) 绑定**；key 重绑定（同 key 换 uid/包）会打日志 "possible key leak / binding hijack"；
   - 返回 Cursor：`[port, serverNonce]`。
   - `McpPackageChangeReceiver`（k4/s.java）监听 PACKAGE_REPLACED / PACKAGE_FULLY_REMOVED，清除过期身份绑定。
2. **鉴权**：`BearerAuthenticator` + `KeyValidator`（`CachingKeyValidator`/`RemoteKeyValidator$HttpTransport` 远端校验，带正/负 TTL 缓存）。`McpServerModule$provideKeyValidator$1` 提供本机包身份回退（resolveSelf）。
3. **工具调用**：`endpoint/a.java`（JsonRpcRouter 主体）
   - 支持 JSON-RPC `tools/call` 与 `tools/batch`（DAG 依赖调度 `BatchExecutor`）；
   - **逐 caller 工具 scope 检查**：越权工具返回 403 `"Tool out of caller scope: <tool>"`；
   - **RateLimiter**：per-callerKey 令牌桶（rateLimitPerMinute / burst），batch 按任务数扣减；
   - 会话管理（SessionManager，idle timeout）。
4. 配置：`McpServerConfig`（bindHost/port/限流/握手配额/key TTL 等 23 项，DI 提供）。

### 3.3 通道三：AgentService（能力中枢 AIDL）

`sources/com/stepos/ability/service/AgentService.java`（exported，ACCESS_AGENT_SERVICE=knownSigner|system|signature）：

- 每个 binder 方法先 `enforceAccessPermission()`（同 UID 放行，否则 enforce ACCESS_AGENT_SERVICE）；
- 任务类操作再 `enforceTaskOwnerIfRegistered(taskId)`：任务注册时记录 callingUid（`TaskRegistry.register(internalTask, callingUid)`），非属主 UID 抛 `SecurityException("Caller uid X is not the owner of task ...")`。

对外接口（IAgentServiceManager）关键项：

| 方法 | 安全语义 |
|---|---|
| `checkSlaPermissionV1(functions)` | **函数级 SLA 权限检查**（详见 3.4） |
| `checkAppWhitelistV1(appName)` | 应用白名单检查（ALLOWED/REDIRECT/FAILED） |
| `submitPermissionAuthResult(agreed, toolCallId, extras)` | **授权卡（用户确认弹窗）结果回传**，驱动挂起的工具调用继续/取消 |
| `submitTask / updateTask / updateTaskStatusAndControl` | 任务生命周期（pause/resume/cancel/takeOver/unTakeOver） |
| `isAppOccupiedV1 / getMainDisplayTopAppHistory / listActiveTasks` | 任务占用与状态查询 |
| `submitUserInput / fullScreenGui / voiceInput` | GUI/语音交互面 |

*English version:*

| Method | Security semantics |
|---|---|
| `checkSlaPermissionV1(functions)` | **Function-level SLA permission check** (see 3.4 for details) |
| `checkAppWhitelistV1(appName)` | App whitelist check (ALLOWED/REDIRECT/FAILED) |
| `submitPermissionAuthResult(agreed, toolCallId, extras)` | **Returns the authorization card (user confirmation dialog) result**, driving the pending tool call to continue/cancel |
| `submitTask / updateTask / updateTaskStatusAndControl` | Task lifecycle (pause/resume/cancel/takeOver/unTakeOver) |
| `isAppOccupiedV1 / getMainDisplayTopAppHistory / listActiveTasks` | Task occupancy and status queries |
| `submitUserInput / fullScreenGui / voiceInput` | GUI/voice interaction surface |

### 3.4 SLA 权限引擎（函数级门控，安全策略核心）

实现：`sources/o4/d.java`（SlaPermissionManagerImpl，实现 `com/stepos/ability/api/ability/permission/ISlaPermissionManager.java`），规则引擎在 `sources/M/a.java` 的 `R()`/`j0()`/`m0()`，模型在 `sources/s4/`（e=LedgerRules、f=ModeTable、g=PolicyDetail、h=PolicyVerdict、a/b/c=Resolution 变体）。

判定流程（`M.a.R`）：

```
checkSlaPermission(functions)
  ├─ 空列表 → abstain(allow)
  ├─ 无 mapping 快照 → DENY(6 noMappingSnapshot)   ← fail-closed
  ├─ 无 mode 快照   → DENY(5 noModeSnapshot)         ← fail-closed
  ├─ 逐函数 j0(): LedgerRules 解析 scope+groupId → ModeTable 查该组当前 mode → PolicyDetail(allowed, redline, dataLevel)
  ├─ 全部 allowed → ALLOW
  ├─ 任一 denied → DENY(denyReason, deniedFunction, reason)
  └─ 任何异常 → DENY(5, "internal error")            ← fail-closed（"checkSlaPermission threw -> DENY(fail-closed)"）
```

*English version:*

```
checkSlaPermission(functions)
  ├─ empty list → abstain(allow)
  ├─ no mapping snapshot → DENY(6 noMappingSnapshot)   ← fail-closed
  ├─ no mode snapshot   → DENY(5 noModeSnapshot)         ← fail-closed
  ├─ per-function j0(): LedgerRules resolves scope+groupId → ModeTable looks up the group's current mode → PolicyDetail(allowed, redline, dataLevel)
  ├─ all allowed → ALLOW
  ├─ any denied → DENY(denyReason, deniedFunction, reason)
  └─ any exception → DENY(5, "internal error")            ← fail-closed ("checkSlaPermission threw -> DENY(fail-closed)")
```

denyReason 语义（`M.a.m0`）：`1=mode`（模式未开）、`2=redline`（**红线函数**）、`3=unknownFunction`（账本无此函数）、`4=scopeMissing`、`5=noModeSnapshot`、`6=noMappingSnapshot`、`7=stale`。错误码统一 `SLA_UNAUTHORIZED=280004`（`com/stepos/ability/bean/SlaPermissionResultKt.java`）。

`SlaFunctionDetail(function, scope, groupId, mode, redline, allowed)` — 每个受控函数带 **redline（红线）与 dataLevel（数据等级）** 属性。

缓存与刷新（`com/stepos/ability/permission/cache/`）：
- `MappingCache`（a.java）：函数→scope 映射（Ledger），24h 安全网轮询；
- `ModeCache`（b.java）：权限模式表，12h 安全网轮询；注册 ContentObserver 监听 `content://com.stepos.agentsafetycenter.permission/snapshot`（通知推送刷新，失败降级为轮询）；
- `RefreshScheduler`（c.java）：**按 denyReason 定向刷新**——deny(mode)→强制刷 mode（60s 节流）；deny(unknownFunction)→强制刷 mapping（30min 节流）；deny(noModeSnapshot/noMappingSnapshot)→绕过节流立即刷新；
- `onAuthCardDecided(toolCallId)`：用户在授权卡上做决定后触发"post-card refresh"（`RefreshScheduler$onAuthCardDecided`）。

**重要安全观察**：`checkSlaPermission` 在本 APK 内的调用点只有 `AgentService.checkSlaPermissionV1`（供外部调用方查询）与 SDK client —— **mdisdk 工具执行路径本身不强制经过 SLA 检查**；SLA 是供编排方（如 AILauncher/agentfront）在发起工具调用前查询的建议性门控，真正的强制点（若有）应在调用方或云端。

### 3.5 授权卡（用户确认）机制

- 入口：`AgentService.submitPermissionAuthResult(agreed, toolCallId, extras)` → `TaskExecutor(f.java).submitPermissionAuthResult` → TOOL executor（`com/stepos/ability/task/executor/`）恢复/拒绝挂起的工具调用；
- `ISlaPermissionManager.onAuthCardDecided(toolCallId)` 联动权限缓存刷新（用户可能在卡上改模式）；
- `ToolCallEvent` 经 `submitToolCallEvent` 上报，授权卡 UI 由前端（AILauncher 等）渲染。

### 3.6 其它门控

- `ScreenOpsServiceImpl`（exported，SCREEN_OPS signature）：主屏 `getEditContent/setEditContent/setEditContentBatch`（遍历全屏 EditText 读/写文本，`findAllEditTexts/collectEditTexts`，写入走 `UiCapabilityManager.setTextWithTags`）——签名应用可读写主屏任意输入框内容；
- `SettingsContentProvider`（ACCESS_SETTINGS signature）、`VdTaskReceiver`（VD_TASK signature）等均有清单级保护；
- 应用白名单：`com/stepos/taskrobot/appwhitelist/engine/AppWhitelistEngine.java` —— 云端 manifest（Mock 源 `MockWhitelistRemoteSource` + 磁盘缓存）定义 AppEntry(enabled, recommendations)；不在清单 → FAILED(2)；已装且 enabled → ALLOWED(0)；否则找推荐替代 → REDIRECT(1)。用于限制自动化可操作的目标 App。

---

## 4. UI 自动化 / 模拟点击能力（有，且非常完整）

1. **输入注入**：`sources/com/mdisdk/capability/input/adapter/InputManagerAdapter.java` 通过**反射**获取 `InputManager.getInstance()` 与 `injectInputEvent(InputEvent, mode[, displayId, ...])`，配合 manifest 的 `android.permission.INJECT_EVENTS` + system UID 实现任意屏注入。手势执行器：`com/mdisdk/capability/input/impl/gesture/`（Swipe/Fling/Pinch GestureExecutor）、`impl/AndroidEventInjector.java`（构造 MotionEvent 触摸事件注入，支持 setDisplayId 定向虚拟屏）。
2. **坐标点击 + 元素定位点击**：`mdi_click/mdi_tap` 支持纯坐标，也支持 text/contentDesc 定位——`MdiAbility.resolveElementCoords`（a.java `k()`）：`UiSnapshotAction` 抓 UI 快照 → `S0.b.W0(snapshot, text, contentDesc)` 匹配节点返回坐标。
3. **UI 树感知**：`mdi_snapshot` 返回扁平化视图树；`com/stepos/taskrobot/screenperception/viewtreeapi/` 封装 zyql ScreenPerception 的 ViewTree API（queries 可见 `com.zyql.screenperception.api`）。
4. **截屏**：`mdi_capture`（PNG base64）；进程持有 READ_FRAME_BUFFER / CAPTURE_SECURE_VIDEO_OUTPUT（**可截安全/DRM 屏**）/ 前台服务 FOREGROUND_SERVICE_MEDIA_PROJECTION。
5. **虚拟显示屏**：MDI Task 自动创建 VirtualDisplay，应用在虚拟屏运行（用户主屏不可见），`mdi_move_app` 可在主/虚屏间搬移应用；`setOmniDisplayImeEnabled` 管理虚拟屏 IME。
6. **系统按键**：`mdi_key_event`（任意 KeyCode）、back/home 专用工具。
7. 无 AccessibilityService 声明，无 `dispatchGesture` 调用（注入不走无障碍通道，走 InputManager 系统调用——比无障碍服务更底层、更难被普通用户察觉和撤销）。

---

## 5. 支付 / 短信 / 通讯录等敏感操作

- **没有专用支付/转账/短信/通讯录工具**。全库无 `SmsManager`、`ContactsContract`、`ACTION_CALL` 等直接调用（仅第三方库通用代码命中）。
- 敏感操作**统一通过 UI 自动化在目标 App 内完成**：`sources/com/stepos/taskrobot/llmapi/stepfun/MockedTree.java` 的 mock 任务树演示了完整"美团外卖下单→选规格→去结算→选择支付方式（微信/支付宝/美团支付）→确认支付"流程，证明支付类操作属于预期用例，依赖的把控点是：
  1. 应用白名单（checkAppWhitelistV1，云端 manifest 控制）；
  2. SLA 函数权限（redline/dataLevel/scope，来自 AgentSafetyCenter）；
  3. 授权卡（submitPermissionAuthResult 用户确认）。
- **电话**：`com/stepos/ability/calltool/` 的 CallToolImpl 不是拨号工具，而是**工具调用总线**（AppFunctions / Jetpack AppFunctions / Cloud 三类 handler 分发 + SLA 场景标记 `SLAScene`（1=无页面跳转，2=跳转页面）+ 请求/响应事件上报 `ToolCallRequestEvent/ToolCallResponseEvent`）。
- 语音唤醒（voicewakeup）：训练/设置页由 signature 权限 + consent provider 双重把关，语音唤醒词数据（res/raw/voice_wake_*.wav）本地处理。

---

## 6. 与 AgentSafetyCenter（com.stepos.agentsafetycenter）的交互点

1. **uses-permission**：`com.stepos.agentsafetycenter.permission.READ_AGENT_PERMISSIONS`、`READ_AGENT_LEDGER`（manifest 42-43 行）。
2. **queries**：`<package android:name="com.stepos.agentsafetycenter"/>`（manifest 51 行）。
3. **ContentProvider 数据流**（`sources/r4/AbstractC1878a.java`）：
   - `content://com.stepos.agentsafetycenter.ledger` — **Ledger 账本**（函数→scope/groupId/redline/dataLevel 映射，MappingCache 数据源）；
   - `content://com.stepos.agentsafetycenter.permission` — 权限模式（ModeCache 数据源）；
   - `content://com.stepos.agentsafetycenter.permission/snapshot` — 权限快照（ContentObserver 监听，变更即刷新 ModeCache）。
4. 读取错误码（r4/AbstractC1878a.a）：`noReadPermission / notWhitelisted / invalidArgs / noCacheAndFetchFailed / unknownGroupId / internalError` — 表明安全中心侧同样有调用方白名单。
5. 语义分工：AgentSafetyCenter 是**策略存储与决策数据源**（账本+权限模式，用户在安全中心改模式会实时推给 ability），ability 是**策略执行客户端**（checkSlaPermission fail-closed 判定 + 授权卡结果回流刷新）。

---

## 7. 关键文件索引

| 主题 | 路径（相对 sources/） |
|---|---|
| 工具定义 JSON | ../resources/res/raw/mcp_tools.json、tools_ext.json |
| 工具注册 | com/stepos/taskrobot/ability/TaskRobotMcpTool.java、TaskRobotMCPService.java |
| MDI 能力实现 | com/stepos/taskrobot/ability/a.java（MdiAbility）、com/mdisdk/capability/input/** |
| MCP AIDL 基类与权限检查 | com/stepos/mcp/sdk/java/service/AbsMCPService.java（enforceCallerHasPermission） |
| HTTP MCP Server | com/stepos/ability/mcpserver/McpServerInit.java、endpoint/a.java、model/McpServerConfig.java |
| 握手/身份/限流 | mcpserver/handshake/McpHandshakeProvider.java、security/（CallerIdentityRegistry、CachingKeyValidator、RateLimiter、BearerAuthenticator） |
| 能力中枢 AIDL | com/stepos/ability/service/AgentService.java（enforceAccessPermission/enforceTaskOwnerIfRegistered） |
| SLA 权限引擎 | o4/d.java、M/a.java（R/j0/m0）、s4/*、com/stepos/ability/permission/cache/* |
| SLA 结果模型 | com/stepos/ability/bean/SlaPermissionResult.java、SlaFunctionDetail.java、SlaPermissionResultKt.java |
| 安全中心 URI | r4/AbstractC1878a.java |
| 应用白名单 | com/stepos/taskrobot/appwhitelist/engine/AppWhitelistEngine.java |
| 主屏文本读写 | com/stepos/ability/screenops/service/ScreenOpsServiceImpl.java |
| 工具调用总线 | com/stepos/ability/calltool/CallToolImpl.java |
| 支付流程样例 | com/stepos/taskrobot/llmapi/stepfun/MockedTree.java |

*English version:*

| Topic | Path (relative to sources/) |
|---|---|
| Tool definition JSON | ../resources/res/raw/mcp_tools.json, tools_ext.json |
| Tool registration | com/stepos/taskrobot/ability/TaskRobotMcpTool.java, TaskRobotMCPService.java |
| MDI capability implementation | com/stepos/taskrobot/ability/a.java (MdiAbility), com/mdisdk/capability/input/** |
| MCP AIDL base class and permission check | com/stepos/mcp/sdk/java/service/AbsMCPService.java (enforceCallerHasPermission) |
| HTTP MCP Server | com/stepos/ability/mcpserver/McpServerInit.java, endpoint/a.java, model/McpServerConfig.java |
| Handshake/identity/rate limiting | mcpserver/handshake/McpHandshakeProvider.java, security/ (CallerIdentityRegistry, CachingKeyValidator, RateLimiter, BearerAuthenticator) |
| Capability hub AIDL | com/stepos/ability/service/AgentService.java (enforceAccessPermission/enforceTaskOwnerIfRegistered) |
| SLA permission engine | o4/d.java, M/a.java (R/j0/m0), s4/*, com/stepos/ability/permission/cache/* |
| SLA result models | com/stepos/ability/bean/SlaPermissionResult.java, SlaFunctionDetail.java, SlaPermissionResultKt.java |
| Safety center URIs | r4/AbstractC1878a.java |
| App whitelist | com/stepos/taskrobot/appwhitelist/engine/AppWhitelistEngine.java |
| Main-screen text read/write | com/stepos/ability/screenops/service/ScreenOpsServiceImpl.java |
| Tool call bus | com/stepos/ability/calltool/CallToolImpl.java |
| Payment flow sample | com/stepos/taskrobot/llmapi/stepfun/MockedTree.java |

---

## 8. 安全评估要点

1. **能力极强**：system UID + INJECT_EVENTS + 虚拟屏 + UI 树感知 + 截屏（含 SECURE 屏）+ IME 控制 = 完整的"无感操作任意应用"能力；ScreenOps 还提供主屏输入框读写。
2. **门控分层清晰但执行层留白**：传输层（signature/knownSigner 权限、api_key 绑定、scope 403、限流）很完善；但 19 个 mdi_* 工具的 handler 内无 per-call 权限/确认逻辑，SLA 检查是供编排方调用的查询接口（advisory），不是执行时强制（enforcing）拦截器。若调用方（launcher/agentfront）被绕过或存在漏洞，工具层无第二道防线。
3. **fail-closed 设计良好**：SLA 判定在快照缺失/异常时一律 DENY；授权卡决定后强制刷新缓存，防止用过期权限放行。
4. **握手面**：McpHandshakeProvider exported 无清单权限（有意为之），自防逻辑（uid≥10000、限流、server running、身份解析失败不建绑定、key 重绑定告警）是唯一的防线；api_key 经远端验证 + 本机包身份回退。
5. **攻击面提示**：DemoAct exported 无权限（低危）；`usesCleartextTraffic="true"`；ScreenOps 对签名应用开放主屏文本读写（凭据收集风险取决于签名域大小）。
