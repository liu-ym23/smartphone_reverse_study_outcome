package com.bytedance.android.shopping.anchorv3.auction;

import com.bytedance.android.ec.core.data.PagingLoadingStatus;

/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f164458a = null;

    static {
        int[] r100 = new int[PagingLoadingStatus.values().length];
        f164458a = r100;
        r100[PagingLoadingStatus.LOADING.ordinal()] = 1;
        r100[PagingLoadingStatus.ERROR.ordinal()] = 2;
        r100[PagingLoadingStatus.SUCCESS.ordinal()] = 3;
        r100[PagingLoadingStatus.END.ordinal()] = 4;
    }
}
