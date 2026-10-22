package com.obric.aiagent.skill.credentials.api;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f18948a;

    public final h a() {
        return this.f18948a;
    }

    public e(h r2) {
        d.h.b.o.e(r2, "envelope");
        super("Credential operation failed");
        this.f18948a = r2;
    }
}
