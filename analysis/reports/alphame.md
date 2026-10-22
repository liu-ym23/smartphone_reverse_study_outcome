# AlphaMe 逆向分析报告（com.stepos.alphame）

- 分析对象：`analysis/decompiled/AlphaMe/`（jadx 输出，ProGuard 混淆，`com.stepos.*` 包名保留）
- APK 信息：`package="com.stepos.alphame"`，`versionName="1.0.0_20260924_180508"`（versionCode 10002），`coreApp="true"`，minSdk 33 / targetSdk 34（Android 14），应用显示名为 `aicy_app_name` = **"Smart Engine"**（`resources/res/values/strings.xml:28`）
- 源码根：`sources/com/stepos/alphame/`（约 40 个子包），资源：`resources/AndroidManifest.xml`

## 0. 总体结论（先说重点）

**AlphaMe 不是对话式主智能体（无 Siri 式主循环、无 LLM、无 MCP、无语音/文本指令入口、无 UI 自动化）。** 它是 StepOS 平台的**系统级"情境感知 + 个性化画像"后台引擎**（血统上接近魅族 Flyme 的 "One Mind / Aicy"，代码中残留 `onemind.zyql.com`、`*.meizu.com` 证书锚定、百度定位/地图 SDK、"AICY_Butler" 等痕迹）。它的工作模式是：

1. 开机自启（`AliveService`、`BootReceiver` 保活）；
2. 通过自定义 Binder 服务 `alphame_server`（发布到 `com.stepos.appplatform`）向**平台内其他系统应用**（设置、语音助手 `com.stepos.voiceassistant`、笔记、天气等白名单应用）提供"引擎函数"（场景识别、OCR、应用预测、个人偏好数据等）；
3. 通过 4 个导出 ContentProvider 对外提供用户行为统计；
4. 通过若干导出 Activity 提供"用户在 UI 上确认/选择个人信息"的选择器界面（选家/公司地址、选 WiFi、选车载蓝牙、选时间）。

与 `com.stepos.aiengine`、`com.stepos.agentbus`、`com.stepos.agentsafetycenter` **均无任何代码级交互**（详见第 3、7 节，双向 grep 均为空）。

---

## 1. AndroidManifest.xml 组件清单

文件：`resources/AndroidManifest.xml`

### 1.1 自定义权限（均为 signature 级）
| 权限 | 保护级别 |
|---|---|
| `stepos.alphame.dump` | signature（dump 服务端信息用） |
| `stepos.alphame.USER_BEHAVIOR` | signature（访问行为数据 provider） |
| `com.stepos.alphame.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | signature |

*English version:*

| Permission | Protection level |
|---|---|
| `stepos.alphame.dump` | signature (used for dumping server-side info) |
| `stepos.alphame.USER_BEHAVIOR` | signature (access to the behavior-data provider) |
| `com.stepos.alphame.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | signature |

### 1.2 申请的关键权限
- 平台 IPC：`com.stepos.appplatform.permission.ACCESS_IPC_SERVICE`、`com.stepos.permission.RECEIVE_KEEP_ALIVE`、`com.stepos.permission.PUSH`、`com.stepos.secureservice.permission.OPEN_DATA_PROVIDER`
- 常规：`INTERNET`、`ACCESS_NETWORK_STATE`、`CHANGE_WIFI_STATE`、`BLUETOOTH_CONNECT/ADMIN`、`QUERY_ALL_PACKAGES`、`RECEIVE_BOOT_COMPLETED`、`FOREGROUND_SERVICE`、`POST_NOTIFICATIONS`、`USE_EXACT_ALARM`、`ACCESS_LOCATION_EXTRA_COMMANDS` 等
- `<queries>`：appplatform、dataservice、pushservice、Google Maps
- ⚠️ `android:usesCleartextTraffic="true"`（允许明文流量；统计 SDK 确实走 `http://uxip.zyql.com`）

### 1.3 组件清单

