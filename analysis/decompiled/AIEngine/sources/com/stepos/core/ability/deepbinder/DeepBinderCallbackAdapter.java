package com.stepos.core.ability.deepbinder;

import ai.onnxruntime.a;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IInferenceStreamCallback;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.ota.d;
import h0.e;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeepBinderCallbackAdapter extends IInferenceCallback.Stub {
    private final String TAG;
    private final String inferId;
    private final InferRecycleGate recycleGate;
    private final IInferenceStreamCallback streamCallback;
    private final AtomicBoolean terminalSent;

    public DeepBinderCallbackAdapter(String inferId, IInferenceStreamCallback streamCallback, InferRecycleGate recycleGate) {
        g.f(inferId, "inferId");
        g.f(streamCallback, "streamCallback");
        g.f(recycleGate, "recycleGate");
        this.inferId = inferId;
        this.streamCallback = streamCallback;
        this.recycleGate = recycleGate;
        this.TAG = "DBCallbackAdapter";
        this.terminalSent = new AtomicBoolean(false);
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onComplete(String inferId) {
        Object objA;
        g.f(inferId, "inferId");
        if (!this.terminalSent.compareAndSet(false, true)) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, "[DIAG] onComplete dropped (terminal already sent): inferId=".concat(inferId));
            return;
        }
        AIEngineLogger.i(LogModule.IPC, this.TAG, "[DIAG] onComplete: inferId=".concat(inferId));
        try {
            this.streamCallback.onComplete(inferId);
            if (this.recycleGate.onInferTerminal(inferId)) {
                this.streamCallback.onRecycle();
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.IPC, this.TAG, a.l("[DIAG] onComplete/onRecycle FAILED: inferId=", inferId, ", ", thB.getMessage()), thB);
        }
        AIEngineLogger.i(LogModule.IPC, this.TAG, "[DIAG] onComplete DONE: inferId=".concat(inferId));
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onError(String inferId, int i10, String str) {
        Object objA;
        g.f(inferId, "inferId");
        if (!this.terminalSent.compareAndSet(false, true)) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, d.h("[DIAG] onError dropped (terminal already sent): inferId=", i10, inferId, ", code="));
            return;
        }
        a0.a.x(e.f("[DIAG] onError: inferId=", inferId, ", code=", i10, ", msg="), str, LogModule.IPC, this.TAG);
        try {
            IInferenceStreamCallback iInferenceStreamCallback = this.streamCallback;
            if (str == null) {
                str = "";
            }
            iInferenceStreamCallback.onError(inferId, i10, str);
            objA = Boolean.valueOf(this.recycleGate.onInferTerminal(inferId));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.IPC, this.TAG, a.l("[DIAG] onError FAILED: inferId=", inferId, ", ", thB.getMessage()), thB);
        }
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onOutput(String inferId, Content output) {
        Object objA;
        g.f(inferId, "inferId");
        g.f(output, "output");
        try {
            this.streamCallback.onOutput(inferId, output);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            LogModule logModule = LogModule.IPC;
            String str = this.TAG;
            String simpleName = thB.getClass().getSimpleName();
            String message = thB.getMessage();
            StringBuilder sbS = a.s("[DIAG] onOutput FAILED: inferId=", inferId, ", ", simpleName, ": ");
            sbS.append(message);
            AIEngineLogger.e(logModule, str, sbS.toString(), thB);
            onError(inferId, AIEngineError.IPC_BINDER_FAILED, "result delivery failed: ".concat(thB.getClass().getSimpleName()));
        }
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onProgress(String inferId, int i10, Content content) {
        g.f(inferId, "inferId");
        try {
            this.streamCallback.onProgress(inferId, i10, content);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onRoutingDecision(String inferId, String executionLocation, String reason) {
        g.f(inferId, "inferId");
        g.f(executionLocation, "executionLocation");
        g.f(reason, "reason");
        try {
            this.streamCallback.onRoutingDecision(inferId, executionLocation, reason);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }
}
