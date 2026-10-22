package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpOpenAwemeDetail")
public final class u4 extends x<p3, q3> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        com.bytedance.android.gamecp.host_api.a.b().getHostBusiness().a();
    }

    public u4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        p3 r102 = (p3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamecpOpenAwemeDetail", GsonProtectorUtils.toJson(new Gson(), r102));
        com.bytedance.android.gamecp.common.utils.e1.a(r102);
        String r103 = com.bytedance.android.annie.api.data.subscribe.d.c(r102);
        com.bytedance.android.gamecp.host_api.a.b().getHostBusiness().i2(r102.a());
        ov.a r104 = com.bytedance.android.gamecp.host_api.a.b().getHostBusiness();
        r101.getContext();
        new JSONObject(r103);
        r104.u2();
    }
}
