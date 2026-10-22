package com.bytedance.android.ec.model.sku;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuCheckResult;", "Ljava/io/Serializable;", "selectedSkuId", "", "checkedNameList", "", "count", "", "skuChosenPrice", "supermarketPopExtraParams", "", "", "(Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/util/Map;)V", "getCheckedNameList", "()Ljava/util/List;", "getCount", "()J", "getSelectedSkuId", "()Ljava/lang/String;", "getSkuChosenPrice", "getSupermarketPopExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuCheckResult implements Serializable {
    private final List<String> checkedNameList;
    private final long count;
    private final String selectedSkuId;
    private final String skuChosenPrice;
    private final Map<String, Object> supermarketPopExtraParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuCheckResult copy$default(SkuCheckResult r100, String r101, List r102, long r103, String r104, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.selectedSkuId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.checkedNameList;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.count;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.skuChosenPrice;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.supermarketPopExtraParams;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final String component1() {
        return this.selectedSkuId;
    }

    public final List<String> component2() {
        return this.checkedNameList;
    }

    public final long component3() {
        return this.count;
    }

    public final String component4() {
        return this.skuChosenPrice;
    }

    public final Map<String, Object> component5() {
        return this.supermarketPopExtraParams;
    }

    public final SkuCheckResult copy(String r100, List<String> r110, long r111, String r112, Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "selectedSkuId");
        Intrinsics.checkNotNullParameter(r110, "checkedNameList");
        return new SkuCheckResult(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuCheckResult) == false) goto L16;
        SkuCheckResult r101 = (SkuCheckResult) r100;
        if (Intrinsics.areEqual(this.selectedSkuId, r101.selectedSkuId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.checkedNameList, r101.checkedNameList) == true) goto L10;
        return false;
    L10:
        if (this.count == r101.count) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skuChosenPrice, r101.skuChosenPrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.supermarketPopExtraParams, r101.supermarketPopExtraParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.selectedSkuId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.checkedNameList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.count;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.skuChosenPrice;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Map<String, Object> r112 = this.supermarketPopExtraParams;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkuCheckResult(selectedSkuId=" + this.selectedSkuId + ", checkedNameList=" + this.checkedNameList + ", count=" + this.count + ", skuChosenPrice=" + this.skuChosenPrice + ", supermarketPopExtraParams=" + this.supermarketPopExtraParams + ")";
    }

    public final List<String> getCheckedNameList() {
        return this.checkedNameList;
    }

    public final long getCount() {
        return this.count;
    }

    public final String getSelectedSkuId() {
        return this.selectedSkuId;
    }

    public final String getSkuChosenPrice() {
        return this.skuChosenPrice;
    }

    public final Map<String, Object> getSupermarketPopExtraParams() {
        return this.supermarketPopExtraParams;
    }

    public SkuCheckResult(String r100, List<String> r101, long r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "selectedSkuId");
        Intrinsics.checkNotNullParameter(r101, "checkedNameList");
        this.selectedSkuId = r100;
        this.checkedNameList = r101;
        this.count = r102;
        this.skuChosenPrice = r103;
        this.supermarketPopExtraParams = r104;
    }

    public /* synthetic */ SkuCheckResult(String r110, List r111, long r112, String r113, Map r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 16) == 0) goto L9;
        Map r101 = null;
    L10:
        this(r110, r111, r112, r100, r101);
        return;
    L9:
        r101 = r114;
        goto L10
    L5:
        r100 = r113;
        goto L7
    }
}
