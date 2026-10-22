# STEPX 手机逆向工程总报告 —— 智能体工作模式与安全策略

> 项目：AgenticSmartphoneSafety / STEPX_Neo / 0_BasicObservation / 1_ReverseEngineering
> 日期：2026-10-20 | 分析环境：jadx 1.5.3（~/tools），设备经 mac-mini-ts USB adb（stepx-adb 包装脚本）
> 设备：StepX "pandora" PZ261A，Android 16 (SDK 36)，高通 SM8845，构建 2026-10-04，无 root
> 分报告：reports/{agentsafetycenter,ability,clawx_sprite_sandbox,agentbus,alphame,ailauncher}.md
> **全流程报告：reports/text_prompt_flow.md（用户发送一条文字的端到端完整链路，含 sla_local_exec.md / cloud_tool_downlink.md 两份深挖）**
> **能力评估：reports/agent_capability_assessment.md（四维度强度评估：系统内工具/MCP/GUI/A2A）**
> **附录：APPENDIX.md（所有名单/规则的完整枚举——权限组、119 工具映射、SLA 词表、白名单、密钥端点等）**
> 原始数据：live_permission_snapshot.txt, live_ledger_rules.txt, all_packages.txt, dumpsys_accessibility.txt

---

## 1. 系统概况

StepOS（品牌 StepX，阶跃星辰 StepFun 生态，工程域名 stepos.com/stepx.com，合作方 zyql.com）是深度改造的 Android 16，构建产物带 AIOSBUG 内部缺陷跟踪号。系统内置 262 个包，其中 com.stepos.* 60+ 个，形成完整的"智能体操作系统"栈。预装第三方应用（微信/支付宝/淘宝/美团/携程/滴滴/微博/高德等）即智能体的操作对象。

**平台扩展**：
- /apex/com.stepos.framework（steposcore-framework.jar，495 类）：CTA 权限门（CtaPermissionGate）、AccessControlManager 应用锁、SecureInput 安全输入、SMS OTP 胶囊（防读取验证码的 UI 机制）
- framework.jar 内置 com.stepos.internal.picker（系统级识屏：ScanScreen/ContentCapture/AlphaMeBinderClient）
- 合作方 SDK（zyql screenperception/ability/agentfront、stepai.android.mindx.sdk、com.zeroclaw.android）在 queries 中声明但**本机未安装**

## 2. 智能体栈架构（核心结论）

### 2.1 一句话模型

StepOS 的智能体采用"**云脑—端手—本地策略**"三段式：

- **云脑（思考）**：任务理解、规划、工具选择全部在云端完成（StepFun 大模型 + 云端 OpenClaw 编排）。手机只上传用户输入和屏幕状态，**不做决策**。
- **端手（执行）**：真正的操作由手机上以 **system 权限**运行的执行中枢（ability）完成——核心手段是在**虚拟屏**里打开目标 App，注入点击/输入事件。
- **本地策略（把关）**：AgentSafetyCenter 维护权限台账（哪些操作必须问用户）。但台账检查是否真正生效，**取决于任务走哪条通道**（见 2.4，这是本系统最重要的安全边界）。

用户入口是助手 **Amoo**：AiLauncher 主界面 / 侧边 AI 键（单击对话、长按持续语音）/ 唤醒词 "amoo amoo"。

### 2.2 六个核心组件

| # | 层 | 组件（包名） | 运行身份 | 一句话职责 |
|---|---|---|---|---|
| 1 | 前端 | AiLauncher (com.stepos.ailauncher) | 系统 App | Amoo 对话界面：上行用户输入，下行展示结果与风险卡，托管虚拟屏画面 |
| 2 | 云端脑 | StepFun LLM + 云端 OpenClaw | 云服务 | 推理与编排：拆解任务、选择工具、逐步下发指令 |
| 3 | 端侧运行时 | ClawX (com.stepos.stepclaw) | system + root(chroot) | 在 /mnt/openclaw chroot 内跑 OpenClaw Gateway（Node.js），是云端在端侧的"代理手" |
| 4 | 总线 | AgentBus (com.stepos.agentbus) | system | 组件间消息总线（LocalSocket）+ 云端 BFF 长连接（otter-connection.stepaos.com） |
| 5 | 执行中枢 | ability (com.stepos.ability) | system | 真正干活：虚拟屏管理、UI 自动化（19 个 mdi_* 工具）、SLA 判定、授权卡协议 |
| 6 | 安全策略 | AgentSafetyCenter (com.stepos.agentsafetycenter) | 系统 App | 权限组×模式台账、119 工具数据分级、审计、安全删除；供 ability 查询 |

