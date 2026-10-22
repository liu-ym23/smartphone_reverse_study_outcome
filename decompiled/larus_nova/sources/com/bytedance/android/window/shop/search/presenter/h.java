package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f189742a = null;

    static {
        int[] r100 = new int[WindowLoadStatus.values().length];
        f189742a = r100;
        r100[WindowLoadStatus.LoadMoreEnd.ordinal()] = 1;
        r100[WindowLoadStatus.LoadMoreIn.ordinal()] = 2;
        r100[WindowLoadStatus.LoadMoreError.ordinal()] = 3;
    }
}
