package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f186111a = null;

    static {
        int[] r100 = new int[LoadStatus.values().length];
        f186111a = r100;
        r100[LoadStatus.Initialize.ordinal()] = 1;
        r100[LoadStatus.InitializeSuccess.ordinal()] = 2;
        r100[LoadStatus.InitializeError.ordinal()] = 3;
        r100[LoadStatus.InitializeEmpty.ordinal()] = 4;
    }
}
