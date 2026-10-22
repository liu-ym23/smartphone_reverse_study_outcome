package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SkillEditTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class af {
    public static final List<com.obric.aiagent.skill.manager.impl.bf> a(bb r3, bb r4) {
        d.h.b.o.e(r3, "initial");
        d.h.b.o.e(r4, "submitted");
        List r0 = d.a.p.a();
        if (d.h.b.o.a(r3.a(), r4.a()) == true) goto L6;
        r0.add(com.obric.aiagent.skill.manager.impl.bf.f19556a);
    L6:
        if (d.h.b.o.a(r3.b(), r4.b()) == true) goto L9;
        r0.add(com.obric.aiagent.skill.manager.impl.bf.f19557b);
    L9:
        if (d.h.b.o.a(r3.c(), r4.c()) == true) goto L12;
        r0.add(com.obric.aiagent.skill.manager.impl.bf.f19558c);
    L12:
        return d.a.p.a(r0);
    }

    public static final com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> a(int r3, List<? extends com.obric.aiagent.skill.manager.impl.bf> r4, d.h.a.a<? extends com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r5, d.h.a.m<? super com.obric.aiagent.skill.manager.api.e, ? super List<? extends com.obric.aiagent.skill.manager.impl.bf>, d.x> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "fields");
        d.h.b.o.e(r8, "save");
        d.h.b.o.e(r9, "report");
        com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r10 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r8.invoke(), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L5;
        com.obric.aiagent.skill.manager.api.u.b r0 = (com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L15;
        com.obric.aiagent.skill.manager.api.e r1 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r0.a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        if (r1.j() == r3) goto L15;
        r9.invoke(r1, r7);     // Catch: Exception -> L16
    L15:
        return r10;
    L5:
        r0 = null;
        goto L6
    }
}
