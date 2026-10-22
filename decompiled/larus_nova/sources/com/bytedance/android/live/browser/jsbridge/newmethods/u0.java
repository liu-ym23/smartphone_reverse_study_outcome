package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setBottomBannerVisibility")
public final class u0 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("visible")
        int visible;

        public a() {
        }
    }

    public u0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        xs2.b.a().post(new b30.b(r100.visible));
        return null;
    }
}
