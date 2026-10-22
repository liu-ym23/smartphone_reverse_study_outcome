package com.android.server.biometrics.sensors.fingerprint;

import android.content.Context;
import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintShellCommand extends ShellCommand {
    private final Context mContext;
    private final FingerprintService mService;

    public FingerprintShellCommand(Context context, FingerprintService service) {
        this.mContext = context;
        this.mService = service;
    }

    public int onCommand(String cmd) {
        byte r0 = 1;
        if (cmd != null) goto L37;
        onHelp();
        return 1;
    L37:
    L13:
        e = move-exception;
        getOutPrintWriter().println("Exception: " + e);
    L36:
        return -1;
    L8:
        switch(cmd.hashCode()) {
            case -1014576245: goto L22;
            case 3198785: goto L19;
            case 3545755: goto L16;
            case 595233003: goto L11;
            default: goto L24;
        };     // Catch: Exception -> L13
    L24:
        r0 = -1;
    L25:
        switch(r0) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            default: goto L26;
        };     // Catch: Exception -> L13
    L26:
        getOutPrintWriter().println("Unrecognized command: " + cmd);     // Catch: Exception -> L13
        goto L36
    L28:
        return doNotify();
    L30:
        return doSimulateVhalFingerDown();
    L32:
        return doSync();
    L34:
        return doHelp();
    L11:
        if (cmd.equals("notification") == false) goto L24;
        r0 = 3;
        goto L25
    L16:
        if (cmd.equals("sync") == false) goto L24;
    L19:
        if (cmd.equals("help") == false) goto L24;
        r0 = 0;
        goto L25
    L22:
        if (cmd.equals("fingerdown") == false) goto L24;
        r0 = 2;
        goto L25
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Fingerprint Service commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  sync");
        pw.println("      Sync enrollments now (virtualized sensors only).");
        pw.println("  fingerdown");
        pw.println("      Simulate finger down event (virtualized sensors only).");
        pw.println("  notification");
        pw.println("     Sends a Fingerprint re-enrollment notification");
    }

    private int doHelp() {
        onHelp();
        return 0;
    }

    private int doSync() {
        this.mService.syncEnrollmentsNow();
        return 0;
    }

    private int doSimulateVhalFingerDown() {
        this.mService.simulateVhalFingerDown();
        return 0;
    }

    private int doNotify() {
        this.mService.sendFingerprintReEnrollNotification();
        return 0;
    }
}
