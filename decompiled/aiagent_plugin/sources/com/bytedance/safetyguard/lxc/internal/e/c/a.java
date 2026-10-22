package com.bytedance.safetyguard.lxc.internal.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10715e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final Integer k;
    private final boolean l;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10711a, r6.f10711a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10712b, r6.f10712b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10713c, r6.f10713c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10714d, r6.f10714d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f10715e, r6.f10715e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L30;
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
        if (o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f10711a.hashCode() * 31) + this.f10712b.hashCode()) * 31) + this.f10713c.hashCode()) * 31) + this.f10714d.hashCode()) * 31;
        String r1 = this.f10715e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.i;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.j;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.k;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return ((r19 + r2) * 31) + Boolean.hashCode(this.l);
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
        r0.append("HttpDiagnosticContext(component=").append(this.f10711a).append(", operation=").append(this.f10712b).append(", method=").append(this.f10713c).append(", host=").append(this.f10714d).append(", safePath=").append(this.f10715e).append(", brand=").append(this.f).append(", appRef=").append(this.g).append(", deviceRef=").append(this.h).append(", sessionRef=").append(this.i).append(", pathRef=").append(this.j).append(", attempt=").append(this.k).append(", polling=");
        r0.append(this.l).append(')');
        return r0.toString();
    }

    public a(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, Integer r12, boolean r13) {
        o.e(r2, "component");
        o.e(r3, "operation");
        o.e(r4, "method");
        o.e(r5, "host");
        this.f10711a = r2;
        this.f10712b = r3;
        this.f10713c = r4;
        this.f10714d = r5;
        this.f10715e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }

    public /* synthetic */ a(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Integer r27, boolean r28, int r29, h r30) {
        if ((r29 & 32) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r29 & 64) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r29 & 128) == 0) goto L13;
        String r11 = null;
    L15:
        if ((r29 & 256) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r29 & 512) == 0) goto L21;
        String r13 = null;
    L23:
        if ((r29 & 1024) == 0) goto L25;
        Integer r14 = null;
    L27:
        if ((r29 & 2048) == 0) goto L29;
        boolean r15 = false;
    L30:
        this(r17, r18, r19, r20, r21, r9, r10, r11, r12, r13, r14, r15);
        return;
    L29:
        r15 = r28;
        goto L30
    L25:
        r14 = r27;
        goto L27
    L21:
        r13 = r26;
        goto L23
    L17:
        r12 = r25;
        goto L19
    L13:
        r11 = r24;
        goto L15
    L9:
        r10 = r23;
        goto L11
    L5:
        r9 = r22;
        goto L7
    }

    public final String a() {
        return this.f10711a;
    }

    public final String b() {
        return this.f10712b;
    }

    public final String c() {
        return this.f10713c;
    }

    public final String d() {
        return this.f10714d;
    }

    public final String e() {
        return this.f10715e;
    }

    public final String f() {
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

    public final String j() {
        return this.j;
    }

    public final Integer k() {
        return this.k;
    }

    public final boolean l() {
        return this.l;
    }
}
