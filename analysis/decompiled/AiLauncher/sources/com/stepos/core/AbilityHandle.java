package com.stepos.core;

import android.os.RemoteException;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.ability.IAIAbility;
import com.stepos.core.callback.IReleaseCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.transport.bridge.DeepBinderTransportBridge;
import com.stepos.core.transport.bridge.DefaultTransportBridge;
import com.stepos.core.transport.bridge.IInferenceBridge;
import com.stepos.core.transport.bridge.IResponseHandler;
import com.stepos.core.transport.bridge.InferenceRequest;
import com.stepos.core.transport.bridge.InferenceResponseResult;
import com.stepos.core.transport.bridge.TransportResponse;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0001K\u0018\u00002\u00020\u0001:\u0001TB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001a*\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJA\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001a*\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010 JA\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001a*\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010!JÃ\u0001\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001a*\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u00002\u001a\b\u0002\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\"2 \b\u0002\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0$2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0'2 \b\u0002\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0$2\u001a\b\u0002\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\"¢\u0006\u0004\b\u001c\u0010+J»\u0001\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001a*\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u00002\u001a\b\u0002\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\"2 \b\u0002\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0$2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0'2 \b\u0002\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0$2\u001a\b\u0002\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\"¢\u0006\u0004\b\u001c\u0010,JÃ\u0001\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001a*\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\u001a\b\u0002\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\"2 \b\u0002\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0$2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0'2 \b\u0002\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0$2\u001a\b\u0002\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\"¢\u0006\u0004\b\u001c\u0010-J\u0017\u0010/\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\b1\u0010\u0010J+\u00103\u001a\u00020\f2\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\"H\u0016¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\b¢\u0006\u0004\b7\u00108J#\u0010;\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\f2\u0006\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010BR\u0014\u0010C\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u0010DR&\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR.\u0010I\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\"0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010R¨\u0006U"}, d2 = {"Lcom/stepos/core/AbilityHandle;", "Lcom/stepos/core/IAbilityHandle;", "Lcom/stepos/core/ability/IAIAbility;", "proxy", "Lcom/stepos/core/transport/bridge/IInferenceBridge;", "transportBridge", "<init>", "(Lcom/stepos/core/ability/IAIAbility;Lcom/stepos/core/transport/bridge/IInferenceBridge;)V", "", "requestId", "Lcom/stepos/core/InferenceCallback;", "callback", "LY8/t;", "registerCallback", "(Ljava/lang/String;Lcom/stepos/core/InferenceCallback;)V", "doRelease", "()V", "runPendingReleaseIfDrained", "", "prepare", "()Z", "Lcom/stepos/core/ability/AbilityInfo;", "getAbilityInfo", "()Lcom/stepos/core/ability/AbilityInfo;", "Lcom/stepos/core/data/base/Content;", ExifInterface.GPS_DIRECTION_TRUE, "R", "input", "infer", "(Lcom/stepos/core/data/base/Content;Lcom/stepos/core/InferenceCallback;)Ljava/lang/String;", "Ljava/util/concurrent/Executor;", "executor", "(Lcom/stepos/core/data/base/Content;Ljava/util/concurrent/Executor;Lcom/stepos/core/InferenceCallback;)Ljava/lang/String;", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/InferenceCallback;)Ljava/lang/String;", "Lkotlin/Function2;", "onResult", "Lkotlin/Function3;", "", "onError", "Lkotlin/Function1;", "onComplete", "onCancelled", "onRoutingDecision", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lp9/p;Lp9/q;Lp9/l;Lp9/q;Lp9/p;)Ljava/lang/String;", "(Lcom/stepos/core/data/base/Content;Lp9/p;Lp9/q;Lp9/l;Lp9/q;Lp9/p;)Ljava/lang/String;", "(Lcom/stepos/core/data/base/Content;Ljava/util/concurrent/Executor;Lp9/p;Lp9/q;Lp9/l;Lp9/q;Lp9/p;)Ljava/lang/String;", "inferId", "cancel", "(Ljava/lang/String;)Z", "release", "listener", "setOnModelReleased", "(Lp9/p;)V", "errorCode", "message", "failAllPending", "(ILjava/lang/String;)I", "action", "params", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "feedInput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "completeInput", "(Ljava/lang/String;)V", "Lcom/stepos/core/ability/IAIAbility;", "Lcom/stepos/core/transport/bridge/IInferenceBridge;", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "inferenceCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicReference;", "releasedListener", "Ljava/util/concurrent/atomic/AtomicReference;", "com/stepos/core/AbilityHandle$releaseCallbackStub$1", "releaseCallbackStub", "Lcom/stepos/core/AbilityHandle$releaseCallbackStub$1;", "", "releaseLock", "Ljava/lang/Object;", "pendingRelease", "Z", "released", "ResponseHandlerImpl", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityHandle implements IAbilityHandle {
    private final String TAG;
    private final ConcurrentHashMap<String, InferenceCallback<Content>> inferenceCallbacks;
    private boolean pendingRelease;
    private final IAIAbility proxy;
    private final AbilityHandle$releaseCallbackStub$1 releaseCallbackStub;
    private final Object releaseLock;
    private boolean released;
    private final AtomicReference<p9.p<Integer, String, Y8.t>> releasedListener;
    private final IInferenceBridge transportBridge;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/core/AbilityHandle$ResponseHandlerImpl;", "Lcom/stepos/core/transport/bridge/IResponseHandler;", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "", "requestId", "Lcom/stepos/core/transport/bridge/TransportResponse;", UxipConstants.f30685x, "LY8/t;", "onResponse", "(Ljava/lang/String;Lcom/stepos/core/transport/bridge/TransportResponse;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ResponseHandlerImpl implements IResponseHandler {
        public ResponseHandlerImpl() {
        }

        @Override // com.stepos.core.transport.bridge.IResponseHandler
        public void onResponse(String requestId, TransportResponse response) {
            kotlin.jvm.internal.p.i(requestId, "requestId");
            kotlin.jvm.internal.p.i(response, "response");
            if (response instanceof TransportResponse.Result) {
                Content output = ((TransportResponse.Result) response).getOutput();
                Log.d(AbilityHandle.this.TAG, "onResult: " + requestId + ", outputType=" + output.getClass().getSimpleName());
                if (output instanceof TextContent) {
                    ((TextContent) output).validate();
                } else if (output instanceof ImageContent) {
                    ((ImageContent) output).validate();
                } else if (output instanceof AudioContent) {
                    ((AudioContent) output).validate();
                }
                InferenceCallback inferenceCallback = (InferenceCallback) AbilityHandle.this.inferenceCallbacks.get(requestId);
                if (inferenceCallback != null) {
                    inferenceCallback.onNext(requestId, new InferResult.Result(output));
                    return;
                }
                return;
            }
            if (response instanceof TransportResponse.Error) {
                TransportResponse.Error error = (TransportResponse.Error) response;
                Log.d(AbilityHandle.this.TAG, "onError: " + requestId + ", " + error.getErrorCode() + ", " + error.getMessage());
                InferenceCallback inferenceCallback2 = (InferenceCallback) AbilityHandle.this.inferenceCallbacks.remove(requestId);
                if (inferenceCallback2 != null) {
                    inferenceCallback2.onNext(requestId, new InferResult.Error(error.getErrorCode(), error.getMessage()));
                }
                AbilityHandle.this.runPendingReleaseIfDrained();
                return;
            }
            if (response instanceof TransportResponse.Cancelled) {
                TransportResponse.Cancelled cancelled = (TransportResponse.Cancelled) response;
                Log.d(AbilityHandle.this.TAG, "onCancelled: " + requestId + ", reason=" + cancelled.getReason() + ", " + cancelled.getMessage());
                InferenceCallback inferenceCallback3 = (InferenceCallback) AbilityHandle.this.inferenceCallbacks.remove(requestId);
                if (inferenceCallback3 != null) {
                    inferenceCallback3.onNext(requestId, new InferResult.Cancelled(cancelled.getReason(), cancelled.getMessage()));
                }
                AbilityHandle.this.runPendingReleaseIfDrained();
                return;
            }
            if (kotlin.jvm.internal.p.d(response, TransportResponse.Complete.INSTANCE)) {
                Log.d(AbilityHandle.this.TAG, "onComplete: " + requestId);
                InferenceCallback inferenceCallback4 = (InferenceCallback) AbilityHandle.this.inferenceCallbacks.remove(requestId);
                if (inferenceCallback4 != null) {
                    inferenceCallback4.onNext(requestId, InferResult.Complete.INSTANCE);
                }
                AbilityHandle.this.runPendingReleaseIfDrained();
                return;
            }
            if (response instanceof TransportResponse.Progress) {
                TransportResponse.Progress progress = (TransportResponse.Progress) response;
                Log.d(AbilityHandle.this.TAG, "onProgress: " + requestId + ", " + progress.getPercent() + "%");
                InferenceCallback inferenceCallback5 = (InferenceCallback) AbilityHandle.this.inferenceCallbacks.get(requestId);
                if (inferenceCallback5 != null) {
                    inferenceCallback5.onNext(requestId, new InferResult.Progress(progress.getPercent(), progress.getExtra()));
                    return;
                }
                return;
            }
            if (!(response instanceof TransportResponse.RoutingDecision)) {
                throw new NoWhenBranchMatchedException();
            }
            TransportResponse.RoutingDecision routingDecision = (TransportResponse.RoutingDecision) response;
            Log.d(AbilityHandle.this.TAG, "onRoutingDecision: " + requestId + ", location=" + routingDecision.getExecutionLocation());
            InferenceCallback inferenceCallback6 = (InferenceCallback) AbilityHandle.this.inferenceCallbacks.get(requestId);
            if (inferenceCallback6 != null) {
                inferenceCallback6.onNext(requestId, new InferResult.RoutingDecision(routingDecision.getExecutionLocation(), routingDecision.getReason()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.stepos.core.AbilityHandle$releaseCallbackStub$1] */
    public AbilityHandle(IAIAbility proxy, IInferenceBridge transportBridge) {
        kotlin.jvm.internal.p.i(proxy, "proxy");
        kotlin.jvm.internal.p.i(transportBridge, "transportBridge");
        this.proxy = proxy;
        this.transportBridge = transportBridge;
        this.TAG = "AbilityHandle";
        this.inferenceCallbacks = new ConcurrentHashMap<>();
        this.releasedListener = new AtomicReference<>(null);
        this.releaseCallbackStub = new IReleaseCallback.Stub() { // from class: com.stepos.core.AbilityHandle$releaseCallbackStub$1
            @Override // com.stepos.core.callback.IReleaseCallback
            public void onReleased(String modelId, int reasonCode, String message) {
                Object objB;
                Y8.t tVar;
                if (message == null) {
                    message = "reasonCode=" + reasonCode;
                }
                AbilityHandle abilityHandle = this.this$0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    p9.p pVar = (p9.p) abilityHandle.releasedListener.get();
                    if (pVar != null) {
                        pVar.invoke(Integer.valueOf(reasonCode), message);
                        tVar = Y8.t.f7040a;
                    } else {
                        tVar = null;
                    }
                    objB = Result.b(tVar);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                AbilityHandle abilityHandle2 = this.this$0;
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(abilityHandle2.TAG, "setOnModelReleased listener threw for modelId=" + modelId, thE);
                }
            }
        };
        this.releaseLock = new Object();
        transportBridge.setResponseHandler(new ResponseHandlerImpl());
    }

    private final void doRelease() throws RemoteException {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.proxy.unregisterReleaseCallback();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.TAG, "unregisterReleaseCallback during release failed", thE);
        }
        this.releasedListener.set(null);
        this.pendingRelease = false;
        this.inferenceCallbacks.clear();
        this.transportBridge.release();
        this.proxy.release();
        this.released = true;
    }

    public static /* synthetic */ String infer$default(AbilityHandle abilityHandle, String str, Content content, p9.p pVar, p9.q qVar, InterfaceC5074l interfaceC5074l, p9.q qVar2, p9.p pVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            pVar = new p9.p() { // from class: com.stepos.core.a
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return AbilityHandle.infer$lambda$0((String) obj2, (Content) obj3);
                }
            };
        }
        p9.p pVar3 = pVar;
        if ((i10 & 8) != 0) {
            qVar = new p9.q() { // from class: com.stepos.core.g
                @Override // p9.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AbilityHandle.infer$lambda$1((String) obj2, ((Integer) obj3).intValue(), (String) obj4);
                }
            };
        }
        p9.q qVar3 = qVar;
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.core.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return AbilityHandle.infer$lambda$2((String) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        if ((i10 & 32) != 0) {
            qVar2 = new p9.q() { // from class: com.stepos.core.i
                @Override // p9.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AbilityHandle.infer$lambda$3((String) obj2, ((Integer) obj3).intValue(), (String) obj4);
                }
            };
        }
        return abilityHandle.infer(str, (String) content, pVar3, (p9.q<? super String, ? super Integer, ? super String, Y8.t>) qVar3, (InterfaceC5074l<? super String, Y8.t>) interfaceC5074l2, (p9.q<? super String, ? super Integer, ? super String, Y8.t>) qVar2, (p9.p<? super String, ? super String, Y8.t>) ((i10 & 64) != 0 ? new p9.p() { // from class: com.stepos.core.j
            @Override // p9.p
            public final Object invoke(Object obj2, Object obj3) {
                return AbilityHandle.infer$lambda$4((String) obj2, (String) obj3);
            }
        } : pVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$0(String str, Content content) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(content, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$1(String str, int i10, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$10(String str, Content content) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(content, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$11(String str, int i10, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$12(String str) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$13(String str, int i10, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$14(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$2(String str) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$3(String str, int i10, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$4(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$5(String str, Content content) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(content, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$6(String str, int i10, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$7(String str) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$8(String str, int i10, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t infer$lambda$9(String str, String str2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        return Y8.t.f7040a;
    }

    private final void registerCallback(String requestId, InferenceCallback<?> callback) {
        synchronized (this.releaseLock) {
            try {
                if (this.released) {
                    Log.w(this.TAG, "infer on released handle: re-arming transport bridge responseHandler (reuse-after-release)");
                    this.transportBridge.setResponseHandler(new ResponseHandlerImpl());
                    this.released = false;
                }
                ConcurrentHashMap<String, InferenceCallback<Content>> concurrentHashMap = this.inferenceCallbacks;
                kotlin.jvm.internal.p.g(callback, "null cannot be cast to non-null type com.stepos.core.InferenceCallback<com.stepos.core.data.base.Content>");
                concurrentHashMap.put(requestId, callback);
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runPendingReleaseIfDrained() {
        synchronized (this.releaseLock) {
            try {
                if (this.pendingRelease && this.inferenceCallbacks.isEmpty()) {
                    Log.i(this.TAG, "release: shared handle drained, running deferred teardown");
                    doRelease();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.stepos.core.IAbilityHandle
    public boolean cancel(String inferId) {
        kotlin.jvm.internal.p.i(inferId, "inferId");
        this.inferenceCallbacks.remove(inferId);
        runPendingReleaseIfDrained();
        return this.transportBridge.cancel(inferId);
    }

    @Override // com.stepos.core.IAbilityHandle
    public void completeInput(String inferId) {
        Object objB;
        kotlin.jvm.internal.p.i(inferId, "inferId");
        IInferenceBridge iInferenceBridge = this.transportBridge;
        if (iInferenceBridge instanceof DeepBinderTransportBridge) {
            ((DeepBinderTransportBridge) iInferenceBridge).completeInput(inferId);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.proxy.completeInput(inferId);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Result.a(objB);
    }

    @Override // com.stepos.core.IAbilityHandle
    public Content execute(String action, Content params) {
        Object objB;
        kotlin.jvm.internal.p.i(action, "action");
        IInferenceBridge iInferenceBridge = this.transportBridge;
        if (iInferenceBridge instanceof DeepBinderTransportBridge) {
            return ((DeepBinderTransportBridge) iInferenceBridge).execute(action, params);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.proxy.execute(action, params));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Content) objB;
    }

    public final int failAllPending(int errorCode, String message) {
        Object objB;
        kotlin.jvm.internal.p.i(message, "message");
        Map mapA = kotlin.collections.a.A(this.inferenceCallbacks);
        this.inferenceCallbacks.clear();
        for (Map.Entry entry : mapA.entrySet()) {
            String str = (String) entry.getKey();
            InferenceCallback inferenceCallback = (InferenceCallback) entry.getValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                inferenceCallback.onNext(str, new InferResult.Error(errorCode, message));
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(this.TAG, "failAllPending: callback(" + str + ") threw", thE);
            }
        }
        if (!mapA.isEmpty()) {
            Log.w(this.TAG, "failAllPending: notified " + mapA.size() + " pending callbacks with code=" + errorCode);
        }
        return mapA.size();
    }

    @Override // com.stepos.core.IAbilityHandle
    public void feedInput(String inferId, Content input) {
        Object objB;
        kotlin.jvm.internal.p.i(inferId, "inferId");
        kotlin.jvm.internal.p.i(input, "input");
        IInferenceBridge iInferenceBridge = this.transportBridge;
        if (iInferenceBridge instanceof DeepBinderTransportBridge) {
            ((DeepBinderTransportBridge) iInferenceBridge).feedInput(inferId, input);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.proxy.feedInput(inferId, input);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Result.a(objB);
    }

    @Override // com.stepos.core.IAbilityHandle
    public AbilityInfo getAbilityInfo() throws RemoteException {
        AbilityInfo info = this.proxy.getInfo();
        kotlin.jvm.internal.p.h(info, "getInfo(...)");
        return info;
    }

    @Override // com.stepos.core.IAbilityHandle
    public <T extends Content, R extends Content> String infer(T input, InferenceCallback<? super R> callback) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(callback, "callback");
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        registerCallback(string, callback);
        Log.d(this.TAG, "infer: requestId=" + string + ", inputType=" + input.getClass().getSimpleName());
        InferenceResponseResult inferenceResponseResultSend = this.transportBridge.send(new InferenceRequest(string, input));
        if (inferenceResponseResultSend instanceof InferenceResponseResult.Success) {
            Log.d(this.TAG, "Request sent successfully: " + string);
            return string;
        }
        if (!(inferenceResponseResultSend instanceof InferenceResponseResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        InferenceResponseResult.Failure failure = (InferenceResponseResult.Failure) inferenceResponseResultSend;
        Log.e(this.TAG, "Request failed: " + failure.getError().getMessage());
        this.inferenceCallbacks.remove(string);
        callback.onNext(string, new InferResult.Error(failure.getError().getCode(), failure.getError().getMessage()));
        return string;
    }

    @Override // com.stepos.core.IAbilityHandle
    public boolean prepare() {
        return this.proxy.acquire();
    }

    @Override // com.stepos.core.IAbilityHandle
    public void release() {
        synchronized (this.releaseLock) {
            if (this.inferenceCallbacks.isEmpty()) {
                doRelease();
                Y8.t tVar = Y8.t.f7040a;
                return;
            }
            this.pendingRelease = true;
            Log.w(this.TAG, "release: " + this.inferenceCallbacks.size() + " in-flight infer(s) on shared handle, deferring teardown until drain");
        }
    }

    @Override // com.stepos.core.IAbilityHandle
    public void setOnModelReleased(p9.p<? super Integer, ? super String, Y8.t> listener) {
        Object objB;
        Object objB2;
        synchronized (this.releaseLock) {
            if (this.released) {
                Log.w(this.TAG, "setOnModelReleased ignored on released handle");
                return;
            }
            this.releasedListener.set(listener);
            if (listener == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    this.proxy.unregisterReleaseCallback();
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(this.TAG, "unregisterReleaseCallback failed", thE);
                }
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                this.proxy.registerReleaseCallback(this.releaseCallbackStub);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                Log.w(this.TAG, "registerReleaseCallback failed", thE2);
            }
        }
    }

    public static /* synthetic */ String infer$default(AbilityHandle abilityHandle, Content content, p9.p pVar, p9.q qVar, InterfaceC5074l interfaceC5074l, p9.q qVar2, p9.p pVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = new p9.p() { // from class: com.stepos.core.k
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return AbilityHandle.infer$lambda$5((String) obj2, (Content) obj3);
                }
            };
        }
        p9.p pVar3 = pVar;
        if ((i10 & 4) != 0) {
            qVar = new p9.q() { // from class: com.stepos.core.l
                @Override // p9.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AbilityHandle.infer$lambda$6((String) obj2, ((Integer) obj3).intValue(), (String) obj4);
                }
            };
        }
        p9.q qVar3 = qVar;
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.core.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return AbilityHandle.infer$lambda$7((String) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        if ((i10 & 16) != 0) {
            qVar2 = new p9.q() { // from class: com.stepos.core.n
                @Override // p9.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AbilityHandle.infer$lambda$8((String) obj2, ((Integer) obj3).intValue(), (String) obj4);
                }
            };
        }
        p9.q qVar4 = qVar2;
        if ((i10 & 32) != 0) {
            pVar2 = new p9.p() { // from class: com.stepos.core.o
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return AbilityHandle.infer$lambda$9((String) obj2, (String) obj3);
                }
            };
        }
        return abilityHandle.infer(content, pVar3, qVar3, interfaceC5074l2, qVar4, pVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AbilityHandle(IAIAbility iAIAbility, IInferenceBridge iInferenceBridge, int i10, kotlin.jvm.internal.i iVar) {
        this(iAIAbility, (i10 & 2) != 0 ? new DefaultTransportBridge(iAIAbility, null, 2, 0 == true ? 1 : 0) : iInferenceBridge);
    }

    public static /* synthetic */ String infer$default(AbilityHandle abilityHandle, Content content, Executor executor, p9.p pVar, p9.q qVar, InterfaceC5074l interfaceC5074l, p9.q qVar2, p9.p pVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            pVar = new p9.p() { // from class: com.stepos.core.b
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return AbilityHandle.infer$lambda$10((String) obj2, (Content) obj3);
                }
            };
        }
        p9.p pVar3 = pVar;
        if ((i10 & 8) != 0) {
            qVar = new p9.q() { // from class: com.stepos.core.c
                @Override // p9.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AbilityHandle.infer$lambda$11((String) obj2, ((Integer) obj3).intValue(), (String) obj4);
                }
            };
        }
        p9.q qVar3 = qVar;
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.core.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return AbilityHandle.infer$lambda$12((String) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        if ((i10 & 32) != 0) {
            qVar2 = new p9.q() { // from class: com.stepos.core.e
                @Override // p9.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AbilityHandle.infer$lambda$13((String) obj2, ((Integer) obj3).intValue(), (String) obj4);
                }
            };
        }
        return abilityHandle.infer((AbilityHandle) content, executor, pVar3, (p9.q<? super String, ? super Integer, ? super String, Y8.t>) qVar3, (InterfaceC5074l<? super String, Y8.t>) interfaceC5074l2, (p9.q<? super String, ? super Integer, ? super String, Y8.t>) qVar2, (p9.p<? super String, ? super String, Y8.t>) ((i10 & 64) != 0 ? new p9.p() { // from class: com.stepos.core.f
            @Override // p9.p
            public final Object invoke(Object obj2, Object obj3) {
                return AbilityHandle.infer$lambda$14((String) obj2, (String) obj3);
            }
        } : pVar2));
    }

    @Override // com.stepos.core.IAbilityHandle
    public <T extends Content, R extends Content> String infer(T input, Executor executor, InferenceCallback<? super R> callback) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(callback, "callback");
        return infer(input, new AbilityHandle$infer$executorCallback$1(executor, callback));
    }

    @Override // com.stepos.core.IAbilityHandle
    public <T extends Content, R extends Content> String infer(String requestId, T input, InferenceCallback<? super R> callback) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(callback, "callback");
        registerCallback(requestId, callback);
        Log.d(this.TAG, "infer: requestId=" + requestId + ", inputType=" + input.getClass().getSimpleName());
        InferenceResponseResult inferenceResponseResultSend = this.transportBridge.send(new InferenceRequest(requestId, input));
        if (inferenceResponseResultSend instanceof InferenceResponseResult.Success) {
            Log.d(this.TAG, "Request sent successfully: " + requestId);
            return requestId;
        }
        if (inferenceResponseResultSend instanceof InferenceResponseResult.Failure) {
            InferenceResponseResult.Failure failure = (InferenceResponseResult.Failure) inferenceResponseResultSend;
            Log.e(this.TAG, "Request failed: " + failure.getError().getMessage());
            this.inferenceCallbacks.remove(requestId);
            callback.onNext(requestId, new InferResult.Error(failure.getError().getCode(), failure.getError().getMessage()));
            return requestId;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Content, R extends Content> String infer(String requestId, T input, final p9.p<? super String, ? super R, Y8.t> onResult, final p9.q<? super String, ? super Integer, ? super String, Y8.t> onError, final InterfaceC5074l<? super String, Y8.t> onComplete, final p9.q<? super String, ? super Integer, ? super String, Y8.t> onCancelled, final p9.p<? super String, ? super String, Y8.t> onRoutingDecision) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        kotlin.jvm.internal.p.i(onError, "onError");
        kotlin.jvm.internal.p.i(onComplete, "onComplete");
        kotlin.jvm.internal.p.i(onCancelled, "onCancelled");
        kotlin.jvm.internal.p.i(onRoutingDecision, "onRoutingDecision");
        return infer(requestId, (String) input, (InferenceCallback) new InferenceCallback<R>() { // from class: com.stepos.core.AbilityHandle$infer$callback$1
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends R> result) {
                kotlin.jvm.internal.p.i(inferId, "inferId");
                kotlin.jvm.internal.p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    onResult.invoke(inferId, ((InferResult.Result) result).getValue());
                    return;
                }
                if (result instanceof InferResult.Error) {
                    InferResult.Error error = (InferResult.Error) result;
                    onError.invoke(inferId, Integer.valueOf(error.getErrorCode()), error.getMessage());
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    InferResult.Cancelled cancelled = (InferResult.Cancelled) result;
                    onCancelled.invoke(inferId, Integer.valueOf(cancelled.getReason()), cancelled.getMessage());
                } else if (result instanceof InferResult.RoutingDecision) {
                    InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
                    onRoutingDecision.invoke(routingDecision.getExecutionLocation(), routingDecision.getReason());
                } else if (kotlin.jvm.internal.p.d(result, InferResult.Complete.INSTANCE)) {
                    onComplete.invoke(inferId);
                } else if (!(result instanceof InferResult.Progress)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Content, R extends Content> String infer(T input, final p9.p<? super String, ? super R, Y8.t> onResult, final p9.q<? super String, ? super Integer, ? super String, Y8.t> onError, final InterfaceC5074l<? super String, Y8.t> onComplete, final p9.q<? super String, ? super Integer, ? super String, Y8.t> onCancelled, final p9.p<? super String, ? super String, Y8.t> onRoutingDecision) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        kotlin.jvm.internal.p.i(onError, "onError");
        kotlin.jvm.internal.p.i(onComplete, "onComplete");
        kotlin.jvm.internal.p.i(onCancelled, "onCancelled");
        kotlin.jvm.internal.p.i(onRoutingDecision, "onRoutingDecision");
        return infer(input, new InferenceCallback<R>() { // from class: com.stepos.core.AbilityHandle$infer$callback$2
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends R> result) {
                kotlin.jvm.internal.p.i(inferId, "inferId");
                kotlin.jvm.internal.p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    onResult.invoke(inferId, ((InferResult.Result) result).getValue());
                    return;
                }
                if (result instanceof InferResult.Error) {
                    InferResult.Error error = (InferResult.Error) result;
                    onError.invoke(inferId, Integer.valueOf(error.getErrorCode()), error.getMessage());
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    InferResult.Cancelled cancelled = (InferResult.Cancelled) result;
                    onCancelled.invoke(inferId, Integer.valueOf(cancelled.getReason()), cancelled.getMessage());
                } else if (result instanceof InferResult.RoutingDecision) {
                    InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
                    onRoutingDecision.invoke(routingDecision.getExecutionLocation(), routingDecision.getReason());
                } else if (kotlin.jvm.internal.p.d(result, InferResult.Complete.INSTANCE)) {
                    onComplete.invoke(inferId);
                } else if (!(result instanceof InferResult.Progress)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Content, R extends Content> String infer(T input, Executor executor, final p9.p<? super String, ? super R, Y8.t> onResult, final p9.q<? super String, ? super Integer, ? super String, Y8.t> onError, final InterfaceC5074l<? super String, Y8.t> onComplete, final p9.q<? super String, ? super Integer, ? super String, Y8.t> onCancelled, final p9.p<? super String, ? super String, Y8.t> onRoutingDecision) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        kotlin.jvm.internal.p.i(onError, "onError");
        kotlin.jvm.internal.p.i(onComplete, "onComplete");
        kotlin.jvm.internal.p.i(onCancelled, "onCancelled");
        kotlin.jvm.internal.p.i(onRoutingDecision, "onRoutingDecision");
        return infer((AbilityHandle) input, executor, (InferenceCallback) new InferenceCallback<R>() { // from class: com.stepos.core.AbilityHandle$infer$lambdaCallback$1
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends R> result) {
                kotlin.jvm.internal.p.i(inferId, "inferId");
                kotlin.jvm.internal.p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    onResult.invoke(inferId, ((InferResult.Result) result).getValue());
                    return;
                }
                if (result instanceof InferResult.Error) {
                    InferResult.Error error = (InferResult.Error) result;
                    onError.invoke(inferId, Integer.valueOf(error.getErrorCode()), error.getMessage());
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    InferResult.Cancelled cancelled = (InferResult.Cancelled) result;
                    onCancelled.invoke(inferId, Integer.valueOf(cancelled.getReason()), cancelled.getMessage());
                } else if (result instanceof InferResult.RoutingDecision) {
                    InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
                    onRoutingDecision.invoke(routingDecision.getExecutionLocation(), routingDecision.getReason());
                } else if (kotlin.jvm.internal.p.d(result, InferResult.Complete.INSTANCE)) {
                    onComplete.invoke(inferId);
                } else if (!(result instanceof InferResult.Progress)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
    }
}
