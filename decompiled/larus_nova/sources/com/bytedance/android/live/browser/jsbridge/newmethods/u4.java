package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveNtpTimeResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u4 extends w20.n1<JsonObject, GetLiveNtpTimeResultModel> {
    public u4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r103 = com.bytedance.android.livesdk.utils.ntp.e.a();
        ALogger.i("GetLiveNtpTimeMethod", "param: " + r102 + ", currentServerTime: " + r103);
        GetLiveNtpTimeResultModel r104 = new GetLiveNtpTimeResultModel();
        r104.a(GetLiveNtpTimeResultModel.Code.Success);
        GetLiveNtpTimeResultModel.a r105 = new GetLiveNtpTimeResultModel.a();
        r105.a(Long.valueOf(r103));
        Unit r106 = Unit.INSTANCE;
        r104.b(r105);
        finishWithResult(r104);
    }
}
