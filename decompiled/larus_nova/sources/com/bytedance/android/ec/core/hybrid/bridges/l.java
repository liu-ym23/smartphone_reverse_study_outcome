package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "ec.preloadPdpFull")
public final class l extends b {
    public l() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b.InterfaceC0799b r103 = (b.InterfaceC0799b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r104 = r100.getOwnerActivity();
        String r105 = r103.getSchema();
        if (r104 == null) goto L8;
        if (r105 == null) goto L8;
        int r106 = ECSdk.f48106a;
        ca3.c r107 = (ca3.c) ECSdk.a(ca3.c.class);
        if (r107 == null) goto L8;
        r107.a(r104, r105);
    L8:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class)), null, 2, null);
    }
}
