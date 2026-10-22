package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "CJPrefetch")
public final class f extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("merchant_id");
        String r104 = r102.optString("uid");
        String r105 = r102.optString("app_id");
        String r106 = r102.optString("exts");
        com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).X(r101.getContext(), r105, r103, r104, r106);
        return null;
    }
}
