package com.bytedance.safetyguard.lxc.internal.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f10721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f10722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f10725e;
    private final String f;
    private final Boolean g;
    private final d h;
    private final Long i;
    private final g j;

    public static /* synthetic */ c a(c r12, b r13, Integer r14, int r15, int r16, long r17, String r19, Boolean r20, d r21, Long r22, g r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        b r2 = r12.f10721a;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Integer r3 = r12.f10722b;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r4 = r12.f10723c;
    L15:
        if ((r24 & 8) == 0) goto L17;
        int r5 = r12.f10724d;
    L19:
        if ((r24 & 16) == 0) goto L21;
        long r6 = r12.f10725e;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r8 = r12.f;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Boolean r9 = r12.g;
    L31:
        if ((r24 & 128) == 0) goto L33;
        d r10 = r12.h;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Long r11 = r12.i;
    L39:
        if ((r24 & 512) == 0) goto L41;
        g r1 = r12.j;
    L43:
        return r12.a(r2, r3, r4, r5, r6, r8, r9, r10, r11, r1);
    L41:
        r1 = r23;
        goto L43
    L37:
        r11 = r22;
        goto L39
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final c a(b r14, Integer r15, int r16, int r17, long r18, String r20, Boolean r21, d r22, Long r23, g r24) {
        o.e(r14, "outcome");
        return new c(r14, r15, r16, r17, r18, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if (this.f10721a == r10.f10721a) goto L12;
        return false;
    L12:
        if (o.a(this.f10722b, r10.f10722b) == true) goto L15;
        return false;
    L15:
        if (this.f10723c == r10.f10723c) goto L18;
        return false;
    L18:
        if (this.f10724d == r10.f10724d) goto L21;
        return false;
    L21:
        if (this.f10725e == r10.f10725e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r10.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = this.f10721a.hashCode() * 31;
        Integer r1 = this.f10722b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + Integer.hashCode(this.f10723c)) * 31) + Integer.hashCode(this.f10724d)) * 31) + Long.hashCode(this.f10725e)) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        d r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.i;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        g r17 = this.j;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
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
        return "HttpResponseDiagnostics(outcome=" + this.f10721a + ", httpStatus=" + this.f10722b + ", requestBytes=" + this.f10723c + ", responseBytes=" + this.f10724d + ", durationMs=" + this.f10725e + ", contentType=" + this.f + ", jsonParsed=" + this.g + ", envelope=" + this.h + ", retryAfterSec=" + this.i + ", failure=" + this.j + ')';
    }

    public c(b r2, Integer r3, int r4, int r5, long r6, String r8, Boolean r9, d r10, Long r11, g r12) {
        o.e(r2, "outcome");
        this.f10721a = r2;
        this.f10722b = r3;
        this.f10723c = r4;
        this.f10724d = r5;
        this.f10725e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }

    public final b a() {
        return this.f10721a;
    }

    public final Integer b() {
        return this.f10722b;
    }

    public final int c() {
        return this.f10723c;
    }

    public final int d() {
        return this.f10724d;
    }

    public final long e() {
        return this.f10725e;
    }

    public final String f() {
        return this.f;
    }

    public final Boolean g() {
        return this.g;
    }

    public final d h() {
        return this.h;
    }

    public final Long i() {
        return this.i;
    }

    public final g j() {
        return this.j;
    }
}
