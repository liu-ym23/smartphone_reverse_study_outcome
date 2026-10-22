package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openOutSitePushAuthPanel")
public final class w8 extends o<JsonObject, OpenOutSitePushAuthPanelResultModel> {
    public w8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((!Intrinsics.areEqual(r102.get("push_guide_share_scene").getAsString(), "after_live_reservation")) == false) goto L5;
        finishWithFailure(new IllegalArgumentException());
    L5:
        IMatchShareService r103 = (IMatchShareService) jc1.k.f(IMatchShareService.class);
        if (r103 == null) goto L11;
        Pair<Integer, String> r104 = r103.openPushGuideDialogForSaas();
        int r105 = r104.component1().intValue();
        String r106 = r104.component2();
        if (r105 != 0) goto L10;
        OpenOutSitePushAuthPanelResultModel r107 = new OpenOutSitePushAuthPanelResultModel();
        r107.a(OpenOutSitePushAuthPanelResultModel.Code.Failed);
        JsonObject r108 = new JsonObject();
        r108.addProperty("msg", "msg");
        Unit r109 = Unit.INSTANCE;
        r107.b(r108);
        finishWithResult(r107);
        return;
    L10:
        finishWithRawResult(new JSONObject("{\"code\": 1, \"msg\": \"" + r106 + "\"}"));
        return;
    L11:
        finishWithRawResult(new JSONObject("{\"code\": 1, \"msg\": \"IMatchShareService null\"}"));
    }
}
