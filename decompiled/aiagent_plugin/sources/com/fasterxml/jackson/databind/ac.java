package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: SerializerProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ac extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p<Object> f12250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final p<Object> f12251b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final aa f12252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Class<?> f12253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.r f12254e;
    protected final com.fasterxml.jackson.databind.j.q f;
    protected transient com.fasterxml.jackson.databind.a.j g;
    protected p<Object> h;
    protected p<Object> i;
    protected p<Object> j;
    protected p<Object> k;
    protected final com.fasterxml.jackson.databind.j.a.l l;
    protected DateFormat m;
    protected final boolean n;

    public abstract com.fasterxml.jackson.databind.j.a.u a(Object r1, ObjectIdGenerator<?> r2);

    public abstract Object a(com.fasterxml.jackson.databind.e.t r1, Class<?> r2);

    public abstract p<Object> b(com.fasterxml.jackson.databind.e.b r1, Object r2);

    public abstract boolean b(Object r1);

    public com.fasterxml.jackson.a.h j() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e
    public /* synthetic */ com.fasterxml.jackson.databind.a.m a() {
        return c();
    }

    static {
        f12250a = new com.fasterxml.jackson.databind.j.a.c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
        f12251b = new com.fasterxml.jackson.databind.j.a.q();
    }

    public ac() {
        this.h = f12251b;
        this.j = com.fasterxml.jackson.databind.j.b.v.f12924a;
        this.k = f12250a;
        this.f12252c = null;
        this.f12254e = null;
        this.f = new com.fasterxml.jackson.databind.j.q();
        this.l = null;
        this.f12253d = null;
        this.g = null;
        this.n = true;
    }

    public ac(ac r3, aa r4, com.fasterxml.jackson.databind.j.r r5) {
        this.h = f12251b;
        this.j = com.fasterxml.jackson.databind.j.b.v.f12924a;
        p<Object> r0 = f12250a;
        this.k = r0;
        this.f12254e = r5;
        this.f12252c = r4;
        com.fasterxml.jackson.databind.j.q r6 = r3.f;
        this.f = r6;
        this.h = r3.h;
        this.i = r3.i;
        p<Object> r1 = r3.j;
        this.j = r1;
        this.k = r3.k;
        if (r1 != r0) goto L5;
        boolean r7 = true;
    L6:
        this.n = r7;
        this.f12253d = r4.x();
        this.g = r4.y();
        this.l = r6.a();
        return;
    L5:
        r7 = false;
        goto L6
    }

    public final aa c() {
        return this.f12252c;
    }

    public final b d() {
        return this.f12252c.j();
    }

    @Override // com.fasterxml.jackson.databind.e
    public final com.fasterxml.jackson.databind.k.o b() {
        return this.f12252c.o();
    }

    public k a(k r2, Class<?> r3) {
        if (r2.a(r3) == false) goto L6;
        return r2;
    L6:
        return c().o().a(r2, r3, true);
    }

    public final Class<?> e() {
        return this.f12253d;
    }

    public final boolean f() {
        return this.f12252c.g();
    }

    public final boolean a(r r1) {
        return this.f12252c.a(r1);
    }

    public final JsonFormat.Value a(Class<?> r1) {
        return this.f12252c.f(r1);
    }

    public final JsonInclude.Value b(Class<?> r1) {
        return this.f12252c.e(r1);
    }

    public Locale g() {
        return this.f12252c.s();
    }

    public TimeZone h() {
        return this.f12252c.t();
    }

    public Object a(Object r1) {
        return this.g.a(r1);
    }

    public ac a(Object r2, Object r3) {
        this.g = this.g.a(r2, r3);
        return this;
    }

    public final boolean a(ab r1) {
        return this.f12252c.a(r1);
    }

    public final com.fasterxml.jackson.databind.j.l i() {
        return this.f12252c.b();
    }

    public p<Object> a(Class<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L13;
        r0 = this.f.a(r3);
        if (r0 != null) goto L13;
        r0 = this.f.a(this.f12252c.b(r3));
        if (r0 != null) goto L13;
        r0 = e(r3);
        if (r0 != null) goto L13;
        return d(r3);
    L13:
        return b(r0, r5);
    }

    public p<Object> a(k r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        b("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
    L5:
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L14;
        r0 = this.f.a(r3);
        if (r0 != null) goto L14;
        r0 = b(r3);
        if (r0 != null) goto L14;
        return d(r3.e());
    L14:
        return b(r0, r5);
    }

    public p<Object> c(Class<?> r3) {
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L12;
        p<Object> r1 = this.f.a(r3);
        if (r1 != null) goto L13;
        p<Object> r2 = this.f.a(this.f12252c.b(r3));
        if (r2 != null) goto L14;
        p<Object> r4 = e(r3);
        if (r4 == null) goto L11;
        return r4;
    L11:
        return d(r3);
    L14:
        return r2;
    L13:
        return r1;
    L12:
        return r0;
    }

    public p<Object> a(k r2) {
        p<Object> r0 = this.l.b(r2);
        if (r0 != null) goto L10;
        p<Object> r1 = this.f.a(r2);
        if (r1 != null) goto L11;
        p<Object> r3 = b(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return d(r2.e());
    L11:
        return r1;
    L10:
        return r0;
    }

    public p<Object> b(k r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L11;
        r0 = this.f.a(r3);
        if (r0 != null) goto L11;
        r0 = b(r3);
        if (r0 != null) goto L11;
        return d(r3.e());
    L11:
        return a(r0, r5);
    }

    public p<Object> b(Class<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L13;
        r0 = this.f.a(r3);
        if (r0 != null) goto L13;
        r0 = this.f.a(this.f12252c.b(r3));
        if (r0 != null) goto L13;
        r0 = e(r3);
        if (r0 != null) goto L13;
        return d(r3);
    L13:
        return a(r0, r5);
    }

    public p<Object> c(k r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L11;
        r0 = this.f.a(r3);
        if (r0 != null) goto L11;
        r0 = b(r3);
        if (r0 != null) goto L11;
        return d(r3.e());
    L11:
        return b(r0, r5);
    }

    public p<Object> c(Class<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.b(r3);
        if (r0 != null) goto L13;
        r0 = this.f.a(r3);
        if (r0 != null) goto L13;
        r0 = this.f.a(this.f12252c.b(r3));
        if (r0 != null) goto L13;
        r0 = e(r3);
        if (r0 != null) goto L13;
        return d(r3);
    L13:
        return b(r0, r5);
    }

    public p<Object> a(Class<?> r5, boolean r6, d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.a(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        p<Object> r1 = this.f.b(r5);
        if (r1 == null) goto L8;
        return r1;
    L8:
        p<Object> r2 = a(r5, r8);
        com.fasterxml.jackson.databind.j.r r3 = this.f12254e;
        aa r4 = this.f12252c;
        com.fasterxml.jackson.databind.h.h r9 = r3.a(r4, r4.b(r5));
        if (r9 == null) goto L11;
        r2 = new com.fasterxml.jackson.databind.j.a.p(r9.a(r8), r2);
    L11:
        if (r6 == false) goto L13;
        this.f.a(r5, r2);
    L13:
        return r2;
    }

    public p<Object> a(k r4, boolean r5, d r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        p<Object> r0 = this.l.a(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        p<Object> r1 = this.f.b(r4);
        if (r1 == null) goto L8;
        return r1;
    L8:
        p<Object> r2 = a(r4, r7);
        com.fasterxml.jackson.databind.h.h r3 = this.f12254e.a(this.f12252c, r4);
        if (r3 == null) goto L11;
        r2 = new com.fasterxml.jackson.databind.j.a.p(r3.a(r7), r2);
    L11:
        if (r5 == false) goto L13;
        this.f.a(r4, r2);
    L13:
        return r2;
    }

    public p<Object> d(k r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return c(this.f12254e.a(this, r3, this.i), r5);
    }

    public p<Object> d(Class<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return d(this.f12252c.b(r3), r5);
    }

    public p<Object> k() {
        return this.j;
    }

    public p<Object> e(k r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return this.k;
    }

    public p<Object> a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return this.j;
    }

    public p<Object> d(Class<?> r2) {
        if (r2 != Object.class) goto L7;
        return this.h;
    L7:
        return new com.fasterxml.jackson.databind.j.a.q(r2);
    }

    public p<?> a(p<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return r3;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.j.j.class) == true) goto L7;
        return r3;
    L7:
        return ((com.fasterxml.jackson.databind.j.j) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.j.j.class, "com.obric.aiagent.plugin")).a(this, r5);
    }

    public p<?> b(p<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return r3;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.j.j.class) == true) goto L7;
        return r3;
    L7:
        return ((com.fasterxml.jackson.databind.j.j) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.j.j.class, "com.obric.aiagent.plugin")).a(this, r5);
    }

    public final void a(Object r4, com.fasterxml.jackson.a.h r5) {
        if (r4 == null) goto L5;
        a(r4.getClass(), true, null).a(r4, r5, this);
        return;
    L5:
        if (this.n == false) goto L7;
        r5.l();
        return;
    L7:
        this.j.a(null, r5, this);
    }

    public final void a(Date r2, com.fasterxml.jackson.a.h r3) {
        if (a(ab.j) == false) goto L5;
        r3.b(r2.getTime());
        return;
    L5:
        r3.b(l().format(r2));
    }

    public void a(long r2, com.fasterxml.jackson.a.h r4) {
        if (a(ab.k) == false) goto L5;
        r4.a(String.valueOf(r2));
        return;
    L5:
        r4.a(l().format(new Date(r2)));
    }

    public void b(Date r2, com.fasterxml.jackson.a.h r3) {
        if (a(ab.k) == false) goto L5;
        r3.a(String.valueOf(r2.getTime()));
        return;
    L5:
        r3.a(l().format(r2));
    }

    public final void a(com.fasterxml.jackson.a.h r3) {
        if (this.n == false) goto L5;
        r3.l();
        return;
    L5:
        this.j.a(null, r3, this);
    }

    public void b(String r1, Object... r2) {
        throw c(r1, r2);
    }

    public <T> T a(c r4, String r5, Object... r6) {
        if (r4 == null) goto L4;
        String r0 = com.fasterxml.jackson.databind.l.h.h(r4.a());
    L6:
        throw com.fasterxml.jackson.databind.c.b.a(j(), String.format("Invalid type definition for type %s: %s", new Object[]{r0, a(r5, r6)}), r4, null);
    L4:
        r0 = "N/A";
        goto L6
    }

    public <T> T a(c r4, com.fasterxml.jackson.databind.e.t r5, String r6, Object... r7) {
        String r8 = a(r6, r7);
        String r9 = "N/A";
        if (r5 == null) goto L5;
        String r0 = b(r5.a());
    L6:
        if (r4 == null) goto L9;
        r9 = com.fasterxml.jackson.databind.l.h.h(r4.a());
    L9:
        throw com.fasterxml.jackson.databind.c.b.a(j(), String.format("Invalid definition for property %s (of type %s): %s", new Object[]{r0, r9, r8}), r4, r5);
    L5:
        r0 = "N/A";
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.e
    public <T> T b(k r1, String r2) {
        throw com.fasterxml.jackson.databind.c.b.a(j(), r2, r1);
    }

    public <T> T a(Class<?> r2, String r3, Throwable r4) {
        throw com.fasterxml.jackson.databind.c.b.a(j(), r3, a(r2)).a(r4);
    }

    public void a(Throwable r1, String r2, Object... r3) {
        String r4 = a(r2, r3);
        throw m.a(j(), r4, r1);
    }

    @Override // com.fasterxml.jackson.databind.e
    public m a(k r4, String r5, String r6) {
        return com.fasterxml.jackson.databind.c.e.a(null, a(String.format("Could not resolve type id '%s' as a subtype of %s", new Object[]{r5, com.fasterxml.jackson.databind.l.h.b(r4)}), r6), r4, r5);
    }

    @Deprecated
    public m c(String r2, Object... r3) {
        return m.a(j(), a(r2, r3));
    }

    public void a(Object r3, k r4) {
        if (r4.o() == true) goto L5;
    L7:
        b(r4, String.format("Incompatible types: declared root type (%s) vs %s", new Object[]{r4, com.fasterxml.jackson.databind.l.h.d(r3)}));
        return;
    L5:
        if (com.fasterxml.jackson.databind.l.h.j(r4.e()).isAssignableFrom(r3.getClass()) == false) goto L7;
    }

    public p<Object> e(Class<?> r4) {
        k r0 = this.f12252c.b(r4);
        p<Object> r1 = c(r0);     // Catch: IllegalArgumentException -> L5
    L7:
        if (r1 == null) goto L9;
        this.f.a(r4, r0, r1, this);
    L9:
        return r1;
    L5:
        e = move-exception;
        b(r0, com.fasterxml.jackson.databind.l.h.h(e));
        r1 = null;
        goto L7
    }

    public p<Object> b(k r5) {
        p<Object> r0 = c(r5);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r0 == null) goto L8;
        this.f.a(r5, r0, this);
    L8:
        return r0;
    L4:
        e = move-exception;
        a(e, com.fasterxml.jackson.databind.l.h.h(e), new Object[0]);
        r0 = null;
        goto L6
    }

    public p<Object> c(k r2) {
        return this.f12254e.a(this, r2);
    }

    public p<Object> c(p<?> r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.j.p.class) == false) goto L6;
        ((com.fasterxml.jackson.databind.j.p) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.j.p.class, "com.obric.aiagent.plugin")).a(this);
    L6:
        return b(r3, r5);
    }

    public p<Object> a(p<?> r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.j.p.class) == false) goto L5;
        ((com.fasterxml.jackson.databind.j.p) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.j.p.class, "com.obric.aiagent.plugin")).a(this);
    L5:
        return r3;
    }

    public final DateFormat l() {
        DateFormat r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        DateFormat r1 = (DateFormat) ZeusTransformUtils.preCheckCast(this.f12252c.r().clone(), DateFormat.class, "com.obric.aiagent.plugin");
        this.m = r1;
        return r1;
    }
}
