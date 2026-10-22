package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u33.a;
import v43.r;

/* JADX INFO: loaded from: classes12.dex */
public final class m<STATE extends v43.r, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164257b;

    @Override // m33.a
    public final String d() {
        return this.f164257b;
    }

    public m(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164257b = "selfHandleEventWhenAppear";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(ReportCardMonitorPlugin.EVENT_NAME);
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r100 == null) goto L12;
        Object r104 = r100.get("opportunity");
    L14:
        if ((r104 instanceof String) == true) goto L16;
        r104 = null;
    L16:
        String r105 = (String) r104;
        if (r100 == null) goto L19;
        Object r106 = r100.get("need_hold");
    L21:
        if ((r106 instanceof Boolean) == false) goto L24;
        r101 = r106;
    L24:
        Boolean r107 = (Boolean) r101;
        boolean r108 = false;
        if (r107 == null) goto L27;
        boolean r109 = r107.booleanValue();
    L28:
        String r111 = r110.f();
        if (r103 != null) goto L31;
    L34:
        boolean r112 = true;
    L35:
        if (r112 == true) goto L49;
        if (r105 != null) goto L38;
    L41:
        boolean r113 = true;
    L42:
        if (r113 == true) goto L49;
        if (r111 != null) goto L45;
    L46:
        r108 = true;
    L47:
        if (r108 == true) goto L49;
        ((v43.r) this.f511708a.f507247a).u().put(r105, new v43.q(r103, r105, r109, r111));
        goto L49
    L45:
        if (StringsKt.isBlank(r111) == false) goto L47;
    L38:
        if (StringsKt.isBlank(r105) == true) goto L41;
        r113 = false;
    L49:
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L31:
        if (StringsKt.isBlank(r103) == true) goto L34;
        r112 = false;
        goto L35
    L27:
        r109 = false;
        goto L28
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
