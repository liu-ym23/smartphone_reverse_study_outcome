package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f21594e;
    private final boolean f;
    private final Integer g;
    private final boolean h;
    private final long i;
    private final long j;
    private final String k;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, p.class) == true) goto L8;
        return false;
    L8:
        p r10 = (p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21590a, r10.f21590a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21591b, r10.f21591b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f21592c, r10.f21592c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f21593d, r10.f21593d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f21594e, r10.f21594e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f21590a.hashCode() * 31) + this.f21591b.hashCode()) * 31) + this.f21592c.hashCode()) * 31) + this.f21593d.hashCode()) * 31) + this.f21594e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31;
        Integer r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + Boolean.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31;
        String r5 = this.k;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ShellExecutionSnapshot(groupId=").append(this.f21590a).append(", executionId=").append(this.f21591b).append(", workDir=").append(this.f21592c).append(", command=").append(this.f21593d).append(", status=").append(this.f21594e).append(", completed=").append(this.f).append(", exitCode=").append(this.g).append(", killed=").append(this.h).append(", startedAtMs=").append(this.i).append(", durationMs=").append(this.j).append(", clientEgressResultJson=").append(this.k).append(')');
        return r0.toString();
    }

    public p(String r2, String r3, String r4, String r5, String r6, boolean r7, Integer r8, boolean r9, long r10, long r12, String r14) {
        d.h.b.o.e(r2, "groupId");
        d.h.b.o.e(r3, "executionId");
        d.h.b.o.e(r4, "workDir");
        d.h.b.o.e(r5, "command");
        d.h.b.o.e(r6, "status");
        this.f21590a = r2;
        this.f21591b = r3;
        this.f21592c = r4;
        this.f21593d = r5;
        this.f21594e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r14;
    }

    public final String a() {
        return this.f21590a;
    }

    public final String b() {
        return this.f21591b;
    }

    public final String c() {
        return this.f21592c;
    }

    public final String d() {
        return this.f21593d;
    }

    public final String e() {
        return this.f21594e;
    }

    public final boolean f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final long i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }
}
