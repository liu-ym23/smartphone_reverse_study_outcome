package com.android.server.accounts;

import android.app.ActivityManager;
import android.os.ShellCommand;
import android.os.UserHandle;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class AccountManagerServiceShellCommand extends ShellCommand {
    final AccountManagerService mService;

    AccountManagerServiceShellCommand(AccountManagerService service) {
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
        if (userId != null) goto L6;
        return -1;
    L6:
        getOutPrintWriter().println(Boolean.toString(this.mService.getBindInstantServiceAllowed(userId.intValue())));
        return 0;
    }

    private int runSetBindInstantServiceAllowed() {
        Integer userId = parseUserId();
        if (userId != null) goto L5;
        return -1;
    L5:
        String allowed = getNextArgRequired();
        if (allowed != null) goto L9;
        getErrPrintWriter().println("Error: no true/false specified");
        return -1;
    L9:
        this.mService.setBindInstantServiceAllowed(userId.intValue(), Boolean.parseBoolean(allowed));
        return 0;
    }

    private Integer parseUserId() {
        String option = getNextOption();
        if (option == null) goto L22;
        if (option.equals("--user") == false) goto L19;
        int userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId != (-2)) goto L11;
        return Integer.valueOf(ActivityManager.getCurrentUser());
    L11:
        if (userId != (-1)) goto L14;
        getErrPrintWriter().println("USER_ALL not supported. Specify a user.");
        return null;
    L14:
        if (userId >= 0) goto L18;
        getErrPrintWriter().println("Invalid user: " + userId);
        return null;
    L18:
        return Integer.valueOf(userId);
    L19:
        getErrPrintWriter().println("Unknown option: " + option);
        return null;
    L22:
        return Integer.valueOf(ActivityManager.getCurrentUser());
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Account manager service commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  set-bind-instant-service-allowed [--user <USER_ID> (current user if not specified)] true|false ");
        pw.println("    Set whether binding to services provided by instant apps is allowed.");
        pw.println("  get-bind-instant-service-allowed [--user <USER_ID> (current user if not specified)]");
        pw.println("    Get whether binding to services provided by instant apps is allowed.");
    }
}
