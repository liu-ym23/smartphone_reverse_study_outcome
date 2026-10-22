package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RefreshActivityBannerNumberResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "refreshActivityBannerNumber")
public final class fa extends w20.d5<w20.ed, RefreshActivityBannerNumberResultModel> {
    public fa() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.ed r102 = (w20.ed) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r103 = r102.a();
        if (r103 == null) goto L6;
        b30.y r104 = new b30.y(r103.intValue());
        xs2.b.a().post(r104);
        return;
    }
}