**Activity（共 13 个，AlphaMe 自有 8 个）**
| 组件 | exported | intent-filter / 说明 |
|---|---|---|
| `persona.information_used.ui.PersonalInfoAuthorizationActivity` | false | 个人信息使用授权管理页 |
| `persona.ui.PersonalMainActivity` | **true** | `com.stepos.alphame.action.personal_preference` 个性化主页 |
| `persona.common.time.PersonalCommonTimePickerActivity` | **true** | `...action.TIME_PICKER` 时间选择器（弹窗样式） |
| `persona.common.list.PersonalCommonListActivity` | false | 通用列表 |
| `persona.wifi.WifiListActivity` | **true** | `...action.SELECT_WIFI` WiFi 选择器 |
| `persona.carbluetooth.CarBluetoothListActivity` | **true** | `...action.SELECT_CAR_BLUETOOTH` 车载蓝牙选择器 |
| `persona.address.ui.AddressMainActivity` | **true** | `...action.ADDRESS_PICKER` 地址选择器 |
| `persona.privacy.PrivacySettingActivity` | false | 隐私设置页 |
| `ocr.OcrTestActivity` | false | OCR 测试页 |
| `com.stepos.policy.sdk.activity.PolicyWebViewActivity` / `PolicyPermissionDesActivity` | 未声明(默认false) | 隐私政策 WebView / 权限说明（`inheritShowWhenLocked=true`） |
| `stepos.support.v7.app.WebViewActivity`、`StepOSPalettePopupActivity` | 未声明 | 平台 UI 库 |
| `GoogleApiActivity` | false | GMS |

*English version:*

| Component | exported | intent-filter / Description |
|---|---|---|
| `persona.information_used.ui.PersonalInfoAuthorizationActivity` | false | Personal-info usage authorization management page |
| `persona.ui.PersonalMainActivity` | **true** | `com.stepos.alphame.action.personal_preference` personalization home page |
| `persona.common.time.PersonalCommonTimePickerActivity` | **true** | `...action.TIME_PICKER` time picker (dialog style) |
| `persona.common.list.PersonalCommonListActivity` | false | Generic list |
| `persona.wifi.WifiListActivity` | **true** | `...action.SELECT_WIFI` Wi-Fi picker |
| `persona.carbluetooth.CarBluetoothListActivity` | **true** | `...action.SELECT_CAR_BLUETOOTH` car Bluetooth picker |
| `persona.address.ui.AddressMainActivity` | **true** | `...action.ADDRESS_PICKER` address picker |
| `persona.privacy.PrivacySettingActivity` | false | Privacy settings page |
| `ocr.OcrTestActivity` | false | OCR test page |
| `com.stepos.policy.sdk.activity.PolicyWebViewActivity` / `PolicyPermissionDesActivity` | not declared (defaults to false) | Privacy policy WebView / permission description (`inheritShowWhenLocked=true`) |
| `stepos.support.v7.app.WebViewActivity` / `StepOSPalettePopupActivity` | not declared | Platform UI library |
| `GoogleApiActivity` | false | GMS |

**Service**
- `com.baidu.location.f`（百度定位服务，`:remote` 进程）
- `com.stepos.alphame.AliveService`（空壳保活服务，`sources/com/stepos/alphame/AliveService.java`，onStartCommand 返回 START_STICKY）
- androidx WorkManager 三个系统服务

**Provider**
| authorities | exported | 保护 |
|---|---|---|
| `com.stepos.alphame.sceneupdate.provider`（AlphaMeContentProvider） | false | — |
| `com.stepos.alphame.behavior.provider`（UserBehaviorContentProvider） | **true** | 需 `stepos.alphame.USER_BEHAVIOR`（signature） |
| `com.stepos.alphame.dailyusage.provider` / `.restrictprovider` | **true** | 同上 |
| `com.stepos.alphame.suggest.provider`（AppSuggest） | **true** | 同上 |
| `com.stepos.alphame.PolicySdk.FileProvider` | false | — |
| androidx-startup / steposcommon / renderfilter | false | — |

*English version:*

| authorities | exported | Protection |
|---|---|---|
| `com.stepos.alphame.sceneupdate.provider` (AlphaMeContentProvider) | false | — |
| `com.stepos.alphame.behavior.provider` (UserBehaviorContentProvider) | **true** | Requires `stepos.alphame.USER_BEHAVIOR` (signature) |
| `com.stepos.alphame.dailyusage.provider` / `.restrictprovider` | **true** | Same as above |
| `com.stepos.alphame.suggest.provider` (AppSuggest) | **true** | Same as above |
| `com.stepos.alphame.PolicySdk.FileProvider` | false | — |
| androidx-startup / steposcommon / renderfilter | false | — |

