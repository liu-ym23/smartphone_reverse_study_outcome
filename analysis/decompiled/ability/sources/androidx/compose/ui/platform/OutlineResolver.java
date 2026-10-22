package androidx.compose.ui.platform;

import android.graphics.Outline;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u001b\u001a\u00020\u0018*\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010#\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u0015\u0010'\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0012¢\u0006\u0004\b%\u0010&J\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b\u001f\u0010*R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R$\u00105\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00188\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010,R\u0018\u00109\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00102R\u0018\u0010:\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010,R\u0018\u0010B\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00102R\u0018\u0010C\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00102R\u0013\u0010F\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010H\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bG\u00107R\u0013\u0010K\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006L"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "updateCache", "Landroidx/compose/ui/geometry/Rect;", "rect", "updateCacheWithRect", "(Landroidx/compose/ui/geometry/Rect;)V", "Landroidx/compose/ui/geometry/RoundRect;", "roundRect", "updateCacheWithRoundRect", "(Landroidx/compose/ui/geometry/RoundRect;)V", "Landroidx/compose/ui/graphics/Path;", "composePath", "updateCacheWithPath", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Size;", "size", "", "radius", "", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "isSameBounds", "Landroidx/compose/ui/graphics/Outline;", "outline", "alpha", "clipToOutline", "elevation", "update-S_szKao", "(Landroidx/compose/ui/graphics/Outline;FZFJ)Z", "update", "position", "isInOutline-k-4lQ0M", "(J)Z", "isInOutline", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "isSupportedOutline", "Z", "Landroid/graphics/Outline;", "cachedOutline", "Landroid/graphics/Outline;", "Landroidx/compose/ui/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "outlinePath", "value", "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "usePathForClip", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "roundedCornerRadius", "F", "rectTopLeft", "J", "rectSize", "outlineNeeded", "tmpTouchPointPath", "tmpOpPath", "getAndroidOutline", "()Landroid/graphics/Outline;", "androidOutline", "getOutlineClipSupported", "outlineClipSupported", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "clipPath", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private boolean isSupportedOutline = true;
    private androidx.compose.ui.graphics.Outline outline;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        this.rectTopLeft = Offset.INSTANCE.m3911getZeroF1C5BW0();
        this.rectSize = Size.INSTANCE.m3973getZeroNHjbRc();
    }

    /* renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m6048isSameBounds4L21HEs(RoundRect roundRect, long j5, long j6, float f) {
        if (roundRect == null || !RoundRectKt.isSimple(roundRect)) {
            return false;
        }
        int i = (int) (j5 >> 32);
        if (roundRect.getLeft() != Float.intBitsToFloat(i)) {
            return false;
        }
        int i6 = (int) (j5 & 4294967295L);
        if (roundRect.getTop() != Float.intBitsToFloat(i6)) {
            return false;
        }
        if (roundRect.getRight() == Float.intBitsToFloat((int) (j6 >> 32)) + Float.intBitsToFloat(i)) {
            return roundRect.getBottom() == Float.intBitsToFloat((int) (j6 & 4294967295L)) + Float.intBitsToFloat(i6) && Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() >> 32)) == f;
        }
        return false;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.INSTANCE.m3911getZeroF1C5BW0();
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            androidx.compose.ui.graphics.Outline outline = this.outline;
            if (outline == null || !this.outlineNeeded || Float.intBitsToFloat((int) (this.rectSize >> 32)) <= 0.0f || Float.intBitsToFloat((int) (this.rectSize & 4294967295L)) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            if (outline instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) outline).getRect());
            } else if (outline instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) outline).getRoundRect());
            } else {
                if (!(outline instanceof Outline.Generic)) {
                    throw new NoWhenBranchMatchedException();
                }
                updateCacheWithPath(((Outline.Generic) outline).getPath());
            }
        }
    }

    private final void updateCacheWithPath(Path composePath) {
        OutlineVerificationHelper.INSTANCE.setPath(this.cachedOutline, composePath);
        this.usePathForClip = !this.cachedOutline.canClip();
        this.outlinePath = composePath;
    }

    private final void updateCacheWithRect(Rect rect) {
        float left = rect.getLeft();
        float top = rect.getTop();
        this.rectTopLeft = Offset.m3887constructorimpl((Float.floatToRawIntBits(top) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
        float right = rect.getRight() - rect.getLeft();
        float bottom = rect.getBottom() - rect.getTop();
        this.rectSize = Size.m3955constructorimpl((Float.floatToRawIntBits(bottom) & 4294967295L) | (Float.floatToRawIntBits(right) << 32));
        this.cachedOutline.setRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() >> 32));
        float left = roundRect.getLeft();
        float top = roundRect.getTop();
        this.rectTopLeft = Offset.m3887constructorimpl((Float.floatToRawIntBits(top) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
        float width = roundRect.getWidth();
        float height = roundRect.getHeight();
        this.rectSize = Size.m3955constructorimpl((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32));
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(Math.round(roundRect.getLeft()), Math.round(roundRect.getTop()), Math.round(roundRect.getRight()), Math.round(roundRect.getBottom()), fIntBitsToFloat);
            this.roundedCornerRadius = fIntBitsToFloat;
            return;
        }
        Path Path = this.cachedRrectPath;
        if (Path == null) {
            Path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = Path;
        }
        Path.reset();
        Path.addRoundRect$default(Path, roundRect, null, 2, null);
        updateCacheWithPath(Path);
    }

    public final void clipToOutline(Canvas canvas) {
        Path clipPath = getClipPath();
        if (clipPath != null) {
            Canvas.m4110clipPathmtrdDE$default(canvas, clipPath, 0, 2, null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f <= 0.0f) {
            Canvas.m4111clipRectN_I0leg$default(canvas, Float.intBitsToFloat((int) (this.rectTopLeft >> 32)), Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L)), Float.intBitsToFloat((int) (this.rectTopLeft >> 32)) + Float.intBitsToFloat((int) (this.rectSize >> 32)), Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L)) + Float.intBitsToFloat((int) (this.rectSize & 4294967295L)), 0, 16, null);
            return;
        }
        Path Path = this.tmpPath;
        RoundRect roundRect = this.tmpRoundRect;
        if (Path == null || !m6048isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (this.rectTopLeft >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L));
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (this.rectSize >> 32)) + Float.intBitsToFloat((int) (this.rectTopLeft >> 32));
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (this.rectSize & 4294967295L)) + Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L));
            float f7 = this.roundedCornerRadius;
            RoundRect roundRectM3949RoundRectgG7oq9Y = RoundRectKt.m3949RoundRectgG7oq9Y(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(f7) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L)));
            if (Path == null) {
                Path = AndroidPath_androidKt.Path();
            } else {
                Path.reset();
            }
            Path.addRoundRect$default(Path, roundRectM3949RoundRectgG7oq9Y, null, 2, null);
            this.tmpRoundRect = roundRectM3949RoundRectgG7oq9Y;
            this.tmpPath = Path;
        }
        Canvas.m4110clipPathmtrdDE$default(canvas, Path, 0, 2, null);
    }

    public final android.graphics.Outline getAndroidOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    /* renamed from: getCacheIsDirty$ui_release, reason: from getter */
    public final boolean getCacheIsDirty() {
        return this.cacheIsDirty;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    /* renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m6049isInOutlinek4lQ0M(long position) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.outline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Float.intBitsToFloat((int) (position >> 32)), Float.intBitsToFloat((int) (position & 4294967295L)), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    /* renamed from: update-S_szKao, reason: not valid java name */
    public final boolean m6050updateS_szKao(androidx.compose.ui.graphics.Outline outline, float alpha, boolean clipToOutline, float elevation, long size) {
        this.cachedOutline.setAlpha(alpha);
        boolean zB = kotlin.jvm.internal.k.b(this.outline, outline);
        boolean z10 = !zB;
        if (!zB) {
            this.outline = outline;
            this.cacheIsDirty = true;
        }
        this.rectSize = size;
        boolean z11 = outline != null && (clipToOutline || elevation > 0.0f);
        if (this.outlineNeeded != z11) {
            this.outlineNeeded = z11;
            this.cacheIsDirty = true;
        }
        return z10;
    }
}
