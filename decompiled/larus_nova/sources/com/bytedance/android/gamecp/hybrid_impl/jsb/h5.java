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
@XBridgeMethod(biz = "webcast", name = "performGamePromoteDownloadAction")
public final class h5 extends r0<i5, PerformGamePromoteDownloadActionResultModel> {

    public static final class a {
    }

    static {
    }

    public h5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        i5 r102 = (i5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("performGamePromoteDownloadAction", GsonProtectorUtils.toJson(new Gson(), r102));
        JsonObject r103 = r102.a();
        JsonObject r104 = r102.a();     // Catch: AssertionError -> L9
        if (r104 == null) goto L6;
        String r105 = r104.toString();     // Catch: AssertionError -> L9
    L7:
        yr.b.b(4, "GamePromoteDownload", String.valueOf(r105));     // Catch: AssertionError -> L9
    L11:
        if (r103 != null) goto L13;
        PerformGamePromoteDownloadActionResultModel r106 = new PerformGamePromoteDownloadActionResultModel();
        r106.a(PerformGamePromoteDownloadActionResultModel.Code.Failed);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        yr.b.b(4, "GamePromoteDownload", r103 + " failed");
        return;
    L13:
        xr.f r108 = (xr.f) xr.s.a(xr.f.class);
        if (r108 == null) goto L18;
        xr.b r109 = r108.p1();
        if (r109 == null) goto L18;
        r109.X0(r101.getContext(), r103, null);
    L18:
        PerformGamePromoteDownloadActionResultModel r110 = new PerformGamePromoteDownloadActionResultModel();
        r110.a(PerformGamePromoteDownloadActionResultModel.Code.Success);
        Unit r111 = Unit.INSTANCE;
        finishWithResult(r110);
        return;
    L6:
        r105 = null;
    L9:
        e = move-exception;
        yr.b.b(4, "GamePromoteDownload", String.valueOf(e.getMessage()));
        goto L11
    }
}
