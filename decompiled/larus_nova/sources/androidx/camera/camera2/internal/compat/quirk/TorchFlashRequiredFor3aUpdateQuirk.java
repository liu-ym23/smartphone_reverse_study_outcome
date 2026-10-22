package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class TorchFlashRequiredFor3aUpdateQuirk implements Quirk {
    private static final List<String> AFFECTED_PIXEL_MODELS = null;
    private final CameraCharacteristicsCompat mCameraCharacteristics;

    static {
        AFFECTED_PIXEL_MODELS = Arrays.asList(new String[]{"PIXEL 6A", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7A", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"});
    }

    private static boolean isAffectedPixelModel() {
        Iterator<String> r100 = AFFECTED_PIXEL_MODELS.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        String r101 = r100.next();
        if (Build.MODEL.toUpperCase(Locale.US).equals(r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isFlashModeTorchRequired() {
        return !isExternalFlashAeModeSupported(this.mCameraCharacteristics);
    }

    public TorchFlashRequiredFor3aUpdateQuirk(CameraCharacteristicsCompat r100) {
        this.mCameraCharacteristics = r100;
    }

    private static boolean isAffectedModel(CameraCharacteristicsCompat r100) {
        if (isAffectedPixelModel() == true) goto L5;
    L7:
        return false;
    L5:
        if (isFrontCamera(r100) == false) goto L7;
        return true;
    }

    private static boolean isExternalFlashAeModeSupported(CameraCharacteristicsCompat r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return false;
    L6:
        if (Camera2CameraControlImpl.getSupportedAeMode(r100, 5) != 5) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean isFrontCamera(CameraCharacteristicsCompat r100) {
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        return isAffectedModel(r100);
    }
}
