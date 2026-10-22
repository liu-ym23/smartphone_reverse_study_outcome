package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.bluetooth.AbsNotifyBLECharacteristicValueChangeMethodIDL;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l4.c;
import t3.e0;
import t3.u1;
import t3.v1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/NotifyBLECharacteristicValueChangeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsNotifyBLECharacteristicValueChangeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsNotifyBLECharacteristicValueChangeMethodIDL$NotifyBLECharacteristicValueChangeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsNotifyBLECharacteristicValueChangeMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyBLECharacteristicValueChangeMethod extends AbsNotifyBLECharacteristicValueChangeMethodIDL {
    public NotifyBLECharacteristicValueChangeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final d r100, ParamModel r101, final h r102) {
        final AbsNotifyBLECharacteristicValueChangeMethodIDL.b r103 = (AbsNotifyBLECharacteristicValueChangeMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = this.f35269a;
        e0.f544279a.getClass();
        c.b(r100, r104, e0.c(), new u1(r102), new v1(r100, r103, r102));
    }
}
