package com.fasterxml.jackson.a.e;

import com.fasterxml.jackson.a.h.i;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.n;
import com.fasterxml.jackson.a.o;
import com.fasterxml.jackson.a.r;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

/* JADX INFO: compiled from: ReaderBasedJsonParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends com.fasterxml.jackson.a.a.b {
    protected static final int[] R = null;
    private static final int ac = 0;
    private static final int ad = 0;
    private static final int ae = 0;
    private static final int af = 0;
    private static final int ag = 0;
    private static final int ah = 0;
    private static final int ai = 0;
    private static final int aj = 0;
    protected Reader S;
    protected char[] T;
    protected boolean U;
    protected o V;
    protected final com.fasterxml.jackson.a.f.b W;
    protected final int X;
    protected boolean Y;
    protected long Z;
    protected int aa;
    protected int ab;

    static {
        ac = k.a.l.c();
        ad = k.a.h.c();
        ae = k.a.j.c();
        af = k.a.k.c();
        ag = k.a.f12142e.c();
        ah = k.a.f12141d.c();
        ai = k.a.f12139b.c();
        aj = k.a.f12140c.c();
        R = com.fasterxml.jackson.a.d.b.a();
    }

    public f(com.fasterxml.jackson.a.d.e r1, int r2, Reader r3, o r4, com.fasterxml.jackson.a.f.b r5, char[] r6, int r7, int r8, boolean r9) {
        super(r1, r2);
        this.S = r3;
        this.V = r4;
        this.T = r6;
        this.g = r7;
        this.h = r8;
        this.k = r7;
        this.i = -r7;
        this.W = r5;
        this.X = r5.d();
        this.U = r9;
    }

    public f(com.fasterxml.jackson.a.d.e r1, int r2, Reader r3, o r4, com.fasterxml.jackson.a.f.b r5) {
        super(r1, r2);
        this.S = r3;
        this.T = r1.e();
        this.g = 0;
        this.h = 0;
        this.V = r4;
        this.W = r5;
        this.X = r5.d();
        this.U = true;
    }

    @Override // com.fasterxml.jackson.a.k
    public o a() {
        return this.V;
    }

    @Override // com.fasterxml.jackson.a.k
    public i<r> c() {
        return f11974d;
    }

    @Deprecated
    public char j(String r2) {
        return d(r2, null);
    }

    public char d(String r3, n r4) {
        if (this.g >= this.h) goto L5;
    L7:
        char[] r5 = this.T;
        int r6 = this.g;
        this.g = r6 + 1;
        return r5[r6];
    L5:
        if (aw() == true) goto L7;
        c(r3, r4);
        goto L7
    }

    @Override // com.fasterxml.jackson.a.a.b
    public void ab() {
        if (this.S != null) goto L5;
        return;
    L5:
        if (this.f11975e.a() == false) goto L7;
    L8:
        this.S.close();
    L9:
        this.S = null;
        return;
    L7:
        if (a(k.a.f12138a) == false) goto L9;
        goto L8
    }

    @Override // com.fasterxml.jackson.a.a.b
    public void ac() {
        super.ac();
        this.W.b();
        if (this.U == false) goto L8;
        char[] r0 = this.T;
        if (r0 == null) goto L9;
        this.T = null;
        this.f11975e.a(r0);
        return;
    L9:
        return;
    }

    public void av() {
        if (aw() == true) goto L6;
        at();
        return;
    }

    public boolean aw() {
        Reader r0 = this.S;
        if (r0 == null) goto L13;
        char[] r2 = this.T;
        int r1 = r0.read(r2, 0, r2.length);
        if (r1 <= 0) goto L8;
        int r3 = this.h;
        long r5 = r3;
        this.i += r5;
        this.k -= r3;
        this.Z -= r5;
        this.g = 0;
        this.h = r1;
        return true;
    L8:
        ab();
        if (r1 != 0) goto L13;
        throw new IOException("Reader returned 0 characters when trying to read " + this.h);
    L13:
        return false;
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public final String x() {
        if (this.P != n.h) goto L10;
        if (this.Y == false) goto L8;
        this.Y = false;
        aq();
    L8:
        return this.q.e();
    L10:
        return c(this.P);
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public final String R() {
        if (this.P != n.h) goto L10;
        if (this.Y == false) goto L8;
        this.Y = false;
        aq();
    L8:
        return this.q.e();
    L10:
        if (this.P != n.f) goto L14;
        return v();
    L14:
        return super.a(null);
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public final String a(String r3) {
        if (this.P != n.h) goto L10;
        if (this.Y == false) goto L8;
        this.Y = false;
        aq();
    L8:
        return this.q.e();
    L10:
        if (this.P != n.f) goto L14;
        return v();
    L14:
        return super.a(r3);
    }

    public final String c(n r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r0 = r3.a();
        if (r0 == 5) goto L18;
        if (r0 == 6) goto L16;
        if (r0 == 7) goto L16;
        if (r0 == 8) goto L16;
        return r3.b();
    L16:
        return this.q.e();
    L18:
        return this.o.h();
    }

    @Override // com.fasterxml.jackson.a.k
    public final char[] y() {
        if (this.P == null) goto L30;
        int r0 = this.P.a();
        if (r0 == 5) goto L20;
        if (r0 == 6) goto L15;
        if (r0 == 7) goto L18;
        if (r0 == 8) goto L18;
        return this.P.c();
    L18:
        return this.q.d();
    L15:
        if (this.Y == false) goto L18;
        this.Y = false;
        aq();
        goto L18
    L20:
        if (this.s == true) goto L29;
        String r1 = this.o.h();
        int r2 = r1.length();
        if (this.r != null) goto L25;
        this.r = this.f11975e.b(r2);
    L27:
        r1.getChars(0, r2, this.r, 0);
        this.s = true;
        goto L29
    L25:
        if (this.r.length >= r2) goto L27;
        this.r = new char[r2];
    L29:
        return this.r;
    L30:
        return null;
    }

    @Override // com.fasterxml.jackson.a.k
    public final int z() {
        if (this.P == null) goto L21;
        int r0 = this.P.a();
        if (r0 == 5) goto L20;
        if (r0 == 6) goto L15;
        if (r0 == 7) goto L18;
        if (r0 == 8) goto L18;
        return this.P.c().length;
    L18:
        return this.q.b();
    L15:
        if (this.Y == false) goto L18;
        this.Y = false;
        aq();
        goto L18
    L20:
        return this.o.h().length();
    L21:
        return 0;
    }

    @Override // com.fasterxml.jackson.a.k
    public final int A() {
        if (this.P == null) goto L16;
        int r0 = this.P.a();
        if (r0 == 6) goto L12;
        if (r0 == 7) goto L15;
        if (r0 != 8) goto L16;
    L15:
        return this.q.c();
    L12:
        if (this.Y == false) goto L15;
        this.Y = false;
        aq();
    L16:
        return 0;
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.k
    public byte[] a(com.fasterxml.jackson.a.a r4) {
        if (this.P != n.g) goto L9;
        if (this.u == null) goto L9;
        return this.u;
    L9:
        if (this.P == n.h) goto L12;
        i("Current token (" + this.P + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    L12:
        if (this.Y == false) goto L19;
        this.u = c(r4);     // Catch: IllegalArgumentException -> L15
        this.Y = false;
    L22:
        return this.u;
    L15:
        e = move-exception;
        throw b("Failed to decode VALUE_STRING as base64 (" + r4 + "): " + e.getMessage());
    L19:
        if (this.u != null) goto L22;
        com.fasterxml.jackson.a.h.c r0 = af();
        a(x(), r0, r4);
        this.u = r0.b();
        goto L22
    }

    @Override // com.fasterxml.jackson.a.k
    public int a(com.fasterxml.jackson.a.a r3, OutputStream r4) {
        if (this.Y == true) goto L5;
    L14:
        byte[] r2 = a(r3);
        r4.write(r2);
        return r2.length;
    L5:
        if (this.P != n.h) goto L14;
        byte[] r0 = this.f11975e.d();
        int r5 = a(r3, r4, r0);     // Catch: Throwable -> L11
        this.f11975e.a(r0);
        return r5;
    L11:
        th = move-exception;
        this.f11975e.a(r0);
        throw th;
    }

    public int a(com.fasterxml.jackson.a.a r17, OutputStream r18, byte[] r19) {
        int r5 = 3;
        int r4 = r19.length - 3;
        int r7 = 0;
        int r8 = 0;
    L4:
        if (this.g < this.h) goto L6;
        av();
    L6:
        char[] r9 = this.T;
        int r10 = this.g;
        this.g = r10 + 1;
        char r11 = r9[r10];
        if (r11 <= ' ') goto L67;
        int r12 = r17.b(r11);
        if (r12 >= 0) goto L15;
        if (r11 == '\"') goto L57;
        r12 = a(r17, r11, 0);
        if (r12 >= 0) goto L15;
    L57:
        this.Y = false;
        if (r7 <= 0) goto L81;
        int r13 = r8 + r7;
        r18.write(r19, 0, r7);
        return r13;
    L81:
        return r8;
    L15:
        if (r7 <= r4) goto L18;
        r8 = r8 + r7;
        r18.write(r19, 0, r7);
        r7 = 0;
    L18:
        if (this.g < this.h) goto L20;
        av();
    L20:
        char[] r14 = this.T;
        int r15 = this.g;
        this.g = r15 + 1;
        char r16 = r14[r15];
        int r110 = r17.b(r16);
        if (r110 >= 0) goto L23;
        r110 = a(r17, r16, 1);
    L23:
        int r20 = (r12 << 6) | r110;
        if (this.g < this.h) goto L26;
        av();
    L26:
        char[] r111 = this.T;
        int r112 = this.g;
        this.g = r112 + 1;
        char r113 = r111[r112];
        int r114 = r17.b(r113);
        if (r114 >= 0) goto L47;
        if (r114 == (-2)) goto L35;
        if (r113 == '\"') goto L30;
        r114 = a(r17, r113, 2);
        goto L35
    L30:
        int r6 = r7 + 1;
        r19[r7] = (byte) (r20 >> 4);
        if (r17.b() == false) goto L33;
        this.g--;
        b(r17);
    L33:
        r7 = r6;
    L35:
        if (r114 != (-2)) goto L47;
        if (this.g < this.h) goto L39;
        av();
    L39:
        char[] r115 = this.T;
        int r116 = this.g;
        this.g = r116 + 1;
        char r117 = r115[r116];
        if (r17.a(r117) == false) goto L42;
    L46:
        r19[r7] = (byte) (r20 >> 4);
        r7 = r7 + 1;
        goto L4
    L42:
        if (a(r17, r117, r5) == (-2)) goto L46;
        throw a(r17, r117, r5, "expected padding character '" + r17.e() + "'");
    L47:
        int r21 = (r20 << 6) | r114;
        if (this.g < this.h) goto L50;
        av();
    L50:
        char[] r118 = this.T;
        int r119 = this.g;
        this.g = r119 + 1;
        char r22 = r118[r119];
        int r120 = r17.b(r22);
        if (r120 >= 0) goto L65;
        if (r120 == (-2)) goto L62;
        if (r22 == '\"') goto L54;
        int r121 = 3;
        r120 = a(r17, r22, 3);
    L63:
        if (r120 != (-2)) goto L66;
        int r23 = r21 >> 2;
        int r24 = r7 + 1;
        r19[r7] = (byte) (r23 >> 8);
        r7 = r24 + 1;
        r19[r24] = (byte) r23;
    L68:
        r5 = r121;
    L66:
        int r25 = (r21 << 6) | r120;
        int r26 = r7 + 1;
        r19[r7] = (byte) (r25 >> 16);
        int r27 = r26 + 1;
        r19[r26] = (byte) (r25 >> 8);
        r19[r27] = (byte) r25;
        r7 = r27 + 1;
        goto L68
    L54:
        int r28 = r21 >> 2;
        int r29 = r7 + 1;
        r19[r7] = (byte) (r28 >> 8);
        r7 = r29 + 1;
        r19[r29] = (byte) r28;
        if (r17.b() == false) goto L57;
        this.g--;
        b(r17);
        goto L57
    L62:
        r121 = 3;
        goto L63
    L65:
        r121 = 3;
    L67:
        r121 = r5;
        goto L68
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public final n g() {
        if (this.P == n.f) goto L5;
        this.v = 0;
        if (this.Y == false) goto L9;
        aD();
    L9:
        int r0 = aK();
        if (r0 >= 0) goto L13;
        close();
        this.P = null;
        return null;
    L13:
        this.u = null;
        if (r0 != 93) goto L16;
    L71:
        n(r0);
        return this.P;
    L16:
        if (r0 == 125) goto L71;
        if (this.o.m() == false) goto L26;
        r0 = m(r0);
        if ((this.f12136b & ac) == 0) goto L26;
        if (r0 == 93) goto L24;
        if (r0 != 125) goto L26;
    L24:
        n(r0);
        return this.P;
    L26:
        boolean r1 = this.o.d();
        if (r1 == false) goto L33;
        aU();
        if (r0 != 34) goto L31;
        String r2 = az();
    L32:
        this.o.a(r2);
        this.P = n.f;
        r0 = aI();
        goto L33
    L31:
        r2 = i(r0);
    L33:
        aT();
        if (r0 != 34) goto L36;
        this.Y = true;
        n r3 = n.h;
    L66:
        if (r1 == false) goto L69;
        this.p = r3;
        return this.P;
    L69:
        this.P = r3;
        return r3;
    L36:
        if (r0 != 91) goto L38;
        if (r1 == true) goto L64;
        this.o = this.o.a(this.m, this.n);
    L64:
        r3 = n.f12154d;
        goto L66
    L38:
        if (r0 != 102) goto L40;
        aR();
        r3 = n.l;
        goto L66
    L40:
        if (r0 != 110) goto L42;
        aS();
        r3 = n.m;
        goto L66
    L42:
        if (r0 != 116) goto L44;
    L59:
        aQ();
        r3 = n.k;
        goto L66
    L44:
        if (r0 == 123) goto L56;
        if (r0 != 125) goto L47;
        d(r0, "expected a value");
        goto L59
    L47:
        if (r0 != 45) goto L49;
        r3 = ay();
        goto L66
    L49:
        if (r0 == 46) goto L53;
        switch(r0) {
            case 48: goto L52;
            case 49: goto L52;
            case 50: goto L52;
            case 51: goto L52;
            case 52: goto L52;
            case 53: goto L52;
            case 54: goto L52;
            case 55: goto L52;
            case 56: goto L52;
            case 57: goto L52;
            default: goto L51;
        };
    L51:
        r3 = j(r0);
        goto L66
    L52:
        r3 = h(r0);
        goto L66
    L53:
        r3 = ax();
        goto L66
    L56:
        if (r1 == true) goto L58;
        this.o = this.o.b(this.m, this.n);
    L58:
        r3 = n.f12152b;
        goto L66
    L5:
        return aF();
    }

    private final n aF() {
        this.s = false;
        n r0 = this.p;
        this.p = null;
        if (r0 != n.f12154d) goto L6;
        this.o = this.o.a(this.m, this.n);
    L8:
        this.P = r0;
        return r0;
    L6:
        if (r0 != n.f12152b) goto L8;
        this.o = this.o.b(this.m, this.n);
        goto L8
    }

    @Override // com.fasterxml.jackson.a.k
    public String i() {
        this.v = 0;
        if (this.P != n.f) goto L7;
        aF();
        return null;
    L7:
        if (this.Y == false) goto L9;
        aD();
    L9:
        int r0 = aK();
        if (r0 >= 0) goto L13;
        close();
        this.P = null;
        return null;
    L13:
        this.u = null;
        if (r0 != 93) goto L16;
    L64:
        n(r0);
        return null;
    L16:
        if (r0 == 125) goto L64;
        if (this.o.m() == false) goto L27;
        r0 = m(r0);
        if ((this.f12136b & ac) == 0) goto L27;
        if (r0 == 93) goto L24;
        if (r0 != 125) goto L27;
    L24:
        n(r0);
        return null;
    L27:
        if (this.o.d() == true) goto L30;
        aT();
        k(r0);
        return null;
    L30:
        aU();
        if (r0 != 34) goto L33;
        String r1 = az();
    L34:
        this.o.a(r1);
        this.P = n.f;
        int r2 = aI();
        aT();
        if (r2 != 34) goto L39;
        this.Y = true;
        this.p = n.h;
        return r1;
    L39:
        if (r2 != 45) goto L41;
        n r3 = ay();
    L62:
        this.p = r3;
        return r1;
    L41:
        if (r2 != 46) goto L43;
        r3 = ax();
        goto L62
    L43:
        if (r2 != 91) goto L45;
        r3 = n.f12154d;
        goto L62
    L45:
        if (r2 != 102) goto L47;
        aR();
        r3 = n.l;
        goto L62
    L47:
        if (r2 != 110) goto L49;
        aS();
        r3 = n.m;
        goto L62
    L49:
        if (r2 != 116) goto L51;
        aQ();
        r3 = n.k;
        goto L62
    L51:
        if (r2 == 123) goto L55;
        switch(r2) {
            case 48: goto L54;
            case 49: goto L54;
            case 50: goto L54;
            case 51: goto L54;
            case 52: goto L54;
            case 53: goto L54;
            case 54: goto L54;
            case 55: goto L54;
            case 56: goto L54;
            case 57: goto L54;
            default: goto L53;
        };
    L53:
        r3 = j(r2);
        goto L62
    L54:
        r3 = h(r2);
        goto L62
    L55:
        r3 = n.f12152b;
        goto L62
    L33:
        r1 = i(r0);
        goto L34
    }

    private final n k(int r4) {
        if (r4 != 34) goto L7;
        this.Y = true;
        n r5 = n.h;
        this.P = r5;
        return r5;
    L7:
        if (r4 != 91) goto L9;
        this.o = this.o.a(this.m, this.n);
        n r6 = n.f12154d;
        this.P = r6;
        return r6;
    L9:
        if (r4 != 102) goto L11;
        a("false", 1);
        n r7 = n.l;
        this.P = r7;
        return r7;
    L11:
        if (r4 != 110) goto L13;
        a("null", 1);
        n r8 = n.m;
        this.P = r8;
        return r8;
    L13:
        if (r4 != 116) goto L15;
        a("true", 1);
        n r9 = n.k;
        this.P = r9;
        return r9;
    L15:
        if (r4 == 123) goto L33;
        switch(r4) {
            case 44: goto L26;
            case 45: goto L23;
            case 46: goto L21;
            default: goto L17;
        };
    L17:
        switch(r4) {
            case 48: goto L19;
            case 49: goto L19;
            case 50: goto L19;
            case 51: goto L19;
            case 52: goto L19;
            case 53: goto L19;
            case 54: goto L19;
            case 55: goto L19;
            case 56: goto L19;
            case 57: goto L19;
            default: goto L31;
        };
    L19:
        n r10 = h(r4);
        this.P = r10;
        return r10;
    L31:
        n r11 = j(r4);
        this.P = r11;
        return r11;
    L21:
        n r12 = ax();
        this.P = r12;
        return r12;
    L23:
        n r13 = ay();
        this.P = r13;
        return r13;
    L26:
        if (this.o.c() == true) goto L31;
        if ((this.f12136b & af) == 0) goto L31;
        this.g--;
        n r14 = n.m;
        this.P = r14;
        return r14;
    L33:
        this.o = this.o.b(this.m, this.n);
        n r15 = n.f12152b;
        this.P = r15;
        return r15;
    }

    @Override // com.fasterxml.jackson.a.k
    public final String j() {
        if (this.P != n.f) goto L19;
        this.s = false;
        n r1 = this.p;
        this.p = null;
        this.P = r1;
        if (r1 != n.h) goto L12;
        if (this.Y == false) goto L10;
        this.Y = false;
        aq();
    L10:
        return this.q.e();
    L12:
        if (r1 != n.f12154d) goto L15;
        this.o = this.o.a(this.m, this.n);
    L17:
        return null;
    L15:
        if (r1 != n.f12152b) goto L17;
        this.o = this.o.b(this.m, this.n);
        goto L17
    L19:
        if (g() == n.h) goto L21;
        return null;
    L21:
        return x();
    }

    public final n ax() {
        if (a(d.h.a()) == true) goto L7;
        return j(46);
    L7:
        return a(46, this.g - 1, this.g, false, 0);
    }

    public final n h(int r8) {
        int r0 = this.g;
        int r3 = r0 - 1;
        int r1 = this.h;
        if (r8 == 48) goto L5;
        int r6 = 1;
    L7:
        if (r0 >= r1) goto L8;
        int r5 = r0 + 1;
        char r9 = this.T[r0];
        if (r9 < '0') goto L17;
        if (r9 > '9') goto L17;
        r6 = r6 + 1;
        r0 = r5;
    L17:
        if (r9 != '.') goto L19;
    L28:
        this.g = r5;
        return a(r9, r3, r5, false, r6);
    L19:
        if (r9 == 'e') goto L28;
        if (r9 == 'E') goto L28;
        int r7 = r5 - 1;
        this.g = r7;
        if (this.o.c() == false) goto L26;
        l(r9);
    L26:
        this.q.a(this.T, r3, r7 - r3);
        return a(false, r6);
    L8:
        this.g = r3;
        return b(false, r3);
    L5:
        return b(false, r3);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x006e -> B:30:0x0050). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v13 ??, r9v9 ??, r9v4 ??, r9v3 ??, r9v7 ??, r9v6 ??, r9v8 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    private final com.fasterxml.jackson.a.n a(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v13 ??, r9v9 ??, r9v4 ??, r9v3 ??, r9v7 ??, r9v6 ??, r9v8 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public final n ay() {
        int r0 = this.g;
        int r3 = r0 - 1;
        int r1 = this.h;
        if (r0 >= r1) goto L5;
        int r5 = r0 + 1;
        char r2 = this.T[r0];
        if (r2 <= '9') goto L9;
    L37:
        this.g = r5;
        return a(r2, true);
    L9:
        if (r2 < '0') goto L37;
        if (r2 == '0') goto L13;
        int r4 = 1;
    L15:
        if (r5 >= r1) goto L17;
        int r8 = r5 + 1;
        char r6 = this.T[r5];
        if (r6 < '0') goto L24;
        if (r6 > '9') goto L24;
        r4 = r4 + 1;
        r5 = r8;
    L24:
        if (r6 != '.') goto L26;
    L35:
        this.g = r8;
        return a(r6, r3, r8, true, r4);
    L26:
        if (r6 == 'e') goto L35;
        if (r6 == 'E') goto L35;
        int r9 = r8 - 1;
        this.g = r9;
        if (this.o.c() == false) goto L33;
        l(r6);
    L33:
        this.q.a(this.T, r3, r9 - r3);
        return a(true, r4);
    L17:
        return b(true, r3);
    L13:
        return b(true, r3);
    L5:
        return b(true, r3);
    }

    private final n b(boolean r14, int r15) {
        if (r14 == false) goto L4;
        r15 = r15 + 1;
    L4:
        this.g = r15;
        char[] r16 = this.q.j();
        int r1 = 0;
        if (r14 == false) goto L7;
        r16[0] = '-';
        int r3 = 1;
    L9:
        if (this.g >= this.h) goto L11;
        char[] r4 = this.T;
        int r5 = this.g;
        this.g = r5 + 1;
        char r6 = r4[r5];
    L13:
        if (r6 != '0') goto L15;
        r6 = aG();
    L15:
        int r7 = 0;
    L17:
        if (r6 < '0') goto L28;
        if (r6 > '9') goto L28;
        r7 = r7 + 1;
        if (r3 < r16.length) goto L22;
        r16 = this.q.l();
        r3 = 0;
    L22:
        int r8 = r3 + 1;
        r16[r3] = r6;
        if (this.g < this.h) goto L27;
        if (aw() == true) goto L27;
        r6 = 0;
        r3 = r8;
        boolean r9 = true;
    L29:
        if (r7 != 0) goto L33;
        return a(r6, r14);
    L33:
        if (r6 == '.') goto L35;
        int r10 = 0;
    L55:
        if (r6 == 'e') goto L59;
        if (r6 == 'E') goto L59;
    L92:
        if (r9 == true) goto L96;
        this.g--;
        if (this.o.c() == false) goto L96;
        l(r6);
    L96:
        this.q.a(r3);
        return a(r14, r7, r10, r1);
    L59:
        if (r3 < r16.length) goto L61;
        r16 = this.q.l();
        r3 = 0;
    L61:
        int r11 = r3 + 1;
        r16[r3] = r6;
        if (this.g >= this.h) goto L64;
        char[] r12 = this.T;
        int r13 = this.g;
        this.g = r13 + 1;
        char r17 = r12[r13];
    L65:
        if (r17 == '-') goto L71;
        if (r17 == '+') goto L71;
    L69:
        int r0 = 0;
        r6 = r17;
    L78:
        if (r6 > '9') goto L89;
        if (r6 < '0') goto L89;
        r0 = r0 + 1;
        if (r11 < r16.length) goto L83;
        r16 = this.q.l();
        r11 = 0;
    L83:
        r3 = r11 + 1;
        r16[r11] = r6;
        if (this.g < this.h) goto L88;
        if (aw() == true) goto L88;
        r1 = r0;
        r9 = true;
    L90:
        if (r1 != 0) goto L92;
        c(r6, "Exponent indicator not followed by a digit");
    L88:
        char[] r18 = this.T;
        int r19 = this.g;
        this.g = r19 + 1;
        r6 = r18[r19];
        r11 = r3;
    L89:
        r1 = r0;
        r3 = r11;
    L71:
        if (r11 < r16.length) goto L73;
        r16 = this.q.l();
        r11 = 0;
    L73:
        int r2 = r11 + 1;
        r16[r11] = r17;
        if (this.g >= this.h) goto L76;
        char[] r20 = this.T;
        int r21 = this.g;
        this.g = r21 + 1;
        r17 = r20[r21];
    L77:
        r11 = r2;
        goto L69
    L76:
        r17 = j("expected a digit for number exponent");
        goto L77
    L64:
        r17 = j("expected a digit for number exponent");
        goto L65
    L35:
        if (r3 < r16.length) goto L37;
        r16 = this.q.l();
        r3 = 0;
    L37:
        r16[r3] = r6;
        r3 = r3 + 1;
        r10 = 0;
    L39:
        if (this.g >= this.h) goto L41;
    L43:
        char[] r22 = this.T;
        int r110 = this.g;
        this.g = r110 + 1;
        r6 = r22[r110];
        if (r6 < '0') goto L51;
        if (r6 > '9') goto L51;
        r10 = r10 + 1;
        if (r3 < r16.length) goto L50;
        r16 = this.q.l();
        r3 = 0;
    L50:
        r16[r3] = r6;
        r3 = r3 + 1;
    L51:
        if (r10 != 0) goto L55;
        c(r6, "Decimal point not followed by a digit");
        goto L55
    L41:
        if (aw() == true) goto L43;
        r9 = true;
    L27:
        char[] r23 = this.T;
        int r24 = this.g;
        this.g = r24 + 1;
        r6 = r23[r24];
        r3 = r8;
    L28:
        r9 = false;
        goto L29
    L11:
        r6 = d("No digit following minus sign", n.i);
        goto L13
    L7:
        r3 = 0;
        goto L9
    }

    private final char aG() {
        if (this.g >= this.h) goto L10;
        char r0 = this.T[this.g];
        if (r0 >= '0') goto L7;
    L8:
        return '0';
    L7:
        if (r0 > '9') goto L8;
    L10:
        return aH();
    }

    private char aH() {
        if (this.g >= this.h) goto L5;
    L7:
        char r0 = this.T[this.g];
        if (r0 >= '0') goto L10;
    L30:
        return '0';
    L10:
        if (r0 > '9') goto L30;
        if ((this.f12136b & ad) != 0) goto L15;
        d("Leading zeroes not allowed");
    L15:
        this.g++;
        if (r0 == '0') goto L18;
    L29:
        return r0;
    L18:
        if (this.g >= this.h) goto L20;
    L21:
        r0 = this.T[this.g];
        if (r0 < '0') goto L28;
        if (r0 > '9') goto L28;
        this.g++;
        if (r0 == '0') goto L18;
    L28:
        return '0';
    L20:
        if (aw() == false) goto L29;
    L5:
        if (aw() == true) goto L7;
        return '0';
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public com.fasterxml.jackson.a.n a(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private final void l(int r2) {
        this.g++;
        if (r2 != 9) goto L5;
        return;
    L5:
        if (r2 != 10) goto L7;
        this.j++;
        this.k = this.g;
        return;
    L7:
        if (r2 != 13) goto L9;
        aE();
        return;
    L9:
        if (r2 == 32) goto L17;
        e(r2);
        return;
    }

    public final String az() {
        int r0 = this.g;
        int r1 = this.X;
        int[] r2 = R;
    L4:
        if (r0 >= this.h) goto L13;
        char r3 = this.T[r0];
        if (r3 >= r2.length) goto L12;
        if (r2[r3] == 0) goto L12;
        if (r3 != '\"') goto L13;
        int r4 = this.g;
        this.g = r0 + 1;
        return this.W.a(this.T, r4, r0 - r4, r1);
    L12:
        r1 = (r1 * 33) + r3;
        r0 = r0 + 1;
    L13:
        int r5 = this.g;
        this.g = r0;
        return a(r5, r1, 34);
    }

    private String a(int r5, int r6, int r7) {
        this.q.a(this.T, r5, this.g - r5);
        char[] r8 = this.q.i();
        int r0 = this.q.k();
    L4:
        if (this.g >= this.h) goto L6;
    L8:
        char[] r1 = this.T;
        int r2 = this.g;
        this.g = r2 + 1;
        char r3 = r1[r2];
        if (r3 > '\\') goto L19;
        if (r3 != '\\') goto L12;
        r3 = ao();
        goto L19
    L12:
        if (r3 > r7) goto L19;
        if (r3 == r7) goto L14;
        if (r3 >= ' ') goto L19;
        b(r3, "name");
        goto L19
    L14:
        this.q.a(r0);
        com.fasterxml.jackson.a.h.o r9 = this.q;
        char[] r10 = r9.d();
        int r4 = r9.c();
        int r11 = r9.b();
        return this.W.a(r10, r4, r11, r6);
    L19:
        r6 = (r6 * 33) + r3;
        int r12 = r0 + 1;
        r8[r0] = r3;
        if (r12 >= r8.length) goto L21;
        r0 = r12;
        goto L4
    L21:
        r8 = this.q.l();
        r0 = 0;
        goto L4
    L6:
        if (aw() == true) goto L8;
        c(" in field name", n.f);
        goto L8
    }

    public String i(int r8) {
        if (r8 != 39) goto L9;
        if ((this.f12136b & ag) == 0) goto L9;
        return aA();
    L9:
        if ((this.f12136b & ah) != 0) goto L11;
        d(r8, "was expecting double-quote to start field name");
    L11:
        int[] r0 = com.fasterxml.jackson.a.d.b.b();
        int r1 = r0.length;
        if (r8 < r1) goto L14;
        boolean r3 = Character.isJavaIdentifierPart((char) r8);
    L18:
        if (r3 == true) goto L20;
        d(r8, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    L20:
        int r9 = this.g;
        int r4 = this.X;
        int r5 = this.h;
        if (r9 >= r5) goto L34;
    L22:
        char r6 = this.T[r9];
        if (r6 >= r1) goto L29;
        if (r0[r6] != 0) goto L26;
    L32:
        r4 = (r4 * 33) + r6;
        r9 = r9 + 1;
        if (r9 < r5) goto L22;
    L26:
        int r2 = this.g - 1;
        this.g = r9;
        return this.W.a(this.T, r2, r9 - r2, r4);
    L29:
        if (Character.isJavaIdentifierPart(r6) == true) goto L32;
        int r7 = this.g - 1;
        this.g = r9;
        return this.W.a(this.T, r7, r9 - r7, r4);
    L34:
        int r10 = this.g - 1;
        this.g = r9;
        return a(r10, r4, r0);
    L14:
        if (r0[r8] != 0) goto L16;
        r3 = true;
        goto L18
    L16:
        r3 = false;
        goto L18
    }

    public String aA() {
        int r0 = this.g;
        int r1 = this.X;
        int r2 = this.h;
        if (r0 >= r2) goto L15;
        int[] r4 = R;
        int r5 = r4.length;
    L5:
        char r6 = this.T[r0];
        if (r6 == '\'') goto L7;
        if (r6 < r5) goto L11;
    L13:
        r1 = (r1 * 33) + r6;
        r0 = r0 + 1;
        if (r0 < r2) goto L5;
    L11:
        if (r4[r6] == 0) goto L13;
    L7:
        int r3 = this.g;
        this.g = r0 + 1;
        return this.W.a(this.T, r3, r0 - r3, r1);
    L15:
        int r7 = this.g;
        this.g = r0;
        return a(r7, r1, 39);
    }

    public n j(int r4) {
        if (r4 == 39) goto L42;
        if (r4 != 73) goto L7;
        a("Infinity", 1);
        if ((this.f12136b & ae) != 0) goto L39;
        i("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
    L46:
        if (Character.isJavaIdentifierStart(r4) == false) goto L48;
        a("" + ((char) r4), am());
    L48:
        d(r4, "expected a valid value " + an());
        return null;
    L39:
        return a("Infinity", Double.POSITIVE_INFINITY);
    L7:
        if (r4 != 78) goto L9;
        a("NaN", 1);
        if ((this.f12136b & ae) != 0) goto L34;
        i("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        goto L46
    L34:
        return a("NaN", Double.NaN);
    L9:
        if (r4 == 93) goto L23;
        if (r4 == 43) goto L16;
        if (r4 != 44) goto L46;
    L26:
        if (this.o.c() == true) goto L46;
        if ((this.f12136b & af) == 0) goto L46;
        this.g--;
        return n.m;
    L16:
        if (this.g >= this.h) goto L18;
    L20:
        char[] r5 = this.T;
        int r0 = this.g;
        this.g = r0 + 1;
        return a(r5[r0], false);
    L18:
        if (aw() == true) goto L20;
        b(n.i);
        goto L20
    L23:
        if (this.o.b() == true) goto L26;
    L42:
        if ((this.f12136b & ag) == 0) goto L46;
        return aB();
    }

    public n aB() {
        char[] r0 = this.q.j();
        int r1 = this.q.k();
    L4:
        if (this.g >= this.h) goto L6;
    L8:
        char[] r2 = this.T;
        int r3 = this.g;
        this.g = r3 + 1;
        char r4 = r2[r3];
        if (r4 > '\\') goto L21;
        if (r4 != '\\') goto L13;
        r4 = ao();
        goto L21
    L13:
        if (r4 > '\'') goto L21;
        if (r4 == '\'') goto L15;
        if (r4 >= ' ') goto L21;
        b(r4, "string value");
        goto L21
    L15:
        this.q.a(r1);
        return n.h;
    L21:
        if (r1 < r0.length) goto L23;
        r0 = this.q.l();
        r1 = 0;
    L23:
        r0[r1] = r4;
        r1 = r1 + 1;
        goto L4
    L6:
        if (aw() == true) goto L8;
        c(": was expecting closing quote for a string value", n.h);
        goto L8
    }

    private String a(int r5, int r6, int[] r7) {
        this.q.a(this.T, r5, this.g - r5);
        char[] r8 = this.q.i();
        int r0 = this.q.k();
        int r1 = r7.length;
    L4:
        if (this.g >= this.h) goto L6;
    L8:
        char r2 = this.T[this.g];
        if (r2 >= r1) goto L14;
        if (r7[r2] != 0) goto L15;
    L17:
        this.g++;
        r6 = (r6 * 33) + r2;
        int r3 = r0 + 1;
        r8[r0] = r2;
        if (r3 >= r8.length) goto L19;
        r0 = r3;
        goto L4
    L19:
        r8 = this.q.l();
        r0 = 0;
    L15:
        this.q.a(r0);
        com.fasterxml.jackson.a.h.o r9 = this.q;
        return this.W.a(r9.d(), r9.c(), r9.b(), r6);
    L14:
        if (Character.isJavaIdentifierPart(r2) == true) goto L17;
    L6:
        if (aw() == true) goto L8;
        goto L8
    }

    @Override // com.fasterxml.jackson.a.a.b
    public final void aq() {
        int r0 = this.g;
        int r1 = this.h;
        if (r0 >= r1) goto L15;
        int[] r2 = R;
        int r3 = r2.length;
    L5:
        char r4 = this.T[r0];
        if (r4 < r3) goto L8;
    L13:
        r0 = r0 + 1;
        if (r0 < r1) goto L5;
    L8:
        if (r2[r4] == 0) goto L13;
        if (r4 != '\"') goto L15;
        this.q.a(this.T, this.g, r0 - this.g);
        this.g = r0 + 1;
        return;
    L15:
        this.q.b(this.T, this.g, r0 - this.g);
        this.g = r0;
        aC();
    }

    public void aC() {
        char[] r0 = this.q.i();
        int r1 = this.q.k();
        int[] r2 = R;
        int r3 = r2.length;
    L4:
        if (this.g >= this.h) goto L6;
    L8:
        char[] r4 = this.T;
        int r5 = this.g;
        this.g = r5 + 1;
        char r6 = r4[r5];
        if (r6 >= r3) goto L23;
        if (r2[r6] == 0) goto L23;
        if (r6 == '\"') goto L14;
        if (r6 != '\\') goto L20;
        r6 = ao();
        goto L23
    L20:
        if (r6 >= ' ') goto L23;
        b(r6, "string value");
        goto L23
    L14:
        this.q.a(r1);
        return;
    L23:
        if (r1 < r0.length) goto L25;
        r0 = this.q.l();
        r1 = 0;
    L25:
        r0[r1] = r6;
        r1 = r1 + 1;
        goto L4
    L6:
        if (aw() == true) goto L8;
        c(": was expecting closing quote for a string value", n.h);
        goto L8
    }

    public final void aD() {
        this.Y = false;
        int r0 = this.g;
        int r1 = this.h;
        char[] r2 = this.T;
    L3:
        if (r0 < r1) goto L8;
        this.g = r0;
        if (aw() == true) goto L7;
        c(": was expecting closing quote for a string value", n.h);
    L7:
        r0 = this.g;
        r1 = this.h;
    L8:
        int r3 = r0 + 1;
        char r4 = r2[r0];
        if (r4 > '\\') goto L20;
        if (r4 == '\\') goto L11;
        if (r4 > '\"') goto L20;
        if (r4 == '\"') goto L15;
        if (r4 >= ' ') goto L20;
        this.g = r3;
        b(r4, "string value");
        goto L20
    L15:
        this.g = r3;
        return;
    L11:
        this.g = r3;
        ao();
        r0 = this.g;
        r1 = this.h;
    L20:
        r0 = r3;
        goto L3
    }

    public final void aE() {
        if (this.g < this.h) goto L7;
        if (aw() == true) goto L7;
    L9:
        this.j++;
        this.k = this.g;
        return;
    L7:
        if (this.T[this.g] != '\n') goto L9;
        this.g++;
        goto L9
    }

    private final int aI() {
        if ((this.g + 4) >= this.h) goto L5;
        char r0 = this.T[this.g];
        if (r0 != ':') goto L30;
        char[] r1 = this.T;
        int r2 = this.g + 1;
        this.g = r2;
        char r3 = r1[r2];
        if (r3 <= ' ') goto L17;
        if (r3 == '/') goto L16;
        if (r3 == '#') goto L16;
        this.g++;
        return r3;
    L16:
        return a(true);
    L17:
        if (r3 == ' ') goto L19;
        if (r3 == '\t') goto L19;
    L29:
        return a(true);
    L19:
        char[] r4 = this.T;
        int r5 = this.g + 1;
        this.g = r5;
        char r6 = r4[r5];
        if (r6 <= ' ') goto L29;
        if (r6 == '/') goto L27;
        if (r6 == '#') goto L27;
        this.g++;
        return r6;
    L27:
        return a(true);
    L30:
        if (r0 == ' ') goto L32;
        if (r0 == '\t') goto L32;
    L33:
        if (r0 != ':') goto L57;
        char[] r7 = this.T;
        int r8 = this.g + 1;
        this.g = r8;
        char r9 = r7[r8];
        if (r9 <= ' ') goto L43;
        if (r9 == '/') goto L42;
        if (r9 == '#') goto L42;
        this.g++;
        return r9;
    L42:
        return a(true);
    L43:
        if (r9 == ' ') goto L45;
        if (r9 == '\t') goto L45;
    L55:
        return a(true);
    L45:
        char[] r10 = this.T;
        int r11 = this.g + 1;
        this.g = r11;
        char r12 = r10[r11];
        if (r12 <= ' ') goto L55;
        if (r12 == '/') goto L53;
        if (r12 == '#') goto L53;
        this.g++;
        return r12;
    L53:
        return a(true);
    L57:
        return a(false);
    L32:
        char[] r13 = this.T;
        int r14 = this.g + 1;
        this.g = r14;
        r0 = r13[r14];
        goto L33
    L5:
        return a(false);
    }

    private final int a(boolean r5) {
    L4:
        if (this.g >= this.h) goto L6;
    L10:
        char[] r1 = this.T;
        int r2 = this.g;
        this.g = r2 + 1;
        char r3 = r1[r2];
        if (r3 > ' ') goto L13;
        if (r3 >= ' ') goto L4;
        if (r3 == '\n') goto L29;
        if (r3 == '\r') goto L32;
        if (r3 == '\t') goto L4;
        f(r3);
        goto L4
    L32:
        aE();
        goto L4
    L29:
        this.j++;
        this.k = this.g;
        goto L4
    L13:
        if (r3 == '/') goto L14;
        if (r3 != '#') goto L20;
        if (aO() == true) goto L4;
    L20:
        if (r5 == true) goto L21;
        if (r3 == ':') goto L25;
        d(r3, "was expecting a colon to separate field name and value");
    L25:
        r5 = true;
        goto L4
    L21:
        return r3;
    L14:
        aM();
        goto L4
    L6:
        if (aw() == true) goto L10;
        c(" within/between " + this.o.e() + " entries", null);
        return -1;
    }

    private final int m(int r3) {
        if (r3 == 44) goto L6;
        d(r3, "was expecting comma to separate " + this.o.e() + " entries");
    L6:
        if (this.g >= this.h) goto L28;
        char[] r4 = this.T;
        int r0 = this.g;
        this.g = r0 + 1;
        char r5 = r4[r0];
        if (r5 > ' ') goto L10;
        if (r5 >= ' ') goto L6;
        if (r5 == '\n') goto L20;
        if (r5 == '\r') goto L23;
        if (r5 == '\t') goto L6;
        f(r5);
        goto L6
    L23:
        aE();
        goto L6
    L20:
        this.j++;
        this.k = this.g;
        goto L6
    L10:
        if (r5 != '/') goto L12;
    L15:
        this.g--;
        return aJ();
    L12:
        if (r5 == '#') goto L15;
        return r5;
    L28:
        return aJ();
    }

    private final int aJ() {
    L3:
        if (this.g >= this.h) goto L5;
    L9:
        char[] r0 = this.T;
        int r1 = this.g;
        this.g = r1 + 1;
        char r2 = r0[r1];
        if (r2 > ' ') goto L12;
        if (r2 >= ' ') goto L3;
        if (r2 == '\n') goto L23;
        if (r2 == '\r') goto L26;
        if (r2 == '\t') goto L3;
        f(r2);
        goto L3
    L26:
        aE();
        goto L3
    L23:
        this.j++;
        this.k = this.g;
        goto L3
    L12:
        if (r2 == '/') goto L13;
        if (r2 != '#') goto L19;
        if (aO() == true) goto L3;
    L19:
        return r2;
    L13:
        aM();
        goto L3
    L5:
        if (aw() == true) goto L9;
        throw b("Unexpected end-of-input within/between " + this.o.e() + " entries");
    }

    private final int aK() {
        if (this.g >= this.h) goto L5;
    L8:
        char[] r0 = this.T;
        int r1 = this.g;
        this.g = r1 + 1;
        char r2 = r0[r1];
        if (r2 <= ' ') goto L17;
        if (r2 == '/') goto L14;
        if (r2 == '#') goto L14;
        return r2;
    L14:
        this.g--;
        return aL();
    L17:
        if (r2 == ' ') goto L25;
        if (r2 != '\n') goto L20;
        this.j++;
        this.k = this.g;
        goto L25
    L20:
        if (r2 != '\r') goto L22;
        aE();
        goto L25
    L22:
        if (r2 == '\t') goto L25;
        f(r2);
    L25:
        if (this.g >= this.h) goto L42;
        char[] r3 = this.T;
        int r7 = this.g;
        this.g = r7 + 1;
        char r4 = r3[r7];
        if (r4 > ' ') goto L28;
        if (r4 == ' ') goto L25;
        if (r4 == '\n') goto L36;
        if (r4 == '\r') goto L38;
        if (r4 == '\t') goto L25;
        f(r4);
        goto L25
    L38:
        aE();
        goto L25
    L36:
        this.j++;
        this.k = this.g;
        goto L25
    L28:
        if (r4 == '/') goto L32;
        if (r4 == '#') goto L32;
        return r4;
    L32:
        this.g--;
        return aL();
    L42:
        return aL();
    L5:
        if (aw() == true) goto L8;
        return ae();
    }

    private int aL() {
    L3:
        if (this.g >= this.h) goto L5;
    L8:
        char[] r0 = this.T;
        int r1 = this.g;
        this.g = r1 + 1;
        char r2 = r0[r1];
        if (r2 > ' ') goto L11;
        if (r2 == ' ') goto L3;
        if (r2 == '\n') goto L22;
        if (r2 == '\r') goto L25;
        if (r2 == '\t') goto L3;
        f(r2);
        goto L3
    L25:
        aE();
        goto L3
    L22:
        this.j++;
        this.k = this.g;
        goto L3
    L11:
        if (r2 == '/') goto L12;
        if (r2 != '#') goto L18;
        if (aO() == true) goto L3;
    L18:
        return r2;
    L12:
        aM();
        goto L3
    L5:
        if (aw() == true) goto L8;
        return ae();
    }

    private void aM() {
        if ((this.f12136b & ai) != 0) goto L6;
        d(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    L6:
        if (this.g >= this.h) goto L8;
    L10:
        char[] r0 = this.T;
        int r2 = this.g;
        this.g = r2 + 1;
        char r1 = r0[r2];
        if (r1 != '/') goto L14;
        aP();
        return;
    L14:
        if (r1 != '*') goto L16;
        aN();
        return;
    L16:
        d(r1, "was expecting either '*' or '/' for a comment");
        return;
    L8:
        if (aw() == true) goto L10;
        c(" in a comment", null);
        goto L10
    }

    private void aN() {
    L3:
        if (this.g >= this.h) goto L5;
    L6:
        char[] r0 = this.T;
        int r1 = this.g;
        this.g = r1 + 1;
        char r2 = r0[r1];
        if (r2 > '*') goto L3;
        if (r2 == '*') goto L10;
        if (r2 >= ' ') goto L3;
        if (r2 == '\n') goto L23;
        if (r2 == '\r') goto L26;
        if (r2 == '\t') goto L3;
        f(r2);
        goto L3
    L26:
        aE();
        goto L3
    L23:
        this.j++;
        this.k = this.g;
        goto L3
    L10:
        if (this.g < this.h) goto L16;
        if (aw() == true) goto L16;
    L13:
        c(" in a comment", null);
        return;
    L16:
        if (this.T[this.g] != '/') goto L3;
        this.g++;
        return;
    L5:
        if (aw() == false) goto L13;
        goto L6
    }

    private boolean aO() {
        if ((this.f12136b & aj) != 0) goto L6;
        return false;
    L6:
        aP();
        return true;
    }

    private void aP() {
    L3:
        if (this.g >= this.h) goto L5;
    L6:
        char[] r0 = this.T;
        int r1 = this.g;
        this.g = r1 + 1;
        char r2 = r0[r1];
        if (r2 >= ' ') goto L3;
        if (r2 == '\n') goto L10;
        if (r2 == '\r') goto L13;
        if (r2 == '\t') goto L3;
        f(r2);
        goto L3
    L13:
        aE();
        return;
    L10:
        this.j++;
        this.k = this.g;
        return;
    L5:
        if (aw() == true) goto L6;
    }

    @Override // com.fasterxml.jackson.a.a.b
    public char ao() {
        if (this.g >= this.h) goto L5;
    L7:
        char[] r0 = this.T;
        int r1 = this.g;
        this.g = r1 + 1;
        char r2 = r0[r1];
        if (r2 != '\"') goto L10;
    L51:
        return r2;
    L10:
        if (r2 == '/') goto L51;
        if (r2 == '\\') goto L51;
        if (r2 != 'b') goto L16;
        return '\b';
    L16:
        if (r2 != 'f') goto L18;
        return '\f';
    L18:
        if (r2 != 'n') goto L20;
        return '\n';
    L20:
        if (r2 != 'r') goto L22;
        return '\r';
    L22:
        if (r2 != 't') goto L24;
        return '\t';
    L24:
        if (r2 != 'u') goto L26;
        int r3 = 0;
        int r4 = 0;
    L29:
        if (r3 >= 4) goto L40;
        if (this.g >= this.h) goto L33;
    L35:
        char[] r5 = this.T;
        int r6 = this.g;
        this.g = r6 + 1;
        char r7 = r5[r6];
        int r8 = com.fasterxml.jackson.a.d.b.b(r7);
        if (r8 >= 0) goto L38;
        d(r7, "expected a hex-digit for character escape sequence");
    L38:
        r4 = (r4 << 4) | r8;
        r3 = r3 + 1;
        goto L29
    L33:
        if (aw() == true) goto L35;
        c(" in character escape sequence", n.h);
        goto L35
    L40:
        return (char) r4;
    L26:
        return a(r2);
    L5:
        if (aw() == true) goto L7;
        c(" in character escape sequence", n.h);
        goto L7
    }

    private final void aQ() {
        int r0 = this.g;
        if ((r0 + 3) >= this.h) goto L18;
        char[] r1 = this.T;
        if (r1[r0] != 'r') goto L18;
        int r2 = r0 + 1;
        if (r1[r2] != 'u') goto L18;
        int r3 = r2 + 1;
        if (r1[r3] != 'e') goto L18;
        int r4 = r3 + 1;
        char r5 = r1[r4];
        if (r5 >= '0') goto L13;
    L16:
        this.g = r4;
        return;
    L13:
        if (r5 == ']') goto L16;
        if (r5 == '}') goto L16;
    L18:
        a("true", 1);
    }

    private final void aR() {
        int r0 = this.g;
        if ((r0 + 4) >= this.h) goto L20;
        char[] r1 = this.T;
        if (r1[r0] != 'a') goto L20;
        int r2 = r0 + 1;
        if (r1[r2] != 'l') goto L20;
        int r3 = r2 + 1;
        if (r1[r3] != 's') goto L20;
        int r4 = r3 + 1;
        if (r1[r4] != 'e') goto L20;
        int r5 = r4 + 1;
        char r6 = r1[r5];
        if (r6 >= '0') goto L15;
    L18:
        this.g = r5;
        return;
    L15:
        if (r6 == ']') goto L18;
        if (r6 == '}') goto L18;
    L20:
        a("false", 1);
    }

    private final void aS() {
        int r0 = this.g;
        if ((r0 + 3) >= this.h) goto L18;
        char[] r1 = this.T;
        if (r1[r0] != 'u') goto L18;
        int r2 = r0 + 1;
        if (r1[r2] != 'l') goto L18;
        int r3 = r2 + 1;
        if (r1[r3] != 'l') goto L18;
        int r4 = r3 + 1;
        char r5 = r1[r4];
        if (r5 >= '0') goto L13;
    L16:
        this.g = r4;
        return;
    L13:
        if (r5 == ']') goto L16;
        if (r5 == '}') goto L16;
    L18:
        a("null", 1);
    }

    public final void a(String r4, int r5) {
        int r0 = r4.length();
        if ((this.g + r0) < this.h) goto L7;
        b(r4, r5);
        return;
    L7:
        if (this.T[this.g] == r4.charAt(r5)) goto L9;
        k(r4.substring(0, r5));
    L9:
        this.g++;
        r5 = r5 + 1;
        if (r5 < r0) goto L7;
        char r1 = this.T[this.g];
        if (r1 >= '0') goto L14;
        return;
    L14:
        if (r1 != ']') goto L16;
        return;
    L16:
        if (r1 == '}') goto L23;
        a(r4, r5, r1);
        return;
    }

    private final void b(String r4, int r5) {
        int r0 = r4.length();
    L4:
        if (this.g < this.h) goto L8;
        if (aw() == true) goto L8;
    L9:
        k(r4.substring(0, r5));
    L10:
        this.g++;
        r5 = r5 + 1;
        if (r5 < r0) goto L4;
        if (this.g >= this.h) goto L15;
    L17:
        char r1 = this.T[this.g];
        if (r1 >= '0') goto L20;
        return;
    L20:
        if (r1 != ']') goto L22;
        return;
    L22:
        if (r1 == '}') goto L29;
        a(r4, r5, r1);
        return;
    L29:
        return;
    L15:
        if (aw() == true) goto L17;
        return;
    L8:
        if (this.T[this.g] == r4.charAt(r5)) goto L10;
        goto L9
    }

    private final void a(String r1, int r2, int r3) {
        if (Character.isJavaIdentifierPart((char) r3) == false) goto L6;
        k(r1.substring(0, r2));
        return;
    }

    public byte[] c(com.fasterxml.jackson.a.a r11) {
        com.fasterxml.jackson.a.h.c r0 = af();
    L4:
        if (this.g < this.h) goto L6;
        av();
    L6:
        char[] r1 = this.T;
        int r2 = this.g;
        this.g = r2 + 1;
        char r3 = r1[r2];
        if (r3 <= ' ') goto L4;
        int r4 = r11.b(r3);
        if (r4 >= 0) goto L17;
        if (r3 == '\"') goto L12;
        r4 = a(r11, r3, 0);
        if (r4 >= 0) goto L17;
    L12:
        return r0.b();
    L17:
        if (this.g < this.h) goto L19;
        av();
    L19:
        char[] r5 = this.T;
        int r6 = this.g;
        this.g = r6 + 1;
        char r7 = r5[r6];
        int r8 = r11.b(r7);
        if (r8 >= 0) goto L22;
        r8 = a(r11, r7, 1);
    L22:
        int r9 = (r4 << 6) | r8;
        if (this.g < this.h) goto L25;
        av();
    L25:
        char[] r10 = this.T;
        int r12 = this.g;
        this.g = r12 + 1;
        char r13 = r10[r12];
        int r14 = r11.b(r13);
        if (r14 >= 0) goto L47;
        if (r14 == (-2)) goto L35;
        if (r13 == '\"') goto L29;
        r14 = a(r11, r13, 2);
        goto L35
    L29:
        r0.a(r9 >> 4);
        if (r11.b() == false) goto L33;
        this.g--;
        b(r11);
    L33:
        return r0.b();
    L35:
        if (r14 != (-2)) goto L47;
        if (this.g < this.h) goto L39;
        av();
    L39:
        char[] r15 = this.T;
        int r16 = this.g;
        this.g = r16 + 1;
        char r17 = r15[r16];
        if (r11.a(r17) == false) goto L42;
    L46:
        r0.a(r9 >> 4);
        goto L4
    L42:
        if (a(r11, r17, 3) == (-2)) goto L46;
        throw a(r11, r17, 3, "expected padding character '" + r11.e() + "'");
    L47:
        int r18 = (r9 << 6) | r14;
        if (this.g < this.h) goto L50;
        av();
    L50:
        char[] r19 = this.T;
        int r20 = this.g;
        this.g = r20 + 1;
        char r21 = r19[r20];
        int r22 = r11.b(r21);
        if (r22 >= 0) goto L62;
        if (r22 == (-2)) goto L60;
        if (r21 == '\"') goto L54;
        r22 = a(r11, r21, 3);
        goto L60
    L54:
        r0.b(r18 >> 2);
        if (r11.b() == false) goto L58;
        this.g--;
        b(r11);
    L58:
        return r0.b();
    L60:
        if (r22 != (-2)) goto L62;
        r0.b(r18 >> 2);
    L62:
        r0.c((r18 << 6) | r22);
        goto L4
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.i f() {
        if (this.P != n.f) goto L7;
        long r11 = this.i + (this.Z - 1);
        return new com.fasterxml.jackson.a.i(ap(), -1, r11, this.aa, this.ab);
    L7:
        return new com.fasterxml.jackson.a.i(ap(), -1, this.l - 1, this.m, this.n);
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.i e() {
        int r8 = (this.g - this.k) + 1;
        com.fasterxml.jackson.a.d.d r2 = ap();
        long r3 = this.i;
        return new com.fasterxml.jackson.a.i(r2, -1, ((long) this.g) + r3, this.j, r8);
    }

    private final void aT() {
        int r0 = this.g;
        this.l = this.i + ((long) r0);
        this.m = this.j;
        this.n = r0 - this.k;
    }

    private final void aU() {
        int r0 = this.g;
        this.Z = r0;
        this.aa = this.j;
        this.ab = r0 - this.k;
    }

    public void k(String r2) {
        a(r2, am());
    }

    public void a(String r3, String r4) {
        StringBuilder r0 = new StringBuilder(r3);
    L4:
        if (this.g >= this.h) goto L6;
    L7:
        char r5 = this.T[this.g];
        if (Character.isJavaIdentifierPart(r5) == false) goto L13;
        this.g++;
        r0.append(r5);
        if (r0.length() < 256) goto L4;
        r0.append("...");
    L13:
        a("Unrecognized token '%s': was expecting %s", r0, r4);
        return;
    L6:
        if (aw() == false) goto L13;
        goto L7
    }

    private void n(int r4) {
        if (r4 != 93) goto L8;
        aT();
        if (this.o.b() == true) goto L7;
        a(r4, '}');
    L7:
        this.o = this.o.k();
        this.P = n.f12155e;
    L8:
        if (r4 != 125) goto L14;
        aT();
        if (this.o.d() == true) goto L12;
        a(r4, ']');
    L12:
        this.o = this.o.k();
        this.P = n.f12153c;
        return;
    }
}
