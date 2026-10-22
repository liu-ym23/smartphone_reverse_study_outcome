package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMuteStatusResultModel;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getMuteStatus")
public final class d5 extends w20.p1<JsonObject, GetMuteStatusResultModel> {
    public d5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = ((IHostAction) jc1.k.n(IHostAction.class)).getMuteStatus();
        GetMuteStatusResultModel r103 = new GetMuteStatusResultModel();
        r103.a(GetMuteStatusResultModel.Code.Success);
        GetMuteStatusResultModel.a r104 = new GetMuteStatusResultModel.a();
        r104.a(Boolean.valueOf(r102));
        Unit r105 = Unit.INSTANCE;
        r103.b(r104);
        finishWithResult(r103);
    }
}
