package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f174597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f174598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f174599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f174603i;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE);
        appendParam("product_id", this.f174595a);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174596b);
        appendParam("author_id", this.f174597c);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174598d);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174599e);
        appendParam("follow_status", this.f174600f);
        appendParam("group_id", this.f174601g);
        appendParam("source_page", this.f174602h);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f174603i);
    }

    public a0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "moduleLabel");
        Intrinsics.checkNotNullParameter(r102, "authorId");
        Intrinsics.checkNotNullParameter(r103, "commodityId");
        Intrinsics.checkNotNullParameter(r104, "commodityType");
        Intrinsics.checkNotNullParameter(r105, "followStatus");
        Intrinsics.checkNotNullParameter(r106, "groupId");
        Intrinsics.checkNotNullParameter(r107, "sourcePage");
        Intrinsics.checkNotNullParameter(r110, "ecomEntranceForm");
        super("comment_group_show");
        this.f174595a = r100;
        this.f174596b = r101;
        this.f174597c = r102;
        this.f174598d = r103;
        this.f174599e = r104;
        this.f174600f = r105;
        this.f174601g = r106;
        this.f174602h = r107;
        this.f174603i = r110;
    }
}
