package com.bytedance.applet.aibridge.timer;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.manager.AudioStopTimerManagerDelegate;
import com.larus.utils.logger.FLogger;
import f3.h;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3.d;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/timer/SetAudioStopTimerMethod;", "Lcom/bytedance/applet/aibridge/timer/AbsSetAudioStopTimerMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/timer/AbsSetAudioStopTimerMethodIDL$SetAudioStopTimerMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/timer/AbsSetAudioStopTimerMethodIDL$SetAudioStopTimerMethodResultModel;", "Companion", "AudioStopTimerCallbackImpl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetAudioStopTimerMethod extends AbsSetAudioStopTimerMethodIDL {

    public static final class a implements z78.a {
        public a() {
        }

        @Override // z78.a
        public final void a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Lazy r102 = d.f507201a;
            JsonObject r103 = new JsonObject();
            r103.addProperty("scene", r100);
            r103.addProperty("timerResult", Integer.valueOf(r101));
            Unit r104 = Unit.INSTANCE;
            d.c(new l3.a("flow.audioStopTimerOver", r103, 4));
        }
    }

    public static final class b {
    }

    static {
    }

    public SetAudioStopTimerMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, h r112) {
        AbsSetAudioStopTimerMethodIDL.a r113 = (AbsSetAudioStopTimerMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r114 = r113.getScene();
        Intrinsics.checkNotNullParameter(AbsSetAudioStopTimerMethodIDL.b.class, "<this>");
        AbsSetAudioStopTimerMethodIDL.b r100 = (AbsSetAudioStopTimerMethodIDL.b) c.a(AbsSetAudioStopTimerMethodIDL.b.class);
        AudioStopTimerManagerDelegate r101 = AudioStopTimerManagerDelegate.f290173b;
        if (r101.a().contains(r114) == true) goto L6;
        FLogger.f375446a.i("SetAudioStopTimerMethod", "wrong scene: " + r114);
        r112.b(r100, "");
        return;
    L6:
        if (r101.c(r114) == false) goto L9;
        FLogger.f375446a.i("SetAudioStopTimerMethod", "disable timer for " + r114 + ", switch: " + r113.getSwitch());
    L9:
        if (r113.getSwitch() == true) goto L11;
        r100.setResult(true);
        r112.b(r100, "");
        return;
    L11:
        Long r115 = r113.getDuration();
        if (r115 == null) goto L14;
        long r102 = r115.longValue();
        r101.d(r114, r102, new a());
        Long r116 = r101.b(r114);
        FLogger.f375446a.i("SetAudioStopTimerMethod", "enable timer for " + r114 + " with duration " + r102 + ", stopTime: " + r116);
        r100.setResult(true);
        r100.setStopTime(r116);
        r112.b(r100, "");
        return;
    L14:
        FLogger.f375446a.i("SetAudioStopTimerMethod", "param duration is null");
        r112.b(r100, "");
    }
}
