package androidx.compose.material.ripple;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ripple/RippleAlpha;", "", "draggedAlpha", "", "focusedAlpha", "hoveredAlpha", "pressedAlpha", "<init>", "(FFFF)V", "getDraggedAlpha", "()F", "getFocusedAlpha", "getHoveredAlpha", "getPressedAlpha", "equals", "", "other", "hashCode", "", "toString", "", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleAlpha {
    public static final int $stable = 0;
    private final float draggedAlpha;
    private final float focusedAlpha;
    private final float hoveredAlpha;
    private final float pressedAlpha;

    public int hashCode() {
        return (((((Float.floatToIntBits(this.draggedAlpha) * 31) + Float.floatToIntBits(this.focusedAlpha)) * 31) + Float.floatToIntBits(this.hoveredAlpha)) * 31) + Float.floatToIntBits(this.pressedAlpha);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.draggedAlpha + ", focusedAlpha=" + this.focusedAlpha + ", hoveredAlpha=" + this.hoveredAlpha + ", pressedAlpha=" + this.pressedAlpha + ')';
    }

    public final float getDraggedAlpha() {
        return this.draggedAlpha;
    }

    public final float getFocusedAlpha() {
        return this.focusedAlpha;
    }

    public final float getHoveredAlpha() {
        return this.hoveredAlpha;
    }

    public final float getPressedAlpha() {
        return this.pressedAlpha;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RippleAlpha) == true) goto L8;
        return false;
    L8:
        RippleAlpha r101 = (RippleAlpha) r100;
        if (this.draggedAlpha != r101.draggedAlpha) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (this.focusedAlpha != r101.focusedAlpha) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (this.hoveredAlpha != r101.hoveredAlpha) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == true) goto L27;
        return false;
    L27:
        if (this.pressedAlpha != r101.pressedAlpha) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == true) goto L32;
        return false;
    L32:
        return true;
    L29:
        r105 = false;
        goto L30
    L23:
        r104 = false;
        goto L24
    L17:
        r103 = false;
        goto L18
    L11:
        r102 = false;
        goto L12
    }

    public RippleAlpha(float r100, float r101, float r102, float r103) {
        this.draggedAlpha = r100;
        this.focusedAlpha = r101;
        this.hoveredAlpha = r102;
        this.pressedAlpha = r103;
    }
}
