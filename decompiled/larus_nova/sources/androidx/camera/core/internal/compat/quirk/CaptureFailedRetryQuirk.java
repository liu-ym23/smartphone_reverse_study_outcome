package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.Quirk;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureFailedRetryQuirk implements Quirk {
    private static final Set<Pair<String, String>> FAILED_RETRY_ALLOW_LIST = null;

    public CaptureFailedRetryQuirk() {
    }

    public int getRetryCount() {
        return 1;
    }

    static {
        FAILED_RETRY_ALLOW_LIST = new HashSet(Collections.singletonList(Pair.create("SAMSUNG", "SM-G981U1")));
    }

    public static boolean load() {
        String r100 = Build.BRAND;
        Locale r101 = Locale.US;
        String r102 = r100.toUpperCase(r101);
        String r103 = Build.MODEL.toUpperCase(r101);
        return FAILED_RETRY_ALLOW_LIST.contains(Pair.create(r102, r103));
    }
}
