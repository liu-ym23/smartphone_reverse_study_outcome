package com.android.server.display;

import android.content.Context;
import android.media.RemoteDisplay;
import android.os.Handler;
import android.util.Slog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class ExtendedRemoteDisplayHelper {
    private static final String TAG = "ExtendedRemoteDisplayHelper";
    private static Class sExtRemoteDisplayClass;
    private static Method sExtRemoteDisplayDispose;
    private static Method sExtRemoteDisplayListen;

    ExtendedRemoteDisplayHelper() {
    }

    static {
        sExtRemoteDisplayClass = Class.forName("com.qualcomm.wfd.ExtendedRemoteDisplay");     // Catch: Throwable -> L5
    L8:
        if (sExtRemoteDisplayClass == null) goto L25;
        Slog.i(TAG, "ExtendedRemoteDisplay Is available. Find Methods");
        sExtRemoteDisplayListen = sExtRemoteDisplayClass.getDeclaredMethod("listen", new Class[]{String.class, RemoteDisplay.Listener.class, Handler.class, Context.class});     // Catch: Throwable -> L12
    L19:
        sExtRemoteDisplayDispose = sExtRemoteDisplayClass.getDeclaredMethod("dispose", new Class[0]);     // Catch: Throwable -> L16
        return;
    L17:
        Slog.i(TAG, "ExtendedRemoteDisplay.dispose Not available.");
        return;
    L13:
        Slog.i(TAG, "ExtendedRemoteDisplay.listen Not available.");
        goto L19
    L25:
        return;
    L6:
        Slog.i(TAG, "ExtendedRemoteDisplay Not available.");
        goto L8
    }

    public static Object listen(String iface, RemoteDisplay.Listener listener, Handler handler, Context context) {
        Slog.i(TAG, "ExtendedRemoteDisplay.listen");
        if (sExtRemoteDisplayListen != null) goto L5;
        return null;
    L5:
        if (sExtRemoteDisplayDispose == null) goto L26;
        Object extRemoteDisplay = sExtRemoteDisplayListen.invoke(null, new Object[]{iface, listener, handler, context});     // Catch: IllegalAccessException -> L8 InvocationTargetException -> L10
    L27:
        return extRemoteDisplay;
    L8:
        e = move-exception;
        Slog.i(TAG, "ExtendedRemoteDisplay.listen -IllegalAccessException");
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        Slog.i(TAG, "ExtendedRemoteDisplay.listen - InvocationTargetException");
        Throwable cause = e.getCause();
        if ((cause instanceof RuntimeException) == true) goto L22;
        if ((cause instanceof Error) == false) goto L20;
        throw ((Error) cause);
    L20:
        throw new RuntimeException(e);
    L22:
        throw ((RuntimeException) cause);
    L26:
        return null;
    }

    public static void dispose(Object extRemoteDisplay) {
        Slog.i(TAG, "ExtendedRemoteDisplay.dispose");
        sExtRemoteDisplayDispose.invoke(extRemoteDisplay, new Object[0]);     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7
    L23:
        return;
    L5:
        e = move-exception;
        Slog.i(TAG, "ExtendedRemoteDisplay.dispose-IllegalAccessException");
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        Slog.i(TAG, "ExtendedRemoteDisplay.dispose - InvocationTargetException");
        Throwable cause = e.getCause();
        if ((cause instanceof RuntimeException) == true) goto L20;
        if ((cause instanceof Error) == false) goto L18;
        throw ((Error) cause);
    L18:
        throw new RuntimeException(e);
    L20:
        throw ((RuntimeException) cause);
    }

    public static boolean isAvailable() {
        if (sExtRemoteDisplayClass != null) goto L5;
    L10:
        Slog.i(TAG, "ExtendedRemoteDisplay isAvailable() : Not Available.");
        return false;
    L5:
        if (sExtRemoteDisplayDispose == null) goto L10;
        if (sExtRemoteDisplayListen == null) goto L10;
        Slog.i(TAG, "ExtendedRemoteDisplay isAvailable() : Available.");
        return true;
    }
}
