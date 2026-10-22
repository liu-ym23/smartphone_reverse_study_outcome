package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtualDisplayRecordSetBizTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f27591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f27592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f27593e;
    private final Integer f;
    private final String g;
    private final String h;
    private final String i;
    private final Integer j;
    private final Boolean k;
    private final String l;
    private final Integer m;
    private final Integer n;
    private final Integer o;
    private final Boolean p;
    private final Boolean q;
    private final Boolean r;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L8;
        return false;
    L8:
        s r6 = (s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f27589a, r6.f27589a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f27590b, r6.f27590b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f27591c, r6.f27591c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f27592d, r6.f27592d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f27593e, r6.f27593e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (d.h.b.o.a(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (d.h.b.o.a(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (d.h.b.o.a(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (d.h.b.o.a(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (d.h.b.o.a(this.r, r6.r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f27589a.hashCode() * 31) + this.f27590b.hashCode()) * 31) + this.f27591c.hashCode()) * 31;
        String r1 = this.f27592d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f27593e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.k;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.l;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.m;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.n;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.o;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        Boolean r38 = this.p;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        Boolean r41 = this.q;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        Boolean r44 = this.r;
        if (r44 == null) goto L63;
        r2 = r44.hashCode();
    L63:
        return r43 + r2;
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
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
        r0.append("VirtualDisplayRecordSetTrackingEvent(stage=").append(this.f27589a).append(", outcome=").append(this.f27590b).append(", reason=").append(this.f27591c).append(", source=").append(this.f27592d).append(", frameworkSessionId=").append(this.f27593e).append(", displayId=").append(this.f).append(", oautoSessionId=").append(this.g).append(", sessionKey=").append(this.h).append(", requestSessionKey=").append(this.i).append(", sessionOrigin=").append(this.j).append(", isOmni=").append(this.k).append(", packageName=");
        r0.append(this.l).append(", publishedPackageCount=").append(this.m).append(", attemptedTotalCount=").append(this.n).append(", frameworkReasonCode=").append(this.o).append(", operationBlocked=").append(this.p).append(", failClosed=").append(this.q).append(", ownerMatched=").append(this.r).append(')');
        return r0.toString();
    }

    public s(String r6, String r7, String r8, String r9, Long r10, Integer r11, String r12, String r13, String r14, Integer r15, Boolean r16, String r17, Integer r18, Integer r19, Integer r20, Boolean r21, Boolean r22, Boolean r23) {
        d.h.b.o.e(r6, "stage");
        d.h.b.o.e(r7, "outcome");
        d.h.b.o.e(r8, "reason");
        this.f27589a = r6;
        this.f27590b = r7;
        this.f27591c = r8;
        this.f27592d = r9;
        this.f27593e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
    }

    public /* synthetic */ s(String r23, String r24, String r25, String r26, Long r27, Integer r28, String r29, String r30, String r31, Integer r32, Boolean r33, String r34, Integer r35, Integer r36, Integer r37, Boolean r38, Boolean r39, Boolean r40, int r41, d.h.b.h r42) {
        if ((r41 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r41 & 16) == 0) goto L9;
        Long r8 = null;
    L11:
        if ((r41 & 32) == 0) goto L13;
        Integer r9 = null;
    L15:
        if ((r41 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r41 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r41 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r41 & 512) == 0) goto L29;
        Integer r13 = null;
    L31:
        if ((r41 & 1024) == 0) goto L33;
        Boolean r14 = null;
    L35:
        if ((r41 & 2048) == 0) goto L37;
        String r15 = null;
    L39:
        if ((r41 & 4096) == 0) goto L41;
        Integer r16 = null;
    L43:
        if ((r41 & 8192) == 0) goto L45;
        Integer r17 = null;
    L47:
        if ((r41 & 16384) == 0) goto L49;
        Integer r18 = null;
    L51:
        if ((32768 & r41) == 0) goto L53;
        Boolean r19 = null;
    L55:
        if ((65536 & r41) == 0) goto L57;
        Boolean r20 = null;
    L59:
        if ((r41 & UiType.FLAG_PHONE_CARD) == 0) goto L61;
        Boolean r21 = null;
    L62:
        this(r23, r24, r25, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        return;
    L61:
        r21 = r40;
        goto L62
    L57:
        r20 = r39;
        goto L59
    L53:
        r19 = r38;
        goto L55
    L49:
        r18 = r37;
        goto L51
    L45:
        r17 = r36;
        goto L47
    L41:
        r16 = r35;
        goto L43
    L37:
        r15 = r34;
        goto L39
    L33:
        r14 = r33;
        goto L35
    L29:
        r13 = r32;
        goto L31
    L25:
        r12 = r31;
        goto L27
    L21:
        r11 = r30;
        goto L23
    L17:
        r10 = r29;
        goto L19
    L13:
        r9 = r28;
        goto L15
    L9:
        r8 = r27;
        goto L11
    L5:
        r7 = r26;
        goto L7
    }

    public final String a() {
        return this.f27589a;
    }

    public final String b() {
        return this.f27590b;
    }

    public final String c() {
        return this.f27591c;
    }

    public final String d() {
        return this.f27592d;
    }

    public final Long e() {
        return this.f27593e;
    }

    public final Integer f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final Integer j() {
        return this.j;
    }

    public final Boolean k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final Integer m() {
        return this.m;
    }

    public final Integer n() {
        return this.n;
    }

    public final Integer o() {
        return this.o;
    }

    public final Boolean p() {
        return this.p;
    }

    public final Boolean q() {
        return this.q;
    }

    public final Boolean r() {
        return this.r;
    }
}
