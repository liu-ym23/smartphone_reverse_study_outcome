package com.android.server.contentsuggestions;

import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ContentSuggestionsManagerServiceShellCommand extends ShellCommand {
    private static final String TAG = null;
    private final ContentSuggestionsManagerService mService;

    static {
        TAG = ContentSuggestionsManagerServiceShellCommand.class.getSimpleName();
    }

    public ContentSuggestionsManagerServiceShellCommand(ContentSuggestionsManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case 102230: goto L12;
            case 113762: goto L9;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L21;
            case 1: goto L19;
            default: goto L17;
        };
    L17:
        return handleDefaultCommands(cmd);
    L19:
        return requestGet(pw);
    L21:
        return requestSet(pw);
    L9:
        if (cmd.equals("set") == false) goto L14;
        r1 = 0;
        goto L15
    L12:
        if (cmd.equals("get") == false) goto L14;
        r1 = 1;
        goto L15
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("ContentSuggestionsManagerService commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-service USER_ID [COMPONENT_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the service implementation.");     // Catch: Throwable -> L6
        pw.println("    To reset, call with just the USER_ID argument.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set default-service-enabled USER_ID [true|false]");     // Catch: Throwable -> L6
        pw.println("    Enable / disable the default service for the user.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get default-service-enabled USER_ID");     // Catch: Throwable -> L6
        pw.println("    Checks whether the default service is enabled for the user.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.close();
        return;
    L6:
        th = move-exception;
        if (pw != null) goto L15;
    L12:
        throw th;
    L15:
        pw.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    private int requestSet(PrintWriter pw) {
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case 529654941: goto L9;
            case 2003978041: goto L6;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L18;
            case 1: goto L16;
            default: goto L13;
        };
    L13:
        pw.println("Invalid set: " + what);
        return -1;
    L16:
        return setDefaultServiceEnabled();
    L18:
        return setTemporaryService(pw);
    L6:
        if (what.equals("temporary-service") == false) goto L19;
        r1 = 0;
        goto L12
    L19:
        r1 = -1;
        goto L12
    L9:
        if (what.equals("default-service-enabled") == false) goto L20;
        r1 = 1;
        goto L12
    L20:
        r1 = -1;
        goto L12
    }

    private int requestGet(PrintWriter pw) {
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case 529654941: goto L6;
            default: goto L8;
        };
    L8:
        byte r1 = -1;
    L9:
        switch(r1) {
            case 0: goto L13;
            default: goto L10;
        };
    L10:
        pw.println("Invalid get: " + what);
        return -1;
    L13:
        return getDefaultServiceEnabled(pw);
    L6:
        if (what.equals("default-service-enabled") == false) goto L8;
        r1 = 0;
        goto L9
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
        pw.println("ContentSuggestionsService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int setDefaultServiceEnabled() {
        int userId = getNextIntArgRequired();
        boolean enabled = Boolean.parseBoolean(getNextArg());
        this.mService.setDefaultServiceEnabled(userId, enabled);
        return 0;
    }

    private int getDefaultServiceEnabled(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        boolean enabled = this.mService.isDefaultServiceEnabled(userId);
        pw.println(enabled);
        return 0;
    }

    private int getNextIntArgRequired() {
        return Integer.parseInt(getNextArgRequired());
    }
}
