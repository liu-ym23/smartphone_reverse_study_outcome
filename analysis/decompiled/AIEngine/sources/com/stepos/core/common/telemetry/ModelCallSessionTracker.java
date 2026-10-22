package com.stepos.core.common.telemetry;

import android.os.SystemClock;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudTransport;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.common.util.TraceIdKeys;
import gc.o;
import gc.q;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallSessionTracker {
    private static final int ORPHAN_TERMINAL_DEDUP_CAP = 4096;
    public static final ModelCallSessionTracker INSTANCE = new ModelCallSessionTracker();
    private static final ConcurrentHashMap<String, SessionState> sessions = new ConcurrentHashMap<>();
    private static final BoundedInferIdSet orphanTerminalDedup = new BoundedInferIdSet(4096);
    private static final ConcurrentHashMap.KeySetView<String, Boolean> establishedLoggedKeys = ConcurrentHashMap.newKeySet();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BoundedInferIdSet {
        private final int cap;
        private final Object lock = new Object();
        private final LinkedHashSet<String> ids = new LinkedHashSet<>();

        public BoundedInferIdSet(int i10) {
            this.cap = i10;
        }

        private final void evictOldestIfNeeded() {
            while (this.ids.size() >= this.cap) {
                Iterator<String> it = this.ids.iterator();
                kotlin.jvm.internal.g.e(it, "iterator(...)");
                if (!it.hasNext()) {
                    return;
                }
                it.next();
                it.remove();
            }
        }

        public final boolean addIfAbsent(String id2) {
            kotlin.jvm.internal.g.f(id2, "id");
            synchronized (this.lock) {
                if (this.ids.contains(id2)) {
                    return false;
                }
                evictOldestIfNeeded();
                this.ids.add(id2);
                return true;
            }
        }

        public final boolean mark(String id2) {
            boolean zAdd;
            kotlin.jvm.internal.g.f(id2, "id");
            synchronized (this.lock) {
                evictOldestIfNeeded();
                zAdd = this.ids.add(id2);
            }
            return zAdd;
        }

        public final boolean remove(String id2) {
            boolean zRemove;
            kotlin.jvm.internal.g.f(id2, "id");
            synchronized (this.lock) {
                zRemove = this.ids.remove(id2);
            }
            return zRemove;
        }
    }

    private ModelCallSessionTracker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0(BindContext bindContext, String str) {
        kotlin.jvm.internal.g.c(str);
        return o.k0(str, bindContext.getInferId() + "|", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$1(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    private final ModelCallRecord buildFirstRecord(SessionState sessionState, String str) {
        long firstTokenMonoNs = sessionState.getFirstTokenMonoNs();
        long startMonoNs = firstTokenMonoNs > 0 ? (firstTokenMonoNs - sessionState.getCtx().getStartMonoNs()) / 1000000 : 0L;
        if (firstTokenMonoNs <= 0) {
            firstTokenMonoNs = sessionState.getCtx().getStartMonoNs();
        }
        return buildRecord(sessionState, str, "", 0, firstTokenMonoNs, 0L, startMonoNs);
    }

    private final ModelCallRecord buildRecord(SessionState sessionState, String str, String str2, int i10, long j10, long j11, long j12) {
        CloudSessionCorrelationState correlation = sessionState.getCorrelation();
        String cloudCorrelationId = correlation.getCloudCorrelationId();
        if (q.t0(cloudCorrelationId)) {
            cloudCorrelationId = correlation.getAsyncTaskId();
        }
        String str3 = cloudCorrelationId;
        String clientDebugTraceId = correlation.getClientDebugTraceId();
        if (q.t0(clientDebugTraceId)) {
            clientDebugTraceId = sessionState.getCtx().getBusinessTraceId();
        }
        return new ModelCallRecord(sessionState.getCtx().getExecutionPath(), str3, ModelCallRecord.Companion.sourceName(correlation.getSource()), str, sessionState.getCtx().getAbilityId(), sessionState.getCtx().getModelId(), sessionState.getCtx().getTransport(), sessionState.getCtx().getCallerUid(), sessionState.getCtx().getCallerPkg(), clientDebugTraceId, correlation.getGatewayTraceId(), correlation.getAsyncTaskId(), correlation.getConnectionGeneration(), str2, i10, sessionState.getCtx().getStartMonoNs(), j10, sessionState.getCtx().getStartWallMs(), j11, j12, correlation.getHeaderFetchMs(), correlation.getConnectToOpenMs(), correlation.getOpenToHandshakeAckMs(), correlation.getHandshakeAckToReadyMs(), sessionState.getUploadMs(), sessionState.getAsrMs(), sessionState.getAudioDurationMs());
    }

    private final ModelCallRecord buildTerminalRecord(SessionState sessionState, String str, ModelCallOutcome modelCallOutcome, int i10) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long j10 = 1000000;
        long startMonoNs = (jElapsedRealtimeNanos - sessionState.getCtx().getStartMonoNs()) / j10;
        long firstTokenMonoNs = sessionState.getFirstTokenMonoNs();
        return buildRecord(sessionState, str, modelCallOutcome.name(), i10, jElapsedRealtimeNanos, startMonoNs, firstTokenMonoNs > 0 ? (firstTokenMonoNs - sessionState.getCtx().getStartMonoNs()) / j10 : 0L);
    }

    private final ModelCallRecord buildUplinkRecord(SessionState sessionState, String str) {
        return buildRecord(sessionState, str, "", 0, sessionState.getCtx().getStartMonoNs(), 0L, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clear$lambda$10(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clear$lambda$9(String str, String str2) {
        kotlin.jvm.internal.g.c(str2);
        return o.k0(str2, str + "|", false);
    }

    public static /* synthetic */ BindContext edgeBindContext$default(ModelCallSessionTracker modelCallSessionTracker, String str, String str2, String str3, int i10, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            str5 = "";
        }
        return modelCallSessionTracker.edgeBindContext(str, str2, str3, i10, str4, str5, (i11 & 64) != 0 ? ModelCallSessionTrackerKt.MODEL_CALL_TRANSPORT_NATIVE : str6);
    }

    public static /* synthetic */ void recordStageTiming$default(ModelCallSessionTracker modelCallSessionTracker, String str, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = -1;
        }
        if ((i10 & 4) != 0) {
            j11 = -1;
        }
        if ((i10 & 8) != 0) {
            j12 = -1;
        }
        modelCallSessionTracker.recordStageTiming(str, j10, j11, j12);
    }

    public static /* synthetic */ void reportTerminalOnce$default(ModelCallSessionTracker modelCallSessionTracker, String str, ModelCallOutcome modelCallOutcome, int i10, CloudSessionCorrelationState cloudSessionCorrelationState, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            cloudSessionCorrelationState = null;
        }
        modelCallSessionTracker.reportTerminalOnce(str, modelCallOutcome, i10, cloudSessionCorrelationState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportTerminalOnce$lambda$4(String str, String str2) {
        kotlin.jvm.internal.g.c(str2);
        return o.k0(str2, str + "|", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportTerminalOnce$lambda$5(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    private final void uploadOrphanTerminal(String str, ModelCallOutcome modelCallOutcome, int i10, CloudSessionCorrelationState cloudSessionCorrelationState) {
        CloudSessionCorrelationState cloudSessionCorrelationState2;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (cloudSessionCorrelationState == null) {
            cloudSessionCorrelationState2 = new CloudSessionCorrelationState(null, null, null, null, 0, null, 0L, 0L, 0L, 0L, 1023, null);
        } else {
            cloudSessionCorrelationState2 = cloudSessionCorrelationState;
        }
        ModelCallExecutionPath modelCallExecutionPath = ModelCallExecutionPath.CLOUD;
        String cloudCorrelationId = cloudSessionCorrelationState2.getCloudCorrelationId();
        if (q.t0(cloudCorrelationId)) {
            cloudCorrelationId = cloudSessionCorrelationState2.getAsyncTaskId();
        }
        ModelCallUpload.INSTANCE.onDownlink(new ModelCallRecord(modelCallExecutionPath, cloudCorrelationId, ModelCallRecord.Companion.sourceName(cloudSessionCorrelationState2.getSource()), str, "", null, "", 0, "", cloudSessionCorrelationState2.getClientDebugTraceId(), cloudSessionCorrelationState2.getGatewayTraceId(), cloudSessionCorrelationState2.getAsyncTaskId(), cloudSessionCorrelationState2.getConnectionGeneration(), modelCallOutcome.name(), i10, jElapsedRealtimeNanos, jElapsedRealtimeNanos, System.currentTimeMillis(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 133693472, null));
    }

    public final void bind(BindContext ctx) {
        kotlin.jvm.internal.g.f(ctx, "ctx");
        AiEngineAtrace.endAll(ctx.getInferId());
        sessions.put(ctx.getInferId(), new SessionState(ctx, null, 0L, null, null, 0L, 0L, 0L, 254, null));
        orphanTerminalDedup.remove(ctx.getInferId());
        establishedLoggedKeys.removeIf(new b9.b(new androidx.compose.runtime.g(ctx, 10), 4));
        if (ctx.getExecutionPath() == ModelCallExecutionPath.EDGE) {
            AiEngineAtrace.begin(ctx.getInferId(), ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "e2e");
        }
    }

    public final void clear(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        sessions.remove(inferId);
        orphanTerminalDedup.remove(inferId);
        establishedLoggedKeys.removeIf(new b9.b(new com.stepos.core.ability.e(inferId, 1), 5));
    }

    public final BindContext cloudBindContext(String inferId, String abilityId, String modelId, int i10, String callerPkg, CloudTransport transport, String businessTraceId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(transport, "transport");
        kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
        return new BindContext(inferId, abilityId, modelId, i10, callerPkg, ModelCallExecutionPath.CLOUD, ModelCallRecord.Companion.transportName(transport), businessTraceId, 0L, 0L, 768, null);
    }

    public final BindContext edgeBindContext(String inferId, String abilityId, String modelId, int i10, String callerPkg, String businessTraceId, String transport) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
        kotlin.jvm.internal.g.f(transport, "transport");
        return new BindContext(inferId, abilityId, modelId, i10, callerPkg, ModelCallExecutionPath.EDGE, transport, businessTraceId, 0L, 0L, 768, null);
    }

    public final void logEstablishedOnce(String inferId, CloudSessionCorrelationState state) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(state, "state");
        String cloudCorrelationId = state.getCloudCorrelationId();
        if (q.t0(cloudCorrelationId)) {
            cloudCorrelationId = state.getAsyncTaskId();
        }
        if (q.t0(cloudCorrelationId)) {
            return;
        }
        if (establishedLoggedKeys.add(inferId + "|" + cloudCorrelationId + "|" + state.getConnectionGeneration())) {
            setCorrelationState(inferId, state);
            SessionState sessionState = sessions.get(inferId);
            if (sessionState != null && sessionState.getCtx().getExecutionPath() == ModelCallExecutionPath.CLOUD) {
                ModelCallUpload.INSTANCE.onUplink(buildUplinkRecord(sessionState, inferId));
            }
        }
    }

    public final void logModelReadyOnce(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        SessionState sessionState = sessions.get(inferId);
        if (sessionState != null && sessionState.getCtx().getExecutionPath() == ModelCallExecutionPath.EDGE) {
            if (establishedLoggedKeys.add(inferId.concat("|model_ready"))) {
                ModelCallUpload.INSTANCE.onUplink(buildUplinkRecord(sessionState, inferId));
            }
        }
    }

    public final void recordFirstToken(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        SessionState sessionState = sessions.get(inferId);
        if (sessionState == null) {
            return;
        }
        if (sessionState.getFirstTokenMonoNs() == 0) {
            sessionState.setFirstTokenMonoNs(SystemClock.elapsedRealtimeNanos());
        }
        if (sessionState.getFirstCallEmitted().compareAndSet(false, true)) {
            if (sessionState.getCtx().getExecutionPath() == ModelCallExecutionPath.EDGE) {
                AiEngineAtrace.end(inferId, ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "prefill_to_first_token");
            }
            ModelCallUpload.INSTANCE.onFirstCall(buildFirstRecord(sessionState, inferId));
        }
    }

    public final void recordStageTiming(String inferId, long j10, long j11, long j12) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        SessionState sessionState = sessions.get(inferId);
        if (sessionState == null) {
            return;
        }
        if (j10 >= 0) {
            sessionState.setUploadMs(j10);
        }
        if (j11 >= 0) {
            sessionState.setAsrMs(j11);
        }
        if (j12 >= 0) {
            sessionState.setAudioDurationMs(j12);
        }
    }

    public final void reportTerminalOnce(String inferId, ModelCallOutcome status, int i10, CloudSessionCorrelationState cloudSessionCorrelationState) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(status, "status");
        ConcurrentHashMap<String, SessionState> concurrentHashMap = sessions;
        SessionState sessionState = concurrentHashMap.get(inferId);
        if (sessionState == null) {
            if (orphanTerminalDedup.addIfAbsent(inferId)) {
                uploadOrphanTerminal(inferId, status, i10, cloudSessionCorrelationState);
                return;
            }
            return;
        }
        if (sessionState.getTerminalEmitted().compareAndSet(false, true)) {
            concurrentHashMap.remove(inferId);
            if (cloudSessionCorrelationState != null) {
                sessionState.setCorrelation(sessionState.getCorrelation().mergedWith(cloudSessionCorrelationState));
            }
            try {
                ModelCallUpload.INSTANCE.onDownlink(buildTerminalRecord(sessionState, inferId, status, i10));
                AiEngineAtrace.endAll(inferId);
                orphanTerminalDedup.mark(inferId);
                int i11 = 0;
                establishedLoggedKeys.removeIf(new e(new d(inferId, i11), i11));
            } catch (Throwable th) {
                AiEngineAtrace.endAll(inferId);
                orphanTerminalDedup.mark(inferId);
                establishedLoggedKeys.removeIf(new b9.b(new d(inferId, 0), 3));
                throw th;
            }
        }
    }

    public final void setCorrelationState(String inferId, CloudSessionCorrelationState state) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(state, "state");
        SessionState sessionState = sessions.get(inferId);
        if (sessionState == null) {
            return;
        }
        sessionState.setCorrelation(sessionState.getCorrelation().mergedWith(state));
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SessionState {
        private volatile long asrMs;
        private volatile long audioDurationMs;
        private volatile CloudSessionCorrelationState correlation;
        private final BindContext ctx;
        private final AtomicBoolean firstCallEmitted;
        private volatile long firstTokenMonoNs;
        private final AtomicBoolean terminalEmitted;
        private volatile long uploadMs;

        public SessionState(BindContext ctx, CloudSessionCorrelationState correlation, long j10, AtomicBoolean firstCallEmitted, AtomicBoolean terminalEmitted, long j11, long j12, long j13) {
            kotlin.jvm.internal.g.f(ctx, "ctx");
            kotlin.jvm.internal.g.f(correlation, "correlation");
            kotlin.jvm.internal.g.f(firstCallEmitted, "firstCallEmitted");
            kotlin.jvm.internal.g.f(terminalEmitted, "terminalEmitted");
            this.ctx = ctx;
            this.correlation = correlation;
            this.firstTokenMonoNs = j10;
            this.firstCallEmitted = firstCallEmitted;
            this.terminalEmitted = terminalEmitted;
            this.uploadMs = j11;
            this.asrMs = j12;
            this.audioDurationMs = j13;
        }

        public static /* synthetic */ SessionState copy$default(SessionState sessionState, BindContext bindContext, CloudSessionCorrelationState cloudSessionCorrelationState, long j10, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, long j11, long j12, long j13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bindContext = sessionState.ctx;
            }
            if ((i10 & 2) != 0) {
                cloudSessionCorrelationState = sessionState.correlation;
            }
            if ((i10 & 4) != 0) {
                j10 = sessionState.firstTokenMonoNs;
            }
            if ((i10 & 8) != 0) {
                atomicBoolean = sessionState.firstCallEmitted;
            }
            if ((i10 & 16) != 0) {
                atomicBoolean2 = sessionState.terminalEmitted;
            }
            if ((i10 & 32) != 0) {
                j11 = sessionState.uploadMs;
            }
            if ((i10 & 64) != 0) {
                j12 = sessionState.asrMs;
            }
            if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
                j13 = sessionState.audioDurationMs;
            }
            long j14 = j13;
            long j15 = j12;
            long j16 = j10;
            return sessionState.copy(bindContext, cloudSessionCorrelationState, j16, atomicBoolean, atomicBoolean2, j11, j15, j14);
        }

        public final BindContext component1() {
            return this.ctx;
        }

        public final CloudSessionCorrelationState component2() {
            return this.correlation;
        }

        public final long component3() {
            return this.firstTokenMonoNs;
        }

        public final AtomicBoolean component4() {
            return this.firstCallEmitted;
        }

        public final AtomicBoolean component5() {
            return this.terminalEmitted;
        }

        public final long component6() {
            return this.uploadMs;
        }

        public final long component7() {
            return this.asrMs;
        }

        public final long component8() {
            return this.audioDurationMs;
        }

        public final SessionState copy(BindContext ctx, CloudSessionCorrelationState correlation, long j10, AtomicBoolean firstCallEmitted, AtomicBoolean terminalEmitted, long j11, long j12, long j13) {
            kotlin.jvm.internal.g.f(ctx, "ctx");
            kotlin.jvm.internal.g.f(correlation, "correlation");
            kotlin.jvm.internal.g.f(firstCallEmitted, "firstCallEmitted");
            kotlin.jvm.internal.g.f(terminalEmitted, "terminalEmitted");
            return new SessionState(ctx, correlation, j10, firstCallEmitted, terminalEmitted, j11, j12, j13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionState)) {
                return false;
            }
            SessionState sessionState = (SessionState) obj;
            return kotlin.jvm.internal.g.b(this.ctx, sessionState.ctx) && kotlin.jvm.internal.g.b(this.correlation, sessionState.correlation) && this.firstTokenMonoNs == sessionState.firstTokenMonoNs && kotlin.jvm.internal.g.b(this.firstCallEmitted, sessionState.firstCallEmitted) && kotlin.jvm.internal.g.b(this.terminalEmitted, sessionState.terminalEmitted) && this.uploadMs == sessionState.uploadMs && this.asrMs == sessionState.asrMs && this.audioDurationMs == sessionState.audioDurationMs;
        }

        public final long getAsrMs() {
            return this.asrMs;
        }

        public final long getAudioDurationMs() {
            return this.audioDurationMs;
        }

        public final CloudSessionCorrelationState getCorrelation() {
            return this.correlation;
        }

        public final BindContext getCtx() {
            return this.ctx;
        }

        public final AtomicBoolean getFirstCallEmitted() {
            return this.firstCallEmitted;
        }

        public final long getFirstTokenMonoNs() {
            return this.firstTokenMonoNs;
        }

        public final AtomicBoolean getTerminalEmitted() {
            return this.terminalEmitted;
        }

        public final long getUploadMs() {
            return this.uploadMs;
        }

        public int hashCode() {
            return Long.hashCode(this.audioDurationMs) + a0.a.c(a0.a.c((this.terminalEmitted.hashCode() + ((this.firstCallEmitted.hashCode() + a0.a.c((this.correlation.hashCode() + (this.ctx.hashCode() * 31)) * 31, this.firstTokenMonoNs, 31)) * 31)) * 31, this.uploadMs, 31), this.asrMs, 31);
        }

        public final void setAsrMs(long j10) {
            this.asrMs = j10;
        }

        public final void setAudioDurationMs(long j10) {
            this.audioDurationMs = j10;
        }

        public final void setCorrelation(CloudSessionCorrelationState cloudSessionCorrelationState) {
            kotlin.jvm.internal.g.f(cloudSessionCorrelationState, "<set-?>");
            this.correlation = cloudSessionCorrelationState;
        }

        public final void setFirstTokenMonoNs(long j10) {
            this.firstTokenMonoNs = j10;
        }

        public final void setUploadMs(long j10) {
            this.uploadMs = j10;
        }

        public String toString() {
            BindContext bindContext = this.ctx;
            CloudSessionCorrelationState cloudSessionCorrelationState = this.correlation;
            long j10 = this.firstTokenMonoNs;
            AtomicBoolean atomicBoolean = this.firstCallEmitted;
            AtomicBoolean atomicBoolean2 = this.terminalEmitted;
            long j11 = this.uploadMs;
            long j12 = this.asrMs;
            long j13 = this.audioDurationMs;
            StringBuilder sb2 = new StringBuilder("SessionState(ctx=");
            sb2.append(bindContext);
            sb2.append(", correlation=");
            sb2.append(cloudSessionCorrelationState);
            sb2.append(", firstTokenMonoNs=");
            sb2.append(j10);
            sb2.append(", firstCallEmitted=");
            sb2.append(atomicBoolean);
            sb2.append(", terminalEmitted=");
            sb2.append(atomicBoolean2);
            sb2.append(", uploadMs=");
            sb2.append(j11);
            a0.a.s(j12, ", asrMs=", ", audioDurationMs=", sb2);
            return ai.onnxruntime.a.m(sb2, j13, ")");
        }

        public /* synthetic */ SessionState(BindContext bindContext, CloudSessionCorrelationState cloudSessionCorrelationState, long j10, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, long j11, long j12, long j13, int i10, kotlin.jvm.internal.e eVar) {
            this(bindContext, (i10 & 2) != 0 ? new CloudSessionCorrelationState(null, null, null, null, 0, null, 0L, 0L, 0L, 0L, 1023, null) : cloudSessionCorrelationState, (i10 & 4) != 0 ? 0L : j10, (i10 & 8) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i10 & 16) != 0 ? new AtomicBoolean(false) : atomicBoolean2, (i10 & 32) != 0 ? -1L : j11, (i10 & 64) != 0 ? -1L : j12, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? -1L : j13);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BindContext {
        private final String abilityId;
        private final String businessTraceId;
        private final String callerPkg;
        private final int callerUid;
        private final ModelCallExecutionPath executionPath;
        private final String inferId;
        private final String modelId;
        private final long startMonoNs;
        private final long startWallMs;
        private final String transport;

        public BindContext(String inferId, String abilityId, String modelId, int i10, String callerPkg, ModelCallExecutionPath executionPath, String transport, String businessTraceId, long j10, long j11) {
            kotlin.jvm.internal.g.f(inferId, "inferId");
            kotlin.jvm.internal.g.f(abilityId, "abilityId");
            kotlin.jvm.internal.g.f(modelId, "modelId");
            kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
            kotlin.jvm.internal.g.f(executionPath, "executionPath");
            kotlin.jvm.internal.g.f(transport, "transport");
            kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
            this.inferId = inferId;
            this.abilityId = abilityId;
            this.modelId = modelId;
            this.callerUid = i10;
            this.callerPkg = callerPkg;
            this.executionPath = executionPath;
            this.transport = transport;
            this.businessTraceId = businessTraceId;
            this.startMonoNs = j10;
            this.startWallMs = j11;
        }

        public static /* synthetic */ BindContext copy$default(BindContext bindContext, String str, String str2, String str3, int i10, String str4, ModelCallExecutionPath modelCallExecutionPath, String str5, String str6, long j10, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bindContext.inferId;
            }
            if ((i11 & 2) != 0) {
                str2 = bindContext.abilityId;
            }
            if ((i11 & 4) != 0) {
                str3 = bindContext.modelId;
            }
            if ((i11 & 8) != 0) {
                i10 = bindContext.callerUid;
            }
            if ((i11 & 16) != 0) {
                str4 = bindContext.callerPkg;
            }
            if ((i11 & 32) != 0) {
                modelCallExecutionPath = bindContext.executionPath;
            }
            if ((i11 & 64) != 0) {
                str5 = bindContext.transport;
            }
            if ((i11 & TraceIdKeys.MAX_LENGTH) != 0) {
                str6 = bindContext.businessTraceId;
            }
            if ((i11 & 256) != 0) {
                j10 = bindContext.startMonoNs;
            }
            if ((i11 & VadSessionManager.FRAME_BYTES) != 0) {
                j11 = bindContext.startWallMs;
            }
            long j12 = j11;
            long j13 = j10;
            String str7 = str5;
            String str8 = str6;
            String str9 = str4;
            ModelCallExecutionPath modelCallExecutionPath2 = modelCallExecutionPath;
            return bindContext.copy(str, str2, str3, i10, str9, modelCallExecutionPath2, str7, str8, j13, j12);
        }

        public final String component1() {
            return this.inferId;
        }

        public final long component10() {
            return this.startWallMs;
        }

        public final String component2() {
            return this.abilityId;
        }

        public final String component3() {
            return this.modelId;
        }

        public final int component4() {
            return this.callerUid;
        }

        public final String component5() {
            return this.callerPkg;
        }

        public final ModelCallExecutionPath component6() {
            return this.executionPath;
        }

        public final String component7() {
            return this.transport;
        }

        public final String component8() {
            return this.businessTraceId;
        }

        public final long component9() {
            return this.startMonoNs;
        }

        public final BindContext copy(String inferId, String abilityId, String modelId, int i10, String callerPkg, ModelCallExecutionPath executionPath, String transport, String businessTraceId, long j10, long j11) {
            kotlin.jvm.internal.g.f(inferId, "inferId");
            kotlin.jvm.internal.g.f(abilityId, "abilityId");
            kotlin.jvm.internal.g.f(modelId, "modelId");
            kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
            kotlin.jvm.internal.g.f(executionPath, "executionPath");
            kotlin.jvm.internal.g.f(transport, "transport");
            kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
            return new BindContext(inferId, abilityId, modelId, i10, callerPkg, executionPath, transport, businessTraceId, j10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BindContext)) {
                return false;
            }
            BindContext bindContext = (BindContext) obj;
            return kotlin.jvm.internal.g.b(this.inferId, bindContext.inferId) && kotlin.jvm.internal.g.b(this.abilityId, bindContext.abilityId) && kotlin.jvm.internal.g.b(this.modelId, bindContext.modelId) && this.callerUid == bindContext.callerUid && kotlin.jvm.internal.g.b(this.callerPkg, bindContext.callerPkg) && this.executionPath == bindContext.executionPath && kotlin.jvm.internal.g.b(this.transport, bindContext.transport) && kotlin.jvm.internal.g.b(this.businessTraceId, bindContext.businessTraceId) && this.startMonoNs == bindContext.startMonoNs && this.startWallMs == bindContext.startWallMs;
        }

        public final String getAbilityId() {
            return this.abilityId;
        }

        public final String getBusinessTraceId() {
            return this.businessTraceId;
        }

        public final String getCallerPkg() {
            return this.callerPkg;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final ModelCallExecutionPath getExecutionPath() {
            return this.executionPath;
        }

        public final String getInferId() {
            return this.inferId;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public final long getStartMonoNs() {
            return this.startMonoNs;
        }

        public final long getStartWallMs() {
            return this.startWallMs;
        }

        public final String getTransport() {
            return this.transport;
        }

        public int hashCode() {
            return Long.hashCode(this.startWallMs) + a0.a.c(v1.d.a(v1.d.a((this.executionPath.hashCode() + v1.d.a(ai.onnxruntime.a.d(this.callerUid, v1.d.a(v1.d.a(this.inferId.hashCode() * 31, 31, this.abilityId), 31, this.modelId), 31), 31, this.callerPkg)) * 31, 31, this.transport), 31, this.businessTraceId), this.startMonoNs, 31);
        }

        public String toString() {
            String str = this.inferId;
            String str2 = this.abilityId;
            String str3 = this.modelId;
            int i10 = this.callerUid;
            String str4 = this.callerPkg;
            ModelCallExecutionPath modelCallExecutionPath = this.executionPath;
            String str5 = this.transport;
            String str6 = this.businessTraceId;
            long j10 = this.startMonoNs;
            long j11 = this.startWallMs;
            StringBuilder sbS = ai.onnxruntime.a.s("BindContext(inferId=", str, ", abilityId=", str2, ", modelId=");
            com.stepos.core.ota.d.o(i10, str3, ", callerUid=", ", callerPkg=", sbS);
            sbS.append(str4);
            sbS.append(", executionPath=");
            sbS.append(modelCallExecutionPath);
            sbS.append(", transport=");
            ai.onnxruntime.a.z(sbS, str5, ", businessTraceId=", str6, ", startMonoNs=");
            sbS.append(j10);
            return a0.a.d(j11, ", startWallMs=", ")", sbS);
        }

        public /* synthetic */ BindContext(String str, String str2, String str3, int i10, String str4, ModelCallExecutionPath modelCallExecutionPath, String str5, String str6, long j10, long j11, int i11, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, i10, str4, modelCallExecutionPath, str5, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? "" : str6, (i11 & 256) != 0 ? SystemClock.elapsedRealtimeNanos() : j10, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? System.currentTimeMillis() : j11);
        }
    }
}
