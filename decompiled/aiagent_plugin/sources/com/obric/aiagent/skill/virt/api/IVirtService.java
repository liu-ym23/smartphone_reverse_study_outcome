package com.obric.aiagent.skill.virt.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IVirtService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: VirtService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f21541a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f21542b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile IVirtService f21543c;

        private a() {
        }

        static {
            f21541a = new a();
            f21542b = new Object();
        }

        public final IVirtService a() {
            IVirtService r3 = f21543c;
            if (r3 == null) goto L5;
            return r3;
        L5:
            Object r4 = f21542b;
            monitor-enter(r4);
            IVirtService r0 = f21543c;     // Catch: Throwable -> L16
            if (r0 != null) goto L14;
            r0 = (IVirtService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtService.class), IVirtService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r0 == null) goto L13;
            f21543c = r0;     // Catch: Throwable -> L16
            goto L14
        L13:
            r0 = null;
        L14:
            monitor-exit(r4);
            return r0;
        L16:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: VirtService.kt */
    public interface b {

        /* JADX INFO: compiled from: VirtService.kt */
        public static final class a {
            public static /* synthetic */ Object a(b r7, g r8, x r9, f r10, d.c.d r11, int r12, Object r13) {
                b r14 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
                g r15 = (g) ZeusTransformUtils.wrapperContextForParams(r8, g.class, "com.obric.aiagent.plugin");
                x r16 = (x) ZeusTransformUtils.wrapperContextForParams(r9, x.class, "com.obric.aiagent.plugin");
                d.c.d<? super h> r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                if (r13 != null) goto L10;
                if ((r12 & 4) == 0) goto L8;
                r10 = new f(false, false, false, false, 15, null);
            L8:
                return r14.a(r15, r16, r10, r17);
            L10:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importFile");
            }
        }

        Object a(g r1, x r2, f r3, d.c.d<? super h> r4);

        Object a(x r1, com.obric.aiagent.skill.virt.api.c r2, com.obric.aiagent.skill.virt.api.b r3, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r4);
    }

    /* JADX INFO: compiled from: VirtService.kt */
    public interface c {
        Object close(d.c.d<? super d.x> r1);

        y getPaths();

        boolean isBackendSupported();

        Object open(d.c.d<? super d.x> r1);
    }

    /* JADX INFO: compiled from: VirtService.kt */
    public interface d {

        /* JADX INFO: compiled from: VirtService.kt */
        public static final class a {

            /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.api.IVirtService$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: VirtService.kt */
            @d.c.b.a.f(b = "VirtService.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.api.IVirtService$Shell$startAsync$1")
            static final class C0455a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21544a;

                C0455a(d.c.d<? super C0455a> r3) {
                    super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(d.c.d<? super d.x> r3) {
                    return ((C0455a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C0455a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<d.x> create(d.c.d<?> r2) {
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0455a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r1) {
                    d.c.a.b.a();
                    if (this.f21544a != 0) goto L7;
                    d.o.a(r1);
                    return d.x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: compiled from: VirtService.kt */
            @d.c.b.a.f(b = "VirtService.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.api.IVirtService$Shell$startAsync$2")
            static final class b extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21545a;

                b(d.c.d<? super b> r3) {
                    super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(d.c.d<? super d.x> r3) {
                    return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<d.x> create(d.c.d<?> r2) {
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r1) {
                    d.c.a.b.a();
                    if (this.f21545a != 0) goto L7;
                    d.o.a(r1);
                    return d.x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: compiled from: VirtService.kt */
            @d.c.b.a.f(b = "VirtService.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.api.IVirtService$Shell$startAsync$3")
            static final class c extends d.c.b.a.l implements d.h.a.m<p, d.c.d<? super d.x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21546a;

                c(d.c.d<? super c> r3) {
                    super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(p r3, d.c.d<? super d.x> r4) {
                    return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(p r3, d.c.d<? super d.x> r4) {
                    return a((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r1) {
                    d.c.a.b.a();
                    if (this.f21546a != 0) goto L7;
                    d.o.a(r1);
                    return d.x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.api.IVirtService$d$a$d, reason: collision with other inner class name */
            /* JADX INFO: compiled from: VirtService.kt */
            @d.c.b.a.f(b = "VirtService.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.api.IVirtService$Shell$startAsync$5")
            static final class C0456d extends d.c.b.a.l implements d.h.a.q<n, d.h.a.m<? super Long, ? super Long, ? extends d.x>, d.c.d<? super d.x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21547a;

                C0456d(d.c.d<? super C0456d> r3) {
                    super(3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(n r1, d.h.a.m<? super Long, ? super Long, d.x> r2, d.c.d<? super d.x> r3) {
                    d.h.a.m r0 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
                    return new C0456d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
                }

                @Override // d.h.a.q
                public /* synthetic */ Object invoke(n r3, d.h.a.m<? super Long, ? super Long, ? extends d.x> r4, d.c.d<? super d.x> r5) {
                    return a((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(r4, d.h.a.m.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r1) {
                    d.c.a.b.a();
                    if (this.f21547a != 0) goto L7;
                    d.o.a(r1);
                    return d.x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public static /* synthetic */ d.x lambda$e8x7XQdxcuBJI88v7X07Cs6soIc(r r0) {
                return a(r0);
            }

            /* JADX INFO: renamed from: lambda$ut6ATrvy0Um-z35cpuOPSzNJuNs, reason: not valid java name */
            public static /* synthetic */ d.x m370lambda$ut6ATrvy0Umz35cpuOPSzNJuNs() {
                return a();
            }

            private static d.x a() {
                return d.x.f38692a;
            }

            public static /* synthetic */ Object a(d r2, d.h.a.a r3, d.h.a.b r4, d.c.d r5, int r6, Object r7) {
                d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
                d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                if (r7 != null) goto L10;
                if ((r6 & 1) == 0) goto L8;
                r9 = $$Lambda$IVirtService$d$a$ut6ATrvy0Umz35cpuOPSzNJuNs.INSTANCE;
            L8:
                return r8.a(r9, r10, r11);
            L10:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withExclusiveExecution");
            }

            public static /* synthetic */ Object a(d r5, u r6, d.h.a.b r7, d.h.a.b r8, d.h.a.m r9, d.h.a.b r10, d.h.a.q r11, d.c.d r12, int r13, Object r14) {
                d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.h.a.m<? super p, ? super d.c.d<? super d.x>, ? extends Object> r18 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
                d.h.a.b<? super r, d.x> r19 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.h.a.q<? super n, ? super d.h.a.m<? super Long, ? super Long, d.x>, ? super d.c.d<? super d.x>, ? extends Object> r110 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.q.class, "com.obric.aiagent.plugin");
                d.c.d<? super n> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
                if (r14 != null) goto L26;
                if ((r13 & 2) == 0) goto L7;
                r16 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new C0455a(null), d.h.a.b.class, "com.obric.aiagent.plugin");
            L7:
                d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r111 = r16;
                if ((r13 & 4) == 0) goto L10;
                d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.b.class, "com.obric.aiagent.plugin");
            L12:
                if ((r13 & 8) == 0) goto L14;
                d.h.a.m<? super p, ? super d.c.d<? super d.x>, ? extends Object> r3 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin");
            L16:
                if ((r13 & 16) == 0) goto L18;
                d.h.a.b<? super r, d.x> r4 = $$Lambda$IVirtService$d$a$e8x7XQdxcuBJI88v7X07Cs6soIc.INSTANCE;
            L20:
                if ((r13 & 32) == 0) goto L22;
                d.h.a.q<? super n, ? super d.h.a.m<? super Long, ? super Long, d.x>, ? super d.c.d<? super d.x>, ? extends Object> r112 = (d.h.a.q) ZeusTransformUtils.preCheckCast(new C0456d(null), d.h.a.q.class, "com.obric.aiagent.plugin");
            L24:
                return r15.a(r6, r111, r2, r3, r4, r112, r0);
            L22:
                r112 = r110;
                goto L24
            L18:
                r4 = r19;
                goto L20
            L14:
                r3 = r18;
                goto L16
            L10:
                r2 = r17;
                goto L12
            L26:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAsync");
            }

            private static d.x a(r r1) {
                d.h.b.o.e(r1, "it");
                return d.x.f38692a;
            }
        }

        p a(String r1);

        Object a(aa r1, d.c.d<? super z> r2);

        Object a(u r1, d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r2, d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r3, d.h.a.m<? super p, ? super d.c.d<? super d.x>, ? extends Object> r4, d.h.a.b<? super r, d.x> r5, d.h.a.q<? super n, ? super d.h.a.m<? super Long, ? super Long, d.x>, ? super d.c.d<? super d.x>, ? extends Object> r6, d.c.d<? super n> r7);

        <T> Object a(d.h.a.a<d.x> r1, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r2, d.c.d<? super T> r3);

        boolean a(String r1, boolean r2);

        boolean b(String r1);
    }

    static {
        Companion = a.f21541a;
    }

    b getFiles();

    c getLifecycle();

    d getShell();
}
