package com.android.server;

import android.util.LogWriter;
import android.util.Slog;
import dalvik.system.AnnotatedStackTraceElement;
import dalvik.system.VMStack;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class WatchdogDiagnostics {
    WatchdogDiagnostics() {
    }

    private static String getBlockedOnString(Object blockedOn) {
        return String.format("- waiting to lock <0x%08x> (a %s)", new Object[]{Integer.valueOf(System.identityHashCode(blockedOn)), blockedOn.getClass().getName()});
    }

    private static String getLockedString(Object heldLock) {
        return String.format("- locked <0x%08x> (a %s)", new Object[]{Integer.valueOf(System.identityHashCode(heldLock)), heldLock.getClass().getName()});
    }

    public static boolean printAnnotatedStack(Thread thread, PrintWriter out) {
        AnnotatedStackTraceElement[] stack = VMStack.getAnnotatedThreadStackTrace(thread);
        if (stack != null) goto L5;
        return false;
    L5:
        out.println(thread.getName() + " annotated stack trace:");
        int r2 = stack.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L17;
        AnnotatedStackTraceElement element = stack[r3];
        out.println("    at " + element.getStackTraceElement());
        if (element.getBlockedOn() == null) goto L11;
        out.println("    " + getBlockedOnString(element.getBlockedOn()));
    L11:
        if (element.getHeldLocks() == null) goto L16;
        Object[] r5 = element.getHeldLocks();
        int r7 = r5.length;
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L16;
        Object held = r5[r8];
        out.println("    " + getLockedString(held));
        r8 = r8 + 1;
    L16:
        r3 = r3 + 1;
        goto L6
    L17:
        return true;
    }

    public static void diagnoseCheckers(List<Watchdog.HandlerChecker> blockedCheckers) {
        PrintWriter out = new PrintWriter(new LogWriter(5, "Watchdog", 3), true);
        int i = 0;
    L4:
        if (i >= blockedCheckers.size()) goto L14;
        Thread blockedThread = blockedCheckers.get(i).getThread();
        if (printAnnotatedStack(blockedThread, out) == true) goto L12;
        Slog.w("Watchdog", blockedThread.getName() + " stack trace:");
        StackTraceElement[] stackTrace = blockedThread.getStackTrace();
        int r5 = stackTrace.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L12;
        StackTraceElement element = stackTrace[r6];
        Slog.w("Watchdog", "    at " + element);
        r6 = r6 + 1;
    L12:
        i = i + 1;
        goto L4
    }
}
