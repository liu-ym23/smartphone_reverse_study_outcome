package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetCurrentDegradeInfoResultModel;
import com.bytedance.android.live.browser.utils.DegradeUtils;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getCurrentDegradeInfo")
public final class d4 extends w20.g1<JsonObject, GetCurrentDegradeInfoResultModel> {
    public d4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetCurrentDegradeInfoResultModel r103 = new GetCurrentDegradeInfoResultModel();
        GetCurrentDegradeInfoResultModel.a r104 = new GetCurrentDegradeInfoResultModel.a();
        Object r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L9
        JsonElement r107 = r102.get("scene");     // Catch: Throwable -> L9
        if (r107 == null) goto L6;
        String r108 = r107.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r109) == true) goto L15;
        r105 = r109;
    L15:
        String r110 = (String) r105;
        Lazy r111 = DegradeUtils.f64296a;
        if (com.bytedance.android.live.core.setting.g4.f65306a.getValue().booleanValue() == true) goto L18;
        IPerformanceStrategyManager r112 = (IPerformanceStrategyManager) DegradeUtils.f64296a.getValue();
        if (r112 == null) goto L23;
        int r113 = r112.getCurrentPerformanceLevel();
    L24:
        r104.a(Integer.valueOf(r113));
        r104.b(0);
        Unit r114 = Unit.INSTANCE;
        r103.a(r104);
        finishWithResult(r103);
        return;
    L23:
        r113 = 0;
        goto L24
    L18:
        if (Intrinsics.areEqual(r110, "live_resource_hour_rank_anim") == false) goto L23;
        r113 = n20.a.f516683a;
        goto L24
    L6:
        r108 = null;
    L9:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
