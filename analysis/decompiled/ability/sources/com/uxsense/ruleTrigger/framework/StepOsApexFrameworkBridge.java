package com.uxsense.ruleTrigger.framework;

import android.content.Intent;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class StepOsApexFrameworkBridge implements IApexFrameworkBridge {
    private static final String TAG = "StepOsApexFrameworkBridge";
    private static Method sSetApexServiceMethod;

    @Override // com.uxsense.ruleTrigger.framework.IApexFrameworkBridge
    public void setApexService(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (sSetApexServiceMethod == null) {
                sSetApexServiceMethod = Class.forName("android.view.StepOSViewContentUtils").getMethod("setApexService", Intent.class);
            }
            sSetApexServiceMethod.invoke(null, intent);
            Log.d(TAG, "setApexService via StepOSViewContentUtils success");
        } catch (Exception e) {
            Log.e(TAG, "setApexService failed", e);
        }
    }
}
