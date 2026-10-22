package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "ec.anniePrerender")
public final class h extends a {
    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        a.b r112 = (a.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        boolean r101 = ECServiceManager.f42805a;
        pd.e r102 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        Activity r103 = r100.getOwnerActivity();
        if (r103 == null) goto L7;
        if (r102 == null) goto L8;
        r102.prerenderAnnieWithSchema(r103, r112.getSchema(), "webcast", (Integer) r112.getExpiredTime(), r112.getStrategy(), new g(r102, r112, r111));
        return;
    L8:
        return;
    }
}
