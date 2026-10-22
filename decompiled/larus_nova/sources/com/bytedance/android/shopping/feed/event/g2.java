package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g2 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f174739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f174740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f174741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f174742l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174731a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("duration", r100, r101);
        appendParam("author_id", this.f174732b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, null, r101);
        appendParam("source_page", null, r101);
        appendParam("enter_method", null, r101);
        appendParam("product_id", this.f174733c, r101);
        appendParam("follow_status", followStatus(null, this.f174732b), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, r101);
        appendParam("page_name", null, r101);
        appendParam("group_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, null, r101);
        appendParam("search_id", this.f174735e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f174734d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WHICH_ACCOUNT, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, this.f174736f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f174737g, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, this.f174738h, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_LABEL_NAME, null, r101);
        appendParam("inflow_product_card_mode", this.f174739i);
        appendParam("display_rank", this.f174742l);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f174741k);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, this.f174740j);
    }

    public g2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
