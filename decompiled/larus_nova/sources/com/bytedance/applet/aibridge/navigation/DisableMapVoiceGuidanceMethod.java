package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/DisableMapVoiceGuidanceMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsDisableMapVoiceGuidanceIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsDisableMapVoiceGuidanceIDL$DisableVoiceParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsDisableMapVoiceGuidanceIDL$DisableVoiceResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisableMapVoiceGuidanceMethod extends AbsDisableMapVoiceGuidanceIDL {

    public static final class a {
    }

    static {
    }

    public DisableMapVoiceGuidanceMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsDisableMapVoiceGuidanceIDL.a r103 = (AbsDisableMapVoiceGuidanceIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = com.larus.navigation.api.c.f359656a;     // Catch: Exception -> L9
        com.larus.navigation.api.c.d("jsb_disable_voice", "handle: navigationId=" + r103.getNavigationId());     // Catch: Exception -> L9
        int r105 = com.larus.navigation.api.j.f359662a;     // Catch: Exception -> L9
        com.larus.navigation.api.j.a("flow.disableMapVoiceGuidance", "navigationId=" + r103.getNavigationId());     // Catch: Exception -> L9
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.disableMapVoiceGuidance] navigationId=" + r103.getNavigationId());     // Catch: Exception -> L9
        NavigationServiceDelegate r106 = NavigationServiceDelegate.f359630b;     // Catch: Exception -> L9
        if (r106.b() == true) goto L7;
        com.larus.navigation.api.c.d("jsb_disable_voice", "not navigating yet, no-op");     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(AbsDisableMapVoiceGuidanceIDL.b.class, "<this>");     // Catch: Exception -> L9
        BaseModel r107 = k3.c.a(AbsDisableMapVoiceGuidanceIDL.b.class);     // Catch: Exception -> L9
        ((AbsDisableMapVoiceGuidanceIDL.b) r107).setSuccess(Boolean.TRUE);     // Catch: Exception -> L9
        r102.b((ResultModel) r107, "");     // Catch: Exception -> L9
    L12:
        return;
    L7:
        r106.m();     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(AbsDisableMapVoiceGuidanceIDL.b.class, "<this>");     // Catch: Exception -> L9
        BaseModel r108 = k3.c.a(AbsDisableMapVoiceGuidanceIDL.b.class);     // Catch: Exception -> L9
        ((AbsDisableMapVoiceGuidanceIDL.b) r108).setSuccess(Boolean.TRUE);     // Catch: Exception -> L9
        r102.b((ResultModel) r108, "");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        int r109 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("jsb_disable_voice", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.disableMapVoiceGuidance] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r110 = new StringBuilder("internal_error: ");
        r110.append(e.getMessage());
        f3.h.a.a(r102, r110.toString(), null, null, 14);
    }
}
