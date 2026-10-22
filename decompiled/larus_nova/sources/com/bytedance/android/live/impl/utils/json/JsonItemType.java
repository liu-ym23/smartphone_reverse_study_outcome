package com.bytedance.android.live.impl.utils.json;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemType;", "", "STALL_ITEM", "ENTER_ROOM_DURATION_ITEM", "WATCH_ROOM_PV_ITEM", "WATCH_HOTROOM_PV_ITEM", "STALL_ROOM_SENSITIVITY", "STALL_LIVE_SENSITIVITY", "PREVIEW_SHOW_PV_ITEM", "PREVIEW_CLICK_PV_ITEM", "DEFINITION_ITEM", "WATCH_LIVE_DATE_ITEM", "GIFT_SHOW_DATE_ITEM", "FIRST_FRAME_LOAD_DURATION_ITEM", "MINI_WINDOW_LOAD_DURATION_ITEM", "MINI_WINDOW_SHOW_DURATION_ITEM", "FIRST_ROOM_PERFORMANCE_DATA_ITEM", "START_LIVE_COUNT_ITEM", "RESTART_LIVE_ALERT_SHOW_REASON_3_COUNT_ITEM", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum JsonItemType extends Enum<JsonItemType> {
    public static final JsonItemType DEFINITION_ITEM = null;
    public static final JsonItemType ENTER_ROOM_DURATION_ITEM = null;
    public static final JsonItemType FIRST_FRAME_LOAD_DURATION_ITEM = null;
    public static final JsonItemType FIRST_ROOM_PERFORMANCE_DATA_ITEM = null;
    public static final JsonItemType GIFT_SHOW_DATE_ITEM = null;
    public static final JsonItemType MINI_WINDOW_LOAD_DURATION_ITEM = null;
    public static final JsonItemType MINI_WINDOW_SHOW_DURATION_ITEM = null;
    public static final JsonItemType PREVIEW_CLICK_PV_ITEM = null;
    public static final JsonItemType PREVIEW_SHOW_PV_ITEM = null;
    public static final JsonItemType RESTART_LIVE_ALERT_SHOW_REASON_3_COUNT_ITEM = null;
    public static final JsonItemType STALL_ITEM = null;
    public static final JsonItemType STALL_LIVE_SENSITIVITY = null;
    public static final JsonItemType STALL_ROOM_SENSITIVITY = null;
    public static final JsonItemType START_LIVE_COUNT_ITEM = null;
    public static final JsonItemType WATCH_HOTROOM_PV_ITEM = null;
    public static final JsonItemType WATCH_LIVE_DATE_ITEM = null;
    public static final JsonItemType WATCH_ROOM_PV_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsonItemType[] f69323a = null;

    static {
        JsonItemType r100 = new JsonItemType("STALL_ITEM", 0);
        STALL_ITEM = r100;
        JsonItemType r101 = new JsonItemType("ENTER_ROOM_DURATION_ITEM", 1);
        ENTER_ROOM_DURATION_ITEM = r101;
        JsonItemType r102 = new JsonItemType("WATCH_ROOM_PV_ITEM", 2);
        WATCH_ROOM_PV_ITEM = r102;
        JsonItemType r103 = new JsonItemType("WATCH_HOTROOM_PV_ITEM", 3);
        WATCH_HOTROOM_PV_ITEM = r103;
        JsonItemType r104 = new JsonItemType("STALL_ROOM_SENSITIVITY", 4);
        STALL_ROOM_SENSITIVITY = r104;
        JsonItemType r105 = new JsonItemType("STALL_LIVE_SENSITIVITY", 5);
        STALL_LIVE_SENSITIVITY = r105;
        JsonItemType r106 = new JsonItemType("PREVIEW_SHOW_PV_ITEM", 6);
        PREVIEW_SHOW_PV_ITEM = r106;
        JsonItemType r107 = new JsonItemType("PREVIEW_CLICK_PV_ITEM", 7);
        PREVIEW_CLICK_PV_ITEM = r107;
        JsonItemType r108 = new JsonItemType("DEFINITION_ITEM", 8);
        DEFINITION_ITEM = r108;
        JsonItemType r109 = new JsonItemType("WATCH_LIVE_DATE_ITEM", 9);
        WATCH_LIVE_DATE_ITEM = r109;
        JsonItemType r110 = new JsonItemType("GIFT_SHOW_DATE_ITEM", 10);
        GIFT_SHOW_DATE_ITEM = r110;
        JsonItemType r111 = new JsonItemType("FIRST_FRAME_LOAD_DURATION_ITEM", 11);
        FIRST_FRAME_LOAD_DURATION_ITEM = r111;
        JsonItemType r112 = new JsonItemType("MINI_WINDOW_LOAD_DURATION_ITEM", 12);
        MINI_WINDOW_LOAD_DURATION_ITEM = r112;
        JsonItemType r113 = new JsonItemType("MINI_WINDOW_SHOW_DURATION_ITEM", 13);
        MINI_WINDOW_SHOW_DURATION_ITEM = r113;
        JsonItemType r114 = new JsonItemType("FIRST_ROOM_PERFORMANCE_DATA_ITEM", 14);
        FIRST_ROOM_PERFORMANCE_DATA_ITEM = r114;
        JsonItemType r115 = new JsonItemType("START_LIVE_COUNT_ITEM", 15);
        START_LIVE_COUNT_ITEM = r115;
        JsonItemType r116 = new JsonItemType("RESTART_LIVE_ALERT_SHOW_REASON_3_COUNT_ITEM", 16);
        RESTART_LIVE_ALERT_SHOW_REASON_3_COUNT_ITEM = r116;
        f69323a = new JsonItemType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
    }

    public static JsonItemType valueOf(String r100) {
        return (JsonItemType) r27.a.a(JsonItemType.class, r100);
    }

    public static JsonItemType[] values() {
        return (JsonItemType[]) f69323a.clone();
    }

    public JsonItemType(String r100, int r101) {
        super(r100, r101);
    }
}
