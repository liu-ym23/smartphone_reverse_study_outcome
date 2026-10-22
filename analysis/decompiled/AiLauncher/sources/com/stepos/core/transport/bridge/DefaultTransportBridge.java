package com.stepos.core.transport.bridge;

import android.util.Log;
import com.stepos.core.ability.IAIAbility;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.strategy.InferChannelRoutingStrategy;
import com.stepos.core.strategy.RoutingStrategy;
import com.stepos.core.transport.bridge.InferenceResponseResult;
import com.stepos.core.transport.bridge.TransportResponse;
import com.stepos.core.transport.channel.BaseInferenceChannel;
import com.stepos.core.transport.channel.BinderChannel;
import com.stepos.core.transport.channel.ChannelType;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u00060'R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/stepos/core/transport/bridge/DefaultTransportBridge;", "Lcom/stepos/core/transport/bridge/IInferenceBridge;", "Lcom/stepos/core/ability/IAIAbility;", "proxy", "Lcom/stepos/core/strategy/RoutingStrategy;", "routingStrategy", "<init>", "(Lcom/stepos/core/ability/IAIAbility;Lcom/stepos/core/strategy/RoutingStrategy;)V", "LY8/t;", "initializeChannels", "()V", "Lcom/stepos/core/transport/bridge/InferenceRequest;", "request", "Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "send", "(Lcom/stepos/core/transport/bridge/InferenceRequest;)Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "Lcom/stepos/core/transport/bridge/IResponseHandler;", "handler", "setResponseHandler", "(Lcom/stepos/core/transport/bridge/IResponseHandler;)V", "", "isReady", "()Z", "", "inferId", "cancel", "(Ljava/lang/String;)Z", "release", "Lcom/stepos/core/ability/IAIAbility;", "Lcom/stepos/core/strategy/RoutingStrategy;", "TAG", "Ljava/lang/String;", "responseHandler", "Lcom/stepos/core/transport/bridge/IResponseHandler;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/core/transport/channel/ChannelType;", "Lcom/stepos/core/transport/channel/BaseInferenceChannel;", "channels", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/core/transport/bridge/DefaultTransportBridge$InternalCallbackProxy;", "callbackProxy", "Lcom/stepos/core/transport/bridge/DefaultTransportBridge$InternalCallbackProxy;", "InternalCallbackProxy", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultTransportBridge implements IInferenceBridge {
    private final String TAG;
    private final InternalCallbackProxy callbackProxy;
    private final ConcurrentHashMap<ChannelType, BaseInferenceChannel> channels;
    private final IAIAbility proxy;
    private IResponseHandler responseHandler;
    private final RoutingStrategy routingStrategy;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/core/transport/bridge/DefaultTransportBridge$InternalCallbackProxy;", "Lcom/stepos/core/callback/IInferenceCallback$Stub;", "<init>", "(Lcom/stepos/core/transport/bridge/DefaultTransportBridge;)V", "", "inferId", "Lcom/stepos/core/data/base/Content;", "output", "LY8/t;", "onOutput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "", "errorCode", "message", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "onComplete", "(Ljava/lang/String;)V", "percent", "extra", "onProgress", "(Ljava/lang/String;ILcom/stepos/core/data/base/Content;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class InternalCallbackProxy extends IInferenceCallback.Stub {
        public InternalCallbackProxy() {
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onComplete(String inferId) {
            p.i(inferId, "inferId");
            Log.d(DefaultTransportBridge.this.TAG, "onComplete: " + inferId);
            IResponseHandler iResponseHandler = DefaultTransportBridge.this.responseHandler;
            if (iResponseHandler != null) {
                iResponseHandler.onResponse(inferId, TransportResponse.Complete.INSTANCE);
            }
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onError(String inferId, int errorCode, String message) {
            p.i(inferId, "inferId");
            if (message == null) {
                message = "";
            }
            TransportResponse transportResponseFromErrorCode = TransportResponse.INSTANCE.fromErrorCode(errorCode, message);
            Log.d(DefaultTransportBridge.this.TAG, "onError: " + inferId + ", " + errorCode + ", " + message + " -> " + t.b(transportResponseFromErrorCode.getClass()).t());
            IResponseHandler iResponseHandler = DefaultTransportBridge.this.responseHandler;
            if (iResponseHandler != null) {
                iResponseHandler.onResponse(inferId, transportResponseFromErrorCode);
            }
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onOutput(String inferId, Content output) {
            p.i(inferId, "inferId");
            p.i(output, "output");
            IResponseHandler iResponseHandler = DefaultTransportBridge.this.responseHandler;
            if (iResponseHandler != null) {
                iResponseHandler.onResponse(inferId, new TransportResponse.Result(output));
            }
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onProgress(String inferId, int percent, Content extra) {
            p.i(inferId, "inferId");
            Log.d(DefaultTransportBridge.this.TAG, "onProgress: " + inferId + ", " + percent + "%");
            IResponseHandler iResponseHandler = DefaultTransportBridge.this.responseHandler;
            if (iResponseHandler != null) {
                iResponseHandler.onResponse(inferId, new TransportResponse.Progress(percent, extra));
            }
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onRoutingDecision(String inferId, String executionLocation, String reason) {
            p.i(inferId, "inferId");
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
            Log.d(DefaultTransportBridge.this.TAG, "onRoutingDecision: " + inferId + ", location=" + executionLocation + ", reason=" + reason);
            IResponseHandler iResponseHandler = DefaultTransportBridge.this.responseHandler;
            if (iResponseHandler != null) {
                iResponseHandler.onResponse(inferId, new TransportResponse.RoutingDecision(executionLocation, reason));
            }
        }
    }

    public DefaultTransportBridge(IAIAbility proxy, RoutingStrategy routingStrategy) {
        p.i(proxy, "proxy");
        p.i(routingStrategy, "routingStrategy");
        this.proxy = proxy;
        this.routingStrategy = routingStrategy;
        this.TAG = "DefaultTransportBridge";
        this.channels = new ConcurrentHashMap<>();
        this.callbackProxy = new InternalCallbackProxy();
        initializeChannels();
    }

    private final void initializeChannels() {
        this.channels.put(ChannelType.PURE_BINDER, new BinderChannel(this.proxy));
        try {
            Log.d(this.TAG, "SharedMemory channels initialized");
        } catch (Exception e10) {
            Log.e(this.TAG, "Failed to initialize SharedMemory channels", e10);
        }
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public boolean cancel(String inferId) {
        Object objB;
        p.i(inferId, "inferId");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.proxy.cancelInfer(inferId)));
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

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public boolean isReady() {
        return !this.channels.isEmpty();
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public void release() {
        Collection<BaseInferenceChannel> collectionValues = this.channels.values();
        p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((BaseInferenceChannel) it.next()).release();
        }
        this.channels.clear();
        this.responseHandler = null;
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public InferenceResponseResult send(InferenceRequest request) {
        p.i(request, "request");
        String requestId = request.getRequestId();
        Content input = request.getInput();
        ChannelType channelTypeSelectChannel = this.routingStrategy.selectChannel(input);
        Log.d(this.TAG, "send: requestId=" + requestId + ", channelType=" + channelTypeSelectChannel);
        BaseInferenceChannel baseInferenceChannel = this.channels.get(channelTypeSelectChannel);
        if (baseInferenceChannel == null) {
            BaseInferenceChannel baseInferenceChannel2 = this.channels.get(ChannelType.PURE_BINDER);
            p.f(baseInferenceChannel2);
            baseInferenceChannel = baseInferenceChannel2;
        }
        if (baseInferenceChannel.sendInferRequest(requestId, input, this.callbackProxy)) {
            return new InferenceResponseResult.Success(requestId);
        }
        Log.w(this.TAG, "Failed via " + channelTypeSelectChannel + ", fallback to Binder");
        BaseInferenceChannel baseInferenceChannel3 = this.channels.get(ChannelType.PURE_BINDER);
        p.f(baseInferenceChannel3);
        return baseInferenceChannel3.sendInferRequest(requestId, input, this.callbackProxy) ? new InferenceResponseResult.Success(requestId) : new InferenceResponseResult.Failure(requestId, new InferenceResponseError(AIEngineError.IPC_BINDER_FAILED, "All channels failed", null, 4, null));
    }

    @Override // com.stepos.core.transport.bridge.IInferenceBridge
    public void setResponseHandler(IResponseHandler handler) {
        p.i(handler, "handler");
        this.responseHandler = handler;
    }

    public /* synthetic */ DefaultTransportBridge(IAIAbility iAIAbility, RoutingStrategy routingStrategy, int i10, i iVar) {
        this(iAIAbility, (i10 & 2) != 0 ? new InferChannelRoutingStrategy() : routingStrategy);
    }
}
