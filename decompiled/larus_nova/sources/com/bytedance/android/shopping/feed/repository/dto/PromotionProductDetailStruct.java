package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wd3.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002¢\u0006\u0004\b4\u00105J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002HÆ\u0003J\u0081\u0001\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002HÆ\u0001J\t\u0010\u001b\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001cHÖ\u0001J\u0013\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b%\u0010$R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b)\u0010$R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b1\u00102R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b3\u0010$¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/PromotionProductDetailStruct;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component1", "Lcom/bytedance/android/shopping/feed/repository/dto/DetailImageStruct;", "component2", "component3", "Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormatGroup;", "component4", "Lwd3/a;", "component5", "Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesComponent;", "component6", "", "component7", "Lcom/bytedance/android/shopping/feed/repository/dto/DetailDescriptionCfgStruct;", "component8", "detailImgs", "newDetailImgs", "titleImage", "productFormat", "detailTopTagComponent", "combineProperties", "jumpUrl", "detailConfig", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getDetailImgs", "()Ljava/util/List;", "getNewDetailImgs", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTitleImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getProductFormat", "Lwd3/a;", "getDetailTopTagComponent", "()Lwd3/a;", "Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesComponent;", "getCombineProperties", "()Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesComponent;", "Ljava/lang/String;", "getJumpUrl", "()Ljava/lang/String;", "getDetailConfig", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Lwd3/a;Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesComponent;Ljava/lang/String;Ljava/util/List;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductDetailStruct implements Serializable {

    @SerializedName("combining_properties")
    private final DetailCombinePropertiesComponent combineProperties;

    @SerializedName("detail_config")
    private final List<DetailDescriptionCfgStruct> detailConfig;

    @SerializedName("detail_imgs")
    private final List<ECUrlModel> detailImgs;

    @SerializedName("detail_top_tag_component")
    private final a detailTopTagComponent;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("detail_imgs_new")
    private final List<DetailImageStruct> newDetailImgs;

    @SerializedName("product_format")
    private final List<ProductFormatGroup> productFormat;

    @SerializedName("title_image")
    private final ECUrlModel titleImage;

    public PromotionProductDetailStruct() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionProductDetailStruct copy$default(PromotionProductDetailStruct r100, List r110, List r111, ECUrlModel r112, List r113, a r114, DetailCombinePropertiesComponent r115, String r116, List r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        List r101 = r100.detailImgs;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = r100.newDetailImgs;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ECUrlModel r103 = r100.titleImage;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.productFormat;
    L19:
        if ((r118 & 16) == 0) goto L21;
        a r105 = r100.detailTopTagComponent;
    L23:
        if ((r118 & 32) == 0) goto L25;
        DetailCombinePropertiesComponent r106 = r100.combineProperties;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.jumpUrl;
    L31:
        if ((r118 & 128) == 0) goto L33;
        List r108 = r100.detailConfig;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final List<ECUrlModel> component1() {
        return this.detailImgs;
    }

    public final List<DetailImageStruct> component2() {
        return this.newDetailImgs;
    }

    public final ECUrlModel component3() {
        return this.titleImage;
    }

    public final List<ProductFormatGroup> component4() {
        return this.productFormat;
    }

    public final a component5() {
        return this.detailTopTagComponent;
    }

    public final DetailCombinePropertiesComponent component6() {
        return this.combineProperties;
    }

    public final String component7() {
        return this.jumpUrl;
    }

    public final List<DetailDescriptionCfgStruct> component8() {
        return this.detailConfig;
    }

    public final PromotionProductDetailStruct copy(List<? extends ECUrlModel> r110, List<DetailImageStruct> r111, ECUrlModel r112, List<ProductFormatGroup> r113, a r114, DetailCombinePropertiesComponent r115, String r116, List<DetailDescriptionCfgStruct> r117) {
        return new PromotionProductDetailStruct(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductDetailStruct) == false) goto L22;
        PromotionProductDetailStruct r101 = (PromotionProductDetailStruct) r100;
        if (Intrinsics.areEqual(this.detailImgs, r101.detailImgs) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.newDetailImgs, r101.newDetailImgs) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.titleImage, r101.titleImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productFormat, r101.productFormat) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.detailTopTagComponent, r101.detailTopTagComponent) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.combineProperties, r101.combineProperties) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.detailConfig, r101.detailConfig) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        List<ECUrlModel> r100 = this.detailImgs;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<DetailImageStruct> r104 = this.newDetailImgs;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.titleImage;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ProductFormatGroup> r110 = this.productFormat;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.detailTopTagComponent;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        DetailCombinePropertiesComponent r116 = this.combineProperties;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.jumpUrl;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        List<DetailDescriptionCfgStruct> r122 = this.detailConfig;
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
        return "PromotionProductDetailStruct(detailImgs=" + this.detailImgs + ", newDetailImgs=" + this.newDetailImgs + ", titleImage=" + this.titleImage + ", productFormat=" + this.productFormat + ", detailTopTagComponent=" + this.detailTopTagComponent + ", combineProperties=" + this.combineProperties + ", jumpUrl=" + this.jumpUrl + ", detailConfig=" + this.detailConfig + ")";
    }

    public final DetailCombinePropertiesComponent getCombineProperties() {
        return this.combineProperties;
    }

    public final List<DetailDescriptionCfgStruct> getDetailConfig() {
        return this.detailConfig;
    }

    public final List<ECUrlModel> getDetailImgs() {
        return this.detailImgs;
    }

    public final a getDetailTopTagComponent() {
        return this.detailTopTagComponent;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<DetailImageStruct> getNewDetailImgs() {
        return this.newDetailImgs;
    }

    public final List<ProductFormatGroup> getProductFormat() {
        return this.productFormat;
    }

    public final ECUrlModel getTitleImage() {
        return this.titleImage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PromotionProductDetailStruct(List<? extends ECUrlModel> r100, List<DetailImageStruct> r101, ECUrlModel r102, List<ProductFormatGroup> r103, a r104, DetailCombinePropertiesComponent r105, String r106, List<DetailDescriptionCfgStruct> r107) {
        this.detailImgs = r100;
        this.newDetailImgs = r101;
        this.titleImage = r102;
        this.productFormat = r103;
        this.detailTopTagComponent = r104;
        this.combineProperties = r105;
        this.jumpUrl = r106;
        this.detailConfig = r107;
    }

    public /* synthetic */ PromotionProductDetailStruct(List r110, List r111, ECUrlModel r112, List r113, a r114, DetailCombinePropertiesComponent r115, String r116, List r117, int r118, DefaultConstructorMarker r119) {
        List r100 = null;
        if ((r118 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ECUrlModel r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        a r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        DetailCombinePropertiesComponent r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
