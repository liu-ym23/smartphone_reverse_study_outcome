package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.s;

/* JADX INFO: loaded from: classes12.dex */
public final class u0<STATE extends v43.s, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164276b;

    @Override // m33.a
    public final String d() {
        return this.f164276b;
    }

    public u0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164276b = "selfUpdateSkipTriggers";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        v43.t r101 = new v43.t(0);
        if (r100 == null) goto L5;
        Object r102 = r100.get("global_triggers");
    L7:
        if ((r102 instanceof List) == true) goto L9;
        r102 = null;
    L9:
        List r103 = (List) r102;
        if (r103 == null) goto L16;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        r104.add(new v43.u("global", (String) r105.next()));
        goto L13
    L15:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f553081a = r104;
    L16:
        if (r100 == null) goto L18;
        Object r106 = r100.get("module_infos");
    L20:
        if ((r106 instanceof List) == true) goto L22;
        r106 = null;
    L22:
        List r107 = (List) r106;
        if (r107 == null) goto L54;
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L26:
        if (r109.hasNext() == false) goto L53;
        Object r111 = r109.next();
        if ((r111 instanceof Map) == true) goto L30;
        r111 = null;
    L30:
        Map r112 = (Map) r111;
        if (r112 == null) goto L26;
        Object r113 = r112.get("module_key");
        if ((r113 instanceof String) == true) goto L35;
        r113 = null;
    L35:
        String r114 = (String) r113;
        if (r114 != null) goto L39;
        r114 = "";
    L39:
        if (r114.length() != 0) goto L41;
        boolean r115 = true;
    L42:
        if (r115 == true) goto L26;
        Object r116 = r112.get("triggers");
        if ((r116 instanceof List) == true) goto L46;
        r116 = null;
    L46:
        List r117 = (List) r116;
        if (r117 != null) goto L49;
        r117 = CollectionsKt.emptyList();
    L49:
        Iterator r118 = r117.iterator();
    L51:
        if (r118.hasNext() == false) goto L26;
        r108.add(new v43.u(r114, (String) r118.next()));
        goto L51
    L41:
        r115 = false;
        goto L42
    L53:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r101.f553082b = r108;
    L54:
        ((v43.s) this.f511708a.f507247a).l(r101);
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L18:
        r106 = null;
        goto L20
    L5:
        r102 = null;
        goto L7
    }
}
