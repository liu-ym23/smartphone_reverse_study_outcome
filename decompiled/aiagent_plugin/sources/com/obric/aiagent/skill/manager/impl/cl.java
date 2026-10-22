package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.q f19675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final gs f19679e;
    private final String f;
    private final String g;

    public static /* synthetic */ cl a(cl r5, com.obric.aiagent.skill.manager.api.q r6, String r7, String r8, String r9, gs r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.f19675a;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.f19676b;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.f19677c;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.f19678d;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.f19679e;
    L17:
        gs r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.f;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.g;
    L23:
        com.obric.aiagent.skill.manager.api.q r16 = r6;
        return r5.a(r16, r15, r0, r1, r2, r3, r12);
    }

    public final cl a(com.obric.aiagent.skill.manager.api.q r9, String r10, String r11, String r12, gs r13, String r14, String r15) {
        d.h.b.o.e(r9, "installMethod");
        d.h.b.o.e(r10, "skillName");
        return new cl(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cl.class) == true) goto L8;
        return false;
    L8:
        cl r6 = (cl) ZeusTransformUtils.preCheckCast(r5, cl.class, "com.obric.aiagent.plugin");
        if (this.f19675a == r6.f19675a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19676b, r6.f19676b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19677c, r6.f19677c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19678d, r6.f19678d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19679e, r6.f19679e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19675a.hashCode() * 31) + this.f19676b.hashCode()) * 31;
        String r1 = this.f19677c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f19678d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        gs r8 = this.f19679e;
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
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
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
        return "SkillInstallTrackingContext(installMethod=" + this.f19675a + ", skillName=" + this.f19676b + ", skillId=" + this.f19677c + ", skillSourceUrl=" + this.f19678d + ", storeInstallMetadata=" + this.f19679e + ", performanceTraceId=" + this.f + ", performanceEntrySource=" + this.g + ')';
    }

    public cl(com.obric.aiagent.skill.manager.api.q r2, String r3, String r4, String r5, gs r6, String r7, String r8) {
        d.h.b.o.e(r2, "installMethod");
        d.h.b.o.e(r3, "skillName");
        this.f19675a = r2;
        this.f19676b = r3;
        this.f19677c = r4;
        this.f19678d = r5;
        this.f19679e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ cl(com.obric.aiagent.skill.manager.api.q r11, String r12, String r13, String r14, gs r15, String r16, String r17, int r18, d.h.b.h r19) {
        if ((r18 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r18 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        gs r7 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r18 & 64) == 0) goto L21;
        String r9 = null;
    L22:
        this(r11, r12, r5, r6, r7, r8, r9);
        return;
    L21:
        r9 = r17;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final com.obric.aiagent.skill.manager.api.q a() {
        return this.f19675a;
    }

    public final String b() {
        return this.f19676b;
    }

    public final String c() {
        return this.f19677c;
    }

    public final String d() {
        return this.f19678d;
    }

    public final gs e() {
        return this.f19679e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }
}
