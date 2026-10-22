package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillEditGuards.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dh extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final di f19741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19742b;

    public final di a() {
        return this.f19741a;
    }

    public final String b() {
        return this.f19742b;
    }

    public dh(di r3, String r4, String r5) {
        d.h.b.o.e(r3, "failure");
        d.h.b.o.e(r4, "slug");
        super("Skill modification security check failed: " + r3 + ", slug=" + r4);
        this.f19741a = r3;
        this.f19742b = r5;
    }
}
