package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "getCjBindInfo")
public final class e extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.live.wallet.d r102 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b());
        String r103 = r102.o().getType();
        String r104 = r102.o().f102678a;
        com.bytedance.android.live.wallet.model.b r105 = r102.o();
        r105.f102678a = "";
        r105.f102679b = "";
        r102.r1();
        JSONObject r106 = new JSONObject();
        r106.put("type", r103);
        r106.put("data", r104);
        finishWithResult(r106);
    }
}
