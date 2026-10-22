package com.android.server.contentcapture;

import android.os.ShellCommand;
import android.os.UserHandle;
import com.android.internal.os.IResultReceiver;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureManagerServiceShellCommand extends ShellCommand {
    private final ContentCaptureManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$DgVJ5YVq3O0B0i3-Gr1Abe4OLWg, reason: not valid java name */
    public static /* synthetic */ void m3223$r8$lambda$DgVJ5YVq3O0B0i3Gr1Abe4OLWg(ContentCaptureManagerServiceShellCommand r0, int r1, IResultReceiver r2) {
        r0.lambda$requestDestroy$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ObS0pK9EY93Edr9Av8pMpZBUC0g(ContentCaptureManagerServiceShellCommand r0, int r1, IResultReceiver r2) {
        r0.lambda$requestList$1(r1, r2);
    }

    public ContentCaptureManagerServiceShellCommand(ContentCaptureManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case 102230: goto L18;
            case 113762: goto L15;
            case 3322014: goto L12;
            case 1557372922: goto L9;
            default: goto L20;
        };
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        return handleDefaultCommands(cmd);
    L25:
        return requestSet(pw);
    L27:
        return requestGet(pw);
    L29:
        return requestDestroy(pw);
    L31:
        return requestList(pw);
    L9:
        if (cmd.equals("destroy") == false) goto L20;
        r1 = 1;
        goto L21
    L12:
        if (cmd.equals("list") == false) goto L20;
        r1 = 0;
        goto L21
    L15:
        if (cmd.equals("set") == false) goto L20;
        r1 = 3;
        goto L21
    L18:
        if (cmd.equals("get") == false) goto L20;
        r1 = 2;
        goto L21
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("ContentCapture Service (content_capture) commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get bind-instant-service-allowed");     // Catch: Throwable -> L6
        pw.println("    Gets whether binding to services provided by instant apps is allowed");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set bind-instant-service-allowed [true | false]");     // Catch: Throwable -> L6
        pw.println("    Sets whether binding to services provided by instant apps is allowed");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-service USER_ID [COMPONENT_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the service implemtation.");     // Catch: Throwable -> L6
        pw.println("    To reset, call with just the USER_ID argument.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set default-service-enabled USER_ID [true|false]");     // Catch: Throwable -> L6
        pw.println("    Enable / disable the default service for the user.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get default-service-enabled USER_ID");     // Catch: Throwable -> L6
        pw.println("    Checks whether the default service is enabled for the user.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  list sessions [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Lists all pending sessions.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  destroy sessions [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Destroys all pending sessions.");     // Catch: Throwable -> L6
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

    private int requestGet(PrintWriter pw) {
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case 529654941: goto L9;
            case 809633044: goto L6;
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
        return getDefaultServiceEnabled(pw);
    L18:
        return getBindInstantService(pw);
    L6:
        if (what.equals("bind-instant-service-allowed") == false) goto L19;
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

    private int requestSet(PrintWriter pw) {
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case 529654941: goto L12;
            case 809633044: goto L9;
            case 2003978041: goto L6;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            default: goto L16;
        };
    L16:
        pw.println("Invalid set: " + what);
        return -1;
    L19:
        return setDefaultServiceEnabled(pw);
    L21:
        return setTemporaryService(pw);
    L23:
        return setBindInstantService(pw);
    L6:
        if (what.equals("temporary-service") == false) goto L24;
        r1 = 1;
        goto L15
    L24:
        r1 = -1;
        goto L15
    L9:
        if (what.equals("bind-instant-service-allowed") == false) goto L25;
        r1 = 0;
        goto L15
    L25:
        r1 = -1;
        goto L15
    L12:
        if (what.equals("default-service-enabled") == false) goto L26;
        r1 = 2;
        goto L15
    L26:
        r1 = -1;
        goto L15
    }

    private int getBindInstantService(PrintWriter pw) {
        if (this.mService.getAllowInstantService() == false) goto L5;
        pw.println("true");
        return 0;
    L5:
        pw.println("false");
        return 0;
    }

    private int setBindInstantService(PrintWriter pw) {
        String mode = getNextArgRequired();
        String r1 = mode.toLowerCase();
        switch(r1.hashCode()) {
            case 3569038: goto L9;
            case 97196323: goto L6;
            default: goto L11;
        };
    L11:
        byte r2 = -1;
    L12:
        switch(r2) {
            case 0: goto L17;
            case 1: goto L15;
            default: goto L13;
        };
    L13:
        pw.println("Invalid mode: " + mode);
        return -1;
    L15:
        this.mService.setAllowInstantService(false);
        return 0;
    L17:
        this.mService.setAllowInstantService(true);
        return 0;
    L6:
        if (r1.equals("false") == false) goto L19;
        r2 = 1;
        goto L12
    L19:
        r2 = -1;
        goto L12
    L9:
        if (r1.equals("true") == false) goto L20;
        r2 = 0;
        goto L12
    L20:
        r2 = -1;
        goto L12
    }

    private int setTemporaryService(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        String serviceName = getNextArg();
        if (serviceName != null) goto L6;
        this.mService.resetTemporaryService(userId);
        return 0;
    L6:
        int duration = getNextIntArgRequired();
        this.mService.setTemporaryService(userId, serviceName, duration);
        pw.println("ContentCaptureService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int setDefaultServiceEnabled(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        boolean enabled = Boolean.parseBoolean(getNextArgRequired());
        boolean changed = this.mService.setDefaultServiceEnabled(userId, enabled);
        if (changed == true) goto L7;
        pw.println("already " + enabled);
        return 0;
    L7:
        return 0;
    }

    private int getDefaultServiceEnabled(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        boolean enabled = this.mService.isDefaultServiceEnabled(userId);
        pw.println(enabled);
        return 0;
    }

    private int requestDestroy(PrintWriter pw) {
        if (isNextArgSessions(pw) == true) goto L6;
        return -1;
    L6:
        final int userId = getUserIdFromArgsOrAllUsers();
        final CountDownLatch latch = new CountDownLatch(1);
        final IResultReceiver.Stub r2 = new AnonymousClass1(this, latch);
        return requestSessionCommon(pw, latch, new ContentCaptureManagerServiceShellCommand$$ExternalSyntheticLambda1(this, userId, r2));
    }

    private /* synthetic */ void lambda$requestDestroy$0(int userId, IResultReceiver receiver) {
        this.mService.destroySessions(userId, receiver);
    }

    private int requestList(final PrintWriter pw) {
        if (isNextArgSessions(pw) == true) goto L6;
        return -1;
    L6:
        final int userId = getUserIdFromArgsOrAllUsers();
        final CountDownLatch latch = new CountDownLatch(1);
        final IResultReceiver.Stub r2 = new AnonymousClass2(this, pw, latch);
        return requestSessionCommon(pw, latch, new ContentCaptureManagerServiceShellCommand$$ExternalSyntheticLambda0(this, userId, r2));
    }

    private /* synthetic */ void lambda$requestList$1(int userId, IResultReceiver receiver) {
        this.mService.listSessions(userId, receiver);
    }

    private boolean isNextArgSessions(PrintWriter pw) {
        String type = getNextArgRequired();
        if (type.equals("sessions") == true) goto L6;
        pw.println("Error: invalid list type");
        return false;
    L6:
        return true;
    }

    private int requestSessionCommon(PrintWriter pw, CountDownLatch latch, Runnable command) {
        command.run();
        return waitForLatch(pw, latch);
    }

    private int waitForLatch(PrintWriter pw, CountDownLatch latch) {
        boolean received = latch.await(5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L7
        if (received == true) goto L9;
        pw.println("Timed out after 5 seconds");     // Catch: InterruptedException -> L7
        return -1;
    L9:
        return 0;
    L11:
        pw.println("System call interrupted");
        Thread.currentThread().interrupt();
        return -1;
    }

    private int getUserIdFromArgsOrAllUsers() {
        if ("--user".equals(getNextArg()) == true) goto L5;
        return -1;
    L5:
        return UserHandle.parseUserArg(getNextArgRequired());
    }

    private int getNextIntArgRequired() {
        return Integer.parseInt(getNextArgRequired());
    }
}