**Receiver**
- `apprequest.MyPushMsgReceiver`（**true**，受 `com.stepos.cloud.push.permission.MESSAGE` 保护；处理 `com.stepos.push.intent.MESSAGE` 等——实现里仅打日志，无指令执行逻辑）
- `dailyusage.BootReceiver`（**true**，受 `com.stepos.permission.RECEIVE_KEEP_ALIVE` 保护，`com.stepos.alphame.KEEP_ALIVE`）
- `dailyusage.MidnightAlarmReceiver`、`userbehavior.UserBehaviorTimeReceiver`（false）
- androidx work/profileinstaller 附属 receiver

### 1.4 无障碍服务声明
**没有。** 全 manifest 无任何 `<service android.permission="android.permission.BIND_ACCESSIBILITY_SERVICE">`；源码中 `accessibility` 关键字仅命中自定义控件的 `AccessibilityNodeInfo` 无障碍标签支持（`com/stepos/common/widget/*`），与无障碍服务无关。

---

## 2. "智能体"架构：引擎/数据源模型（非 LLM 智能体）

核心文件：
- `sources/com/stepos/alphame/ApplicationImpl.java`（应用入口 + 装配）
- `sources/com/stepos/alphame/AlphaMeServer.java`（Binder 服务端）
- `sources/com/stepos/alphame/engine/EngineBase.java` / `EngineFunc.java` / `EngineFuncMap.java` / `ExecuteItem.java` / `AppClient.java` / `ReceiverList.java`
- `sources/com/stepos/alphame/manager/EngineManager.java` / `ActionManager.java`
- `sources/com/stepos/common/alphame/`（客户端 SDK：`AlphaMeNative`、`AlphaMeProxy`、`AlphaMeClientProxy`、`Args`）

### 2.1 初始化流程（ApplicationImpl.initialize()，行 445-477）
```
registerAction()      // 注册 ~30 个广播 Action（APP_EVENT/ACTIVITY_DETECT/SCENE_CHANGED/WIFI/LOCATION/BLUETOOTH/CHARGING/...）
publishServer()       // 把 AlphaMeServer 以 "alphame_server" 名字发布到 AppPlatform
registerDataSource()  // APP_CLICK / SCREEN_EVENT / AppSuggest / ACTIVITY_CLICK / AWARENESS / PERSONA / UserBehavior + Room DB
registerDataEngine()  // 注册 17 个引擎：SleepMode/AppInfo/SceneDetector/SystemState/Wifi/Location/BlueTooth/
                      // Power/Headset/Notification/UserBehavior/Ocr/Cutout/Predict/Personal/DailyUsage（Lite 模式裁剪）
startAliveService() + registerUserSwitch() + initSensitiveJob()（MovingStateEngine + UsageStats 统计 SDK）
```

*English version:*

```
registerAction()      // Registers ~30 broadcast Actions (APP_EVENT/ACTIVITY_DETECT/SCENE_CHANGED/WIFI/LOCATION/BLUETOOTH/CHARGING/...)
publishServer()       // Publishes AlphaMeServer to AppPlatform under the name "alphame_server"
registerDataSource()  // APP_CLICK / SCREEN_EVENT / AppSuggest / ACTIVITY_CLICK / AWARENESS / PERSONA / UserBehavior + Room DB
registerDataEngine()  // Registers 17 engines: SleepMode/AppInfo/SceneDetector/SystemState/Wifi/Location/BlueTooth/
                      // Power/Headset/Notification/UserBehavior/Ocr/Cutout/Predict/Personal/DailyUsage (trimmed down in Lite mode)
startAliveService() + registerUserSwitch() + initSensitiveJob() (MovingStateEngine + UsageStats statistics SDK)
```

### 2.2 指令接收方式：没有用户指令入口
- **无语音、无文本输入 UI，无 ASR/NLU/LLM 代码**（grep `llm|nlu|asr|speech` 无命中）。
- 唯一的"外部驱动"是 **IPC 调用**：其他应用通过 AppPlatform 拿到 `alphame_server` Binder（`PerfBinderHelper.checkAlphaMeService("alphame_server")`），然后：
  - `addClient(IBinder)` 注册客户端；
  - `exec(IBinder, funcName, Args, sync, receiverId)` → 查 `EngineFuncMap` → 反射调用引擎方法（`EngineFunc.invoke`，`method.invoke(owner, args)`）→ 结果经客户端回调 Binder `AppClient.client.onResult(Args)` 异步返回；
  - `registerActionReceiver(IBinder, actions[], receiverId)` 订阅事件广播；
  - `collect(tag, Args)` 向数据源灌数据。
