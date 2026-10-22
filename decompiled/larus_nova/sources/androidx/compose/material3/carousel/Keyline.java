package androidx.compose.material3.carousel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006!"}, d2 = {"Landroidx/compose/material3/carousel/Keyline;", "", "size", "", "offset", "unadjustedOffset", "isFocal", "", "isAnchor", "isPivot", "cutoff", "<init>", "(FFFZZZF)V", "getSize", "()F", "getOffset", "getUnadjustedOffset", "()Z", "getCutoff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Keyline {
    public static final int $stable = 0;
    private final float cutoff;
    private final boolean isAnchor;
    private final boolean isFocal;
    private final boolean isPivot;
    private final float offset;
    private final float size;
    private final float unadjustedOffset;

    public static /* synthetic */ Keyline copy$default(Keyline r100, float r101, float r102, float r103, boolean r104, boolean r110, boolean r111, float r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.size;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.offset;
    L8:
        float r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.unadjustedOffset;
    L11:
        float r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isFocal;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isAnchor;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isPivot;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.cutoff;
    L23:
        float r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final float component1() {
        return this.size;
    }

    public final float component2() {
        return this.offset;
    }

    public final float component3() {
        return this.unadjustedOffset;
    }

    public final boolean component4() {
        return this.isFocal;
    }

    public final boolean component5() {
        return this.isAnchor;
    }

    public final boolean component6() {
        return this.isPivot;
    }

    public final float component7() {
        return this.cutoff;
    }

    public final Keyline copy(float r110, float r111, float r112, boolean r113, boolean r114, boolean r115, float r116) {
        return new Keyline(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Keyline) == true) goto L8;
        return false;
    L8:
        Keyline r101 = (Keyline) r100;
        if (Float.compare(this.size, r101.size) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.offset, r101.offset) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.unadjustedOffset, r101.unadjustedOffset) == 0) goto L18;
        return false;
    L18:
        if (this.isFocal == r101.isFocal) goto L21;
        return false;
    L21:
        if (this.isAnchor == r101.isAnchor) goto L24;
        return false;
    L24:
        if (this.isPivot == r101.isPivot) goto L27;
        return false;
    L27:
        if (Float.compare(this.cutoff, r101.cutoff) == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((Float.floatToIntBits(this.size) * 31) + Float.floatToIntBits(this.offset)) * 31) + Float.floatToIntBits(this.unadjustedOffset)) * 31;
        int r101 = 1231;
        if (this.isFocal == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isAnchor == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.isPivot == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + Float.floatToIntBits(this.cutoff);
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "Keyline(size=" + this.size + ", offset=" + this.offset + ", unadjustedOffset=" + this.unadjustedOffset + ", isFocal=" + this.isFocal + ", isAnchor=" + this.isAnchor + ", isPivot=" + this.isPivot + ", cutoff=" + this.cutoff + ')';
    }

    public final float getCutoff() {
        return this.cutoff;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final float getSize() {
        return this.size;
    }

    public final float getUnadjustedOffset() {
        return this.unadjustedOffset;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final boolean isFocal() {
        return this.isFocal;
    }

    public final boolean isPivot() {
        return this.isPivot;
    }

    public Keyline(float r100, float r101, float r102, boolean r103, boolean r104, boolean r105, float r106) {
        this.size = r100;
        this.offset = r101;
        this.unadjustedOffset = r102;
        this.isFocal = r103;
        this.isAnchor = r104;
        this.isPivot = r105;
        this.cutoff = r106;
    }
}
