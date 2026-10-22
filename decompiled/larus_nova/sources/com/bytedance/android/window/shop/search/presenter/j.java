package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f189745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f189746b = null;

    static {
        int[] r100 = new int[WindowLayoutTypes.values().length];
        f189745a = r100;
        WindowLayoutTypes r101 = WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        r100[r101.ordinal()] = 1;
        WindowLayoutTypes r102 = WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[WindowLayoutTypes.values().length];
        f189746b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
