package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

/* JADX INFO: compiled from: AppFunctionDataTypeMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18306a;

    public final String a() {
        return this.f18306a;
    }

    public u(String r2, boolean r3, String r4) {
        d.h.b.o.e(r2, "qualifiedName");
        d.h.b.o.e(r4, "description");
        super(r3, r4);
        this.f18306a = r2;
    }
}
