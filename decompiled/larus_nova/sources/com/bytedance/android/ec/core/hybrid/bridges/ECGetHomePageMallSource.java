package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECGetHomePageMallSource;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetHomePageMallSource extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ec.getHomePageMallSource";
    }

    public ECGetHomePageMallSource() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        JSONObject r102 = new JSONObject();
        r102.put("code", 1);     // Catch: JSONException -> L9
        int r103 = ECSdk.f48106a;     // Catch: JSONException -> L9
        s83.g r104 = (s83.g) ECSdk.a(s83.g.class);     // Catch: JSONException -> L9
        if (r104 == null) goto L6;
        Integer r105 = Integer.valueOf(r104.getHomePageMallSource());     // Catch: JSONException -> L9
    L7:
        r102.put("mallSourceType", r105);     // Catch: JSONException -> L9
        r101.a(r102);     // Catch: JSONException -> L9
        return;
    L6:
        r105 = null;
    L9:
        e = move-exception;
        r102.put("code", 0);
        r102.put("msg", e.getMessage());
        r101.a(r102);
        ECExceptionMonitor.e(e);
    }
}
