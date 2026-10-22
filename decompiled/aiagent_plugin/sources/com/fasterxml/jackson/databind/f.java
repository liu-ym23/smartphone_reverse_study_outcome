package com.fasterxml.jackson.databind;

/* JADX INFO: compiled from: DatabindException.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends com.fasterxml.jackson.a.l {
    public abstract void a(Object r1, String r2);

    public f(String r1, com.fasterxml.jackson.a.i r2, Throwable r3) {
        super(r1, r2, r3);
    }

    public f(String r1) {
        super(r1);
    }

    public f(String r2, com.fasterxml.jackson.a.i r3) {
        this(r2, r3, null);
    }

    public f(String r2, Throwable r3) {
        this(r2, null, r3);
    }
}
