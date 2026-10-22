package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "directFlashPurchaseCategories")
public final class e0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        IHostCommerceServiceLive r103 = (IHostCommerceServiceLive) jc1.k.n(IHostCommerceServiceLive.class);
        JSONObject r104 = r102.optJSONObject("data");
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.optString("categoriesName");
    L6:
        JSONObject r107 = r102.optJSONObject("data");
        if (r107 == null) goto L9;
        r105 = r107.optString("categoriesIds");
    L9:
        r103.chooseCategory(r106, r105);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
