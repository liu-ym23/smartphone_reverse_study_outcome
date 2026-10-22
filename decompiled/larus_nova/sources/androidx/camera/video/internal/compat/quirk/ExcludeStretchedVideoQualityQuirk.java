package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;

/* JADX INFO: loaded from: classes2.dex */
public class ExcludeStretchedVideoQualityQuirk implements VideoQualityQuirk {
    public ExcludeStretchedVideoQualityQuirk() {
    }

    private static boolean isSamsungJ2() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-J260F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ4() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-J400G".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ5() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-J530F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ6() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("sm-j600g".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ7Api27Above() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if ("SM-J710MN".equalsIgnoreCase(Build.MODEL) == false) goto L9;
        if (Build.VERSION.SDK_INT < 27) goto L9;
        return true;
    }

    private static boolean isSamsungJ7Nxt() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-J701F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if ("SM-G610M".equalsIgnoreCase(Build.MODEL) == false) goto L9;
        if (Build.VERSION.SDK_INT < 27) goto L9;
        return true;
    }

    public static boolean load() {
        if (isSamsungJ2() == false) goto L5;
    L18:
        return true;
    L5:
        if (isSamsungJ4() == true) goto L18;
        if (isSamsungJ5() == true) goto L18;
        if (isSamsungJ6() == true) goto L18;
        if (isSamsungJ7Nxt() == true) goto L18;
        if (isSamsungJ7PrimeApi27Above() == true) goto L18;
        if (isSamsungJ7Api27Above() == true) goto L18;
        return false;
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean isProblematicVideoQuality(CameraInfoInternal r100, Quality r101) {
        if (isSamsungJ4() == false) goto L12;
        if (r101 != Quality.FHD) goto L7;
        return true;
    L7:
        if (r101 == Quality.UHD) goto L31;
        return false;
    L31:
        return true;
    L12:
        if (isSamsungJ2() == true) goto L26;
        if (isSamsungJ5() == true) goto L26;
        if (isSamsungJ6() == true) goto L26;
        if (isSamsungJ7Nxt() == true) goto L26;
        if (isSamsungJ7PrimeApi27Above() == true) goto L26;
        if (isSamsungJ7Api27Above() == true) goto L26;
        return false;
    L26:
        if (r101 == Quality.FHD) goto L32;
        return false;
    L32:
        return true;
    }
}
