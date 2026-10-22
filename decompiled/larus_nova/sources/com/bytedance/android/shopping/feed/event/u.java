package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class u extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174924g;

    public static final class a {
    }

    static {
    }

    public u() {
        super("click_exchange_coupon_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174918a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", r100, r101);
        appendParam("previous_page", this.f174919b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PANEL_NAME, this.f174920c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EXCHANGE_COUPON_ACTIVITY_NAME, this.f174921d, r101);
        appendParam("click_type", this.f174922e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, this.f174923f, r101);
        appendParam("product_id", this.f174924g, r101);
    }
}
