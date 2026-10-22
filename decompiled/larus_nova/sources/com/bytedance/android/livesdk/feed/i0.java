package com.bytedance.android.livesdk.feed;

import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f124085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f124086b = null;

    static {
        int[] r100 = new int[BaseFeedRepository.ApiDataStatus.values().length];
        f124085a = r100;
        BaseFeedRepository.ApiDataStatus r101 = BaseFeedRepository.ApiDataStatus.START;
        r100[r101.ordinal()] = 1;
        BaseFeedRepository.ApiDataStatus r102 = BaseFeedRepository.ApiDataStatus.SUCCESS;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[BaseFeedRepository.ApiDataStatus.values().length];
        f124086b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
