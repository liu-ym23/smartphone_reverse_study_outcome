package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillMetadataStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class hk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20115a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f20116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f20117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f20119e;
    private final String f;
    private final String g;
    private final String h;
    private final Long i;
    private final Long j;

    /* JADX INFO: compiled from: SkillMetadataStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final hk a() {
            return new hk(0, null, null, null, null, null, null, null, null);
        }
    }

    static {
        f20115a = new a(null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hk.class) == true) goto L8;
        return false;
    L8:
        hk r10 = (hk) ZeusTransformUtils.preCheckCast(r9, hk.class, "com.obric.aiagent.plugin");
        if (this.f20116b == r10.f20116b) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20117c, r10.f20117c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20118d, r10.f20118d) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20119e, r10.f20119e) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f20116b) * 31;
        Integer r1 = this.f20117c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f20118d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f20119e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.i;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.j;
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
        return "StoredSkillScan(generation=" + this.f20116b + ", version=" + this.f20117c + ", rawTaskJson=" + this.f20118d + ", rawSignedManifestJson=" + this.f20119e + ", submittedPackageSha256=" + this.f + ", fetchedManifestSha256=" + this.g + ", triggerType=" + this.h + ", createdAtMs=" + this.i + ", updatedAtMs=" + this.j + ')';
    }

    public hk(long r1, Integer r3, String r4, String r5, String r6, String r7, String r8, Long r9, Long r10) {
        this.f20116b = r1;
        this.f20117c = r3;
        this.f20118d = r4;
        this.f20119e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final long a() {
        return this.f20116b;
    }

    public final Integer b() {
        return this.f20117c;
    }

    public final String c() {
        return this.f20118d;
    }

    public final String d() {
        return this.f20119e;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final Long h() {
        return this.i;
    }

    public final Long i() {
        return this.j;
    }
}
