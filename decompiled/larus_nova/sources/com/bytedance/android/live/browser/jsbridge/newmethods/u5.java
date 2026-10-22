package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isTeenMode")
public final class u5 extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {
    public u5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(Object r100, CallContext r101) throws Exception {
        JSONObject r102 = new JSONObject();
        Boolean r103 = Boolean.valueOf(((IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class)).isNeedProtectUnderage());
        ALogger.i("isTeenMode", "AnnieParamUtil is_teen_mode = " + r103);
        r102.put("is_teen_mode", r103);
        return r102;
    }
}
