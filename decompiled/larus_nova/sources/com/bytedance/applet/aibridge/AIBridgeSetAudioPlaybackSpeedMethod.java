package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeSetAudioPlaybackSpeedMethod;", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackSpeedMethod;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackSpeedMethod$SetAudioPlaybackSpeedMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackSpeedMethod$SetAudioPlaybackSpeedMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSetAudioPlaybackSpeedMethod extends AbsSetAudioPlaybackSpeedMethod {
    public AIBridgeSetAudioPlaybackSpeedMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsSetAudioPlaybackSpeedMethod.a r103 = (AbsSetAudioPlaybackSpeedMethod.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r103.getSpeed() > 0.0f) goto L6;
        f3.h.a.a(r102, "The speed must be more than 0.", null, null, 14);
        return;
    L6:
        if (NewsUrlAudioManagerDelegate.f290179b.e(r103.getScene(), r103.getSpeed()) == false) goto L8;
        Intrinsics.checkNotNullParameter(AbsSetAudioPlaybackSpeedMethod.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsSetAudioPlaybackSpeedMethod.b.class), "");
        return;
    L8:
        f3.h.a.a(r102, "The target url does not match the current url when on SetAudioPlaybackSpeed", null, null, 14);
    }
}
