package ara;

import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.getCarrierToken")
public final class e extends bra.f {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        bra.f.b r103 = (bra.f.b) r101;
        IOnekeyLoginService r104 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (r104 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "one key login service un register", null, 4, null);
        return;
    L5:
        r104.getAuthToken(new d(r102));
    }
}
