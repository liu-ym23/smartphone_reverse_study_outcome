package com.android.server;

import android.util.Slog;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes.dex */
public class SysOptBridge {
    private static String SYSOPT_COMMON_CLASS_NAME;
    private static String SYSOPT_MULTIPLAT_CLASS_NAME;
    private static String TAG;
    private static IMultiPlatSvsFactory sIMultiPlatSvsFactory;
    private static ISysSvsFactory sISysSvsFactory;

    public SysOptBridge() {
    }

    static {
        TAG = "SysOptBridge";
        SYSOPT_COMMON_CLASS_NAME = "com.android.server.am.SysSvsFactoryImpl";
        SYSOPT_MULTIPLAT_CLASS_NAME = "com.android.server.MultiPlatFactoryImpl";
    }

    public static ISysSvsFactory getFactory() {
        if (sISysSvsFactory != null) goto L19;
        monitor-enter(ISysSvsFactory.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (sISysSvsFactory == null) goto L20;
    L14:
        monitor-exit(ISysSvsFactory.class);     // Catch: Throwable -> L10
        goto L19
    L20:
        BaseDexClassLoader loader = (BaseDexClassLoader) SysOptBridge.class.getClassLoader();     // Catch: Throwable -> L10 Exception -> L12
        sISysSvsFactory = (ISysSvsFactory) loader.loadClass(SYSOPT_COMMON_CLASS_NAME).newInstance();     // Catch: Throwable -> L10 Exception -> L12
        Slog.i(TAG, "SysOptBridge ISysSvsFactory: instance: " + sISysSvsFactory);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        sISysSvsFactory = new AnonymousClass1();     // Catch: Throwable -> L10
        Slog.e(TAG, "SysOptBridge ISysSvsFactory getInstance error: " + e.toString());     // Catch: Throwable -> L10
    L19:
        return sISysSvsFactory;
    }

    public static IMultiPlatSvsFactory getMultiPlatFactory() {
        if (sIMultiPlatSvsFactory != null) goto L19;
        monitor-enter(IMultiPlatSvsFactory.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (sIMultiPlatSvsFactory == null) goto L20;
    L14:
        monitor-exit(IMultiPlatSvsFactory.class);     // Catch: Throwable -> L10
        goto L19
    L20:
        BaseDexClassLoader loader = (BaseDexClassLoader) SysOptBridge.class.getClassLoader();     // Catch: Throwable -> L10 Exception -> L12
        sIMultiPlatSvsFactory = (IMultiPlatSvsFactory) loader.loadClass(SYSOPT_MULTIPLAT_CLASS_NAME).newInstance();     // Catch: Throwable -> L10 Exception -> L12
        Slog.i(TAG, "SysOptBridge IMultiPlatSvsFactory: instance: " + sIMultiPlatSvsFactory);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "SysOptBridge IMultiPlatSvsFactory getInstance error: " + e.toString());     // Catch: Throwable -> L10
    L19:
        return sIMultiPlatSvsFactory;
    }
}
