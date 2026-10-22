package com.bytedance.android.shopping.collect.custom_view;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f172211a = null;

    static {
        int[] r100 = new int[ECMallFeedState.values().length];
        f172211a = r100;
        r100[ECMallFeedState.INITIALIZING.ordinal()] = 1;
        r100[ECMallFeedState.REFRESHING.ordinal()] = 2;
        r100[ECMallFeedState.INIT_WITH_CACHE_SUCCESS.ordinal()] = 3;
        r100[ECMallFeedState.INIT_SUCCESS.ordinal()] = 4;
        r100[ECMallFeedState.REFRESH_SUCCESS.ordinal()] = 5;
        r100[ECMallFeedState.INIT_FAILED.ordinal()] = 6;
        r100[ECMallFeedState.REFRESH_FAILED.ordinal()] = 7;
    }
}
