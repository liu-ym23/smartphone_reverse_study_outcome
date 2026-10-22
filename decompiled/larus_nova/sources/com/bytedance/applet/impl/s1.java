package com.bytedance.applet.impl;

import com.bytedance.apm.ApmAgent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class s1 implements k5.h {
    public s1() {
    }

    @Override // k5.h
    public final void b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.platform.service.o.f365780a.reportEvent(r100, r101);
    }

    @Override // k5.h
    public final void d(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.platform.service.o.f365780a.reportEvent(r100, r101);
    }

    @Override // k5.h
    public final void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ApmAgent.monitorEvent(r100, r102, r103, r101);
    }

    @Override // k5.h
    public final void c(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "errorName");
        ApmAgent.monitorEvent(r100, r102, r103, r101);
    }

    @Override // k5.h
    public final void e(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ApmAgent.monitorEvent(r100, r102, r103, r101);
    }
}
