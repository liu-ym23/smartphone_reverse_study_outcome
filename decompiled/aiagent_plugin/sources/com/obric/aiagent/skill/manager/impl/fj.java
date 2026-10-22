package com.obric.aiagent.skill.manager.impl;

import java.io.File;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fj implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fe f19890a;

    public fj(fe r2) {
        d.h.b.o.e(r2, "apiClient");
        this.f19890a = r2;
    }

    @Override // com.obric.aiagent.skill.manager.impl.h
    public g a(String r8) {
        d.h.b.o.e(r8, "name");
        f r7 = this.f19890a.c(r8);
        return new g(r7.b(), r7.d(), r7.e(), r7.a(), r7.c());
    }

    @Override // com.obric.aiagent.skill.manager.impl.h
    public long a(String r2, File r3) {
        d.h.b.o.e(r2, "downloadUrl");
        d.h.b.o.e(r3, "destination");
        return this.f19890a.a(r2, r3);
    }
}
