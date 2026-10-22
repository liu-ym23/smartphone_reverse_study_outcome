package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f174615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f174623i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("words_source", this.f174618d);
        appendParam("words_position", String.valueOf(this.f174615a));
        appendParam("words_content", this.f174616b);
        appendParam("enter_from", "search_order_center_product_flow_page");
        appendParam(ECFindSimilarConfig.ENTER_FROM_SECOND, this.f174620f);
        appendParam("impr_id", this.f174617c);
        appendParam("group_id", this.f174619e);
        appendParam("from_gid", this.f174621g);
        appendParam("guess_like_item_rank", this.f174622h);
        appendParam("group_result_id", this.f174623i);
    }

    public b1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
