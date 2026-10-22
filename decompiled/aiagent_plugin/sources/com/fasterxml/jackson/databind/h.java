package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: compiled from: DeserializationContext.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.o f12708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.p f12709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final g f12710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f12711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.h.i<com.fasterxml.jackson.a.r> f12712e;
    protected final Class<?> f;
    protected transient com.fasterxml.jackson.a.k g;
    protected final j h;
    protected transient com.fasterxml.jackson.databind.l.c i;
    protected transient com.fasterxml.jackson.databind.l.s j;
    protected transient DateFormat k;
    protected transient com.fasterxml.jackson.databind.a.j l;
    protected com.fasterxml.jackson.databind.l.o<k> m;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeserializationContext.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12713a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.a.n.values().length];
            f12713a = r0;
            r0[com.fasterxml.jackson.a.n.f12152b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            f12713a[com.fasterxml.jackson.a.n.f12153c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            f12713a[com.fasterxml.jackson.a.n.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            f12713a[com.fasterxml.jackson.a.n.f12154d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            f12713a[com.fasterxml.jackson.a.n.f12155e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            f12713a[com.fasterxml.jackson.a.n.l.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            f12713a[com.fasterxml.jackson.a.n.k.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            f12713a[com.fasterxml.jackson.a.n.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            f12713a[com.fasterxml.jackson.a.n.j.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            f12713a[com.fasterxml.jackson.a.n.i.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            f12713a[com.fasterxml.jackson.a.n.h.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            f12713a[com.fasterxml.jackson.a.n.m.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            f12713a[com.fasterxml.jackson.a.n.f12151a.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    public abstract com.fasterxml.jackson.databind.b.a.z a(Object r1, ObjectIdGenerator<?> r2, ObjectIdResolver r3);

    public abstract l<Object> b(com.fasterxml.jackson.databind.e.b r1, Object r2);

    public abstract q c(com.fasterxml.jackson.databind.e.b r1, Object r2);

    @Override // com.fasterxml.jackson.databind.e
    public /* synthetic */ com.fasterxml.jackson.databind.a.m a() {
        return c();
    }

    public h(com.fasterxml.jackson.databind.b.p r2, com.fasterxml.jackson.databind.b.o r3) {
        Objects.requireNonNull(r2, "Cannot pass null DeserializerFactory");
        this.f12709b = r2;
        if (r3 != null) goto L5;
        r3 = new com.fasterxml.jackson.databind.b.o();
    L5:
        this.f12708a = r3;
        this.f12711d = 0;
        this.f12712e = null;
        this.f12710c = null;
        this.h = null;
        this.f = null;
        this.l = null;
    }

    public h(h r2, g r3, com.fasterxml.jackson.a.k r4, j r5) {
        this.f12708a = r2.f12708a;
        this.f12709b = r2.f12709b;
        if (r4 != null) goto L5;
        com.fasterxml.jackson.a.h.i<com.fasterxml.jackson.a.r> r6 = null;
    L6:
        this.f12712e = r6;
        this.f12710c = r3;
        this.f12711d = r3.b();
        this.f = r3.x();
        this.g = r4;
        this.h = r5;
        this.l = r3.y();
        return;
    L5:
        r6 = r4.c();
        goto L6
    }

    public h(h r2, g r3) {
        this.f12708a = r2.f12708a;
        this.f12709b = r2.f12709b;
        this.f12712e = null;
        this.f12710c = r3;
        this.f12711d = r3.b();
        this.f = null;
        this.g = null;
        this.h = null;
        this.l = null;
    }

    public g c() {
        return this.f12710c;
    }

    public final Class<?> d() {
        return this.f;
    }

    public final boolean e() {
        return this.f12710c.g();
    }

    public final boolean a(r r1) {
        return this.f12710c.a(r1);
    }

    public final JsonFormat.Value a(Class<?> r1) {
        return this.f12710c.f(r1);
    }

    public final b f() {
        return this.f12710c.j();
    }

    @Override // com.fasterxml.jackson.databind.e
    public final com.fasterxml.jackson.databind.k.o b() {
        return this.f12710c.o();
    }

    public k a(k r2, Class<?> r3) {
        if (r2.a(r3) == false) goto L6;
        return r2;
    L6:
        return c().o().a(r2, r3, false);
    }

    public Locale g() {
        return this.f12710c.s();
    }

    public TimeZone h() {
        return this.f12710c.t();
    }

    public final boolean a(i r1) {
        if ((this.f12711d & r1.b()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(com.fasterxml.jackson.a.r r1) {
        return this.f12712e.b(r1);
    }

    public final int i() {
        return this.f12711d;
    }

    public final boolean a(int r1) {
        if ((this.f12711d & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.fasterxml.jackson.a.k j() {
        return this.g;
    }

    public final Object a(Object r3, d r4, Object r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        j r0 = this.h;
        if (r0 != null) goto L7;
        return a(com.fasterxml.jackson.databind.l.h.a(r3), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", new Object[]{r3}));
    L7:
        return r0.a(r3, this, r6, r5);
    }

    public final com.fasterxml.jackson.a.a k() {
        return this.f12710c.u();
    }

    public final com.fasterxml.jackson.databind.i.l l() {
        return this.f12710c.d();
    }

    public com.fasterxml.jackson.databind.a.b a(com.fasterxml.jackson.databind.k.f r1, Class<?> r2, com.fasterxml.jackson.databind.a.e r3) {
        return this.f12710c.a(r1, r2, r3);
    }

    public com.fasterxml.jackson.databind.a.b a(com.fasterxml.jackson.databind.k.f r1, Class<?> r2, com.fasterxml.jackson.databind.a.b r3) {
        return this.f12710c.a(r1, r2, r3);
    }

    public com.fasterxml.jackson.databind.l.y a(com.fasterxml.jackson.a.k r2) {
        return new com.fasterxml.jackson.databind.l.y(r2, this);
    }

    public final com.fasterxml.jackson.databind.l.y m() {
        return a(j());
    }

    public com.fasterxml.jackson.databind.l.y b(com.fasterxml.jackson.a.k r1) {
        com.fasterxml.jackson.databind.l.y r0 = a(r1);
        r0.b(r1);
        return r0;
    }

    public final l<Object> a(k r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        l<Object> r0 = this.f12708a.a(this, this.f12709b, r3);
        if (r0 != null) goto L5;
        return r0;
    L5:
        return b(r0, r5, r3);
    }

    public final l<Object> a(k r3) {
        return this.f12708a.a(this, this.f12709b, r3);
    }

    public final l<Object> b(k r4) {
        l<Object> r0 = this.f12708a.a(this, this.f12709b, r4);
        if (r0 != null) goto L5;
        return null;
    L5:
        l<?> r1 = b(r0, null, r4);
        com.fasterxml.jackson.databind.h.e r3 = this.f12709b.b(this.f12710c, r4);
        if (r3 != null) goto L8;
        return r1;
    L8:
        return new com.fasterxml.jackson.databind.b.a.ab(r3.a(null), r1);
    }

    public final q b(k r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        q r7 = this.f12708a.b(this, this.f12709b, r4);     // Catch: IllegalArgumentException -> L5
    L8:
        if (ZeusTransformUtils.instanceOf(r7, com.fasterxml.jackson.databind.b.j.class) == true) goto L10;
        return r7;
    L10:
        return ((com.fasterxml.jackson.databind.b.j) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.b.j.class, "com.obric.aiagent.plugin")).a(this, r6);
    L5:
        e = move-exception;
        b(r4, com.fasterxml.jackson.databind.l.h.h(e));
        r7 = null;
        goto L8
    }

    public final k b(Class<?> r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return this.f12710c.b(r1);
    }

    public Class<?> c(String r1) {
        return b().a(r1);
    }

    public final com.fasterxml.jackson.databind.l.s n() {
        com.fasterxml.jackson.databind.l.s r0 = this.j;
        if (r0 == null) goto L7;
        this.j = null;
        return r0;
    L7:
        return new com.fasterxml.jackson.databind.l.s();
    }

    public final void a(com.fasterxml.jackson.databind.l.s r3) {
        if (this.j != null) goto L5;
    L6:
        this.j = r3;
        return;
    L5:
        if (r3.b() >= this.j.b()) goto L6;
    }

    public final com.fasterxml.jackson.databind.l.c o() {
        if (this.i != null) goto L6;
        this.i = new com.fasterxml.jackson.databind.l.c();
    L6:
        return this.i;
    }

    public l<?> a(l<?> r4, d r5, k r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.b.i.class) == false) goto L10;
        this.m = new com.fasterxml.jackson.databind.l.o(r6, this.m);
        r4 = ((com.fasterxml.jackson.databind.b.i) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.b.i.class, "com.obric.aiagent.plugin")).a(this, r7);     // Catch: Throwable -> L7
        this.m = this.m.a();
    L7:
        th = move-exception;
        this.m = this.m.a();
        throw th;
    L10:
        return r4;
    }

    public l<?> b(l<?> r4, d r5, k r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.b.i.class) == false) goto L10;
        this.m = new com.fasterxml.jackson.databind.l.o(r6, this.m);
        r4 = ((com.fasterxml.jackson.databind.b.i) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.b.i.class, "com.obric.aiagent.plugin")).a(this, r7);     // Catch: Throwable -> L7
        this.m = this.m.a();
    L7:
        th = move-exception;
        this.m = this.m.a();
        throw th;
    L10:
        return r4;
    }

    public Date d(String r4) {
        return p().parse(r4);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[]{r4, com.fasterxml.jackson.databind.l.h.h(e)}));
    }

    public Calendar a(Date r1) {
        Calendar r0 = Calendar.getInstance(h());
        r0.setTime(r1);
        return r0;
    }

    public String a(com.fasterxml.jackson.a.k r1, l<?> r2, Class<?> r3) {
        return (String) ZeusTransformUtils.preCheckCast(a(r3, r1), String.class, "com.obric.aiagent.plugin");
    }

    public <T> T a(com.fasterxml.jackson.a.k r2, Class<T> r3) {
        return (T) a(r2, b().a(r3));
    }

    public <T> T a(com.fasterxml.jackson.a.k r2, k r3) {
        l<Object> r0 = b(r3);
        if (r0 != null) goto L7;
        return (T) b(r3, "Could not find JsonDeserializer for type " + com.fasterxml.jackson.databind.l.h.b(r3));
    L7:
        return (T) r0.a(r2, this);
    }

    public boolean a(com.fasterxml.jackson.a.k r10, l<?> r11, Object r12, String r13) {
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r0 = this.f12710c.c();
    L4:
        if (r0 == null) goto L10;
        if (((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r0.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r10, r11, r12, r13) == true) goto L7;
        r0 = r0.a();
        goto L4
    L7:
        return true;
    L10:
        if (a(i.f12758e) == true) goto L13;
        r10.k();
        return true;
    L13:
        if (r11 != null) goto L15;
        Collection<Object> r14 = null;
    L17:
        throw com.fasterxml.jackson.databind.c.h.a(this.g, r12, r13, r14);
    L15:
        r14 = r11.d();
        goto L17
    }

    public Object a(Class<?> r4, String r5, String r6, Object... r7) {
        String r8 = a(r6, r7);
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r9 = this.f12710c.c();
    L3:
        if (r9 == null) goto L15;
        Object r0 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r9.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r4, r5, r8);
        if (r0 != com.fasterxml.jackson.databind.b.n.f12528a) goto L6;
        r9 = r9.a();
        goto L3
    L6:
        if (r0 != null) goto L8;
    L12:
        return r0;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, r0) == true) goto L12;
        throw a(r5, r4, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.c(r4), com.fasterxml.jackson.databind.l.h.c(r0)}));
    L15:
        throw a(r4, r5, r8);
    }

    public Object b(Class<?> r4, String r5, String r6, Object... r7) {
        String r8 = a(r6, r7);
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r9 = this.f12710c.c();
    L3:
        if (r9 == null) goto L13;
        Object r0 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r9.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).b(this, r4, r5, r8);
        if (r0 != com.fasterxml.jackson.databind.b.n.f12528a) goto L7;
        r9 = r9.a();
        goto L3
    L7:
        if (a(r4, r0) == false) goto L10;
        return r0;
    L10:
        throw a(r5, r4, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.c(r4), com.fasterxml.jackson.databind.l.h.c(r0)}));
    L13:
        throw a(r5, r4, r8);
    }

    public Object a(Class<?> r4, Number r5, String r6, Object... r7) {
        String r8 = a(r6, r7);
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r9 = this.f12710c.c();
    L3:
        if (r9 == null) goto L13;
        Object r0 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r9.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r4, r5, r8);
        if (r0 != com.fasterxml.jackson.databind.b.n.f12528a) goto L7;
        r9 = r9.a();
        goto L3
    L7:
        if (a(r4, r0) == false) goto L10;
        return r0;
    L10:
        throw a(r5, r4, a("DeserializationProblemHandler.handleWeirdNumberValue() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.c(r4), com.fasterxml.jackson.databind.l.h.c(r0)}));
    L13:
        throw a(r5, r4, r8);
    }

    public Object a(k r6, Object r7, com.fasterxml.jackson.a.k r8) {
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r0 = this.f12710c.c();
        Class<?> r1 = r6.e();
    L3:
        if (r0 == null) goto L15;
        Object r2 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r0.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r6, r7, r8);
        if (r2 != com.fasterxml.jackson.databind.b.n.f12528a) goto L6;
        r0 = r0.a();
        goto L3
    L6:
        if (r2 != null) goto L8;
    L12:
        return r2;
    L8:
        if (ZeusTransformUtils.instanceOf(r1, r2) == true) goto L12;
        throw m.a(r8, a("DeserializationProblemHandler.handleWeirdNativeValue() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.c(r6), com.fasterxml.jackson.databind.l.h.c(r2)}));
    L15:
        throw a(r7, r1);
    }

    public Object a(Class<?> r10, com.fasterxml.jackson.databind.b.y r11, com.fasterxml.jackson.a.k r12, String r13, Object... r14) {
        if (r12 != null) goto L4;
        r12 = j();
    L4:
        String r15 = a(r13, r14);
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r16 = this.f12710c.c();
    L6:
        if (r16 == null) goto L14;
        Object r0 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r16.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r10, r11, r12, r15);
        if (r0 == com.fasterxml.jackson.databind.b.n.f12528a) goto L13;
        if (a(r10, r0) == true) goto L11;
        b(b(r10), String.format("DeserializationProblemHandler.handleMissingInstantiator() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.c(r10), com.fasterxml.jackson.databind.l.h.c(r0)}));
        goto L13
    L11:
        return r0;
    L13:
        r16 = r16.a();
        goto L6
    L14:
        if (r11 != null) goto L18;
        return a(r10, String.format("Cannot construct instance of %s: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r10), r15}));
    L18:
        if (r11.c() == true) goto L22;
        return a(r10, String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r10), r15}));
    L22:
        return a(r10, String.format("Cannot construct instance of %s (although at least one Creator exists): %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r10), r15}), new Object[0]);
    }

    public Object a(Class<?> r7, Object r8, Throwable r9) {
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r0 = this.f12710c.c();
    L3:
        if (r0 == null) goto L11;
        Object r1 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r0.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r7, r8, r9);
        if (r1 == com.fasterxml.jackson.databind.b.n.f12528a) goto L10;
        if (a(r7, r1) == true) goto L8;
        b(b(r7), String.format("DeserializationProblemHandler.handleInstantiationProblem() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.c(r7), com.fasterxml.jackson.databind.l.h.d(r1)}));
        goto L10
    L8:
        return r1;
    L10:
        r0 = r0.a();
        goto L3
    L11:
        com.fasterxml.jackson.databind.l.h.c(r9);
        if (a(i.p) == true) goto L15;
        com.fasterxml.jackson.databind.l.h.b(r9);
    L15:
        throw a(r7, r9);
    }

    public Object a(Class<?> r7, com.fasterxml.jackson.a.k r8) {
        return a(b(r7), r8.l(), r8, null, new Object[0]);
    }

    public Object a(Class<?> r7, com.fasterxml.jackson.a.n r8, com.fasterxml.jackson.a.k r9, String r10, Object... r11) {
        return a(b(r7), r8, r9, r10, r11);
    }

    public Object a(k r7, com.fasterxml.jackson.a.k r8) {
        return a(r7, r8.l(), r8, null, new Object[0]);
    }

    public Object a(k r10, com.fasterxml.jackson.a.n r11, com.fasterxml.jackson.a.k r12, String r13, Object... r14) {
        String r15 = a(r13, r14);
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r16 = this.f12710c.c();
    L4:
        if (r16 == null) goto L12;
        Object r0 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r16.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r10, r11, r12, r15);
        if (r0 == com.fasterxml.jackson.databind.b.n.f12528a) goto L11;
        if (a(r10.e(), r0) == true) goto L9;
        b(r10, String.format("DeserializationProblemHandler.handleUnexpectedToken() for type %s returned value of type %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r10), com.fasterxml.jackson.databind.l.h.d(r0)}));
        goto L11
    L9:
        return r0;
    L11:
        r16 = r16.a();
        goto L4
    L12:
        if (r15 != null) goto L17;
        String r17 = com.fasterxml.jackson.databind.l.h.b(r10);
        if (r11 != null) goto L16;
        r15 = String.format("Unexpected end-of-input when trying read value of type %s", new Object[]{r17});
        goto L17
    L16:
        r15 = String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", new Object[]{r17, a(r11), r11});
    L17:
        if (r11 != null) goto L19;
    L21:
        a(r10, r15, new Object[0]);
        return null;
    L19:
        if (r11.g() == false) goto L21;
        r12.x();
        goto L21
    }

    public k a(k r10, String r11, com.fasterxml.jackson.databind.h.f r12, String r13) {
        com.fasterxml.jackson.databind.h.f r14 = (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r12, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r0 = this.f12710c.c();
    L4:
        if (r0 == null) goto L17;
        k r2 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r0.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r10, r11, r14, r13);
        if (r2 != null) goto L8;
        r0 = r0.a();
        goto L4
    L8:
        if (r2.a(Void.class) == false) goto L11;
        return null;
    L11:
        if (r2.b(r10.e()) == false) goto L14;
        return r2;
    L14:
        throw a(r10, r11, "problem handler tried to resolve into non-subtype: " + com.fasterxml.jackson.databind.l.h.b(r2));
    L17:
        if (a(i.h) == true) goto L20;
        return null;
    L20:
        throw a(r10, r11, r13);
    }

    public k a(k r5, com.fasterxml.jackson.databind.h.f r6, String r7) {
        com.fasterxml.jackson.databind.h.f r8 = (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l.o<com.fasterxml.jackson.databind.b.n> r0 = this.f12710c.c();
    L3:
        if (r0 == null) goto L16;
        k r2 = ((com.fasterxml.jackson.databind.b.n) ZeusTransformUtils.preCheckCast(r0.b(), com.fasterxml.jackson.databind.b.n.class, "com.obric.aiagent.plugin")).a(this, r5, r8, r7);
        if (r2 != null) goto L7;
        r0 = r0.a();
        goto L3
    L7:
        if (r2.a(Void.class) == false) goto L10;
        return null;
    L10:
        if (r2.b(r5.e()) == false) goto L13;
        return r2;
    L13:
        throw a(r5, null, "problem handler tried to resolve into non-subtype: " + com.fasterxml.jackson.databind.l.h.b(r2));
    L16:
        throw c(r5, r7);
    }

    public void a(l<?> r4) {
        if (a(r.D) == false) goto L5;
        return;
    L5:
        k r5 = b(r4.a());
        throw com.fasterxml.jackson.databind.c.b.a(j(), String.format("Invalid configuration: values of type %s cannot be merged", new Object[]{com.fasterxml.jackson.databind.l.h.b(r5)}), r5);
    }

    public boolean a(Class<?> r2, Object r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, r3) == false) goto L8;
        return true;
    L8:
        if (r2.isPrimitive() == true) goto L10;
    L12:
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(com.fasterxml.jackson.databind.l.h.j(r2), r3) == false) goto L12;
        return true;
    }

    public void a(l<?> r1, com.fasterxml.jackson.a.n r2, String r3, Object... r4) {
        String r5 = a(r3, r4);
        throw a(j(), r1.a(), r2, r5);
    }

    public void a(k r1, com.fasterxml.jackson.a.n r2, String r3, Object... r4) {
        String r5 = a(r3, r4);
        throw a(j(), r1, r2, r5);
    }

    public void a(Class<?> r1, com.fasterxml.jackson.a.n r2, String r3, Object... r4) {
        String r5 = a(r3, r4);
        throw a(j(), r1, r2, r5);
    }

    public <T> T a(com.fasterxml.jackson.databind.b.a.s r4, Object r5) {
        return (T) a(r4.f, String.format("No Object Id found for an instance of %s, to assign to property '%s'", new Object[]{com.fasterxml.jackson.databind.l.h.d(r5), r4.f12329b}), new Object[0]);
    }

    public <T> T a(l<?> r1, String r2, Object... r3) {
        String r4 = a(r2, r3);
        throw com.fasterxml.jackson.databind.c.f.a(j(), r1.a(), r4);
    }

    public <T> T a(Class<?> r1, String r2, Object... r3) {
        String r4 = a(r2, r3);
        throw com.fasterxml.jackson.databind.c.f.a(j(), r1, r4);
    }

    public <T> T a(k r1, String r2, Object... r3) {
        String r4 = a(r2, r3);
        throw com.fasterxml.jackson.databind.c.f.a(j(), r1, r4);
    }

    public <T> T a(d r3, String r4, Object... r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        String r7 = a(r4, r5);
        if (r6 != null) goto L5;
        k r8 = null;
    L6:
        com.fasterxml.jackson.databind.c.f r2 = com.fasterxml.jackson.databind.c.f.a(j(), r8, r7);
        if (r6 == null) goto L12;
        com.fasterxml.jackson.databind.e.j r9 = r6.d();
        if (r9 == null) goto L13;
        r2.a(r9.f(), r6.a());
        throw r2;
    L13:
        throw r2;
    L12:
        throw r2;
    L5:
        r8 = r6.getType();
        goto L6
    }

    public <T> T c(Class<?> r1, String r2, String r3, Object... r4) {
        String r5 = a(r3, r4);
        com.fasterxml.jackson.databind.c.f r0 = com.fasterxml.jackson.databind.c.f.a(j(), r1, r5);
        if (r2 == null) goto L6;
        r0.a(r1, r2);
        throw r0;
    L6:
        throw r0;
    }

    public <T> T a(k r1, String r2, String r3, Object... r4) {
        return (T) c(r1.e(), r2, r3, r4);
    }

    public <T> T a(l<?> r1, Class<?> r2, Object r3, String r4, Object... r5) {
        String r6 = a(r4, r5);
        throw com.fasterxml.jackson.databind.c.c.a(j(), r6, r3, r2);
    }

    public <T> T a(Class<?> r2, com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.a.n r4) {
        throw com.fasterxml.jackson.databind.c.f.a(r3, r2, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", new Object[]{r4, com.fasterxml.jackson.databind.l.h.h(r2)}));
    }

    public <T> T a(c r3, String r4, Object... r5) {
        throw com.fasterxml.jackson.databind.c.b.a(this.g, String.format("Invalid type definition for type %s: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r3.a()), a(r4, r5)}), r3, null);
    }

    public <T> T a(c r4, com.fasterxml.jackson.databind.e.t r5, String r6, Object... r7) {
        String r8 = a(r6, r7);
        throw com.fasterxml.jackson.databind.c.b.a(this.g, String.format("Invalid definition for property %s (of type %s): %s", new Object[]{com.fasterxml.jackson.databind.l.h.a(r5), com.fasterxml.jackson.databind.l.h.h(r4.a()), r8}), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.e
    public <T> T b(k r1, String r2) {
        throw com.fasterxml.jackson.databind.c.b.a(this.g, r2, r1);
    }

    public m a(com.fasterxml.jackson.a.k r4, k r5, com.fasterxml.jackson.a.n r6, String r7) {
        return com.fasterxml.jackson.databind.c.f.a(r4, r5, a(String.format("Unexpected token (%s), expected %s", new Object[]{r4.l(), r6}), r7));
    }

    public m a(com.fasterxml.jackson.a.k r4, Class<?> r5, com.fasterxml.jackson.a.n r6, String r7) {
        return com.fasterxml.jackson.databind.c.f.a(r4, r5, a(String.format("Unexpected token (%s), expected %s", new Object[]{r4.l(), r6}), r7));
    }

    public m a(Class<?> r5, String r6, String r7) {
        return com.fasterxml.jackson.databind.c.c.a(this.g, String.format("Cannot deserialize Map key of type %s from String %s: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5), b(r6), r7}), r6, r5);
    }

    public m a(String r4, Class<?> r5, String r6) {
        return com.fasterxml.jackson.databind.c.c.a(this.g, String.format("Cannot deserialize value of type %s from String %s: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5), b(r4), r6}), r4, r5);
    }

    public m a(Number r4, Class<?> r5, String r6) {
        return com.fasterxml.jackson.databind.c.c.a(this.g, String.format("Cannot deserialize value of type %s from number %s: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5), String.valueOf(r4), r6}), r4, r5);
    }

    public m a(Object r4, Class<?> r5) {
        return com.fasterxml.jackson.databind.c.c.a(this.g, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5), com.fasterxml.jackson.databind.l.h.d(r4)}), r4, r5);
    }

    public m a(Class<?> r5, Throwable r6) {
        if (r6 != null) goto L4;
        String r0 = "N/A";
    L8:
        return com.fasterxml.jackson.databind.c.i.a(this.g, String.format("Cannot construct instance of %s, problem: %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5), r0}), b(r5), r6);
    L4:
        r0 = com.fasterxml.jackson.databind.l.h.h(r6);
        if (r0 != null) goto L8;
        r0 = com.fasterxml.jackson.databind.l.h.h(r6.getClass());
        goto L8
    }

    @Override // com.fasterxml.jackson.databind.e
    public m a(k r4, String r5, String r6) {
        return com.fasterxml.jackson.databind.c.e.a(this.g, a(String.format("Could not resolve type id '%s' as a subtype of %s", new Object[]{r5, com.fasterxml.jackson.databind.l.h.b(r4)}), r6), r4, r5);
    }

    public m c(k r3, String r4) {
        return com.fasterxml.jackson.databind.c.e.a(this.g, a(String.format("Could not resolve subtype of %s", new Object[]{r3}), r4), r3, null);
    }

    public DateFormat p() {
        DateFormat r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        DateFormat r1 = (DateFormat) ZeusTransformUtils.preCheckCast(this.f12710c.r().clone(), DateFormat.class, "com.obric.aiagent.plugin");
        this.k = r1;
        return r1;
    }

    public String a(com.fasterxml.jackson.a.n r1) {
        if (r1 != null) goto L4;
        return "<end of input>";
    L4:
        switch(AnonymousClass1.f12713a[r1.ordinal()]) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L7;
            default: goto L5;
        };
    L5:
        return "[Unavailable value]";
    L7:
        return "Null value";
    L9:
        return "String value";
    L11:
        return "Integer value";
    L13:
        return "Floating-point value";
    L15:
        return "Embedded Object";
    L17:
        return "Boolean value";
    L19:
        return "Array value";
    L21:
        return "Object value";
    }
}
