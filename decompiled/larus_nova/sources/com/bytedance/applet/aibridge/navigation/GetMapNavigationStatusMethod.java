package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/GetMapNavigationStatusMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapNavigationStatusIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapNavigationStatusIDL$GetNavStatusParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapNavigationStatusIDL$GetNavStatusResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetMapNavigationStatusMethod extends AbsGetMapNavigationStatusIDL {

    public static final class a {
    }

    static {
    }

    public GetMapNavigationStatusMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetMapNavigationStatusIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        NavigationServiceDelegate r103 = NavigationServiceDelegate.f359630b;     // Catch: Exception -> L5
        boolean r104 = r103.b();     // Catch: Exception -> L5
        int r105 = com.larus.navigation.api.c.f359656a;     // Catch: Exception -> L5
        com.larus.navigation.api.c.d("jsb_nav_status", "handle: isNavigating=" + r104);     // Catch: Exception -> L5
        com.larus.navigation.api.j.a("flow.getMapNavigationStatus", "");     // Catch: Exception -> L5
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.getMapNavigationStatus] (no params) → isNavigating=" + r104);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(AbsGetMapNavigationStatusIDL.b.class, "<this>");     // Catch: Exception -> L5
        BaseModel r106 = k3.c.a(AbsGetMapNavigationStatusIDL.b.class);     // Catch: Exception -> L5
        AbsGetMapNavigationStatusIDL.b r107 = (AbsGetMapNavigationStatusIDL.b) r106;     // Catch: Exception -> L5
        r107.setNavigating(Boolean.valueOf(r104));     // Catch: Exception -> L5
        r107.setNavigationId(r103.c());     // Catch: Exception -> L5
        r107.setVoiceGuidanceEnabled(Boolean.valueOf(r103.h()));     // Catch: Exception -> L5
        r102.b((ResultModel) r106, "");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        int r108 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("jsb_nav_status", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.getMapNavigationStatus] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r109 = new StringBuilder("internal_error: ");
        r109.append(e.getMessage());
        f3.h.a.a(r102, r109.toString(), null, null, 14);
    }
}
