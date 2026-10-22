package com.android.server.accessibility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import android.os.ShellCommand;
import android.os.UserHandle;
import com.android.server.LocalServices;
import com.android.server.wm.WindowManagerInternal;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class AccessibilityShellCommand extends ShellCommand {
    final Context mContext;
    final AccessibilityManagerService mService;
    final SystemActionPerformer mSystemActionPerformer;
    final WindowManagerInternal mWindowManagerService;

    AccessibilityShellCommand(Context context, AccessibilityManagerService service, SystemActionPerformer systemActionPerformer) {
        this.mContext = context;
        this.mService = service;
        this.mSystemActionPerformer = systemActionPerformer;
        this.mWindowManagerService = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -1659822550: goto L24;
            case -859068373: goto L21;
            case 789489311: goto L18;
            case 1340897306: goto L15;
            case 1748820581: goto L12;
            case 1857979322: goto L9;
            default: goto L26;
        };
    L26:
        byte r0 = -1;
    L27:
        switch(r0) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L32;
            case 5: goto L30;
            default: goto L28;
        };
    L28:
        return -1;
    L30:
        return checkHidraw();
    L32:
        return this.mService.getTraceManager().onShellCommand(cmd, this);
    L34:
        return runCallSystemAction();
    L36:
        return runSetBindInstantServiceAllowed();
    L38:
        return runGetBindInstantServiceAllowed();
    L9:
        if (cmd.equals("stop-trace") == false) goto L39;
        r0 = 4;
        goto L27
    L39:
        r0 = -1;
        goto L27
    L12:
        if (cmd.equals("call-system-action") == false) goto L40;
        r0 = 2;
        goto L27
    L40:
        r0 = -1;
        goto L27
    L15:
        if (cmd.equals("start-trace") == false) goto L41;
        r0 = 3;
        goto L27
    L41:
        r0 = -1;
        goto L27
    L18:
        if (cmd.equals("set-bind-instant-service-allowed") == false) goto L42;
        r0 = 1;
        goto L27
    L42:
        r0 = -1;
        goto L27
    L21:
        if (cmd.equals("get-bind-instant-service-allowed") == false) goto L43;
        r0 = 0;
        goto L27
    L43:
        r0 = -1;
        goto L27
    L24:
        if (cmd.equals("check-hidraw") == false) goto L44;
        r0 = 5;
        goto L27
    L44:
        r0 = -1;
        goto L27
    }

    private int runGetBindInstantServiceAllowed() {
        Integer userId = parseUserId();
        if (userId != null) goto L6;
        return -1;
    L6:
        getOutPrintWriter().println(Boolean.toString(this.mService.getBindInstantServiceAllowed(userId.intValue())));
        return 0;
    }

    private int runSetBindInstantServiceAllowed() {
        Integer userId = parseUserId();
        if (userId != null) goto L5;
        return -1;
    L5:
        String allowed = getNextArgRequired();
        if (allowed != null) goto L9;
        getErrPrintWriter().println("Error: no true/false specified");
        return -1;
    L9:
        this.mService.setBindInstantServiceAllowed(userId.intValue(), Boolean.parseBoolean(allowed));
        return 0;
    }

    private int runCallSystemAction() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
    L9:
        String option = getNextArg();
        if (option == null) goto L13;
        int actionId = Integer.parseInt(option);
        this.mSystemActionPerformer.performSystemAction(actionId);
        return 0;
    L13:
        return -1;
    L5:
        if (callingUid == 1000) goto L9;
        if (callingUid == 2000) goto L9;
        return -1;
    }

    private int checkHidraw() {
        this.mContext.enforceCallingPermission("android.permission.MANAGE_ACCESSIBILITY", "Missing MANAGE_ACCESSIBILITY permission");
        String subcommand = getNextArgRequired();
        File hidrawNode = new File(getNextArgRequired());
        switch(subcommand.hashCode()) {
            case -748366993: goto L12;
            case 3496342: goto L9;
            case 113399775: goto L6;
            default: goto L14;
        };
    L14:
        byte r2 = -1;
    L15:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            default: goto L16;
        };
    L16:
        getErrPrintWriter().print("Unknown subcommand " + subcommand);
        return -1;
    L19:
        return checkHidrawDescriptor(hidrawNode);
    L21:
        return checkHidrawWrite(hidrawNode);
    L23:
        return checkHidrawRead(hidrawNode);
    L6:
        if (subcommand.equals("write") == false) goto L24;
        r2 = 1;
        goto L15
    L24:
        r2 = -1;
        goto L15
    L9:
        if (subcommand.equals("read") == false) goto L25;
        r2 = 0;
        goto L15
    L25:
        r2 = -1;
        goto L15
    L12:
        if (subcommand.equals("descriptor") == false) goto L26;
        r2 = 2;
        goto L15
    L26:
        r2 = -1;
        goto L15
    }

    private int checkHidrawRead(File hidrawNode) {
        if (hidrawNode.canRead() == true) goto L6;
        getErrPrintWriter().println("Unable to read from " + hidrawNode);
        return -1;
    L6:
        getOutPrintWriter().print(hidrawNode.getAbsolutePath());
        return 0;
    }

    private int checkHidrawWrite(File hidrawNode) {
        if (hidrawNode.canWrite() == true) goto L6;
        getErrPrintWriter().println("Unable to write to " + hidrawNode);
        return -1;
    L6:
        getOutPrintWriter().print(hidrawNode.getAbsolutePath());
        return 0;
    }

    private int checkHidrawDescriptor(File hidrawNode) {
        BrailleDisplayConnection.BrailleDisplayScanner scanner = BrailleDisplayConnection.createScannerForShell();
        byte[] descriptor = scanner.getDeviceReportDescriptor(hidrawNode.toPath());
        if (descriptor != null) goto L12;
        getErrPrintWriter().println("Unable to read descriptor for " + hidrawNode);
        return -1;
    L12:
        getRawOutputStream().write(descriptor);     // Catch: IOException -> L9
        return 0;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private Integer parseUserId() {
        String option = getNextOption();
        if (option == null) goto L11;
        if (option.equals("--user") == true) goto L7;
        getErrPrintWriter().println("Unknown option: " + option);
        return null;
    L7:
        return Integer.valueOf(UserHandle.parseUserArg(getNextArgRequired()));
    L11:
        return Integer.valueOf(ActivityManager.getCurrentUser());
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Accessibility service (accessibility) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  set-bind-instant-service-allowed [--user <USER_ID>] true|false ");
        pw.println("    Set whether binding to services provided by instant apps is allowed.");
        pw.println("  get-bind-instant-service-allowed [--user <USER_ID>]");
        pw.println("    Get whether binding to services provided by instant apps is allowed.");
        pw.println("  call-system-action <ACTION_ID>");
        pw.println("    Calls the system action with the given action id.");
        pw.println("  check-hidraw [read|write|descriptor] <HIDRAW_NODE_PATH>");
        pw.println("    Checks if the system can perform various actions on the HIDRAW node.");
        this.mService.getTraceManager().onHelp(pw);
    }
}
