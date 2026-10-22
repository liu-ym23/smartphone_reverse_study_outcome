package com.bytedance.android.ec.window.base.shop;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/ECWindowFansClubResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/ec/window/base/shop/q;", "userData", "Lcom/bytedance/android/ec/window/base/shop/q;", "getUserData", "()Lcom/bytedance/android/ec/window/base/shop/q;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowFansClubResponse extends CommerceBaseResponse {

    @SerializedName("user_data")
    private final q userData;

    public ECWindowFansClubResponse() {
    }

    public final q getUserData() {
        return this.userData;
    }
}
