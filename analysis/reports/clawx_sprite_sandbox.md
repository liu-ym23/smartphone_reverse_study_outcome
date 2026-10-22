# StepOS 智能体应用逆向分析报告：ClawX / AgentSprite / AppSandbox(pps)

> 分析对象（jadx 反编译输出，代码经 R8 混淆但 `com.stepos.*` 包名保留）：
> - ClawX (`com.stepos.stepclaw`)：`analysis/decompiled/ClawX/`，versionName 1.0.7_20260915_173835
> - AgentSprite (`com.stepos.agentpack`)：`analysis/decompiled/AgentSprite/`，versionName 1.0.4_20260928_154957
> - AppSandbox (`com.stepos.pps`)：`analysis/decompiled/AppSandbox/`，versionName 1.0.0_20260716_182848
>
> 所有路径均相对 `analysis/decompiled/`。

---

## 1. ClawX 是什么：一个跑在 system uid 上的 OpenClaw 节点（端侧 Agent 运行时）

**结论：ClawX 不是浏览器/爬虫。"Claw" 来自 OpenClaw**（开源个人 AI 助手项目）。ClawX 是把 OpenClaw Gateway（Node.js）通过 **chroot Linux rootfs** 完整搬进手机的"端侧 Agent 服务"（`ClawX/resources/res/values/strings.xml` 中 `app_name = "端侧Agent服务"`），主题名为 `Theme.OpenClawNode`。助手人格名"小跃"，自我定位"ClawPhone 内置智能助手"（`ClawX/resources/assets/openclaw/workspace/IDENTITY.md`）。

### 1.1 应用形态与入口

- `AndroidManifest.xml`：`android:sharedUserId="android.uid.system"`（**以 system uid 运行**），无任何 Activity（纯无头后台系统应用），入口组件：
  - `com.stepos.stepclaw.StepClawApp`（Application）
  - `GatewayForegroundService`（specialUse 前台服务，保活 Gateway 会话）
  - `StepClawService`（dump 服务，注册 `DumpCommandHandler`/`MemoryDumpCommandHandler`，供 `dumpsys` 调试）
  - `OpenClawProvider`（跨进程配置 IPC，authority `com.stepos.stepclaw.provider`）
  - `AliveReceiver`（`com.stepos.stepclaw.KEEP_ALIVE` 系统保活广播）、`InstallResultReceiver`、`PackageReplacedReceiver`
  - `edge.DeviceNotificationListenerService`（读取系统通知，给智能体提供设备上下文）
- 启动链：`StepClawApp.onCreate()` → `UserSetupCompletionGate.startGatewayWhenComplete()`（监听 Settings.Global `user_setup_complete=1` 后拉起 `GatewayForegroundService`）→ `GatewayRuntime` → `GatewayAutoStart.startGateway()` → `SystemChrootRuntimeController.startOpenClawEnv()`（`/system/bin/setprop` 置 `init.svc.openclaw_env` 相关属性，由 init 脚本在 chroot 内启动 node/openclaw）。关键代码：
  - `ClawX/sources/com/stepos/stepclaw/StepClawApp.java`
  - `ClawX/sources/com/stepos/stepclaw/GatewayRuntime.java`（会话/自愈核心：`ensureLoopbackEndpoint()` 默认连接 `127.0.0.1:18789`；`triggerChrootOtaSelfHeal()` 在断连/网络恢复时自动重装/自愈 rootfs）
  - `ClawX/sources/com/stepos/stepclaw/gateway/GatewayAutoStart.java`
  - `ClawX/sources/com/stepos/stepclaw/runtime/SystemChrootRuntimeController.java`（GETPROP/SETPROP/STOP 二进制路径写死 `/system/bin/*`）

### 1.2 chroot 子系统（Agent 的"身体"）

