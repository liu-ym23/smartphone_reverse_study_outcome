package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/SameGoodsItem;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/g;", "product", "Lcom/bytedance/android/shopping/anchorv4/dto/business/g;", "getProduct", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/g;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameGoodsItem implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f166519id;

    @SerializedName("product")
    private final g product;

    @SerializedName("type")
    private final Integer type;

    public SameGoodsItem() {
        this.type = 0;
        this.f166519id = "";
    }

    public final String getId() {
        return this.f166519id;
    }

    public final g getProduct() {
        return this.product;
    }

    public final Integer getType() {
        return this.type;
    }
}
