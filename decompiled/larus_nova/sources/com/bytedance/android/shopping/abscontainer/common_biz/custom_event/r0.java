package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class r0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164270b;

    @Override // m33.a
    public final String d() {
        return this.f164270b;
    }

    public r0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164270b = "selfTracker";
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
        if (r100 == null) goto L14;
        Object r104 = r100.get("params");
    L16:
        if ((r104 instanceof Map) == false) goto L19;
        r101 = r104;
    L19:
        Map<String, ? extends Object> r105 = (Map) r101;
        if (r105 != null) goto L23;
        r105 = MapsKt.emptyMap();
    L23:
        if (r103.length() != 0) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L29;
        r110.d(new m33.c(false, "event_name is empty", false, null, 20));
        return;
    L29:
        this.f511708a.f507250d.a().a(r103, r105);
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L25:
        r106 = false;
        goto L26
    L14:
        r104 = null;
        goto L16
    L5:
        r102 = null;
        goto L7
    }
}
