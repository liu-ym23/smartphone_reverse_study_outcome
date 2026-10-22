package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.impl.hc;
import com.obric.aiagent.skill.manager.impl.hd;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPageTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<bp> f20500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final hd f20501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final hc f20502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20503d;

    public ag(d.h.a.a<? extends bp> r3, hd r4, hc r5) {
        d.h.a.a<bp> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        hc r7 = (hc) ZeusTransformUtils.wrapperContextForParams(r5, hc.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "contextProvider");
        d.h.b.o.e(r4, "reporter");
        d.h.b.o.e(r7, "logger");
        this.f20500a = r6;
        this.f20501b = r4;
        this.f20502c = r7;
    }

    public /* synthetic */ ag(d.h.a.a r8, hd r9, hc r10, int r11, d.h.b.h r12) {
        d.h.a.a r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        hc r14 = (hc) ZeusTransformUtils.wrapperContextForParams(r10, hc.class, "com.obric.aiagent.plugin");
        if ((r11 & 2) == 0) goto L6;
        r9 = new hd(null, null, null, 7, null);
    L6:
        if ((r11 & 4) == 0) goto L8;
        r14 = (hc) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.e.f19796a, hc.class, "com.obric.aiagent.plugin");
    L8:
        this(r13, r9, r14);
    }

    public final void a() {
        if (this.f20503d == false) goto L5;
        return;
    L5:
        this.f20503d = true;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L8
        Object r3 = d.n.f((bp) ZeusTransformUtils.preCheckCast(((ag) ZeusTransformUtils.preCheckCast(this, ag.class, "com.obric.aiagent.plugin")).f20500a.invoke(), bp.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L11:
        if (d.n.c(r3) == null) goto L14;
        r3 = (bp) ZeusTransformUtils.preCheckCast(new bp.a("context_provider_failure"), bp.class, "com.obric.aiagent.plugin");
    L14:
        bp r4 = (bp) ZeusTransformUtils.preCheckCast(r3, bp.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, bp.b.class) == false) goto L18;
        this.f20501b.a(((bp.b) ZeusTransformUtils.preCheckCast(r4, bp.b.class, "com.obric.aiagent.plugin")).getContext());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r4, bp.a.class) == false) goto L26;
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L21
        ((ag) ZeusTransformUtils.preCheckCast(this, ag.class, "com.obric.aiagent.plugin")).f20502c.c("enter_page", ((bp.a) ZeusTransformUtils.preCheckCast(r4, bp.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L21
        Object r6 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L21
    L23:
        d.n.g(r6);
        return;
    L21:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L23
    L26:
        throw new d.k();
    L8:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L11
    }
}
