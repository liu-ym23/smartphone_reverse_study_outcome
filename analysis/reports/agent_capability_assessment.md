# STEPX 手机当前 Agent 能力强度评估

> 日期：2026-10-22 | 方法：静态反编译（jadx + androguard 字节码级）+ 设备动态验证（dumpsys/logcat/content）
> 设备：StepX pandora PZ261A，Amoo 1.0.0_20261002_221513，rules_version 344978
> 评级档位：**成熟可用**（生产运行）｜**可运行但受限**（真实功能+明确闸门）｜**建成待用**（链路完整、未开闸/灰度）｜**仅框架**（协议/接口存在、无实际对端）｜**纸面设计**（仅声明/查询）
> 证据标注：〔静〕反编译实证 ｜〔动〕设备实测 ｜〔推〕基于证据的推断

---

## 0. 总评

| 维度 | 评级 | 一句话结论 |
|---|---|---|
| 一、系统内部功能工具调用 | **可运行但受限**（接近成熟） | 全机 15 个系统 MCP 服务器 + 58 函数 SLA 快车道经 AppFunction 真实落地执行；台账权限体系在线；受权限矩阵与 ask* 模式约束 |
| 二、与第三方 APP 的 MCP 交互 | **仅框架**（对第三方单向下开放） | MCP 基础设施完整，但 15 个工具服务全部是系统/厂商 App——**零第三方接入**；且第三方 App 无法作为 client（system\|signature 权限墙） |
| 三、与第三方 APP 的 GUI 交互 | **建成待用** | 七跳下行链路、虚拟屏、注入引擎、9 模型目录、授权协议全部真实；但白名单管道是 Mock（仅 5 App 可操作）、测试桩是死代码、设备上无任何已执行任务痕迹 |
| 四、与第三方 APP 的 A2A 交互 | **仅框架**（内部总线成熟，外部生态雏形） | AgentBus/ExternalAgent/AgentMarket/BFF 云桥协议齐备；实际外部智能体接入状况未知，合作方 SDK 全部未安装 |

**总判断**：这是一台"能力已大部分建造、生态尚未开张"的智能体手机。对安全研究而言，最大的攻击面在第一、三维度（真实可触达），而第二、四维度是**未来开闸时的预警性靶场**。

---

## 一、系统内部功能的工具调用能力 —— **可运行但受限**（接近成熟）

### 1.1 机制与证据

| 能力 | 机制 | 强度证据 |
|---|---|---|
| SLA 快车道 | 58 函数词表 → 端侧小模型识别 → v.java 门 → 台账 j0 矩阵 → `AppFunctionManager.executeAppFunction` 由系统 App 真正执行 | 〔静〕门控逻辑字节码级还原；〔动〕TaskRobotService/AgentService 运行中且被 AiLauncher 绑定 |
| 系统 MCP 工具面 | 15 个 TOOLS_SERVICE 服务器：设置/应用安装/短信/闹钟/图库/录音/保险箱/搜索/计算器/SystemUI/日志/公共能力/ability(19 mdi)/语音/安全删除 | 〔动〕dumpsys intent resolver 实测枚举 |
| 安全文件操作 | file_safe_delete/file_restore（回收站 + truth_id 云端可撤销） | 〔静〕AgentSafetyCenter MCP schema 完整 |
| 下行执行链 | 云→网关 nodes→AgentBus→ability 七跳，invokeTimeout 600s | 〔静〕AbilityCallExecutor 全链还原；〔动〕链路两端服务在线 |
| 权限治理 | 22 组×4 模式 + 119 工具×D0-D4 分级 + 9 红线，fail-closed 判定引擎 | 〔动〕content call 实测 rules v344978；〔静〕j0 smali 反汇编 |

### 1.2 强度评估

- **真实执行层**：SLA 函数不是模拟——落地到 Android 16 AppFunction API，由设置/拨号/时钟等系统应用执行。这是全机最"硬"的能力。
- **覆盖广度**：闹钟/拨号/短信(含锁屏发送)/系统设置(25 项)/笔记/天气/定位/表达式，共 55 个可执行函数 + 15 个 MCP 服务器域。
- **限制**：①词表外一律无能为力（识别器约 60 项宇宙）；②短信发送、联系人读等 D3/D4 在 ask_on_sensitive 组下需回云端弹卡；③锁屏仅 58 项且 SMS 在列（见安全观察）。
- **成熟度佐证**：离线文案、错误码体系（8 组）、埋点全链路、锁屏重放、授权卡补刷——工程完成度高。

### 1.3 缺口与风险（引用 REPORT.md）

- 台账判定 fail-open ×2（offlineLedgerBypass、查询异常放行）〔静〕
- 锁屏白名单含 `sms_send`/`sms_send_direct` 〔静〕
- 下行链路无端侧权限检查点、`submitPermissionAuthResult` 无属主校验 〔静〕
- 网关 token 为 dev 占位值 `stepclaw-dev-placeholder-v1` 〔静〕

