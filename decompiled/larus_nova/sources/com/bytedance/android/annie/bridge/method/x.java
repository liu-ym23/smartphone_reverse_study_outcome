package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getContainerID")
public final class x extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38849a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L6;
        this.f38849a = r101;
        return;
    }

    public x(IHybridComponent r100) {
        this.f38849a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r102 = new JSONObject();
        IHybridComponent r103 = this.f38849a;
        if (r103 == null) goto L6;
        String r104 = r103.containerId();
        if (r104 == null) goto L6;
    L7:
        r102.put("containerID", r104);
        r102.put("msg", "SUCCESS");
        finishWithResult(r102);
        return;
    L6:
        r104 = "";
        goto L7
    }
}
