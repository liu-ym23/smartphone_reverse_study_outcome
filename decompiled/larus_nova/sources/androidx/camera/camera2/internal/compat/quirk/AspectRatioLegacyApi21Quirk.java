package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class AspectRatioLegacyApi21Quirk implements Quirk {
    public AspectRatioLegacyApi21Quirk() {
    }

    public int getCorrectedAspectRatio() {
        return 2;
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        Integer r101 = (Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if (r101.intValue() != 2) goto L9;
        if (Build.VERSION.SDK_INT != 21) goto L9;
        return true;
    }
}
