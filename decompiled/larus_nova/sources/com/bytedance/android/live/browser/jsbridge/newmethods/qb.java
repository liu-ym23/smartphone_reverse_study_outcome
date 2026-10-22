package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendAdLog")
public final class qb extends w20.u5<w20.xd, w20.yd> {

    public static final class a {
    }

    static {
    }

    public qb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.xd r112 = (w20.xd) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        w20.yd r113 = new w20.yd();
        JsonObject r100 = new JsonObject();
        String r101 = r112.b();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        r113.a(1);
        r100.addProperty("error_msg", "creative_id is invalid");
        r113.b(r100);
        finishWithResult(r113);
        return;
    L12:
        HashMap r103 = new HashMap();
        r103.put("value", r112.b());
        r103.put("log_extra", r112.f());
        if (r112.c() != null) goto L36;
    L21:
        ILiveDouPlusService r104 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        String r105 = r112.h();
        String r106 = r112.e();
        HashMap r107 = new HashMap();
        if (TextUtils.isEmpty(r112.g()) == true) goto L25;
        r107.put("refer", r112.g());
    L25:
        if (TextUtils.isEmpty(r112.a()) == true) goto L28;
        r107.put("category", r112.a());
    L28:
        if (TextUtils.isEmpty(r112.d()) == true) goto L30;
        r107.put("ext_value", r112.d());
    L30:
        Unit r114 = Unit.INSTANCE;
        if (r103.isEmpty() == true) goto L34;
        r107.putAll(r103);
    L34:
        r104.logEvent(true, r105, r106, r107);
        r113.a(1);
        r100.addProperty("error_msg", "success");
        r113.b(r100);
        finishWithResult(r113);
        return;
    L36:
        JSONObject r108 = tv5.a.a(GsonHelper.get(), r112.c());     // Catch: Exception -> L19
        Iterator<String> r109 = r108.keys();     // Catch: Exception -> L19
    L16:
        if (r109.hasNext() == false) goto L21;
        String r115 = r109.next();     // Catch: Exception -> L19
        r103.put(r115, r108.get(r115).toString());     // Catch: Exception -> L19
    L19:
        e = move-exception;
        ALogger.d("Live-SendAdLogMethod", String.valueOf(e.getMessage()));
        goto L21
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
