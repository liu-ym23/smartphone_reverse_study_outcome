package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.setVerifyPortraitFlag")
public final class n extends bra.b {
    public n() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        tb7.a.d("AccountSDK", "setVerifyPortraitFlag");
        com.bytedance.sdk.account.impl.h.a().w(((bra.b.a) r101).getFlag());
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(bra.b.InterfaceC0349b.class), null, 2, null);
    }
}
