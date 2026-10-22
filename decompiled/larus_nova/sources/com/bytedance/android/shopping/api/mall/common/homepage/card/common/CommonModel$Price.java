package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.crash.dumper.Scraps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003JE\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019¨\u0006!"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price", "", "", "component1", "component2", "component3", "component4", "component5", "component6", "kind", "integers", "decimals", Scraps.INNER_UNIT, "above", "label", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKind", "()Ljava/lang/String;", "getIntegers", "getDecimals", "getUnit", "getAbove", "getLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$Price {
    private final String above;
    private final String decimals;
    private final String integers;
    private final String kind;
    private final String label;
    private final String unit;

    public static /* synthetic */ CommonModel$Price copy$default(CommonModel$Price r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.kind;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.integers;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.decimals;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.unit;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.above;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.label;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.kind;
    }

    public final String component2() {
        return this.integers;
    }

    public final String component3() {
        return this.decimals;
    }

    public final String component4() {
        return this.unit;
    }

    public final String component5() {
        return this.above;
    }

    public final String component6() {
        return this.label;
    }

    public final CommonModel$Price copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r110, "integers");
        Intrinsics.checkNotNullParameter(r111, "decimals");
        Intrinsics.checkNotNullParameter(r112, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r113, "above");
        Intrinsics.checkNotNullParameter(r114, "label");
        return new CommonModel$Price(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$Price) == false) goto L18;
        CommonModel$Price r101 = (CommonModel$Price) r100;
        if (Intrinsics.areEqual(this.kind, r101.kind) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.integers, r101.integers) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.decimals, r101.decimals) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unit, r101.unit) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.above, r101.above) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.kind;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.integers;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.decimals;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.unit;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.above;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.label;
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
        return "Price(kind=" + this.kind + ", integers=" + this.integers + ", decimals=" + this.decimals + ", unit=" + this.unit + ", above=" + this.above + ", label=" + this.label + ")";
    }

    public final String getAbove() {
        return this.above;
    }

    public final String getDecimals() {
        return this.decimals;
    }

    public final String getIntegers() {
        return this.integers;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUnit() {
        return this.unit;
    }

    public CommonModel$Price(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "integers");
        Intrinsics.checkNotNullParameter(r102, "decimals");
        Intrinsics.checkNotNullParameter(r103, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r104, "above");
        Intrinsics.checkNotNullParameter(r105, "label");
        this.kind = r100;
        this.integers = r101;
        this.decimals = r102;
        this.unit = r103;
        this.above = r104;
        this.label = r105;
    }
}
