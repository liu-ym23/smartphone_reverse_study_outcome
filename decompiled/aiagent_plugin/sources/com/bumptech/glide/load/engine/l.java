package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: EngineJob.java */
/* JADX INFO: loaded from: classes.dex */
class l<R> implements com.bumptech.glide.f.a.a.c, h.a<R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f3700e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f3701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.bumptech.glide.load.a f3702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    q f3703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p<?> f3704d;
    private final com.bumptech.glide.f.a.c f;
    private final p.a g;
    private final androidx.core.util.f.a<l<?>> h;
    private final c i;
    private final m j;
    private final com.bumptech.glide.load.engine.c.a k;
    private final com.bumptech.glide.load.engine.c.a l;
    private final com.bumptech.glide.load.engine.c.a m;
    private final com.bumptech.glide.load.engine.c.a n;
    private final AtomicInteger o;
    private com.bumptech.glide.load.g p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private v<?> u;
    private boolean v;
    private boolean w;
    private h<R> x;
    private volatile boolean y;

    /* JADX INFO: compiled from: EngineJob.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f3705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.i f3706b;

        a(l r3, com.bumptech.glide.request.i r4) {
            com.bumptech.glide.request.i r5 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            this.f3705a = r3;
            this.f3706b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.f3706b.h();
            monitor-enter(r0);
            l r1 = this.f3705a;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.f3705a.f3701a.b(this.f3706b) == false) goto L9;
            this.f3705a.b(this.f3706b);     // Catch: Throwable -> L13
        L9:
            this.f3705a.e();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f3707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.i f3708b;

        b(l r3, com.bumptech.glide.request.i r4) {
            com.bumptech.glide.request.i r5 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            this.f3707a = r3;
            this.f3708b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.f3708b.h();
            monitor-enter(r0);
            l r1 = this.f3707a;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.f3707a.f3701a.b(this.f3708b) == false) goto L9;
            this.f3707a.f3704d.g();     // Catch: Throwable -> L13
            this.f3707a.a(this.f3708b);     // Catch: Throwable -> L13
            this.f3707a.c(this.f3708b);     // Catch: Throwable -> L13
        L9:
            this.f3707a.e();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static class c {
        c() {
        }

        public <R> p<R> a(v<R> r8, boolean r9, com.bumptech.glide.load.g r10, p.a r11) {
            return new p((v) ZeusTransformUtils.wrapperContextForParams(r8, v.class, "com.obric.aiagent.plugin"), r9, true, (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin"), (p.a) ZeusTransformUtils.wrapperContextForParams(r11, p.a.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.request.i f3709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f3710b;

        d(com.bumptech.glide.request.i r3, Executor r4) {
            com.bumptech.glide.request.i r5 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            this.f3709a = r5;
            this.f3710b = r6;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L6;
            d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
            return this.f3709a.equals(r4.f3709a);
        L6:
            return false;
        }

        public int hashCode() {
            return this.f3709a.hashCode();
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d> f3711a;

        e() {
            this(new ArrayList(2));
        }

        e(List<d> r3) {
            this.f3711a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        void a(com.bumptech.glide.request.i r3, Executor r4) {
            com.bumptech.glide.request.i r5 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            this.f3711a.add(new d(r5, r6));
        }

        void a(com.bumptech.glide.request.i r3) {
            com.bumptech.glide.request.i r4 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            this.f3711a.remove(c(r4));
        }

        boolean b(com.bumptech.glide.request.i r3) {
            com.bumptech.glide.request.i r4 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            return this.f3711a.contains(c(r4));
        }

        boolean a() {
            return this.f3711a.isEmpty();
        }

        int b() {
            return this.f3711a.size();
        }

        void c() {
            this.f3711a.clear();
        }

        e d() {
            return new e(new ArrayList(this.f3711a));
        }

        private static d c(com.bumptech.glide.request.i r2) {
            return new d((com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin"), com.bumptech.glide.f.e.b());
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f3711a.iterator();
        }
    }

    static {
        f3700e = new c();
    }

    l(com.bumptech.glide.load.engine.c.a r12, com.bumptech.glide.load.engine.c.a r13, com.bumptech.glide.load.engine.c.a r14, com.bumptech.glide.load.engine.c.a r15, m r16, p.a r17, androidx.core.util.f.a<l<?>> r18) {
        this(r12, r13, r14, r15, (m) ZeusTransformUtils.wrapperContextForParams(r16, m.class, "com.obric.aiagent.plugin"), (p.a) ZeusTransformUtils.wrapperContextForParams(r17, p.a.class, "com.obric.aiagent.plugin"), (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r18, androidx.core.util.f.a.class, "com.obric.aiagent.plugin"), f3700e);
    }

    l(com.bumptech.glide.load.engine.c.a r3, com.bumptech.glide.load.engine.c.a r4, com.bumptech.glide.load.engine.c.a r5, com.bumptech.glide.load.engine.c.a r6, m r7, p.a r8, androidx.core.util.f.a<l<?>> r9, c r10) {
        m r11 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
        p.a r12 = (p.a) ZeusTransformUtils.wrapperContextForParams(r8, p.a.class, "com.obric.aiagent.plugin");
        androidx.core.util.f.a<l<?>> r13 = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r9, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f3701a = new e();
        this.f = com.bumptech.glide.f.a.c.a();
        this.o = new AtomicInteger();
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.j = r11;
        this.g = r12;
        this.h = r13;
        this.i = r10;
    }

    synchronized l<R> a(com.bumptech.glide.load.g r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        monitor-enter(this);
        this.p = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.q = r4;     // Catch: Throwable -> L6
        this.r = r5;     // Catch: Throwable -> L6
        this.s = r6;     // Catch: Throwable -> L6
        this.t = r7;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b(h<R> r2) {
        monitor-enter(this);
        this.x = r2;     // Catch: Throwable -> L10
        if (r2.a() == false) goto L6;
        com.bumptech.glide.load.engine.c.a r0 = this.k;     // Catch: Throwable -> L10
    L7:
        r0.execute(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = g();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    synchronized void a(com.bumptech.glide.request.i r3, Executor r4) {
        monitor-enter(this);
        com.bumptech.glide.request.i r5 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        this.f.b();     // Catch: Throwable -> L16
        this.f3701a.a(r5, r6);     // Catch: Throwable -> L16
        boolean r1 = true;
        if (this.v == false) goto L7;
        a(1);     // Catch: Throwable -> L16
        r6.execute(new b(this, r5));     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L7:
        if (this.w == false) goto L10;
        a(1);     // Catch: Throwable -> L16
        r6.execute(new a(this, r5));     // Catch: Throwable -> L16
        goto L14
    L10:
        if (this.y == false) goto L13;
        r1 = false;
    L13:
        com.bumptech.glide.f.j.a(r1, "Cannot add callbacks to a cancelled EngineJob");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    void a(com.bumptech.glide.request.i r3) {
        com.bumptech.glide.request.i r4 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
        r4.a(this.f3704d, this.f3702b);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw new com.bumptech.glide.load.engine.b(th);
    }

    void b(com.bumptech.glide.request.i r3) {
        com.bumptech.glide.request.i r4 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
        r4.a(this.f3703c);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw new com.bumptech.glide.load.engine.b(th);
    }

    synchronized void c(com.bumptech.glide.request.i r3) {
        monitor-enter(this);
        com.bumptech.glide.request.i r4 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        this.f.b();     // Catch: Throwable -> L18
        this.f3701a.a(r4);     // Catch: Throwable -> L18
        if (this.f3701a.a() == false) goto L16;
        b();     // Catch: Throwable -> L18
        if (this.v == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L16;
        if (this.o.get() != 0) goto L16;
        i();     // Catch: Throwable -> L18
        goto L16
    L8:
        if (this.w == true) goto L11;
        r5 = false;
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    boolean a() {
        return this.t;
    }

    private com.bumptech.glide.load.engine.c.a g() {
        if (this.r == false) goto L6;
        return this.m;
    L6:
        if (this.s == false) goto L9;
        return this.n;
    L9:
        return this.l;
    }

    void b() {
        if (h() == false) goto L5;
        return;
    L5:
        this.y = true;
        this.x.b();
        this.j.a(this, this.p);
    }

    private boolean h() {
        if (this.w == false) goto L5;
    L10:
        return true;
    L5:
        if (this.v == true) goto L10;
        if (this.y == true) goto L10;
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void c() {
        monitor-enter(this);
        this.f.b();     // Catch: Throwable -> L24
        if (this.y == false) goto L9;
        this.u.f();     // Catch: Throwable -> L24
        i();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.f3701a.a() == true) goto L23;
        if (this.v == true) goto L21;
        this.f3704d = this.i.a(this.u, this.q, this.p, this.g);     // Catch: Throwable -> L24
        this.v = true;     // Catch: Throwable -> L24
        e r1 = this.f3701a.d();     // Catch: Throwable -> L24
        a(r1.b() + 1);     // Catch: Throwable -> L24
        com.bumptech.glide.load.g r0 = this.p;     // Catch: Throwable -> L24
        p<?> r2 = this.f3704d;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.j.a(this, r0, r2);
        Iterator<d> r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.aiagent.plugin");
        r4.f3710b.execute(new b(this, r4.f3709a));
        goto L16
    L18:
        e();
        return;
    L21:
        throw new IllegalStateException("Already have resource");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received a resource without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    synchronized void a(int r3) {
        monitor-enter(this);
        com.bumptech.glide.f.j.a(h(), "Not yet complete!");     // Catch: Throwable -> L10
        if (this.o.getAndAdd(r3) != 0) goto L8;
        p<?> r4 = this.f3704d;     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r4.g();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void e() {
        monitor-enter(this);
        this.f.b();     // Catch: Throwable -> L15
        com.bumptech.glide.f.j.a(h(), "Not yet complete!");     // Catch: Throwable -> L15
        int r0 = this.o.decrementAndGet();     // Catch: Throwable -> L15
        if (r0 < 0) goto L6;
        boolean r1 = true;
    L7:
        com.bumptech.glide.f.j.a(r1, "Can't decrement below 0");     // Catch: Throwable -> L15
        if (r0 != 0) goto L10;
        p<?> r2 = this.f3704d;     // Catch: Throwable -> L15
        i();     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r2 == null) goto L20;
        r2.h();
        return;
    L20:
        return;
    L10:
        r2 = null;
        goto L11
    L6:
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    private synchronized void i() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.p == null) goto L9;
        this.f3701a.c();     // Catch: Throwable -> L10
        this.p = null;     // Catch: Throwable -> L10
        this.f3704d = null;     // Catch: Throwable -> L10
        this.u = null;     // Catch: Throwable -> L10
        this.w = false;     // Catch: Throwable -> L10
        this.y = false;     // Catch: Throwable -> L10
        this.v = false;     // Catch: Throwable -> L10
        this.x.a(false);     // Catch: Throwable -> L10
        this.x = null;     // Catch: Throwable -> L10
        this.f3703c = null;     // Catch: Throwable -> L10
        this.f3702b = null;     // Catch: Throwable -> L10
        this.h.a(this);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    }

    @Override // com.bumptech.glide.load.engine.h.a
    public void a(v<R> r3, com.bumptech.glide.load.a r4) {
        v<?> r5 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        this.u = r5;     // Catch: Throwable -> L8
        this.f3702b = r4;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        c();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.h.a
    public void a(q r1) {
        monitor-enter(this);
        this.f3703c = r1;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        f();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.h.a
    public void a(h<?> r1) {
        g().execute(r1);
    }

    void f() {
        monitor-enter(this);
        this.f.b();     // Catch: Throwable -> L24
        if (this.y == false) goto L9;
        i();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.f3701a.a() == true) goto L23;
        if (this.w == true) goto L21;
        this.w = true;     // Catch: Throwable -> L24
        com.bumptech.glide.load.g r1 = this.p;     // Catch: Throwable -> L24
        e r2 = this.f3701a.d();     // Catch: Throwable -> L24
        a(r2.b() + 1);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.j.a(this, r1, null);
        Iterator<d> r0 = r2.iterator();
    L16:
        if (r0.hasNext() == false) goto L18;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.aiagent.plugin");
        r3.f3710b.execute(new a(this, r3.f3709a));
        goto L16
    L18:
        e();
        return;
    L21:
        throw new IllegalStateException("Already failed once");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received an exception without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.f.a.a.c
    public com.bumptech.glide.f.a.c b_() {
        return this.f;
    }
}
