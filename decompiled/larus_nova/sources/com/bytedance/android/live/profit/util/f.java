package com.bytedance.android.live.profit.util;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f89094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f89095b = null;

    static {
        int[] r100 = new int[ProfitNitaViewInfo.values().length];
        f89094a = r100;
        ProfitNitaViewInfo r101 = ProfitNitaViewInfo.TTLIVE_VIEW_USER_INFO_MVI_FOLLOW;
        r100[r101.ordinal()] = 1;
        ProfitNitaViewInfo r102 = ProfitNitaViewInfo.TTLIVE_VIEW_USER_INFO_MVI_FOLLOW_VSSYTLE;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ProfitNitaViewInfo.values().length];
        f89095b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
