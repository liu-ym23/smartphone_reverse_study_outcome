package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.bluetooth.AbsStartBeaconDiscoveryMethodIDL;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l4.c;
import t3.e0;
import t3.e2;
import t3.f0;
import t3.f2;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StartBeaconDiscoveryMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBeaconDiscoveryMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBeaconDiscoveryMethodIDL$StartBeaconDiscoveryParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBeaconDiscoveryMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartBeaconDiscoveryMethod extends AbsStartBeaconDiscoveryMethodIDL {
    public StartBeaconDiscoveryMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, final h r102) {
        final AbsStartBeaconDiscoveryMethodIDL.b r103 = (AbsStartBeaconDiscoveryMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r103.getUuids().isEmpty() == false) goto L5;
        f0.a(r102, "startBeaconDiscovery failed: uuids is empty");
        return;
    L5:
        String r104 = this.f35273a;
        e0.f544279a.getClass();
        c.b(r100, r104, e0.j(), new e2(r102), new f2(r103, r102));
    }
}
