package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetMusicStatusMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetMusicStatusMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetMusicStatusMethodIDL$GetMusicStatusParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetMusicStatusMethodIDL$GetMusicStatusResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetMusicStatusMethod extends AbsAIBridgeGetMusicStatusMethodIDL {
    public AIBridgeGetMusicStatusMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsAIBridgeGetMusicStatusMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        MusicPlayManagerDelegate r103 = MusicPlayManagerDelegate.f290176b;
        a88.e r104 = r103.a();
        if (r104 == null) goto L9;
        String r105 = r104.f2189a;
        if (r105 == null) goto L9;
        if (Intrinsics.areEqual(r105, i.f191169b) == false) goto L9;
        String r106 = i.f191170c;
    L10:
        String r107 = r103.h(r105);
        Intrinsics.checkNotNullParameter(AbsAIBridgeGetMusicStatusMethodIDL.b.class, "<this>");
        BaseModel r108 = k3.c.a(AbsAIBridgeGetMusicStatusMethodIDL.b.class);
        AbsAIBridgeGetMusicStatusMethodIDL.b r109 = (AbsAIBridgeGetMusicStatusMethodIDL.b) r108;
        r109.setMusicId(r105);
        r109.setStatus(r106);
        r109.setPausedReason(r107);
        r102.b((ResultModel) r108, "");
        return;
    L9:
        r106 = "stopped";
        r105 = "";
        goto L10
    }
}
