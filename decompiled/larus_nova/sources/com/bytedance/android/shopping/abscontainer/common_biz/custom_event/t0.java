package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class t0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164274b;

    @Override // m33.a
    public final String d() {
        return this.f164274b;
    }

    public t0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164274b = "selfUpdateCommonEventParams";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.c();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("common_event_params");
    L7:
        if ((r103 instanceof Map) == true) goto L9;
        r103 = null;
    L9:
        Map r104 = (Map) r103;
        if (r104 != null) goto L12;
        r104 = MapsKt.emptyMap();
    L12:
        Map<String, Object> r105 = r100.a();
        if (r105 != null) goto L15;
        r105 = MapsKt.emptyMap();
    L15:
        Object r106 = r105.get("common_event_params");
        if ((r106 instanceof Map) == false) goto L19;
        r102 = r106;
    L19:
        Map r107 = (Map) r102;
        if (r107 != null) goto L22;
        r107 = MapsKt.emptyMap();
    L22:
        this.f511708a.f507250d.a().c(MapsKt.plus(MapsKt.plus(r104, r105), r107));
        r100.d(new m33.c(true, null, false, null, 30));
        return;
    L5:
        r103 = null;
        goto L7
    }
}
