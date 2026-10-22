package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class z<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164291b;

    @Override // m33.a
    public final String d() {
        return this.f164291b;
    }

    public z(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164291b = "selfPublishEvent";
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
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        b43.c r104 = b43.c.f17507a;
        if (b43.c.c(r103) == false) goto L16;
        r110.d(new m33.c(false, "event_name is null", false, null, 20));
        return;
    L16:
        Map<String, Object> r105 = r110.a();
        if (r105 == null) goto L19;
        Object r106 = r105.get("params");
    L21:
        if ((r106 instanceof Map) == false) goto L24;
        r101 = r106;
    L24:
        Map<String, ? extends Object> r107 = (Map) r101;
        if (r107 != null) goto L27;
        r107 = MapsKt.emptyMap();
    L27:
        this.f511708a.f507250d.d().a(r103, r107);
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L19:
        r106 = null;
        goto L21
    L5:
        r102 = null;
        goto L7
    }
}
