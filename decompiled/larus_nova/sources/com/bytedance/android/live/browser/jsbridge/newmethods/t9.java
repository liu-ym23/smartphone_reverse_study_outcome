package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "popTuringVerifyView")
public final class t9 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/t9$a;", "", "Lorg/json/JSONObject;", "decision", "Lorg/json/JSONObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lorg/json/JSONObject;", "setDecision", "(Lorg/json/JSONObject;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static class a {

        @SerializedName("decision")
        private JSONObject decision;

        public a() {
        }

        public final JSONObject a() {
            return this.decision;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public t9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "paramModel");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        ((IHostAction) jc1.k.n(IHostAction.class)).popTuringVerifyViewForJSB(r101.getContext(), String.valueOf(r102.a()), new u9(this));
    }
}
