package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class d0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f174648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174651d;

    public static final class a {
    }

    static {
    }

    public d0() {
        super("enter_product_flow_page_fail");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        Integer r100 = this.f174648a;
        if (r100 == null) goto L5;
        String r101 = String.valueOf(r100.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r102 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("status_code", r101, r102);
        appendParam("status_msg", this.f174649b, r102);
        appendParam("is_preload", this.f174651d, r102);
        appendParam("log_id", this.f174650c, r102);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