- rootfs 挂载点 `/mnt/openclaw/rootfs`（`runtime/OpenClawRuntimeConfig.java` 的 `MOUNTED_ROOTFS_PATH`，由系统镜像 ubuntu.img 挂载）。
- APK 内置资产 `resources/assets/openclaw/`：
  - `openclaw.tgz`（gateway npm 包，版本 `2026.4.26-stepclaw.21`，见 `manifest.json`）——由 `chroot/OpenClawPackageInstaller.java` + `chroot/ChrootRootfsInitializer.java` 解包安装（tar 流式解压，`TarArchiveInputStreamExtKt`），含 `UpgradeDoctor`/`RootfsHealthChecker` 自愈与快照回滚（`snapshotBeforeRootfs: true, snapshotMaxKeep: 5`）。
  - `resources/assets/scripts/chroot-env-probe.sh`：探测 chroot 内 python3/node/npm/git、python 包（requests/numpy/pandas/PIL/faster_whisper…）、DNS（`api.moonshot.cn`）、`/sdcard` 读写、gateway 18789 存活——说明 **chroot 内可访问 /sdcard（用户共享存储）**。
  - `workspace/`（IDENTITY/SOUL/TOOLS/HEARTBEAT/AGENTS/USER/BOOTSTRAP.md，OpenClaw 人格文件）、`prompt-templates/zh|en/`（含 `safety.md`）、`skills/`、`extensions/`、`auth-profiles.json`、`openclaw.json`（默认配置）。
- 用户数据管理：`chroot/UserDataManager.java`；工作空间 `/mnt/openclaw/rootfs/root/.openclaw/workspace`（`StepClawManager.init()` 中传给 MemoryBridge）。

### 1.3 工作模式：Gateway（云侧大脑） + Android 节点（端侧手脚）

`resources/assets/openclaw/openclaw.json` 定义了完整拓扑：

```json
"gateway": { "auth": {"mode":"token"}, "bind": "loopback", "port": 18789,
  "nodes": { "allowCommands": ["ability.call","agent.call","stepclaw.exec"] } },
"channels": { "android-node": { "mode": "stepclaw" } },
"models": { "providers": { "stepos": { "baseUrl": "http://127.0.0.1:18791/v1", "api": "openai-completions",
  "models": [{"id":"stepos-model-auto","maxTokens":32768}] } } },
"agents": { "list": [ {"id":"main","default":true,"subagents":{"allowAgents":["task-bot"]}},
  {"id":"task-bot"}, {"id":"echo","tools":{"allow":["read"],"deny":["exec","ability.call","nodes","browser","web_search","write","edit"],"fs":{"workspaceOnly":true}}} ] },
"tools": { "allow": ["group:fs","group:runtime","group:openclaw","group:plugins","task-bridge"],
  "deny": ["web_search","browser"] },
"plugins": { "allow": ["android-node","stepclaw-intercept","stepclaw-exec","task-bridge"], "slots": {"memory":"none"} }
```

- **与 LLM 的交互**：chroot 内 OpenClaw Gateway 不直连云端 LLM，而是把模型统一指向本机 `http://127.0.0.1:18791/v1`（OpenAI completions 协议）。18791 是 ClawX Java 侧的 **StepOSProxyServer**（`base/net/StepOSProxyServer.java`，随 `GatewayAutoStart` 启动），由它代理转发到 StepOS 云 `https://biz-gw.stepos.com`（测试环境 `biz-gw.t-stepos.com`，见 `base/net/StepNet.java`），并用 `StepOSHeaders`/`StepOSCredentials`（HMAC-SHA256 签名，`base/util/HmacSha256Utils.java`）注入设备/账号签名——**API key 不落在 chroot/Gateway 配置里**（`auth-profiles.json` 里 stepos:default 的 key 只是 `"proxy-placeholder"`）。云端模型名 `stepos-model-auto`（`StepModel.java`/`ModelPreset.java` 支持按 model/provider/baseUrl/apiKey 覆盖）。
- **Java↔Gateway 控制面**：`GatewaySession.java` 以 WebSocket **node 客户端**身份连入 `127.0.0.1:18789`：connect.challenge nonce → `DeviceAuthPayload.buildV3(...)` 由 `DeviceIdentityStore` 私钥签名 → token/password 认证（`config/GatewayAuthConstants.java`、`gateway/DeviceAuthStore.java`）。Gateway 下发 `invoke` 事件，App 执行 ability.call 等命令并把结果回传（`GatewaySession$Connection$handleInvokeEvent`）。`openclaw/OpenClawClient.java` 另提供到 Gateway HTTP API 的 REST 客户端（健康检查 `/health`、sessions 等）。
- **消息通道**：`extensions/android-node/index.js`（纯 JS 插件）注册 `android-node` channel，通过 Gateway broadcast 把 cron/心跳/回复投递到设备；注册制 `android-node.register-session` + `before_tool_call` 钩子强制 cron 任务 delivery 指向注册过的会话。
- **记忆子系统**（`memory/`）：LightMem 云记忆 + 本地混合检索——`memory/search/`（BM25 + 向量双路召回、查询改写、rerank）、`memory/storage/index/`（BM25 索引、分词、分层缓存）、`memory/embedding/`（远程 embedding）与 `memory/lightmem/local/LocalMemoryRuntime.java`（**调用 Meizu/Flyme 端侧 NPU 算法服务 `com.meizu.aiservice.api.service.IAIEngine` binder 做本地 BGE 向量**，对应 Manifest 中 queries `com.flyme.auto.superai`/`com.meizu.superalgorithmservice`）、`memory/upload/`（签名上传）、`memory/lightmem/evolution/OfflineEvolution*`（离线记忆演化）。模型/密钥从 `Settings.Secure lightmem_model / lightmem_key` 动态读取（`StepClawManager.java`）。
- **执行什么任务**：`skills/android-abilities/SKILL.md`（意图路由器）列出 12 类端侧能力：phone_comm（电话短信）、contacts、system_settings、media_gallery、map_navigation、app_device、web_search（云侧）、file_memory、**gui_agent（核心：在第三方 App 内做搜索/加购/下单/点赞/关注等 GUI 自动化，超时 600s）**、scheduled_tasks（cron）、session_runtime、log_report。调用协议统一为 `nodes action=invoke invokeCommand="ability.call" invokeParamsJson='{"method":"...","params":{...}}'`，且 SKILL.md 强制"必须先 read 类目 .md 文档拿 method 名，禁止猜测/禁止绕过 ability 层直接调底层 action"。文件操作走 `stepclaw.exec`（见下）。`echo` 是一个最小权限探针 agent（只许 read、workspaceOnly、禁 exec/browser）。

