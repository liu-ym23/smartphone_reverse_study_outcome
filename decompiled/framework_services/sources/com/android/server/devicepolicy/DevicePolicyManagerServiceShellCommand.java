package com.android.server.devicepolicy;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.UserHandle;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class DevicePolicyManagerServiceShellCommand extends ShellCommand {
    private static final String CMD_CLEAR_FREEZE_PERIOD_RECORD = "clear-freeze-period-record";
    private static final String CMD_FORCE_NETWORK_LOGS = "force-network-logs";
    private static final String CMD_FORCE_SECURITY_LOGS = "force-security-logs";
    private static final String CMD_IS_SAFE_OPERATION = "is-operation-safe";
    private static final String CMD_IS_SAFE_OPERATION_BY_REASON = "is-operation-safe-by-reason";
    private static final String CMD_LIST_OWNERS = "list-owners";
    private static final String CMD_LIST_POLICY_EXEMPT_APPS = "list-policy-exempt-apps";
    private static final String CMD_MARK_PO_ON_ORG_OWNED_DEVICE = "mark-profile-owner-on-organization-owned-device";
    private static final String CMD_REMOVE_ACTIVE_ADMIN = "remove-active-admin";
    private static final String CMD_SET_ACTIVE_ADMIN = "set-active-admin";
    private static final String CMD_SET_DEVICE_OWNER = "set-device-owner";
    private static final String CMD_SET_PROFILE_OWNER = "set-profile-owner";
    private static final String CMD_SET_SAFE_OPERATION = "set-operation-safe";
    private static final String DO_ONLY_OPTION = "--device-owner-only";
    private static final String PROVISIONING_CONTEXT_OPTION = "--provisioning-context";
    private static final String USER_OPTION = "--user";
    private ComponentName mComponent;
    private String mProvisioningContext;
    private final DevicePolicyManagerService mService;
    private boolean mSetDoOnly;
    private int mUserId;

    DevicePolicyManagerServiceShellCommand(DevicePolicyManagerService service) {
        this.mUserId = 0;
        this.mProvisioningContext = null;
        service.getClass();
        this.mService = service;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.printf("DevicePolicyManager Service (device_policy) commands:\n\n", new Object[0]);     // Catch: Throwable -> L6
        showHelp(pw);     // Catch: Throwable -> L6
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

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        th = move-exception;
        if (pw != null) goto L115;
    L113:
        throw th;
    L115:
        pw.close();     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        th.addSuppressed(th);
        goto L113
    L7:
        switch(cmd.hashCode()) {
            case -2077120112: goto L48;
            case -1819296492: goto L45;
            case -1791908857: goto L42;
            case -1073491921: goto L39;
            case -905136898: goto L36;
            case -898547037: goto L33;
            case -776610703: goto L30;
            case -577127626: goto L27;
            case -536624985: goto L24;
            case 547934547: goto L21;
            case 639813476: goto L18;
            case 1325530298: goto L15;
            case 1509758184: goto L10;
            default: goto L50;
        };     // Catch: Throwable -> L12
    L50:
        byte r1 = -1;
    L51:
        switch(r1) {
            case 0: goto L104;
            case 1: goto L100;
            case 2: goto L96;
            case 3: goto L92;
            case 4: goto L88;
            case 5: goto L84;
            case 6: goto L80;
            case 7: goto L76;
            case 8: goto L72;
            case 9: goto L68;
            case 10: goto L64;
            case 11: goto L60;
            case 12: goto L56;
            default: goto L52;
        };     // Catch: Throwable -> L12
    L52:
        int r2 = onInvalidCommand(pw, cmd);     // Catch: Throwable -> L12
        if (pw == null) goto L55;
        pw.close();
    L55:
        return r2;
    L56:
        int r3 = runMarkProfileOwnerOnOrganizationOwnedDevice(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L59;
        pw.close();
    L59:
        return r3;
    L60:
        int r4 = runForceSecurityLogs(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L63;
        pw.close();
    L63:
        return r4;
    L64:
        int r5 = runForceNetworkLogs(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L67;
        pw.close();
    L67:
        return r5;
    L68:
        int r6 = runClearFreezePeriodRecord(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L71;
        pw.close();
    L71:
        return r6;
    L72:
        int r7 = runRemoveActiveAdmin(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L75;
        pw.close();
    L75:
        return r7;
    L76:
        int r8 = runSetProfileOwner(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L79;
        pw.close();
    L79:
        return r8;
    L80:
        int r9 = runSetDeviceOwner(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L83;
        pw.close();
    L83:
        return r9;
    L84:
        int r10 = runSetActiveAdmin(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L87;
        pw.close();
    L87:
        return r10;
    L88:
        int r11 = runListPolicyExemptApps(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L91;
        pw.close();
    L91:
        return r11;
    L92:
        int r12 = runListOwners(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L95;
        pw.close();
    L95:
        return r12;
    L96:
        int r13 = runSetSafeOperation(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L99;
        pw.close();
    L99:
        return r13;
    L100:
        int r14 = runIsSafeOperationByReason(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L103;
        pw.close();
    L103:
        return r14;
    L104:
        int r15 = runIsSafeOperation(pw);     // Catch: Throwable -> L12
        if (pw == null) goto L107;
        pw.close();
    L107:
        return r15;
    L10:
        if (cmd.equals(CMD_MARK_PO_ON_ORG_OWNED_DEVICE) == false) goto L50;
        r1 = 12;
        goto L51
    L15:
        if (cmd.equals(CMD_FORCE_SECURITY_LOGS) == false) goto L50;
        r1 = 11;
        goto L51
    L18:
        if (cmd.equals(CMD_SET_PROFILE_OWNER) == false) goto L50;
        r1 = 7;
        goto L51
    L21:
        if (cmd.equals(CMD_SET_ACTIVE_ADMIN) == false) goto L50;
        r1 = 5;
        goto L51
    L24:
        if (cmd.equals(CMD_CLEAR_FREEZE_PERIOD_RECORD) == false) goto L50;
        r1 = 9;
        goto L51
    L27:
        if (cmd.equals(CMD_IS_SAFE_OPERATION) == false) goto L50;
        r1 = 0;
        goto L51
    L30:
        if (cmd.equals(CMD_REMOVE_ACTIVE_ADMIN) == false) goto L50;
        r1 = 8;
        goto L51
    L33:
        if (cmd.equals(CMD_IS_SAFE_OPERATION_BY_REASON) == false) goto L50;
        r1 = 1;
        goto L51
    L36:
        if (cmd.equals(CMD_SET_SAFE_OPERATION) == false) goto L50;
        r1 = 2;
        goto L51
    L39:
        if (cmd.equals(CMD_LIST_OWNERS) == false) goto L50;
        r1 = 3;
        goto L51
    L42:
        if (cmd.equals(CMD_SET_DEVICE_OWNER) == false) goto L50;
        r1 = 6;
        goto L51
    L45:
        if (cmd.equals(CMD_LIST_POLICY_EXEMPT_APPS) == false) goto L50;
        r1 = 4;
        goto L51
    L48:
        if (cmd.equals(CMD_FORCE_NETWORK_LOGS) == false) goto L50;
        r1 = 10;
        goto L51
    L4:
        return handleDefaultCommands(cmd);
    }

    private int onInvalidCommand(PrintWriter pw, String cmd) {
        if (super.handleDefaultCommands(cmd) != 0) goto L5;
        return 0;
    L5:
        pw.printf("Usage: \n", new Object[0]);
        showHelp(pw);
        return -1;
    }

    private void showHelp(PrintWriter pw) {
        pw.printf("  help\n", new Object[0]);
        pw.printf("    Prints this help text.\n\n", new Object[0]);
        pw.printf("  %s <OPERATION_ID>\n", new Object[]{CMD_IS_SAFE_OPERATION});
        pw.printf("    Checks if the give operation is safe \n\n", new Object[0]);
        pw.printf("  %s <REASON_ID>\n", new Object[]{CMD_IS_SAFE_OPERATION_BY_REASON});
        pw.printf("    Checks if the operations are safe for the given reason\n\n", new Object[0]);
        pw.printf("  %s <OPERATION_ID> <REASON_ID>\n", new Object[]{CMD_SET_SAFE_OPERATION});
        pw.printf("    Emulates the result of the next call to check if the given operation is safe \n\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{CMD_LIST_OWNERS});
        pw.printf("    Lists the device / profile owners per user \n\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{CMD_LIST_POLICY_EXEMPT_APPS});
        pw.printf("    Lists the apps that are exempt from policies\n\n", new Object[0]);
        pw.printf("  %s [ %s <USER_ID> | current ] [ %s <PROVISIONING_CONTEXT>] <COMPONENT>\n", new Object[]{CMD_SET_ACTIVE_ADMIN, USER_OPTION, PROVISIONING_CONTEXT_OPTION});
        pw.printf("    Sets the given component as active admin for an existing user.\n\n", new Object[0]);
        pw.printf("  %s [ %s <USER_ID> | current *EXPERIMENTAL* ] [ %s ] [ %s <PROVISIONING_CONTEXT>] <COMPONENT>\n", new Object[]{CMD_SET_DEVICE_OWNER, USER_OPTION, DO_ONLY_OPTION, PROVISIONING_CONTEXT_OPTION});
        pw.printf("    Sets the given component as active admin, and its package as device owner.\n\n", new Object[0]);
        pw.printf("  %s [ %s <USER_ID> | current ] [ %s <PROVISIONING_CONTEXT>] <COMPONENT>\n", new Object[]{CMD_SET_PROFILE_OWNER, USER_OPTION, PROVISIONING_CONTEXT_OPTION});
        pw.printf("    Sets the given component as active admin and profile owner for an existing user.\n\n", new Object[0]);
        pw.printf("  %s [ %s <USER_ID> | current ] <COMPONENT>\n", new Object[]{CMD_REMOVE_ACTIVE_ADMIN, USER_OPTION});
        pw.printf("    Disables an active admin, the admin must have declared android:testOnly in the application in its manifest. This will also remove device and profile owners.\n\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{CMD_CLEAR_FREEZE_PERIOD_RECORD});
        pw.printf("    Clears framework-maintained record of past freeze periods that the device went through. For use during feature development to prevent triggering restriction on setting freeze periods.\n\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{CMD_FORCE_NETWORK_LOGS});
        pw.printf("    Makes all network logs available to the DPC and triggers DeviceAdminReceiver.onNetworkLogsAvailable() if needed.\n\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{CMD_FORCE_SECURITY_LOGS});
        pw.printf("    Makes all security logs available to the DPC and triggers DeviceAdminReceiver.onSecurityLogsAvailable() if needed.\n\n", new Object[0]);
        pw.printf("  %s [ %s <USER_ID> | current ] <COMPONENT>\n", new Object[]{CMD_MARK_PO_ON_ORG_OWNED_DEVICE, USER_OPTION});
        pw.printf("    Marks the profile owner of the given user as managing an organization-owneddevice. That will give it access to device identifiers (such as serial number, IMEI and MEID), as well as other privileges.\n\n", new Object[0]);
    }

    private int runIsSafeOperation(PrintWriter pw) {
        int operation = Integer.parseInt(getNextArgRequired());
        int reason = this.mService.getUnsafeOperationReason(operation);
        if (reason != (-1)) goto L5;
        boolean safe = true;
    L6:
        pw.printf("Operation %s is %s. Reason: %s\n", new Object[]{DevicePolicyManager.operationToString(operation), safeToString(safe), DevicePolicyManager.operationSafetyReasonToString(reason)});
        return 0;
    L5:
        safe = false;
        goto L6
    }

    private int runIsSafeOperationByReason(PrintWriter pw) {
        int reason = Integer.parseInt(getNextArgRequired());
        boolean safe = this.mService.isSafeOperation(reason);
        pw.printf("Operations affected by %s are %s\n", new Object[]{DevicePolicyManager.operationSafetyReasonToString(reason), safeToString(safe)});
        return 0;
    }

    private static String safeToString(boolean safe) {
        if (safe == false) goto L4;
        return "SAFE";
    L4:
        return "UNSAFE";
    }

    private int runSetSafeOperation(PrintWriter pw) {
        int operation = Integer.parseInt(getNextArgRequired());
        int reason = Integer.parseInt(getNextArgRequired());
        this.mService.setNextOperationSafety(operation, reason);
        pw.printf("Next call to check operation %s will return %s\n", new Object[]{DevicePolicyManager.operationToString(operation), DevicePolicyManager.operationSafetyReasonToString(reason)});
        return 0;
    }

    private int printAndGetSize(PrintWriter pw, Collection<?> collection, String nameOnSingular) {
        if (collection.isEmpty() == false) goto L6;
        pw.printf("no %ss\n", new Object[]{nameOnSingular});
        return 0;
    L6:
        int size = collection.size();
        Integer r1 = Integer.valueOf(size);
        if (size != 1) goto L9;
        String r2 = "";
    L10:
        pw.printf("%d %s%s:\n", new Object[]{r1, nameOnSingular, r2});
        return size;
    L9:
        r2 = "s";
        goto L10
    }

    private int runListOwners(PrintWriter pw) {
        List<OwnerShellData> owners = this.mService.listAllOwners();
        int size = printAndGetSize(pw, owners, "owner");
        if (size != 0) goto L5;
        return 0;
    L5:
        int i = 0;
    L6:
        if (i >= size) goto L21;
        OwnerShellData owner = owners.get(i);
        pw.printf("User %2d: admin=%s", new Object[]{Integer.valueOf(owner.userId), owner.admin.flattenToShortString()});
        if (owner.isDeviceOwner == false) goto L11;
        pw.print(",DeviceOwner");
    L11:
        if (owner.isProfileOwner == false) goto L14;
        pw.print(",ProfileOwner");
    L14:
        if (owner.isManagedProfileOwner == false) goto L17;
        pw.printf(",ManagedProfileOwner(parentUserId=%d)", new Object[]{Integer.valueOf(owner.parentUserId)});
    L17:
        if (owner.isAffiliated == false) goto L19;
        pw.print(",Affiliated");
    L19:
        pw.println();
        i = i + 1;
        goto L6
    L21:
        return 0;
    }

    private int runListPolicyExemptApps(PrintWriter pw) {
        List<String> apps = this.mService.listPolicyExemptApps();
        int size = printAndGetSize(pw, apps, "policy exempt app");
        if (size != 0) goto L5;
        return 0;
    L5:
        int i = 0;
    L6:
        if (i >= size) goto L9;
        String app = apps.get(i);
        pw.printf("  %d: %s\n", new Object[]{Integer.valueOf(i), app});
        i = i + 1;
        goto L6
    L9:
        return 0;
    }

    private int runSetActiveAdmin(PrintWriter pw) {
        parseArgs();
        this.mService.setActiveAdmin(this.mComponent, true, this.mUserId, this.mProvisioningContext);
        pw.printf("Success: Active admin set to component %s\n", new Object[]{this.mComponent.flattenToShortString()});
        return 0;
    }

    private int runSetDeviceOwner(PrintWriter pw) {
        parseArgs();
        boolean isAdminAdded = false;
        this.mService.setActiveAdmin(this.mComponent, false, this.mUserId, this.mProvisioningContext);     // Catch: IllegalArgumentException -> L5
        isAdminAdded = true;
    L23:
        DevicePolicyManagerService r2 = this.mService;     // Catch: Exception -> L17
        ComponentName r3 = this.mComponent;     // Catch: Exception -> L17
        int r4 = this.mUserId;     // Catch: Exception -> L17
        if (this.mSetDoOnly == true) goto L10;
        boolean r5 = true;
    L12:
        if (r2.setDeviceOwner(r3, r4, r5) == false) goto L16;
        this.mService.setUserProvisioningState(3, this.mUserId);
        pw.printf("Success: Device owner set to package %s\n", new Object[]{this.mComponent.flattenToShortString()});
        pw.printf("Active admin set to component %s\n", new Object[]{this.mComponent.flattenToShortString()});
        return 0;
    L16:
        throw new RuntimeException("Can't set package " + this.mComponent + " as device owner.");     // Catch: Exception -> L17
    L10:
        r5 = false;
    L17:
        e = move-exception;
        if (isAdminAdded == false) goto L20;
        this.mService.removeActiveAdmin(this.mComponent, this.mUserId);
    L20:
        throw e;
    L6:
        pw.printf("%s was already an admin for user %d. No need to set it again.\n", new Object[]{this.mComponent.flattenToShortString(), Integer.valueOf(this.mUserId)});
        goto L23
    }

    private int runRemoveActiveAdmin(PrintWriter pw) {
        parseArgs();
        this.mService.forceRemoveActiveAdmin(this.mComponent, this.mUserId);
        pw.printf("Success: Admin removed %s\n", new Object[]{this.mComponent});
        return 0;
    }

    private int runSetProfileOwner(PrintWriter pw) {
        parseArgs();
        this.mService.setActiveAdmin(this.mComponent, true, this.mUserId, this.mProvisioningContext);
    L9:
        e = move-exception;
        this.mService.removeActiveAdmin(this.mComponent, this.mUserId);
        throw e;
    L4:
        if (this.mService.setProfileOwner(this.mComponent, this.mUserId) == false) goto L8;
        this.mService.setUserProvisioningState(3, this.mUserId);
        pw.printf("Success: Active admin and profile owner set to %s for user %d\n", new Object[]{this.mComponent.flattenToShortString(), Integer.valueOf(this.mUserId)});
        return 0;
    L8:
        throw new RuntimeException("Can't set component " + this.mComponent.flattenToShortString() + " as profile owner for user " + this.mUserId);     // Catch: Exception -> L9
    }

    private int runClearFreezePeriodRecord(PrintWriter pw) {
        this.mService.clearSystemUpdatePolicyFreezePeriodRecord();
        pw.printf("Success\n", new Object[0]);
        return 0;
    }

    private int runForceNetworkLogs(PrintWriter pw) {
    L2:
        long toWait = this.mService.forceNetworkLogs();
        if (toWait == 0) goto L4;
        pw.printf("We have to wait for %d milliseconds...\n", new Object[]{Long.valueOf(toWait)});
        SystemClock.sleep(toWait);
        goto L2
    L4:
        pw.printf("Success\n", new Object[0]);
        return 0;
    }

    private int runForceSecurityLogs(PrintWriter pw) {
    L2:
        long toWait = this.mService.forceSecurityLogs();
        if (toWait == 0) goto L4;
        pw.printf("We have to wait for %d milliseconds...\n", new Object[]{Long.valueOf(toWait)});
        SystemClock.sleep(toWait);
        goto L2
    L4:
        pw.printf("Success\n", new Object[0]);
        return 0;
    }

    private int runMarkProfileOwnerOnOrganizationOwnedDevice(PrintWriter pw) {
        parseArgs();
        this.mService.setProfileOwnerOnOrganizationOwnedDevice(this.mComponent, this.mUserId, true);
        pw.printf("Success\n", new Object[0]);
        return 0;
    }

    private void parseArgs() {
    L2:
        String opt = getNextOption();
        if (opt == null) goto L18;
        if (USER_OPTION.equals(opt) == true) goto L6;
        if (DO_ONLY_OPTION.equals(opt) == true) goto L12;
        if (PROVISIONING_CONTEXT_OPTION.equals(opt) == false) goto L17;
        this.mProvisioningContext = getNextArgRequired();
        goto L2
    L17:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L12:
        this.mSetDoOnly = true;
        goto L2
    L6:
        String arg = getNextArgRequired();
        this.mUserId = UserHandle.parseUserArg(arg);
        if (this.mUserId != (-2)) goto L2;
        this.mUserId = ActivityManager.getCurrentUser();
        goto L2
    L18:
        this.mComponent = parseComponentName(getNextArgRequired());
    }

    private ComponentName parseComponentName(String component) {
        ComponentName cn = ComponentName.unflattenFromString(component);
        if (cn == null) goto L6;
        return cn;
    L6:
        throw new IllegalArgumentException("Invalid component " + component);
    }
}
