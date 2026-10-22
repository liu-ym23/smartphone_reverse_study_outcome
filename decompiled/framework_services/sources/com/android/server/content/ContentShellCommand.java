package com.android.server.content;

import android.content.IContentService;
import android.os.RemoteException;
import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ContentShellCommand extends ShellCommand {
    final IContentService mInterface;

    ContentShellCommand(IContentService service) {
        this.mInterface = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L16:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -796331115: goto L10;
            default: goto L12;
        };     // Catch: RemoteException -> L16
    L12:
        byte r2 = -1;
    L13:
        switch(r2) {
            case 0: goto L19;
            default: goto L15;
        };     // Catch: RemoteException -> L16
    L15:
        return handleDefaultCommands(cmd);
    L19:
        return runResetTodayStats();
    L10:
        if (cmd.equals("reset-today-stats") == false) goto L12;
        r2 = 0;
        goto L13
    L4:
        return handleDefaultCommands(cmd);
    }

    private int runResetTodayStats() throws RemoteException {
        this.mInterface.resetTodayStats();
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Content service commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  reset-today-stats");
        pw.println("    Reset 1-day sync stats.");
        pw.println();
    }
}
