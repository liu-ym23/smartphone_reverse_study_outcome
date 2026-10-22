package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.l;

/* JADX INFO: loaded from: classes12.dex */
public final class q0<STATE extends v43.l, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164268b;

    @Override // m33.a
    public final String d() {
        return this.f164268b;
    }

    public q0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164268b = "selfToggleSubmit";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(ForwardDependency$ForwardLocation.FLAG);
    L7:
        if ((r102 instanceof Boolean) == false) goto L10;
        r101 = r102;
    L10:
        Boolean r103 = (Boolean) r101;
        if (r103 == null) goto L13;
        boolean r104 = r103.booleanValue();
    L14:
        ((v43.l) this.f511708a.f507247a).m(r104);
        this.f511708a.f507250d.a().a("ies_ecommerce_fe_custom_log", MapsKt.mapOf(TuplesKt.to("type", "selfToggleSubmit_" + r104)));
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L13:
        r104 = true;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
