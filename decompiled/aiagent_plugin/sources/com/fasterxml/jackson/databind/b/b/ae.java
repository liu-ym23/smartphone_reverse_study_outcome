package com.fasterxml.jackson.databind.b.b;

/* JADX INFO: compiled from: StdScalarDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ae<T> extends ab<T> {
    public ae(Class<?> r1) {
        super(r1);
    }

    public ae(ae<?> r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.m;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12995b;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.c(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, T r3) {
        r2.a(this);
        return a(r1, r2);
    }
}
