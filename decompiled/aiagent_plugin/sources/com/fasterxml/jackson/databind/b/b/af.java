package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: StdValueInstantiator.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class af extends com.fasterxml.jackson.databind.b.y implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f12387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<?> f12388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.e.o f12389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.e.o f12390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.b.v[] f12391e;
    protected com.fasterxml.jackson.databind.k f;
    protected com.fasterxml.jackson.databind.e.o g;
    protected com.fasterxml.jackson.databind.b.v[] h;
    protected com.fasterxml.jackson.databind.k i;
    protected com.fasterxml.jackson.databind.e.o j;
    protected com.fasterxml.jackson.databind.b.v[] k;
    protected com.fasterxml.jackson.databind.e.o l;
    protected com.fasterxml.jackson.databind.e.o m;
    protected com.fasterxml.jackson.databind.e.o n;
    protected com.fasterxml.jackson.databind.e.o o;
    protected com.fasterxml.jackson.databind.e.o p;
    protected com.fasterxml.jackson.databind.e.o q;
    protected com.fasterxml.jackson.databind.e.o r;

    public af(com.fasterxml.jackson.databind.g r1, com.fasterxml.jackson.databind.k r2) {
        if (r2 != null) goto L5;
        String r3 = "UNKNOWN TYPE";
    L6:
        this.f12387a = r3;
        if (r2 != null) goto L9;
        Class<?> r4 = Object.class;
    L10:
        this.f12388b = r4;
        return;
    L9:
        r4 = r2.e();
        goto L10
    L5:
        r3 = r2.toString();
        goto L6
    }

    public void a(com.fasterxml.jackson.databind.e.o r1, com.fasterxml.jackson.databind.e.o r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.b.v[] r4, com.fasterxml.jackson.databind.e.o r5, com.fasterxml.jackson.databind.b.v[] r6) {
        this.f12389c = r1;
        this.g = r2;
        this.f = r3;
        this.h = r4;
        this.f12390d = r5;
        this.f12391e = r6;
    }

    public void a(com.fasterxml.jackson.databind.e.o r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.b.v[] r3) {
        this.j = r1;
        this.i = r2;
        this.k = r3;
    }

    public void a(com.fasterxml.jackson.databind.e.o r1) {
        this.l = r1;
    }

    public void b(com.fasterxml.jackson.databind.e.o r1) {
        this.m = r1;
    }

    public void c(com.fasterxml.jackson.databind.e.o r1) {
        this.n = r1;
    }

    public void d(com.fasterxml.jackson.databind.e.o r1) {
        this.o = r1;
    }

    public void e(com.fasterxml.jackson.databind.e.o r1) {
        this.p = r1;
    }

    public void f(com.fasterxml.jackson.databind.e.o r1) {
        this.q = r1;
    }

    public void g(com.fasterxml.jackson.databind.e.o r1) {
        this.r = r1;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public String b() {
        return this.f12387a;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Class<?> a() {
        return this.f12388b;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean d() {
        if (this.l == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean e() {
        if (this.m == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean f() {
        if (this.n == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean g() {
        if (this.o == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean h() {
        if (this.p == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean i() {
        if (this.q == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean j() {
        if (this.r == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean k() {
        if (this.f12389c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean l() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean m() {
        if (this.i == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean n() {
        if (this.f12390d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public boolean c() {
        if (k() == false) goto L5;
    L22:
        return true;
    L5:
        if (l() == true) goto L22;
        if (m() == true) goto L22;
        if (n() == true) goto L22;
        if (d() == true) goto L22;
        if (e() == true) goto L22;
        if (f() == true) goto L22;
        if (h() == true) goto L22;
        if (j() == true) goto L22;
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.g r1) {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.k c(com.fasterxml.jackson.databind.g r1) {
        return this.i;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.b.v[] a(com.fasterxml.jackson.databind.g r1) {
        return this.f12391e;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.f12389c;
        if (r0 == null) goto L5;
        return r0.call();
    L8:
        e = move-exception;
        return r4.a(this.f12388b, null, b(r4, e));
    L5:
        return super.a(r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, Object[] r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.f12390d;
        if (r0 == null) goto L5;
        return r0.call(r4);
    L8:
        e = move-exception;
        return r3.a(this.f12388b, r4, b(r3, e));
    L5:
        return super.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, Object r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.g;
        if (r0 != null) goto L9;
        com.fasterxml.jackson.databind.e.o r1 = this.j;
        if (r1 == null) goto L9;
        return a(r1, this.k, r3, r4);
    L9:
        return a(r0, this.h, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object b(com.fasterxml.jackson.databind.h r3, Object r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.j;
        if (r0 != null) goto L9;
        if (this.g == null) goto L9;
        return a(r3, r4);
    L9:
        return a(r0, this.k, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, String r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.l;
        if (r0 == null) goto L10;
        return r0.a(r4);
    L6:
        th = move-exception;
        return r3.a(this.l.f(), r4, b(r3, th));
    L10:
        return super.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, int r4) {
        if (this.m == null) goto L11;
        Integer r5 = Integer.valueOf(r4);
        return this.m.a(r5);
    L7:
        th = move-exception;
        return r3.a(this.m.f(), r5, b(r3, th));
    L11:
        if (this.n == null) goto L19;
        Long r6 = Long.valueOf(r4);
        return this.n.a(r6);
    L15:
        th = move-exception;
        return r3.a(this.n.f(), r6, b(r3, th));
    L19:
        if (this.o == null) goto L27;
        BigInteger r7 = BigInteger.valueOf(r4);
        return this.o.a(r7);
    L23:
        th = move-exception;
        return r3.a(this.o.f(), r7, b(r3, th));
    L27:
        return super.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r2, long r3) {
        if (this.n == null) goto L11;
        Long r4 = Long.valueOf(r3);
        return this.n.a(r4);
    L7:
        th = move-exception;
        return r2.a(this.n.f(), r4, b(r2, th));
    L11:
        if (this.o == null) goto L19;
        BigInteger r5 = BigInteger.valueOf(r3);
        return this.o.a(r5);
    L15:
        th = move-exception;
        return r2.a(this.o.f(), r5, b(r2, th));
    L19:
        return super.a(r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, BigInteger r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.o;
        if (r0 == null) goto L10;
        return r0.a(r4);
    L6:
        th = move-exception;
        return r3.a(this.o.f(), r4, b(r3, th));
    L10:
        return super.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r2, double r3) {
        if (this.p == null) goto L11;
        Double r4 = Double.valueOf(r3);
        return this.p.a(r4);
    L7:
        th = move-exception;
        return r2.a(this.p.f(), r4, b(r2, th));
    L11:
        if (this.q == null) goto L19;
        BigDecimal r5 = BigDecimal.valueOf(r3);
        return this.q.a(r5);
    L15:
        th = move-exception;
        return r2.a(this.q.f(), r5, b(r2, th));
    L19:
        return super.a(r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, BigDecimal r4) {
        com.fasterxml.jackson.databind.e.o r0 = this.q;
        if (r0 == null) goto L10;
        return r0.a(r4);
    L6:
        th = move-exception;
        return r3.a(this.q.f(), r4, b(r3, th));
    L10:
        if (this.p == null) goto L19;
        Double r1 = a(r4);
        if (r1 == null) goto L19;
        return this.p.a(r1);
    L15:
        th = move-exception;
        return r3.a(this.p.f(), r1, b(r3, th));
    L19:
        return super.a(r3, r4);
    }

    static Double a(BigDecimal r2) {
        double r0 = r2.doubleValue();
        if (Double.isInfinite(r0) == false) goto L6;
        return null;
    L6:
        return Double.valueOf(r0);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r3, boolean r4) {
        if (this.r == null) goto L5;
        Boolean r5 = Boolean.valueOf(r4);
        return this.r.a(r5);
    L9:
        th = move-exception;
        return r3.a(this.r.f(), r5, b(r3, th));
    L5:
        return super.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.e.o p() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.e.o q() {
        return this.j;
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.e.o o() {
        return this.f12389c;
    }

    public com.fasterxml.jackson.databind.m a(com.fasterxml.jackson.databind.h r2, Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.m.class) == false) goto L7;
        return (com.fasterxml.jackson.databind.m) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.m.class, "com.obric.aiagent.plugin");
    L7:
        return r2.a(a(), r3);
    }

    public com.fasterxml.jackson.databind.m b(com.fasterxml.jackson.databind.h r2, Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r3, ExceptionInInitializerError.class) == false) goto L5;
    L6:
        Throwable r0 = r3.getCause();
        if (r0 == null) goto L10;
        r3 = r0;
    L10:
        return a(r2, r3);
    L5:
        if (ZeusTransformUtils.instanceOf(r3, InvocationTargetException.class) == false) goto L10;
        goto L6
    }

    private Object a(com.fasterxml.jackson.databind.e.o r7, com.fasterxml.jackson.databind.b.v[] r8, com.fasterxml.jackson.databind.h r9, Object r10) {
        if (r7 == null) goto L19;
        if (r8 == null) goto L5;
        int r0 = r8.length;     // Catch: Throwable -> L15
        Object[] r1 = new Object[r0];     // Catch: Throwable -> L15
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L14;
        com.fasterxml.jackson.databind.b.v r3 = r8[r2];     // Catch: Throwable -> L15
        if (r3 != null) goto L11;
        r1[r2] = r10;     // Catch: Throwable -> L15
    L12:
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L7
    L11:
        r1[r2] = r9.a(r3.h(), r3, null);     // Catch: Throwable -> L15
        goto L12
    L14:
        return r7.call(r1);
    L5:
        return r7.a(r10);
    L15:
        th = move-exception;
        throw b(r9, th);
    L19:
        throw new IllegalStateException("No delegate constructor for " + b());
    }
}
