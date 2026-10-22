package com.android.server.utils;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public interface Watchable {
    void dispatchChange(Watchable r1);

    boolean isRegisteredObserver(Watcher r1);

    void registerObserver(Watcher r1);

    void unregisterObserver(Watcher r1);

    static void verifyWatchedAttributes(Object base, Watcher observer, boolean logOnly) {
        if (Build.IS_ENG == false) goto L5;
    L7:
        Field[] r1 = base.getClass().getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L28;
        Field f = r1[r3];
        Watched annotation = (Watched) f.getAnnotation(Watched.class);
        if (annotation == null) goto L27;
        String fn = base.getClass().getName() + "." + f.getName();
        f.setAccessible(true);     // Catch: IllegalAccessException -> L19
        Object o = f.get(base);     // Catch: IllegalAccessException -> L19
        if ((o instanceof Watchable) == false) goto L23;
        Watchable attr = (Watchable) o;     // Catch: IllegalAccessException -> L19
        if (attr == null) goto L27;
        if (attr.isRegisteredObserver(observer) == true) goto L27;
        handleVerifyError("Watchable " + fn + " missing an observer", logOnly);     // Catch: IllegalAccessException -> L19
        goto L27
    L23:
        if (annotation.manual() == true) goto L27;
        handleVerifyError("@Watched annotated field " + fn + " is not a watchable type and is not flagged for manual watching.", logOnly);     // Catch: IllegalAccessException -> L19
    L26:
        handleVerifyError("Watchable " + fn + " not visible", logOnly);
    L27:
        r3 = r3 + 1;
        goto L8
    L28:
        return;
    L5:
        if (Build.IS_USERDEBUG == true) goto L7;
    }

    static void handleVerifyError(String errorMessage, boolean logOnly) {
        if (logOnly == false) goto L6;
        Log.e("Watchable", errorMessage);
        return;
    L6:
        throw new RuntimeException(errorMessage);
    }

    static void verifyWatchedAttributes(Object base, Watcher observer) {
        verifyWatchedAttributes(base, observer, false);
    }
}
