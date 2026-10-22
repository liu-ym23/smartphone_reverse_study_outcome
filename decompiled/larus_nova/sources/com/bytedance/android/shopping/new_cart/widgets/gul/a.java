package com.bytedance.android.shopping.new_cart.widgets.gul;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f179483a = null;

    static {
        int[] r100 = new int[ECMallFeedState.values().length];
        f179483a = r100;
        r100[ECMallFeedState.INITIALIZING.ordinal()] = 1;
        r100[ECMallFeedState.REFRESHING.ordinal()] = 2;
        r100[ECMallFeedState.INIT_WITH_CACHE_SUCCESS.ordinal()] = 3;
        r100[ECMallFeedState.INIT_SUCCESS.ordinal()] = 4;
        r100[ECMallFeedState.REFRESH_SUCCESS.ordinal()] = 5;
        r100[ECMallFeedState.INIT_FAILED.ordinal()] = 6;
        r100[ECMallFeedState.REFRESH_FAILED.ordinal()] = 7;
    }
}