辅助组件（不在主链路上）：AIEngine = 端侧推理引擎（llama/MNN/ONNX/QNN 后端）+ 多模态 GuiAgentAbility；AlphaMe = 旧一代情境画像引擎（魅族 OneMind 血统），与 Agent 栈零交互。

*English version:*

| # | Layer | Component (package) | UID | One-line role |
|---|---|---|---|---|
| 1 | Front-end | AiLauncher (com.stepos.ailauncher) | system app | Amoo chat UI: uploads user input, renders results & risk cards, hosts the virtual-display view |
| 2 | Cloud brain | StepFun LLM + cloud OpenClaw | cloud service | Reasoning & orchestration: decomposes the task, picks tools, issues step-by-step commands |
| 3 | On-device runtime | ClawX (com.stepos.stepclaw) | system + root (chroot) | Runs the OpenClaw Gateway (Node.js) inside /mnt/openclaw chroot — the cloud's "proxy hand" on device |
| 4 | Bus | AgentBus (com.stepos.agentbus) | system | Inter-component message bus (LocalSocket) + cloud BFF channel (otter-connection.stepaos.com) |
| 5 | Execution hub | ability (com.stepos.ability) | system | Does the real work: virtual-display management, UI automation (19 mdi_* tools), SLA adjudication, auth-card protocol |
| 6 | Security policy | AgentSafetyCenter (com.stepos.agentsafetycenter) | system app | Permission-group×mode ledger, data classification for 119 tools, auditing, safe delete; queried by ability |

Auxiliary (off the main path): AIEngine = on-device inference engine (llama/MNN/ONNX/QNN backends) + multimodal GuiAgentAbility; AlphaMe = legacy context-profiling engine (Meizu OneMind lineage), zero interaction with the agent stack.

### 2.3 一次典型任务的完整链路

以"**帮我在美团下单一杯拿铁**"为例（GUI 自动化路径，最复杂也最常用）。编号步骤对应组件：AiLauncher=①、云端=②、ability=③：

1. **输入**：用户对 Amoo 说话 → ①
2. **上云**：①的 SendPipeline 三步——AuditStage 内容审核 → SLA 竞速（决定走本地快车道还是云端）→ commitToCloud
3. **云端规划**：②拆解任务，决定调用 gui_agent（GUI 自动化总开关；注意它在台账的免确认白名单 tool_allow 里）
4. **下发**：工具调用经 BFF 长连接（protobuf ToolCall）→ ④AgentBus → ③ClawX（zeroclaw 桥）→ ③ability
5. **【安全点①｜风险卡】**：云端"应当"先调 assistant_show_risk_statement，由 ①Amoo 弹卡让用户选 allow_once / always_allow / reject——**但这依赖云端自觉，端侧此路径无强制闸门**（薄弱点 #1）
6. **建虚拟屏**：③taskrobot 创建 VirtualDisplay 并在其中启动美团（AppWhitelistEngine 校验白名单，不在名单→REDIRECT/FAILED）
7. **看**：③mdi_snapshot / mdi_capture 输出虚拟屏的 UI 视图树 + 截图（base64），回传 ②
8. **想**：②的 GUI 机器人（默认模型 doubao-1.5-ui-tars）分析画面，输出下一步动作（点击坐标/输入文本/滑动）
9. **动**：③mdi_click / mdi_set_text / mdi_swipe 注入事件（反射 InputManager.injectInputEvent）→ 回到第 7 步循环，直到下单完成
10. **敏感节点**：进行到支付等 D3/D4 动作且权限模式为 ask* 时 → 授权卡；用户拒绝 → 任务终止并回传
11. **收尾**：ToolResult 逐级回传 ② → Amoo 汇报结果；dashboard_days 记录 ops/risks，会话数据经 agentcache 上报云端