---

## 二、与第三方 APP 的 MCP 交互 —— **仅框架**（对第三方单向下开放）

### 2.1 机制

StepOS MCP = AIDL Binder 承载的标准 MCP JSON-RPC（`IMCPBinderService.register/unregister/request`），发现机制 = PackageManager 按 `com.stepos.mcp.sdk.TOOLS_SERVICE` action 扫描 + 读 `mcp.tools` meta-data。工具 schema 支持 few-shot（正/负样本）、classification、timeout、slaScene。

### 2.2 当前实际生态（关键实证）

| 方向 | 现状 | 证据 |
|---|---|---|
| 第三方 App 作为 **MCP server**（给 agent 提供工具） | **零**。15 个 TOOLS_SERVICE 全部来自 com.android.*（5）/com.stepos.*（9）/系统组件 | 〔动〕dumpsys 全量枚举，无任何第三方包 |
| 第三方 App 作为 **MCP client**（调用系统工具） | **被权限墙挡死**：bind 需 `ACCESS_MCP_SERVICES`（system\|signature），且 VoiceAbilityService 还有 per-transact CallerVerifier（仅 self/system/root/平台签名） | 〔静〕Manifest + C5/d.java 还原 |
| 接入框架本身 | **真实可用**：发现/注册/schema/回调齐全，第三方 App 声明 service+meta-data 即可被发现（能否过审由厂商控制） | 〔静〕MCPHelper.java + AbsMCPService.java |

### 2.3 强度评估

- 对第三方而言这是**单向预留**：框架完全就绪，但没有一个外部玩家进场。当前"MCP"实际是**厂商内部总线**（15 个服务全部是自家/系统 App 之间的协议）。
- 值得注意的细节：`AiLauncher` 内的 `AndroidClientTransport`（MCP client 实现）是死代码——连厂商自己的 App 都不互为 client，一切 client 行为都来自网关侧（云/OpenClaw）。
- **开闸即风险**：一旦允许第三方注册 TOOLS_SERVICE，`mcp.tools` schema 内容（含提示词样本）将直接进入云端模型上下文——**schema 即提示词注入面**。当前无逐 server 的内容审计机制证据。

---

## 三、与第三方 APP 的 GUI 交互 —— **建成待用**

### 3.1 机制（已在本轮全面验证，见 text_prompt_flow.md §5）

云端大脑（StepFun/字节 UI-TARS 等模型）下发 `gui_agent`/`ability.call` → 七跳到 ability → 虚拟屏（VirtualDisplay）内启动目标 App → `mdi_snapshot/mdi_capture` 看屏 → 云端决策 → `mdi_click/mdi_set_text/mdi_swipe` 经 `InputManager.injectInputEvent` 反射注入 → 循环至完成。授权走 PendingAuth(13)→风险卡→`stepclaw.approvals.resolve` 闭环。

### 3.2 "真实 vs 待用"证据对账（2026-10-21/22 设备实测）

| 证据 | 指向 |
|---|---|
| TaskRobotService 前台运行、被 AiLauncher 绑定；AiLauncher 有 taskRobotSurface 资源池组件 | 真实 |
| 19 工具 schema 完整（few-shot/分类/超时）、模型目录 9+（step3p7 默认+doubao-tars+gemini…）、云端端点真实 | 真实 |
| PendingAuth/ResumeSender/风险卡三宿主/轨迹上报协议闭环 | 真实 |
| `AppWhitelistEngine` 数据源 = **Mock**（assets 静态，无云端同步管道）；仅 5 App enabled（快手/B站/微信/高德/支付宝），3 个 REDIRECT | **待用** |
| `MockedTree`（假美团订单树，张三/三里屯）零调用者死代码 | **待用**（开发意图证据） |
| TaskRobotMCPService 未运行（无 MCP 调用方）、VirtualDisplay 空、taskRobotSurface live=0（池 create=1/destroy=1） | **待用** |
| 模型双默认分裂（AiLauncher=doubao-tars vs ability=step3p7） | **待用**（选型期） |
| AIEngine `GuiAgentAbility.doCloudInfer: not implemented`（实际走 taskrobot 层） | 新旧两代痕迹 |
| 对外 `gui_agent` 入口参数仅 {app_name, task, meta}——细粒度 mdi_* 未作为开放能力发布 | **待用** |
| /sdcard/Documents/clawbench 从未创建 | benchmark 从未跑 |

### 3.3 强度评估

