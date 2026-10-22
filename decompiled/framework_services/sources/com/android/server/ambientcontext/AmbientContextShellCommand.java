package com.android.server.ambientcontext;

import android.app.ambientcontext.AmbientContextEvent;
import android.app.ambientcontext.AmbientContextEventRequest;
import android.app.ambientcontext.IAmbientContextObserver;
import android.content.ComponentName;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteCallback;
import android.os.ShellCommand;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AmbientContextShellCommand extends ShellCommand {
    private static final AmbientContextEventRequest MIXED_REQUEST = null;
    private static final AmbientContextEventRequest REQUEST = null;
    private static final String TAG = null;
    private static final int WEARABLE_AMBIENT_CONTEXT_EVENT_FOR_TESTING = 100001;
    private static final AmbientContextEventRequest WEARABLE_REQUEST = null;
    static final TestableCallbackInternal sTestableCallbackInternal = null;
    private final AmbientContextManagerService mService;

    static class TestableCallbackInternal {
        private List<AmbientContextEvent> mLastEvents;
        private int mLastStatus;

        public static /* synthetic */ void $r8$lambda$a2GN4tJFzpJpzv_HV7BMUy0RzQc(TestableCallbackInternal r0, Bundle r1) {
            r0.lambda$createRemoteStatusCallback$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLastEvents, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1611$$Nest$fputmLastEvents(TestableCallbackInternal r0, List r1) {
            r0.mLastEvents = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLastStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1612$$Nest$fputmLastStatus(TestableCallbackInternal r0, int r1) {
            r0.mLastStatus = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mcreateAmbientContextObserver, reason: not valid java name */
        static /* bridge */ /* synthetic */ IAmbientContextObserver m1613$$Nest$mcreateAmbientContextObserver(TestableCallbackInternal r0) {
            return r0.createAmbientContextObserver();
        }

        /* JADX INFO: renamed from: -$$Nest$mcreateRemoteStatusCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ RemoteCallback m1614$$Nest$mcreateRemoteStatusCallback(TestableCallbackInternal r0) {
            return r0.createRemoteStatusCallback();
        }

        TestableCallbackInternal() {
        }

        public List<AmbientContextEvent> getLastEvents() {
            return this.mLastEvents;
        }

        public int getLastStatus() {
            return this.mLastStatus;
        }

        private IAmbientContextObserver createAmbientContextObserver() {
            return new AnonymousClass1(this);
        }

        private RemoteCallback createRemoteStatusCallback() {
            return new RemoteCallback(new AmbientContextShellCommand$TestableCallbackInternal$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$createRemoteStatusCallback$0(Bundle result) {
            int status = result.getInt("android.app.ambientcontext.AmbientContextStatusBundleKey");
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
        TAG = AmbientContextShellCommand.class.getSimpleName();
        REQUEST = new AmbientContextEventRequest.Builder().addEventType(1).addEventType(2).addEventType(3).build();
        WEARABLE_REQUEST = new AmbientContextEventRequest.Builder().addEventType(WEARABLE_AMBIENT_CONTEXT_EVENT_FOR_TESTING).build();
        MIXED_REQUEST = new AmbientContextEventRequest.Builder().addEventType(1).addEventType(WEARABLE_AMBIENT_CONTEXT_EVENT_FOR_TESTING).build();
        sTestableCallbackInternal = new TestableCallbackInternal();
    }

    AmbientContextShellCommand(AmbientContextManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -2084150080: goto L39;
            case -2048517510: goto L36;
            case -1827236351: goto L33;
            case -920381716: goto L30;
            case -919702712: goto L27;
            case -108354651: goto L24;
            case 943496953: goto L21;
            case 1104883342: goto L18;
            case 1519475119: goto L15;
            case 2018305992: goto L12;
            case 2084757210: goto L9;
            default: goto L41;
        };
    L41:
        byte r0 = -1;
    L42:
        switch(r0) {
            case 0: goto L66;
            case 1: goto L64;
            case 2: goto L62;
            case 3: goto L60;
            case 4: goto L58;
            case 5: goto L56;
            case 6: goto L54;
            case 7: goto L52;
            case 8: goto L50;
            case 9: goto L48;
            case 10: goto L46;
            default: goto L44;
        };
    L44:
        return handleDefaultCommands(cmd);
    L46:
        return setTemporaryServices();
    L48:
        return setTemporaryService();
    L50:
        return getBoundPackageName();
    L52:
        return runQueryMixedServiceStatus();
    L54:
        return runQueryWearableServiceStatus();
    L56:
        return runQueryServiceStatus();
    L58:
        return getLastStatusCode();
    L60:
        return runStopDetection();
    L62:
        return runMixedStartDetection();
    L64:
        return runWearableStartDetection();
    L66:
        return runStartDetection();
    L9:
        if (cmd.equals("start-detection") == false) goto L41;
        r0 = 0;
        goto L42
    L12:
        if (cmd.equals("get-last-status-code") == false) goto L41;
        r0 = 4;
        goto L42
    L15:
        if (cmd.equals("query-service-status") == false) goto L41;
        r0 = 5;
        goto L42
    L18:
        if (cmd.equals("set-temporary-service") == false) goto L41;
        r0 = 9;
        goto L42
    L21:
        if (cmd.equals("query-wearable-service-status") == false) goto L41;
        r0 = 6;
        goto L42
    L24:
        if (cmd.equals("set-temporary-services") == false) goto L41;
        r0 = 10;
        goto L42
    L27:
        if (cmd.equals("start-detection-mixed") == false) goto L41;
        r0 = 2;
        goto L42
    L30:
        if (cmd.equals("start-detection-wearable") == false) goto L41;
        r0 = 1;
        goto L42
    L33:
        if (cmd.equals("query-mixed-service-status") == false) goto L41;
        r0 = 7;
        goto L42
    L36:
        if (cmd.equals("stop-detection") == false) goto L41;
        r0 = 3;
        goto L42
    L39:
        if (cmd.equals("get-bound-package") == false) goto L41;
        r0 = 8;
        goto L42
    }

    private int runStartDetection() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        this.mService.startDetection(userId, REQUEST, packageName, TestableCallbackInternal.m1613$$Nest$mcreateAmbientContextObserver(sTestableCallbackInternal));
        this.mService.newClientAdded(userId, REQUEST, packageName, TestableCallbackInternal.m1613$$Nest$mcreateAmbientContextObserver(sTestableCallbackInternal));
        return 0;
    }

    private int runWearableStartDetection() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        this.mService.startDetection(userId, WEARABLE_REQUEST, packageName, TestableCallbackInternal.m1613$$Nest$mcreateAmbientContextObserver(sTestableCallbackInternal));
        this.mService.newClientAdded(userId, WEARABLE_REQUEST, packageName, TestableCallbackInternal.m1613$$Nest$mcreateAmbientContextObserver(sTestableCallbackInternal));
        return 0;
    }

    private int runMixedStartDetection() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        this.mService.startDetection(userId, MIXED_REQUEST, packageName, TestableCallbackInternal.m1613$$Nest$mcreateAmbientContextObserver(sTestableCallbackInternal));
        this.mService.newClientAdded(userId, MIXED_REQUEST, packageName, TestableCallbackInternal.m1613$$Nest$mcreateAmbientContextObserver(sTestableCallbackInternal));
        return 0;
    }

    private int runStopDetection() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        this.mService.stopAmbientContextEvent(userId, packageName);
        return 0;
    }

    private int runQueryServiceStatus() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        int[] types = {1, 2};
        this.mService.queryServiceStatus(userId, packageName, types, TestableCallbackInternal.m1614$$Nest$mcreateRemoteStatusCallback(sTestableCallbackInternal));
        return 0;
    }

    private int runQueryWearableServiceStatus() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        int[] types = {WEARABLE_AMBIENT_CONTEXT_EVENT_FOR_TESTING};
        this.mService.queryServiceStatus(userId, packageName, types, TestableCallbackInternal.m1614$$Nest$mcreateRemoteStatusCallback(sTestableCallbackInternal));
        return 0;
    }

    private int runQueryMixedServiceStatus() {
        int userId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArgRequired();
        int[] types = {1, WEARABLE_AMBIENT_CONTEXT_EVENT_FOR_TESTING};
        this.mService.queryServiceStatus(userId, packageName, types, TestableCallbackInternal.m1614$$Nest$mcreateRemoteStatusCallback(sTestableCallbackInternal));
        return 0;
    }

    private int getLastStatusCode() {
        PrintWriter resultPrinter = getOutPrintWriter();
        int lastStatus = sTestableCallbackInternal.getLastStatus();
        resultPrinter.println(lastStatus);
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("AmbientContextEvent commands: ");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  start-detection USER_ID PACKAGE_NAME: Starts AmbientContextEvent detection.");
        pw.println("  start-detection-wearable USER_ID PACKAGE_NAME: Starts AmbientContextEvent detection for wearable.");
        pw.println("  start-detection-mixed USER_ID PACKAGE_NAME:  Starts AmbientContextEvent detection for mixed events.");
        pw.println("  stop-detection USER_ID PACKAGE_NAME: Stops AmbientContextEvent detection.");
        pw.println("  get-last-status-code: Prints the latest request status code.");
        pw.println("  query-service-status USER_ID PACKAGE_NAME: Prints the service status code.");
        pw.println("  query-wearable-service-status USER_ID PACKAGE_NAME: Prints the service status code for wearable.");
        pw.println("  query-mixed-service-status USER_ID PACKAGE_NAME: Prints the service status code for mixed events.");
        pw.println("  get-bound-package USER_ID:     Print the bound package that implements the service.");
        pw.println("  set-temporary-service USER_ID [PACKAGE_NAME] [COMPONENT_NAME DURATION]");
        pw.println("    Temporarily (for DURATION ms) changes the service implementation.");
        pw.println("    To reset, call with just the USER_ID argument.");
        pw.println("  set-temporary-services USER_ID [FIRST_PACKAGE_NAME] [SECOND_PACKAGE_NAME] [COMPONENT_NAME DURATION]");
        pw.println("    Temporarily (for DURATION ms) changes the service implementation.");
        pw.println("    To reset, call with just the USER_ID argument.");
    }

    private int getBoundPackageName() {
        PrintWriter resultPrinter = getOutPrintWriter();
        int userId = Integer.parseInt(getNextArgRequired());
        ComponentName componentName = this.mService.getComponentName(userId, AmbientContextManagerPerUserService.ServiceType.DEFAULT);
        if (componentName != null) goto L5;
        String r3 = "";
    L6:
        resultPrinter.println(r3);
        return 0;
    L5:
        r3 = componentName.getPackageName();
        goto L6
    }

    private int setTemporaryService() {
        PrintWriter out = getOutPrintWriter();
        int userId = Integer.parseInt(getNextArgRequired());
        String serviceName = getNextArg();
        if (serviceName != null) goto L6;
        this.mService.resetTemporaryService(userId);
        out.println("AmbientContextDetectionService temporary reset. ");
        this.mService.setDefaultServiceEnabled(userId, true);
        return 0;
    L6:
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryService(userId, serviceName, duration);
        out.println("AmbientContextDetectionService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int setTemporaryServices() {
        String[] serviceNames = new String[2];
        PrintWriter out = getOutPrintWriter();
        int userId = Integer.parseInt(getNextArgRequired());
        this.mService.setDefaultServiceEnabled(userId, false);
        String firstServiceName = getNextArg();
        String secondServiceName = getNextArg();
        if (firstServiceName == null) goto L8;
        if (secondServiceName == null) goto L8;
        serviceNames[0] = firstServiceName;
        serviceNames[1] = secondServiceName;
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryServices(userId, serviceNames, duration);
        Slog.w(TAG, "AmbientContextDetectionService temporarily set to " + serviceNames[0] + " and " + serviceNames[1] + " for " + duration + "ms");
        out.println("AmbientContextDetectionService temporarily set to " + serviceNames[0] + " and " + serviceNames[1] + " for " + duration + "ms");
        return 0;
    L8:
        this.mService.resetTemporaryService(userId);
        this.mService.setDefaultServiceEnabled(userId, true);
        out.println("AmbientContextDetectionService temporary reset.");
        return 0;
    }
}
