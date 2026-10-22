package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jx\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u000b\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECCartItemBasicInfo;", "Ljava/io/Serializable;", "cartId", "", "productId", "name", "specPic", "specDesc", "comboId", "comboNum", "", "isMultiSku", "", "shopId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)V", "getCartId", "()Ljava/lang/String;", "getComboId", "getComboNum", "()I", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getProductId", "getShopId", "getSpecDesc", "getSpecPic", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/livesdk/livecommerce/network/response/ECCartItemBasicInfo;", "equals", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartItemBasicInfo implements Serializable {

    @SerializedName("cart_id")
    private final String cartId;

    @SerializedName(a.KEY_COMBO_ID)
    private final String comboId;

    @SerializedName("combo_num")
    private final int comboNum;

    @SerializedName("is_multi_sku")
    private final Boolean isMultiSku;

    @SerializedName("name")
    private final String name;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName(a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("spec_desc")
    private final String specDesc;

    @SerializedName("spec_pic")
    private final String specPic;

    public ECCartItemBasicInfo() {
        this(null, null, null, null, null, null, 0, null, null, 511, null);
    }

    public static /* synthetic */ ECCartItemBasicInfo copy$default(ECCartItemBasicInfo r110, String r111, String r112, String r113, String r114, String r115, String r116, int r117, Boolean r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.cartId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.productId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.name;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.specPic;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.specDesc;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.comboId;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r106 = r110.comboNum;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r107 = r110.isMultiSku;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.shopId;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.cartId;
    }

    public final String component2() {
        return this.productId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.specPic;
    }

    public final String component5() {
        return this.specDesc;
    }

    public final String component6() {
        return this.comboId;
    }

    public final int component7() {
        return this.comboNum;
    }

    public final Boolean component8() {
        return this.isMultiSku;
    }

    public final String component9() {
        return this.shopId;
    }

    public final ECCartItemBasicInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, int r116, Boolean r117, String r210) {
        return new ECCartItemBasicInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECCartItemBasicInfo) == false) goto L24;
        ECCartItemBasicInfo r101 = (ECCartItemBasicInfo) r100;
        if (Intrinsics.areEqual(this.cartId, r101.cartId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.specPic, r101.specPic) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.specDesc, r101.specDesc) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.comboId, r101.comboId) == true) goto L18;
        return false;
    L18:
        if (this.comboNum == r101.comboNum) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.isMultiSku, r101.isMultiSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.cartId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.specPic;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.specDesc;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.comboId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((r115 + r117) * 31) + this.comboNum) * 31;
        Boolean r119 = this.isMultiSku;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.shopId;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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

    public String toString() {
        return "ECCartItemBasicInfo(cartId=" + this.cartId + ", productId=" + this.productId + ", name=" + this.name + ", specPic=" + this.specPic + ", specDesc=" + this.specDesc + ", comboId=" + this.comboId + ", comboNum=" + this.comboNum + ", isMultiSku=" + this.isMultiSku + ", shopId=" + this.shopId + ")";
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final String getComboId() {
        return this.comboId;
    }

    public final int getComboNum() {
        return this.comboNum;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSpecDesc() {
        return this.specDesc;
    }

    public final String getSpecPic() {
        return this.specPic;
    }

    public final Boolean isMultiSku() {
        return this.isMultiSku;
    }

    public ECCartItemBasicInfo(String r100, String r101, String r102, String r103, String r104, String r105, int r106, Boolean r107, String r108) {
        this.cartId = r100;
        this.productId = r101;
        this.name = r102;
        this.specPic = r103;
        this.specDesc = r104;
        this.comboId = r105;
        this.comboNum = r106;
        this.isMultiSku = r107;
        this.shopId = r108;
    }

    public /* synthetic */ ECCartItemBasicInfo(String r110, String r111, String r112, String r113, String r114, String r115, int r116, Boolean r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
