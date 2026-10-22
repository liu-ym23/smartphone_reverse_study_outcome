package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJT\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECCombinationProduct;", "Ljava/io/Serializable;", "id", "", "promotionId", "coverUrl", "name", "minPrice", "", "maxPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;)V", "getCoverUrl", "()Ljava/lang/String;", "getId", "getMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMinPrice", "()J", "getName", "getPromotionId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;)Lcom/bytedance/android/ec/model/response/ECCombinationProduct;", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECCombinationProduct implements Serializable {

    @SerializedName("cover_url")
    private final String coverUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f47899id;

    @SerializedName("max_price")
    private final Long maxPrice;

    @SerializedName("min_price")
    private final long minPrice;

    @SerializedName("name")
    private final String name;

    @SerializedName("promotion_id")
    private final String promotionId;

    public ECCombinationProduct() {
        this(null, null, null, null, 0, null, 63, null);
    }

    public static /* synthetic */ ECCombinationProduct copy$default(ECCombinationProduct r100, String r101, String r102, String r103, String r104, long r110, Long r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.f47899id;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.promotionId;
    L8:
        String r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.coverUrl;
    L11:
        String r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.name;
    L14:
        String r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.minPrice;
    L17:
        long r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.maxPrice;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.f47899id;
    }

    public final String component2() {
        return this.promotionId;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final String component4() {
        return this.name;
    }

    public final long component5() {
        return this.minPrice;
    }

    public final Long component6() {
        return this.maxPrice;
    }

    public final ECCombinationProduct copy(String r110, String r111, String r112, String r113, long r114, Long r115) {
        return new ECCombinationProduct(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECCombinationProduct) == false) goto L18;
        ECCombinationProduct r101 = (ECCombinationProduct) r100;
        if (Intrinsics.areEqual(this.f47899id, r101.f47899id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (this.minPrice == r101.minPrice) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.maxPrice, r101.maxPrice) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.f47899id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.coverUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.name;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.minPrice;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        Long r115 = this.maxPrice;
        if (r115 == null) goto L22;
        r101 = r115.hashCode();
    L22:
        return r114 + r101;
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
        return "ECCombinationProduct(id=" + this.f47899id + ", promotionId=" + this.promotionId + ", coverUrl=" + this.coverUrl + ", name=" + this.name + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ")";
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getId() {
        return this.f47899id;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final long getMinPrice() {
        return this.minPrice;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public ECCombinationProduct(String r100, String r101, String r102, String r103, long r104, Long r105) {
        this.f47899id = r100;
        this.promotionId = r101;
        this.coverUrl = r102;
        this.name = r103;
        this.minPrice = r104;
        this.maxPrice = r105;
    }

    public /* synthetic */ ECCombinationProduct(String r100, String r101, String r102, String r110, long r111, Long r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        r111 = 0;
    L21:
        long r106 = r111;
        if ((r113 & 32) == 0) goto L24;
        Long r116 = null;
    L25:
        this(r115, r103, r104, r105, r106, r116);
        return;
    L24:
        r116 = r112;
        goto L25
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
        r115 = r100;
        goto L7
    }
}
