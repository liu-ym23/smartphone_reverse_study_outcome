package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
final class d implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f19715a = null;

    static {
        f19715a = new d();
    }

    private d() {
    }

    @Override // com.obric.aiagent.skill.manager.impl.gd
    public void a(String r3) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.b("SkillManager", "Skill signing event", r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.gd
    public void a(String r3, Throwable r4) {
        d.h.b.o.e(r3, "message");
        d.h.b.o.e(r4, "throwable");
        ee.f19808a.a("SkillManager", "Skill signing operation failed", r3, r4);
    }
}
