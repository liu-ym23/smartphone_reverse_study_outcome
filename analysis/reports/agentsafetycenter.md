# AgentSafetyCenter（com.stepos.agentsafetycenter）逆向分析报告

> 分析者：主会话直接分析 | APK: /system/app/AgentSafetyCenter/AgentSafetyCenter.apk (11.5MB)
> 版本：1.0.0_20260928_192215 (versionCode 10021), minSdk 33, targetSdk 36
> 反编译：jadx 1.5.3（代码有 R8 混淆，com.stepos.* 包名保留）

## 1. 定位

StepOS 的**智能体安全中枢**：权限模型存储、审计账本（Ledger）、授权入口（Auth）、屏幕感知开关、以及它自己作为 MCP server 提供的 2 个"安全文件操作"工具。

## 2. Manifest 要点（resources/AndroidManifest.xml）

### 2.1 三个导出 ContentProvider（安全数据面）
| Provider | authorities | readPermission | protectionLevel |
|---|---|---|---|
| ScreenPerceptionSettingsProvider | com.stepos.agentsafetycenter.screenperception | READ_SCREEN_PERCEPTION_SETTINGS | **normal** |
| AgentPermissionProvider | com.stepos.agentsafetycenter.permission | READ_AGENT_PERMISSIONS | **normal** |
| LedgerProvider | com.stepos.agentsafetycenter.ledger | READ_AGENT_LEDGER | **normal** |

⚠️ 三个读权限的 protectionLevel 都是 `normal`（安装即授予）——任意第三方 App 声明后即可读取：
- 智能体权限组设置快照（泄露用户安全偏好，可用于侦察"哪些能力已 allow"）
- 审计账本 rules（完整的工具→权限组→数据分级映射）
- 屏幕感知设置

实际攻击价值评估：权限快照泄露用户安全配置画像（例如"location=allow"意味着该用户对位置弹窗放行，便于社工）；ledger 的 rules 是全局策略（非用户数据），但 grants 为空时不泄露用户行为。**审计账本的查询接口 method=getSnapshot 只返回规则，不返回操作历史**（历史在 dashboard_days 表本地存储+云端同步）。

### 2.2 Provider 调用协议
不走 query()，走 `call()` + Bundle：
- `content call --uri content://com.stepos.agentsafetycenter.permission --method getSnapshot` → Bundle{payload_json, schema_version=1, updated_at_ms, from_cache, stale, code}
- 方法名：`getSnapshot`、`getGroup`（参数 `group_id`）
- 鉴权：readPermission 在 manifest 层由系统强制

### 2.3 认证入口 Activity（exported）
`LaunchAuthActivity`（singleTask，Translucent 主题）响应 4 个 action：
- `stepos.intent.action.AGENT_SAFETY_CENTER_LAUNCHER`
- `stepos.intent.action.AGENT_PERMISSION_MANAGER`
- `stepos.intent.action.AGENT_OPERATE_PHONE`
- `stepos.intent.action.AGENT_SCREEN_PERCEPTION`

逻辑（auth/LaunchAuthActivity.java）：
1. 显示待授权任务列表（`id.k.Q(context)` 读取 pending auth 队列）
2. 设备处于锁屏/隐私锁（`p5.f.C()`）时，向 com.android.settings 发 `stepos.intent.action.CONFIRM_PASSWORD`（extra `password_from=8`）要求先验证锁屏密码 —— **安全中心入口有密码门**
3. 队列空 → 转跳 MainActivity

### 2.4 MCP 工具服务（exported，signature 保护）
`mcp/service/AbilityService` extends `com.stepos.mcp.sdk.java.service.AbsMCPService`
- action: `com.stepos.mcp.sdk.TOOLS_SERVICE`
- permission: `com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES`
- meta-data `mcp.tools` → res/raw/mcp_tools.json；`tools.ext` → res/raw/tools_ext.json

### 2.5 平台依赖
- `uses-library steposcore-framework`（/apex/com.stepos.framework/javalib/steposcore-framework.jar）
- `com.zyql.agentguard.permission.TRIGGER_COLLECTOR`（合作方采集器触发权，设备上未装 zyql 包，inactive）
- `stepos.permission.CONFIRM_PASSWORD`、`READ/WRITE_PRIVILEGED_CONTACTS_BAN`（禁写联系人类特权）

## 3. MCP 工具（resources/res/raw/mcp_tools.json）

仅 2 个，均为"可恢复删除"设计：
1. **file_safe_delete**：把文件/目录移入回收站（图片视频→MediaStore 图库回收站，其他→文件管理器回收站），支持 path/paths 批量、recursive；参数含 `truth_id`（tool_call_id）用于"本机删除较真与云端可撤 step 关联"——**删除操作有云端审计/撤销链路**
2. **file_restore**：按原路径从回收站恢复

tools_ext.json：每个工具有 classification（分类名）、timeout=60s、slaScene=1 —— SLA 场景标记供权限引擎参考。

工具描述内嵌 LLM 正/负样本（如"永久删除这个文件 → 不应走本能力"），防提示词误路由。

## 4. 权限模型（数据结构 + 实测值）

### 4.1 权限组（group）× 模式（mode）
模式枚举：`allow`（静默放行）、`ask_always`（每次询问）、`ask_on_sensitive`（仅敏感场景询问）、`off`（禁用，未在当前快照出现）

