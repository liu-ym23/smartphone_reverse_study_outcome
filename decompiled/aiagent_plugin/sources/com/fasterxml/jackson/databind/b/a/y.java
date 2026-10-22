package com.fasterxml.jackson.databind.b.a;

import java.util.BitSet;

/* JADX INFO: compiled from: PropertyValueBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.k f12348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h f12349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final s f12350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Object[] f12351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12352e;
    protected int f;
    protected final BitSet g;
    protected x h;
    protected Object i;

    public y(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, int r3, s r4) {
        this.f12348a = r1;
        this.f12349b = r2;
        this.f12352e = r3;
        this.f12350c = r4;
        this.f12351d = new Object[r3];
        if (r3 >= 32) goto L5;
        this.g = null;
        return;
    L5:
        this.g = new BitSet();
    }

    public Object[] a(com.fasterxml.jackson.databind.b.v[] r8) {
        if (this.f12352e <= 0) goto L17;
        if (this.g != null) goto L12;
        int r0 = this.f;
        int r2 = this.f12351d.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L17;
        if ((r0 & 1) != 0) goto L11;
        this.f12351d[r3] = a(r8[r3]);
    L11:
        r3 = r3 + 1;
        r0 = r0 >> 1;
        goto L7
    L12:
        int r1 = this.f12351d.length;
        int r4 = 0;
    L13:
        int r5 = this.g.nextClearBit(r4);
        if (r5 >= r1) goto L17;
        this.f12351d[r5] = a(r8[r5]);
        r4 = r5 + 1;
    L17:
        if (this.f12349b.a(com.fasterxml.jackson.databind.i.m) == false) goto L26;
        int r6 = 0;
    L20:
        if (r6 >= r8.length) goto L26;
        if (this.f12351d[r6] != null) goto L24;
        com.fasterxml.jackson.databind.b.v r7 = r8[r6];
        this.f12349b.a(r7, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", new Object[]{r7.a(), Integer.valueOf(r8[r6].g())});
    L24:
        r6 = r6 + 1;
    L26:
        return this.f12351d;
    }

    public Object a(com.fasterxml.jackson.databind.b.v r7) {
        if (r7.h() == null) goto L7;
        return this.f12349b.a(r7.h(), r7, null);
    L7:
        if (r7.s() == false) goto L10;
        this.f12349b.a(r7, "Missing required creator property '%s' (index %d)", new Object[]{r7.a(), Integer.valueOf(r7.g())});
    L10:
        if (this.f12349b.a(com.fasterxml.jackson.databind.i.l) == false) goto L22;
        this.f12349b.a(r7, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", new Object[]{r7.a(), Integer.valueOf(r7.g())});
    L22:
        Object r0 = r7.q().b(this.f12349b);     // Catch: com.fasterxml.jackson.databind.f -> L17
        if (r0 == null) goto L15;
        return r0;
    L15:
        return r7.o().b(this.f12349b);
    L17:
        e = move-exception;
        com.fasterxml.jackson.databind.e.j r1 = r7.d();
        if (r1 == null) goto L21;
        e.a(r1.f(), r7.a());
    L21:
        throw e;
    }

    public boolean a(String r3) {
        s r0 = this.f12350c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r3.equals(r0.f12329b.b()) == false) goto L10;
        this.i = this.f12350c.a(this.f12348a, this.f12349b);
        return true;
    L10:
        return false;
    }

    public Object a(com.fasterxml.jackson.databind.h r4, Object r5) {
        s r0 = this.f12350c;
        if (r0 == null) goto L11;
        Object r1 = this.i;
        if (r1 == null) goto L10;
        r4.a(r1, r0.f12330c, this.f12350c.f12331d).a(r5);
        com.fasterxml.jackson.databind.b.v r6 = this.f12350c.f;
        if (r6 == null) goto L11;
        return r6.b(r5, this.i);
    L10:
        r4.a(r0, r5);
    L11:
        return r5;
    }

    public x a() {
        return this.h;
    }

    public boolean a(com.fasterxml.jackson.databind.b.v r3, Object r4) {
        int r5 = r3.g();
        this.f12351d[r5] = r4;
        BitSet r6 = this.g;
        if (r6 != null) goto L15;
        int r7 = this.f;
        int r8 = (1 << r5) | r7;
        if (r7 == r8) goto L17;
        this.f = r8;
        int r9 = this.f12352e - 1;
        this.f12352e = r9;
        if (r9 > 0) goto L17;
        if (this.f12350c == null) goto L13;
        if (this.i != null) goto L13;
        return false;
    L13:
        return true;
    L17:
        return false;
    L15:
        if (r6.get(r5) == true) goto L17;
        this.g.set(r5);
        this.f12352e--;
        goto L17
    }

    public void b(com.fasterxml.jackson.databind.b.v r3, Object r4) {
        this.h = new x.c(this.h, r4, r3);
    }

    public void a(com.fasterxml.jackson.databind.b.u r3, String r4, Object r5) {
        this.h = new x.a(this.h, r5, r3, r4);
    }

    public void a(Object r3, Object r4) {
        this.h = new x.b(this.h, r4, r3);
    }
}
