package com.android.server.pm;

import android.content.pm.IOtaDexopt;
import android.os.RemoteException;
import android.os.ShellCommand;
import java.io.PrintWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class OtaDexoptShellCommand extends ShellCommand {
    final IOtaDexopt mInterface;

    OtaDexoptShellCommand(OtaDexoptService service) {
        this.mInterface = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -1001078227: goto L27;
            case -318370553: goto L24;
            case 3089282: goto L21;
            case 3377907: goto L18;
            case 3540684: goto L15;
            case 856774308: goto L10;
            default: goto L29;
        };     // Catch: RemoteException -> L12
    L29:
        byte r2 = -1;
    L30:
        switch(r2) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L34;
            default: goto L32;
        };     // Catch: RemoteException -> L12
    L32:
        return handleDefaultCommands(cmd);
    L34:
        return runOtaProgress();
    L36:
        return runOtaNext();
    L38:
        return runOtaStep();
    L40:
        return runOtaDone();
    L42:
        return runOtaCleanup();
    L44:
        return runOtaPrepare();
    L10:
        if (cmd.equals("cleanup") == false) goto L29;
        r2 = 1;
        goto L30
    L15:
        if (cmd.equals("step") == false) goto L29;
        r2 = 3;
        goto L30
    L18:
        if (cmd.equals("next") == false) goto L29;
        r2 = 4;
        goto L30
    L21:
        if (cmd.equals("done") == false) goto L29;
        r2 = 2;
        goto L30
    L24:
        if (cmd.equals("prepare") == false) goto L29;
        r2 = 0;
        goto L30
    L27:
        if (cmd.equals("progress") == false) goto L29;
        r2 = 5;
        goto L30
    L4:
        return handleDefaultCommands(null);
    }

    private int runOtaPrepare() throws RemoteException {
        this.mInterface.prepare();
        getOutPrintWriter().println("Success");
        return 0;
    }

    private int runOtaCleanup() throws RemoteException {
        this.mInterface.cleanup();
        return 0;
    }

    private int runOtaDone() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        if (this.mInterface.isDone() == false) goto L5;
        pw.println("OTA complete.");
        return 0;
    L5:
        pw.println("OTA incomplete.");
        return 0;
    }

    private int runOtaStep() throws RemoteException {
        this.mInterface.dexoptNextPackage();
        return 0;
    }

    private int runOtaNext() throws RemoteException {
        getOutPrintWriter().println(this.mInterface.nextDexoptCommand());
        return 0;
    }

    private int runOtaProgress() throws RemoteException {
        float progress = this.mInterface.getProgress();
        PrintWriter pw = getOutPrintWriter();
        pw.format(Locale.ROOT, "%.2f", new Object[]{Float.valueOf(progress)});
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("OTA Dexopt (ota) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  prepare");
        pw.println("    Prepare an OTA dexopt pass, collecting all packages.");
        pw.println("  done");
        pw.println("    Replies whether the OTA is complete or not.");
        pw.println("  step");
        pw.println("    OTA dexopt the next package.");
        pw.println("  next");
        pw.println("    Get parameters for OTA dexopt of the next package.");
        pw.println("  cleanup");
        pw.println("    Clean up internal states. Ends an OTA session.");
    }
}
