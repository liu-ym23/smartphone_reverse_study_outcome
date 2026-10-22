package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.setVerifyPortraitOuterFlag")
public final class o extends bra.c {
    public o() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        tb7.a.d("AccountSDK", "setVerifyPortraitOuterFlag");
        com.bytedance.sdk.account.impl.h.a().x(((bra.c.a) r101).getFlag());
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(bra.c.b.class), null, 2, null);
    }
}
