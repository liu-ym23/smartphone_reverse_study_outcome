package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetStarInfoResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getStarInfo")
public final class c9 extends w20.t1<JsonObject, GetStarInfoResultModel> {
    public c9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetStarInfoResultModel r102 = new GetStarInfoResultModel();
        GetStarInfoResultModel.a r103 = new GetStarInfoResultModel.a();
        GetStarInfoResultModel.b r104 = new GetStarInfoResultModel.b();
        r104.a(((IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class)).getPreviewStarOrderId());
        Unit r105 = Unit.INSTANCE;
        r103.a(r104);
        r102.a(r103);
        finishWithResult(r102);
    }
}
