package com.fasterxml.jackson.databind.h;

import com.fasterxml.jackson.databind.a.m;
import com.fasterxml.jackson.databind.e.j;
import com.fasterxml.jackson.databind.k;
import java.util.Collection;

/* JADX INFO: compiled from: SubtypeResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public d() {
    }

    public Collection<b> a(m<?> r2, j r3, k r4) {
        return a(r3, r2, r2.j(), r4);
    }

    public Collection<b> a(m<?> r2, com.fasterxml.jackson.databind.e.d r3) {
        return a(r3, r2, r2.j());
    }

    public Collection<b> b(m<?> r2, j r3, k r4) {
        return a(r3, r2, r2.j(), r4);
    }

    public Collection<b> b(m<?> r2, com.fasterxml.jackson.databind.e.d r3) {
        return a(r3, r2, r2.j());
    }

    @Deprecated
    public Collection<b> a(j r1, m<?> r2, com.fasterxml.jackson.databind.b r3, k r4) {
        return a(r2, r1, r4);
    }

    @Deprecated
    public Collection<b> a(com.fasterxml.jackson.databind.e.d r1, m<?> r2, com.fasterxml.jackson.databind.b r3) {
        return a(r2, r1);
    }
}
