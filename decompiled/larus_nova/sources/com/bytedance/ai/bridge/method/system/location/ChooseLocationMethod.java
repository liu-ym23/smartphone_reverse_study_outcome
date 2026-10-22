package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.location.AbsChooseLocationMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/ChooseLocationMethod;", "Lcom/bytedance/ai/bridge/system/location/AbsChooseLocationMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/location/AbsChooseLocationMethodIDL$ChooseLocationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/location/AbsChooseLocationMethodIDL$ChooseLocationResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseLocationMethod extends AbsChooseLocationMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public ChooseLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r100, ParamModel r101, final f3.h r102) {
        final AbsChooseLocationMethodIDL.a r103 = (AbsChooseLocationMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = LocationAuthorization.f35985a;
        Function1 r105 = new a(this, r100, r103, r102);
        LocationAuthorization.a(r100, r102, Scope.userLocation, "doubao.getLocation.permission_check.call", r105);
    }
}
