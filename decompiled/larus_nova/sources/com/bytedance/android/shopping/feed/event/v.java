package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class v extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174941f;

    public v() {
        super("click_inflow_switch_tab");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE);
        appendParam("source_page", this.f174936a);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f174937b);
        appendParam("author_id", this.f174938c);
        appendParam("group_id", this.f174939d);
        appendParam("inflow_product_card_mode_after_click", this.f174941f);
        appendParam("inflow_product_card_mode", this.f174940e);
    }
}
