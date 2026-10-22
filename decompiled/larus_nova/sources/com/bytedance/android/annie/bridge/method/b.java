package com.bytedance.android.annie.bridge.method;

import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.AppInfoResultModel;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "appInfo")
public final class b extends e7.a<JSONObject, AppInfoResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        JSONObject r102 = (JSONObject) r100;
        AppInfoResultModel r103 = new AppInfoResultModel();
        com.bytedance.android.annie.ng.g.f39670b.getClass();
        r103.a(String.valueOf(com.bytedance.android.annie.ng.e.f39661a.f522305a));
        r103.d(String.valueOf(AnnieXMonitorConstants.a()));
        String r104 = r101.getContext().getPackageManager().getPackageInfo(r101.getContext().getPackageName(), 0).versionName;     // Catch: Exception -> L5
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L9;
        com.bytedance.android.annie.ng.g.f39670b.getClass();
        r104 = com.bytedance.android.annie.ng.e.f39661a.f522307c;
    L9:
        r103.b(r104);
        com.bytedance.android.annie.ng.g.f39670b.getClass();
        r103.h(com.bytedance.android.annie.ng.e.f39661a.f522307c);
        r103.i(r104);
        String r105 = ((i9.d) Annie.getService(i9.d.class)).k0();
        if (r105 == null) goto L12;
        r103.j(r105);
    L12:
        r103.c(AppInfoResultModel.Code.Success);
        r103.e(NetworkUtils.getNetworkAccessType(r101.getContext().getApplicationContext()));
        com.bytedance.android.annie.util.p r106 = com.bytedance.android.annie.util.p.f40070a;
        r103.f(Integer.valueOf(r106.d()));
        r103.g(Integer.valueOf(r106.e()));
        finishWithResult(r103);
        return;
    L5:
        r104 = "";
        goto L7
    }
}
