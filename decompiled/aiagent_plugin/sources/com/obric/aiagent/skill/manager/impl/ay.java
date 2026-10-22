package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDeleteTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ay {
    public static final ax a(com.obric.aiagent.skill.manager.api.e r2, d.h.a.b<? super String, Boolean> r3, d.h.a.b<? super String, Boolean> r4, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, d.x> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "skill");
        d.h.b.o.e(r6, "deletePersistent");
        d.h.b.o.e(r7, "removeRegistry");
        d.h.b.o.e(r8, "report");
        ax r0 = new ax(((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(r2.a()), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r2.a()), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        if (r0.c() == true) goto L9;
    L8:
        return r0;
    L9:
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L6
        r8.invoke(r2);     // Catch: Throwable -> L6
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L8
    }
}
