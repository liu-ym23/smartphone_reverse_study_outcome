package com.fasterxml.jackson.databind.b.a;

import com.fasterxml.jackson.annotation.JacksonInject;

/* JADX INFO: compiled from: CreatorCandidate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.o f12280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f12281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final a[] f12282d;

    /* JADX INFO: compiled from: CreatorCandidate.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.e.n f12283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.e.t f12284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JacksonInject.Value f12285c;

        public a(com.fasterxml.jackson.databind.e.n r1, com.fasterxml.jackson.databind.e.t r2, JacksonInject.Value r3) {
            this.f12283a = r1;
            this.f12284b = r2;
            this.f12285c = r3;
        }
    }

    public d(com.fasterxml.jackson.databind.b r1, com.fasterxml.jackson.databind.e.o r2, a[] r3, int r4) {
        this.f12279a = r1;
        this.f12280b = r2;
        this.f12282d = r3;
        this.f12281c = r4;
    }

    public static d a(com.fasterxml.jackson.databind.b r7, com.fasterxml.jackson.databind.e.o r8, com.fasterxml.jackson.databind.e.t[] r9) {
        int r0 = r8.e();
        a[] r1 = new a[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        com.fasterxml.jackson.databind.e.n r3 = r8.d(r2);
        JacksonInject.Value r4 = r7.e(r3);
        if (r9 != null) goto L7;
        com.fasterxml.jackson.databind.e.t r6 = null;
    L8:
        r1[r2] = new a(r3, r6, r4);
        r2 = r2 + 1;
        goto L3
    L7:
        r6 = r9[r2];
        goto L8
    L10:
        return new d(r7, r8, r1, r0);
    }

    public com.fasterxml.jackson.databind.e.o a() {
        return this.f12280b;
    }

    public int b() {
        return this.f12281c;
    }

    public JacksonInject.Value a(int r1) {
        return this.f12282d[r1].f12285c;
    }

    public com.fasterxml.jackson.databind.e.n b(int r1) {
        return this.f12282d[r1].f12283a;
    }

    public com.fasterxml.jackson.databind.e.t c(int r1) {
        return this.f12282d[r1].f12284b;
    }

    public com.fasterxml.jackson.databind.x d(int r1) {
        com.fasterxml.jackson.databind.e.t r0 = this.f12282d[r1].f12284b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b();
    }

    public com.fasterxml.jackson.databind.x e(int r1) {
        com.fasterxml.jackson.databind.e.t r0 = this.f12282d[r1].f12284b;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.e() == true) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public com.fasterxml.jackson.databind.x f(int r2) {
        String r1 = this.f12279a.g(this.f12282d[r2].f12283a);
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return com.fasterxml.jackson.databind.x.a(r1);
    }

    public int c() {
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r1 >= this.f12281c) goto L11;
        if (this.f12282d[r1].f12285c != null) goto L10;
        if (r2 >= 0) goto L8;
        r2 = r1;
        goto L10
    L8:
        return -1;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r2;
    }

    public String toString() {
        return this.f12280b.toString();
    }
}
