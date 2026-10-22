package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f174994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f174995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f174996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f175000i;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE);
        appendParam("product_id", this.f174992a);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174993b);
        appendParam("author_id", this.f174994c);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174995d);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174996e);
        appendParam("follow_status", this.f174997f);
        appendParam("group_id", this.f174998g);
        appendParam("source_page", this.f174999h);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f175000i);
    }

    public z(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "moduleLabel");
        Intrinsics.checkNotNullParameter(r102, "authorId");
        Intrinsics.checkNotNullParameter(r103, "commodityId");
        Intrinsics.checkNotNullParameter(r104, "commodityType");
        Intrinsics.checkNotNullParameter(r105, "followStatus");
        Intrinsics.checkNotNullParameter(r106, "groupId");
        Intrinsics.checkNotNullParameter(r107, "sourcePage");
        Intrinsics.checkNotNullParameter(r110, "ecomEntranceForm");
        super("comment_group_click");
        this.f174992a = r100;
        this.f174993b = r101;
        this.f174994c = r102;
        this.f174995d = r103;
        this.f174996e = r104;
        this.f174997f = r105;
        this.f174998g = r106;
        this.f174999h = r107;
        this.f175000i = r110;
    }
}
