package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.CloseAnchorLiveRoomResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "closeAnchorLiveRoom")
public final class g0 extends w20.u<JsonObject, CloseAnchorLiveRoomResultModel> {
    public g0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        zg1.h1 r102 = new zg1.h1(7);
        xs2.b.a().post(r102);
        finishWithSuccess();
    }
}
