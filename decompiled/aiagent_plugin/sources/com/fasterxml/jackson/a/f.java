package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;

/* JADX INFO: compiled from: JsonFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int f12035a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final int f12036b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final int f12037c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f12038d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final transient com.fasterxml.jackson.a.f.b f12039e;
    protected final transient com.fasterxml.jackson.a.f.a f;
    protected int g;
    protected int h;
    protected int i;
    protected o j;
    protected com.fasterxml.jackson.a.d.c k;
    protected com.fasterxml.jackson.a.d.f l;
    protected com.fasterxml.jackson.a.d.k m;
    protected q n;
    protected int o;
    protected final char p;

    /* JADX INFO: compiled from: JsonFactory.java */
    public static final enum a extends Enum<a> implements com.fasterxml.jackson.a.h.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12040a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12041b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12042c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12043d = null;
        private static final /* synthetic */ a[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f12044e;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("INTERN_FIELD_NAMES", 0, true);
            f12040a = r0;
            a r1 = new a("CANONICALIZE_FIELD_NAMES", 1, true);
            f12041b = r1;
            a r4 = new a("FAIL_ON_SYMBOL_HASH_OVERFLOW", 2, true);
            f12042c = r4;
            a r5 = new a("USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING", 3, true);
            f12043d = r5;
            f = new a[]{r0, r1, r4, r5};
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
            this.f12044e = r3;
        }

        @Override // com.fasterxml.jackson.a.h.h
        public boolean b() {
            return this.f12044e;
        }

        public boolean a(int r1) {
            if ((c() & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.fasterxml.jackson.a.h.h
        public int c() {
            return 1 << ordinal();
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    static {
        f12035a = a.a();
        f12036b = k.a.a();
        f12037c = h.a.a();
        f12038d = com.fasterxml.jackson.a.h.e.f12102c;
    }

    public f() {
        this((o) ZeusTransformUtils.preCheckCast(null, o.class, "com.obric.aiagent.plugin"));
    }

    public f(o r2) {
        this.f12039e = com.fasterxml.jackson.a.f.b.a();
        this.f = com.fasterxml.jackson.a.f.a.a();
        this.g = f12035a;
        this.h = f12036b;
        this.i = f12037c;
        this.n = f12038d;
        this.j = r2;
        this.p = '\"';
    }

    public String d() {
        if (getClass() != f.class) goto L6;
        return "JSON";
    L6:
        return null;
    }

    public f a(o r1) {
        this.j = r1;
        return this;
    }

    public o e() {
        return this.j;
    }

    public k a(Reader r3) {
        com.fasterxml.jackson.a.d.e r0 = a(a(r3), false);
        return a(b(r3, r0), r0);
    }

    public k a(String r7) {
        int r3 = r7.length();
        if (this.l != null) goto L12;
        if (r3 > 32768) goto L12;
        if (c() == false) goto L12;
        com.fasterxml.jackson.a.d.e r4 = a(a(r7), true);
        char[] r1 = r4.a(r3);
        r7.getChars(0, r3, r1, 0);
        return a(r1, 0, r3, r4, true);
    L12:
        return a(new StringReader(r7));
    }

    public h a(Writer r3) {
        com.fasterxml.jackson.a.d.e r0 = a(a(r3), false);
        return a(b(r3, r0), r0);
    }

    public k a(Reader r8, com.fasterxml.jackson.a.d.e r9) {
        return new com.fasterxml.jackson.a.e.f(r9, this.h, r8, this.j, this.f12039e.b(this.g));
    }

    public k a(char[] r12, int r13, int r14, com.fasterxml.jackson.a.d.e r15, boolean r16) {
        return new com.fasterxml.jackson.a.e.f(r15, this.h, null, this.j, this.f12039e.b(this.g), r12, r13, r13 + r14, r16);
    }

    public h a(Writer r8, com.fasterxml.jackson.a.d.e r9) {
        com.fasterxml.jackson.a.e.g r6 = new com.fasterxml.jackson.a.e.g(r9, this.i, this.j, r8, this.p);
        int r10 = this.o;
        if (r10 <= 0) goto L5;
        r6.b(r10);
    L5:
        com.fasterxml.jackson.a.d.c r11 = this.k;
        if (r11 == null) goto L8;
        r6.a(r11);
    L8:
        q r7 = this.n;
        if (r7 == f12038d) goto L11;
        r6.a(r7);
    L11:
        return r6;
    }

    public final Reader b(Reader r1, com.fasterxml.jackson.a.d.e r2) {
        com.fasterxml.jackson.a.d.f r0 = this.l;
        if (r0 == null) goto L7;
        Reader r3 = r0.a(r2, r1);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return r1;
    }

    public final Writer b(Writer r1, com.fasterxml.jackson.a.d.e r2) {
        com.fasterxml.jackson.a.d.k r0 = this.m;
        if (r0 == null) goto L7;
        Writer r3 = r0.a(r2, r1);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return r1;
    }

    public com.fasterxml.jackson.a.h.a f() {
        if (a.f12043d.a(this.g) == false) goto L7;
        return com.fasterxml.jackson.a.h.b.a();
    L7:
        return new com.fasterxml.jackson.a.h.a();
    }

    public com.fasterxml.jackson.a.d.e a(com.fasterxml.jackson.a.d.d r2, boolean r3) {
        if (r2 != null) goto L5;
        r2 = com.fasterxml.jackson.a.d.d.a();
    L5:
        return new com.fasterxml.jackson.a.d.e(f(), r2, r3);
    }

    public com.fasterxml.jackson.a.d.d a(Object r1) {
        return com.fasterxml.jackson.a.d.d.a(!b(), r1);
    }
}
