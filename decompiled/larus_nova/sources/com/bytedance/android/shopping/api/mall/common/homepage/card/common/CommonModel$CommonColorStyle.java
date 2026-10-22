package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003JE\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle", "", "", "component1", "component2", "component3", "component4", "component5", "color", "colorDark", "colorLight", "colorFrom", "colorTo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getColor", "()Ljava/lang/String;", "getColorDark", "getColorLight", "getColorFrom", "getColorTo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$CommonColorStyle {
    private final String color;
    private final String colorDark;
    private final String colorFrom;
    private final String colorLight;
    private final String colorTo;

    public CommonModel$CommonColorStyle() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CommonModel$CommonColorStyle copy$default(CommonModel$CommonColorStyle r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.color;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.colorDark;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.colorLight;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.colorFrom;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.colorTo;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.colorDark;
    }

    public final String component3() {
        return this.colorLight;
    }

    public final String component4() {
        return this.colorFrom;
    }

    public final String component5() {
        return this.colorTo;
    }

    public final CommonModel$CommonColorStyle copy(String r100, String r101, String r110, String r111, String r112) {
        return new CommonModel$CommonColorStyle(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$CommonColorStyle) == false) goto L16;
        CommonModel$CommonColorStyle r101 = (CommonModel$CommonColorStyle) r100;
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.colorDark, r101.colorDark) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.colorLight, r101.colorLight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorFrom, r101.colorFrom) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.colorTo, r101.colorTo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.color;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.colorDark;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.colorLight;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.colorFrom;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.colorTo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "CommonColorStyle(color=" + this.color + ", colorDark=" + this.colorDark + ", colorLight=" + this.colorLight + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
    }

    public final String getColor() {
        return this.color;
    }

    public final String getColorDark() {
        return this.colorDark;
    }

    public final String getColorFrom() {
        return this.colorFrom;
    }

    public final String getColorLight() {
        return this.colorLight;
    }

    public final String getColorTo() {
        return this.colorTo;
    }

    public CommonModel$CommonColorStyle(String r100, String r101, String r102, String r103, String r104) {
        this.color = r100;
        this.colorDark = r101;
        this.colorLight = r102;
        this.colorFrom = r103;
        this.colorTo = r104;
    }

    public /* synthetic */ CommonModel$CommonColorStyle(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
