package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getGameCPLiveCommonTrackContext")
public final class y3 extends c0<JsonObject, GetGameCPLiveCommonTrackContextResultModel> {

    public static final class a {
    }

    static {
    }

    public y3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        HashMap<String, String> r102 = GamecpTracker.f56755a;     // Catch: Throwable -> L5
        Map r103 = GamecpTracker.k(null, null);     // Catch: Throwable -> L5
        String r104 = GsonHelper.a.f57433a.create().toJson(r103);     // Catch: Throwable -> L5
        GetGameCPLiveCommonTrackContextResultModel r105 = new GetGameCPLiveCommonTrackContextResultModel();     // Catch: Throwable -> L5
        r105.a(GetGameCPLiveCommonTrackContextResultModel.Code.Success);     // Catch: Throwable -> L5
        GetGameCPLiveCommonTrackContextResultModel.a r106 = new GetGameCPLiveCommonTrackContextResultModel.a();     // Catch: Throwable -> L5
        r106.a(GsonHelper.a.f57436d.parse(r104).getAsJsonObject());     // Catch: Throwable -> L5
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r105.b(r106);     // Catch: Throwable -> L5
        finishWithResult(r105);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        x8.a.c("Error getting common track data from JSB", th, false);
        GetGameCPLiveCommonTrackContextResultModel r108 = new GetGameCPLiveCommonTrackContextResultModel();
        r108.a(GetGameCPLiveCommonTrackContextResultModel.Code.Failed);
        r108.c("Error in getting common track data");
        Unit r109 = Unit.INSTANCE;
        finishWithResult(r108);
    }
}
