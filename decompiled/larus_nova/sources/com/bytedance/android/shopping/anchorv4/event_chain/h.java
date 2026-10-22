package com.bytedance.android.shopping.anchorv4.event_chain;

import com.bytedance.android.ecom.arch.slice.action.v;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements v96.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f166746a;

    @Override // v96.h
    public final void c(Map<String, ? extends Object> r100) {
    }

    public h(v r100) {
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        this.f166746a = r100;
    }

    @Override // v96.h
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r100, "btm");
    }

    @Override // v96.h
    public final void a(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        int r102 = jq.a.f500015a;
        jq.a r103 = jq.a.C6473a.a(r101);
        if (r103 == null) goto L6;
        this.f166746a.a(r103, r101, null);
        return;
    }
}
