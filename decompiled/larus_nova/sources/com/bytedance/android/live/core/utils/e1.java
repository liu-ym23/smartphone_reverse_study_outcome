package com.bytedance.android.live.core.utils;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.utils.e5;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e1 {
    static {
    }

    @JvmStatic
    public static final void a(Activity r100, String r101) {
        if (r100 == null) goto L4;
        int r102 = r100.getRequestedOrientation();
    L6:
        if (e5.m(r102) == false) goto L9;
        return;
    L9:
        if (((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).canShowPushPermissionGuide().booleanValue() == false) goto L23;
        if (r101 != null) goto L12;
        return;
    L12:
        if (com.bytedance.android.live.base.model.user.q0.a(r101) == false) goto L25;
        HashMap r103 = new HashMap();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L17
        com.bytedance.android.live.base.model.user.o0.f58946a.getClass();     // Catch: JSONException -> L17
        r104.put("int64_features", r105.put("event_author_id", com.bytedance.android.live.base.model.user.o0.a.f(r101)).toString());     // Catch: JSONException -> L17
        r104.put("enter_from", "live_follow");     // Catch: JSONException -> L17
    L19:
        r103.put("__need_pass_other_fields__", r104.toString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_after_live_follow", r103, new Object[0]);
        return;
    L17:
        e = move-exception;
        ALogger.e("LivePushPermissionHelper", e);
        goto L19
    L25:
        return;
    L23:
        return;
    L4:
        r102 = 1;
        goto L6
    }
}
