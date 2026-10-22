package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.sendLog")
public final class m extends bra.j {
    public m() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        bra.j.a r113 = (bra.j.a) r111;
        long r100 = System.currentTimeMillis();
        String r114 = r113.getEventName();
        Map<String, Object> r101 = r113.getParams();
        if (r101 == null) goto L5;
        JSONObject r102 = new JSONObject(r101);
    L6:
        com.bytedance.sdk.account.monitor.a.a(r114, r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(bra.j.b.class), null, 2, null);
        int r115 = a.f16045a;
        String r103 = this.f20185a;
        long r104 = System.currentTimeMillis() - r100;
        JSONObject r116 = new JSONObject();
        r116.put("event", r113.getEventName());
        a.b(r103, r116.toString(), null, r104, null, 116);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
