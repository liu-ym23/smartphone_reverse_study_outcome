package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public class FovUtil {
    private static final String TAG = "FovUtil";

    private FovUtil() {
    }

    public static float getDefaultFocalLength(CameraCharacteristicsCompat r100) {
        float[] r101 = (float[]) r100.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        Preconditions.checkNotNull(r101, "The focal lengths can not be empty.");
        return r101[0];
    }

    public static float getSensorHorizontalLength(CameraCharacteristicsCompat r100) {
        SizeF r101 = (SizeF) r100.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        Rect r102 = (Rect) r100.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Size r103 = (Size) r100.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        Integer r104 = (Integer) r100.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(r101, "The sensor size can't be null.");
        Preconditions.checkNotNull(r104, "The sensor orientation can't be null.");
        Preconditions.checkNotNull(r102, "The active array size can't be null.");
        Preconditions.checkNotNull(r103, "The pixel array size can't be null.");
        Size r105 = TransformUtils.rectToSize(r102);
        if (TransformUtils.is90or270(r104.intValue()) == false) goto L6;
        r101 = TransformUtils.reverseSizeF(r101);
        r105 = TransformUtils.reverseSize(r105);
        r103 = TransformUtils.reverseSize(r103);
    L6:
        return (r101.getWidth() * r105.getWidth()) / r103.getWidth();
    }

    public static int focalLengthToViewAngleDegrees(float r100, float r101) {
        boolean r102 = true;
        if (r100 <= 0.0f) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "Focal length should be positive.");
        if (r101 > 0.0f) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102, "Sensor length should be positive.");
        int r104 = (int) Math.toDegrees(Math.atan(r101 / (r100 * 2.0f)) * 2.0d);
        Preconditions.checkArgumentInRange(r104, 0, 360, "The provided focal length and sensor length result in an invalid view angle degrees.");
        return r104;
    L5:
        r103 = false;
        goto L6
    }

    public static int getDeviceDefaultViewAngleDegrees(CameraManagerCompat r100, int r101) {
        String[] r102 = r100.getCameraIdList();     // Catch: CameraAccessExceptionCompat -> L11
        int r103 = r102.length;     // Catch: CameraAccessExceptionCompat -> L11
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        CameraCharacteristicsCompat r105 = r100.getCameraCharacteristicsCompat(r102[r104]);     // Catch: CameraAccessExceptionCompat -> L11
        Integer r106 = (Integer) r105.get(CameraCharacteristics.LENS_FACING);     // Catch: CameraAccessExceptionCompat -> L11
        Preconditions.checkNotNull(r106, "Lens facing can not be null");     // Catch: CameraAccessExceptionCompat -> L11
        if (r106.intValue() == LensFacingUtil.getLensFacingInt(r101)) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return focalLengthToViewAngleDegrees(getDefaultFocalLength(r105), getSensorHorizontalLength(r105));
    L10:
        throw new IllegalArgumentException("Unable to get the default focal length with the specified lens facing.");
    L12:
        throw new IllegalArgumentException("Unable to get the default focal length.");
    }
}
