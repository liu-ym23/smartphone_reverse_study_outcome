package com.fasterxml.jackson.a.d;

import com.fasterxml.jackson.a.h.o;

/* JADX INFO: compiled from: IOContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final d f12000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    protected final Object f12001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f12002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.h.a f12003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected byte[] f12004e;
    protected char[] f;
    protected char[] g;
    protected char[] h;

    public e(com.fasterxml.jackson.a.h.a r1, d r2, boolean r3) {
        this.f12003d = r1;
        this.f12000a = r2;
        this.f12001b = r2.c();
        this.f12002c = r3;
    }

    public boolean a() {
        return this.f12002c;
    }

    public d b() {
        return this.f12000a;
    }

    public o c() {
        return new o(this.f12003d);
    }

    public byte[] d() {
        a(this.f12004e);
        byte[] r0 = this.f12003d.a(3);
        this.f12004e = r0;
        return r0;
    }

    public char[] e() {
        a(this.f);
        char[] r0 = this.f12003d.b(0);
        this.f = r0;
        return r0;
    }

    public char[] a(int r3) {
        a(this.f);
        char[] r4 = this.f12003d.b(0, r3);
        this.f = r4;
        return r4;
    }

    public char[] f() {
        a(this.g);
        char[] r0 = this.f12003d.b(1);
        this.g = r0;
        return r0;
    }

    public char[] b(int r3) {
        a(this.h);
        char[] r4 = this.f12003d.b(3, r3);
        this.h = r4;
        return r4;
    }

    public void a(byte[] r2) {
        if (r2 == null) goto L5;
        a(r2, this.f12004e);
        this.f12004e = null;
        this.f12003d.a(3, r2);
        return;
    }

    public void a(char[] r2) {
        if (r2 == null) goto L5;
        a(r2, this.f);
        this.f = null;
        this.f12003d.a(0, r2);
        return;
    }

    public void b(char[] r2) {
        if (r2 == null) goto L5;
        a(r2, this.g);
        this.g = null;
        this.f12003d.a(1, r2);
        return;
    }

    public void c(char[] r2) {
        if (r2 == null) goto L5;
        a(r2, this.h);
        this.h = null;
        this.f12003d.a(3, r2);
        return;
    }

    public final void a(Object r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        throw new IllegalStateException("Trying to call same allocXxx() method second time");
    }

    public final void a(byte[] r1, byte[] r2) {
        if (r1 != r2) goto L4;
        return;
    L4:
        if (r1.length < r2.length) goto L7;
        return;
    L7:
        throw g();
    }

    public final void a(char[] r1, char[] r2) {
        if (r1 != r2) goto L4;
        return;
    L4:
        if (r1.length < r2.length) goto L7;
        return;
    L7:
        throw g();
    }

    private IllegalArgumentException g() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }
}
