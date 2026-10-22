package com.bytedance.ai.bridge.method.device.Compass;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStartCompassMethodIDL;
import com.bytedance.ai.bridge.method.device.DeviceSensorInterval;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t3.r0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/Compass/StartCompassMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$SensorStartParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartCompassMethod extends AbsStartCompassMethodIDL {

    public static final class a {
    }

    static {
    }

    public StartCompassMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r110) {
        AbsStartCompassMethodIDL.b r102 = (AbsStartCompassMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        DeviceSensorInterval.a r103 = DeviceSensorInterval.Companion;
        AbsStartCompassMethodIDL.SensorInterval r104 = r102.getInterval();
        if (r104 == null) goto L5;
        String r105 = r104.name();
    L6:
        r103.getClass();
        DeviceSensorInterval r106 = DeviceSensorInterval.a.a(r105);
        a0 r107 = r100.getContainerContext();
        g r108 = g.f37637a;
        StringBuilder r109 = new StringBuilder("call start, interval=");
        r109.append(r106);
        r109.append(", appletId=");
        if (r107 == null) goto L9;
        String r111 = r107.getAppletId();
    L10:
        r109.append(r111);
        r109.append(", containerId=");
        if (r107 == null) goto L13;
        String r112 = r107.getContainerId();
    L14:
        r109.append(r112);
        r108.i("AISDK_JSB_StartCompassMethod", r109.toString());
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r113 = RefType.NORMAL;
        Object r114 = r100.d(u3.a.class);
        if (r114 != null) goto L17;
        r114 = new u3.a(r100);
        r100.b(u3.a.class, r114, r113);
    L17:
        r0 r115 = ((u3.a) r114).e(r106, this.f35287a);
        if (r115 != null) goto L20;
        r108.i("AISDK_JSB_StartCompassMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsStartCompassMethodIDL.a.class, "<this>");
        r110.b((ResultModel) c.a(AbsStartCompassMethodIDL.a.class), "");
        return;
    L20:
        r108.e("AISDK_JSB_StartCompassMethod", "call failed, errNo=" + r115.f544366b.f475285a + ", msg=" + r115.f544365a);
        h.a.a(r110, r115.f544365a, r115.f544366b, null, 10);
        return;
    L13:
        r112 = null;
        goto L14
    L9:
        r111 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
