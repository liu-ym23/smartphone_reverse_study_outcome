package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setSideslip")
public final class h2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridFragment f38660a;

    public h2(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridFragment r101 = (HybridFragment) r100.c(HybridFragment.class);
        if (r101 == null) goto L6;
        this.f38660a = r101;
        return;
    }

    public h2(HybridFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridFragment");
        this.f38660a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("forbid_right_back", "");
        if (Intrinsics.areEqual(r103, "0") == false) goto L8;
        HybridFragment r104 = this.f38660a;
        if (r104 == null) goto L13;
        r104.setCloseByGesture(true);
    L13:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r103, "1") == false) goto L13;
        HybridFragment r105 = this.f38660a;
        if (r105 == null) goto L13;
        r105.setCloseByGesture(false);
        goto L13
    }
}
