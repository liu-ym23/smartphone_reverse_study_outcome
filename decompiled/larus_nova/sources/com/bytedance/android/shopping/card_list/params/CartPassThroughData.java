package com.bytedance.android.shopping.card_list.params;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u007f\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\fHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "Ljava/io/Serializable;", "newSourceType", "", "historyPath", "enterFromLiveSaas", "cartIds", "shopIds", "showShopIds", "anchorCartId", "transparentParams", "heightPercent", "", "deliverySessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAnchorCartId", "()Ljava/lang/String;", "setAnchorCartId", "(Ljava/lang/String;)V", "getCartIds", "setCartIds", "getDeliverySessionId", "setDeliverySessionId", "getEnterFromLiveSaas", "getHeightPercent", "()I", "setHeightPercent", "(I)V", "getHistoryPath", "getNewSourceType", "getShopIds", "setShopIds", "getShowShopIds", "setShowShopIds", "getTransparentParams", "setTransparentParams", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartPassThroughData implements Serializable {

    @SerializedName("anchor_cart_id")
    private String anchorCartId;

    @SerializedName("cart_ids")
    private String cartIds;

    @SerializedName("delivery_session_id")
    private String deliverySessionId;

    @SerializedName("enter_from_live_saas")
    private final String enterFromLiveSaas;

    @SerializedName("cart_height_percent")
    private int heightPercent;

    @SerializedName("history_path")
    private final String historyPath;

    @SerializedName(a.KEY_NEW_SOURCE_TYPE)
    private final String newSourceType;

    @SerializedName("shop_ids")
    private String shopIds;

    @SerializedName("show_shop_ids")
    private String showShopIds;

    @SerializedName("transparent_params")
    private String transparentParams;

    public CartPassThroughData() {
        this(null, null, null, null, null, null, null, null, 0, null, 1023, null);
    }

    public static /* synthetic */ CartPassThroughData copy$default(CartPassThroughData r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, int r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.newSourceType;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.historyPath;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.enterFromLiveSaas;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.cartIds;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.shopIds;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.showShopIds;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.anchorCartId;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.transparentParams;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r119 = r110.heightPercent;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.deliverySessionId;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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
        return this.newSourceType;
    }

    public final String component10() {
        return this.deliverySessionId;
    }

    public final String component2() {
        return this.historyPath;
    }

    public final String component3() {
        return this.enterFromLiveSaas;
    }

    public final String component4() {
        return this.cartIds;
    }

    public final String component5() {
        return this.shopIds;
    }

    public final String component6() {
        return this.showShopIds;
    }

    public final String component7() {
        return this.anchorCartId;
    }

    public final String component8() {
        return this.transparentParams;
    }

    public final int component9() {
        return this.heightPercent;
    }

    public final CartPassThroughData copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, int r211, String r212) {
        return new CartPassThroughData(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CartPassThroughData) == false) goto L26;
        CartPassThroughData r101 = (CartPassThroughData) r100;
        if (Intrinsics.areEqual(this.newSourceType, r101.newSourceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.historyPath, r101.historyPath) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFromLiveSaas, r101.enterFromLiveSaas) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cartIds, r101.cartIds) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopIds, r101.shopIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.showShopIds, r101.showShopIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.anchorCartId, r101.anchorCartId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.transparentParams, r101.transparentParams) == true) goto L22;
        return false;
    L22:
        if (this.heightPercent == r101.heightPercent) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.deliverySessionId, r101.deliverySessionId) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.newSourceType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.historyPath;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterFromLiveSaas;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cartIds;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.shopIds;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.showShopIds;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.anchorCartId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.transparentParams;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (((r121 + r123) * 31) + this.heightPercent) * 31;
        String r125 = this.deliverySessionId;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
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
        return "CartPassThroughData(newSourceType=" + this.newSourceType + ", historyPath=" + this.historyPath + ", enterFromLiveSaas=" + this.enterFromLiveSaas + ", cartIds=" + this.cartIds + ", shopIds=" + this.shopIds + ", showShopIds=" + this.showShopIds + ", anchorCartId=" + this.anchorCartId + ", transparentParams=" + this.transparentParams + ", heightPercent=" + this.heightPercent + ", deliverySessionId=" + this.deliverySessionId + ")";
    }

    public final String getAnchorCartId() {
        return this.anchorCartId;
    }

    public final String getCartIds() {
        return this.cartIds;
    }

    public final String getDeliverySessionId() {
        return this.deliverySessionId;
    }

    public final String getEnterFromLiveSaas() {
        return this.enterFromLiveSaas;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final String getHistoryPath() {
        return this.historyPath;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final String getShopIds() {
        return this.shopIds;
    }

    public final String getShowShopIds() {
        return this.showShopIds;
    }

    public final String getTransparentParams() {
        return this.transparentParams;
    }

    public final void setAnchorCartId(String r100) {
        this.anchorCartId = r100;
    }

    public final void setCartIds(String r100) {
        this.cartIds = r100;
    }

    public final void setDeliverySessionId(String r100) {
        this.deliverySessionId = r100;
    }

    public final void setHeightPercent(int r100) {
        this.heightPercent = r100;
    }

    public final void setShopIds(String r100) {
        this.shopIds = r100;
    }

    public final void setShowShopIds(String r100) {
        this.showShopIds = r100;
    }

    public final void setTransparentParams(String r100) {
        this.transparentParams = r100;
    }

    public CartPassThroughData(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, int r108, String r110) {
        this.newSourceType = r100;
        this.historyPath = r101;
        this.enterFromLiveSaas = r102;
        this.cartIds = r103;
        this.shopIds = r104;
        this.showShopIds = r105;
        this.anchorCartId = r106;
        this.transparentParams = r107;
        this.heightPercent = r108;
        this.deliverySessionId = r110;
    }

    public /* synthetic */ CartPassThroughData(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r118 = 0;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
