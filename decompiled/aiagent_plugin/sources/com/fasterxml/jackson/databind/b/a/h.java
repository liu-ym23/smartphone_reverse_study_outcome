package com.fasterxml.jackson.databind.b.a;

/* JADX INFO: compiled from: FailingDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends com.fasterxml.jackson.databind.b.b.ab<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f12304a;

    public h(String r2) {
        this(Object.class, r2);
    }

    public h(Class<?> r1, String r2) {
        super(r1);
        this.f12304a = r2;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        r3.a(this, this.f12304a, new Object[0]);
        return null;
    }
}
