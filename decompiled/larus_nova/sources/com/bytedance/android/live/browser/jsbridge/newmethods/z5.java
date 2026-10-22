package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.LiveCloseProfileResultModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.closeProfile")
public final class z5 extends me7.a<me7.k, LiveCloseProfileResultModel> {
    public z5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        me7.k r102 = (me7.k) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xs2.b r103 = xs2.b.a();
        Boolean r104 = r102.a();
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        r103.post(new ps0.a(r105));
        finishWithSuccess();
        return;
    L5:
        r105 = false;
        goto L6
    }
}
