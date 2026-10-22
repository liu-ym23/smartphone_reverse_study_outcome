package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class x0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174966h;

    public static final class a {
    }

    static {
    }

    public x0() {
        super("inflow_rd_core_params_monitor");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174959a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_C_BIZ_COMBO, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BUYIN_TRACK, this.f174960b, r101);
        appendParam("item_id", this.f174961c, r101);
        appendParam("promotion_id", this.f174962d, r101);
        appendParam("author_id", this.f174963e, r101);
        appendParam("request_id", this.f174964f, r101);
        appendParam("user_id", this.f174965g, r101);
        appendParam("is_preload", this.f174966h, r101);
    }
}
