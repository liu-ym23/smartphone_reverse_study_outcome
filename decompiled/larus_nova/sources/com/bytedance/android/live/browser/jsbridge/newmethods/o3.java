package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfFinishLoadWithErrorResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "gcpLoadPerfFinishLoadWithError")
public final class o3 extends w20.z0<w20.f9, GcpLoadPerfFinishLoadWithErrorResultModel> {
    public o3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.f9 r102 = (w20.f9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostGameCP r103 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
        if (r103 == null) goto L5;
        IGameCPFmpMonitorService r104 = r103.getGameCPFmpMonitorService();
    L6:
        if (r104 == null) goto L8;
        r104.stopFmpTrack(String.valueOf(r102.b()), String.valueOf(r102.a()));
    L8:
        GcpLoadPerfFinishLoadWithErrorResultModel r105 = new GcpLoadPerfFinishLoadWithErrorResultModel();
        r105.a(GcpLoadPerfFinishLoadWithErrorResultModel.Code.Success);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
