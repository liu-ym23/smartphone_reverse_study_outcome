package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t43.c;
import u33.a;
import v43.r;

/* JADX INFO: loaded from: classes12.dex */
public final class d<STATE extends r, PROPS extends u33.a & t43.c> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164333c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164333c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164332b;
    }

    public d(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164332b = "ReloadSKUPanelModule";
        this.f164333c = "reloadSKUPanel";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Object r101 = ((HashMap) r100).get("product_id");
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        b43.c r103 = b43.c.f17507a;
        if (b43.c.c(r102) == false) goto L11;
    L13:
        com.bytedance.android.shopping.abscontainer.common_biz.helper.b.a(this.f540457a.f507250d.c(), (r) this.f540457a.f507247a, "receive_update_sku_notice");
        return;
    L11:
        if ((!Intrinsics.areEqual(r102, ((t43.c) this.f540457a.f507249c).getProductID())) == false) goto L13;
    }
}
