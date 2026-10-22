package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PersistentSkillRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f20932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20933b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, x.class) == true) goto L8;
        return false;
    L8:
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20932a, r6.f20932a) == true) goto L12;
        return false;
    L12:
        if (this.f20933b == r6.f20933b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20932a.hashCode() * 31) + Integer.hashCode(this.f20933b);
    }

    public String toString() {
        return "LocalPackageApplyOutcome(skill=" + this.f20932a + ", previousVersion=" + this.f20933b + ')';
    }

    public x(com.obric.aiagent.skill.manager.api.e r2, int r3) {
        d.h.b.o.e(r2, "skill");
        this.f20932a = r2;
        this.f20933b = r3;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f20932a;
    }

    public final int b() {
        return this.f20933b;
    }
}
