package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyCameraSurfaceCleanupQuirk implements Quirk {
    public LegacyCameraSurfaceCleanupQuirk() {
    }

    public static boolean isLegacyDevice(CameraCharacteristicsCompat r100) {
        Integer r101 = (Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.intValue() != 2) goto L7;
        return true;
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 > 23) goto L5;
    L9:
        return false;
    L5:
        if (r101 >= 29) goto L9;
        if (isLegacyDevice(r100) == false) goto L9;
        return true;
    }
}