### 1.4 保持运行

`keepalive/DynamicKeepAliveManager.java` + `AliveReceiver`（权限 `com.stepos.permission.RECEIVE_KEEP_ALIVE`，系统级保活框架广播）、`NetworkRecoveryMonitor.java`（断网恢复后重连 + chroot OTA 自愈）、`GatewayReconnectDiagnostics`（自动重启限速/冷却 AUTO_START_COOLDOWN_MS）。

---

## 2. ClawX 的安全策略

### 2.1 Gateway 加固（ConfigGuard）

`gateway/GatewayAutoStart.java` 中 `enforceGatewayConfig()`/`handlePersistentConnectFailure()` 强制纠正三项配置并记日志（"[ConfigGuard] corrected ..."）：
- `gateway.auth` 必须 token 模式；
- `gateway.port` 必须 18789；
- `gateway.bind` 必须 `loopback`（仅本机监听）。

恢复策略分三层：Tier-0 字段纠正 → Tier-1 `restoreGatewayFields` 外科恢复 → Tier-2 从 `JsonConfigStore.backupKnownGood()` 全量回滚（连接成功后备份 known-good 配置）。

### 2.2 工具调用拦截（edge/hooks，Java 侧安全钩子服务）

`edge/intercept/InterceptHttpServer.java`：**仅绑定 `127.0.0.1:18790`**（`new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"))`），OpenClaw 的 stepclaw-intercept 插件把全部生命周期钩子 POST 到这里：`before_tool_call / after_tool_call / tool_result_persist / before_message_write / before_prompt_build / before_model_resolve / llm_input / llm_output / before_agent_start / agent_end / session_start / session_end / before_reset / before_compaction / after_compaction / message_received / message_sending / message_sent / subagent_spawning / subagent_spawned / subagent_ended / subagent_delivery_target / gateway_start / gateway_stop / cron_session_start / tool_client_correlation`。

当前实际生效的拦截规则（`edge/intercept/handlers/ToolHookHandler.java`）：
- **exec 危险删除拦截**：一组正则（`RM_ON_SD_CARD_REGEX`、`FIND_DELETE_ON_SD_CARD_REGEX`、`FIND_EXEC_RM_ON_SD_CARD_REGEX`、`FIND_XARGS_RM_ON_SD_CARD_REGEX`、`CD_TO_SD_CARD_WITH_RM_REGEX`、`CD_TO_SD_CARD_WITH_FIND_DELETE_REGEX`）匹配 `rm/find -delete/-exec rm/|xargs rm` 作用于 `/sdcard` 或 `/storage/emulated/0` 的命令 → `BeforeToolCallResponse.block(...)`；其余工具默认 `allow()`（memory 文件读写特判放行，cron 交给 android-node 处理 delivery）。**即：默认放行、仅封"删用户数据"一类命令**。
- 网络明文白名单（`resources/res/xml/network_security_config.xml`）：cleartext 仅允许 `localhost/127.0.0.1`、`openclaw.local`（mDNS 发现）、`ts.net`（Tailscale）。

