package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "preloadHeliumGame")
public final class j2 extends u0<q5, PreloadHeliumGameResultModel> {

    public static final class a {
    }

    static {
    }

    public j2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        q5 r102 = (q5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("preloadHeliumGame", GsonProtectorUtils.toJson(new Gson(), r102));
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);
        if (r103 == null) goto L7;
        xr.h r104 = r103.getGameService();
        if (r104 == null) goto L7;
        r104.preloadMiniGame(r102.a());
    L7:
        PreloadHeliumGameResultModel r105 = new PreloadHeliumGameResultModel();
        r105.a(PreloadHeliumGameResultModel.Code.Success);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
    }
}
