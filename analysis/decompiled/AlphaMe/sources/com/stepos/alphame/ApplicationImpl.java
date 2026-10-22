package com.stepos.alphame;

import C.d;
import D2.b;
import L2.c;
import T2.a;
import a2.AbstractC0155a;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.fragment.app.C0284f;
import c2.AbstractC0392b;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.google.android.material.internal.m;
import com.stepos.alphame.activityclick.ActivityClickDataSource;
import com.stepos.alphame.app.AppClickDataSource;
import com.stepos.alphame.app.AppEventDataSource;
import com.stepos.alphame.app.AppInfoEngine;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.awareness.TimetableTracker;
import com.stepos.alphame.bluetooth.BlueToothEngine;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.cutout.CutoutEngine;
import com.stepos.alphame.dailyusage.DailyUsageEngineService;
import com.stepos.alphame.data.DataSourceManager;
import com.stepos.alphame.database.EngineRoomDatabase;
import com.stepos.alphame.headset.HeadsetEngine;
import com.stepos.alphame.location.LocationEngine;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.manager.EngineManager;
import com.stepos.alphame.movingstate.MovingStateEngine;
import com.stepos.alphame.notification.NotificationEngine;
import com.stepos.alphame.ocr.OcrEngine;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.persona.PersonaDataSource;
import com.stepos.alphame.persona.PersonalEngine;
import com.stepos.alphame.power.PowerEngine;
import com.stepos.alphame.predict.PredictEngine;
import com.stepos.alphame.reflect.UserHandle;
import com.stepos.alphame.reflect.UserInfoProxy;
import com.stepos.alphame.scene.NewAppEventCollector;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.screen.ScreenEventDataSource;
import com.stepos.alphame.sleep.SleepModeEngine;
import com.stepos.alphame.suggest.AppSuggestDataSource;
import com.stepos.alphame.suggest.AppSuggestReport;
import com.stepos.alphame.systemstate.SystemStateEngine;
import com.stepos.alphame.userbehavior.UserBehaviorDataSource;
import com.stepos.alphame.userbehavior.UserBehaviorEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.SystemProperty;
import com.stepos.alphame.utils.UsageStatsUtils;
import com.stepos.alphame.utils.Utils;
import com.stepos.alphame.utils.net.FirstNetworkTrigger;
import com.stepos.alphame.utils.pool.PoolManager;
import com.stepos.alphame.wifi.WifiEngine;
import com.stepos.statsapp.v3.SdkVer;
import f0.HandlerC0555a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import l1.g;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class ApplicationImpl extends BaseApplication {
    public static final String ACTION_ALPHAME_BOOT_BROADCAST = "ACTION_ALPHAME_BOOT_BROADCAST";
    private static final Handler ALPHAME_THREAD;
    private static final String APP_ID = "111154";
    private static final String APP_KEY = "aaabbbcccdddeeefffggghhhiiijjjkk";
    public static final String KEY_BOOT_MINUTE = "boot_minute";
    public static final String KEY_MINUTE_BOOT_TIMES = "minute_boot_times";
    public static final int MAX_MINUTE_BOOT_TIMES = 10;
    public static final String PROPERTY_STEPOS_LITE = "persist.sys.steposlite";
    private static final String TAG = "AlphaMe";
    public static final int VALUE_STEPOS_LITE = 1;
    public static final int VALUE_STEPOS_NORMAL = 0;

    @SuppressLint({"StaticFieldLeak"})
    private static ApplicationImpl mAppCtx;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);
    private BroadcastReceiver mUserReceiver;
    public static final int MY_PID = Process.myPid();
    private static long sAppBootTime = 0;
    private static boolean sBootFailed = false;

    static {
        HandlerThread handlerThread = new HandlerThread("alphame-thread");
        handlerThread.start();
        ALPHAME_THREAD = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInvalidBoot() {
        int iSaveBootInfo = saveBootInfo();
        AlphaMeLogger.iLog("initialize bootTimes = " + iSaveBootInfo);
        if (iSaveBootInfo <= 10) {
            return false;
        }
        AlphaMeLogger.eLog("initialize boot time too much!! bootTimes: " + iSaveBootInfo);
        sBootFailed = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInvalidUser() {
        int iMyUid = Process.myUid() / ComplexPt.TEN_THOUSAND;
        boolean zIsInMdm = Utils.isInMdm();
        AlphaMeLogger.iLog("AlphaMe_Boot. user=" + iMyUid + ", safeMode=" + zIsInMdm);
        if (iMyUid == 0 && zIsInMdm) {
            AlphaMeLogger.eLog("AlphaMe_Boot. Invalide");
            return true;
        }
        AlphaMeLogger.iLog("AlphaMe_Boot. Valid");
        return false;
    }

    public static Looper getAlphaMeLooper() {
        if (sAppBootTime == 0) {
            AlphaMeLogger.eLog("getAlphaMeLooper before App.onCreate()");
        }
        return ALPHAME_THREAD.getLooper();
    }

    public static long getAppBootTime() {
        return sAppBootTime;
    }

    public static ApplicationImpl getApplication() {
        return mAppCtx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNetworkMonitor() {
        new FirstNetworkTrigger(this).startMonitor(new FirstNetworkTrigger.OnNetworkReadyListener() { // from class: com.stepos.alphame.ApplicationImpl.3
            @Override // com.stepos.alphame.utils.net.FirstNetworkTrigger.OnNetworkReadyListener
            public void onFirstNetworkReady() {
                ApplicationImpl.this.initPushReceiver();
            }
        });
    }

    private void initUsageStats() {
        File externalFilesDir;
        if (!d.f250d) {
            boolean z4 = true;
            d.f250d = true;
            d dVar = b.f395a;
            if (TextUtils.isEmpty("20013709")) {
                throw new IllegalArgumentException("appId is null!");
            }
            dVar.f252b = this;
            dVar.f253c = "20013709";
            int i4 = 0;
            dVar.f251a = 0;
            if (T2.d.f1874c && (externalFilesDir = getExternalFilesDir(null)) != null) {
                String absolutePath = externalFilesDir.getAbsolutePath();
                T2.b bVar = new T2.b();
                bVar.f1862a = absolutePath;
                File file = new File(absolutePath);
                if (!file.exists() || !file.isDirectory()) {
                    file.mkdirs();
                }
                bVar.f1863b = new File(absolutePath, "usage_logs_v2.txt");
                a aVar = new a();
                aVar.f1861c = 0;
                aVar.f1859a = new char[64];
                aVar.f1861c = "copyright".charAt(0) % '\r';
                while (true) {
                    char[] cArr = a.f1855d;
                    if (i4 >= 64) {
                        break;
                    }
                    aVar.f1859a[i4] = cArr[(aVar.f1861c + i4) % 64];
                    i4++;
                }
                aVar.f1860b = aVar.f1859a;
                bVar.f1864c = aVar;
                bVar.f1865d = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
                bVar.f1866e = Process.myPid();
                T2.d.f1872a = bVar;
            }
            c cVar = L2.b.f1231a;
            Application application = (Application) dVar.f252b;
            int i5 = dVar.f251a;
            String str = (String) dVar.f253c;
            T2.d.d("SDKInstanceImpl", "SDKInstanceImpl, pkgType: " + i5 + ", appId: " + str + ", channel: APP, initConfig: " + new D2.a() + ", sdkVersion: " + SdkVer.verName);
            cVar.f1232a = application;
            cVar.f1233b = i5;
            cVar.f1234c = str;
            cVar.f1235d = "APP";
            com.stepos.statsrpk.c.f12363f = "6KAIUyh8oTuWsB0JiE9";
            com.stepos.statsrpk.c.f12359b = "http://uxip.zyql.com/api/v3/event/";
            com.stepos.statsrpk.c.f12360c = "http://uxip-config.zyql.com/api/v3/umid/privacy";
            com.stepos.statsrpk.c.f12361d = "http://uxip-res.zyql.com/resource/v3/config/";
            com.stepos.statsrpk.c.f12362e = "http://uxip-res.zyql.com/resource/v3/config/rpk/";
            cVar.f1237f = new g(str);
            C0284f c0284f = new C0284f();
            HandlerThread handlerThread = new HandlerThread("com.stepos.statsapp.v3.SessionControllerWorker", 5);
            handlerThread.start();
            c0284f.f3746c = new HandlerC0555a(c0284f, handlerThread.getLooper(), 3);
            N2.a aVar2 = (N2.a) c0284f.f3747d;
            if (aVar2 != null) {
                application.unregisterActivityLifecycleCallbacks(aVar2);
                c0284f.f3747d = null;
            }
            N2.a aVar3 = new N2.a(c0284f);
            c0284f.f3747d = aVar3;
            application.registerActivityLifecycleCallbacks(aVar3);
            T2.d.a("SessionController", "registerApplicationLifeCycle");
            T2.d.a("SessionController", "SessionController init");
            cVar.f1238g = c0284f;
            new LinkedList();
            T2.d.a("PageController", "PageController init");
            cVar.f1239h = new stepos.support.v7.app.palette.b(3);
            ((ThreadPoolExecutor) R2.a.f1659a.f9664b).execute(new m(2, cVar, z4));
            T2.d.a("UsageStatsProxy3", "UsageStatsProxy3 init complete");
        }
        UsageStatsUtils.onEvent("onemind_initialization", null, null);
    }

    public static boolean isBootFailed() {
        return sBootFailed;
    }

    private boolean isLite() {
        return 1 == SystemProperty.getInt(PROPERTY_STEPOS_LITE, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitComplete() {
        this.mInitialized.set(true);
        ((ScreenEventDataSource) DataSourceManager.getInstance().getDataSource(Tags.SCREEN_EVENT)).onInitComplete();
        sendBroadcast(new Intent(ACTION_ALPHAME_BOOT_BROADCAST));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserBackground() {
        AlphaMeLogger.iLog("onUserBackground. myUserId=" + UserHandle.myUserId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserForeground() {
        AlphaMeLogger.iLog("onUserForeground. myUserId=" + UserHandle.myUserId());
        publishServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishServer() {
        IBinder iBinderCheckAlphaMeService = PerfBinderHelper.checkAlphaMeService("alphame_server");
        Integer numUserIdOfBinder = AlphaMeServer.userIdOfBinder(iBinderCheckAlphaMeService);
        IBinder userBinder = numUserIdOfBinder != null ? AlphaMeServer.getUserBinder(iBinderCheckAlphaMeService, numUserIdOfBinder.intValue()) : null;
        int iMyUserId = UserHandle.myUserId();
        boolean zEquals = Integer.valueOf(iMyUserId).equals(numUserIdOfBinder);
        AlphaMeServer alphaMeServer = AlphaMeServer.getInstance();
        AlphaMeLogger.iLog("publishServer for newUserId=" + iMyUserId + ", newServer=" + alphaMeServer + ", oldUserId=" + numUserIdOfBinder + ", oldService=" + userBinder + ", isSame=" + zEquals + ", oldRawBinder=" + iBinderCheckAlphaMeService);
        AlphaMeServer.linkUserBinder(iBinderCheckAlphaMeService, iMyUserId, alphaMeServer);
        AlphaMeServer.notifyUserBackground(userBinder);
        alphaMeServer.publish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAction() {
        ActionManager actionManager = ActionManager.getInstance();
        actionManager.register("APP_EVENT", (byte) 9, new String[]{"Activity事件", "@author lxh", "@return 类型为String[] 其中", "        [0]：应用包名", "        [1]：事件类型，可能值为resume pause", "        [2]：activityName", "        [3]：userId", "        [4]：permissionIds", "        [5]：permissionValues"});
        actionManager.register(LocalConsts.ACTION_APP_DIED, (byte) 4, new String[]{"App 死亡", "@author hzy", "@return pid"}, true);
        actionManager.register(LocalConsts.ACTION_ACTIVITY_DETECT, (byte) 9, new String[]{"Top Activity 变化", "@author hzy", "@return pkgName, activity, userId, quickAppPkg"}, true);
        actionManager.register(LocalConsts.ACTION_SCREEN_OFF_BY_PAUSE, (byte) 2, new String[]{"异常灭屏", "@author hzy", "@return true"}, true);
        actionManager.register("SCREEN_EVENT", (byte) 4, new String[]{"灭屏亮屏事件", "@author liukeliang", "@return 类型为int 其中", "        0为灭屏", "        1为亮屏"});
        actionManager.register("SYSTEM_STATE_CHANGED", (byte) 4, new String[]{"系统状态", "@author liukeliang", "@return 类型为int 其中", "        1代表系统处于Active状态", "        2代表系统处于Pause状态", "        3代表系统处于Idle状态", "        4代表系统处于Standby状态", "        5代表系统处于SLEEP状态"});
        actionManager.register("SCENE_CHANGED", (byte) 9, new String[]{"当前应用的场景,应用启动时如果场景变化会发送这个广播", "@author zhuhequan", "@return 类型为String[] 其中", "        [0]为场景", "        [1]为包名", "        [2]wifi是否不休眠"});
        actionManager.register(LocalConsts.ACTION_APP_CREATED, (byte) 9, new String[]{"应用create的时候发送，方便游戏模式有针对的初始化", "@author lxh", "@return 类型为String[] 其中", "        [0]为包名", "        [1]为场景"});
        actionManager.register("APP_LIST_CHANGED", (byte) 15, new String[]{"系统应用列表发生改变", "@author zhuhequan", "@return 类型为Args 其中", "        [0] int 为应用类型其中：0为工作状态名单 1为用户手动拉白名单 2为用户多任务加锁名单", "        [1] ArrayList<String> 返回的名单"});
        actionManager.register("APP_STATE_CHANGED", (byte) 4, new String[]{"APP工作状态", "@author liukeliang", "@return 类型为int 其中", "        0代表系统处于空闲状态", "        1代表系统处于工作状态"});
        actionManager.register("SLEEP_STATE_CHANGED", (byte) 4, new String[]{"sleep状态", "@author zhouyueguo", "@return 类型为int 其中", "        0代表系统处于正常模式", "        1代表系统处于睡眠模式", "        2代表系统处于深度睡眠模式"});
        actionManager.register("ACTION_STEP_STATE_CHANGED", (byte) 4, new String[]{"运动状态.\u3000当动态状态改变时会发出此广播. 要获取速度可以通过getStepState接口", "@author huangzuoyong", "@return 类型为int 其中", "        1-手机处于静止, 2-手机处于走路, 3-手机处于跑步"});
        actionManager.register(LocalConsts.ACTION_WIFI_STATE_CHANGED, (byte) 9, new String[]{"WIFI状态，当前连接上的wifi", "@author lxh", "@return 类型为String[] 其中", "        [0]ssid", "        [1]bssid"});
        actionManager.register(LocalConsts.ACTION_LOCATION_CHANGED, (byte) 9, new String[]{"LOCATION状态，当前的位置", "@author lxh", "@return 类型为String[] 其中", "        [0]state 请求定位的发起者", "        [1]coord", "        [2]address", "        [3]type"});
        actionManager.register(LocalConsts.ACTION_COUNTRY_CHANGED, (byte) 9, new String[]{"出国场景", "@author lxh", "@return 类型为String[] 其中", "        [0]currCN 当前国家的国家码", "        [1]currUTC 当前国家的时区", "        [2]cn 系统区域国家码", "        [3]utc 系统时区"});
        actionManager.register(LocalConsts.ACTION_CITY_CHANGED, (byte) 9, new String[]{"出国场景", "@author lxh", "@return 类型为String[] 其中", "        [0]lastCity 先前的城市名", "        [1]currCity 当前的城市名"});
        actionManager.register(LocalConsts.ACTION_BLUETOOTH_CHANGED, (byte) 9, new String[]{"Bluetooth状态", "@author lxh", "@return 类型为String[] 其中", "        [0]state 连接或断开", "        [1]name 蓝牙名称", "        [2]name 蓝牙地址", "        [3]vehicle 1是车载蓝牙， 0是普通蓝牙"});
        actionManager.register(LocalConsts.ACTION_CHARGING_CHANGED, (byte) 10, new String[]{"电源状态", "@author lxh", "@return 类型为int[] 其中", "        [0]chargingType -1 没有充电, 1 AC 充电, 2 USB 充电, 4 无线充电", "        [1]level 当前电量", "        [2]scale 总电量"});
        actionManager.register(LocalConsts.ACTION_HEADSET_CHANGED, (byte) 4, new String[]{"耳机插入状态", "@author lxh", "@return 类型为int 其中", "        -1 错误状态, 0 断开, 1 连上"});
        actionManager.register("OCR_DETECT", (byte) 9, new String[]{"系统状态", "@author lxh", "@return 类型为int 其中", "        成功或失败1 成功，0 失败", "        之前请求的type", "        成功时为识别结果，识别则为errorcode"});
        actionManager.register(LocalConsts.ACTION_QUERY_HOME_COMPANY_RESULT, (byte) 9, new String[]{"查询当前位置是否是家或公司的结果广播", "@author zuoyong", "@return [当前位置类型（家0，公司1，其它-1）, 当前位置经纬度，当前地址，家经纬度，家地址，公司经纬度，公司地址]"});
        actionManager.register(DailyUsageEngineService.ACTION_GET_MULTI_DAILY_USAGE_SUMMARY, (byte) 6, new String[]{"查询多天使用记录", "@author yingjie", "@return string 通过Gson获取对应的对象 Response<MultiDailyUsageSummary>"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerDataEngine() {
        EngineManager.getInstance().register(SleepModeEngine.getInstance());
        EngineManager.getInstance().register(AppInfoEngine.getInstance());
        EngineManager.getInstance().register(SceneDetectorEngine.getInstance());
        EngineManager.getInstance().register(new SystemStateEngine());
        if (isLite()) {
            return;
        }
        EngineManager.getInstance().register(WifiEngine.getInstance(this));
        EngineManager.getInstance().register(LocationEngine.getInstance(this));
        EngineManager.getInstance().register(BlueToothEngine.getInstance(this));
        EngineManager.getInstance().register(PowerEngine.getInstance(this));
        EngineManager.getInstance().register(HeadsetEngine.getInstance(this));
        EngineManager.getInstance().register(NotificationEngine.getInstance(this));
        EngineManager.getInstance().register(UserBehaviorEngine.INSTANCE.getINSTANCE());
        EngineManager.getInstance().register(OcrEngine.INSTANCE.getINSTANCE());
        EngineManager.getInstance().register(CutoutEngine.INSTANCE.getINSTANCE());
        EngineManager.getInstance().register(PredictEngine.INSTANCE.getINSTANCE());
        EngineManager.getInstance().register(PersonalEngine.INSTANCE.getINSTANCE());
        EngineManager.getInstance().register(DailyUsageEngineService.INSTANCE.getINSTANCE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerDataSource() {
        DataSourceManager.getInstance().register(new AppClickDataSource(Tags.APP_CLICK));
        DataSourceManager.getInstance().register(new ScreenEventDataSource(Tags.SCREEN_EVENT));
        DataSourceManager.getInstance().register(new AppSuggestDataSource(AppSuggestReport.TAG));
        try {
            EngineRoomDatabase.INSTANCE.getDatabase(this);
        } catch (Exception unused) {
        }
        if (isLite()) {
            return;
        }
        DataSourceManager.getInstance().register(new ActivityClickDataSource(Tags.ACTIVITY_CLICK));
        DataSourceManager.getInstance().register(AwarenessDataSource.getInstance());
        DataSourceManager.getInstance().register(new PersonaDataSource(Tags.PERSONA));
        DataSourceManager.getInstance().register(UserBehaviorDataSource.getInstance());
        TimetableTracker.getInstance().init();
    }

    private void registerSensitiveDataEngine() {
        EngineManager.getInstance().register(MovingStateEngine.getInstance(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerUserSwitch() {
        this.mUserReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.ApplicationImpl.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent != null ? intent.getAction() : null;
                AlphaMeLogger.iLog("User Intent: " + intent + ", current=" + UserInfoProxy.getCurrentUser());
                if ("android.intent.action.USER_FOREGROUND".equals(action)) {
                    ApplicationImpl.this.onUserForeground();
                } else if ("android.intent.action.USER_BACKGROUND".equals(action)) {
                    ApplicationImpl.this.onUserBackground();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_FOREGROUND");
        intentFilter.addAction("android.intent.action.USER_BACKGROUND");
        registerReceiver(this.mUserReceiver, intentFilter);
    }

    @SuppressLint({"ApplySharedPref"})
    public static int saveBootInfo() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 60000;
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(Property.SHARED_PREFERENCES_NAME, 0);
        long j4 = sharedPreferences.getLong(KEY_BOOT_MINUTE, 0L);
        StringBuilder sbE = AbstractC0831a.e("saveBootInfo ", jCurrentTimeMillis, " / ");
        sbE.append(j4);
        AlphaMeLogger.iLog(sbE.toString());
        if (jCurrentTimeMillis != j4) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(KEY_BOOT_MINUTE, jCurrentTimeMillis);
            editorEdit.putInt(KEY_MINUTE_BOOT_TIMES, 1);
            editorEdit.commit();
            return 1;
        }
        int i4 = 1 + sharedPreferences.getInt(KEY_MINUTE_BOOT_TIMES, 1);
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        editorEdit2.putInt(KEY_MINUTE_BOOT_TIMES, i4);
        editorEdit2.commit();
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAliveService() {
        try {
            startService(new Intent(this, (Class<?>) AliveService.class));
        } catch (Exception e4) {
            Log.e(TAG, "startAliveService: " + e4.getMessage());
        }
    }

    @Override // com.stepos.alphame.common.utils.BaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mAppCtx = this;
    }

    public void ensureUserBehaviorInitialized() throws InterruptedException {
        int i4 = 0;
        while (!this.mInitialized.get() && (i4 = i4 + 1) <= 50) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        UserBehaviorDataSource.getInstance().ensureInitialized();
    }

    public boolean hasInitialized() {
        return this.mInitialized.get();
    }

    public void initPushReceiver() {
        AlphaMeLogger.iLog("initPushReceiver on first network ready");
        ApplicationImpl applicationImpl = mAppCtx;
        if (AbstractC0155a.f2266a.compareAndSet(false, true)) {
            Process.myPid();
        }
        AbstractC0155a.b("5.0.7", "register start, appId: 111154");
        applicationImpl.getSharedPreferences("com.stepos.push", 0).edit().putString("app_id", APP_ID).apply();
        W1.b bVar = (W1.b) V1.a.f1932a.f3212a;
        bVar.f13182b = APP_ID;
        bVar.f13183c = APP_KEY;
        AbstractC0392b.f4467a.execute(new o(13, bVar, applicationImpl));
    }

    public void initSensitiveJob() {
        Log.w(TAG, "initSensitiveJob");
        initUsageStats();
        registerSensitiveDataEngine();
    }

    public void initialize() {
        ALPHAME_THREAD.post(new Runnable() { // from class: com.stepos.alphame.ApplicationImpl.1
            @Override // java.lang.Runnable
            public void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (ApplicationImpl.this.checkInvalidBoot() && ApplicationImpl.this.mInitialized.get()) {
                    Log.e(ApplicationImpl.TAG, "checkInvalidBoot fail");
                    return;
                }
                if (ApplicationImpl.this.checkInvalidUser()) {
                    Log.e(ApplicationImpl.TAG, "checkInvalidUser fail");
                    return;
                }
                ApplicationImpl.this.registerAction();
                ApplicationImpl.this.publishServer();
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                ApplicationImpl.this.registerDataSource();
                ApplicationImpl.this.registerDataEngine();
                long jUptimeMillis3 = SystemClock.uptimeMillis() - jUptimeMillis2;
                long jUptimeMillis4 = SystemClock.uptimeMillis();
                AppInfoDbHelper.getInstance().checkUpgrade();
                RuleUpdater.getInstance();
                long jUptimeMillis5 = SystemClock.uptimeMillis() - jUptimeMillis4;
                ApplicationImpl.this.startAliveService();
                ApplicationImpl.this.registerUserSwitch();
                ApplicationImpl.this.initSensitiveJob();
                ApplicationImpl.this.onInitComplete();
                AlphaMeLogger.iLog("initialize done. time=" + (SystemClock.uptimeMillis() - jUptimeMillis) + ", initEngine time=" + jUptimeMillis3 + ", data time=" + jUptimeMillis5);
                ApplicationImpl.this.initNetworkMonitor();
            }
        });
    }

    @Override // com.stepos.alphame.common.utils.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        initialize();
        if (!NewAppEventCollector.init(this, getAlphaMeLooper())) {
            DataSourceManager.getInstance().register(new AppEventDataSource(Tags.APP_EVENT));
        }
        sAppBootTime = System.currentTimeMillis();
    }

    @Override // com.stepos.alphame.common.utils.BaseApplication, android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
        PoolManager.trimMemory(i4);
        if (i4 >= 60) {
            DataSourceManager.getInstance().trimMemory();
            EngineManager.getInstance().trimMemory();
        }
    }

    public void waitInitializedDone(int i4) throws InterruptedException {
        if (this.mInitialized.get() || i4 == MY_PID) {
            return;
        }
        int i5 = 0;
        while (!this.mInitialized.get() && (i5 = i5 + 1) <= 10) {
            AlphaMeLogger.debugLog("wait...");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
    }
}
