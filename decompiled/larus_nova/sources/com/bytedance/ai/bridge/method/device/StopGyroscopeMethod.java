package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStopGyroscopeMethodIDL;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t3.o1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StopGyroscopeMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopGyroscopeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopGyroscopeMethodIDL$StopGyroscopeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopGyroscopeMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopGyroscopeMethod extends AbsStopGyroscopeMethodIDL {
    public StopGyroscopeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsStopGyroscopeMethodIDL.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r103 = RefType.NORMAL;
        Object r104 = r100.d(o1.class);
        if (r104 != null) goto L5;
        r104 = new o1(r100);
        r100.b(o1.class, r104, r103);
    L5:
        ((o1) r104).f();
        Intrinsics.checkNotNullParameter(AbsStopGyroscopeMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsStopGyroscopeMethodIDL.a.class), "");
    }
}
