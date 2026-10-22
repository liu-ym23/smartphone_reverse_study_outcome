package com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/feed/viewstate/FeedMultiPlayMode;", "", "PERSONAL_PK", "TEAM_PK", "VOTE", "BREAK_THROUGH", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FeedMultiPlayMode extends Enum<FeedMultiPlayMode> {
    public static final FeedMultiPlayMode BREAK_THROUGH = null;
    public static final FeedMultiPlayMode PERSONAL_PK = null;
    public static final FeedMultiPlayMode TEAM_PK = null;
    public static final FeedMultiPlayMode VOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedMultiPlayMode[] f94276a = null;

    static {
        FeedMultiPlayMode r100 = new FeedMultiPlayMode("PERSONAL_PK", 0);
        PERSONAL_PK = r100;
        FeedMultiPlayMode r101 = new FeedMultiPlayMode("TEAM_PK", 1);
        TEAM_PK = r101;
        FeedMultiPlayMode r102 = new FeedMultiPlayMode("VOTE", 2);
        VOTE = r102;
        FeedMultiPlayMode r103 = new FeedMultiPlayMode("BREAK_THROUGH", 3);
        BREAK_THROUGH = r103;
        f94276a = new FeedMultiPlayMode[]{r100, r101, r102, r103};
    }

    public static FeedMultiPlayMode valueOf(String r100) {
        return (FeedMultiPlayMode) r27.a.a(FeedMultiPlayMode.class, r100);
    }

    public static FeedMultiPlayMode[] values() {
        return (FeedMultiPlayMode[]) f94276a.clone();
    }

    public FeedMultiPlayMode(String r100, int r101) {
        super(r100, r101);
    }
}
