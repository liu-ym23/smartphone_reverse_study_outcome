package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsCloseSocketMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/CloseSocketMethod;", "Lcom/bytedance/ai/bridge/network/AbsCloseSocketMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsCloseSocketMethodIDL$CloseSocketParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsCloseSocketMethodIDL$CloseSocketResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseSocketMethod extends AbsCloseSocketMethodIDL {

    public static final class a {
    }

    static {
    }

    public CloseSocketMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r112) {
        AbsCloseSocketMethodIDL.a r113 = (AbsCloseSocketMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Integer r100 = r113.getCode();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r103 = new StringBuilder("call start, socketTaskId=");
        r103.append(r113.getSocketTaskId());
        r103.append(", code=");
        r103.append(r101);
        r103.append(", hasReason=");
        String r104 = r113.getReason();
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        r103.append(!r105);
        r102.i("AISDK_JSB_CloseSocketMethod", r103.toString());
        c4.a r106 = c4.b.a(r110);
        if (r106 != null) goto L16;
        StringBuilder r107 = new StringBuilder("call failed, errNo=");
        f3.a r108 = f3.a.f475276q;
        r107.append(r108.f475285a);
        r107.append(", msg=The socketTaskId doesn't exist");
        r102.e("AISDK_JSB_CloseSocketMethod", r107.toString());
        f3.h.a.a(r112, "The socketTaskId doesn't exist", r108, null, 10);
        return;
    L16:
        long r109 = r113.getSocketTaskId();
        String r114 = r113.getReason();
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        int r115 = c4.a.c.f22362c;
        c4.a.c r116 = c4.a.c.C0402a.a(r110);
        if (r116 != null) goto L19;
        int r117 = c4.a.f22355d;
        c4.a.d r118 = new c4.a.d("The socketTaskId doesn't exist", f3.a.f475276q);
    L26:
        if (r118 == null) goto L28;
        r102.e("AISDK_JSB_CloseSocketMethod", "call failed, errNo=" + r118.f22366b.f475285a + ", msg=" + r118.f22365a);
        f3.h.a.a(r112, r118.f22365a, r118.f22366b, null, 10);
        return;
    L28:
        r102.i("AISDK_JSB_CloseSocketMethod", "call success, socketTaskId=" + r113.getSocketTaskId());
        Intrinsics.checkNotNullParameter(AbsCloseSocketMethodIDL.b.class, "<this>");
        r112.b((ResultModel) k3.c.a(AbsCloseSocketMethodIDL.b.class), "");
        return;
    L19:
        Object r119 = r106.f22357b;
        monitor-enter(r119);
        c4.a.e r120 = r106.i(r109, r116, null);     // Catch: Throwable -> L30
        monitor-exit(r119);
        if (r120 != null) goto L25;
        r118 = new c4.a.d("The socketTaskId doesn't exist", f3.a.f475276q);
        goto L26
    L25:
        r118 = r120.a(r101, r114);
    L30:
        th = move-exception;
        throw th;
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
        goto L13
    L5:
        r101 = 1000;
        goto L6
    }
}
