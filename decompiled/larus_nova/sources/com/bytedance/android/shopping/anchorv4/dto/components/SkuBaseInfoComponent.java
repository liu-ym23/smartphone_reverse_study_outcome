package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.business.SkuBaseInfoDataModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J_\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "Ljava/io/Serializable;", "mainSkuImage", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "skuNumContent", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "textSpace", "", DocCallbackImpl.KEY_THUMBNAIL, "Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "moreSkuInfoContent", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "selectedIndex", "skuPriceList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/SkuBaseInfoDataModel;", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;ILcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;ILjava/util/List;)V", "getMainSkuImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "getMoreSkuInfoContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getSelectedIndex", "()I", "getSkuNumContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getSkuPriceList", "()Ljava/util/List;", "getTextSpace", "getThumbnail", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBaseInfoComponent implements Serializable {

    @SerializedName("main_sku_image")
    private final MediaBoxElement mainSkuImage;

    @SerializedName("more_sku_info_content")
    private final TextWithOneIconElement moreSkuInfoContent;

    @SerializedName("selected_index")
    private final int selectedIndex;

    @SerializedName("sku_num_content")
    private final TextElement skuNumContent;

    @SerializedName("sku_price_list")
    private final List<SkuBaseInfoDataModel> skuPriceList;

    @SerializedName("text_space")
    private final int textSpace;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private final MediaScrollBoxComponent thumbnail;

    public SkuBaseInfoComponent() {
        this(null, null, 0, null, null, 0, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuBaseInfoComponent copy$default(SkuBaseInfoComponent r100, MediaBoxElement r101, TextElement r102, int r103, MediaScrollBoxComponent r104, TextWithOneIconElement r110, int r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.mainSkuImage;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.skuNumContent;
    L8:
        TextElement r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.textSpace;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.thumbnail;
    L14:
        MediaScrollBoxComponent r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.moreSkuInfoContent;
    L17:
        TextWithOneIconElement r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.selectedIndex;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.skuPriceList;
    L23:
        MediaBoxElement r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final MediaBoxElement component1() {
        return this.mainSkuImage;
    }

    public final TextElement component2() {
        return this.skuNumContent;
    }

    public final int component3() {
        return this.textSpace;
    }

    public final MediaScrollBoxComponent component4() {
        return this.thumbnail;
    }

    public final TextWithOneIconElement component5() {
        return this.moreSkuInfoContent;
    }

    public final int component6() {
        return this.selectedIndex;
    }

    public final List<SkuBaseInfoDataModel> component7() {
        return this.skuPriceList;
    }

    public final SkuBaseInfoComponent copy(MediaBoxElement r110, TextElement r111, int r112, MediaScrollBoxComponent r113, TextWithOneIconElement r114, int r115, List<SkuBaseInfoDataModel> r116) {
        return new SkuBaseInfoComponent(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuBaseInfoComponent) == false) goto L20;
        SkuBaseInfoComponent r101 = (SkuBaseInfoComponent) r100;
        if (Intrinsics.areEqual(this.mainSkuImage, r101.mainSkuImage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skuNumContent, r101.skuNumContent) == true) goto L10;
        return false;
    L10:
        if (this.textSpace == r101.textSpace) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.thumbnail, r101.thumbnail) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.moreSkuInfoContent, r101.moreSkuInfoContent) == true) goto L16;
        return false;
    L16:
        if (this.selectedIndex == r101.selectedIndex) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skuPriceList, r101.skuPriceList) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        MediaBoxElement r100 = this.mainSkuImage;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextElement r104 = this.skuNumContent;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.textSpace) * 31;
        MediaScrollBoxComponent r107 = this.thumbnail;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextWithOneIconElement r110 = this.moreSkuInfoContent;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.selectedIndex) * 31;
        List<SkuBaseInfoDataModel> r113 = this.skuPriceList;
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
        return "SkuBaseInfoComponent(mainSkuImage=" + this.mainSkuImage + ", skuNumContent=" + this.skuNumContent + ", textSpace=" + this.textSpace + ", thumbnail=" + this.thumbnail + ", moreSkuInfoContent=" + this.moreSkuInfoContent + ", selectedIndex=" + this.selectedIndex + ", skuPriceList=" + this.skuPriceList + ")";
    }

    public final MediaBoxElement getMainSkuImage() {
        return this.mainSkuImage;
    }

    public final TextWithOneIconElement getMoreSkuInfoContent() {
        return this.moreSkuInfoContent;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final TextElement getSkuNumContent() {
        return this.skuNumContent;
    }

    public final List<SkuBaseInfoDataModel> getSkuPriceList() {
        return this.skuPriceList;
    }

    public final int getTextSpace() {
        return this.textSpace;
    }

    public final MediaScrollBoxComponent getThumbnail() {
        return this.thumbnail;
    }

    public SkuBaseInfoComponent(MediaBoxElement r100, TextElement r101, int r102, MediaScrollBoxComponent r103, TextWithOneIconElement r104, int r105, List<SkuBaseInfoDataModel> r106) {
        this.mainSkuImage = r100;
        this.skuNumContent = r101;
        this.textSpace = r102;
        this.thumbnail = r103;
        this.moreSkuInfoContent = r104;
        this.selectedIndex = r105;
        this.skuPriceList = r106;
    }

    public /* synthetic */ SkuBaseInfoComponent(MediaBoxElement r100, TextElement r101, int r102, MediaScrollBoxComponent r110, TextWithOneIconElement r111, int r112, List r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        MediaBoxElement r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        TextElement r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r104 = 10;
    L15:
        if ((r114 & 8) == 0) goto L17;
        MediaScrollBoxComponent r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        TextWithOneIconElement r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        int r107 = -1;
    L27:
        if ((r114 & 64) == 0) goto L29;
        List r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
