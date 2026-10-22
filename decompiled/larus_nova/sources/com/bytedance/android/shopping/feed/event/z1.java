package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class z1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f175004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f175005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f175006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f175007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f175008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f175009f;

    public static final class a {
    }

    static {
    }

    public z1() {
        super("show_exchange_coupon_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f175004a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", r100, r101);
        appendParam("previous_page", this.f175005b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PANEL_NAME, this.f175006c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EXCHANGE_COUPON_ACTIVITY_NAME, this.f175007d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, this.f175008e, r101);
        appendParam("product_id", this.f175009f, r101);
    }
}
