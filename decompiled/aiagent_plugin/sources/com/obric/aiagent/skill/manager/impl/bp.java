package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PersistentSkillRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f19577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19580e;
    private final boolean f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bp.class) == true) goto L8;
        return false;
    L8:
        bp r6 = (bp) ZeusTransformUtils.preCheckCast(r5, bp.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19576a, r6.f19576a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19577b, r6.f19577b) == true) goto L15;
        return false;
    L15:
        if (this.f19578c == r6.f19578c) goto L18;
        return false;
    L18:
        if (this.f19579d == r6.f19579d) goto L21;
        return false;
    L21:
        if (this.f19580e == r6.f19580e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19576a.hashCode() * 31;
        com.obric.aiagent.skill.manager.api.e r1 = this.f19577b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((r0 + r2) * 31) + Boolean.hashCode(this.f19578c)) * 31) + Boolean.hashCode(this.f19579d)) * 31) + Boolean.hashCode(this.f19580e)) * 31) + Boolean.hashCode(this.f);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillExistencePurgeResult(slug=" + this.f19576a + ", previousSkill=" + this.f19577b + ", filesExisted=" + this.f19578c + ", metadataExisted=" + this.f19579d + ", filesRemoved=" + this.f19580e + ", metadataRemoved=" + this.f + ')';
    }

    public bp(String r2, com.obric.aiagent.skill.manager.api.e r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        d.h.b.o.e(r2, "slug");
        this.f19576a = r2;
        this.f19577b = r3;
        this.f19578c = r4;
        this.f19579d = r5;
        this.f19580e = r6;
        this.f = r7;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f19577b;
    }

    public final boolean b() {
        if (this.f19578c == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f19579d == true) goto L8;
        return false;
    }

    public final boolean c() {
        if (this.f19580e == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f == false) goto L7;
        return true;
    }
}
