package org.c.a.l;

import java.util.Objects;

/* JADX INFO: compiled from: ScalarToken.java */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f40507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.c.a.a.d f40508c;

    public q(String r7, org.c.a.c.a r8, org.c.a.c.a r9, boolean r10) {
        this(r7, r10, r8, r9, org.c.a.a.d.f40328e);
    }

    public q(String r1, boolean r2, org.c.a.c.a r3, org.c.a.c.a r4, org.c.a.a.d r5) {
        super(r3, r4);
        this.f40506a = r1;
        this.f40507b = r2;
        Objects.requireNonNull(r5, "Style must be provided.");
        this.f40508c = r5;
    }

    public boolean a() {
        return this.f40507b;
    }

    public String c() {
        return this.f40506a;
    }

    public org.c.a.a.d d() {
        return this.f40508c;
    }

    @Override // org.c.a.l.v
    public v.a b() {
        return v.a.p;
    }
}
