package com.bytedance.android.shopping.ligo.container.event;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JR\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/ligo/container/event/LiveLigoCartStatusChangeEventData;", "Ljava/io/Serializable;", "status", "", "productId", "", "skuId", "skuNum", "eventFrom", "cartExtra", "Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;)V", "getCartExtra", "()Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;", "getEventFrom", "()Ljava/lang/String;", "getProductId", "getSkuId", "getSkuNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;)Lcom/bytedance/android/shopping/ligo/container/event/LiveLigoCartStatusChangeEventData;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLigoCartStatusChangeEventData implements Serializable {

    @SerializedName("cart_extra")
    private final AddCartExtraData cartExtra;

    @SerializedName("event_from")
    private final String eventFrom;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName(a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName("sku_num")
    private final Integer skuNum;

    @SerializedName("status")
    private final int status;

    public static /* synthetic */ LiveLigoCartStatusChangeEventData copy$default(LiveLigoCartStatusChangeEventData r100, int r101, String r102, String r103, Integer r104, String r105, AddCartExtraData r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.productId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.skuId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.skuNum;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.eventFrom;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.cartExtra;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.productId;
    }

    public final String component3() {
        return this.skuId;
    }

    public final Integer component4() {
        return this.skuNum;
    }

    public final String component5() {
        return this.eventFrom;
    }

    public final AddCartExtraData component6() {
        return this.cartExtra;
    }

    public final LiveLigoCartStatusChangeEventData copy(int r100, String r110, String r111, Integer r112, String r113, AddCartExtraData r114) {
        Intrinsics.checkNotNullParameter(r113, "eventFrom");
        return new LiveLigoCartStatusChangeEventData(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveLigoCartStatusChangeEventData) == false) goto L18;
        LiveLigoCartStatusChangeEventData r101 = (LiveLigoCartStatusChangeEventData) r100;
        if (this.status == r101.status) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skuNum, r101.skuNum) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventFrom, r101.eventFrom) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cartExtra, r101.cartExtra) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r100 = this.status * 31;
        String r101 = this.productId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.skuId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.skuNum;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.eventFrom;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        AddCartExtraData r114 = this.cartExtra;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "LiveLigoCartStatusChangeEventData(status=" + this.status + ", productId=" + this.productId + ", skuId=" + this.skuId + ", skuNum=" + this.skuNum + ", eventFrom=" + this.eventFrom + ", cartExtra=" + this.cartExtra + ")";
    }

    public final AddCartExtraData getCartExtra() {
        return this.cartExtra;
    }

    public final String getEventFrom() {
        return this.eventFrom;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final Integer getSkuNum() {
        return this.skuNum;
    }

    public final int getStatus() {
        return this.status;
    }

    public LiveLigoCartStatusChangeEventData(int r100, String r101, String r102, Integer r103, String r104, AddCartExtraData r105) {
        Intrinsics.checkNotNullParameter(r104, "eventFrom");
        this.status = r100;
        this.productId = r101;
        this.skuId = r102;
        this.skuNum = r103;
        this.eventFrom = r104;
        this.cartExtra = r105;
    }

    public /* synthetic */ LiveLigoCartStatusChangeEventData(int r100, String r101, String r110, Integer r111, String r112, AddCartExtraData r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        r112 = "edit_cart_from_other";
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
