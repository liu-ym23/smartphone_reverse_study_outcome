package com.android.server.adb;

import com.android.modules.utils.BasicShellCommandHandler;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
class AdbShellCommand extends BasicShellCommandHandler {
    private final AdbService mService;

    AdbShellCommand(AdbService service) {
        service.getClass();
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -138263081: goto L12;
            case 434812665: goto L9;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L20;
            case 1: goto L18;
            default: goto L17;
        };
    L18:
        pw.println(Boolean.toString(this.mService.isAdbWifiQrSupported()));
        return 0;
    L20:
        pw.println(Boolean.toString(this.mService.isAdbWifiSupported()));
        return 0;
    L17:
        return handleDefaultCommands(cmd);
    L9:
        if (cmd.equals("is-wifi-supported") == false) goto L14;
        r1 = 0;
        goto L15
    L12:
        if (cmd.equals("is-wifi-qr-supported") == false) goto L14;
        r1 = 1;
        goto L15
    L4:
        return handleDefaultCommands(null);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Adb service commands:");
        pw.println("  help or -h");
        pw.println("    Print this help text.");
        pw.println("  is-wifi-supported");
        pw.println("    Returns \"true\" if adb over wifi is supported.");
        pw.println("  is-wifi-qr-supported");
        pw.println("    Returns \"true\" if adb over wifi + QR pairing is supported.");
        pw.println();
    }
}
