package com.stepos.core.ability.telemetry;

import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudTransport;
import com.stepos.core.common.telemetry.ModelCallOutcome;
import com.stepos.core.common.telemetry.ModelCallSessionTracker;
import com.stepos.core.common.telemetry.ModelCallSessionTrackerKt;
import com.stepos.core.common.util.TraceIdExtractorKt;
import com.stepos.core.model.task.AITaskRecord;
import kotlin.Pair;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallBridge {
    public static final ModelCallBridge INSTANCE = new ModelCallBridge();

    private ModelCallBridge() {
    }

    public static /* synthetic */ void bindEdge$default(ModelCallBridge modelCallBridge, String str, String str2, String str3, int i10, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            str5 = "";
        }
        modelCallBridge.bindEdge(str, str2, str3, i10, str4, str5, (i11 & 64) != 0 ? ModelCallSessionTrackerKt.MODEL_CALL_TRANSPORT_NATIVE : str6);
    }

    public static /* synthetic */ void recordStageTiming$default(ModelCallBridge modelCallBridge, String str, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = -1;
        }
        if ((i10 & 4) != 0) {
            j11 = -1;
        }
        if ((i10 & 8) != 0) {
            j12 = -1;
        }
        modelCallBridge.recordStageTiming(str, j10, j11, j12);
    }

    public static /* synthetic */ void reportTerminal$default(ModelCallBridge modelCallBridge, String str, InferResult inferResult, CloudSessionCorrelationState cloudSessionCorrelationState, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cloudSessionCorrelationState = null;
        }
        modelCallBridge.reportTerminal(str, inferResult, cloudSessionCorrelationState);
    }

    private final Pair<ModelCallOutcome, Integer> statusFromInferResult(InferResult inferResult) {
        if (inferResult instanceof InferResult.Complete) {
            return new Pair<>(ModelCallOutcome.SUCCESS, 0);
        }
        if (!(inferResult instanceof InferResult.Error)) {
            return new Pair<>(ModelCallOutcome.FAILED, 0);
        }
        InferResult.Error error = (InferResult.Error) inferResult;
        int errorCode = error.getErrorCode();
        return errorCode != -101 ? errorCode != -100 ? new Pair<>(ModelCallOutcome.FAILED, Integer.valueOf(error.getErrorCode())) : new Pair<>(ModelCallOutcome.CANCELLED, Integer.valueOf(error.getErrorCode())) : new Pair<>(ModelCallOutcome.TIMEOUT, Integer.valueOf(error.getErrorCode()));
    }

    public final void bindCloud(String inferId, String abilityId, String modelId, int i10, String callerPkg, CloudTransport transport, String businessTraceId) {
        g.f(inferId, "inferId");
        g.f(abilityId, "abilityId");
        g.f(modelId, "modelId");
        g.f(callerPkg, "callerPkg");
        g.f(transport, "transport");
        g.f(businessTraceId, "businessTraceId");
        ModelCallSessionTracker modelCallSessionTracker = ModelCallSessionTracker.INSTANCE;
        modelCallSessionTracker.bind(modelCallSessionTracker.cloudBindContext(inferId, abilityId, modelId, i10, callerPkg, transport, TraceIdExtractorKt.resolveFlywheelTraceId(businessTraceId)));
    }

    public final void bindEdge(String inferId, String abilityId, String modelId, int i10, String callerPkg, String businessTraceId, String transport) {
        g.f(inferId, "inferId");
        g.f(abilityId, "abilityId");
        g.f(modelId, "modelId");
        g.f(callerPkg, "callerPkg");
        g.f(businessTraceId, "businessTraceId");
        g.f(transport, "transport");
        ModelCallSessionTracker modelCallSessionTracker = ModelCallSessionTracker.INSTANCE;
        modelCallSessionTracker.bind(modelCallSessionTracker.edgeBindContext(inferId, abilityId, modelId, i10, callerPkg, TraceIdExtractorKt.resolveFlywheelTraceId(businessTraceId), transport));
    }

    public final Pair<Integer, String> callerFromRecord(Object obj) {
        AITaskRecord aITaskRecord = obj instanceof AITaskRecord ? (AITaskRecord) obj : null;
        return aITaskRecord == null ? new Pair<>(0, "") : new Pair<>(Integer.valueOf(aITaskRecord.getCallerUid()), aITaskRecord.getCallerPackage());
    }

    public final void logEstablished(String inferId, CloudSessionCorrelationState state) {
        g.f(inferId, "inferId");
        g.f(state, "state");
        ModelCallSessionTracker.INSTANCE.logEstablishedOnce(inferId, state);
    }

    public final void logModelReady(String inferId) {
        g.f(inferId, "inferId");
        ModelCallSessionTracker.INSTANCE.logModelReadyOnce(inferId);
    }

    public final void mergeSessionState(String inferId, CloudSessionCorrelationState state) {
        g.f(inferId, "inferId");
        g.f(state, "state");
        ModelCallSessionTracker.INSTANCE.setCorrelationState(inferId, state);
    }

    public final void recordFirstToken(String inferId) {
        g.f(inferId, "inferId");
        ModelCallSessionTracker.INSTANCE.recordFirstToken(inferId);
    }

    public final void recordStageTiming(String inferId, long j10, long j11, long j12) {
        g.f(inferId, "inferId");
        ModelCallSessionTracker.INSTANCE.recordStageTiming(inferId, j10, j11, j12);
    }

    public final void reportTerminal(String inferId, InferResult result, CloudSessionCorrelationState cloudSessionCorrelationState) {
        g.f(inferId, "inferId");
        g.f(result, "result");
        Pair<ModelCallOutcome, Integer> pairStatusFromInferResult = statusFromInferResult(result);
        ModelCallSessionTracker.INSTANCE.reportTerminalOnce(inferId, pairStatusFromInferResult.f9985a, pairStatusFromInferResult.f9986b.intValue(), cloudSessionCorrelationState);
    }

    public static /* synthetic */ void reportTerminal$default(ModelCallBridge modelCallBridge, String str, ModelCallOutcome modelCallOutcome, int i10, CloudSessionCorrelationState cloudSessionCorrelationState, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            cloudSessionCorrelationState = null;
        }
        modelCallBridge.reportTerminal(str, modelCallOutcome, i10, cloudSessionCorrelationState);
    }

    public final void reportTerminal(String inferId, ModelCallOutcome status, int i10, CloudSessionCorrelationState cloudSessionCorrelationState) {
        g.f(inferId, "inferId");
        g.f(status, "status");
        ModelCallSessionTracker.INSTANCE.reportTerminalOnce(inferId, status, i10, cloudSessionCorrelationState);
    }
}
