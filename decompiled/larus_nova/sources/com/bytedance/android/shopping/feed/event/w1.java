package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class w1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174958g;

    public static final class a {
    }

    static {
    }

    public w1() {
        super("show_comment_button");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174952a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("enter_from", r100, r101);
        appendParam("page_name", this.f174953b, r101);
        appendParam("product_id", this.f174954c, r101);
        appendParam("group_id", this.f174955d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174956e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f174957f, r101);
        appendParam("inflow_product_card_mode", this.f174958g);
    }
}
