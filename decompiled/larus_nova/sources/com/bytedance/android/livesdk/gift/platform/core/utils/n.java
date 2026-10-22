package com.bytedance.android.livesdk.gift.platform.core.utils;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f132054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f132055b = null;

    static {
        int[] r100 = new int[GiftNitaViewInfo.values().length];
        f132054a = r100;
        GiftNitaViewInfo r101 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_FAST_V3;
        r100[r101.ordinal()] = 1;
        GiftNitaViewInfo r102 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3;
        r100[r102.ordinal()] = 2;
        GiftNitaViewInfo r103 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3_PK;
        r100[r103.ordinal()] = 3;
        GiftNitaViewInfo r104 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[GiftNitaViewInfo.values().length];
        f132055b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
    }
}
