package androidx.compose.ui.graphics.colorspace;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bB)\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\nJ\r\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "", "x", "", "y", "<init>", "(FF)V", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "(FFF)V", "sum", "(FFFF)V", "getX", "()F", "getY", "toXyz", "", "toXyz$ui_graphics_release", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WhitePoint {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f15190x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f15191y;

    public static /* synthetic */ WhitePoint copy$default(WhitePoint r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f15190x;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f15191y;
    L9:
        return r100.copy(r101, r102);
    }

    public final float component1() {
        return this.f15190x;
    }

    public final float component2() {
        return this.f15191y;
    }

    public final WhitePoint copy(float r100, float r101) {
        return new WhitePoint(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WhitePoint) == true) goto L8;
        return false;
    L8:
        WhitePoint r101 = (WhitePoint) r100;
        if (Float.compare(this.f15190x, r101.f15190x) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f15191y, r101.f15191y) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f15190x) * 31) + Float.floatToIntBits(this.f15191y);
    }

    public String toString() {
        return "WhitePoint(x=" + this.f15190x + ", y=" + this.f15191y + ')';
    }

    public final float[] toXyz$ui_graphics_release() {
        float r100 = this.f15190x;
        float r101 = this.f15191y;
        return new float[]{r100 / r101, 1.0f, ((1.0f - r100) - r101) / r101};
    }

    public final float getX() {
        return this.f15190x;
    }

    public final float getY() {
        return this.f15191y;
    }

    public WhitePoint(float r100, float r101) {
        this.f15190x = r100;
        this.f15191y = r101;
    }

    public WhitePoint(float r100, float r101, float r102) {
        this(r100, r101, r102, (r100 + r101) + r102);
    }

    private WhitePoint(float r100, float r101, float r102, float r103) {
        this(r100 / r103, r101 / r103);
    }
}
