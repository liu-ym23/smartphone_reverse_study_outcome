package com.bytedance.android.shopping.store.utils;

import com.bytedance.pitaya.api.PTYMessageHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/store/utils/ECShopProductListPitayaManager$registerPitaya$1$1", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "Lorg/json/JSONObject;", "message", "onMessage", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopProductListPitayaManager$registerPitaya$1$1 implements PTYMessageHandler {
    public ECShopProductListPitayaManager$registerPitaya$1$1() {
    }

    @Override // com.bytedance.pitaya.api.PTYMessageHandler
    public JSONObject onMessage(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        JSONObject r101 = new JSONObject();
        r101.put("is_ready", 1);
        return r101;
    }
}
