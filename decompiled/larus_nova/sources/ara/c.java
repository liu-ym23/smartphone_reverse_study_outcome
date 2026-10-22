package ara;

import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.getCarrierPhone")
public final class c extends bra.e {
    public c() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        bra.e.b r103 = (bra.e.b) r101;
        IOnekeyLoginService r104 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (r104 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "one key login service un register", null, 4, null);
        return;
    L5:
        r104.getPhoneInfo(r103.getScene(), Intrinsics.areEqual(r103.getIgnoreCache(), Boolean.TRUE), new b(r102));
    }
}
