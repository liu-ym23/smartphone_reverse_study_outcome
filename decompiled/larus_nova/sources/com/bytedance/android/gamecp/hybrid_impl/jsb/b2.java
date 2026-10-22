package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openExternalBrowser")
public final class b2 extends l0<x4, OpenExternalBrowserResultModel> {

    public static final class a {
    }

    static {
    }

    public b2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        x4 r102 = (x4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("openExternalBrowser", GsonProtectorUtils.toJson(new Gson(), r102));
        String r103 = r102.b();
        if (r103 == null) goto L11;
        String r104 = r102.a();
        if (r104 == null) goto L11;
        xr.f r105 = (xr.f) xr.s.a(xr.f.class);
        if (r105 == null) goto L11;
        xr.h r106 = r105.getGameService();
        if (r106 == null) goto L11;
        r106.openExternalBrowser(r101.getContext(), r103, r104);
    L11:
        OpenExternalBrowserResultModel r107 = new OpenExternalBrowserResultModel();
        r107.a(OpenExternalBrowserResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}
