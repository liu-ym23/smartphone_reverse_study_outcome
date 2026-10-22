package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f174974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f174975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f174976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f174980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f174981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f174982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f174983l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f174984m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f174985n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f174986o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f174987p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f174988q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f174989r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f174990s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f174991t;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174972a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r100, r101);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, this.f174973b, r101);
        appendParam("display_rank", this.f174974c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f174975d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174980i, r101);
        appendParam("request_id", this.f174976e, r101);
        appendParam("page_name", this.f174977f, r101);
        appendParam("previous_page", this.f174978g, r101);
        appendParam("group_id", this.f174979h, r101);
        appendParam("enter_from", this.f174972a, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CHANNEL_ID, this.f174981j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID_GROUP, this.f174982k, r101);
        appendParam("ecom_mall_type", this.f174983l);
        appendParam("inflow_coupon_type", this.f174984m, r101);
        appendParam("coupon_id", this.f174985n, r101);
        appendParam("coupon_value", this.f174986o, r101);
        appendParam("is_category", this.f174987p, r101);
        appendParam("category_name", this.f174988q, r101);
        appendParam("resource_id", this.f174990s, r101);
        appendParam("mall_enter_from", this.f174991t, r101);
        String r102 = this.f174989r;
        if (r102 == null) goto L6;
        appendParam("bsk", r102, r101);
        return;
    }

    public final String getType() {
        return this.f174973b;
    }

    public y1(String r100, String r101, String r102, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r100, "carrierSource");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "displayRank");
        Intrinsics.checkNotNullParameter(r110, "recommendInfo");
        super("show_ecom_inflow_card");
        this.f174972a = r100;
        this.f174973b = r101;
        this.f174974c = r102;
        this.f174975d = r110;
        this.f174976e = r111;
        this.f174977f = r112;
        this.f174978g = r113;
        this.f174979h = r114;
        this.f174980i = r115;
        this.f174981j = r116;
        this.f174982k = r117;
        this.f174983l = r118;
        this.f174984m = r119;
        this.f174985n = r210;
        this.f174986o = r211;
        this.f174987p = r212;
        this.f174988q = r213;
        this.f174989r = r214;
        this.f174990s = r215;
        this.f174991t = r216;
    }
}
