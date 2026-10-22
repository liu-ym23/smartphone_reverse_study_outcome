package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.core.Logger;
import java.nio.BufferUnderflowException;

/* JADX INFO: loaded from: classes2.dex */
public final class FlashAvailabilityChecker {
    private static final String TAG = "FlashAvailability";

    private FlashAvailabilityChecker() {
    }

    public static boolean isFlashAvailable(CameraCharacteristicsProvider r100) {
        return isFlashAvailable(false, r100);
    }

    public static boolean isFlashAvailable(boolean r100, CameraCharacteristicsProvider r101) {
        Boolean r102 = (Boolean) r101.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);     // Catch: BufferUnderflowException -> L5
    L12:
        if (r102 != null) goto L14;
        Logger.w(TAG, "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
    L14:
        if (r102 != null) goto L16;
        return false;
    L16:
        return r102.booleanValue();
    L5:
        e = move-exception;
        if (DeviceQuirks.get(FlashAvailabilityBufferUnderflowQuirk.class) == null) goto L9;
        Logger.d(TAG, String.format("Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: %s, Model: %s, API Level: %d].", new Object[]{Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)}));
    L10:
        if (r100 == true) goto L17;
        r102 = Boolean.FALSE;
        goto L12
    L17:
        throw e;
    L9:
        Logger.e(TAG, String.format("Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, API Level: %d].\nFlash is not available.", new Object[]{Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)}), e);
        goto L10
    }
}
