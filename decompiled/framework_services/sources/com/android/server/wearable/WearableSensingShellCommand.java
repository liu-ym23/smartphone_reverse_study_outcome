package com.android.server.wearable;

import android.content.ComponentName;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.ShellCommand;
import android.util.Slog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
final class WearableSensingShellCommand extends ShellCommand {
    private static final String TAG = null;
    private static ParcelFileDescriptor[] sPipe;
    static final TestableCallbackInternal sTestableCallbackInternal = null;
    private final WearableSensingManagerService mService;

    static class TestableCallbackInternal {
        private int mLastStatus;

        public static /* synthetic */ void $r8$lambda$Z8wERZw8FiWkZXCijwngc10bZ34(TestableCallbackInternal r0, Bundle r1) {
            r0.lambda$createRemoteStatusCallback$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mcreateRemoteStatusCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ RemoteCallback m9581$$Nest$mcreateRemoteStatusCallback(TestableCallbackInternal r0) {
            return r0.createRemoteStatusCallback();
        }

        TestableCallbackInternal() {
        }

        public int getLastStatus() {
            return this.mLastStatus;
        }

        private RemoteCallback createRemoteStatusCallback() {
            return new RemoteCallback(new WearableSensingShellCommand$TestableCallbackInternal$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$createRemoteStatusCallback$0(Bundle result) {
            int status = result.getInt("android.app.wearable.WearableSensingStatusBundleKey");
            long token = Binder.clearCallingIdentity();
            this.mLastStatus = status;     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }
    }

    static {
        TAG = WearableSensingShellCommand.class.getSimpleName();
        sTestableCallbackInternal = new TestableCallbackInternal();
    }

    WearableSensingShellCommand(WearableSensingManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -2084150080: goto L33;
            case -1302613409: goto L30;
            case -1151909456: goto L27;
            case -1090567019: goto L24;
            case -482328746: goto L21;
            case 586534834: goto L18;
            case 1104883342: goto L15;
            case 1539157463: goto L12;
            case 2018305992: goto L9;
            default: goto L35;
        };
    L35:
        byte r0 = -1;
    L36:
        switch(r0) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            case 8: goto L40;
            default: goto L38;
        };
    L38:
        return handleDefaultCommands(cmd);
    L40:
        return setDataRequestRateLimitWindowSize();
    L42:
        return setTemporaryService();
    L44:
        return getBoundPackageName();
    L46:
        return getLastStatusCode();
    L48:
        return provideData();
    L50:
        return writeToDataStream();
    L52:
        return provideDataStream();
    L54:
        return destroyDataStream();
    L56:
        return createDataStream();
    L9:
        if (cmd.equals("get-last-status-code") == false) goto L35;
        r0 = 5;
        goto L36
    L12:
        if (cmd.equals("provide-data-stream") == false) goto L35;
        r0 = 2;
        goto L36
    L15:
        if (cmd.equals("set-temporary-service") == false) goto L35;
        r0 = 7;
        goto L36
    L18:
        if (cmd.equals("create-data-stream") == false) goto L35;
        r0 = 0;
        goto L36
    L21:
        if (cmd.equals("provide-data") == false) goto L35;
        r0 = 4;
        goto L36
    L24:
        if (cmd.equals("set-data-request-rate-limit-window-size") == false) goto L35;
        r0 = 8;
        goto L36
    L27:
        if (cmd.equals("destroy-data-stream") == false) goto L35;
        r0 = 1;
        goto L36
    L30:
        if (cmd.equals("write-to-data-stream") == false) goto L35;
        r0 = 3;
        goto L36
    L33:
        if (cmd.equals("get-bound-package") == false) goto L35;
        r0 = 6;
        goto L36
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("WearableSensingCommands commands: ");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  create-data-stream: Creates a data stream to be provided.");
        pw.println("  destroy-data-stream: Destroys a data stream if one was previously created.");
        pw.println("  provide-data-stream USER_ID: Provides data stream to WearableSensingService.");
        pw.println("  write-to-data-stream STRING: writes string to data stream.");
        pw.println("  provide-data USER_ID KEY INTEGER: provide integer as data with key.");
        pw.println("  get-last-status-code: Prints the latest request status code.");
        pw.println("  get-bound-package USER_ID:     Print the bound package that implements the service.");
        pw.println("  set-temporary-service USER_ID [PACKAGE_NAME] [COMPONENT_NAME DURATION]");
        pw.println("    Temporarily (for DURATION ms) changes the service implementation.");
        pw.println("    To reset, call with just the USER_ID argument.");
        pw.println("  set-data-request-rate-limit-window-size WINDOW_SIZE");
        pw.println("    Set the window size used in data request rate limiting to WINDOW_SIZE seconds.");
        pw.println("    positive WINDOW_SIZE smaller than 20 will be automatically set to 20.");
        pw.println("    To reset, call with 0 or a negative WINDOW_SIZE.");
    }

