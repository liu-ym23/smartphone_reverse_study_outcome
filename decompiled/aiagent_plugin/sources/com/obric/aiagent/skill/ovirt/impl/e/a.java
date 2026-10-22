package com.obric.aiagent.skill.ovirt.impl.e;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.ovirt.impl.OVirt;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.v;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.aiagent.skill.virt.api.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.k;
import d.n;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.co;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: MaintenanceCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IOVirtService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OVirt f21216a;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaintenanceCapability.kt */
    @f(b = "MaintenanceCapability.kt", c = {118, 85, 87, 96, 96, 96, 96}, d = "access", e = "com.obric.aiagent.skill.ovirt.impl.maintenance.MaintenanceCapability")
    static final class C0445a<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21221e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        C0445a(a r3, d.c.d<? super C0445a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return a.a(this.g, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: MaintenanceCapability.kt */
    @f(b = "MaintenanceCapability.kt", c = {87}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.maintenance.MaintenanceCapability$access$2$1")
    static final class b<T> extends l implements d.h.a.b<d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m<com.obric.aiagent.skill.virt.api.e, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>>, Object> f21223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.e f21224c;

        b(m<? super com.obric.aiagent.skill.virt.api.e, ? super d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>>, ? extends Object> r3, com.obric.aiagent.skill.virt.api.e r4, d.c.d<? super b> r5) {
            m<com.obric.aiagent.skill.virt.api.e, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21223b = r6;
            this.f21224c = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f21223b, this.f21224c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(Object r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21222a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r4);
            m<com.obric.aiagent.skill.virt.api.e, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>>, Object> r5 = this.f21223b;
            com.obric.aiagent.skill.virt.api.e r2 = this.f21224c;
            this.f21222a = 1;
            r4 = r5.invoke(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MaintenanceCapability.kt */
    @f(b = "MaintenanceCapability.kt", c = {97}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.maintenance.MaintenanceCapability$access$2$2")
    static final class c extends l implements m<am, d.c.d<? super n<? extends x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f21226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f21227c;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21226b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super n<x>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f21226b, r5);
            r0.f21227c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super n<? extends x>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21225a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            o.a(r5);     // Catch: Throwable -> L15
        L13:
            Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L15
        L18:
            return n.g(r4);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.f21227c, am.class, "com.obric.aiagent.plugin");
            a r7 = this.f21226b;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L15
            IVirtService.c r8 = a.a(r7).getVirt$impl_release().getLifecycle();     // Catch: Throwable -> L15
            this.f21225a = 1;     // Catch: Throwable -> L15
            if (r8.close(this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            n.a r9 = n.f38560a;
            r4 = n.f(o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: MaintenanceCapability.kt */
    @f(b = "MaintenanceCapability.kt", c = {22}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.maintenance.MaintenanceCapability$calculateHomeUsageBytes$2")
    static final class d extends l implements m<com.obric.aiagent.skill.virt.api.e, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends Long>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21230c;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.e.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaintenanceCapability.kt */
        /* synthetic */ class C0446a extends d.h.b.l implements d.h.a.b<String, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0446a f21231a = null;

            static {
                f21231a = new C0446a();
            }

            C0446a() {
                super(1, d.o.o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
            }

            public final String a(String r2) {
                d.h.b.o.e(r2, "p0");
                return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            }

            @Override // d.h.a.b
            public /* synthetic */ String invoke(String r3) {
                return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            }
        }

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21230c = r3;
            super(2, r5);
        }

        public final Object a(com.obric.aiagent.skill.virt.api.e r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<Long>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f21230c, r5);
            r0.f21229b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.virt.api.e r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends Long>> r4) {
            return a((com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21228a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r13);
        L11:
            z r12 = (z) ZeusTransformUtils.preCheckCast(r13, z.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r12, z.b.class) == true) goto L14;
            d.h.b.o.a(r12, "null cannot be cast to non-null type com.obric.aiagent.skill.virt.api.VirtSyncShellResult.Completed");
            z.a r14 = (z.a) ZeusTransformUtils.preCheckCast(r12, z.a.class, "com.obric.aiagent.plugin");
            if (((z.a) ZeusTransformUtils.preCheckCast(r12, z.a.class, "com.obric.aiagent.plugin")).b() != 0) goto L18;
            Iterator r15 = d.n.m.d(d.o.o.f((CharSequence) ZeusTransformUtils.preCheckCast(((z.a) ZeusTransformUtils.preCheckCast(r12, z.a.class, "com.obric.aiagent.plugin")).c(), CharSequence.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(C0446a.f21231a, d.h.a.b.class, "com.obric.aiagent.plugin")).a();
        L21:
            if (r15.hasNext() == false) goto L25;
            Object r16 = r15.next();
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L21;
        L26:
            String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L37;
            Long r18 = d.o.o.e(r17);
            if (r18 == null) goto L37;
            long r19 = r18.longValue();
            if (r19 <= 9007199254740991L) goto L33;
            long r110 = Long.MAX_VALUE;
        L35:
            return new com.obric.aiagent.skill.ovirt.api.a.c(d.c.b.a.b.a(r110));
        L33:
            r110 = d.l.n.a(r19, 0) * 1024;
        L37:
            return new com.obric.aiagent.skill.ovirt.api.a.b((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("HOME usage output is invalid"), Throwable.class, "com.obric.aiagent.plugin"));
        L25:
            r16 = null;
            goto L26
        L18:
            return new com.obric.aiagent.skill.ovirt.api.a.b((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("HOME usage command failed"), Throwable.class, "com.obric.aiagent.plugin"));
        L14:
            return com.obric.aiagent.skill.ovirt.api.a.d.f20943a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r13);
            com.obric.aiagent.skill.virt.api.e r111 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(this.f21229b, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
            String r2 = com.obric.aiagent.skill.ovirt.impl.a.a(r111.a());
            d.c.d<? super z> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21228a = 1;
            r13 = a.a(this.f21230c).getShellCapability$impl_release().a((com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin"), "du -sk -- " + r2 + " 2>/dev/null | awk 'NR==1 { print $1 }'", OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, SensitiveType.UNKNOWN, r11);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MaintenanceCapability.kt */
    @f(b = "MaintenanceCapability.kt", c = {56}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.maintenance.MaintenanceCapability$clearHome$2")
    static final class e extends l implements m<com.obric.aiagent.skill.virt.api.e, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21234c;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21234c = r3;
            super(2, r5);
        }

        public final Object a(com.obric.aiagent.skill.virt.api.e r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<x>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f21234c, r5);
            r0.f21233b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.virt.api.e r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends x>> r4) {
            return a((com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21232a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L11:
            z r11 = (z) ZeusTransformUtils.preCheckCast(r12, z.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, z.b.class) == false) goto L15;
            return (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.ovirt.api.a.d.f20943a, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        L15:
            if (ZeusTransformUtils.instanceOf(r11, z.a.class) == false) goto L22;
            if (((z.a) ZeusTransformUtils.preCheckCast(r11, z.a.class, "com.obric.aiagent.plugin")).b() != 0) goto L20;
            return (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.c(x.f38692a), com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        L20:
            return (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.b((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("HOME cleanup command failed"), Throwable.class, "com.obric.aiagent.plugin")), com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        L22:
            throw new k();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            com.obric.aiagent.skill.virt.api.e r13 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(this.f21233b, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
            String r2 = com.obric.aiagent.skill.ovirt.impl.a.a(r13.a());
            com.obric.aiagent.skill.ovirt.impl.g.e r4 = a.a(this.f21234c).getShellCapability$impl_release();
            com.obric.aiagent.skill.virt.api.x r5 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");
            d.c.d<? super z> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21232a = 1;
            r12 = r4.a(r5, "if [ -d " + r2 + " ]; then find " + r2 + " -mindepth 1 -maxdepth 1 -exec rm -rf -- {} +; fi", 60000, SensitiveType.UNKNOWN, r10);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    public a(OVirt r2) {
        d.h.b.o.e(r2, "owner");
        this.f21216a = r2;
    }

    public static final /* synthetic */ OVirt a(a r0) {
        return r0.f21216a;
    }

    public static final /* synthetic */ Object a(a r2, m r3, d.c.d r4) {
        return r2.a((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.c
    public Object a(d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<Long>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a((m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.c
    public Object b(d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<x>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a((m) ZeusTransformUtils.preCheckCast(new e(this, null), m.class, "com.obric.aiagent.plugin"), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0341: MOVE (r1 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:137:0x0341 */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25, types: [com.obric.aiagent.skill.ovirt.impl.e.a] */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v34 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v4, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.aiagent.skill.ovirt.impl.e.a] */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.obric.aiagent.skill.ovirt.impl.e.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [d.h.a.m] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [d.h.a.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v37, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r2v46, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.obric.aiagent.skill.ovirt.impl.e.a$a, d.c.d] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.obric.aiagent.skill.ovirt.impl.e.a$a, d.c.d] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.obric.aiagent.skill.virt.api.IVirtService$c] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [d.c.d] */
    private final <T> Object a(m<? super com.obric.aiagent.skill.virt.api.e, ? super d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>>, ? extends Object> r17, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a<? extends T>> r18) {
        ?? r1 = this;
        ?? r3 = "com.obric.aiagent.plugin";
        ?? r2 = (m) ZeusTransformUtils.wrapperContextForParams(r17, m.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C0445a.class) == false) goto L7;
        C0445a r5 = (C0445a) ZeusTransformUtils.preCheckCast(r4, C0445a.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
        ?? r6 = r5;
    L8:
        Object r7 = r6.f;
        Object r12 = d.c.a.b.a();
        ?? r8 = r6.h;
        int r9 = 1;
        switch(r8) {
            case 0: goto L48;
            case 1: goto L43;
            case 2: goto L32;
            case 3: goto L22;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        Throwable r10 = (Throwable) ZeusTransformUtils.preCheckCast(r6.f21219c, Throwable.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r11 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21218b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        a r13 = (a) ZeusTransformUtils.preCheckCast(r6.f21217a, a.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L20
        ?? r14 = r13;
    L129:
        throw r10;     // Catch: Throwable -> L130
    L15:
        com.obric.aiagent.skill.ovirt.api.a r15 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(r6.f21219c, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r16 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21218b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Object r19 = r6.f21217a;
        com.obric.aiagent.skill.ovirt.api.a r20 = r15;
        kotlinx.coroutines.f.a r21 = r16;
        a r22 = (a) ZeusTransformUtils.preCheckCast(r19, a.class, "com.obric.aiagent.plugin");
        Object r23 = r19;
    L18:
        o.a(r7);     // Catch: Throwable -> L20
        com.obric.aiagent.skill.ovirt.api.a r24 = r20;
        ?? r25 = r21;
        ?? r26 = r22;
        ?? r27 = r23;
    L94:
        com.obric.aiagent.skill.ovirt.api.a r0 = r24;
        ?? r110 = r26;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r6 = r27;
    L115:
        r2.b(null);     // Catch: Throwable -> L136
        r110.f21216a.getExclusiveExecutionRequested$impl_release().set(false);
        return r0;
    L16:
        com.obric.aiagent.skill.ovirt.api.a r28 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(r6.f21219c, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r29 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21218b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Object r30 = r6.f21217a;
        r20 = r28;
        r21 = r29;
        r22 = (a) ZeusTransformUtils.preCheckCast(r30, a.class, "com.obric.aiagent.plugin");
        r23 = r30;
        goto L18
    L17:
        com.obric.aiagent.skill.ovirt.api.a r31 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(r6.f21219c, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r32 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21218b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Object r33 = r6.f21217a;
        r20 = r31;
        r21 = r32;
        r22 = (a) ZeusTransformUtils.preCheckCast(r33, a.class, "com.obric.aiagent.plugin");
        r23 = r33;
        goto L18
    L22:
        int r34 = r6.f21221e;
        ?? r35 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21218b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        a r36 = (a) ZeusTransformUtils.preCheckCast(r6.f21217a, a.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L25 Exception -> L27 v -> L29 CancellationException -> L30
        ?? r111 = r36;
        r34 = r34;
        r35 = r35;
    L150:
        com.obric.aiagent.skill.ovirt.api.a r37 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L95 CancellationException -> L97 v -> L141 Throwable -> L118
        r0 = r37;
        r1 = r34;
        r2 = r35;
        r3 = r3;
        r6 = r6;
        r110 = r111;
        if (r34 == 0) goto L115;
        g r38 = (g) ZeusTransformUtils.preCheckCast(co.f39209b, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L130
        m r39 = (m) ZeusTransformUtils.preCheckCast(new c(r111, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L130
        r6.f21217a = r111;     // Catch: Throwable -> L130
        r6.f21218b = r35;     // Catch: Throwable -> L130
        r6.f21219c = r37;     // Catch: Throwable -> L130
        r6.h = 4;     // Catch: Throwable -> L130
        com.obric.aiagent.skill.ovirt.api.a r40 = r37;
        ?? r41 = r35;
        ?? r112 = r111;
        if (i.a(r38, r39, r6) != r12) goto L93;
        return r12;
    L93:
        r24 = r40;
        r26 = r112;
        r25 = r41;
        r27 = r6;
        goto L94
    L97:
        e = e;
    L161:
        throw e;     // Catch: Throwable -> L25
    L95:
        e = e;
    L104:
        com.obric.aiagent.skill.ovirt.api.a r42 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.b((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L118
        r0 = r42;
        r1 = r34;
        r2 = r35;
        r3 = r3;
        r6 = r6;
        r110 = r111;
        if (r34 == 0) goto L115;
        g r43 = (g) ZeusTransformUtils.preCheckCast(co.f39209b, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L130
        m r44 = (m) ZeusTransformUtils.preCheckCast(new c(r111, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L130
        r6.f21217a = r111;     // Catch: Throwable -> L130
        r6.f21218b = r35;     // Catch: Throwable -> L130
        r6.f21219c = r42;     // Catch: Throwable -> L130
        r6.f21220d = null;     // Catch: Throwable -> L130
        r6.h = 6;     // Catch: Throwable -> L130
        r40 = r42;
        r41 = r35;
        r112 = r111;
        if (i.a(r43, r44, r6) != r12) goto L93;
        return r12;
    L110:
        com.obric.aiagent.skill.ovirt.api.a r45 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.ovirt.api.a.C0438a.f20940a, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L118
        r0 = r45;
        r1 = r34;
        r2 = r35;
        r3 = r3;
        r6 = r6;
        r110 = r111;
        if (r34 == 0) goto L115;
        g r46 = (g) ZeusTransformUtils.preCheckCast(co.f39209b, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L130
        m r47 = (m) ZeusTransformUtils.preCheckCast(new c(r111, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L130
        r6.f21217a = r111;     // Catch: Throwable -> L130
        r6.f21218b = r35;     // Catch: Throwable -> L130
        r6.f21219c = r45;     // Catch: Throwable -> L130
        r6.f21220d = null;     // Catch: Throwable -> L130
        r6.h = 5;     // Catch: Throwable -> L130
        r40 = r45;
        r41 = r35;
        r112 = r111;
        if (i.a(r46, r47, r6) != r12) goto L93;
        return r12;
    L29:
        r111 = r36;
    L30:
        e = move-exception;
        throw e;     // Catch: Throwable -> L25
    L27:
        e = e;
        r111 = r36;
        goto L104
    L32:
        r34 = r6.f21221e;
        com.obric.aiagent.skill.ovirt.impl.h.a r48 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r6.f21220d, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r49 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21219c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        m r50 = (m) ZeusTransformUtils.preCheckCast(r6.f21218b, m.class, "com.obric.aiagent.plugin");
        a r51 = (a) ZeusTransformUtils.preCheckCast(r6.f21217a, a.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L35 Exception -> L38 v -> L40 CancellationException -> L41
        int r52 = r34;
        ?? r53 = r49;
        ?? r54 = r50;
        ?? r55 = r51;
    L69:
        com.obric.aiagent.skill.ovirt.impl.h.a r56 = r48;
        ?? r57 = r53;
        ?? r58 = r54;
        r111 = r55;
        r34 = r52;
    L78:
        if (r56 != null) goto L158;
    L83:
        com.obric.aiagent.skill.virt.api.e r59 = r111.f21216a.getVirt$impl_release().getLifecycle().getPaths().a();     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
    L84:
        IVirtService.d r60 = r111.f21216a.getVirt$impl_release().getShell();     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        d.h.a.b r61 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r58, r59, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        r6.f21217a = r111;     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        r6.f21218b = r57;     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        r6.f21219c = null;     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        r6.f21220d = null;     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        r6.f21221e = r34;     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        r6.h = 3;     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        Object r62 = IVirtService.d.a.a(r60, null, r61, r6, 1, null);     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        if (r62 != r12) goto L87;
        return r12;
    L87:
        r35 = r57;
        r7 = r62;
        r34 = r34;
        r111 = r111;
        goto L150
    L109:
        r35 = r57;
    L120:
        e = e;
    L102:
        e = e;
        r35 = r57;
    L99:
        th = th;
        int r63 = r34;
        ?? r64 = r57;
        ?? r113 = r111;
    L101:
        ?? r65 = r64;
        ?? r66 = r3;
        ?? r67 = r6;
        ?? r68 = r63;
        ?? r114 = r113;
    L37:
        r10 = th;
        if (r68 == 0) goto L163;
        g r69 = (g) ZeusTransformUtils.preCheckCast(co.f39209b, g.class, r66);     // Catch: Throwable -> L130
        m r70 = (m) ZeusTransformUtils.preCheckCast(new c(r114, null), m.class, r66);     // Catch: Throwable -> L130
        r67.f21217a = r114;     // Catch: Throwable -> L130
        r67.f21218b = r65;     // Catch: Throwable -> L130
        r67.f21219c = r10;     // Catch: Throwable -> L130
        r67.f21220d = null;     // Catch: Throwable -> L130
        r67.h = 7;     // Catch: Throwable -> L130
        if (i.a(r69, r70, r67) != r12) goto L127;
        return r12;
    L127:
        r14 = r114;
        goto L129
    L163:
        throw r10;     // Catch: Throwable -> L130
    L158:
        y r71 = r56.d();     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        if (r71 == null) goto L83;
        r59 = r71.a();     // Catch: Throwable -> L99 Exception -> L102 v -> L109 CancellationException -> L120
        if (r59 != null) goto L84;
    L40:
        r35 = r49;
        r111 = r51;
    L41:
        e = move-exception;
        throw e;     // Catch: Throwable -> L25
    L38:
        e = e;
        r35 = r49;
        r111 = r51;
    L35:
        th = th;
        r68 = r34;
        r65 = r49;
        r114 = r51;
        r66 = r3;
        r67 = r6;
        goto L37
    L43:
        kotlinx.coroutines.f.a r72 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r6.f21219c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        m r73 = (m) ZeusTransformUtils.preCheckCast(r6.f21218b, m.class, "com.obric.aiagent.plugin");
        a r74 = (a) ZeusTransformUtils.preCheckCast(r6.f21217a, a.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L46
        ?? r75 = r72;
        ?? r76 = r74;
        ?? r77 = r73;
    L145:
        r56 = r76.f21216a.activeState$impl_release(null);     // Catch: Throwable -> L132
        if (r56 == null) goto L64;
        r9 = 0;
    L64:
        if (r9 != 0) goto L154;
        r111 = r76;
        r34 = r9 == true ? 1 : 0;
        r58 = r77;
        r57 = r75;
        goto L78
    L154:
        ?? r78 = r76.f21216a.getVirt$impl_release().getLifecycle();     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        r6.f21217a = r76;     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        r6.f21218b = r77;     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        r6.f21219c = r75;     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        r6.f21220d = r56;     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        r6.f21221e = r9 == true ? 1 : 0;     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        r6.h = 2;     // Catch: Throwable -> L70 Exception -> L72 v -> L74 CancellationException -> L75
        if (r78.open(r6) != r12) goto L68;
        return r12;
    L68:
        r55 = r76;
        r53 = r75;
        r52 = r9 == true ? 1 : 0;
        r54 = r77;
        r48 = r56;
        goto L69
    L74:
        r111 = r76;
        r35 = r75;
        r34 = r9 == true ? 1 : 0;
    L75:
        e = move-exception;
        boolean r79 = r9 == true ? 1 : 0;
        throw e;     // Catch: Throwable -> L25
    L72:
        e = e;
        r111 = r76;
        r35 = r75;
        r34 = r9 == true ? 1 : 0;
    L70:
        th = th;
        r113 = r76;
        r64 = r75;
        r63 = r9;
    L132:
        th = th;
        r2 = r75;
    L134:
        r2.b(null);     // Catch: Throwable -> L136
        throw th;     // Catch: Throwable -> L136
    L46:
        th = th;
        r1 = r74;
    L139:
        r1.f21216a.getExclusiveExecutionRequested$impl_release().set(false);
        throw th;
    L48:
        o.a(r7);
        if (r1.f21216a.isAvailableNow$impl_release() == true) goto L53;
        return com.obric.aiagent.skill.ovirt.api.a.e.f20944a;
    L53:
        if (r1.f21216a.getExclusiveExecutionRequested$impl_release().compareAndSet(false, true) == false) goto L55;
        ?? r80 = r1.f21216a.getMutex$impl_release();     // Catch: Throwable -> L138
        r6.f21217a = r1;     // Catch: Throwable -> L138
        r6.f21218b = r2;     // Catch: Throwable -> L138
        r6.f21219c = r80;     // Catch: Throwable -> L138
        r6.h = 1;     // Catch: Throwable -> L138
        if (r80.a(null, r6) != r12) goto L59;
        return r12;
    L59:
        r75 = r80;
        r76 = r1;
        r77 = r2;
    L138:
        th = th;
        goto L139
    L55:
        return com.obric.aiagent.skill.ovirt.api.a.C0438a.f20940a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L25:
        th = th;
        r68 = r1;
        r114 = r8;
        r65 = r2;
        r66 = r3;
        r67 = r6;
    L130:
        th = th;
    L118:
        th = th;
        r68 = r1;
        r65 = r2;
        r66 = r3;
        r67 = r6;
        r114 = r110;
    L136:
        th = th;
        r1 = r15;
    L20:
        th = th;
    L7:
        r6 = new C0445a(r1, r4);
        goto L8
    }
}
