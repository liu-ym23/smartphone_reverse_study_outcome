package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdkapi.depend.constant.ApiConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getXTtToken")
public final class v3 extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {
    public v3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(Object r100, CallContext r101) throws Exception {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        if (LiveHybridSettingKeys.ARGUS_DELETE_GET_XTT_TOKEN_JSB.getValue().booleanValue() == false) goto L5;
        r101.getContext();
        LocalTestManager.a(new Class[]{wy.a.class});
    L13:
        return r102;
    L5:
        Map<String, String> r104 = ((IHostWebView) jc1.k.f(IHostWebView.class)).getHeaderMap(ApiConfig.API_URL_PREFIX_I);
        if (r104 == null) goto L13;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        Map.Entry<String, String> r106 = r105.next();
        r103.put(r106.getKey(), r106.getValue());
        goto L10
    L12:
        r102.put("token", r103);
        goto L13
    }
}
