package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class ev extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eu f19846a;

    public final eu a() {
        return this.f19846a;
    }

    public ev(eu r2) {
        d.h.b.o.e(r2, "reason");
        super("Skill server tracking user identity is unavailable.");
        this.f19846a = r2;
    }
}
