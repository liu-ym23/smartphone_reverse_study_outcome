package com.stepos.core.ability.handler;

import a0.a;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BinderResultHandler implements IResultHandler {
    private final String TAG = "BinderResultHandler";
    private final IInferenceCallback callback;

    public BinderResultHandler(IInferenceCallback iInferenceCallback) {
        this.callback = iInferenceCallback;
    }

    @Override // com.stepos.core.ability.handler.IResultHandler
    public void onResult(String requestId, InferResult result) {
        g.f(requestId, "requestId");
        g.f(result, "result");
        IInferenceCallback iInferenceCallback = this.callback;
        if (iInferenceCallback == null) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, "Callback is null, result dropped: requestId=".concat(requestId));
            return;
        }
        if (result instanceof InferResult.Output) {
            iInferenceCallback.onOutput(requestId, ((InferResult.Output) result).getContent());
            return;
        }
        if (result instanceof InferResult.Error) {
            InferResult.Error error = (InferResult.Error) result;
            AIEngineLogger.d(LogModule.IPC, this.TAG, d.h("onError: requestId=", error.getErrorCode(), requestId, ", code="));
            this.callback.onError(requestId, error.getErrorCode(), error.getMessage());
            return;
        }
        if (result.equals(InferResult.Complete.INSTANCE)) {
            AIEngineLogger.d(LogModule.IPC, this.TAG, "onComplete: requestId=".concat(requestId));
            this.callback.onComplete(requestId);
            return;
        }
        if (!(result instanceof InferResult.RoutingDecision)) {
            if (!(result instanceof InferResult.Progress)) {
                throw new NoWhenBranchMatchedException();
            }
            InferResult.Progress progress = (InferResult.Progress) result;
            AIEngineLogger.d(LogModule.IPC, this.TAG, d.h("onProgress: requestId=", progress.getPercent(), requestId, ", percent="));
            this.callback.onProgress(requestId, progress.getPercent(), progress.getExtra());
            return;
        }
        LogModule logModule = LogModule.IPC;
        String str = this.TAG;
        InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
        String executionLocation = routingDecision.getExecutionLocation();
        a.z(ai.onnxruntime.a.s("onRoutingDecision: requestId=", requestId, ", location=", executionLocation, ", reason="), routingDecision.getReason(), logModule, str);
        this.callback.onRoutingDecision(requestId, routingDecision.getExecutionLocation(), routingDecision.getReason());
    }
}
