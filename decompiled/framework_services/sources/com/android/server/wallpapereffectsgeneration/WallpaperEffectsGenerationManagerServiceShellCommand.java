package com.android.server.wallpapereffectsgeneration;

import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class WallpaperEffectsGenerationManagerServiceShellCommand extends ShellCommand {
    private static final String TAG = null;
    private final WallpaperEffectsGenerationManagerService mService;

    static {
        TAG = WallpaperEffectsGenerationManagerServiceShellCommand.class.getSimpleName();
    }

    public WallpaperEffectsGenerationManagerServiceShellCommand(WallpaperEffectsGenerationManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        byte r2 = -1;
        switch(cmd.hashCode()) {
            case 113762: goto L9;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L15;
            default: goto L14;
        };
    L15:
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case 2003978041: goto L19;
            default: goto L21;
        };
    L21:
        switch(r2) {
            case 0: goto L23;
            default: goto L29;
        };
    L23:
        int userId = Integer.parseInt(getNextArgRequired());
        String serviceName = getNextArg();
        if (serviceName != null) goto L27;
        this.mService.resetTemporaryService(userId);
        pw.println("WallpaperEffectsGenerationService temporarily reset. ");
        return 0;
    L27:
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryService(userId, serviceName, duration);
        pw.println("WallpaperEffectsGenerationService temporarily set to " + serviceName + " for " + duration + "ms");
    L29:
        return 0;
    L19:
        if (what.equals("temporary-service") == false) goto L21;
        r2 = 0;
        goto L21
    L14:
        return handleDefaultCommands(cmd);
    L9:
        if (cmd.equals("set") == false) goto L11;
        r1 = 0;
        goto L12
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("WallpaperEffectsGenerationService commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-service USER_ID [COMPONENT_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the service implemtation.");     // Catch: Throwable -> L6
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
