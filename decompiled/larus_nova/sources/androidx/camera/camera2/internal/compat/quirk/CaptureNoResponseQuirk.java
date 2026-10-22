package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureNoResponseQuirk implements Quirk {
    public CaptureNoResponseQuirk() {
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        String r101 = Build.HARDWARE;
        if ("samsungexynos7420".equalsIgnoreCase(r101) == true) goto L7;
        if ("universal7420".equalsIgnoreCase(r101) == true) goto L7;
    L9:
        return false;
    L7:
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L9;
        return true;
    }
}
