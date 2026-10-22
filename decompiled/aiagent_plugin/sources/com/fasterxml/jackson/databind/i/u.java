package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;

/* JADX INFO: compiled from: ValueNode.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends b {
    @Override // com.fasterxml.jackson.databind.n
    public final com.fasterxml.jackson.databind.n a(String r1) {
        return null;
    }

    public abstract com.fasterxml.jackson.a.n d();

    public u() {
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r2, ac r3, com.fasterxml.jackson.databind.h.h r4) {
        com.fasterxml.jackson.a.g.b r0 = r4.a(r2, r4.a(this, d()));
        a(r2, r3);
        r4.b(r2, r0);
    }
}
