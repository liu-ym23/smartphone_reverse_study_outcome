package androidx.compose.ui.geometry;

import androidx.appfunctions.metadata.a;
import androidx.compose.runtime.Immutable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u001f\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0001FBO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010\"\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b!\u0010\u001dJ\u0010\u0010$\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b#\u0010\u001dJ`\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0000H\u0002¢\u0006\u0004\b.\u0010/J/\u00104\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\b4\u00105R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00106\u001a\u0004\b7\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00106\u001a\u0004\b8\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00106\u001a\u0004\b9\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00106\u001a\u0004\b:\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010;\u001a\u0004\b<\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010;\u001a\u0004\b=\u0010\u001dR\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010;\u001a\u0004\b>\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010;\u001a\u0004\b?\u0010\u001dR\u0018\u0010@\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0011\u0010C\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0011\u0010E\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bD\u0010\u0018¨\u0006G"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "", "left", "top", "right", "bottom", "Landroidx/compose/ui/geometry/CornerRadius;", "topLeftCornerRadius", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", AppAgent.CONSTRUCT, "(FFFFJJJJLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "", "contains-k-4lQ0M", "(J)Z", "contains", "", "toString", "()Ljava/lang/String;", "component1", "()F", "component2", "component3", "component4", "component5-kKHJgLs", "()J", "component5", "component6-kKHJgLs", "component6", "component7-kKHJgLs", "component7", "component8-kKHJgLs", "component8", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "copy", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "scaledRadiiRect", "()Landroidx/compose/ui/geometry/RoundRect;", "min", "radius1", "radius2", "limit", "minRadius", "(FFFF)F", "F", "getLeft", "getTop", "getRight", "getBottom", "J", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "getBottomRightCornerRadius-kKHJgLs", "getBottomLeftCornerRadius-kKHJgLs", "_scaledRadiiRect", "Landroidx/compose/ui/geometry/RoundRect;", "getWidth", "width", "getHeight", "height", "Companion", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RoundRect {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RoundRect Zero = RoundRectKt.m3949RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.INSTANCE.m3867getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ void getZero$annotations() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoundRect(float f, float f7, float f9, float f10, long j5, long j6, long j10, long j11, e eVar) {
        this(f, f7, f9, f10, j5, j6, j10, j11);
    }

    /* renamed from: copy-MDFrsts$default, reason: not valid java name */
    public static /* synthetic */ RoundRect m3936copyMDFrsts$default(RoundRect roundRect, float f, float f7, float f9, float f10, long j5, long j6, long j10, long j11, int i, Object obj) {
        if ((i & 1) != 0) {
            f = roundRect.left;
        }
        if ((i & 2) != 0) {
            f7 = roundRect.top;
        }
        if ((i & 4) != 0) {
            f9 = roundRect.right;
        }
        if ((i & 8) != 0) {
            f10 = roundRect.bottom;
        }
        if ((i & 16) != 0) {
            j5 = roundRect.topLeftCornerRadius;
        }
        if ((i & 32) != 0) {
            j6 = roundRect.topRightCornerRadius;
        }
        if ((i & 64) != 0) {
            j10 = roundRect.bottomRightCornerRadius;
        }
        if ((i & 128) != 0) {
            j11 = roundRect.bottomLeftCornerRadius;
        }
        long j12 = j11;
        long j13 = j10;
        long j14 = j6;
        long j15 = j5;
        return roundRect.m3942copyMDFrsts(f, f7, f9, f10, j15, j14, j13, j12);
    }

    public static final RoundRect getZero() {
        return INSTANCE.getZero();
    }

    private final float minRadius(float min, float radius1, float radius2, float limit) {
        float f = radius1 + radius2;
        return (f <= limit || f == 0.0f) ? min : Math.min(min, limit / f);
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float fMinRadius = minRadius(minRadius(minRadius(minRadius(1.0f, Float.intBitsToFloat((int) (this.bottomLeftCornerRadius & 4294967295L)), Float.intBitsToFloat((int) (this.topLeftCornerRadius & 4294967295L)), getHeight()), Float.intBitsToFloat((int) (this.topLeftCornerRadius >> 32)), Float.intBitsToFloat((int) (this.topRightCornerRadius >> 32)), getWidth()), Float.intBitsToFloat((int) (this.topRightCornerRadius & 4294967295L)), Float.intBitsToFloat((int) (this.bottomRightCornerRadius & 4294967295L)), getHeight()), Float.intBitsToFloat((int) (this.bottomRightCornerRadius >> 32)), Float.intBitsToFloat((int) (this.bottomLeftCornerRadius >> 32)), getWidth());
        float f = this.left * fMinRadius;
        float f7 = this.top * fMinRadius;
        float f9 = this.right * fMinRadius;
        float f10 = this.bottom * fMinRadius;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.topLeftCornerRadius >> 32)) * fMinRadius;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.topLeftCornerRadius & 4294967295L)) * fMinRadius;
        long jM3849constructorimpl = CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (this.topRightCornerRadius >> 32)) * fMinRadius;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (this.topRightCornerRadius & 4294967295L)) * fMinRadius;
        long jM3849constructorimpl2 = CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat4) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (this.bottomRightCornerRadius >> 32)) * fMinRadius;
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (this.bottomRightCornerRadius & 4294967295L)) * fMinRadius;
        long jM3849constructorimpl3 = CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat6) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat5) << 32));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (this.bottomLeftCornerRadius >> 32)) * fMinRadius;
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (this.bottomLeftCornerRadius & 4294967295L)) * fMinRadius;
        RoundRect roundRect2 = new RoundRect(f, f7, f9, f10, jM3849constructorimpl, jM3849constructorimpl2, jM3849constructorimpl3, CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat7) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat8) & 4294967295L)), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
    }

    /* renamed from: component1, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* renamed from: component2, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    /* renamed from: component3, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* renamed from: component4, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: component5-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ec  */
    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m3941containsk4lQ0M(long r11) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRect.m3941containsk4lQ0M(long):boolean");
    }

    /* renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m3942copyMDFrsts(float left, float top, float right, float bottom, long topLeftCornerRadius, long topRightCornerRadius, long bottomRightCornerRadius, long bottomLeftCornerRadius) {
        return new RoundRect(left, top, right, bottom, topLeftCornerRadius, topRightCornerRadius, bottomRightCornerRadius, bottomLeftCornerRadius, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) other;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m3854equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m3854equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m3854equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m3854equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m3943getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m3944getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
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

    /* renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m3945getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m3946getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return CornerRadius.m3857hashCodeimpl(this.bottomLeftCornerRadius) + ((CornerRadius.m3857hashCodeimpl(this.bottomRightCornerRadius) + ((CornerRadius.m3857hashCodeimpl(this.topRightCornerRadius) + ((CornerRadius.m3857hashCodeimpl(this.topLeftCornerRadius) + a.b(this.bottom, a.b(this.right, a.b(this.top, Float.hashCode(this.left) * 31, 31), 31), 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        long j5 = this.topLeftCornerRadius;
        long j6 = this.topRightCornerRadius;
        long j10 = this.bottomRightCornerRadius;
        long j11 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m3854equalsimpl0(j5, j6) || !CornerRadius.m3854equalsimpl0(j6, j10) || !CornerRadius.m3854equalsimpl0(j10, j11)) {
            StringBuilder sbV = B7.a.v("RoundRect(rect=", str, ", topLeft=");
            sbV.append((Object) CornerRadius.m3863toStringimpl(j5));
            sbV.append(", topRight=");
            sbV.append((Object) CornerRadius.m3863toStringimpl(j6));
            sbV.append(", bottomRight=");
            sbV.append((Object) CornerRadius.m3863toStringimpl(j10));
            sbV.append(", bottomLeft=");
            sbV.append((Object) CornerRadius.m3863toStringimpl(j11));
            sbV.append(')');
            return sbV.toString();
        }
        int i = (int) (j5 >> 32);
        int i6 = (int) (j5 & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i6)) {
            StringBuilder sbV2 = B7.a.v("RoundRect(rect=", str, ", radius=");
            sbV2.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i), 1));
            sbV2.append(')');
            return sbV2.toString();
        }
        StringBuilder sbV3 = B7.a.v("RoundRect(rect=", str, ", x=");
        sbV3.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i), 1));
        sbV3.append(", y=");
        sbV3.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i6), 1));
        sbV3.append(')');
        return sbV3.toString();
    }

    private RoundRect(float f, float f7, float f9, float f10, long j5, long j6, long j10, long j11) {
        this.left = f;
        this.top = f7;
        this.right = f9;
        this.bottom = f10;
        this.topLeftCornerRadius = j5;
        this.topRightCornerRadius = j6;
        this.bottomRightCornerRadius = j10;
        this.bottomLeftCornerRadius = j11;
    }

    public /* synthetic */ RoundRect(float f, float f7, float f9, float f10, long j5, long j6, long j10, long j11, int i, e eVar) {
        this(f, f7, f9, f10, (i & 16) != 0 ? CornerRadius.INSTANCE.m3867getZerokKHJgLs() : j5, (i & 32) != 0 ? CornerRadius.INSTANCE.m3867getZerokKHJgLs() : j6, (i & 64) != 0 ? CornerRadius.INSTANCE.m3867getZerokKHJgLs() : j10, (i & 128) != 0 ? CornerRadius.INSTANCE.m3867getZerokKHJgLs() : j11, null);
    }
}
