package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoStabilizationUtil {
    private VideoStabilizationUtil() {
    }

    public static boolean isPreviewStabilizationSupported(CameraCharacteristicsCompat r100) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        int[] r101 = (int[]) r100.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r101 != null) goto L8;
    L17:
        return false;
    L8:
        if (r101.length == 0) goto L17;
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L17;
        if (r101[r103] == 2) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return true;
    }
}
