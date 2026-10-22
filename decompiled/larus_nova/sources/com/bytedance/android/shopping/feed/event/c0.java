package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class c0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f174633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174635f;

    public static final class a {
    }

    static {
    }

    public c0() {
        super("enter_product_flow_page");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174630a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("log_id", r100, r101);
        appendParam("inflow_recommend_type", this.f174631b, r101);
        String r102 = null;
        appendParam("previous_page", null, r101);
        appendParam("inflow_product_card_mode", this.f174632c);
        Integer r103 = this.f174633d;
        if (r103 == null) goto L5;
        r102 = String.valueOf(r103.intValue());
    L5:
        appendParam("is_similar_product_na", r102, r101);
        appendParam("video_product_is_unsale", this.f174634e);
        if (com.bytedance.android.shopping.extensions.k.c(this.f174635f) == false) goto L9;
        appendParam("cid", this.f174635f);
        return;
    }
}