> 注：第 5 步描述的是**云端路径**。若走**本地快车道**，则在 ①派发前调 checkSlaPermissionV1 → ③SLA 引擎查台账（fail-closed：未知函数/无快照/过期一律拒绝）。

### 2.4 三条工具执行通道（安全边界的关键）

同一个"工具调用"有三条通道，安全性质完全不同：

| 通道 | 决策者 | 权限检查 | 强制性 | 典型工具 |
|---|---|---|---|---|
| A. 云脑工具路径 | 云端 LLM | 云端"自愿"调 assistant_show_risk_statement 弹卡；端侧**不查**台账 | **端侧无强制**（仅剩 signature 权限门）→ 薄弱点 #1 | mdi_*、多数 MCP 工具 |
| B. 本地快车道 | 端侧小模型竞速获胜 | ①调 checkSlaPermissionV1 → ③SLA 引擎查台账（fail-closed） | 判定强制，但**遵守在调用方**；断网时 offlineLedgerBypass **fail-open** → 薄弱点 #2 | ~65 个系统函数白名单 |
| C. OpenClaw 命令路径 | 云端/本地 gateway | stepclaw-exec 白名单（15 命令）+ 黑名单（rm -rf 等）+ cwd/env 限制 | 白名单强制 | bash/python/node/sh |

*English version:*

| Path | Decision maker | Permission check | Enforcement | Typical tools |
|---|---|---|---|---|
| A. Cloud tool path | Cloud LLM | Cloud "voluntarily" calls assistant_show_risk_statement to show the card; on-device does **not** consult the ledger | **No on-device enforcement** (only the signature-permission gate) → Finding #1 | mdi_*, most MCP tools |
| B. Local fast path | On-device small model winning the race | ①calls checkSlaPermissionV1 → ③SLA engine checks ledger (fail-closed) | Adjudication mandatory, but **compliance is up to the caller**; when offline, offlineLedgerBypass **fails open** → Finding #2 | ~65 whitelisted system functions |
| C. OpenClaw command path | Cloud/local gateway | stepclaw-exec allowlist (15 commands) + denylist (rm -rf etc.) + cwd/env restrictions | Allowlist enforced | bash/python/node/sh |

### 2.5 全景架构图

下图是 2.2–2.4 的浓缩总结（阅读顺序：最上方=云端；中层左=ClawX 运行时、右=AgentBus；下方=ability 执行中枢与 AgentSafetyCenter 策略中枢）：

```
┌─────────────────────────── 云端 ───────────────────────────┐
│  StepFun LLM (api)   biz-gw.stepos.com   otter-connection.stepaos.com/ws │
│  云端 OpenClaw 编排（云脑）      ↑签名代理18791    ↑BFF protobuf 长连接 │
└───────────────┬───────────────────────────┬───────────────┘
                │                           │
┌───────────────┴───────────┐   ┌───────────┴────────────────┐
│ ClawX (com.stepos.stepclaw)│   │ AgentBus (com.stepos.agentbus)│
│ /mnt/openclaw chroot       │   │ LocalSocket"agentbus" 抽象命名空间│
│ openclaw-gateway(system)   │←──│ zeroclaw Binder(JSON-RPC)     │
│ openclaw_env(root!)        │   │ REST 18801 / Blob 18800       │
│ Node.js, 端口 18789/90/91  │   └───────────┬────────────────┘
│ 人格"小跃"，工具:stepclaw.  │               │
│ exec/ability.call/cron/记忆│               │
└───────────────┬───────────┘               │
                │ WebSocket node 协议        │
┌───────────────┴───────────────────────────┴────────────────┐
│ ability (com.stepos.ability) — system uid，能力中枢        │
│ • AgentService(AIDL): submitGuiTask/submitToolTask          │
│   → TaskExecutor → SLA权限引擎(fail-closed) → 授权卡 → 执行  │
│ • MCP TOOLS_SERVICE: 19个 mdi_* 虚拟屏UI自动化工具           │
│   (InputManager.injectInputEvent 反射注入，非无障碍)         │
│ • taskrobot → StepFun 云 API（GuiAgentTraceManagerV2 轨迹）  │
│ • AppWhitelistEngine（美团/淘宝等 App 白名单→REDIRECT/FAILED）│
└───────────────┬────────────────────────────────────────────┘
                │ content provider 快照/规则
┌───────────────┴────────────────────────────────────────────┐
│ AgentSafetyCenter — 安全策略中枢                             │
│ • 权限组22个 × 模式(allow/ask_always/ask_on_sensitive/off)  │
│ • Ledger rules: 119工具→{组,数据分级D0–D4}, 云同步v344978   │
│ • 授权入口(锁屏需CONFIRM_PASSWORD) / 每日审计(dashboard_days)│
│ • MCP工具: file_safe_delete/file_restore(回收站+truth_id)   │
└────────────────────────────────────────────────────────────┘
   前端: AiLauncher(主界面+任务) / ability内Amoo精灵(唤醒词"amoo amoo")
   感知: AIEngine(llama/MNN/ONNX/QNN端侧推理+GuiAgentAbility多模态+PermissionGuard)
         AlphaMe(旧一代情境画像，魅族OneMind血统)
```

