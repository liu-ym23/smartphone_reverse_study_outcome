package com.byted.cast.common;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class AppLogWrapper {
    private static final String TAG = "AppLogWrapper";
    private static volatile AppLogWrapper sInstance;

    public static boolean hasAppLog() {
        return false;
    }

    public String getDid() {
        return "";
    }

    public void onEventV3(String r100, JSONObject r101) {
    }

    public static AppLogWrapper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(AppLogWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppLogWrapper(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppLogWrapper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public AppLogWrapper(ContextManager.CastContext r100) {
    }

    public static AppLogWrapper createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new AppLogWrapper(r100);
    }
}
