package com.fasterxml.jackson.a.a;

import com.fasterxml.jackson.a.d.g;
import com.fasterxml.jackson.a.d.i;
import com.fasterxml.jackson.a.h.q;
import com.fasterxml.jackson.a.j;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: ParserMinimalBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends k {
    protected static final byte[] F = null;
    protected static final int[] G = null;
    protected static final BigInteger H = null;
    protected static final BigInteger I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected static final BigInteger f11976J = null;
    protected static final BigInteger K = null;
    protected static final BigDecimal L = null;
    protected static final BigDecimal M = null;
    protected static final BigDecimal N = null;
    protected static final BigDecimal O = null;
    protected n P;
    protected n Q;

    public abstract void ad();

    @Override // com.fasterxml.jackson.a.k
    public abstract n g();

    @Override // com.fasterxml.jackson.a.k
    public abstract String v();

    @Override // com.fasterxml.jackson.a.k
    public abstract String x();

    static {
        F = new byte[0];
        G = new int[0];
        BigInteger r0 = BigInteger.valueOf(-2147483648L);
        H = r0;
        BigInteger r1 = BigInteger.valueOf(2147483647L);
        I = r1;
        BigInteger r2 = BigInteger.valueOf(Long.MIN_VALUE);
        f11976J = r2;
        BigInteger r3 = BigInteger.valueOf(Long.MAX_VALUE);
        K = r3;
        L = new BigDecimal(r2);
        M = new BigDecimal(r3);
        N = new BigDecimal(r0);
        O = new BigDecimal(r1);
    }

    public c(int r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.a.k
    public n l() {
        return this.P;
    }

    @Override // com.fasterxml.jackson.a.k
    public int m() {
        n r0 = this.P;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.a();
    }

    @Override // com.fasterxml.jackson.a.k
    public n n() {
        return this.P;
    }

    @Override // com.fasterxml.jackson.a.k
    @Deprecated
    public int o() {
        n r0 = this.P;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.a();
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean p() {
        if (this.P == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean b(int r3) {
        n r2 = this.P;
        if (r2 != null) goto L9;
        if (r3 != 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        if (r2.a() != r3) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean a(n r1) {
        if (this.P != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean q() {
        if (this.P != n.f12154d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean r() {
        if (this.P != n.f12152b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean s() {
        if (this.P != n.i) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public n h() {
        n r0 = g();
        if (r0 == n.f) goto L5;
        return r0;
    L5:
        return g();
    }

    @Override // com.fasterxml.jackson.a.k
    public k k() {
        if (this.P != n.f12152b) goto L5;
    L7:
        int r0 = 1;
    L8:
        n r1 = g();
        if (r1 == null) goto L10;
        if (r1.e() == true) goto L14;
        if (r1.f() == true) goto L17;
        if (r1 != n.f12151a) goto L8;
        a("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", getClass().getName());
        goto L8
    L17:
        r0 = r0 - 1;
        if (r0 != 0) goto L8;
        return this;
    L14:
        r0 = r0 + 1;
        goto L8
    L10:
        ad();
        return this;
    L5:
        if (this.P == n.f12154d) goto L7;
        return this;
    }

    @Override // com.fasterxml.jackson.a.k
    public void u() {
        n r0 = this.P;
        if (r0 == null) goto L6;
        this.Q = r0;
        this.P = null;
        return;
    }

    @Override // com.fasterxml.jackson.a.k
    public int P() {
        n r0 = this.P;
        if (r0 == n.i) goto L10;
        if (r0 == n.j) goto L10;
        return c(0);
    L10:
        return H();
    }

    @Override // com.fasterxml.jackson.a.k
    public int c(int r4) {
        n r0 = this.P;
        if (r0 == n.i) goto L26;
        if (r0 == n.j) goto L26;
        if (r0 == null) goto L24;
        int r1 = r0.a();
        if (r1 == 6) goto L19;
        switch(r1) {
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L12;
            default: goto L24;
        };
    L12:
        Object r3 = N();
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L24;
        return ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
    L16:
        return 0;
    L17:
        return 1;
    L19:
        String r2 = x();
        if (c(r2) == false) goto L23;
        return 0;
    L23:
        return i.a(r2, r4);
    L24:
        return r4;
    L26:
        return H();
    }

    @Override // com.fasterxml.jackson.a.k
    public long Q() {
        n r0 = this.P;
        if (r0 == n.i) goto L10;
        if (r0 == n.j) goto L10;
        return a(0);
    L10:
        return I();
    }

    @Override // com.fasterxml.jackson.a.k
    public long a(long r5) {
        n r0 = this.P;
        if (r0 == n.i) goto L26;
        if (r0 == n.j) goto L26;
        if (r0 == null) goto L24;
        int r1 = r0.a();
        if (r1 == 6) goto L19;
        switch(r1) {
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L12;
            default: goto L24;
        };
    L12:
        Object r4 = N();
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L24;
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue();
    L16:
        return 0;
    L17:
        return 1;
    L19:
        String r2 = x();
        if (c(r2) == false) goto L23;
        return 0;
    L23:
        return i.a(r2, r5);
    L24:
        return r5;
    L26:
        return I();
    }

    @Override // com.fasterxml.jackson.a.k
    public String R() {
        return a(null);
    }

    @Override // com.fasterxml.jackson.a.k
    public String a(String r3) {
        if (this.P != n.h) goto L7;
        return x();
    L7:
        if (this.P == n.f) goto L9;
        n r0 = this.P;
        if (r0 != null) goto L13;
    L19:
        return r3;
    L13:
        if (r0 == n.m) goto L19;
        if (this.P.g() == false) goto L19;
        return x();
    L9:
        return v();
    }

    public void a(String r1, com.fasterxml.jackson.a.h.c r2, com.fasterxml.jackson.a.a r3) {
        r3.a(r1, r2);     // Catch: IllegalArgumentException -> L4
        return;
    L4:
        e = move-exception;
        i(e.getMessage());
    }

    public boolean c(String r1) {
        return "null".equals(r1);
    }

    public void c(int r3, String r4) {
        String r5 = String.format("Unexpected character (%s) in numeric value", new Object[]{g(r3)});
        if (r4 == null) goto L5;
        r5 = r5 + ": " + r4;
    L5:
        i(r5);
    }

    public void d(String r3) {
        i("Invalid numeric value: " + r3);
    }

    public void ar() {
        e(x());
    }

    public void e(String r2) {
        a(r2, l());
    }

    public void a(String r3, n r4) {
        a(String.format("Numeric value (%s) out of range of int (%d - %s)", new Object[]{g(r3), Integer.MIN_VALUE, Integer.MAX_VALUE}), r4, Integer.TYPE);
    }

    public void as() {
        f(x());
    }

    public void f(String r2) {
        b(r2, l());
    }

    public void b(String r4, n r5) {
        a(String.format("Numeric value (%s) out of range of long (%d - %s)", new Object[]{g(r4), Long.MIN_VALUE, Long.MAX_VALUE}), r5, Long.TYPE);
    }

    public void a(String r2, n r3, Class<?> r4) {
        throw new com.fasterxml.jackson.a.b.a(this, r2, r3, r4);
    }

    public String g(String r2) {
        int r1 = r2.length();
        if (r1 >= 1000) goto L6;
        return r2;
    L6:
        if (r2.startsWith("-") == false) goto L9;
        r1 = r1 - 1;
    L9:
        return String.format("[Integer with %d digits]", new Object[]{Integer.valueOf(r1)});
    }

    public String h(String r2) {
        int r1 = r2.length();
        if (r1 >= 1000) goto L6;
        return r2;
    L6:
        if (r2.startsWith("-") == false) goto L9;
        r1 = r1 - 1;
    L9:
        return String.format("[number with %d characters]", new Object[]{Integer.valueOf(r1)});
    }

    public void d(int r3, String r4) {
        if (r3 >= 0) goto L4;
        at();
    L4:
        String r5 = String.format("Unexpected character (%s)", new Object[]{g(r3)});
        if (r4 == null) goto L7;
        r5 = r5 + ": " + r4;
    L7:
        i(r5);
    }

    public void at() {
        c(" in " + this.P, this.P);
    }

    public void b(n r2) {
        if (r2 != n.h) goto L6;
        String r0 = " in a String value";
    L12:
        c(r0, r2);
        return;
    L6:
        if (r2 != n.i) goto L8;
    L11:
        r0 = " in a Number value";
        goto L12
    L8:
        if (r2 == n.j) goto L11;
        r0 = " in a value";
        goto L12
    }

    public void c(String r4, n r5) {
        throw new g(this, r5, "Unexpected end-of-input" + r4);
    }

    public void e(int r2) {
        d(r2, "Expected space separating root-level values");
    }

    public void f(int r3) {
        i("Illegal character (" + g((char) r3) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    public static final String g(int r5) {
        char r0 = (char) r5;
        if (Character.isISOControl(r0) == false) goto L7;
        return "(CTRL-CHAR, code " + r5 + ")";
    L7:
        if (r5 <= 255) goto L11;
        return "'" + r0 + "' (code " + r5 + " / 0x" + Integer.toHexString(r5) + ")";
    L11:
        return "'" + r0 + "' (code " + r5 + ")";
    }

    public final void i(String r1) {
        throw b(r1);
    }

    public final void a(String r3, Object r4) {
        throw b(String.format(r3, new Object[]{r4}));
    }

    public final void a(String r3, Object r4, Object r5) {
        throw b(String.format(r3, new Object[]{r4, r5}));
    }

    public final void a(String r1, Throwable r2) {
        throw b(r1, r2);
    }

    public final void au() {
        q.a();
    }

    public final j b(String r2, Throwable r3) {
        return new j(this, r2, r3);
    }
}
