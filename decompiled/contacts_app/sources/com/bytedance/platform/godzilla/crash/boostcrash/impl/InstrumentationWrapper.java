package com.bytedance.platform.godzilla.crash.boostcrash.impl;

import android.app.Instrumentation;
import android.os.Looper;
import com.bytedance.platform.godzilla.common.ActivityThreadHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InstrumentationWrapper extends Instrumentation {
    private static final String TAG = "InstrumentationWrapper";
    private static List<ExceptionCatcher> sExceptionCatchers;
    private static boolean sIsFixed;

    public InstrumentationWrapper() {
    }

    static {
        sExceptionCatchers = new ArrayList();
    }

    public static void startFix() {
        if (sIsFixed == false) goto L13;
        return;
    L13:
        Object r1 = ActivityThreadHelper.currentActivityThread();     // Catch: Exception -> L10
        Field r2 = r1.getClass().getDeclaredField("mInstrumentation");     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        if ((r2.get(r1) instanceof InstrumentationWrapper) == false) goto L8;
        return;
    L8:
        r2.set(r1, new InstrumentationWrapper());     // Catch: Exception -> L10
        Logger.d(TAG, "Fix success.");     // Catch: Exception -> L10
        sIsFixed = true;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.d(TAG, e.getMessage());
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object r3, Throwable r4) {
        Iterator<ExceptionCatcher> r0 = sExceptionCatchers.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().analysis(r3, r4) == false) goto L4;
        return true;
    L10:
        return super.onException(r3, r4);
    }

    public static void registerExceptionCatcher(ExceptionCatcher r2) {
        if (Logger.debug() == true) goto L5;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.registerCondition() == true) goto L14;
        return;
    L14:
        if (sExceptionCatchers.contains(r2) == true) goto L18;
        sExceptionCatchers.add(r2);
        return;
    L18:
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("register only in UI thread.");
    }

    public static void unRegisterExceptionCatcher(ExceptionCatcher r2) {
        if (Logger.debug() == true) goto L5;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        sExceptionCatchers.remove(r2);
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("unRegister only in UI thread.");
    }
}
