package com.android.server.security.advancedprotection;

import android.os.RemoteException;
import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class AdvancedProtectionShellCommand extends ShellCommand {
    private AdvancedProtectionService mService;

    AdvancedProtectionShellCommand(AdvancedProtectionService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        e = move-exception;
        pw.println("Remote exception: " + e);
    L40:
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -1996175388: goto L24;
            case 3198785: goto L21;
            case 338948892: goto L18;
            case 1004719568: goto L15;
            case 1597219736: goto L10;
            default: goto L26;
        };     // Catch: RemoteException -> L12
    L26:
        byte r2 = -1;
    L27:
        switch(r2) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            default: goto L40;
        };     // Catch: RemoteException -> L12
    L37:
        onHelp();     // Catch: RemoteException -> L12
        return 0;
    L30:
        return isUsbDataProtectedEnabled(pw);
    L32:
        return setUsbDataProtectedEnabled();
    L34:
        return isProtectionEnabled(pw);
    L36:
        return setProtectionEnabled();
    L10:
        if (cmd.equals("set-protection-enabled") == false) goto L26;
        r2 = 1;
        goto L27
    L15:
        if (cmd.equals("is-protection-enabled") == false) goto L26;
        r2 = 2;
        goto L27
    L18:
        if (cmd.equals("set-usb-data-protection-enabled") == false) goto L26;
        r2 = 3;
        goto L27
    L21:
        if (cmd.equals("help") == false) goto L26;
        r2 = 0;
        goto L27
    L24:
        if (cmd.equals("is-usb-data-protection-enabled") == false) goto L26;
        r2 = 4;
        goto L27
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        dumpHelp(pw);
    }

    private void dumpHelp(PrintWriter pw) {
        pw.println("Advanced Protection Mode commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  set-protection-enabled [true|false]");
        pw.println("  is-protection-enabled");
    }

    private int setProtectionEnabled() throws RemoteException {
        String protectionMode = getNextArgRequired();
        this.mService.setAdvancedProtectionEnabled(Boolean.parseBoolean(protectionMode));
        return 0;
    }

    private int isProtectionEnabled(PrintWriter pw) throws RemoteException {
        boolean protectionMode = this.mService.isAdvancedProtectionEnabled();
        pw.println(protectionMode);
        return 0;
    }

    private int setUsbDataProtectedEnabled() throws RemoteException {
        return 0;
    }

    private int isUsbDataProtectedEnabled(PrintWriter pw) throws RemoteException {
        return 0;
    }
}
