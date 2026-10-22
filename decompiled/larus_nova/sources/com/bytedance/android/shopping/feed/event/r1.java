package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class r1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f174865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f174866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f174867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f174868l;

    public static final class a {
    }

    static {
    }

    public r1() {
        super("product_ranking_entrance_click");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", this.f174857a, r100);
        appendParam("entrance_position", this.f174864h, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, this.f174867k, r100);
        appendParam("product_id", this.f174868l, r100);
        appendParam("spu_rank", this.f174865i, r100);
        appendParam("display_rank", this.f174859c, r100);
        appendParam("inflow_list_type", this.f174866j, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f174858b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174860d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174861e, r100);
        appendParam("source_page", this.f174862f, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174863g, r100);
    }
}
