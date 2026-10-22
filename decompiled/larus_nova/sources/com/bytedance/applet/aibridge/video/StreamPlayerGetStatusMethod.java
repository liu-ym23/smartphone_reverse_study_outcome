package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.utils.g;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayerGetStatusMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeGetStatusMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeGetStatusMethodIDL$GetStatusParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeGetStatusMethodIDL$GetStatusResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayerGetStatusMethod extends AbsAIBridgeGetStatusMethodIDL {
    public StreamPlayerGetStatusMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsAIBridgeGetStatusMethodIDL.a r103 = (AbsAIBridgeGetStatusMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        AudioStreamPlayerDelegate r104 = AudioStreamPlayerDelegate.f290191b;
        Pair<String, String> r105 = r104.h();
        if (r105 == null) goto L5;
        String r106 = r105.getSecond();
    L7:
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        String r107 = r104.d(r103.getUuid());
        g.f37637a.i("flow.getStreamAudioPlayStatus", "StreamPlayerGetStatusMethod was called. result = " + r107);
        Intrinsics.checkNotNullParameter(AbsAIBridgeGetStatusMethodIDL.b.class, "<this>");
        AbsAIBridgeGetStatusMethodIDL.b r108 = (AbsAIBridgeGetStatusMethodIDL.b) c.a(AbsAIBridgeGetStatusMethodIDL.b.class);
        r108.setUuid(r106);
        r108.setCurStatus(r107);
        r102.b(r108, "");
        return;
    L5:
        r106 = null;
        goto L7
    }
}
