package com.obric.aiagent.skill.credentials.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: SidecarAuthWebViewBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.m<String, String, x> f18999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<x> f19000b;

    public o(d.h.a.m<? super String, ? super String, x> r3, d.h.a.a<x> r4) {
        d.h.a.m<String, String, x> r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "loadCallback");
        d.h.b.o.e(r6, "closeCallback");
        this.f18999a = r5;
        this.f19000b = r6;
    }

    public final void a(String r2, String r3) {
        d.h.b.o.e(r2, "url");
        d.h.b.o.e(r3, "flowId");
        this.f18999a.invoke(r2, r3);
    }

    public final void a() {
        this.f19000b.invoke();
    }
}
