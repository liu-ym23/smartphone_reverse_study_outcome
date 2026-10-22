package com.obric.aiagent.skill.manager.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: SkillScanPerformanceState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19824e;
    private final long f;
    private final String g;
    private final String h;
    private final Map<String, Integer> i;
    private final int j;
    private final int k;
    private final long l;
    private final long m;
    private final boolean n;

    public static /* synthetic */ ej a(ej r16, int r17, String r18, int r19, long r20, String r22, long r23, String r25, String r26, Map r27, int r28, int r29, long r30, long r32, boolean r34, int r35, Object r36) {
        Map<String, Integer> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
        if ((r35 & 1) == 0) goto L5;
        int r3 = r16.f19820a;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r4 = r16.f19821b;
    L11:
        if ((r35 & 4) == 0) goto L13;
        int r5 = r16.f19822c;
    L15:
        if ((r35 & 8) == 0) goto L17;
        long r6 = r16.f19823d;
    L19:
        if ((r35 & 16) == 0) goto L21;
        String r8 = r16.f19824e;
    L23:
        if ((r35 & 32) == 0) goto L25;
        long r9 = r16.f;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r11 = r16.g;
    L31:
        if ((r35 & 128) == 0) goto L33;
        String r12 = r16.h;
    L35:
        if ((r35 & 256) == 0) goto L38;
        r2 = r16.i;
    L38:
        if ((r35 & 512) == 0) goto L40;
        int r13 = r16.j;
    L42:
        if ((r35 & 1024) == 0) goto L44;
        int r14 = r16.k;
    L45:
        int r210 = r14;
        if ((r35 & 2048) == 0) goto L48;
        long r15 = r16.l;
    L49:
        long r31 = r15;
        if ((r35 & 4096) == 0) goto L52;
        long r110 = r16.m;
    L54:
        if ((r35 & 8192) == 0) goto L56;
        boolean r1 = r16.n;
    L58:
        return r16.a(r3, r4, r5, r6, r8, r9, r11, r12, r2, r13, r210, r31, r110, r1);
    L56:
        r1 = r34;
        goto L58
    L52:
        r110 = r32;
        goto L54
    L48:
        r15 = r30;
        goto L49
    L44:
        r14 = r29;
        goto L45
    L40:
        r13 = r28;
        goto L42
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r6 = r20;
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

    public final ej a(int r21, String r22, int r23, long r24, String r26, long r27, String r29, String r30, Map<String, Integer> r31, int r32, int r33, long r34, long r36, boolean r38) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r22, "slug");
        d.h.b.o.e(r26, DBDefinition.TASK_ID);
        d.h.b.o.e(r29, "traceId");
        d.h.b.o.e(r0, "operationAttempts");
        return new ej(r21, r22, r23, r24, r26, r27, r29, r30, r0, r32, r33, r34, r36, r38);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ej.class) == true) goto L8;
        return false;
    L8:
        ej r10 = (ej) ZeusTransformUtils.preCheckCast(r9, ej.class, "com.obric.aiagent.plugin");
        if (this.f19820a == r10.f19820a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19821b, r10.f19821b) == true) goto L15;
        return false;
    L15:
        if (this.f19822c == r10.f19822c) goto L18;
        return false;
    L18:
        if (this.f19823d == r10.f19823d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19824e, r10.f19824e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
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
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
        return false;
    L45:
        if (this.m == r10.m) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((Integer.hashCode(this.f19820a) * 31) + this.f19821b.hashCode()) * 31) + Integer.hashCode(this.f19822c)) * 31) + Long.hashCode(this.f19823d)) * 31) + this.f19824e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
        String r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((r0 + r2) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Long.hashCode(this.m)) * 31) + Boolean.hashCode(this.n);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SkillScanPerformanceState(schemaVersion=").append(this.f19820a).append(", slug=").append(this.f19821b).append(", skillVersion=").append(this.f19822c).append(", generation=").append(this.f19823d).append(", taskId=").append(this.f19824e).append(", taskStartedElapsedMs=").append(this.f).append(", traceId=").append(this.g).append(", parentTraceId=").append(this.h).append(", operationAttempts=").append(this.i).append(", processingPollCount=").append(this.j).append(", queryFailureCount=").append(this.k).append(", queryDurationMs=");
        r0.append(this.l).append(", queryMaxDurationMs=").append(this.m).append(", timeoutReported=").append(this.n).append(')');
        return r0.toString();
    }

    public ej(int r8, String r9, int r10, long r11, String r13, long r14, String r16, String r17, Map<String, Integer> r18, int r19, int r20, long r21, long r23, boolean r25) {
        Map<String, Integer> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "slug");
        d.h.b.o.e(r13, DBDefinition.TASK_ID);
        d.h.b.o.e(r16, "traceId");
        d.h.b.o.e(r4, "operationAttempts");
        this.f19820a = r8;
        this.f19821b = r9;
        this.f19822c = r10;
        this.f19823d = r11;
        this.f19824e = r13;
        this.f = r14;
        this.g = r16;
        this.h = r17;
        this.i = r4;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r23;
        this.n = r25;
    }

    public final String a() {
        return this.f19821b;
    }

    public final int b() {
        return this.f19822c;
    }

    public final long c() {
        return this.f19823d;
    }

    public final String d() {
        return this.f19824e;
    }

    public final long e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public /* synthetic */ ej(int r23, String r24, int r25, long r26, String r28, long r29, String r31, String r32, Map r33, int r34, int r35, long r36, long r38, boolean r40, int r41, d.h.b.h r42) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        if ((r41 & 1) == 0) goto L5;
        int r4 = 1;
    L7:
        if ((r41 & 16) == 0) goto L9;
        String r9 = "";
    L11:
        if ((r41 & 32) == 0) goto L13;
        long r10 = 0;
    L15:
        if ((r41 & 128) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r41 & 256) == 0) goto L21;
        r1 = d.a.ao.b();
    L21:
        Map r14 = r1;
        if ((r41 & 512) == 0) goto L24;
        int r15 = 0;
    L26:
        if ((r41 & 1024) == 0) goto L28;
        int r16 = 0;
    L30:
        if ((r41 & 2048) == 0) goto L32;
        long r17 = 0;
    L34:
        if ((r41 & 4096) == 0) goto L36;
        long r19 = 0;
    L38:
        if ((r41 & 8192) == 0) goto L40;
        boolean r21 = false;
    L41:
        this(r4, r24, r25, r26, r9, r10, r31, r13, r14, r15, r16, r17, r19, r21);
        return;
    L40:
        r21 = r40;
        goto L41
    L36:
        r19 = r38;
        goto L38
    L32:
        r17 = r36;
        goto L34
    L28:
        r16 = r35;
        goto L30
    L24:
        r15 = r34;
        goto L26
    L17:
        r13 = r32;
        goto L19
    L13:
        r10 = r29;
        goto L15
    L9:
        r9 = r28;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }

    public final Map<String, Integer> h() {
        return this.i;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final long k() {
        return this.l;
    }

    public final long l() {
        return this.m;
    }

    public final boolean m() {
        return this.n;
    }
}
