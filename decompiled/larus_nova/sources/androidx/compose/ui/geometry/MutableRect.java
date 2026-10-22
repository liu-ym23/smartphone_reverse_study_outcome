package androidx.compose.ui.geometry;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0016\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0003J&\u0010+\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0000J\u0018\u0010E\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0086\u0002¢\u0006\u0004\bF\u0010GJ&\u0010H\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0012\u0010\u0015\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\nR\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\nR\u0011\u00103\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b4\u0010\u001aR\u0011\u00105\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b6\u0010\u001aR\u0011\u00107\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b8\u0010\u001aR\u0011\u00109\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b:\u0010\u001aR\u0011\u0010;\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b<\u0010\u001aR\u0011\u0010=\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b>\u0010\u001aR\u0011\u0010?\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b@\u0010\u001aR\u0011\u0010A\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\bB\u0010\u001aR\u0011\u0010C\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\bD\u0010\u001a¨\u0006K"}, d2 = {"Landroidx/compose/ui/geometry/MutableRect;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft", "()F", "setLeft", "(F)V", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "width", "getWidth", "height", "getHeight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "isInfinite", "", "()Z", "isFinite", "isEmpty", "translate", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-k-4lQ0M", "(J)V", "translateX", "translateY", WidgetCostModule.TYPE_INFLATE, "delta", "deflate", "intersect", "overlaps", "other", "Landroidx/compose/ui/geometry/Rect;", "minDimension", "getMinDimension", "maxDimension", "getMaxDimension", "topLeft", "getTopLeft-F1C5BW0", "topCenter", "getTopCenter-F1C5BW0", "topRight", "getTopRight-F1C5BW0", "centerLeft", "getCenterLeft-F1C5BW0", "center", "getCenter-F1C5BW0", "centerRight", "getCenterRight-F1C5BW0", "bottomLeft", "getBottomLeft-F1C5BW0", "bottomCenter", "getBottomCenter-F1C5BW0", "bottomRight", "getBottomRight-F1C5BW0", "contains", "contains-k-4lQ0M", "(J)Z", "set", "toString", "", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableRect {
    public static final int $stable = 8;
    private float bottom;
    private float left;
    private float right;
    private float top;

    /* JADX INFO: renamed from: getBottomCenter-F1C5BW0, reason: not valid java name */
    public final long m4557getBottomCenterF1C5BW0() {
        float r100 = this.left + ((getRight() - getLeft()) / 2.0f);
        float r101 = this.bottom;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getBottomLeft-F1C5BW0, reason: not valid java name */
    public final long m4558getBottomLeftF1C5BW0() {
        float r100 = this.left;
        float r101 = this.bottom;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getBottomRight-F1C5BW0, reason: not valid java name */
    public final long m4559getBottomRightF1C5BW0() {
        float r100 = this.right;
        float r101 = this.bottom;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m4560getCenterF1C5BW0() {
        float r100 = this.left + ((getRight() - getLeft()) / 2.0f);
        float r101 = this.top + ((getBottom() - getTop()) / 2.0f);
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getCenterLeft-F1C5BW0, reason: not valid java name */
    public final long m4561getCenterLeftF1C5BW0() {
        float r100 = this.left;
        float r101 = this.top + ((getBottom() - getTop()) / 2.0f);
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getCenterRight-F1C5BW0, reason: not valid java name */
    public final long m4562getCenterRightF1C5BW0() {
        float r100 = this.right;
        float r101 = this.top + ((getBottom() - getTop()) / 2.0f);
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getTopCenter-F1C5BW0, reason: not valid java name */
    public final long m4564getTopCenterF1C5BW0() {
        float r100 = this.left + ((getRight() - getLeft()) / 2.0f);
        float r101 = this.top;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getTopLeft-F1C5BW0, reason: not valid java name */
    public final long m4565getTopLeftF1C5BW0() {
        float r100 = this.left;
        float r101 = this.top;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: getTopRight-F1C5BW0, reason: not valid java name */
    public final long m4566getTopRightF1C5BW0() {
        float r100 = this.right;
        float r101 = this.top;
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    public final boolean isEmpty() {
        boolean r100 = true;
        if (this.left < this.right) goto L5;
        boolean r101 = true;
    L7:
        if (this.top >= this.bottom) goto L11;
        r100 = false;
    L11:
        return r101 | r100;
    L5:
        r101 = false;
        goto L7
    }

    public final boolean isFinite() {
        boolean r100 = true;
        if ((Float.floatToRawIntBits(this.left) & Integer.MAX_VALUE) >= 2139095040) goto L5;
        boolean r101 = true;
    L7:
        if ((Float.floatToRawIntBits(this.top) & Integer.MAX_VALUE) >= 2139095040) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = r101 & r102;
        if ((Float.floatToRawIntBits(this.right) & Integer.MAX_VALUE) >= 2139095040) goto L13;
        boolean r104 = true;
    L14:
        boolean r105 = r103 & r104;
        if ((Integer.MAX_VALUE & Float.floatToRawIntBits(this.bottom)) < 2139095040) goto L19;
        r100 = false;
    L19:
        return r105 & r100;
    L13:
        r104 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public final boolean isInfinite() {
        boolean r100 = true;
        if (this.left != Float.POSITIVE_INFINITY) goto L5;
        boolean r101 = true;
    L7:
        if (this.top != Float.POSITIVE_INFINITY) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = r101 | r102;
        if (this.right != Float.POSITIVE_INFINITY) goto L13;
        boolean r104 = true;
    L14:
        boolean r105 = r103 | r104;
        if (this.bottom == Float.POSITIVE_INFINITY) goto L19;
        r100 = false;
    L19:
        return r105 | r100;
    L13:
        r104 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public String toString() {
        return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    public final float getHeight() {
        return getBottom() - getTop();
    }

    public final float getMaxDimension() {
        return Math.max(Math.abs(getRight() - getLeft()), Math.abs(getBottom() - getTop()));
    }

    public final float getMinDimension() {
        return Math.min(Math.abs(getRight() - getLeft()), Math.abs(getBottom() - getTop()));
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m4563getSizeNHjbRc() {
        float r100 = getRight() - getLeft();
        float r101 = getBottom() - getTop();
        long r102 = Float.floatToRawIntBits(r100);
        return Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    public final float getWidth() {
        return getRight() - getLeft();
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m4556containsk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        boolean r103 = true;
        if (r101 < this.left) goto L5;
        boolean r104 = true;
    L7:
        if (r101 >= this.right) goto L9;
        boolean r105 = true;
    L10:
        boolean r106 = r104 & r105;
        if (r102 < this.top) goto L13;
        boolean r107 = true;
    L14:
        boolean r108 = r106 & r107;
        if (r102 < this.bottom) goto L19;
        r103 = false;
    L19:
        return r108 & r103;
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    public final void deflate(float r100) {
        inflate(-r100);
    }

    public final void inflate(float r100) {
        this.left -= r100;
        this.top -= r100;
        this.right += r100;
        this.bottom += r100;
    }

    public final boolean overlaps(Rect r100) {
        boolean r101 = true;
        if (this.left >= r100.getRight()) goto L5;
        boolean r102 = true;
    L7:
        if (r100.getLeft() >= this.right) goto L9;
        boolean r103 = true;
    L10:
        boolean r104 = r102 & r103;
        if (this.top >= r100.getBottom()) goto L13;
        boolean r105 = true;
    L14:
        boolean r106 = r104 & r105;
        if (r100.getTop() < this.bottom) goto L19;
        r101 = false;
    L19:
        return r106 & r101;
    L13:
        r105 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    public final void setBottom(float r100) {
        this.bottom = r100;
    }

    public final void setLeft(float r100) {
        this.left = r100;
    }

    public final void setRight(float r100) {
        this.right = r100;
    }

    public final void setTop(float r100) {
        this.top = r100;
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final void m4567translatek4lQ0M(long r100) {
        translate(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
    }

    public final boolean overlaps(MutableRect r100) {
        if (this.right > r100.left) goto L5;
    L14:
        return false;
    L5:
        if (r100.right <= this.left) goto L14;
        if (this.bottom <= r100.top) goto L14;
        if (r100.bottom <= this.top) goto L14;
        return true;
    }

    public final void translate(float r100, float r101) {
        this.left += r100;
        this.top += r101;
        this.right += r100;
        this.bottom += r101;
    }

    public MutableRect(float r100, float r101, float r102, float r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }

    public final void intersect(float r100, float r101, float r102, float r103) {
        this.left = Math.max(r100, this.left);
        this.top = Math.max(r101, this.top);
        this.right = Math.min(r102, this.right);
        this.bottom = Math.min(r103, this.bottom);
    }

    public final void set(float r100, float r101, float r102, float r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }
}
