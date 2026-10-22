package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/GetMapSnapshotMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapSnapshotIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapSnapshotIDL$GetMapSnapshotParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapSnapshotIDL$GetMapSnapshotResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetMapSnapshotMethod extends AbsGetMapSnapshotIDL {

    public static final class a {
    }

    static {
    }

    public GetMapSnapshotMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetMapSnapshotIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        com.larus.navigation.api.j.a("flow.getMapNavigationSnapshot", "");     // Catch: Exception -> L12
        com.larus.navigation.api.g r103 = NavigationServiceDelegate.f359630b.l();     // Catch: Exception -> L12
        if (r103.f359659a != 2001) goto L6;
        com.larus.navigation.api.c.a("jsb_nav_snapshot", "NavigationService not available → SERVICE_UNAVAILABLE");     // Catch: Exception -> L12
    L6:
        int r104 = com.larus.navigation.api.c.f359656a;     // Catch: Exception -> L12
        StringBuilder r105 = new StringBuilder("[FE_IN/flow.getMapNavigationSnapshot] → code=");     // Catch: Exception -> L12
        r105.append(r103.f359659a);     // Catch: Exception -> L12
        r105.append(" snapshotLen=");     // Catch: Exception -> L12
        String r106 = r103.f359660b;     // Catch: Exception -> L12
        if (r106 == null) goto L9;
        int r107 = r106.length();     // Catch: Exception -> L12
    L10:
        r105.append(r107);     // Catch: Exception -> L12
        com.larus.navigation.api.c.d("nav_protocol_trace", r105.toString());     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(AbsGetMapSnapshotIDL.b.class, "<this>");     // Catch: Exception -> L12
        BaseModel r108 = k3.c.a(AbsGetMapSnapshotIDL.b.class);     // Catch: Exception -> L12
        AbsGetMapSnapshotIDL.b r109 = (AbsGetMapSnapshotIDL.b) r108;     // Catch: Exception -> L12
        r109.setCode(Integer.valueOf(r103.f359659a));     // Catch: Exception -> L12
        r109.setSnapshot(r103.f359660b);     // Catch: Exception -> L12
        r102.b((ResultModel) r108, "");     // Catch: Exception -> L12
        return;
    L9:
        r107 = 0;
    L12:
        e = move-exception;
        int r110 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("jsb_nav_snapshot", "handle error: type=".concat(e.getClass().getSimpleName()));
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.getMapNavigationSnapshot] type=".concat(e.getClass().getSimpleName()));
        f3.h.a.a(r102, "internal_error: " + e.getMessage(), null, null, 14);
    }
}
