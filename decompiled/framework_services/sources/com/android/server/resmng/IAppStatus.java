package com.android.server.resmng;

/* JADX INFO: loaded from: classes3.dex */
public final enum IAppStatus extends Enum<IAppStatus> {
    private static final /* synthetic */ IAppStatus[] $VALUES = null;
    public static final IAppStatus ACTIVE_BACKGROUND = null;
    public static final IAppStatus ACTIVE_QUICK_TILE = null;
    public static final IAppStatus APP_HOLD_BLE = null;
    public static final IAppStatus APP_IS_DOWNLOADING = null;
    public static final IAppStatus BLIND_MODE = null;
    public static final IAppStatus DEBUG_ACTIVE = null;
    public static final IAppStatus DEFAULT_DAILER = null;
    public static final IAppStatus DEFAULT_INPUT = null;
    public static final IAppStatus DEFAULT_LAUNCHER = null;
    public static final IAppStatus DEFAULT_SMS = null;
    public static final IAppStatus DYNAMIC_BLACK_LIST = null;
    public static final IAppStatus FIRST_APPLICATION = null;
    public static final IAppStatus FOCUSED_APP = null;
    public static final IAppStatus HAS_FLOATING_WINDOW = null;
    public static final IAppStatus HAS_LAUNCHER_ICON = null;
    public static final IAppStatus HAS_RESUMED_ACTIVITY = null;
    public static final IAppStatus HAS_VISIBLE_WINDOW = null;
    public static final IAppStatus HAS_WIDGET = null;
    public static final IAppStatus HIGH_PRIO_APP = null;
    public static final IAppStatus INPUT_METHOD_CLIENT = null;
    public static final IAppStatus IS_PLAYING_AUDIO = null;
    public static final IAppStatus IS_WALLPAPER = null;
    public static final IAppStatus OTHER = null;
    public static final IAppStatus PENDING_TOP = null;
    public static final IAppStatus POWER_KILL_COMB_JUDGEMENT = null;
    public static final IAppStatus PREFETCH_NOT_DONE = null;
    public static final IAppStatus RECENTLY_STARTED_5S = null;
    public static final IAppStatus SCREEN_RECORDING = null;
    public static final IAppStatus SET_RESUMED_ACTIVITY = null;
    public static final IAppStatus SYSTEM_APP = null;
    public static final IAppStatus TASK_PERSIST = null;
    public static final IAppStatus Top_OR_BOUND_TOP_PROC = null;
    public static final IAppStatus UID_ACTIVE = null;
    public static final IAppStatus UID_CPU_RUNNER_RECENT = null;
    public static final IAppStatus UNINSTALLABLE_SYSTEM_APP = null;
    public static final IAppStatus USING_CAMERA = null;
    public static final IAppStatus UX_ALLOW_BG_POWER_HIGH = null;
    public static final IAppStatus XR_KEEP_ALIVE = null;
    private String mName;

    private static /* synthetic */ IAppStatus[] $values() {
        return new IAppStatus[]{FOCUSED_APP, PENDING_TOP, Top_OR_BOUND_TOP_PROC, INPUT_METHOD_CLIENT, HIGH_PRIO_APP, UID_CPU_RUNNER_RECENT, TASK_PERSIST, ACTIVE_BACKGROUND, BLIND_MODE, FIRST_APPLICATION, PREFETCH_NOT_DONE, HAS_VISIBLE_WINDOW, IS_PLAYING_AUDIO, IS_WALLPAPER, HAS_WIDGET, HAS_FLOATING_WINDOW, USING_CAMERA, SCREEN_RECORDING, UX_ALLOW_BG_POWER_HIGH, POWER_KILL_COMB_JUDGEMENT, DYNAMIC_BLACK_LIST, SYSTEM_APP, UNINSTALLABLE_SYSTEM_APP, APP_IS_DOWNLOADING, APP_HOLD_BLE, HAS_LAUNCHER_ICON, DEFAULT_LAUNCHER, DEFAULT_SMS, DEFAULT_DAILER, DEFAULT_INPUT, XR_KEEP_ALIVE, DEBUG_ACTIVE, UID_ACTIVE, HAS_RESUMED_ACTIVITY, SET_RESUMED_ACTIVITY, RECENTLY_STARTED_5S, ACTIVE_QUICK_TILE, OTHER};
    }

    public static IAppStatus valueOf(String name) {
        return (IAppStatus) Enum.valueOf(IAppStatus.class, name);
    }

    public static IAppStatus[] values() {
        return (IAppStatus[]) $VALUES.clone();
    }

