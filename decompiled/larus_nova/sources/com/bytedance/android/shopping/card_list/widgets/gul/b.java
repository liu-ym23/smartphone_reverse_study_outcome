package com.bytedance.android.shopping.card_list.widgets.gul;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f171955a = null;

    static {
        int[] r100 = new int[ECMallFeedState.values().length];
        f171955a = r100;
        r100[ECMallFeedState.INITIALIZING.ordinal()] = 1;
        r100[ECMallFeedState.REFRESHING.ordinal()] = 2;
        r100[ECMallFeedState.INIT_WITH_CACHE_SUCCESS.ordinal()] = 3;
        r100[ECMallFeedState.INIT_SUCCESS.ordinal()] = 4;
        r100[ECMallFeedState.REFRESH_SUCCESS.ordinal()] = 5;
        r100[ECMallFeedState.INIT_FAILED.ordinal()] = 6;
        r100[ECMallFeedState.REFRESH_FAILED.ordinal()] = 7;
    }
}
