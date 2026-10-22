package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.k f28207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.k f28208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f28209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f28210d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f28207a == r6.f28207a) goto L12;
        return false;
    L12:
        if (this.f28208b == r6.f28208b) goto L15;
        return false;
    L15:
        if (this.f28209c == r6.f28209c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f28210d, r6.f28210d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f28207a.hashCode() * 31) + this.f28208b.hashCode()) * 31) + Boolean.hashCode(this.f28209c)) * 31;
        e r2 = this.f28210d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectEvaluationAggregate(startStatus=" + this.f28207a + ", endStatus=" + this.f28208b + ", completed=" + this.f28209c + ", decisiveEntry=" + this.f28210d + ')';
    }

    public b(com.obric.autogui.agents.a.f.k r2, com.obric.autogui.agents.a.f.k r3, boolean r4, e r5) {
        d.h.b.o.e(r2, "startStatus");
        d.h.b.o.e(r3, "endStatus");
        this.f28207a = r2;
        this.f28208b = r3;
        this.f28209c = r4;
        this.f28210d = r5;
    }

    public final com.obric.autogui.agents.a.f.k a() {
        return this.f28208b;
    }

    public final boolean b() {
        return this.f28209c;
    }

    public final e c() {
        return this.f28210d;
    }
}
