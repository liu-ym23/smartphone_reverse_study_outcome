package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillEditGuards.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bg {
    public static final void a(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "<this>");
        if (az.c(r1) == false) goto L6;
        return;
    L6:
        throw new dk();
    }

    public static final void b(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.d.class) == false) goto L6;
        return;
    L6:
        throw new dk();
    }

    public static final boolean a(di r1) {
        d.h.b.o.e(r1, "<this>");
        if (r1 != di.f19744b) goto L5;
    L8:
        return true;
    L5:
        if (r1 == di.f19746d) goto L8;
        return false;
    }

    public static final di a(com.obric.aiagent.skill.manager.api.aj r2) {
        com.obric.aiagent.skill.manager.api.aj r3 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (d.h.b.o.a(r3, com.obric.aiagent.skill.manager.api.aj.c.f19187a) == false) goto L5;
    L30:
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.a.class) == true) goto L30;
        if (d.h.b.o.a(r3, com.obric.aiagent.skill.manager.api.aj.d.f19189a) == false) goto L11;
        return di.f19743a;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.e.class) == false) goto L23;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.aj.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.aj.e.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L34;
        return di.f19746d;
    L34:
        return di.f19744b;
    L15:
        if (d.o.o.d(r4) == true) goto L18;
        r5 = false;
        goto L19
    L23:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.b.class) == false) goto L29;
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.aj.b) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.aj.b.class, "com.obric.aiagent.plugin")).b(), "SECURITY_RESULT_UNAVAILABLE") == false) goto L36;
        return di.f19746d;
    L36:
        return di.f19745c;
    L29:
        throw new d.k();
    }

    public static final void c(com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r3, "<this>");
        di r0 = a(r3.i());
        if (r0 != null) goto L6;
        return;
    L6:
        throw new dh(r0, r3.a(), r3.i().a());
    }
}
