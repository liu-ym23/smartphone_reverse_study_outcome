package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "secondValid")
public final class w3 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    public static final class a {

        @SerializedName("decision_config")
        public String decisionConfig;

        @SerializedName("ticket")
        public String ticket;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public w3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        Activity r102 = ContextUtil.contextToActivity(r101.getContext());
        ((IHostVerify) jc1.k.f(IHostVerify.class)).startTwiceVerifyWithDialog(r102, r100.decisionConfig).compose(RxUtil.rxSchedulerHelper()).subscribe(new u3(this), new v3(this));
    }
}
