package com.fasterxml.jackson.databind.b.a;

import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: compiled from: TypeWrappedDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ab extends com.fasterxml.jackson.databind.l<Object> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12269b;

    public ab(com.fasterxml.jackson.databind.h.e r1, com.fasterxml.jackson.databind.l<?> r2) {
        this.f12268a = r1;
        this.f12269b = r2;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return this.f12269b.b();
    }

    @Override // com.fasterxml.jackson.databind.l
    public Class<?> a() {
        return this.f12269b.a();
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return this.f12269b.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Collection<Object> d() {
        return this.f12269b.d();
    }

    @Override // com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
    public Object a(com.fasterxml.jackson.databind.h r1) {
        return this.f12269b.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return this.f12269b.c(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        return this.f12269b.a(r2, r3, this.f12268a);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        return this.f12269b.a(r1, r2, r3);
    }
}
