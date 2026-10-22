package com.fasterxml.jackson.databind.j.b;

/* JADX INFO: compiled from: RawSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class z<T> extends aj<T> {
    public z(Class<?> r2) {
        super(r2, false);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(T r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.d(r1.toString());
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.g));
        a(r2, r3, r4);
        r5.b(r3, r0);
    }
}
