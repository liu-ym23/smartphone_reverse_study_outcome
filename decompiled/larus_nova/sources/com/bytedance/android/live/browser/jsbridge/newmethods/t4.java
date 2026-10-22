package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveFoldStateResultModel;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getLiveFoldState")
public final class t4 extends w20.m1<JsonObject, GetLiveFoldStateResultModel> {
    public t4() {
        new GetLiveFoldStateResultModel();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetLiveFoldStateResultModel r102 = new GetLiveFoldStateResultModel();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        r102.a(GetLiveFoldStateResultModel.Code.Success);     // Catch: Throwable -> L5
        GetLiveFoldStateResultModel.a r104 = new GetLiveFoldStateResultModel.a();     // Catch: Throwable -> L5
        r104.a(Integer.valueOf(FoldScreenUtils.a()));     // Catch: Throwable -> L5
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r102.b(r104);     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L10;
        r102.a(GetLiveFoldStateResultModel.Code.Failed);
        GetLiveFoldStateResultModel.a r107 = new GetLiveFoldStateResultModel.a();
        r107.a(-2);
        Unit r108 = Unit.INSTANCE;
        r102.b(r107);
    L10:
        finishWithResult(r102);
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
