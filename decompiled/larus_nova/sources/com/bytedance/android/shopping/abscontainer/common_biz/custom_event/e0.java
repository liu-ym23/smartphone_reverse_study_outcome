package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.p;

/* JADX INFO: loaded from: classes12.dex */
public final class e0<STATE extends v43.p, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164242b;

    @Override // m33.a
    public final String d() {
        return this.f164242b;
    }

    public e0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164242b = "selfSaveRenderNode";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.a();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("render_node_key");
    L7:
        if ((r103 instanceof String) == false) goto L10;
        r102 = r103;
    L10:
        String r104 = (String) r102;
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        ((v43.p) this.f511708a.f507247a).x(r104);
        r100.d(new m33.c(true, null, false, null, 30));
        return;
    L5:
        r103 = null;
        goto L7
    }
}
