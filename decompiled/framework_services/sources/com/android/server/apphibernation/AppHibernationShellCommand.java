package com.android.server.apphibernation;

import android.os.ShellCommand;
import android.os.UserHandle;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class AppHibernationShellCommand extends ShellCommand {
    private static final int ERROR = -1;
    private static final String GLOBAL_OPT = "--global";
    private static final int SUCCESS = 0;
    private static final String USER_OPT = "--user";
    private final AppHibernationService mService;

    AppHibernationShellCommand(AppHibernationService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -499367066: goto L12;
            case -284749990: goto L9;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L21;
            case 1: goto L19;
            default: goto L17;
        };
    L17:
        return handleDefaultCommands(cmd);
    L19:
        return runGetState();
    L21:
        return runSetState();
    L9:
        if (cmd.equals("get-state") == false) goto L14;
        r0 = 1;
        goto L15
    L12:
        if (cmd.equals("set-state") == false) goto L14;
        r0 = 0;
        goto L15
    }

    private int runSetState() {
        boolean setsGlobal = false;
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L20;
        switch(opt.hashCode()) {
            case 1156993347: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L18;
            case 1: goto L17;
            default: goto L16;
        };
    L17:
        setsGlobal = true;
        goto L3
    L18:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L16:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        goto L3
    L9:
        if (opt.equals(USER_OPT) == true) goto L15;
        r4 = -1;
        goto L15
    L12:
        if (opt.equals(GLOBAL_OPT) == false) goto L42;
        r4 = 1;
        goto L15
    L42:
        r4 = -1;
        goto L15
    L20:
        String pkg = getNextArgRequired();
        if (pkg != null) goto L24;
        getErrPrintWriter().println("Error: no package specified");
        return -1;
    L24:
        String newStateRaw = getNextArgRequired();
        if (newStateRaw != null) goto L28;
        getErrPrintWriter().println("Error: No state to set specified");
        return -1;
    L28:
        boolean newState = Boolean.parseBoolean(newStateRaw);
        if (setsGlobal == false) goto L31;
        this.mService.setHibernatingGlobally(pkg, newState);
    L32:
        return 0;
    L31:
        this.mService.setHibernatingForUser(pkg, userId, newState);
        goto L32
    }

    private int runGetState() {
        boolean requestsGlobal = false;
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L20;
        switch(opt.hashCode()) {
            case 1156993347: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L18;
            case 1: goto L17;
            default: goto L16;
        };
    L17:
        requestsGlobal = true;
        goto L3
    L18:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L16:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        goto L3
    L9:
        if (opt.equals(USER_OPT) == true) goto L15;
        r4 = -1;
        goto L15
    L12:
        if (opt.equals(GLOBAL_OPT) == false) goto L38;
        r4 = 1;
        goto L15
    L38:
        r4 = -1;
        goto L15
    L20:
        String pkg = getNextArgRequired();
        if (pkg != null) goto L24;
        getErrPrintWriter().println("Error: No package specified");
        return -1;
    L24:
        if (requestsGlobal == false) goto L26;
        boolean isHibernating = this.mService.isHibernatingGlobally(pkg);
    L27:
        PrintWriter pw = getOutPrintWriter();
        pw.println(isHibernating);
        return 0;
    L26:
        isHibernating = this.mService.isHibernatingForUser(pkg, userId);
        goto L27
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("App hibernation (app_hibernation) commands: ");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  set-state [--user USER_ID] [--global] PACKAGE true|false");
        pw.println("    Sets the hibernation state of the package to value specified. Optionally");
        pw.println("    may specify a user id or set global hibernation state.");
        pw.println("");
        pw.println("  get-state [--user USER_ID] [--global] PACKAGE");
        pw.println("    Gets the hibernation state of the package. Optionally may specify a user");
        pw.println("    id or request global hibernation state.");
        pw.println("");
    }
}
