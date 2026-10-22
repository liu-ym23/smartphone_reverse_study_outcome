package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J_\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/end/ProductItem;", "", "productId", "", "name", "imageList", "", "shortTitle", "price", "", "originalPrice", "recommendTag", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JJLjava/lang/String;)V", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOriginalPrice", "()J", "setOriginalPrice", "(J)V", "getPrice", "setPrice", "getProductId", "setProductId", "getRecommendTag", "setRecommendTag", "getShortTitle", "setShortTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProductItem {

    @SerializedName("img_url_list")
    private List<String> imageList;

    @SerializedName("name")
    private String name;

    @SerializedName("market_price")
    private long originalPrice;

    @SerializedName("price")
    private long price;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("recommend_tag")
    private String recommendTag;

    @SerializedName("short_title")
    private String shortTitle;

    public ProductItem() {
        this(null, null, null, null, 0, 0, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductItem copy$default(ProductItem r110, String r111, String r112, List r113, String r114, long r115, long r116, String r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.productId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r102 = r110.imageList;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.shortTitle;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.price;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.originalPrice;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.recommendTag;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
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
        return this.productId;
    }

    public final String component2() {
        return this.name;
    }

    public final List<String> component3() {
        return this.imageList;
    }

    public final String component4() {
        return this.shortTitle;
    }

    public final long component5() {
        return this.price;
    }

    public final long component6() {
        return this.originalPrice;
    }

    public final String component7() {
        return this.recommendTag;
    }

    public final ProductItem copy(String r110, String r111, List<String> r112, String r113, long r114, long r115, String r210) {
        return new ProductItem(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductItem) == false) goto L20;
        ProductItem r101 = (ProductItem) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageList, r101.imageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shortTitle, r101.shortTitle) == true) goto L14;
        return false;
    L14:
        if (this.price == r101.price) goto L16;
        return false;
    L16:
        if (this.originalPrice == r101.originalPrice) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendTag, r101.recommendTag) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.imageList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.shortTitle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.price;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.originalPrice;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        String r117 = this.recommendTag;
        if (r117 == null) goto L22;
        r101 = r117.hashCode();
    L22:
        return r116 + r101;
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
        return "ProductItem(productId=" + this.productId + ", name=" + this.name + ", imageList=" + this.imageList + ", shortTitle=" + this.shortTitle + ", price=" + this.price + ", originalPrice=" + this.originalPrice + ", recommendTag=" + this.recommendTag + ")";
    }

    public final List<String> getImageList() {
        return this.imageList;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOriginalPrice() {
        return this.originalPrice;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRecommendTag() {
        return this.recommendTag;
    }

    public final String getShortTitle() {
        return this.shortTitle;
    }

    public final void setImageList(List<String> r100) {
        this.imageList = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setOriginalPrice(long r100) {
        this.originalPrice = r100;
    }

    public final void setPrice(long r100) {
        this.price = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setRecommendTag(String r100) {
        this.recommendTag = r100;
    }

    public final void setShortTitle(String r100) {
        this.shortTitle = r100;
    }

    public ProductItem(String r100, String r101, List<String> r102, String r103, long r104, long r105, String r106) {
        this.productId = r100;
        this.name = r101;
        this.imageList = r102;
        this.shortTitle = r103;
        this.price = r104;
        this.originalPrice = r105;
        this.recommendTag = r106;
    }

    public /* synthetic */ ProductItem(String r110, String r111, List r112, String r113, long r114, long r115, String r116, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L18:
        long r105 = 0;
        if ((r210 & 16) == 0) goto L21;
        long r106 = 0;
    L23:
        if ((r210 & 32) != 0) goto L27;
        r105 = r115;
    L27:
        if ((r210 & 64) != 0) goto L30;
        r100 = r116;
    L30:
        this(r101, r102, r103, r104, r106, r105, r100);
        return;
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
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
