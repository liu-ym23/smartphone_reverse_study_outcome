package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.p1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StopMapLocationMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapLocationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapLocationIDL$StopLocationParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapLocationIDL$StopLocationResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopMapLocationMethod extends AbsStopMapLocationIDL {

    public static final class a {
    }

    static {
    }

    public StopMapLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r110) {
        AbsStopMapLocationIDL.a r102 = (AbsStopMapLocationIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r103 = r102.getIdentifier();     // Catch: Exception -> L12
        int r104 = com.larus.navigation.api.j.f359662a;     // Catch: Exception -> L12
        com.larus.navigation.api.j.a("flow.stopMapLocation", "identifier=" + r103);     // Catch: Exception -> L12
        int r105 = com.larus.navigation.api.c.f359656a;     // Catch: Exception -> L12
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.stopMapLocation] identifier=" + r103);     // Catch: Exception -> L12
        com.larus.platform.service.m r106 = com.larus.platform.service.m.f365762a;     // Catch: Exception -> L12
        p1 r107 = com.larus.platform.service.m.i();     // Catch: Exception -> L12
        if (r107 != null) goto L8;
        com.larus.navigation.api.c.b("jsb_stop_location", "LocationService not available");     // Catch: Exception -> L12
        f3.h.a.a(r110, "location_service_not_available", null, null, 14);     // Catch: Exception -> L12
    L15:
        return;
    L8:
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r107.d(r103);     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(AbsStopMapLocationIDL.b.class, "<this>");     // Catch: Exception -> L12
        BaseModel r108 = k3.c.a(AbsStopMapLocationIDL.b.class);     // Catch: Exception -> L12
        ((AbsStopMapLocationIDL.b) r108).setSuccess(Boolean.TRUE);     // Catch: Exception -> L12
        r110.b((ResultModel) r108, "");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        int r109 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("jsb_stop_location", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.stopMapLocation] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r111 = new StringBuilder("internal_error: ");
        r111.append(e.getMessage());
        f3.h.a.a(r110, r111.toString(), null, null, 14);
    }
}
