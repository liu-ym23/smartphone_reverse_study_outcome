package com.bef.effectsdk;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class EffectApplicationInfo {
    private static Context appContext;

    public EffectApplicationInfo() {
    }

    private static native int nativeSetHomeDir(String r100);

    private static void onSetAppContext() {
        Context r100 = appContext;
        if (r100 == null) goto L6;
        nativeSetHomeDir(r100.getFilesDir().getAbsolutePath());
        return;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static void setAppContext(Context r100) {
        appContext = r100;
        onSetAppContext();
    }
}
