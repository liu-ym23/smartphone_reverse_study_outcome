package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "doDouyinAuth")
public final class p2 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    public static class a {

        @SerializedName("source")
        String source;

        public a() {
        }
    }

    public static final class b {

        @SerializedName("status")
        int status;

        public b(int r100) {
            this.status = r100;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public p2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        Activity r103 = ContextUtil.contextToActivity(r101.getContext());
        if (r103 != null) goto L6;
        finishWithFailure();
    L6:
        if (TTLiveSDK.hostService().user().isLogin() == false) goto L8;
        finishWithResult(new b(0));
    L8:
        ((IAuthRoutine) jc1.k.f(IAuthRoutine.class)).doDouyinAuth(r103, new o2(this), r102.source);
    }
}