- 协议是**自定义 Parcel 序列化（Args）+ 反射 RPC**，不是 MCP、不是标准 AIDL 接口描述（虽有 AIDL 风格的 `IAlphaMe` 抽象，`com/stepos/common/alphame/AlphaMeNative.java` 手写 onTransact）。

### 2.3 "规划/工具调用"
不存在 LLM 式 planning。最接近"能力目录"的是引擎函数注册表 `EngineFuncMap`（可 `dump` 输出函数签名清单）。代表性远程函数（`sources/com/stepos/alphame/utils/LocalConsts.java`）：
- 场景：`getCurrentScene`、`detectActivityScene(All/ByActivity)`、`getSceneFrequency`、`enterDebugScene`
- 应用画像：`getPrediction/Prediction3/PredictionWithUserId`（应用使用预测排序）、`notiPredict`、`getAppInfo`、`isGame/isMiniGame/getGameType`
- OCR：`ocrInit/Release`、`recognizeOCRByBinder/Byte/Path/Uri(+WithVersion)`、`detectOCRPointBy*`、`detectOCRBoundsByPath`
- 个人信息：`chooseHome/chooseCompany`、`getChosenHome/Company`、`getAllWifiInfo`、`getHomeWifiList/getCompanyWifiList`、`makeLocation`、`getLocationInfoByID`、`getVehicleBluetoothInfo`、`getVehicleBluetoothes`、`getFrequentLocations`、`getCityHistory`
- 其它：`wordMatch`、`cutImage*`（抠图模型）、`getAppBlackListForUserGeneratedContent`（`SceneDetectorEngine.java:1553`，UGC 应用黑名单）、`setCustomGameModeForPackage` 等

### 2.4 事件采集机制
- `PerfBinderHelper`（`sources/com/stepos/alphame/perfbinder/PerfBinderHelper.java`，775 行）通过 `content://com.stepos.appplatform` 的 provider `call()`（方法名 `publishAlphaMeService`/`checkAlphaMeService`/…，需 `ACCESS_IPC_SERVICE` 签名权限）获取**特权系统数据**：`enableAppEventsMonitor`、`enableNotificationMonitor`、`getTopActivityBundle`、`getWifiConnectionInfo`、`getWifiMac`、`getCallState`、`getActiveGpsUids`、`getWakeLockUidSets`、`getInstalledPackagesAsUser`、`writeSceneConfigFile`（写 `/data/misc/scene_config/stepos-scene-recognition-config.json`）等。
- `scene/NewAppEventCollector.java:95` 调 `PerfBinderHelper.enableAppEventsMonitor()` 后，监听 appplatform 转发的 `ACTION_APP_EVENTS_FORWARD` 等受保护广播获取应用前后台事件。

---

## 3. 与 AIEngine（com.stepos.aiengine）/ AgentBus（com.stepos.agentbus）的交互

**结论：完全没有交互。**
- AlphaMe 源码中 grep `aiengine|agentbus|agentsafetycenter`（不区分大小写）**零命中**；唯一的外部应用名引用是 `EngineContract`（`sources/com/stepos/alphame/EngineContract.java`）中的白名单：`com.stepos.voiceassistant`、`com.stepos.notepaper`、`com.android.settings`、`com.stepos.systemuitools`、`com.stepos.aicymanager`、`com.stepos.weather`。
- 反向验证：对 `decompiled/AgentBus/sources`、`decompiled/AIEngine/sources`、`decompiled/AgentSafetyCenter/sources` grep `alphame`（含 manifest/resources）也**零命中**。
- 即：AlphaMe 属于平台里**与 Agent 栈并行的旧一代/底层情境服务**。AgentBus/AIEngine 若要用用户画像，目前从代码上看不到通道（二者查询列表 `<queries>` 也不含 alphame）。
- AlphaMe 对外的实际接口只有：`alphame_server` Binder（经 AppPlatform 中转）+ 4 个签名权限保护的 ContentProvider + 5 个导出选择器 Activity。

---

## 4. UI 自动化执行方式

