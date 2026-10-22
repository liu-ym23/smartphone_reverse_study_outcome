package com.fasterxml.jackson.a.a;

import com.fasterxml.jackson.a.d.d;
import com.fasterxml.jackson.a.d.e;
import com.fasterxml.jackson.a.h.i;
import com.fasterxml.jackson.a.h.o;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.m;
import com.fasterxml.jackson.a.n;
import com.fasterxml.jackson.a.r;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: ParserBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final i<r> f11974d = null;
    protected BigDecimal A;
    protected boolean B;
    protected int C;
    protected int D;
    protected int E;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final e f11975e;
    protected boolean f;
    protected int g;
    protected int h;
    protected long i;
    protected int j;
    protected int k;
    protected long l;
    protected int m;
    protected int n;
    protected com.fasterxml.jackson.a.e.c o;
    protected n p;
    protected final o q;
    protected char[] r;
    protected boolean s;
    protected com.fasterxml.jackson.a.h.c t;
    protected byte[] u;
    protected int v;
    protected int w;
    protected long x;
    protected double y;
    protected BigInteger z;

    public abstract void ab();

    public void aq() {
    }

    @Override // com.fasterxml.jackson.a.k
    public /* synthetic */ m d() {
        return X();
    }

    static {
        f11974d = f12135a;
    }

    public b(e r2, int r3) {
        super(r3);
        this.j = 1;
        this.m = 1;
        this.v = 0;
        this.f11975e = r2;
        this.q = r2.c();
        if (k.a.m.a(r3) == false) goto L5;
        com.fasterxml.jackson.a.e.a r4 = com.fasterxml.jackson.a.e.a.a(this);
    L6:
        this.o = com.fasterxml.jackson.a.e.c.b(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.fasterxml.jackson.a.k
    public void a(Object r1) {
        this.o.a(r1);
    }

    @Override // com.fasterxml.jackson.a.k
    @Deprecated
    public k a(int r2) {
        int r0 = this.f12136b ^ r2;
        if (r0 == 0) goto L5;
        this.f12136b = r2;
        c(r2, r0);
    L5:
        return this;
    }

    @Override // com.fasterxml.jackson.a.k
    public k a(int r3, int r4) {
        int r0 = this.f12136b;
        int r5 = r3 & r4;
        int r6 = r5 | ((~r4) & r0);
        int r7 = r0 ^ r6;
        if (r7 == 0) goto L5;
        this.f12136b = r6;
        c(r6, r7);
    L5:
        return this;
    }

    public void c(int r2, int r3) {
        int r0 = k.a.m.c();
        if ((r3 & r0) != 0) goto L5;
        return;
    L5:
        if ((r2 & r0) != 0) goto L7;
        return;
    L7:
        if (this.o.l() != null) goto L9;
        this.o = this.o.a(com.fasterxml.jackson.a.e.a.a(this));
        return;
    L9:
        this.o = this.o.a(null);
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public String v() {
        if (this.P != n.f12152b) goto L5;
    L6:
        com.fasterxml.jackson.a.e.c r0 = this.o.j();
        if (r0 != null) goto L9;
    L11:
        return this.o.h();
    L9:
        return r0.h();
    L5:
        if (this.P != n.f12154d) goto L11;
        goto L6
    }

    @Override // com.fasterxml.jackson.a.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f == true) goto L10;
        this.g = Math.max(this.g, this.h);
        this.f = true;
        ab();     // Catch: Throwable -> L7
        ac();
        return;
    L7:
        th = move-exception;
        ac();
        throw th;
    }

    public com.fasterxml.jackson.a.e.c X() {
        return this.o;
    }

    @Override // com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.i f() {
        return new com.fasterxml.jackson.a.i(ap(), -1, Y(), Z(), aa());
    }

    @Override // com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.i e() {
        int r8 = (this.g - this.k) + 1;
        d r2 = ap();
        long r3 = this.i;
        return new com.fasterxml.jackson.a.i(r2, -1, ((long) this.g) + r3, this.j, r8);
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean B() {
        if (this.P != n.h) goto L7;
        return true;
    L7:
        if (this.P == n.f) goto L9;
        return false;
    L9:
        return this.s;
    }

    @Override // com.fasterxml.jackson.a.k
    public byte[] a(com.fasterxml.jackson.a.a r3) {
        if (this.u != null) goto L9;
        if (this.P == n.h) goto L7;
        i("Current token (" + this.P + ") not VALUE_STRING, can not access as binary");
    L7:
        com.fasterxml.jackson.a.h.c r0 = af();
        a(x(), r0, r3);
        this.u = r0.b();
    L9:
        return this.u;
    }

    public long Y() {
        return this.l;
    }

    public int Z() {
        return this.m;
    }

    public int aa() {
        int r0 = this.n;
        if (r0 >= 0) goto L6;
        return r0;
    L6:
        return r0 + 1;
    }

    public void ac() {
        this.q.a();
        char[] r0 = this.r;
        if (r0 == null) goto L6;
        this.r = null;
        this.f11975e.c(r0);
        return;
    }

    @Override // com.fasterxml.jackson.a.a.c
    public void ad() {
        if (this.o.c() == false) goto L5;
        return;
    L5:
        if (this.o.b() == false) goto L7;
        String r0 = "Array";
    L8:
        c(String.format(": expected close marker for %s (start marker at %s)", new Object[]{r0, this.o.a(ap())}), null);
        return;
    L7:
        r0 = "Object";
        goto L8
    }

    public final int ae() {
        ad();
        return -1;
    }

    public com.fasterxml.jackson.a.h.c af() {
        com.fasterxml.jackson.a.h.c r0 = this.t;
        if (r0 != null) goto L5;
        this.t = new com.fasterxml.jackson.a.h.c();
    L7:
        return this.t;
    L5:
        r0.a();
        goto L7
    }

    public final n a(boolean r2, int r3, int r4, int r5) {
        if (r4 >= 1) goto L8;
        if (r5 >= 1) goto L8;
        return a(r2, r3);
    L8:
        return b(r2, r3, r4, r5);
    }

    public final n a(boolean r1, int r2) {
        this.B = r1;
        this.C = r2;
        this.D = 0;
        this.E = 0;
        this.v = 0;
        return n.i;
    }

    public final n b(boolean r1, int r2, int r3, int r4) {
        this.B = r1;
        this.C = r2;
        this.D = r3;
        this.E = r4;
        this.v = 0;
        return n.j;
    }

    public final n a(String r2, double r3) {
        this.q.a(r2);
        this.y = r3;
        this.v = 8;
        return n.j;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean t() {
        if (this.P == n.j) goto L5;
        return false;
    L5:
        if ((this.v & 8) == 0) goto L13;
        double r0 = this.y;
        if (Double.isNaN(r0) == false) goto L9;
    L10:
        return true;
    L9:
        if (Double.isInfinite(r0) == true) goto L10;
        return false;
    L13:
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public Number C() {
        if (this.v != 0) goto L6;
        d(0);
    L6:
        if (this.P != n.i) goto L20;
        int r0 = this.v;
        if ((r0 & 1) == 0) goto L12;
        return Integer.valueOf(this.w);
    L12:
        if ((r0 & 2) == 0) goto L16;
        return Long.valueOf(this.x);
    L16:
        if ((r0 & 4) != 0) goto L18;
        au();
        goto L20
    L18:
        return this.z;
    L20:
        int r1 = this.v;
        if ((r1 & 16) == 0) goto L25;
        return this.A;
    L25:
        if ((r1 & 8) != 0) goto L28;
        au();
    L28:
        return Double.valueOf(this.y);
    }

    @Override // com.fasterxml.jackson.a.k
    public Number D() {
        if (this.P != n.i) goto L21;
        if (this.v != 0) goto L7;
        d(0);
    L7:
        int r0 = this.v;
        if ((r0 & 1) == 0) goto L12;
        return Integer.valueOf(this.w);
    L12:
        if ((r0 & 2) == 0) goto L16;
        return Long.valueOf(this.x);
    L16:
        if ((r0 & 4) != 0) goto L18;
        au();
        goto L21
    L18:
        return this.z;
    L21:
        if (this.v != 0) goto L23;
        d(16);
    L23:
        int r1 = this.v;
        if ((r1 & 16) == 0) goto L28;
        return this.A;
    L28:
        if ((r1 & 8) != 0) goto L31;
        au();
    L31:
        return Double.valueOf(this.y);
    }

    @Override // com.fasterxml.jackson.a.k
    public k.b E() {
        if (this.v != 0) goto L6;
        d(0);
    L6:
        if (this.P != n.i) goto L18;
        int r2 = this.v;
        if ((r2 & 1) == 0) goto L12;
        return k.b.f12143a;
    L12:
        if ((r2 & 2) == 0) goto L16;
        return k.b.f12144b;
    L16:
        return k.b.f12145c;
    L18:
        if ((this.v & 16) == 0) goto L22;
        return k.b.f;
    L22:
        return k.b.f12147e;
    }

    @Override // com.fasterxml.jackson.a.k
    public int H() {
        int r0 = this.v;
        if ((r0 & 1) != 0) goto L11;
        if (r0 != 0) goto L8;
        return ag();
    L8:
        if ((r0 & 1) != 0) goto L11;
        ah();
    L11:
        return this.w;
    }

    @Override // com.fasterxml.jackson.a.k
    public long I() {
        int r0 = this.v;
        if ((r0 & 2) != 0) goto L11;
        if (r0 != 0) goto L8;
        d(2);
    L8:
        if ((this.v & 2) != 0) goto L11;
        ai();
    L11:
        return this.x;
    }

    @Override // com.fasterxml.jackson.a.k
    public BigInteger J() {
        int r0 = this.v;
        if ((r0 & 4) != 0) goto L11;
        if (r0 != 0) goto L8;
        d(4);
    L8:
        if ((this.v & 4) != 0) goto L11;
        aj();
    L11:
        return this.z;
    }

    @Override // com.fasterxml.jackson.a.k
    public float K() {
        return (float) L();
    }

    @Override // com.fasterxml.jackson.a.k
    public double L() {
        int r0 = this.v;
        if ((r0 & 8) != 0) goto L11;
        if (r0 != 0) goto L8;
        d(8);
    L8:
        if ((this.v & 8) != 0) goto L11;
        ak();
    L11:
        return this.y;
    }

    @Override // com.fasterxml.jackson.a.k
    public BigDecimal M() {
        int r0 = this.v;
        if ((r0 & 16) != 0) goto L11;
        if (r0 != 0) goto L8;
        d(16);
    L8:
        if ((this.v & 16) != 0) goto L11;
        al();
    L11:
        return this.A;
    }

    public void d(int r6) {
        if (this.f == false) goto L6;
        i("Internal error: _parseNumericValue called when parser instance closed");
    L6:
        if (this.P != n.i) goto L30;
        int r0 = this.C;
        if (r0 > 9) goto L12;
        this.w = this.q.a(this.B);
        this.v = 1;
        return;
    L12:
        if (r0 > 18) goto L27;
        long r3 = this.q.b(this.B);
        if (r0 == 10) goto L16;
    L25:
        this.x = r3;
        this.v = 2;
        return;
    L16:
        if (this.B == false) goto L22;
        if (r3 < (-2147483648L)) goto L25;
        this.w = (int) r3;
        this.v = 1;
        return;
    L22:
        if (r3 > 2147483647L) goto L25;
        this.w = (int) r3;
        this.v = 1;
        return;
    L27:
        i(r6);
        return;
    L30:
        if (this.P != n.j) goto L33;
        h(r6);
        return;
    L33:
        a("Current token (%s) not numeric, can not use numeric value accessors", this.P);
    }

    public int ag() {
        if (this.f == false) goto L6;
        i("Internal error: _parseNumericValue called when parser instance closed");
    L6:
        if (this.P == n.i) goto L8;
    L11:
        d(1);
        if ((this.v & 1) != 0) goto L15;
        ah();
    L15:
        return this.w;
    L8:
        if (this.C > 9) goto L11;
        int r0 = this.q.a(this.B);
        this.w = r0;
        this.v = 1;
        return r0;
    }

    private void h(int r3) {
        if (r3 != 16) goto L5;
        this.A = this.q.g();     // Catch: NumberFormatException -> L7
        this.v = 16;     // Catch: NumberFormatException -> L7
    L10:
        return;
    L5:
        this.y = this.q.h();     // Catch: NumberFormatException -> L7
        this.v = 8;     // Catch: NumberFormatException -> L7
    L7:
        e = move-exception;
        a("Malformed numeric value (" + h(this.q.e()) + ")", e);
    }

    private void i(int r6) {
        String r0 = this.q.e();
        int r1 = this.C;     // Catch: NumberFormatException -> L21
        char[] r2 = this.q.d();     // Catch: NumberFormatException -> L21
        int r3 = this.q.c();     // Catch: NumberFormatException -> L21
        boolean r4 = this.B;     // Catch: NumberFormatException -> L21
        if (r4 == false) goto L7;
        r3 = r3 + 1;     // Catch: NumberFormatException -> L21
    L7:
        if (com.fasterxml.jackson.a.d.i.a(r2, r3, r1, r4) == false) goto L10;
        this.x = Long.parseLong(r0);     // Catch: NumberFormatException -> L21
        this.v = 2;     // Catch: NumberFormatException -> L21
        return;
    L10:
        if (r6 == 1) goto L12;
        if (r6 == 2) goto L12;
    L14:
        if (r6 != 8) goto L16;
    L19:
        this.y = com.fasterxml.jackson.a.d.i.c(r0);     // Catch: NumberFormatException -> L21
        this.v = 8;     // Catch: NumberFormatException -> L21
        return;
    L16:
        if (r6 == 32) goto L19;
        this.z = new BigInteger(r0);     // Catch: NumberFormatException -> L21
        this.v = 4;     // Catch: NumberFormatException -> L21
        return;
    L12:
        a(r6, r0);     // Catch: NumberFormatException -> L21
    L21:
        e = move-exception;
        a("Malformed numeric value (" + h(r0) + ")", e);
    }

    public void a(int r2, String r3) {
        if (r2 != 1) goto L5;
        e(r3);
        return;
    L5:
        f(r3);
    }

    public void ah() {
        int r0 = this.v;
        if ((r0 & 2) == 0) goto L9;
        long r1 = this.x;
        int r2 = (int) r1;
        if (r2 == r1) goto L7;
        a(x(), l());
    L7:
        this.w = r2;
    L33:
        this.v |= 1;
        return;
    L9:
        if ((r0 & 4) == 0) goto L17;
        if (H.compareTo(this.z) <= 0) goto L13;
    L14:
        ar();
    L15:
        this.w = this.z.intValue();
        goto L33
    L13:
        if (I.compareTo(this.z) >= 0) goto L15;
    L17:
        if ((r0 & 8) == 0) goto L25;
        double r3 = this.y;
        if (r3 >= (-2.147483648E9d)) goto L21;
    L22:
        ar();
    L23:
        this.w = (int) this.y;
        goto L33
    L21:
        if (r3 <= 2.147483647E9d) goto L23;
    L25:
        if ((r0 & 16) != 0) goto L27;
        au();
        goto L33
    L27:
        if (N.compareTo(this.A) <= 0) goto L29;
    L30:
        ar();
    L31:
        this.w = this.A.intValue();
        goto L33
    L29:
        if (O.compareTo(this.A) >= 0) goto L31;
        goto L30
    }

    public void ai() {
        int r0 = this.v;
        if ((r0 & 1) == 0) goto L6;
        this.x = this.w;
    L30:
        this.v |= 2;
        return;
    L6:
        if ((r0 & 4) == 0) goto L14;
        if (f11976J.compareTo(this.z) <= 0) goto L10;
    L11:
        as();
    L12:
        this.x = this.z.longValue();
        goto L30
    L10:
        if (K.compareTo(this.z) >= 0) goto L12;
    L14:
        if ((r0 & 8) == 0) goto L22;
        double r1 = this.y;
        if (r1 >= (-9.223372036854776E18d)) goto L18;
    L19:
        as();
    L20:
        this.x = (long) this.y;
        goto L30
    L18:
        if (r1 <= 9.223372036854776E18d) goto L20;
    L22:
        if ((r0 & 16) != 0) goto L24;
        au();
        goto L30
    L24:
        if (L.compareTo(this.A) <= 0) goto L26;
    L27:
        as();
    L28:
        this.x = this.A.longValue();
        goto L30
    L26:
        if (M.compareTo(this.A) >= 0) goto L28;
        goto L27
    }

    public void aj() {
        int r0 = this.v;
        if ((r0 & 16) == 0) goto L6;
        this.z = this.A.toBigInteger();
    L15:
        this.v |= 4;
        return;
    L6:
        if ((r0 & 2) == 0) goto L9;
        this.z = BigInteger.valueOf(this.x);
        goto L15
    L9:
        if ((r0 & 1) == 0) goto L12;
        this.z = BigInteger.valueOf(this.w);
        goto L15
    L12:
        if ((r0 & 8) == 0) goto L14;
        this.z = BigDecimal.valueOf(this.y).toBigInteger();
        goto L15
    L14:
        au();
        goto L15
    }

    public void ak() {
        int r0 = this.v;
        if ((r0 & 16) == 0) goto L6;
        this.y = this.A.doubleValue();
    L15:
        this.v |= 8;
        return;
    L6:
        if ((r0 & 4) == 0) goto L9;
        this.y = this.z.doubleValue();
        goto L15
    L9:
        if ((r0 & 2) == 0) goto L12;
        this.y = this.x;
        goto L15
    L12:
        if ((r0 & 1) == 0) goto L14;
        this.y = this.w;
        goto L15
    L14:
        au();
        goto L15
    }

    public void al() {
        int r0 = this.v;
        if ((r0 & 8) == 0) goto L6;
        this.A = com.fasterxml.jackson.a.d.i.d(x());
    L15:
        this.v |= 16;
        return;
    L6:
        if ((r0 & 4) == 0) goto L9;
        this.A = new BigDecimal(this.z);
        goto L15
    L9:
        if ((r0 & 2) == 0) goto L12;
        this.A = BigDecimal.valueOf(this.x);
        goto L15
    L12:
        if ((r0 & 1) == 0) goto L14;
        this.A = BigDecimal.valueOf(this.w);
        goto L15
    L14:
        au();
        goto L15
    }

    public void a(int r4, char r5) {
        com.fasterxml.jackson.a.e.c r0 = X();
        i(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", new Object[]{Character.valueOf((char) r4), Character.valueOf(r5), r0.e(), r0.a(ap())}));
    }

    public char a(char r3) {
        if (a(k.a.g) == false) goto L6;
        return r3;
    L6:
        if (r3 == '\'') goto L8;
    L10:
        i("Unrecognized character escape " + g(r3));
        return r3;
    L8:
        if (a(k.a.f12142e) == false) goto L10;
        return r3;
    }

    public void b(int r3, String r4) {
        if (a(k.a.f) == true) goto L5;
    L6:
        i("Illegal unquoted character (" + g((char) r3) + "): has to be escaped using backslash to be included in " + r4);
        return;
    L5:
        if (r3 > 32) goto L6;
    }

    public String am() {
        return an();
    }

    public String an() {
        if (a(k.a.j) == false) goto L6;
        return "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')";
    L6:
        return "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    public char ao() {
        throw new UnsupportedOperationException();
    }

    public final int a(com.fasterxml.jackson.a.a r3, char r4, int r5) {
        if (r4 != '\\') goto L20;
        char r6 = ao();
        if (r6 > ' ') goto L9;
        if (r5 != 0) goto L9;
        return -1;
    L9:
        int r0 = r3.b(r6);
        if (r0 < 0) goto L12;
    L18:
        return r0;
    L12:
        if (r0 != (-2)) goto L17;
        if (r5 >= 2) goto L18;
    L17:
        throw a(r3, r6, r5);
    L20:
        throw a(r3, r4, r5);
    }

    public IllegalArgumentException a(com.fasterxml.jackson.a.a r2, int r3, int r4) {
        return a(r2, r3, r4, null);
    }

    public IllegalArgumentException a(com.fasterxml.jackson.a.a r2, int r3, int r4, String r5) {
        if (r3 > 32) goto L6;
        String r1 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", new Object[]{Integer.toHexString(r3), Integer.valueOf(r4 + 1)});
    L15:
        if (r5 == null) goto L18;
        r1 = r1 + ": " + r5;
    L18:
        return new IllegalArgumentException(r1);
    L6:
        if (r2.a(r3) == false) goto L9;
        r1 = "Unexpected padding character ('" + r2.e() + "') as character #" + (r4 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        goto L15
    L9:
        if (Character.isDefined(r3) == true) goto L11;
    L14:
        r1 = "Illegal character (code 0x" + Integer.toHexString(r3) + ") in base64 content";
        goto L15
    L11:
        if (Character.isISOControl(r3) == true) goto L14;
        r1 = "Illegal character '" + ((char) r3) + "' (code 0x" + Integer.toHexString(r3) + ") in base64 content";
        goto L15
    }

    public void b(com.fasterxml.jackson.a.a r1) {
        i(r1.j());
    }

    public d ap() {
        if (k.a.o.a(this.f12136b) == false) goto L7;
        return this.f11975e.b();
    L7:
        return d.a();
    }
}
