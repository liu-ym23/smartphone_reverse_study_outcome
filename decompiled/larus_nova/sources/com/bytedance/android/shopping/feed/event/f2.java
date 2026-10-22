package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class f2 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174717g;

    public static final class a {
    }

    static {
    }

    public f2() {
        super(com.bytedance.android.ec.core.event.a.KEY_PDP_GALLERY_SHARE_BUTTON_SHOW);
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174711a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("enter_from", r100, r101);
        appendParam("page_name", this.f174712b, r101);
        appendParam("product_id", this.f174713c, r101);
        appendParam("group_id", this.f174714d, r101);
        appendParam("author_id", this.f174715e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174716f, r101);
        appendParam("inflow_product_card_mode", this.f174717g);
    }
}
