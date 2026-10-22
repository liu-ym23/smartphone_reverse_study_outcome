package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dy f19781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final dz f19782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19785e;
    private final String f;
    private final Integer g;
    private final String h;
    private final String i;
    private final String j;
    private final dw k;
    private final String l;
    private final Boolean m;
    private final Boolean n;
    private final Map<String, Object> o;

    public static /* synthetic */ dx a(dx r16, dy r17, dz r18, long r19, String r21, int r22, String r23, Integer r24, String r25, String r26, String r27, dw r28, String r29, Boolean r30, Boolean r31, Map r32, int r33, Object r34) {
        Map<String, ? extends Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        if ((r33 & 1) == 0) goto L5;
        dy r3 = r16.f19781a;
    L7:
        if ((r33 & 2) == 0) goto L9;
        dz r4 = r16.f19782b;
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r5 = r16.f19783c;
    L15:
        if ((r33 & 8) == 0) goto L17;
        String r7 = r16.f19784d;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r8 = r16.f19785e;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r9 = r16.f;
    L27:
        if ((r33 & 64) == 0) goto L29;
        Integer r10 = r16.g;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r11 = r16.h;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r12 = r16.i;
    L39:
        if ((r33 & 512) == 0) goto L41;
        String r13 = r16.j;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        dw r14 = r16.k;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        String r15 = r16.l;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        Boolean r6 = r16.m;
    L54:
        Boolean r35 = r6;
        if ((r33 & 8192) == 0) goto L57;
        Boolean r20 = r16.n;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        Map<String, ? extends Object> r1 = r16.o;
    L63:
        return r16.a(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r35, r20, r1);
    L61:
        r1 = r2;
        goto L63
    L57:
        r20 = r31;
        goto L59
    L53:
        r6 = r30;
        goto L54
    L49:
        r15 = r29;
        goto L51
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public final dx a(dy r20, dz r21, long r22, String r24, int r25, String r26, Integer r27, String r28, String r29, String r30, dw r31, String r32, Boolean r33, Boolean r34, Map<String, ? extends Object> r35) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r20, "operation");
        d.h.b.o.e(r21, "result");
        d.h.b.o.e(r24, "traceId");
        d.h.b.o.e(r0, "dimensions");
        return new dx(r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r0);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, dx.class) == true) goto L8;
        return false;
    L8:
        dx r10 = (dx) ZeusTransformUtils.preCheckCast(r9, dx.class, "com.obric.aiagent.plugin");
        if (this.f19781a == r10.f19781a) goto L12;
        return false;
    L12:
        if (this.f19782b == r10.f19782b) goto L15;
        return false;
    L15:
        if (this.f19783c == r10.f19783c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19784d, r10.f19784d) == true) goto L21;
        return false;
    L21:
        if (this.f19785e == r10.f19785e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (d.h.b.o.a(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (d.h.b.o.a(this.o, r10.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f19781a.hashCode() * 31) + this.f19782b.hashCode()) * 31) + Long.hashCode(this.f19783c)) * 31) + this.f19784d.hashCode()) * 31) + Integer.hashCode(this.f19785e)) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.j;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        dw r17 = this.k;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.l;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.m;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Boolean r26 = this.n;
        if (r26 == null) goto L39;
        r2 = r26.hashCode();
    L39:
        return ((r25 + r2) * 31) + this.o.hashCode();
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
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
        r0.append("SkillPerformanceEvent(operation=").append(this.f19781a).append(", result=").append(this.f19782b).append(", durationMs=").append(this.f19783c).append(", traceId=").append(this.f19784d).append(", attemptIndex=").append(this.f19785e).append(", skillId=").append(this.f).append(", skillVersion=").append(this.g).append(", skillSource=").append(this.h).append(", taskId=").append(this.i).append(", parentTraceId=").append(this.j).append(", errorCode=").append(this.k).append(", failureStage=");
        r0.append(this.l).append(", retryable=").append(this.m).append(", willRetry=").append(this.n).append(", dimensions=").append(this.o).append(')');
        return r0.toString();
    }

    public dx(dy r8, dz r9, long r10, String r12, int r13, String r14, Integer r15, String r16, String r17, String r18, dw r19, String r20, Boolean r21, Boolean r22, Map<String, ? extends Object> r23) {
        Map<String, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "operation");
        d.h.b.o.e(r9, "result");
        d.h.b.o.e(r12, "traceId");
        d.h.b.o.e(r4, "dimensions");
        this.f19781a = r8;
        this.f19782b = r9;
        this.f19783c = r10;
        this.f19784d = r12;
        this.f19785e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r4;
    }

    public final dy a() {
        return this.f19781a;
    }

    public final dz b() {
        return this.f19782b;
    }

    public final long c() {
        return this.f19783c;
    }

    public final String d() {
        return this.f19784d;
    }

    public final int e() {
        return this.f19785e;
    }

    public final String f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final dw k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final Boolean m() {
        return this.m;
    }

    public final Boolean n() {
        return this.n;
    }

    public /* synthetic */ dx(dy r21, dz r22, long r23, String r25, int r26, String r27, Integer r28, String r29, String r30, String r31, dw r32, String r33, Boolean r34, Boolean r35, Map r36, int r37, d.h.b.h r38) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        if ((r37 & 16) == 0) goto L5;
        int r9 = 1;
    L7:
        if ((r37 & 32) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r37 & 64) == 0) goto L13;
        Integer r11 = null;
    L15:
        if ((r37 & 128) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r37 & 256) == 0) goto L21;
        String r13 = null;
    L23:
        if ((r37 & 512) == 0) goto L25;
        String r14 = null;
    L27:
        if ((r37 & 1024) == 0) goto L29;
        dw r15 = null;
    L31:
        if ((r37 & 2048) == 0) goto L33;
        String r16 = null;
    L35:
        if ((r37 & 4096) == 0) goto L37;
        Boolean r17 = null;
    L39:
        if ((r37 & 8192) == 0) goto L41;
        Boolean r18 = null;
    L43:
        if ((r37 & 16384) == 0) goto L45;
        r1 = d.a.ao.b();
    L45:
        this(r21, r22, r23, r25, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r1);
        return;
    L41:
        r18 = r35;
        goto L43
    L37:
        r17 = r34;
        goto L39
    L33:
        r16 = r33;
        goto L35
    L29:
        r15 = r32;
        goto L31
    L25:
        r14 = r31;
        goto L27
    L21:
        r13 = r30;
        goto L23
    L17:
        r12 = r29;
        goto L19
    L13:
        r11 = r28;
        goto L15
    L9:
        r10 = r27;
        goto L11
    L5:
        r9 = r26;
        goto L7
    }

    public final Map<String, Object> o() {
        return this.o;
    }

    public final dx a(com.obric.aiagent.skill.manager.api.e r20) {
        if (r20 != null) goto L4;
        return this;
    L4:
        String r7 = r20.a();
        Integer r8 = Integer.valueOf(r20.j());
        com.obric.aiagent.skill.manager.api.aq r0 = r20.g();
        if (r0 == null) goto L7;
        String r1 = r0.a();
    L9:
        return a(this, null, null, 0, null, 0, r7, r8, r1, null, null, null, null, null, null, null, 32543, null);
    L7:
        r1 = null;
        goto L9
    }
}
