package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class eq extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19838a;

    public final long a() {
        return this.f19838a;
    }

    public eq(long r2) {
        super("Skill server tracking business request failed.");
        this.f19838a = r2;
    }
}
