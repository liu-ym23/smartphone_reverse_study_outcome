package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* JADX INFO: loaded from: classes2.dex */
final class ZslUtil {
    private ZslUtil() {
    }

    public static boolean isCapabilitySupported(CameraCharacteristicsCompat r100, int r101) {
        int[] r102 = (int[]) r100.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (r102 == null) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        if (r102[r104] == r101) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }
}
