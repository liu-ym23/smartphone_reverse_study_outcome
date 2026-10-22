package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.e.af;
import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: compiled from: DeserializationConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.fasterxml.jackson.databind.a.n<i, g> implements Serializable {
    private static final int v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> f12703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.i.l f12704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.d f12705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.i f12706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f12707e;
    protected final int f;
    protected final int g;
    protected final int h;
    protected final int i;

    @Override // com.fasterxml.jackson.databind.a.n
    public /* synthetic */ com.fasterxml.jackson.databind.a.n b(long r1) {
        return a(r1);
    }

    static {
        v = a(i.class);
    }

    public g(com.fasterxml.jackson.databind.a.a r1, com.fasterxml.jackson.databind.h.d r2, af r3, com.fasterxml.jackson.databind.l.v r4, com.fasterxml.jackson.databind.a.h r5, com.fasterxml.jackson.databind.a.d r6) {
        super(r1, r2, r3, r4, r5);
        this.f12707e = v;
        this.f12703a = null;
        this.f12704b = com.fasterxml.jackson.databind.i.l.f12784a;
        this.f12706d = null;
        this.f12705c = r6;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    private g(g r1, long r2, int r4, int r5, int r6, int r7, int r8) {
        super(r1, r2);
        this.f12707e = r4;
        this.f12703a = r1.f12703a;
        this.f12704b = r1.f12704b;
        this.f12705c = r1.f12705c;
        this.f12706d = r1.f12706d;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }

    public final g a(long r11) {
        return new g(this, r11, this.f12707e, this.f, this.g, this.h, this.i);
    }

    public com.fasterxml.jackson.a.k a(com.fasterxml.jackson.a.k r3) {
        int r0 = this.g;
        if (r0 == 0) goto L5;
        r3.a(this.f, r0);
    L5:
        int r1 = this.i;
        if (r1 == 0) goto L8;
        r3.b(this.h, r1);
    L8:
        return r3;
    }

    public boolean a() {
        if (this.q == null) goto L7;
        return !this.q.e();
    L7:
        return a(i.s);
    }

    public final boolean a(i r1) {
        if ((this.f12707e & r1.b()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int b() {
        return this.f12707e;
    }

    public com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> c() {
        return this.f12703a;
    }

    public final com.fasterxml.jackson.databind.i.l d() {
        return this.f12704b;
    }

    public com.fasterxml.jackson.databind.a.i e() {
        com.fasterxml.jackson.databind.a.i r0 = this.f12706d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.fasterxml.jackson.databind.a.i.f12214a;
    }

    public c a(k r2) {
        return i().d(this, r2, this);
    }

    public c b(k r2) {
        return i().c(this, r2, this);
    }

    public c a(k r2, c r3) {
        return i().b(this, r2, this, r3);
    }

    public com.fasterxml.jackson.databind.h.e c(k r4) {
        com.fasterxml.jackson.databind.e.d r0 = c(r4.e()).c();
        com.fasterxml.jackson.databind.h.g<?> r1 = j().a(this, r0, r4);
        Collection<com.fasterxml.jackson.databind.h.b> r2 = null;
        if (r1 != null) goto L7;
        r1 = d(r4);
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.a(this, r4, r2);
    L7:
        r2 = v().b(this, r0);
        goto L9
    }

    public com.fasterxml.jackson.databind.a.b a(com.fasterxml.jackson.databind.k.f r2, Class<?> r3, com.fasterxml.jackson.databind.a.e r4) {
        return this.f12705c.a(this, r2, r3, r4);
    }

    public com.fasterxml.jackson.databind.a.b a(com.fasterxml.jackson.databind.k.f r2, Class<?> r3, com.fasterxml.jackson.databind.a.b r4) {
        return this.f12705c.a(this, r2, r3, r4);
    }
}
