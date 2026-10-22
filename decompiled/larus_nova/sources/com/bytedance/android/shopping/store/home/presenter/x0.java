package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f184455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f184456b = null;

    static {
        int[] r100 = new int[LoadStatus.values().length];
        f184455a = r100;
        LoadStatus r101 = LoadStatus.Initialize;
        r100[r101.ordinal()] = 1;
        LoadStatus r102 = LoadStatus.InitializeSuccess;
        r100[r102.ordinal()] = 2;
        LoadStatus r103 = LoadStatus.InitializeError;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[LoadStatus.values().length];
        f184456b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
