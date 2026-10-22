package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.login")
public final class r extends bra.l {
    public r() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r212) {
        bra.l.b r100 = (bra.l.b) r211;
        long r101 = System.currentTimeMillis();
        bb7.d r102 = (bb7.d) bb7.b.f18533a.get("account_sdk_login");
        if (r102 != null) goto L5;
        int r103 = a.f16045a;
        String r104 = this.f20191a;
        long r105 = System.currentTimeMillis() - r101;
        JSONObject r106 = new JSONObject();
        r106.put("scene", r100.getScene());
        a.a(r104, r106.toString(), "account login service is null", r105, null, null, 112);
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "account login service is null", null, 4, null);
        return;
    L5:
        LinkedHashMap r107 = new LinkedHashMap();
        Map<String, Object> r108 = r100.getContext();     // Catch: Exception -> L24
        if (r108 == null) goto L12;
        Iterator<String> r109 = r108.keySet().iterator();     // Catch: Exception -> L24
    L10:
        if (r109.hasNext() == false) goto L12;
        String r110 = r109.next();     // Catch: Exception -> L24
        r107.put(r110, String.valueOf(r108.get(r110)));     // Catch: Exception -> L24
    L12:
        String r111 = r100.getLoginMethod();     // Catch: Exception -> L24
        if (r111 != null) goto L15;
    L25:
        r100.getScene();
        r102.a();
        return;
    L15:
        if (r111.length() <= 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L21;
        r111 = null;
    L21:
        if (r111 == null) goto L25;
        r107.put("force_login_method", r111);     // Catch: Exception -> L24
        goto L25
    L17:
        r112 = false;
    L24:
        tb7.a.d("UcUserLoginMethod", "account login params error, context=" + r100.getContext());
        goto L25
    }
}
