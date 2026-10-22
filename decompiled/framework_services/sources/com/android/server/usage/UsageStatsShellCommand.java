package com.android.server.usage;

import android.app.ActivityManager;
import android.os.ShellCommand;
import android.os.UserHandle;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class UsageStatsShellCommand extends ShellCommand {
    private final UsageStatsService mService;

    UsageStatsShellCommand(UsageStatsService usageStatsService) {
        this.mService = usageStatsService;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(null);
    L6:
        switch(cmd.hashCode()) {
            case 949945779: goto L12;
            case 2135796854: goto L9;
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
        return deletePackageData();
    L21:
        return runClearLastUsedTimestamps();
    L9:
        if (cmd.equals("clear-last-used-timestamps") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (cmd.equals("delete-package-data") == false) goto L14;
        r0 = 1;
        goto L15
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("UsageStats service (usagestats) commands:");
        pw.println("help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("clear-last-used-timestamps PACKAGE_NAME [-u | --user USER_ID]");
        pw.println("    Clears the last used timestamps for the given package.");
        pw.println();
        pw.println("delete-package-data PACKAGE_NAME [-u | --user USER_ID]");
        pw.println("    Deletes all the usage stats for the given package.");
        pw.println();
    }

    private int runClearLastUsedTimestamps() {
        String packageName = getNextArgRequired();
        int userId = getUserId();
        if (userId != (-1)) goto L5;
        return -1;
    L5:
        this.mService.clearLastUsedTimestamps(packageName, userId);
        return 0;
    }

    private int deletePackageData() {
        String packageName = getNextArgRequired();
        int userId = getUserId();
        if (userId != (-1)) goto L5;
        return -1;
    L5:
        this.mService.deletePackageData(packageName, userId);
        return 0;
    }

    private int getUserId() {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L14;
        if ("-u".equals(opt) == true) goto L12;
        if ("--user".equals(opt) == true) goto L12;
        getErrPrintWriter().println("Error: unknown option: " + opt);
        return -1;
    L12:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L14:
        if (userId != (-2)) goto L21;
        int userId2 = ActivityManager.getCurrentUser();
        return userId2;
    L21:
        return userId;
    }
}
