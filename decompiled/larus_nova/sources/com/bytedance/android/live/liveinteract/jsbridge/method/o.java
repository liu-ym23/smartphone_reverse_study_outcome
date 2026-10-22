package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GetFansClubStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "getFansClubStatus")
public final class o extends w20.h1<JsonObject, GetFansClubStatusResultModel> {
    public o() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetFansClubStatusResultModel r102 = new GetFansClubStatusResultModel();
        com.bytedance.android.live.profit.fansclub.o r103 = yt0.c.c();
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.fansclub.g> r104 = r103.getProfile();
        if (r104 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.g r105 = r104.getValue();
        if (r105 == null) goto L9;
        int r106 = r105.b();
    L10:
        r102.b(Integer.valueOf(r106));
        r102.a(GetFansClubStatusResultModel.Code.Success);
        finishWithResult(r102);
        StringBuilder r107 = new StringBuilder("status: ");
        com.bytedance.android.live.profit.fansclub.o r108 = yt0.c.c();
        if (r108 == null) goto L17;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.fansclub.g> r109 = r108.getProfile();
        if (r109 == null) goto L17;
        com.bytedance.android.live.profit.fansclub.g r110 = r109.getValue();
        if (r110 == null) goto L17;
        String r111 = String.valueOf(r110.b());
    L18:
        r107.append(r111);
        ALogger.d("GetFansClubStatusMethod", r107.toString());
        return;
    L17:
        r111 = null;
    L9:
        r106 = 0;
        goto L10
    }
}
