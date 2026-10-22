package com.bytedance.android.ec.common.impl.hybrid.bridges;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/GetSearchHistoryMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetSearchHistoryMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "getSearchHistory";
    }

    public GetSearchHistoryMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        boolean r102 = ECServiceManager.f42805a;
        JSONObject r103 = ((g) ECServiceManager.c(g.class)).f(r100);
        if (r103 == null) goto L5;
        r101.a(r103);
        return;
    L5:
        r101.onFailed(0, "data parse failed");
    }
}
