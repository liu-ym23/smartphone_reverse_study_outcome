package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class o0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164264b;

    @Override // m33.a
    public final String d() {
        return this.f164264b;
    }

    public o0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164264b = "selfTTPay";
    }

    @Override // m33.a
    public final void e(final e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.a();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("tt_pay_params");
    L7:
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r101 == null) goto L12;
        Object r105 = r101.get("success_code");
    L14:
        if ((r105 instanceof List) == false) goto L17;
        r102 = r105;
    L17:
        final List r106 = (List) r102;
        b43.c r107 = b43.c.f17507a;
        final Map r108 = b43.c.d(r104);
        if (r108 == null) goto L20;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r109 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.f164354a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.d(this.f511708a.f507252f, r108, new SelfTTPayEvent$onExecute$$inlined$let$lambda$1(this, r108, r106, r100));
        Unit r110 = Unit.INSTANCE;
        return;
    L20:
        new SelfTTPayEvent$onExecute$2(r100);
        return;
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }
}
