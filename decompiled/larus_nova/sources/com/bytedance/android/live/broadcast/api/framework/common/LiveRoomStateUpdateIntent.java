package com.bytedance.android.live.broadcast.api.framework.common;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveRoomStateUpdateIntent;", "", "", "value", "I", "getValue", "()I", GXAnimation.STATE_START, "PAUSE", "RESUME", "STOP", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomStateUpdateIntent extends Enum<LiveRoomStateUpdateIntent> {
    public static final LiveRoomStateUpdateIntent PAUSE = null;
    public static final LiveRoomStateUpdateIntent RESUME = null;
    public static final LiveRoomStateUpdateIntent START = null;
    public static final LiveRoomStateUpdateIntent STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRoomStateUpdateIntent[] f58988a = null;
    private final int value;

    static {
        LiveRoomStateUpdateIntent r100 = new LiveRoomStateUpdateIntent(GXAnimation.STATE_START, 0, 0);
        START = r100;
        LiveRoomStateUpdateIntent r101 = new LiveRoomStateUpdateIntent("PAUSE", 1, 1);
        PAUSE = r101;
        LiveRoomStateUpdateIntent r102 = new LiveRoomStateUpdateIntent("RESUME", 2, 2);
        RESUME = r102;
        LiveRoomStateUpdateIntent r103 = new LiveRoomStateUpdateIntent("STOP", 3, 3);
        STOP = r103;
        f58988a = new LiveRoomStateUpdateIntent[]{r100, r101, r102, r103};
    }

    public static LiveRoomStateUpdateIntent valueOf(String r100) {
        return (LiveRoomStateUpdateIntent) r27.a.a(LiveRoomStateUpdateIntent.class, r100);
    }

    public static LiveRoomStateUpdateIntent[] values() {
        return (LiveRoomStateUpdateIntent[]) f58988a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRoomStateUpdateIntent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