**没有 UI 自动化能力。**
- 无无障碍服务声明（见 1.4）；
- 无坐标点击/手势注入代码（grep 无 `dispatchGesture|injectInputEvent|Instrumentation|MotionEvent.obtain` 相关调用）；
- 无 `MediaProjection`/截屏代码——OCR 引擎的图片**全部由调用方传入**（byte[]/文件路径/URI/共享内存 Binder，见 `OcrEngine` 各 EngineFunc 的 `argsName`："bitmapByte"/"filePath"/"bitmapUri"/"iBinder"），AlphaMe 自己不截屏；
- 也就是说屏幕内容理解是"被动服务"：其他应用（如语音助手）截屏后调 `recognizeOCRByBinder` 请求识别，结果通过 `OCR_DETECT` 广播或回调返回。

---

## 5. 安全确认流 / 授权 / 白名单（本应用的安全策略核心）

### 5.1 Binder 层权限检查（AlphaMeServer.checkPermission，`AlphaMeServer.java:105-135`）
```java
if (userId != myUserId && uid != 2000) return false;           // 同用户（或 adb shell uid 2000）
if (z4 /*func.isPublic*/ || UserHandle.isCore(uid)) ...        // isPublic 函数 / 系统 uid 直接放行
else z = AppUtils.hasSameSignature(pm, uid)                    // 或与 alphame 同签名
        || checkPermission("stepos.alphame.USER_BEHAVIOR", pid, uid) == 0;  // 或持签名权限
```

*English version:*

```java
if (userId != myUserId && uid != 2000) return false;           // Same user (or adb shell uid 2000)
if (z4 /*func.isPublic*/ || UserHandle.isCore(uid)) ...        // isPublic functions / system uid are allowed through directly
else z = AppUtils.hasSameSignature(pm, uid)                    // Or same signature as alphame
        || checkPermission("stepos.alphame.USER_BEHAVIOR", pid, uid) == 0;  // Or holds the signature permission
```
- `isPublic=true` 的函数（如 `recognizeOCRByUri`，`OcrEngine.java:398`）**同用户任意应用可调**；
- 其余函数需同签名或 `stepos.alphame.USER_BEHAVIOR`；
- 若 `Utils.isCollectAuthority()` 开启，会经 `AwarenessDataSource.newPermissionRecord(...)` 记录每次访问者（uid/pid/包名/描述/级别 0-2），即可审计"谁在调个人数据接口"。

### 5.2 个人信息函数的"硬拒绝"层（值得注意）
`engine/EngineBase.run()`（`EngineBase.java:132-146`）在真正反射调用前过 `AuthorizationUtils.isAuthorized()`（`sources/com/stepos/alphame/utils/AuthorizationUtils.java`）：
```java
if (engineFunc == null || !EngineContract.getAuthorizationFunList().contains(engineFunc.name)) return true;
AlphaMeLogger.eLog("personal-info denied: func=" + ... );
return false;   // 命中名单 → 拒绝执行，返回 null
```

*English version:*

```java
if (engineFunc == null || !EngineContract.getAuthorizationFunList().contains(engineFunc.name)) return true;
AlphaMeLogger.eLog("personal-info denied: func=" + ... );
return false;   // Hits the deny list → execution refused, returns null
```
`EngineContract.authorizationFunList`（`EngineContract.java:44`）列出 25 个敏感函数：`getHomeAddress/setHomeAddress/getCompanyAddress/getHomeWifi/getCompanyWifi/getCarBluetooth/getSleepTime/getWakeupTime/getCommutingMode/chooseHome/chooseCompany/getAllWifiInfo/makeLocation/getLocationInfoByID/getVehicleBluetoothes...`。**即：这批函数在通用 exec 通道上对所有远端调用者一律拒绝**（疑似合规锁死；真要用个人信息只能走 5.3 的 UI 选择器路径或广播）。

### 5.3 用户确认 UI（个人信息"选择器"流）
导出 Activity 即确认 UI，供白名单应用（典型为语音助手）拉起，由**用户当场点选**后通过 `setResult`/定向广播回传：
- `AddressMainActivity`（`action.ADDRESS_PICKER`）→ 选家/公司地址
- `WifiListActivity`（`action.SELECT_WIFI`）、`CarBluetoothListActivity`（`action.SELECT_CAR_BLUETOOTH`）
- `PersonalCommonTimePickerActivity`（`action.TIME_PICKER`）→ 睡眠/起床/下班时间
- `PersonalMainActivity`（`action.personal_preference`）→ 个性化总开关管理
对应引擎函数 `chooseHome/chooseCompany/chooseVehicleBluetooth`（弹出 UI 让用户确认，而非静默返回数据）。

