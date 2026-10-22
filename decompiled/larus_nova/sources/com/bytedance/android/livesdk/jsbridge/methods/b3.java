package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openProductList")
public final class b3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostCommerceServiceLive r102 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).c();
        if (r102 == null) goto L6;
        Context r103 = r101.getContext();
        JSONObject r104 = new JSONObject();
        r104.put("entry_name", "from_webview");
        Unit r105 = Unit.INSTANCE;
        r102.showLivePromotionListFragment(r103, r104);
        return;
    }
}
