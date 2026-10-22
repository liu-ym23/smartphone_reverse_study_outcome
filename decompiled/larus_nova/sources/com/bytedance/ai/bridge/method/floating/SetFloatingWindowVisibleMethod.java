package com.bytedance.ai.bridge.method.floating;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f3.h;
import i2.i;
import i2.j;
import k2.s;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/floating/SetFloatingWindowVisibleMethod;", "Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL$SetFloatingWindowVisibleParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL$SetFloatingWindowVisibleResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetFloatingWindowVisibleMethod extends AbsSetFloatingWindowVisibleMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public SetFloatingWindowVisibleMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsSetFloatingWindowVisibleMethodIDL.a r103 = (AbsSetFloatingWindowVisibleMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getViewId();
        if (r104 != null) goto L8;
        j r105 = i.f488034a;
        s r106 = i.a.a().j();
        if (r106 == null) goto L7;
        r104 = r106.getPageID();
        goto L8
    L7:
        r104 = null;
    L8:
        if (r104 == null) goto L10;
        j r107 = i.f488034a;
        i.a.a().a(r104, r103.getVisible());
        Intrinsics.checkNotNullParameter(AbsSetFloatingWindowVisibleMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsSetFloatingWindowVisibleMethodIDL.b.class), "");
        return;
    L10:
        h.a.a(r102, "viewId or current floating is null", null, null, 14);
    }
}
