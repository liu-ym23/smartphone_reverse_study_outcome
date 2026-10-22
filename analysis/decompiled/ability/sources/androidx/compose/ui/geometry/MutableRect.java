package androidx.compose.ui.geometry;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0014J-\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010 \u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b \u0010\bJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010$\u001a\u0004\b(\u0010&\"\u0004\b)\u0010\u0014R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010\u0014R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010$\u001a\u0004\b,\u0010&\"\u0004\b-\u0010\u0014R\u0012\u0010/\u001a\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b.\u0010&R\u0012\u00101\u001a\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b0\u0010&R\u0011\u00105\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00106\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b8\u00107R\u0011\u00109\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b9\u00107R\u0011\u0010;\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010&R\u0011\u0010=\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b<\u0010&R\u0011\u0010?\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b>\u00104R\u0011\u0010A\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b@\u00104R\u0011\u0010C\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bB\u00104R\u0011\u0010E\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bD\u00104R\u0011\u0010G\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bF\u00104R\u0011\u0010I\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bH\u00104R\u0011\u0010K\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bJ\u00104R\u0011\u0010M\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bL\u00104R\u0011\u0010O\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bN\u00104¨\u0006P"}, d2 = {"Landroidx/compose/ui/geometry/MutableRect;", "", "", "left", "top", "right", "bottom", AppAgent.CONSTRUCT, "(FFFF)V", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "LC7/r;", "translate-k-4lQ0M", "(J)V", "translate", "translateX", "translateY", "(FF)V", "delta", "inflate", "(F)V", "deflate", "intersect", "Landroidx/compose/ui/geometry/Rect;", "other", "", "overlaps", "(Landroidx/compose/ui/geometry/Rect;)Z", "(Landroidx/compose/ui/geometry/MutableRect;)Z", "contains-k-4lQ0M", "(J)Z", "contains", "set", "", "toString", "()Ljava/lang/String;", "F", "getLeft", "()F", "setLeft", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "getWidth", "width", "getHeight", "height", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "size", "isInfinite", "()Z", "isFinite", "isEmpty", "getMinDimension", "minDimension", "getMaxDimension", "maxDimension", "getTopLeft-F1C5BW0", "topLeft", "getTopCenter-F1C5BW0", "topCenter", "getTopRight-F1C5BW0", "topRight", "getCenterLeft-F1C5BW0", "centerLeft", "getCenter-F1C5BW0", "center", "getCenterRight-F1C5BW0", "centerRight", "getBottomLeft-F1C5BW0", "bottomLeft", "getBottomCenter-F1C5BW0", "bottomCenter", "getBottomRight-F1C5BW0", "bottomRight", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableRect {
    public static final int $stable = 8;
    private float bottom;
    private float left;
    private float right;
    private float top;

    public MutableRect(float f, float f7, float f9, float f10) {
        this.left = f;
        this.top = f7;
        this.right = f9;
        this.bottom = f10;
    }

    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m3869containsk4lQ0M(long offset) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (offset >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (offset & 4294967295L));
        return (fIntBitsToFloat >= this.left) & (fIntBitsToFloat < this.right) & (fIntBitsToFloat2 >= this.top) & (fIntBitsToFloat2 < this.bottom);
    }

    public final void deflate(float delta) {
        inflate(-delta);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomCenter-F1C5BW0, reason: not valid java name */
    public final long m3870getBottomCenterF1C5BW0() {
        float right = ((getRight() - getLeft()) / 2.0f) + this.left;
        float f = this.bottom;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(right) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
    }

    /* renamed from: getBottomLeft-F1C5BW0, reason: not valid java name */
    public final long m3871getBottomLeftF1C5BW0() {
        float f = this.left;
        float f7 = this.bottom;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    /* renamed from: getBottomRight-F1C5BW0, reason: not valid java name */
    public final long m3872getBottomRightF1C5BW0() {
        float f = this.right;
        float f7 = this.bottom;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m3873getCenterF1C5BW0() {
        float right = ((getRight() - getLeft()) / 2.0f) + this.left;
        float bottom = ((getBottom() - getTop()) / 2.0f) + this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(right) << 32) | (Float.floatToRawIntBits(bottom) & 4294967295L));
    }

    /* renamed from: getCenterLeft-F1C5BW0, reason: not valid java name */
    public final long m3874getCenterLeftF1C5BW0() {
        float f = this.left;
        float bottom = ((getBottom() - getTop()) / 2.0f) + this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(bottom) & 4294967295L));
    }

    /* renamed from: getCenterRight-F1C5BW0, reason: not valid java name */
    public final long m3875getCenterRightF1C5BW0() {
        float f = this.right;
        float bottom = ((getBottom() - getTop()) / 2.0f) + this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(bottom) & 4294967295L));
    }

    public final float getHeight() {
        return getBottom() - getTop();
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getMaxDimension() {
        return Math.max(Math.abs(getRight() - getLeft()), Math.abs(getBottom() - getTop()));
    }

    public final float getMinDimension() {
        return Math.min(Math.abs(getRight() - getLeft()), Math.abs(getBottom() - getTop()));
    }

    public final float getRight() {
        return this.right;
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m3876getSizeNHjbRc() {
        float right = getRight() - getLeft();
        float bottom = getBottom() - getTop();
        return Size.m3955constructorimpl((Float.floatToRawIntBits(bottom) & 4294967295L) | (Float.floatToRawIntBits(right) << 32));
    }

    public final float getTop() {
        return this.top;
    }

    /* renamed from: getTopCenter-F1C5BW0, reason: not valid java name */
    public final long m3877getTopCenterF1C5BW0() {
        float right = ((getRight() - getLeft()) / 2.0f) + this.left;
        float f = this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(right) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
    }

    /* renamed from: getTopLeft-F1C5BW0, reason: not valid java name */
    public final long m3878getTopLeftF1C5BW0() {
        float f = this.left;
        float f7 = this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    /* renamed from: getTopRight-F1C5BW0, reason: not valid java name */
    public final long m3879getTopRightF1C5BW0() {
        float f = this.right;
        float f7 = this.top;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    public final float getWidth() {
        return getRight() - getLeft();
    }

    public final void inflate(float delta) {
        this.left -= delta;
        this.top -= delta;
        this.right += delta;
        this.bottom += delta;
    }

    public final void intersect(float left, float top, float right, float bottom) {
        this.left = Math.max(left, this.left);
        this.top = Math.max(top, this.top);
        this.right = Math.min(right, this.right);
        this.bottom = Math.min(bottom, this.bottom);
    }

    public final boolean isEmpty() {
        return (this.left >= this.right) | (this.top >= this.bottom);
    }

    public final boolean isFinite() {
        return ((Float.floatToRawIntBits(this.left) & Integer.MAX_VALUE) < 2139095040) & ((Float.floatToRawIntBits(this.top) & Integer.MAX_VALUE) < 2139095040) & ((Float.floatToRawIntBits(this.right) & Integer.MAX_VALUE) < 2139095040) & ((Float.floatToRawIntBits(this.bottom) & Integer.MAX_VALUE) < 2139095040);
    }

    public final boolean isInfinite() {
        return (this.left == Float.POSITIVE_INFINITY) | (this.top == Float.POSITIVE_INFINITY) | (this.right == Float.POSITIVE_INFINITY) | (this.bottom == Float.POSITIVE_INFINITY);
    }

    public final boolean overlaps(Rect other) {
        return (this.left < other.getRight()) & (other.getLeft() < this.right) & (this.top < other.getBottom()) & (other.getTop() < this.bottom);
    }

    public final void set(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public final void setBottom(float f) {
        this.bottom = f;
    }

    public final void setLeft(float f) {
        this.left = f;
    }

    public final void setRight(float f) {
        this.right = f;
    }

    public final void setTop(float f) {
        this.top = f;
    }

    public String toString() {
        return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    public final void translate(float translateX, float translateY) {
        this.left += translateX;
        this.top += translateY;
        this.right += translateX;
        this.bottom += translateY;
    }

    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final void m3880translatek4lQ0M(long offset) {
        translate(Float.intBitsToFloat((int) (offset >> 32)), Float.intBitsToFloat((int) (offset & 4294967295L)));
    }

    public final boolean overlaps(MutableRect other) {
        return this.right > other.left && other.right > this.left && this.bottom > other.top && other.bottom > this.top;
    }
}
