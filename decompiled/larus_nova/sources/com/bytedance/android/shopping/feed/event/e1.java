package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class e1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174693c;

    public e1() {
        super("inflow_toast_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("source_page", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r100);
        appendParam("enter_from", "ecom_video_product_inner", r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO, this.f174691a);
        appendParam("coupon_id", this.f174692b);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, this.f174693c);
    }
}
