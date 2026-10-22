package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19967e;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19963a, r10.f19963a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19964b, r10.f19964b) == true) goto L15;
        return false;
    L15:
        if (this.f19965c == r10.f19965c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19966d, r10.f19966d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19967e, r10.f19967e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f19963a.hashCode() * 31) + this.f19964b.hashCode()) * 31) + Long.hashCode(this.f19965c)) * 31) + this.f19966d.hashCode()) * 31) + this.f19967e.hashCode();
    }

    public String toString() {
        return "CliBinaryDownloadDescriptor(version=" + this.f19963a + ", filename=" + this.f19964b + ", fileSize=" + this.f19965c + ", downloadUrl=" + this.f19966d + ", status=" + this.f19967e + ')';
    }

    public g(String r2, String r3, long r4, String r6, String r7) {
        d.h.b.o.e(r2, "version");
        d.h.b.o.e(r3, "filename");
        d.h.b.o.e(r6, "downloadUrl");
        d.h.b.o.e(r7, "status");
        this.f19963a = r2;
        this.f19964b = r3;
        this.f19965c = r4;
        this.f19966d = r6;
        this.f19967e = r7;
    }

    public final String a() {
        return this.f19963a;
    }

    public final String b() {
        return this.f19964b;
    }

    public final long c() {
        return this.f19965c;
    }

    public final String d() {
        return this.f19966d;
    }

    public final String e() {
        return this.f19967e;
    }
}
