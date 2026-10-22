package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class FlashTooSlowQuirk implements UseTorchAsFlashQuirk {
    private static final List<String> AFFECTED_MODEL_PREFIXES = null;

    public FlashTooSlowQuirk() {
    }

    static {
        AFFECTED_MODEL_PREFIXES = Arrays.asList(new String[]{"PIXEL 3A", "PIXEL 3A XL", "PIXEL 4", "PIXEL 5", "SM-A320", "MOTO G(20)", "ITEL L6006", "RMX3231"});
    }

    private static boolean isAffectedModel() {
        Iterator<String> r100 = AFFECTED_MODEL_PREFIXES.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        String r101 = r100.next();
        if (Build.MODEL.toUpperCase(Locale.US).startsWith(r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean load(CameraCharacteristicsCompat r100) {
        if (isAffectedModel() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r100.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L7;
        return true;
    }
}
