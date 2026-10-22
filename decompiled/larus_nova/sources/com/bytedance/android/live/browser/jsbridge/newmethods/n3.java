package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfAddExtraParamsResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "gcpLoadPerfAddExtraParams")
public final class n3 extends w20.y0<w20.e9, GcpLoadPerfAddExtraParamsResultModel> {
    public n3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.e9 r102 = (w20.e9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostGameCP r103 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
        if (r103 == null) goto L5;
        IGameCPFmpMonitorService r104 = r103.getGameCPFmpMonitorService();
    L6:
        JsonObject r105 = r102.a();
        if (r105 == null) goto L22;
        Set<String> r106 = r105.keySet();
        if (r106 == null) goto L22;
        Iterator<T> r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L22;
        String r108 = (String) r107.next();
        if (r104 == null) goto L12;
        String r109 = String.valueOf(r102.b());
        JsonObject r110 = r102.a();
        if (r110 == null) goto L20;
        JsonElement r111 = r110.get(r108);
        if (r111 == null) goto L20;
        String r112 = r111.toString();
    L21:
        r104.addTrackExtra(r109, r108, r112);
    L20:
        r112 = null;
    L22:
        GcpLoadPerfAddExtraParamsResultModel r113 = new GcpLoadPerfAddExtraParamsResultModel();
        r113.a(GcpLoadPerfAddExtraParamsResultModel.Code.Success);
        Unit r114 = Unit.INSTANCE;
        finishWithResult(r113);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