### 2.3 stepclaw-exec（chroot 内 shell/文件工具，JS 插件侧白名单）

`resources/assets/openclaw/extensions/stepclaw-exec/index.js`（In-Gateway exec，替代外部 node-host daemon）+ `TOOL-SPEC.md`（ls/stat/find/mkdir/rm/mv/cp/read/write/edit/pull/push，workspace: URI 映射 `/root/.openclaw/workspace/`）：
- **argv[0] 白名单** `DEFAULT_ALLOWED_COMMANDS`：`python, python3, node, sh, bash, echo, cat, ls, pwd, whoami, uname, env, which, head, tail, wc`；绝对路径仅允许 /usr、/bin、/sbin 前缀；
- **硬编码拒绝子串** `HARDCODED_DENY_PATTERNS`：`rm -rf`、`mkfs`、`dd if=/dd of=`、`curl|sh` 系列、`sudo `、`eval $(`、反弹 shell `bash -i >& /dev/tcp/`、`chmod 777 `、`/etc/shadow`、`/proc/self/mem`（配置不可关闭）+ 可配置 denyPatterns；
- **cwd 白名单** `ALLOWED_CWDS`：`/`、`/tmp`、`/root`、`/root/.openclaw`、`/var/log/openclaw`，禁 `..`；
- **env 黑名单** `FORBIDDEN_ENV_KEYS`：`LD_PRELOAD, LD_LIBRARY_PATH, PATH, HOME, USER, LOGNAME, SHELL, NODE_OPTIONS, PYTHONSTARTUP`；
- 超时 100ms–60s（默认 10s）；read 2MB/2000 行上限、write 8MB 上限（`E_TOO_LARGE`）。

### 2.4 URL 加载 / JS 执行 / WebView（澄清）

ClawX **没有浏览器型 URL 白名单机制**——它根本不内置浏览器：
- OpenClaw 原生 `browser` 与 `web_search` 工具在全局 `tools.deny` 中被禁（"browser 仅控制桌面/PC 浏览器"，`SKILL.md` app_device 类目注明"打开网页"走手机侧 App 而非 browser 工具）；
- 网页类需求改走**云侧** ability：`web_search / web_fetch / bing_search / stepsearch-public / fetch_trending_news / diandian_share_fetch`（`skills/android-abilities/web_search.md`），即抓取在云端完成，端侧不渲染网页；
- WebView 在 App 内仅用于能力探测（`StepClawApp.onCreate()` 里 `new WebView(this)` try/catch 置 `isWebViewAllowed`），无 URL 加载逻辑；
- JS 执行发生在两处：chroot 内 Node.js 插件（受 2.3 白名单约束的 exec）与 Gateway 插件体系（plugins.allow 白名单 + `ZipExtractor.java` 安装扩展时拦截 `..` 路径穿越，写权限 `com.stepos.aios.stepclaw.permission.WRITE_EXTENSIONS` 为 system|signature）。
- 可选隐私路由插件 `extensions/clawxrouter/`（默认 disabled）：S1/S2/S3 三级敏感度分类、本地 guard agent（ollama/minicpm4.1）、隐私代理（默认 8403 端口）先脱敏 PII 再转发云端（`src/privacy-proxy.ts`、`src/guard-agent.ts`、marker `<clawxrouter-s2>`）。

### 2.5 凭证处理

