package com.bytedance.android.ec.hybrid.card.bridge;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.hybrid.bridge.b {

    public static final class a {
    }

    static {
    }

    public b() {
        super("ec.publishEventToLive");
    }

    @Override // com.bytedance.android.ec.hybrid.bridge.b
    public final Pair<Boolean, String> a(IBDXBridgeContext r100, Map<String, ? extends Object> r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "result");
        JSONObject r103 = new JSONObject(r101);
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        if (r104 == null) goto L11;
        yj.f r105 = r104.getHybridECSdkService();
        if (r105 == null) goto L11;
        String r106 = r103.optString("eventName");
        JSONObject r107 = r103.optJSONObject("params");
        if (r107 != null) goto L9;
        r107 = new JSONObject();
    L9:
        r105.a(r106, r107);
    L11:
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
