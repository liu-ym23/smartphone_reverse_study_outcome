package com.obric.aiagent.skill.manager.impl;

import java.util.Locale;

/* JADX INFO: compiled from: SkillIdentityConflictException.kt */
/* JADX INFO: loaded from: classes3.dex */
public class cd extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ce f19646b;

    public cd(String r4, ce r5) {
        d.h.b.o.e(r4, "conflictingSlug");
        d.h.b.o.e(r5, "field");
        StringBuilder r0 = new StringBuilder().append("Skill identity already exists: field=");
        String r1 = r5.name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r1, "toLowerCase(...)");
        super(r0.append(r1).append(", conflictingSlug=").append(r4).toString());
        this.f19645a = r4;
        this.f19646b = r5;
    }
}
