package com.bytedance.android.live.revenue.platform.container.impl.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyRoomStateRequestState;", "", "", "tag", "I", "getTag", "()I", "UNKNOWN", "ENTERED", "COMPONENTS_LOADED", "PRE_ENTERED", "LEFT", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NotifyRoomStateRequestState extends Enum<NotifyRoomStateRequestState> {
    public static final NotifyRoomStateRequestState COMPONENTS_LOADED = null;
    public static final NotifyRoomStateRequestState ENTERED = null;
    public static final NotifyRoomStateRequestState LEFT = null;
    public static final NotifyRoomStateRequestState PRE_ENTERED = null;
    public static final NotifyRoomStateRequestState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotifyRoomStateRequestState[] f91178a = null;
    private final int tag;

    static {
        NotifyRoomStateRequestState r100 = new NotifyRoomStateRequestState("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        NotifyRoomStateRequestState r101 = new NotifyRoomStateRequestState("ENTERED", 1, 1);
        ENTERED = r101;
        NotifyRoomStateRequestState r102 = new NotifyRoomStateRequestState("COMPONENTS_LOADED", 2, 3);
        COMPONENTS_LOADED = r102;
        NotifyRoomStateRequestState r103 = new NotifyRoomStateRequestState("PRE_ENTERED", 3, 4);
        PRE_ENTERED = r103;
        NotifyRoomStateRequestState r104 = new NotifyRoomStateRequestState("LEFT", 4, 20);
        LEFT = r104;
        f91178a = new NotifyRoomStateRequestState[]{r100, r101, r102, r103, r104};
    }

    public static NotifyRoomStateRequestState valueOf(String r100) {
        return (NotifyRoomStateRequestState) r27.a.a(NotifyRoomStateRequestState.class, r100);
    }

    public static NotifyRoomStateRequestState[] values() {
        return (NotifyRoomStateRequestState[]) f91178a.clone();
    }

    public final int getTag() {
        return this.tag;
    }

    public NotifyRoomStateRequestState(String r100, int r101, int r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