### 5.4 每应用授权白名单（PersonalPreferenceConfigs）
- 文件：`sources/com/stepos/alphame/persona/data/config/PersonalPreferenceConfigs.java`（+ `PersonalEngine.java:461,642`）
- 模型：`authorizationWhiteList`（Set）由 6 个系统应用的授权开关派生，**默认值 `Boolean.TRUE`（默认授权，opt-out 模式）**：
```java
if (((Boolean) personalPreferenceConfigs2.getData(next, Boolean.TRUE)).booleanValue()) authorizationWhiteList.add(next);
```
- 管理界面：`persona/information_used/ui/PersonalInfoAuthorizationFragment.java`（"voice_app"/"note_app" 等 SwitchPreference）→ `setAuthorizationStatus(pkg, checked)` → 持久化到 DataStore `personalPreference` + 发定向广播 `com.stepos.alphame.action_authorization_changed`。
- ⚠️ 弱点：`PersonalEngine` 各 getter 的 `packageName` 参数**由调用方在 Args 里传入**（`argsName={"packageName"}`），`isInWhitelist(packageName)` 校验的是这个字符串而非 Binder 调用方真实包名——若能到达这些函数即可伪装成白名单包；目前靠 5.2 的硬拒绝层挡住远端路径，属于"纵深防御只有一层"的脆弱设计。
- 用户撤回：`clearDataWhenUserRevocation()` 清空全部偏好 + 全部授权置 false + 自动学习关闭。

### 5.5 隐私合规（CTA）确认流
- `persona/privacy/PolicyManager.java` + `com/stepos/policy/sdk/`（PolicySdk）
- `initPolicy`/`checkNewestPolicy`/`showReGrantDialog`（政策更新后重新弹窗确认），Key：`is_cta_agree`、`is_cta_re_grant`
- `PolicyPermissionDialogBuilder`（权限用途确认对话框）、`PolicyWebViewActivity`（展示 `AicyPrivacyPolicy.html` 等本地资产）、`PolicyPermissionDesActivity`
- 内置硬编码 appId/appSecret：`"44847302403461083790"` / `"6d193fe8202147a68cddff953c9e6296"`（`persona/privacy/PolicyManager.java:49-51`）
- **没有"高风险操作二次确认/免确认模式"这类智能体安全逻辑**——那类功能不在本应用内（平台另有 AgentSafetyCenter）。

---

## 6. 敏感信息存储与加密

| 数据 | 位置 | 加密 |
|---|---|---|
| 用户行为/每日使用统计（app 使用时长、通知数、app 明细） | `AlphaMe.db`（SQLCipher，`database/Database.java`） | ✅ **SQLCipher 全库加密**；密钥由 AndroidKeyStore HMAC-SHA256 派生（`database/AlphaMeDbKey.java`，alias `com.stepos.alphame.db_hmac_v1`，context `com.stepos.alphame/AlphaMe.db/v1`），含明文→密文迁移（`.plain.bak`/`.enc.tmp`） |
| 常去地点 FrequentLocation、历史地址 history_address | Room 库 `engine.db`（`database/EngineRoomDatabase.java`） | ❌ 未加密（普通 Room/SQLite） |
| 个人画像偏好（家/公司地址、WiFi、车载蓝牙 MAC、作息时间、授权开关） | Jetpack DataStore `personalPreference`（`common/data/DataStoreManager`） | ❌ 未加密（明文 preference 文件） |
| 情境事件（AwarenessDataItem：pkg/scene/state/data1/data2/date） | AwarenessStorable → AlphaMe.db | ✅（随库加密） |
| 聊天记录 | **不存在**（无聊天功能） | — |
| 屏幕内容 | 不落盘：OCR 输入由调用方传入，识别结果经回调/`OCR_DETECT` 广播返回，仅内存中 PendingOcr 队列 | — |
| 云端规则文件 | `assets/commomwhitelists.dat`、`activityinfo.dat` 等 + 云端更新 | 下载自 `https://resm-onemind.zyql.com/pack/...`（`RuleUpdater.java`），未见对下发内容做签名校验（仅版本号比对） |

*English version:*

