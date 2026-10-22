package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f94128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f94129b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f94130c = null;

    static {
        int[] r100 = new int[FeedMultiPlayMode.values().length];
        f94128a = r100;
        FeedMultiPlayMode r101 = FeedMultiPlayMode.VOTE;
        r100[r101.ordinal()] = 1;
        FeedMultiPlayMode r102 = FeedMultiPlayMode.PERSONAL_PK;
        r100[r102.ordinal()] = 2;
        FeedMultiPlayMode r103 = FeedMultiPlayMode.TEAM_PK;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[FeedMultiPlayMode.values().length];
        f94129b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[FeedMultiPlayMode.values().length];
        f94130c = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
    }
}
