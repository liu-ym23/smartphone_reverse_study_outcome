package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getGameCPReserveStatus")
public final class b4 extends e0<c4, GetGameCPReserveStatusResultModel> {

    public static final class a {
    }

    static {
    }

    public b4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        c4 r102 = (c4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("getGameCPReserveStatus", GsonProtectorUtils.toJson(new Gson(), r102));
        GetGameCPReserveStatusResultModel.a r103 = new GetGameCPReserveStatusResultModel.a();
        xr.f r104 = (xr.f) xr.s.a(xr.f.class);
        if (r104 == null) goto L5;
        Number r105 = r104.getGameReserveStatus(r102.a());
    L6:
        r103.a(r105);
        GetGameCPReserveStatusResultModel r106 = new GetGameCPReserveStatusResultModel();
        r106.a(GetGameCPReserveStatusResultModel.Code.Success);
        r106.b(r103);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
