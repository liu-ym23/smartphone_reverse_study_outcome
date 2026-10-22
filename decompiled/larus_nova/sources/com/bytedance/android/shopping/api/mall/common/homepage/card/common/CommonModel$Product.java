package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J[\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0002HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\"\u0010!R\u0017\u0010\u0013\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b)\u0010!R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b*\u0010!R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b\u0018\u0010/¨\u00062"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product", "", "", "isReturnRewardContainerVisible", "", "getRewardText", "component1", "component2", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "component3", "", "component4", "component5", "component6", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "component7", "component8", "cover", "title", "price", SalesInfoStruct.SALES, "accessibilityLabel", "recReason", "marketingData", "isCoverInPool", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getCover", "()Ljava/lang/String;", "getTitle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "I", "getSales", "()I", "getAccessibilityLabel", "getRecReason", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "getMarketingData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;Z)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$Product {
    private final String accessibilityLabel;
    private final String cover;
    private final boolean isCoverInPool;
    private final CommonData.MarketingData marketingData;
    private final CommonModel$Price price;
    private final String recReason;
    private final int sales;
    private final String title;

    public static /* synthetic */ CommonModel$Product copy$default(CommonModel$Product r100, String r110, String r111, CommonModel$Price r112, int r113, String r114, String r115, CommonData.MarketingData r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.cover;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.title;
    L11:
        if ((r118 & 4) == 0) goto L13;
        CommonModel$Price r103 = r100.price;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.sales;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.accessibilityLabel;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.recReason;
    L27:
        if ((r118 & 64) == 0) goto L29;
        CommonData.MarketingData r107 = r100.marketingData;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.isCoverInPool;
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
        return this.cover;
    }

    public final String component2() {
        return this.title;
    }

    public final CommonModel$Price component3() {
        return this.price;
    }

    public final int component4() {
        return this.sales;
    }

    public final String component5() {
        return this.accessibilityLabel;
    }

    public final String component6() {
        return this.recReason;
    }

    public final CommonData.MarketingData component7() {
        return this.marketingData;
    }

    public final boolean component8() {
        return this.isCoverInPool;
    }

    public final CommonModel$Product copy(String r110, String r111, CommonModel$Price r112, int r113, String r114, String r115, CommonData.MarketingData r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "cover");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "price");
        Intrinsics.checkNotNullParameter(r114, "accessibilityLabel");
        Intrinsics.checkNotNullParameter(r115, "recReason");
        return new CommonModel$Product(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$Product) == false) goto L22;
        CommonModel$Product r101 = (CommonModel$Product) r100;
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L12;
        return false;
    L12:
        if (this.sales == r101.sales) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.accessibilityLabel, r101.accessibilityLabel) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.recReason, r101.recReason) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marketingData, r101.marketingData) == true) goto L20;
        return false;
    L20:
        if (this.isCoverInPool == r101.isCoverInPool) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.cover;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CommonModel$Price r107 = this.price;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.sales) * 31;
        String r110 = this.accessibilityLabel;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.recReason;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        CommonData.MarketingData r116 = this.marketingData;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.isCoverInPool;
        ?? r119 = r118;
        if (r118 == false) goto L29;
        r119 = 1;
    L29:
        return r117 + r119;
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
        return "Product(cover=" + this.cover + ", title=" + this.title + ", price=" + this.price + ", sales=" + this.sales + ", accessibilityLabel=" + this.accessibilityLabel + ", recReason=" + this.recReason + ", marketingData=" + this.marketingData + ", isCoverInPool=" + this.isCoverInPool + ")";
    }

    public final String getRewardText() {
        StringBuilder r100 = new StringBuilder();
        CommonData.MarketingData r101 = this.marketingData;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getReturnRewardPrefix();
    L6:
        r100.append(r103);
        CommonData.MarketingData r104 = this.marketingData;
        if (r104 == null) goto L9;
        String r105 = r104.getReturnReward();
    L10:
        r100.append(r105);
        CommonData.MarketingData r106 = this.marketingData;
        if (r106 == null) goto L13;
        r102 = r106.getReturnRewardUnit();
    L13:
        r100.append(r102);
        return r100.toString();
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final boolean isReturnRewardContainerVisible() {
        CommonData.MarketingData r100 = this.marketingData;
        if (r100 == null) goto L5;
        String r101 = r100.getReturnRewardPrefix();
    L6:
        if (r101 != null) goto L8;
    L12:
        return false;
    L8:
        if (this.marketingData.getReturnReward() == null) goto L12;
        if (this.marketingData.getReturnRewardUnit() == null) goto L12;
        return true;
    L5:
        r101 = null;
        goto L6
    }

    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final String getCover() {
        return this.cover;
    }

    public final CommonData.MarketingData getMarketingData() {
        return this.marketingData;
    }

    public final CommonModel$Price getPrice() {
        return this.price;
    }

    public final String getRecReason() {
        return this.recReason;
    }

    public final int getSales() {
        return this.sales;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCoverInPool() {
        return this.isCoverInPool;
    }

    public CommonModel$Product(String r100, String r101, CommonModel$Price r102, int r103, String r104, String r105, CommonData.MarketingData r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "cover");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "price");
        Intrinsics.checkNotNullParameter(r104, "accessibilityLabel");
        Intrinsics.checkNotNullParameter(r105, "recReason");
        this.cover = r100;
        this.title = r101;
        this.price = r102;
        this.sales = r103;
        this.accessibilityLabel = r104;
        this.recReason = r105;
        this.marketingData = r106;
        this.isCoverInPool = r107;
    }

    public /* synthetic */ CommonModel$Product(String r110, String r111, CommonModel$Price r112, int r113, String r114, String r115, CommonData.MarketingData r116, boolean r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 32) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r210 & 64) == 0) goto L9;
        CommonData.MarketingData r101 = null;
    L11:
        if ((r210 & 128) == 0) goto L13;
        boolean r118 = false;
    L14:
        this(r110, r111, r112, r113, r114, r100, r101, r118);
        return;
    L13:
        r118 = r117;
        goto L14
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
