package com.bytedance.applet.aibridge.timer;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.manager.AudioStopTimerManagerDelegate;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/timer/GetAudioStopTimerInfoMethod;", "Lcom/bytedance/applet/aibridge/timer/AbsGetAudioStopTimerInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/timer/AbsGetAudioStopTimerInfoMethodIDL$GetAudioStopTimerInfoMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/timer/AbsGetAudioStopTimerInfoMethodIDL$GetAudioStopTimerInfoMethodResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAudioStopTimerInfoMethod extends AbsGetAudioStopTimerInfoMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetAudioStopTimerInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r110) {
        AbsGetAudioStopTimerInfoMethodIDL.a r102 = (AbsGetAudioStopTimerInfoMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r103 = r102.getScene();
        Intrinsics.checkNotNullParameter(AbsGetAudioStopTimerInfoMethodIDL.b.class, "<this>");
        AbsGetAudioStopTimerInfoMethodIDL.b r104 = (AbsGetAudioStopTimerInfoMethodIDL.b) c.a(AbsGetAudioStopTimerInfoMethodIDL.b.class);
        AudioStopTimerManagerDelegate r105 = AudioStopTimerManagerDelegate.f290173b;
        if (r105.a().contains(r103) == true) goto L5;
        FLogger.f375446a.i("GetAudioStopTimerInfoMethod", "wrong scene: " + r103);
        r110.b(r104, "");
        return;
    L5:
        Long r106 = r105.b(r103);
        if (r106 == null) goto L8;
        boolean r107 = true;
    L9:
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("get timer info of ");
        r109.append(r103);
        r109.append(" with switch ");
        r109.append(r107);
        r109.append(", stopTime: ");
        if (r106 != null) goto L12;
        Object r111 = "disabled";
    L13:
        r109.append(r111);
        r108.i("GetAudioStopTimerInfoMethod", r109.toString());
        r104.setSwitch(r107);
        r104.setStopTime(r106);
        r110.b(r104, "");
        return;
    L12:
        r111 = r106;
        goto L13
    L8:
        r107 = false;
        goto L9
    }
}
