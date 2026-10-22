package com.bytedance.android.shopping.skubuy.module;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t43.d;
import u33.a;
import v43.o;

/* JADX INFO: loaded from: classes13.dex */
public final class a<STATE extends o, PROPS extends u33.a & t43.d> extends s33.b<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l33.b<STATE, PROPS> f183129c;

    @Override // s33.b
    public final void A() {
        this.f183129c.f507250d.d().a("ecom.sku.dismiss", MapsKt.mapOf(new Pair[]{TuplesKt.to("sku_session_id", ((t43.d) this.f183129c.f507249c).b()), TuplesKt.to("stage", "will_dismiss"), TuplesKt.to("close_type", ((o) this.f183129c.f507247a).K())}));
    }

    @Override // s33.b
    public final void y() {
        this.f183129c.f507250d.d().a("ecom.sku.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("stage", "will_show"), TuplesKt.to("sku_session_id", ((t43.d) this.f183129c.f507249c).b())}));
    }

    @Override // s33.b
    public final String j() {
        return this.f183128b;
    }

    public a(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f183129c = r100;
        this.f183128b = "PageExposeModule";
    }
}
