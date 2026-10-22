package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.onBindPhone")
public final class g extends bra.h {
    public g() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        bra.h.b r103 = (bra.h.b) r101;
        com.bytedance.sdk.account.impl.g.a().b("normal", null);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(bra.h.c.class), null, 2, null);
    }
}
