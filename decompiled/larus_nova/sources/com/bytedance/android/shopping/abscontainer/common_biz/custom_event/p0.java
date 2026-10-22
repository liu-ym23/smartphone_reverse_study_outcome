package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class p0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164266b;

    @Override // m33.a
    public final String d() {
        return this.f164266b;
    }

    public p0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164266b = "selfToast";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.c();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("toast_message");
    L7:
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r104 != null) goto L20;
        Map<String, Object> r105 = r100.a();
        if (r105 == null) goto L14;
        Object r106 = r105.get("toast_message");
    L16:
        if ((r106 instanceof String) == false) goto L19;
        r102 = r106;
    L19:
        r104 = (String) r102;
        goto L20
    L14:
        r106 = null;
    L20:
        if (r104 == null) goto L22;
        this.f511708a.f507250d.b().showToast(r104);
    L23:
        r100.d(new m33.c(true, null, false, null, 30));
        return;
    L22:
        SelfToastEvent$onExecute$2 r107 = SelfToastEvent$onExecute$2.INSTANCE;
        goto L23
    L5:
        r103 = null;
        goto L7
    }
}
