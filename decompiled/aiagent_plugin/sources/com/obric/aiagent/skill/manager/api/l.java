package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f19275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f19276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f19277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r f19278e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (this.f19274a == r6.f19274a) goto L12;
        return false;
    L12:
        if (this.f19275b == r6.f19275b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19276c, r6.f19276c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19277d, r6.f19277d) == true) goto L21;
        return false;
    L21:
        if (this.f19278e == r6.f19278e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.f19274a) * 31) + this.f19275b.hashCode()) * 31) + this.f19276c.hashCode()) * 31;
        Integer r1 = this.f19277d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        r r5 = this.f19278e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillApplyResult(applied=" + this.f19274a + ", changeType=" + this.f19275b + ", skill=" + this.f19276c + ", previousVersion=" + this.f19277d + ", scanError=" + this.f19278e + ')';
    }

    public l(boolean r2, i r3, e r4, Integer r5, r r6) {
        d.h.b.o.e(r3, "changeType");
        d.h.b.o.e(r4, "skill");
        this.f19274a = r2;
        this.f19275b = r3;
        this.f19276c = r4;
        this.f19277d = r5;
        this.f19278e = r6;
    }

    public final boolean a() {
        return this.f19274a;
    }

    public final i b() {
        return this.f19275b;
    }

    public final e c() {
        return this.f19276c;
    }

    public final Integer d() {
        return this.f19277d;
    }

    public final r e() {
        return this.f19278e;
    }
}