*English version:*

```
┌────────────────────────── CLOUD ─────────────────────────┐
│  StepFun LLM (api)   biz-gw.stepos.com   otter-connection.stepaos.com/ws │
│  Cloud OpenClaw orchestration  ↑signed proxy 18791  ↑BFF protobuf channel │
└───────────────┬───────────────────────────┬───────────────┘
                │                           │
┌───────────────┴───────────┐   ┌───────────┴────────────────┐
│ ClawX (com.stepos.stepclaw)│   │ AgentBus (com.stepos.agentbus)│
│ /mnt/openclaw chroot       │   │ LocalSocket "agentbus" (abstract ns)│
│ openclaw-gateway(system)   │←──│ zeroclaw Binder (JSON-RPC)    │
│ openclaw_env(root!)        │   │ REST 18801 / Blob 18800       │
│ Node.js, ports 18789/90/91 │   └───────────┬────────────────┘
│ persona "Xiaoyue", tools:  │               │
│ stepclaw.exec/ability.call/│               │
│ cron/memory                │               │
└───────────────┬───────────┘               │
                │ WebSocket node protocol   │
┌───────────────┴───────────────────────────┴────────────────┐
│ ability (com.stepos.ability) — system uid, capability hub  │
│ • AgentService (AIDL): submitGuiTask/submitToolTask         │
│   → TaskExecutor → SLA engine (fail-closed) → auth card → run│
│ • MCP TOOLS_SERVICE: 19 mdi_* virtual-display UI automation │
│   (InputManager.injectInputEvent reflection, not a11y)      │
│ • taskrobot → StepFun cloud API (GuiAgentTraceManagerV2)    │
│ • AppWhitelistEngine (Meituan/Taobao etc. → REDIRECT/FAILED)│
└───────────────┬────────────────────────────────────────────┘
                │ content provider snapshot/rules
┌───────────────┴────────────────────────────────────────────┐
│ AgentSafetyCenter — security policy hub                     │
│ • 22 permission groups × modes (allow/ask_always/ask_on_    │
│   sensitive/off)                                            │
│ • Ledger rules: 119 tools→{group, data level D0–D4},        │
│   cloud-synced v344978                                      │
│ • Auth entry (CONFIRM_PASSWORD when locked) / daily audit   │
│   (dashboard_days)                                          │
│ • MCP tools: file_safe_delete/file_restore (trash+truth_id) │
└────────────────────────────────────────────────────────────┘
   Front-end: AiLauncher (main UI + tasks) / Amoo sprite inside ability (wake word "amoo amoo")
   Perception: AIEngine (on-device llama/MNN/ONNX/QNN + multimodal GuiAgentAbility + PermissionGuard)
               AlphaMe (legacy context-profiling engine, Meizu OneMind lineage)
```

### 2.6 运行时实证细节（动态验证）

