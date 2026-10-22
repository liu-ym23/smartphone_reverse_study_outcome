package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.j.b.aj;

/* JADX INFO: compiled from: ContainerSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T> extends aj<T> {
    public abstract boolean a(T r1);

    public abstract i<?> b(com.fasterxml.jackson.databind.h.h r1);

    public i(Class<T> r1) {
        super(r1);
    }

    public i(com.fasterxml.jackson.databind.k r1) {
        super(r1);
    }

    public i(Class<?> r1, boolean r2) {
        super(r1, r2);
    }

    public i(i<?> r2) {
        super(r2.r, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i<?> a(com.fasterxml.jackson.databind.h.h r1) {
        if (r1 != null) goto L5;
        return this;
    L5:
        return b(r1);
    }
}
