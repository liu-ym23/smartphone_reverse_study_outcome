package com.obric.aiagent.skill.virt.impl.c;

import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.aa;
import com.obric.aiagent.skill.virt.api.n;
import com.obric.aiagent.skill.virt.api.p;
import com.obric.aiagent.skill.virt.api.r;
import com.obric.aiagent.skill.virt.api.u;
import com.obric.aiagent.skill.virt.impl.a.k;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.a.q;
import d.h.b.z;
import d.o;
import d.x;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: VirtShell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements IVirtService.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f22167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.c.a f22168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.c.b f22169c;

    /* JADX INFO: compiled from: VirtShell.kt */
    @d.c.b.a.f(b = "VirtShell.kt", c = {91}, d = "executeSync", e = "com.obric.aiagent.skill.virt.impl.shell.VirtShell")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f22170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f22171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22172c;

        a(e r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22171b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22170a = r3;
            this.f22172c |= Integer.MIN_VALUE;
            return this.f22171b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VirtShell.kt */
    @d.c.b.a.f(b = "VirtShell.kt", c = {44, 46, ITaskManager.Stub.TRANSACTION_tryActiveAgent, 81}, d = "startAsync", e = "com.obric.aiagent.skill.virt.impl.shell.VirtShell")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f22176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f22177e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ e i;
        int j;

        b(e r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.h = r9;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VirtShell.kt */
    @d.c.b.a.f(b = "VirtShell.kt", c = {74}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.VirtShell$startAsync$3")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q<n, m<? super Long, ? super Long, x>, d.c.d<? super x>, Object> f22179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f22180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.e f22181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.e f22182e;

        c(q<? super n, ? super m<? super Long, ? super Long, x>, ? super d.c.d<? super x>, ? extends Object> r3, n r4, z.e r5, z.e r6, d.c.d<? super c> r7) {
            q<n, m<? super Long, ? super Long, x>, d.c.d<? super x>, Object> r8 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22179b = r8;
            this.f22180c = r4;
            this.f22181d = r5;
            this.f22182e = r6;
            super(1, r9);
        }

        public static /* synthetic */ x lambda$Yz8YXjvgkCeMyljlVBu4czzhAQE(z.e r0, z.e r1, long r2, long r4) {
            return a(r0, r1, r2, r4);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r9) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f22179b, this.f22180c, this.f22181d, this.f22182e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22178a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            q<n, m<? super Long, ? super Long, x>, d.c.d<? super x>, Object> r8 = this.f22179b;
            n r2 = this.f22180c;
            final z.e r3 = this.f22181d;
            final z.e r4 = this.f22182e;
            m<? super Long, ? super Long, x> r5 = new $$Lambda$e$c$Yz8YXjvgkCeMyljlVBu4czzhAQE(r3, r4);
            this.f22178a = 1;
            if (r8.invoke(r2, r5, this) != r0) goto L12;
            return r0;
        }

        private static final x a(z.e r2, z.e r3, long r4, long r6) {
            r2.f38503a = d.l.n.a(r4, 0);
            r3.f38503a = d.l.n.a(r6, 0);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: VirtShell.kt */
    @d.c.b.a.f(b = "VirtShell.kt", c = {61, 63}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.VirtShell$startAsync$result$1")
    static final class d extends l implements m<com.obric.aiagent.skill.virt.impl.c.a.d, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.c.b.C0476b f22185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ m<p, d.c.d<? super x>, Object> f22186d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.e$d$1, reason: invalid class name */
        /* JADX INFO: compiled from: VirtShell.kt */
        @d.c.b.a.f(b = "VirtShell.kt", c = {61}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.VirtShell$startAsync$result$1$1")
        static final class AnonymousClass1 extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22187a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ m<p, d.c.d<? super x>, Object> f22188b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.virt.impl.c.a.d f22189c;

            AnonymousClass1(m<? super p, ? super d.c.d<? super x>, ? extends Object> r3, com.obric.aiagent.skill.virt.impl.c.a.d r4, d.c.d<? super AnonymousClass1> r5) {
                m<p, d.c.d<? super x>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22188b = r6;
                this.f22189c = r4;
                super(1, r7);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22188b, this.f22189c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22187a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r4);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r4);
                m<p, d.c.d<? super x>, Object> r5 = this.f22188b;
                p r2 = f.a(this.f22189c);
                this.f22187a = 1;
                if (r5.invoke(r2, this) != r0) goto L12;
                return r0;
            }
        }

        d(com.obric.aiagent.skill.virt.impl.c.b.C0476b r3, m<? super p, ? super d.c.d<? super x>, ? extends Object> r4, d.c.d<? super d> r5) {
            m<p, d.c.d<? super x>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22185c = r3;
            this.f22186d = r6;
            super(2, r7);
        }

        public final Object a(com.obric.aiagent.skill.virt.impl.c.a.d r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f22185c, this.f22186d, r6);
            r0.f22184b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.virt.impl.c.a.d r3, d.c.d<? super x> r4) {
            return a((com.obric.aiagent.skill.virt.impl.c.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.virt.impl.c.a.d.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22183a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r8);
        L19:
            return x.f38692a;
        L10:
            o.a(r8);
            com.obric.aiagent.skill.virt.impl.c.a.d r9 = (com.obric.aiagent.skill.virt.impl.c.a.d) ZeusTransformUtils.preCheckCast(this.f22184b, com.obric.aiagent.skill.virt.impl.c.a.d.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.virt.impl.c.b.C0476b r2 = this.f22185c;
            if (r2 == null) goto L15;
            d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22186d, r9, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22183a = 1;
            if (r2.a(r10, r3) != r0) goto L19;
            return r0;
        L15:
            m<p, d.c.d<? super x>, Object> r4 = this.f22186d;
            p r11 = f.a(r9);
            this.f22183a = 2;
            if (r4.invoke(r11, this) != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$-6sACUgTzUvanxkkyRI1nCuQfC0, reason: not valid java name */
    public static /* synthetic */ x m383lambda$6sACUgTzUvanxkkyRI1nCuQfC0(d.h.a.b r0, r r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$G3jcbk0aF2ya_ZNXqIXv37EQSYU(com.obric.aiagent.skill.virt.impl.c.b.C0476b r0, d.h.a.b r1, r r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$IT_W4QP2eJTbGjIwY_Zz8tjlWCc(long r0, long r2) {
        return a(r0, r2);
    }

    public e(k r3, com.obric.aiagent.skill.virt.impl.c.a r4, com.obric.aiagent.skill.virt.impl.c.b r5) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "backend");
        d.h.b.o.e(r4, "shellManager");
        d.h.b.o.e(r5, "shellMonitor");
        this.f22167a = r6;
        this.f22168b = r4;
        this.f22169c = r5;
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.d
    public <T> Object a(d.h.a.a<x> r3, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r4, d.c.d<? super T> r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.c.d<? super T>, ? extends Object> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super T> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f22168b.a(r6, r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [d.h.a.b] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.obric.aiagent.skill.virt.api.IVirtService.d
    public Object a(u r28, d.h.a.b<? super d.c.d<? super x>, ? extends Object> r29, d.h.a.b<? super d.c.d<? super x>, ? extends Object> r30, m<? super p, ? super d.c.d<? super x>, ? extends Object> r31, d.h.a.b<? super r, x> r32, q<? super n, ? super m<? super Long, ? super Long, x>, ? super d.c.d<? super x>, ? extends Object> r33, d.c.d<? super n> r34) {
        com.obric.aiagent.skill.virt.impl.c.b.C0476b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r29, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.c.d<? super x>, ? extends Object> r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r30, d.h.a.b.class, "com.obric.aiagent.plugin");
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r31, m.class, "com.obric.aiagent.plugin");
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r32, d.h.a.b.class, "com.obric.aiagent.plugin");
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r33, q.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r34, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L7;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if ((r8.j & Integer.MIN_VALUE) == 0) goto L7;
        r8.j -= Integer.MIN_VALUE;
    L8:
        Object r9 = r8.h;
        Object r15 = d.c.a.b.a();
        int r10 = r8.j;
        if (r10 == 0) goto L32;
        if (r10 == 1) goto L27;
        if (r10 == 2) goto L24;
        if (r10 == 3) goto L19;
        if (r10 != 4) goto L18;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r8.f22174b, n.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.c.b.C0476b r2 = (com.obric.aiagent.skill.virt.impl.c.b.C0476b) ZeusTransformUtils.preCheckCast(r8.f22173a, com.obric.aiagent.skill.virt.impl.c.b.C0476b.class, "com.obric.aiagent.plugin");
        o.a(r9);     // Catch: Throwable -> L30
    L57:
        return r0;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        z.e r11 = (z.e) ZeusTransformUtils.preCheckCast(r8.f22176d, z.e.class, "com.obric.aiagent.plugin");
        z.e r12 = (z.e) ZeusTransformUtils.preCheckCast(r8.f22175c, z.e.class, "com.obric.aiagent.plugin");
        n r13 = (n) ZeusTransformUtils.preCheckCast(r8.f22174b, n.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.c.b.C0476b r14 = (com.obric.aiagent.skill.virt.impl.c.b.C0476b) ZeusTransformUtils.preCheckCast(r8.f22173a, com.obric.aiagent.skill.virt.impl.c.b.C0476b.class, "com.obric.aiagent.plugin");
        o.a(r9);     // Catch: Throwable -> L22
        z.e r16 = r12;
        final com.obric.aiagent.skill.virt.impl.c.b.C0476b r17 = r14;
    L51:
        r17.a(r13, r16.f38503a, r11.f38503a);     // Catch: Throwable -> L30
        return r13;
    L22:
        th = th;
        r1 = r14;
    L62:
        if (r1 == 0) goto L64;
        r1.a(ZeusTransformUtils.instanceOf(th, CancellationException.class));
    L64:
        throw th;
    L24:
        r17 = (com.obric.aiagent.skill.virt.impl.c.b.C0476b) ZeusTransformUtils.preCheckCast(r8.f22174b, com.obric.aiagent.skill.virt.impl.c.b.C0476b.class, "com.obric.aiagent.plugin");
        q r18 = (q) ZeusTransformUtils.preCheckCast(r8.f22173a, q.class, "com.obric.aiagent.plugin");
        o.a(r9);     // Catch: Throwable -> L30
        int r19 = 3;
        int r20 = 4;
        Object r21 = r15;
    L45:
        n r22 = f.a((com.obric.aiagent.skill.virt.impl.c.a.f) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.virt.impl.c.a.f.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        r16 = new z.e();     // Catch: Throwable -> L30
        z.e r23 = new z.e();     // Catch: Throwable -> L30
        if (r17 == null) goto L52;
        d.h.a.b r24 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r18, r22, r16, r23, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        r8.f22173a = r17;     // Catch: Throwable -> L30
        r8.f22174b = r22;     // Catch: Throwable -> L30
        r8.f22175c = r16;     // Catch: Throwable -> L30
        r8.f22176d = r23;     // Catch: Throwable -> L30
        r8.j = r19;     // Catch: Throwable -> L30
        if (r17.a(r24, r8) != r21) goto L50;
        return r21;
    L50:
        r13 = r22;
        r11 = r23;
        goto L51
    L52:
        $$Lambda$e$IT_W4QP2eJTbGjIwY_Zz8tjlWCc r25 = $$Lambda$e$IT_W4QP2eJTbGjIwY_Zz8tjlWCc.INSTANCE;     // Catch: Throwable -> L30
        r8.f22173a = r17;     // Catch: Throwable -> L30
        r8.f22174b = r22;     // Catch: Throwable -> L30
        r8.j = r20;     // Catch: Throwable -> L30
        if (r18.invoke(r22, r25, r8) != r21) goto L55;
        return r21;
    L55:
        r0 = r22;
        goto L57
    L27:
        r17 = (com.obric.aiagent.skill.virt.impl.c.b.C0476b) ZeusTransformUtils.preCheckCast(r8.g, com.obric.aiagent.skill.virt.impl.c.b.C0476b.class, "com.obric.aiagent.plugin");
        r6 = (q) ZeusTransformUtils.preCheckCast(r8.f, q.class, "com.obric.aiagent.plugin");
        r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r8.f22177e, d.h.a.b.class, "com.obric.aiagent.plugin");
        r4 = (m) ZeusTransformUtils.preCheckCast(r8.f22176d, m.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.c.d<? super x>, ? extends Object> r26 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r8.f22175c, d.h.a.b.class, "com.obric.aiagent.plugin");
        u r27 = (u) ZeusTransformUtils.preCheckCast(r8.f22174b, u.class, "com.obric.aiagent.plugin");
        e r35 = (e) ZeusTransformUtils.preCheckCast(r8.f22173a, e.class, "com.obric.aiagent.plugin");
        o.a(r9);     // Catch: Throwable -> L30
        d.h.a.b<? super d.c.d<? super x>, ? extends Object> r210 = r26;
    L39:
        if (r17 == null) goto L41;
        r17.a();     // Catch: Throwable -> L30
    L41:
        com.obric.aiagent.skill.virt.impl.c.a r36 = r35.f22168b;     // Catch: Throwable -> L30
        String r37 = r27.a();     // Catch: Throwable -> L30
        String r110 = r27.b().a();     // Catch: Throwable -> L30
        String r111 = r27.c();     // Catch: Throwable -> L30
        Map<String, String> r112 = r27.d();     // Catch: Throwable -> L30
        String r113 = r27.k();     // Catch: Throwable -> L30
        long r114 = r27.e();     // Catch: Throwable -> L30
        Long r38 = r27.f();     // Catch: Throwable -> L30
        Long r115 = r27.g();     // Catch: Throwable -> L30
        long r116 = r27.h();     // Catch: Throwable -> L30
        String r211 = r27.i();     // Catch: Throwable -> L30
        m<? super com.obric.aiagent.skill.virt.impl.c.a.d, ? super d.c.d<? super x>, ? extends Object> r212 = (m) ZeusTransformUtils.preCheckCast(new d(r17, r4, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        d.h.a.b<? super r, x> r39 = new $$Lambda$e$G3jcbk0aF2ya_ZNXqIXv37EQSYU(r17, r5);     // Catch: Throwable -> L30
        r8.f22173a = r6;     // Catch: Throwable -> L30
        r8.f22174b = r17;     // Catch: Throwable -> L30
        r8.f22175c = null;     // Catch: Throwable -> L30
        r8.f22176d = null;     // Catch: Throwable -> L30
        r8.f22177e = null;     // Catch: Throwable -> L30
        r8.f = null;     // Catch: Throwable -> L30
        r8.g = null;     // Catch: Throwable -> L30
        r8.j = 2;     // Catch: Throwable -> L30
        r19 = 3;
        r20 = 4;
        r21 = r15;
        r9 = r36.a(r37, r110, r111, r112, r113, r114, r38, r115, r116, r211, r210, r212, r39, r8);     // Catch: Throwable -> L30
        if (r9 != r21) goto L44;
        return r21;
    L44:
        r18 = r6;
        goto L45
    L32:
        o.a(r9);
        com.obric.aiagent.skill.virt.impl.c.b.C0476b r40 = this.f22169c.a(r28.j(), r28.c(), this.f22167a.a(), r28.a());
        String r41 = com.obric.aiagent.skill.virt.impl.c.c.f22164a.a(r28.a());     // Catch: Throwable -> L60
        if (r41 != null) goto L59;
        r8.f22173a = this;     // Catch: Throwable -> L60
        r8.f22174b = r28;     // Catch: Throwable -> L60
        r8.f22175c = r3;     // Catch: Throwable -> L60
        r8.f22176d = r4;     // Catch: Throwable -> L60
        r8.f22177e = r5;     // Catch: Throwable -> L60
        r8.f = r6;     // Catch: Throwable -> L60
        r8.g = r40;     // Catch: Throwable -> L60
        r8.j = 1;     // Catch: Throwable -> L60
        if (r1.invoke(r8) != r15) goto L38;
        return r15;
    L38:
        r210 = r3;
        r17 = r40;
        r35 = this;
        r27 = r28;
        goto L39
    L59:
        throw new IllegalArgumentException(r41);     // Catch: Throwable -> L60
    L60:
        th = th;
        r1 = r40;
    L30:
        th = th;
    L7:
        r8 = new b(this, r7);
        goto L8
    }

    private static final x a(com.obric.aiagent.skill.virt.impl.c.b.C0476b r2, d.h.a.b r3, final r r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "event");
        if (r2 == null) goto L5;
        r2.a(new $$Lambda$e$6sACUgTzUvanxkkyRI1nCuQfC0(r5, r4));
    L7:
        return x.f38692a;
    L5:
        r5.invoke(r4);
        goto L7
    }

    private static final x a(d.h.a.b r2, r r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        return x.f38692a;
    }

    private static final x a(long r0, long r2) {
        return x.f38692a;
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.d
    public Object a(aa r12, d.c.d<? super com.obric.aiagent.skill.virt.api.z> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin");
        if ((r0.f22172c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f22172c -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f22170a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f22172c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r15);
    L23:
        return f.a((com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r15);
        com.obric.aiagent.skill.virt.impl.c.a r11 = this.f22168b;
        String r6 = r12.a();
        String r7 = r12.b().a();
        long r8 = r12.c();
        com.obric.aiagent.skill.virt.api.q r4 = r12.d();
        if (r4 == null) goto L18;
        String r5 = r4.b();
        if (r5 == null) goto L18;
    L19:
        com.obric.aiagent.skill.virt.impl.a.b r16 = new com.obric.aiagent.skill.virt.impl.a.b(r6, r7, r8, r5);
        com.obric.aiagent.skill.virt.api.q r17 = r12.d();
        r0.f22172c = 1;
        r15 = r11.a(r16, r17, r0);
        if (r15 != r2) goto L23;
        return r2;
    L18:
        r5 = "internal_sync";
    L7:
        r0 = new a(this, r14);
        goto L8
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.d
    public p a(String r2) {
        d.h.b.o.e(r2, "executionId");
        com.obric.aiagent.skill.virt.impl.c.a.d r1 = this.f22168b.c(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return f.a(r1);
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.d
    public boolean a(String r2, boolean r3) {
        d.h.b.o.e(r2, "executionId");
        return this.f22168b.a(r2, r3);
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.d
    public boolean b(String r2) {
        d.h.b.o.e(r2, "groupId");
        return this.f22168b.b(r2);
    }
}
