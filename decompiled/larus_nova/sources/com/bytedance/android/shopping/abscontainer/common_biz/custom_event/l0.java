package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class l0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164256b;

    @Override // m33.a
    public final String d() {
        return this.f164256b;
    }

    public l0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164256b = "selfSetStatusBar";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.a();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("theme");
    L7:
        if ((r103 instanceof String) == false) goto L10;
        r102 = r103;
    L10:
        String r104 = (String) r102;
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        if (r104.length() != 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        this.f511708a.f507250d.b().f(r104);
    L19:
        r100.d(new m33.c(true, null, false, null, 30));
        return;
    L16:
        r105 = false;
        goto L17
    L5:
        r103 = null;
        goto L7
    }
}
