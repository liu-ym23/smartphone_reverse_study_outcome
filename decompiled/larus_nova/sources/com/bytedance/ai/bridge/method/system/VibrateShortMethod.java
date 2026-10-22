package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.vibrate.AbsVibrateShortMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/VibrateShortMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateShortParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$EmptyMessageModel;", "triggerShortVibration", "vibrator", "Landroid/os/Vibrator;", "type", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VibrateShortMethod extends AbsVibrateShortMethodIDL {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35942a = null;

        static {
            int[] r100 = new int[AbsVibrateShortMethodIDL.VibrateType.values().length];
            r100[AbsVibrateShortMethodIDL.VibrateType.HEAVY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AbsVibrateShortMethodIDL.VibrateType.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AbsVibrateShortMethodIDL.VibrateType.LIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f35942a = r100;
        }
    }

    static {
    }

    public VibrateShortMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, h r112) {
        AbsVibrateShortMethodIDL.b r113 = (AbsVibrateShortMethodIDL.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        g r100 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call start, type=");
        r101.append(r113.getType());
        r101.append(", appletId=");
        a0 r102 = r110.getContainerContext();
        if (r102 == null) goto L5;
        String r103 = r102.getAppletId();
    L6:
        r101.append(r103);
        r100.i("AISDK_JSB_VibrateShortMethod", r101.toString());
        Activity r114 = r110.getOwnerActivity();
        if (r114 != null) goto L10;
        r114 = k.b();
    L10:
        if (r114 != null) goto L12;
        StringBuilder r115 = new StringBuilder("call failed, errNo=");
        f3.a r116 = f3.a.f475265f;
        r115.append(r116.f475285a);
        r115.append(", msg=context is null");
        r100.e("AISDK_JSB_VibrateShortMethod", r115.toString());
        h.a.a(r112, "context is null", r116, null, 10);
        return;
    L12:
        Object r117 = r114.getSystemService("vibrator");
        if ((r117 instanceof Vibrator) == false) goto L15;
        Vibrator r118 = (Vibrator) r117;
    L16:
        if (r118 != null) goto L18;
    L50:
        StringBuilder r119 = new StringBuilder("call failed, errNo=");
        f3.a r120 = f3.a.f475266g;
        r119.append(r120.f475285a);
        r119.append(", msg=vibrate is not supported");
        r100.e("AISDK_JSB_VibrateShortMethod", r119.toString());
        h.a.a(r112, "vibrate is not supported", r120, null, 10);
        return;
    L18:
        if (r118.hasVibrator() == false) goto L50;
        AbsVibrateShortMethodIDL.VibrateType r121 = r113.getType();     // Catch: Throwable -> L41
        if (Build.VERSION.SDK_INT < 26) goto L38;
        int r122 = b.f35942a[r121.ordinal()];     // Catch: Throwable -> L41
        if (r122 != 1) goto L25;
        int r123 = 255;
    L34:
        if (r118.hasAmplitudeControl() == false) goto L36;
        VibrationEffect r124 = VibrationEffect.createOneShot(15, r123);     // Catch: Throwable -> L41
    L37:
        r118.vibrate(r124);     // Catch: Throwable -> L41
    L39:
        r100.i("AISDK_JSB_VibrateShortMethod", "call success");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(AbsVibrateShortMethodIDL.a.class, "<this>");     // Catch: Throwable -> L41
        r112.b((ResultModel) k3.c.a(AbsVibrateShortMethodIDL.a.class), "");     // Catch: Throwable -> L41
        return;
    L36:
        r124 = VibrationEffect.createOneShot(15, -1);     // Catch: Throwable -> L41
        goto L37
    L25:
        if (r122 != 2) goto L27;
        r123 = 180;
        goto L34
    L27:
        if (r122 != 3) goto L30;
        r123 = 100;
        goto L34
    L30:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L41
    L38:
        r118.vibrate(15);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        g r125 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call failed, errNo=");
        f3.a r105 = f3.a.f475265f;
        r104.append(r105.f475285a);
        r104.append(", msg=vibrateShort failed: ");
        String r106 = th.getMessage();
        String r107 = "unknown";
        if (r106 != null) goto L45;
        r106 = "unknown";
    L45:
        r104.append(r106);
        r125.e("AISDK_JSB_VibrateShortMethod", r104.toString());
        String r126 = th.getMessage();
        if (r126 == null) goto L49;
        r107 = r126;
    L49:
        h.a.a(r112, "vibrateShort failed: ".concat(r107), r105, null, 10);
        return;
    L15:
        r118 = null;
        goto L16
    L5:
        r103 = null;
        goto L6
    }
}
