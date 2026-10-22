package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopTags;", "Ljava/io/Serializable;", "()V", "longTermIndicators", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "getLongTermIndicators", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "setLongTermIndicators", "(Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;)V", "shortTermIndicators", "getShortTermIndicators", "setShortTermIndicators", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopTags implements Serializable {

    @SerializedName("long_term_indicators")
    private ECTagListDTO longTermIndicators;

    @SerializedName("short_term_indicators")
    private ECTagListDTO shortTermIndicators;

    public ShopTags() {
    }

    public final ECTagListDTO getLongTermIndicators() {
        return this.longTermIndicators;
    }

    public final ECTagListDTO getShortTermIndicators() {
        return this.shortTermIndicators;
    }

    public final void setLongTermIndicators(ECTagListDTO r100) {
        this.longTermIndicators = r100;
    }

    public final void setShortTermIndicators(ECTagListDTO r100) {
        this.shortTermIndicators = r100;
    }
}
