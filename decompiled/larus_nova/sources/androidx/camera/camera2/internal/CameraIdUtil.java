package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.InitializationException;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraIdUtil {
    private CameraIdUtil() {
    }

    public static boolean isBackwardCompatible(CameraManagerCompat r100, String r101) throws InitializationException {
        if ("robolectric".equals(Build.FINGERPRINT) == false) goto L18;
        return true;
    L18:
        int[] r102 = (int[]) r100.getCameraCharacteristicsCompat(r101).get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);     // Catch: CameraAccessExceptionCompat -> L15
        if (r102 == null) goto L14;
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L14;
        if (r102[r104] == 0) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    L15:
        e = move-exception;
        throw new InitializationException(CameraUnavailableExceptionHelper.createFrom(e));
    }
}
