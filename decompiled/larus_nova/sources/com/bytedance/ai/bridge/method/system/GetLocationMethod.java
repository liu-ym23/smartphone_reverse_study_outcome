package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostLocationPermissionDepend;
import f2.k;
import f3.h;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "use doubao.getLocation")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetLocationMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL$GetLocationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL$GetLocationResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetLocationMethod extends AbsGetLocationMethodIDL {
    public GetLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetLocationMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r103 = r100.getOwnerActivity();
        if (r103 != null) goto L7;
        r103 = k.b();
        if (r103 != null) goto L7;
        h.a.a(r102, "context is null", null, null, 14);
        return;
    L7:
        IHostLocationPermissionDepend r104 = r4.a.f535980g;
        if (r104 != null) goto L10;
        h.a.a(r102, "LocationPermissionDepend is null", null, null, 14);
        return;
    L10:
        r104.requestPermission(r103, r100, this.f35932a, new a(r103, r102));
    }
}
