package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.g5;
import com.larus.platform.service.i0;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/GetDouyinAccessTokenMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsGetDouyinAccessTokenMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/auth/AbsGetDouyinAccessTokenMethodIDL$GetDouyinAccessTokenParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/auth/AbsGetDouyinAccessTokenMethodIDL$GetDouyinAccessTokenResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetDouyinAccessTokenMethod extends AbsGetDouyinAccessTokenMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetDouyinAccessTokenMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetDouyinAccessTokenMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ISdkDouyinAuth r103 = i0.a();
        if (r103 == null) goto L7;
        g5 r104 = r103.b();
        if (r104 == null) goto L7;
        String r105 = r104.f365134a;
    L9:
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        Intrinsics.checkNotNullParameter(AbsGetDouyinAccessTokenMethodIDL.b.class, "<this>");
        BaseModel r106 = k3.c.a(AbsGetDouyinAccessTokenMethodIDL.b.class);
        ((AbsGetDouyinAccessTokenMethodIDL.b) r106).setAccessToken(r105);
        r102.b((ResultModel) r106, "");
        return;
    L7:
        r105 = null;
        goto L9
    }
}
