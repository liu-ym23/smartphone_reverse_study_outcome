package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "pixarActivityDidLoad")
public final class d3 extends com.bytedance.ies.web.jsbridge2.f<b30.u.a, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b30.u.a r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xs2.b.a().post(new b30.u());
        finishWithSuccess();
    }
}
