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
@XBridgeMethod(biz = "webcast", name = "unRegisterGamePromoteDownload")
public final class a6 extends y0<b6, UnRegisterGamePromoteDownloadResultModel> {

    public static final class a {
    }

    static {
    }

    public a6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        b6 r102 = (b6) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("unRegisterGamePromoteDownload", GsonProtectorUtils.toJson(new Gson(), r102));
        JsonObject r103 = r102.a();
        if (r103 != null) goto L5;
        UnRegisterGamePromoteDownloadResultModel r104 = new UnRegisterGamePromoteDownloadResultModel();
        r104.a(UnRegisterGamePromoteDownloadResultModel.Code.Failed);
        Unit r105 = Unit.INSTANCE;
        finishWithResult(r104);
        return;
    L5:
        xr.f r106 = (xr.f) xr.s.a(xr.f.class);
        if (r106 == null) goto L8;
        r101.getContext();
        r106.N0(r103);
    L8:
        UnRegisterGamePromoteDownloadResultModel r107 = new UnRegisterGamePromoteDownloadResultModel();
        r107.a(UnRegisterGamePromoteDownloadResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}
