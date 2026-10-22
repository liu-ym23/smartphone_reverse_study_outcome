package com.android.server.voiceinteraction;

import android.os.Bundle;
import android.os.ShellCommand;
import android.util.Slog;
import com.android.internal.app.IVoiceInteractionSessionShowCallback;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class VoiceInteractionManagerServiceShellCommand extends ShellCommand {
    private static final String TAG = "VoiceInteractionManager";
    private static final long TIMEOUT_MS = 5000;
    private final VoiceInteractionManagerService.VoiceInteractionManagerServiceStub mService;

    VoiceInteractionManagerServiceShellCommand(VoiceInteractionManagerService.VoiceInteractionManagerServiceStub service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -1097066044: goto L21;
            case 3202370: goto L18;
            case 3529469: goto L15;
            case 1671308008: goto L12;
            case 1718895687: goto L9;
            default: goto L23;
        };
    L23:
        byte r1 = -1;
    L24:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        return handleDefaultCommands(cmd);
    L28:
        return setDebugHotwordLogging(pw);
    L30:
        return requestRestartDetection(pw);
    L32:
        return requestDisable(pw);
    L34:
        return requestHide(pw);
    L36:
        return requestShow(pw);
    L9:
        if (cmd.equals("restart-detection") == false) goto L23;
        r1 = 3;
        goto L24
    L12:
        if (cmd.equals("disable") == false) goto L23;
        r1 = 2;
        goto L24
    L15:
        if (cmd.equals("show") == false) goto L23;
        r1 = 0;
        goto L24
    L18:
        if (cmd.equals("hide") == false) goto L23;
        r1 = 1;
        goto L24
    L21:
        if (cmd.equals("set-debug-hotword-logging") == false) goto L23;
        r1 = 4;
        goto L24
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("VoiceInteraction Service (voiceinteraction) commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  show");     // Catch: Throwable -> L6
        pw.println("    Shows a session for the active service");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  hide");     // Catch: Throwable -> L6
        pw.println("    Hides the current session");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  disable [true|false]");     // Catch: Throwable -> L6
        pw.println("    Temporarily disable (when true) service");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  restart-detection");     // Catch: Throwable -> L6
        pw.println("    Force a restart of a hotword detection service");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set-debug-hotword-logging [true|false]");     // Catch: Throwable -> L6
        pw.println("    Temporarily enable or disable debug logging for hotword result.");     // Catch: Throwable -> L6
        pw.println("    The debug logging will be reset after one hour from last enable.");     // Catch: Throwable -> L6
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

    private int requestShow(final PrintWriter pw) {
        Slog.i(TAG, "requestShow()");
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicInteger result = new AtomicInteger();
        IVoiceInteractionSessionShowCallback callback = new AnonymousClass1(this, pw, result, latch);
        Bundle args = new Bundle();     // Catch: Exception -> L7
        boolean ok = this.mService.showSessionForActiveService(args, 0, null, callback, null);     // Catch: Exception -> L7
        if (ok == true) goto L10;
        pw.println("showSessionForActiveService() returned false");     // Catch: Exception -> L7
        return 1;
    L10:
        if (latch.await(TIMEOUT_MS, TimeUnit.MILLISECONDS) == true) goto L13;
        pw.printf("Callback not called in %d ms\n", new Object[]{Long.valueOf(TIMEOUT_MS)});     // Catch: Exception -> L7
        return 1;
    L13:
        return 0;
    L7:
        e = move-exception;
        return handleError(pw, "showSessionForActiveService()", e);
    }

    private int requestHide(PrintWriter pw) {
        Slog.i(TAG, "requestHide()");
        this.mService.hideCurrentSession();     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        return handleError(pw, "requestHide()", e);
    }

    private int requestDisable(PrintWriter pw) {
        boolean disabled = Boolean.parseBoolean(getNextArgRequired());
        Slog.i(TAG, "requestDisable(): " + disabled);
        this.mService.setDisabled(disabled);     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        return handleError(pw, "requestDisable()", e);
    }

    private int requestRestartDetection(PrintWriter pw) {
        Slog.i(TAG, "requestRestartDetection()");
        this.mService.forceRestartHotwordDetector();     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        return handleError(pw, "requestRestartDetection()", e);
    }

    private int setDebugHotwordLogging(PrintWriter pw) {
        boolean logging = Boolean.parseBoolean(getNextArgRequired());
        Slog.i(TAG, "setDebugHotwordLogging(): " + logging);
        this.mService.setDebugHotwordLogging(logging);     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        return handleError(pw, "setDebugHotwordLogging()", e);
    }

    private static int handleError(PrintWriter pw, String message, Exception e) {
        Slog.e(TAG, "error calling " + message, e);
        pw.printf("Error calling %s: %s\n", new Object[]{message, e});
        return 1;
    }
}
