package com.bytedance.android.livesdkapi.roomset;

import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum LiveRoomSetState extends Enum<LiveRoomSetState> {
    private static final /* synthetic */ LiveRoomSetState[] $VALUES = null;
    public static final LiveRoomSetState DETACHED = null;
    public static final LiveRoomSetState IDLE = null;
    public static final LiveRoomSetState INITIALIZED = null;
    public static final LiveRoomSetState LIVE_FINISHED = null;
    public static final LiveRoomSetState LIVE_STARTED = null;
    public static final LiveRoomSetState PREPARED = null;

    static {
        LiveRoomSetState r100 = new LiveRoomSetState("IDLE", 0);
        IDLE = r100;
        LiveRoomSetState r101 = new LiveRoomSetState("INITIALIZED", 1);
        INITIALIZED = r101;
        LiveRoomSetState r102 = new LiveRoomSetState("PREPARED", 2);
        PREPARED = r102;
        LiveRoomSetState r103 = new LiveRoomSetState("LIVE_STARTED", 3);
        LIVE_STARTED = r103;
        LiveRoomSetState r104 = new LiveRoomSetState("LIVE_FINISHED", 4);
        LIVE_FINISHED = r104;
        LiveRoomSetState r105 = new LiveRoomSetState("DETACHED", 5);
        DETACHED = r105;
        $VALUES = new LiveRoomSetState[]{r100, r101, r102, r103, r104, r105};
    }

    public static LiveRoomSetState[] values() {
        return (LiveRoomSetState[]) $VALUES.clone();
    }

    public static LiveRoomSetState valueOf(String r100) {
        return (LiveRoomSetState) a.a(LiveRoomSetState.class, r100);
    }

    private LiveRoomSetState(String r100, int r101) {
        super(r100, r101);
    }
}
