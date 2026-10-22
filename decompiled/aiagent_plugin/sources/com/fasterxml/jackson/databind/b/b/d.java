package com.fasterxml.jackson.databind.b.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: AtomicLongDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ae<AtomicLong> {
    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    public d() {
        super(AtomicLong.class);
    }

    public AtomicLong b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        if (r3.s() == true) goto L5;
        Long r2 = c(r3, r4, AtomicLong.class);
        if (r2 != null) goto L10;
        return null;
    L10:
        return new AtomicLong(r2.intValue());
    L5:
        return new AtomicLong(r3.I());
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return new AtomicLong();
    }
}
