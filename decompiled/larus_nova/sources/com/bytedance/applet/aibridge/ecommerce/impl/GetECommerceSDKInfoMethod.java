package com.bytedance.applet.aibridge.ecommerce.impl;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsGetECommerceSDKInfoMethodIDL;
import com.larus.platform.api.l2;
import com.larus.platform.service.l0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/GetECommerceSDKInfoMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetECommerceSDKInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetECommerceSDKInfoMethodIDL$GetECommerceSDKInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetECommerceSDKInfoMethodIDL$GetECommerceSDKInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetECommerceSDKInfoMethod extends AbsGetECommerceSDKInfoMethodIDL {
    public GetECommerceSDKInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetECommerceSDKInfoMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        l2 r103 = l0.a();
        if (r103 == null) goto L6;
        String r104 = Integer.valueOf(r103.getVersion()).toString();
        if (r104 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(AbsGetECommerceSDKInfoMethodIDL.b.class, "<this>");
        AbsGetECommerceSDKInfoMethodIDL.b r105 = (AbsGetECommerceSDKInfoMethodIDL.b) c.a(AbsGetECommerceSDKInfoMethodIDL.b.class);
        r105.setVersion(r104);
        r105.setSupport(Boolean.TRUE);
        if (r103 == null) goto L10;
        boolean r106 = true;
    L11:
        r105.setSupportEcommerceSaas(Boolean.valueOf(r106));
        r102.b(r105, "");
        return;
    L10:
        r106 = false;
    L6:
        r104 = "0";
        goto L7
    }
}
