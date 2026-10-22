package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureWithFlashUnderexposureQuirk implements UseTorchAsFlashQuirk {
    public static final List<String> BUILD_MODELS = null;

    public ImageCaptureWithFlashUnderexposureQuirk() {
    }

    static {
        BUILD_MODELS = Arrays.asList(new String[]{"sm-a260f", "sm-j530f", "sm-j600g", "sm-j701f", "sm-g610f", "sm-j710mn"});
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        if (BUILD_MODELS.contains(Build.MODEL.toLowerCase(Locale.US)) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L7;
        return true;
    }
}
