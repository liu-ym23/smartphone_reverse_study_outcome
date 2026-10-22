package com.bytedance.applet.aibridge.ecommerce.impl;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsGetBtmInfoMethodIDL;
import com.larus.btm.api.IBTMService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/GetBtmInfoMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL$AbsGetBtmInfoMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL$AbsGetBtmInfoMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetBtmInfoMethod extends AbsGetBtmInfoMethodIDL {
    public GetBtmInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsGetBtmInfoMethodIDL.a r103 = (AbsGetBtmInfoMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getBtm();
        JSONObject r105 = r103.getBcm();
        IBTMService r106 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        String r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.n(r104, r105, r100.getEngineView());
    L6:
        IBTMService r109 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r109 == null) goto L9;
        r107 = r109.c(r108);
    L9:
        Intrinsics.checkNotNullParameter(AbsGetBtmInfoMethodIDL.b.class, "<this>");
        AbsGetBtmInfoMethodIDL.b r110 = (AbsGetBtmInfoMethodIDL.b) c.a(AbsGetBtmInfoMethodIDL.b.class);
        r110.setSourceBtmToken(r108);
        r110.setBtmShowId(r107);
        r102.b(r110, "");
        return;
    L5:
        r108 = null;
        goto L6
    }
}
