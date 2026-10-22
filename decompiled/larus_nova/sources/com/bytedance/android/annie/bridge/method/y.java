package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.GetCurrentTimeResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getCurrentTime")
public final class y extends e7.g<JsonObject, GetCurrentTimeResultModel> {
    public y() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r102 = com.bytedance.android.annie.util.x.b();
        if (r102 == 0) goto L5;
        GetCurrentTimeResultModel r103 = new GetCurrentTimeResultModel();
        r103.a(GetCurrentTimeResultModel.Code.Success);
        GetCurrentTimeResultModel.a r104 = new GetCurrentTimeResultModel.a();
        r104.a(Long.valueOf(r102));
        r103.b(r104);
        finishWithResult(r103);
        return;
    L5:
        JSONObject r105 = new JSONObject();
        r105.put("code", 0);
        finishWithRawResult(r105);
    }
}
