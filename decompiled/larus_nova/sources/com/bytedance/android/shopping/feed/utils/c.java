package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionGroupBuyPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionIPActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSeckillPrice;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175441a = 0;

    public c() {
    }

    static {
    }

    public static PromotionDiscountPrice b(PromotionProductPriceStruct r100) {
        if (r100 == null) goto L6;
        PromotionDiscountPrice r101 = r100.getDiscountPrice();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new PromotionDiscountPrice(null, null, null, null, 15, null);
    }

    public static Long c(PromotionProductPriceStruct r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getRegularPrice();
    }

    public static Long d(PromotionProductPriceStruct r100) {
        Long r101 = c(r100);
        Long r102 = b(r100).getMinPrice();
        Long r103 = e(r100);
        if (r101 != null) goto L5;
    L7:
        r101 = null;
    L8:
        if (r102 != null) goto L10;
    L14:
        if (r103 != null) goto L16;
        return r101;
    L16:
        if (r103.longValue() <= 0) goto L22;
        if (r101 == null) goto L20;
        r103 = Long.valueOf(Math.min(r101.longValue(), r103.longValue()));
    L20:
        return r103;
    L22:
        return r101;
    L10:
        if (r102.longValue() <= 0) goto L14;
        if (r101 == null) goto L13;
        r102 = Long.valueOf(Math.min(r102.longValue(), r101.longValue()));
    L13:
        r101 = r102;
        goto L14
    L5:
        if (r101.longValue() <= 0) goto L7;
        goto L7
    }

    public static Long e(PromotionProductPriceStruct r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getMinPrice();
    }

    public static long f(PromotionProductPriceStruct r100) {
        Long r101 = null;
        if (r100 == null) goto L7;
        PromotionDiscountPrice r102 = r100.getDiscountPrice();
        if (r102 == null) goto L7;
        Long r103 = r102.getMinPrice();
    L8:
        if (r103 == null) goto L13;
        if (r100 == null) goto L15;
        PromotionDiscountPrice r104 = r100.getDiscountPrice();
        if (r104 == null) goto L15;
        r101 = r104.getMinPrice();
    L15:
        if (r101 != null) goto L19;
        return 0;
    L19:
        return r101.longValue();
    L13:
        if (r100 == null) goto L15;
        r101 = r100.getMinPrice();
    L7:
        r103 = null;
        goto L8
    }

    public static long g(PromotionProductPriceStruct r100) {
        if (r100 == null) goto L8;
        PromotionDiscountPrice r101 = r100.getDiscountPrice();
        if (r101 == null) goto L8;
        Long r102 = r101.getMaxPrice();
        if (r102 == null) goto L8;
        return r102.longValue();
    L8:
        return 0;
    }

    public static long j(PromotionProductPriceStruct r100) {
        if (r100 == null) goto L8;
        PromotionDiscountPrice r101 = r100.getDiscountPrice();
        if (r101 == null) goto L8;
        Long r102 = r101.getMinPrice();
        if (r102 == null) goto L8;
        return r102.longValue();
    L8:
        return 0;
    }

    public static long k(PromotionProductPriceStruct r100) {
        Long r101 = null;
        if (r100 == null) goto L5;
        Long r102 = r100.getRegularPrice();
    L6:
        if (r102 == null) goto L9;
        if (r100 == null) goto L11;
        r101 = r100.getRegularPrice();
    L11:
        if (r101 != null) goto L15;
        return 0;
    L15:
        return r101.longValue();
    L9:
        if (r100 == null) goto L11;
        r101 = r100.getMinPrice();
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public static /* synthetic */ Long i(PromotionProductPriceStruct r100, int r101) {
        return h(r100, r101, false, null, false);
    }

    public static Long h(PromotionProductPriceStruct r100, int r101, boolean r102, PromotionIPActivity r103, boolean r104) {
        if (r101 != 1) goto L12;
        if (r102 == false) goto L12;
        if (r103 == null) goto L7;
        if (r104 == false) goto L12;
    L7:
        if (r100 == null) goto L15;
        PromotionSeckillPrice r105 = r100.getSeckillPrice();
        if (r105 != null) goto L11;
        return null;
    L11:
        return r105.getSeckillMinPrice();
    L15:
        return null;
    L12:
        if (r100 != null) goto L14;
        return null;
    L14:
        return r100.getMinPrice();
    }

    public static Long a(PromotionProductPriceStruct r100, int r101, boolean r102, boolean r103, PromotionIPActivity r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if (r101 != 1) goto L18;
        if (r103 == false) goto L18;
        if (r104 != null) goto L18;
        if (r100 == null) goto L27;
        PromotionSeckillPrice r106 = r100.getSeckillPrice();
        if (r106 != null) goto L29;
        return null;
    L29:
        return r106.getSeckillMaxPrice();
    L27:
        return null;
    L18:
        if (r101 != 6) goto L24;
        if (r102 == false) goto L24;
        if (r100 == null) goto L30;
        PromotionGroupBuyPrice r107 = r100.getGroupBuyPrice();
        if (r107 != null) goto L32;
        return null;
    L32:
        return r107.getOriginMaxPrice();
    L30:
        return null;
    L24:
        if (r100 != null) goto L26;
        return null;
    L26:
        return r100.getMaxPrice();
    }
}
