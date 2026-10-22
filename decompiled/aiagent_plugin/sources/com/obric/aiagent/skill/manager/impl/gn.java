package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gn {
    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.an a(s r2, com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.api.am r4) {
        return b((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    private static final com.obric.aiagent.skill.manager.api.an b(s r6, com.obric.aiagent.skill.manager.api.e r7, com.obric.aiagent.skill.manager.api.am r8) {
        s r9 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        if (d.h.b.o.a(r9, s.b.f20165a) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r9, s.a.class) == false) goto L11;
        return new com.obric.aiagent.skill.manager.api.an(r7.a(), com.obric.aiagent.skill.manager.api.am.g, ((s.a) ZeusTransformUtils.preCheckCast(r9, s.a.class, "com.obric.aiagent.plugin")).a());
    L11:
        throw new d.k();
    L13:
        return new com.obric.aiagent.skill.manager.api.an(r7.a(), r8, null, 4, null);
    }

    public static final boolean a(com.obric.aiagent.skill.manager.api.an r5) {
        d.h.b.o.e(r5, "<this>");
        if (r5.b() != com.obric.aiagent.skill.manager.api.am.g) goto L13;
        String r6 = r5.c();
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L13;
        return true;
    L7:
        if (d.o.o.b(r6, "DECISION_", false, 2, null) != true) goto L9;
        r7 = true;
    L13:
        return false;
    }
}
