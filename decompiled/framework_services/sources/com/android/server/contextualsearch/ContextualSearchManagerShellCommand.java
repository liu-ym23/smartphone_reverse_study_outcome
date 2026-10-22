package com.android.server.contextualsearch;

import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ContextualSearchManagerShellCommand extends ShellCommand {
    private final ContextualSearchManagerService mService;

    ContextualSearchManagerShellCommand(ContextualSearchManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        byte r2 = -1;
        switch(cmd.hashCode()) {
            case 113762: goto L9;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L15;
            default: goto L14;
        };
    L15:
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case -787237686: goto L22;
            case 1235500776: goto L19;
            default: goto L25;
        };
    L19:
        if (what.equals("token-duration") == false) goto L25;
        r2 = 1;
        goto L25
    L22:
        if (what.equals("temporary-package") == false) goto L25;
        r2 = 0;
    L25:
        switch(r2) {
            case 0: goto L32;
            case 1: goto L27;
            default: goto L38;
        };
    L27:
        String durationStr = getNextArg();
        if (durationStr != null) goto L31;
        this.mService.resetTokenValidDurationMs();
        pw.println("ContextualSearchManagerService token duration reset.");
        return 0;
    L31:
        int durationMs = Integer.parseInt(durationStr);
        this.mService.setTokenValidDurationMs(durationMs);
        pw.println("ContextualSearchManagerService temporarily set token duration to " + durationMs + "ms");
        goto L38
    L32:
        String packageName = getNextArg();
        if (packageName != null) goto L36;
        this.mService.resetTemporaryPackage();
        pw.println("ContextualSearchManagerService reset.");
        return 0;
    L36:
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryPackage(packageName, duration);
        pw.println("ContextualSearchManagerService temporarily set to " + packageName + " for " + duration + "ms");
    L38:
        return 0;
    L14:
        return handleDefaultCommands(cmd);
    L9:
        if (cmd.equals("set") == false) goto L11;
        r1 = 0;
        goto L12
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("ContextualSearchService commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-package [PACKAGE_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the Contextual Search implementation.");     // Catch: Throwable -> L6
        pw.println("    To reset, call without any arguments.");     // Catch: Throwable -> L6
        pw.println("  set token-duration [DURATION]");     // Catch: Throwable -> L6
        pw.println("    Changes the Contextual Search token duration to DURATION ms.");     // Catch: Throwable -> L6
        pw.println("    To reset, call without any arguments.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.close();
        return;
    L6:
        th = move-exception;
        if (pw != null) goto L13;
    L12:
        throw th;
    L13:
        pw.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }
}
