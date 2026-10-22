package com.uxsense.ruleTrigger.framework;

import android.content.Intent;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class DefaultApexFrameworkBridge implements IApexFrameworkBridge {
    private static final String TAG = "DefaultApexFrameworkBridge";

    @Override // com.uxsense.ruleTrigger.framework.IApexFrameworkBridge
    public void setApexService(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Log.d(TAG, "setApexService via ViewContentUtils");
        FrameworkUtils.setApexService(intent);
    }
}
