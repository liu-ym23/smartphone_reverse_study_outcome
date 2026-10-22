package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "pixActivity")
public final class c3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public c3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("type");
        if (r103 == null) goto L27;
        int r104 = r103.hashCode();
        if (r104 == (-1157320344)) goto L25;
        if (r104 == (-672946791)) goto L16;
        if (r104 != 772280203) goto L27;
        if (r103.equals("take_off_pix_prop") == false) goto L27;
        xs2.b.a().post(new b30.w());
        finishWithSuccess();
        return;
    L16:
        if (r103.equals("start_random_link") == false) goto L27;
        if (r102.has("args") == false) goto L20;
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r102, "args");
    L21:
        if (r105 == null) goto L23;
        boolean r106 = r105.optBoolean("is_pix_activity", false);
        xs2.b.a().post(new b30.v(r106));
        finishWithSuccess();
        return;
    L23:
        finishWithFailure();
        return;
    L20:
        r105 = null;
        goto L21
    L25:
        if (r103.equals("open_pix_activity_h5") == false) goto L27;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r107 = com.bytedance.android.livesdk.sharedpref.b.H2;
        Boolean r108 = Boolean.TRUE;
        r107.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r107, r108);
        finishWithSuccess();
        return;
    L27:
        finishWithFailure();
    }
}
