package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0091\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreBusinessMeta;", "Ljava/io/Serializable;", "shopNavLink", "", "shopAvatarLink", "shopPortfolioUrl", "isStore", "", "shopAuthorId", "shopCouponUrl", "", "shopCouponType", "", "shopCouponEntranceLocation", "shopRankList", "shopReputationLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getShopAuthorId", "()Ljava/lang/String;", "getShopAvatarLink", "getShopCouponEntranceLocation", "()Ljava/util/List;", "getShopCouponType", "getShopCouponUrl", "getShopNavLink", "getShopPortfolioUrl", "getShopRankList", "getShopReputationLink", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreBusinessMeta implements Serializable {

    @SerializedName("is_store")
    private final boolean isStore;

    @SerializedName("shop_author_id")
    private final String shopAuthorId;

    @SerializedName("shop_avatar_link")
    private final String shopAvatarLink;

    @SerializedName("shop_coupon_entrance_location")
    private final List<String> shopCouponEntranceLocation;

    @SerializedName("shop_coupon_type")
    private final List<Long> shopCouponType;

    @SerializedName("shop_coupon_url")
    private final List<String> shopCouponUrl;

    @SerializedName("shop_nav_link")
    private final String shopNavLink;

    @SerializedName("shop_portfolio_url")
    private final String shopPortfolioUrl;

    @SerializedName("shop_rank_list")
    private final String shopRankList;

    @SerializedName("shop_reputation_link")
    private final String shopReputationLink;

    public AnchorV4ShopAndStoreBusinessMeta() {
        this(null, null, null, false, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreBusinessMeta copy$default(AnchorV4ShopAndStoreBusinessMeta r110, String r111, String r112, String r113, boolean r114, String r115, List r116, List r117, List r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.shopNavLink;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.shopAvatarLink;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.shopPortfolioUrl;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r103 = r110.isStore;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.shopAuthorId;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r105 = r110.shopCouponUrl;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.shopCouponType;
    L31:
        if ((r212 & 128) == 0) goto L33;
        List r107 = r110.shopCouponEntranceLocation;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.shopRankList;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.shopReputationLink;
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
        return this.shopNavLink;
    }

    public final String component10() {
        return this.shopReputationLink;
    }

    public final String component2() {
        return this.shopAvatarLink;
    }

    public final String component3() {
        return this.shopPortfolioUrl;
    }

    public final boolean component4() {
        return this.isStore;
    }

    public final String component5() {
        return this.shopAuthorId;
    }

    public final List<String> component6() {
        return this.shopCouponUrl;
    }

    public final List<Long> component7() {
        return this.shopCouponType;
    }

    public final List<String> component8() {
        return this.shopCouponEntranceLocation;
    }

    public final String component9() {
        return this.shopRankList;
    }

    public final AnchorV4ShopAndStoreBusinessMeta copy(String r110, String r111, String r112, boolean r113, String r114, List<String> r115, List<Long> r116, List<String> r210, String r211, String r212) {
        return new AnchorV4ShopAndStoreBusinessMeta(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ShopAndStoreBusinessMeta) == false) goto L26;
        AnchorV4ShopAndStoreBusinessMeta r101 = (AnchorV4ShopAndStoreBusinessMeta) r100;
        if (Intrinsics.areEqual(this.shopNavLink, r101.shopNavLink) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopAvatarLink, r101.shopAvatarLink) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopPortfolioUrl, r101.shopPortfolioUrl) == true) goto L12;
        return false;
    L12:
        if (this.isStore == r101.isStore) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopAuthorId, r101.shopAuthorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopCouponUrl, r101.shopCouponUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shopCouponType, r101.shopCouponType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.shopCouponEntranceLocation, r101.shopCouponEntranceLocation) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopRankList, r101.shopRankList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopReputationLink, r101.shopReputationLink) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        String r100 = this.shopNavLink;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.shopAvatarLink;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopPortfolioUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.isStore;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.shopAuthorId;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.shopCouponUrl;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        List<Long> r119 = this.shopCouponType;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.shopCouponEntranceLocation;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.shopRankList;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.shopReputationLink;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        return r127 + r101;
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
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
        return "AnchorV4ShopAndStoreBusinessMeta(shopNavLink=" + this.shopNavLink + ", shopAvatarLink=" + this.shopAvatarLink + ", shopPortfolioUrl=" + this.shopPortfolioUrl + ", isStore=" + this.isStore + ", shopAuthorId=" + this.shopAuthorId + ", shopCouponUrl=" + this.shopCouponUrl + ", shopCouponType=" + this.shopCouponType + ", shopCouponEntranceLocation=" + this.shopCouponEntranceLocation + ", shopRankList=" + this.shopRankList + ", shopReputationLink=" + this.shopReputationLink + ")";
    }

    public final String getShopAuthorId() {
        return this.shopAuthorId;
    }

    public final String getShopAvatarLink() {
        return this.shopAvatarLink;
    }

    public final List<String> getShopCouponEntranceLocation() {
        return this.shopCouponEntranceLocation;
    }

    public final List<Long> getShopCouponType() {
        return this.shopCouponType;
    }

    public final List<String> getShopCouponUrl() {
        return this.shopCouponUrl;
    }

    public final String getShopNavLink() {
        return this.shopNavLink;
    }

    public final String getShopPortfolioUrl() {
        return this.shopPortfolioUrl;
    }

    public final String getShopRankList() {
        return this.shopRankList;
    }

    public final String getShopReputationLink() {
        return this.shopReputationLink;
    }

    public final boolean isStore() {
        return this.isStore;
    }

    public AnchorV4ShopAndStoreBusinessMeta(String r100, String r101, String r102, boolean r103, String r104, List<String> r105, List<Long> r106, List<String> r107, String r108, String r110) {
        this.shopNavLink = r100;
        this.shopAvatarLink = r101;
        this.shopPortfolioUrl = r102;
        this.isStore = r103;
        this.shopAuthorId = r104;
        this.shopCouponUrl = r105;
        this.shopCouponType = r106;
        this.shopCouponEntranceLocation = r107;
        this.shopRankList = r108;
        this.shopReputationLink = r110;
    }

    public /* synthetic */ AnchorV4ShopAndStoreBusinessMeta(String r110, String r111, String r112, boolean r113, String r114, List r115, List r116, List r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
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
        boolean r104 = false;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
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
