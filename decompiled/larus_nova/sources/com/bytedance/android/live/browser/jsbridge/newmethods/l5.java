package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.HideLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "hideLoading")
public final class l5 extends w20.c2<JsonObject, HideLoadingResultModel> {
    public l5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.widget.e1 r102 = l30.f.f507221a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        com.bytedance.android.livesdk.widget.e1 r104 = l30.f.f507221a;     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        l30.f.a(r104);     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L11:
        l30.f.f507221a = null;
        HideLoadingResultModel r106 = new HideLoadingResultModel();
        r106.a(HideLoadingResultModel.Code.Success);
        r106.b("SUCCESS");
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
