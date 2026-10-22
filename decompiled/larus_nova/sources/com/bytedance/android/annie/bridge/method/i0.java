package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = com.alipay.sdk.m.x.d.f25925o)
public final class i0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridFragment f38663a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridFragment r101 = (HybridFragment) r100.c(HybridFragment.class);
        if (r101 == null) goto L6;
        this.f38663a = r101;
        return;
    }

    public i0(HybridFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridFragment");
        this.f38663a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("title");
        HybridFragment r104 = this.f38663a;
        if (r104 == null) goto L5;
        r104.setHybridTitle(r103);
    L5:
        finishWithResult(null);
    }
}
