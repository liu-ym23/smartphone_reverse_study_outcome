package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.databind.j.s;
import java.io.Serializable;

/* JADX INFO: compiled from: SerializerFactoryConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final s[] f12235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.j.h[] f12236b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final s[] f12237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final s[] f12238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.h[] f12239e;

    static {
        f12235a = new s[0];
        f12236b = new com.fasterxml.jackson.databind.j.h[0];
    }

    public p() {
        this(null, null, null);
    }

    public p(s[] r1, s[] r2, com.fasterxml.jackson.databind.j.h[] r3) {
        if (r1 != null) goto L5;
        r1 = f12235a;
    L5:
        this.f12237c = r1;
        if (r2 != null) goto L8;
        r2 = f12235a;
    L8:
        this.f12238d = r2;
        if (r3 != null) goto L11;
        r3 = f12236b;
    L11:
        this.f12239e = r3;
    }

    public boolean a() {
        if (this.f12238d.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.f12239e.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Iterable<s> c() {
        return new com.fasterxml.jackson.databind.l.d(this.f12237c);
    }

    public Iterable<s> d() {
        return new com.fasterxml.jackson.databind.l.d(this.f12238d);
    }

    public Iterable<com.fasterxml.jackson.databind.j.h> e() {
        return new com.fasterxml.jackson.databind.l.d(this.f12239e);
    }
}
