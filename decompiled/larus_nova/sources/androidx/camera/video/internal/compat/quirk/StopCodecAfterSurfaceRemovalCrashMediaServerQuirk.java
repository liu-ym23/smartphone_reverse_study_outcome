package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes2.dex */
public class StopCodecAfterSurfaceRemovalCrashMediaServerQuirk implements Quirk {
    public StopCodecAfterSurfaceRemovalCrashMediaServerQuirk() {
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isMotoC();
    }
}
