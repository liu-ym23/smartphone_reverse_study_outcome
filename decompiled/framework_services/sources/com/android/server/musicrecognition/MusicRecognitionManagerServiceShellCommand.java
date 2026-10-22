package com.android.server.musicrecognition;

import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class MusicRecognitionManagerServiceShellCommand extends ShellCommand {
    private final MusicRecognitionManagerService mService;

    MusicRecognitionManagerServiceShellCommand(MusicRecognitionManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        if ("set".equals(cmd) == false) goto L10;
        return requestSet(pw);
    L10:
        return handleDefaultCommands(cmd);
    L4:
        return handleDefaultCommands(cmd);
    }

    private int requestSet(PrintWriter pw) {
        String what = getNextArgRequired();
        if ("temporary-service".equals(what) == true) goto L5;
        pw.println("Invalid set: " + what);
        return -1;
    L5:
        return setTemporaryService(pw);
    }

    private int setTemporaryService(PrintWriter pw) {
        int userId = Integer.parseInt(getNextArgRequired());
        String serviceName = getNextArg();
        if (serviceName != null) goto L6;
        this.mService.resetTemporaryService(userId);
        return 0;
    L6:
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryService(userId, serviceName, duration);
        pw.println("MusicRecognitionService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("MusicRecognition Service (music_recognition) commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-service USER_ID [COMPONENT_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the service implementation.");     // Catch: Throwable -> L6
        pw.println("    To reset, call with just the USER_ID argument.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.close();
        return;
    L6:
        th = move-exception;
        if (pw != null) goto L13;
    L12:
        throw th;
    L13:
        pw.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }
}
