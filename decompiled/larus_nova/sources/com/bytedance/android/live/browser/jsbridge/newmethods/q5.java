package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isBizEntryInHomeSideBar")
public final class q5 extends h<r5, IsBizEntryInHomeSideBarResultModel> {
    public q5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        r5 r102 = (r5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
        IsBizEntryInHomeSideBarResultModel r104 = new IsBizEntryInHomeSideBarResultModel();
        r104.a(Boolean.FALSE);
        Unit r105 = Unit.INSTANCE;
        finishWithResult(r104);
        return;
    L5:
        ((IHostAction) jc1.k.n(IHostAction.class)).businessInHomeSideBar(r103, new p5(this));
    }
}
