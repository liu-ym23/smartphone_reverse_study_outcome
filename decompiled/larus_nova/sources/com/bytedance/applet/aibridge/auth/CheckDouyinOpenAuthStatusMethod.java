package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.service.i0;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/CheckDouyinOpenAuthStatusMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsCheckDouyinOpenAuthStatusMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/auth/AbsCheckDouyinOpenAuthStatusMethodIDL$CheckDouyinOpenAuthStatusParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/auth/AbsCheckDouyinOpenAuthStatusMethodIDL$CheckDouyinOpenAuthStatusResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckDouyinOpenAuthStatusMethod extends AbsCheckDouyinOpenAuthStatusMethodIDL {
    public CheckDouyinOpenAuthStatusMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsCheckDouyinOpenAuthStatusMethodIDL.a r103 = (AbsCheckDouyinOpenAuthStatusMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ISdkDouyinAuth r104 = i0.a();
        if (r104 == null) goto L6;
        r104.i(r103.getClientKey(), r103.getScope(), r103.getState(), new a(r102));
        return;
    }
}
