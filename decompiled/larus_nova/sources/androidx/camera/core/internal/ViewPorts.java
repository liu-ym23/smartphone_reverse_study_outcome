package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPorts {
    private static float flipX(float r100, float r101) {
        return (r101 + r101) - r100;
    }

    private static float flipY(float r100, float r101) {
        return (r101 + r101) - r100;
    }

    private static boolean shouldMirrorStartAndEnd(boolean r100, int r101) {
        boolean r102 = true;
        if (r101 == 1) goto L7;
        r102 = false;
    L7:
        return r100 ^ r102;
    }

    private ViewPorts() {
    }

    private static RectF flipHorizontally(RectF r100, float r101) {
        return new RectF(flipX(r100.right, r101), r100.top, flipX(r100.left, r101), r100.bottom);
    }

    private static RectF flipVertically(RectF r100, float r101) {
        return new RectF(r100.left, flipY(r100.bottom, r101), r100.right, flipY(r100.top, r101));
    }

    private static RectF correctStartOrEnd(boolean r100, int r101, RectF r102, RectF r103) {
        boolean r104 = true;
        if (r101 != 0) goto L6;
        if (r100 == true) goto L6;
        boolean r105 = true;
    L8:
        if (r101 != 90) goto L11;
        if (r100 == false) goto L11;
        boolean r106 = true;
    L12:
        if (r105 == true) goto L58;
        if (r106 == true) goto L58;
        if (r101 != 0) goto L18;
        if (r100 == false) goto L18;
        boolean r107 = true;
    L20:
        if (r101 != 270) goto L23;
        if (r100 == true) goto L23;
        boolean r108 = true;
    L24:
        if (r107 == true) goto L57;
        if (r108 == true) goto L57;
        if (r101 != 90) goto L30;
        if (r100 == true) goto L30;
        boolean r109 = true;
    L32:
        if (r101 != 180) goto L35;
        if (r100 == false) goto L35;
        boolean r110 = true;
    L36:
        if (r109 == true) goto L55;
        if (r110 == true) goto L55;
        if (r101 != 180) goto L42;
        if (r100 == true) goto L42;
        boolean r111 = true;
    L43:
        if (r101 != 270) goto L46;
        if (r100 == false) goto L46;
    L47:
        if (r111 == true) goto L53;
        if (r104 == true) goto L53;
        throw new IllegalArgumentException("Invalid argument: mirrored " + r100 + " rotation " + r101);
    L53:
        return flipHorizontally(flipVertically(r103, r102.centerY()), r102.centerX());
    L46:
        r104 = false;
    L42:
        r111 = false;
    L55:
        return flipVertically(r103, r102.centerY());
    L35:
        r110 = false;
    L30:
        r109 = false;
    L57:
        return flipHorizontally(r103, r102.centerX());
    L23:
        r108 = false;
    L18:
        r107 = false;
    L58:
        return r103;
    L11:
        r106 = false;
    L6:
        r105 = false;
        goto L8
    }

    public static RectF getScaledRect(RectF r100, Rational r101, int r102, boolean r103, int r104, int r105) {
        if (r102 != 3) goto L5;
        return r100;
    L5:
        Matrix r106 = new Matrix();
        RectF r107 = new RectF(0.0f, 0.0f, r101.getNumerator(), r101.getDenominator());
        if (r102 != 0) goto L8;
        r106.setRectToRect(r107, r100, Matrix.ScaleToFit.START);
    L16:
        RectF r108 = new RectF();
        r106.mapRect(r108, r107);
        return correctStartOrEnd(shouldMirrorStartAndEnd(r103, r104), r105, r100, r108);
    L8:
        if (r102 != 1) goto L10;
        r106.setRectToRect(r107, r100, Matrix.ScaleToFit.CENTER);
        goto L16
    L10:
        if (r102 != 2) goto L13;
        r106.setRectToRect(r107, r100, Matrix.ScaleToFit.END);
        goto L16
    L13:
        throw new IllegalStateException("Unexpected scale type: " + r102);
    }

    public static Map<UseCase, Rect> calculateViewPortRects(Rect r100, boolean r101, Rational r110, int r111, int r112, int r113, Map<UseCase, StreamSpec> r114) {
        if (r100.width() > 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Preconditions.checkArgument(r102, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF r103 = new RectF(r100);
        HashMap r104 = new HashMap();
        RectF r105 = new RectF(r100);
        Iterator<Map.Entry<UseCase, StreamSpec>> r106 = r114.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        Map.Entry<UseCase, StreamSpec> r115 = r106.next();
        Matrix r107 = new Matrix();
        RectF r108 = new RectF(0.0f, 0.0f, r115.getValue().getResolution().getWidth(), r115.getValue().getResolution().getHeight());
        r107.setRectToRect(r108, r103, Matrix.ScaleToFit.CENTER);
        r104.put(r115.getKey(), r107);
        RectF r116 = new RectF();
        r107.mapRect(r116, r108);
        r105.intersect(r116);
        goto L10
    L12:
        RectF r109 = getScaledRect(r105, ImageUtil.getRotatedAspectRatio(r111, r110), r112, r101, r113, r111);
        HashMap r117 = new HashMap();
        RectF r118 = new RectF();
        Matrix r119 = new Matrix();
        Iterator r120 = r104.entrySet().iterator();
    L14:
        if (r120.hasNext() == false) goto L16;
        Map.Entry r121 = (Map.Entry) r120.next();
        ((Matrix) r121.getValue()).invert(r119);
        r119.mapRect(r118, r109);
        Rect r122 = new Rect();
        r118.round(r122);
        r117.put((UseCase) r121.getKey(), r122);
        goto L14
    L16:
        return r117;
    L5:
        if (r100.height() <= 0) goto L7;
        r102 = true;
        goto L8
    }
}
