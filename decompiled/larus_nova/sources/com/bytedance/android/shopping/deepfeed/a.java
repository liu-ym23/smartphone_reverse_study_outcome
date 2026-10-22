package com.bytedance.android.shopping.deepfeed;

import com.bytedance.android.shopping.inflow.common.base.LoadStatus;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f173030a = null;

    static {
        int[] r100 = new int[LoadStatus.values().length];
        f173030a = r100;
        r100[LoadStatus.LOADING.ordinal()] = 1;
        r100[LoadStatus.FINISH_NO_MORE.ordinal()] = 2;
        r100[LoadStatus.PACK_ERROR.ordinal()] = 3;
        r100[LoadStatus.FINISH_ERROR.ordinal()] = 4;
    }
}
