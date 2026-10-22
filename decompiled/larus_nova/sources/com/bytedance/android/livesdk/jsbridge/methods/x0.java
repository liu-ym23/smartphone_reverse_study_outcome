package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getLiveLifeCouponInfo")
public final class x0 extends d<y0, GetLiveLifeCouponInfoResultModel> {
    public x0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((y0) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetLiveLifeCouponInfoResultModel r102 = new GetLiveLifeCouponInfoResultModel();
        IHostLiveLocalLife r103 = TTLiveSDK.hostService().hostLiveLocalLife();
        List<Object> r104 = null;
        if (r103 == null) goto L5;
        List<Object> r105 = r103.getInvalidCouponInfo();
    L6:
        if (r103 == null) goto L8;
        r104 = r103.getFullCouponInfo();
    L8:
        GetLiveLifeCouponInfoResultModel.a r106 = new GetLiveLifeCouponInfoResultModel.a();
        r106.b(r105);
        r106.a(r104);
        r102.a(GetLiveLifeCouponInfoResultModel.Code.Success);
        r102.b(r106);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r102);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
