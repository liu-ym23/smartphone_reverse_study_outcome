package com.bytedance.android.shopping.store.aggregate.presenter;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f183477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f183478b = null;

    static {
        int[] r100 = new int[LayoutTypes.values().length];
        f183477a = r100;
        LayoutTypes r101 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        r100[r101.ordinal()] = 1;
        LayoutTypes r102 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[LayoutTypes.values().length];
        f183478b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
