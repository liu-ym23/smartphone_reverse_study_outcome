package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "handleDetainmentDialog")
public final class o0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Context, Pair<String, String>> f142162a = null;

    public static final class a {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    static {
        f142162a = new WeakHashMap();
    }

    public o0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("room_id");
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        finishWithFailure();
        ALogger.e("DetainmentMethod", "id should`nt be null ");
    L12:
        int r106 = r102.optInt("action");
        String r107 = r102.optString("scene");
        if (r107 != null) goto L15;
    L16:
        r104 = true;
    L17:
        if (r104 == false) goto L19;
        finishWithFailure();
        ALogger.e("DetainmentMethod", "scene should`nt be null");
    L19:
        if (r106 != 0) goto L21;
        Pair<String, String> r108 = new Pair(r103, r107);
        f142162a.put(r101.getContext(), r108);
    L23:
        finishWithSuccess();
        return;
    L21:
        if (r106 != 1) goto L23;
        f142162a.remove(r101.getContext());
        goto L23
    L15:
        if (r107.length() != 0) goto L17;
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L10
    }
}