    static {
        FOCUSED_APP = new IAppStatus("FOCUSED_APP", 0, "1");
        PENDING_TOP = new IAppStatus("PENDING_TOP", 1, "2");
        Top_OR_BOUND_TOP_PROC = new IAppStatus("Top_OR_BOUND_TOP_PROC", 2, "3");
        INPUT_METHOD_CLIENT = new IAppStatus("INPUT_METHOD_CLIENT", 3, "4");
        HIGH_PRIO_APP = new IAppStatus("HIGH_PRIO_APP", 4, "5");
        UID_CPU_RUNNER_RECENT = new IAppStatus("UID_CPU_RUNNER_RECENT", 5, "6");
        TASK_PERSIST = new IAppStatus("TASK_PERSIST", 6, "7");
        ACTIVE_BACKGROUND = new IAppStatus("ACTIVE_BACKGROUND", 7, "8");
        BLIND_MODE = new IAppStatus("BLIND_MODE", 8, "9");
        FIRST_APPLICATION = new IAppStatus("FIRST_APPLICATION", 9, "10");
        PREFETCH_NOT_DONE = new IAppStatus("PREFETCH_NOT_DONE", 10, "11");
        HAS_VISIBLE_WINDOW = new IAppStatus("HAS_VISIBLE_WINDOW", 11, "12");
        IS_PLAYING_AUDIO = new IAppStatus("IS_PLAYING_AUDIO", 12, "13");
        IS_WALLPAPER = new IAppStatus("IS_WALLPAPER", 13, "14");
        HAS_WIDGET = new IAppStatus("HAS_WIDGET", 14, "15");
        HAS_FLOATING_WINDOW = new IAppStatus("HAS_FLOATING_WINDOW", 15, "16");
        USING_CAMERA = new IAppStatus("USING_CAMERA", 16, "17");
        SCREEN_RECORDING = new IAppStatus("SCREEN_RECORDING", 17, "18");
        UX_ALLOW_BG_POWER_HIGH = new IAppStatus("UX_ALLOW_BG_POWER_HIGH", 18, "19");
        POWER_KILL_COMB_JUDGEMENT = new IAppStatus("POWER_KILL_COMB_JUDGEMENT", 19, "20");
        DYNAMIC_BLACK_LIST = new IAppStatus("DYNAMIC_BLACK_LIST", 20, "21");
        SYSTEM_APP = new IAppStatus("SYSTEM_APP", 21, "22");
        UNINSTALLABLE_SYSTEM_APP = new IAppStatus("UNINSTALLABLE_SYSTEM_APP", 22, "23");
        APP_IS_DOWNLOADING = new IAppStatus("APP_IS_DOWNLOADING", 23, "24");
        APP_HOLD_BLE = new IAppStatus("APP_HOLD_BLE", 24, "25");
        HAS_LAUNCHER_ICON = new IAppStatus("HAS_LAUNCHER_ICON", 25, "26");
        DEFAULT_LAUNCHER = new IAppStatus("DEFAULT_LAUNCHER", 26, "27");
        DEFAULT_SMS = new IAppStatus("DEFAULT_SMS", 27, "28");
        DEFAULT_DAILER = new IAppStatus("DEFAULT_DAILER", 28, "29");
        DEFAULT_INPUT = new IAppStatus("DEFAULT_INPUT", 29, "30");
        XR_KEEP_ALIVE = new IAppStatus("XR_KEEP_ALIVE", 30, "31");
        DEBUG_ACTIVE = new IAppStatus("DEBUG_ACTIVE", 31, "32");
        UID_ACTIVE = new IAppStatus("UID_ACTIVE", 32, "33");
        HAS_RESUMED_ACTIVITY = new IAppStatus("HAS_RESUMED_ACTIVITY", 33, "34");
        SET_RESUMED_ACTIVITY = new IAppStatus("SET_RESUMED_ACTIVITY", 34, "35");
        RECENTLY_STARTED_5S = new IAppStatus("RECENTLY_STARTED_5S", 35, "36");
        ACTIVE_QUICK_TILE = new IAppStatus("ACTIVE_QUICK_TILE", 36, "37");
        OTHER = new IAppStatus("OTHER", 37, "-1");
        $VALUES = $values();
    }

    private IAppStatus(String r1, int r2, String name) {
        super(r1, r2);
        this.mName = name;
    }

    public static IAppStatus fromString(String name) {
        IAppStatus[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        IAppStatus type = r0[r2];
        if (type.mName.equals(name) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return type;
    L8:
        return null;
    }
}
