package com.android.server.rotationresolver;

import android.content.ComponentName;
import android.os.ShellCommand;
import android.rotationresolver.RotationResolverInternal;
import android.service.rotationresolver.RotationResolutionRequest;
import com.android.server.ISmtResourceControl;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
final class RotationResolverShellCommand extends ShellCommand {
    private static final int INITIAL_RESULT_CODE = -1;
    static final TestableRotationCallbackInternal sTestableRotationCallbackInternal = null;
    private final RotationResolverManagerService mService;

    static class TestableRotationCallbackInternal implements RotationResolverInternal.RotationResolverCallbackInternal {
        private int mLastCallbackResultCode;

        TestableRotationCallbackInternal() {
            this.mLastCallbackResultCode = -1;
        }

        public void onSuccess(int result) {
            this.mLastCallbackResultCode = result;
        }

        public void onFailure(int error) {
            this.mLastCallbackResultCode = error;
        }

        public void reset() {
            this.mLastCallbackResultCode = -1;
        }

        public int getLastCallbackCode() {
            return this.mLastCallbackResultCode;
        }
    }

    RotationResolverShellCommand(RotationResolverManagerService service) {
        this.mService = service;
    }

    static {
        sTestableRotationCallbackInternal = new TestableRotationCallbackInternal();
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -2084150080: goto L18;
            case 384662079: goto L15;
            case 1104883342: goto L12;
            case 1820466124: goto L9;
            default: goto L20;
        };
    L20:
        byte r0 = -1;
    L21:
        switch(r0) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        return handleDefaultCommands(cmd);
    L25:
        return setTemporaryService();
    L27:
        return getBoundPackageName();
    L29:
        return getLastResolution();
    L31:
        return runResolveRotation();
    L9:
        if (cmd.equals("get-last-resolution") == false) goto L20;
        r0 = 1;
        goto L21
    L12:
        if (cmd.equals("set-temporary-service") == false) goto L20;
        r0 = 3;
        goto L21
    L15:
        if (cmd.equals("resolve-rotation") == false) goto L20;
        r0 = 0;
        goto L21
    L18:
        if (cmd.equals("get-bound-package") == false) goto L20;
        r0 = 2;
        goto L21
    }

    private int getBoundPackageName() {
        PrintWriter out = getOutPrintWriter();
        int userId = Integer.parseInt(getNextArgRequired());
        ComponentName componentName = this.mService.getComponentNameShellCommand(userId);
        if (componentName != null) goto L5;
        String r3 = "";
    L6:
        out.println(r3);
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
        out.println("RotationResolverService temporary reset. ");
        return 0;
    L6:
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryService(userId, serviceName, duration);
        out.println("RotationResolverService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int runResolveRotation() {
        int userId = Integer.parseInt(getNextArgRequired());
        RotationResolutionRequest request = new RotationResolutionRequest("", 0, 0, true, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
        this.mService.resolveRotationShellCommand(userId, sTestableRotationCallbackInternal, request);
        return 0;
    }

    private int getLastResolution() {
        PrintWriter out = getOutPrintWriter();
        out.println(sTestableRotationCallbackInternal.getLastCallbackCode());
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Rotation Resolver commands: ");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  resolve-rotation USER_ID: request a rotation resolution.");
        pw.println("  get-last-resolution: show the last rotation resolution result.");
        pw.println("  get-bound-package USER_ID:");
        pw.println("    Print the bound package that implements the service.");
        pw.println("  set-temporary-service USER_ID [COMPONENT_NAME DURATION]");
        pw.println("    Temporarily (for DURATION ms) changes the service implementation.");
        pw.println("    To reset, call with just the USER_ID argument.");
    }
}
