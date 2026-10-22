package com.stepos.alphame.reflect;

import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class PowerManagerStepos {
    private static final String TAG = "PowerManagerStepos";

    @Deprecated
    public static List<?> getWakeLockInfo() {
        Log.w(TAG, "getWakeLockInfo is deprecated; use WakeLockUtils.getWakeLockUidSets via IPC");
        return null;
    }
}
