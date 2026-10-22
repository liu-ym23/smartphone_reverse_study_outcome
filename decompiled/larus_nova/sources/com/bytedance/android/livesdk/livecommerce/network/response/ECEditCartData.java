package com.bytedance.android.livesdk.livecommerce.network.response;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\nHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "Ljava/io/Serializable;", "shopCartItem", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECShopCartItem;", "cartNum", "", "cartNumWithBusinessLine", "Lcom/bytedance/android/ec/model/sku/CartNumWithBusinessLine;", "toastMsg", "", "(Ljava/util/List;ILjava/util/List;Ljava/lang/String;)V", "getCartNum", "()I", "getCartNumWithBusinessLine", "()Ljava/util/List;", "getShopCartItem", "getToastMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEditCartData implements Serializable {

    @SerializedName("cart_num")
    private final int cartNum;

    @SerializedName("cart_num_with_business_line")
    private final List<CartNumWithBusinessLine> cartNumWithBusinessLine;

    @SerializedName("shop_cart_item")
    private final List<ECShopCartItem> shopCartItem;

    @SerializedName(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    private final String toastMsg;

    public ECEditCartData() {
        this(null, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECEditCartData copy$default(ECEditCartData r100, List r101, int r102, List r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.shopCartItem;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.cartNum;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.cartNumWithBusinessLine;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.toastMsg;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<ECShopCartItem> component1() {
        return this.shopCartItem;
    }

    public final int component2() {
        return this.cartNum;
    }

    public final List<CartNumWithBusinessLine> component3() {
        return this.cartNumWithBusinessLine;
    }

    public final String component4() {
        return this.toastMsg;
    }

    public final ECEditCartData copy(List<ECShopCartItem> r100, int r101, List<CartNumWithBusinessLine> r102, String r103) {
        return new ECEditCartData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECEditCartData) == false) goto L14;
        ECEditCartData r101 = (ECEditCartData) r100;
        if (Intrinsics.areEqual(this.shopCartItem, r101.shopCartItem) == true) goto L8;
        return false;
    L8:
        if (this.cartNum == r101.cartNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cartNumWithBusinessLine, r101.cartNumWithBusinessLine) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toastMsg, r101.toastMsg) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<ECShopCartItem> r100 = this.shopCartItem;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.cartNum) * 31;
        List<CartNumWithBusinessLine> r104 = this.cartNumWithBusinessLine;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.toastMsg;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECEditCartData(shopCartItem=" + this.shopCartItem + ", cartNum=" + this.cartNum + ", cartNumWithBusinessLine=" + this.cartNumWithBusinessLine + ", toastMsg=" + this.toastMsg + ")";
    }

    public final int getCartNum() {
        return this.cartNum;
    }

    public final List<CartNumWithBusinessLine> getCartNumWithBusinessLine() {
        return this.cartNumWithBusinessLine;
    }

    public final List<ECShopCartItem> getShopCartItem() {
        return this.shopCartItem;
    }

    public final String getToastMsg() {
        return this.toastMsg;
    }

    public ECEditCartData(List<ECShopCartItem> r100, int r101, List<CartNumWithBusinessLine> r102, String r103) {
        this.shopCartItem = r100;
        this.cartNum = r101;
        this.cartNumWithBusinessLine = r102;
        this.toastMsg = r103;
    }

    public /* synthetic */ ECEditCartData(List r100, int r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
