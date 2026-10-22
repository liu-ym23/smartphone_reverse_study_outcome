package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/EnableMapVoiceGuidanceMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsEnableMapVoiceGuidanceIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsEnableMapVoiceGuidanceIDL$EnableVoiceParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsEnableMapVoiceGuidanceIDL$EnableVoiceResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnableMapVoiceGuidanceMethod extends AbsEnableMapVoiceGuidanceIDL {

    public static final class a {
    }

    static {
    }

    public EnableMapVoiceGuidanceMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsEnableMapVoiceGuidanceIDL.a r103 = (AbsEnableMapVoiceGuidanceIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = com.larus.navigation.api.c.f359656a;     // Catch: Exception -> L9
        com.larus.navigation.api.c.d("jsb_enable_voice", "handle: navigationId=" + r103.getNavigationId());     // Catch: Exception -> L9
        int r105 = com.larus.navigation.api.j.f359662a;     // Catch: Exception -> L9
        com.larus.navigation.api.j.a("flow.enableMapVoiceGuidance", "navigationId=" + r103.getNavigationId());     // Catch: Exception -> L9
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.enableMapVoiceGuidance] navigationId=" + r103.getNavigationId());     // Catch: Exception -> L9
        NavigationServiceDelegate r106 = NavigationServiceDelegate.f359630b;     // Catch: Exception -> L9
        if (r106.b() == true) goto L7;
        com.larus.navigation.api.c.d("jsb_enable_voice", "not navigating yet, no-op (default voice-on after start)");     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(AbsEnableMapVoiceGuidanceIDL.b.class, "<this>");     // Catch: Exception -> L9
        BaseModel r107 = k3.c.a(AbsEnableMapVoiceGuidanceIDL.b.class);     // Catch: Exception -> L9
        ((AbsEnableMapVoiceGuidanceIDL.b) r107).setSuccess(Boolean.TRUE);     // Catch: Exception -> L9
        r102.b((ResultModel) r107, "");     // Catch: Exception -> L9
    L12:
        return;
    L7:
        r106.e();     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(AbsEnableMapVoiceGuidanceIDL.b.class, "<this>");     // Catch: Exception -> L9
        BaseModel r108 = k3.c.a(AbsEnableMapVoiceGuidanceIDL.b.class);     // Catch: Exception -> L9
        ((AbsEnableMapVoiceGuidanceIDL.b) r108).setSuccess(Boolean.TRUE);     // Catch: Exception -> L9
        r102.b((ResultModel) r108, "");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        int r109 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("jsb_enable_voice", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.enableMapVoiceGuidance] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r110 = new StringBuilder("internal_error: ");
        r110.append(e.getMessage());
        f3.h.a.a(r102, r110.toString(), null, null, 14);
    }
}
