package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ProductShelfExperimentConfig;", "", "productImgShow", "", "productTitleShow", "productListShow", "productCourseNumShow", "productGiveawayShow", "productValidityShow", "productPriceShow", "(ZZZZZZZ)V", "getProductCourseNumShow", "()Z", "getProductGiveawayShow", "getProductImgShow", "getProductListShow", "getProductPriceShow", "getProductTitleShow", "getProductValidityShow", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductShelfExperimentConfig {

    @SerializedName("product_course_num_show")
    private final boolean productCourseNumShow;

    @SerializedName("product_giveaway_show")
    private final boolean productGiveawayShow;

    @SerializedName("product_img_show")
    private final boolean productImgShow;

    @SerializedName("product_list_show")
    private final boolean productListShow;

    @SerializedName("product_price_show")
    private final boolean productPriceShow;

    @SerializedName("product_title_show")
    private final boolean productTitleShow;

    @SerializedName("product_validity_show")
    private final boolean productValidityShow;

    public ProductShelfExperimentConfig() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ ProductShelfExperimentConfig copy$default(ProductShelfExperimentConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.productImgShow;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.productTitleShow;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.productListShow;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.productCourseNumShow;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.productGiveawayShow;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.productValidityShow;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.productPriceShow;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.productImgShow;
    }

    public final boolean component2() {
        return this.productTitleShow;
    }

    public final boolean component3() {
        return this.productListShow;
    }

    public final boolean component4() {
        return this.productCourseNumShow;
    }

    public final boolean component5() {
        return this.productGiveawayShow;
    }

    public final boolean component6() {
        return this.productValidityShow;
    }

    public final boolean component7() {
        return this.productPriceShow;
    }

    public final ProductShelfExperimentConfig copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116) {
        return new ProductShelfExperimentConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductShelfExperimentConfig) == false) goto L20;
        ProductShelfExperimentConfig r101 = (ProductShelfExperimentConfig) r100;
        if (this.productImgShow == r101.productImgShow) goto L8;
        return false;
    L8:
        if (this.productTitleShow == r101.productTitleShow) goto L10;
        return false;
    L10:
        if (this.productListShow == r101.productListShow) goto L12;
        return false;
    L12:
        if (this.productCourseNumShow == r101.productCourseNumShow) goto L14;
        return false;
    L14:
        if (this.productGiveawayShow == r101.productGiveawayShow) goto L16;
        return false;
    L16:
        if (this.productValidityShow == r101.productValidityShow) goto L18;
        return false;
    L18:
        if (this.productPriceShow == r101.productPriceShow) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean r100 = this.productImgShow;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.productTitleShow;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.productListShow;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.productCourseNumShow;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.productGiveawayShow;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.productValidityShow;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.productPriceShow;
        if (r119 == true) goto L25;
        r101 = r119;
    L25:
        return r118 + r101;
    }

    public String toString() {
        return "ProductShelfExperimentConfig(productImgShow=" + this.productImgShow + ", productTitleShow=" + this.productTitleShow + ", productListShow=" + this.productListShow + ", productCourseNumShow=" + this.productCourseNumShow + ", productGiveawayShow=" + this.productGiveawayShow + ", productValidityShow=" + this.productValidityShow + ", productPriceShow=" + this.productPriceShow + ")";
    }

    public final boolean getProductCourseNumShow() {
        return this.productCourseNumShow;
    }

    public final boolean getProductGiveawayShow() {
        return this.productGiveawayShow;
    }

    public final boolean getProductImgShow() {
        return this.productImgShow;
    }

    public final boolean getProductListShow() {
        return this.productListShow;
    }

    public final boolean getProductPriceShow() {
        return this.productPriceShow;
    }

    public final boolean getProductTitleShow() {
        return this.productTitleShow;
    }

    public final boolean getProductValidityShow() {
        return this.productValidityShow;
    }

    public ProductShelfExperimentConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.productImgShow = r100;
        this.productTitleShow = r101;
        this.productListShow = r102;
        this.productCourseNumShow = r103;
        this.productGiveawayShow = r104;
        this.productValidityShow = r105;
        this.productPriceShow = r106;
    }

    public /* synthetic */ ProductShelfExperimentConfig(boolean r100, boolean r101, boolean r102, boolean r110, boolean r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r114 & 64) == 0) goto L29;
        boolean r117 = false;
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
