package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J3\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "Lyu1/a;", "", "component1", "", "Lcom/bytedance/android/livesdk/end/ProductItem;", "component2", "component3", "shopSchema", "productItemList", "shopId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getShopSchema", "()Ljava/lang/String;", "setShopSchema", "(Ljava/lang/String;)V", "Ljava/util/List;", "getProductItemList", "()Ljava/util/List;", "setProductItemList", "(Ljava/util/List;)V", "getShopId", "setShopId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EndingPageShopCardInfo extends a {

    @SerializedName("product_list")
    private List<ProductItem> productItemList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shop_schema")
    private String shopSchema;

    public EndingPageShopCardInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EndingPageShopCardInfo copy$default(EndingPageShopCardInfo r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.shopSchema;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.productItemList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.shopId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.shopSchema;
    }

    public final List<ProductItem> component2() {
        return this.productItemList;
    }

    public final String component3() {
        return this.shopId;
    }

    public final EndingPageShopCardInfo copy(String r100, List<ProductItem> r101, String r102) {
        return new EndingPageShopCardInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EndingPageShopCardInfo) == false) goto L12;
        EndingPageShopCardInfo r101 = (EndingPageShopCardInfo) r100;
        if (Intrinsics.areEqual(this.shopSchema, r101.shopSchema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productItemList, r101.productItemList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.shopSchema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ProductItem> r104 = this.productItemList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EndingPageShopCardInfo(shopSchema=" + this.shopSchema + ", productItemList=" + this.productItemList + ", shopId=" + this.shopId + ")";
    }

    public final List<ProductItem> getProductItemList() {
        return this.productItemList;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShopSchema() {
        return this.shopSchema;
    }

    public final void setProductItemList(List<ProductItem> r100) {
        this.productItemList = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShopSchema(String r100) {
        this.shopSchema = r100;
    }

    public EndingPageShopCardInfo(String r100, List<ProductItem> r101, String r102) {
        this.shopSchema = r100;
        this.productItemList = r101;
        this.shopId = r102;
    }

    public /* synthetic */ EndingPageShopCardInfo(String r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
