package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastSdk.dialogPullDownClose")
public final class be extends com.bytedance.ies.web.jsbridge2.g<a, JsonObject> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/be$a;", "", "", "pullDownClose", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setPullDownClose", "(I)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName(AppConstants.BUNDLE_PULL_DOWN_CLOSE)
        private int pullDownClose;

        public a() {
        }

        public final int a() {
            return this.pullDownClose;
        }
    }

    public be() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JsonObject invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        xs2.b.a().post(new b30.z(r102.a()));
        return null;
    }
}
