package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ProductPurchaseQualification;", "Ljava/io/Serializable;", "()V", "havePurchaseQualification", "", "getHavePurchaseQualification", "()Ljava/lang/Boolean;", "setHavePurchaseQualification", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "notifyData", "", "getNotifyData", "()Ljava/lang/String;", "notifyEvent", "getNotifyEvent", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductPurchaseQualification implements Serializable {

    @SerializedName("have_purchase_qualification")
    private Boolean havePurchaseQualification;

    @SerializedName("notify_data")
    private final String notifyData;

    @SerializedName("notify_event")
    private final String notifyEvent;

    public ProductPurchaseQualification() {
    }

    public final Boolean getHavePurchaseQualification() {
        return this.havePurchaseQualification;
    }

    public final String getNotifyData() {
        return this.notifyData;
    }

    public final String getNotifyEvent() {
        return this.notifyEvent;
    }

    public final void setHavePurchaseQualification(Boolean r100) {
        this.havePurchaseQualification = r100;
    }
}
