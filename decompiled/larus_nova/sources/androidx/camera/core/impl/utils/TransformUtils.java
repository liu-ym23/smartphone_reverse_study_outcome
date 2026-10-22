package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.core.util.Preconditions;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class TransformUtils {
    public static final RectF NORMALIZED_RECT = null;

    static {
        NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);
    }

    private TransformUtils() {
    }

    public static Matrix getNormalizedToBuffer(RectF r100) {
        Matrix r101 = new Matrix();
        r101.setRectToRect(NORMALIZED_RECT, r100, Matrix.ScaleToFit.FILL);
        return r101;
    }

    public static int getRotationDegrees(Matrix r100) {
        float[] r101 = new float[9];
        r100.getValues(r101);
        return within360((int) Math.round(Math.atan2(r101[3], r101[0]) * 57.29577951308232d));
    }

    public static boolean is90or270(int r100) {
        if (r100 != 90) goto L5;
        return true;
    L5:
        if (r100 == 270) goto L18;
        if (r100 != 0) goto L9;
        return false;
    L9:
        if (r100 != 180) goto L12;
        return false;
    L12:
        throw new IllegalArgumentException("Invalid rotation degrees: " + r100);
    L18:
        return true;
    }

    public static boolean isMirrored(Matrix r100) {
        float[] r101 = {0.0f, 1.0f, 1.0f, 0.0f};
        r100.mapVectors(r101);
        if (calculateSignedAngle(r101[0], r101[1], r101[2], r101[3]) <= 0.0f) goto L6;
        return true;
    L6:
        return false;
    }

    public static Size rectToSize(Rect r100) {
        return new Size(r100.width(), r100.height());
    }

    public static String rectToString(Rect r100) {
        return String.format(Locale.US, "%s(%dx%d)", new Object[]{r100, Integer.valueOf(r100.width()), Integer.valueOf(r100.height())});
    }

    public static float[] rectToVertices(RectF r100) {
        float r101 = r100.left;
        float r102 = r100.top;
        float r103 = r100.right;
        float r104 = r100.bottom;
        return new float[]{r101, r102, r103, r102, r103, r104, r101, r104};
    }

    public static Size reverseSize(Size r100) {
        return new Size(r100.getHeight(), r100.getWidth());
    }

    public static SizeF reverseSizeF(SizeF r100) {
        return new SizeF(r100.getHeight(), r100.getWidth());
    }

    public static Rect sizeToRect(Size r100) {
        return sizeToRect(r100, 0, 0);
    }

    public static RectF sizeToRectF(Size r100) {
        return sizeToRectF(r100, 0, 0);
    }

    public static float[] sizeToVertices(Size r100) {
        return new float[]{0.0f, 0.0f, r100.getWidth(), 0.0f, r100.getWidth(), r100.getHeight(), 0.0f, r100.getHeight()};
    }

    public static RectF verticesToRect(float[] r110) {
        return new RectF(min(r110[0], r110[2], r110[4], r110[6]), min(r110[1], r110[3], r110[5], r110[7]), max(r110[0], r110[2], r110[4], r110[6]), max(r110[1], r110[3], r110[5], r110[7]));
    }

    public static int within360(int r100) {
        return ((r100 % 360) + 360) % 360;
    }

    public static Matrix getNormalizedToBuffer(Rect r100) {
        return getNormalizedToBuffer(new RectF(r100));
    }

    public static Size getRotatedSize(Rect r100, int r101) {
        return rotateSize(rectToSize(r100), r101);
    }

    public static boolean hasCropping(Rect r100, Size r101) {
        if (r100.left == 0) goto L5;
    L12:
        return true;
    L5:
        if (r100.top != 0) goto L12;
        if (r100.width() != r101.getWidth()) goto L12;
        if (r100.height() != r101.getHeight()) goto L12;
        return false;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size r100, Size r101) {
        return isAspectRatioMatchingWithRoundingError(r100, false, r101, false);
    }

    public static RectF rotateRect(RectF r100, int r101) {
        if ((r101 % 90) != 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "Invalid rotation degrees: " + r101);
        if (is90or270(within360(r101)) == true) goto L9;
        return r100;
    L9:
        return new RectF(0.0f, 0.0f, r100.height(), r100.width());
    L5:
        r102 = false;
        goto L6
    }

    public static Size rotateSize(Size r100, int r101) {
        if ((r101 % 90) != 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "Invalid rotation degrees: " + r101);
        if (is90or270(within360(r101)) == true) goto L9;
        return r100;
    L9:
        return reverseSize(r100);
    L5:
        r102 = false;
        goto L6
    }

    public static Matrix updateSensorToBufferTransform(Matrix r100, Rect r101) {
        Matrix r102 = new Matrix(r100);
        r102.postTranslate(-r101.left, -r101.top);
        return r102;
    }

    public static Matrix getExifTransform(int r100, int r110, int r111) {
        Matrix r101 = new Matrix();
        float r112 = r110;
        float r113 = r111;
        RectF r102 = new RectF(0.0f, 0.0f, r112, r113);
        RectF r103 = NORMALIZED_RECT;
        r101.setRectToRect(r102, r103, Matrix.ScaleToFit.FILL);
        boolean r104 = true;
        switch(r100) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L12;
        };
    L5:
        r101.postRotate(270.0f);
    L13:
        if (r104 == false) goto L15;
        r102 = new RectF(0.0f, 0.0f, r113, r112);
    L15:
        Matrix r105 = new Matrix();
        r105.setRectToRect(r103, r102, Matrix.ScaleToFit.FILL);
        r101.postConcat(r105);
        return r101;
    L6:
        r101.postScale(-1.0f, 1.0f);
        r101.postRotate(90.0f);
        goto L13
    L7:
        r101.postRotate(90.0f);
        goto L13
    L8:
        r101.postScale(-1.0f, 1.0f);
        r101.postRotate(270.0f);
        goto L13
    L9:
        r101.postScale(1.0f, -1.0f);
        goto L12
    L10:
        r101.postRotate(180.0f);
        goto L12
    L11:
        r101.postScale(-1.0f, 1.0f);
    L12:
        r104 = false;
        goto L13
    }

    public static Matrix getRectToRect(RectF r100, RectF r101, int r102) {
        return getRectToRect(r100, r101, r102, false);
    }

    public static Rect sizeToRect(Size r100, int r101, int r102) {
        return new Rect(r101, r102, r100.getWidth() + r101, r100.getHeight() + r102);
    }

    public static RectF sizeToRectF(Size r100, int r101, int r102) {
        return new RectF(r101, r102, r101 + r100.getWidth(), r102 + r100.getHeight());
    }

    public static float calculateSignedAngle(float r100, float r101, float r102, float r103) {
        float r104 = (r100 * r102) + (r101 * r103);
        float r105 = (r100 * r103) - (r101 * r102);
        double r106 = Math.sqrt((r100 * r100) + (r101 * r101)) * Math.sqrt((r102 * r102) + (r103 * r103));
        return (float) Math.toDegrees(Math.atan2(((double) r105) / r106, ((double) r104) / r106));
    }

    public static Matrix getRectToRect(RectF r100, RectF r101, int r102, boolean r103) {
        Matrix r104 = new Matrix();
        r104.setRectToRect(r100, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        r104.postRotate(r102);
        if (r103 == false) goto L5;
        r104.postScale(-1.0f, 1.0f);
    L5:
        r104.postConcat(getNormalizedToBuffer(r101));
        return r104;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size r100, boolean r101, Size r102, boolean r103) {
        if (r101 == false) goto L5;
        float r104 = r100.getWidth() / r100.getHeight();
        float r105 = r104;
    L6:
        if (r103 == false) goto L8;
        float r106 = r102.getWidth() / r102.getHeight();
        float r107 = r106;
    L10:
        if (r104 >= r106) goto L12;
    L14:
        return false;
    L12:
        if (r107 < r105) goto L14;
        return true;
    L8:
        float r108 = (r102.getWidth() + 1.0f) / (r102.getHeight() - 1.0f);
        r106 = (r102.getWidth() - 1.0f) / (r102.getHeight() + 1.0f);
        r107 = r108;
        goto L10
    L5:
        r104 = (r100.getWidth() + 1.0f) / (r100.getHeight() - 1.0f);
        r105 = (r100.getWidth() - 1.0f) / (r100.getHeight() + 1.0f);
        goto L6
    }

    public static float max(float r100, float r101, float r102, float r103) {
        return Math.max(Math.max(r100, r101), Math.max(r102, r103));
    }

    public static float min(float r100, float r101, float r102, float r103) {
        return Math.min(Math.min(r100, r101), Math.min(r102, r103));
    }
}
