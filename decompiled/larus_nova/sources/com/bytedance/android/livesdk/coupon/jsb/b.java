package com.bytedance.android.livesdk.coupon.jsb;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121915a = 0;

    static {
    }

    public static JSONObject a(com.bytedance.android.livesdk.coupon.expandcoupon.model.d r100, ct1.e r101) {
        JSONObject r102 = new JSONObject();
        Long r103 = null;
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r104 = r100.f121903e;
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf(r104.b());
    L8:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE, r105);
        if (r100 == null) goto L13;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r106 = r100.f121903e;
        if (r106 == null) goto L13;
        String r107 = r106.e();
    L14:
        r102.put("req_id", r107);
        if (r100 == null) goto L19;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r108 = r100.f121903e;
        if (r108 == null) goto L19;
        String r109 = r108.f();
    L20:
        r102.put("ad_token", r109);
        if (r100 == null) goto L25;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r110 = r100.f121903e;
        if (r110 == null) goto L25;
        String r111 = r110.c();
    L26:
        r102.put("biz_tag", r111);
        if (r100 == null) goto L31;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r112 = r100.f121903e;
        if (r112 == null) goto L31;
        Long r113 = Long.valueOf(r112.a());
    L32:
        r102.put("ad_id", r113);
        if (r100 == null) goto L37;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r114 = r100.f121903e;
        if (r114 == null) goto L37;
        Long r115 = Long.valueOf(r114.d());
    L38:
        r102.put("cid", r115);
        if (r100 == null) goto L41;
        String r116 = r100.f121899a;
    L42:
        r102.put("coupon_id", r116);
        if (r101 != null) goto L45;
    L47:
        if (r100 == null) goto L49;
        String r117 = r100.f121900b;
    L50:
        r102.put("before_expand_amount", r117);
        if (r100 == null) goto L53;
        String r118 = r100.f121901c;
    L54:
        r102.put("after_expand_amount", r118);
        if (r100 != null) goto L57;
    L59:
        if (r101 == null) goto L61;
        Integer r119 = Integer.valueOf(r101.getState());
    L62:
        if (r119 != null) goto L65;
    L67:
        if (r119 == null) goto L73;
        if (r119.intValue() != 1) goto L73;
    L77:
        Integer r120 = 1;
    L86:
        r102.put("coupon_status", r120);
        if (r101 == null) goto L89;
        r103 = Long.valueOf(r101.getTaskKey());
    L89:
        r102.put("qcpx_expansion_task_id", r103);
        return r102;
    L73:
        if (r119 != null) goto L76;
    L78:
        if (r119 != null) goto L81;
    L83:
        if (r119 != null) goto L85;
        r120 = 3;
        goto L86
    L85:
        r120 = null;
        goto L86
    L81:
        if (r119.intValue() != 3) goto L83;
        r120 = 2;
        goto L86
    L76:
        if (r119.intValue() != 2) goto L78;
    L65:
        if (r119.intValue() != 0) goto L67;
        r120 = 0;
        goto L86
    L61:
        r119 = null;
        goto L62
    L57:
        if (r100.f121902d != true) goto L59;
        r120 = 3;
        goto L86
    L53:
        r118 = null;
        goto L54
    L49:
        r117 = null;
        goto L50
    L45:
        if (r101.getState() != 1) goto L47;
        r102.put("expand_end_time", r101.getRemainTime());
        goto L47
    L41:
        r116 = null;
    L37:
        r115 = null;
    L31:
        r113 = null;
    L25:
        r111 = null;
    L19:
        r109 = null;
    L13:
        r107 = null;
    L7:
        r105 = null;
        goto L8
    }
}
