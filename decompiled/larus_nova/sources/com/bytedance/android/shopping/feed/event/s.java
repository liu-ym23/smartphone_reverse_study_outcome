package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class s extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174875g;

    public static final class a {
    }

    static {
    }

    public s() {
        super("click_comment_button");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174869a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("request_id", r100, r101);
        appendParam("enter_from", this.f174870b, r101);
        appendParam("page_name", this.f174871c, r101);
        appendParam("product_id", this.f174872d, r101);
        appendParam("group_id", this.f174873e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174874f, r101);
        appendParam("inflow_product_card_mode", this.f174875g);
    }
}
