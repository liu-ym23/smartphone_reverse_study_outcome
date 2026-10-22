package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillExistencePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bo extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19575a;

    public bo(String r3) {
        d.h.b.o.e(r3, "slug");
        super("Skill is disabled by existence policy: " + r3);
        this.f19575a = r3;
    }
}
