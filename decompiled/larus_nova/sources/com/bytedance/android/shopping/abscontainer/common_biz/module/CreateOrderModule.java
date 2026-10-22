package com.bytedance.android.shopping.abscontainer.common_biz.module;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.b;
import v43.l;

/* JADX INFO: loaded from: classes12.dex */
public final class CreateOrderModule<STATE extends l & v43.b, PROPS extends u33.a> extends s33.b<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164296b;

    @Override // s33.b
    public final void b() {
        ConcurrentHashMap<String, Object> r100 = a43.a.f1756a;
        if (Intrinsics.areEqual(l43.a.a("iesec_buy_finance_risk_post"), 1) == false) goto L6;
        k33.a r101 = this.f540457a.f507250d.e().b(new CreateOrderModule$flowFirstScreenRenderFinished$cjInfoAsyncJob$1(this));
        ((l) this.f540457a.f507247a).G(r101);
        return;
    }

    @Override // s33.b
    public final String j() {
        return this.f164296b;
    }

    public CreateOrderModule(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164296b = "CreateOrderModule";
    }
}
