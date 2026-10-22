package com.android.server.accessibility;

import android.accessibilityservice.AccessibilityTrace;
import android.os.Binder;
import android.os.ShellCommand;
import com.android.server.wm.WindowManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityTraceManager implements AccessibilityTrace {
    private static AccessibilityTraceManager sInstance;
    private final WindowManagerInternal.AccessibilityControllerInternal mA11yController;
    private final Object mA11yMSLock;
    private volatile long mEnabledLoggingFlags;
    private final AccessibilityManagerService mService;

    static {
        sInstance = null;
    }

    static AccessibilityTraceManager getInstance(WindowManagerInternal.AccessibilityControllerInternal a11yController, AccessibilityManagerService service, Object lock) {
        if (sInstance != null) goto L6;
        sInstance = new AccessibilityTraceManager(a11yController, service, lock);
    L6:
        return sInstance;
    }

    private AccessibilityTraceManager(WindowManagerInternal.AccessibilityControllerInternal a11yController, AccessibilityManagerService service, Object lock) {
        this.mA11yController = a11yController;
        this.mService = service;
        this.mA11yMSLock = lock;
        this.mEnabledLoggingFlags = 0;
    }

    public boolean isA11yTracingEnabled() {
        if (this.mEnabledLoggingFlags == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isA11yTracingEnabledForTypes(long typeIdFlags) {
        if ((this.mEnabledLoggingFlags & typeIdFlags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getTraceStateForAccessibilityManagerClientState() {
        int state = 0;
        if (isA11yTracingEnabledForTypes(16) == false) goto L6;
        state = 0 | 256;
    L6:
        if (isA11yTracingEnabledForTypes(32) == false) goto L9;
        state = state | 512;
    L9:
        if (isA11yTracingEnabledForTypes(262144) == false) goto L12;
        state = state | 1024;
    L12:
        if (isA11yTracingEnabledForTypes(16384) == true) goto L14;
        return state;
    L14:
        return state | 2048;
    }

    public void startTrace(long loggingTypes) {
        if (loggingTypes != 0) goto L5;
        return;
    L5:
        long oldEnabled = this.mEnabledLoggingFlags;
        this.mEnabledLoggingFlags = loggingTypes;
        if (needToNotifyClients(oldEnabled) == false) goto L15;
        Object r2 = this.mA11yMSLock;
        monitor-enter(r2);
        this.mService.scheduleUpdateClientsIfNeededLocked(this.mService.getCurrentUserState());     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        this.mA11yController.startTrace(loggingTypes);
    }

    public void stopTrace() {
        boolean stop = isA11yTracingEnabled();
        long oldEnabled = this.mEnabledLoggingFlags;
        this.mEnabledLoggingFlags = 0;
        if (needToNotifyClients(oldEnabled) == false) goto L12;
        Object r3 = this.mA11yMSLock;
        monitor-enter(r3);
        this.mService.scheduleUpdateClientsIfNeededLocked(this.mService.getCurrentUserState());     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        if (stop == false) goto L17;
        this.mA11yController.stopTrace();
        return;
    }

    public void logTrace(String where, long loggingTypes) {
        logTrace(where, loggingTypes, "");
    }

    public void logTrace(String where, long loggingTypes, String callingParams) {
        if (isA11yTracingEnabledForTypes(loggingTypes) == false) goto L6;
        this.mA11yController.logTrace(where, loggingTypes, callingParams, "".getBytes(), Binder.getCallingUid(), Thread.currentThread().getStackTrace(), new HashSet(Arrays.asList(new String[]{"logTrace"})));
        return;
    }

    public void logTrace(long timestamp, String where, long loggingTypes, String callingParams, int processId, long threadId, int callingUid, StackTraceElement[] callStack, Set<String> ignoreElementList) {
        if (isA11yTracingEnabledForTypes(loggingTypes) == false) goto L10;
        WindowManagerInternal.AccessibilityControllerInternal r0 = this.mA11yController;
        byte[] r5 = "".getBytes();
        if (ignoreElementList != null) goto L7;
        Set<String> r13 = new HashSet();
    L8:
        r0.logTrace(where, loggingTypes, callingParams, r5, callingUid, callStack, timestamp, processId, threadId, r13);
        return;
    L7:
        r13 = ignoreElementList;
        goto L8
    }

    private boolean needToNotifyClients(long otherTypesEnabled) {
        if ((this.mEnabledLoggingFlags & 278576) == (278576 & otherTypesEnabled)) goto L5;
        return true;
    L5:
        return false;
    }

    int onShellCommand(String cmd, ShellCommand shell) {
        switch(cmd.hashCode()) {
            case 1340897306: goto L9;
            case 1857979322: goto L6;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L12:
        switch(r0) {
            case 0: goto L16;
            case 1: goto L14;
            default: goto L13;
        };
    L13:
        return -1;
    L14:
        stopTrace();
        return 0;
    L16:
        String opt = shell.getNextOption();
        if (opt != null) goto L20;
        startTrace(-1);
        return 0;
    L20:
        List<String> types = new ArrayList();
    L21:
        if (opt == null) goto L36;
        switch(opt.hashCode()) {
            case 1511: goto L26;
            default: goto L28;
        };
    L28:
        byte r4 = -1;
    L29:
        switch(r4) {
            case 0: goto L32;
            default: goto L30;
        };
    L32:
        String type = shell.getNextArg();
    L33:
        if (type == null) goto L35;
        types.add(type);
        type = shell.getNextArg();
        goto L33
    L35:
        opt = shell.getNextOption();
        goto L21
    L30:
        shell.getErrPrintWriter().println("Error: option not recognized " + opt);
        stopTrace();
        return -1;
    L26:
        if (opt.equals("-t") == false) goto L28;
        r4 = 0;
        goto L29
    L36:
        long enabledTypes = AccessibilityTrace.getLoggingFlagsFromNames(types);
        startTrace(enabledTypes);
        return 0;
    L6:
        if (cmd.equals("stop-trace") == false) goto L41;
        r0 = 1;
        goto L12
    L41:
        r0 = -1;
        goto L12
    L9:
        if (cmd.equals("start-trace") == false) goto L42;
        r0 = 0;
        goto L12
    L42:
        r0 = -1;
        goto L12
    }

    void onHelp(PrintWriter pw) {
        pw.println("  start-trace [-t LOGGING_TYPE [LOGGING_TYPE...]]");
        pw.println("    Start the debug tracing. If no option is present, full trace will be");
        pw.println("    generated. Options are:");
        pw.println("      -t: Only generate tracing for the logging type(s) specified here.");
        pw.println("          LOGGING_TYPE can be any one of below:");
        pw.println("            IAccessibilityServiceConnection");
        pw.println("            IAccessibilityServiceClient");
        pw.println("            IAccessibilityManager");
        pw.println("            IAccessibilityManagerClient");
        pw.println("            IAccessibilityInteractionConnection");
        pw.println("            IAccessibilityInteractionConnectionCallback");
        pw.println("            IRemoteMagnificationAnimationCallback");
        pw.println("            IMagnificationConnection");
        pw.println("            IMagnificationConnectionCallback");
        pw.println("            WindowManagerInternal");
        pw.println("            WindowsForAccessibilityCallback");
        pw.println("            MagnificationCallbacks");
        pw.println("            InputFilter");
        pw.println("            Gesture");
        pw.println("            AccessibilityService");
        pw.println("            PMBroadcastReceiver");
        pw.println("            UserBroadcastReceiver");
        pw.println("            FingerprintGesture");
        pw.println("  stop-trace");
        pw.println("    Stop the debug tracing.");
    }
}
