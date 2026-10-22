package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;
import com.huawei.hms.android.SystemUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageCaptureRotationOptionQuirk implements Quirk {
    public ImageCaptureRotationOptionQuirk() {
    }

    private static boolean isEmulator() {
        String r100 = Build.FINGERPRINT;
        if (r100.startsWith("generic") == false) goto L5;
    L26:
        return true;
    L5:
        if (r100.startsWith("unknown") == true) goto L26;
        String r101 = Build.MODEL;
        if (r101.contains("google_sdk") == true) goto L26;
        if (r101.contains("Emulator") == true) goto L26;
        if (r101.contains("Cuttlefish") == true) goto L26;
        if (r101.contains("Android SDK built for x86") == true) goto L26;
        if (Build.MANUFACTURER.contains("Genymotion") == true) goto L26;
        if (Build.BRAND.startsWith("generic") == false) goto L21;
        if (Build.DEVICE.startsWith("generic") == true) goto L26;
    L21:
        if (Build.PRODUCT.equals("google_sdk") == true) goto L26;
        if (Build.HARDWARE.contains("ranchu") == true) goto L26;
        return false;
    }

    private static boolean isHonor9X() {
        if (SystemUtils.PRODUCT_HONOR.equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("STK-LX1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isHuaweiMate20Lite() {
        if (SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SNE-LX1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isEmulatorAndApi21() {
        if (isEmulator() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT != 21) goto L7;
        return true;
    }

    public static boolean load() {
        if (isHuaweiMate20Lite() == false) goto L5;
    L10:
        return true;
    L5:
        if (isHonor9X() == true) goto L10;
        if (isEmulatorAndApi21() == true) goto L10;
        return false;
    }

    public boolean isSupported(Config.Option<?> r100) {
        if (r100 == CaptureConfig.OPTION_ROTATION) goto L5;
        return true;
    L5:
        return false;
    }
}
