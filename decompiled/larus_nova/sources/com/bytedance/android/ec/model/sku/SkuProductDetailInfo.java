package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.model.ProductPriceInfo;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u0018\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010#\u001a\u00020\nHÆ\u0003Jd\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "Ljava/io/Serializable;", "skuBigImageUrl", "", "skuPrice", "Lcom/bytedance/android/ec/model/ProductPriceInfo;", "epInfo", "", "skuName", "isSkuInfo", "", "specArray", "", "needRefreshFromServer", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ProductPriceInfo;Ljava/lang/Object;Ljava/lang/String;Z[Ljava/lang/String;Z)V", "getEpInfo", "()Ljava/lang/Object;", "()Z", "getNeedRefreshFromServer", "setNeedRefreshFromServer", "(Z)V", "getSkuBigImageUrl", "()Ljava/lang/String;", "getSkuName", "getSkuPrice", "()Lcom/bytedance/android/ec/model/ProductPriceInfo;", "getSpecArray", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ProductPriceInfo;Ljava/lang/Object;Ljava/lang/String;Z[Ljava/lang/String;Z)Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "equals", "other", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuProductDetailInfo implements Serializable {
    private final Object epInfo;
    private final boolean isSkuInfo;
    private boolean needRefreshFromServer;
    private final String skuBigImageUrl;
    private final String skuName;
    private final ProductPriceInfo skuPrice;
    private final String[] specArray;

    public static /* synthetic */ SkuProductDetailInfo copy$default(SkuProductDetailInfo r100, String r101, ProductPriceInfo r102, Object r103, String r104, boolean r110, String[] r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.skuBigImageUrl;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.skuPrice;
    L8:
        ProductPriceInfo r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.epInfo;
    L11:
        Object r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.skuName;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isSkuInfo;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.specArray;
    L20:
        String[] r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.needRefreshFromServer;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.skuBigImageUrl;
    }

    public final ProductPriceInfo component2() {
        return this.skuPrice;
    }

    public final Object component3() {
        return this.epInfo;
    }

    public final String component4() {
        return this.skuName;
    }

    public final boolean component5() {
        return this.isSkuInfo;
    }

    public final String[] component6() {
        return this.specArray;
    }

    public final boolean component7() {
        return this.needRefreshFromServer;
    }

    public final SkuProductDetailInfo copy(String r110, ProductPriceInfo r111, Object r112, String r113, boolean r114, String[] r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r111, "skuPrice");
        return new SkuProductDetailInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuProductDetailInfo) == false) goto L20;
        SkuProductDetailInfo r101 = (SkuProductDetailInfo) r100;
        if (Intrinsics.areEqual(this.skuBigImageUrl, r101.skuBigImageUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skuPrice, r101.skuPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.epInfo, r101.epInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skuName, r101.skuName) == true) goto L14;
        return false;
    L14:
        if (this.isSkuInfo == r101.isSkuInfo) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.specArray, r101.specArray) == true) goto L18;
        return false;
    L18:
        if (this.needRefreshFromServer == r101.needRefreshFromServer) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.skuBigImageUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ProductPriceInfo r104 = this.skuPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.epInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.skuName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.isSkuInfo;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        String[] r117 = this.specArray;
        if (r117 == null) goto L24;
        r101 = Arrays.hashCode(r117);
    L24:
        int r118 = (r116 + r101) * 31;
        boolean r119 = this.needRefreshFromServer;
        if (r119 == true) goto L29;
        r114 = r119;
    L29:
        return r118 + r114;
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
        return "SkuProductDetailInfo(skuBigImageUrl=" + this.skuBigImageUrl + ", skuPrice=" + this.skuPrice + ", epInfo=" + this.epInfo + ", skuName=" + this.skuName + ", isSkuInfo=" + this.isSkuInfo + ", specArray=" + Arrays.toString(this.specArray) + ", needRefreshFromServer=" + this.needRefreshFromServer + ")";
    }

    public final Object getEpInfo() {
        return this.epInfo;
    }

    public final boolean getNeedRefreshFromServer() {
        return this.needRefreshFromServer;
    }

    public final String getSkuBigImageUrl() {
        return this.skuBigImageUrl;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public final ProductPriceInfo getSkuPrice() {
        return this.skuPrice;
    }

    public final String[] getSpecArray() {
        return this.specArray;
    }

    public final boolean isSkuInfo() {
        return this.isSkuInfo;
    }

    public final void setNeedRefreshFromServer(boolean r100) {
        this.needRefreshFromServer = r100;
    }

    public SkuProductDetailInfo(String r100, ProductPriceInfo r101, Object r102, String r103, boolean r104, String[] r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "skuPrice");
        this.skuBigImageUrl = r100;
        this.skuPrice = r101;
        this.epInfo = r102;
        this.skuName = r103;
        this.isSkuInfo = r104;
        this.specArray = r105;
        this.needRefreshFromServer = r106;
    }

    public /* synthetic */ SkuProductDetailInfo(String r110, ProductPriceInfo r111, Object r112, String r113, boolean r114, String[] r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r117 & 32) == 0) goto L17;
        String[] r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        boolean r104 = true;
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
