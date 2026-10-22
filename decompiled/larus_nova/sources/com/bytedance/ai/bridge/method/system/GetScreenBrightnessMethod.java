package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.video.AudioStats;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.a0;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetScreenBrightnessMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsGetScreenBrightnessMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/system/AbsGetScreenBrightnessMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/system/AbsGetScreenBrightnessMethodIDL$GetScreenBrightnessResultModel;", "getScreenBrightness", "", "activity", "Landroid/app/Activity;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetScreenBrightnessMethod extends AbsGetScreenBrightnessMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetScreenBrightnessMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, h r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetScreenBrightnessMethodIDL.a) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        g r100 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call start, appletId=");
        a0 r102 = r110.getContainerContext();
        if (r102 == null) goto L5;
        String r103 = r102.getAppletId();
    L6:
        r101.append(r103);
        r100.i("AISDK_JSB_GetScreenBrightnessMethod", r101.toString());
        Activity r104 = r110.getOwnerActivity();
        if (r104 != null) goto L9;
        r104 = k.b();
    L9:
        if (r104 == null) goto L11;
        Context r105 = r104;
    L16:
        if (r105 != null) goto L18;
        StringBuilder r106 = new StringBuilder("call failed, errNo=");
        f3.a r107 = f3.a.f475265f;
        r106.append(r107.f475285a);
        r106.append(", msg=context is null");
        r100.e("AISDK_JSB_GetScreenBrightnessMethod", r106.toString());
        h.a.a(r112, "context is null", r107, null, 10);
        return;
    L18:
        if (r104 != null) goto L41;
    L26:
        float r108 = -1.0f;
    L28:
        if (r108 >= 0.0f) goto L30;
    L33:
        double r109 = ((double) Settings.System.getInt(r105.getContentResolver(), "screen_brightness")) / 255.0d;     // Catch: Exception -> L24
    L34:
        double r113 = RangesKt.coerceIn(r109, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);     // Catch: Exception -> L24
        r100.i("AISDK_JSB_GetScreenBrightnessMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsGetScreenBrightnessMethodIDL.b.class, "<this>");
        BaseModel r114 = k3.c.a(AbsGetScreenBrightnessMethodIDL.b.class);
        ((AbsGetScreenBrightnessMethodIDL.b) r114).setValue(Double.valueOf(r113));
        r112.b((ResultModel) r114, "");
        return;
    L24:
        e = move-exception;
        String r115 = e.getMessage();
        if (r115 != null) goto L39;
        r115 = "unknown";
    L39:
        String r116 = "get screen brightness error: ".concat(r115);
        g r117 = g.f37637a;
        StringBuilder r118 = new StringBuilder("call failed, errNo=");
        f3.a r119 = f3.a.f475265f;
        r118.append(r119.f475285a);
        r118.append(", msg=");
        r118.append(r116);
        r117.e("AISDK_JSB_GetScreenBrightnessMethod", r118.toString(), e);
        h.a.a(r112, r116, r119, null, 10);
        return;
    L30:
        if (r108 > 1.0f) goto L33;
        r109 = r108;
        goto L34
    L41:
        Window r120 = r104.getWindow();     // Catch: Exception -> L24
        if (r120 == null) goto L26;
        WindowManager.LayoutParams r121 = r120.getAttributes();     // Catch: Exception -> L24
        if (r121 == null) goto L26;
        r108 = r121.screenBrightness;     // Catch: Exception -> L24
        goto L28
    L11:
        View r122 = r110.getEngineView();
        if (r122 == null) goto L14;
        r105 = r122.getContext();
        goto L16
    L14:
        r105 = null;
        goto L16
    L5:
        r103 = null;
        goto L6
    }
}
