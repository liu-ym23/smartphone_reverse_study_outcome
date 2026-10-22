package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.vibrate.AbsVibrateLongMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/VibrateLongMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$VibrateLongParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$EmptyMessageModel;", "triggerLongVibration", "vibrator", "Landroid/os/Vibrator;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VibrateLongMethod extends AbsVibrateLongMethodIDL {

    public static final class a {
    }

    static {
    }

    public VibrateLongMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r110, h r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsVibrateLongMethodIDL.b) r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        g r112 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call start, appletId=");
        a0 r102 = r100.getContainerContext();
        if (r102 == null) goto L5;
        String r103 = r102.getAppletId();
    L6:
        r101.append(r103);
        r112.i("AISDK_JSB_VibrateLongMethod", r101.toString());
        Activity r104 = r100.getOwnerActivity();
        if (r104 != null) goto L10;
        r104 = k.b();
    L10:
        if (r104 != null) goto L12;
        StringBuilder r105 = new StringBuilder("call failed, errNo=");
        f3.a r106 = f3.a.f475265f;
        r105.append(r106.f475285a);
        r105.append(", msg=context is null");
        r112.e("AISDK_JSB_VibrateLongMethod", r105.toString());
        h.a.a(r111, "context is null", r106, null, 10);
        return;
    L12:
        Object r107 = r104.getSystemService("vibrator");
        if ((r107 instanceof Vibrator) == false) goto L15;
        Vibrator r108 = (Vibrator) r107;
    L16:
        if (r108 != null) goto L18;
    L31:
        StringBuilder r109 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f475266g;
        r109.append(r113.f475285a);
        r109.append(", msg=vibrate is not supported");
        r112.e("AISDK_JSB_VibrateLongMethod", r109.toString());
        h.a.a(r111, "vibrate is not supported", r113, null, 10);
        return;
    L18:
        if (r108.hasVibrator() == false) goto L31;
    L26:
        th = move-exception;
        String r114 = th.getMessage();
        if (r114 != null) goto L30;
        r114 = "unknown";
    L30:
        String r115 = "vibrateLong failed: ".concat(r114);
        g r116 = g.f37637a;
        StringBuilder r117 = new StringBuilder("call failed, errNo=");
        f3.a r118 = f3.a.f475265f;
        r117.append(r118.f475285a);
        r117.append(", msg=");
        r117.append(r115);
        r116.e("AISDK_JSB_VibrateLongMethod", r117.toString(), th);
        h.a.a(r111, r115, r118, null, 10);
        return;
    L21:
        if (Build.VERSION.SDK_INT < 26) goto L23;
        r108.vibrate(VibrationEffect.createOneShot(400, -1));     // Catch: Throwable -> L26
    L24:
        r112.i("AISDK_JSB_VibrateLongMethod", "call success");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(AbsVibrateLongMethodIDL.a.class, "<this>");     // Catch: Throwable -> L26
        r111.b((ResultModel) k3.c.a(AbsVibrateLongMethodIDL.a.class), "");     // Catch: Throwable -> L26
        return;
    L23:
        r108.vibrate(400);     // Catch: Throwable -> L26
        goto L24
    L15:
        r108 = null;
        goto L16
    L5:
        r103 = null;
        goto L6
    }
}
