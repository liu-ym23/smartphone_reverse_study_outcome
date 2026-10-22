package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveRoomStateUpdateEvent;", "", "", "value", "I", "getValue", "()I", "User", "Business", "RoomCovered", "RoomUncovered", "AppInactive", "AppActive", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomStateUpdateEvent extends Enum<LiveRoomStateUpdateEvent> {
    public static final LiveRoomStateUpdateEvent AppActive = null;
    public static final LiveRoomStateUpdateEvent AppInactive = null;
    public static final LiveRoomStateUpdateEvent Business = null;
    public static final LiveRoomStateUpdateEvent RoomCovered = null;
    public static final LiveRoomStateUpdateEvent RoomUncovered = null;
    public static final LiveRoomStateUpdateEvent User = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRoomStateUpdateEvent[] f58987a = null;
    private final int value;

    static {
        LiveRoomStateUpdateEvent r100 = new LiveRoomStateUpdateEvent("User", 0, 0);
        User = r100;
        LiveRoomStateUpdateEvent r101 = new LiveRoomStateUpdateEvent("Business", 1, 1);
        Business = r101;
        LiveRoomStateUpdateEvent r102 = new LiveRoomStateUpdateEvent("RoomCovered", 2, 2);
        RoomCovered = r102;
        LiveRoomStateUpdateEvent r103 = new LiveRoomStateUpdateEvent("RoomUncovered", 3, 3);
        RoomUncovered = r103;
        LiveRoomStateUpdateEvent r104 = new LiveRoomStateUpdateEvent("AppInactive", 4, 4);
        AppInactive = r104;
        LiveRoomStateUpdateEvent r105 = new LiveRoomStateUpdateEvent("AppActive", 5, 5);
        AppActive = r105;
        f58987a = new LiveRoomStateUpdateEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static LiveRoomStateUpdateEvent valueOf(String r100) {
        return (LiveRoomStateUpdateEvent) r27.a.a(LiveRoomStateUpdateEvent.class, r100);
    }

    public static LiveRoomStateUpdateEvent[] values() {
        return (LiveRoomStateUpdateEvent[]) f58987a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRoomStateUpdateEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