- **存储**：`SecurePrefs.java` / `base/prefs/SharedSecurePrefs.java` 用 EncryptedSharedPreferences + AndroidKeyStore MasterKey；gateway token/password 按实例 ID 分键（`gateway.token.<stableId>`、`gateway.password.<stableId>`、TLS pin `gateway.tlsFingerprint`）。
- **设备绑定派生**：`config/GatewayTokenDeriver.java`（HMAC-SHA256，盐 `stepclaw-gateway-token-salt-v1`）+ `config/DeviceGatewayTokenStore.java`（`derived_token`，`deviceBound=true`），即 gateway token 由设备身份派生而非明文下发；`maskToken()` 日志脱敏。
- **云端认证**：LLM 流量经 StepOSProxyServer 注入签名头（`StepOSCredentials.getSigningCredentials()`），chroot 内不见真实 key；账号身份由 `base/util/StepAccount.java`（OAID/localAccountId）与 `MzAccountIdentityProvider` 提供。
- **提示词层安全**：`prompt-templates/zh/safety.md`（红线：不自我复制、不扩权、不绕过安全措施、人类监督优先）；compaction 后固定回灌 "Red Lines 红线（对用户）" 段落（openclaw.json `postCompactionSections`）。

### 2.6 IPC 暴露面

`provider/OpenClawProvider.java`（exported，但读/写分别要求 `com.stepos.aios.stepclaw.permission.READ_CONFIG` / `WRITE_CONFIG`，protectionLevel=system|signature）：路由 `config/model`、`config/openclaw/reset`、`gateway/auth_token`、`gateway/status`、`skills[/install|/update/]`、`tools[/install|/update/]`、`cronjobs[/add]`、`cron/run_logs`、`channels`、core files；handlers 在 `provider/handlers/`（`SkillsHandler/ToolsHandler/CronjobsHandler/GatewayManagerHandler/CoreFilesHandler/ZipExtractor` 等）。

---

## 3. AgentSprite 是什么：智能体精灵"Amoo"的纯资源包

**`com.stepos.agentpack` 是一个 `android:hasCode="false"` 的无代码资源 APK**（Manifest 仅 19 行，无组件、无权限，label "AgentSprite Pack"，allowBackup=false）——它不"执行"任何智能体，只承载**桌面宠物式智能体形象（名叫 Amoo）的全部视觉/文案资源**，供宿主 App（主要是 `com.stepos.ability`，其 Manifest `<queries>` 明确查询 `com.stepos.agentpack`）加载渲染。

内容（`AgentSprite/resources/`）：
- **33 个 PAG 动画**（腾讯 PAG 格式，`assets/*.pag`）覆盖智能体全状态机：`thinking`、`awaiting_user`、`awaiting_user_authorize`、`idle_night`、`idle_flying`、`idle_loafing`、`idle_exercise`、`speed_up`、`success`、`error`、`gui_operate`（GUI 自动化执行中）、`skill_market_browsing/installing/installed/early_installing`（技能市场）、`repair_room_idle`、`agent_space_idle`、`chat_view_idle`、`oobe_*`（开机引导：greet/listening_left|right/confirm/excellent/wake/smile/entry_slide/wear_glasses 等）。
- **状态台词**（`res/values/arrays.xml` 的 `agent_lines_*`，含 zh-CN/zh-HK/zh-TW）：awaiting_user("Need a decision from you.")、browsing、error("Let me head to the fix-it room.")、html_pet("I'm a tiny WebView pet now. Yes — this body is just HTML + CSS.")、installing、interrupted、invoking("Calling a tool — hang tight.")、listening、responding、sleeping("zzz… Tap to wake me.")、speaking、thinking、timeout、watching_stars/snow、morning_stretch 等 ~24 组。
- **帧序列/场景网格**：`amoo_home_screen_frames`、`amoo_keyboard_shown_frames`（`res/drawable/amoo_home_screen_00..N` 帧动画）、`awaiting_user_danger_frames`、`idle_safe_frames`、`thinking_safe_frames`、`gui_operate_frames`、`place_skill_market_grid`、`place_repair_room_grid`、`place_workshop_grid`、`weather_*_grid`（晴/雨/雪/雾/雷/风天气场景）。
- **表情与背景**：`emo_love/emo_star_eyes/emo_cry/emo_fallen/emo_frustrated/emo_thumbs_up...`、`agent_thinking/agent_sleeping/agent_success...`、锁屏/启动器/聊天视图背景（`lock_screen_*`、`launcher_idle_*`、`chat_view_*`、`agent_space_bg`）。

