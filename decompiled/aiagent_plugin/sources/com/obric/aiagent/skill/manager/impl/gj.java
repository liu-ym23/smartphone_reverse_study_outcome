package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningStateStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19997e;
    private final String f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;

    public static /* synthetic */ gj a(gj r15, String r16, int r17, long r18, String r20, String r21, String r22, String r23, String r24, long r25, long r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        String r2 = r15.f19993a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        int r3 = r15.f19994b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        long r4 = r15.f19995c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r6 = r15.f19996d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r7 = r15.f19997e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r8 = r15.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r9 = r15.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r10 = r15.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        long r11 = r15.i;
    L39:
        if ((r29 & 512) == 0) goto L41;
        long r13 = r15.j;
    L43:
        return r15.a(r2, r3, r4, r6, r7, r8, r9, r10, r11, r13);
    L41:
        r13 = r27;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final gj a(String r16, int r17, long r18, String r20, String r21, String r22, String r23, String r24, long r25, long r27) {
        d.h.b.o.e(r16, "slug");
        d.h.b.o.e(r20, "rawTaskJson");
        d.h.b.o.e(r21, "rawSignedManifestJson");
        d.h.b.o.e(r22, "submittedPackageSha256");
        d.h.b.o.e(r23, "fetchedManifestSha256");
        d.h.b.o.e(r24, "scanTriggerType");
        return new gj(r16, r17, r18, r20, r21, r22, r23, r24, r25, r27);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, gj.class) == true) goto L8;
        return false;
    L8:
        gj r10 = (gj) ZeusTransformUtils.preCheckCast(r9, gj.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19993a, r10.f19993a) == true) goto L12;
        return false;
    L12:
        if (this.f19994b == r10.f19994b) goto L15;
        return false;
    L15:
        if (this.f19995c == r10.f19995c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19996d, r10.f19996d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19997e, r10.f19997e) == true) goto L24;
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
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((this.f19993a.hashCode() * 31) + Integer.hashCode(this.f19994b)) * 31) + Long.hashCode(this.f19995c)) * 31) + this.f19996d.hashCode()) * 31) + this.f19997e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j);
    }

    public String toString() {
        return "SkillSigningRecord(slug=" + this.f19993a + ", version=" + this.f19994b + ", generation=" + this.f19995c + ", rawTaskJson=" + this.f19996d + ", rawSignedManifestJson=" + this.f19997e + ", submittedPackageSha256=" + this.f + ", fetchedManifestSha256=" + this.g + ", scanTriggerType=" + this.h + ", createdAtMs=" + this.i + ", updatedAtMs=" + this.j + ')';
    }

    public gj(String r2, int r3, long r4, String r6, String r7, String r8, String r9, String r10, long r11, long r13) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r6, "rawTaskJson");
        d.h.b.o.e(r7, "rawSignedManifestJson");
        d.h.b.o.e(r8, "submittedPackageSha256");
        d.h.b.o.e(r9, "fetchedManifestSha256");
        d.h.b.o.e(r10, "scanTriggerType");
        this.f19993a = r2;
        this.f19994b = r3;
        this.f19995c = r4;
        this.f19996d = r6;
        this.f19997e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
    }

    public final String a() {
        return this.f19993a;
    }

    public final int b() {
        return this.f19994b;
    }

    public final long c() {
        return this.f19995c;
    }

    public final String d() {
        return this.f19996d;
    }

    public final String e() {
        return this.f19997e;
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

    public final long i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }
}
