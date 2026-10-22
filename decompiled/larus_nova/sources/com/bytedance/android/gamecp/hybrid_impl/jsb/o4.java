package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "isGameCPAppInstalled")
public final class o4 extends i0<p4, IsGameCPAppInstalledResultModel> {

    public static final class a {
    }

    static {
    }

    public o4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        p4 r102 = (p4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        Context r104 = r101.getContext();
        if (r103 != null) goto L5;
        String r105 = "";
    L6:
        n1.a("isGameCPAppInstalled", r105);
        boolean r106 = false;
        if (r103 != null) goto L9;
    L18:
        IsGameCPAppInstalledResultModel r107 = new IsGameCPAppInstalledResultModel();
        r107.a(IsGameCPAppInstalledResultModel.Code.Success);
        r107.b(Boolean.valueOf(r106));
        finishWithResult(r107);
        return;
    L9:
        if (r103.length() != 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L18;
        if (r104.getPackageManager().getPackageInfo(r103, 1) == null) goto L18;
        r106 = true;
        goto L18
    L11:
        r108 = false;
        goto L12
    L5:
        r105 = r103;
        goto L6
    }
}
