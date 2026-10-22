package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class t0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f174906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f174907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f174908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f174912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f174913j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174904a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174905b, r101);
        appendParam("page_name", this.f174906c, r101);
        appendParam("author_id", this.f174907d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174908e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174909f, r101);
        appendParam("group_id", this.f174910g, r101);
        appendParam("source_page", this.f174911h, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CHANNEL_ID, this.f174912i, r101);
        String r102 = this.f174913j;
        if (r102 == null) goto L6;
        appendParam("btm_id", r102, r101);
        return;
    }

    public t0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        super("inflow_big_sale_entrance_click");
        this.f174904a = r100;
        this.f174905b = r101;
        this.f174906c = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE;
        this.f174907d = r102;
        this.f174908e = r103;
        this.f174909f = r104;
        this.f174910g = r105;
        this.f174911h = r106;
        this.f174912i = r107;
        this.f174913j = r110;
    }
}
