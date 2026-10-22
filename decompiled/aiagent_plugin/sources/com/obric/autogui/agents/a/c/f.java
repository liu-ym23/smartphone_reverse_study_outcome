package com.obric.autogui.agents.a.c;

import com.obric.autogui.agents.a.f.k;
import com.obric.autogui.agents.a.m.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectExecutionResultEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.h f26340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f26342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f26343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26344e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f26340a == r6.f26340a) goto L12;
        return false;
    L12:
        if (o.a(this.f26341b, r6.f26341b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26342c, r6.f26342c) == true) goto L18;
        return false;
    L18:
        if (this.f26343d == r6.f26343d) goto L21;
        return false;
    L21:
        if (o.a(this.f26344e, r6.f26344e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f26340a.hashCode() * 31) + this.f26341b.hashCode()) * 31) + this.f26342c.hashCode()) * 31) + this.f26343d.hashCode()) * 31) + this.f26344e.hashCode();
    }

    public String toString() {
        return "ActionEffectExecutionResultEvaluation(action=" + this.f26340a + ", attemptId=" + this.f26341b + ", facts=" + this.f26342c + ", status=" + this.f26343d + ", detectionReason=" + this.f26344e + ')';
    }

    public f(com.obric.autogui.agents.a.f.h r2, String r3, h r4, k r5, String r6) {
        o.e(r2, "action");
        o.e(r3, "attemptId");
        o.e(r4, "facts");
        o.e(r5, "status");
        o.e(r6, "detectionReason");
        this.f26340a = r2;
        this.f26341b = r3;
        this.f26342c = r4;
        this.f26343d = r5;
        this.f26344e = r6;
    }

    public final h a() {
        return this.f26342c;
    }

    public final com.obric.autogui.agents.a.f.g a(v r17) {
        o.e(r17, "timingReport");
        String r3 = this.f26341b;
        String r4 = this.f26340a.a();
        k r6 = this.f26343d;
        com.obric.autogui.agents.a.f.f r7 = com.obric.autogui.agents.a.f.f.f26420d;
        Integer r1 = Integer.valueOf(this.f26342c.b());
        ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (this.f26343d != k.f26446e) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        return new com.obric.autogui.agents.a.f.g(r3, r4, r6, r6, r7, r1, null, this.f26344e, null, r17, null, 1344, null);
    L5:
        r2 = false;
        goto L6
    }
}
