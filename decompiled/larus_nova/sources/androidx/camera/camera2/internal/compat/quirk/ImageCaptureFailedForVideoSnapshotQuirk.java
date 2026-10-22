package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import com.huawei.hms.android.SystemUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureFailedForVideoSnapshotQuirk implements Quirk {
    private static final Set<String> PROBLEMATIC_UNI_SOC_MODELS = null;

    public ImageCaptureFailedForVideoSnapshotQuirk() {
    }

    static {
        PROBLEMATIC_UNI_SOC_MODELS = new HashSet(Arrays.asList(new String[]{"itel l6006", "itel w6004", "moto g(20)", "moto e13", "moto e20", "rmx3231", "rmx3511", "sm-a032f", "sm-a035m", "tecno mobile bf6"}));
    }

    private static boolean isHuaweiPSmart() {
        if (SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("FIG-LX1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isUniSocChipsetDevice() {
        Set<String> r100 = PROBLEMATIC_UNI_SOC_MODELS;
        String r101 = Build.MODEL;
        Locale r102 = Locale.US;
        if (r100.contains(r101.toLowerCase(r102)) == false) goto L5;
    L16:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L8:
        String r103 = Build.HARDWARE;
        if (r103.toLowerCase(r102).startsWith("ums") == true) goto L16;
        if ("itel".equalsIgnoreCase(Build.BRAND) == true) goto L13;
    L15:
        return false;
    L13:
        if (r103.toLowerCase(r102).startsWith(CloudControlInf.SP) == false) goto L15;
    L7:
        if ("Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER) == true) goto L16;
        goto L8
    }

    public static boolean load() {
        if (isUniSocChipsetDevice() == false) goto L5;
    L8:
        return true;
    L5:
        if (isHuaweiPSmart() == true) goto L8;
        return false;
    }
}
