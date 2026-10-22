package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28348b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28347a, r6.f28347a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28348b, r6.f28348b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f28347a.hashCode() * 31) + this.f28348b.hashCode();
    }

    public String toString() {
        return "ActionEffectReportedStatuses(first=" + this.f28347a + ", end=" + this.f28348b + ')';
    }

    public g(String r2, String r3) {
        d.h.b.o.e(r2, "first");
        d.h.b.o.e(r3, "end");
        this.f28347a = r2;
        this.f28348b = r3;
    }

    public final String a() {
        return this.f28347a;
    }

    public final String b() {
        return this.f28348b;
    }
}
