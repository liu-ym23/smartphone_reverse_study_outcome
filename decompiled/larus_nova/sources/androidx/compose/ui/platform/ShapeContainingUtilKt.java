package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002\u001a\f\u0010\u0011\u001a\u00020\u0001*\u00020\u0012H\u0002\u001a7\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a4\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u001c"}, d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInRectangle", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "isInPath", "path", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect r100) {
        if ((Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() >> 32)) + Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() >> 32))) <= r100.getWidth()) goto L5;
    L11:
        return false;
    L5:
        if ((Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() >> 32)) + Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() >> 32))) > r100.getWidth()) goto L11;
        if ((Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)) + Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax))) > r100.getHeight()) goto L11;
        if ((Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)) + Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax))) > r100.getHeight()) goto L11;
        return true;
    }

    private static final boolean isInRectangle(Rect r100, float r101, float r102) {
        if (r100.getLeft() <= r101) goto L5;
    L11:
        return false;
    L5:
        if (r101 >= r100.getRight()) goto L11;
        if (r100.getTop() > r102) goto L11;
        if (r102 >= r100.getBottom()) goto L11;
        return true;
    }

    public static final boolean isInOutline(Outline r100, float r101, float r102, Path r103, Path r104) {
        if ((r100 instanceof Outline.Rectangle) == false) goto L6;
        return isInRectangle(((Outline.Rectangle) r100).getRect(), r101, r102);
    L6:
        if ((r100 instanceof Outline.Rounded) == false) goto L9;
        return isInRoundedRect((Outline.Rounded) r100, r101, r102, r103, r104);
    L9:
        if ((r100 instanceof Outline.Generic) == false) goto L13;
        return isInPath(((Outline.Generic) r100).getPath(), r101, r102, r103, r104);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean isInPath(Path r100, float r101, float r102, Path r103, Path r104) {
        Rect r105 = new Rect(r101 - 0.005f, r102 - 0.005f, r101 + 0.005f, r102 + 0.005f);
        if (r103 != null) goto L5;
        r103 = AndroidPath_androidKt.Path();
    L5:
        Path.CC.addRect$default(r103, r105, null, 2, null);
        if (r104 != null) goto L8;
        r104 = AndroidPath_androidKt.Path();
    L8:
        r104.mo4717opN5in7k0(r100, r103, PathOperation.Companion.m5141getIntersectb3I0S0c());
        boolean r106 = r104.isEmpty();
        r104.reset();
        r103.reset();
        return !r106;
    }

    private static final boolean isInRoundedRect(Outline.Rounded r110, float r111, float r112, Path r113, Path r114) {
        RoundRect r100 = r110.getRoundRect();
        if (r111 >= r100.getLeft()) goto L5;
        return false;
    L5:
        if (r111 < r100.getRight()) goto L7;
        return false;
    L7:
        if (r112 >= r100.getTop()) goto L9;
        return false;
    L9:
        if (r112 < r100.getBottom()) goto L12;
        return false;
    L12:
        if (cornersFit(r100) == true) goto L18;
        if (r114 != null) goto L15;
        Path r101 = AndroidPath_androidKt.Path();
    L16:
        Path.CC.addRoundRect$default(r101, r100, null, 2, null);
        return isInPath(r101, r111, r112, r113, r114);
    L15:
        r101 = r114;
        goto L16
    L18:
        float r102 = r100.getLeft();
        float r103 = Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() >> 32)) + r102;
        float r104 = r100.getTop();
        float r105 = Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)) + r104;
        float r106 = r100.getRight() - Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() >> 32));
        float r107 = r100.getTop();
        float r108 = Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax)) + r107;
        float r115 = r100.getRight() - Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() >> 32));
        float r116 = r100.getBottom() - Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax));
        float r109 = r100.getBottom() - Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100.m4630getBottomLeftCornerRadiuskKHJgLs()));
        float r117 = r100.getLeft();
        float r118 = Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() >> 32)) + r117;
        if (r111 >= r103) goto L24;
        if (r112 >= r105) goto L24;
        return m6744isWithinEllipseVE1yxkc(r111, r112, r100.m4632getTopLeftCornerRadiuskKHJgLs(), r103, r105);
    L24:
        if (r111 >= r118) goto L29;
        if (r112 <= r109) goto L29;
        return m6744isWithinEllipseVE1yxkc(r111, r112, r100.m4630getBottomLeftCornerRadiuskKHJgLs(), r118, r109);
    L29:
        if (r111 <= r106) goto L34;
        if (r112 >= r108) goto L34;
        return m6744isWithinEllipseVE1yxkc(r111, r112, r100.m4633getTopRightCornerRadiuskKHJgLs(), r106, r108);
    L34:
        if (r111 > r115) goto L36;
    L38:
        return true;
    L36:
        if (r112 <= r116) goto L38;
        return m6744isWithinEllipseVE1yxkc(r111, r112, r100.m4631getBottomRightCornerRadiuskKHJgLs(), r115, r116);
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m6744isWithinEllipseVE1yxkc(float r100, float r101, long r102, float r103, float r104) {
        float r105 = r100 - r103;
        float r106 = r101 - r104;
        float r107 = Float.intBitsToFloat((int) (r102 >> 32));
        float r108 = Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax));
        if ((((r105 * r105) / (r107 * r107)) + ((r106 * r106) / (r108 * r108))) > 1.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean isInOutline$default(Outline r100, float r101, float r102, Path r103, Path r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r104 = null;
    L9:
        return isInOutline(r100, r101, r102, r103, r104);
    }
}
