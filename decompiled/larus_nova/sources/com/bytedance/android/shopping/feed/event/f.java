package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174698e;

    public static final class a {
    }

    static {
    }

    public f() {
        super("aftersale_information_right");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174694a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", r100, r101);
        appendParam("product_id", this.f174695b, r101);
        appendParam("group_id", this.f174696c, r101);
        appendParam("text", this.f174697d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174698e, r101);
    }
}
