package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f168376a = null;

    static {
        int[] r100 = new int[ECMallFeedState.values().length];
        f168376a = r100;
        r100[ECMallFeedState.INIT_FAILED.ordinal()] = 1;
        r100[ECMallFeedState.INITIALIZING.ordinal()] = 2;
        r100[ECMallFeedState.INIT_DATA_PREPARED.ordinal()] = 3;
        r100[ECMallFeedState.INIT_WITH_CACHE_SUCCESS.ordinal()] = 4;
        r100[ECMallFeedState.INIT_SUCCESS.ordinal()] = 5;
    }
}
