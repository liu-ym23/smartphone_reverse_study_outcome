package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f184823a = null;

    static {
        int[] r100 = new int[LoadStatus.values().length];
        f184823a = r100;
        r100[LoadStatus.Initialize.ordinal()] = 1;
        r100[LoadStatus.InitializeSuccess.ordinal()] = 2;
        r100[LoadStatus.InitializeError.ordinal()] = 3;
    }
}
