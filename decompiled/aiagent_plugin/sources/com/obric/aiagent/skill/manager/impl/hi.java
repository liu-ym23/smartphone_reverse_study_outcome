package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class hi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f20109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ar f20111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ab f20112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final l f20113e;
    private final boolean f;
    private final com.obric.aiagent.skill.manager.api.u.a g;
    private final dw h;
    private final dw i;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, hi.class) == true) goto L8;
        return false;
    L8:
        hi r6 = (hi) ZeusTransformUtils.preCheckCast(r5, hi.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20109a, r6.f20109a) == true) goto L12;
        return false;
    L12:
        if (this.f20110b == r6.f20110b) goto L15;
        return false;
    L15:
        if (this.f20111c == r6.f20111c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20112d, r6.f20112d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f20113e, r6.f20113e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f20109a.hashCode() * 31) + Integer.hashCode(this.f20110b)) * 31) + this.f20111c.hashCode()) * 31) + this.f20112d.hashCode()) * 31;
        l r1 = this.f20113e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.f)) * 31;
        com.obric.aiagent.skill.manager.api.u.a r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        dw r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        dw r11 = this.i;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        return "SkillUpdateResult(skill=" + this.f20109a + ", previousVersion=" + this.f20110b + ", skillOutcome=" + this.f20111c + ", packageResult=" + this.f20112d + ", cliSummary=" + this.f20113e + ", cliRefreshEscapedFailure=" + this.f + ", skillUpdateFailure=" + this.g + ", skillUpdateErrorCode=" + this.h + ", cliRefreshErrorCode=" + this.i + ')';
    }

    public hi(com.obric.aiagent.skill.manager.api.e r3, int r4, ar r5, ab r6, l r7, boolean r8, com.obric.aiagent.skill.manager.api.u.a r9, dw r10, dw r11) {
        ab r12 = (ab) ZeusTransformUtils.wrapperContextForParams(r6, ab.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r5, "skillOutcome");
        d.h.b.o.e(r12, "packageResult");
        this.f20109a = r3;
        this.f20110b = r4;
        this.f20111c = r5;
        this.f20112d = r12;
        this.f20113e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }

    public /* synthetic */ hi(com.obric.aiagent.skill.manager.api.e r13, int r14, ar r15, ab r16, l r17, boolean r18, com.obric.aiagent.skill.manager.api.u.a r19, dw r20, dw r21, int r22, d.h.b.h r23) {
        ab r6 = (ab) ZeusTransformUtils.wrapperContextForParams(r16, ab.class, "com.obric.aiagent.plugin");
        if ((r22 & 16) == 0) goto L5;
        l r7 = null;
    L7:
        if ((r22 & 32) == 0) goto L9;
        boolean r8 = false;
    L11:
        if ((r22 & 64) == 0) goto L13;
        com.obric.aiagent.skill.manager.api.u.a r9 = null;
    L15:
        if ((r22 & 128) == 0) goto L17;
        dw r10 = null;
    L19:
        if ((r22 & 256) == 0) goto L21;
        dw r11 = null;
    L22:
        this(r13, r14, r15, r6, r7, r8, r9, r10, r11);
        return;
    L21:
        r11 = r21;
        goto L22
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f20109a;
    }

    public final int b() {
        return this.f20110b;
    }

    public final ar c() {
        return this.f20111c;
    }

    public final ab d() {
        return this.f20112d;
    }

    public final l e() {
        return this.f20113e;
    }

    public final boolean f() {
        return this.f;
    }

    public final com.obric.aiagent.skill.manager.api.u.a g() {
        return this.g;
    }

    public final dw h() {
        return this.h;
    }

    public final dw i() {
        return this.i;
    }
}
