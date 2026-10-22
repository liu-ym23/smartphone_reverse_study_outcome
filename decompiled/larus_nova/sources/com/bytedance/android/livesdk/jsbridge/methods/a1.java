package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "localLife.getPageBtm")
public final class a1 extends k<JsonObject, LocalLifeGetPageBtmResultModel> {
    public a1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostLiveLocalLife r102 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);
        if (r102 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r103 = r101.f249269d;
        if (r103 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        JsonObject r104 = r102.getPageBtmInfo(r103);
        LocalLifeGetPageBtmResultModel r105 = new LocalLifeGetPageBtmResultModel();
        r105.a(LocalLifeGetPageBtmResultModel.Code.Success);
        LocalLifeGetPageBtmResultModel.a r106 = new LocalLifeGetPageBtmResultModel.a();
        r106.a(r104);
        Unit r107 = Unit.INSTANCE;
        r105.b(r106);
        finishWithResult(r105);
    }
}
