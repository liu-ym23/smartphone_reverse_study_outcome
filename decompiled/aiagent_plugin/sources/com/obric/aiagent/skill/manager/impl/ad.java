package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
final class ad implements ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ad f19442a = null;

    static {
        f19442a = new ad();
    }

    private ad() {
    }

    @Override // com.obric.aiagent.skill.manager.impl.ed
    public void a(String r3) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.b("SkillManager", "Obric package metadata event", r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ed
    public void b(String r3) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.a("SkillManager", "Obric package metadata debug event", r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ed
    public void a(String r3, Throwable r4) {
        d.h.b.o.e(r3, "message");
        d.h.b.o.e(r4, "throwable");
        ee.f19808a.a("SkillManager", "Obric package metadata operation failed", r3, r4);
    }
}
