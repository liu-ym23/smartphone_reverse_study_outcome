package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class w0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f174949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174951c;

    public static final class a {
    }

    static {
    }

    public w0() {
        super("inflow_ngroup_product_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174951c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_N_GROUP_BUY, String.valueOf(this.f174949a), r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_N_GROUP_BUY_STATE, this.f174950b, r100);
    }
}
