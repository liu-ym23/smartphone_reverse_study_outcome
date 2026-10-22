package com.fasterxml.jackson.databind;

/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p<T> {

    /* JADX INFO: compiled from: JsonSerializer.java */
    public static abstract class a extends p<Object> {
        public a() {
        }
    }

    public p<T> a(com.fasterxml.jackson.databind.l.q r1) {
        return this;
    }

    public Class<T> a() {
        return null;
    }

    public abstract void a(T r1, com.fasterxml.jackson.a.h r2, ac r3);

    public boolean a(ac r1, T r2) {
        if (r2 != null) goto L4;
        return true;
    L4:
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(T r2, com.fasterxml.jackson.a.h r3, ac r4, com.fasterxml.jackson.databind.h.h r5) {
        Class r6 = a();
        if (r6 != null) goto L5;
        r6 = r2.getClass();
    L5:
        r4.a(r6, String.format("Type id handling not implemented for type %s (by serializer of type %s)", new Object[]{r6.getName(), getClass().getName()}));
    }
}
