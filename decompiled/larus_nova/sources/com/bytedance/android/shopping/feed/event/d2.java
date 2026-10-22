package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class d2 extends com.bytedance.android.ec.core.event.a {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f174664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f174665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f174666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f174667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f174668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f174669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f174670o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f174671p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f174672q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f174673r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f174674s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f174675t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f174676u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f174677v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f174678w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f174679x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f174680y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f174681z;

    public static final class a {
    }

    static {
    }

    public d2() {
        super(com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT);
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_FLOW_TYPE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FULLSCREEN_CARD, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_MESSAGE_BAR, this.f174656a, r100);
        appendParam("campaign_sub_type", this.f174657b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, this.f174660e, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BELT_DETAIL, this.f174658c, r100);
        appendParam("aftersale_information", this.f174659d, r100);
        appendParam("display_rank", this.f174661f, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, this.f174662g, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_WITH_VIDEO, this.f174663h, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_NUM_LABEL_TYPE, this.f174664i, r100);
        appendParam("inflow_recommend_type", this.f174665j, r100);
        appendParam("previous_page", this.f174666k, r100);
        appendParam("inflow_product_card_mode", this.f174667l);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE, this.f174668m, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE, this.f174669n, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MIN_SKU_PRICE, this.f174670o, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MAX_SKU_PRICE, this.f174671p, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f174672q, r100);
        appendParam("enter_from", this.f174673r, r100);
        appendParam("page_name", this.f174674s, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174675t, r100);
        appendParam("user_type", this.f174676u, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COUPON_NAME, this.f174677v, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, this.f174678w, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, this.f174679x, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_NEW_GIFT_TYPE, this.f174680y, r100);
        appendParam("product_id", this.A, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_ACTIVITY_TYPE, this.C, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_ACTIVITY_ID, this.D, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRICE_TYPE, this.E, r100);
        if (com.bytedance.android.shopping.extensions.k.c(this.B) == false) goto L5;
        appendParam("cid", this.B);
    L5:
        appendParam("btm_id", this.f174681z);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRICE_INFO, this.F, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STANDARD_TRACK_PARAM, this.G, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STANDARD_PRODUCT_MARKETING_PARAM, this.H, r100);
    }
}
