package com.bytedance.android.live.browser.jsbridge.newmethods;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.browser.jsbridge.base.GetStrategyFactorResultModel;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getStrategyFactor")
public final class h5 extends w20.u1<w20.s9, GetStrategyFactorResultModel> {
    public h5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.s9 r102 = (w20.s9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetStrategyFactorResultModel r103 = new GetStrategyFactorResultModel();
        r103.a(GetStrategyFactorResultModel.Code.Success);
        GetStrategyFactorResultModel.a r104 = new GetStrategyFactorResultModel.a();
        IStrategyService r105 = (IStrategyService) jc1.k.f(IStrategyService.class);
        String r106 = "";
        if (r105 == null) goto L13;
        String r107 = r102.a();
        if (r107 != null) goto L7;
        r107 = "";
    L7:
        LiveData r108 = IStrategyService.a.a(r105, r107, "", false, 12);
        if (r108 == null) goto L13;
        String r109 = (String) r108.getValue();
        if (r109 == null) goto L13;
        r106 = r109;
    L13:
        r104.a(r106);
        Unit r110 = Unit.INSTANCE;
        r103.b(r104);
        finishWithResult(r103);
    }
}
