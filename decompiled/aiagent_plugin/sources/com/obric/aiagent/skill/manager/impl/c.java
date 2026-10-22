package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: PersistentSkillRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
final class c implements ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19635a = null;

    static {
        f19635a = new c();
    }

    private c() {
    }

    @Override // com.obric.aiagent.skill.manager.impl.ed
    public void a(String r3) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.b("SkillManager", "Skill repository event", r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ed
    public void b(String r3) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.a("SkillManager", "Skill repository debug event", r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ed
    public void a(String r3, Throwable r4) {
        d.h.b.o.e(r3, "message");
        d.h.b.o.e(r4, "throwable");
        ee.f19808a.a("SkillManager", "Skill repository operation failed", r3, r4);
    }
}
