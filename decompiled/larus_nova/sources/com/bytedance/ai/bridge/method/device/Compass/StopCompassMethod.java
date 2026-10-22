package com.bytedance.ai.bridge.method.device.Compass;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStopCompassMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/Compass/StopCompassMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopCompassMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopCompassMethodIDL$StopCompassParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopCompassMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopCompassMethod extends AbsStopCompassMethodIDL {

    public static final class a {
    }

    static {
    }

    public StopCompassMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsStopCompassMethodIDL.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r103 = r100.getContainerContext();
        g r104 = g.f37637a;
        StringBuilder r105 = new StringBuilder("call start, appletId=");
        String r106 = null;
        if (r103 == null) goto L5;
        String r107 = r103.getAppletId();
    L6:
        r105.append(r107);
        r105.append(", containerId=");
        if (r103 == null) goto L9;
        r106 = r103.getContainerId();
    L9:
        r105.append(r106);
        r104.i("AISDK_JSB_StopCompassMethod", r105.toString());
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r108 = RefType.NORMAL;
        Object r109 = r100.d(u3.a.class);
        if (r109 != null) goto L12;
        r109 = new u3.a(r100);
        r100.b(u3.a.class, r109, r108);
    L12:
        ((u3.a) r109).f();
        r104.i("AISDK_JSB_StopCompassMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsStopCompassMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsStopCompassMethodIDL.a.class), "");
        return;
    L5:
        r107 = null;
        goto L6
    }
}
