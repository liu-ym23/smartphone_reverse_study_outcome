package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cc {
    public static final /* synthetic */ bt a(int r0, int r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ bv a(String r2, Map r3, Set r4, Set r5) {
        return b(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
    }

    private static final bt b(int r1, int r2) {
        if (r2 <= 1) goto L12;
        if (r1 != 0) goto L8;
        return bt.f20670b;
    L8:
        if (r1 != (r2 - 1)) goto L11;
        return bt.f20672d;
    L11:
        return bt.f20671c;
    L12:
        return bt.f20669a;
    }

    private static final bv b(String r2, Map<String, com.obric.aiagent.skill.manager.api.e> r3, Set<String> r4, Set<String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6.get(r2), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r7.contains(r2) == false) goto L6;
        return bv.f20684b;
    L6:
        if (r8.contains(r2) == true) goto L21;
        boolean r10 = true;
        if (r9 != null) goto L11;
    L13:
        r10 = false;
    L14:
        if (r10 == true) goto L22;
        if (r9 == null) goto L19;
        return bv.f20687e;
    L19:
        return bv.f20683a;
    L22:
        return bv.f20686d;
    L11:
        if (r9.l() != true) goto L13;
    L21:
        return bv.f20685c;
    }
}
