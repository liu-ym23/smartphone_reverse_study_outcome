package com.android.ttcjpaysdk.kmp.common.view.text;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/text/BadgePlacement;", "", "badgeX", "", "badgeY", "textX", "textY", "layoutWidth", "layoutHeight", "<init>", "(IIIIII)V", "getBadgeX", "()I", "getBadgeY", "getTextX", "getTextY", "getLayoutWidth", "getLayoutHeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BadgePlacement {
    public static final int $stable = 0;
    private final int badgeX;
    private final int badgeY;
    private final int layoutHeight;
    private final int layoutWidth;
    private final int textX;
    private final int textY;

    public static /* synthetic */ BadgePlacement copy$default(BadgePlacement r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.badgeX;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.badgeY;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.textX;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.textY;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.layoutWidth;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.layoutHeight;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.badgeX;
    }

    public final int component2() {
        return this.badgeY;
    }

    public final int component3() {
        return this.textX;
    }

    public final int component4() {
        return this.textY;
    }

    public final int component5() {
        return this.layoutWidth;
    }

    public final int component6() {
        return this.layoutHeight;
    }

    public final BadgePlacement copy(int r100, int r110, int r111, int r112, int r113, int r114) {
        return new BadgePlacement(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BadgePlacement) == true) goto L8;
        return false;
    L8:
        BadgePlacement r101 = (BadgePlacement) r100;
        if (this.badgeX == r101.badgeX) goto L12;
        return false;
    L12:
        if (this.badgeY == r101.badgeY) goto L15;
        return false;
    L15:
        if (this.textX == r101.textX) goto L18;
        return false;
    L18:
        if (this.textY == r101.textY) goto L21;
        return false;
    L21:
        if (this.layoutWidth == r101.layoutWidth) goto L24;
        return false;
    L24:
        if (this.layoutHeight == r101.layoutHeight) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.badgeX * 31) + this.badgeY) * 31) + this.textX) * 31) + this.textY) * 31) + this.layoutWidth) * 31) + this.layoutHeight;
    }

    public String toString() {
        return "BadgePlacement(badgeX=" + this.badgeX + ", badgeY=" + this.badgeY + ", textX=" + this.textX + ", textY=" + this.textY + ", layoutWidth=" + this.layoutWidth + ", layoutHeight=" + this.layoutHeight + ')';
    }

    public final int getBadgeX() {
        return this.badgeX;
    }

    public final int getBadgeY() {
        return this.badgeY;
    }

    public final int getLayoutHeight() {
        return this.layoutHeight;
    }

    public final int getLayoutWidth() {
        return this.layoutWidth;
    }

    public final int getTextX() {
        return this.textX;
    }

    public final int getTextY() {
        return this.textY;
    }

    public BadgePlacement(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.badgeX = r100;
        this.badgeY = r101;
        this.textX = r102;
        this.textY = r103;
        this.layoutWidth = r104;
        this.layoutHeight = r105;
    }
}
