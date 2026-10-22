package org.c.a.a;

import org.c.a.d.d;

/* JADX INFO: compiled from: CommentLine.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private org.c.a.c.a f40336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private org.c.a.c.a f40337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f40338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f40339d;

    public b(d r4) {
        this(r4.f(), r4.g(), r4.b(), r4.c());
    }

    public b(org.c.a.c.a r1, org.c.a.c.a r2, String r3, c r4) {
        this.f40336a = r1;
        this.f40337b = r2;
        this.f40338c = r3;
        this.f40339d = r4;
    }

    public c a() {
        return this.f40339d;
    }

    public String b() {
        return this.f40338c;
    }

    public String toString() {
        return "<" + getClass().getName() + " (type=" + a() + ", value=" + b() + ")>";
    }
}
