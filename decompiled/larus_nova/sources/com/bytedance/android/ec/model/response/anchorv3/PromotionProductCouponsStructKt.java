package com.bytedance.android.ec.model.response.anchorv3;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class PromotionProductCouponsStructKt {
    public static final String a(PromotionProductCouponsStruct r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L15;
        List<PromotionDiscountLabel> r102 = r100.getDiscountLabels();
        if (r102 == null) goto L15;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        PromotionDiscountLabel r104 = (PromotionDiscountLabel) r103.next();
        if (r104.getType() != 1) goto L8;
        if (r104.getId() == null) goto L8;
        r101.append(r104.getId() + ",");
    L15:
        if (r101.length() != 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        return r101.toString();
    L21:
        return r101.substring(0, r101.length() - 1);
    L17:
        r105 = false;
        goto L18
    }

    public static final String b(PromotionProductCouponsStruct r100) {
        List<PromotionDiscountLabel> r101 = r100.getDiscountLabels();
        if (r101 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, PromotionProductCouponsStructKt$getKolUserTag$1.INSTANCE, 30, null);
    }
}
