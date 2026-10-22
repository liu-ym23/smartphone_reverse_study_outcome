package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import androidx.camera.core.processing.util.GLUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;
import java.math.RoundingMode;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\rJ$\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003J \u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0003H\u0002J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "", "type", "", "minPrice", "", "maxPrice", "marketPrice", "typeText", "", "originalPrice", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)V", "getMarketPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaxPrice", "getMinPrice", "getOriginalPrice", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTypeText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "equals", "", "other", "getPrice", "getPromoPrice", "showTenThous", "integerLenLimit", SubInfo.KEY_FORMAT, "getRealFormat", "price", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceStruct {

    @SerializedName("market_price")
    private final Double marketPrice;

    @SerializedName("max_price")
    private final Double maxPrice;

    @SerializedName("min_price")
    private final Double minPrice;

    @SerializedName(BdpAppEventConstant.PARAMS_ORIGINAL_PRICE)
    private final Double originalPrice;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("type_text")
    private final String typeText;

    public PriceStruct() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PriceStruct copy$default(PriceStruct r100, Integer r101, Double r102, Double r103, Double r104, String r105, Double r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.minPrice;
    L8:
        Double r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.maxPrice;
    L11:
        Double r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.marketPrice;
    L14:
        Double r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.typeText;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.originalPrice;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.type;
    }

    public final Double component2() {
        return this.minPrice;
    }

    public final Double component3() {
        return this.maxPrice;
    }

    public final Double component4() {
        return this.marketPrice;
    }

    public final String component5() {
        return this.typeText;
    }

    public final Double component6() {
        return this.originalPrice;
    }

    public final PriceStruct copy(Integer r100, Double r110, Double r111, Double r112, String r113, Double r114) {
        return new PriceStruct(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PriceStruct) == false) goto L18;
        PriceStruct r101 = (PriceStruct) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.minPrice, r101.minPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxPrice, r101.maxPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.typeText, r101.typeText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.originalPrice, r101.originalPrice) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Double r104 = this.minPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.maxPrice;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.marketPrice;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.typeText;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.originalPrice;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "PriceStruct(type=" + this.type + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", marketPrice=" + this.marketPrice + ", typeText=" + this.typeText + ", originalPrice=" + this.originalPrice + ")";
    }

    private final Double getPrice() {
        Double r100 = this.minPrice;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.marketPrice;
    }

    public final Double getMarketPrice() {
        return this.marketPrice;
    }

    public final Double getMaxPrice() {
        return this.maxPrice;
    }

    public final Double getMinPrice() {
        return this.minPrice;
    }

    public final Double getOriginalPrice() {
        return this.originalPrice;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getTypeText() {
        return this.typeText;
    }

    private final int getRealFormat(int r100, double r101, int r102) {
        if (((int) (r101 / ((double) 1000000))) <= Math.pow(10.0d, r100 + 1)) goto L6;
        return 0;
    L6:
        return r102;
    }

    public final String getPromoPrice(boolean r100, int r110, int r111) {
        Double r101 = getPrice();
        if (r101 == null) goto L12;
        double r102 = r101.doubleValue();
        NumberFormat r103 = NumberFormat.getNumberInstance();
        r103.setGroupingUsed(false);
        r103.setRoundingMode(RoundingMode.DOWN);
        double r104 = r102 / ((double) 100);
        if (r104 >= 0.1d) goto L7;
        r103.setMaximumFractionDigits(2);
        return r103.format(r102);
    L7:
        double r105 = 1000000;
        if (r102 < r105) goto L11;
        if (r100 == false) goto L11;
        double r106 = r102 / r105;
        r103.setMaximumFractionDigits(getRealFormat(r110, r106, r111));
        return r103.format(r106) + 19975;
    L11:
        r103.setMaximumFractionDigits(getRealFormat(r110, r104, r111));
        return r103.format(r104);
    L12:
        return GLUtils.VERSION_UNKNOWN;
    }

    public PriceStruct(Integer r100, Double r101, Double r102, Double r103, String r104, Double r105) {
        this.type = r100;
        this.minPrice = r101;
        this.maxPrice = r102;
        this.marketPrice = r103;
        this.typeText = r104;
        this.originalPrice = r105;
    }

    public static /* synthetic */ String getPromoPrice$default(PriceStruct r100, boolean r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = 4;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = 2;
    L12:
        return r100.getPromoPrice(r101, r102, r103);
    }

    public /* synthetic */ PriceStruct(Integer r100, Double r101, Double r102, Double r103, String r110, Double r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Double r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Double r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Double r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Double r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
