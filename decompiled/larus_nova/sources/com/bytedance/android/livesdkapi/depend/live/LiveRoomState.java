package com.bytedance.android.livesdkapi.depend.live;

import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum LiveRoomState extends Enum<LiveRoomState> {
    private static final /* synthetic */ LiveRoomState[] $VALUES = null;
    public static final LiveRoomState DETACHED = null;
    public static final LiveRoomState IDLE = null;
    public static final LiveRoomState INITIALIZED = null;
    public static final LiveRoomState LIVE_FINISHED = null;
    public static final LiveRoomState LIVE_STARTED = null;
    public static final LiveRoomState PREPARED = null;
    public static final LiveRoomState PREPARING = null;
    public static final LiveRoomState PREPARING_WITH_PRE_SHOW = null;

    static {
        LiveRoomState r100 = new LiveRoomState("IDLE", 0);
        IDLE = r100;
        LiveRoomState r101 = new LiveRoomState("INITIALIZED", 1);
        INITIALIZED = r101;
        LiveRoomState r102 = new LiveRoomState("PREPARING", 2);
        PREPARING = r102;
        LiveRoomState r103 = new LiveRoomState("PREPARING_WITH_PRE_SHOW", 3);
        PREPARING_WITH_PRE_SHOW = r103;
        LiveRoomState r104 = new LiveRoomState("PREPARED", 4);
        PREPARED = r104;
        LiveRoomState r105 = new LiveRoomState("LIVE_STARTED", 5);
        LIVE_STARTED = r105;
        LiveRoomState r110 = new LiveRoomState("LIVE_FINISHED", 6);
        LIVE_FINISHED = r110;
        LiveRoomState r111 = new LiveRoomState("DETACHED", 7);
        DETACHED = r111;
        $VALUES = new LiveRoomState[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static LiveRoomState[] values() {
        return (LiveRoomState[]) $VALUES.clone();
    }

    public static LiveRoomState valueOf(String r100) {
        return (LiveRoomState) a.a(LiveRoomState.class, r100);
    }

    private LiveRoomState(String r100, int r101) {
        super(r100, r101);
    }
}
