package com.bytedance.android.ec.store.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/store/setting/i;", "", "Lcom/bytedance/android/ec/store/setting/c;", "enterShopSceneConfig", "Lcom/bytedance/android/ec/store/setting/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/store/setting/c;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("enter_shop_scene")
    private final c enterShopSceneConfig;

    public i() {
        this(0);
    }

    public final c a() {
        return this.enterShopSceneConfig;
    }

    public i(int r100) {
        this.enterShopSceneConfig = null;
    }
}
