package com.android.server.dreams;

import android.os.Binder;
import android.os.ShellCommand;
import android.util.Slog;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DreamShellCommand extends ShellCommand {
    private static final boolean DEBUG = true;
    private static final String TAG = "DreamShellCommand";
    private final DreamManagerService mService;

    DreamShellCommand(DreamManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        Slog.d(TAG, "onCommand:" + cmd);
    L9:
        e = move-exception;
        getOutPrintWriter().println(e);
        return -1;
    L4:
        switch(cmd.hashCode()) {
            case -183711126: goto L12;
            case 1473640970: goto L7;
            default: goto L14;
        };     // Catch: SecurityException -> L9
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L20;
            case 1: goto L18;
            default: goto L17;
        };     // Catch: SecurityException -> L9
    L18:
        enforceCallerIsRoot();     // Catch: SecurityException -> L9
        return stopDreaming();
    L20:
        enforceCallerIsRoot();     // Catch: SecurityException -> L9
        return startDreaming();
    L17:
        return super.handleDefaultCommands(cmd);
    L7:
        if (cmd.equals("start-dreaming") == false) goto L14;
        r1 = 0;
        goto L15
    L12:
        if (cmd.equals("stop-dreaming") == false) goto L14;
        r1 = 1;
        goto L15
    }

    private int startDreaming() {
        this.mService.requestStartDreamFromShell();
        return 0;
    }

    private int stopDreaming() {
        this.mService.requestStopDreamFromShell();
        return 0;
    }

    private void enforceCallerIsRoot() {
        if (Binder.getCallingUid() != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Must be root to call Dream shell commands");
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Dream manager (dreams) commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  start-dreaming");
        pw.println("      Start the currently configured dream.");
        pw.println("  stop-dreaming");
        pw.println("      Stops any active dream");
    }
}
