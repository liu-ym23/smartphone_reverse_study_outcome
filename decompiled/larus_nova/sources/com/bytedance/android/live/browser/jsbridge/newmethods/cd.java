package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "startAnimationEvent")
public final class cd extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public cd() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = JSONObjectProtectorUtils.getString(r102, "key");
        if (TextUtils.isEmpty(r103) == true) goto L5;
        b30.e0 r104 = new b30.e0(r103);
        xs2.b.a().post(r104);
    L5:
        finishWithSuccess();
    }
}
