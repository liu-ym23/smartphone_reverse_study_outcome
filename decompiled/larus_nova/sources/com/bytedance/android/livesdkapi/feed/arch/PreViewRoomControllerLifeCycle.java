package com.bytedance.android.livesdkapi.feed.arch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/arch/PreViewRoomControllerLifeCycle;", "", "(Ljava/lang/String;I)V", "PREVIEW_VIEW_HOLDER_ON_BIND_START", "PREVIEW_VIEW_HOLDER_ON_BIND_END", "PREVIEW_INJECT_HANDLE_FUN", "PREVIEW_VIEW_HOLDER_UN_BIND", "PREVIEW_VIEW_HOLDER_SELECT", "PREVIEW_VIEW_HOLDER_UN_SELECT", "PREVIEW_VIEW_HOLDER_START_VIEW", "PREVIEW_VIEW_HOLDER_ON_PAUSE", "PREVIEW_MESSAGE_CAN_LISTENER", "PREVIEW_SPECIFIC_BEHAVIOR_LOAD", "PREVIEW_SPECIFIC_WIDGET_LOADED", "PREVIEW_SPECIFIC_BEHAVIOR_UN_LOAD", "CLEAR_ROOM_CONTROLLER", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreViewRoomControllerLifeCycle extends Enum<PreViewRoomControllerLifeCycle> {
    private static final /* synthetic */ PreViewRoomControllerLifeCycle[] $VALUES = null;
    public static final PreViewRoomControllerLifeCycle CLEAR_ROOM_CONTROLLER = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_INJECT_HANDLE_FUN = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_MESSAGE_CAN_LISTENER = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_SPECIFIC_BEHAVIOR_LOAD = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_SPECIFIC_BEHAVIOR_UN_LOAD = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_SPECIFIC_WIDGET_LOADED = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_ON_BIND_END = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_ON_BIND_START = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_ON_PAUSE = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_SELECT = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_START_VIEW = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_UN_BIND = null;
    public static final PreViewRoomControllerLifeCycle PREVIEW_VIEW_HOLDER_UN_SELECT = null;

    static {
        PreViewRoomControllerLifeCycle r100 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_ON_BIND_START", 0);
        PREVIEW_VIEW_HOLDER_ON_BIND_START = r100;
        PreViewRoomControllerLifeCycle r101 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_ON_BIND_END", 1);
        PREVIEW_VIEW_HOLDER_ON_BIND_END = r101;
        PreViewRoomControllerLifeCycle r102 = new PreViewRoomControllerLifeCycle("PREVIEW_INJECT_HANDLE_FUN", 2);
        PREVIEW_INJECT_HANDLE_FUN = r102;
        PreViewRoomControllerLifeCycle r103 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_UN_BIND", 3);
        PREVIEW_VIEW_HOLDER_UN_BIND = r103;
        PreViewRoomControllerLifeCycle r104 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_SELECT", 4);
        PREVIEW_VIEW_HOLDER_SELECT = r104;
        PreViewRoomControllerLifeCycle r105 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_UN_SELECT", 5);
        PREVIEW_VIEW_HOLDER_UN_SELECT = r105;
        PreViewRoomControllerLifeCycle r106 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_START_VIEW", 6);
        PREVIEW_VIEW_HOLDER_START_VIEW = r106;
        PreViewRoomControllerLifeCycle r107 = new PreViewRoomControllerLifeCycle("PREVIEW_VIEW_HOLDER_ON_PAUSE", 7);
        PREVIEW_VIEW_HOLDER_ON_PAUSE = r107;
        PreViewRoomControllerLifeCycle r108 = new PreViewRoomControllerLifeCycle("PREVIEW_MESSAGE_CAN_LISTENER", 8);
        PREVIEW_MESSAGE_CAN_LISTENER = r108;
        PreViewRoomControllerLifeCycle r109 = new PreViewRoomControllerLifeCycle("PREVIEW_SPECIFIC_BEHAVIOR_LOAD", 9);
        PREVIEW_SPECIFIC_BEHAVIOR_LOAD = r109;
        PreViewRoomControllerLifeCycle r110 = new PreViewRoomControllerLifeCycle("PREVIEW_SPECIFIC_WIDGET_LOADED", 10);
        PREVIEW_SPECIFIC_WIDGET_LOADED = r110;
        PreViewRoomControllerLifeCycle r111 = new PreViewRoomControllerLifeCycle("PREVIEW_SPECIFIC_BEHAVIOR_UN_LOAD", 11);
        PREVIEW_SPECIFIC_BEHAVIOR_UN_LOAD = r111;
        PreViewRoomControllerLifeCycle r112 = new PreViewRoomControllerLifeCycle("CLEAR_ROOM_CONTROLLER", 12);
        CLEAR_ROOM_CONTROLLER = r112;
        $VALUES = new PreViewRoomControllerLifeCycle[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static PreViewRoomControllerLifeCycle valueOf(String r100) {
        return (PreViewRoomControllerLifeCycle) a.a(PreViewRoomControllerLifeCycle.class, r100);
    }

    public static PreViewRoomControllerLifeCycle[] values() {
        return (PreViewRoomControllerLifeCycle[]) $VALUES.clone();
    }

    private PreViewRoomControllerLifeCycle(String r100, int r101) {
        super(r100, r101);
    }
}
