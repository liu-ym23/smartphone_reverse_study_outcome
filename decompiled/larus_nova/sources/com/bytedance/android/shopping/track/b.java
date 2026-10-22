package com.bytedance.android.shopping.track;

import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static final String a(PromotionProductStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getCashRebate");
        PromotionProductPrivilegesStruct r101 = r100.getPrivilegeInfo();
        if (r101 == null) goto L21;
        PromotionProductCouponsStruct r102 = r101.getCoupons();
        if (r102 == null) goto L22;
        List<PromotionDiscountLabel> r103 = r102.discounts();
        if (r103 != null) goto L9;
        return "0";
    L9:
        if ((!r103.isEmpty()) == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L24;
        int r104 = ((PromotionDiscountLabel) ListProtector.get(r103, 0)).getType();
        if (r104 != 2) goto L16;
        return "1";
    L16:
        if (r104 != 3) goto L26;
        return "2";
    L26:
        return "0";
    L24:
        return "0";
    L22:
        return "0";
    L21:
        return "0";
    }
}
