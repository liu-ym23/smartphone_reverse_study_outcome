package com.obric.agent.trace.toolmetrics;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: OmniClientToolTraceServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OmniClientToolTraceServiceImpl implements IOmniClientToolTraceService {
    private static final a Companion = null;

    @Deprecated
    public static final String DIAGNOSTIC_BEGIN_FAILED = "begin_failed";

    @Deprecated
    public static final String DIAGNOSTIC_COLLECTOR_FAILED = "collector_failed";

    @Deprecated
    public static final long DIAGNOSTIC_LOG_SAMPLE_RATE = 100;

    @Deprecated
    public static final String DIAGNOSTIC_LOOKUP_FAILED = "lookup_failed";

    @Deprecated
    public static final String TAG = "OmniClientToolTrace";

    @Deprecated
    public static final long WATCHDOG_INTERVAL_MS = 30000;
    private final bp backgroundDispatcher;
    private final am backgroundScope;
    private final b clock;
    private final p coordinator;
    private final c diagnostics;
    private final AtomicBoolean initialized;
    private final s reporter;

    /* JADX INFO: compiled from: OmniClientToolTraceServiceImpl.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniClientToolTraceServiceImpl.kt */
    private static final class b implements o {
        public b() {
        }

        @Override // com.obric.agent.trace.toolmetrics.o
        public long a() {
            return SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: compiled from: OmniClientToolTraceServiceImpl.kt */
    private static final class c implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap<String, AtomicLong> f15862a;

        public c() {
            this.f15862a = new ConcurrentHashMap();
        }

        @Override // com.obric.agent.trace.toolmetrics.q
        public void a(String r7, String r8) {
            d.h.b.o.e(r7, "name");
            ConcurrentMap r6 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.f15862a, ConcurrentMap.class, "com.obric.aiagent.plugin");
            Object r0 = r6.get(r7);
            if (r0 != null) goto L8;
            r0 = new AtomicLong();
            Object r9 = r6.putIfAbsent(r7, r0);
            if (r9 == null) goto L8;
            r0 = r9;
        L8:
            long r1 = ((AtomicLong) ZeusTransformUtils.preCheckCast(r0, AtomicLong.class, "com.obric.aiagent.plugin")).incrementAndGet();
            if (r1 != 1) goto L11;
        L12:
            ILogDepend.Companion r10 = ILogDepend.Companion;
            StringBuilder r11 = new StringBuilder().append("diagnostic=").append(r7).append(" count=").append(r1).append(" traceId=");
            if (r8 != null) goto L15;
            r8 = "";
        L15:
            r10.w(OmniClientToolTraceServiceImpl.TAG, r11.append(r8).toString());
            return;
        L11:
            if ((r1 % 100) == 0) goto L12;
        }
    }

    /* JADX INFO: compiled from: OmniClientToolTraceServiceImpl.kt */
    @d.c.b.a.f(b = "OmniClientToolTraceServiceImpl.kt", c = {46}, d = "invokeSuspend", e = "com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl$initialize$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OmniClientToolTraceServiceImpl f15864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f15865c;

        d(OmniClientToolTraceServiceImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15864b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f15864b, r5);
            r0.f15865c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0049 -> B:14:0x004c). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15863a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f15865c, am.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
        L14:
            OmniClientToolTraceServiceImpl.access$getCoordinator$p(this.f15864b).b();
        L10:
            if (an.a(r2) == false) goto L16;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15865c = r2;
            this.f15863a = 1;
            if (ax.a(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r8) != r0) goto L14;
            return r0;
        L16:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            r2 = (am) ZeusTransformUtils.preCheckCast(this.f15865c, am.class, "com.obric.aiagent.plugin");
            goto L10
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ Thread lambda$MiIVouu1Sx4BDE5fuFOMRrdPw4k(Runnable r0) {
        return backgroundDispatcher$lambda$0(r0);
    }

    public OmniClientToolTraceServiceImpl() {
        this.initialized = new AtomicBoolean(false);
        ExecutorService r1 = Executors.newSingleThreadExecutor($$Lambda$OmniClientToolTraceServiceImpl$MiIVouu1Sx4BDE5fuFOMRrdPw4k.INSTANCE);
        d.h.b.o.c(r1, "newSingleThreadExecutor(...)");
        bp r2 = br.a(r1);
        this.backgroundDispatcher = r2;
        am r3 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(r2, d.c.g.class, "com.obric.aiagent.plugin")));
        this.backgroundScope = r3;
        b r4 = new b();
        this.clock = r4;
        c r5 = new c();
        this.diagnostics = r5;
        s r6 = new s(r3, new r(), (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin"));
        this.reporter = r6;
        this.coordinator = new p((o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.aiagent.plugin"), (t) ZeusTransformUtils.preCheckCast(r6, t.class, "com.obric.aiagent.plugin"), (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin"), null, 0, 24, null);
    }

    public static final /* synthetic */ p access$getCoordinator$p(OmniClientToolTraceServiceImpl r0) {
        return r0.coordinator;
    }

    private static final Thread backgroundDispatcher$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "client-tool-trace");
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public void initialize() {
        if (this.initialized.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(this.backgroundScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public z begin() {
        initialize();
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r2 = d.n.f(((OmniClientToolTraceServiceImpl) ZeusTransformUtils.preCheckCast(this, OmniClientToolTraceServiceImpl.class, "com.obric.aiagent.plugin")).coordinator.a());     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r2) == null) goto L12;
        q.a.a((q) ZeusTransformUtils.preCheckCast(this.diagnostics, q.class, "com.obric.aiagent.plugin"), DIAGNOSTIC_BEGIN_FAILED, null, 2, null);
        r2 = new z("tool_trace_untracked_" + UUID.randomUUID());
    L12:
        return (z) ZeusTransformUtils.preCheckCast(r2, z.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L8
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public z findByMessageId(String r4) {
        d.h.b.o.e(r4, "messageId");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((OmniClientToolTraceServiceImpl) ZeusTransformUtils.preCheckCast(this, OmniClientToolTraceServiceImpl.class, "com.obric.aiagent.plugin")).coordinator.a(r4));     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r5) == null) goto L12;
        q.a.a((q) ZeusTransformUtils.preCheckCast(this.diagnostics, q.class, "com.obric.aiagent.plugin"), DIAGNOSTIC_LOOKUP_FAILED, null, 2, null);
        r5 = null;
    L12:
        return (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L8
    }

    private final void runSafely(z r3, d.h.a.a<d.x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r6 = d.n.f(r5.invoke());     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r6) == null) goto L13;
        this.diagnostics.a(DIAGNOSTIC_COLLECTOR_FAILED, r3.a());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L8
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public void markCorePoint(z r2, j r3) {
        d.h.b.o.e(r2, "token");
        d.h.b.o.e(r3, "point");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        this.coordinator.a(r2, r3);     // Catch: Throwable -> L5
        Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r4) == null) goto L13;
        this.diagnostics.a(DIAGNOSTIC_COLLECTOR_FAILED, r2.a());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public void markProgress(z r2, String r3) {
        d.h.b.o.e(r2, "token");
        d.h.b.o.e(r3, "stage");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        this.coordinator.a(r2, r3);     // Catch: Throwable -> L5
        Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r4) == null) goto L13;
        this.diagnostics.a(DIAGNOSTIC_COLLECTOR_FAILED, r2.a());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public void append(z r2, n r3) {
        d.h.b.o.e(r2, "token");
        d.h.b.o.e(r3, "appendix");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        this.coordinator.a(r2, r3);     // Catch: Throwable -> L5
        Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r4) == null) goto L13;
        this.diagnostics.a(DIAGNOSTIC_COLLECTOR_FAILED, r2.a());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public void finish(z r3) {
        d.h.b.o.e(r3, "token");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        this.coordinator.a(r3);     // Catch: Throwable -> L5
        Object r1 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r1) == null) goto L13;
        this.diagnostics.a(DIAGNOSTIC_COLLECTOR_FAILED, r3.a());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L8
    }

    @Override // com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService
    public void cancel(z r3) {
        d.h.b.o.e(r3, "token");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        this.coordinator.b(r3);     // Catch: Throwable -> L5
        Object r1 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r1) == null) goto L13;
        this.diagnostics.a(DIAGNOSTIC_COLLECTOR_FAILED, r3.a());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L8
    }
}
