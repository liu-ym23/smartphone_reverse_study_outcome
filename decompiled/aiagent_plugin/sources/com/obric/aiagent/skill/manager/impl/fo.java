package com.obric.aiagent.skill.manager.impl;

import java.util.Collection;

/* JADX INFO: compiled from: SkillExistencePolicyRemoteSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fo implements bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fe f19906a;

    /* JADX WARN: Multi-variable type inference failed */
    public fo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public fo(fe r2) {
        d.h.b.o.e(r2, "shopClient");
        this.f19906a = r2;
    }

    public /* synthetic */ fo(fe r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new fe();
    L5:
        this(r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.bn
    public Collection<String> a() {
        return this.f19906a.a();
    }
}
