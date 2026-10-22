package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class et extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.tools.api.net.c f19839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19840b;

    public final com.obric.autogui.tools.api.net.c getType() {
        return this.f19839a;
    }

    public final String a() {
        return this.f19840b;
    }

    public et(com.obric.autogui.tools.api.net.c r2, String r3) {
        super("Skill server tracking http request failed.");
        this.f19839a = r2;
        this.f19840b = r3;
    }
}
