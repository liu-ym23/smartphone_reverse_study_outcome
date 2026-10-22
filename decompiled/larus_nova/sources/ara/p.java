package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.ss.android.account.ThirdPartyAuthType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.thirdPartyAuth")
public final class p extends bra.d {

    public static final class a {
    }

    static {
    }

    public p() {
    }

    public final void a(CompletionBlock<Object> r110, long r111, bra.d.a r112) {
        Boolean r100 = r112.getNeedRawData();
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "handle third party auth failed", null, 4, null);
        int r113 = ara.a.f16045a;
        String r102 = this.f20169a;
        long r103 = System.currentTimeMillis() - r111;
        JSONObject r114 = new JSONObject();
        r114.put("platform", r112.getPlatform());
        r114.put("needRawData", r101);
        ara.a.a(r102, r114.toString(), "handle third party auth failed", r103, r112.getPlatform(), String.valueOf(r101), 64);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        bra.d.a r103 = (bra.d.a) r101;
        long r104 = System.currentTimeMillis();
        Boolean r105 = r103.getNeedRawData();
        if (r105 == null) goto L5;
        boolean r106 = r105.booleanValue();
    L6:
        tb7.a.d("UcThirdPartyAuthMethod", "call in, params: platform=" + r103.getPlatform() + ", needRawData=" + r106);
        if (com.ss.android.account.k.d().f() == null) goto L9;
        com.ss.android.account.k.d().getApplicationContext();
        ThirdPartyAuthType r107 = ThirdPartyAuthType.LOGIN;
        r103.getPlatform();
        a(r102, r104, r103);
        return;
    L9:
        a(r102, r104, r103);
        return;
    L5:
        r106 = false;
        goto L6
    }
}
