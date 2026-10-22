package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c1;", "", "", "recommendText", "Ljava/lang/String;", "getRecommendText", "()Ljava/lang/String;", "setRecommendText", "(Ljava/lang/String;)V", "storeName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setStoreName", "storeUrl", "c", "setStoreUrl", "", "storeProductCount", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setStoreProductCount", "(Ljava/lang/Integer;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c1 {

    @SerializedName("recommend_text")
    private String recommendText;

    @SerializedName("store_name")
    private String storeName;

    @SerializedName("store_product_count")
    private Integer storeProductCount;

    @SerializedName("store_url")
    private String storeUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c1) == false) goto L14;
        c1 r101 = (c1) r100;
        if (Intrinsics.areEqual(this.recommendText, r101.recommendText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.storeName, r101.storeName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.storeUrl, r101.storeUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storeProductCount, r101.storeProductCount) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.recommendText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.storeName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.storeUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.storeProductCount;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowStoreEntranceDTO(recommendText=" + this.recommendText + ", storeName=" + this.storeName + ", storeUrl=" + this.storeUrl + ", storeProductCount=" + this.storeProductCount + ")";
    }

    public c1() {
        this.recommendText = null;
        this.storeName = null;
        this.storeUrl = null;
        this.storeProductCount = null;
    }

    public final String a() {
        return this.storeName;
    }

    public final Integer b() {
        return this.storeProductCount;
    }

    public final String c() {
        return this.storeUrl;
    }
}
