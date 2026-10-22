package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.Quirk;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class FlashAvailabilityBufferUnderflowQuirk implements Quirk {
    private static final Set<Pair<String, String>> KNOWN_AFFECTED_MODELS = null;

    public FlashAvailabilityBufferUnderflowQuirk() {
    }

    static {
        KNOWN_AFFECTED_MODELS = new HashSet();
        addAffectedDevice("sprd", "lemp");
        addAffectedDevice("sprd", "DM20C");
    }

    public static boolean load() {
        Set<Pair<String, String>> r100 = KNOWN_AFFECTED_MODELS;
        String r101 = Build.MANUFACTURER;
        Locale r102 = Locale.US;
        return r100.contains(new Pair(r101.toLowerCase(r102), Build.MODEL.toLowerCase(r102)));
    }

    private static void addAffectedDevice(String r100, String r101) {
        Set<Pair<String, String>> r102 = KNOWN_AFFECTED_MODELS;
        Locale r103 = Locale.US;
        r102.add(new Pair(r100.toLowerCase(r103), r101.toLowerCase(r103)));
    }
}
