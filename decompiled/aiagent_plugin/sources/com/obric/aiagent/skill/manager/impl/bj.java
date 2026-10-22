package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManager.kt */
/* JADX INFO: loaded from: classes3.dex */
final class bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bp f19565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19566b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bj.class) == true) goto L8;
        return false;
    L8:
        bj r6 = (bj) ZeusTransformUtils.preCheckCast(r5, bj.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19565a, r6.f19565a) == true) goto L12;
        return false;
    L12:
        if (this.f19566b == r6.f19566b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19565a.hashCode() * 31) + Boolean.hashCode(this.f19566b);
    }

    public String toString() {
        return "SkillExistenceCleanupResult(persistent=" + this.f19565a + ", removedRegistry=" + this.f19566b + ')';
    }

    public bj(bp r2, boolean r3) {
        d.h.b.o.e(r2, "persistent");
        this.f19565a = r2;
        this.f19566b = r3;
    }

    public final boolean a() {
        if (this.f19565a.b() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f19566b == true) goto L8;
        return false;
    }

    public final boolean b() {
        return this.f19565a.c();
    }
}
