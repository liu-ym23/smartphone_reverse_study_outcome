package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillPackageInstallFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dn extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.ttnet.k f19753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f19754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f19755c;

    public /* synthetic */ dn(com.obric.aiagent.ttnet.k r2, Long r3, Integer r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public final com.obric.aiagent.ttnet.k a() {
        return this.f19753a;
    }

    public final Long b() {
        return this.f19754b;
    }

    public final Integer c() {
        return this.f19755c;
    }

    public dn(com.obric.aiagent.ttnet.k r3, Long r4, Integer r5) {
        d.h.b.o.e(r3, "reason");
        super("Skill package download failed: " + r3);
        this.f19753a = r3;
        this.f19754b = r4;
        this.f19755c = r5;
    }
}
