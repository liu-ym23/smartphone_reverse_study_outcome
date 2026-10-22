package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.hybrid.utils.p;
import com.bytedance.android.ec.core.hybrid.utils.q;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/GetOrderPrefetchDataMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetOrderPrefetchDataMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "getOrderPrefetchData";
    }

    public GetOrderPrefetchDataMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("requestId");
        JSONObject r103 = p.f44324a;
        Intrinsics.checkNotNullParameter(r102, "requestId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Map<String, q> r104 = p.f44333j;
        if (r104.containsKey(r102) == false) goto L11;
        q r105 = r104.remove(r102);
        if (r105 != null) goto L7;
        p.f44334k.put(r102, r101);
        return;
    L7:
        int r106 = r105.f44336b;
        if (r106 != 1) goto L10;
        p.f(r105, r101);
        return;
    L10:
        p.b(r106, r101);
        return;
    L11:
        p.b(3, r101);
    }
}
