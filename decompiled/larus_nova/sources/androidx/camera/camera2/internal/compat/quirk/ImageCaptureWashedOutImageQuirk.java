package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureWashedOutImageQuirk implements UseTorchAsFlashQuirk {
    public static final List<String> BUILD_MODELS = null;

    public ImageCaptureWashedOutImageQuirk() {
    }

    static {
        BUILD_MODELS = Arrays.asList(new String[]{"SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P"});
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        if (BUILD_MODELS.contains(Build.MODEL.toUpperCase(Locale.US)) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L7;
        return true;
    }
}
