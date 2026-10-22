package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "cancelLoading")
public final class e extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridFragment f38650a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridFragment r101 = (HybridFragment) r100.c(HybridFragment.class);
        if (r101 == null) goto L6;
        this.f38650a = r101;
        return;
    }

    public e(HybridFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridFragment");
        this.f38650a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        HybridFragment r102 = this.f38650a;
        if (r102 == null) goto L6;
        r102.cancelLoading();
        return;
    }
}