    private int createDataStream() {
        Slog.d(TAG, "createDataStream");
        sPipe = ParcelFileDescriptor.createPipe();     // Catch: IOException -> L5
        return 0;
    L5:
        e = move-exception;
        Slog.d(TAG, "Failed to createDataStream.", e);
        return 0;
    }

    private int destroyDataStream() {
        Slog.d(TAG, "destroyDataStream");
    L7:
        e = move-exception;
        Slog.d(TAG, "Failed to destroyDataStream.", e);
    L11:
        return 0;
    L4:
        if (sPipe == null) goto L11;
        sPipe[0].close();     // Catch: IOException -> L7
        sPipe[1].close();     // Catch: IOException -> L7
        goto L11
    }

    private int provideDataStream() {
        Slog.d(TAG, "provideDataStream");
        if (sPipe == null) goto L5;
        int userId = Integer.parseInt(getNextArgRequired());
        this.mService.provideDataStream(userId, sPipe[0], TestableCallbackInternal.m9581$$Nest$mcreateRemoteStatusCallback(sTestableCallbackInternal));
    L5:
        return 0;
    }

    private int writeToDataStream() {
        Slog.d(TAG, "writeToDataStream");
        if (sPipe == null) goto L13;
        String value = getNextArgRequired();
        ParcelFileDescriptor writePipe = sPipe[1].dup();     // Catch: IOException -> L7
        OutputStream os = new ParcelFileDescriptor.AutoCloseOutputStream(writePipe);     // Catch: IOException -> L7
        os.write(value.getBytes());     // Catch: IOException -> L7
        return 0;
    L7:
        e = move-exception;
        Slog.d(TAG, "Failed to writeToDataStream.", e);
        return 0;
    L13:
        return 0;
    }

    private int provideData() {
        Slog.d(TAG, "provideData");
        int userId = Integer.parseInt(getNextArgRequired());
        String key = getNextArgRequired();
        int value = Integer.parseInt(getNextArgRequired());
        PersistableBundle data = new PersistableBundle();
        data.putInt(key, value);
        this.mService.provideData(userId, data, null, TestableCallbackInternal.m9581$$Nest$mcreateRemoteStatusCallback(sTestableCallbackInternal));
        return 0;
    }

    private int getLastStatusCode() {
        Slog.d(TAG, "getLastStatusCode");
        PrintWriter resultPrinter = getOutPrintWriter();
        int lastStatus = sTestableCallbackInternal.getLastStatus();
        resultPrinter.println(lastStatus);
        return 0;
    }

    private int setTemporaryService() {
        PrintWriter out = getOutPrintWriter();
        int userId = Integer.parseInt(getNextArgRequired());
        String serviceName = getNextArg();
        if (serviceName != null) goto L6;
        this.mService.resetTemporaryService(userId);
        out.println("WearableSensingManagerService temporary reset. ");
        return 0;
    L6:
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryService(userId, serviceName, duration);
        out.println("WearableSensingService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int getBoundPackageName() {
        PrintWriter resultPrinter = getOutPrintWriter();
        int userId = Integer.parseInt(getNextArgRequired());
        ComponentName componentName = this.mService.getComponentName(userId);
        if (componentName != null) goto L5;
        String r3 = "";
    L6:
        resultPrinter.println(r3);
        return 0;
    L5:
        r3 = componentName.getPackageName();
        goto L6
    }

    private int setDataRequestRateLimitWindowSize() {
        Slog.d(TAG, "setDataRequestRateLimitWindowSize");
        int windowSizeSeconds = Integer.parseInt(getNextArgRequired());
        if (windowSizeSeconds > 0) goto L6;
        this.mService.resetDataRequestRateLimitWindowSize();
        return 0;
    L6:
        if (windowSizeSeconds >= 20) goto L8;
        windowSizeSeconds = 20;
    L8:
        this.mService.setDataRequestRateLimitWindowSize(Duration.ofSeconds(windowSizeSeconds));
        return 0;
    }
}
