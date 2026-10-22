package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum Features$BooleanFeatureKeys extends Enum<Features$BooleanFeatureKeys> {
    public static final Features$BooleanFeatureKeys ADJUST_TERMINATE_SWITCH = null;
    public static final Features$BooleanFeatureKeys BG_SESSION_SWITCH = null;
    public static final Features$BooleanFeatureKeys CHILD_MODE_BEFORE_INIT_SWITCH = null;
    public static final Features$BooleanFeatureKeys CHILD_MODE_SWITCH = null;
    public static final Features$BooleanFeatureKeys CONTROL_CUSTOM_HEADER_SWITCH = null;
    public static final Features$BooleanFeatureKeys CONTROL_EVENT_PARAM_SWITCH = null;
    public static final Features$BooleanFeatureKeys CUSTOM_EVENT_FILTER = null;
    public static final Features$BooleanFeatureKeys DATA_ISOLATE_SWITCH = null;
    public static final Features$BooleanFeatureKeys DEBUG_LOG_SWITCH = null;
    public static final Features$BooleanFeatureKeys DEVTOOLS_SWITCH = null;
    public static final Features$BooleanFeatureKeys DISABLE_PERSONALIZATION_SWITCH = null;
    public static final Features$BooleanFeatureKeys ENCRYPT_SWITCH = null;
    public static final Features$BooleanFeatureKeys EVENT_USER_ID_SWITCH = null;
    public static final Features$BooleanFeatureKeys FORWARD_REPORT_SWITCH = null;
    public static final Features$BooleanFeatureKeys LOG_SETTINGS_EVENT_FILTER = null;
    public static final Features$BooleanFeatureKeys NORMAL_SAMPLING_SWITCH = null;
    public static final Features$BooleanFeatureKeys PRIORITY_SWITCH = null;
    public static final Features$BooleanFeatureKeys RECOVERY_SWITCH = null;
    public static final Features$BooleanFeatureKeys TEA_SAMPLING_SWITCH = null;
    public static final Features$BooleanFeatureKeys TOURIST_MODE_EVENT_SWITCH = null;
    public static final Features$BooleanFeatureKeys TOURIST_MODE_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Features$BooleanFeatureKeys[] f192496a = null;
    private final int position;

    static {
        Features$BooleanFeatureKeys r100 = new Features$BooleanFeatureKeys("NORMAL_SAMPLING_SWITCH", 0, 0);
        NORMAL_SAMPLING_SWITCH = r100;
        Features$BooleanFeatureKeys r101 = new Features$BooleanFeatureKeys("TEA_SAMPLING_SWITCH", 1, 1);
        TEA_SAMPLING_SWITCH = r101;
        Features$BooleanFeatureKeys r102 = new Features$BooleanFeatureKeys("PRIORITY_SWITCH", 2, 2);
        PRIORITY_SWITCH = r102;
        Features$BooleanFeatureKeys r103 = new Features$BooleanFeatureKeys("RECOVERY_SWITCH", 3, 3);
        RECOVERY_SWITCH = r103;
        Features$BooleanFeatureKeys r104 = new Features$BooleanFeatureKeys("LOG_SETTINGS_EVENT_FILTER", 4, 4);
        LOG_SETTINGS_EVENT_FILTER = r104;
        Features$BooleanFeatureKeys r105 = new Features$BooleanFeatureKeys("CUSTOM_EVENT_FILTER", 5, 5);
        CUSTOM_EVENT_FILTER = r105;
        Features$BooleanFeatureKeys r110 = new Features$BooleanFeatureKeys("ENCRYPT_SWITCH", 6, 6);
        ENCRYPT_SWITCH = r110;
        Features$BooleanFeatureKeys r111 = new Features$BooleanFeatureKeys("FORWARD_REPORT_SWITCH", 7, 7);
        FORWARD_REPORT_SWITCH = r111;
        Features$BooleanFeatureKeys r112 = new Features$BooleanFeatureKeys("DATA_ISOLATE_SWITCH", 8, 8);
        DATA_ISOLATE_SWITCH = r112;
        Features$BooleanFeatureKeys r113 = new Features$BooleanFeatureKeys("EVENT_USER_ID_SWITCH", 9, 9);
        EVENT_USER_ID_SWITCH = r113;
        Features$BooleanFeatureKeys r114 = new Features$BooleanFeatureKeys("TOURIST_MODE_SWITCH", 10, 10);
        TOURIST_MODE_SWITCH = r114;
        Features$BooleanFeatureKeys r115 = new Features$BooleanFeatureKeys("TOURIST_MODE_EVENT_SWITCH", 11, 11);
        TOURIST_MODE_EVENT_SWITCH = r115;
        Features$BooleanFeatureKeys r106 = new Features$BooleanFeatureKeys("ADJUST_TERMINATE_SWITCH", 12, 12);
        ADJUST_TERMINATE_SWITCH = r106;
        Features$BooleanFeatureKeys r107 = new Features$BooleanFeatureKeys("DISABLE_PERSONALIZATION_SWITCH", 13, 13);
        DISABLE_PERSONALIZATION_SWITCH = r107;
        Features$BooleanFeatureKeys r108 = new Features$BooleanFeatureKeys("CHILD_MODE_BEFORE_INIT_SWITCH", 14, 14);
        CHILD_MODE_BEFORE_INIT_SWITCH = r108;
        Features$BooleanFeatureKeys r109 = new Features$BooleanFeatureKeys("CHILD_MODE_SWITCH", 15, 15);
        CHILD_MODE_SWITCH = r109;
        Features$BooleanFeatureKeys r116 = new Features$BooleanFeatureKeys("DEVTOOLS_SWITCH", 16, 16);
        DEVTOOLS_SWITCH = r116;
        Features$BooleanFeatureKeys r117 = new Features$BooleanFeatureKeys("DEBUG_LOG_SWITCH", 17, 17);
        DEBUG_LOG_SWITCH = r117;
        Features$BooleanFeatureKeys r118 = new Features$BooleanFeatureKeys("BG_SESSION_SWITCH", 18, 18);
        BG_SESSION_SWITCH = r118;
        Features$BooleanFeatureKeys r119 = new Features$BooleanFeatureKeys("CONTROL_EVENT_PARAM_SWITCH", 19, 21);
        CONTROL_EVENT_PARAM_SWITCH = r119;
        Features$BooleanFeatureKeys r120 = new Features$BooleanFeatureKeys("CONTROL_CUSTOM_HEADER_SWITCH", 20, 22);
        CONTROL_CUSTOM_HEADER_SWITCH = r120;
        f192496a = new Features$BooleanFeatureKeys[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
    }

    public static Features$BooleanFeatureKeys[] values() {
        return (Features$BooleanFeatureKeys[]) f192496a.clone();
    }

    public static Features$BooleanFeatureKeys valueOf(String r100) {
        return (Features$BooleanFeatureKeys) a.a(Features$BooleanFeatureKeys.class, r100);
    }

    public int toBits(int r100, boolean r101) {
        int r102 = 1 << this.position;
        if (r101 == false) goto L7;
        return r100 | r102;
    L7:
        return r100 & (~r102);
    }

    public Features$BooleanFeatureKeys(String r100, int r101, int r102) {
        super(r100, r101);
        this.position = r102;
    }
}
