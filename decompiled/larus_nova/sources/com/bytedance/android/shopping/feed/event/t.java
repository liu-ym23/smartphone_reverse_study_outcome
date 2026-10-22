package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f174882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f174883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f174884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f174888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f174889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f174890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f174891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f174892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f174893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f174894o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f174895p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f174896q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f174897r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f174898s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f174899t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f174900u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Integer f174901v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f174902w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f174903x;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174880a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r100, r101);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, this.f174881b, r101);
        appendParam("display_rank", this.f174882c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f174883d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f174884e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174888i, r101);
        appendParam("request_id", this.f174885f, r101);
        appendParam("page_name", this.f174886g, r101);
        appendParam("enter_from", this.f174880a, r101);
        appendParam("group_id", this.f174890k, r101);
        appendParam("previous_page", this.f174887h, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CHANNEL_ID, this.f174889j, r101);
        appendParam("product_id", this.f174891l, r101);
        String r102 = this.f174895p;
        if (r102 == null) goto L5;
        appendParam("btm_id", r102, r101);
    L5:
        appendParam("coupon_id", this.f174892m, r101);
        appendParam("coupon_value", this.f174893n, r101);
        appendParam("inflow_coupon_type", this.f174894o, r101);
        appendParam("ecom_mall_type", this.f174896q);
        appendParam("is_category", this.f174897r, r101);
        appendParam("category_name", this.f174898s, r101);
        String r103 = this.f174899t;
        if (r103 == null) goto L8;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID_GROUP, r103, r101);
    L8:
        String r104 = this.f174900u;
        if (r104 == null) goto L11;
        appendParam("bsk", r104, r101);
    L11:
        Integer r105 = this.f174901v;
        if (r105 == null) goto L15;
        String r106 = String.valueOf(r105.intValue());
        if (r106 == null) goto L15;
    L16:
        appendParam("is_inflow_auto_expand", r106);
        appendParam("resource_id", this.f174902w, r101);
        appendParam("mall_enter_from", this.f174903x, r101);
        return;
    L15:
        r106 = "0";
        goto L16
    }

    public t(String r100, String r101, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, Integer r218, String r219, String r310) {
        Intrinsics.checkNotNullParameter(r100, "carrierSource");
        Intrinsics.checkNotNullParameter(r101, "ecomType");
        Intrinsics.checkNotNullParameter(r110, "displayRank");
        Intrinsics.checkNotNullParameter(r111, "clickArea");
        Intrinsics.checkNotNullParameter(r112, "recommendInfo");
        super("click_ecom_inflow_card");
        this.f174880a = r100;
        this.f174881b = r101;
        this.f174882c = r110;
        this.f174883d = r111;
        this.f174884e = r112;
        this.f174885f = r113;
        this.f174886g = null;
        this.f174887h = r114;
        this.f174888i = r115;
        this.f174889j = r116;
        this.f174890k = r117;
        this.f174891l = r118;
        this.f174892m = r119;
        this.f174893n = r210;
        this.f174894o = r211;
        this.f174895p = r212;
        this.f174896q = r213;
        this.f174897r = r214;
        this.f174898s = r215;
        this.f174899t = r216;
        this.f174900u = r217;
        this.f174901v = r218;
        this.f174902w = r219;
        this.f174903x = r310;
    }
}
