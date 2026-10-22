package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j2 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f174774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f174775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f174776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f174777l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174766a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("request_id", r100, r101);
        appendParam("page_name", this.f174767b, r101);
        appendParam("product_id", this.f174768c, r101);
        appendParam("group_id", this.f174769d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174770e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f174771f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, this.f174772g, r101);
        appendParam("inflow_product_card_mode", this.f174773h);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE, this.f174774i, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE, this.f174775j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MIN_SKU_PRICE, this.f174776k, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MAX_SKU_PRICE, this.f174777l, r101);
    }

    public j2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
