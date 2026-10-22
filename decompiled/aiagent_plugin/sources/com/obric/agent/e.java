package com.obric.agent;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autoaction.view.DraggableFloatingLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: AgentScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String TAG = "AgentScope";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Thread f14436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f14437c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f14438d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final am f14439e = null;
    private static final AtomicLong f = null;
    private static final ScheduledThreadPoolExecutor g = null;

    /* JADX INFO: compiled from: AgentScope.kt */
    @d.c.b.a.f(b = "AgentScope.kt", c = {87}, d = "invokeSuspend", e = "com.obric.agent.AgentScope$launchOnAgentWithWatchdog$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScheduledFuture<?> f14441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f14442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f14444e;
        final /* synthetic */ d.h.a.m<am, d.c.d<? super d.x>, Object> f;
        private /* synthetic */ Object g;

        a(ScheduledFuture<?> r3, long r4, String r6, long r7, d.h.a.m<? super am, ? super d.c.d<? super d.x>, ? extends Object> r9, d.c.d<? super a> r10) {
            ScheduledFuture<?> r5 = (ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledFuture.class, "com.obric.aiagent.plugin");
            d.h.a.m<am, d.c.d<? super d.x>, Object> r11 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14441b = r5;
            this.f14442c = r4;
            this.f14443d = r6;
            this.f14444e = r7;
            this.f = r11;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            a r14 = new a(this.f14441b, this.f14442c, this.f14443d, this.f14444e, this.f, r10);
            r14.g = r12;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v8, types: [d.x, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v5, types: [long] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v4, types: [long] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14440a;
            String r3 = " totalCost=";
            String r4 = "launchOnAgent block end tag=";
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r14);     // Catch: Throwable -> L7
        L15:
            ILogDepend.Companion r15 = ILogDepend.Companion;
            StringBuilder r2 = new StringBuilder().append("launchOnAgent block end tag=").append(this.f14443d).append(" seq=");
            r4 = this.f14444e;
            StringBuilder r5 = r2.append(r4).append(" totalCost=");
            r3 = System.currentTimeMillis() - this.f14442c;
            r15.i(e.TAG, r5.append(r3).append("ms").toString());
            a this = d.x.f38692a;
            return this;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r14);
            am r16 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            this.f14441b.cancel(false);
            ILogDepend.Companion.i(e.TAG, "launchOnAgent block start tag=" + this.f14443d + " seq=" + this.f14444e + " waitCost=" + (System.currentTimeMillis() - this.f14442c) + "ms thread=" + Thread.currentThread().getName());
            d.h.a.m<am, d.c.d<? super d.x>, Object> r6 = this.f;     // Catch: Throwable -> L7
            this.f14440a = 1;     // Catch: Throwable -> L7
            if (r6.invoke(r16, this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            ILogDepend.Companion.i(e.TAG, r4 + this.f14443d + " seq=" + this.f14444e + r3 + (System.currentTimeMillis() - this.f14442c) + "ms");
            throw th;
        }
    }

    /* JADX INFO: renamed from: lambda$09FdHl6-gGktoQ9zITu7DqCPLCE, reason: not valid java name */
    public static /* synthetic */ Thread m70lambda$09FdHl6gGktoQ9zITu7DqCPLCE(Runnable r0) {
        return b(r0);
    }

    public static /* synthetic */ Thread lambda$0kfGx6PO4nmYhQAS9TRPIohearo(Runnable r0) {
        return d(r0);
    }

    public static /* synthetic */ Thread lambda$6lwoyySnWQRvvtq4q9QW3ROnZ_U(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$qL2ylEh2VXc8YtFHzDr3FkZb79s(String r0, long r1, long r3) {
        b(r0, r1, r3);
    }

    public static /* synthetic */ Thread lambda$qVqx_r5mgV6SpVeqoxAiBrG5jA0(Runnable r0) {
        return c(r0);
    }

    private e() {
    }

    static {
        f14435a = new e();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$e$6lwoyySnWQRvvtq4q9QW3ROnZ_U.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        f14437c = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
        ExecutorService r1 = Executors.newSingleThreadExecutor($$Lambda$e$09FdHl6gGktoQ9zITu7DqCPLCE.INSTANCE);
        d.h.b.o.c(r1, "newSingleThreadExecutor(...)");
        f14438d = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r1), d.c.g.class, "com.obric.aiagent.plugin"));
        ExecutorService r2 = Executors.newSingleThreadExecutor($$Lambda$e$qVqx_r5mgV6SpVeqoxAiBrG5jA0.INSTANCE);
        d.h.b.o.c(r2, "newSingleThreadExecutor(...)");
        f14439e = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r2), d.c.g.class, "com.obric.aiagent.plugin"));
        f = new AtomicLong(0);
        ScheduledThreadPoolExecutor r3 = new ScheduledThreadPoolExecutor(1, $$Lambda$e$0kfGx6PO4nmYhQAS9TRPIohearo.INSTANCE);
        r3.setRemoveOnCancelPolicy(true);
        g = r3;
    }

    public final am a() {
        return f14437c;
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "agent-dispatcher");
        f14436b = r0;
        return r0;
    }

    public final am b() {
        return f14438d;
    }

    private static final Thread b(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "intentTracer-dispatcher");
    }

    public final am c() {
        return f14439e;
    }

    private static final Thread c(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "im-dispatcher");
    }

    private static final Thread d(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "agent-dispatcher-watchdog");
        r0.setDaemon(true);
        return r0;
    }

    public static /* synthetic */ ca a(e r1, String r2, long r3, d.h.a.m r5, int r6, Object r7) {
        d.h.a.m<? super am, ? super d.c.d<? super d.x>, ? extends Object> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = DraggableFloatingLayout.DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS;
    L6:
        return r1.a(r2, r3, r8);
    }

    public final ca a(final String r21, long r22, d.h.a.m<? super am, ? super d.c.d<? super d.x>, ? extends Object> r24) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r21, "tag");
        d.h.b.o.e(r7, "block");
        final long r10 = f.incrementAndGet();
        final long r12 = System.currentTimeMillis();
        ILogDepend.Companion.i(TAG, "launchOnAgent before launch tag=" + r21 + " seq=" + r10);
        return kotlinx.coroutines.i.a(f14437c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(g.schedule(new $$Lambda$e$qL2ylEh2VXc8YtFHzDr3FkZb79s(r21, r10, r12), r22, TimeUnit.MILLISECONDS), r12, r21, r10, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final void b(String r6, long r7, long r9) {
        f14435a.a(r6, r7, r9);
    }

    private final void a(String r9, long r10, long r12) {
        Thread r1 = f14436b;     // Catch: Throwable -> L16
        long r2 = System.currentTimeMillis() - r12;
        if (r1 != null) goto L8;
        ILogDepend.Companion.e(TAG, "launchOnAgent STUCK tag=" + r9 + " seq=" + r10 + " cost=" + r2 + "ms, agent-dispatcher thread NOT INIT");     // Catch: Throwable -> L16
        return;
    L8:
        StackTraceElement[] r4 = r1.getStackTrace();     // Catch: Throwable -> L16
        int r5 = Math.min(r4.length, 40);     // Catch: Throwable -> L16
        StringBuilder r6 = new StringBuilder(2048);     // Catch: Throwable -> L16
        r6.append("launchOnAgent STUCK tag=").append(r9).append(" seq=").append(r10).append(" cost=").append(r2).append("ms").append(" thread=").append(r1.getName()).append(" state=").append(r1.getState()).append(" frames=").append(r4.length).append('\n');     // Catch: Throwable -> L16
        int r13 = 0;
    L9:
        if (r13 >= r5) goto L12;
        r6.append("    at ").append(r4[r13].toString()).append('\n');     // Catch: Throwable -> L16
        r13 = r13 + 1;     // Catch: Throwable -> L16
        goto L9
    L12:
        if (r4.length <= r5) goto L14;
        r6.append("    ... ").append(r4.length - r5).append(" more\n");     // Catch: Throwable -> L16
    L14:
        String r14 = r6.toString();     // Catch: Throwable -> L16
        d.h.b.o.c(r14, "toString(...)");     // Catch: Throwable -> L16
        com.obric.agent.complextask.c.f14330a.b(TAG, "scope thread stuck");     // Catch: Throwable -> L16
        ILogDepend.Companion.e(TAG, r14);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "launchOnAgent watchdog error tag=" + r9 + " seq=" + r10 + ": " + th.getMessage());
    }
}
