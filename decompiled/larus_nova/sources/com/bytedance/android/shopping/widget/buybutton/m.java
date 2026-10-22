package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.shopping.utils.p;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements mf.b {
    public m() {
    }

    @Override // mf.b
    public final JSONObject a(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        ClickButtonParam r102 = r101.f519522g;
        String r103 = null;
        if (r102 != null) goto L5;
        return null;
    L5:
        String r104 = r102.getEntranceInfo();
        if (r104 == null) goto L8;
        JSONObject r105 = new JSONObject(r104);
    L9:
        ClickButtonParam r106 = r101.f519522g;
        if (r106 == null) goto L12;
        r103 = r106.getEnterFrom();
    L12:
        r105.put(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r103);
        r105.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r102.getPromotionId());
        r105.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r102.getPromotionSource());
        r105.put("product_id", r102.getProductId());
        return r105;
    L8:
        r105 = new JSONObject();
        goto L9
    }

    @Override // mf.b
    public final void b(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
    }

    @Override // mf.b
    public final String c(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        ClickButtonParam r102 = r101.f519522g;
        if (r102 != null) goto L6;
        return null;
    L6:
        String r103 = r102.getMarketingChannel();
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    }

    @Override // mf.b
    public final JSONObject d(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        ClickButtonParam r102 = r101.f519522g;
        String r103 = null;
        if (r102 != null) goto L5;
        return null;
    L5:
        SingleClickParam r104 = com.bytedance.android.ec.model.c.a(r102, r101.f519521f);
        JSONObject r105 = new JSONObject();
        r105.put("coupon_id", r104.getApplyCouponIds());
        r105.put(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, "0");
        String r106 = r102.getEntranceInfo();
        if (r106 == null) goto L8;
        r103 = z1.f(r106).optString(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, "0");
    L8:
        r105.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r103);
        r105.put("author_id", r102.getAuthorId());
        r105.put("item_id", r102.getItemId());
        List<PromotionDiscountLabel> r107 = r102.getDiscountLabels();
        StringBuilder r108 = new StringBuilder();
        if (r107 == null) goto L19;
        Iterator<T> r109 = r107.iterator();
    L12:
        if (r109.hasNext() == false) goto L19;
        PromotionDiscountLabel r110 = (PromotionDiscountLabel) r109.next();
        if (r110.getType() != 1) goto L12;
        if (r110.getId() == null) goto L12;
        r108.append(Intrinsics.stringPlus(r110.getId(), ","));
    L19:
        if (r108.length() != 0) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == false) goto L24;
        String r112 = r108.toString();
    L25:
        r105.put("coupon_id", r112);
        return r105;
    L24:
        r112 = r108.substring(0, r108.length() - 1);
        goto L25
    L21:
        r111 = false;
        goto L22
    }

    @Override // mf.b
    public final String e(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        return null;
    }

    @Override // mf.b
    public final String f(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        ClickButtonParam r102 = r101.f519522g;
        if (r102 == null) goto L7;
        String r103 = r102.getGroupId();
        if (r103 == null) goto L9;
        return r103;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // mf.b
    public final void g(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
    }

    @Override // mf.b
    public final JSONObject h(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        JSONObject r102 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L5;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        r102.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, p.b());
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
    L5:
        return r102;
    }

    @Override // mf.b
    public final void i(Map r100, nl.e r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r100, "schemaParams");
        Intrinsics.checkNotNullParameter(r101, "orderSchemaVo");
    }
}
