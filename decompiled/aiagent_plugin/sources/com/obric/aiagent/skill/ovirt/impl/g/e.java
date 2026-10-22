package com.obric.aiagent.skill.ovirt.impl.g;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.ovirt.impl.OVirt;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.aa;
import com.obric.aiagent.skill.virt.api.n;
import com.obric.aiagent.skill.virt.api.o;
import com.obric.aiagent.skill.virt.api.p;
import com.obric.aiagent.skill.virt.api.r;
import com.obric.aiagent.skill.virt.api.u;
import com.obric.aiagent.skill.virt.api.v;
import com.obric.aiagent.skill.virt.api.z;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.l;
import d.h.a.m;
import d.h.a.q;
import d.k;
import d.s;
import d.x;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ShellCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements IOVirtService.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OVirt f21375a;

    /* JADX INFO: compiled from: ShellCapability.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21376a = null;

        static {
            int[] r0 = new int[o.values().length];
            r0[o.f21585a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[o.f21586b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[o.f21587c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f21376a = r0;
        }
    }

    /* JADX INFO: compiled from: ShellCapability.kt */
    @d.c.b.a.f(b = "ShellCapability.kt", c = {205, 214}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability$monitorDetachedExecution$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f21379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.g.a f21380d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21381e;

        b(e r3, com.obric.aiagent.skill.ovirt.impl.g.a r4, com.obric.aiagent.skill.ovirt.impl.h.a r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21379c = r3;
            this.f21380d = r4;
            this.f21381e = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f21379c, this.f21380d, this.f21381e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ac -> B:16:0x0030). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21378b;
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L12;
            if (r1 != 2) goto L11;
            d.o.a(r9);     // Catch: Throwable -> L8
        L16:
            p r10 = e.b(this.f21379c).getShell().a(this.f21380d.a());     // Catch: Throwable -> L8
            if (r10 == null) goto L33;
            com.obric.aiagent.skill.ovirt.api.b.b.c r2 = this.f21381e.h().update(e.a(this.f21379c, r10));     // Catch: Throwable -> L8
            if (r2.f() == false) goto L28;
            i r11 = this.f21381e.h();     // Catch: Throwable -> L8
            String r5 = this.f21380d.a();     // Catch: Throwable -> L8
            com.obric.aiagent.skill.ovirt.impl.g.b r6 = this.f21381e.i();     // Catch: Throwable -> L8
            d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.c> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            this.f21377a = r2;     // Catch: Throwable -> L8
            this.f21378b = 1;     // Catch: Throwable -> L8
            r9 = r11.a(r5, r6, r7);     // Catch: Throwable -> L8
            if (r9 != r0) goto L24;
            return r0;
        L24:
            com.obric.aiagent.skill.ovirt.api.b.b.c r12 = (com.obric.aiagent.skill.ovirt.api.b.b.c) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.api.b.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            if (r12 == null) goto L28;
            r2 = r12;
        L28:
            this.f21380d.a(r2);     // Catch: Throwable -> L8
            if (r2.f() == true) goto L33;
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            this.f21377a = null;     // Catch: Throwable -> L8
            this.f21378b = 2;     // Catch: Throwable -> L8
            if (ax.a(1000, r13) != r0) goto L16;
            return r0;
        L33:
            this.f21380d.c();
            this.f21381e.b(this.f21380d);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r2 = (com.obric.aiagent.skill.ovirt.api.b.b.c) ZeusTransformUtils.preCheckCast(this.f21377a, com.obric.aiagent.skill.ovirt.api.b.b.c.class, "com.obric.aiagent.plugin");
            d.o.a(r9);     // Catch: Throwable -> L8
            goto L24
        L15:
            d.o.a(r9);
        L8:
            th = move-exception;
            this.f21380d.c();
            this.f21381e.b(this.f21380d);
            throw th;
        }
    }

    /* JADX INFO: compiled from: ShellCapability.kt */
    @d.c.b.a.f(b = "ShellCapability.kt", c = {55, 60, ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId}, d = "start", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21386e;
        final /* synthetic */ e f;
        int g;

        c(e r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21386e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellCapability.kt */
    @d.c.b.a.f(b = "ShellCapability.kt", c = {98, 121}, d = "start", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21390d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21391e;
        final /* synthetic */ e f;
        int g;

        d(e r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21391e = r3;
            this.g |= Integer.MIN_VALUE;
            return e.a(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.g.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellCapability.kt */
    @d.c.b.a.f(b = "ShellCapability.kt", c = {56}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability$start$locked$1")
    static final class C0449e extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21393b;

        C0449e(e r3, d.c.d<? super C0449e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21393b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((C0449e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0449e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0449e(this.f21393b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21392a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.c.b.a.b.a(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            kotlinx.coroutines.f.a r6 = e.a(this.f21393b).getMutex$impl_release();
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21392a = 1;
            if (kotlinx.coroutines.f.a.C1058a.a(r6, null, r2, 1, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShellCapability.kt */
    @d.c.b.a.f(b = "ShellCapability.kt", c = {151}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability$startAsync$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f21396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.g.a f21398e;
        final /* synthetic */ w<x> f;

        /* JADX INFO: compiled from: ShellCapability.kt */
        @d.c.b.a.f(b = "ShellCapability.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability$startAsync$1$result$1")
        static final class a extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21399a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ w<x> f21400b;

            a(w<x> r3, d.c.d<? super a> r4) {
                w<x> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21400b = r5;
                super(1, r6);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f21400b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f21399a != 0) goto L7;
                d.o.a(r2);
                this.f21400b.a(x.f38692a);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: ShellCapability.kt */
        @d.c.b.a.f(b = "ShellCapability.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability$startAsync$1$result$2")
        static final class b extends l implements m<p, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21401a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f21402b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.g.a f21403c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21404d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ e f21405e;

            b(com.obric.aiagent.skill.ovirt.impl.g.a r3, com.obric.aiagent.skill.ovirt.impl.h.a r4, e r5, d.c.d<? super b> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21403c = r3;
                this.f21404d = r4;
                this.f21405e = r5;
                super(2, r7);
            }

            public final Object a(p r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                b r0 = new b(this.f21403c, this.f21404d, this.f21405e, r7);
                r0.f21402b = r5;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(p r3, d.c.d<? super x> r4) {
                return a((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f21401a != 0) goto L7;
                d.o.a(r3);
                p r4 = (p) ZeusTransformUtils.preCheckCast(this.f21402b, p.class, "com.obric.aiagent.plugin");
                this.f21403c.a(this.f21404d.h().update(e.a(this.f21405e, r4)));
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: ShellCapability.kt */
        @d.c.b.a.f(b = "ShellCapability.kt", c = {165, 166}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability$startAsync$1$result$4")
        static final class c extends l implements q<n, m<? super Long, ? super Long, ? extends x>, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21406a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f21407b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f21408c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f21409d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21410e;
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.g.a f;

            c(e r3, com.obric.aiagent.skill.ovirt.impl.h.a r4, com.obric.aiagent.skill.ovirt.impl.g.a r5, d.c.d<? super c> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21409d = r3;
                this.f21410e = r4;
                this.f = r5;
                super(3, r7);
            }

            public final Object a(n r4, m<? super Long, ? super Long, x> r5, d.c.d<? super x> r6) {
                m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                c r0 = new c(this.f21409d, this.f21410e, this.f, r8);
                r0.f21407b = r4;
                r0.f21408c = r7;
                return r0.invokeSuspend(x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(n r3, m<? super Long, ? super Long, ? extends x> r4, d.c.d<? super x> r5) {
                return a((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21406a;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                m r2 = (m) ZeusTransformUtils.preCheckCast(this.f21407b, m.class, "com.obric.aiagent.plugin");
                d.o.a(r10);
            L17:
                com.obric.aiagent.skill.ovirt.api.b.b.a r11 = (com.obric.aiagent.skill.ovirt.api.b.b.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.ovirt.api.b.b.a.class, "com.obric.aiagent.plugin");
                this.f.a(r11);
                r2.invoke(d.c.b.a.b.a(r11.a().d().length()), d.c.b.a.b.a(r11.a().e().length()));
                return x.f38692a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                m r3 = (m) ZeusTransformUtils.preCheckCast(this.f21407b, m.class, "com.obric.aiagent.plugin");
                d.o.a(r10);
            L13:
                com.obric.aiagent.skill.ovirt.api.b.b.a r12 = (com.obric.aiagent.skill.ovirt.api.b.b.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.ovirt.api.b.b.a.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.ovirt.impl.d.a r4 = e.a(this.f21409d).getLifecycleDispatcher$impl_release();
                d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21407b = r3;
                this.f21406a = 2;
                r10 = r4.a(r12, r5);
                if (r10 != r0) goto L16;
                return r0;
            L16:
                r2 = r3;
                goto L17
            L10:
                d.o.a(r10);
                n r13 = (n) ZeusTransformUtils.preCheckCast(this.f21407b, n.class, "com.obric.aiagent.plugin");
                r3 = (m) ZeusTransformUtils.preCheckCast(this.f21408c, m.class, "com.obric.aiagent.plugin");
                e r6 = this.f21409d;
                i r7 = this.f21410e.h();
                com.obric.aiagent.skill.ovirt.impl.g.b r8 = this.f21410e.i();
                d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21407b = r3;
                this.f21406a = 1;
                r10 = e.a(r6, r13, r7, r8, r9);
                if (r10 != r0) goto L13;
                return r0;
            }
        }

        f(e r3, u r4, com.obric.aiagent.skill.ovirt.impl.h.a r5, com.obric.aiagent.skill.ovirt.impl.g.a r6, w<x> r7, d.c.d<? super f> r8) {
            w<x> r9 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21395b = r3;
            this.f21396c = r4;
            this.f21397d = r5;
            this.f21398e = r6;
            this.f = r9;
            super(2, r10);
        }

        public static /* synthetic */ x lambda$rIlEOHZ9BiRhPj0VrdXlPRiSxFo(com.obric.aiagent.skill.ovirt.impl.h.a r0, com.obric.aiagent.skill.ovirt.impl.g.a r1, r r2) {
            return a(r0, r1, r2);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f21395b, this.f21396c, this.f21397d, this.f21398e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21394a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r15);     // Catch: Throwable -> L7
        L16:
            if (((n) ZeusTransformUtils.preCheckCast(r15, n.class, "com.obric.aiagent.plugin")).b() != o.f21586b) goto L18;
            e.a(this.f21395b, this.f21397d, this.f21398e);     // Catch: Throwable -> L7
        L20:
            return x.f38692a;
        L18:
            this.f21397d.b(this.f21398e);     // Catch: Throwable -> L7
            goto L20
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r15);
            IVirtService.d r4 = e.b(this.f21395b).getShell();     // Catch: Throwable -> L7
            u r5 = this.f21396c;     // Catch: Throwable -> L7
            d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this.f, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            m r8 = (m) ZeusTransformUtils.preCheckCast(new b(this.f21398e, this.f21397d, this.f21395b, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            final com.obric.aiagent.skill.ovirt.impl.h.a r2 = this.f21397d;     // Catch: Throwable -> L7
            final com.obric.aiagent.skill.ovirt.impl.g.a r9 = this.f21398e;     // Catch: Throwable -> L7
            d.h.a.b r10 = new $$Lambda$e$f$rIlEOHZ9BiRhPj0VrdXlPRiSxFo(r2, r9);     // Catch: Throwable -> L7
            q r3 = (q) ZeusTransformUtils.preCheckCast(new c(this.f21395b, this.f21397d, this.f21398e, null), q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f21394a = 1;     // Catch: Throwable -> L7
            r15 = IVirtService.d.a.a(r4, r5, null, r16, r8, r10, r3, r11, 2, null);     // Catch: Throwable -> L7
            if (r15 != r0) goto L16;
            return r0;
        L7:
            th = move-exception;
            if (IAppContext.Companion.isDebug() == false) goto L24;
            ILogDepend.Companion.e("SkRt/Handle", "start: IVirtService start failed executionId=" + this.f21398e.a() + " shellGroupId=" + this.f21397d.c(), th);
        L25:
            this.f21398e.a(th);
            this.f21397d.b(this.f21398e);
            this.f.a(th);
            throw th;
        L24:
            ILogDepend.Companion.w("SkRt/Handle", "start: IVirtService start failed");
            goto L25
        }

        private static final x a(com.obric.aiagent.skill.ovirt.impl.h.a r1, com.obric.aiagent.skill.ovirt.impl.g.a r2, r r3) {
            r1.h().a(r3);
            com.obric.aiagent.skill.ovirt.api.b.b.c r4 = r1.h().a(r3.b());
            if (r4 == null) goto L6;
            r2.a(r4);
        L6:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ShellCapability.kt */
    @d.c.b.a.f(b = "ShellCapability.kt", c = {287}, d = "toApi", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellCapability")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f21414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21415e;

        g(e r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21414d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21413c = r3;
            this.f21415e |= Integer.MIN_VALUE;
            return e.a(this.f21414d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public e(OVirt r2) {
        d.h.b.o.e(r2, "owner");
        this.f21375a = r2;
    }

    public static final /* synthetic */ OVirt a(e r0) {
        return r0.f21375a;
    }

    public static final /* synthetic */ j a(e r0, p r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(e r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, com.obric.aiagent.skill.ovirt.api.b.a r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(e r2, n r3, i r4, com.obric.aiagent.skill.ovirt.impl.g.b r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(e r0, com.obric.aiagent.skill.ovirt.impl.h.a r1, com.obric.aiagent.skill.ovirt.impl.g.a r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ IVirtService b(e r0) {
        return r0.a();
    }

    private final IVirtService a() {
        return this.f21375a.getVirt$impl_release();
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.d
    public com.obric.aiagent.skill.ovirt.api.b.b.c a(String r4, String r5) {
        d.h.b.o.e(r4, "uniqueId");
        d.h.b.o.e(r5, "executionId");
        com.obric.aiagent.skill.ovirt.impl.h.a r6 = this.f21375a.activeState$impl_release(r4);
        if (r6 != null) goto L6;
        return null;
    L6:
        this.f21375a.assertShellEnabled$impl_release("snapshotExecution", r6.a());
        return a(r6, r5);
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.d
    public boolean a(String r4, String r5, boolean r6) {
        d.h.b.o.e(r4, "uniqueId");
        d.h.b.o.e(r5, "executionId");
        if (this.f21375a.activeState$impl_release(r4) != null) goto L6;
        return false;
    L6:
        OVirt.assertShellEnabled$impl_release$default(this.f21375a, "cancel", null, 2, null);
        return a().getShell().a(r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [com.obric.aiagent.skill.ovirt.api.b.a] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.aiagent.skill.ovirt.impl.g.e] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.aiagent.skill.ovirt.impl.g.e] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.aiagent.skill.ovirt.impl.g.e] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.d
    public Object a(String r29, com.obric.aiagent.skill.ovirt.api.b.a r30, d.c.d<? super com.obric.aiagent.skill.ovirt.api.d> r31) {
        e r0 = this;
        ?? r1 = r29;
        ?? r2 = r30;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r6.g & Integer.MIN_VALUE) == 0) goto L7;
        r6.g -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f21386e;
        Object r7 = d.c.a.b.a();
        int r8 = r6.g;
        if (r8 == 0) goto L26;
        if (r8 == 1) goto L25;
        if (r8 == 2) goto L24;
        if (r8 != 3) goto L23;
        com.obric.aiagent.skill.ovirt.impl.h.a r3 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r6.f21383b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        e r9 = (e) ZeusTransformUtils.preCheckCast(r6.f21382a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r1 = r3;
        r2 = r9;
    L48:
        com.obric.aiagent.skill.ovirt.api.d r10 = (com.obric.aiagent.skill.ovirt.api.d) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.d.c((com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin")), com.obric.aiagent.skill.ovirt.api.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        ?? r11 = r2;
    L56:
        kotlinx.coroutines.f.a.C1058a.b(r11.f21375a.getMutex$impl_release(), null, 1, null);
        return r10;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        long r12 = r6.f21385d;
        com.obric.aiagent.skill.ovirt.api.b.a r13 = (com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r6.f21384c, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r6.f21383b, String.class, "com.obric.aiagent.plugin");
        e r15 = (e) ZeusTransformUtils.preCheckCast(r6.f21382a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r0 = r15;
        long r16 = r12;
        ?? r17 = r14;
        ?? r18 = r13;
    L36:
        ?? r19 = r18;
        boolean r20 = true;
        ?? r21 = r17;
    L32:
        e r22 = r0;
        if (r20 == false) goto L39;
        com.obric.aiagent.skill.ovirt.impl.h.a r23 = r22.f21375a.activeState$impl_release(r21);     // Catch: Throwable -> L59
        if (r23 != null) goto L45;
        com.obric.aiagent.skill.ovirt.api.d.C0441d r24 = new com.obric.aiagent.skill.ovirt.api.d.C0441d("OVirt is not active");     // Catch: Throwable -> L59
        kotlinx.coroutines.f.a.C1058a.b(r22.f21375a.getMutex$impl_release(), null, 1, null);
        return r24;
    L45:
        com.obric.aiagent.skill.ovirt.api.b.a r25 = com.obric.aiagent.skill.ovirt.api.b.a.a(r19, null, null, null, 0, null, null, d.l.n.a(r19.g() - r22.f21375a.elapsedSince$impl_release(r16), 0), null, 191, null);     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r6.f21382a = r22;     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r6.f21383b = r23;     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r6.f21384c = null;     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r6.g = 3;     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r5 = r22.a(r23, r25, r6);     // Catch: Throwable -> L16 v -> L18 CancellationException -> L20
        r1 = r23;
        r2 = r22;
        if (r5 != r7) goto L48;
        return r7;
    L39:
        return new com.obric.aiagent.skill.ovirt.api.d.a(null, "Timed out waiting for exclusive execution", 1, null);
    L25:
        long r26 = r6.f21385d;
        com.obric.aiagent.skill.ovirt.api.b.a r27 = (com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r6.f21384c, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin");
        String r28 = (String) ZeusTransformUtils.preCheckCast(r6.f21383b, String.class, "com.obric.aiagent.plugin");
        e r32 = (e) ZeusTransformUtils.preCheckCast(r6.f21382a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r0 = r32;
        ?? r33 = r28;
        Object r34 = r5;
        r16 = r26;
        ?? r35 = r27;
    L31:
        r20 = d.h.b.o.a(r34, d.c.b.a.b.a(true));
        r19 = r35;
        r21 = r33;
        goto L32
    L26:
        d.o.a(r5);
        r16 = SystemClock.elapsedRealtime();
        if (r0.f21375a.getExclusiveExecutionRequested$impl_release().get() == false) goto L33;
        long r110 = r30.g();
        m r36 = (m) ZeusTransformUtils.preCheckCast(new C0449e(r0, null), m.class, "com.obric.aiagent.plugin");
        r6.f21382a = r0;
        r6.f21383b = r1;
        r6.f21384c = r2;
        r6.f21385d = r16;
        r6.g = 1;
        r34 = dg.b(r110, r36, r6);
        r33 = r1;
        r35 = r2;
        if (r34 != r7) goto L31;
        return r7;
    L33:
        kotlinx.coroutines.f.a r37 = r0.f21375a.getMutex$impl_release();
        r6.f21382a = r0;
        r6.f21383b = r1;
        r6.f21384c = r2;
        r6.f21385d = r16;
        r6.g = 2;
        r17 = r1;
        r18 = r2;
        if (kotlinx.coroutines.f.a.C1058a.a(r37, null, r6, 1, null) != r7) goto L36;
        return r7;
    L59:
        th = move-exception;
        kotlinx.coroutines.f.a.C1058a.b(r2.f21375a.getMutex$impl_release(), null, 1, null);
        throw th;
    L20:
        e = move-exception;
        throw e;     // Catch: Throwable -> L59
    L18:
        e = move-exception;
        String r38 = e.a();     // Catch: Throwable -> L59
        if (r38 == null) goto L54;
        com.obric.aiagent.skill.ovirt.api.b.b.c r39 = r2.a(r1, r38);     // Catch: Throwable -> L59
    L55:
        r10 = (com.obric.aiagent.skill.ovirt.api.d) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.d.a(r39, r2.f21375a.busyReason$impl_release(e)), com.obric.aiagent.skill.ovirt.api.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        r11 = r2;
        goto L56
    L54:
        r39 = null;
    L16:
        th = move-exception;
        r10 = (com.obric.aiagent.skill.ovirt.api.d) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.d.b(th), com.obric.aiagent.skill.ovirt.api.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        r11 = r2;
    L7:
        r6 = new c(r0, r4);
        goto L8
    }

    private final Object a(com.obric.aiagent.skill.ovirt.impl.h.a r20, com.obric.aiagent.skill.ovirt.api.b.a r21, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.g.a> r22) {
        e r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f21391e;
        Object r4 = d.c.a.b.a();
        int r5 = r3.g;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L21;
        if (r5 != 2) goto L20;
        com.obric.aiagent.skill.ovirt.impl.g.a r6 = (com.obric.aiagent.skill.ovirt.impl.g.a) ZeusTransformUtils.preCheckCast(r3.f21389c, com.obric.aiagent.skill.ovirt.impl.g.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.api.b.a r7 = (com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r3.f21388b, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.h.a r8 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r3.f21387a, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: CancellationException -> L15 v -> L17 Throwable -> L47
    L34:
        if (IAppContext.Companion.isDebug() == false) goto L41;
        ILogDepend.Companion r9 = ILogDepend.Companion;
        StringBuilder r10 = new StringBuilder().append("execute: launched shellGroupId=").append(r8.c()).append(" pendingId=").append(r6.a()).append(" workDir=");
        com.obric.aiagent.skill.virt.api.x r11 = r7.b();
        if (r11 == null) goto L39;
        String r12 = r11.a();
        if (r12 == null) goto L39;
    L40:
        r9.i("SkRt/Shell", r10.append(r12).append(" cmd=").append(r7.a()).toString());
    L42:
        return r6;
    L39:
        r12 = r8.d().a().a();
        goto L40
    L41:
        ILogDepend.Companion.i("SkRt/Shell", "execute: launched");
        goto L42
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        long r13 = r3.f21390d;
        com.obric.aiagent.skill.ovirt.api.b.a r14 = (com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r3.f21389c, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.h.a r15 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r3.f21388b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        e r16 = (e) ZeusTransformUtils.preCheckCast(r3.f21387a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        long r17 = r13;
        Object r18 = r2;
        com.obric.aiagent.skill.ovirt.api.b.a r19 = r14;
        r0 = r16;
    L28:
        Map<String, String> r110 = (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.aiagent.plugin");
        String r23 = r0.b();
        u r111 = r0.a(r15.c(), r23, r15.b(), r110, r19, r15.d(), r17);
        com.obric.aiagent.skill.ovirt.impl.g.a r112 = new com.obric.aiagent.skill.ovirt.impl.g.a(r0.a(), r15.c(), r23, r15.h(), r15.h().a(r0.a(r23, r111)));
        w<x> r24 = y.a(null, 1, null);
        r15.a(r112);
        r0.a(r15, r111, r112, r24);
        r3.f21387a = r15;     // Catch: CancellationException -> L15 v -> L17 Throwable -> L48
        r3.f21388b = r19;     // Catch: CancellationException -> L15 v -> L17 Throwable -> L48
        r3.f21389c = r112;     // Catch: CancellationException -> L15 v -> L17 Throwable -> L48
        r3.g = 2;     // Catch: CancellationException -> L15 v -> L17 Throwable -> L48
        if (r24.a(r3) != r4) goto L32;
        return r4;
    L32:
        r7 = r19;
        r8 = r15;
        r6 = r112;
        goto L34
    L22:
        d.o.a(r2);
        long r25 = SystemClock.elapsedRealtime();
        r0.f21375a.assertShellEnabled$impl_release("execute", r20.a());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L46;
        com.obric.aiagent.skill.ovirt.impl.d.a r26 = r0.f21375a.getLifecycleDispatcher$impl_release();
        String r27 = r20.a();
        r3.f21387a = r0;
        r3.f21388b = r20;
        r3.f21389c = r21;
        r3.f21390d = r25;
        r3.g = 1;
        Object r28 = r26.a(r27, r3);
        if (r28 != r4) goto L27;
        return r4;
    L27:
        r17 = r25;
        r15 = r20;
        r18 = r28;
        r19 = r21;
        goto L28
    L46:
        throw new IllegalArgumentException("OVirtShellRequest.command must not be blank".toString());
    L17:
        e = move-exception;
        throw e;
    L15:
        e = move-exception;
        throw e;
    L7:
        r3 = new d(r0, r1);
        goto L8
    }

    private final void a(com.obric.aiagent.skill.ovirt.impl.h.a r15, u r16, com.obric.aiagent.skill.ovirt.impl.g.a r17, w<x> r18) {
        w r7 = (w) ZeusTransformUtils.wrapperContextForParams(r18, w.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.b(r15.g(), null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r16, r15, r17, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(com.obric.aiagent.skill.ovirt.impl.h.a r7, com.obric.aiagent.skill.ovirt.impl.g.a r8) {
        kotlinx.coroutines.i.b(r7.g(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r8, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final u a(String r26, String r27, Map<String, String> r28, Map<String, String> r29, com.obric.aiagent.skill.ovirt.api.b.a r30, com.obric.aiagent.skill.virt.api.y r31, long r32) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.api.x r3 = r30.b();
        if (r3 != null) goto L5;
        r3 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r31.a(), com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");
    L5:
        Map r8 = ao.a(ao.a(ao.a(a(r31), r0), r2), r30.c());
        String r5 = r30.a();
        long r9 = r30.d();
        Long r11 = r30.e();
        Long r12 = r30.f();
        long r13 = r30.g();
        String r17 = r30.h();
        return new u(r5, r3, r27, r8, r9, r11, r12, r13, r26, new com.obric.aiagent.skill.virt.api.q(MemorySourceLinkType.INTENT, null, r32, 2, null), r17);
    }

    private final Map<String, String> a(com.obric.aiagent.skill.virt.api.y r11) {
        return ao.a(s.a("PATH", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{r11.a(".obric/bin").a(), r11.a(".local/bin").a(), "/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin", r11.a(".npm-global/bin").a()}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null)));
    }

    private final j a(String r20, u r21) {
        String r0 = r21.i();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return new j(r0, r20, r21.b().a(), r21.a(), "pending", false, null, false, System.currentTimeMillis(), 0, null, null, null, 6144, null);
    }

    private final Object a(n r12, i r13, com.obric.aiagent.skill.ovirt.impl.g.b r14, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin");
        if ((r0.f21415e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21415e -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f21413c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21415e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.aiagent.skill.ovirt.api.b.b.c r11 = (com.obric.aiagent.skill.ovirt.api.b.b.c) ZeusTransformUtils.preCheckCast(r0.f21412b, com.obric.aiagent.skill.ovirt.api.b.b.c.class, "com.obric.aiagent.plugin");
        r12 = (n) ZeusTransformUtils.preCheckCast(r0.f21411a, n.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L19:
        com.obric.aiagent.skill.ovirt.api.b.b.c r18 = (com.obric.aiagent.skill.ovirt.api.b.b.c) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.ovirt.api.b.b.c.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L23;
        com.obric.aiagent.skill.ovirt.api.b.b.c r6 = r18;
    L24:
        int r19 = a.f21376a[r12.b().ordinal()];
        if (r19 != 1) goto L27;
        com.obric.aiagent.skill.ovirt.api.b.b.EnumC0440b r110 = com.obric.aiagent.skill.ovirt.api.b.b.EnumC0440b.f20978a;
    L36:
        return new com.obric.aiagent.skill.ovirt.api.b.b.a(r6, r110, null, 4, null);
    L27:
        if (r19 != 2) goto L29;
        r110 = com.obric.aiagent.skill.ovirt.api.b.b.EnumC0440b.f20979b;
        goto L36
    L29:
        if (r19 != 3) goto L32;
        r110 = com.obric.aiagent.skill.ovirt.api.b.b.EnumC0440b.f20980c;
        goto L36
    L32:
        throw new k();
    L23:
        r6 = r11;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        r11 = r13.update(a(r12.a()));
        if (r11.f() == false) goto L23;
        String r111 = r11.a();
        r0.f21411a = r12;
        r0.f21412b = r11;
        r0.f21415e = 1;
        r17 = r13.a(r111, r14, r0);
        if (r17 != r2) goto L19;
        return r2;
    L7:
        r0 = new g(this, r16);
        goto L8
    }

    public final com.obric.aiagent.skill.ovirt.api.b.b.c a(com.obric.aiagent.skill.ovirt.impl.h.a r4, String r5) {
        d.h.b.o.e(r4, "state");
        d.h.b.o.e(r5, "executionId");
        p r0 = a().getShell().a(r5);
        if (r0 == null) goto L13;
        if (d.h.b.o.a(r0.a(), r4.c()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        j r3 = a(r0);
        if (r3 == null) goto L13;
        r4.h().update(r3);
    L13:
        return r4.h().a(r5);
    }

    private final j a(p r20) {
        return new j(r20.a(), r20.b(), r20.c(), r20.d(), r20.e(), r20.f(), r20.g(), r20.h(), r20.i(), r20.j(), r20.k(), null, null, 6144, null);
    }

    private final String b() {
        char[] r0 = new char[6];
        int r1 = 0;
    L3:
        if (r1 >= 6) goto L6;
        r0[r1] = "0123456789abcdefghijklmnopqrstuvwxyz".charAt(com.obric.aiagent.skill.ovirt.impl.g.f.a().nextInt(36));
        r1 = r1 + 1;
        goto L3
    L6:
        return "sh_" + new String(r0);
    }

    public final Object a(com.obric.aiagent.skill.virt.api.x r9, String r10, long r11, String r13, d.c.d<? super z> r14) {
        com.obric.aiagent.skill.virt.api.x r4 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");
        d.c.d<? super z> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return a().getShell().a(new aa(r10, r4, r11, new com.obric.aiagent.skill.virt.api.q("primitive", r13, SystemClock.elapsedRealtime())), r12);
    }
}
