package com.android.server.scene;

import android.app.WallpaperManager;
import android.app.usage.UsageStatsManagerInternal;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public class SceneUtils {
    public static final int DEVICEIDLE_TYPE_DEEP = 1;
    public static final int DEVICEIDLE_TYPE_LIGHT = 0;
    public static final int DEVICE_IDLE_STATE_IDLE = 5;
    public static final int DEVICE_IDLE_STATE_IDLE_MAINTENANCE = 6;
    public static final int DISPLAY_DEVICE_ADDED = 1;
    public static final int DISPLAY_DEVICE_REMOVED = 3;
    public static final String DOUBLE_LAY_SUFFIX = "#999";
    public static final int DOUBLE_LAY_USERID = 999;
    public static final String KEY_ACTIVITY_NAME = "ActivityName";
    public static final String KEY_CALLER = "caller";
    public static final String KEY_CHANGED = "changed";
    public static final String KEY_COLD_LAUNCH = "isColdLaunch";
    public static final String KEY_CPUABI = "cpuAbi";
    public static final String KEY_DISPLAY_ID = "displayId";
    public static final String KEY_HOME_ACTIVITY = "isHome";
    public static final String KEY_ID = "unique_id";
    public static final String KEY_INTENT = "itnt";
    public static final String KEY_IS_HFULL = "is_HFull";
    public static final String KEY_IS_LANDSCAPE = "is_landscape";
    public static final String KEY_NAME = "name";
    public static final String KEY_NEXT_CLASS = "nextClass";
    public static final String KEY_PATTERN_NAME = "pattern-name";
    public static final String KEY_PERSIST = "persist";
    public static final String KEY_PID = "pid";
    public static final String KEY_PKG = "pkg";
    public static final String KEY_PKGNAME = "PkgName";
    public static final String KEY_PRIV_CLASS = "privClass";
    public static final String KEY_PROBABILITY = "probability";
    public static final String KEY_PROCESS_NAME = "process";
    public static final String KEY_RECENT = "isRecents";
    public static final String KEY_SCENE_EVENT = "Event";
    public static final String KEY_SMART_OPTIMIZE_STATE = "smart_state";
    public static final String KEY_STACK_ID = "stackId";
    public static final String KEY_STATE = "state";
    public static final String KEY_TIME_STAMP = "timestamp";
    public static final String KEY_TOP_ACTIVITY = "top_activity";
    public static final String KEY_TOP_ACTIVITY_PKG = "top_activity_pkg";
    public static final String KEY_TOUCHED = "touch";
    public static final String KEY_UID = "uid";
    public static final String KEY_VISIBLE = "visible";
    public static final String KEY_WINDOW_MODE = "mode";
    public static final int LIGHT_DEVICE_IDLE_STATE_IDLE = 4;
    public static final int LONG_GAP = 1500000;
    public static final int MAX_WARNING_COUNT = 10;
    public static final int MIN_BACKGROUND_DUR = 600000;
    public static final String PKG_SYS_UI = "com.android.systemui";
    public static final int SCENE_EVENT_BLUETOOTH_CLOSE = 17;
    public static final int SCENE_EVENT_BLUETOOTH_CONNECT = 16;
    public static final int SCENE_EVENT_CONFIG_CHANGED = 18;
    public static final int SCENE_EVENT_ENTER_BENCHMARK = 3;
    public static final int SCENE_EVENT_ENTER_GAME = 1;
    public static final int SCENE_EVENT_ENTER_HEAVY_TEST = 29;
    public static final int SCENE_EVENT_ENTER_KEEPALIVE = 30;
    public static final int SCENE_EVENT_ENTER_LONGLIFE_WAIT = 32;
    public static final int SCENE_EVENT_ENTER_SPLM = 26;
    public static final int SCENE_EVENT_EXIT_BENCHMARK = 4;
    public static final int SCENE_EVENT_EXIT_GAME = 2;
    public static final int SCENE_EVENT_EXIT_KEEPALIVE = 31;
    public static final int SCENE_EVENT_EXIT_KEEP_SCREEN_ON = 6;
    public static final int SCENE_EVENT_EXIT_SPLM = 27;
    public static final int SCENE_EVENT_GAMETURBO_START = 24;
    public static final int SCENE_EVENT_GAMETURBO_STOP = 25;
    public static final int SCENE_EVENT_INDOOR = 21;
    public static final int SCENE_EVENT_INOUTDOOR_OTHER = 23;
    public static final int SCENE_EVENT_KEEP_SCREEN_ON = 5;
    public static final int SCENE_EVENT_OUTDOOR = 22;
    public static final int SCENE_EVENT_PAUSE_AUDIO = 11;
    public static final int SCENE_EVENT_PAUSE_VIDEO = 14;
    public static final int SCENE_EVENT_SPLM_FINAL_STAGE = 28;
    public static final int SCENE_EVENT_START_AUDIO = 10;
    public static final int SCENE_EVENT_START_VIDEO = 13;
    public static final int SCENE_EVENT_STOP_AUDIO = 12;
    public static final int SCENE_EVENT_STOP_VIDEO = 15;
    public static final int SCENE_EVENT_VPN_CLOSE = 20;
    public static final int SCENE_EVENT_VPN_CONNECT = 19;
    public static final int SCENE_TYPE_ANIMATOR = 11;
    public static final int SCENE_TYPE_AUDIO = 2;
    public static final int SCENE_TYPE_BENCHMARK = 7;
    public static final int SCENE_TYPE_BLUETOOTH = 3;
    public static final int SCENE_TYPE_GAME = 5;
    public static final int SCENE_TYPE_GAME_TURBO = 10;
    public static final int SCENE_TYPE_INOUTDOOR = 9;
    public static final int SCENE_TYPE_LOCATION = 4;
    public static final int SCENE_TYPE_NEW_SPLM = 13;
    public static final int SCENE_TYPE_NONE = 0;
    public static final int SCENE_TYPE_SENSOR = 6;
    public static final int SCENE_TYPE_SPLM = 12;
    public static final int SCENE_TYPE_VIDEO = 1;
    public static final int SCENE_TYPE_VPN = 8;
    public static final int SHORT_GAP = 30000;
    public static final String SYS_UI_CONTROL_CENTER = "com.android.systemui.control_center";
    private static final String TAG = "Scene-Utils";
    public static final int TWO_HOURS = 7200000;
    public static final int USER_DOUBLE_LAY_PKG_UID = 99900000;
    public static final boolean isMyOS145OrLater = true;
    private static volatile SceneUtils sInstance;
    public static boolean sPlatformLogEnabled;
    private Context mContext;
    private PackageManager mPackageManager;
    private final ArrayList<PolicyReadyListener> mPlicyReadyListenter;
    private UsageStatsManagerInternal mUsageStatsService;
    private WallpaperManager mWallpaperManager;

    public interface PolicyReadyListener {
        void onPolicyInitCompleted();
    }

    public static /* synthetic */ boolean $r8$lambda$WURNl2b0_2Ta4jpIIhPMkKZmuQo(Object r0) {
        return lambda$isArgsValid$0(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$fGxXjtWQSq2nmlSMO1qZ4QqslOA(Object r0) {
        return lambda$isArgsValid$1(r0);
    }

    static {
        sInstance = null;
        sPlatformLogEnabled = false;
    }

    private SceneUtils(Context context) {
        this.mPlicyReadyListenter = new ArrayList();
        this.mContext = context;
        this.mPackageManager = this.mContext.getPackageManager();
        this.mWallpaperManager = (WallpaperManager) this.mContext.getSystemService(WallpaperManager.class);
        this.mUsageStatsService = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
    }

    protected static SceneUtils createInstance(Context context) {
        if (sInstance != null) goto L16;
        monitor-enter(SceneUtils.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new SceneUtils(context);     // Catch: Throwable -> L9
    L11:
        monitor-exit(SceneUtils.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public static SceneUtils getInstance() {
        monitor-enter(SceneUtils.class);
        SceneUtils r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(SceneUtils.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerPolicyReadyListener(PolicyReadyListener listener) {
        Slog.d(TAG, "registerPolicyReadyListener listener : " + listener);
        if (listener == null) goto L6;
        this.mPlicyReadyListenter.add(listener);
        return;
    }

    protected void onPolicyReady() {
        Iterator<PolicyReadyListener> r0 = this.mPlicyReadyListenter.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        PolicyReadyListener listener = r0.next();
        if (listener == null) goto L4;
        listener.onPolicyInitCompleted();
        goto L4
    }

    public Context getContext() {
        return this.mContext;
    }

    public PackageManager getPackageManager() {
        return this.mPackageManager;
    }

    public WallpaperManager getWallpaperManager() {
        return this.mWallpaperManager;
    }

    public UsageStatsManagerInternal getUsageStatsService() {
        return this.mUsageStatsService;
    }

    public static String getPkgNameForDoublelay(String caller, String originPkgName, Object... args) {
        if (TextUtils.isEmpty(originPkgName) == false) goto L5;
        return "";
    L5:
        boolean isArgsValid = isArgsValid(caller, args);
        if (isArgsValid == false) goto L20;
        int uid = ((Integer) args[0]).intValue();
        if (uid <= 99900000) goto L16;
        if (originPkgName.endsWith(DOUBLE_LAY_SUFFIX) == true) goto L23;
        String pgkName = originPkgName + DOUBLE_LAY_SUFFIX;
        return pgkName;
    L23:
        return originPkgName;
    L16:
        if (originPkgName.endsWith(DOUBLE_LAY_SUFFIX) == false) goto L19;
        String pgkName2 = originPkgName.replace(DOUBLE_LAY_SUFFIX, "");
        return pgkName2;
    L19:
        return originPkgName;
    L20:
        return originPkgName;
    }

    public static boolean isArgsValid(String methodName, Object... args) {
        if (args != null) goto L5;
    L11:
        return false;
    L5:
        if (args.length <= 0) goto L11;
        Object param = args[0];
        boolean valid = Optional.ofNullable(param).filter(new SceneUtils$$ExternalSyntheticLambda0()).map(new SceneUtils$$ExternalSyntheticLambda1()).isPresent();
        if (valid == false) goto L10;
        return true;
    L10:
        Slog.e(TAG, "Scene-Warning call " + methodName + " with invalid params in MyOS14.5 or later!!!");
        goto L11
    }

    private static /* synthetic */ boolean lambda$isArgsValid$0(Object obj) {
        return obj instanceof Integer;
    }

    private static /* synthetic */ Integer lambda$isArgsValid$1(Object it) {
        return Integer.valueOf(((Integer) it).intValue());
    }
}
