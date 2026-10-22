package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.l5;
import w20.ld;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "resumeGuestBattle")
public final class d1 extends l5<JsonObject, ld> {
    public d1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r103 = MultiRevenueDataContext.a.a();
        if (r103 == null) goto L6;
        r103.d0(ji0.e.f499165b, r102);
        return;
    }
}
