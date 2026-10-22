package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openGameRankPromotePanel")
public final class z4 extends n0<b5, OpenGameRankPromotePanelResultModel> {

    public static final class a {
    }

    static {
    }

    public z4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        b5 r102 = (b5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("openGameRankPromotePanel", GsonProtectorUtils.toJson(new Gson(), r102));
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);
        if (r103 == null) goto L9;
        Context r104 = r101.getContext();
        String r105 = r102.a();
        if (r105 != null) goto L7;
        r105 = "rank";
    L7:
        r103.d1(r104, r105, new a5(this));
        return;
    }
}
