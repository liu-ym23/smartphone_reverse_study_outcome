package com.fasterxml.jackson.databind.b;

/* JADX INFO: compiled from: UnresolvedId.java */
/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f12543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.fasterxml.jackson.a.i f12544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f12545c;

    public x(Object r1, Class<?> r2, com.fasterxml.jackson.a.i r3) {
        this.f12543a = r1;
        this.f12545c = r2;
        this.f12544b = r3;
    }

    public Class<?> getType() {
        return this.f12545c;
    }

    public String toString() {
        return String.format("Object id [%s] (for %s) at %s", new Object[]{this.f12543a, com.fasterxml.jackson.databind.l.h.h(this.f12545c), this.f12544b});
    }
}
