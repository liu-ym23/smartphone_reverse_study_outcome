package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetStreamTimeStampResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.y2;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.getStreamTimeStamp")
public final class d extends y2<JsonObject, LiveGetStreamTimeStampResultModel> {
    public d() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        LiveGetStreamTimeStampResultModel r102 = new LiveGetStreamTimeStampResultModel();
        r102.a(LiveGetStreamTimeStampResultModel.Code.Success);
        LiveGetStreamTimeStampResultModel.a r103 = new LiveGetStreamTimeStampResultModel.a();
        r103.a(String.valueOf(com.bytedance.android.livesdk.utils.ntp.e.a()));
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
    }
}
