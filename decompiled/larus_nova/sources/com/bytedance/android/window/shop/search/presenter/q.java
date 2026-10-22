package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f189754a = null;

    static {
        int[] r100 = new int[WindowLoadStatus.values().length];
        f189754a = r100;
        r100[WindowLoadStatus.Initialize.ordinal()] = 1;
        r100[WindowLoadStatus.InitializeSuccess.ordinal()] = 2;
        r100[WindowLoadStatus.InitializeError.ordinal()] = 3;
        r100[WindowLoadStatus.InitializeEmpty.ordinal()] = 4;
    }
}
