package com.android.server.pm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.IActivityManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.LocalServices;
import com.android.server.UiThread;
import com.android.server.input.KeyboardMetricsCollector;
import com.android.server.power.ShutdownThread;
import com.android.server.utils.Slogf;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UserManagerServiceShellCommand extends ShellCommand {
    private static final String LOG_TAG = "UserManagerServiceShellCommand";
    private final Context mContext;
    private final LockPatternUtils mLockPatternUtils;
    private final UserManagerService mService;
    private final UserSystemPackageInstaller mSystemPackageInstaller;

    public static /* synthetic */ void $r8$lambda$hoyxLnyq522ZTdCgpQjg0pEm61U() {
        lambda$runSetSystemUserModeEmulation$0();
    }

    UserManagerServiceShellCommand(UserManagerService service, UserSystemPackageInstaller userSystemPackageInstaller, LockPatternUtils lockPatternUtils, Context context) {
        this.mService = service;
        this.mSystemPackageInstaller = userSystemPackageInstaller;
        this.mLockPatternUtils = lockPatternUtils;
        this.mContext = context;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("User manager (user) commands:");
        pw.println("  help");
        pw.println("    Prints this help text.");
        pw.println();
        pw.println("  list [-v | --verbose] [--all]");
        pw.println("    Prints all users on the system.");
        pw.println();
        pw.println("  report-system-user-package-whitelist-problems [-v | --verbose] [--critical-only] [--mode MODE]");
        pw.println("    Reports all issues on user-type package allowlist XML files. Options:");
        pw.println("    -v | --verbose: shows extra info, like number of issues");
        pw.println("    --critical-only: show only critical issues, excluding warnings");
        pw.println("    --mode MODE: shows what errors would be if device used mode MODE");
        pw.println("      (where MODE is the allowlist mode integer as defined by config_userTypePackageWhitelistMode)");
        pw.println();
        pw.println("  set-system-user-mode-emulation [--reboot | --no-restart] <headless | full | default>");
        pw.println("    Changes whether the system user is headless, full, or default (as defined by OEM).");
        pw.println("    WARNING: this command is meant just for development and debugging purposes.");
        pw.println("             It should NEVER be used on automated tests.");
        pw.println("    NOTE: by default it restarts the Android runtime, unless called with");
        pw.println("          --reboot (which does a full reboot) or");
        pw.println("          --no-restart (which requires a manual restart)");
        pw.println();
        pw.println("  is-headless-system-user-mode [-v | --verbose]");
        pw.println("    Checks whether the device uses headless system user mode.");
        pw.println("  is-visible-background-users-on-default-display-supported [-v | --verbose]");
        pw.println("    Checks whether the device allows users to be start visible on background in the default display.");
        pw.println("    It returns the effective mode, even when using emulation");
        pw.println("    (to get the real mode as well, use -v or --verbose)");
        pw.println();
        pw.println("  is-visible-background-users-supported [-v | --verbose]");
        pw.println("    Checks whether the device allows users to be start visible on background.");
        pw.println("    It returns the effective mode, even when using emulation");
        pw.println("    (to get the real mode as well, use -v or --verbose)");
        pw.println();
        pw.println("  is-user-visible [--display DISPLAY_ID] <USER_ID>");
        pw.println("    Checks if the given user is visible in the given display.");
        pw.println("    If the display option is not set, it uses the user's context to check");
        pw.println("    (so it emulates what apps would get from UserManager.isUserVisible())");
        pw.println();
        pw.println("  get-main-user ");
        pw.println("    Displays main user id or message if there is no main user");
        pw.println();
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L67;
        return handleDefaultCommands(null);
    L67:
    L12:
        e = move-exception;
        getOutPrintWriter().println("Remote exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -1698126264: goto L39;
            case -66900680: goto L36;
            case 3322014: goto L33;
            case 340621931: goto L30;
            case 681635871: goto L27;
            case 980857487: goto L24;
            case 1085270974: goto L21;
            case 1453420968: goto L18;
            case 1605325659: goto L15;
            case 1802440755: goto L10;
            default: goto L41;
        };     // Catch: RemoteException -> L12
    L41:
        byte r1 = -1;
    L42:
        switch(r1) {
            case 0: goto L64;
            case 1: goto L62;
            case 2: goto L60;
            case 3: goto L58;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L52;
            case 7: goto L50;
            case 8: goto L48;
            case 9: goto L46;
            default: goto L44;
        };     // Catch: RemoteException -> L12
    L44:
        return handleDefaultCommands(cmd);
    L46:
        return isMainUserPermanentAdmin();
    L48:
        return canSwitchToHeadlessSystemUser();
    L50:
        return runGetMainUserId();
    L52:
        return runIsUserVisible();
    L54:
        return runIsVisibleBackgroundUserOnDefaultDisplaySupported();
    L56:
        return runIsVisibleBackgroundUserSupported();
    L58:
        return runIsHeadlessSystemUserMode();
    L60:
        return runSetSystemUserModeEmulation();
    L62:
        return runReportPackageAllowlistProblems();
    L64:
        return runList();
    L10:
        if (cmd.equals("is-user-visible") == false) goto L41;
        r1 = 6;
        goto L42
    L15:
        if (cmd.equals("set-system-user-mode-emulation") == false) goto L41;
        r1 = 2;
        goto L42
    L18:
        if (cmd.equals("get-main-user") == false) goto L41;
        r1 = 7;
        goto L42
    L21:
        if (cmd.equals("report-system-user-package-whitelist-problems") == false) goto L41;
        r1 = 1;
        goto L42
    L24:
        if (cmd.equals("is-visible-background-users-on-default-display-supported") == false) goto L41;
        r1 = 5;
        goto L42
    L27:
        if (cmd.equals("is-main-user-permanent-admin") == false) goto L41;
        r1 = 9;
        goto L42
    L30:
        if (cmd.equals("can-switch-to-headless-system-user") == false) goto L41;
        r1 = 8;
        goto L42
    L33:
        if (cmd.equals("list") == false) goto L41;
        r1 = 0;
        goto L42
    L36:
        if (cmd.equals("is-headless-system-user-mode") == false) goto L41;
        r1 = 3;
        goto L42
    L39:
        if (cmd.equals("is-visible-background-users-supported") == false) goto L41;
        r1 = 4;
        goto L42
    }

    private int runList() throws RemoteException {
        UserManagerServiceShellCommand r1 = this;
        PrintWriter pw = r1.getOutPrintWriter();
        boolean verbose = false;
        boolean all = false;
    L3:
        String opt = r1.getNextOption();
        char r6 = 0;
        if (opt == null) goto L24;
        switch(opt.hashCode()) {
            case 1513: goto L15;
            case 42995713: goto L12;
            case 1737088994: goto L9;
            default: goto L17;
        };
    L17:
        r6 = 65535;
    L18:
        switch(r6) {
            case 0: goto L22;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        pw.println("Invalid option: " + opt);
        return -1;
    L22:
        verbose = true;
        goto L3
    L21:
        all = true;
        goto L3
    L9:
        if (opt.equals("--verbose") == false) goto L106;
        r6 = 1;
        goto L18
    L106:
        r6 = 65535;
        goto L18
    L12:
        if (opt.equals("--all") == false) goto L107;
        r6 = 2;
        goto L18
    L107:
        r6 = 65535;
        goto L18
    L15:
        if (opt.equals("-v") == true) goto L18;
        r6 = 65535;
        goto L18
    L24:
        IActivityManager am = ActivityManager.getService();
        List<UserInfo> users = r1.mService.getUsers(!all, false, !all);
        if (users != null) goto L28;
        pw.println("Error: couldn't get users");
        return 1;
    L28:
        int size = users.size();
        if (verbose == false) goto L31;
        pw.printf("%d users:\n\n", new Object[]{Integer.valueOf(size)});
        int currentUser = am.getCurrentUser().id;
        int currentUser2 = currentUser;
    L32:
        int i = 0;
    L33:
        if (i >= size) goto L93;
        UserInfo user = users.get(i);
        boolean running = am.isUserRunning(user.id, r6);
        String r0 = "";
        if (verbose == false) goto L87;
        DevicePolicyManagerInternal dpm = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        String deviceOwner = "";
        String profileOwner = "";
        if (dpm == null) goto L51;
        long identity = Binder.clearCallingIdentity();
    L42:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L40:
        if (dpm.getDeviceOwnerUserId() != user.id) goto L44;
        deviceOwner = " (device-owner)";
    L44:
        if (dpm.getProfileOwnerAsUser(user.id) != null) goto L47;
    L48:
        Binder.restoreCallingIdentity(identity);
        String deviceOwner2 = deviceOwner;
        String profileOwner2 = profileOwner;
    L53:
        if (user.id != currentUser2) goto L55;
        char r7 = 1;
    L57:
        if (user.profileGroupId != user.id) goto L59;
    L61:
        char r3 = r6;
    L62:
        boolean visible = r1.mService.isUserVisible(user.id);
        Integer r21 = Integer.valueOf(i);
        Integer r22 = Integer.valueOf(user.id);
        String r8 = user.name;
        char r18 = r3;
        String r24 = user.userType.replace("android.os.usertype.", "");
        String r25 = UserInfo.flagsToString(user.flags);
        if (r18 == 0) goto L65;
        String r26 = " (parentId=" + user.profileGroupId + ")";
    L66:
        if (running == false) goto L68;
        Object r27 = " (running)";
    L70:
        if (user.partial == false) goto L72;
        Object r28 = " (partial)";
    L74:
        if (user.preCreated == false) goto L76;
        Object r29 = " (pre-created)";
    L78:
        if (user.convertedFromPreCreated == false) goto L80;
        Object r30 = " (converted)";
    L81:
        if (r7 == 0) goto L83;
        Object r33 = " (current)";
    L84:
        if (visible == false) goto L86;
        r0 = " (visible)";
    L86:
        pw.printf("%d: id=%d, name=%s, type=%s, flags=%s%s%s%s%s%s%s%s%s%s\n", new Object[]{r21, r22, r8, r24, r25, r26, r27, r28, r29, r30, deviceOwner2, profileOwner2, r33, r0});
    L91:
        i = i + 1;
        r1 = this;
        all = all;
        r6 = r6;
        goto L33
    L83:
        r33 = "";
        goto L84
    L80:
        r30 = "";
        goto L81
    L76:
        r29 = "";
        goto L78
    L72:
        r28 = "";
        goto L74
    L68:
        r27 = "";
        goto L70
    L65:
        r26 = "";
        goto L66
    L59:
        if (user.profileGroupId == (-10000)) goto L61;
        r3 = 1;
        goto L62
    L55:
        r7 = r6;
        goto L57
    L47:
        profileOwner = " (profile-owner)";
        goto L48
    L51:
        deviceOwner2 = "";
        profileOwner2 = "";
        goto L53
    L87:
        r6 = r6;
        if (running == false) goto L90;
        r0 = " running";
    L90:
        pw.printf("\t%s%s\n", new Object[]{user, r0});
        goto L91
    L93:
        return r6;
    L31:
        pw.println("Users:");
        currentUser2 = -10000;
        goto L32
    }

    private int runReportPackageAllowlistProblems() {
        PrintWriter pw = getOutPrintWriter();
        boolean verbose = false;
        boolean criticalOnly = false;
        int mode = -1000;
    L3:
        String opt = getNextOption();
        byte r6 = 0;
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case -1362766982: goto L18;
            case 1513: goto L15;
            case 1333227331: goto L12;
            case 1737088994: goto L9;
            default: goto L20;
        };
    L20:
        r6 = -1;
    L21:
        switch(r6) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Invalid option: " + opt);
        return -1;
    L25:
        criticalOnly = true;
        goto L3
    L26:
        verbose = true;
        goto L3
    L24:
        mode = Integer.parseInt(getNextArgRequired());
        goto L3
    L9:
        if (opt.equals("--verbose") == false) goto L51;
        r6 = 1;
        goto L21
    L51:
        r6 = -1;
        goto L21
    L12:
        if (opt.equals("--mode") == false) goto L52;
        r6 = 3;
        goto L21
    L52:
        r6 = -1;
        goto L21
    L15:
        if (opt.equals("-v") == true) goto L21;
        r6 = -1;
        goto L21
    L18:
        if (opt.equals("--critical-only") == false) goto L54;
        r6 = 2;
        goto L21
    L54:
        r6 = -1;
        goto L21
    L28:
        Slog.d(LOG_TAG, "runReportPackageAllowlistProblems(): verbose=" + verbose + ", criticalOnly=" + criticalOnly + ", mode=" + UserSystemPackageInstaller.modeToString(mode));
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        this.mSystemPackageInstaller.dumpPackageWhitelistProblems(ipw, mode, verbose, criticalOnly);     // Catch: Throwable -> L32
        ipw.close();
        return 0;
    L32:
        th = move-exception;
        ipw.close();     // Catch: Throwable -> L35
    L37:
        throw th;
    L35:
        th = move-exception;
        th.addSuppressed(th);
        goto L37
    }

    private int runSetSystemUserModeEmulation() {
        if (confirmBuildIsDebuggable() == true) goto L5;
    L72:
        return -1;
    L5:
        if (confirmIsCalledByRoot() == false) goto L72;
        PrintWriter pw = getOutPrintWriter();
        if (this.mLockPatternUtils.isSecure(0) == false) goto L11;
        pw.println("Cannot change system user mode when it has a credential");
        return -1;
    L11:
        boolean restart = true;
        boolean reboot = false;
    L12:
        String opt = getNextOption();
        byte r7 = 1;
        if (opt == null) goto L30;
        switch(opt.hashCode()) {
            case 1269283747: goto L21;
            case 1465075013: goto L18;
            default: goto L23;
        };
    L23:
        r7 = -1;
    L24:
        switch(r7) {
            case 0: goto L28;
            case 1: goto L27;
            default: goto L25;
        };
    L25:
        pw.println("Invalid option: " + opt);
        return -1;
    L28:
        reboot = true;
        goto L12
    L27:
        restart = false;
        goto L12
    L18:
        if (opt.equals("--reboot") == false) goto L82;
        r7 = 0;
        goto L24
    L82:
        r7 = -1;
        goto L24
    L21:
        if (opt.equals("--no-restart") == true) goto L24;
        r7 = -1;
        goto L24
    L30:
        if (reboot == false) goto L34;
        if (restart == true) goto L34;
        getErrPrintWriter().println("You can use --reboot or --no-restart, but not both");
        return -1;
    L34:
        String mode = getNextArgRequired();
        boolean isHeadlessSystemUserModeCurrently = UserManager.isHeadlessSystemUserMode();
        String r10 = "headless";
        switch(mode.hashCode()) {
            case -1115062407: goto L44;
            case 3154575: goto L41;
            case 1544803905: goto L38;
            default: goto L46;
        };
    L46:
        r7 = -1;
    L47:
        switch(r7) {
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L50;
            default: goto L48;
        };
    L48:
        getErrPrintWriter().printf("Invalid arg: %s\n", new Object[]{mode});
        return -1;
    L50:
        boolean changed = true;
    L53:
        if (changed == true) goto L59;
        if (isHeadlessSystemUserModeCurrently == true) goto L57;
        r10 = "full";
    L57:
        pw.printf("No change needed, system user is already %s\n", new Object[]{r10});
        return 0;
    L59:
        Slogf.d(LOG_TAG, "Updating system property %s to %s", new Object[]{"persist.debug.user_mode_emulation", mode});
        SystemProperties.set("persist.debug.user_mode_emulation", mode);
        if (reboot == false) goto L62;
        Slog.i(LOG_TAG, "Rebooting to finalize the changes");
        pw.println("Rebooting to finalize changes");
        UiThread.getHandler().post(new UserManagerServiceShellCommand$$ExternalSyntheticLambda0());
    L71:
        return 0;
    L62:
        if (restart == false) goto L70;
        Slog.i(LOG_TAG, "Shutting PackageManager down");
        ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).shutdown();
        IActivityManager am = ActivityManager.getService();
        if (am != null) goto L73;
    L69:
        int pid = Process.myPid();
        Slogf.i(LOG_TAG, "Restarting Android runtime(PID=%d) to finalize changes", new Object[]{Integer.valueOf(pid)});
        pw.println("Restarting Android runtime to finalize changes");
        pw.println("The restart may trigger a 'Broken pipe' message; this is to be expected.");
        pw.flush();
        Process.killProcess(pid);
        goto L71
    L73:
        Slog.i(LOG_TAG, "Shutting ActivityManager down");     // Catch: RemoteException -> L67
        am.shutdown(10000);     // Catch: RemoteException -> L67
    L67:
        e = move-exception;
        Slog.e(LOG_TAG, "Failed to shut down ActivityManager" + e);
        goto L69
    L70:
        pw.println("System user mode changed - please reboot (or restart Android runtime) to continue");
        pw.println("NOTICE: after restart, some apps might be uninstalled (and their data will be lost)");
        goto L71
    L51:
        changed = !isHeadlessSystemUserModeCurrently;
        goto L53
    L52:
        changed = isHeadlessSystemUserModeCurrently;
        goto L53
    L38:
        if (mode.equals("default") == false) goto L84;
        r7 = 2;
        goto L47
    L84:
        r7 = -1;
        goto L47
    L41:
        if (mode.equals("full") == false) goto L85;
        r7 = 0;
        goto L47
    L85:
        r7 = -1;
        goto L47
    L44:
        if (mode.equals("headless") == true) goto L47;
        r7 = -1;
        goto L47
    }

    private static /* synthetic */ void lambda$runSetSystemUserModeEmulation$0() {
        ShutdownThread.reboot(ActivityThread.currentActivityThread().getSystemUiContext(), "To switch headless / full system user mode", false);
    }

    private int runIsUserVisible() {
        PrintWriter pw = getOutPrintWriter();
        Integer displayId = null;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case -1237221598: goto L9;
            default: goto L11;
        };
    L11:
        r4 = -1;
    L12:
        switch(r4) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        displayId = Integer.valueOf(Integer.parseInt(getNextArgRequired()));
        goto L3
    L13:
        pw.println("Invalid option: " + opt);
        return -1;
    L9:
        if (opt.equals("--display") == false) goto L11;
    L16:
        int userId = UserHandle.parseUserArg(getNextArgRequired());
        switch(userId) {
            case -10000: goto L25;
            case -3: goto L25;
            case -2: goto L19;
            case -1: goto L25;
            default: goto L20;
        };
    L19:
        userId = ActivityManager.getCurrentUser();
        goto L20
    L25:
        pw.printf("invalid value (%d) for --user option\n", new Object[]{Integer.valueOf(userId)});
        return -1;
    L20:
        if (displayId == null) goto L22;
        boolean isVisible = this.mService.isUserVisibleOnDisplay(userId, displayId.intValue());
    L23:
        pw.println(isVisible);
        return 0;
    L22:
        isVisible = getUserManagerForUser(userId).isUserVisible();
        goto L23
    }

    private int runIsHeadlessSystemUserMode() {
        PrintWriter pw = getOutPrintWriter();
        boolean verbose = false;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L19;
        switch(opt.hashCode()) {
            case 1513: goto L12;
            case 1737088994: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L18;
            case 1: goto L18;
            default: goto L16;
        };
    L18:
        verbose = true;
        goto L3
    L16:
        pw.println("Invalid option: " + opt);
        return -1;
    L9:
        if (opt.equals("--verbose") == false) goto L26;
        r4 = 1;
        goto L15
    L26:
        r4 = -1;
        goto L15
    L12:
        if (opt.equals("-v") == true) goto L15;
        r4 = -1;
        goto L15
    L19:
        boolean effective = this.mService.isHeadlessSystemUserMode();
        if (verbose == true) goto L22;
        pw.println(effective);
    L23:
        return 0;
    L22:
        pw.printf("effective=%b real=%b\n", new Object[]{Boolean.valueOf(effective), Boolean.valueOf(RoSystemProperties.MULTIUSER_HEADLESS_SYSTEM_USER)});
        goto L23
    }

    private int runIsVisibleBackgroundUserSupported() {
        PrintWriter pw = getOutPrintWriter();
        boolean verbose = false;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L19;
        switch(opt.hashCode()) {
            case 1513: goto L12;
            case 1737088994: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L18;
            case 1: goto L18;
            default: goto L16;
        };
    L18:
        verbose = true;
        goto L3
    L16:
        pw.println("Invalid option: " + opt);
        return -1;
    L9:
        if (opt.equals("--verbose") == false) goto L26;
        r4 = 1;
        goto L15
    L26:
        r4 = -1;
        goto L15
    L12:
        if (opt.equals("-v") == true) goto L15;
        r4 = -1;
        goto L15
    L19:
        boolean effective = UserManager.isVisibleBackgroundUsersEnabled();
        if (verbose == true) goto L22;
        pw.println(effective);
    L23:
        return 0;
    L22:
        pw.printf("effective=%b real=%b\n", new Object[]{Boolean.valueOf(effective), Boolean.valueOf(Resources.getSystem().getBoolean(R.bool.config_networkSamplingWakesDevice))});
        goto L23
    }

    private int runIsVisibleBackgroundUserOnDefaultDisplaySupported() {
        PrintWriter pw = getOutPrintWriter();
        boolean verbose = false;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L19;
        switch(opt.hashCode()) {
            case 1513: goto L12;
            case 1737088994: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L18;
            case 1: goto L18;
            default: goto L16;
        };
    L18:
        verbose = true;
        goto L3
    L16:
        pw.println("Invalid option: " + opt);
        return -1;
    L9:
        if (opt.equals("--verbose") == false) goto L26;
        r4 = 1;
        goto L15
    L26:
        r4 = -1;
        goto L15
    L12:
        if (opt.equals("-v") == true) goto L15;
        r4 = -1;
        goto L15
    L19:
        boolean effective = UserManager.isVisibleBackgroundUsersOnDefaultDisplayEnabled();
        if (verbose == true) goto L22;
        pw.println(effective);
    L23:
        return 0;
    L22:
        pw.printf("effective=%b real=%b\n", new Object[]{Boolean.valueOf(effective), Boolean.valueOf(Resources.getSystem().getBoolean(R.bool.config_nightDisplayAvailable))});
        goto L23
    }

    private int runGetMainUserId() {
        PrintWriter pw = getOutPrintWriter();
        int mainUserId = this.mService.getMainUserId();
        if (mainUserId != (-10000)) goto L6;
        pw.println(KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG);
        return 1;
    L6:
        pw.println(mainUserId);
        return 0;
    }

    private int canSwitchToHeadlessSystemUser() {
        PrintWriter pw = getOutPrintWriter();
        boolean canSwitchToHeadlessSystemUser = this.mService.canSwitchToHeadlessSystemUser();
        pw.println(canSwitchToHeadlessSystemUser);
        return 0;
    }

    private int isMainUserPermanentAdmin() {
        PrintWriter pw = getOutPrintWriter();
        boolean isMainUserPermanentAdmin = this.mService.isMainUserPermanentAdmin();
        pw.println(isMainUserPermanentAdmin);
        return 0;
    }

    private UserManager getUserManagerForUser(int userId) {
        UserHandle user = UserHandle.of(userId);
        Context context = this.mContext.createContextAsUser(user, 0);
        return (UserManager) context.getSystemService(UserManager.class);
    }

    private boolean confirmBuildIsDebuggable() {
        if (Build.isDebuggable() == false) goto L6;
        return true;
    L6:
        getErrPrintWriter().println("Command not available on user builds");
        return false;
    }

    private boolean confirmIsCalledByRoot() {
        if (Binder.getCallingUid() != 0) goto L6;
        return true;
    L6:
        getErrPrintWriter().println("Command only available on root user");
        return false;
    }
}