**展示/驱动方**：`ability`（com.stepos.ability）中存在 `voicewakeup/ui/WakeupPagAnimation.java`（播放 PAG）、`VoiceWakeupStateProvider`（方法 `set_amoo_enabled`——语音唤醒/精灵开关）、唤醒词 `amoo_amoo`("amoo amoo")/`amoo_chulai`("amoo出来")（`ability/sources/C4/a.java`）；`com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient`（ICoreAgentClient 适配器，带 PushMessageListener/取消句柄/traceId）说明 ability 既是精灵宿主也是 ClawX Gateway 的 SDK 客户端。即：**AgentSprite=形象层，ability=宿主/交互层，ClawX=大脑与执行层**。（"danger/safe frames"、`awaiting_user_authorize` 等状态名暗示精灵会可视化"危险操作/等待授权"的安全状态。）

---

## 4. AppSandbox (`com.stepos.pps`)：遥测/数据"沙箱"（Quality Sense），而非应用隔离沙箱

**pps 不是安全意义上的 App 沙箱（不做应用隔离/权限围栏）**，它是 StepOS 的**持久化系统级数据采集-暂存-上报组件**（"数据沙箱"：数据先落本地沙箱、经用户同意与云端配置门控后再上报）。应用名 "Quality Sense"，图标 onemind，`coreApp="true"`、`persistent`、`directBootAware`、`defaultToDeviceProtectedStorage`、`usesNonSdkApi`，同样 `sharedUserId="android.uid.system"`。

### 4.1 隔离/门控什么

- **同意门控**：`PPSApplication.onCreate()` 检查 setup wizard 是否完成，未完成则 "defer all collection/report init"；`LogCollectionGate` 控制日志采集初始化（`com/stepos/pps/PPSApplication.java`）。
- **本地沙箱暂存**：错误/日志先写本地（OUC = 上报通道），磁盘满/空 tag/重复时经 `data/ouc/EmsLogDropReporter`（`R_SANDBOX_DISK_FULL`、`R_SANDBOX_EMPTY_TAG`、`R_SANDBOX_DUPLICATE`）上报丢弃原因——即"沙箱"指本地暂存区。
- **用户显式授权的日志拉取**：`logpull/LogPullAuthActivity`（授权）、`LogPullUploadChoiceActivity`（上传选择）、`LogPullCheckJobService/LogPullDeadlineJobService`（期限控制）、`USER_DELETE/PACK_STOP/FORCE_CHECK` receivers——抓取的设备日志受授权+期限约束。
- **云端配置门控**：`data/ouc/cloud/CloudUserConfigManager`（source_module="appsandbox"）拉取云控开关决定采集行为。
- **进程隔离**：`SystemEventService`（`com.stepos.pps.action.KEEP_ALIVE_SERVICE` / `SYSTEM_USAGE_BRIDGE`）通过 `IPPSClientService.aidl`（`onProcessLifecycle(uid, pid, state, pkg, start, end)`）接收框架进程生命周期事件——采集端与被采集 App 经 binder 隔离。

### 4.2 采集什么

`data/stats/`（ReportJobService、Battery/Graphics 触发 job、异常码 ExCodeReport）、`data/systemusage/SystemUsageManager`（亮灭屏、解锁、关机、uptime/进程数、每日 job）、`data/deviceid/DeviceIdService`（独立 `:deviceid` 进程）、`push/DataSyncManager.FetchConfigJobService`、`stability/KEReportReceiver`（内核异常 `com.stepos.pps.cpuexception` protected-broadcast）、`logpull/`、性能/游戏模式（`com.stepos.perf.*`、gamemode AIDL、刷新率权限）。`pps/reflect/`（`ActivityManagerStepOS` 等 + `usesNonSdkApi`）用反射访问框架隐藏 API；`stepos/com/android/os/StatsLog.java` 等是框架 stats 原子定义的映射。上报通道复用 Bytedance applog（`com.bytedance.applog.collector.Collector`，MigrateDetectorActivity）。

### 4.3 与智能体体系的关系

未发现 pps 与 ClawX/AgentBus/AIEngine/AgentSafetyCenter 的直接代码耦合；其价值在于为系统（含智能体质量分析）提供设备侧遥测。三者中只有它与智能体链路无直接交互。

---

## 5. 三者 AndroidManifest 关键组件与权限对比

