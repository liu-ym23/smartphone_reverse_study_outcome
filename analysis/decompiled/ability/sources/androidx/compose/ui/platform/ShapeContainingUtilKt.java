package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002\u001a\f\u0010\u0011\u001a\u00020\u0001*\u00020\u0012H\u0002\u001a7\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a4\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u001c"}, d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "isInPath", SingleFileBundle.KEY_PATH, "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        if (Float.intBitsToFloat((int) (roundRect.m3946getTopRightCornerRadiuskKHJgLs() >> 32)) + Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() >> 32)) > roundRect.getWidth()) {
            return false;
        }
        if (Float.intBitsToFloat((int) (roundRect.m3944getBottomRightCornerRadiuskKHJgLs() >> 32)) + Float.intBitsToFloat((int) (roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() >> 32)) > roundRect.getWidth()) {
            return false;
        }
        if (Float.intBitsToFloat((int) (roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() & 4294967295L)) + Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() & 4294967295L)) <= roundRect.getHeight()) {
            return Float.intBitsToFloat((int) (roundRect.m3944getBottomRightCornerRadiuskKHJgLs() & 4294967295L)) + Float.intBitsToFloat((int) (roundRect.m3946getTopRightCornerRadiuskKHJgLs() & 4294967295L)) <= roundRect.getHeight();
        }
        return false;
    }

    public static final boolean isInOutline(Outline outline, float f, float f7, Path path, Path path2) {
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f7);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f7, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f7, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f7, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f7, path, path2);
    }

    private static final boolean isInPath(Path path, float f, float f7, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f7 - 0.005f, f + 0.005f, f7 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        Path.addRect$default(path2, rect, null, 2, null);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo4029opN5in7k0(path, path2, PathOperation.INSTANCE.m4443getIntersectb3I0S0c());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f, float f7) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f7 && f7 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f7, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f7 < roundRect.getTop() || f7 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect$default(Path, roundRect, null, 2, null);
            return isInPath(Path, f, f7, path, path2);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() >> 32)) + roundRect.getLeft();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() & 4294967295L)) + roundRect.getTop();
        float right = roundRect.getRight() - Float.intBitsToFloat((int) (roundRect.m3946getTopRightCornerRadiuskKHJgLs() >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (roundRect.m3946getTopRightCornerRadiuskKHJgLs() & 4294967295L)) + roundRect.getTop();
        float right2 = roundRect.getRight() - Float.intBitsToFloat((int) (roundRect.m3944getBottomRightCornerRadiuskKHJgLs() >> 32));
        float bottom = roundRect.getBottom() - Float.intBitsToFloat((int) (roundRect.m3944getBottomRightCornerRadiuskKHJgLs() & 4294967295L));
        float bottom2 = roundRect.getBottom() - Float.intBitsToFloat((int) (4294967295L & roundRect.m3943getBottomLeftCornerRadiuskKHJgLs()));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() >> 32)) + roundRect.getLeft();
        if (f < fIntBitsToFloat && f7 < fIntBitsToFloat2) {
            return m6054isWithinEllipseVE1yxkc(f, f7, roundRect.m3945getTopLeftCornerRadiuskKHJgLs(), fIntBitsToFloat, fIntBitsToFloat2);
        }
        if (f < fIntBitsToFloat4 && f7 > bottom2) {
            return m6054isWithinEllipseVE1yxkc(f, f7, roundRect.m3943getBottomLeftCornerRadiuskKHJgLs(), fIntBitsToFloat4, bottom2);
        }
        if (f > right && f7 < fIntBitsToFloat3) {
            return m6054isWithinEllipseVE1yxkc(f, f7, roundRect.m3946getTopRightCornerRadiuskKHJgLs(), right, fIntBitsToFloat3);
        }
        if (f <= right2 || f7 <= bottom) {
            return true;
        }
        return m6054isWithinEllipseVE1yxkc(f, f7, roundRect.m3944getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    /* renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m6054isWithinEllipseVE1yxkc(float f, float f7, long j5, float f9, float f10) {
        float f11 = f - f9;
        float f12 = f7 - f10;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        return ((f12 * f12) / (fIntBitsToFloat2 * fIntBitsToFloat2)) + ((f11 * f11) / (fIntBitsToFloat * fIntBitsToFloat)) <= 1.0f;
    }
}
