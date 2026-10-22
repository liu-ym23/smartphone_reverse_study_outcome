package com.android.server.biometrics.sensors.face;

import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class FaceShellCommand extends ShellCommand {
    private final FaceService mService;

    public FaceShellCommand(FaceService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        byte r0 = 1;
        if (cmd != null) goto L32;
        onHelp();
        return 1;
    L32:
    L13:
        e = move-exception;
        getOutPrintWriter().println("Exception: " + e);
    L31:
        return -1;
    L8:
        switch(cmd.hashCode()) {
            case 3198785: goto L19;
            case 3545755: goto L16;
            case 595233003: goto L11;
            default: goto L21;
        };     // Catch: Exception -> L13
    L21:
        r0 = -1;
    L22:
        switch(r0) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            default: goto L23;
        };     // Catch: Exception -> L13
    L23:
        getOutPrintWriter().println("Unrecognized command: " + cmd);     // Catch: Exception -> L13
        goto L31
    L25:
        return doNotify();
    L27:
        return doSync();
    L29:
        return doHelp();
    L11:
        if (cmd.equals("notification") == false) goto L21;
        r0 = 2;
        goto L22
    L16:
        if (cmd.equals("sync") == false) goto L21;
    L19:
        if (cmd.equals("help") == false) goto L21;
        r0 = 0;
        goto L22
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Face Service commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  sync");
        pw.println("      Sync enrollments now (virtualized sensors only).");
        pw.println("  notification");
        pw.println("     Sends a Face re-enrollment notification");
    }

    private int doHelp() {
        onHelp();
        return 0;
    }

    private int doSync() {
        this.mService.syncEnrollmentsNow();
        return 0;
    }

    private int doNotify() {
        this.mService.sendFaceReEnrollNotification();
        return 0;
    }
}
