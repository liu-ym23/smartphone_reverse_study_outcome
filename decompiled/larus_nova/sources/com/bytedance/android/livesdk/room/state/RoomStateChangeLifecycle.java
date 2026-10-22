package com.bytedance.android.livesdk.room.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/RoomStateChangeLifecycle;", "", "LIVE_PAGE_ON_VISIBLE", "LIVE_PAGE_ON_IN_VISIBLE", "LIVE_HORIZONTAL_PLAY_EVENT", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomStateChangeLifecycle extends Enum<RoomStateChangeLifecycle> {
    public static final RoomStateChangeLifecycle LIVE_HORIZONTAL_PLAY_EVENT = null;
    public static final RoomStateChangeLifecycle LIVE_PAGE_ON_IN_VISIBLE = null;
    public static final RoomStateChangeLifecycle LIVE_PAGE_ON_VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoomStateChangeLifecycle[] f157821a = null;

    static {
        RoomStateChangeLifecycle r100 = new RoomStateChangeLifecycle("LIVE_PAGE_ON_VISIBLE", 0);
        LIVE_PAGE_ON_VISIBLE = r100;
        RoomStateChangeLifecycle r101 = new RoomStateChangeLifecycle("LIVE_PAGE_ON_IN_VISIBLE", 1);
        LIVE_PAGE_ON_IN_VISIBLE = r101;
        RoomStateChangeLifecycle r102 = new RoomStateChangeLifecycle("LIVE_HORIZONTAL_PLAY_EVENT", 2);
        LIVE_HORIZONTAL_PLAY_EVENT = r102;
        f157821a = new RoomStateChangeLifecycle[]{r100, r101, r102};
    }

    public static RoomStateChangeLifecycle valueOf(String r100) {
        return (RoomStateChangeLifecycle) a.a(RoomStateChangeLifecycle.class, r100);
    }

    public static RoomStateChangeLifecycle[] values() {
        return (RoomStateChangeLifecycle[]) f157821a.clone();
    }

    public RoomStateChangeLifecycle(String r100, int r101) {
        super(r100, r101);
    }
}
