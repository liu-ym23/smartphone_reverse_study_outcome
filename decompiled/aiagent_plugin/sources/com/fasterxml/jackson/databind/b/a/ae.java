package com.fasterxml.jackson.databind.b.a;

/* JADX INFO: compiled from: ValueInjector.java */
/* JADX INFO: loaded from: classes2.dex */
public class ae extends com.fasterxml.jackson.databind.d.b {
    protected final Object h;

    public ae(com.fasterxml.jackson.databind.x r7, com.fasterxml.jackson.databind.k r8, com.fasterxml.jackson.databind.e.j r9, Object r10) {
        super(r7, r8, null, r9, com.fasterxml.jackson.databind.w.f13126b);
        this.h = r10;
    }

    public Object a(com.fasterxml.jackson.databind.h r2, Object r3) {
        return r2.a(this.h, this, r3);
    }

    public void b(com.fasterxml.jackson.databind.h r2, Object r3) {
        this.g.a(r3, a(r2, r3));
    }
}
