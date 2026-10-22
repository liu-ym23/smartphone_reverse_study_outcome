package com.obric.autogui.agents.scripted.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScriptMemorySnapshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f26897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f26898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f26899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f26900e;
    private final Long f;
    private final Long g;
    private final Long h;
    private final Long i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (this.f26896a == r10.f26896a) goto L12;
        return false;
    L12:
        if (o.a(this.f26897b, r10.f26897b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26898c, r10.f26898c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26899d, r10.f26899d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26900e, r10.f26900e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r10.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f26896a) * 31;
        Long r1 = this.f26897b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f26898c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.f26899d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.f26900e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.i;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
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
        return "ScriptMemoryDelta(totalPssKb=" + this.f26896a + ", javaHeapKb=" + this.f26897b + ", nativeHeapKb=" + this.f26898c + ", codeKb=" + this.f26899d + ", stackKb=" + this.f26900e + ", graphicsKb=" + this.f + ", privateOtherKb=" + this.g + ", systemKb=" + this.h + ", totalSwapKb=" + this.i + ')';
    }

    public a(long r1, Long r3, Long r4, Long r5, Long r6, Long r7, Long r8, Long r9, Long r10) {
        this.f26896a = r1;
        this.f26897b = r3;
        this.f26898c = r4;
        this.f26899d = r5;
        this.f26900e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final long a() {
        return this.f26896a;
    }

    public final Long b() {
        return this.f26897b;
    }

    public final Long c() {
        return this.f26898c;
    }

    public final Long d() {
        return this.f26899d;
    }

    public final Long e() {
        return this.f26900e;
    }

    public final Long f() {
        return this.f;
    }

    public final Long g() {
        return this.g;
    }

    public final Long h() {
        return this.h;
    }

    public final Long i() {
        return this.i;
    }
}
