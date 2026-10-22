package com.fasterxml.jackson.databind.b.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AtomicBooleanDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ae<AtomicBoolean> {
    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    public b() {
        super(AtomicBoolean.class);
    }

    public AtomicBoolean b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.a.n r0 = r3.l();
        if (r0 != com.fasterxml.jackson.a.n.k) goto L7;
        return new AtomicBoolean(true);
    L7:
        if (r0 == com.fasterxml.jackson.a.n.l) goto L9;
        Boolean r2 = a(r3, r4, AtomicBoolean.class);
        if (r2 != null) goto L14;
        return null;
    L14:
        return new AtomicBoolean(r2.booleanValue());
    L9:
        return new AtomicBoolean(false);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.h;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return new AtomicBoolean(false);
    }
}
