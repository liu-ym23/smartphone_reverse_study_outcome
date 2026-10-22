package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillPackageInstallFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fp extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fq f19907a;

    public /* synthetic */ fp(fq r1, Throwable r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final fq a() {
        return this.f19907a;
    }

    public fp(fq r3, Throwable r4) {
        d.h.b.o.e(r3, "reason");
        super("Skill Store request failed: " + r3, r4);
        this.f19907a = r3;
    }
}
