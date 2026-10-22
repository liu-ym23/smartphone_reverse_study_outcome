package com.mdisdk.capability.framework;

import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public class FrameworkBridgeFactory {
    private static final String BRAND_STEPOS = "StepX";
    private static final String TAG = "FrameworkBridgeFactory";
    private static volatile IFrameworkBridge instance;

    private static IFrameworkBridge create() {
        String str = Build.BRAND;
        Log.d(TAG, "Build.BRAND=" + str);
        return BRAND_STEPOS.equalsIgnoreCase(str) ? new StepOsFrameworkBridge() : new DefaultFrameworkBridge();
    }

    public static IFrameworkBridge get() {
        if (instance == null) {
            synchronized (FrameworkBridgeFactory.class) {
                try {
                    if (instance == null) {
                        instance = create();
                    }
                } finally {
                }
            }
        }
        return instance;
    }
}
