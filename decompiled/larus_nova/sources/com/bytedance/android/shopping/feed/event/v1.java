package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class v1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174946a;

    public static final class a {
    }

    static {
    }

    public v1() {
        super("show_cart_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("inflow_product_card_mode", this.f174946a);
    }
}
