package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RequestPinWidgetResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "requestPinWidget")
public final class eb extends w20.k5<w20.kd, RequestPinWidgetResultModel> {
    public eb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.kd r102 = (w20.kd) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostBusiness r103 = (IHostBusiness) jc1.k.n(IHostBusiness.class);
        Integer r104 = r102.b();
        if (r104 != null) goto L6;
    L8:
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.intValue() != 2) goto L15;
        r103.updateAppWidget(r101.getContext(), r102.a());
        return;
    L15:
        return;
    L6:
        if (r104.intValue() != 1) goto L8;
        r103.requestPinWidget(r101.getContext(), r102.a());
    }
}
