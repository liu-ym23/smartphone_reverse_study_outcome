package com.bytedance.applet.aibridge;

import android.media.AudioManager;
import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.common.apphost.AppHost;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeSetAudioVolumeMethod;", "Lcom/bytedance/applet/aibridge/AbsSetAudioVolumeMethod;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsSetAudioVolumeMethod$SetAudioVolumeMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsSetAudioVolumeMethod$SetAudioVolumeMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSetAudioVolumeMethod extends AbsSetAudioVolumeMethod {
    public AIBridgeSetAudioVolumeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsSetAudioVolumeMethod.a r103 = (AbsSetAudioVolumeMethod.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        double r104 = r103.getVolume();     // Catch: Exception -> L20
        Object r105 = AppHost.f326268a.getApplication().getSystemService("audio");     // Catch: Exception -> L20
        if ((r105 instanceof AudioManager) == false) goto L6;
        AudioManager r106 = (AudioManager) r105;     // Catch: Exception -> L20
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        if (r106 == null) goto L11;
        int r107 = r106.getStreamMinVolume(3);     // Catch: Exception -> L20
    L12:
        if (r106 == null) goto L14;
        int r108 = r106.getStreamMaxVolume(3);     // Catch: Exception -> L20
    L16:
        if (b.a((int) ((((double) (r108 - r107)) * r104) + ((double) r107))) == false) goto L18;
        Intrinsics.checkNotNullParameter(AbsSetAudioVolumeMethod.b.class, "<this>");     // Catch: Exception -> L20
        r102.b((ResultModel) k3.c.a(AbsSetAudioVolumeMethod.b.class), "");     // Catch: Exception -> L20
        return;
    L18:
        f3.h.a.a(r102, "adjustSystemVolume failed", null, null, 14);     // Catch: Exception -> L20
        return;
    L14:
        r108 = 15;
    L11:
        r107 = 0;
        goto L12
    L6:
        r106 = null;
    L20:
        e = move-exception;
        f3.h.a.a(r102, ExceptionsKt.stackTraceToString(e), null, null, 14);
    }
}
