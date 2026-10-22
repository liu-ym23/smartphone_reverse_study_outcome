package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "authAlipay")
public final class b extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("infoStr");
        Boolean r104 = Boolean.valueOf(r102.optBoolean("isShowLoading"));
        Activity r105 = ContextUtil.contextToActivity(r101.getContext());
        if (r105 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).authAlipay(r105, r103, r104.booleanValue(), new a(this));
    }
}
