package com.stepos.core.performance.orchestrator;

import android.content.Context;
import b6.g;
import com.stepos.core.common.cloud.d;
import com.stepos.core.performance.data.EnrichedVerdict;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PerformanceRequestContext;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.data.VerdictReason;
import com.stepos.core.performance.policies.BatteryPolicy;
import com.stepos.core.performance.policies.DspConcurrencyPolicy;
import com.stepos.core.performance.policies.HealthPolicy;
import com.stepos.core.performance.policies.HistoryDrivenPolicy;
import com.stepos.core.performance.policies.IPerformancePolicy;
import com.stepos.core.performance.policies.MemoryPressurePolicy;
import com.stepos.core.performance.policies.SceneBackendPolicy;
import com.stepos.core.performance.policies.ThermalPolicy;
import com.stepos.core.performance.signal.SignalHub;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import lb.n;
import mb.k;
import mb.m;
import ob.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PerformanceOrchestratorImpl {
    private static final int AUDIT_RING_SIZE = 20;
    public static final Companion Companion = new Companion(null);
    private static final long TTL_MS = 5000;
    private static volatile PerformanceOrchestratorImpl instance;
    private final ReentrantReadWriteLock auditLock;
    private final k<GlobalVerdict> auditRing;
    private volatile long cacheTimestampMs;
    private volatile GlobalVerdict cachedGlobal;
    private final RequestEnrichment enrichment;
    private volatile boolean invalidated;
    private final List<IPerformancePolicy> policies;
    private final SignalHub signalHub;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final PerformanceOrchestratorImpl buildDefault(Context context) {
            SignalHub signalHub = new SignalHub(context, null, 2, 0 == true ? 1 : 0);
            PerformanceOrchestratorImpl performanceOrchestratorImpl = new PerformanceOrchestratorImpl(signalHub, a.I0(m.b0(new ThermalPolicy(), new MemoryPressurePolicy(), new BatteryPolicy(), new SceneBackendPolicy(), new DspConcurrencyPolicy(), new HealthPolicy(), new HistoryDrivenPolicy()), new Comparator() { // from class: com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl$Companion$buildDefault$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t8, T t10) {
                    return b.a(Integer.valueOf(((IPerformancePolicy) t8).getPriority()), Integer.valueOf(((IPerformancePolicy) t10).getPriority()));
                }
            }), 0 == true ? 1 : 0);
            signalHub.registerInvalidator(new g(performanceOrchestratorImpl, 10));
            return performanceOrchestratorImpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n buildDefault$lambda$3(PerformanceOrchestratorImpl performanceOrchestratorImpl) {
            performanceOrchestratorImpl.invalidate();
            return n.f10413a;
        }

        public final PerformanceOrchestratorImpl getInstance(Context context) {
            PerformanceOrchestratorImpl performanceOrchestratorImplBuildDefault;
            kotlin.jvm.internal.g.f(context, "context");
            PerformanceOrchestratorImpl performanceOrchestratorImpl = PerformanceOrchestratorImpl.instance;
            if (performanceOrchestratorImpl != null) {
                return performanceOrchestratorImpl;
            }
            synchronized (this) {
                performanceOrchestratorImplBuildDefault = PerformanceOrchestratorImpl.instance;
                if (performanceOrchestratorImplBuildDefault == null) {
                    performanceOrchestratorImplBuildDefault = PerformanceOrchestratorImpl.Companion.buildDefault(context);
                    PerformanceOrchestratorImpl.instance = performanceOrchestratorImplBuildDefault;
                }
            }
            return performanceOrchestratorImplBuildDefault;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PerformanceOrchestratorImpl(SignalHub signalHub, List list, e eVar) {
        this(signalHub, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpAuditLog$lambda$5$lambda$4(GlobalVerdict verdict) {
        kotlin.jvm.internal.g.f(verdict, "verdict");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("=== verdict @ " + verdict.getTimestampMs() + " ===");
        sb2.append('\n');
        sb2.append("backend=" + verdict.getRecommendedBackend() + ", constraint=" + verdict.getBackendConstraint());
        sb2.append('\n');
        sb2.append("maxConcurrent=" + verdict.getMaxConcurrent() + ", dspMax=" + verdict.getDspMaxConcurrent());
        sb2.append('\n');
        long idleTimeoutMs = verdict.getIdleTimeoutMs();
        long deferredReleaseDelayMs = verdict.getDeferredReleaseDelayMs();
        StringBuilder sbQ = ai.onnxruntime.a.q(idleTimeoutMs, "idleTimeout=", "ms, deferredRelease=");
        sbQ.append(deferredReleaseDelayMs);
        sbQ.append("ms");
        sb2.append(sbQ.toString());
        sb2.append('\n');
        sb2.append("thermal=" + verdict.getThermalState() + ", battery=" + verdict.getBatteryLevel() + "%, charging=" + verdict.isCharging());
        sb2.append('\n');
        Set<String> sealedFields = verdict.getSealedFields();
        StringBuilder sb3 = new StringBuilder("sealed: ");
        sb3.append(sealedFields);
        sb2.append(sb3.toString());
        sb2.append('\n');
        for (VerdictReason verdictReason : verdict.getReasons()) {
            String policyId = verdictReason.getPolicyId();
            String field = verdictReason.getField();
            String value = verdictReason.getValue();
            String action = verdictReason.getAction();
            String reason = verdictReason.getReason();
            StringBuilder sbS = ai.onnxruntime.a.s("  [", policyId, "] ", field, "=");
            ai.onnxruntime.a.z(sbS, value, " (", action, ") ← ");
            sbS.append(reason);
            sb2.append(sbS.toString());
            sb2.append('\n');
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    private final synchronized GlobalVerdict recompute() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GlobalVerdict globalVerdict = this.cachedGlobal;
        if (globalVerdict != null && !this.invalidated && jCurrentTimeMillis - this.cacheTimestampMs < 5000) {
            return globalVerdict;
        }
        SignalSnapshot signalSnapshotCollect = this.signalHub.collect();
        VerdictBuilder verdictBuilder = new VerdictBuilder(VerdictDefaults.Companion.from(signalSnapshotCollect));
        Iterator<T> it = this.policies.iterator();
        while (it.hasNext()) {
            ((IPerformancePolicy) it.next()).evaluate(signalSnapshotCollect, verdictBuilder);
        }
        GlobalVerdict globalVerdictBuild = verdictBuilder.build();
        this.cachedGlobal = globalVerdictBuild;
        this.cacheTimestampMs = System.currentTimeMillis();
        this.invalidated = false;
        ReentrantReadWriteLock.WriteLock writeLock = this.auditLock.writeLock();
        kotlin.jvm.internal.g.e(writeLock, "writeLock(...)");
        writeLock.lock();
        try {
            if (this.auditRing.a() >= 20) {
                this.auditRing.removeFirst();
            }
            this.auditRing.addLast(globalVerdictBuild);
            n nVar = n.f10413a;
            writeLock.unlock();
            return globalVerdictBuild;
        } finally {
            writeLock.unlock();
        }
    }

    public final GlobalVerdict cachedVerdict() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GlobalVerdict globalVerdict = this.cachedGlobal;
        return (globalVerdict == null || this.invalidated || jCurrentTimeMillis - this.cacheTimestampMs >= 5000) ? recompute() : globalVerdict;
    }

    public final PreInitAction decidePreInit(ModelMeta modelMeta) {
        kotlin.jvm.internal.g.f(modelMeta, "modelMeta");
        SignalSnapshot signalSnapshotLastSnapshot = this.signalHub.lastSnapshot();
        List<IPerformancePolicy> list = this.policies;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            PreInitAction preInitActionEvaluatePreInit = ((IPerformancePolicy) it.next()).evaluatePreInit(signalSnapshotLastSnapshot, modelMeta);
            if (kotlin.jvm.internal.g.b(preInitActionEvaluatePreInit, PreInitAction.NoOp.INSTANCE)) {
                preInitActionEvaluatePreInit = null;
            }
            if (preInitActionEvaluatePreInit != null) {
                arrayList.add(preInitActionEvaluatePreInit);
            }
        }
        PreInitAction preInitAction = (PreInitAction) a.v0(arrayList);
        return preInitAction == null ? PreInitAction.NoOp.INSTANCE : preInitAction;
    }

    public final String dumpAuditLog() {
        ReentrantReadWriteLock.ReadLock lock = this.auditLock.readLock();
        kotlin.jvm.internal.g.e(lock, "readLock(...)");
        lock.lock();
        try {
            return a.z0(this.auditRing, "\n\n", null, null, new d(26), 30);
        } finally {
            lock.unlock();
        }
    }

    public final EnrichedVerdict enrich(GlobalVerdict global, PerformanceRequestContext context) {
        kotlin.jvm.internal.g.f(global, "global");
        kotlin.jvm.internal.g.f(context, "context");
        return this.enrichment.enrich(global, context, this.signalHub.lastSnapshot());
    }

    public final void invalidate() {
        this.invalidated = true;
    }

    public final SignalHub signalHub() {
        return this.signalHub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PerformanceOrchestratorImpl(SignalHub signalHub, List<? extends IPerformancePolicy> list) {
        this.signalHub = signalHub;
        this.policies = list;
        this.auditRing = new k<>(20);
        this.auditLock = new ReentrantReadWriteLock();
        this.enrichment = new RequestEnrichment();
    }
}
