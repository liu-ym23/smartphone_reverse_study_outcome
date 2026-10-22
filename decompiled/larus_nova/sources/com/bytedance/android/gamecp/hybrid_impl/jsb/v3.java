package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceCardType;
import com.bytedance.android.gamecp.live_api.ProviderSource;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getGameCPCurrentExplainPropInfo")
public final class v3 extends a0<JsonObject, GetGameCPCurrentExplainPropInfoResultModel> {

    public static final class a {
    }

    static {
    }

    public v3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        mw.a r102 = (mw.a) xr.s.a(mw.a.class);
        String r103 = null;
        if (r102 == null) goto L5;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r104 = r102.getCardData();
    L6:
        mw.a r105 = (mw.a) xr.s.a(mw.a.class);
        if (r105 == null) goto L15;
        Room r106 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r106 == null) goto L13;
        Long r107 = r106.getRoomId();
        if (r107 == null) goto L13;
        String r108 = String.valueOf(r107.longValue());
    L14:
        Boolean r109 = r105.isIntroducingCardManually(r108, null, ProviderSource.DEFAULT.name());
    L16:
        if (r104 != null) goto L18;
    L29:
        GetGameCPCurrentExplainPropInfoResultModel r110 = new GetGameCPCurrentExplainPropInfoResultModel();
        r110.a(GetGameCPCurrentExplainPropInfoResultModel.Code.Success);
        r110.b(new GetGameCPCurrentExplainPropInfoResultModel.a());
        Unit r111 = Unit.INSTANCE;
        finishWithResult(r110);
        return;
    L18:
        if (r104.f57384d != IntroduceCardType.PROP.getType()) goto L29;
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == false) goto L29;
        GetGameCPCurrentExplainPropInfoResultModel r112 = new GetGameCPCurrentExplainPropInfoResultModel();
        r112.a(GetGameCPCurrentExplainPropInfoResultModel.Code.Success);
        GetGameCPCurrentExplainPropInfoResultModel.a r113 = new GetGameCPCurrentExplainPropInfoResultModel.a();
        com.bytedance.android.gamecp.host_api.model.introducecard.m r114 = r104.f57388h;
        if (r114 == null) goto L24;
        String r115 = r114.propId;
    L25:
        r113.a(r115);
        com.bytedance.android.gamecp.host_api.model.introducecard.m r116 = r104.f57388h;
        if (r116 == null) goto L28;
        r103 = r116.propName;
    L28:
        r113.b(r103);
        Unit r117 = Unit.INSTANCE;
        r112.b(r113);
        finishWithResult(r112);
        return;
    L24:
        r115 = null;
    L13:
        r108 = null;
        goto L14
    L15:
        r109 = null;
        goto L16
    L5:
        r104 = null;
        goto L6
    }
}
