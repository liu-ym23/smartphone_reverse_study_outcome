package com.bytedance.android.livesdk.chatroom.vs_base.base.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/model/ReplayRoomState;", "", "IDLE", "INITIALIZED", "PREPARING", "PREPARING_WITH_PRE_SHOW", "PREPARED", "VIDEO_STARTED", "VIDEO_FINISHED", "DETACHED", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayRoomState extends Enum<ReplayRoomState> {
    public static final ReplayRoomState DETACHED = null;
    public static final ReplayRoomState IDLE = null;
    public static final ReplayRoomState INITIALIZED = null;
    public static final ReplayRoomState PREPARED = null;
    public static final ReplayRoomState PREPARING = null;
    public static final ReplayRoomState PREPARING_WITH_PRE_SHOW = null;
    public static final ReplayRoomState VIDEO_FINISHED = null;
    public static final ReplayRoomState VIDEO_STARTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayRoomState[] f117896a = null;

    static {
        ReplayRoomState r100 = new ReplayRoomState("IDLE", 0);
        IDLE = r100;
        ReplayRoomState r101 = new ReplayRoomState("INITIALIZED", 1);
        INITIALIZED = r101;
        ReplayRoomState r102 = new ReplayRoomState("PREPARING", 2);
        PREPARING = r102;
        ReplayRoomState r103 = new ReplayRoomState("PREPARING_WITH_PRE_SHOW", 3);
        PREPARING_WITH_PRE_SHOW = r103;
        ReplayRoomState r104 = new ReplayRoomState("PREPARED", 4);
        PREPARED = r104;
        ReplayRoomState r105 = new ReplayRoomState("VIDEO_STARTED", 5);
        VIDEO_STARTED = r105;
        ReplayRoomState r106 = new ReplayRoomState("VIDEO_FINISHED", 6);
        VIDEO_FINISHED = r106;
        ReplayRoomState r107 = new ReplayRoomState("DETACHED", 7);
        DETACHED = r107;
        f117896a = new ReplayRoomState[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static ReplayRoomState valueOf(String r100) {
        return (ReplayRoomState) a.a(ReplayRoomState.class, r100);
    }

    public static ReplayRoomState[] values() {
        return (ReplayRoomState[]) f117896a.clone();
    }

    public ReplayRoomState(String r100, int r101) {
        super(r100, r101);
    }
}
