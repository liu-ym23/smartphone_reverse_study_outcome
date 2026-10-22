package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dr f19773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ds f19774b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, du.class) == true) goto L8;
        return false;
    L8:
        du r6 = (du) ZeusTransformUtils.preCheckCast(r5, du.class, "com.obric.aiagent.plugin");
        if (this.f19773a == r6.f19773a) goto L12;
        return false;
    L12:
        if (this.f19774b == r6.f19774b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19773a.hashCode() * 31) + this.f19774b.hashCode();
    }

    public String toString() {
        return "SkillPageTrackingSource(previousPage=" + this.f19773a + ", enterMethod=" + this.f19774b + ')';
    }

    public du(dr r2, ds r3) {
        d.h.b.o.e(r2, "previousPage");
        d.h.b.o.e(r3, "enterMethod");
        this.f19773a = r2;
        this.f19774b = r3;
    }

    public final dr a() {
        return this.f19773a;
    }

    public final ds b() {
        return this.f19774b;
    }
}
