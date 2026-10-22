package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveAVResourceRole;", "", "", "value", "I", "getValue", "()I", "User", "Business", "RoomState", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAVResourceRole extends Enum<LiveAVResourceRole> {
    public static final LiveAVResourceRole Business = null;
    public static final LiveAVResourceRole RoomState = null;
    public static final LiveAVResourceRole User = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveAVResourceRole[] f58984a = null;
    private final int value;

    static {
        LiveAVResourceRole r100 = new LiveAVResourceRole("User", 0, 0);
        User = r100;
        LiveAVResourceRole r101 = new LiveAVResourceRole("Business", 1, 1);
        Business = r101;
        LiveAVResourceRole r102 = new LiveAVResourceRole("RoomState", 2, 2);
        RoomState = r102;
        f58984a = new LiveAVResourceRole[]{r100, r101, r102};
    }

    public static LiveAVResourceRole valueOf(String r100) {
        return (LiveAVResourceRole) r27.a.a(LiveAVResourceRole.class, r100);
    }

    public static LiveAVResourceRole[] values() {
        return (LiveAVResourceRole[]) f58984a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveAVResourceRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
