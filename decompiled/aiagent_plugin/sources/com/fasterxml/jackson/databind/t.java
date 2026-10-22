package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.e.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ObjectMapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends com.fasterxml.jackson.a.o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final b f13101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.a.a f13102b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.f f13103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.k.o f13104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected j f13105e;
    protected com.fasterxml.jackson.databind.h.d f;
    protected final com.fasterxml.jackson.databind.a.h g;
    protected final com.fasterxml.jackson.databind.a.d h;
    protected af i;
    protected aa j;
    protected com.fasterxml.jackson.databind.j.k k;
    protected com.fasterxml.jackson.databind.j.r l;
    protected g m;
    protected com.fasterxml.jackson.databind.b.m n;
    protected final ConcurrentHashMap<k, l<Object>> o;

    static {
        com.fasterxml.jackson.databind.e.y r2 = new com.fasterxml.jackson.databind.e.y();
        f13101a = r2;
        f13102b = new com.fasterxml.jackson.databind.a.a(null, r2, null, com.fasterxml.jackson.databind.k.o.a(), null, com.fasterxml.jackson.databind.l.x.g, null, Locale.getDefault(), null, com.fasterxml.jackson.a.b.a(), com.fasterxml.jackson.databind.h.a.l.f12721a, new com.fasterxml.jackson.databind.e.x.b());
    }

    public t() {
        this(null, null, null);
    }

    public t(com.fasterxml.jackson.a.f r2) {
        this(r2, null, null);
    }

    public t(com.fasterxml.jackson.a.f r12, com.fasterxml.jackson.databind.j.k r13, com.fasterxml.jackson.databind.b.m r14) {
        this.o = new ConcurrentHashMap(64, 0.6f, 2);
        if (r12 != null) goto L5;
        this.f13103c = new s(this);
    L8:
        this.f = new com.fasterxml.jackson.databind.h.a.n();
        com.fasterxml.jackson.databind.l.v r15 = new com.fasterxml.jackson.databind.l.v();
        this.f13104d = com.fasterxml.jackson.databind.k.o.a();
        af r6 = new af(null);
        this.i = r6;
        com.fasterxml.jackson.databind.a.a r7 = f13102b.a(c());
        com.fasterxml.jackson.databind.a.h r8 = new com.fasterxml.jackson.databind.a.h();
        this.g = r8;
        com.fasterxml.jackson.databind.a.d r9 = new com.fasterxml.jackson.databind.a.d();
        this.h = r9;
        this.j = new aa(r7, this.f, r6, r15, r8);
        this.m = new g(r7, this.f, r6, r15, r8, r9);
        boolean r16 = this.f13103c.a();
        if ((this.j.a(r.t) ^ r16) == false) goto L11;
        a(r.t, r16);
    L11:
        if (r13 != null) goto L13;
        r13 = new com.fasterxml.jackson.databind.j.k.a();
    L13:
        this.k = r13;
        if (r14 != null) goto L16;
        r14 = new com.fasterxml.jackson.databind.b.m.a(com.fasterxml.jackson.databind.b.f.f12520c);
    L16:
        this.n = r14;
        this.l = com.fasterxml.jackson.databind.j.g.f12947d;
        return;
    L5:
        this.f13103c = r12;
        if (r12.e() != null) goto L8;
        r12.a(this);
        goto L8
    }

    public com.fasterxml.jackson.databind.e.u c() {
        return new com.fasterxml.jackson.databind.e.s();
    }

    public u a(g r8, k r9, Object r10, com.fasterxml.jackson.a.d r11, j r12) {
        return new u(this, r8, r9, r10, (com.fasterxml.jackson.a.d) ZeusTransformUtils.wrapperContextForParams(r11, com.fasterxml.jackson.a.d.class, "com.obric.aiagent.plugin"), r12);
    }

    public v a(aa r2) {
        return new v(this, r2);
    }

    public aa d() {
        return this.j;
    }

    public g e() {
        return this.m;
    }

    @Override // com.fasterxml.jackson.a.o
    public com.fasterxml.jackson.a.f b() {
        return this.f13103c;
    }

    @Deprecated
    public t a(r r6, boolean r7) {
        if (r7 == false) goto L5;
        aa r3 = this.j.a(new r[]{r6});
    L6:
        this.j = (aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L9;
        g r8 = this.m.a(new r[]{r6});
    L10:
        this.m = (g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin");
        return this;
    L9:
        r8 = this.m.b(new r[]{r6});
        goto L10
    L5:
        r3 = this.j.b(new r[]{r6});
        goto L6
    }

    @Override // com.fasterxml.jackson.a.o
    public void a(com.fasterxml.jackson.a.h r3, Object r4) {
        a("g", r3);
        aa r0 = d();
        if (r0.a(ab.f12246b) == false) goto L8;
        if (r3.c() != null) goto L8;
        r3.a(r0.a());
    L8:
        if (r0.a(ab.h) == true) goto L10;
    L12:
        b(r0).a(r3, r4);
        if (r0.a(ab.i) == false) goto L17;
        r3.flush();
        return;
    L17:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, Closeable.class) == false) goto L12;
        a(r3, r4, r0);
    }

    public <T> T a(String r2, Class<T> r3) {
        a("content", r2);
        return (T) a(r2, this.f13104d.a(r3));
    }

    public <T> T a(String r2, k r3) {
        a("content", r2);
        return (T) a(this.f13103c.a(r2), r3);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw m.a(e);
    }

    public v f() {
        return a(d());
    }

    public u a(Class<?> r7) {
        return a(e(), this.f13104d.a(r7), null, null, this.f13105e);
    }

    public com.fasterxml.jackson.databind.j.k b(aa r2) {
        return this.k.a(r2, this.l);
    }

    private final void a(com.fasterxml.jackson.a.h r3, Object r4, aa r5) {
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.aiagent.plugin");
        b(r5).a(r3, r4);     // Catch: Exception -> L8
        if (r5.a(ab.i) == false) goto L6;
        r3.flush();     // Catch: Exception -> L8
    L6:
        r0.close();
        return;
    L8:
        e = move-exception;
        com.fasterxml.jackson.databind.l.h.a(null, r0, e);
    }

    public Object a(com.fasterxml.jackson.a.k r6, k r7) {
        g r0 = e();     // Catch: Throwable -> L17
        com.fasterxml.jackson.databind.b.m r1 = a(r6, r0);     // Catch: Throwable -> L17
        com.fasterxml.jackson.a.n r2 = b(r6, r7);     // Catch: Throwable -> L17
        Object r4 = null;
        if (r2 != com.fasterxml.jackson.a.n.m) goto L6;
        r4 = a(r1, r7).a(r1);     // Catch: Throwable -> L17
    L12:
        if (r0.a(i.o) == false) goto L14;
        a(r6, r1, r7);     // Catch: Throwable -> L17
    L14:
        if (r6 == null) goto L16;
        r6.close();
    L16:
        return r4;
    L6:
        if (r2 == com.fasterxml.jackson.a.n.f12155e) goto L12;
        if (r2 == com.fasterxml.jackson.a.n.f12153c) goto L12;
        r4 = r1.a(r6, r7, a(r1, r7), null);     // Catch: Throwable -> L17
        r1.q();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r6 != null) goto L28;
    L25:
        throw th;
    L28:
        r6.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    public com.fasterxml.jackson.databind.b.m a(com.fasterxml.jackson.a.k r2, g r3) {
        return this.n.a(r3, r2, this.f13105e);
    }

    public com.fasterxml.jackson.a.n b(com.fasterxml.jackson.a.k r1, k r2) {
        this.m.a(r1);
        com.fasterxml.jackson.a.n r0 = r1.l();
        if (r0 != null) goto L9;
        r0 = r1.g();
        if (r0 != null) goto L9;
        throw com.fasterxml.jackson.databind.c.f.a(r1, r2, "No content to map due to end-of-input");
    L9:
        return r0;
    }

    public final void a(com.fasterxml.jackson.a.k r1, h r2, k r3) {
        com.fasterxml.jackson.a.n r0 = r1.g();
        if (r0 == null) goto L6;
        r2.a(com.fasterxml.jackson.databind.l.h.a(r3), r1, r0);
        return;
    }

    public l<Object> a(h r4, k r5) {
        l<Object> r0 = (l) ZeusTransformUtils.preCheckCast(this.o.get(r5), l.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        l<Object> r1 = r4.b(r5);
        if (r1 == null) goto L8;
        this.o.put(r5, r1);
        return r1;
    L8:
        return (l) ZeusTransformUtils.preCheckCast(r4.b(r5, "Cannot find a deserializer for type " + r5), l.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r2, Object r3) {
        if (r3 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format("argument \"%s\" is null", new Object[]{r2}));
    }
}
