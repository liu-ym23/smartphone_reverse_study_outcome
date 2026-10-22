package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

/* JADX INFO: compiled from: AppFunctionDataTypeMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f18249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18250b;

    public i(boolean r2, String r3) {
        d.h.b.o.e(r3, "description");
        this.f18249a = r2;
        this.f18250b = r3;
    }

    public final boolean c() {
        return this.f18249a;
    }
}
