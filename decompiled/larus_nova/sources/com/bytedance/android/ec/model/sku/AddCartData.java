package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/sku/AddCartData;", "Ljava/io/Serializable;", "cartId", "", "cartNum", "", "cartIdString", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCartId", "()Ljava/lang/String;", "getCartIdString", "getCartNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "asJSONDescription", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/ec/model/sku/AddCartData;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AddCartData implements Serializable {

    @SerializedName("cart_id")
    private final String cartId;

    @SerializedName("cart_id_str")
    private final String cartIdString;

    @SerializedName("cart_num")
    private final Integer cartNum;

    public AddCartData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AddCartData copy$default(AddCartData r100, String r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.cartId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.cartNum;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.cartIdString;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.cartId;
    }

    public final Integer component2() {
        return this.cartNum;
    }

    public final String component3() {
        return this.cartIdString;
    }

    public final AddCartData copy(String r100, Integer r101, String r102) {
        return new AddCartData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AddCartData) == false) goto L12;
        AddCartData r101 = (AddCartData) r100;
        if (Intrinsics.areEqual(this.cartId, r101.cartId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cartNum, r101.cartNum) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cartIdString, r101.cartIdString) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.cartId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cartNum;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cartIdString;
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
        return "AddCartData(cartId=" + this.cartId + ", cartNum=" + this.cartNum + ", cartIdString=" + this.cartIdString + ")";
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("cart_id", this.cartId);
        r100.put("cart_num", this.cartNum);
        r100.put("cart_id_str", this.cartIdString);
        return r100;
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final String getCartIdString() {
        return this.cartIdString;
    }

    public final Integer getCartNum() {
        return this.cartNum;
    }

    public AddCartData(String r100, Integer r101, String r102) {
        this.cartId = r100;
        this.cartNum = r101;
        this.cartIdString = r102;
    }

    public /* synthetic */ AddCartData(String r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
