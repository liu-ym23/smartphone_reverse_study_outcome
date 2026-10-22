package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class e0 {
    static {
    }

    public static String a(PromotionProductStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getDiscountActivityId");
        PromotionProductExtraStruct r101 = r100.getExtraInfo();
        if (r101 == null) goto L9;
        String r102 = r101.getLogExtra();
        if (r102 == null) goto L9;
        JSONObject r103 = z1.g(r102);
        if (r103 == null) goto L9;
        return r103.optString(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_ACTIVITY_ID);
    L9:
        return null;
    }

    public static String b(PromotionProductStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getDiscountActivityType");
        PromotionProductExtraStruct r101 = r100.getExtraInfo();
        if (r101 == null) goto L9;
        String r102 = r101.getLogExtra();
        if (r102 == null) goto L9;
        JSONObject r103 = z1.g(r102);
        if (r103 == null) goto L9;
        return r103.optString(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_ACTIVITY_TYPE);
    L9:
        return null;
    }
}
