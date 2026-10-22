package com.bytedance.android.shopping.store.mall.follows.basic;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f185602a = null;

    static {
        int[] r100 = new int[LoadStatus.values().length];
        f185602a = r100;
        r100[LoadStatus.LoadMoreEnd.ordinal()] = 1;
        r100[LoadStatus.LoadMoreIn.ordinal()] = 2;
        r100[LoadStatus.LoadMoreError.ordinal()] = 3;
    }
}
