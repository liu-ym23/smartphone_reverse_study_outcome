package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    public static CameraUnavailableException createFrom(CameraAccessExceptionCompat r100) {
        int r101 = r100.getReason();
        int r102 = 1;
        if (r101 == 1) goto L17;
        r102 = 2;
        if (r101 == 2) goto L17;
        r102 = 3;
        if (r101 == 3) goto L17;
        r102 = 4;
        if (r101 == 4) goto L17;
        r102 = 5;
        if (r101 == 5) goto L17;
        if (r101 == 10001) goto L15;
        r102 = 0;
        goto L17
    L15:
        r102 = 6;
    L17:
        return new CameraUnavailableException(r102, r100);
    }
}
