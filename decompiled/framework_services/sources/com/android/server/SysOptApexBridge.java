package com.android.server;

import android.util.Slog;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes.dex */
public class SysOptApexBridge {
    private static final String SYS_APEX_CLASS_NAME = "com.android.server.SysApexFactoryImpl";
    private static final String TAG = "SysOptApexBridge";
    private static volatile ISysApexFactory sISysApexFactory;

    public SysOptApexBridge() {
    }

    public static ISysApexFactory getFactory() {
        if (sISysApexFactory != null) goto L19;
        monitor-enter(ISysApexFactory.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (sISysApexFactory == null) goto L20;
    L14:
        monitor-exit(ISysApexFactory.class);     // Catch: Throwable -> L10
        goto L19
    L20:
        BaseDexClassLoader loader = (BaseDexClassLoader) SysOptApexBridge.class.getClassLoader();     // Catch: Throwable -> L10 Exception -> L12
        sISysApexFactory = (ISysApexFactory) loader.loadClass(SYS_APEX_CLASS_NAME).newInstance();     // Catch: Throwable -> L10 Exception -> L12
        Slog.i(TAG, "SysOptApexBridge ISysApexFactory: instance: " + sISysApexFactory);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        sISysApexFactory = new AnonymousClass1();     // Catch: Throwable -> L10
        Slog.e(TAG, "SysOptApexBridge ISysApexFactory getInstance error: " + e.toString());     // Catch: Throwable -> L10
    L19:
        return sISysApexFactory;
    }
}
