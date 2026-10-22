package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class ex extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19852a;

    public /* synthetic */ ex(String r1, Throwable r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final String a() {
        return this.f19852a;
    }

    public ex(String r2, Throwable r3) {
        d.h.b.o.e(r2, "reason");
        super("Skill server tracking response is invalid.", r3);
        this.f19852a = r2;
    }
}
