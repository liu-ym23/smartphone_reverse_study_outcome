package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetailResponse;", "Lcom/bytedance/android/ec/model/g;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetail;", "data", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetail;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetail;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowDetailResponse extends g {

    @SerializedName("data")
    private final ECFloatWindowDetail data;

    public ECFloatWindowDetailResponse() {
    }

    public final ECFloatWindowDetail a() {
        return this.data;
    }
}
