package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "sendPoiLog")
public final class y3 extends r<z3, SendPoiLogResultModel> {
    public y3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        z3 r101 = (z3) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r101.e();
        if (r102 == null) goto L8;
        HashMap r111 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.get(), r101.f(), new x3().getType());
        if (r111 != null) goto L7;
        r111 = new HashMap();
    L7:
        HashMap r103 = r111;
        TTLiveSDK.hostService().hostLiveLocalLife().sendPoiLog(r102, r103, r101.b(), r101.d(), r101.a(), r101.c());
    L8:
        SendPoiLogResultModel r104 = new SendPoiLogResultModel();
        r104.a(SendPoiLogResultModel.Code.Success);
        r104.b("success");
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r104);
    }
}
