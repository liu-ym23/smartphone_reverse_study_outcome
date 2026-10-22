package com.stepos.alphame.reflect;

import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class WindowManagerStepos {
    private static final String TAG = "WindowManagerStepos";

    public static Object getIWindowManager() {
        Log.w(TAG, "getIWindowManager deprecated");
        return null;
    }

    public static IBinder getWindowService() {
        Log.w(TAG, "getWindowService deprecated");
        return null;
    }
}
