package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class s0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164272b;

    @Override // m33.a
    public final String d() {
        return this.f164272b;
    }

    public s0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164272b = "selfTransformLocation";
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
        Map<String, ?> r103 = (Map) r102;
        if (r100 == null) goto L12;
        Object r104 = r100.get(SlcElement.KEY_SLICE_KEY);
    L14:
        if ((r104 instanceof String) == true) goto L16;
        r104 = null;
    L16:
        String r105 = (String) r104;
        if (r100 == null) goto L19;
        Object r106 = r100.get("ignore_null");
    L21:
        if ((r106 instanceof Boolean) == false) goto L24;
        r101 = r106;
    L24:
        boolean r107 = Intrinsics.areEqual((Boolean) r101, Boolean.TRUE);
        if (r103 != null) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == true) goto L33;
        View r109 = this.f511708a.f507250d.b().e(r103);
    L34:
        if (r109 == null) goto L37;
        if (r105 == null) goto L37;
        r109 = this.f511708a.f507250d.r().b(r109, r105);
    L37:
        Map<String, Float> r111 = this.f511708a.f507250d.b().i(r109);
        if (r107 == true) goto L45;
        if (r111 != null) goto L41;
    L42:
        r110.d(new m33.c(false, "boundingRect is empty", false, null, 20));
        return;
    L41:
        if (r111.isEmpty() == true) goto L42;
    L45:
        if (r111 != null) goto L47;
        r111 = MapsKt.emptyMap();
    L47:
        r110.d(new m33.c(true, null, false, MapsKt.mapOf(TuplesKt.to("boundingRect", r111)), 14));
        return;
    L33:
        r109 = r110.g();
        goto L34
    L27:
        if (r103.isEmpty() == true) goto L30;
        r108 = false;
        goto L31
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
