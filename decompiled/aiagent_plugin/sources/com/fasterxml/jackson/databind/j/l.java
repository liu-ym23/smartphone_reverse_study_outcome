package com.fasterxml.jackson.databind.j;

/* JADX INFO: compiled from: FilterProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    @Deprecated
    public abstract c a(Object r1);

    public n a(Object r1, Object r2) {
        c r0 = a(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.fasterxml.jackson.databind.j.a.m.a(r0);
    }
}
