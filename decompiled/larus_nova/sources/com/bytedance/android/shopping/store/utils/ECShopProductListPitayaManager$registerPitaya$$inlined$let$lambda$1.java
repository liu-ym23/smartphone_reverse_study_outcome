package com.bytedance.android.shopping.store.utils;

import com.bytedance.pitaya.api.PTYMessageHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/bytedance/android/shopping/store/utils/ECShopProductListPitayaManager$registerPitaya$1$2", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "onMessage", "Lorg/json/JSONObject;", "message", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopProductListPitayaManager$registerPitaya$$inlined$let$lambda$1 implements PTYMessageHandler {
    final /* synthetic */ Function1 $handler$inlined;

    public ECShopProductListPitayaManager$registerPitaya$$inlined$let$lambda$1(Function1 r100) {
        this.$handler$inlined = r100;
    }

    @Override // com.bytedance.pitaya.api.PTYMessageHandler
    public JSONObject onMessage(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.$handler$inlined.invoke(r100);
        return new JSONObject();
    }
}
