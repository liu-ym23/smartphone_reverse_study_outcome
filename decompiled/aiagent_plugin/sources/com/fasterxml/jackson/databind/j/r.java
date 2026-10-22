package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ac;

/* JADX INFO: compiled from: SerializerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public abstract com.fasterxml.jackson.databind.h.h a(aa r1, com.fasterxml.jackson.databind.k r2);

    @Deprecated
    public abstract com.fasterxml.jackson.databind.p<Object> a(aa r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.p<Object> r3);

    public abstract com.fasterxml.jackson.databind.p<Object> a(ac r1, com.fasterxml.jackson.databind.k r2);

    public r() {
    }

    public com.fasterxml.jackson.databind.p<Object> a(ac r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.p<Object> r3) {
        return a(r1.c(), r2, r3);
    }
}
