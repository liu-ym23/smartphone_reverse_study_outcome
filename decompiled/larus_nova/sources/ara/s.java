package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.logout")
public final class s extends bra.m {

    public static final class a {
    }

    static {
    }

    public s() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        bra.m.b r102 = (bra.m.b) r101;
        long r103 = System.currentTimeMillis();
        tb7.a.d("UcUserLogoutMethod", "call in, params: scene=" + r102.getScene());
        String r104 = r102.getScene();
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        com.ss.android.token.d r105 = new com.ss.android.token.d(r104);
        ((sa7.f) sa7.f.a()).b(r105, new t(this, r110, r103, r102));
    }
}
