package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r4 extends g<JsonObject, GetInteractGameLiveSceneResultModel> {
    public r4(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetInteractGameLiveSceneResultModel r102 = new GetInteractGameLiveSceneResultModel();
        r102.a(GetInteractGameLiveSceneResultModel.Code.Success);
        GetInteractGameLiveSceneResultModel.a r103 = new GetInteractGameLiveSceneResultModel.a();
        r103.a(String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
    }
}
