package com.obric.autogui.common.api.threading;

import android.os.SystemClock;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.d.a;
import d.d.b;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkingThreadWatchdog {
    public static final Companion Companion = null;
    public static final long DEFAULT_FROZEN_THRESHOLD_MS = 5000;
    public static final int DEFAULT_MAX_TRACE_DUMPS = 5;
    public static final long DEFAULT_SAMPLE_INTERVAL_MS = 1000;
    public static final long DEFAULT_STALL_GRACE_MS = 1000;
    private static final String EVENT_NAME = "rd_thread_stuck";
    private static final int FINGERPRINT_DEPTH = 32;
    private static final String TAG = "WTWatchdog";
    private int frozenCount;
    private long frozenSinceMs;
    private final long frozenThresholdMs;
    private Integer lastFingerprint;
    private volatile String lastStuckStackTrace;
    private final int maxTraceDumps;
    private final long sampleIntervalMs;
    private final long stallGraceMs;
    private volatile boolean stuckReported;
    private volatile long stuckSinceMs;
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper targetThread;
    private volatile int traceDumpCount;
    private ca watchJob;
    private final am watchScope;

    /* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
    private static final enum StackKind extends Enum<StackKind> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ StackKind[] $VALUES = null;
        public static final StackKind BUSY = null;
        public static final StackKind IDLE = null;
        public static final StackKind UNKNOWN = null;

        private static final /* synthetic */ StackKind[] $values() {
            return new StackKind[]{IDLE, BUSY, UNKNOWN};
        }

        public static a<StackKind> getEntries() {
            return $ENTRIES;
        }

        private StackKind(String r1, int r2) {
            super(r1, r2);
        }

        static {
            IDLE = new StackKind("IDLE", 0);
            BUSY = new StackKind("BUSY", 1);
            UNKNOWN = new StackKind("UNKNOWN", 2);
            StackKind[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public final String tag() {
            String r1 = name().toLowerCase(Locale.ROOT);
            o.c(r1, "toLowerCase(...)");
            return r1;
        }

        public static StackKind valueOf(String r2) {
            return (StackKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(StackKind.class, r2), StackKind.class, "com.obric.aiagent.plugin");
        }

        public static StackKind[] values() {
            return (StackKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StackKind[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
    private static final class ThreadSample {
        private final int fingerprint;
        private final StackKind kind;
        private final Thread.State state;
        private final String trace;

        public static /* synthetic */ ThreadSample copy$default(ThreadSample r0, StackKind r1, Thread.State r2, int r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.kind;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.state;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.fingerprint;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.trace;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final StackKind component1() {
            return this.kind;
        }

        public final Thread.State component2() {
            return this.state;
        }

        public final int component3() {
            return this.fingerprint;
        }

        public final String component4() {
            return this.trace;
        }

        public final ThreadSample copy(StackKind r1, Thread.State r2, int r3, String r4) {
            o.e(r1, "kind");
            return new ThreadSample(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ThreadSample.class) == true) goto L8;
            return false;
        L8:
            ThreadSample r6 = (ThreadSample) ZeusTransformUtils.preCheckCast(r5, ThreadSample.class, "com.obric.aiagent.plugin");
            if (this.kind == r6.kind) goto L12;
            return false;
        L12:
            if (this.state == r6.state) goto L15;
            return false;
        L15:
            if (this.fingerprint == r6.fingerprint) goto L18;
            return false;
        L18:
            if (o.a(this.trace, r6.trace) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = this.kind.hashCode() * 31;
            Thread.State r1 = this.state;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.fingerprint)) * 31;
            String r5 = this.trace;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ThreadSample(kind=" + this.kind + ", state=" + this.state + ", fingerprint=" + this.fingerprint + ", trace=" + this.trace + ')';
        }

        public ThreadSample(StackKind r2, Thread.State r3, int r4, String r5) {
            o.e(r2, "kind");
            this.kind = r2;
            this.state = r3;
            this.fingerprint = r4;
            this.trace = r5;
        }

        public final StackKind getKind() {
            return this.kind;
        }

        public final Thread.State getState() {
            return this.state;
        }

        public final int getFingerprint() {
            return this.fingerprint;
        }

        public final String getTrace() {
            return this.trace;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.WorkingThreadWatchdog$monitorLoop$1, reason: invalid class name */
    /* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
    @f(b = "WorkingThreadWatchdog.kt", c = {236}, d = "monitorLoop", e = "com.obric.autogui.common.api.threading.WorkingThreadWatchdog")
    static final class AnonymousClass1 extends d {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WorkingThreadWatchdog this$0;

        AnonymousClass1(WorkingThreadWatchdog r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return WorkingThreadWatchdog.access$monitorLoop(this.this$0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.WorkingThreadWatchdog$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
    @f(b = "WorkingThreadWatchdog.kt", c = {169}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.WorkingThreadWatchdog$start$1")
    static final class C11491 extends l implements m<am, d.c.d<? super x>, Object> {
        int label;
        final /* synthetic */ WorkingThreadWatchdog this$0;

        C11491(WorkingThreadWatchdog r3, d.c.d<? super C11491> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11491(this.this$0, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super x> r4) {
            return ((C11491) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11491.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Loog.INSTANCE.i(WorkingThreadWatchdog.TAG, "[watchdog] monitoring thread '" + WorkingThreadWatchdog.access$getTargetThread$p(this.this$0).getName() + "' | sampleInterval=" + WorkingThreadWatchdog.access$getSampleIntervalMs$p(this.this$0) + "ms, frozenThreshold=" + WorkingThreadWatchdog.access$getFrozenThresholdMs$p(this.this$0) + "ms, stallGrace=" + WorkingThreadWatchdog.access$getStallGraceMs$p(this.this$0) + "ms");
            WorkingThreadWatchdog r7 = this.this$0;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (WorkingThreadWatchdog.access$monitorLoop(r7, r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WorkingThreadWatchdog(AOThreadingTools.SingleThreadCoroutineScopeWrapper r2, long r3, long r5, int r7, long r8) {
        o.e(r2, "targetThread");
        this.targetThread = r2;
        this.sampleIntervalMs = r3;
        this.frozenThresholdMs = r5;
        this.maxTraceDumps = r7;
        this.stallGraceMs = r8;
        this.watchScope = an.a(bd.c().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")));
    }

    public /* synthetic */ WorkingThreadWatchdog(AOThreadingTools.SingleThreadCoroutineScopeWrapper r9, long r10, long r12, int r14, long r15, int r17, h r18) {
        long r1 = 1000;
        if ((r17 & 2) == 0) goto L5;
        long r3 = 1000;
    L7:
        if ((r17 & 4) == 0) goto L9;
        long r5 = 5000;
    L11:
        if ((r17 & 8) == 0) goto L13;
        int r0 = 5;
    L15:
        if ((r17 & 16) != 0) goto L18;
        r1 = r15;
    L18:
        this(r9, r3, r5, r0, r1);
        return;
    L13:
        r0 = r14;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public static final /* synthetic */ long access$getFrozenThresholdMs$p(WorkingThreadWatchdog r2) {
        return r2.frozenThresholdMs;
    }

    public static final /* synthetic */ long access$getSampleIntervalMs$p(WorkingThreadWatchdog r2) {
        return r2.sampleIntervalMs;
    }

    public static final /* synthetic */ long access$getStallGraceMs$p(WorkingThreadWatchdog r2) {
        return r2.stallGraceMs;
    }

    public static final /* synthetic */ AOThreadingTools.SingleThreadCoroutineScopeWrapper access$getTargetThread$p(WorkingThreadWatchdog r0) {
        return r0.targetThread;
    }

    public static final /* synthetic */ Object access$monitorLoop(WorkingThreadWatchdog r2, d.c.d r3) {
        return r2.monitorLoop((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final String getLastStuckStackTrace() {
        return this.lastStuckStackTrace;
    }

    public final long getStuckSinceMs() {
        return this.stuckSinceMs;
    }

    public final boolean isStuck() {
        return this.stuckReported;
    }

    public final long getStuckDurationMs() {
        if (this.stuckReported == true) goto L5;
        return 0;
    L5:
        if (this.stuckSinceMs > 0) goto L7;
        return 0;
    L7:
        return nowMs() - this.stuckSinceMs;
    }

    public final void start() {
        stop(true);
        this.watchJob = i.a(this.watchScope, null, null, (m) ZeusTransformUtils.preCheckCast(new C11491(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void stop() {
        stop(true);
    }

    public final void release() {
        stop(true);
        an.a(this.watchScope, null, 1, null);
    }

    public final String captureThreadDiagnostics() {
        Thread r0 = this.targetThread.getUnderlyingThread();
        if (r0 != null) goto L6;
        return null;
    L6:
        Thread.State r1 = r0.getState();
        StackTraceElement[] r2 = r0.getStackTrace();
        o.c(r2, "getStackTrace(...)");
        return buildTrace(r0, r1, r2);
    }

    public final String describeState() {
        Thread r0 = this.targetThread.getUnderlyingThread();
        StringBuilder r1 = new StringBuilder().append("watchJobActive=");
        ca r2 = this.watchJob;
        Thread.State r3 = null;
        if (r2 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r2.b());
    L6:
        StringBuilder r5 = r1.append(r4).append(", threadState=");
        if (r0 == null) goto L9;
        r3 = r0.getState();
    L9:
        StringBuilder r6 = r5.append(r3).append(", frozenCount=").append(this.frozenCount).append(", frozenDurationMs=").append(currentFrozenDurationMs()).append(", stuckReported=").append(this.stuckReported).append(", stuckDurationMs=").append(getStuckDurationMs()).append(", traceDumpCount=").append(this.traceDumpCount).append(", lastTracePresent=");
        if (this.lastStuckStackTrace == null) goto L12;
        boolean r7 = true;
    L14:
        return r6.append(r7).toString();
    L12:
        r7 = false;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    private final void stop(boolean r4) {
        ca r0 = this.watchJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.watchJob = null;
        if (r4 == false) goto L9;
        resetFrozenTracking();
        this.stuckReported = false;
        this.traceDumpCount = 0;
        this.lastStuckStackTrace = null;
        this.stuckSinceMs = 0;
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007b -> B:20:0x007e). Please report as a decompilation issue!!! */
    private final Object monitorLoop(d.c.d<? super x> r16) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r16, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = d.c.a.b.a();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r7 = r2.J$1;
        long r9 = r2.J$0;
        WorkingThreadWatchdog r3 = (WorkingThreadWatchdog) ZeusTransformUtils.preCheckCast(r2.L$0, WorkingThreadWatchdog.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
        WorkingThreadWatchdog this = r3;
    L20:
        long r6 = this.nowMs();
        long r10 = r6 - r9;
        long r13 = n.a(r10 - (SystemClock.uptimeMillis() - r7), 0);
        long r11 = n.a(r10 - this.sampleIntervalMs, 0);
        if (r11 < this.stallGraceMs) goto L23;
        this.onGlobalStall(r10, r11, r13);
    L16:
        if (ce.a(r2.getContext()) == false) goto L25;
        r9 = this.nowMs();
        r7 = SystemClock.uptimeMillis();
        long r8 = this.sampleIntervalMs;
        r2.L$0 = this;
        r2.J$0 = r9;
        r2.J$1 = r7;
        r2.label = 1;
        if (ax.a(r8, r2) != r4) goto L20;
        return r4;
    L25:
        return x.f38692a;
    L23:
        this.handleSample(this.sampleThread(), r6, r11, r13);
        goto L16
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
    L7:
        r2 = new AnonymousClass1(this, r0);
        goto L8
    }

    private final ThreadSample sampleThread() {
        Thread r0 = this.targetThread.getUnderlyingThread();
        if (r0 == null) goto L5;
        Thread.State r3 = r0.getState();
        StackTraceElement[] r4 = r0.getStackTrace();
        o.a(r4);
        if (r4.length != 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L14;
        return new ThreadSample(StackKind.UNKNOWN, r3, 0, null);
    L14:
        return new ThreadSample(classifyStack(r4), r3, fingerprintOf(r4), buildTrace(r0, r3, r4));
    L9:
        r5 = false;
        goto L10
    L5:
        return new ThreadSample(StackKind.UNKNOWN, null, 0, null);
    }

    private final void handleSample(ThreadSample r11, long r12, long r14, long r16) {
        if (r11.getKind() == StackKind.BUSY) goto L6;
        onThreadHealthy(r12);
        return;
    L6:
        Integer r1 = this.lastFingerprint;
        if (r1 != null) goto L9;
    L18:
        onThreadHealthy(r12);
        this.lastFingerprint = Integer.valueOf(r11.getFingerprint());
        return;
    L9:
        if (r1.intValue() != r11.getFingerprint()) goto L18;
        if (this.frozenCount != 0) goto L14;
        this.frozenSinceMs = n.a(r12 - this.sampleIntervalMs, 0);
    L14:
        this.frozenCount++;
        long r4 = r12 - this.frozenSinceMs;
        if (r4 < this.frozenThresholdMs) goto L20;
        onThreadStuck(r11, r12, r4, r14, r16);
        return;
    }

    private final void onGlobalStall(long r4, long r6, long r8) {
        resetFrozenTracking();
        Loog.INSTANCE.w(TAG, "[watchdog] global stall on monitor for '" + this.targetThread.getName() + "', skip judgment | actualIntervalMs=" + r4 + ", monitorDriftMs=" + r6 + ", deepSleepMs=" + r8 + ", wasStuckReported=" + this.stuckReported);
    }

    private final void onThreadHealthy(long r10) {
        if (this.stuckReported == false) goto L5;
        long r11 = r10 - this.stuckSinceMs;
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r3 = buildDimensions("recovered", StackKind.BUSY, 0, 0).put("total_stuck_duration_ms", r11).put("dump_count", this.traceDumpCount);
        o.c(r3, "put(...)");
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, EVENT_NAME, r3, false, false, null, 28, null);
        Loog.INSTANCE.w(TAG, "[watchdog] thread '" + this.targetThread.getName() + "' recovered from stuck | total stuck duration=" + r11 + "ms, dumps=" + this.traceDumpCount);
        this.stuckReported = false;
        this.traceDumpCount = 0;
        this.lastStuckStackTrace = null;
        this.stuckSinceMs = 0;
    L5:
        resetFrozenTracking();
    }

    private final void onThreadStuck(ThreadSample r25, long r26, long r28, long r30, long r32) {
        if (this.stuckReported == true) goto L5;
        this.stuckReported = true;
        this.stuckSinceMs = this.frozenSinceMs;
        this.traceDumpCount = 0;
    L5:
        this.traceDumpCount++;
        this.lastStuckStackTrace = r25.getTrace();
        if (this.traceDumpCount > this.maxTraceDumps) goto L16;
        IAutoActionTrackingApi r16 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r0 = buildDimensions("stuck", r25.getKind(), r30, r32).put("stuck_duration_ms", r28).put("frozen_sample_count", this.frozenCount);
        Thread.State r1 = r25.getState();
        if (r1 == null) goto L13;
        String r2 = r1.name();
        if (r2 == null) goto L13;
        String r13 = r2;
    L14:
        JSONObject r3 = r0.put("thread_state", r13).put("dump_count", this.traceDumpCount).put("max_dumps", this.maxTraceDumps).put("trace", r25.getTrace());
        o.c(r3, "put(...)");
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r16, EVENT_NAME, r3, false, false, null, 28, null);
        Loog.INSTANCE.e(TAG, "[watchdog] !! STUCK !! thread '" + this.targetThread.getName() + "' frozen for " + r28 + "ms (state=" + r25.getState() + ", dump #" + this.traceDumpCount + '/' + this.maxTraceDumps + ")\n" + r25.getTrace());
        return;
    L13:
        r13 = "";
        goto L14
    L16:
        if (this.traceDumpCount != (this.maxTraceDumps + 1)) goto L27;
        IAutoActionTrackingApi r17 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = buildDimensions("stuck", r25.getKind(), r30, r32).put("stuck_duration_ms", r28).put("frozen_sample_count", this.frozenCount);
        Thread.State r5 = r25.getState();
        if (r5 == null) goto L23;
        String r6 = r5.name();
        if (r6 == null) goto L23;
        String r14 = r6;
    L24:
        JSONObject r7 = r4.put("thread_state", r14).put("dump_count", this.traceDumpCount).put("note", "max_dumps_reached, suppressing further traces");
        o.c(r7, "put(...)");
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r17, EVENT_NAME, r7, false, false, null, 28, null);
        Loog.INSTANCE.e(TAG, "[watchdog] thread '" + this.targetThread.getName() + "' still frozen for " + r28 + "ms, suppressing further dumps");
        return;
    L23:
        r14 = "";
        goto L24
    }

    private final void resetFrozenTracking() {
        this.lastFingerprint = null;
        this.frozenCount = 0;
        this.frozenSinceMs = 0;
    }

    private final long currentFrozenDurationMs() {
        if (this.frozenSinceMs > 0) goto L5;
        return 0;
    L5:
        return nowMs() - this.frozenSinceMs;
    }

    private final JSONObject buildDimensions(String r3, StackKind r4, long r5, long r7) {
        JSONObject r2 = new JSONObject().put("event", r3).put("thread_name", this.targetThread.getName()).put("session_key", parseSessionKey(this.targetThread.getName())).put("stack_kind", r4.tag()).put("monitor_drift_ms", r5).put("deep_sleep_ms", r7).put("frozen_threshold_ms", this.frozenThresholdMs);
        o.c(r2, "put(...)");
        return r2;
    }

    private final String parseSessionKey(String r7) {
        int r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '/', 0, false, 6, null);
        boolean r0 = false;
        if (r6 >= 0) goto L5;
    L7:
        if (r0 == false) goto L9;
        String r8 = r7.substring(r6 + 1);
        o.c(r8, "substring(...)");
        return r8;
    L9:
        return "";
    L5:
        if (r6 >= (r7.length() - 1)) goto L7;
        r0 = true;
        goto L7
    }

    private final StackKind classifyStack(StackTraceElement[] r11) {
        boolean r0 = true;
        if (r11.length != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        int r12 = r11.length;
        int r2 = 0;
    L10:
        if (r2 >= r12) goto L25;
        StackTraceElement r3 = r11[r2];
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(WorkingThreadWatchdogKt.access$getIDLE_STACK_MARKERS$p(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L14;
    L16:
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L15;
        if (d.o.o.c(r3.getClassName() + '.' + r3.getMethodName(), (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L18;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L26;
        r2 = r2 + 1;
    L26:
        if (r0 == false) goto L29;
        return StackKind.IDLE;
    L29:
        return StackKind.BUSY;
    L15:
        r6 = false;
        goto L22
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L16;
    L25:
        r0 = false;
        goto L26
    L8:
        return StackKind.UNKNOWN;
    L5:
        r10 = false;
        goto L6
    }

    private final int fingerprintOf(StackTraceElement[] r4) {
        int r3 = Math.min(r4.length, 32);
        int r0 = 1;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0 = (r0 * 31) + r4[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private final String buildTrace(Thread r5, Thread.State r6, StackTraceElement[] r7) {
        StringBuilder r4 = new StringBuilder();
        StringBuilder r8 = r4.append('\"' + r5.getName() + "\" tid=" + r5.getId() + " state=" + r6);
        o.c(r8, "append(...)");
        o.c(r8.append('\n'), "append(...)");
        if (r7.length != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L8;
        StringBuilder r10 = r4.append("  (no stack trace available)");
        o.c(r10, "append(...)");
        o.c(r10.append('\n'), "append(...)");
    L13:
        String r11 = r4.toString();
        o.c(r11, "toString(...)");
        return r11;
    L8:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.i.c(r7, 50), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        StringBuilder r13 = r4.append("  at " + ((StackTraceElement) ZeusTransformUtils.preCheckCast(r12.next(), StackTraceElement.class, "com.obric.aiagent.plugin")));
        o.c(r13, "append(...)");
        o.c(r13.append('\n'), "append(...)");
        goto L10
    L12:
        x r14 = x.f38692a;
        goto L13
    L5:
        r9 = false;
        goto L6
    }

    private final long nowMs() {
        return SystemClock.elapsedRealtime();
    }
}
