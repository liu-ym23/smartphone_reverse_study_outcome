package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dp f20161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final gg f20163c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20161a, r6.f20161a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20162b, r6.f20162b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20163c, r6.f20163c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f20161a.hashCode() * 31) + this.f20162b.hashCode()) * 31) + this.f20163c.hashCode();
    }

    public String toString() {
        return "CurrentSigningInput(packageFile=" + this.f20161a + ", packageSha256=" + this.f20162b + ", metadata=" + this.f20163c + ')';
    }

    public r(dp r2, String r3, gg r4) {
        d.h.b.o.e(r2, "packageFile");
        d.h.b.o.e(r3, "packageSha256");
        d.h.b.o.e(r4, "metadata");
        this.f20161a = r2;
        this.f20162b = r3;
        this.f20163c = r4;
    }

    public final dp a() {
        return this.f20161a;
    }

    public final String b() {
        return this.f20162b;
    }

    public final gg c() {
        return this.f20163c;
    }
}
