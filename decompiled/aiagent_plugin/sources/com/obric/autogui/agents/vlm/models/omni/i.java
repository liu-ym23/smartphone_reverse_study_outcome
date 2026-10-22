package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.k f28350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f28351b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f28350a == r6.f28350a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28351b, r6.f28351b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f28350a.hashCode() * 31;
        e r1 = this.f28351b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectStatusDecision(status=" + this.f28350a + ", decisiveEntry=" + this.f28351b + ')';
    }

    public i(com.obric.autogui.agents.a.f.k r2, e r3) {
        d.h.b.o.e(r2, "status");
        this.f28350a = r2;
        this.f28351b = r3;
    }

    public final com.obric.autogui.agents.a.f.k a() {
        return this.f28350a;
    }

    public final e b() {
        return this.f28351b;
    }
}
