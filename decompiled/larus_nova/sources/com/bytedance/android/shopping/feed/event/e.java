package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174686e;

    public static final class a {
    }

    static {
    }

    public e() {
        super("add_cart_toast_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174682a);
        appendParam("page_name", null);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, this.f174683b);
        appendParam("source_page", null);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, null);
        appendParam("author_id", null);
        appendParam("group_id", null);
        appendParam("follow_status", null);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174684c);
        appendParam("product_id", this.f174685d);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174686e);
    }
}
