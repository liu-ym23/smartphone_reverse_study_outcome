package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;

/* JADX INFO: loaded from: classes13.dex */
public final class a1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f174604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174609f;

    public a1() {
        super("trending_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("words_num", String.valueOf(this.f174604a));
        appendParam("enter_from", "search_order_center_product_flow_page");
        appendParam("impr_id", this.f174605b);
        appendParam("words_source", this.f174606c);
        appendParam(ECFindSimilarConfig.ENTER_FROM_SECOND, this.f174607d);
        appendParam("from_gid", this.f174608e);
        appendParam("guess_like_item_rank", this.f174609f);
    }
}
