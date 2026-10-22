package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.onUserInfoChanged")
public final class i extends bra.i {
    public i() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        bra.i.b r102 = (bra.i.b) r101;
        long r103 = System.currentTimeMillis();
        com.bytedance.sdk.account.impl.g.a().b(r102.getScene(), new h(this, r110, r103, r102));
    }
}
