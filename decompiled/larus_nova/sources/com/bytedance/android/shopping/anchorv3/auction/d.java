package com.bytedance.android.shopping.anchorv3.auction;

import com.bytedance.android.ec.core.data.LoadingStatus;

/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f164460a = null;

    static {
        int[] r100 = new int[LoadingStatus.values().length];
        f164460a = r100;
        r100[LoadingStatus.LOADING.ordinal()] = 1;
        r100[LoadingStatus.ERROR.ordinal()] = 2;
        r100[LoadingStatus.SUCCESS.ordinal()] = 3;
    }
}
