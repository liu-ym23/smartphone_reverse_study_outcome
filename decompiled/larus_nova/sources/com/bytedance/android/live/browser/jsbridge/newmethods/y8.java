package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenPanelInRoomResultModel;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPanelInRoom")
public final class y8 extends w20.r4<w20.qc, OpenPanelInRoomResultModel> {
    public y8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.qc r102 = (w20.qc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IPaidOuterService r103 = (IPaidOuterService) jc1.k.f(IPaidOuterService.class);
        if (r103 == null) goto L6;
        r103.openPanelInRoom(r102.a());
        return;
    }
}