| Data | Location | Encryption |
|---|---|---|
| User behavior / daily usage statistics (app usage duration, notification counts, per-app details) | `AlphaMe.db` (SQLCipher, `database/Database.java`) | ✅ **Full-database SQLCipher encryption**; key derived via AndroidKeyStore HMAC-SHA256 (`database/AlphaMeDbKey.java`, alias `com.stepos.alphame.db_hmac_v1`, context `com.stepos.alphame/AlphaMe.db/v1`), including plaintext→ciphertext migration (`.plain.bak`/`.enc.tmp`) |
| Frequent locations FrequentLocation, historical addresses history_address | Room database `engine.db` (`database/EngineRoomDatabase.java`) | ❌ Not encrypted (plain Room/SQLite) |
| Personal profile preferences (home/company addresses, Wi-Fi, car Bluetooth MAC, sleep schedule, authorization switches) | Jetpack DataStore `personalPreference` (`common/data/DataStoreManager`) | ❌ Not encrypted (plaintext preference files) |
| Context events (AwarenessDataItem: pkg/scene/state/data1/data2/date) | AwarenessStorable → AlphaMe.db | ✅ (encrypted along with the database) |
| Chat history | **Does not exist** (no chat functionality) | — |
| Screen content | Not persisted to disk: OCR input is passed in by the caller, recognition results are returned via callback / `OCR_DETECT` broadcast, only an in-memory PendingOcr queue | — |
| Cloud rule files | `assets/commomwhitelists.dat`, `activityinfo.dat`, etc. + cloud updates | Downloaded from `https://resm-onemind.zyql.com/pack/...` (`RuleUpdater.java`); no signature verification of downloaded content observed (version-number comparison only) |

**云上传**（`request/RequestManager.java:23-27`、`predict/PredictManager.java:533-585`）：
- 端点：`https://hades.zyql.com/up/DailyPortrait`（画像上传）、`https://onemind.zyql.com/service/...`、`https://hades.zyql.com/daily-portrait/service-info`
- `postAwarenessIfNeed()` 把 awareness 事件（含 **OAID**）打包 JSON 上传；由服务端下发开关控制（`UploadInfoBean.upload==1` 才传，默认 0；record 默认保留 30 天，上传后 `deleteOldAwarenessData` 删除）
- 统计 SDK（UsageStats v3）上报 `http://uxip.zyql.com/api/v3/event/` 等 **明文 HTTP**（`ApplicationImpl.initUsageStats`，行 210-214），appId 20013709，另含 push APP_ID `111154` / APP_KEY `aaabbbcccdddeeefffggghhhiiijjjkk` 硬编码
- TLS：`request/KeyPinStore.java` 固定了两张 **GlobalSign 签发的 *.meizu.com 证书（2018/2024 年已过期）**，属遗留代码

---

## 7. 与 AgentSafetyCenter（com.stepos.agentsafetycenter）的调用

**无任何调用。**
- AlphaMe 源码 grep `agentsafetycenter|safetycenter` 零命中；
- `decompiled/AgentSafetyCenter/sources` 与 `resources` 中 grep `alphame` 亦零命中；
- AlphaMe 中名字最接近"安全"的组件是 `com.stepos.secureservice`（另一系统应用）：`policy/sdk/manager/WithdrawalManager.java:120` bind `com.stepos.secureservice/.certification.SafeCertService`（action `com.stepos.secureservice.SafeCertification`），用 `ISafeCertService.encrypt()`（RSA/密钥版本 keyId/keyVersion/keyLevel）加密**账号注销/数据撤回**的绑定标识后再上传——这是隐私合规的"数据退出"通道，与智能体安全确认无关。

---

## 8. 其他安全观察（附）

1. `AlphaMeServer` 私有 transact 码 101-104（getMyUserId/getUserBinder/linkUserBinder/notifyUserBackground）有 `enforcePrivateTransactCaller`（同 uid 取模校验）防护（`AlphaMeServer.java:137-151`）。
2. `exec()` 有 TOCTOU 式小瑕疵：权限检查用 `Binder.getCallingUid()` 在线程池执行前完成（OK），但 `waitInitializedDone` 会阻塞；结果回传仅凭 `AppClient.active`。
3. 导出 provider 均挂签名权限，风险可控；但 `UserBehaviorContentProvider` 对签名授权应用返回含 `appDetail`（每应用使用明细）的行为统计。
4. `AppRequest.writeSystemConfigFile` 可经 appplatform 写系统目录 `/data/misc/scene_config/`（签名权限保护）。
5. `checkInvalidBoot`：一分钟内启动 >10 次判定 boot 失败（防崩溃循环）。
6. push 接收器 `MyPushMsgReceiver.onMessage` 仅打日志，**无远程命令执行**。
7. 遗留敏感常量：`PolicyManager` appId/appSecret、push APP_KEY、过期的 Meizu 证书锚定，均可作为指纹/供应链痕迹。

