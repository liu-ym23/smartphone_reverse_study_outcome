package com.stepos.core.transport.bridge;

import H4.o;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import g5.AbstractC1460a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"com/stepos/core/transport/bridge/DefaultTransportBridge$InternalCallbackProxy", "Lcom/stepos/core/callback/IInferenceCallback$Stub;", AppAgent.CONSTRUCT, "(Lcom/stepos/core/transport/bridge/a;)V", "", "inferId", "Lcom/stepos/core/data/base/Content;", "output", "LC7/r;", "onOutput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "", "errorCode", "message", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "onComplete", "(Ljava/lang/String;)V", "percent", "extra", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "(Ljava/lang/String;ILcom/stepos/core/data/base/Content;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class DefaultTransportBridge$InternalCallbackProxy extends IInferenceCallback.Stub {
    final /* synthetic */ a this$0;

    public DefaultTransportBridge$InternalCallbackProxy(a aVar) {
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onComplete(String inferId) {
        k.f(inferId, "inferId");
        throw null;
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onError(String inferId, int errorCode, String message) {
        k.f(inferId, "inferId");
        Object obj = AbstractC1460a.f4483a;
        o.N(-100, -101, -102, -103).contains(Integer.valueOf(errorCode));
        throw null;
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onOutput(String inferId, Content output) {
        k.f(inferId, "inferId");
        k.f(output, "output");
        throw null;
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onProgress(String inferId, int percent, Content extra) {
        k.f(inferId, "inferId");
        throw null;
    }

    @Override // com.stepos.core.callback.IInferenceCallback
    public void onRoutingDecision(String inferId, String executionLocation, String reason) {
        k.f(inferId, "inferId");
        k.f(executionLocation, "executionLocation");
        k.f(reason, "reason");
        throw null;
    }
}
