package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b3\u00104J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003Jn\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001J\u0013\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b)\u0010(R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b*\u0010(R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b+\u0010(R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b.\u0010(R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b/\u0010(R\u001a\u0010\u001d\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsStruct;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/c;", "", "getEnterFromStr", "getSearchChannelStr", "getSearchSourceStr", "getProductIdStr", "", "getShownCountInt", "()Ljava/lang/Integer;", "getProductNameStr", "getImageUriStr", "getTypeInt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "enterFrom", "searchChannel", "searchSource", "productId", "shownCount", "productName", "imageUri", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;I)Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsStruct;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "getSearchChannel", "getSearchSource", "getProductId", "Ljava/lang/Integer;", "getShownCount", "getProductName", "getImageUri", "I", "getType", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicSearchGoodsStruct implements Serializable, c {

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("image_uri")
    private final String imageUri;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_name")
    private final String productName;

    @SerializedName("search_channel")
    private final String searchChannel;

    @SerializedName("search_source")
    private final String searchSource;

    @SerializedName("shown_count")
    private final Integer shownCount;

    @SerializedName("type")
    private final int type;

    public PicSearchGoodsStruct() {
        this(null, null, null, null, null, null, null, 0, 255, null);
    }

    public static /* synthetic */ PicSearchGoodsStruct copy$default(PicSearchGoodsStruct r100, String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.enterFrom;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.searchChannel;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.searchSource;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.productId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.shownCount;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.productName;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.imageUri;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.type;
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

    public final String component1() {
        return this.enterFrom;
    }

    public final String component2() {
        return this.searchChannel;
    }

    public final String component3() {
        return this.searchSource;
    }

    public final String component4() {
        return this.productId;
    }

    public final Integer component5() {
        return this.shownCount;
    }

    public final String component6() {
        return this.productName;
    }

    public final String component7() {
        return this.imageUri;
    }

    public final int component8() {
        return this.type;
    }

    public final PicSearchGoodsStruct copy(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, int r117) {
        return new PicSearchGoodsStruct(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PicSearchGoodsStruct) == false) goto L22;
        PicSearchGoodsStruct r101 = (PicSearchGoodsStruct) r100;
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.searchChannel, r101.searchChannel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchSource, r101.searchSource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shownCount, r101.shownCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.productName, r101.productName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUri, r101.imageUri) == true) goto L20;
        return false;
    L20:
        if (this.type == r101.type) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getBlockNameStr() {
        return null;
    }

    public String getFindSameSchemaStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public Integer getPageCounterInt() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public Integer getPageCursorInt() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getRecommendProductIdStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSceneIdStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSceneProductIdStr() {
        return null;
    }

    public int hashCode() {
        String r100 = this.enterFrom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.searchChannel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.searchSource;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.productId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.shownCount;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.productName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.imageUri;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return ((r118 + r101) * 31) + this.type;
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
        return "PicSearchGoodsStruct(enterFrom=" + this.enterFrom + ", searchChannel=" + this.searchChannel + ", searchSource=" + this.searchSource + ", productId=" + this.productId + ", shownCount=" + this.shownCount + ", productName=" + this.productName + ", imageUri=" + this.imageUri + ", type=" + this.type + ")";
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getEnterFromStr() {
        return this.enterFrom;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getImageUriStr() {
        return this.imageUri;
    }

    public final String getProductId() {
        return this.productId;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getProductIdStr() {
        return this.productId;
    }

    public final String getProductName() {
        return this.productName;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getProductNameStr() {
        return this.productName;
    }

    public final String getSearchChannel() {
        return this.searchChannel;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSearchChannelStr() {
        return this.searchChannel;
    }

    public final String getSearchSource() {
        return this.searchSource;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSearchSourceStr() {
        return this.searchSource;
    }

    public final Integer getShownCount() {
        return this.shownCount;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public Integer getShownCountInt() {
        return this.shownCount;
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public int getTypeInt() {
        return this.type;
    }

    public PicSearchGoodsStruct(String r100, String r101, String r102, String r103, Integer r104, String r105, String r106, int r107) {
        this.enterFrom = r100;
        this.searchChannel = r101;
        this.searchSource = r102;
        this.productId = r103;
        this.shownCount = r104;
        this.productName = r105;
        this.imageUri = r106;
        this.type = r107;
    }

    public /* synthetic */ PicSearchGoodsStruct(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, int r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r107 = 0;
    L34:
        this(r101, r102, r103, r104, r105, r106, r100, r107);
        return;
    L33:
        r107 = r117;
        goto L34
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
