package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillFeatureVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bs f19588a = null;

    static {
        f19588a = new bs();
    }

    private bs() {
    }

    public static /* synthetic */ boolean a(bs r0, com.obric.aiagent.skill.manager.api.al r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
    L6:
        return r0.a(r1);
    }

    public final boolean a(com.obric.aiagent.skill.manager.api.al r1) {
        d.h.b.o.e(r1, "settings");
        return r1.x();
    }

    public final boolean b(com.obric.aiagent.skill.manager.api.al r1) {
        d.h.b.o.e(r1, "settings");
        return r1.y();
    }

    public final boolean a(String r3, com.obric.aiagent.skill.manager.api.al r4) {
        d.h.b.o.e(r3, "slug");
        d.h.b.o.e(r4, "settings");
        if (d.h.b.o.a(r3, "skill-creator") == false) goto L8;
        if (r4.x() == true) goto L13;
        return true;
    L13:
        return false;
    L8:
        if (d.h.b.o.a(r3, "skill-installer") == false) goto L13;
        if (r4.y() == true) goto L13;
        return true;
    }

    public final boolean a(com.obric.aiagent.skill.manager.api.e r2, com.obric.aiagent.skill.manager.api.al r3) {
        d.h.b.o.e(r2, "skill");
        d.h.b.o.e(r3, "settings");
        return a(r2.a(), r3);
    }

    public static /* synthetic */ List a(bs r1, List r2, com.obric.aiagent.skill.manager.api.al r3, int r4, Object r5) {
        List<com.obric.aiagent.skill.manager.api.e> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
    L6:
        return r1.a(r6, r3);
    }

    public final List<com.obric.aiagent.skill.manager.api.e> a(List<com.obric.aiagent.skill.manager.api.e> r5, com.obric.aiagent.skill.manager.api.al r6) {
        List<com.obric.aiagent.skill.manager.api.e> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "skills");
        d.h.b.o.e(r6, "settings");
        if (r6.x() == true) goto L5;
    L7:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L14;
        Object r1 = r9.next();
        com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (f19588a.a(r2, r6) == true) goto L9;
        r8.add(r1);
        goto L9
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L5:
        if (r6.y() == false) goto L7;
        return r4;
    }
}
