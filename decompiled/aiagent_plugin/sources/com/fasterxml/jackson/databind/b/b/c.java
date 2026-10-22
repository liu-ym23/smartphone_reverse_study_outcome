package com.fasterxml.jackson.databind.b.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: AtomicIntegerDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends ae<AtomicInteger> {
    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    public c() {
        super(AtomicInteger.class);
    }

    public AtomicInteger b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.s() == true) goto L5;
        Integer r1 = b(r2, r3, AtomicInteger.class);
        if (r1 != null) goto L10;
        return null;
    L10:
        return new AtomicInteger(r1.intValue());
    L5:
        return new AtomicInteger(r2.H());
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return new AtomicInteger();
    }
}
