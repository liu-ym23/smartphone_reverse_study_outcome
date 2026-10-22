package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class e2 extends com.bytedance.android.ec.core.event.a {
    public e2() {
        super("show_search");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("inflow_product_card_mode", null);
    }
}
