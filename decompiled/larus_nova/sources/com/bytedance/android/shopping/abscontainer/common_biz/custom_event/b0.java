package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class b0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164235b;

    @Override // m33.a
    public final String d() {
        return this.f164235b;
    }

    public b0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164235b = "selfReadFieldAndTrigger";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("field_path");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L13;
        r110.d(new m33.c(false, "field_path is empty", false, null, 20));
        return;
    L13:
        Map<String, Object> r104 = r110.e();
        b43.c r105 = b43.c.f17507a;
        Object r106 = m43.a.a(r104, r103);
        if ((r106 instanceof String) == false) goto L17;
        r101 = r106;
    L17:
        String r107 = (String) r101;
        if (r107 != null) goto L20;
        String r108 = "";
    L22:
        if (r108.length() != 0) goto L24;
        boolean r109 = true;
    L25:
        if (r109 == false) goto L28;
        r110.d(new m33.c(false, "target " + r103 + " is empty", false, null, 20));
        return;
    L28:
        String r111 = r110.f();
        if (r111 != null) goto L31;
        String r112 = "";
    L32:
        this.f511708a.f507250d.c().j(null, r112, r108, null, this.f164235b);
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L31:
        r112 = r111;
        goto L32
    L24:
        r109 = false;
        goto L25
    L20:
        r108 = r107;
        goto L22
    L5:
        r102 = null;
        goto L7
    }
}
