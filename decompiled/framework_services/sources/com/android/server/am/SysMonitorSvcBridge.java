package com.android.server.am;

import android.util.Slog;
import com.android.server.ISysMonitorSvcFactory;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes.dex */
public class SysMonitorSvcBridge {
    private static String SYSOPT_COMMON_CLASS_NAME;
    private static String TAG;
    private static volatile ISysMonitorSvcFactory sISysMonitorSvcFactory;

    public SysMonitorSvcBridge() {
    }

    static {
        TAG = "SysMonitorSvcBridge";
        SYSOPT_COMMON_CLASS_NAME = "com.android.server.am.SysMonitorSvcFactoryImpl";
    }

    public static ISysMonitorSvcFactory getFactory() {
        if (sISysMonitorSvcFactory != null) goto L19;
        monitor-enter(ISysMonitorSvcFactory.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (sISysMonitorSvcFactory == null) goto L20;
    L14:
        monitor-exit(ISysMonitorSvcFactory.class);     // Catch: Throwable -> L10
        goto L19
    L20:
        BaseDexClassLoader loader = (BaseDexClassLoader) SysMonitorSvcBridge.class.getClassLoader();     // Catch: Throwable -> L10 Exception -> L12
        sISysMonitorSvcFactory = (ISysMonitorSvcFactory) loader.loadClass(SYSOPT_COMMON_CLASS_NAME).newInstance();     // Catch: Throwable -> L10 Exception -> L12
        Slog.i(TAG, "SysMonitorSvcBridge ISysMonitorSvcFactory: instance: " + sISysMonitorSvcFactory);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        sISysMonitorSvcFactory = new AnonymousClass1();     // Catch: Throwable -> L10
        Slog.e(TAG, "SysMonitorSvcBridge ISysMonitorSvcFactory getInstance error: " + e.toString());     // Catch: Throwable -> L10
    L19:
        return sISysMonitorSvcFactory;
    }
}
