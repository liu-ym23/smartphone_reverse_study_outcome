package com.fasterxml.jackson.databind;

import java.util.Collection;

/* JADX INFO: compiled from: JsonDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l<T> implements com.fasterxml.jackson.databind.b.s {

    /* JADX INFO: compiled from: JsonDeserializer.java */
    public static abstract class a extends l<Object> {
        private a() {
        }
    }

    public l<T> a(com.fasterxml.jackson.databind.l.q r1) {
        return this;
    }

    public Boolean a(g r1) {
        return null;
    }

    public Class<?> a() {
        return null;
    }

    public abstract T a(com.fasterxml.jackson.a.k r1, h r2);

    public com.fasterxml.jackson.databind.k.f b() {
        return null;
    }

    public boolean c() {
        return false;
    }

    public Collection<Object> d() {
        return null;
    }

    public com.fasterxml.jackson.databind.b.a.s f() {
        return null;
    }

    @Deprecated
    public T g() {
        return null;
    }

    public l() {
    }

    public T a(com.fasterxml.jackson.a.k r1, h r2, T r3) {
        r2.a(this);
        return a(r1, r2);
    }

    public Object a(com.fasterxml.jackson.a.k r1, h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.d(r1, r2);
    }

    public Object a(com.fasterxml.jackson.a.k r1, h r2, com.fasterxml.jackson.databind.h.e r3, T r4) {
        r2.a(this);
        return a(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.s
    public T a(h r1) {
        return g();
    }

    @Override // com.fasterxml.jackson.databind.b.s
    public Object b(h r1) {
        return a(r1);
    }

    public Object c(h r1) {
        return a(r1);
    }

    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12996c;
    }

    public com.fasterxml.jackson.databind.b.v a(String r4) {
        throw new IllegalArgumentException("Cannot handle managed/back reference '" + r4 + "': type: value deserializer of type " + getClass().getName() + " does not support them");
    }
}
