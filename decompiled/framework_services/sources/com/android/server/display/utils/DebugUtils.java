package com.android.server.display.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class DebugUtils {
    public static final boolean DEBUG_ALL = false;

    public DebugUtils() {
    }

    static {
        DEBUG_ALL = Log.isLoggable("DisplayManager_All", 3);
    }

    public static boolean isDebuggable(String tag) {
        if (Log.isLoggable(tag, 3) == false) goto L5;
    L8:
        return true;
    L5:
        if (DEBUG_ALL == true) goto L8;
        return false;
    }
}
