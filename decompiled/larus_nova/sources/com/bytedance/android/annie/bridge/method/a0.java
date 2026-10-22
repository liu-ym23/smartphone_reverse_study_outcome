package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.GetCurrentTimeResultModel;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast", name = "getCurrentTimeSaas")
public final class a0 extends e7.g<JsonObject, GetCurrentTimeResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38503a = 0;

    public static final class a {
    }

    static {
    }

    public a0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r102 = p6.b();
        if (r102 == 0) goto L5;
        GetCurrentTimeResultModel r103 = new GetCurrentTimeResultModel();
        r103.a(GetCurrentTimeResultModel.Code.Success);
        GetCurrentTimeResultModel.a r104 = new GetCurrentTimeResultModel.a();
        r104.a(Long.valueOf(r102));
        Unit r105 = Unit.INSTANCE;
        r103.b(r104);
        finishWithResult(r103);
        return;
    L5:
        JSONObject r106 = new JSONObject();
        r106.put("code", 0);
        Unit r107 = Unit.INSTANCE;
        finishWithRawResult(r106);
    }
}
