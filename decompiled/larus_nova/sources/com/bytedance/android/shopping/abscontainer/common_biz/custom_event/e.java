package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.l;

/* JADX INFO: loaded from: classes12.dex */
public final class e<STATE extends v43.l, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164241b;

    @Override // m33.a
    public final String d() {
        return this.f164241b;
    }

    public e(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164241b = "selfCheckPayStatus";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("check_pay_status_params");
    L7:
        if ((r102 instanceof Map) == false) goto L10;
        r101 = r102;
    L10:
        ((v43.l) this.f511708a.f507247a).w().c(new w33.a(new p43.b((Map) r101, 1, CollectionsKt.emptyList())));
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L5:
        r102 = null;
        goto L7
    }
}
