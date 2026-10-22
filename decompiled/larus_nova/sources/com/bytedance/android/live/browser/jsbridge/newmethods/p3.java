package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfLoadResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "gcpLoadPerfLoad")
public final class p3 extends w20.a1<w20.g9, GcpLoadPerfLoadResultModel> {
    public p3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.g9 r102 = (w20.g9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostGameCP r103 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
        if (r103 == null) goto L5;
        IGameCPFmpMonitorService r104 = r103.getGameCPFmpMonitorService();
    L7:
        if (Intrinsics.areEqual(r102.a(), GearStrategyConsts.EV_SELECT_BEGIN) == false) goto L11;
        if (r104 == null) goto L14;
        r104.markActionStart(String.valueOf(r102.c()), r102.b() + '_' + r102.a(), r102.b() + "_duration", Intrinsics.areEqual(r102.d(), Boolean.TRUE));
    L14:
        GcpLoadPerfLoadResultModel r105 = new GcpLoadPerfLoadResultModel();
        r105.a(GcpLoadPerfLoadResultModel.Code.Success);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L11:
        if (Intrinsics.areEqual(r102.a(), "end") == false) goto L14;
        if (r104 == null) goto L14;
        r104.markActionEnd(String.valueOf(r102.c()), r102.b() + '_' + r102.a());
        goto L14
    L5:
        r104 = null;
        goto L7
    }
}
