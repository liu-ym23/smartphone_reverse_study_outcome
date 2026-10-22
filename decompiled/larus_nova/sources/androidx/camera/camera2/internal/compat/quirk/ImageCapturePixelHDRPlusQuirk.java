package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCapturePixelHDRPlusQuirk implements Quirk {
    public static final List<String> BUILD_MODELS = null;

    public ImageCapturePixelHDRPlusQuirk() {
    }

    static {
        BUILD_MODELS = Arrays.asList(new String[]{"Pixel 2", "Pixel 2 XL", "Pixel 3", "Pixel 3 XL"});
    }

    public static boolean load() {
        if (BUILD_MODELS.contains(Build.MODEL) == true) goto L5;
    L9:
        return false;
    L5:
        if (LocationInfoConst.GOOGLE.equals(Build.MANUFACTURER) == false) goto L9;
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return true;
    }
}
