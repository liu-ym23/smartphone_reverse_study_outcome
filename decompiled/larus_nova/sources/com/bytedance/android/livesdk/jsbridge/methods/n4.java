package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "switchFlashConfig")
public final class n4 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public n4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((IHostCommerceServiceLive) jc1.k.n(IHostCommerceServiceLive.class)).switchFlashConfig(r102.optBoolean("is_open"));
    }
}
