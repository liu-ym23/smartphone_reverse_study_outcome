package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class b2 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174628e;

    public b2() {
        super("show_inflow_switch_tab");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE);
        appendParam("source_page", this.f174624a);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f174625b);
        appendParam("author_id", this.f174626c);
        appendParam("group_id", this.f174627d);
        appendParam("inflow_product_card_mode", this.f174628e);
    }
}
