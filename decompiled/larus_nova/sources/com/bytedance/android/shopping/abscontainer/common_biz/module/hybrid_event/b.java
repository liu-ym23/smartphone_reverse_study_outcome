package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t43.d;
import u33.a;
import v43.p;

/* JADX INFO: loaded from: classes12.dex */
public final class b<STATE extends p, PROPS extends u33.a & t43.d> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164329c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164329c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164328b;
    }

    public b(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164328b = "NextPageEventModule";
        this.f164329c = "next_page_event";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        b43.c r100 = b43.c.f17507a;
        HashMap r111 = (HashMap) r110;
        Object r101 = r111.get("session_params");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r103 = (String) r101;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        Map r104 = b43.c.d(r103);
        if (r104 == null) goto L11;
        Object r105 = r104.get("session_id");
    L13:
        if ((r105 instanceof String) == true) goto L15;
        r105 = null;
    L15:
        String r106 = (String) r105;
        if (r106 != null) goto L18;
    L20:
        if (r104 == null) goto L22;
        Object r107 = r104.get("node_id");
    L24:
        if ((r107 instanceof String) == true) goto L26;
        r107 = null;
    L26:
        String r108 = (String) r107;
        if (r108 == null) goto L44;
        Object r109 = r111.get("type");
        if ((r109 instanceof String) == true) goto L31;
        r109 = null;
    L31:
        String r112 = (String) r109;
        Object r113 = r111.get(SlcCommonAction.KEY_PARAMS);
        if ((r113 instanceof String) == false) goto L35;
        r102 = r113;
    L35:
        String r114 = (String) r102;
        if (r114 != null) goto L38;
        r114 = "";
    L38:
        j33.f r115 = this.f540457a.f507250d.c();
        if (r112 != null) goto L41;
        String r116 = "";
    L42:
        r115.j(null, r108, r116, b43.c.d(r114), "handleSkuPayForFixEvent");
        return;
    L41:
        r116 = r112;
        goto L42
    L44:
        return;
    L22:
        r107 = null;
        goto L24
    L18:
        if ((!Intrinsics.areEqual(r106, this.f540457a.f507249c.f548574a.getSessionID())) == false) goto L20;
        return;
    L11:
        r105 = null;
        goto L13
    }
}
