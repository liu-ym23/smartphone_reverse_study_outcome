package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeStopMusicMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopMusicMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopMusicMethodIDL$StopMusicParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopMusicMethodIDL$StopMusicResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeStopMusicMethod extends AbsAIBridgeStopMusicMethodIDL {
    public AIBridgeStopMusicMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsAIBridgeStopMusicMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = i.f191169b;
        if (r103 == null) goto L15;
        MusicPlayManagerDelegate r104 = MusicPlayManagerDelegate.f290176b;
        a88.e r105 = r104.a();
        if (r105 == null) goto L8;
        String r106 = r105.f2189a;
        if (r106 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r103, r106) == true) goto L12;
    L14:
        f3.h.a.a(r102, "Failed to stop music: current_music_id = " + r106 + ", latest_music_id = " + r103, null, null, 14);
        return;
    L12:
        if (r104.c(r103) == false) goto L14;
        Intrinsics.checkNotNullParameter(AbsAIBridgeStopMusicMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsAIBridgeStopMusicMethodIDL.b.class), "");
        return;
    L8:
        r106 = "";
        goto L10
    L15:
        f3.h.a.a(r102, "Failed to stop music: latest_music_id is null", null, null, 14);
    }
}
