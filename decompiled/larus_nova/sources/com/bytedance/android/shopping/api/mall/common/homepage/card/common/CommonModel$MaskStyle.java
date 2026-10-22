package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J0\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001b"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle", "", "", "component1", "()Ljava/lang/Integer;", "", "component2", "component3", "height", "colorFrom", "colorTo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "getHeight", "Ljava/lang/String;", "getColorFrom", "()Ljava/lang/String;", "getColorTo", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$MaskStyle {
    private final String colorFrom;
    private final String colorTo;
    private final Integer height;

    public static /* synthetic */ CommonModel$MaskStyle copy$default(CommonModel$MaskStyle r100, Integer r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.height;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.colorFrom;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.colorTo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.height;
    }

    public final String component2() {
        return this.colorFrom;
    }

    public final String component3() {
        return this.colorTo;
    }

    public final CommonModel$MaskStyle copy(Integer r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "colorFrom");
        Intrinsics.checkNotNullParameter(r102, "colorTo");
        return new CommonModel$MaskStyle(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$MaskStyle) == false) goto L12;
        CommonModel$MaskStyle r101 = (CommonModel$MaskStyle) r100;
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.colorFrom, r101.colorFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.colorTo, r101.colorTo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.height;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.colorFrom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.colorTo;
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
        return "MaskStyle(height=" + this.height + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
    }

    public final String getColorFrom() {
        return this.colorFrom;
    }

    public final String getColorTo() {
        return this.colorTo;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public CommonModel$MaskStyle(Integer r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "colorFrom");
        Intrinsics.checkNotNullParameter(r102, "colorTo");
        this.height = r100;
        this.colorFrom = r101;
        this.colorTo = r102;
    }

    public /* synthetic */ CommonModel$MaskStyle(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101, r102);
    }
}
