package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongSingState;", "", "", "value", "I", "getValue", "()I", "STATE_NOSING", "STATE_SINGING", "STATE_START_SING", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RequestSongSingState extends Enum<RequestSongSingState> {
    public static final RequestSongSingState STATE_NOSING = null;
    public static final RequestSongSingState STATE_SINGING = null;
    public static final RequestSongSingState STATE_START_SING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestSongSingState[] f72290a = null;
    private final int value;

    static {
        RequestSongSingState r100 = new RequestSongSingState("STATE_NOSING", 0, 0);
        STATE_NOSING = r100;
        RequestSongSingState r101 = new RequestSongSingState("STATE_SINGING", 1, 1);
        STATE_SINGING = r101;
        RequestSongSingState r102 = new RequestSongSingState("STATE_START_SING", 2, 2);
        STATE_START_SING = r102;
        f72290a = new RequestSongSingState[]{r100, r101, r102};
    }

    public static RequestSongSingState valueOf(String r100) {
        return (RequestSongSingState) r27.a.a(RequestSongSingState.class, r100);
    }

    public static RequestSongSingState[] values() {
        return (RequestSongSingState[]) f72290a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RequestSongSingState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
