package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerLiveFollowStatus;", "", "", "value", "J", "getValue", "()J", CheckStatus.FAIL, "UnFollow", "Followed", "FollowingFollowed", "BeenFollowed", "UnDefined", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerLiveFollowStatus extends Enum<LiveDrawerLiveFollowStatus> {
    public static final LiveDrawerLiveFollowStatus BeenFollowed = null;
    public static final LiveDrawerLiveFollowStatus Fail = null;
    public static final LiveDrawerLiveFollowStatus Followed = null;
    public static final LiveDrawerLiveFollowStatus FollowingFollowed = null;
    public static final LiveDrawerLiveFollowStatus UnDefined = null;
    public static final LiveDrawerLiveFollowStatus UnFollow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerLiveFollowStatus[] f122500a = null;
    private final long value;

    static {
        LiveDrawerLiveFollowStatus r100 = new LiveDrawerLiveFollowStatus(CheckStatus.FAIL, 0, -1);
        Fail = r100;
        LiveDrawerLiveFollowStatus r101 = new LiveDrawerLiveFollowStatus("UnFollow", 1, 0);
        UnFollow = r101;
        LiveDrawerLiveFollowStatus r102 = new LiveDrawerLiveFollowStatus("Followed", 2, 1);
        Followed = r102;
        LiveDrawerLiveFollowStatus r103 = new LiveDrawerLiveFollowStatus("FollowingFollowed", 3, 2);
        FollowingFollowed = r103;
        LiveDrawerLiveFollowStatus r104 = new LiveDrawerLiveFollowStatus("BeenFollowed", 4, 3);
        BeenFollowed = r104;
        LiveDrawerLiveFollowStatus r105 = new LiveDrawerLiveFollowStatus("UnDefined", 5, 4);
        UnDefined = r105;
        f122500a = new LiveDrawerLiveFollowStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static LiveDrawerLiveFollowStatus valueOf(String r100) {
        return (LiveDrawerLiveFollowStatus) r27.a.a(LiveDrawerLiveFollowStatus.class, r100);
    }

    public static LiveDrawerLiveFollowStatus[] values() {
        return (LiveDrawerLiveFollowStatus[]) f122500a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerLiveFollowStatus(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
