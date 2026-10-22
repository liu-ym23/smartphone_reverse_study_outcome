package com.bytedance.android.shopping.abscontainer.common_biz.module;

import com.bytedance.android.shopping.abscontainer.common_biz.util.TargetViewFinder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class d<STATE extends g, PROPS extends u33.a> extends s33.b<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164317b;

    @Override // s33.b
    public final void r() {
        Object r100 = this.f540457a.f507250d.c().e("scroller_listener_start");
        if ((r100 instanceof List) == true) goto L5;
        r100 = null;
    L5:
        List r101 = (List) r100;
        if (r101 == null) goto L33;
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L47;
        Object r103 = r102.next();
        if ((r103 instanceof Map) == true) goto L13;
        r103 = null;
    L13:
        Map r104 = (Map) r103;
        if (r104 == null) goto L9;
        Object r105 = r104.get("target_component_name");
        if ((r105 instanceof String) == true) goto L19;
        r105 = null;
    L19:
        String r106 = (String) r105;
        if (r106 == null) goto L9;
        Object r107 = r104.get("target_yata_key");
        if ((r107 instanceof String) == true) goto L25;
        r107 = null;
    L25:
        String r108 = (String) r107;
        if (r108 == null) goto L9;
        z33.a r109 = TargetViewFinder.a(this.f540457a.f507250d.c(), r106, r108);
        if (r109 == null) goto L9;
        String r110 = r109.d();
        if (r110 == null) goto L9;
        this.f540457a.f507250d.c().j(null, r110, "onBodyContainerScrolled", null, "onBodyContainerScrolled");
        goto L9
    L47:
        return;
    }

    @Override // s33.b
    public final String j() {
        return this.f164317b;
    }

    public d(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164317b = "ScrollNotifyModule";
    }
}