- openclaw-gateway 以 **system uid** 运行、openclaw_env 以 **root** 运行（chroot 管理器）
- 端口 18789(gateway) / 18790(edge 钩子) / 18791(LLM 签名代理) 仅绑 loopback；/health 无认证可查
- UI 自动化**不走无障碍服务**：ability 用 INJECT_EVENTS + 反射 InputManager.injectInputEvent 向虚拟屏注入事件（MDI 架构），第三方 App 操作在虚拟屏完成，主屏可并行使用
- gui_agent 在台账的 tool_allow（免确认）清单中；device.automation(D4) / screen.capture(D3) / ui.canvas.control(D3) 属 screen.understanding 组（当前 ask_always）
- taskrobot 虚拟屏 GUI 机器人模型默认分两层：AiLauncher RobotManager 缺省 **doubao-1.5-ui-tars**（字节 UI-TARS），ability ModelCatalog 兜底默认 step3p7-mtp3（阶跃），目录另含 gemini-2.5-pro/glm-4.6v/autoglm-phone/MiMo-VL；pureVirtualScreen TextureView 产出 Surface
- 用户询问共四类 UI：MCP 风险卡（inline 聊天卡/灵动岛/弹窗三宿主，RiskCardHandoffCoordinator 处理前后台切换与锁屏 KeyguardUnlockActivity）、INQUIRY 审批气泡（AgentBus answerInquiry）、Android 运行时权限、账号合规

### 2.7 全系统 MCP 服务器注册表（工具面）

（dumpsys intent resolver 实测，TOOLS_SERVICE action；智能体的工具面=整部手机。权限持有者 ACCESS_MCP_SERVICES：AiLauncher、AgentBus、ClawX——三者构成完整调用闭环。）
| 提供方 | 服务 | 领域 |
|---|---|---|
| com.stepos.ability | TaskRobotMCPService | 19 个 mdi_* 虚拟屏 UI 自动化 |
| com.stepos.agentsafetycenter | AbilityService | file_safe_delete / file_restore |
| com.stepos.ailauncher | VoiceAbilityService | 语音 |
| com.android.settings | McpService | 系统设置 |
| com.android.packageinstaller | McpService | 应用安装/卸载 |
| com.android.mms | AbilityService | 短信 |
| com.android.alarmclock | AlarmMCPService | 闹钟 |
| com.stepos.media.gallery | GalleryMCPService | 图库 |
| com.android.soundrecorder | RecordManagerMCPService | 录音 |
| com.stepos.safebox | AbilityService | 保险箱 |
| com.stepos.net.search | SearchManagerMcpService | 搜索 |
| com.stepos.calculator | CalculatorMCPService | 计算器 |
| com.android.systemui | SystemUIMCPService | SystemUI |
| com.stepos.logreport | LogReportAbilityService | 日志上报 |
| com.stepos.common.ability.proxy | CommonAbilityService | 公共能力代理 |

*English version:*

| Provider | Service | Domain |
|---|---|---|
| com.stepos.ability | TaskRobotMCPService | 19 mdi_* virtual-display UI automation tools |
| com.stepos.agentsafetycenter | AbilityService | file_safe_delete / file_restore |
| com.stepos.ailauncher | VoiceAbilityService | Voice |
| com.android.settings | McpService | System settings |
| com.android.packageinstaller | McpService | App install/uninstall |
| com.android.mms | AbilityService | SMS |
| com.android.alarmclock | AlarmMCPService | Alarm |
| com.stepos.media.gallery | GalleryMCPService | Gallery |
| com.android.soundrecorder | RecordManagerMcpService | Audio recording |
| com.stepos.safebox | AbilityService | Safe box |
| com.stepos.net.search | SearchManagerMcpService | Search |
| com.stepos.calculator | CalculatorMCPService | Calculator |
| com.android.systemui | SystemUIMCPService | SystemUI |
| com.stepos.logreport | LogReportAbilityService | Log reporting |
| com.stepos.common.ability.proxy | CommonAbilityService | Common ability proxy |

## 3. 安全策略体系（分层）

