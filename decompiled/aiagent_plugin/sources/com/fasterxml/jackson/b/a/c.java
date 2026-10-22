package com.fasterxml.jackson.b.a;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.fasterxml.jackson.a.d.e;
import com.fasterxml.jackson.a.o;
import com.fasterxml.jackson.a.p;
import com.fasterxml.jackson.a.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import org.c.a.d.f;
import org.c.a.d.g;
import org.c.a.d.h;
import org.c.a.d.i;
import org.c.a.d.j;
import org.c.a.d.l;
import org.c.a.d.m;
import org.c.a.d.n;

/* JADX INFO: compiled from: YAMLGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends com.fasterxml.jackson.a.a.a {
    private static final org.c.a.a.d A = null;
    private static final h B = null;
    private static final h C = null;
    protected static final Pattern k = null;
    protected static final String l = null;
    private static final org.c.a.a.d v = null;
    private static final org.c.a.a.d w = null;
    private static final org.c.a.a.d x = null;
    private static final org.c.a.a.d y = null;
    private static final org.c.a.a.d z = null;
    protected final e m;
    protected int n;
    protected Writer o;
    protected org.c.a.a p;
    protected final org.c.a.a.e q;
    protected org.c.a.b.a r;
    protected String s;
    protected String t;
    protected final com.fasterxml.jackson.b.a.b.a u;

    /* JADX INFO: compiled from: YAMLGenerator.java */
    public static final enum a extends Enum<a> implements com.fasterxml.jackson.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12171a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12172b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12173c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12174d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f12175e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        public static final a k = null;
        private static final /* synthetic */ a[] n = null;
        protected final boolean l;
        protected final int m;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(n.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("WRITE_DOC_START_MARKER", 0, true);
            f12171a = r0;
            a r1 = new a("USE_NATIVE_OBJECT_ID", 1, true);
            f12172b = r1;
            a r4 = new a("USE_NATIVE_TYPE_ID", 2, true);
            f12173c = r4;
            a r5 = new a("CANONICAL_OUTPUT", 3, false);
            f12174d = r5;
            a r7 = new a("SPLIT_LINES", 4, true);
            f12175e = r7;
            a r9 = new a("MINIMIZE_QUOTES", 5, false);
            f = r9;
            a r11 = new a("ALWAYS_QUOTE_NUMBERS_AS_STRINGS", 6, false);
            g = r11;
            a r13 = new a("LITERAL_BLOCK_STYLE", 7, false);
            h = r13;
            a r15 = new a("INDENT_ARRAYS", 8, false);
            i = r15;
            a r14 = new a("INDENT_ARRAYS_WITH_INDICATOR", 9, false);
            j = r14;
            a r12 = new a("USE_PLATFORM_LINE_BREAKS", 10, false);
            k = r12;
            n = new a[]{r0, r1, r4, r5, r7, r9, r11, r13, r15, r14, r12};
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
            this.l = r3;
            this.m = 1 << ordinal();
        }

        @Override // com.fasterxml.jackson.a.h.h
        public boolean b() {
            return this.l;
        }

        public boolean a(int r1) {
            if ((this.m & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.fasterxml.jackson.a.h.h
        public int c() {
            return this.m;
        }
    }

    public c b(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Override // com.fasterxml.jackson.a.h
    public /* synthetic */ com.fasterxml.jackson.a.h a(p r3) {
        return b((p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin"));
    }

    static {
        k = Pattern.compile("-?[0-9]*(\\.[0-9]*)?");
        l = org.c.a.f.b.f.toString();
        v = org.c.a.a.d.f40328e;
        w = org.c.a.a.d.f40328e;
        x = org.c.a.a.d.f40324a;
        org.c.a.a.d r0 = org.c.a.a.d.f40326c;
        y = r0;
        z = r0;
        A = org.c.a.a.d.f40328e;
        B = new h(true, true);
        C = new h(false, false);
    }

    public c(e r1, int r2, int r3, com.fasterxml.jackson.b.a.b.a r4, o r5, Writer r6, org.c.a.a.e r7) {
        super(r2, r5);
        this.m = r1;
        this.n = r3;
        if (r4 != null) goto L5;
        r4 = com.fasterxml.jackson.b.a.b.a.C0268a.a();
    L5:
        this.u = r4;
        this.o = r6;
        this.q = r7;
        this.p = a(r2, r3, r7);
        this.r = new org.c.a.b.a(this.o, this.p);
        a(new org.c.a.d.p(null, null));
        q();
    }

    public org.c.a.a a(int r3, int r4, org.c.a.a.e r5) {
        org.c.a.a r6 = new org.c.a.a();
        if (a.f12174d.a(this.n) == false) goto L5;
        r6.b(true);
    L6:
        r6.c(a.f12175e.a(this.n));
        if (a.i.a(this.n) == false) goto L10;
        r6.b(1);
        r6.a(2);
    L10:
        if (a.j.a(this.n) == false) goto L13;
        r6.b(2);
        r6.a(true);
    L13:
        if (a.k.a(this.n) == false) goto L15;
        r6.a(org.c.a.a.b.b());
    L15:
        return r6;
    L5:
        r6.b(false);
        r6.a(org.c.a.a.EnumC1093a.f40312b);
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public com.fasterxml.jackson.a.h b(int r3, int r4) {
        int r5 = r3 & r4;
        this.n = r5 | (this.n & (~r4));
        return this;
    }

    @Override // com.fasterxml.jackson.a.h
    public final void a(String r3) {
        if (this.i.a(r3) != 4) goto L5;
        g("Can not write a field name, expecting a value");
    L5:
        i(r3);
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public final void b(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        if (this.i.a(r4.a()) != 4) goto L5;
        g("Can not write a field name, expecting a value");
    L5:
        i(r4.a());
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(long r2) {
        String r3 = Long.valueOf(r2).toString();
        if (this.i.a(r3) != 4) goto L5;
        g("Can not write a field id, expecting a value");
    L5:
        a(r3, "int", w);
    }

    private final void i(String r3) {
        if (this.u.a(r3) == false) goto L5;
        org.c.a.a.d r0 = x;
    L6:
        a(r3, WsChannelMultiProcessSharedProvider.STRING_TYPE, r0);
        return;
    L5:
        r0 = v;
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h, java.io.Flushable
    public final void flush() {
        if (b(com.fasterxml.jackson.a.h.a.f12084c) == false) goto L6;
        this.o.flush();
        return;
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (o() == true) goto L16;
        r();
        a(new org.c.a.d.o(null, null));
        super.close();
        if (this.o != null) goto L7;
        return;
    L7:
        if (this.m.a() == false) goto L9;
    L14:
        this.o.close();
        return;
    L9:
        if (b(com.fasterxml.jackson.a.h.a.f12082a) == true) goto L14;
        if (b(com.fasterxml.jackson.a.h.a.f12084c) == false) goto L18;
        this.o.flush();
        return;
    L18:
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public final void h() {
        h("start an array");
        this.i = this.i.j();
        org.c.a.a.EnumC1093a r7 = this.p.j();
        String r3 = this.t;
        if (r3 != null) goto L5;
        boolean r0 = true;
    L6:
        boolean r4 = r0;
        String r2 = this.s;
        if (r2 == null) goto L9;
        this.s = null;
    L9:
        a(new n(r2, r3, r4, null, null, r7));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public final void i() {
        if (this.i.b() == true) goto L5;
        g("Current context not Array but " + this.i.e());
    L5:
        this.t = null;
        this.i = this.i.l();
        a(new m(null, null));
    }

    @Override // com.fasterxml.jackson.a.h
    public final void j() {
        h("start an object");
        this.i = this.i.k();
        org.c.a.a.EnumC1093a r7 = this.p.j();
        String r3 = this.t;
        if (r3 != null) goto L5;
        boolean r0 = true;
    L6:
        boolean r4 = r0;
        String r2 = this.s;
        if (r2 == null) goto L9;
        this.s = null;
    L9:
        a(new j(r2, r3, r4, null, null, r7));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public final void k() {
        if (this.i.d() == true) goto L5;
        g("Current context not Object but " + this.i.e());
    L5:
        this.t = null;
        this.i = this.i.l();
        a(new i(null, null));
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(String r5) {
        if (r5 != null) goto L5;
        l();
        return;
    L5:
        h("write String value");
        if (r5.isEmpty() == false) goto L10;
        a(r5, WsChannelMultiProcessSharedProvider.STRING_TYPE, x);
        return;
    L10:
        if (a.f.a(this.n) == false) goto L24;
        if (r5.indexOf(10) < 0) goto L15;
        org.c.a.a.d r0 = y;
    L29:
        a(r5, WsChannelMultiProcessSharedProvider.STRING_TYPE, r0);
        return;
    L15:
        if (this.u.b(r5) == false) goto L17;
    L22:
        r0 = x;
        goto L29
    L17:
        if (a.g.a(this.n) == true) goto L19;
    L21:
        r0 = A;
        goto L29
    L19:
        if (k.matcher(r5).matches() == false) goto L21;
    L24:
        if (a.h.a(this.n) == true) goto L26;
    L28:
        r0 = x;
        goto L29
    L26:
        if (r5.indexOf(10) < 0) goto L28;
        r0 = y;
        goto L29
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(char[] r2, int r3, int r4) {
        b(new String(r2, r3, r4));
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public final void c(q r3) {
        b(((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin")).toString());
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(String r1) {
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

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public void d(String r1) {
        n();
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(com.fasterxml.jackson.a.a r3, byte[] r4, int r5, int r6) {
        if (r4 != null) goto L5;
        l();
        return;
    L5:
        h("write Binary value");
        if (r5 <= 0) goto L8;
    L9:
        r4 = Arrays.copyOfRange(r4, r5, r6 + r5);
    L10:
        a(r3, r4);
        return;
    L8:
        if ((r5 + r6) == r4.length) goto L10;
        goto L9
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(boolean r3) {
        h("write boolean value");
        if (r3 == false) goto L5;
        String r4 = "true";
    L6:
        a(r4, "bool", w);
        return;
    L5:
        r4 = "false";
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(int r3) {
        h("write number");
        a(String.valueOf(r3), "int", w);
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(long r3) {
        if (r3 <= 2147483647L) goto L5;
    L8:
        h("write number");
        a(String.valueOf(r3), WsChannelMultiProcessSharedProvider.LONG_TYPE, w);
        return;
    L5:
        if (r3 < (-2147483648L)) goto L8;
        d((int) r3);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(BigInteger r3) {
        if (r3 != null) goto L5;
        l();
        return;
    L5:
        h("write number");
        a(String.valueOf(r3.toString()), "java.math.BigInteger", w);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(double r2) {
        h("write number");
        a(String.valueOf(r2), "double", w);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(float r3) {
        h("write number");
        a(String.valueOf(r3), WsChannelMultiProcessSharedProvider.FLOAT_TYPE, w);
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(BigDecimal r3) {
        if (r3 != null) goto L5;
        l();
        return;
    L5:
        h("write number");
        if (b(com.fasterxml.jackson.a.h.a.h) == false) goto L8;
        String r4 = r3.toPlainString();
    L9:
        a(r4, "java.math.BigDecimal", w);
        return;
    L8:
        r4 = r3.toString();
        goto L9
    }

    @Override // com.fasterxml.jackson.a.h
    public void e(String r3) {
        if (r3 != null) goto L5;
        l();
        return;
    L5:
        h("write number");
        a(r3, "number", w);
    }

    @Override // com.fasterxml.jackson.a.h
    public void l() {
        h("write null value");
        a("null", "object", w);
    }

    @Override // com.fasterxml.jackson.a.h
    public boolean d() {
        return a.f12172b.a(this.n);
    }

    @Override // com.fasterxml.jackson.a.h
    public boolean e() {
        return a.f12173c.a(this.n);
    }

    @Override // com.fasterxml.jackson.a.h
    public void g(Object r1) {
        this.t = String.valueOf(r1);
    }

    @Override // com.fasterxml.jackson.a.h
    public void f(Object r3) {
        h("write Object reference");
        a(new org.c.a.d.a(String.valueOf(r3), null, null));
    }

    @Override // com.fasterxml.jackson.a.h
    public void e(Object r1) {
        if (r1 != null) goto L4;
        String r2 = null;
    L5:
        this.s = r2;
        return;
    L4:
        r2 = String.valueOf(r1);
        goto L5
    }

    @Override // com.fasterxml.jackson.a.a.a
    public final void h(String r3) {
        if (this.i.o() != 5) goto L6;
        g("Can not " + r3 + ", expecting field name");
    L6:
        if (this.i.c() == true) goto L8;
        return;
    L8:
        if (this.i.g() <= 0) goto L12;
        r();
        q();
        return;
    }

    public void a(String r1, String r2, org.c.a.a.d r3) {
        a(a(r1, r3));
    }

    private void a(com.fasterxml.jackson.a.a r10, byte[] r11) {
        if (r10 != com.fasterxml.jackson.a.b.a()) goto L5;
        r10 = com.fasterxml.jackson.a.b.f11977a;
    L5:
        String r5 = a(r10, r11, p());
        a(new l(null, l, C, r5, null, null, z));
    }

    public l a(String r9, org.c.a.a.d r10) {
        String r2 = this.t;
        if (r2 == null) goto L5;
        this.t = null;
    L5:
        String r1 = this.s;
        if (r1 == null) goto L9;
        this.s = null;
    L9:
        return new l(r1, r2, B, r9, null, null, r10);
    }

    private String a(com.fasterxml.jackson.a.a r8, byte[] r9, String r10) {
        int r7 = r9.length;
        StringBuilder r0 = new StringBuilder(((r7 >> 2) + r7) + (r7 >> 3));
        int r1 = r8.f() >> 2;
        int r3 = r7 - 3;
        int r4 = 0;
    L3:
        if (r4 > r3) goto L8;
        int r5 = r4 + 1;
        int r6 = r5 + 1;
        int r11 = ((r9[r4] << 8) | (r9[r5] & 255)) << 8;
        int r12 = r6 + 1;
        r8.a(r0, r11 | (r9[r6] & 255));
        r1 = r1 - 1;
        if (r1 > 0) goto L7;
        r0.append(r10);
        r1 = r8.f() >> 2;
    L7:
        r4 = r12;
        goto L3
    L8:
        int r13 = r7 - r4;
        if (r13 <= 0) goto L15;
        int r14 = r4 + 1;
        int r2 = r9[r4] << 16;
        if (r13 != 2) goto L13;
        r2 = r2 | ((r9[r14] & 255) << 8);
    L13:
        r8.a(r0, r2, r13);
    L15:
        return r0.toString();
    }

    public String p() {
        return this.p.i().a();
    }

    public void q() {
        Map r5 = Collections.emptyMap();
        a(new f(null, null, a.f12171a.a(this.n), this.q, r5));
    }

    public void r() {
        a(new org.c.a.d.e(null, null, false));
    }

    public final void a(g r1) {
        this.r.a(r1);
    }
}
