package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        if (r100 != 90) goto L6;
        return 1;
    L6:
        if (r100 != 180) goto L8;
        return 2;
    L8:
        if (r100 != 270) goto L11;
        return 3;
    L11:
        throw new IllegalStateException("Invalid sensor rotation: " + r100);
    }

    public static int surfaceRotationToDegrees(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        if (r100 != 1) goto L6;
        return 90;
    L6:
        if (r100 != 2) goto L8;
        return 180;
    L8:
        if (r100 != 3) goto L11;
        return 270;
    L11:
        throw new IllegalArgumentException("Unsupported surface rotation: " + r100);
    }

    public static int getRelativeImageRotation(int r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        int r103 = ((r101 - r100) + 360) % 360;
    L6:
        if (Logger.isVerboseEnabled(TAG) == false) goto L8;
        Logger.d(TAG, String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Boolean.valueOf(r102), Integer.valueOf(r103)}));
    L8:
        return r103;
    L4:
        r103 = (r101 + r100) % 360;
        goto L6
    }
}