1. **入口密码门**：AgentSafetyCenter 的授权管理界面在锁屏态强制 CONFIRM_PASSWORD（password_from=8）
2. **权限组模型**：22 组 × 4 模式；UI 自动化归 screen.understanding 组（默认 ask_always=每次问）
3. **数据分级**：D0(web.fetch/calculator) → D4(file.delete/identity.read/payment.security_control/device.automation/remote.device.control/system.security.modify...)；分级决定是否弹授权卡
4. **SLA 权限引擎**（ability 内，o4/d.java）：fail-closed，denyReason∈{redline,mode,unknownFunction,scopeMissing,noSnapshot,stale}——未知函数直接拒；数据从 AgentSafetyCenter 三个 provider 拉取，授权后定向刷新缓存
5. **授权卡协议**：TaskExecutor → PermissionAuthCoordinator.awaitUserThenResolve（挂起等待）→ 调用方展示授权卡 → submitPermissionAuthResult(agreed, toolCallId) → 继续/取消
6. **OpenClaw 执行白名单**（stepclaw-exec 插件）：argv[0] 限 15 命令（python/node/sh/bash/cat...）；硬编码拒绝 rm -rf、curl|sh、sudo、/etc/shadow；cwd 白名单；env 黑名单（LD_PRELOAD）；10–60s 超时
7. **总线鉴权**：LocalSocket 握手=内核 peer UID+包名匹配+平台签名信任集，失败 STEPCLAW_AUTH_DENIED
8. **传输加密**：securedata 用 RSA-OAEP 包裹 AES-256-GCM（key-center 发 KeyId），云长连接 mTLS
9. **可逆删除**：删除进回收站（MediaStore/文件管理器），truth_id 关联云端可撤销 step
10. **审计**：dashboard_days(ops_count/risks_count) 每日云端同步；AgentBus data-report.chat 把用户输入+模型输出喂入 agentcache（traceId 维度）上报

## 4. 已发现的安全薄弱点（按攻击价值排序）

