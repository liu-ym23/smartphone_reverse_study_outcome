package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {
    private static final List<String> BUILD_MODELS = null;
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = null;

    public ImageCaptureFlashNotFireQuirk() {
    }

    static {
        BUILD_MODELS = Arrays.asList(new String[]{"itel w6004"});
        BUILD_MODELS_FRONT_CAMERA = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        List<String> r101 = BUILD_MODELS_FRONT_CAMERA;
        String r102 = Build.MODEL;
        Locale r103 = Locale.US;
        if (r101.contains(r102.toLowerCase(r103)) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        boolean r105 = BUILD_MODELS.contains(r102.toLowerCase(r103));
        if (r104 == true) goto L14;
        if (r105 == true) goto L15;
        return false;
    L15:
        return true;
    L14:
        return true;
    L5:
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L7;
        r104 = true;
        goto L8
    }
}
