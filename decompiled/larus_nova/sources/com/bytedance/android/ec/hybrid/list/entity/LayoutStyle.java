package com.bytedance.android.ec.hybrid.list.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/LayoutStyle;", "", "top", "", "bottom", "left", "right", "width", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottom", "()Ljava/lang/Integer;", "setBottom", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeight", "getLeft", "getRight", "getTop", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/ec/hybrid/list/entity/LayoutStyle;", "equals", "", "other", "hashCode", "toString", "", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LayoutStyle {
    private Integer bottom;
    private final Integer height;
    private final Integer left;
    private final Integer right;
    private final Integer top;
    private final Integer width;

    public LayoutStyle() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LayoutStyle copy$default(LayoutStyle r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.top;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.bottom;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.left;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.right;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.width;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.height;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
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

    public final LayoutStyle copy(Integer r100, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114) {
        return new LayoutStyle(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LayoutStyle) == false) goto L18;
        LayoutStyle r101 = (LayoutStyle) r100;
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
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
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
        return "LayoutStyle(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ", width=" + this.width + ", height=" + this.height + ")";
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

    public final Integer getRight() {
        return this.right;
    }

    public final Integer getTop() {
        return this.top;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setBottom(Integer r100) {
        this.bottom = r100;
    }

    public LayoutStyle(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105) {
        this.top = r100;
        this.bottom = r101;
        this.left = r102;
        this.right = r103;
        this.width = r104;
        this.height = r105;
    }

    public /* synthetic */ LayoutStyle(Integer r100, Integer r101, Integer r102, Integer r103, Integer r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Integer r115 = null;
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
