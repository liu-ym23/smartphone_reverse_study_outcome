package com.android.server.supervision;

import android.os.ShellCommand;
import android.os.UserHandle;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class SupervisionServiceShellCommand extends ShellCommand {
    private final SupervisionService mService;

    public SupervisionServiceShellCommand(SupervisionService mService) {
        this.mService = mService;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(null);
    L6:
        switch(cmd.hashCode()) {
            case -1298848381: goto L12;
            case 1671308008: goto L9;
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
        return setEnabled(false);
    L21:
        return setEnabled(true);
    L9:
        if (cmd.equals("disable") == false) goto L14;
        r0 = 1;
        goto L15
    L12:
        if (cmd.equals("enable") == false) goto L14;
        r0 = 0;
        goto L15
    }

    private int setEnabled(boolean enabled) {
        int userId = UserHandle.parseUserArg(getNextArgRequired());
        this.mService.mInternal.setSupervisionEnabledForUser(userId, enabled);
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Supervision service (supervision) commands:");
        pw.println("  help");
        pw.println("      Prints this help text");
        pw.println("  enable <USER_ID>");
        pw.println("      Enables supervision for the given user.");
        pw.println("  disable <USER_ID>");
        pw.println("      Disables supervision for the given user.");
    }
}