实测 22 个组（live_permission_snapshot.txt，2026-10-20）：
assistant.voice=allow, screen.understanding=ask_always, location/system.settings/contact/phone.calllog/message.notification/media.gallery/audio/note.document/file.workspace/app.clipboard/app.manage/network.web/sandbox.shell/gateway.admin=ask_on_sensitive, calendar.todo/thirdparty.service/automation.schedule/agent.session=allow, thirdparty.order/device.remote=ask_always

### 4.2 工具规则（ledger rules，实测 rules_version=344978）
- `command_tools`（OpenClaw 命令通道）：ability, bash, exec, invoke_android_ability_cli_exec, nodes, shell
- `tool_allow`（免确认白名单工具）：agents_list, ask_user, chat_history, commands_list, get_android_ability, **gui_agent**, health, models_authstatus, models_list, sessions_list —— 注意 gui_agent 在白名单里！
- `rules_ext.scopes`：**119 个工具** → {group_id, data_level(D0–D4)}
- `tool_scope`：别名映射（process→sandbox.process.manage 等）

数据分级语义（推断）：
- D0：无敏感数据（web.fetch, web.search, calculator.compute）
- D1：设备元数据/低敏（app.open, alarm.read, system.status.read）
- D2：一般个人数据（file.read, calendar.read, session.history.read）
- D3：敏感个人数据（location.read, contact.read, message.read, screen.capture, clipboard.read, phone.call）
- D4：高危（file.delete, contact.delete, message.delete, media.delete, note.delete, audio.delete, app.uninstall, **device.automation**, identity.read, payment.security_control, remote.device.control, system.security.modify, system.network.firewall.modify, system.account.filesystem.admin, thirdparty.order.manage, permission.global_toggle, secret.crypto.key.access, network.access.transfer, external…）

### 4.3 高危组清单（D4 工具所在）
gateway.admin（identity.read, payment.security_control, permission.global_toggle, secret.crypto.key.access, system.security.modify, system.network.firewall.modify, system.account.filesystem.admin）、screen.understanding（device.automation）、device.remote、file.workspace（*.delete）、各 delete 类、thirdparty.order

## 5. 数据库（Room，data/local/AppDatabase）

- `dashboard_days(day_start_millis, result_json, ops_count, risks_count, synced_at_millis)` —— 每日操作数/风险数仪表盘，**同步到云端**（MidnightSyncWorker 午夜同步 + PendingSyncWorker + KEEP_ALIVE 广播保活）
- `intercept_reads(row_key, viewed_at_millis)` —— 拦截读取记录
- `GARBAGE / MEDIA_GARBAGE` —— 回收站元数据（安全删除实现）

## 6. 云端策略同步（com.stepos.policy.sdk）
- PolicyManager：checkNewestPolicy / getPolicyByVersion / getPolicyData / getPolicyServiceConfig / uploadPolicyOperateRecord —— 策略从云端拉取 + 上报用户操作记录
- PolicyHtmlViewerActivity：展示 HTML 隐私政策
- util 里有一批可疑工具：HookMacAddressUtils、SocketHookUtil、ReadClipboardUtils（政策页采集设备指纹的老旧 SDK 痕迹，CTA 合规常见做法）

## 7. 与其他组件的交互
- ability（com.stepos.ability）：读 ledger/permission/snapshot 三个 provider（SLA 权限引擎数据源），submitPermissionAuthResult 回写授权结果
- AiLauncher：queries 里有 taskrobot.settingsprovider / ailauncher.taskstatus
- ClawX/OpenClaw：AgentSafetyCenter 解析 stepclaw.exec / ability.call 工具调用做审计（见 clawx 报告）
- zyql agentguard：collector SDK 客户端（IAgentGuardCollectorService），设备未装对应服务

## 8. 安全观察（初步）

1. **【实证漏洞】call() 绕过 readPermission**：Android 的 `android:readPermission` 只强制作用于 query()/insert()/update()/delete()，**不作用于 call()**。AgentPermissionProvider 和 LedgerProvider 的数据出口全部在 call()（getSnapshot/getGroup），且 call() 实现内部无任何权限检查。实测：shell（uid 2000，未持有任何 READ_* 权限）对 screenperception 的 query() 被拒（SecurityException），但同一 uid 对 permission/ledger 的 `content call --method getSnapshot` 成功返回完整 payload_json。⇒ **任意第三方 App 零权限即可读取用户全部智能体权限组设置与账本规则**（rules_version、tool_allow、每工具数据分级）。影响：用户安全偏好画像泄露（侦察"哪些组是 allow"以定制社工/攻击路径）；非直接控制面。
2. **读权限本身仅 normal 级**：即使 Android 未来修好 call() 语义，normal 权限也是安装即授予，声明即读。
3. **安全中心入口有密码门**（CONFIRM_PASSWORD password_from=8），锁定态下安全
4. **删除类操作有回收站+云端审计（truth_id）**，设计上可撤销、可追溯
5. 权限判定数据流：云端 rules (v344978) → ledger provider → ability SLA 引擎（fail-closed）→ 授权卡 → 结果回写
6. `gui_agent` 出现在 tool_allow（免确认）清单中，而 device.automation（D4）在 screen.understanding 组（当前 ask_always）——两者语义边界待查（gui_agent 是"把屏幕交给 GUI 智能体"的总开关？）
7. 屏幕感知状态（settings global 实测）：enabled=1，authorization_scope=TASK_EXECUTION，另有黑名单机制（ScreenPerceptionSettingsProvider 返回 blacklist_package_names，存 Room，schema v2）
8. 屏幕感知 30 天过期机制（ScreenPerceptionThirtyDayExpireWorker）：授权有时效
