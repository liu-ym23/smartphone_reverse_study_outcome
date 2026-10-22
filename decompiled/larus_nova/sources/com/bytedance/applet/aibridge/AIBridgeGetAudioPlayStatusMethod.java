package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetAudioPlayStatusMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetAudioPlayStatusMethod;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetAudioPlayStatusMethod$GetAudioPlayStatusMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetAudioPlayStatusMethod$GetAudioPlayStatusMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetAudioPlayStatusMethod extends AbsAIBridgeGetAudioPlayStatusMethod {
    public AIBridgeGetAudioPlayStatusMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsAIBridgeGetAudioPlayStatusMethod.a r103 = (AbsAIBridgeGetAudioPlayStatusMethod.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getUrl();
        NewsUrlAudioManagerDelegate r105 = NewsUrlAudioManagerDelegate.f290179b;
        UrlAudioPlayStatus r106 = r105.h(r104, Integer.valueOf(r103.getSourceType()), r103.getVideoModel());
        String r107 = r105.a(r104, Integer.valueOf(r103.getSourceType()), r103.getVideoModel());
        Intrinsics.checkNotNullParameter(AbsAIBridgeGetAudioPlayStatusMethod.b.class, "<this>");
        BaseModel r108 = k3.c.a(AbsAIBridgeGetAudioPlayStatusMethod.b.class);
        AbsAIBridgeGetAudioPlayStatusMethod.b r109 = (AbsAIBridgeGetAudioPlayStatusMethod.b) r108;
        r109.setValue(r106.getValue());
        r109.setPausedReason(r107);
        r102.b((ResultModel) r108, "");
    }
}
