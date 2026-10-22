package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class w extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174948b;

    public static final class a {
    }

    static {
    }

    public w() {
        super("click_order_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174947a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("enter_from", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f174948b, r101);
        appendParam("inflow_product_card_mode", null);
    }
}
