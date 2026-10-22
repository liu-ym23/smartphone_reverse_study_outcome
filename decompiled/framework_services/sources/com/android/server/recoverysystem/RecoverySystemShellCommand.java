package com.android.server.recoverysystem;

import android.os.IRecoverySystem;
import android.os.RemoteException;
import android.os.ShellCommand;
import com.android.server.content.SyncStorageEngine;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class RecoverySystemShellCommand extends ShellCommand {
    private final IRecoverySystem mService;

    public RecoverySystemShellCommand(RecoverySystemService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L42;
        return handleDefaultCommands(cmd);
    L42:
    L12:
        e = move-exception;
        getErrPrintWriter().println("Error while executing command: " + cmd);
        e.printStackTrace(getErrPrintWriter());
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -779212638: goto L24;
            case 3649607: goto L21;
            case 1214227142: goto L18;
            case 1256867232: goto L15;
            case 1405182928: goto L10;
            default: goto L26;
        };     // Catch: Exception -> L12
    L26:
        byte r1 = -1;
    L27:
        switch(r1) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            default: goto L29;
        };     // Catch: Exception -> L12
    L29:
        return handleDefaultCommands(cmd);
    L31:
        return wipe();
    L33:
        return rebootAndApply();
    L35:
        return isLskfCaptured();
    L37:
        return clearLskf();
    L39:
        return requestLskf();
    L10:
        if (cmd.equals("reboot-and-apply") == false) goto L26;
        r1 = 3;
        goto L27
    L15:
        if (cmd.equals("request-lskf") == false) goto L26;
        r1 = 0;
        goto L27
    L18:
        if (cmd.equals("is-lskf-captured") == false) goto L26;
        r1 = 2;
        goto L27
    L21:
        if (cmd.equals("wipe") == false) goto L26;
        r1 = 4;
        goto L27
    L24:
        if (cmd.equals("clear-lskf") == false) goto L26;
        r1 = 1;
        goto L27
    }

    private int wipe() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String newFsType = getNextArg();
        String command = "--wipe_data";
        if (newFsType != null) goto L5;
    L7:
        pw.println("Rebooting into recovery with " + command.replaceAll("\n", " "));
        this.mService.rebootRecoveryWithCommand(command);
        return 0;
    L5:
        if (newFsType.isEmpty() == true) goto L7;
        command = "--wipe_data\n--reformat_data=" + newFsType;
        goto L7
    }

    private int requestLskf() throws RemoteException {
        String packageName = getNextArgRequired();
        boolean success = this.mService.requestLskf(packageName, null);
        PrintWriter pw = getOutPrintWriter();
        if (success == false) goto L5;
        String r3 = SyncStorageEngine.MESG_SUCCESS;
    L6:
        pw.printf("Request LSKF for packageName: %s, status: %s\n", new Object[]{packageName, r3});
        return 0;
    L5:
        r3 = "failure";
        goto L6
    }

    private int clearLskf() throws RemoteException {
        String packageName = getNextArgRequired();
        boolean success = this.mService.clearLskf(packageName);
        PrintWriter pw = getOutPrintWriter();
        if (success == false) goto L5;
        String r3 = SyncStorageEngine.MESG_SUCCESS;
    L6:
        pw.printf("Clear LSKF for packageName: %s, status: %s\n", new Object[]{packageName, r3});
        return 0;
    L5:
        r3 = "failure";
        goto L6
    }

    private int isLskfCaptured() throws RemoteException {
        String packageName = getNextArgRequired();
        boolean captured = this.mService.isLskfCaptured(packageName);
        PrintWriter pw = getOutPrintWriter();
        if (captured == false) goto L5;
        String r3 = "true";
    L6:
        pw.printf("%s LSKF capture status: %s\n", new Object[]{packageName, r3});
        return 0;
    L5:
        r3 = "false";
        goto L6
    }

    private int rebootAndApply() throws RemoteException {
        String packageName = getNextArgRequired();
        String rebootReason = getNextArgRequired();
        if (this.mService.rebootWithLskf(packageName, rebootReason, false) != 0) goto L5;
        boolean success = true;
    L6:
        PrintWriter pw = getOutPrintWriter();
        if (success == false) goto L9;
        String r5 = SyncStorageEngine.MESG_SUCCESS;
    L10:
        pw.printf("%s Reboot and apply status: %s\n", new Object[]{packageName, r5});
        return 0;
    L9:
        r5 = "failure";
        goto L10
    L5:
        success = false;
        goto L6
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Recovery system commands:");
        pw.println("  request-lskf <package_name>");
        pw.println("  clear-lskf");
        pw.println("  is-lskf-captured <package_name>");
        pw.println("  reboot-and-apply <package_name> <reason>");
        pw.println("  wipe <new filesystem type ext4/f2fs>");
    }
}
