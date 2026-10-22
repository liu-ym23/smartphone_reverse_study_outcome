package com.bytedance.bdtracker;

import android.net.Uri;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.network.INetworkClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class q {
    public d a;

    public q(d appLogInstance) {
        Intrinsics.checkParameterIsNotNull(appLogInstance, "appLogInstance");
        this.a = appLogInstance;
    }

    public final m<k> a(String uri, l queryParam) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(queryParam, "queryParam");
        try {
            INetworkClient netClient = this.a.getNetClient();
            z3 z3Var = this.a.k;
            Intrinsics.checkExpressionValueIsNotNull(z3Var, "appLogInstance.api");
            byte[] bArrExecute = netClient.execute((byte) 0, z3Var.c.a(a(uri, queryParam.a())), null, a(), (byte) 0, true, 60000);
            Intrinsics.checkExpressionValueIsNotNull(bArrExecute, "appLogInstance.netClient…TIMEOUT\n                )");
            return m.c.a(new String(bArrExecute, Charsets.UTF_8), k.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String a(String str, JSONObject jSONObject) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if (strOptString != null && strOptString.length() != 0) {
                builderBuildUpon.appendQueryParameter(next, jSONObject.optString(next));
            }
        }
        return builderBuildUpon.build().toString();
    }

    public final HashMap<String, String> a() {
        HashMap map = new HashMap(2);
        InitConfig initConfig = this.a.getInitConfig();
        if (initConfig != null) {
            Map<String, String> httpHeaders = initConfig.getHttpHeaderCallback() != null ? initConfig.getHttpHeaderCallback().get() : initConfig.getHttpHeaders();
            if (httpHeaders != null && !httpHeaders.isEmpty()) {
                map.putAll(httpHeaders);
            }
        }
        return g5.a((HashMap<String, String>) map, this.a);
    }

    public final m<n> a(String uri, o request, l queryParam) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(queryParam, "queryParam");
        JSONObject request2 = request.a();
        JSONObject queryParam2 = queryParam.a();
        Intrinsics.checkParameterIsNotNull(this, "$this$notifyDeferDeepLink");
        Intrinsics.checkParameterIsNotNull(request2, "request");
        Intrinsics.checkParameterIsNotNull(queryParam2, "queryParam");
        try {
            this.a.D.debug("Notify DeferDeepLink trigger.", new Object[0]);
            EventBus eventBus = EventBus.global.get(new Object[0]);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request", request2);
            jSONObject.put("queryParam", queryParam2);
            eventBus.emit("ALink_DeferDeepLink_App_Log", jSONObject);
        } catch (Exception e) {
            this.a.D.error("Notify DeferDeepLink trigger failed.", e, new Object[0]);
        }
        try {
            INetworkClient netClient = this.a.getNetClient();
            z3 z3Var = this.a.k;
            Intrinsics.checkExpressionValueIsNotNull(z3Var, "appLogInstance.api");
            byte[] bArrExecute = netClient.execute((byte) 1, z3Var.c.a(a(uri, queryParam2)), request2, a(), (byte) 0, true, 60000);
            Intrinsics.checkExpressionValueIsNotNull(bArrExecute, "appLogInstance.netClient…OUT\n                    )");
            return m.c.a(new String(bArrExecute, Charsets.UTF_8), n.class);
        } catch (Throwable th) {
            return m.c.a(th);
        }
    }
}
