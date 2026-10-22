package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;", "Ljava/io/Serializable;", "shopFollowerCount", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "shopSellNum", "subScoreList", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "dividerColor", "", "lynxReputation", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;)V", "getDividerColor", "()Ljava/lang/String;", "getLynxReputation", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "getShopFollowerCount", "()Ljava/util/List;", "getShopSellNum", "getSubScoreList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreReputation implements Serializable {

    @SerializedName("divider_color")
    private final String dividerColor;

    @SerializedName("lynx_reputation")
    private final LynxCardComponent lynxReputation;

    @SerializedName("shop_follower_section")
    private final List<TextElement> shopFollowerCount;

    @SerializedName("shop_sell_section")
    private final List<TextElement> shopSellNum;

    @SerializedName("shop_score_section")
    private final List<TagsScrollBoxComponent> subScoreList;

    public AnchorV4ShopAndStoreReputation() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreReputation copy$default(AnchorV4ShopAndStoreReputation r100, List r101, List r102, List r103, String r104, LynxCardComponent r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.shopFollowerCount;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.shopSellNum;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.subScoreList;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.dividerColor;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.lynxReputation;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<TextElement> component1() {
        return this.shopFollowerCount;
    }

    public final List<TextElement> component2() {
        return this.shopSellNum;
    }

    public final List<TagsScrollBoxComponent> component3() {
        return this.subScoreList;
    }

    public final String component4() {
        return this.dividerColor;
    }

    public final LynxCardComponent component5() {
        return this.lynxReputation;
    }

    public final AnchorV4ShopAndStoreReputation copy(List<TextElement> r100, List<TextElement> r101, List<TagsScrollBoxComponent> r110, String r111, LynxCardComponent r112) {
        return new AnchorV4ShopAndStoreReputation(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ShopAndStoreReputation) == false) goto L16;
        AnchorV4ShopAndStoreReputation r101 = (AnchorV4ShopAndStoreReputation) r100;
        if (Intrinsics.areEqual(this.shopFollowerCount, r101.shopFollowerCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopSellNum, r101.shopSellNum) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subScoreList, r101.subScoreList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dividerColor, r101.dividerColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lynxReputation, r101.lynxReputation) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<TextElement> r100 = this.shopFollowerCount;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<TextElement> r104 = this.shopSellNum;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<TagsScrollBoxComponent> r107 = this.subScoreList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.dividerColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        LynxCardComponent r113 = this.lynxReputation;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "AnchorV4ShopAndStoreReputation(shopFollowerCount=" + this.shopFollowerCount + ", shopSellNum=" + this.shopSellNum + ", subScoreList=" + this.subScoreList + ", dividerColor=" + this.dividerColor + ", lynxReputation=" + this.lynxReputation + ")";
    }

    public final String getDividerColor() {
        return this.dividerColor;
    }

    public final LynxCardComponent getLynxReputation() {
        return this.lynxReputation;
    }

    public final List<TextElement> getShopFollowerCount() {
        return this.shopFollowerCount;
    }

    public final List<TextElement> getShopSellNum() {
        return this.shopSellNum;
    }

    public final List<TagsScrollBoxComponent> getSubScoreList() {
        return this.subScoreList;
    }

    public AnchorV4ShopAndStoreReputation(List<TextElement> r100, List<TextElement> r101, List<TagsScrollBoxComponent> r102, String r103, LynxCardComponent r104) {
        this.shopFollowerCount = r100;
        this.shopSellNum = r101;
        this.subScoreList = r102;
        this.dividerColor = r103;
        this.lynxReputation = r104;
    }

    public /* synthetic */ AnchorV4ShopAndStoreReputation(List r100, List r101, List r102, String r103, LynxCardComponent r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        List r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        List r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        LynxCardComponent r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
