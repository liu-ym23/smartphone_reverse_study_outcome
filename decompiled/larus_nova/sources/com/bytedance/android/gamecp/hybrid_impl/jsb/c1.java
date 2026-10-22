package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "cancelGamePromoteDownload")
public final class c1 extends com.bytedance.android.gamecp.hybrid_impl.jsb.a<d1, CancelGamePromoteDownloadResultModel> {

    public static final class a {
    }

    static {
    }

    public c1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        d1 r102 = (d1) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("cancelGamePromoteDownload", GsonProtectorUtils.toJson(new Gson(), r102));
        JsonObject r103 = r102.a();
        if (r103 != null) goto L5;
        CancelGamePromoteDownloadResultModel r104 = new CancelGamePromoteDownloadResultModel();
        r104.a(CancelGamePromoteDownloadResultModel.Code.Failed);
        Unit r105 = Unit.INSTANCE;
        finishWithResult(r104);
        return;
    L5:
        xr.f r106 = (xr.f) xr.s.a(xr.f.class);
        if (r106 == null) goto L8;
        r106.cancelDownloadGame(r101.getContext(), r103);
    L8:
        CancelGamePromoteDownloadResultModel r107 = new CancelGamePromoteDownloadResultModel();
        r107.a(CancelGamePromoteDownloadResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}
