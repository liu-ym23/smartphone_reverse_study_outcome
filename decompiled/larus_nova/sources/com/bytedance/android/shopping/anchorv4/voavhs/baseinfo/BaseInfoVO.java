package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.SkuBaseInfoComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;", "Ljava/io/Serializable;", "skuInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "tagsList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "goodsTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "bottomTagsList", "marketPrice", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "discountPrice", "price", SalesInfoStruct.SALES, "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "userLike", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;)V", "getBottomTagsList", "()Ljava/util/List;", "getDiscountPrice", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getGoodsTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "getMarketPrice", "getPrice", "getSales", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getSkuInfo", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "getTagsList", "getUserLike", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseInfoVO implements Serializable {

    @SerializedName("bottom_tag_list")
    private final List<LongContentLabelComponent> bottomTagsList;

    @SerializedName("discount_price")
    private final PriceElement discountPrice;

    @SerializedName("goods_title")
    private final LongTitleComponent goodsTitle;

    @SerializedName("market_price")
    private final PriceElement marketPrice;

    @SerializedName("price")
    private final PriceElement price;

    @SerializedName(SalesInfoStruct.SALES)
    private final TextElement sales;

    @SerializedName("sku_info")
    private final SkuBaseInfoComponent skuInfo;

    @SerializedName("tags_list")
    private final List<LongContentLabelComponent> tagsList;

    @SerializedName("user_like")
    private final TagsScrollBoxComponent userLike;

    public BaseInfoVO() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseInfoVO copy$default(BaseInfoVO r110, SkuBaseInfoComponent r111, List r112, LongTitleComponent r113, List r114, PriceElement r115, PriceElement r116, PriceElement r117, TextElement r118, TagsScrollBoxComponent r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        SkuBaseInfoComponent r100 = r110.skuInfo;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r101 = r110.tagsList;
    L11:
        if ((r210 & 4) == 0) goto L13;
        LongTitleComponent r102 = r110.goodsTitle;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r103 = r110.bottomTagsList;
    L19:
        if ((r210 & 16) == 0) goto L21;
        PriceElement r104 = r110.marketPrice;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PriceElement r105 = r110.discountPrice;
    L27:
        if ((r210 & 64) == 0) goto L29;
        PriceElement r106 = r110.price;
    L31:
        if ((r210 & 128) == 0) goto L33;
        TextElement r107 = r110.sales;
    L35:
        if ((r210 & 256) == 0) goto L37;
        TagsScrollBoxComponent r108 = r110.userLike;
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

    public final SkuBaseInfoComponent component1() {
        return this.skuInfo;
    }

    public final List<LongContentLabelComponent> component2() {
        return this.tagsList;
    }

    public final LongTitleComponent component3() {
        return this.goodsTitle;
    }

    public final List<LongContentLabelComponent> component4() {
        return this.bottomTagsList;
    }

    public final PriceElement component5() {
        return this.marketPrice;
    }

    public final PriceElement component6() {
        return this.discountPrice;
    }

    public final PriceElement component7() {
        return this.price;
    }

    public final TextElement component8() {
        return this.sales;
    }

    public final TagsScrollBoxComponent component9() {
        return this.userLike;
    }

    public final BaseInfoVO copy(SkuBaseInfoComponent r110, List<? extends LongContentLabelComponent> r111, LongTitleComponent r112, List<? extends LongContentLabelComponent> r113, PriceElement r114, PriceElement r115, PriceElement r116, TextElement r117, TagsScrollBoxComponent r210) {
        return new BaseInfoVO(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BaseInfoVO) == false) goto L24;
        BaseInfoVO r101 = (BaseInfoVO) r100;
        if (Intrinsics.areEqual(this.skuInfo, r101.skuInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tagsList, r101.tagsList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.goodsTitle, r101.goodsTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bottomTagsList, r101.bottomTagsList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.sales, r101.sales) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userLike, r101.userLike) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        SkuBaseInfoComponent r100 = this.skuInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<LongContentLabelComponent> r104 = this.tagsList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LongTitleComponent r107 = this.goodsTitle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<LongContentLabelComponent> r110 = this.bottomTagsList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        PriceElement r113 = this.marketPrice;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        PriceElement r116 = this.discountPrice;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        PriceElement r119 = this.price;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        TextElement r122 = this.sales;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        TagsScrollBoxComponent r125 = this.userLike;
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
        return "BaseInfoVO(skuInfo=" + this.skuInfo + ", tagsList=" + this.tagsList + ", goodsTitle=" + this.goodsTitle + ", bottomTagsList=" + this.bottomTagsList + ", marketPrice=" + this.marketPrice + ", discountPrice=" + this.discountPrice + ", price=" + this.price + ", sales=" + this.sales + ", userLike=" + this.userLike + ")";
    }

    public final List<LongContentLabelComponent> getBottomTagsList() {
        return this.bottomTagsList;
    }

    public final PriceElement getDiscountPrice() {
        return this.discountPrice;
    }

    public final LongTitleComponent getGoodsTitle() {
        return this.goodsTitle;
    }

    public final PriceElement getMarketPrice() {
        return this.marketPrice;
    }

    public final PriceElement getPrice() {
        return this.price;
    }

    public final TextElement getSales() {
        return this.sales;
    }

    public final SkuBaseInfoComponent getSkuInfo() {
        return this.skuInfo;
    }

    public final List<LongContentLabelComponent> getTagsList() {
        return this.tagsList;
    }

    public final TagsScrollBoxComponent getUserLike() {
        return this.userLike;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseInfoVO(SkuBaseInfoComponent r100, List<? extends LongContentLabelComponent> r101, LongTitleComponent r102, List<? extends LongContentLabelComponent> r103, PriceElement r104, PriceElement r105, PriceElement r106, TextElement r107, TagsScrollBoxComponent r108) {
        this.skuInfo = r100;
        this.tagsList = r101;
        this.goodsTitle = r102;
        this.bottomTagsList = r103;
        this.marketPrice = r104;
        this.discountPrice = r105;
        this.price = r106;
        this.sales = r107;
        this.userLike = r108;
    }

    public /* synthetic */ BaseInfoVO(SkuBaseInfoComponent r110, List r111, LongTitleComponent r112, List r113, PriceElement r114, PriceElement r115, PriceElement r116, TextElement r117, TagsScrollBoxComponent r118, int r210, DefaultConstructorMarker r211) {
        TagsScrollBoxComponent r100 = null;
        if ((r210 & 1) == 0) goto L5;
        SkuBaseInfoComponent r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        LongTitleComponent r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        PriceElement r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PriceElement r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        PriceElement r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        TextElement r108 = null;
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
