package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class AfRegionFlipHorizontallyQuirk implements Quirk {
    public AfRegionFlipHorizontallyQuirk() {
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        if (Build.BRAND.equalsIgnoreCase("SAMSUNG") == true) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 33) goto L9;
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L9;
        return true;
    }
}
