package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.m.c<? extends g> f22640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f22641b;

    public l() {
    }

    public final void a(d.m.c<? extends g> r3) {
        d.m.c<? extends g> r4 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f22640a = r4;
    }

    public final d.m.c<? extends g> getType() {
        d.m.c<? extends g> r0 = this.f22640a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("type");
        return null;
    }

    public final Integer a() {
        return this.f22641b;
    }

    public final void a(Integer r1) {
        this.f22641b = r1;
    }
}
