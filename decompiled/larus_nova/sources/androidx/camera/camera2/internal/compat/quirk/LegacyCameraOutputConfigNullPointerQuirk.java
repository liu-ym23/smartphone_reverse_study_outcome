package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyCameraOutputConfigNullPointerQuirk implements Quirk {
    public LegacyCameraOutputConfigNullPointerQuirk() {
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        Integer r101 = (Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (Build.VERSION.SDK_INT <= 23) goto L8;
        if (r101 == null) goto L8;
        if (r101.intValue() != 2) goto L8;
        return true;
    L8:
        return false;
    }
}
