package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

/* JADX INFO: compiled from: TokenBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends com.fasterxml.jackson.a.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int f13077e = 0;
    protected com.fasterxml.jackson.a.o f;
    protected com.fasterxml.jackson.a.m g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    protected boolean m;
    protected b n;
    protected b o;
    protected int p;
    protected Object q;
    protected Object r;
    protected boolean s;
    protected com.fasterxml.jackson.a.e.e t;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.l.y$1, reason: invalid class name */
    /* JADX INFO: compiled from: TokenBuffer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13078a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f13079b = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.a.k.b.values().length];
            f13079b = r0;
            r0[com.fasterxml.jackson.a.k.b.f12143a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L63:
            f13079b[com.fasterxml.jackson.a.k.b.f12145c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L49:
            f13079b[com.fasterxml.jackson.a.k.b.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L59:
            f13079b[com.fasterxml.jackson.a.k.b.f12146d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L65:
            f13079b[com.fasterxml.jackson.a.k.b.f12144b.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L12:
            int[] r5 = new int[com.fasterxml.jackson.a.n.values().length];
            f13078a = r5;
            r5[com.fasterxml.jackson.a.n.f12152b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L69:
            f13078a[com.fasterxml.jackson.a.n.f12153c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L75:
            f13078a[com.fasterxml.jackson.a.n.f12154d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L45:
            f13078a[com.fasterxml.jackson.a.n.f12155e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L53:
            f13078a[com.fasterxml.jackson.a.n.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L73:
            f13078a[com.fasterxml.jackson.a.n.h.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L43:
            f13078a[com.fasterxml.jackson.a.n.i.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L67:
            f13078a[com.fasterxml.jackson.a.n.j.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
        L71:
            f13078a[com.fasterxml.jackson.a.n.k.ordinal()] = 9;     // Catch: NoSuchFieldError -> L39
        L55:
            f13078a[com.fasterxml.jackson.a.n.l.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L61:
            f13078a[com.fasterxml.jackson.a.n.m.ordinal()] = 11;     // Catch: NoSuchFieldError -> L41
        L51:
            f13078a[com.fasterxml.jackson.a.n.g.ordinal()] = 12;     // Catch: NoSuchFieldError -> L42
            return;
        }
    }

    /* JADX INFO: compiled from: TokenBuffer.java */
    protected static final class a extends com.fasterxml.jackson.a.a.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected com.fasterxml.jackson.a.o f13080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final boolean f13081e;
        protected final boolean f;
        protected final boolean g;
        protected b h;
        protected int i;
        protected z j;
        protected boolean k;
        protected transient com.fasterxml.jackson.a.h.c l;
        protected com.fasterxml.jackson.a.i m;

        @Override // com.fasterxml.jackson.a.k
        public int A() {
            return 0;
        }

        @Override // com.fasterxml.jackson.a.k
        public boolean B() {
            return false;
        }

        public a(b r3, com.fasterxml.jackson.a.o r4, boolean r5, boolean r6, com.fasterxml.jackson.a.m r7) {
            boolean r0 = false;
            super(0);
            this.m = null;
            this.h = r3;
            this.i = -1;
            this.f13080d = r4;
            this.j = z.a(r7);
            this.f13081e = r5;
            this.f = r6;
            if (r5 == true) goto L5;
            if (r6 == true) goto L5;
        L6:
            this.g = r0;
            return;
        L5:
            r0 = true;
            goto L6
        }

        public void a(com.fasterxml.jackson.a.i r1) {
            this.m = r1;
        }

        @Override // com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.o a() {
            return this.f13080d;
        }

        @Override // com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.h.i<com.fasterxml.jackson.a.r> c() {
            return f12135a;
        }

        @Override // com.fasterxml.jackson.a.k, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k == true) goto L6;
            this.k = true;
            return;
        }

        @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.n g() {
            if (this.k == true) goto L34;
            b r0 = this.h;
            if (r0 == null) goto L34;
            int r2 = this.i + 1;
            this.i = r2;
            if (r2 < 16) goto L12;
            this.i = 0;
            b r1 = r0.a();
            this.h = r1;
            if (r1 != null) goto L12;
            return null;
        L12:
            this.P = this.h.a(this.i);
            if (this.P != com.fasterxml.jackson.a.n.f) goto L20;
            Object r3 = X();
            if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L17;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        L18:
            this.j.a(r4);
        L33:
            return this.P;
        L17:
            r4 = r3.toString();
            goto L18
        L20:
            if (this.P != com.fasterxml.jackson.a.n.f12152b) goto L23;
            this.j = this.j.k();
            goto L33
        L23:
            if (this.P != com.fasterxml.jackson.a.n.f12154d) goto L26;
            this.j = this.j.j();
            goto L33
        L26:
            if (this.P != com.fasterxml.jackson.a.n.f12153c) goto L28;
        L31:
            this.j = this.j.l();
            goto L33
        L28:
            if (this.P == com.fasterxml.jackson.a.n.f12155e) goto L31;
            this.j.m();
        L34:
            return null;
        }

        @Override // com.fasterxml.jackson.a.k
        public String i() {
            if (this.k == true) goto L21;
            b r0 = this.h;
            if (r0 == null) goto L23;
            int r2 = this.i + 1;
            if (r2 >= 16) goto L18;
            if (r0.a(r2) != com.fasterxml.jackson.a.n.f) goto L18;
            this.i = r2;
            this.P = com.fasterxml.jackson.a.n.f;
            Object r1 = this.h.b(r2);
            if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L14;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        L15:
            this.j.a(r3);
            return r3;
        L14:
            r3 = r1.toString();
        L18:
            if (g() == com.fasterxml.jackson.a.n.f) goto L20;
            return null;
        L20:
            return w();
        L23:
            return null;
        L21:
            return null;
        }

        @Override // com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.m d() {
            return this.j;
        }

        @Override // com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.i f() {
            return e();
        }

        @Override // com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.i e() {
            com.fasterxml.jackson.a.i r0 = this.m;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return com.fasterxml.jackson.a.i.f12130a;
        }

        @Override // com.fasterxml.jackson.a.k
        public String w() {
            if (this.P == com.fasterxml.jackson.a.n.f12152b) goto L10;
            if (this.P == com.fasterxml.jackson.a.n.f12154d) goto L10;
            return this.j.h();
        L10:
            return this.j.a().h();
        }

        @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
        public String v() {
            return w();
        }

        @Override // com.fasterxml.jackson.a.a.c, com.fasterxml.jackson.a.k
        public String x() {
            if (this.P != com.fasterxml.jackson.a.n.h) goto L5;
        L19:
            Object r2 = X();
            if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L24;
            return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        L24:
            return h.b(r2);
        L5:
            if (this.P == com.fasterxml.jackson.a.n.f) goto L19;
            if (this.P != null) goto L11;
            return null;
        L11:
            int r0 = AnonymousClass1.f13078a[this.P.ordinal()];
            if (r0 == 7) goto L18;
            if (r0 == 8) goto L18;
            return this.P.b();
        L18:
            return h.b(X());
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
        public boolean t() {
            if (this.P != com.fasterxml.jackson.a.n.j) goto L21;
            Object r4 = X();
            if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L13;
            Double r5 = (Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.aiagent.plugin");
            if (r5.isNaN() == true) goto L11;
            if (r5.isInfinite() == true) goto L11;
            return false;
        L11:
            return true;
        L13:
            if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L22;
            Float r6 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin");
            if (r6.isNaN() == true) goto L19;
            if (r6.isInfinite() == true) goto L19;
            return false;
        L19:
            return true;
        L22:
            return false;
        L21:
            return false;
        }

        @Override // com.fasterxml.jackson.a.k
        public BigInteger J() {
            Number r0 = C();
            if (ZeusTransformUtils.instanceOf(r0, BigInteger.class) == false) goto L7;
            return (BigInteger) ZeusTransformUtils.preCheckCast(r0, BigInteger.class, "com.obric.aiagent.plugin");
        L7:
            if (E() != com.fasterxml.jackson.a.k.b.f) goto L11;
            return ((BigDecimal) ZeusTransformUtils.preCheckCast(r0, BigDecimal.class, "com.obric.aiagent.plugin")).toBigInteger();
        L11:
            return BigInteger.valueOf(r0.longValue());
        }

        @Override // com.fasterxml.jackson.a.k
        public BigDecimal M() {
            Number r0 = C();
            if (ZeusTransformUtils.instanceOf(r0, BigDecimal.class) == true) goto L5;
            int r3 = AnonymousClass1.f13079b[E().ordinal()];
            if (r3 == 1) goto L17;
            if (r3 == 2) goto L15;
            if (r3 == 5) goto L17;
            return BigDecimal.valueOf(r0.doubleValue());
        L15:
            return new BigDecimal((BigInteger) ZeusTransformUtils.preCheckCast(r0, BigInteger.class, "com.obric.aiagent.plugin"));
        L17:
            return BigDecimal.valueOf(r0.longValue());
        L5:
            return (BigDecimal) ZeusTransformUtils.preCheckCast(r0, BigDecimal.class, "com.obric.aiagent.plugin");
        }

        @Override // com.fasterxml.jackson.a.k
        public double L() {
            return C().doubleValue();
        }

        @Override // com.fasterxml.jackson.a.k
        public float K() {
            return C().floatValue();
        }

        @Override // com.fasterxml.jackson.a.k
        public int H() {
            if (this.P != com.fasterxml.jackson.a.n.i) goto L5;
            Number r0 = (Number) ZeusTransformUtils.preCheckCast(X(), Number.class, "com.obric.aiagent.plugin");
        L7:
            if (ZeusTransformUtils.instanceOf(r0, Integer.class) == true) goto L14;
            if (c(r0) == true) goto L14;
            return a(r0);
        L14:
            return r0.intValue();
        L5:
            r0 = C();
            goto L7
        }

        @Override // com.fasterxml.jackson.a.k
        public long I() {
            if (this.P != com.fasterxml.jackson.a.n.i) goto L5;
            Number r0 = (Number) ZeusTransformUtils.preCheckCast(X(), Number.class, "com.obric.aiagent.plugin");
        L7:
            if (ZeusTransformUtils.instanceOf(r0, Long.class) == true) goto L14;
            if (d(r0) == true) goto L14;
            return b(r0);
        L14:
            return r0.longValue();
        L5:
            r0 = C();
            goto L7
        }

        @Override // com.fasterxml.jackson.a.k
        public com.fasterxml.jackson.a.k.b E() {
            Number r1 = C();
            if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L7;
            return com.fasterxml.jackson.a.k.b.f12143a;
        L7:
            if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L11;
            return com.fasterxml.jackson.a.k.b.f12144b;
        L11:
            if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L15;
            return com.fasterxml.jackson.a.k.b.f12147e;
        L15:
            if (ZeusTransformUtils.instanceOf(r1, BigDecimal.class) == false) goto L19;
            return com.fasterxml.jackson.a.k.b.f;
        L19:
            if (ZeusTransformUtils.instanceOf(r1, BigInteger.class) == false) goto L23;
            return com.fasterxml.jackson.a.k.b.f12145c;
        L23:
            if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L27;
            return com.fasterxml.jackson.a.k.b.f12146d;
        L27:
            if (ZeusTransformUtils.instanceOf(r1, Short.class) == true) goto L29;
            return null;
        L29:
            return com.fasterxml.jackson.a.k.b.f12143a;
        }

        @Override // com.fasterxml.jackson.a.k
        public final Number C() {
            Y();
            Object r3 = X();
            if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L7;
            return (Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin");
        L7:
            if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L14;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
            if (r4.indexOf(46) < 0) goto L13;
            return Double.valueOf(Double.parseDouble(r4));
        L13:
            return Long.valueOf(Long.parseLong(r4));
        L14:
            if (r3 != null) goto L18;
            return null;
        L18:
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + r3.getClass().getName());
        }

        private final boolean c(Number r1) {
            if (ZeusTransformUtils.instanceOf(r1, Short.class) == false) goto L5;
        L8:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L8;
            return false;
        }

        private final boolean d(Number r1) {
            if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L5;
        L10:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, Short.class) == true) goto L10;
            if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L10;
            return false;
        }

        public int a(Number r5) {
            if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L9;
            long r0 = r5.longValue();
            int r6 = (int) r0;
            if (r6 == r0) goto L7;
            ar();
        L7:
            return r6;
        L9:
            if (ZeusTransformUtils.instanceOf(r5, BigInteger.class) == false) goto L16;
            BigInteger r1 = (BigInteger) ZeusTransformUtils.preCheckCast(r5, BigInteger.class, "com.obric.aiagent.plugin");
            if (H.compareTo(r1) <= 0) goto L13;
        L14:
            ar();
        L29:
            return r5.intValue();
        L13:
            if (I.compareTo(r1) >= 0) goto L29;
        L16:
            if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L18;
        L30:
            double r2 = r5.doubleValue();
            if (r2 >= (-2.147483648E9d)) goto L33;
        L34:
            ar();
        L36:
            return (int) r2;
        L33:
            if (r2 <= 2.147483647E9d) goto L36;
        L18:
            if (ZeusTransformUtils.instanceOf(r5, Float.class) == true) goto L30;
            if (ZeusTransformUtils.instanceOf(r5, BigDecimal.class) == false) goto L27;
            BigDecimal r3 = (BigDecimal) ZeusTransformUtils.preCheckCast(r5, BigDecimal.class, "com.obric.aiagent.plugin");
            if (N.compareTo(r3) <= 0) goto L25;
        L26:
            ar();
            goto L29
        L25:
            if (O.compareTo(r3) >= 0) goto L29;
        L27:
            au();
            goto L29
        }

        public long b(Number r5) {
            if (ZeusTransformUtils.instanceOf(r5, BigInteger.class) == false) goto L10;
            BigInteger r0 = (BigInteger) ZeusTransformUtils.preCheckCast(r5, BigInteger.class, "com.obric.aiagent.plugin");
            if (f11976J.compareTo(r0) <= 0) goto L7;
        L8:
            as();
        L23:
            return r5.longValue();
        L7:
            if (K.compareTo(r0) >= 0) goto L23;
        L10:
            if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L12;
        L24:
            double r1 = r5.doubleValue();
            if (r1 >= (-9.223372036854776E18d)) goto L27;
        L28:
            as();
        L30:
            return (long) r1;
        L27:
            if (r1 <= 9.223372036854776E18d) goto L30;
        L12:
            if (ZeusTransformUtils.instanceOf(r5, Float.class) == true) goto L24;
            if (ZeusTransformUtils.instanceOf(r5, BigDecimal.class) == false) goto L21;
            BigDecimal r2 = (BigDecimal) ZeusTransformUtils.preCheckCast(r5, BigDecimal.class, "com.obric.aiagent.plugin");
            if (L.compareTo(r2) <= 0) goto L19;
        L20:
            as();
            goto L23
        L19:
            if (M.compareTo(r2) >= 0) goto L23;
        L21:
            au();
            goto L23
        }

        @Override // com.fasterxml.jackson.a.k
        public Object N() {
            if (this.P == com.fasterxml.jackson.a.n.g) goto L5;
            return null;
        L5:
            return X();
        }

        @Override // com.fasterxml.jackson.a.k
        public byte[] a(com.fasterxml.jackson.a.a r4) {
            if (this.P != com.fasterxml.jackson.a.n.g) goto L9;
            Object r1 = X();
            if ((r1 instanceof byte[]) == false) goto L9;
            return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r1, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin");
        L9:
            if (this.P != com.fasterxml.jackson.a.n.h) goto L21;
            String r0 = x();
            if (r0 != null) goto L14;
            return null;
        L14:
            com.fasterxml.jackson.a.h.c r2 = this.l;
            if (r2 != null) goto L17;
            r2 = new com.fasterxml.jackson.a.h.c(100);
            this.l = r2;
        L18:
            a(r0, r2, r4);
            return r2.b();
        L17:
            r2.a();
            goto L18
        L21:
            throw b("Current token (" + this.P + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
        }

        @Override // com.fasterxml.jackson.a.k
        public int a(com.fasterxml.jackson.a.a r2, OutputStream r3) {
            byte[] r1 = a(r2);
            if (r1 == null) goto L6;
            r3.write(r1, 0, r1.length);
            return r1.length;
        L6:
            return 0;
        }

        @Override // com.fasterxml.jackson.a.k
        public boolean S() {
            return this.f;
        }

        @Override // com.fasterxml.jackson.a.k
        public boolean T() {
            return this.f13081e;
        }

        @Override // com.fasterxml.jackson.a.k
        public Object V() {
            return this.h.d(this.i);
        }

        @Override // com.fasterxml.jackson.a.k
        public Object U() {
            return this.h.c(this.i);
        }

        public final Object X() {
            return this.h.b(this.i);
        }

        public final void Y() {
            if (this.P == null) goto L8;
            if (this.P.d() == false) goto L8;
            return;
        L8:
            throw b("Current token (" + this.P + ") not numeric, cannot use numeric value accessors");
        }

        @Override // com.fasterxml.jackson.a.a.c
        public void ad() {
            au();
        }
    }

    /* JADX INFO: compiled from: TokenBuffer.java */
    protected static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.fasterxml.jackson.a.n[] f13082e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected b f13083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected long f13084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Object[] f13085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected TreeMap<Integer, Object> f13086d;

        private final int e(int r1) {
            return r1 + r1;
        }

        private final int f(int r1) {
            return (r1 + r1) + 1;
        }

        static {
            com.fasterxml.jackson.a.n[] r0 = new com.fasterxml.jackson.a.n[16];
            f13082e = r0;
            com.fasterxml.jackson.a.n[] r1 = com.fasterxml.jackson.a.n.values();
            System.arraycopy(r1, 1, r0, 1, Math.min(15, r1.length - 1));
        }

        public b() {
            this.f13085c = new Object[16];
        }

        public com.fasterxml.jackson.a.n a(int r3) {
            long r0 = this.f13084b;
            if (r3 <= 0) goto L5;
            r0 = r0 >> (r3 << 2);
        L5:
            com.fasterxml.jackson.a.n[] r4 = f13082e;
            return r4[((int) r0) & 15];
        }

        public Object b(int r1) {
            return this.f13085c[r1];
        }

        public b a() {
            return this.f13083a;
        }

        public boolean b() {
            if (this.f13086d == null) goto L5;
            return true;
        L5:
            return false;
        }

        public b a(int r2, com.fasterxml.jackson.a.n r3) {
            if (r2 >= 16) goto L6;
            b(r2, r3);
            return null;
        L6:
            b r4 = new b();
            this.f13083a = r4;
            r4.b(0, r3);
            return this.f13083a;
        }

        public b a(int r2, com.fasterxml.jackson.a.n r3, Object r4, Object r5) {
            if (r2 >= 16) goto L6;
            b(r2, r3, r4, r5);
            return null;
        L6:
            b r6 = new b();
            this.f13083a = r6;
            r6.b(0, r3, r4, r5);
            return this.f13083a;
        }

        public b a(int r2, com.fasterxml.jackson.a.n r3, Object r4) {
            if (r2 >= 16) goto L6;
            b(r2, r3, r4);
            return null;
        L6:
            b r5 = new b();
            this.f13083a = r5;
            r5.b(0, r3, r4);
            return this.f13083a;
        }

        public b a(int r7, com.fasterxml.jackson.a.n r8, Object r9, Object r10, Object r11) {
            if (r7 >= 16) goto L6;
            b(r7, r8, r9, r10, r11);
            return null;
        L6:
            b r0 = new b();
            this.f13083a = r0;
            r0.b(0, r8, r9, r10, r11);
            return this.f13083a;
        }

        private void b(int r3, com.fasterxml.jackson.a.n r4) {
            long r0 = r4.ordinal();
            if (r3 <= 0) goto L5;
            r0 = r0 << (r3 << 2);
        L5:
            this.f13084b |= r0;
        }

        private void b(int r5, com.fasterxml.jackson.a.n r6, Object r7, Object r8) {
            long r0 = r6.ordinal();
            if (r5 <= 0) goto L5;
            r0 = r0 << (r5 << 2);
        L5:
            this.f13084b = r0 | this.f13084b;
            a(r5, r7, r8);
        }

        private void b(int r3, com.fasterxml.jackson.a.n r4, Object r5) {
            this.f13085c[r3] = r5;
            long r6 = r4.ordinal();
            if (r3 <= 0) goto L5;
            r6 = r6 << (r3 << 2);
        L5:
            this.f13084b |= r6;
        }

        private void b(int r3, com.fasterxml.jackson.a.n r4, Object r5, Object r6, Object r7) {
            this.f13085c[r3] = r5;
            long r8 = r4.ordinal();
            if (r3 <= 0) goto L5;
            r8 = r8 << (r3 << 2);
        L5:
            this.f13084b = r8 | this.f13084b;
            a(r3, r6, r7);
        }

        private final void a(int r3, Object r4, Object r5) {
            if (this.f13086d != null) goto L5;
            this.f13086d = new TreeMap();
        L5:
            if (r4 == null) goto L7;
            this.f13086d.put(Integer.valueOf(f(r3)), r4);
        L7:
            if (r5 == null) goto L10;
            this.f13086d.put(Integer.valueOf(e(r3)), r5);
            return;
        }

        Object c(int r2) {
            TreeMap<Integer, Object> r0 = this.f13086d;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.get(Integer.valueOf(f(r2)));
        }

        Object d(int r2) {
            TreeMap<Integer, Object> r0 = this.f13086d;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.get(Integer.valueOf(e(r2)));
        }
    }

    @Override // com.fasterxml.jackson.a.h
    public boolean f() {
        return true;
    }

    @Override // com.fasterxml.jackson.a.h, java.io.Flushable
    public void flush() {
    }

    @Override // com.fasterxml.jackson.a.h
    public /* synthetic */ com.fasterxml.jackson.a.m a() {
        return r();
    }

    static {
        f13077e = com.fasterxml.jackson.a.h.a.a();
    }

    public y(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        boolean r0 = false;
        this.s = false;
        this.f = r3.a();
        this.g = r3.d();
        this.h = f13077e;
        this.t = com.fasterxml.jackson.a.e.e.b(null);
        b r1 = new b();
        this.o = r1;
        this.n = r1;
        this.p = 0;
        this.j = r3.T();
        boolean r5 = r3.S();
        this.k = r5;
        if (this.j == true) goto L7;
        if (r5 == true) goto L7;
        boolean r6 = false;
    L8:
        this.l = r6;
        if (r4 == null) goto L12;
        r0 = r4.a(com.fasterxml.jackson.databind.i.f12754a);
    L12:
        this.m = r0;
        return;
    L7:
        r6 = true;
        goto L8
    }

    public com.fasterxml.jackson.a.k o() {
        return a(this.f);
    }

    public com.fasterxml.jackson.a.k p() {
        com.fasterxml.jackson.a.k r1 = a(this.f);
        r1.g();
        return r1;
    }

    public com.fasterxml.jackson.a.k a(com.fasterxml.jackson.a.o r8) {
        return new a(this.n, r8, this.j, this.k, this.g);
    }

    public com.fasterxml.jackson.a.k d(com.fasterxml.jackson.a.k r8) {
        a r6 = new a(this.n, r8.a(), this.j, this.k, this.g);
        r6.a(r8.f());
        return r6;
    }

    public com.fasterxml.jackson.a.n q() {
        return this.n.a(0);
    }

    public y a(y r2) {
        if (this.j == true) goto L6;
        this.j = r2.e();
    L6:
        if (this.k == true) goto L9;
        this.k = r2.d();
    L9:
        if (this.j == false) goto L11;
    L14:
        boolean r0 = true;
    L15:
        this.l = r0;
        com.fasterxml.jackson.a.k r3 = r2.o();
    L17:
        if (r3.g() == null) goto L19;
        b(r3);
        goto L17
    L19:
        return this;
    L11:
        if (this.k == true) goto L14;
        r0 = false;
        goto L15
    }

    public void a(com.fasterxml.jackson.a.h r10) {
        b r0 = this.n;
        boolean r1 = this.l;
        if (r1 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        int r5 = -1;
    L9:
        r5 = r5 + 1;
        if (r5 < 16) goto L20;
        r0 = r0.a();
        if (r0 == null) goto L22;
        if (r1 == true) goto L16;
    L18:
        r4 = false;
    L19:
        r5 = 0;
        goto L20
    L16:
        if (r0.b() == false) goto L18;
        r4 = true;
        goto L19
    L22:
        return;
    L20:
        com.fasterxml.jackson.a.n r6 = r0.a(r5);
        if (r6 == null) goto L151;
        if (r4 == false) goto L31;
        Object r7 = r0.c(r5);
        if (r7 == null) goto L27;
        r10.e(r7);
    L27:
        Object r8 = r0.d(r5);
        if (r8 == null) goto L31;
        r10.g(r8);
    L31:
        switch(AnonymousClass1.f13078a[r6.ordinal()]) {
            case 1: goto L83;
            case 2: goto L82;
            case 3: goto L81;
            case 4: goto L80;
            case 5: goto L76;
            case 6: goto L72;
            case 7: goto L59;
            case 8: goto L44;
            case 9: goto L43;
            case 10: goto L42;
            case 11: goto L41;
            case 12: goto L34;
            default: goto L33;
        };
    L33:
        throw new RuntimeException("Internal error: should never end up through this code path");
    L41:
        r10.l();
        goto L9
    L42:
        r10.a(false);
        goto L9
    L43:
        r10.a(true);
        goto L9
    L44:
        Object r9 = r0.b(r5);
        if (ZeusTransformUtils.instanceOf(r9, Double.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r9, BigDecimal.class) == true) goto L49;
        if (ZeusTransformUtils.instanceOf(r9, Float.class) == true) goto L52;
        if (r9 == null) goto L54;
        if (ZeusTransformUtils.instanceOf(r9, String.class) == true) goto L57;
        g(String.format("Unrecognized value type for VALUE_NUMBER_FLOAT: %s, cannot serialize", new Object[]{r9.getClass().getName()}));
        goto L9
    L57:
        r10.e((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin"));
        goto L9
    L54:
        r10.l();
        goto L9
    L52:
        r10.a(((Float) ZeusTransformUtils.preCheckCast(r9, Float.class, "com.obric.aiagent.plugin")).floatValue());
        goto L9
    L49:
        r10.a((BigDecimal) ZeusTransformUtils.preCheckCast(r9, BigDecimal.class, "com.obric.aiagent.plugin"));
        goto L9
    L46:
        r10.a(((Double) ZeusTransformUtils.preCheckCast(r9, Double.class, "com.obric.aiagent.plugin")).doubleValue());
        goto L9
    L59:
        Object r11 = r0.b(r5);
        if (ZeusTransformUtils.instanceOf(r11, Integer.class) == true) goto L61;
        if (ZeusTransformUtils.instanceOf(r11, BigInteger.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r11, Long.class) == true) goto L67;
        if (ZeusTransformUtils.instanceOf(r11, Short.class) == true) goto L70;
        r10.d(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L9
    L70:
        r10.a(((Short) ZeusTransformUtils.preCheckCast(r11, Short.class, "com.obric.aiagent.plugin")).shortValue());
        goto L9
    L67:
        r10.b(((Long) ZeusTransformUtils.preCheckCast(r11, Long.class, "com.obric.aiagent.plugin")).longValue());
        goto L9
    L64:
        r10.a((BigInteger) ZeusTransformUtils.preCheckCast(r11, BigInteger.class, "com.obric.aiagent.plugin"));
        goto L9
    L61:
        r10.d(((Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.aiagent.plugin")).intValue());
        goto L9
    L72:
        Object r12 = r0.b(r5);
        if (ZeusTransformUtils.instanceOf(r12, com.fasterxml.jackson.a.q.class) == true) goto L74;
        r10.b((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"));
        goto L9
    L74:
        r10.c((com.fasterxml.jackson.a.q) ZeusTransformUtils.preCheckCast(r12, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin"));
        goto L9
    L76:
        Object r13 = r0.b(r5);
        if (ZeusTransformUtils.instanceOf(r13, com.fasterxml.jackson.a.q.class) == true) goto L78;
        r10.a((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"));
        goto L9
    L78:
        r10.b((com.fasterxml.jackson.a.q) ZeusTransformUtils.preCheckCast(r13, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin"));
        goto L9
    L80:
        r10.i();
        goto L9
    L81:
        r10.h();
        goto L9
    L82:
        r10.k();
        goto L9
    L83:
        r10.j();
        goto L9
    L34:
        Object r14 = r0.b(r5);
        if (ZeusTransformUtils.instanceOf(r14, u.class) == true) goto L36;
        if (ZeusTransformUtils.instanceOf(r14, com.fasterxml.jackson.databind.o.class) == true) goto L39;
        r10.d(r14);
        goto L9
    L39:
        r10.h(r14);
        goto L9
    L36:
        ((u) ZeusTransformUtils.preCheckCast(r14, u.class, "com.obric.aiagent.plugin")).a(r10);
        goto L9
    L151:
        return;
    L5:
        if (r0.b() == false) goto L7;
        r4 = true;
        goto L8
    }

    public y a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        if (r5.a(com.fasterxml.jackson.a.n.f) == true) goto L6;
        b(r5);
        return this;
    L6:
        j();
    L7:
        b(r5);
        com.fasterxml.jackson.a.n r0 = r5.g();
        if (r0 == com.fasterxml.jackson.a.n.f) goto L7;
        if (r0 == com.fasterxml.jackson.a.n.f12153c) goto L12;
        r6.a(y.class, com.fasterxml.jackson.a.n.f12153c, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + r0, new Object[0]);
    L12:
        k();
        return this;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[TokenBuffer: ");
        com.fasterxml.jackson.a.k r1 = o();
        int r3 = 0;
        if (this.j == false) goto L5;
    L8:
        boolean r2 = true;
    L28:
        com.fasterxml.jackson.a.n r4 = r1.g();     // Catch: IOException -> L25
        if (r4 == null) goto L12;
        if (r2 == false) goto L18;
        a(r0);     // Catch: IOException -> L25
    L18:
        if (r3 >= 100) goto L24;
        if (r3 <= 0) goto L21;
        r0.append(", ");     // Catch: IOException -> L25
    L21:
        r0.append(r4.toString());     // Catch: IOException -> L25
        if (r4 != com.fasterxml.jackson.a.n.f) goto L24;
        r0.append('(');     // Catch: IOException -> L25
        r0.append(r1.w());     // Catch: IOException -> L25
        r0.append(')');     // Catch: IOException -> L25
    L24:
        r3 = r3 + 1;
        goto L28
    L12:
        if (r3 < 100) goto L14;
        r0.append(" ... (truncated ").append(r3 - 100).append(" entries)");
    L14:
        r0.append(']');
        return r0.toString();
    L25:
        e = move-exception;
        throw new IllegalStateException(e);
    L5:
        if (this.k == true) goto L8;
        r2 = false;
        goto L28
    }

    private final void a(StringBuilder r4) {
        Object r0 = this.o.c(this.p - 1);
        if (r0 == null) goto L5;
        r4.append("[objectId=").append(String.valueOf(r0)).append(']');
    L5:
        Object r3 = this.o.d(this.p - 1);
        if (r3 == null) goto L9;
        r4.append("[typeId=").append(String.valueOf(r3)).append(']');
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public com.fasterxml.jackson.a.h a(com.fasterxml.jackson.a.h.a r2) {
        int r0 = this.h;
        this.h = (~r2.c()) & r0;
        return this;
    }

    @Override // com.fasterxml.jackson.a.h
    public boolean b(com.fasterxml.jackson.a.h.a r1) {
        if ((this.h & r1.c()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.h
    public int b() {
        return this.h;
    }

    @Override // com.fasterxml.jackson.a.h
    @Deprecated
    public com.fasterxml.jackson.a.h a(int r1) {
        this.h = r1;
        return this;
    }

    @Override // com.fasterxml.jackson.a.h
    public com.fasterxml.jackson.a.h a(int r3, int r4) {
        int r5 = r3 & r4;
        this.h = r5 | (b() & (~r4));
        return this;
    }

    public final com.fasterxml.jackson.a.e.e r() {
        return this.t;
    }

    @Override // com.fasterxml.jackson.a.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.i = true;
    }

    @Override // com.fasterxml.jackson.a.h
    public final void h() {
        this.t.o();
        b(com.fasterxml.jackson.a.n.f12154d);
        this.t = this.t.j();
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(Object r2) {
        this.t.o();
        b(com.fasterxml.jackson.a.n.f12154d);
        this.t = this.t.b(r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(Object r1, int r2) {
        this.t.o();
        b(com.fasterxml.jackson.a.n.f12154d);
        this.t = this.t.b(r1);
    }

    @Override // com.fasterxml.jackson.a.h
    public final void i() {
        c(com.fasterxml.jackson.a.n.f12155e);
        com.fasterxml.jackson.a.e.e r0 = this.t.l();
        if (r0 == null) goto L6;
        this.t = r0;
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public final void j() {
        this.t.o();
        b(com.fasterxml.jackson.a.n.f12152b);
        this.t = this.t.k();
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(Object r2) {
        this.t.o();
        b(com.fasterxml.jackson.a.n.f12152b);
        this.t = this.t.c(r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(Object r1, int r2) {
        this.t.o();
        b(com.fasterxml.jackson.a.n.f12152b);
        this.t = this.t.c(r1);
    }

    @Override // com.fasterxml.jackson.a.h
    public final void k() {
        c(com.fasterxml.jackson.a.n.f12153c);
        com.fasterxml.jackson.a.e.e r0 = this.t.l();
        if (r0 == null) goto L6;
        this.t = r0;
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public final void a(String r2) {
        this.t.a(r2);
        j(r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(com.fasterxml.jackson.a.q r3) {
        com.fasterxml.jackson.a.q r4 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
        this.t.a(r4.a());
        j(r4);
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(String r2) {
        if (r2 != null) goto L4;
        l();
        return;
    L4:
        a(com.fasterxml.jackson.a.n.h, r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(char[] r2, int r3, int r4) {
        b(new String(r2, r3, r4));
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(com.fasterxml.jackson.a.q r3) {
        com.fasterxml.jackson.a.q r4 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        l();
        return;
    L5:
        a(com.fasterxml.jackson.a.n.h, r4);
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(String r1) {
        n();
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(com.fasterxml.jackson.a.q r3) {
        com.fasterxml.jackson.a.q r4 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
        n();
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(char[] r1, int r2, int r3) {
        n();
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(char r1) {
        n();
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(String r3) {
        a(com.fasterxml.jackson.a.n.g, new u(r3));
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(short r2) {
        a(com.fasterxml.jackson.a.n.i, Short.valueOf(r2));
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(int r2) {
        a(com.fasterxml.jackson.a.n.i, Integer.valueOf(r2));
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(long r2) {
        a(com.fasterxml.jackson.a.n.i, Long.valueOf(r2));
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(double r2) {
        a(com.fasterxml.jackson.a.n.j, Double.valueOf(r2));
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(float r2) {
        a(com.fasterxml.jackson.a.n.j, Float.valueOf(r2));
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(BigDecimal r2) {
        if (r2 != null) goto L4;
        l();
        return;
    L4:
        a(com.fasterxml.jackson.a.n.j, r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(BigInteger r2) {
        if (r2 != null) goto L4;
        l();
        return;
    L4:
        a(com.fasterxml.jackson.a.n.i, r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void e(String r2) {
        a(com.fasterxml.jackson.a.n.j, r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(boolean r1) {
        if (r1 == false) goto L4;
        com.fasterxml.jackson.a.n r2 = com.fasterxml.jackson.a.n.k;
    L5:
        a(r2);
        return;
    L4:
        r2 = com.fasterxml.jackson.a.n.l;
        goto L5
    }

    @Override // com.fasterxml.jackson.a.h
    public void l() {
        a(com.fasterxml.jackson.a.n.m);
    }

    @Override // com.fasterxml.jackson.a.h
    public void h(Object r3) {
        if (r3 != null) goto L6;
        l();
        return;
    L6:
        if (r3.getClass() != byte[].class) goto L8;
    L15:
        a(com.fasterxml.jackson.a.n.g, r3);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, u.class) == true) goto L15;
        com.fasterxml.jackson.a.o r0 = this.f;
        if (r0 != null) goto L13;
        a(com.fasterxml.jackson.a.n.g, r3);
        return;
    L13:
        r0.a(this, r3);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(com.fasterxml.jackson.a.a r2, byte[] r3, int r4, int r5) {
        byte[] r6 = new byte[r5];
        System.arraycopy(r3, r4, r6, 0, r5);
        h(r6);
    }

    @Override // com.fasterxml.jackson.a.h
    public int a(com.fasterxml.jackson.a.a r1, InputStream r2, int r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fasterxml.jackson.a.h
    public boolean e() {
        return this.j;
    }

    @Override // com.fasterxml.jackson.a.h
    public boolean d() {
        return this.k;
    }

    @Override // com.fasterxml.jackson.a.h
    public void g(Object r1) {
        this.q = r1;
        this.s = true;
    }

    @Override // com.fasterxml.jackson.a.h
    public void e(Object r1) {
        this.r = r1;
        this.s = true;
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(Object r2) {
        a(com.fasterxml.jackson.a.n.g, r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(com.fasterxml.jackson.a.k r4) {
        if (this.l == false) goto L6;
        f(r4);
    L6:
        switch(AnonymousClass1.f13078a[r4.l().ordinal()]) {
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L31;
            case 7: goto L23;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L9:
        h(r4.N());
        return;
    L10:
        l();
        return;
    L11:
        a(false);
        return;
    L12:
        a(true);
        return;
    L23:
        int r0 = AnonymousClass1.f13079b[r4.E().ordinal()];
        if (r0 != 1) goto L26;
        d(r4.H());
        return;
    L26:
        if (r0 == 2) goto L28;
        b(r4.I());
        return;
    L28:
        a(r4.J());
        return;
    L34:
        a(r4.w());
        return;
    L35:
        i();
        return;
    L36:
        h();
        return;
    L37:
        k();
        return;
    L38:
        j();
        return;
    L8:
        throw new RuntimeException("Internal error: unexpected token: " + r4.l());
    L14:
        if (this.m == false) goto L16;
        a(r4.M());
        return;
    L16:
        int r1 = AnonymousClass1.f13079b[r4.E().ordinal()];
        if (r1 != 3) goto L19;
        a(r4.M());
        return;
    L19:
        if (r1 == 4) goto L21;
        a(r4.L());
        return;
    L21:
        a(r4.K());
        return;
    L31:
        if (r4.B() == false) goto L33;
        a(r4.y(), r4.A(), r4.z());
        return;
    L33:
        b(r4.x());
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(com.fasterxml.jackson.a.k r4) {
        com.fasterxml.jackson.a.n r0 = r4.l();
        if (r0 == com.fasterxml.jackson.a.n.f) goto L5;
        if (r0 == null) goto L30;
    L9:
        int r1 = AnonymousClass1.f13078a[r0.ordinal()];
        if (r1 == 1) goto L25;
        if (r1 != 2) goto L14;
        k();
        return;
    L14:
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        a(r4, r0);
        return;
    L18:
        i();
        return;
    L20:
        if (this.l == false) goto L22;
        f(r4);
    L22:
        h();
        e(r4);
        return;
    L25:
        if (this.l == false) goto L27;
        f(r4);
    L27:
        j();
        e(r4);
        return;
    L30:
        throw new IllegalStateException("No token available from argument `JsonParser`");
    L5:
        if (this.l == false) goto L7;
        f(r4);
    L7:
        a(r4.w());
        r0 = r4.g();
        goto L9
    }

    public void e(com.fasterxml.jackson.a.k r6) {
        int r1 = 1;
    L3:
        com.fasterxml.jackson.a.n r2 = r6.g();
        if (r2 == null) goto L35;
        int r3 = AnonymousClass1.f13078a[r2.ordinal()];
        if (r3 == 1) goto L31;
        if (r3 != 2) goto L10;
        k();
        r1 = r1 - 1;
        if (r1 != 0) goto L3;
        return;
    L10:
        if (r3 != 3) goto L12;
        if (this.l == false) goto L26;
        f(r6);
    L26:
        h();
    L34:
        r1 = r1 + 1;
        goto L3
    L12:
        if (r3 != 4) goto L14;
        i();
        r1 = r1 - 1;
        if (r1 != 0) goto L3;
        return;
    L14:
        if (r3 != 5) goto L15;
        if (this.l == false) goto L19;
        f(r6);
    L19:
        a(r6.w());
        goto L3
    L15:
        a(r6, r2);
        goto L3
    L31:
        if (this.l == false) goto L33;
        f(r6);
    L33:
        j();
        goto L34
    }

    private void a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.a.n r4) {
        if (this.l == false) goto L6;
        f(r3);
    L6:
        switch(AnonymousClass1.f13078a[r4.ordinal()]) {
            case 6: goto L25;
            case 7: goto L17;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L9:
        h(r3.N());
        return;
    L10:
        l();
        return;
    L11:
        a(false);
        return;
    L12:
        a(true);
        return;
    L17:
        int r5 = AnonymousClass1.f13079b[r3.E().ordinal()];
        if (r5 != 1) goto L20;
        d(r3.H());
        return;
    L20:
        if (r5 == 2) goto L22;
        b(r3.I());
        return;
    L22:
        a(r3.J());
        return;
    L8:
        throw new RuntimeException("Internal error: unexpected token: " + r4);
    L14:
        if (this.m == false) goto L16;
        a(r3.M());
        return;
    L16:
        a(com.fasterxml.jackson.a.n.j, r3.D());
        return;
    L25:
        if (r3.B() == false) goto L27;
        a(r3.y(), r3.A(), r3.z());
        return;
    L27:
        b(r3.x());
    }

    private final void f(com.fasterxml.jackson.a.k r3) {
        Object r0 = r3.V();
        this.q = r0;
        if (r0 == null) goto L5;
        this.s = true;
    L5:
        Object r4 = r3.U();
        this.r = r4;
        if (r4 == null) goto L9;
        this.s = true;
        return;
    }

    public final void a(com.fasterxml.jackson.a.n r5) {
        this.t.o();
        if (this.s == false) goto L5;
        b r6 = this.o.a(this.p, r5, this.r, this.q);
    L7:
        if (r6 != null) goto L9;
        this.p++;
        return;
    L9:
        this.o = r6;
        this.p = 1;
        return;
    L5:
        r6 = this.o.a(this.p, r5);
        goto L7
    }

    public final void a(com.fasterxml.jackson.a.n r8, Object r9) {
        this.t.o();
        if (this.s == false) goto L5;
        b r10 = this.o.a(this.p, r8, r9, this.r, this.q);
    L7:
        if (r10 != null) goto L9;
        this.p++;
        return;
    L9:
        this.o = r10;
        this.p = 1;
        return;
    L5:
        r10 = this.o.a(this.p, r8, r9);
        goto L7
    }

    public final void j(Object r8) {
        if (this.s == false) goto L5;
        b r9 = this.o.a(this.p, com.fasterxml.jackson.a.n.f, r8, this.r, this.q);
    L7:
        if (r9 != null) goto L9;
        this.p++;
        return;
    L9:
        this.o = r9;
        this.p = 1;
        return;
    L5:
        r9 = this.o.a(this.p, com.fasterxml.jackson.a.n.f, r8);
        goto L7
    }

    public final void b(com.fasterxml.jackson.a.n r5) {
        if (this.s == false) goto L5;
        b r6 = this.o.a(this.p, r5, this.r, this.q);
    L7:
        if (r6 != null) goto L9;
        this.p++;
        return;
    L9:
        this.o = r6;
        this.p = 1;
        return;
    L5:
        r6 = this.o.a(this.p, r5);
        goto L7
    }

    public final void c(com.fasterxml.jackson.a.n r3) {
        b r4 = this.o.a(this.p, r3);
        if (r4 != null) goto L5;
        this.p++;
        return;
    L5:
        this.o = r4;
        this.p = 1;
    }

    @Override // com.fasterxml.jackson.a.h
    public void n() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }
}
