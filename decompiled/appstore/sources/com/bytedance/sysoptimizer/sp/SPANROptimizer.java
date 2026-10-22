package com.bytedance.sysoptimizer.sp;

import android.content.Context;
import i6.a;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SPANROptimizer {
    private static boolean hasFixed;

    public SPANROptimizer() {
    }

    public static synchronized void fix(Context r10) {
        monitor-enter(SPANROptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (hasFixed == false) goto L9;
        monitor-exit(SPANROptimizer.class);
        return;
    L9:
        hasFixed = true;     // Catch: Throwable -> L16
        Field r11 = Class.forName("android.app.QueuedWork").getDeclaredField("sFinishers");     // Catch: Throwable -> L12
        r11.setAccessible(true);     // Catch: Throwable -> L12
        r11.set(null, new SPLinkedList());     // Catch: Throwable -> L12
    L14:
        monitor-exit(SPANROptimizer.class);
        return;
    L12:
        th = move-exception;
        a.d(th, "FIX SP ANR FAIL");     // Catch: Throwable -> L16
        goto L14
    }
}
