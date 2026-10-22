package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: JsonParser.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.a.h.i<r> f12135a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f12136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected transient com.fasterxml.jackson.a.h.m f12137c;

    /* JADX INFO: compiled from: JsonParser.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12138a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12139b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12140c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12141d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f12142e = null;

        @Deprecated
        public static final a f = null;

        @Deprecated
        public static final a g = null;

        @Deprecated
        public static final a h = null;

        @Deprecated
        public static final a i = null;

        @Deprecated
        public static final a j = null;

        @Deprecated
        public static final a k = null;

        @Deprecated
        public static final a l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        private static final /* synthetic */ a[] r = null;
        private final boolean p;
        private final int q;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(r.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("AUTO_CLOSE_SOURCE", 0, true);
            f12138a = r0;
            a r1 = new a("ALLOW_COMMENTS", 1, false);
            f12139b = r1;
            a r4 = new a("ALLOW_YAML_COMMENTS", 2, false);
            f12140c = r4;
            a r5 = new a("ALLOW_UNQUOTED_FIELD_NAMES", 3, false);
            f12141d = r5;
            a r7 = new a("ALLOW_SINGLE_QUOTES", 4, false);
            f12142e = r7;
            a r9 = new a("ALLOW_UNQUOTED_CONTROL_CHARS", 5, false);
            f = r9;
            a r11 = new a("ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER", 6, false);
            g = r11;
            a r13 = new a("ALLOW_NUMERIC_LEADING_ZEROS", 7, false);
            h = r13;
            a r15 = new a("ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS", 8, false);
            i = r15;
            a r14 = new a("ALLOW_NON_NUMERIC_NUMBERS", 9, false);
            j = r14;
            a r12 = new a("ALLOW_MISSING_VALUES", 10, false);
            k = r12;
            a r10 = new a("ALLOW_TRAILING_COMMA", 11, false);
            l = r10;
            a r8 = new a("STRICT_DUPLICATE_DETECTION", 12, false);
            m = r8;
            a r6 = new a("IGNORE_UNDEFINED", 13, false);
            n = r6;
            a r3 = new a("INCLUDE_SOURCE_IN_LOCATION", 14, true);
            o = r3;
            r = new a[]{r0, r1, r4, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r3};
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
            this.q = 1 << ordinal();
            this.p = r3;
        }

        public boolean b() {
            return this.p;
        }

        public boolean a(int r1) {
            if ((this.q & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int c() {
            return this.q;
        }
    }

    /* JADX INFO: compiled from: JsonParser.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12143a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12144b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12145c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f12146d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f12147e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] g = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("INT", 0);
            f12143a = r0;
            b r1 = new b("LONG", 1);
            f12144b = r1;
            b r3 = new b("BIG_INTEGER", 2);
            f12145c = r3;
            b r5 = new b("FLOAT", 3);
            f12146d = r5;
            b r7 = new b("DOUBLE", 4);
            f12147e = r7;
            b r9 = new b("BIG_DECIMAL", 5);
            f = r9;
            g = new b[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public abstract int A();

    public abstract boolean B();

    public abstract Number C();

    public abstract b E();

    public abstract int H();

    public abstract long I();

    public abstract BigInteger J();

    public abstract float K();

    public abstract double L();

    public abstract BigDecimal M();

    public Object N() {
        return null;
    }

    public boolean S() {
        return false;
    }

    public boolean T() {
        return false;
    }

    public Object U() {
        return null;
    }

    public Object V() {
        return null;
    }

    public long a(long r1) {
        return r1;
    }

    public abstract o a();

    public abstract String a(String r1);

    public abstract boolean a(n r1);

    public abstract byte[] a(com.fasterxml.jackson.a.a r1);

    public k b(int r1, int r2) {
        return this;
    }

    public boolean b() {
        return false;
    }

    public abstract boolean b(int r1);

    public int c(int r1) {
        return r1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract m d();

    public abstract i e();

    public abstract i f();

    public abstract n g();

    public abstract n h();

    public abstract k k();

    public abstract n n();

    @Deprecated
    public abstract int o();

    public abstract boolean p();

    public boolean t() {
        return false;
    }

    public abstract void u();

    public abstract String v();

    public abstract String x();

    public abstract char[] y();

    public abstract int z();

    static {
        f12135a = com.fasterxml.jackson.a.h.i.a(r.values());
    }

    public k() {
    }

    public k(int r1) {
        this.f12136b = r1;
    }

    public com.fasterxml.jackson.a.h.i<r> c() {
        return f12135a;
    }

    public void a(Object r1) {
        m r0 = d();
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public boolean a(a r1) {
        return r1.a(this.f12136b);
    }

    @Deprecated
    public k a(int r1) {
        this.f12136b = r1;
        return this;
    }

    public k a(int r3, int r4) {
        int r5 = r3 & r4;
        return a(r5 | (this.f12136b & (~r4)));
    }

    public String i() {
        if (g() == n.f) goto L7;
        return null;
    L7:
        return v();
    }

    public String j() {
        if (g() == n.h) goto L7;
        return null;
    L7:
        return x();
    }

    public n l() {
        return n();
    }

    public int m() {
        return o();
    }

    public boolean q() {
        if (l() != n.f12154d) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean r() {
        if (l() != n.f12152b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s() {
        if (l() != n.i) goto L5;
        return true;
    L5:
        return false;
    }

    public String w() {
        return v();
    }

    public Number D() {
        return C();
    }

    public byte F() {
        int r0 = H();
        if (r0 < (-128)) goto L9;
        if (r0 > 255) goto L9;
        return (byte) r0;
    L9:
        throw new com.fasterxml.jackson.a.b.a(this, String.format("Numeric value (%s) out of range of Java byte", new Object[]{x()}), n.i, Byte.TYPE);
    }

    public short G() {
        int r0 = H();
        if (r0 < (-32768)) goto L9;
        if (r0 > 32767) goto L9;
        return (short) r0;
    L9:
        throw new com.fasterxml.jackson.a.b.a(this, String.format("Numeric value (%s) out of range of Java short", new Object[]{x()}), n.i, Short.TYPE);
    }

    public byte[] O() {
        return a(com.fasterxml.jackson.a.b.a());
    }

    public int a(com.fasterxml.jackson.a.a r1, OutputStream r2) {
        W();
        return 0;
    }

    public int P() {
        return c(0);
    }

    public long Q() {
        return a(0);
    }

    public String R() {
        return a(null);
    }

    public j b(String r2) {
        return new j(this, r2).a(this.f12137c);
    }

    public void W() {
        throw new UnsupportedOperationException("Operation not supported by parser of type " + getClass().getName());
    }
}
