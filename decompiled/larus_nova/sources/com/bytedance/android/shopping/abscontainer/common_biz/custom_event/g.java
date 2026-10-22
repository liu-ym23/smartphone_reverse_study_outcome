package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class g<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164245b;

    @Override // m33.a
    public final String d() {
        return this.f164245b;
    }

    public g(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164245b = "selfCrossTrigger";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("match_vo");
    L7:
        if ((r102 instanceof Map) == true) goto L9;
        r102 = null;
    L9:
        final Map r103 = (Map) r102;
        if (r100 == null) goto L12;
        Object r104 = r100.get("trigger_params");
    L14:
        if ((r104 instanceof Map) == true) goto L16;
        r104 = null;
    L16:
        Map<String, ? extends Object> r105 = (Map) r104;
        if (r100 == null) goto L19;
        Object r106 = r100.get("trigger_type");
    L21:
        if ((r106 instanceof String) == false) goto L24;
        r101 = r106;
    L24:
        String r107 = (String) r101;
        if (r107 != null) goto L27;
        r107 = "";
    L27:
        List<z33.a> r108 = this.f511708a.f507250d.c().o(new SelfCrossTriggerEvent$onExecute$matchVoNodes$1(r103));
        List<z33.a> r109 = r108;
        if (r109 != null) goto L30;
    L33:
        boolean r111 = true;
    L34:
        if (r111 == false) goto L37;
        r110.d(new m33.c(false, "matchVoNodes is null", false, null, 20));
        return;
    L37:
        Iterator<T> r112 = r108.iterator();
    L39:
        if (r112.hasNext() == false) goto L41;
        String r113 = r107;
        this.f511708a.f507250d.c().j(null, ((z33.a) r112.next()).d(), r113, r105, this.f164245b);
        goto L39
    L41:
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L30:
        if (r109.isEmpty() == true) goto L33;
        r111 = false;
        goto L34
    L19:
        r106 = null;
        goto L21
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
