package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19429a = null;

    static {
        f19429a = new a();
    }

    private a() {
    }

    @Override // com.obric.aiagent.skill.manager.impl.m
    public void a(String r3) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.b("SkillManager", "CLI update event", r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.m
    public void a(String r3, Throwable r4) {
        d.h.b.o.e(r3, "message");
        ee.f19808a.a("SkillManager", "CLI update failed", r3, r4);
    }
}
