package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.a.k;

/* JADX INFO: compiled from: InvalidFormatException.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Object f12550d;

    public c(k r1, String r2, Object r3, Class<?> r4) {
        super(r1, r2, r4);
        this.f12550d = r3;
    }

    public static c a(k r1, String r2, Object r3, Class<?> r4) {
        return new c(r1, r2, r3, r4);
    }
}
