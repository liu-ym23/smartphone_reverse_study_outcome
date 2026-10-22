package com.bytedance.android.ec.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "jumpCartsUrl", "", "productNum", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getJumpCartsUrl", "()Ljava/lang/String;", "getProductNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV2CartsInfoDTO extends CommerceBaseResponse {

    @SerializedName("jump_carts_url")
    private final String jumpCartsUrl;

    @SerializedName("products_num")
    private final Integer productNum;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreV2CartsInfoDTO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ StoreV2CartsInfoDTO copy$default(StoreV2CartsInfoDTO r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.jumpCartsUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.productNum;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.jumpCartsUrl;
    }

    public final Integer component2() {
        return this.productNum;
    }

    public final StoreV2CartsInfoDTO copy(String r100, Integer r101) {
        return new StoreV2CartsInfoDTO(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StoreV2CartsInfoDTO) == false) goto L10;
        StoreV2CartsInfoDTO r101 = (StoreV2CartsInfoDTO) r100;
        if (Intrinsics.areEqual(this.jumpCartsUrl, r101.jumpCartsUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productNum, r101.productNum) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.jumpCartsUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.productNum;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StoreV2CartsInfoDTO(jumpCartsUrl=" + this.jumpCartsUrl + ", productNum=" + this.productNum + ")";
    }

    public final String getJumpCartsUrl() {
        return this.jumpCartsUrl;
    }

    public final Integer getProductNum() {
        return this.productNum;
    }

    public StoreV2CartsInfoDTO(String r100, Integer r101) {
        this.jumpCartsUrl = r100;
        this.productNum = r101;
    }

    public /* synthetic */ StoreV2CartsInfoDTO(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
