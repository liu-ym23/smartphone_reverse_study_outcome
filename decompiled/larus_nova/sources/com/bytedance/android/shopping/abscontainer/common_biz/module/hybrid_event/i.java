package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.r;

/* JADX INFO: loaded from: classes12.dex */
public final class i<STATE extends r, PROPS extends u33.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164344c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164344c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164343b;
    }

    public i(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164343b = "UpdateSelectedShopModule";
        this.f164344c = "updateSelectedShop";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Map<String, ? extends Object> r101 = MapsKt.toMutableMap(r100);
        r101.remove("poi_phone");
        ((r) this.f540457a.f507247a).v(r101);
        com.bytedance.android.shopping.abscontainer.common_biz.helper.b.a(this.f540457a.f507250d.c(), (r) this.f540457a.f507247a, "poi_store_entry");
    }
}
