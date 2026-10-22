package com.fasterxml.jackson.databind.i;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: JsonNodeFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12784a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l f12785c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l f12786d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12787b;

    static {
        l r0 = new l(false);
        f12785c = r0;
        f12786d = new l(true);
        f12784a = r0;
    }

    public l(boolean r1) {
        this.f12787b = r1;
    }

    public l() {
        this(false);
    }

    public e a(boolean r1) {
        if (r1 == false) goto L5;
        return e.e();
    L5:
        return e.f();
    }

    public o a() {
        return o.e();
    }

    public p a(short r1) {
        return s.a(r1);
    }

    public p a(int r1) {
        return j.a(r1);
    }

    public p a(long r1) {
        return n.a(r1);
    }

    public u a(BigInteger r1) {
        if (r1 != null) goto L6;
        return a();
    L6:
        return c.a(r1);
    }

    public p a(float r1) {
        return i.a(r1);
    }

    public p a(double r1) {
        return h.a(r1);
    }

    public u a(BigDecimal r1) {
        if (r1 != null) goto L6;
        return a();
    L6:
        if (this.f12787b == false) goto L10;
        return g.a(r1);
    L10:
        if (r1.signum() == 0) goto L12;
        r1 = r1.stripTrailingZeros();     // Catch: ArithmeticException -> L16
    L15:
        return g.a(r1);
    L12:
        return g.f12771a;
    }

    public t a(String r1) {
        return t.b(r1);
    }

    public d a(byte[] r1) {
        return d.a(r1);
    }

    public a b() {
        return new a(this);
    }

    public q c() {
        return new q(this);
    }

    public u a(Object r1) {
        return new r(r1);
    }

    public u a(com.fasterxml.jackson.databind.l.u r1) {
        return new r(r1);
    }
}