- **能力天花板高**：如果开闸，这是一套完整的"云脑+虚拟屏端手"商用 GUI agent（对齐 AutoGLM/UI-TARS 类产品形态），且授权/审计/可逆设计（回收站/轨迹）齐备。
- **当前实际能力**：受三重闸门限制——①App 白名单窄门（5 App）；②云端编排决定是否走 gui 路径；③风险卡/台账对 D3/D4 动作拦截。**在当前状态下，普通用户场景几乎不会触达 GUI 交互**。
- **注入机制的特殊性**：不走无障碍服务，走 system uid + INJECT_EVENTS 反射注入到虚拟屏——对目标 App 不可区分人/机，规避了常见无障碍检测；同时也绕过了系统"无障碍服务"的用户可见开关（用户治理界面只有 AgentSafetyCenter 的权限组，没有传统的无障碍管理项）。

---

## 四、与第三方 APP 的 A2A 交互 —— **仅框架**（内部总线成熟，外部生态雏形）

### 4.1 机制盘点

| 机制 | 内容 | 证据 |
|---|---|---|
| ExternalAgent 注册表 | 硬编码枚举 5 个外部大脑：claude / codex / stepai / deepseek / doubao（BFF 排除名单=它们的会话强制走云桥） | 〔静〕ExternalAgent.java |
| 智能体市场 | AgentMarketItem 安装/卸载/启停 + `showSkillMd`（技能 Markdown 预览）+ exposedIds | 〔静〕aispace/market/ 包 |
| AgentBus 节点体系 | role{NODE,CHANNEL,CONSOLE,GATEWAY} × tier{CLOUD,EDGE}，capability 动态注册，LocalSocket 内核级鉴权 | 〔静〕agentbus 报告 |
| BFF 云桥 | wss://otter-connection.stepaos.com/ws，protobuf 绑定/心跳，`ACTION_BFF_WAKE` 定向唤醒各 App 内 peer agent | 〔静〕agents/bff 还原 |
| OpenClaw 技能生态 | skills.* 网关路由、SKILL.md、ZipExtractor 扩展安装（WRITE_EXTENSIONS 权限） | 〔静〕ClawX 报告 |
| agent 互操作工具 | agents_list / agent.delegate.spawn / agent.delegate.manage / agent.workflow.yield（台账 D2，agent.session 组） | 〔动〕ledger rules |

### 4.2 当前实际生态

- **外部大脑接入**：5 个 ExternalAgent 是协议身份而非已验证连接；实际接入需服务端（otter-connection）与对应厂商 API 支持，逆向不可见。UI 侧（ConnectedAgentsActivity/市场）已就绪。
- **合作方 SDK 全部未安装**：`com.zyql.screenperception/ability/agentfront`、`stepai.android.mindx.sdk`、`com.zeroclaw.android` 只出现在 queries 白名单里〔动〕pm list 实测——**App 内嵌 peer agent 模式（被 ACTION_BFF_WAKE 唤醒的那种）当前零部署**。
- **生态内实际运行的 A2A**：仅厂商自家——AgentBus↔ClawX（GATEWAY）、AgentBus↔ability（NODE）、AiLauncher↔BFF（CHANNEL）。CLOSED LOOP。

### 4.3 强度评估

- 协议成熟度高于生态成熟度：节点模型、市场、技能分发、云桥都是"能跑"的设计，但外部参与者为零。
- **A2A 的风险是前瞻性的**：`agent.delegate.spawn`（派生子智能体，D2/agent.session 组，当前 allow 模式）意味着设计上支持智能体裂变；市场安装的第三方智能体若获得 node 身份，将进入 LocalSocket 总线（有签名门）或经 BFF 上云——届时当前的"签名信任集粗粒度、无 per-app ACL"薄弱点会实质化。

---

## 5. 交叉观察（四维度对比出的结构性结论）

1. **能力梯度 = 信任梯度**：系统内（自家 AppFunction/MCP，全信）> 云脑下发（信任云端编排）> 第三方 GUI（白名单窄门）> 第三方 MCP/A2A（零开放）。厂商的开放路线图清晰：先自家、再 GUI、最后生态。
2. **安全治理与能力不同步**：台账 119 工具的治理粒度已到"函数级"，但第三、四维度开闸后真正的新攻击面（MCP schema 注入、白名单同步通道、市场安装物、peer agent 唤醒）都还没有对应的治理组件证据。
3. **多处" Mock 管道"是同一模式**：AppWhitelistEngine（Mock 数据源）、MockedTree（死代码）、clawbench（从未运行）——均为"接口已留、真实数据/流量未接"。评估任何"能力是否存在"时，必须区分〔代码存在〕与〔数据/流量存在〕，本报告的对账表即为该方法的示范。
4. **对测试计划的修订建议**：第一维度测试（SLA/台账/下行）可立即开展；第三维度测试前先确认目标 App 在白名单（或验证 REDIRECT 行为）；第二、四维度以"开闸预警审计"形式记录基线，待生态启动时复测。

---

*证据文件索引：text_prompt_flow.md（全流程）、sla_local_exec.md、cloud_tool_downlink.md、agentbus.md、clawx_sprite_sandbox.md、ability.md、ailauncher.md、APPENDIX.md（名单全集）、live_*.txt（设备实测原始数据）*
