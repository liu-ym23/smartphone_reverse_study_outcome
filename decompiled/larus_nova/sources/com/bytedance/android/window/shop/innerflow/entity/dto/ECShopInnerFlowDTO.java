package com.bytedance.android.window.shop.innerflow.entity.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import up3.g;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003JG\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b$\u0010#¨\u0006'"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/entity/dto/ECShopInnerFlowDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "component1", "", "component2", "", "Lup3/g;", "component3", "", "component4", "component5", "hasMore", EffectConfiguration.KEY_CURSOR, "mixCards", "shopCartUrl", "cartProductNumber", "copy", "toString", "", "hashCode", "", "other", "equals", "Z", "getHasMore", "()Z", "J", "getCursor", "()J", "Ljava/util/List;", "getMixCards", "()Ljava/util/List;", "Ljava/lang/String;", "getShopCartUrl", "()Ljava/lang/String;", "getCartProductNumber", "<init>", "(ZJLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopInnerFlowDTO extends CommerceBaseResponse {

    @SerializedName("cart_product_num")
    private final String cartProductNumber;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final long cursor;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("mix_full_cards")
    private final List<g> mixCards;

    @SerializedName("shop_cart_url")
    private final String shopCartUrl;

    public ECShopInnerFlowDTO() {
        this(false, 0, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECShopInnerFlowDTO copy$default(ECShopInnerFlowDTO r100, boolean r101, long r102, List r103, String r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.hasMore;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.cursor;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.mixCards;
    L11:
        List r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.shopCartUrl;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.cartProductNumber;
    L17:
        boolean r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final long component2() {
        return this.cursor;
    }

    public final List<g> component3() {
        return this.mixCards;
    }

    public final String component4() {
        return this.shopCartUrl;
    }

    public final String component5() {
        return this.cartProductNumber;
    }

    public final ECShopInnerFlowDTO copy(boolean r100, long r110, List<g> r111, String r112, String r113) {
        return new ECShopInnerFlowDTO(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECShopInnerFlowDTO) == false) goto L16;
        ECShopInnerFlowDTO r101 = (ECShopInnerFlowDTO) r100;
        if (this.hasMore == r101.hasMore) goto L8;
        return false;
    L8:
        if (this.cursor == r101.cursor) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mixCards, r101.mixCards) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shopCartUrl, r101.shopCartUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cartProductNumber, r101.cartProductNumber) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean r100 = this.hasMore;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.cursor;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        List<g> r104 = this.mixCards;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.shopCartUrl;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.cartProductNumber;
        if (r111 == null) goto L17;
        r105 = r111.hashCode();
    L17:
        return r110 + r105;
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public String toString() {
        return "ECShopInnerFlowDTO(hasMore=" + this.hasMore + ", cursor=" + this.cursor + ", mixCards=" + this.mixCards + ", shopCartUrl=" + this.shopCartUrl + ", cartProductNumber=" + this.cartProductNumber + ")";
    }

    public final String getCartProductNumber() {
        return this.cartProductNumber;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<g> getMixCards() {
        return this.mixCards;
    }

    public final String getShopCartUrl() {
        return this.shopCartUrl;
    }

    public ECShopInnerFlowDTO(boolean r100, long r101, List<g> r102, String r103, String r104) {
        this.hasMore = r100;
        this.cursor = r101;
        this.mixCards = r102;
        this.shopCartUrl = r103;
        this.cartProductNumber = r104;
    }

    public /* synthetic */ ECShopInnerFlowDTO(boolean r100, long r101, List r102, String r103, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        List r113 = null;
    L13:
        if ((r111 & 8) == 0) goto L15;
        String r105 = null;
    L17:
        if ((r111 & 16) == 0) goto L19;
        String r106 = null;
    L20:
        this(r100, r104, r113, r105, r106);
        return;
    L19:
        r106 = r110;
        goto L20
    L15:
        r105 = r103;
        goto L17
    L11:
        r113 = r102;
        goto L13
    }
}
