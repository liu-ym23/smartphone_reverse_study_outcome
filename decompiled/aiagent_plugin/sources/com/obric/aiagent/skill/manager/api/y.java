package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f19327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f19328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f19329d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, y.class) == true) goto L8;
        return false;
    L8:
        y r6 = (y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.aiagent.plugin");
        if (this.f19326a == r6.f19326a) goto L12;
        return false;
    L12:
        if (this.f19327b == r6.f19327b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19328c, r6.f19328c) == true) goto L18;
        return false;
    L18:
        if (this.f19329d == r6.f19329d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.f19326a) * 31) + this.f19327b.hashCode()) * 31) + this.f19328c.hashCode()) * 31;
        r r2 = this.f19329d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillPackageInstallResult(installed=" + this.f19326a + ", changeType=" + this.f19327b + ", skill=" + this.f19328c + ", scanError=" + this.f19329d + ')';
    }

    public y(boolean r2, w r3, e r4, r r5) {
        d.h.b.o.e(r3, "changeType");
        d.h.b.o.e(r4, "skill");
        this.f19326a = r2;
        this.f19327b = r3;
        this.f19328c = r4;
        this.f19329d = r5;
    }

    public final boolean a() {
        return this.f19326a;
    }

    public final w b() {
        return this.f19327b;
    }

    public final e c() {
        return this.f19328c;
    }

    public final r d() {
        return this.f19329d;
    }
}
