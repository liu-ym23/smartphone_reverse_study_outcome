package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillScanPerformanceState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ej f19818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19819b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ei.class) == true) goto L8;
        return false;
    L8:
        ei r6 = (ei) ZeusTransformUtils.preCheckCast(r5, ei.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19818a, r6.f19818a) == true) goto L12;
        return false;
    L12:
        if (this.f19819b == r6.f19819b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19818a.hashCode() * 31) + Integer.hashCode(this.f19819b);
    }

    public String toString() {
        return "SkillScanPerformanceAttempt(state=" + this.f19818a + ", attemptIndex=" + this.f19819b + ')';
    }

    public ei(ej r2, int r3) {
        d.h.b.o.e(r2, "state");
        this.f19818a = r2;
        this.f19819b = r3;
    }

    public final ej a() {
        return this.f19818a;
    }

    public final int b() {
        return this.f19819b;
    }
}
