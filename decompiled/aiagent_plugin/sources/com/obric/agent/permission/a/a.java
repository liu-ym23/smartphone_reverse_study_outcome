package com.obric.agent.permission.a;

import d.h.b.o;

/* JADX INFO: compiled from: ServiceNotFoundException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15393a;

    public a(String r2) {
        o.e(r2, "message");
        super(r2);
        this.f15393a = r2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f15393a;
    }
}
