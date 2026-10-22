package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f26661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f26662e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
        return false;
    L8:
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if (this.f26658a == r10.f26658a) goto L12;
        return false;
    L12:
        if (this.f26659b == r10.f26659b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26660c, r10.f26660c) == true) goto L18;
        return false;
    L18:
        if (this.f26661d == r10.f26661d) goto L21;
        return false;
    L21:
        if (this.f26662e == r10.f26662e) goto L24;
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
        if (d.h.b.o.a(this.j, r10.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((Long.hashCode(this.f26658a) * 31) + Integer.hashCode(this.f26659b)) * 31) + this.f26660c.hashCode()) * 31) + Long.hashCode(this.f26661d)) * 31) + this.f26662e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
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
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
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
        return "ActionEffectDetectorTiming(sequence=" + this.f26658a + ", round=" + this.f26659b + ", detectorName=" + this.f26660c + ", elapsedMs=" + this.f26661d + ", finishReason=" + this.f26662e + ", resultStatus=" + this.f + ", resultReason=" + this.g + ", pageClassName=" + this.h + ", beforeActivityClassName=" + this.i + ", afterActivityClassName=" + this.j + ')';
    }

    public e(long r2, int r4, String r5, long r6, s r8, String r9, String r10, String r11, String r12, String r13) {
        d.h.b.o.e(r5, "detectorName");
        d.h.b.o.e(r8, "finishReason");
        this.f26658a = r2;
        this.f26659b = r4;
        this.f26660c = r5;
        this.f26661d = r6;
        this.f26662e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
    }

    public final long a() {
        return this.f26658a;
    }

    public final int b() {
        return this.f26659b;
    }

    public final String c() {
        return this.f26660c;
    }

    public final long d() {
        return this.f26661d;
    }

    public final s e() {
        return this.f26662e;
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
}