| | ClawX (com.stepos.stepclaw) | AgentSprite (com.stepos.agentpack) | AppSandbox (com.stepos.pps) |
|---|---|---|---|
| uid | **sharedUserId android.uid.system** | 普通 | **sharedUserId android.uid.system + coreApp + persistent** |
| 入口 | StepClawApp（无 Activity） | 无组件（hasCode=false） | PPSApplication |
| 服务 | GatewayForegroundService（specialUse FGS）、StepClawService（dump）、edge.DeviceNotificationListenerService（BIND_NOTIFICATION_LISTENER_SERVICE） | — | SystemEventService（APP_BIND_SERVICE 权限）、DeviceIdService(:deviceid)、7 个 JobService |
| Provider | OpenClawProvider（exported；READ/WRITE_CONFIG system\|signature）、FileProvider | — | （依赖 LinkUnion/secureservice 等外部 provider，queries 声明） |
| Receiver | AliveReceiver（KEEP_ALIVE，权限 RECEIVE_KEEP_ALIVE）、InstallResultReceiver、PackageReplacedReceiver | — | KEReportReceiver、LogPull 系列 receiver |
| 自定义权限 | stepclaw.permission.READ/WRITE_CONFIG、WRITE_EXTENSIONS、GATEWAY_MANAGER（均 system\|signature）；signature 级 DYNAMIC_RECEIVER_NOT_EXPORTED | — | pps.service.permission、perf.provider.gamemode、pps.permission.POLICY_SDK、pps.permission.bugreport、battery.permission.health（signatureOrSystem） |
| 关键 uses-permission | INTERNET、**WRITE_SECURE_SETTINGS**、**INTERACT_ACROSS_USERS_FULL**、FOREGROUND_SERVICE(_SPECIAL_USE)、POST_NOTIFICATIONS、WAKE_LOCK、RECEIVE_KEEP_ALIVE、**agentcache.WRITE_AGENT_CACHE** | — | READ_PRIVILEGED_PHONE_STATE、**INTERACT_ACROSS_USERS**、MODIFY_PHONE_STATE、SYSTEM_ALERT_WINDOW、READ_DROPBOX_DATA、DEVICE_POWER、CONNECTIVITY_INTERNAL、UPDATE_CONFIG、BLUETOOTH_ADMIN 等 |
| queries | com.flyme.auto.superai、com.meizu.superalgorithmservice、meizu CapabilityProvider（端侧 NPU） | —（被 ability 查询） | com.stepos.secureservice、LinkUnionBaseProvider |

*English version:*

| | ClawX (com.stepos.stepclaw) | AgentSprite (com.stepos.agentpack) | AppSandbox (com.stepos.pps) |
|---|---|---|---|
| uid | **sharedUserId android.uid.system** | Normal | **sharedUserId android.uid.system + coreApp + persistent** |
| Entry point | StepClawApp (no Activity) | No components (hasCode=false) | PPSApplication |
| Services | GatewayForegroundService (specialUse FGS), StepClawService (dump), edge.DeviceNotificationListenerService (BIND_NOTIFICATION_LISTENER_SERVICE) | — | SystemEventService (APP_BIND_SERVICE permission), DeviceIdService(:deviceid), 7 JobServices |
| Provider | OpenClawProvider (exported; READ/WRITE_CONFIG system\|signature), FileProvider | — | (depends on external providers such as LinkUnion/secureservice, declared in queries) |
| Receiver | AliveReceiver (KEEP_ALIVE, permission RECEIVE_KEEP_ALIVE), InstallResultReceiver, PackageReplacedReceiver | — | KEReportReceiver, LogPull-series receivers |
| Custom permissions | stepclaw.permission.READ/WRITE_CONFIG, WRITE_EXTENSIONS, GATEWAY_MANAGER (all system\|signature); signature-level DYNAMIC_RECEIVER_NOT_EXPORTED | — | pps.service.permission, perf.provider.gamemode, pps.permission.POLICY_SDK, pps.permission.bugreport, battery.permission.health (signatureOrSystem) |
| Key uses-permissions | INTERNET, **WRITE_SECURE_SETTINGS**, **INTERACT_ACROSS_USERS_FULL**, FOREGROUND_SERVICE(_SPECIAL_USE), POST_NOTIFICATIONS, WAKE_LOCK, RECEIVE_KEEP_ALIVE, **agentcache.WRITE_AGENT_CACHE** | — | READ_PRIVILEGED_PHONE_STATE, **INTERACT_ACROSS_USERS**, MODIFY_PHONE_STATE, SYSTEM_ALERT_WINDOW, READ_DROPBOX_DATA, DEVICE_POWER, CONNECTIVITY_INTERNAL, UPDATE_CONFIG, BLUETOOTH_ADMIN, etc. |
| queries | com.flyme.auto.superai, com.meizu.superalgorithmservice, meizu CapabilityProvider (on-device NPU) | — (queried by ability) | com.stepos.secureservice, LinkUnionBaseProvider |

