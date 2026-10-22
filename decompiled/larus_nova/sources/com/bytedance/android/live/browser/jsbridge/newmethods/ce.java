package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastSdk.pull_down_height")
public final class ce extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JsonObject> {
    public ce() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JsonObject invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        JSONObject r103 = r102.optJSONObject("args");
        int r104 = 0;
        if (r103 == null) goto L5;
        r104 = r103.optInt(AppConstants.BUNDLE_PULL_DOWN_HEIGHT, 0);
    L5:
        xs2.b.a().post(new b30.a0(r104));
        return null;
    }
}
