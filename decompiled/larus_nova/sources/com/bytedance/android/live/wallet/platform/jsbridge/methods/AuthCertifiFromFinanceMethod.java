package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "authCertifiFromFinance")
public class AuthCertifiFromFinanceMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public static /* synthetic */ void j(AuthCertifiFromFinanceMethod r100, int r101) {
        r100.callBack(r101);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public AuthCertifiFromFinanceMethod() {
    }

    private void callBack(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("code", 1);     // Catch: Exception -> L5
        r101.put("status_code", r100);     // Catch: Exception -> L5
        finishWithResult(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        int r102 = v.f91009a;
        v.e("AuthCertifiFromFinanceMethod", "jsb call back error occurs  " + e.getMessage());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(JSONObject r110, CallContext r111) throws Exception {
        if ((r111.getContext() instanceof Activity) == true) goto L5;
        return;
    L5:
        String r100 = r110.optString("merchant_id");
        String r101 = r110.optString("app_id");
        String r102 = r110.optString(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS);
        String r103 = r110.optString("theme");
        if (TextUtils.equals(r103, "pay") == false) goto L8;
    L10:
        String r104 = r103;
    L11:
        String r105 = r110.optString("scene");
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        String r106 = r110.optString("style");
        com.bytedance.android.live.wallet.d r107 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b());
        Activity r108 = (Activity) r111.getContext();
        r107.A(r108, r100, r101, r102, r104, r105, r106, new c(this));
        return;
    L8:
        if (TextUtils.equals(r103, "auth") == true) goto L10;
        r104 = "auth";
        goto L11
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public /* bridge */ /* synthetic */ void invoke(JSONObject r100, CallContext r101) throws Exception {
        invoke2(r100, r101);
    }
}
