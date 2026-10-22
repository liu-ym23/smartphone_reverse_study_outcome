package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionAdditionModuleData;", "Ljava/io/Serializable;", "()V", "epInfo", "", "getEpInfo", "()Ljava/lang/Object;", "signUpInfo", "getSignUpInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionAdditionModuleData implements Serializable {

    @SerializedName("ep_info")
    private final Object epInfo;

    @SerializedName("sign_up_info")
    private final Object signUpInfo;

    public PromotionAdditionModuleData() {
    }

    public final Object getEpInfo() {
        return this.epInfo;
    }

    public final Object getSignUpInfo() {
        return this.signUpInfo;
    }
}
