package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getHijackDeviceInfo")
public final class e4 extends f0<JsonObject, GetHijackDeviceInfoResultModel> {

    public static final class a {
    }

    static {
    }

    public e4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xr.f r102 = (xr.f) xr.s.a(xr.f.class);
        Boolean r103 = null;
        if (r102 == null) goto L5;
        com.bytedance.android.gamecp.host_api.model.c r104 = r102.D1();
    L6:
        GetHijackDeviceInfoResultModel r105 = new GetHijackDeviceInfoResultModel();
        r105.a(GetHijackDeviceInfoResultModel.Code.Success);
        GetHijackDeviceInfoResultModel.a r106 = new GetHijackDeviceInfoResultModel.a();
        if (r104 == null) goto L9;
        String r107 = r104.a();
    L10:
        r106.a(r107);
        if (r104 == null) goto L13;
        Boolean r108 = Boolean.valueOf(r104.d());
    L14:
        r106.c(r108);
        if (r104 == null) goto L17;
        r103 = Boolean.valueOf(r104.c());
    L17:
        r106.b(r103);
        Unit r109 = Unit.INSTANCE;
        r105.b(r106);
        finishWithResult(r105);
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
