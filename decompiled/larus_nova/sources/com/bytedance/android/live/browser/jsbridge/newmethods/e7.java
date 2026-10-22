package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.stopDiscoveryService")
public final class e7 extends m<f7, LiveStopDiscoveryServiceResultModel> {
    public e7() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        f7 r102 = (f7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        LiveStopDiscoveryServiceResultModel r105 = new LiveStopDiscoveryServiceResultModel();
        r105.a(LiveStopDiscoveryServiceResultModel.Code.Failed);
        r105.b("serviceType is null");
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L11:
        MdnsServiceManager r107 = MdnsServiceManager.f158767c;
        Context r108 = r101.getContext();
        String r109 = r102.a();
        Intrinsics.checkNotNull(r109);
        if (r107.c(r108, r109) == false) goto L14;
        LiveStopDiscoveryServiceResultModel r110 = new LiveStopDiscoveryServiceResultModel();
        r110.a(LiveStopDiscoveryServiceResultModel.Code.Success);
        Unit r111 = Unit.INSTANCE;
        finishWithResult(r110);
        return;
    L14:
        LiveStopDiscoveryServiceResultModel r112 = new LiveStopDiscoveryServiceResultModel();
        r112.a(LiveStopDiscoveryServiceResultModel.Code.Failed);
        r112.b("not found " + r102.a() + " service");
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }
}
