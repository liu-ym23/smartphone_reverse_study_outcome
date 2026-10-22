package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStartAccelerometerMethodIDL;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t3.r0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StartAccelerometerMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartAccelerometerMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartAccelerometerMethodIDL$SensorStartParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartAccelerometerMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartAccelerometerMethod extends AbsStartAccelerometerMethodIDL {
    public StartAccelerometerMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsStartAccelerometerMethodIDL.b r103 = (AbsStartAccelerometerMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r104 = RefType.NORMAL;
        Object r105 = r100.d(t3.a.class);
        if (r105 != null) goto L5;
        r105 = new t3.a(r100);
        r100.b(t3.a.class, r105, r104);
    L5:
        t3.a r106 = (t3.a) r105;
        DeviceSensorInterval.a r107 = DeviceSensorInterval.Companion;
        AbsStartAccelerometerMethodIDL.SensorInterval r108 = r103.getInterval();
        if (r108 == null) goto L8;
        String r109 = r108.name();
    L9:
        r107.getClass();
        r0 r110 = r106.e(DeviceSensorInterval.a.a(r109), this.f35286a);
        if (r110 != null) goto L12;
        Intrinsics.checkNotNullParameter(AbsStartAccelerometerMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsStartAccelerometerMethodIDL.a.class), "");
        return;
    L12:
        h.a.a(r102, r110.f544365a, r110.f544366b, null, 10);
        return;
    L8:
        r109 = null;
        goto L9
    }
}
