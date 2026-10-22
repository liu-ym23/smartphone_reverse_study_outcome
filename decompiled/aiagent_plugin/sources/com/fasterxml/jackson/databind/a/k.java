package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.databind.b.b.ad;
import com.fasterxml.jackson.databind.b.q;
import com.fasterxml.jackson.databind.b.r;
import com.fasterxml.jackson.databind.b.z;
import java.io.Serializable;

/* JADX INFO: compiled from: DeserializerFactoryConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final q[] f12228a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.b.g[] f12229b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.a[] f12230c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final z[] f12231d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final r[] f12232e = null;
    protected final q[] f;
    protected final r[] g;
    protected final com.fasterxml.jackson.databind.b.g[] h;
    protected final com.fasterxml.jackson.databind.a[] i;
    protected final z[] j;

    static {
        f12228a = new q[0];
        f12229b = new com.fasterxml.jackson.databind.b.g[0];
        f12230c = new com.fasterxml.jackson.databind.a[0];
        f12231d = new z[0];
        f12232e = new r[]{new ad()};
    }

    public k() {
        this(null, null, null, null, null);
    }

    public k(q[] r1, r[] r2, com.fasterxml.jackson.databind.b.g[] r3, com.fasterxml.jackson.databind.a[] r4, z[] r5) {
        if (r1 != null) goto L5;
        r1 = f12228a;
    L5:
        this.f = r1;
        if (r2 != null) goto L8;
        r2 = f12232e;
    L8:
        this.g = r2;
        if (r3 != null) goto L11;
        r3 = f12229b;
    L11:
        this.h = r3;
        if (r4 != null) goto L14;
        r4 = f12230c;
    L14:
        this.i = r4;
        if (r5 != null) goto L17;
        r5 = f12231d;
    L17:
        this.j = r5;
    }

    public boolean a() {
        if (this.g.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.h.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.i.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.j.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Iterable<q> e() {
        return new com.fasterxml.jackson.databind.l.d(this.f);
    }

    public Iterable<r> f() {
        return new com.fasterxml.jackson.databind.l.d(this.g);
    }

    public Iterable<com.fasterxml.jackson.databind.b.g> g() {
        return new com.fasterxml.jackson.databind.l.d(this.h);
    }

    public Iterable<com.fasterxml.jackson.databind.a> h() {
        return new com.fasterxml.jackson.databind.l.d(this.i);
    }

    public Iterable<z> i() {
        return new com.fasterxml.jackson.databind.l.d(this.j);
    }
}
