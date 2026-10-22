package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class a2 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174613d;

    public static final class a {
    }

    static {
    }

    public a2() {
        super("product_flow_page_guide_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174610a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("trigger", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r101);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r101);
        appendParam("group_id", this.f174611b, r101);
        appendParam("author_id", this.f174612c, r101);
        appendParam("enter_from", this.f174613d, r101);
    }
}
