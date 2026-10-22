package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import androidx.camera.video.Quality;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ReportedVideoQualityNotSupportedQuirk implements VideoQualityQuirk, SurfaceProcessingQuirk {
    public ReportedVideoQualityNotSupportedQuirk() {
    }

    private static boolean isHuaweiMate20() {
        if ("Huawei".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("HMA-L29".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isHuaweiMate20Pro() {
        if ("Huawei".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("LYA-AL00".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isHuaweiP40Lite() {
        if ("Huawei".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.asList(new String[]{"JNY-L21A", "JNY-L01A", "JNY-L21B", "JNY-L22A", "JNY-L02A", "JNY-L22B", "JNY-LX1"}).contains(Build.MODEL.toUpperCase(Locale.US)) == false) goto L7;
        return true;
    }

    private static boolean isOppoPht110() {
        if ("OPPO".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("PHT110".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isVivoY91i() {
        if ("Vivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("vivo 1820".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isHuaweiMate20() == false) goto L5;
    L14:
        return true;
    L5:
        if (isHuaweiMate20Pro() == true) goto L14;
        if (isVivoY91i() == true) goto L14;
        if (isHuaweiP40Lite() == true) goto L14;
        if (isOppoPht110() == true) goto L14;
        return false;
    }

    @Override // androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk
    public boolean workaroundBySurfaceProcessing() {
        if (isHuaweiMate20() == false) goto L5;
    L12:
        return true;
    L5:
        if (isHuaweiMate20Pro() == true) goto L12;
        if (isHuaweiP40Lite() == true) goto L12;
        if (isOppoPht110() == true) goto L12;
        return false;
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean isProblematicVideoQuality(CameraInfoInternal r100, Quality r101) {
        if (isHuaweiMate20() == true) goto L38;
        if (isHuaweiMate20Pro() == true) goto L38;
        if (isVivoY91i() == false) goto L17;
        if (r101 != Quality.HD) goto L12;
        return true;
    L12:
        if (r101 == Quality.FHD) goto L43;
        return false;
    L43:
        return true;
    L17:
        if (isHuaweiP40Lite() == false) goto L28;
        if (r100.getLensFacing() == 0) goto L21;
    L25:
        return false;
    L21:
        if (r101 != Quality.FHD) goto L23;
        return true;
    L23:
        if (r101 != Quality.HD) goto L25;
        return true;
    L28:
        if (isOppoPht110() == true) goto L30;
        return false;
    L30:
        if (r100.getLensFacing() == 1) goto L32;
    L34:
        return false;
    L32:
        if (r101 != Quality.UHD) goto L34;
        return true;
    L38:
        if (r101 == Quality.UHD) goto L47;
        return false;
    L47:
        return true;
    }
}
