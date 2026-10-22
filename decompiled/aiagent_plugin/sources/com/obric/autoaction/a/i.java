package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.m.c<? extends f> f22636a;

    public i() {
    }

    public final void a(d.m.c<? extends f> r3) {
        d.m.c<? extends f> r4 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f22636a = r4;
    }

    public final d.m.c<? extends f> getType() {
        d.m.c<? extends f> r0 = this.f22636a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("type");
        return null;
    }
}
