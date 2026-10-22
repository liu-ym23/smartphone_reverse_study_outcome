package com.stepos.core.transport.bridge;

import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/transport/bridge/IInferenceBridge;", "", "Lcom/stepos/core/transport/bridge/InferenceRequest;", "request", "Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "send", "(Lcom/stepos/core/transport/bridge/InferenceRequest;)Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "Lcom/stepos/core/transport/bridge/IResponseHandler;", "handler", "LY8/t;", "setResponseHandler", "(Lcom/stepos/core/transport/bridge/IResponseHandler;)V", "", "isReady", "()Z", "", "inferId", "cancel", "(Ljava/lang/String;)Z", "release", "()V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IInferenceBridge {
    boolean cancel(String inferId);

    boolean isReady();

    void release();

    InferenceResponseResult send(InferenceRequest request);

    void setResponseHandler(IResponseHandler handler);
}
