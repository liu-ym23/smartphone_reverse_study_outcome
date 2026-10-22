package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: JsonGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.a.h.i<s> f12077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.a.h.i<s> f12078b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final com.fasterxml.jackson.a.h.i<s> f12079c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected p f12080d;

    /* JADX INFO: renamed from: com.fasterxml.jackson.a.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: JsonGenerator.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12081a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.a.g.b.a.values().length];
            f12081a = r0;
            r0[com.fasterxml.jackson.a.g.b.a.f12076e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f12081a[com.fasterxml.jackson.a.g.b.a.f12075d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f12081a[com.fasterxml.jackson.a.g.b.a.f12074c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f12081a[com.fasterxml.jackson.a.g.b.a.f12073b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f12081a[com.fasterxml.jackson.a.g.b.a.f12072a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    /* JADX INFO: compiled from: JsonGenerator.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12082a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12083b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12084c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public static final a f12085d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public static final a f12086e = null;

        @Deprecated
        public static final a f = null;

        @Deprecated
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        private static final /* synthetic */ a[] m = null;
        private final boolean k;
        private final int l;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(m.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("AUTO_CLOSE_TARGET", 0, true);
            f12082a = r0;
            a r1 = new a("AUTO_CLOSE_JSON_CONTENT", 1, true);
            f12083b = r1;
            a r4 = new a("FLUSH_PASSED_TO_STREAM", 2, true);
            f12084c = r4;
            a r5 = new a("QUOTE_FIELD_NAMES", 3, true);
            f12085d = r5;
            a r7 = new a("QUOTE_NON_NUMERIC_NUMBERS", 4, true);
            f12086e = r7;
            a r9 = new a("ESCAPE_NON_ASCII", 5, false);
            f = r9;
            a r11 = new a("WRITE_NUMBERS_AS_STRINGS", 6, false);
            g = r11;
            a r13 = new a("WRITE_BIGDECIMAL_AS_PLAIN", 7, false);
            h = r13;
            a r15 = new a("STRICT_DUPLICATE_DETECTION", 8, false);
            i = r15;
            a r14 = new a("IGNORE_UNKNOWN", 9, false);
            j = r14;
            m = new a[]{r0, r1, r4, r5, r7, r9, r11, r13, r15, r14};
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
            this.k = r3;
            this.l = 1 << ordinal();
        }

        public boolean b() {
            return this.k;
        }

        public boolean a(int r1) {
            if ((this.l & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int c() {
            return this.l;
        }
    }

    public abstract int a(com.fasterxml.jackson.a.a r1, InputStream r2, int r3);

    @Deprecated
    public abstract h a(int r1);

    public h a(com.fasterxml.jackson.a.d.c r1) {
        return this;
    }

    public abstract h a(a r1);

    public abstract m a();

    public abstract void a(char r1);

    public abstract void a(double r1);

    public abstract void a(float r1);

    public abstract void a(com.fasterxml.jackson.a.a r1, byte[] r2, int r3, int r4);

    public abstract void a(String r1);

    public abstract void a(BigDecimal r1);

    public abstract void a(BigInteger r1);

    public abstract void a(boolean r1);

    public abstract void a(char[] r1, int r2, int r3);

    public abstract int b();

    public h b(int r1) {
        return this;
    }

    public h b(int r1, int r2) {
        return this;
    }

    public abstract void b(long r1);

    public abstract void b(q r1);

    public abstract void b(String r1);

    public abstract void b(char[] r1, int r2, int r3);

    public abstract boolean b(a r1);

    public abstract void c(q r1);

    public abstract void c(String r1);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract void d(int r1);

    public abstract void d(String r1);

    public boolean d() {
        return false;
    }

    public abstract void e(String r1);

    public boolean e() {
        return false;
    }

    public void f(String r1) {
    }

    public boolean f() {
        return false;
    }

    public abstract void flush();

    public boolean g() {
        return true;
    }

    public abstract void h();

    public abstract void h(Object r1);

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    static {
        com.fasterxml.jackson.a.h.i<s> r0 = com.fasterxml.jackson.a.h.i.a(s.values());
        f12077a = r0;
        f12078b = r0.a(s.f12164b);
        f12079c = r0.a(s.f12163a);
    }

    public h() {
    }

    public void a(Object r1) {
        m r0 = a();
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public h a(int r3, int r4) {
        int r5 = r3 & r4;
        return a(r5 | (b() & (~r4)));
    }

    public void a(d r4) {
        throw new UnsupportedOperationException(String.format("Generator of type %s does not support schema of type '%s'", new Object[]{getClass().getName(), ((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")).a()}));
    }

    public h a(p r3) {
        this.f12080d = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        return this;
    }

    public p c() {
        return this.f12080d;
    }

    public h a(q r2) {
        q r1 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void c(int r1) {
        h();
    }

    public void b(Object r1) {
        h();
        a(r1);
    }

    public void a(Object r1, int r2) {
        c(r2);
        a(r1);
    }

    public void c(Object r1) {
        j();
        a(r1);
    }

    public void b(Object r1, int r2) {
        j();
        a(r1);
    }

    public void a(long r1) {
        a(Long.toString(r1));
    }

    public void a(int[] r2, int r3, int r4) {
        if (r2 == null) goto L9;
        a(r2.length, r3, r4);
        a(r2, r4);
        int r5 = r4 + r3;
    L4:
        if (r3 >= r5) goto L6;
        d(r2[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        i();
        return;
    L9:
        throw new IllegalArgumentException("null array");
    }

    public void a(long[] r3, int r4, int r5) {
        if (r3 == null) goto L9;
        a(r3.length, r4, r5);
        a(r3, r5);
        int r6 = r5 + r4;
    L4:
        if (r4 >= r6) goto L6;
        b(r3[r4]);
        r4 = r4 + 1;
        goto L4
    L6:
        i();
        return;
    L9:
        throw new IllegalArgumentException("null array");
    }

    public void a(double[] r3, int r4, int r5) {
        if (r3 == null) goto L9;
        a(r3.length, r4, r5);
        a(r3, r5);
        int r6 = r5 + r4;
    L4:
        if (r4 >= r6) goto L6;
        a(r3[r4]);
        r4 = r4 + 1;
        goto L4
    L6:
        i();
        return;
    L9:
        throw new IllegalArgumentException("null array");
    }

    public void d(q r3) {
        c(((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin")).a());
    }

    public void e(q r3) {
        d(((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin")).a());
    }

    public void a(byte[] r2, int r3, int r4) {
        a(b.a(), r2, r3, r4);
    }

    public void a(byte[] r4) {
        a(b.a(), r4, 0, r4.length);
    }

    public int a(InputStream r2, int r3) {
        return a(b.a(), r2, r3);
    }

    public void a(short r1) {
        d(r1);
    }

    public void d(Object r4) {
        if (r4 != null) goto L7;
        l();
        return;
    L7:
        if ((r4 instanceof byte[]) == false) goto L11;
        a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"));
        return;
    L11:
        throw new g("No native support for writing embedded objects of type " + r4.getClass().getName(), this);
    }

    public void e(Object r2) {
        throw new g("No native support for writing Object Ids", this);
    }

    public void f(Object r2) {
        throw new g("No native support for writing Object Ids", this);
    }

    public void g(Object r2) {
        throw new g("No native support for writing Type Ids", this);
    }

    public com.fasterxml.jackson.a.g.b a(com.fasterxml.jackson.a.g.b r6) {
        Object r0 = r6.f12069c;
        n r1 = r6.f;
        if (e() == false) goto L6;
        r6.g = false;
        g(r0);
    L27:
        if (r1 != n.f12152b) goto L30;
        c(r6.f12067a);
    L32:
        return r6;
    L30:
        if (r1 != n.f12154d) goto L32;
        h();
        goto L32
    L6:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L9:
        r6.g = true;
        com.fasterxml.jackson.a.g.b.a r3 = r6.f12071e;
        if (r1 != n.f12152b) goto L12;
    L14:
        int r4 = AnonymousClass1.f12081a[r3.ordinal()];
        if (r4 == 1) goto L27;
        if (r4 == 2) goto L27;
        if (r4 != 3) goto L21;
        c(r6.f12067a);
        a(r6.f12070d, r2);
        return r6;
    L21:
        if (r4 == 4) goto L23;
        h();
        b(r2);
        goto L27
    L23:
        j();
        a(r2);
        goto L27
    L12:
        if (r3.a() == false) goto L14;
        r3 = com.fasterxml.jackson.a.g.b.a.f12072a;
        r6.f12071e = r3;
        goto L14
    L8:
        r2 = String.valueOf(r0);
        goto L9
    }

    public com.fasterxml.jackson.a.g.b b(com.fasterxml.jackson.a.g.b r4) {
        n r0 = r4.f;
        if (r0 != n.f12152b) goto L6;
        k();
    L9:
        if (r4.g == false) goto L25;
        int r1 = AnonymousClass1.f12081a[r4.f12071e.ordinal()];
        if (r1 != 1) goto L13;
        Object r2 = r4.f12069c;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L23;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L24:
        a(r4.f12070d, r3);
        goto L25
    L23:
        r3 = String.valueOf(r2);
        goto L24
    L13:
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L25;
        if (r1 == 5) goto L19;
        k();
        goto L25
    L19:
        i();
    L25:
        return r4;
    L6:
        if (r0 != n.f12154d) goto L9;
        i();
        goto L9
    }

    public void a(String r1, String r2) {
        a(r1);
        b(r2);
    }

    public void a(k r3) {
        n r0 = r3.l();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        switch(r1) {
            case -1: goto L36;
            case 0: goto L8;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L28;
            case 7: goto L20;
            case 8: goto L13;
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
    L13:
        k.b r2 = r3.E();
        if (r2 != k.b.f) goto L17;
        a(r3.M());
        return;
    L17:
        if (r2 != k.b.f12146d) goto L19;
        a(r3.K());
        return;
    L19:
        a(r3.L());
        return;
    L20:
        k.b r4 = r3.E();
        if (r4 != k.b.f12143a) goto L24;
        d(r3.H());
        return;
    L24:
        if (r4 != k.b.f12145c) goto L26;
        a(r3.J());
        return;
    L26:
        b(r3.I());
        return;
    L31:
        a(r3.v());
        return;
    L32:
        i();
        return;
    L33:
        h();
        return;
    L34:
        k();
        return;
    L35:
        j();
        return;
    L36:
        g("No current event to copy");
        return;
    L8:
        throw new IllegalStateException("Internal error: unknown current token, " + r0);
    L28:
        if (r3.B() == false) goto L30;
        a(r3.y(), r3.A(), r3.z());
        return;
    L30:
        b(r3.x());
        return;
    L5:
        r1 = r0.a();
        goto L6
    }

    public void b(k r4) {
        n r0 = r4.l();
        int r1 = -1;
        if (r0 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 != 5) goto L14;
        a(r4.v());
        n r3 = r4.g();
        if (r3 == null) goto L12;
        r1 = r3.a();
    L12:
        r2 = r1;
    L14:
        if (r2 != 1) goto L16;
        j();
        c(r4);
        return;
    L16:
        if (r2 == 3) goto L19;
        a(r4);
        return;
    L19:
        h();
        c(r4);
        return;
    L5:
        r2 = r0.a();
        goto L7
    }

    public void c(k r6) {
        int r1 = 1;
    L3:
        n r2 = r6.g();
        if (r2 == null) goto L41;
        switch(r2.a()) {
            case 1: goto L39;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L28;
            case 7: goto L20;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L8:
        throw new IllegalStateException("Internal error: unknown current token, " + r2);
    L10:
        l();
        goto L3
    L11:
        a(false);
        goto L3
    L12:
        a(true);
        goto L3
    L13:
        k.b r3 = r6.E();
        if (r3 == k.b.f) goto L15;
        if (r3 == k.b.f12146d) goto L18;
        a(r6.L());
        goto L3
    L18:
        a(r6.K());
        goto L3
    L15:
        a(r6.M());
        goto L3
    L20:
        k.b r4 = r6.E();
        if (r4 == k.b.f12143a) goto L22;
        if (r4 == k.b.f12145c) goto L25;
        b(r6.I());
        goto L3
    L25:
        a(r6.J());
        goto L3
    L22:
        d(r6.H());
        goto L3
    L28:
        if (r6.B() == true) goto L29;
        b(r6.x());
        goto L3
    L29:
        a(r6.y(), r6.A(), r6.z());
        goto L3
    L31:
        a(r6.v());
        goto L3
    L32:
        i();
        r1 = r1 - 1;
        if (r1 != 0) goto L3;
        return;
    L35:
        h();
    L40:
        r1 = r1 + 1;
        goto L3
    L36:
        k();
        r1 = r1 - 1;
        if (r1 != 0) goto L3;
        return;
    L39:
        j();
        goto L40
    L9:
        h(r6.N());
        goto L3
    }

    public void g(String r2) {
        throw new g(r2, this);
    }

    public final void m() {
        com.fasterxml.jackson.a.h.q.a();
    }

    public void n() {
        throw new UnsupportedOperationException("Operation not supported by generator of type " + getClass().getName());
    }

    public final void a(int r3, int r4, int r5) {
        if (r4 < 0) goto L7;
        if ((r4 + r5) > r3) goto L7;
        return;
    L7:
        throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", new Object[]{Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r3)}));
    }

    public void i(Object r4) {
        if (r4 != null) goto L7;
        l();
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        b((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L53;
        Number r0 = (Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == false) goto L17;
        d(r0.intValue());
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r0, Long.class) == false) goto L21;
        b(r0.longValue());
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r0, Double.class) == false) goto L25;
        a(r0.doubleValue());
        return;
    L25:
        if (ZeusTransformUtils.instanceOf(r0, Float.class) == false) goto L29;
        a(r0.floatValue());
        return;
    L29:
        if (ZeusTransformUtils.instanceOf(r0, Short.class) == false) goto L33;
        a(r0.shortValue());
        return;
    L33:
        if (ZeusTransformUtils.instanceOf(r0, Byte.class) == false) goto L37;
        a(r0.byteValue());
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r0, BigInteger.class) == false) goto L41;
        a((BigInteger) ZeusTransformUtils.preCheckCast(r0, BigInteger.class, "com.obric.aiagent.plugin"));
        return;
    L41:
        if (ZeusTransformUtils.instanceOf(r0, BigDecimal.class) == false) goto L45;
        a((BigDecimal) ZeusTransformUtils.preCheckCast(r0, BigDecimal.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        if (ZeusTransformUtils.instanceOf(r0, AtomicInteger.class) == false) goto L49;
        d(((AtomicInteger) ZeusTransformUtils.preCheckCast(r0, AtomicInteger.class, "com.obric.aiagent.plugin")).get());
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r0, AtomicLong.class) == false) goto L65;
        b(((AtomicLong) ZeusTransformUtils.preCheckCast(r0, AtomicLong.class, "com.obric.aiagent.plugin")).get());
        return;
    L65:
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + r4.getClass().getName() + ")");
    L53:
        if ((r4 instanceof byte[]) == false) goto L57;
        a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"));
        return;
    L57:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L61;
        a(((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L61:
        if (ZeusTransformUtils.instanceOf(r4, AtomicBoolean.class) == false) goto L65;
        a(((AtomicBoolean) ZeusTransformUtils.preCheckCast(r4, AtomicBoolean.class, "com.obric.aiagent.plugin")).get());
    }
}
