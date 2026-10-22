package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003Jp\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\rHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0004R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle", "", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Double;", "", "component8", "top", "bottom", "left", "right", "width", "height", "radius", "url", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "getTop", "getBottom", "setBottom", "(Ljava/lang/Integer;)V", "getLeft", "getRight", "getWidth", "getHeight", "Ljava/lang/Double;", "getRadius", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$LayoutStyle {
    private Integer bottom;
    private final Integer height;
    private final Integer left;
    private final Double radius;
    private final Integer right;
    private final Integer top;
    private final String url;
    private final Integer width;

    public CommonModel$LayoutStyle() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CommonModel$LayoutStyle copy$default(CommonModel$LayoutStyle r100, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Double r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.top;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = r100.bottom;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = r100.left;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = r100.right;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.width;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = r100.height;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Double r107 = r100.radius;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.url;
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

    public final Integer component1() {
        return this.top;
    }

    public final Integer component2() {
        return this.bottom;
    }

    public final Integer component3() {
        return this.left;
    }

    public final Integer component4() {
        return this.right;
    }

    public final Integer component5() {
        return this.width;
    }

    public final Integer component6() {
        return this.height;
    }

    public final Double component7() {
        return this.radius;
    }

    public final String component8() {
        return this.url;
    }

    public final CommonModel$LayoutStyle copy(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Double r116, String r117) {
        return new CommonModel$LayoutStyle(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$LayoutStyle) == false) goto L22;
        CommonModel$LayoutStyle r101 = (CommonModel$LayoutStyle) r100;
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.top;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bottom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.left;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.right;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.width;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.height;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.radius;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.url;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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
        return "LayoutStyle(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ", width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", url=" + this.url + ")";
    }

    public final Integer getBottom() {
        return this.bottom;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getLeft() {
        return this.left;
    }

    public final Double getRadius() {
        return this.radius;
    }

    public final Integer getRight() {
        return this.right;
    }

    public final Integer getTop() {
        return this.top;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setBottom(Integer r100) {
        this.bottom = r100;
    }

    public CommonModel$LayoutStyle(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Double r106, String r107) {
        this.top = r100;
        this.bottom = r101;
        this.left = r102;
        this.right = r103;
        this.width = r104;
        this.height = r105;
        this.radius = r106;
        this.url = r107;
    }

    public /* synthetic */ CommonModel$LayoutStyle(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Double r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Double r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
}
