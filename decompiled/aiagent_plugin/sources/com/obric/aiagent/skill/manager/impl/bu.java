package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillFileFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public class bu extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt f19619a;

    public /* synthetic */ bu(bt r1, Throwable r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final bt a() {
        return this.f19619a;
    }

    public bu(bt r3, Throwable r4) {
        d.h.b.o.e(r3, "failure");
        super("Skill file rejected: " + r3.a(), r4);
        this.f19619a = r3;
    }
}