---

## 9. 关键文件索引

| 主题 | 路径（相对 `sources/`） |
|---|---|
| 清单 | `../resources/AndroidManifest.xml` |
| 应用装配 | `com/stepos/alphame/ApplicationImpl.java` |
| Binder 服务端/权限 | `com/stepos/alphame/AlphaMeServer.java` |
| 引擎调度 | `com/stepos/alphame/engine/EngineBase.java`、`EngineFunc.java` |
| 客户端 SDK | `com/stepos/common/alphame/AlphaMeNative.java`、`AlphaMeProxy.java`、`Args.java` |
| 特权系统查询 | `com/stepos/alphame/perfbinder/PerfBinderHelper.java` |
| 个人信息硬拒绝 | `com/stepos/alphame/utils/AuthorizationUtils.java`、`com/stepos/alphame/EngineContract.java` |
| 个人信息白名单 | `com/stepos/alphame/persona/data/config/PersonalPreferenceConfigs.java`、`persona/PersonalEngine.java` |
| 授权管理 UI | `com/stepos/alphame/persona/information_used/ui/PersonalInfoAuthorizationFragment.java` |
| 隐私合规 SDK | `com/stepos/policy/sdk/`（`PolicySdk.java`、`manager/WithdrawalManager.java`、`dialog/PolicyPermissionDialogBuilder.java`） |
| OCR 引擎 | `com/stepos/alphame/ocr/OcrEngine.java` |
| 场景识别 | `com/stepos/alphame/scene/SceneDetectorEngine.java`、`NewAppEventCollector.java` |
| 加密数据库 | `com/stepos/alphame/database/Database.java`、`AlphaMeDbKey.java`、`EngineRoomDatabase.java` |
| 云端上传 | `com/stepos/alphame/request/RequestManager.java`、`predict/PredictManager.java` |
| 规则更新 | `com/stepos/alphame/RuleUpdater.java` |
| TLS 锚定 | `com/stepos/alphame/request/KeyPinStore.java` |

*English version:*

| Topic | Path (relative to `sources/`) |
|---|---|
| Manifest | `../resources/AndroidManifest.xml` |
| App assembly | `com/stepos/alphame/ApplicationImpl.java` |
| Binder server / permissions | `com/stepos/alphame/AlphaMeServer.java` |
| Engine scheduling | `com/stepos/alphame/engine/EngineBase.java`, `EngineFunc.java` |
| Client SDK | `com/stepos/common/alphame/AlphaMeNative.java`, `AlphaMeProxy.java`, `Args.java` |
| Privileged system queries | `com/stepos/alphame/perfbinder/PerfBinderHelper.java` |
| Personal-info hard-deny | `com/stepos/alphame/utils/AuthorizationUtils.java`, `com/stepos/alphame/EngineContract.java` |
| Personal-info whitelist | `com/stepos/alphame/persona/data/config/PersonalPreferenceConfigs.java`, `persona/PersonalEngine.java` |
| Authorization management UI | `com/stepos/alphame/persona/information_used/ui/PersonalInfoAuthorizationFragment.java` |
| Privacy compliance SDK | `com/stepos/policy/sdk/` (`PolicySdk.java`, `manager/WithdrawalManager.java`, `dialog/PolicyPermissionDialogBuilder.java`) |
| OCR engine | `com/stepos/alphame/ocr/OcrEngine.java` |
| Scene recognition | `com/stepos/alphame/scene/SceneDetectorEngine.java`, `NewAppEventCollector.java` |
| Encrypted database | `com/stepos/alphame/database/Database.java`, `AlphaMeDbKey.java`, `EngineRoomDatabase.java` |
| Cloud upload | `com/stepos/alphame/request/RequestManager.java`, `predict/PredictManager.java` |
| Rule updates | `com/stepos/alphame/RuleUpdater.java` |
| TLS pinning | `com/stepos/alphame/request/KeyPinStore.java` |
