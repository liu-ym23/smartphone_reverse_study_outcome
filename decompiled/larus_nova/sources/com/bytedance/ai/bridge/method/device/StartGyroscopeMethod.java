package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStartGyroscopeMethodIDL;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t3.o1;
import t3.r0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StartGyroscopeMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartGyroscopeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartGyroscopeMethodIDL$SensorStartParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartGyroscopeMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartGyroscopeMethod extends AbsStartGyroscopeMethodIDL {
    public StartGyroscopeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsStartGyroscopeMethodIDL.b r103 = (AbsStartGyroscopeMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r104 = RefType.NORMAL;
        Object r105 = r100.d(o1.class);
        if (r105 != null) goto L5;
        r105 = new o1(r100);
        r100.b(o1.class, r105, r104);
    L5:
        o1 r106 = (o1) r105;
        DeviceSensorInterval.a r107 = DeviceSensorInterval.Companion;
        AbsStartGyroscopeMethodIDL.SensorInterval r108 = r103.getInterval();
        if (r108 == null) goto L8;
        String r109 = r108.name();
    L9:
        r107.getClass();
        r0 r110 = r106.e(DeviceSensorInterval.a.a(r109), this.f35289a);
        if (r110 != null) goto L12;
        Intrinsics.checkNotNullParameter(AbsStartGyroscopeMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsStartGyroscopeMethodIDL.a.class), "");
        return;
    L12:
        h.a.a(r102, r110.f544365a, r110.f544366b, null, 10);
        return;
    L8:
        r109 = null;
        goto L9
    }
}
