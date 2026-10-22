package androidx.core.app;

import android.app.ActivityManager;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    @ReplaceWith(expression = "activityManager.isLowRamDevice()")
    public static boolean isLowRamDevice(ActivityManager r100) {
        return r100.isLowRamDevice();
    }
}