其他要点：ClawX minSdk 31 / target 36，`uses-library steposcore-framework`；pps `usesCleartextTraffic=false` + networkSecurityConfig；ClawX 明文仅限环回/openclaw.local/ts.net。

---

## 6. 与 AgentBus / AIEngine / AgentSafetyCenter 的交互

- **ability (com.stepos.ability)**：最直接的消费方。`com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.java`（ICoreAgentClient 实现，接 SDK 推送、工具调用回调、取消、traceId）+ `adapter/openclaw/AgentLog.java` 把 ClawX/OpenClaw 网关接入 StepOS agentframework；`com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding.java`、`ResumeSender.java` 表明 ability 同时是 **AgentBus 节点**——即 ability 是"AgentBus ↔ OpenClaw(ClawX)"的桥。端侧原子能力（ability.call 的 method 实现：设置、电话、gui_agent、文件等）由 ability 提供，ClawX 的 Gateway 通过 nodes.invoke 反向调用。
- **AgentBus**：`AgentBus/sources/o5/e.java` 的 DegradationController 构造并广播 **`stepclaw.status.change`**（v2，含 service/chat/tools/channel/upstream/bff{wsConnected,authed} 健康复合体）；`d5/b.java` 引用 `openclaw/tools`——AgentBus 订阅 ClawX 状态做降级调度，并感知 OpenClaw 工具清单。
- **AgentSafetyCenter**：`AgentSafetyCenter/sources/z8/f.java` 解析智能体工具调用文案：命令为 **`stepclaw.exec`** 时提取 params.tool、为 **`ability.call`** 时提取 params.method，生成可读操作描述（供安全审查/授权展示）。即安全中心以 ClawX 的两条执行命令为审计对象。
- **AIEngine**：ClawX 不直接引用 com.stepos AIEngine；其端侧推理走 Meizu 算法服务 binder `com.meizu.aiservice.api.service.IAIEngine`（`e3/d.java`、`LocalMemoryRuntime.checkResources`，transact code 11 查询 BGE 资源就绪）——StepOS 底层复用了 Flyme AI 引擎能力。
- **agentcache**：ClawX 持 `com.stepos.agentcache.permission.WRITE_AGENT_CACHE`，内置 `com.stepos.agentcache.sdk.AgentCacheSdk` + `ILogIngestService` binder（LogEventParcel 批量上报，`com/stepos/agentcache/`），把智能体运行日志送入系统侧缓存服务（供质量/安全分析）。
- **AppSandbox(pps)**：与上述四者无直接代码交互。

## 7. 值得注意的安全观察（供后续研究）

1. **ClawX 以 system uid 运行 chroot Linux**，rootfs 可读写 `/sdcard`（probe 脚本实测 sdcard_rw），`INTERACT_ACROSS_USERS_FULL + WRITE_SECURE_SETTINGS`——端侧 exec 白名单虽收紧（禁 sudo/rm -rf 等），但 `python/node/sh/bash` 本身即图灵完备，白名单内命令 + 可写 sdcard 的组合是主要攻击面；Java 侧 before_tool_call 目前只拦"sdcard 删除"，其余放行。
2. chroot 内 DNS 探测含 `api.moonshot.cn`，说明存在直连第三方 LLM 的部署形态（当前默认配置走 18791 本地签名代理）。
3. gateway token 派生盐 `stepclaw-gateway-token-salt-v1` 是硬编码常量（所有设备相同，设备绑定依赖 HMAC 输入中的设备因子）。
4. 环回三端口拓扑清晰：18789 Gateway（WS 控制面）、18790 hooks（安全钩子）、18791 LLM 代理；三者均仅 loopback，且 18790 无认证（依赖环回隔离，同机任意 uid 理论上可 POST 伪造钩子响应——但 hook 响应只影响放行/拦截标志）。
5. `echo` agent 的最小权限配置（allow:[read], fs.workspaceOnly, deny exec/nodes/browser）展示了系统内置的 per-agent 工具治理能力；clawxrouter 隐私脱敏插件默认关闭。
