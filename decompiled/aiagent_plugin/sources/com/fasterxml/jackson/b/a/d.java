package com.fasterxml.jackson.b.a;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.fasterxml.jackson.a.d.e;
import com.fasterxml.jackson.a.h.i;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.n;
import com.fasterxml.jackson.a.o;
import com.fasterxml.jackson.a.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.c.a.d.g;
import org.c.a.d.j;
import org.c.a.d.l;

/* JADX INFO: compiled from: YAMLParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends com.fasterxml.jackson.a.a.b {
    protected o R;
    protected int S;
    protected boolean T;
    protected final Reader U;
    protected final org.c.a.g.b V;
    protected final org.c.a.i.a W;
    protected g X;
    protected g Y;
    protected String Z;
    protected String aa;
    protected String ab;
    protected boolean ac;
    protected String ad;

    /* JADX INFO: compiled from: YAMLParser.java */
    public static final enum a extends Enum<a> implements com.fasterxml.jackson.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12176a = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f12177d = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f12178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f12179c;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f12177d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("EMPTY_STRING_AS_NULL", 0, true);
            f12176a = r0;
            f12177d = new a[]{r0};
        }

        public static int a() {
            a[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r2 >= r1) goto L8;
            a r4 = r0[r2];
            if (r4.b() == false) goto L7;
            r3 = r3 | r4.c();
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            return r3;
        }

        private a(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.f12178b = r3;
            this.f12179c = 1 << ordinal();
        }

        @Override // com.fasterxml.jackson.a.h.h
        public boolean b() {
            return this.f12178b;
        }

        public boolean a(int r1) {
            if ((this.f12179c & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.fasterxml.jackson.a.h.h
        public int c() {
            return this.f12179c;
        }
    }

    @Override // com.fasterxml.jackson.a.k
    public int A() {
        return 0;
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.k
    public boolean B() {
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean S() {
        return true;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean T() {
        return true;
    }

    @Override // com.fasterxml.jackson.a.k
    public boolean b() {
        return false;
    }

    @Override // com.fasterxml.jackson.a.k
    public /* synthetic */ Object U() {
        return av();
    }

    @Override // com.fasterxml.jackson.a.k
    public /* synthetic */ Object V() {
        return aw();
    }

    public d(e r1, com.fasterxml.jackson.a.h.a r2, int r3, int r4, o r5, Reader r6) {
        super(r1, r3);
        this.W = new org.c.a.i.a();
        this.R = r5;
        this.S = r4;
        this.U = r6;
        this.V = new org.c.a.g.b(new org.c.a.h.b(r6));
        this.T = a.f12176a.a(r4);
    }

    @Override // com.fasterxml.jackson.a.k
    public o a() {
        return this.R;
    }

    @Override // com.fasterxml.jackson.a.k
    public i<r> c() {
        return f12135a;
    }

    @Override // com.fasterxml.jackson.a.a.b
    public void ab() {
        if (this.f11975e.a() == false) goto L5;
    L6:
        this.U.close();
        return;
    L5:
        if (a(k.a.f12138a) == true) goto L6;
    }

    @Override // com.fasterxml.jackson.a.k
    public k b(int r3, int r4) {
        int r5 = r3 & r4;
        this.S = r5 | (this.S & (~r4));
        this.T = a.f12176a.a(this.S);
        return this;
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.i f() {
        g r0 = this.X;
        if (r0 != null) goto L7;
        return com.fasterxml.jackson.a.i.f12130a;
    L7:
        return a(r0.f());
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.i e() {
        g r0 = this.X;
        if (r0 != null) goto L7;
        return com.fasterxml.jackson.a.i.f12130a;
    L7:
        return a(r0.g());
    }

    public com.fasterxml.jackson.a.i a(org.c.a.c.a r13) {
        if (r13 != null) goto L6;
        return new com.fasterxml.jackson.a.i(this.f11975e.b(), -1, -1, -1);
    L6:
        return new com.fasterxml.jackson.a.i(this.f11975e.b(), r13.e(), r13.c() + 1, r13.d() + 1);
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public n g() {
        boolean r1 = false;
        this.ac = false;
        this.u = null;
        if (this.f == false) goto L80;
        return null;
    L80:
        g r3 = this.V.b();     // Catch: org.c.a.c.c -> L73
        if (r3 == null) goto L7;
        this.X = r3;
        if (this.o.d() == false) goto L34;
        if (this.P != n.f) goto L14;
    L36:
        this.ad = null;
        this.Y = r3;
        if (r3.a(g.a.g) == true) goto L38;
        if (r3.a(g.a.f) == true) goto L42;
        if (r3.a(g.a.f40402e) == false) goto L48;
        i("Not expecting END_OBJECT but a value");
    L48:
        if (r3.a(g.a.i) == true) goto L49;
        if (r3.a(g.a.h) == true) goto L54;
        if (r3.a(g.a.f40400c) == true) goto L80;
        if (r3.a(g.a.f40401d) == true) goto L80;
        if (r3.a(g.a.f40398a) == true) goto L66;
        if (r3.a(g.a.j) == true) goto L70;
        r3.a(g.a.k);
        goto L80
    L70:
        close();
        this.P = null;
        return null;
    L66:
        org.c.a.d.a r0 = (org.c.a.d.a) ZeusTransformUtils.preCheckCast(r3, org.c.a.d.a.class, "com.obric.aiagent.plugin");
        this.ac = true;
        this.Z = r0.h();
        this.aa = null;
        n r2 = n.h;
        this.P = r2;
        return r2;
    L54:
        if (this.o.b() == true) goto L56;
        a(93, '}');
    L56:
        this.o = this.o.j();
        n r4 = n.f12155e;
        this.P = r4;
        return r4;
    L49:
        org.c.a.c.a r5 = r3.f();
        this.ad = ((org.c.a.d.k) ZeusTransformUtils.preCheckCast(r3, org.c.a.d.k.class, "com.obric.aiagent.plugin")).h();
        this.o = this.o.a(r5.c(), r5.d());
        n r6 = n.f12154d;
        this.P = r6;
        return r6;
    L42:
        org.c.a.c.a r7 = r3.f();
        this.ad = ((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin")).h();
        this.o = this.o.b(r7.c(), r7.d());
        n r8 = n.f12152b;
        this.P = r8;
        return r8;
    L38:
        n r9 = a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"));
        this.P = r9;
        return r9;
    L14:
        if (r3.a(g.a.g) == true) goto L23;
        this.ad = null;
        this.Y = null;
        if (r3.a(g.a.f40402e) == true) goto L18;
        i("Expected a field name (Scalar value in YAML), got this instead: " + r3);
        goto L23
    L18:
        if (this.o.d() == true) goto L20;
        a(125, ']');
    L20:
        this.o = this.o.j();
        n r10 = n.f12153c;
        this.P = r10;
        return r10;
    L23:
        l r11 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
        String r12 = r11.h();
        if (this.P != n.f12152b) goto L26;
        r1 = true;
    L26:
        if (r12 != null) goto L28;
        if (r1 == false) goto L28;
    L29:
        if (r1 == true) goto L31;
        this.Y = r3;
    L31:
        String r13 = r11.e();
        this.ab = r13;
        this.o.a(r13);
        n r14 = n.f;
        this.P = r14;
        return r14;
    L28:
        this.ad = r11.h();
        goto L29
    L34:
        if (this.o.b() == false) goto L36;
        this.o.m();
        goto L36
    L7:
        this.ad = null;
        this.Y = null;
        this.P = null;
        return null;
    L73:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, org.c.a.c.b.class) == false) goto L79;
        throw com.fasterxml.jackson.b.a.a.a.a.a(this, (org.c.a.c.b) ZeusTransformUtils.preCheckCast(e, org.c.a.c.b.class, "com.obric.aiagent.plugin"));
    L79:
        throw new com.fasterxml.jackson.b.a.a(this, e.getMessage(), e);
    }

    public n a(l r6) {
        String r0 = r6.e();
        this.Z = r0;
        this.aa = null;
        if (this.T == false) goto L5;
    L8:
        String r1 = r6.b();
        int r2 = r0.length();
        if (r1 != null) goto L11;
    L48:
        org.c.a.f.b r7 = this.W.a(org.c.a.f.a.f40416a, r0, r6.i().a());
        if (r7 != org.c.a.f.b.l) goto L53;
        return n.h;
    L53:
        if (r7 != org.c.a.f.b.g) goto L57;
        return b(r0, r2);
    L57:
        if (r7 != org.c.a.f.b.h) goto L61;
        this.v = 0;
        return k(r0);
    L61:
        if (r7 != org.c.a.f.b.j) goto L72;
        Boolean r5 = a(r0, r2);
        if (r5 != null) goto L65;
    L70:
        return n.h;
    L65:
        if (r5.booleanValue() == false) goto L68;
        return n.k;
    L68:
        return n.l;
    L72:
        if (r7 != org.c.a.f.b.k) goto L76;
        return n.m;
    L76:
        return n.h;
    L11:
        if (r1.equals("!") == true) goto L48;
        if (r1.startsWith("tag:yaml.org,2002:") == false) goto L19;
        r1 = r1.substring(18);
        if (r1.contains(",") == false) goto L19;
        r1 = r1.split(",")[0];
    L19:
        if ("binary".equals(r1) == false) goto L28;
        String r8 = r0.trim();
        this.u = com.fasterxml.jackson.a.b.f11977a.a(r8);     // Catch: IllegalArgumentException -> L23
    L26:
        return n.g;
    L23:
        e = move-exception;
        i(e.getMessage());
        goto L26
    L28:
        if ("bool".equals(r1) == false) goto L37;
        Boolean r9 = a(r0, r2);
        if (r9 == null) goto L70;
        if (r9.booleanValue() == false) goto L35;
        return n.k;
    L35:
        return n.l;
    L37:
        if ("int".equals(r1) == false) goto L41;
        return b(r0, r2);
    L41:
        if (WsChannelMultiProcessSharedProvider.FLOAT_TYPE.equals(r1) == false) goto L45;
        this.v = 0;
        return k(r0);
    L45:
        if ("null".equals(r1) == false) goto L70;
        return n.m;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return n.h;
    }

    public Boolean a(String r1, int r2) {
        if (r2 != 1) goto L5;
        char r0 = r1.charAt(0);
        if (r0 == 'N') goto L50;
        if (r0 == 'Y') goto L48;
        if (r0 == 'n') goto L50;
        if (r0 == 'y') goto L48;
        return null;
    L48:
        return Boolean.TRUE;
    L50:
        return Boolean.FALSE;
    L5:
        if (r2 == 2) goto L30;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L18;
        if (r2 == 5) goto L14;
        return null;
    L14:
        if ("false".equalsIgnoreCase(r1) == true) goto L16;
        return null;
    L16:
        return Boolean.FALSE;
    L18:
        if ("true".equalsIgnoreCase(r1) == true) goto L20;
        return null;
    L20:
        return Boolean.TRUE;
    L22:
        if ("yes".equalsIgnoreCase(r1) == false) goto L26;
        return Boolean.TRUE;
    L26:
        if ("off".equalsIgnoreCase(r1) == true) goto L28;
        return null;
    L28:
        return Boolean.FALSE;
    L30:
        if ("no".equalsIgnoreCase(r1) == false) goto L34;
        return Boolean.FALSE;
    L34:
        if ("on".equalsIgnoreCase(r1) == true) goto L36;
        return null;
    L36:
        return Boolean.TRUE;
    }

    public n b(String r9, int r10) {
        char r1 = r9.charAt(0);
        if (r1 != '-') goto L7;
        this.B = true;
    L5:
        int r2 = 1;
    L12:
        if (r10 != r2) goto L15;
        return null;
    L15:
        if (r9.charAt(r2) != '0') goto L38;
        int r3 = r2 + 1;
        if (r3 != r10) goto L20;
        this.w = 0;
        this.v = 1;
        return n.i;
    L20:
        char r0 = r9.charAt(r3);
        if (r0 == 'B') goto L37;
        if (r0 == 'X') goto L35;
        if (r0 == '_') goto L33;
        if (r0 == 'b') goto L37;
        if (r0 == 'x') goto L35;
        switch(r0) {
            case 48: goto L33;
            case 49: goto L33;
            case 50: goto L33;
            case 51: goto L33;
            case 52: goto L33;
            case 53: goto L33;
            case 54: goto L33;
            case 55: goto L33;
            case 56: goto L33;
            case 57: goto L33;
            default: goto L31;
        };
    L31:
        return n.h;
    L33:
        return b(r9, r3, r10, this.B);
    L35:
        return c(r9, r3 + 1, r10, this.B);
    L37:
        return a(r9, r3 + 1, r10, this.B);
    L38:
        boolean r4 = false;
    L39:
        char r6 = r9.charAt(r2);
        if (r6 > '9') goto L42;
        if (r6 < '0') goto L42;
    L44:
        r2 = r2 + 1;
        if (r2 != r10) goto L39;
        this.v = 0;
        if (r4 == true) goto L49;
        this.aa = this.Z;
        return n.i;
    L49:
        return j(r9);
    L42:
        if (r6 != '_') goto L53;
        r4 = true;
        goto L44
    L53:
        return n.h;
    L7:
        if (r1 != '+') goto L11;
        this.B = false;
        if (r10 != 1) goto L5;
        return null;
    L11:
        this.B = false;
        r2 = 0;
        goto L12
    }

    public n a(String r3, int r4, int r5, boolean r6) {
        String r7 = a(r3, r4, r5);
        int r8 = r7.length();
        boolean r9 = true;
        if (r8 > 31) goto L10;
        int r10 = Integer.parseInt(r7, 2);
        if (r6 == false) goto L7;
        r10 = -r10;
    L7:
        this.w = r10;
        this.v = 1;
        return n.i;
    L10:
        if (r8 > 63) goto L18;
        long r0 = Long.parseLong(r7, 2);
        if (r8 == 32) goto L16;
        r9 = false;
    L16:
        return a(r0, r6, r9);
    L18:
        return a(new BigInteger(r7, 2), r6);
    }

    public n b(String r2, int r3, int r4, boolean r5) {
        String r6 = a(r2, r3, r4);
        int r7 = r6.length();
        if (r7 > 10) goto L10;
        int r8 = Integer.parseInt(r6, 8);
        if (r5 == false) goto L7;
        r8 = -r8;
    L7:
        this.w = r8;
        this.v = 1;
        return n.i;
    L10:
        if (r7 > 21) goto L14;
        return a(Long.parseLong(r6, 8), r5, false);
    L14:
        return a(new BigInteger(r6, 8), r5);
    }

    public n c(String r3, int r4, int r5, boolean r6) {
        String r7 = a(r3, r4, r5);
        int r8 = r7.length();
        boolean r9 = true;
        if (r8 > 7) goto L10;
        int r10 = Integer.parseInt(r7, 16);
        if (r6 == false) goto L7;
        r10 = -r10;
    L7:
        this.w = r10;
        this.v = 1;
        return n.i;
    L10:
        if (r8 > 15) goto L18;
        long r0 = Long.parseLong(r7, 16);
        if (r8 == 8) goto L16;
        r9 = false;
    L16:
        return a(r0, r6, r9);
    L18:
        return a(new BigInteger(r7, 16), r6);
    }

    private n a(long r2, boolean r4, boolean r5) {
        if (r4 == false) goto L10;
        r2 = -r2;
        if (r5 == true) goto L7;
    L15:
        this.x = r2;
        this.v = 2;
        return n.i;
    L7:
        if (r2 < (-2147483648L)) goto L15;
        this.w = (int) r2;
        this.v = 1;
        return n.i;
    L10:
        if (r5 == false) goto L15;
        if (r2 >= 2147483647L) goto L15;
        this.w = (int) r2;
        this.v = 1;
        return n.i;
    }

    private n a(BigInteger r1, boolean r2) {
        if (r2 == false) goto L4;
        this.z = r1.negate();
    L5:
        this.v = 4;
        return n.i;
    L4:
        this.z = r1;
        goto L5
    }

    @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public String x() {
        if (this.P != n.h) goto L7;
        return this.Z;
    L7:
        if (this.P != n.f) goto L11;
        return this.ab;
    L11:
        if (this.P != null) goto L13;
        return null;
    L13:
        if (this.P.g() == false) goto L17;
        return this.Z;
    L17:
        return this.P.b();
    }

    @Override // com.fasterxml.jackson.a.a.b, com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
    public String v() {
        if (this.P != n.f) goto L7;
        return this.ab;
    L7:
        return super.v();
    }

    @Override // com.fasterxml.jackson.a.k
    public char[] y() {
        String r0 = x();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toCharArray();
    }

    @Override // com.fasterxml.jackson.a.k
    public int z() {
        String r0 = x();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length();
    }

    @Override // com.fasterxml.jackson.a.k
    public Object N() {
        if (this.P == n.g) goto L5;
        return null;
    L5:
        return this.u;
    }

    @Override // com.fasterxml.jackson.a.k
    public int a(com.fasterxml.jackson.a.a r1, OutputStream r2) {
        byte[] r0 = a(r1);
        r2.write(r0);
        return r0.length;
    }

    @Override // com.fasterxml.jackson.a.a.b
    public void d(int r9) {
        if (this.P != n.i) goto L38;
        int r0 = this.aa.length();
        if (this.B == false) goto L8;
        r0 = r0 - 1;
    L8:
        if (r0 > 9) goto L12;
        this.w = Integer.parseInt(this.aa);
        this.v = 1;
        return;
    L12:
        if (r0 > 18) goto L52;
        long r1 = Long.parseLong(this.aa);
        if (r0 == 10) goto L16;
    L25:
        this.x = r1;
        this.v = 2;
        return;
    L16:
        if (this.B == false) goto L22;
        if (r1 < (-2147483648L)) goto L25;
        this.w = (int) r1;
        this.v = 1;
        return;
    L22:
        if (r1 > 2147483647L) goto L25;
        this.w = (int) r1;
        this.v = 1;
        return;
    L52:
        BigInteger r2 = new BigInteger(this.aa);     // Catch: NumberFormatException -> L35
        if (r0 == 19) goto L30;
    L33:
        this.z = r2;     // Catch: NumberFormatException -> L35
        this.v = 4;     // Catch: NumberFormatException -> L35
        return;
    L30:
        if (r2.bitLength() > 63) goto L33;
        this.x = r2.longValue();     // Catch: NumberFormatException -> L35
        this.v = 2;     // Catch: NumberFormatException -> L35
        return;
    L35:
        e = move-exception;
        a("Malformed numeric value '" + this.Z + "'", e);
    L38:
        if (this.P != n.j) goto L47;
        String r3 = this.aa;
        if (r9 != 16) goto L42;
        this.A = new BigDecimal(r3);     // Catch: NumberFormatException -> L44
        this.v = 16;     // Catch: NumberFormatException -> L44
    L49:
        return;
    L42:
        this.y = Double.parseDouble(r3);     // Catch: NumberFormatException -> L44
        this.v = 8;     // Catch: NumberFormatException -> L44
    L44:
        e = move-exception;
        a("Malformed numeric value '" + this.Z + "'", e);
        return;
    L47:
        i("Current token (" + this.P + ") not numeric, can not use numeric value accessors");
    }

    @Override // com.fasterxml.jackson.a.a.b
    public int ag() {
        if (this.P != n.i) goto L11;
        int r0 = this.aa.length();
        if (this.B == false) goto L8;
        r0 = r0 - 1;
    L8:
        if (r0 > 9) goto L11;
        this.v = 1;
        int r1 = Integer.parseInt(this.aa);
        this.w = r1;
        return r1;
    L11:
        d(1);
        if ((this.v & 1) != 0) goto L15;
        ah();
    L15:
        return this.w;
    }

    public String av() {
        return this.ad;
    }

    public String aw() {
        if (ZeusTransformUtils.instanceOf(this.Y, org.c.a.d.c.class) == false) goto L6;
        String r4 = ((org.c.a.d.c) ZeusTransformUtils.preCheckCast(this.Y, org.c.a.d.c.class, "com.obric.aiagent.plugin")).b();
    L8:
        if (r4 != null) goto L10;
    L13:
        return null;
    L10:
        if (r4.startsWith("!") == false) goto L12;
        r4 = r4.substring(1);
        goto L10
    L12:
        return r4;
    L6:
        if (ZeusTransformUtils.instanceOf(this.Y, l.class) == false) goto L13;
        r4 = ((l) ZeusTransformUtils.preCheckCast(this.Y, l.class, "com.obric.aiagent.plugin")).b();
        goto L8
    }

    private n j(String r6) {
        int r0 = r6.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r2 = 0;
        if (r6.charAt(0) != '+') goto L5;
        r2 = 1;
    L5:
        if (r2 >= r0) goto L10;
        char r3 = r6.charAt(r2);
        if (r3 == '_') goto L9;
        r1.append(r3);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        this.aa = r1.toString();
        return n.i;
    }

    private String a(String r3, int r4, int r5) {
        StringBuilder r2 = new StringBuilder(r5);
    L3:
        if (r4 >= r5) goto L9;
        char r0 = r3.charAt(r4);
        if (r0 == '_') goto L7;
        r2.append(r0);
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        if (r2.length() != r5) goto L12;
        return r3;
    L12:
        return r2.toString();
    }

    private n k(String r7) {
        int r0 = r7.length();
        if (r7.indexOf(95) < 0) goto L16;
        if (r0 == 0) goto L16;
        StringBuilder r2 = new StringBuilder(r0);
        int r3 = 0;
        if (r7.charAt(0) != '+') goto L9;
        r3 = 1;
    L9:
        if (r3 >= r0) goto L14;
        char r4 = r7.charAt(r3);
        if (r4 == '_') goto L13;
        r2.append(r4);
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        this.aa = r2.toString();
        return n.j;
    L16:
        this.aa = r7;
        return n.j;
    }
}
