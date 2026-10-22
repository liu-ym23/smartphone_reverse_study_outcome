package com.android.server.vibrator;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
class VibratorDebugUtils {
    VibratorDebugUtils() {
    }

    public static boolean isDebuggable(String tag) {
        if (Log.isLoggable(tag, 3) == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable("Vibrator_All", 3) == true) goto L8;
        return false;
    }
}
