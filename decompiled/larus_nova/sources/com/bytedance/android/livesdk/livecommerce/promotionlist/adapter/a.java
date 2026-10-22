package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f150868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f150869b = null;

    static {
        int[] r100 = new int[PageListLoadStatus.values().length];
        f150868a = r100;
        PageListLoadStatus r101 = PageListLoadStatus.LoadMoreIn;
        r100[r101.ordinal()] = 1;
        PageListLoadStatus r102 = PageListLoadStatus.LoadMoreError;
        r100[r102.ordinal()] = 2;
        PageListLoadStatus r103 = PageListLoadStatus.LoadMoreEnd;
        r100[r103.ordinal()] = 3;
        PageListLoadStatus r104 = PageListLoadStatus.LoadMoreSuccess;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[PageListLoadStatus.values().length];
        f150869b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
    }
}
