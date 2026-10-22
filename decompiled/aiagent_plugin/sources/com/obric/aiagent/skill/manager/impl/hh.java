package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f20106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d.h.a.a<d.x>> f20107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20108c;

    public hh(d.h.a.a<d.x> r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "initialCallback");
        this.f20106a = new Object();
        this.f20107b = d.a.p.c(new d.h.a.a[]{r4});
    }

    public final void a(d.h.a.a<d.x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "callback");
        Object r0 = this.f20106a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f20108c == false) goto L7;
        boolean r3 = true;
    L9:
        monitor-exit(r0);
        if (r3 == false) goto L18;
        r5.invoke();
        return;
    L18:
        return;
    L7:
        ((Collection) ZeusTransformUtils.preCheckCast(this.f20107b, Collection.class, "com.obric.aiagent.plugin")).add(r5);     // Catch: Throwable -> L13
        r3 = false;
        goto L9
    }

    public final void a() {
        Object r0 = this.f20106a;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.f20108c == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        this.f20108c = true;     // Catch: Throwable -> L16
        List r1 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f20107b, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        this.f20107b.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r4.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        goto L13
    }
}
