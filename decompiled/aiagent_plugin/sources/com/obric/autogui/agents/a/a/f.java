package com.obric.autogui.agents.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectEvaluationInput.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.j f26250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.c f26252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.a.a.a.a f26253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f26254e;
    private final Long f;
    private final long g;
    private final Boolean h;
    private final boolean i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26250a, r10.f26250a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26251b, r10.f26251b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26252c, r10.f26252c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26253d, r10.f26253d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26254e, r10.f26254e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f26250a.hashCode() * 31) + this.f26251b.hashCode()) * 31) + this.f26252c.hashCode()) * 31) + this.f26253d.hashCode()) * 31;
        e r1 = this.f26254e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Long.hashCode(this.g)) * 31;
        Boolean r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + Boolean.hashCode(this.i);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectEvaluationInput(policy=" + this.f26250a + ", attemptId=" + this.f26251b + ", baseline=" + this.f26252c + ", actionEvidence=" + this.f26253d + ", directResult=" + this.f26254e + ", frameworkRegistrationToCallbackElapsedMs=" + this.f + ", frameworkCallbackWaitElapsedMs=" + this.g + ", baselineHasDynamicSurface=" + this.h + ", singleRoundForDynamicSurface=" + this.i + ')';
    }

    public f(com.obric.autogui.agents.a.f.j r2, String r3, com.obric.autogui.agents.a.l.c r4, com.obric.autogui.agents.a.a.a.a r5, e r6, Long r7, long r8, Boolean r10, boolean r11) {
        o.e(r2, "policy");
        o.e(r3, "attemptId");
        o.e(r4, "baseline");
        o.e(r5, "actionEvidence");
        this.f26250a = r2;
        this.f26251b = r3;
        this.f26252c = r4;
        this.f26253d = r5;
        this.f26254e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r11;
    }

    public final com.obric.autogui.agents.a.f.j a() {
        return this.f26250a;
    }

    public final String b() {
        return this.f26251b;
    }

    public final com.obric.autogui.agents.a.l.c c() {
        return this.f26252c;
    }

    public final com.obric.autogui.agents.a.a.a.a d() {
        return this.f26253d;
    }

    public final e e() {
        return this.f26254e;
    }

    public final Long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final Boolean h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public final com.obric.autogui.agents.a.f.a j() {
        return this.f26250a.a();
    }

    public final com.obric.autogui.agents.a.a k() {
        return new com.obric.autogui.agents.a.a(j().a(), this.f26251b);
    }
}
