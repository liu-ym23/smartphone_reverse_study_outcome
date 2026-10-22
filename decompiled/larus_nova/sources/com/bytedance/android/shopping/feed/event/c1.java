package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class c1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f174638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f174639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f174640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f174644i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174636a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174637b, r101);
        appendParam("page_name", this.f174638c, r101);
        appendParam("author_id", this.f174639d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174640e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174641f, r101);
        appendParam("group_id", this.f174642g, r101);
        appendParam("source_page", this.f174643h, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CHANNEL_ID, this.f174644i, r101);
    }

    public c1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        super("inflow_big_sale_entrance_show");
        this.f174636a = r100;
        this.f174637b = r101;
        this.f174638c = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE;
        this.f174639d = r102;
        this.f174640e = r103;
        this.f174641f = r104;
        this.f174642g = r105;
        this.f174643h = r106;
        this.f174644i = r107;
    }
}
