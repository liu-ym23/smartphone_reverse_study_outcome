package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isInstalledApp")
public final class v1 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public v1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) throws Exception {
        String r102 = r100.optString("schema", "");
        PackageManager r103 = r101.getContext().getPackageManager();     // Catch: Exception -> L8
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L8
        r104.setData(UriProtector.parse(r102));     // Catch: Exception -> L8
        List<ResolveInfo> r105 = r103.queryIntentActivities(r104, 64);     // Catch: Exception -> L8
        if (r105 == null) goto L10;
        if (r105.size() <= 0) goto L10;
        int r106 = 1;
    L11:
        JSONObject r107 = new JSONObject();
        r107.put("isInstalled", r106);
        return r107;
    L10:
        r106 = 0;
    L8:
        e = move-exception;
        Logger.d("CheckAppInstalledMethod", "exception:" + e.toString());
        goto L10
    }
}
