package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.CommunityGetEnableLiveHistoryResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "community.getEnableLiveHistory")
public final class l0 extends w20.d0<JsonObject, CommunityGetEnableLiveHistoryResultModel> {
    public l0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final /* bridge */ /* synthetic */ void invoke(Object r100, CallContext r101) {
        j((JsonObject) r100, r101);
    }

    public final void j(JsonObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        CommunityGetEnableLiveHistoryResultModel r102 = new CommunityGetEnableLiveHistoryResultModel();
        r102.b(CommunityGetEnableLiveHistoryResultModel.Code.Success);
        CommunityGetEnableLiveHistoryResultModel.a r103 = new CommunityGetEnableLiveHistoryResultModel.a();
        IHostBusiness r104 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r104 == null) goto L5;
        boolean r105 = r104.hasLiveHistoryPermission();
    L6:
        r103.b(Boolean.valueOf(r105));
        Unit r106 = Unit.INSTANCE;
        r102.c(r103);
        finishWithResult(r102);
        return;
    L5:
        r105 = false;
        goto L6
    }
}
