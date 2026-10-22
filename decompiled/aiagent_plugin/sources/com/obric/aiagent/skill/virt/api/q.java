package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21597c;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, q.class) == true) goto L8;
        return false;
    L8:
        q r8 = (q) ZeusTransformUtils.preCheckCast(r7, q.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21595a, r8.f21595a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21596b, r8.f21596b) == true) goto L15;
        return false;
    L15:
        if (this.f21597c == r8.f21597c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f21595a.hashCode() * 31;
        String r1 = this.f21596b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.f21597c);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ShellObservationContext(shellType=" + this.f21595a + ", scene=" + this.f21596b + ", startedAtElapsedRealtimeMs=" + this.f21597c + ')';
    }

    public q(String r3, String r4, long r5) {
        d.h.b.o.e(r3, "shellType");
        this.f21595a = r3;
        this.f21596b = r4;
        this.f21597c = r5;
        boolean r2 = d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        boolean r6 = true;
        if ((!r2) == false) goto L13;
        if (r5 >= 0) goto L8;
        r6 = false;
    L8:
        if (r6 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("ShellObservationContext.startedAtElapsedRealtimeMs must be >= 0".toString());
    L13:
        throw new IllegalArgumentException("ShellObservationContext.shellType must not be blank".toString());
    }

    public /* synthetic */ q(String r1, String r2, long r3, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f21595a;
    }

    public final String b() {
        return this.f21596b;
    }

    public final long c() {
        return this.f21597c;
    }
}
