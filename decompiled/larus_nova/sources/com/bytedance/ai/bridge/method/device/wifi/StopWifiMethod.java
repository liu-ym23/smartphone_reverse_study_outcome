package com.bytedance.ai.bridge.method.device.wifi;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.wifi.AbsStopWifiMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v3.b;
import v3.j;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/StopWifiMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsStopWifiMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/wifi/AbsStopWifiMethodIDL$StopWifiParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsStopWifiMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopWifiMethod extends AbsStopWifiMethodIDL {

    public static final class a {
    }

    static {
    }

    public StopWifiMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsStopWifiMethodIDL.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r103 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call start, appletId=");
        a0 r105 = r100.getContainerContext();
        if (r105 == null) goto L5;
        String r106 = r105.getAppletId();
    L6:
        r104.append(r106);
        r103.i("AISDK_JSB_StopWifiMethod", r104.toString());
        v3.h r107 = j.a(r100);
        Object r108 = r107.f552798b;
        monitor-enter(r108);
        r107.f552800d = false;     // Catch: Throwable -> L13
        r107.b();     // Catch: Throwable -> L13
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r108);
        b.g();
        r103.i("AISDK_JSB_StopWifiMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsStopWifiMethodIDL.a.class, "<this>");
        r102.b((ResultModel) c.a(AbsStopWifiMethodIDL.a.class), "");
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        r106 = null;
        goto L6
    }
}
