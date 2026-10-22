package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class AutoFlashUnderExposedQuirk implements Quirk {
    public AutoFlashUnderExposedQuirk() {
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        return false;
    }
}
