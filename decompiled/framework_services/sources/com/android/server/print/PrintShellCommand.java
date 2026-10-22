package com.android.server.print;

import android.os.RemoteException;
import android.os.ShellCommand;
import android.os.UserHandle;
import android.print.IPrintManager;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
final class PrintShellCommand extends ShellCommand {
    final IPrintManager mService;

    PrintShellCommand(IPrintManager service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -859068373: goto L12;
            case 789489311: goto L9;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        return -1;
    L18:
        return runSetBindInstantServiceAllowed();
    L20:
        return runGetBindInstantServiceAllowed();
    L9:
        if (cmd.equals("set-bind-instant-service-allowed") == false) goto L21;
        r0 = 1;
        goto L15
    L21:
        r0 = -1;
        goto L15
    L12:
        if (cmd.equals("get-bind-instant-service-allowed") == false) goto L22;
        r0 = 0;
        goto L15
    L22:
        r0 = -1;
        goto L15
    }

    private int runGetBindInstantServiceAllowed() {
        Integer userId = parseUserId();
        if (userId != null) goto L12;
        return -1;
    L12:
        getOutPrintWriter().println(Boolean.toString(this.mService.getBindInstantServiceAllowed(userId.intValue())));     // Catch: RemoteException -> L8
        return 0;
    L8:
        e = move-exception;
        e.rethrowFromSystemServer();
        return 0;
    }

    private int runSetBindInstantServiceAllowed() {
        Integer userId = parseUserId();
        if (userId != null) goto L5;
        return -1;
    L5:
        String allowed = getNextArgRequired();
        if (allowed != null) goto L15;
        getErrPrintWriter().println("Error: no true/false specified");
        return -1;
    L15:
        this.mService.setBindInstantServiceAllowed(userId.intValue(), Boolean.parseBoolean(allowed));     // Catch: RemoteException -> L11
        return 0;
    L11:
        e = move-exception;
        e.rethrowFromSystemServer();
        return 0;
    }

    private Integer parseUserId() {
        String option = getNextOption();
        if (option == null) goto L11;
        if (option.equals("--user") == true) goto L7;
        getErrPrintWriter().println("Unknown option: " + option);
        return null;
    L7:
        return Integer.valueOf(UserHandle.parseUserArg(getNextArgRequired()));
    L11:
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Print service commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  set-bind-instant-service-allowed [--user <USER_ID>] true|false ");
        pw.println("    Set whether binding to print services provided by instant apps is allowed.");
        pw.println("  get-bind-instant-service-allowed [--user <USER_ID>]");
        pw.println("    Get whether binding to print services provided by instant apps is allowed.");
    }
}
