package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.data.LoadingStatus;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f43228a = null;

    static {
        int[] r100 = new int[LoadingStatus.values().length];
        f43228a = r100;
        r100[LoadingStatus.LOADING.ordinal()] = 1;
        r100[LoadingStatus.SUCCESS.ordinal()] = 2;
        r100[LoadingStatus.ERROR.ordinal()] = 3;
    }
}
