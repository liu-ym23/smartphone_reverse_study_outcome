package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerLiveFeedTabLayoutStyle;", "", "", "value", "J", "getValue", "()J", "SingleFlow", "DoubleFlow", "InnerFlow", "BigAnd2nSmall", "InnerBanner", "MoreTab", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerLiveFeedTabLayoutStyle extends Enum<LiveDrawerLiveFeedTabLayoutStyle> {
    public static final LiveDrawerLiveFeedTabLayoutStyle BigAnd2nSmall = null;
    public static final LiveDrawerLiveFeedTabLayoutStyle DoubleFlow = null;
    public static final LiveDrawerLiveFeedTabLayoutStyle InnerBanner = null;
    public static final LiveDrawerLiveFeedTabLayoutStyle InnerFlow = null;
    public static final LiveDrawerLiveFeedTabLayoutStyle MoreTab = null;
    public static final LiveDrawerLiveFeedTabLayoutStyle SingleFlow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerLiveFeedTabLayoutStyle[] f122498a = null;
    private final long value;

    static {
        LiveDrawerLiveFeedTabLayoutStyle r100 = new LiveDrawerLiveFeedTabLayoutStyle("SingleFlow", 0, 1);
        SingleFlow = r100;
        LiveDrawerLiveFeedTabLayoutStyle r101 = new LiveDrawerLiveFeedTabLayoutStyle("DoubleFlow", 1, 2);
        DoubleFlow = r101;
        LiveDrawerLiveFeedTabLayoutStyle r102 = new LiveDrawerLiveFeedTabLayoutStyle("InnerFlow", 2, 3);
        InnerFlow = r102;
        LiveDrawerLiveFeedTabLayoutStyle r103 = new LiveDrawerLiveFeedTabLayoutStyle("BigAnd2nSmall", 3, 4);
        BigAnd2nSmall = r103;
        LiveDrawerLiveFeedTabLayoutStyle r104 = new LiveDrawerLiveFeedTabLayoutStyle("InnerBanner", 4, 5);
        InnerBanner = r104;
        LiveDrawerLiveFeedTabLayoutStyle r105 = new LiveDrawerLiveFeedTabLayoutStyle("MoreTab", 5, 6);
        MoreTab = r105;
        f122498a = new LiveDrawerLiveFeedTabLayoutStyle[]{r100, r101, r102, r103, r104, r105};
    }

    public static LiveDrawerLiveFeedTabLayoutStyle valueOf(String r100) {
        return (LiveDrawerLiveFeedTabLayoutStyle) r27.a.a(LiveDrawerLiveFeedTabLayoutStyle.class, r100);
    }

    public static LiveDrawerLiveFeedTabLayoutStyle[] values() {
        return (LiveDrawerLiveFeedTabLayoutStyle[]) f122498a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerLiveFeedTabLayoutStyle(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
