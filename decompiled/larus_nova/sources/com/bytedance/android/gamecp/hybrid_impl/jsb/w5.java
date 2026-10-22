package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "cg.registerTeamPlayRefundToast")
public final class w5 extends b<JsonObject, CgRegisterTeamPlayRefundToastResultModel> {

    public static final class a {
    }

    static {
    }

    public w5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.gamecp.host_api.a.b().getCloudGameService().E0();
        CgRegisterTeamPlayRefundToastResultModel r102 = new CgRegisterTeamPlayRefundToastResultModel();
        r102.a(CgRegisterTeamPlayRefundToastResultModel.Code.Success);
        Unit r103 = Unit.INSTANCE;
        finishWithResult(r102);
    }
}
