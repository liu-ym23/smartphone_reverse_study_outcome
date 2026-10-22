package org.c.a.i;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: ResolverTuple.java */
/* JADX INFO: loaded from: classes5.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.c.a.f.b f40479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pattern f40480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f40481c;

    public b(org.c.a.f.b r1, Pattern r2, int r3) {
        this.f40479a = r1;
        this.f40480b = r2;
        this.f40481c = r3;
    }

    public org.c.a.f.b a() {
        return this.f40479a;
    }

    public Pattern b() {
        return this.f40480b;
    }

    public int c() {
        return this.f40481c;
    }

    public String toString() {
        return "Tuple tag=" + this.f40479a + " regexp=" + this.f40480b + " limit=" + this.f40481c;
    }
}
