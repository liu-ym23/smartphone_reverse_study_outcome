package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "bindSourceParams")
public final class t0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    public static final class a {
    }

    static {
    }

    public t0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("sourceParams");
        LinkedHashMap r104 = new LinkedHashMap();
        ALogger.i("BindStarGraphMethod", String.valueOf(r103));
        if (TextUtils.isEmpty(r103) == false) goto L5;
        xs2.b.a().post(new b30.b0(r104));
        return new JSONObject();
    L5:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_star_task_selected), 0);
        JSONObject r105 = new JSONObject(r103);     // Catch: Throwable -> L13
        Iterator<String> r106 = r105.keys();     // Catch: Throwable -> L13
        if (r106 != null) goto L9;
    L11:
        xs2.b.a().post(new b30.b0(r104));     // Catch: Throwable -> L13
    L16:
        return new JSONObject();
    L9:
        if (r106.hasNext() == false) goto L11;
        String r107 = r106.next();     // Catch: Throwable -> L13
        r104.put(r107, r105.optString(r107, ""));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        ALogger.e("BindStarGraphMethod", "error: " + th);
        goto L16
    }
}
