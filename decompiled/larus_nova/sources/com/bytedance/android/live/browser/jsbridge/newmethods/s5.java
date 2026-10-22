package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isHomeSideBarSupport")
public final class s5 extends i<JsonObject, IsHomeSideBarSupportResultModel> {
    public s5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IsHomeSideBarSupportResultModel r102 = new IsHomeSideBarSupportResultModel();
        r102.a(Boolean.valueOf(((IHostAction) jc1.k.n(IHostAction.class)).isSideBarPageInMain()));
        finishWithResult(r102);
    }
}
