package com.stepos.core.transport.bridge;

import Y8.t;
import Z8.F;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.core.deepbinder.IInferenceStreamCallback;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.transport.bridge.InferenceResponseResult;
import com.stepos.core.transport.bridge.TransportResponse;
import com.stepos.core.transport.factory.DeepBinderExtKt;
import com.stepos.core.transport.factory.RebuildableAbilityService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0014\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020%¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101RT\u00104\u001aB\u0012\f\u0012\n 3*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n 3*\u0004\u0018\u00010\u001d0\u001d 3* \u0012\f\u0012\n 3*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n 3*\u0004\u0018\u00010\u001d0\u001d\u0018\u000102028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/stepos/core/transport/bridge/DeepBinderTransportBridge;", "Lcom/stepos/core/transport/bridge/IInferenceBridge;", "Lcom/stepos/core/transport/factory/RebuildableAbilityService;", "svc", "<init>", "(Lcom/stepos/core/transport/factory/RebuildableAbilityService;)V", "", "requestId", "Lcom/stepos/core/transport/bridge/InferenceRequest;", "request", "Lcom/stepos/core/deepbinder/IInferenceStreamCallback;", "callback", "Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "sendInferSync", "(Ljava/lang/String;Lcom/stepos/core/transport/bridge/InferenceRequest;Lcom/stepos/core/deepbinder/IInferenceStreamCallback;)Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "inferId", "LY8/t;", "trackInferSent", "(Ljava/lang/String;)V", "markInferTerminal", "com/stepos/core/transport/bridge/DeepBinderTransportBridge$buildCallback$1", "buildCallback", "()Lcom/stepos/core/transport/bridge/DeepBinderTransportBridge$buildCallback$1;", "send", "(Lcom/stepos/core/transport/bridge/InferenceRequest;)Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "Lcom/stepos/core/transport/bridge/IResponseHandler;", "handler", "setResponseHandler", "(Lcom/stepos/core/transport/bridge/IResponseHandler;)V", "", "isReady", "()Z", "release", "()V", "cancel", "(Ljava/lang/String;)Z", "action", "Lcom/stepos/core/data/base/Content;", "params", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "input", "feedInput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "completeInput", "Lcom/stepos/core/transport/factory/RebuildableAbilityService;", "TAG", "Ljava/lang/String;", "responseHandler", "Lcom/stepos/core/transport/bridge/IResponseHandler;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "activeInferIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "inferSyncSupported", "Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderTransportBridge implements IInferenceBridge {
    private final String TAG;
    private final ConcurrentHashMap.KeySetView<String, Boolean> activeInferIds;
    private volatile boolean inferSyncSupported;
    private IResponseHandler responseHandler;
    private final RebuildableAbilityService svc;

    public DeepBinderTransportBridge(RebuildableAbilityService svc) {
        p.i(svc, "svc");
        this.svc = svc;
        this.TAG = "DeepBinderTransportBridge";
        this.activeInferIds = ConcurrentHashMap.newKeySet();
        this.inferSyncSupported = true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.stepos.core.transport.bridge.DeepBinderTransportBridge$buildCallback$1] */
    private final AnonymousClass1 buildCallback() {
        return new IInferenceStreamCallback() { // from class: com.stepos.core.transport.bridge.DeepBinderTransportBridge.buildCallback.1
            @Override // com.stepos.core.deepbinder.IInferenceStreamCallback
            public void onComplete(String inferId) {
                p.i(inferId, "inferId");
                DeepBinderTransportBridge.this.markInferTerminal(inferId);
                IResponseHandler iResponseHandler = DeepBinderTransportBridge.this.responseHandler;
                if (iResponseHandler == null) {
                    Log.w(DeepBinderTransportBridge.this.TAG, "onComplete dropped: responseHandler already released, inferId=" + inferId);
                    return;
                }
                Log.i(DeepBinderTransportBridge.this.TAG, "onComplete: inferId=" + inferId);
                iResponseHandler.onResponse(inferId, TransportResponse.Complete.INSTANCE);
            }

            @Override // com.stepos.core.deepbinder.IInferenceStreamCallback
            public void onError(String inferId, int errorCode, String message) {
                p.i(inferId, "inferId");
                p.i(message, "message");
                DeepBinderTransportBridge.this.markInferTerminal(inferId);
                IResponseHandler iResponseHandler = DeepBinderTransportBridge.this.responseHandler;
                if (iResponseHandler == null) {
                    Log.w(DeepBinderTransportBridge.this.TAG, "onError dropped: responseHandler already released, inferId=" + inferId + ", errorCode=" + errorCode + ", message=" + message);
                    return;
                }
                Log.i(DeepBinderTransportBridge.this.TAG, "onError: inferId=" + inferId + ", errorCode=" + errorCode + ", message=" + message);
                iResponseHandler.onResponse(inferId, TransportResponse.INSTANCE.fromErrorCode(errorCode, message));
            }

            @Override // com.stepos.core.deepbinder.IInferenceStreamCallback
            public void onOutput(String inferId, Content output) {
                p.i(inferId, "inferId");
                p.i(output, "output");
                IResponseHandler iResponseHandler = DeepBinderTransportBridge.this.responseHandler;
                if (iResponseHandler != null) {
                    iResponseHandler.onResponse(inferId, new TransportResponse.Result(output));
                    return;
                }
                Log.w(DeepBinderTransportBridge.this.TAG, "onOutput dropped: responseHandler already released, inferId=" + inferId);
            }

            @Override // com.stepos.core.deepbinder.IInferenceStreamCallback
            public void onProgress(String inferId, int percent, Content extra) {
                p.i(inferId, "inferId");
                IResponseHandler iResponseHandler = DeepBinderTransportBridge.this.responseHandler;
                if (iResponseHandler != null) {
                    iResponseHandler.onResponse(inferId, new TransportResponse.Progress(percent, extra));
                }
            }

            @Override // com.stepos.core.deepbinder.IInferenceStreamCallback
            public void onRecycle() {
            }

            @Override // com.stepos.core.deepbinder.IInferenceStreamCallback
            public void onRoutingDecision(String inferId, String executionLocation, String reason) {
                p.i(inferId, "inferId");
                p.i(executionLocation, "executionLocation");
                p.i(reason, "reason");
                IResponseHandler iResponseHandler = DeepBinderTransportBridge.this.responseHandler;
                if (iResponseHandler == null) {
                    Log.w(DeepBinderTransportBridge.this.TAG, "onRoutingDecision dropped: responseHandler already released, inferId=" + inferId + ", location=" + executionLocation + ", reason=" + reason);
                    return;
                }
                Log.i(DeepBinderTransportBridge.this.TAG, "onRoutingDecision: inferId=" + inferId + ", location=" + executionLocation + ", reason=" + reason);
                iResponseHandler.onResponse(inferId, new TransportResponse.RoutingDecision(executionLocation, reason));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Content execute$lambda$4$lambda$3(String str, Content content, IAbilityDeepBinderService it) {
        p.i(it, "it");
        return it.execute(str, content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markInferTerminal(String inferId) {
        this.activeInferIds.remove(inferId);
    }

    private final InferenceResponseResult sendInferSync(final String requestId, final InferenceRequest request, final IInferenceStreamCallback callback) {
        int iIntValue = ((Number) this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.transport.bridge.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(DeepBinderTransportBridge.sendInferSync$lambda$0(requestId, request, callback, (IAbilityDeepBinderService) obj));
            }
        })).intValue();
        if (iIntValue == 0) {
            trackInferSent(requestId);
            Log.d(this.TAG, "send via inferSync OK: requestId=" + requestId);
            return new InferenceResponseResult.Success(requestId);
        }
        Log.w(this.TAG, "send via inferSync REJECTED: requestId=" + requestId + ", ack=" + iIntValue);
        return new InferenceResponseResult.Failure(requestId, new InferenceResponseError(iIntValue, "inferSync rejected: ack=" + iIntValue, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sendInferSync$lambda$0(String str, InferenceRequest inferenceRequest, IInferenceStreamCallback iInferenceStreamCallback, IAbilityDeepBinderService it) {
        p.i(it, "it");
        return it.inferSync(str, inferenceRequest.getInput(), iInferenceStreamCallback);
    }

    private final void trackInferSent(String inferId) {
        this.activeInferIds.add(inferId);
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public boolean cancel(String inferId) {
        Object objB;
        p.i(inferId, "inferId");
        Log.i(this.TAG, "cancel: inferId=" + inferId);
        this.activeInferIds.remove(inferId);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.svc.getCurrent().cancelInfer(inferId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void completeInput(String inferId) {
        Object objB;
        p.i(inferId, "inferId");
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.getCurrent().completeInput(inferId);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "completeInput failed: inferId=" + inferId, thE);
        }
    }

    public final Content execute(final String action, final Content params) {
        Object objB;
        p.i(action, "action");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((Content) this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.transport.bridge.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DeepBinderTransportBridge.execute$lambda$4$lambda$3(action, params, (IAbilityDeepBinderService) obj);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "execute failed: action=" + action, thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Content) objB;
    }

    public final void feedInput(String inferId, Content input) {
        Object objB;
        p.i(inferId, "inferId");
        p.i(input, "input");
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.getCurrent().feedInput(inferId, input);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "feedInput failed: inferId=" + inferId, thE);
        }
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public boolean isReady() {
        return true;
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public void release() {
        ConcurrentHashMap.KeySetView<String, Boolean> activeInferIds = this.activeInferIds;
        p.h(activeInferIds, "activeInferIds");
        List listM1 = F.m1(activeInferIds);
        int size = listM1.size();
        if (size == 0) {
            Log.i(this.TAG, "release: inferIds=none");
        } else if (size != 1) {
            Log.i(this.TAG, "release: inferIds=" + F.A0(listM1, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
        } else {
            Log.i(this.TAG, "release: inferId=" + listM1.get(0));
        }
        this.responseHandler = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.getCurrent().release();
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public InferenceResponseResult send(InferenceRequest request) {
        p.i(request, "request");
        String requestId = request.getRequestId();
        AnonymousClass1 anonymousClass1BuildCallback = buildCallback();
        if (this.inferSyncSupported) {
            try {
                return sendInferSync(requestId, request, anonymousClass1BuildCallback);
            } catch (Exception e10) {
                if (!DeepBinderExtKt.isMethodNotFound(e10)) {
                    Log.e(this.TAG, "send via inferSync failed: " + requestId, e10);
                    String message = e10.getMessage();
                    if (message == null) {
                        message = "inferSync failed";
                    }
                    return new InferenceResponseResult.Failure(requestId, new InferenceResponseError(AIEngineError.IPC_BINDER_FAILED, message, null, 4, null));
                }
                this.inferSyncSupported = false;
                Log.w(this.TAG, "inferSync unsupported (old service), fallback to oneway infer: requestId=" + requestId);
            }
        }
        try {
            this.svc.getCurrent().infer(requestId, request.getInput(), anonymousClass1BuildCallback);
            this.trackInferSent(requestId);
            Log.d(this.TAG, "send via oneway infer (fallback): requestId=" + requestId);
            return new InferenceResponseResult.Success(requestId);
        } catch (Exception e11) {
            Log.e(this.TAG, "send failed (oneway): " + requestId, e11);
            String message2 = e11.getMessage();
            if (message2 == null) {
                message2 = "DeepBinder infer failed";
            }
            return new InferenceResponseResult.Failure(requestId, new InferenceResponseError(AIEngineError.IPC_BINDER_FAILED, message2, null, 4, null));
        }
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public void setResponseHandler(IResponseHandler handler) {
        p.i(handler, "handler");
        this.responseHandler = handler;
    }
}
