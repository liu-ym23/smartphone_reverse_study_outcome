package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setBannerVisibility")
public final class s0 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("visible")
        int visible;

        public a() {
        }
    }

    public s0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        xs2.b r102 = xs2.b.a();
        int r103 = r100.visible;
        r102.post(new b30.a());
        return null;
    }
}
