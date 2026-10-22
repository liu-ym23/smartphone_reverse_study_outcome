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
@XBridgeMethod(biz = "webcast", name = "localLife.getBcmChain")
public final class w0 extends j<u1, LocalLifeGetBcmChainResultModel> {
    public w0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        u1 r102 = (u1) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostLiveLocalLife r103 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);
        if (r103 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r104 = r101.f249269d;
        if (r104 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        Integer r105 = r102.a();
        if (r105 == null) goto L11;
        int r106 = r105.intValue();
    L12:
        Boolean r107 = r102.b();
        if (r107 == null) goto L15;
        boolean r108 = r107.booleanValue();
    L16:
        JsonObject r109 = r103.getBcmChain(r104, r106, r108);
        LocalLifeGetBcmChainResultModel r110 = new LocalLifeGetBcmChainResultModel();
        r110.a(LocalLifeGetBcmChainResultModel.Code.Success);
        LocalLifeGetBcmChainResultModel.a r111 = new LocalLifeGetBcmChainResultModel.a();
        r111.a(r109);
        Unit r112 = Unit.INSTANCE;
        r110.b(r111);
        finishWithResult(r110);
        return;
    L15:
        r108 = false;
        goto L16
    L11:
        r106 = 20;
        goto L12
    }
}
