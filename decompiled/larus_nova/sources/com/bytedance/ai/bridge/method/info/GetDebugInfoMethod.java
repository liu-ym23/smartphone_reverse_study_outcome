package com.bytedance.ai.bridge.method.info;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetDebugInfoMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetDebugInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/info/AbsGetDebugInfoMethodIDL$GetDebugInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/info/AbsGetDebugInfoMethodIDL$GetDebugInfoResultModel;", "getContextDependInstance", "Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetDebugInfoMethod extends AbsGetDebugInfoMethodIDL {
    public GetDebugInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetDebugInfoMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        IHostContextDepend r103 = a.f535974a;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNullParameter(AbsGetDebugInfoMethodIDL.b.class, "<this>");
        BaseModel r104 = c.a(AbsGetDebugInfoMethodIDL.b.class);
        ((AbsGetDebugInfoMethodIDL.b) r104).setHttpEnv(r103.getHttpEnv());
        r102.b((ResultModel) r104, "");
        return;
    L5:
        h.a.a(r102, "context dependency is not binded", null, null, 14);
    }
}
