package com.uxsense.ruleTrigger.framework;

import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public class ApexFrameworkBridgeFactory {
    private static final String BRAND_STEPOS = "StepX";
    private static final String TAG = "ApexFrameworkBridgeFactory";
    private static volatile IApexFrameworkBridge instance;

    private static IApexFrameworkBridge create() {
        String str = Build.BRAND;
        Log.d(TAG, "Build.BRAND=" + str);
        return BRAND_STEPOS.equalsIgnoreCase(str) ? new StepOsApexFrameworkBridge() : new DefaultApexFrameworkBridge();
    }

    public static IApexFrameworkBridge get() {
        if (instance == null) {
            synchronized (ApexFrameworkBridgeFactory.class) {
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
