package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/g1;", "", "", "giftAssetsPoolRemoveOnceSize", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "giftAssetsPoolSize", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g1 {

    @SerializedName("live_gift_assets_pool_remove_once_size")
    private final int giftAssetsPoolRemoveOnceSize;

    @SerializedName("live_gift_assets_pool_size")
    private final int giftAssetsPoolSize;

    public g1() {
        this.giftAssetsPoolRemoveOnceSize = 10240;
        this.giftAssetsPoolSize = 51200;
    }

    public final int a() {
        return this.giftAssetsPoolRemoveOnceSize;
    }

    public final int b() {
        return this.giftAssetsPoolSize;
    }
}
