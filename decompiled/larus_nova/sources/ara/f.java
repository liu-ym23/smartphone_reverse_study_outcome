package ara;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@XBridgeMethod(name = "account.getSdkVersion")
public final class f extends bra.g {
    public f() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        bra.g.a r113 = (bra.g.a) r111;
        long r114 = System.currentTimeMillis();
        bb7.c r100 = (bb7.c) bb7.b.f18533a.get("account_sdk_info");
        if (r100 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "account info service is null", null, 4, null);
        int r115 = a.f16045a;
        a.a(this.f20177a, null, "account info service is null", System.currentTimeMillis() - r114, null, null, 114);
        return;
    L5:
        bra.g.b r101 = (bra.g.b) XBridgeResultModelArguments.INSTANCE.createModel(bra.g.b.class);
        r100.getVersionCode();
        r101.setVersionCode(60592);
        r100.getVersionName();
        r101.setVersionName("0.6.5-alpha.72-doubao");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, r101, null, 2, null);
        int r116 = a.f16045a;
        String r102 = this.f20177a;
        long r103 = System.currentTimeMillis() - r114;
        JSONObject r117 = new JSONObject();
        r117.put(RuleConditionBean.VERSION_CODE_KEY, r101.getVersionCode());
        r117.put("versionName", r101.getVersionName());
        a.b(r102, null, r117.toString(), r103, null, 114);
    }
}
