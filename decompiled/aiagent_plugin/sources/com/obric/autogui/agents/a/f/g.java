package com.obric.autogui.agents.a.f;

import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectResultModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f26424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f26425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f26426e;
    private final Integer f;
    private final c g;
    private final String h;
    private final String i;
    private final v j;
    private final Boolean k;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26422a, r6.f26422a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26423b, r6.f26423b) == true) goto L15;
        return false;
    L15:
        if (this.f26424c == r6.f26424c) goto L18;
        return false;
    L18:
        if (this.f26425d == r6.f26425d) goto L21;
        return false;
    L21:
        if (this.f26426e == r6.f26426e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (o.a(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f26422a.hashCode() * 31) + this.f26423b.hashCode()) * 31) + this.f26424c.hashCode()) * 31) + this.f26425d.hashCode()) * 31) + this.f26426e.hashCode()) * 31;
        Integer r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        c r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        v r8 = this.j;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.k;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ActionEffectEvaluationResult(attemptId=").append(this.f26422a).append(", actionType=").append(this.f26423b).append(", startStatus=").append(this.f26424c).append(", endStatus=").append(this.f26425d).append(", mode=").append(this.f26426e).append(", executionErrorCode=").append(this.f).append(", servedDetector=").append(this.g).append(", detectionReason=").append(this.h).append(", logDetails=").append(this.i).append(", timingReport=").append(this.j).append(", hasDynamicSurface=").append(this.k).append(')');
        return r0.toString();
    }

    public g(String r2, String r3, k r4, k r5, f r6, Integer r7, c r8, String r9, String r10, v r11, Boolean r12) {
        o.e(r2, "attemptId");
        o.e(r3, "actionType");
        o.e(r4, "startStatus");
        o.e(r5, "endStatus");
        o.e(r6, "mode");
        o.e(r9, "detectionReason");
        o.e(r10, "logDetails");
        this.f26422a = r2;
        this.f26423b = r3;
        this.f26424c = r4;
        this.f26425d = r5;
        this.f26426e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public /* synthetic */ g(String r16, String r17, k r18, k r19, f r20, Integer r21, c r22, String r23, String r24, v r25, Boolean r26, int r27, d.h.b.h r28) {
        if ((r27 & 32) == 0) goto L5;
        Integer r9 = null;
    L7:
        if ((r27 & 64) == 0) goto L9;
        c r10 = null;
    L11:
        if ((r27 & 128) == 0) goto L13;
        String r11 = "";
    L15:
        if ((r27 & 256) == 0) goto L17;
        String r12 = "";
    L19:
        if ((r27 & 512) == 0) goto L21;
        v r13 = null;
    L23:
        if ((r27 & 1024) == 0) goto L25;
        Boolean r14 = null;
    L26:
        this(r16, r17, r18, r19, r20, r9, r10, r11, r12, r13, r14);
        return;
    L25:
        r14 = r26;
        goto L26
    L21:
        r13 = r25;
        goto L23
    L17:
        r12 = r24;
        goto L19
    L13:
        r11 = r23;
        goto L15
    L9:
        r10 = r22;
        goto L11
    L5:
        r9 = r21;
        goto L7
    }

    public final String a() {
        return this.f26422a;
    }

    public final String b() {
        return this.f26423b;
    }

    public final k c() {
        return this.f26424c;
    }

    public final k d() {
        return this.f26425d;
    }

    public final f e() {
        return this.f26426e;
    }

    public final Integer f() {
        return this.f;
    }

    public final c g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final v j() {
        return this.j;
    }

    public final Boolean k() {
        return this.k;
    }

    public final s l() {
        v r0 = this.j;
        if (r0 == null) goto L8;
        com.obric.autogui.agents.a.m.g r1 = r0.j();
        if (r1 == null) goto L8;
        s r2 = r1.c();
        if (r2 == null) goto L8;
        return r2;
    L8:
        v r3 = this.j;
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.d();
    }
}
