package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CheckWidgetInstallationResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "checkWidgetInstallation")
public final class y1 extends w20.t<w20.d8, CheckWidgetInstallationResultModel> {
    public y1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.d8 r102 = (w20.d8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostBusiness r103 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        CheckWidgetInstallationResultModel r104 = new CheckWidgetInstallationResultModel();
        r104.b(new CheckWidgetInstallationResultModel.a());
        CheckWidgetInstallationResultModel.a r105 = r104.a();
        if (r105 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        r105.a(Boolean.valueOf(r103.checkIfAppWidgetInstalled(r102.a())));
    L5:
        finishWithResult(r104);
    }
}
