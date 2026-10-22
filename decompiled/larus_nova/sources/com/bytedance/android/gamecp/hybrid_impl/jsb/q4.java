package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpLoadFeedsFlow")
public final class q4 extends v<n3, o3> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        com.bytedance.android.gamecp.host_api.a.b().getHostBusiness().U0();
    }

    public q4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        n3 r102 = (n3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamecpLoadFeedsFlow", GsonProtectorUtils.toJson(new Gson(), r102));
        r101.getContext();
        String r103 = com.bytedance.android.annie.api.data.subscribe.d.c(r102);
        ov.a r104 = com.bytedance.android.gamecp.host_api.a.b().getHostBusiness();
        r101.getContext();
        new JSONObject(r103);
        r104.N1();
    }
}
