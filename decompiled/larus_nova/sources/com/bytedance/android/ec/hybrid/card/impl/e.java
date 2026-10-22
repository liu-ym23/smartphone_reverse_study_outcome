package com.bytedance.android.ec.hybrid.card.impl;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f46529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f46530b = null;

    static {
        int[] r100 = new int[ECLynxLoadType.values().length];
        f46529a = r100;
        ECLynxLoadType r101 = ECLynxLoadType.PRE_CREATE_VIEW;
        r100[r101.ordinal()] = 1;
        ECLynxLoadType r102 = ECLynxLoadType.PRE_LOAD;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ECLynxLoadType.values().length];
        f46530b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
