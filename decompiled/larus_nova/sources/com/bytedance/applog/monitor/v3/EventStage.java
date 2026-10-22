package com.bytedance.applog.monitor.v3;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum EventStage extends Enum<EventStage> {
    public static final EventStage CACHED_BEFORE_HANDLE = null;
    public static final EventStage CACHE_DROP_BEFORE_HANDLE = null;
    public static final EventStage COLLECTED = null;
    public static final EventStage DATA_LIST_ADDED = null;
    public static final EventStage DB_INSERT_START = null;
    public static final EventStage DB_SAVE_END = null;
    public static final EventStage DB_SAVE_FAILED = null;
    public static final EventStage DB_SAVE_START = null;
    public static final EventStage FILTER_CUSTOM_BLOCKED = null;
    public static final EventStage FILTER_EVENT_BLOCKED = null;
    public static final EventStage FILTER_SAMPLING_DROPPED = null;
    public static final EventStage FILTER_SERVER_BLOCKED = null;
    public static final EventStage HANDLE_REALTIME_START = null;
    public static final EventStage NOT_INIT_DROP = null;
    public static final EventStage NO_SESSION_DROP = null;
    public static final EventStage PACK_END = null;
    public static final EventStage PACK_INSERT_END = null;
    public static final EventStage PACK_INSERT_FAILED = null;
    public static final EventStage PACK_INSERT_START = null;
    public static final EventStage PARAMS_INVALID_DROP = null;
    public static final EventStage POST_FAILED = null;
    public static final EventStage POST_ISOLATE = null;
    public static final EventStage POST_START = null;
    public static final EventStage PRE_EVENT_BLOCKED = null;
    public static final EventStage PRE_PROCESS_END = null;
    public static final EventStage PRE_PROCESS_START = null;
    public static final EventStage PRE_QUEUE_OVERFLOW = null;
    public static final EventStage PRIORITY_ACCEPT = null;
    public static final EventStage PRIORITY_HANDLE = null;
    public static final EventStage PROCESS_END = null;
    public static final EventStage PROCESS_START = null;
    public static final EventStage REALTIME_CRASH_DROP = null;
    public static final EventStage REALTIME_SEND_FAILED = null;
    public static final EventStage REALTIME_SEND_START = null;
    public static final EventStage REPORT_END = null;
    public static final EventStage REPORT_START = null;
    public static final EventStage TOURIST_BREAK = null;
    public static final EventStage UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventStage[] f192495a = null;
    private final String label;

    static {
        EventStage r100 = new EventStage("UNKNOWN", 0, "-1");
        UNKNOWN = r100;
        EventStage r101 = new EventStage("COLLECTED", 1, CustomAlbumViewModel.DEFAULT_TAB_ID);
        COLLECTED = r101;
        EventStage r102 = new EventStage("PARAMS_INVALID_DROP", 2, HiAnalyticsConstant.KeyAndValue.NUMBER_01);
        PARAMS_INVALID_DROP = r102;
        EventStage r103 = new EventStage("NOT_INIT_DROP", 3, "02");
        NOT_INIT_DROP = r103;
        EventStage r104 = new EventStage("PRE_PROCESS_START", 4, "03");
        PRE_PROCESS_START = r104;
        EventStage r105 = new EventStage("CACHED_BEFORE_HANDLE", 5, "04");
        CACHED_BEFORE_HANDLE = r105;
        EventStage r110 = new EventStage("CACHE_DROP_BEFORE_HANDLE", 6, "05");
        CACHE_DROP_BEFORE_HANDLE = r110;
        EventStage r111 = new EventStage("DATA_LIST_ADDED", 7, "06");
        DATA_LIST_ADDED = r111;
        EventStage r112 = new EventStage("PRE_QUEUE_OVERFLOW", 8, "07");
        PRE_QUEUE_OVERFLOW = r112;
        EventStage r113 = new EventStage("PRE_EVENT_BLOCKED", 9, "08");
        PRE_EVENT_BLOCKED = r113;
        EventStage r114 = new EventStage("PRE_PROCESS_END", 10, "0F");
        PRE_PROCESS_END = r114;
        EventStage r106 = new EventStage("PROCESS_START", 11, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        PROCESS_START = r106;
        EventStage r107 = new EventStage("TOURIST_BREAK", 12, "11");
        TOURIST_BREAK = r107;
        EventStage r108 = new EventStage("FILTER_EVENT_BLOCKED", 13, "12");
        FILTER_EVENT_BLOCKED = r108;
        EventStage r109 = new EventStage("FILTER_SERVER_BLOCKED", 14, "13");
        FILTER_SERVER_BLOCKED = r109;
        EventStage r115 = new EventStage("FILTER_CUSTOM_BLOCKED", 15, Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        FILTER_CUSTOM_BLOCKED = r115;
        EventStage r116 = new EventStage("FILTER_SAMPLING_DROPPED", 16, Constants.VIA_REPORT_TYPE_WPA_STATE);
        FILTER_SAMPLING_DROPPED = r116;
        EventStage r117 = new EventStage("NO_SESSION_DROP", 17, Constants.VIA_REPORT_TYPE_START_WAP);
        NO_SESSION_DROP = r117;
        EventStage r118 = new EventStage("PROCESS_END", 18, "1F");
        PROCESS_END = r118;
        EventStage r119 = new EventStage("DB_SAVE_START", 19, "20");
        DB_SAVE_START = r119;
        EventStage r120 = new EventStage("HANDLE_REALTIME_START", 20, "21");
        HANDLE_REALTIME_START = r120;
        EventStage r121 = new EventStage("REALTIME_SEND_START", 21, "22");
        REALTIME_SEND_START = r121;
        EventStage r122 = new EventStage("REALTIME_SEND_FAILED", 22, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        REALTIME_SEND_FAILED = r122;
        EventStage r123 = new EventStage("REALTIME_CRASH_DROP", 23, "24");
        REALTIME_CRASH_DROP = r123;
        EventStage r124 = new EventStage("PRIORITY_HANDLE", 24, "28");
        PRIORITY_HANDLE = r124;
        EventStage r125 = new EventStage("PRIORITY_ACCEPT", 25, "29");
        PRIORITY_ACCEPT = r125;
        EventStage r126 = new EventStage("DB_INSERT_START", 26, "2A");
        DB_INSERT_START = r126;
        EventStage r127 = new EventStage("DB_SAVE_FAILED", 27, "2B");
        DB_SAVE_FAILED = r127;
        EventStage r128 = new EventStage("DB_SAVE_END", 28, "2F");
        DB_SAVE_END = r128;
        EventStage r129 = new EventStage("REPORT_START", 29, BDLocationException.ERROR_SDK_NO_PERMISSION);
        REPORT_START = r129;
        EventStage r130 = new EventStage("PACK_END", 30, "31");
        PACK_END = r130;
        EventStage r131 = new EventStage("PACK_INSERT_START", 31, BDLocationException.ERROR_ABNORMAL_NETWORK);
        PACK_INSERT_START = r131;
        EventStage r132 = new EventStage("PACK_INSERT_FAILED", 32, "35");
        PACK_INSERT_FAILED = r132;
        EventStage r133 = new EventStage("PACK_INSERT_END", 33, BDLocationException.ERROR_BACKGROUND_LOCATE);
        PACK_INSERT_END = r133;
        EventStage r134 = new EventStage("POST_ISOLATE", 34, BDLocationException.ERROR_DISPUTED_AREA);
        POST_ISOLATE = r134;
        EventStage r135 = new EventStage("POST_START", 35, "3A");
        POST_START = r135;
        EventStage r136 = new EventStage("POST_FAILED", 36, "3B");
        POST_FAILED = r136;
        EventStage r137 = new EventStage("REPORT_END", 37, "3F");
        REPORT_END = r137;
        f192495a = new EventStage[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137};
    }

    public static EventStage[] values() {
        return (EventStage[]) f192495a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }

    public static EventStage fromLabel(String r100) {
        EventStage[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        EventStage r104 = r101[r103];
        if (r104.label.equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static EventStage fromName(String r100) {
        return valueOf(r100);
    L5:
        return UNKNOWN;
    }

    public static EventStage valueOf(String r100) {
        return (EventStage) a.a(EventStage.class, r100);
    }

    public EventStage(String r100, int r101, String r102) {
        super(r100, r101);
        this.label = r102;
    }
}
