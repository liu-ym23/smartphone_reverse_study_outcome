package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t43.d;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class q<STATE extends w33.g, PROPS extends u33.a & t43.d> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164267b;

    @Override // m33.a
    public final String d() {
        return this.f164267b;
    }

    public q(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164267b = "selfOpenCoupon";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("schema");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        final String r103 = (String) r102;
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        Map<String, Object> r104 = r110.a();
        if (r104 == null) goto L15;
        Object r105 = r104.get("btm");
    L17:
        if ((r105 instanceof String) == false) goto L20;
        r101 = r105;
    L20:
        final String r106 = (String) r101;
        if (r106 == null) goto L23;
        StringsKt.isBlank(r106);
    L23:
        com.bytedance.android.shopping.sku.common.utils.b.a(r103, new SelfOpenCouponEvent$onExecute$1(this, r103, r106), SelfOpenCouponEvent$onExecute$2.INSTANCE);
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L15:
        r105 = null;
        goto L17
    L5:
        r102 = null;
        goto L7
    }
}
