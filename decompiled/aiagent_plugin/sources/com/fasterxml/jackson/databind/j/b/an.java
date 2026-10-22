package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

/* JADX INFO: compiled from: ToStringSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class an extends ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final an f12885a = null;

    static {
        f12885a = new an();
    }

    public an() {
        super(Object.class);
    }

    public an(Class<?> r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ao
    public final String a(Object r1) {
        return r1.toString();
    }
}
