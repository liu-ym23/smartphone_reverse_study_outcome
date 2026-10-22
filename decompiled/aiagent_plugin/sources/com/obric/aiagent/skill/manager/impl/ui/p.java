package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShopSkillState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f20806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f20807b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20806a, r6.f20806a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20807b, r6.f20807b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f20806a.hashCode() * 31;
        com.obric.aiagent.skill.manager.api.e r1 = this.f20807b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ShopSkillState(remote=" + this.f20806a + ", installed=" + this.f20807b + ')';
    }

    public p(com.obric.aiagent.skill.manager.api.e r2, com.obric.aiagent.skill.manager.api.e r3) {
        d.h.b.o.e(r2, "remote");
        this.f20806a = r2;
        this.f20807b = r3;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        com.obric.aiagent.skill.manager.api.e r1 = this.f20807b;
        if (r1 == null) goto L5;
        com.obric.aiagent.skill.manager.api.e r2 = this.f20806a;
        boolean r14 = r1.l();
        boolean r15 = r1.m();
        return com.obric.aiagent.skill.manager.api.e.a(r2, null, null, null, null, null, null, r1.g(), null, null, 0, null, r14, r15, r1.n(), r1.o(), r1.p(), null, 67519, null);
    L5:
        return com.obric.aiagent.skill.manager.api.e.a(this.f20806a, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, 124927, null);
    }
}
