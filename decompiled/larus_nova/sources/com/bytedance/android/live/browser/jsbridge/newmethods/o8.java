package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openCashVerify")
public final class o8 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public o8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        Activity r102 = ContextUtil.contextToActivity(r101.getContext());
        ((IHostVerify) jc1.k.f(IHostVerify.class)).verifyForStartLive(r102, 0, "4", null, null);
        return null;
    }
}
