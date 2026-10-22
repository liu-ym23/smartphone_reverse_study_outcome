package com.fasterxml.jackson.databind.j.b;

/* JADX INFO: compiled from: StdScalarSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ai<T> extends aj<T> {
    public ai(Class<T> r1) {
        super(r1);
    }

    public ai(Class<?> r1, boolean r2) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.h));
        a(r2, r3, r4);
        r5.b(r3, r0);
    }
}
