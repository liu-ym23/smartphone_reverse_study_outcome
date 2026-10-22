package androidx.core.app;

import android.app.ActivityManager;

/* loaded from: classes.dex */
public final class b {
    public static boolean a(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
