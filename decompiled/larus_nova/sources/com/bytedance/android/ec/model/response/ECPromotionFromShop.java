package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionFromShop;", "Ljava/io/Serializable;", "shopName", "", "shopSchema", "shopAuthorId", "carouselTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCarouselTime", "()J", "getShopAuthorId", "()Ljava/lang/String;", "getShopName", "getShopSchema", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionFromShop implements Serializable {

    @SerializedName("carousel_time")
    private final long carouselTime;

    @SerializedName("author_id")
    private final String shopAuthorId;

    @SerializedName("name")
    private final String shopName;

    @SerializedName("schema")
    private final String shopSchema;

    public ECPromotionFromShop() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ ECPromotionFromShop copy$default(ECPromotionFromShop r100, String r101, String r102, String r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.shopName;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.shopSchema;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.shopAuthorId;
    L11:
        String r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.carouselTime;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.shopName;
    }

    public final String component2() {
        return this.shopSchema;
    }

    public final String component3() {
        return this.shopAuthorId;
    }

    public final long component4() {
        return this.carouselTime;
    }

    public final ECPromotionFromShop copy(String r100, String r101, String r110, long r111) {
        return new ECPromotionFromShop(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionFromShop) == false) goto L14;
        ECPromotionFromShop r101 = (ECPromotionFromShop) r100;
        if (Intrinsics.areEqual(this.shopName, r101.shopName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopSchema, r101.shopSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopAuthorId, r101.shopAuthorId) == true) goto L12;
        return false;
    L12:
        if (this.carouselTime == r101.carouselTime) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.shopName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.shopSchema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopAuthorId;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.carouselTime;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECPromotionFromShop(shopName=" + this.shopName + ", shopSchema=" + this.shopSchema + ", shopAuthorId=" + this.shopAuthorId + ", carouselTime=" + this.carouselTime + ")";
    }

    public final long getCarouselTime() {
        return this.carouselTime;
    }

    public final String getShopAuthorId() {
        return this.shopAuthorId;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final String getShopSchema() {
        return this.shopSchema;
    }

    public ECPromotionFromShop(String r100, String r101, String r102, long r103) {
        this.shopName = r100;
        this.shopSchema = r101;
        this.shopAuthorId = r102;
        this.carouselTime = r103;
    }

    public /* synthetic */ ECPromotionFromShop(String r100, String r101, String r102, long r103, int r104, DefaultConstructorMarker r105) {
        String r106 = "";
        if ((r104 & 1) == 0) goto L5;
        String r107 = "";
    L7:
        if ((r104 & 2) == 0) goto L9;
        String r108 = "";
    L11:
        if ((r104 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        long r109 = r103;
        this(r107, r108, r106, r109);
        return;
    L9:
        r108 = r101;
        goto L11
    L5:
        r107 = r100;
        goto L7
    }
}
