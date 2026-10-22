package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f177207a = null;

    static {
        int[] r100 = new int[ECMallFeedState.values().length];
        f177207a = r100;
        r100[ECMallFeedState.PREPARING.ordinal()] = 1;
        r100[ECMallFeedState.INIT_SUCCESS.ordinal()] = 2;
        r100[ECMallFeedState.PREPARE_FAILED.ordinal()] = 3;
        r100[ECMallFeedState.INIT_FAILED.ordinal()] = 4;
        r100[ECMallFeedState.REFRESHING.ordinal()] = 5;
        r100[ECMallFeedState.REFRESH_SUCCESS.ordinal()] = 6;
    }
}
