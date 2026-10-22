package com.fasterxml.jackson.a.h;

import java.io.Serializable;

/* JADX INFO: compiled from: Separators.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f12117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f12118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char f12119c;

    public static n a() {
        return new n();
    }

    public n() {
        this(':', ',', ',');
    }

    public n(char r1, char r2, char r3) {
        this.f12117a = r1;
        this.f12118b = r2;
        this.f12119c = r3;
    }

    public char b() {
        return this.f12117a;
    }

    public char c() {
        return this.f12118b;
    }

    public char d() {
        return this.f12119c;
    }
}