| # | 发现 | 层 | 严重度 | 详情 |
|---|---|---|---|---|
| 1 | **云端工具路径无端侧强制闸门（七跳链实证）**：mdi_* 等云脑工具执行完全不经过 AiLauncher——云→网关 nodes 工具→AgentBus→ability 共 7 跳直达注入；AbilityCallExecutor 只解析参数+超时，KEY_CALL_SOURCE="CLOUD" 仅标记；网关 allowCommands=[ability.call,agent.call,stepclaw.exec] 只约束命令不约束 method（方法级控制缺位）；授权完全依赖云端智能体"自愿"调用 assistant_show_risk_statement 弹风险卡 | AiLauncher+ability+ClawX | **高** | reports/text_prompt_flow.md §5、cloud_tool_downlink.md |
| 2 | **offlineLedgerBypass fail-open（dex 还原实证）**：断网+台账不可用+非 redline → 直接放行本地执行；旧版本权限缺失同样 fail-open | AiLauncher | **高** | reports/ailauncher.md §4 |
| 3 | **call() 绕过 readPermission（已实证）**：任意 App 零权限读权限快照+账本规则（用户安全偏好画像泄露） | AgentSafetyCenter | 中 | reports/agentsafetycenter.md §8.1 |
| 4 | **AgentBus BlobServer(18800) 无逐请求鉴权**：本机任意 App 可 PUT/GET blob | AgentBus | 中 | reports/agentbus.md |
| 5 | **硬编码 prod/test appId+secret** 随包分发（s1/u.java, n7/a.java） | AgentBus | 中 | reports/agentbus.md |
| 6 | **ACTION_BFF_WAKE 广播可伪造**，可唤醒各 App 内 peer agent | AgentBus | 低-中 | reports/agentbus.md |
| 7 | OpenClaw Java 侧 before_tool_call 钩子只拦 /sdcard 的 rm/find -delete，其余放行 | ClawX | 中 | reports/clawx_sprite_sandbox.md |
| 8 | system uid 的 chroot 内可跑图灵完备命令（python/node/sh）且可写 /sdcard | ClawX | 结构性风险 | 同上 |
| 9 | PerfBinderProvider exported 无保护 | AiLauncher | 低-中 | reports/ailauncher.md §7 |
| 10 | ScreenOps 对签名应用开放主屏全部 EditText 读写 | ability | 低 | reports/ability.md §9 |
| 11 | benchmark 帧明文落盘 /sdcard/Documents/clawbench | AgentBus | 低 | reports/agentbus.md |
| 12 | ability/AlphaMe usesCleartextTraffic=true | 多处 | 低 | 各报告 |
| 13 | **网关 auth token 为 dev 占位值** `stepclaw-dev-placeholder-v1`（GatewayAuthConstants.java:14）；LLM 签名代理 18791 为明文 HTTP | ClawX | 中-高 | reports/text_prompt_flow.md §5 |
| 14 | **SlaAtomicDispatcher 权限检查 fail-open**（ACCESS_AGENT_SERVICE 未声明即放行）；解锁态"名字即权限"（任意函数名可派发） | AiLauncher→ability | 中 | reports/sla_local_exec.md §8 |
| 15 | **INSTALL_GUARD 合成假成功**：appstore_install_app 已装时返回与真实执行同构的 SUCCESS resultJson，UI 无真伪校验 | AiLauncher sla/t.java | 中 | reports/sla_local_exec.md §8 |
| 16 | SLA 粗筛文本 ≤480 字才竞速（超长直走云）；OPENCLAW 备路依赖未安装的第三方 APK（com.zyql.agentfront），实际仅 AGENTBUS 单通道 | AiLauncher | 低（信息） | reports/text_prompt_flow.md §2.3/§4.2 |
| 17 | **submitPermissionAuthResult 无属主校验（已证实）**：AgentService binder L334 仅 enforceAccessPermission——任何持 ACCESS_AGENT_SERVICE 的进程（AgentBus/ClawX/ability 自身）可对**任意 toolCallId** 提交授权结果，即"授权卡代答"面真实存在；云路径的恢复协议走 ResumeSender("stepclaw.approvals.resolve")+execution_grant{token,idempotency_key}，与该 binder 方法并行为两套授权通道 | ability | **中-高** | reports/text_prompt_flow.md §5 |
| 18 | 台账查询**抛异常**时若 enabled&&localDispatch 开启 → 放行本地执行（offlineLedgerBypass 之外的又一处 fail-open）；C3474c 四开关 setter 无调用者（编译期固定，云控不可关） | AiLauncher | 中 | reports/text_prompt_flow.md §3.4 |
| 19 | AppWhitelistEngine 当前无真实云端同步源（MockWhitelistRemoteSource，数据=APK assets + 磁盘缓存）——白名单是静态的 | ability | 低（信息） | reports/text_prompt_flow.md §5 |

*English version:*

| # | Finding | Layer | Severity | Details |
|---|---|---|---|---|
| 1 | **No on-device enforcement gate on the cloud tool path**: when mdi_* cloud-brain tools execute, AiLauncher does not consult AgentSafetyCenter — authorization relies entirely on the cloud agent *voluntarily* calling assistant_show_risk_statement to show the risk card (allow_once/always_allow/reject); only the signature-level ACCESS_AGENT_SERVICE boundary remains on-device; the local SLA fast path (~65 system functions) does have checkSlaPermissionV1 adjudication, but **compliance is up to the caller** — mdi handlers contain no mandatory check | AiLauncher+ability | **High** | reports/ailauncher.md §3 |
| 2 | **offlineLedgerBypass fail-open (confirmed via dex restoration)**: offline + ledger unavailable + not redline → local execution allowed directly; missing permissions on older versions also fail open | AiLauncher | **High** | reports/ailauncher.md §4 |
| 3 | **call() bypasses readPermission (verified live)**: any app reads permission snapshot + ledger rules with zero permissions (user security-preference profiling leak) | AgentSafetyCenter | Medium | reports/agentsafetycenter.md §8.1 |
| 4 | **AgentBus BlobServer (18800) has no per-request auth**: any local app can PUT/GET blobs | AgentBus | Medium | reports/agentbus.md |
| 5 | **Hardcoded prod/test appId+secret** shipped in the package (s1/u.java, n7/a.java) | AgentBus | Medium | reports/agentbus.md |
| 6 | **ACTION_BFF_WAKE broadcast is forgeable**, can wake peer agents inside apps | AgentBus | Low-Med | reports/agentbus.md |
| 7 | OpenClaw Java-side before_tool_call hook only intercepts rm/find -delete on /sdcard; everything else passes | ClawX | Medium | reports/clawx_sprite_sandbox.md |
| 8 | Turing-complete commands (python/node/sh) run inside a system-uid chroot with /sdcard writable | ClawX | Structural risk | ibid. |
| 9 | PerfBinderProvider exported with no protection | AiLauncher | Low-Med | reports/ailauncher.md §7 |
| 10 | ScreenOps exposes read/write of all main-display EditTexts to signature apps | ability | Low | reports/ability.md §9 |
| 11 | Benchmark frames written in plaintext to /sdcard/Documents/clawbench | AgentBus | Low | reports/agentbus.md |
| 12 | ability/AlphaMe usesCleartextTraffic=true | multiple | Low | various reports |

