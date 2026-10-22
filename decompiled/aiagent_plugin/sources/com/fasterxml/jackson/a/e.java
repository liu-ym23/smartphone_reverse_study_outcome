package com.fasterxml.jackson.a;

import java.io.IOException;

/* JADX INFO: compiled from: JacksonException.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends IOException {
    public abstract i a();

    public abstract String b();

    public abstract Object c();

    public e(String r1) {
        super(r1);
    }

    public e(String r1, Throwable r2) {
        super(r1, r2);
    }
}
