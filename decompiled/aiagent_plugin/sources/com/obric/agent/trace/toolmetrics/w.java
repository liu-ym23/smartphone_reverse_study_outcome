package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: OmniClientToolTraceState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f15935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f15936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f15937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f15938e;
    private final String f;
    private final Boolean g;
    private final long h;
    private final Long i;
    private final Long j;
    private final Long k;
    private final long l;
    private final String m;
    private final String n;
    private final y o;
    private final m p;
    private final m q;
    private final Long r;
    private final Map<String, Object> s;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, w.class) == true) goto L8;
        return false;
    L8:
        w r10 = (w) ZeusTransformUtils.preCheckCast(r9, w.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15934a, r10.f15934a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15935b, r10.f15935b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15936c, r10.f15936c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15937d, r10.f15937d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f15938e, r10.f15938e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (d.h.b.o.a(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (d.h.b.o.a(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (d.h.b.o.a(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (d.h.b.o.a(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (d.h.b.o.a(this.s, r10.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f15934a.hashCode() * 31) + this.f15935b.hashCode()) * 31) + this.f15936c.hashCode()) * 31;
        Long r1 = this.f15937d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f15938e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Long.hashCode(this.h)) * 31;
        Long r14 = this.i;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.j;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.k;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((r19 + r21) * 31) + Long.hashCode(this.l)) * 31;
        String r23 = this.m;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (((((r22 + r24) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31;
        m r26 = this.p;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        m r29 = this.q;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        Long r32 = this.r;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return ((r31 + r2) * 31) + this.s.hashCode();
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
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
        r0.append("OmniClientToolTraceSnapshot(traceId=").append(this.f15934a).append(", meta=").append(this.f15935b).append(", correlation=").append(this.f15936c).append(", t00ElapsedMs=").append(this.f15937d).append(", clientReceivePushTimestampMs=").append(this.f15938e).append(", omniTaskStateAtPush=").append(this.f).append(", isOmniTaskActiveAtPush=").append(this.g).append(", t0ElapsedMs=").append(this.h).append(", t1ElapsedMs=").append(this.i).append(", t2ElapsedMs=").append(this.j).append(", t3ElapsedMs=").append(this.k).append(", lastObservedElapsedMs=");
        r0.append(this.l).append(", lastReachedStage=").append(this.m).append(", progressPath=").append(this.n).append(", terminalStatus=").append(this.o).append(", executeError=").append(this.p).append(", deliveryError=").append(this.q).append(", observedLowerBoundMs=").append(this.r).append(", fragments=").append(this.s).append(')');
        return r0.toString();
    }

    public w(String r10, l r11, k r12, Long r13, Long r14, String r15, Boolean r16, long r17, Long r19, Long r20, Long r21, long r22, String r24, String r25, y r26, m r27, m r28, Long r29, Map<String, ? extends Object> r30) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "traceId");
        d.h.b.o.e(r11, "meta");
        d.h.b.o.e(r12, "correlation");
        d.h.b.o.e(r25, "progressPath");
        d.h.b.o.e(r26, "terminalStatus");
        d.h.b.o.e(r6, "fragments");
        this.f15934a = r10;
        this.f15935b = r11;
        this.f15936c = r12;
        this.f15937d = r13;
        this.f15938e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
        this.q = r28;
        this.r = r29;
        this.s = r6;
    }

    public final String a() {
        return this.f15934a;
    }

    public final l b() {
        return this.f15935b;
    }

    public final k c() {
        return this.f15936c;
    }

    public final Long d() {
        return this.f15937d;
    }

    public final Long e() {
        return this.f15938e;
    }

    public final String f() {
        return this.f;
    }

    public final Boolean g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final Long i() {
        return this.i;
    }

    public final Long j() {
        return this.j;
    }

    public final Long k() {
        return this.k;
    }

    public final String l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final y n() {
        return this.o;
    }

    public final m o() {
        return this.p;
    }

    public final m p() {
        return this.q;
    }

    public final Long q() {
        return this.r;
    }

    public final Map<String, Object> r() {
        return this.s;
    }
}
