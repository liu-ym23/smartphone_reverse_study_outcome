package com.android.server.locksettings;

import android.app.ActivityManager;
import android.app.admin.PasswordMetrics;
import android.content.Context;
import android.os.ShellCommand;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.PasswordValidationError;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class LockSettingsShellCommand extends ShellCommand {
    private static final String COMMAND_CLEAR = "clear";
    private static final String COMMAND_GET_DISABLED = "get-disabled";
    private static final String COMMAND_HELP = "help";
    private static final String COMMAND_REMOVE_CACHE = "remove-cache";
    private static final String COMMAND_REQUIRE_STRONG_AUTH = "require-strong-auth";
    private static final String COMMAND_SET_DISABLED = "set-disabled";
    private static final String COMMAND_SET_PASSWORD = "set-password";
    private static final String COMMAND_SET_PATTERN = "set-pattern";
    private static final String COMMAND_SET_PIN = "set-pin";
    private static final String COMMAND_SET_ROR_PROVIDER_PACKAGE = "set-resume-on-reboot-provider-package";
    private static final String COMMAND_VERIFY = "verify";
    private final int mCallingPid;
    private final int mCallingUid;
    private final Context mContext;
    private int mCurrentUserId;
    private final LockPatternUtils mLockPatternUtils;
    private String mNew;
    private String mOld;

    LockSettingsShellCommand(LockPatternUtils lockPatternUtils, Context context, int callingPid, int callingUid) {
        this.mOld = "";
        this.mNew = "";
        this.mLockPatternUtils = lockPatternUtils;
        this.mCallingPid = callingPid;
        this.mCallingUid = callingUid;
        this.mContext = context;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L100;
        return handleDefaultCommands(cmd);
    L100:
        this.mCurrentUserId = ActivityManager.getService().getCurrentUser().id;     // Catch: Exception -> L15
        parseArgs();     // Catch: Exception -> L15
        byte r6 = 1;
        if (this.mLockPatternUtils.hasSecureLockScreen() == true) goto L32;
        switch(cmd.hashCode()) {
            case -1473704173: goto L24;
            case 3198785: goto L21;
            case 75288455: goto L18;
            case 1062640281: goto L13;
            default: goto L26;
        };     // Catch: Exception -> L15
    L26:
        byte r1 = -1;
    L27:
        switch(r1) {
            case 0: goto L32;
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L32;
            default: goto L28;
        };     // Catch: Exception -> L15
    L28:
        getErrPrintWriter().println("The device does not support lock screen - ignoring the command.");     // Catch: Exception -> L15
        return -1;
    L13:
        if (cmd.equals(COMMAND_SET_ROR_PROVIDER_PACKAGE) == false) goto L26;
        r1 = 3;
        goto L27
    L18:
        if (cmd.equals(COMMAND_SET_DISABLED) == false) goto L26;
        r1 = 2;
        goto L27
    L21:
        if (cmd.equals(COMMAND_HELP) == false) goto L26;
        r1 = 0;
        goto L27
    L24:
        if (cmd.equals(COMMAND_GET_DISABLED) == false) goto L26;
        r1 = 1;
    L32:
        switch(cmd.hashCode()) {
            case -1957541639: goto L50;
            case -1473704173: goto L47;
            case -868666698: goto L44;
            case 3198785: goto L41;
            case 75288455: goto L38;
            case 1062640281: goto L35;
            default: goto L52;
        };     // Catch: Exception -> L15
    L52:
        byte r2 = -1;
    L53:
        switch(r2) {
            case 0: goto L96;
            case 1: goto L94;
            case 2: goto L92;
            case 3: goto L90;
            case 4: goto L88;
            case 5: goto L86;
            default: goto L55;
        };     // Catch: Exception -> L15
    L86:
        runSetDisabled();     // Catch: Exception -> L15
        return 0;
    L88:
        runGetDisabled();     // Catch: Exception -> L15
        return 0;
    L90:
        onHelp();     // Catch: Exception -> L15
        return 0;
    L92:
        runRequireStrongAuth();     // Catch: Exception -> L15
        return 0;
    L94:
        runSetResumeOnRebootProviderPackage();     // Catch: Exception -> L15
        return 0;
    L96:
        runRemoveCache();     // Catch: Exception -> L15
        return 0;
    L55:
        if (checkCredential() == true) goto L57;
        return -1;
    L57:
        boolean success = true;
        switch(cmd.hashCode()) {
            case -2044327643: goto L73;
            case -819951495: goto L70;
            case 94746189: goto L67;
            case 1021333414: goto L64;
            case 1983832490: goto L61;
            default: goto L75;
        };     // Catch: Exception -> L15
    L75:
        r6 = -1;
    L76:
        switch(r6) {
            case 0: goto L82;
            case 1: goto L81;
            case 2: goto L80;
            case 3: goto L79;
            case 4: goto L78;
            default: goto L77;
        };     // Catch: Exception -> L15
    L77:
        getErrPrintWriter().println("Unknown command: " + cmd);     // Catch: Exception -> L15
    L83:
        if (success == true) goto L85;
        return -1;
    L85:
        return 0;
    L78:
        runVerify();     // Catch: Exception -> L15
        goto L83
    L79:
        success = runClear();     // Catch: Exception -> L15
        goto L83
    L80:
        success = runSetPin();     // Catch: Exception -> L15
        goto L83
    L81:
        success = runSetPassword();     // Catch: Exception -> L15
        goto L83
    L82:
        success = runSetPattern();     // Catch: Exception -> L15
        goto L83
    L61:
        if (cmd.equals(COMMAND_SET_PIN) == false) goto L75;
        r6 = 2;
        goto L76
    L64:
        if (cmd.equals(COMMAND_SET_PASSWORD) == false) goto L75;
    L67:
        if (cmd.equals(COMMAND_CLEAR) == false) goto L75;
        r6 = 3;
        goto L76
    L70:
        if (cmd.equals(COMMAND_VERIFY) == false) goto L75;
        r6 = 4;
        goto L76
    L73:
        if (cmd.equals(COMMAND_SET_PATTERN) == false) goto L75;
        r6 = 0;
        goto L76
    L35:
        if (cmd.equals(COMMAND_SET_ROR_PROVIDER_PACKAGE) == false) goto L52;
        r2 = 1;
        goto L53
    L38:
        if (cmd.equals(COMMAND_SET_DISABLED) == false) goto L52;
        r2 = 5;
        goto L53
    L41:
        if (cmd.equals(COMMAND_HELP) == false) goto L52;
        r2 = 3;
        goto L53
    L44:
        if (cmd.equals(COMMAND_REQUIRE_STRONG_AUTH) == false) goto L52;
        r2 = 2;
        goto L53
    L47:
        if (cmd.equals(COMMAND_GET_DISABLED) == false) goto L52;
        r2 = 4;
        goto L53
    L50:
        if (cmd.equals(COMMAND_REMOVE_CACHE) == false) goto L52;
        r2 = 0;
    L15:
        e = move-exception;
        getErrPrintWriter().println("Error while executing command: " + cmd);
        e.printStackTrace(getErrPrintWriter());
        return -1;
    }

    private void runVerify() {
        getOutPrintWriter().println("Lock credential verified successfully");
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("lockSettings service commands:");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("NOTE: when a secure lock screen is set, most commands require the");     // Catch: Throwable -> L6
        pw.println("--old <CREDENTIAL> option.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get-disabled [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Prints true if the lock screen is completely disabled, i.e. set to None.");     // Catch: Throwable -> L6
        pw.println("    Otherwise prints false.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set-disabled [--user USER_ID] <true|false>");     // Catch: Throwable -> L6
        pw.println("    Sets whether the lock screen is disabled. If the lock screen is secure, this");     // Catch: Throwable -> L6
        pw.println("    has no immediate effect. I.e. this can only change between Swipe and None.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set-pattern [--old <CREDENTIAL>] [--user USER_ID] <PATTERN>");     // Catch: Throwable -> L6
        pw.println("    Sets a secure lock screen that uses the given PATTERN. PATTERN is a series");     // Catch: Throwable -> L6
        pw.println("    of digits 1-9 that identify the cells of the pattern.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set-pin [--old <CREDENTIAL>] [--user USER_ID] <PIN>");     // Catch: Throwable -> L6
        pw.println("    Sets a secure lock screen that uses the given PIN.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set-password [--old <CREDENTIAL>] [--user USER_ID] <PASSWORD>");     // Catch: Throwable -> L6
        pw.println("    Sets a secure lock screen that uses the given PASSWORD.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  clear [--old <CREDENTIAL>] [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Clears the lock credential.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  verify [--old <CREDENTIAL>] [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Verifies the lock credential.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  remove-cache [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Removes cached unified challenge for the managed profile.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set-resume-on-reboot-provider-package <package_name>");     // Catch: Throwable -> L6
        pw.println("    Sets the package name for server based resume on reboot service provider.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  require-strong-auth [--user USER_ID] <reason>");     // Catch: Throwable -> L6
        pw.println("    Requires strong authentication. The current supported reasons:");     // Catch: Throwable -> L6
        pw.println("    STRONG_AUTH_REQUIRED_AFTER_USER_LOCKDOWN.");     // Catch: Throwable -> L6
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

    private void parseArgs() {
    L2:
        String opt = getNextOption();
        if (opt == null) goto L14;
        if ("--old".equals(opt) == true) goto L6;
        if ("--user".equals(opt) == false) goto L12;
        this.mCurrentUserId = UserHandle.parseUserArg(getNextArgRequired());
        if (this.mCurrentUserId != (-2)) goto L2;
        this.mCurrentUserId = ActivityManager.getCurrentUser();
        goto L2
    L12:
        getErrPrintWriter().println("Unknown option: " + opt);
        throw new IllegalArgumentException();
    L6:
        this.mOld = getNextArgRequired();
        goto L2
    L14:
        this.mNew = getNextArg();
    }

    private LockscreenCredential getOldCredential() {
        if (TextUtils.isEmpty(this.mOld) == false) goto L7;
        return LockscreenCredential.createNone();
    L7:
        if (this.mLockPatternUtils.isLockPasswordEnabled(this.mCurrentUserId) == false) goto L15;
        int quality = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(this.mCurrentUserId);
        if (LockPatternUtils.isQualityAlphabeticPassword(quality) == false) goto L13;
        return LockscreenCredential.createPassword(this.mOld);
    L13:
        return LockscreenCredential.createPin(this.mOld);
    L15:
        if (this.mLockPatternUtils.isLockPatternEnabled(this.mCurrentUserId) == false) goto L19;
        return LockscreenCredential.createPattern(LockPatternUtils.byteArrayToPattern(this.mOld.getBytes()));
    L19:
        return LockscreenCredential.createPassword(this.mOld);
    }

    private boolean runSetPattern() {
        LockscreenCredential pattern = LockscreenCredential.createPattern(LockPatternUtils.byteArrayToPattern(this.mNew.getBytes()));
        if (isNewCredentialSufficient(pattern) == true) goto L6;
        return false;
    L6:
        this.mLockPatternUtils.setLockCredential(pattern, getOldCredential(), this.mCurrentUserId);
        getOutPrintWriter().println("Pattern set to '" + this.mNew + "'");
        return true;
    }

    private boolean runSetPassword() {
        LockscreenCredential password = LockscreenCredential.createPassword(this.mNew);
        if (isNewCredentialSufficient(password) == true) goto L6;
        return false;
    L6:
        this.mLockPatternUtils.setLockCredential(password, getOldCredential(), this.mCurrentUserId);
        getOutPrintWriter().println("Password set to '" + this.mNew + "'");
        return true;
    }

    private boolean runSetPin() {
        LockscreenCredential pin = LockscreenCredential.createPin(this.mNew);
        if (isNewCredentialSufficient(pin) == true) goto L6;
        return false;
    L6:
        this.mLockPatternUtils.setLockCredential(pin, getOldCredential(), this.mCurrentUserId);
        getOutPrintWriter().println("Pin set to '" + this.mNew + "'");
        return true;
    }

    private boolean runSetResumeOnRebootProviderPackage() {
        String packageName = this.mNew;
        Slog.i("ShellCommand", "Setting persist.sys.resume_on_reboot_provider_package to " + packageName);
        this.mContext.enforcePermission("android.permission.BIND_RESUME_ON_REBOOT_SERVICE", this.mCallingPid, this.mCallingUid, "ShellCommand");
        SystemProperties.set("persist.sys.resume_on_reboot_provider_package", packageName);
        return true;
    }

    private boolean runRequireStrongAuth() {
        String reason = this.mNew;
        switch(reason.hashCode()) {
            case 1785592813: goto L6;
            default: goto L8;
        };
    L8:
        byte r1 = -1;
    L9:
        switch(r1) {
            case 0: goto L12;
            default: goto L10;
        };
    L10:
        getErrPrintWriter().println("Unsupported reason: " + reason);
        return false;
    L12:
        this.mCurrentUserId = -1;
        this.mLockPatternUtils.requireStrongAuth(32, this.mCurrentUserId);
        getOutPrintWriter().println("Require strong auth for USER_ID " + this.mCurrentUserId + " because of " + this.mNew);
        return true;
    L6:
        if (reason.equals("STRONG_AUTH_REQUIRED_AFTER_USER_LOCKDOWN") == false) goto L8;
        r1 = 0;
        goto L9
    }

    private boolean runClear() {
        LockscreenCredential none = LockscreenCredential.createNone();
        if (isNewCredentialSufficient(none) == true) goto L6;
        return false;
    L6:
        this.mLockPatternUtils.setLockCredential(none, getOldCredential(), this.mCurrentUserId);
        getOutPrintWriter().println("Lock credential cleared");
        return true;
    }

    private boolean isNewCredentialSufficient(LockscreenCredential credential) {
        PasswordMetrics requiredMetrics = this.mLockPatternUtils.getRequestedPasswordMetrics(this.mCurrentUserId);
        int requiredComplexity = this.mLockPatternUtils.getRequestedPasswordComplexity(this.mCurrentUserId);
        List<PasswordValidationError> errors = PasswordMetrics.validateCredential(requiredMetrics, requiredComplexity, credential);
        if (errors.isEmpty() == true) goto L6;
        getOutPrintWriter().println("New credential doesn't satisfy admin policies: " + errors.get(0));
        return false;
    L6:
        return true;
    }

    private void runSetDisabled() {
        boolean disabled = Boolean.parseBoolean(this.mNew);
        this.mLockPatternUtils.setLockScreenDisabled(disabled, this.mCurrentUserId);
        getOutPrintWriter().println("Lock screen disabled set to " + disabled);
    }

    private void runGetDisabled() {
        boolean isLockScreenDisabled = this.mLockPatternUtils.isLockScreenDisabled(this.mCurrentUserId);
        getOutPrintWriter().println(isLockScreenDisabled);
    }

    private boolean checkCredential() {
        if (this.mLockPatternUtils.isSecure(this.mCurrentUserId) == false) goto L25;
        if (this.mLockPatternUtils.isManagedProfileWithUnifiedChallenge(this.mCurrentUserId) == false) goto L9;
        getOutPrintWriter().println("Profile uses unified challenge");
        return false;
    L9:
        if (this.mOld.isEmpty() == false) goto L30;
        getOutPrintWriter().println("User has a lock credential, but old credential was not provided");
        return false;
    L30:
        boolean result = this.mLockPatternUtils.checkCredential(getOldCredential(), this.mCurrentUserId, null);     // Catch: LockPatternUtils.RequestThrottledException -> L17
        if (result == false) goto L15;
        this.mLockPatternUtils.reportSuccessfulPasswordAttempt(this.mCurrentUserId);     // Catch: LockPatternUtils.RequestThrottledException -> L17
    L21:
        return result;
    L15:
        if (this.mLockPatternUtils.isManagedProfileWithUnifiedChallenge(this.mCurrentUserId) == true) goto L19;
        this.mLockPatternUtils.reportFailedPasswordAttempt(this.mCurrentUserId);     // Catch: LockPatternUtils.RequestThrottledException -> L17
    L19:
        getOutPrintWriter().println("Old password '" + this.mOld + "' didn't match");     // Catch: LockPatternUtils.RequestThrottledException -> L17
        goto L21
    L22:
        getOutPrintWriter().println("Request throttled");
        return false;
    L25:
        if (this.mOld.isEmpty() == true) goto L28;
        getOutPrintWriter().println("Old password provided but user has no password");
        return false;
    L28:
        return true;
    }

    private void runRemoveCache() {
        this.mLockPatternUtils.removeCachedUnifiedChallenge(this.mCurrentUserId);
        getOutPrintWriter().println("Password cached removed for user " + this.mCurrentUserId);
    }
}
