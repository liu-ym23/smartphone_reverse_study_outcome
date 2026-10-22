package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import com.bytedance.android.ec.model.response.PriceDescriptionType;
import com.bytedance.android.ec.model.response.PromotionPriceType;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f150567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f150568b = null;

    static {
        int[] r100 = new int[PriceDescriptionType.values().length];
        f150567a = r100;
        r100[PriceDescriptionType.TEXT.ordinal()] = 1;
        r100[PriceDescriptionType.REGULAR_PRICE.ordinal()] = 2;
        r100[PriceDescriptionType.EXCLUSIVE.ordinal()] = 3;
        int[] r101 = new int[PromotionPriceType.values().length];
        f150568b = r101;
        r101[PromotionPriceType.SHOW_PRICE.ordinal()] = 1;
        r101[PromotionPriceType.COUNT_DOWN.ordinal()] = 2;
        r101[PromotionPriceType.SHOW_TEXT.ordinal()] = 3;
    }
}