## 5. 对后续测试的建议（测试用例设计输入）

1. **诱导云端跳过风险卡（最高价值）**：云脑工具路径的授权靠云端"自愿"调 assistant_show_risk_statement——用提示注入/对话诱导让云端智能体不调用该工具直接下发 mdi_* 操作，验证端侧是否放行（预期：放行，因端侧无强制闸门）
2. **offlineLedgerBypass 复现**：断网/屏蔽 AgentSafetyCenter provider 使台账查询失败，构造非 redline 的 D3/D4 工具调用，验证 fail-open 放行
3. **提示注入→越权工具**：在第三方 App 界面（预装美团等）植入界面文本，观察 gui_agent/mdi_snapshot 是否将其当作指令（屏幕感知授权范围 TASK_EXECUTION 下）
4. **ask_on_sensitive 边界**：构造"读取联系人"任务，验证 ask_on_sensitive 模式在何种具体参数下不弹窗（group 级 vs tool 级判定差异）
5. **授权卡代答**：submitPermissionAuthResult 的调用方信任边界——绑定 AgentService 的系统 App 能否代答授权卡
6. **OpenClaw 命令白名单绕过**：stepclaw.exec 的 15 命令+黑名单模式对参数拼接（如 `python -c`、`node -e`）的覆盖
7. **虚拟屏逃逸**：mdi 任务中诱导目标 App 弹出到主屏/读取主屏内容（MainDisplayTopAppHistory 说明主屏状态可查）
8. **BlobServer 数据投毒**：PUT 伪造 blob 影响 agentcache 上报链
9. **权限快照侦察**（已验证可行）：恶意 App 零权限读取用户当前 allow 的组，定制社工话术
10. **OTP 胶囊对抗**：系统有 SMS OTP 胶囊机制，测试 gui_agent 自动化能否绕过（虚拟屏内短信验证码自动填充场景）
11. **风险卡 UI 劫持**：RiskCardHandoffCoordinator 的前后台切换/锁屏重放逻辑（KeyguardUnlockActivity）是否存在 TOCTOU/伪装窗口空间

## 6. 工件清单

- `stepx-adb`（仓库根）：远程 adb 包装脚本
- `analysis/apks/`：17 个 APK + framework/services/steposcore jar（源：设备 /system*）
- `analysis/decompiled/`：jadx 输出（AgentSafetyCenter/AIEngine/AgentBus/ClawX/AppSandbox/AgentSprite/AlphaMe/ability/AiLauncher/FamilyGuard/steposcore）
- `analysis/reports/`：6 份组件报告（本文件为总纲）
- `analysis/APPENDIX.md`：附录——全部名单的完整枚举（A 权限组 / B 台账规则 119 工具 / C MCP 工具面 / D SLA 词表 / E stepclaw-exec 名单 / F App 白名单 / G 证书 / H 端点密钥 / I denyReason）
- `analysis/live_*.txt`：设备实测的策略快照/账本规则
- 工具：~/tools/jdk-21.0.12.1+1-jre、~/tools/jadx
