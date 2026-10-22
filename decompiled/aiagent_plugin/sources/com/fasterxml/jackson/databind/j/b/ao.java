package com.fasterxml.jackson.databind.j.b;

/* JADX INFO: compiled from: ToStringSerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ao extends aj<Object> {
    public abstract String a(Object r1);

    public ao(Class<?> r2) {
        super(r2, false);
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r1, Object r2) {
        return a(r2).isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.b(a(r1));
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.h));
        a(r2, r3, r4);
        r5.b(r3, r0);
    }
}
