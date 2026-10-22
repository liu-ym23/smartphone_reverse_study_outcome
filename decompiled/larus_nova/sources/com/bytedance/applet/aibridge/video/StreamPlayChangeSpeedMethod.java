package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayChangeSpeedMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeChangeSpeedMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeChangeSpeedMethodIDL$StreamChangeSpeedParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeChangeSpeedMethodIDL$StreamChangeSpeedResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayChangeSpeedMethod extends AbsAIBridgeChangeSpeedMethodIDL {
    public StreamPlayChangeSpeedMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsAIBridgeChangeSpeedMethodIDL.a r103 = (AbsAIBridgeChangeSpeedMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getUuid();
        Float r105 = StringsKt.toFloatOrNull(r103.getSpeed());
        if (r105 == null) goto L5;
        float r106 = r105.floatValue();
    L6:
        AudioStreamPlayerDelegate.f290191b.k(r104, r106);
        Intrinsics.checkNotNullParameter(AbsAIBridgeChangeSpeedMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsAIBridgeChangeSpeedMethodIDL.b.class), "");
        return;
    L5:
        r106 = 1.0f;
        goto L6
    }
}
