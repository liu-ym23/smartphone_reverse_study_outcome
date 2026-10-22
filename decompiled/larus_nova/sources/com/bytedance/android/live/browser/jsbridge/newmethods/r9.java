package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getPhoneNumber")
public final class r9 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    public static final class a {

        @SerializedName(IGoogleService.ResponseKey.PHONE_NUMBER)
        String phoneNumber;

        public a(String r100) {
            this.phoneNumber = r100;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        ((IAuthRoutine) jc1.k.f(IAuthRoutine.class)).getCurrentAccountPhoneNumber(new q9(this));
    }
}
