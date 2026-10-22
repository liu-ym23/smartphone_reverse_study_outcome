package com.android.server.backup.utils;

import android.app.compat.CompatChanges;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.pm.PackageManagerService;
import com.google.android.collect.Sets;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BackupEligibilityRules {
    private static final boolean DEBUG = false;
    static final long IGNORE_ALLOW_BACKUP_IN_D2D = 183147249;
    static final long RESTRICT_ADB_BACKUP = 171032338;
    private static final Set<String> systemPackagesAllowedForNonSystemUsers = null;
    private static final Set<String> systemPackagesAllowedForProfileUser = null;
    private final int mBackupDestination;
    private boolean mIsProfileUser;
    private final PackageManager mPackageManager;
    private final PackageManagerInternal mPackageManagerInternal;
    private final boolean mSkipRestoreForLaunchedApps;
    private final int mUserId;

    static {
        systemPackagesAllowedForProfileUser = Sets.newArraySet(new String[]{UserBackupManagerService.PACKAGE_MANAGER_SENTINEL, PackageManagerService.PLATFORM_PACKAGE_NAME});
        systemPackagesAllowedForNonSystemUsers = com.android.server.backup.SetUtils.union(systemPackagesAllowedForProfileUser, Sets.newArraySet(new String[]{UserBackupManagerService.WALLPAPER_PACKAGE, UserBackupManagerService.SETTINGS_PACKAGE}));
        if (UserManager.isHeadlessSystemUserMode() == false) goto L6;
        systemPackagesAllowedForNonSystemUsers.add(UserBackupManagerService.TELEPHONY_PROVIDER_PACKAGE);
        return;
    }

    public static BackupEligibilityRules forBackup(PackageManager packageManager, PackageManagerInternal packageManagerInternal, int userId, Context context) {
        return new BackupEligibilityRules(packageManager, packageManagerInternal, userId, context, 0);
    }

    public BackupEligibilityRules(PackageManager packageManager, PackageManagerInternal packageManagerInternal, int userId, Context context, int backupDestination) {
        this(packageManager, packageManagerInternal, userId, context, backupDestination, false);
    }

    public BackupEligibilityRules(PackageManager packageManager, PackageManagerInternal packageManagerInternal, int userId, Context context, int backupDestination, boolean skipRestoreForLaunchedApps) {
        this.mIsProfileUser = false;
        this.mPackageManager = packageManager;
        this.mPackageManagerInternal = packageManagerInternal;
        this.mUserId = userId;
        this.mBackupDestination = backupDestination;
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        this.mIsProfileUser = userManager.isProfile();
        this.mSkipRestoreForLaunchedApps = skipRestoreForLaunchedApps;
    }

    public boolean appIsEligibleForBackup(ApplicationInfo app) {
        if (isAppBackupAllowed(app) == true) goto L6;
        return false;
    L6:
        if (UserHandle.isCore(app.uid) == false) goto L23;
        if (this.mUserId == 0) goto L20;
        if (this.mIsProfileUser == false) goto L15;
        if (systemPackagesAllowedForProfileUser.contains(app.packageName) == true) goto L15;
        return false;
    L15:
        if (this.mIsProfileUser == true) goto L20;
        if (systemPackagesAllowedForNonSystemUsers.contains(app.packageName) == true) goto L20;
        return false;
    L20:
        if (app.backupAgentName != null) goto L23;
        return false;
    L23:
        if (app.packageName.equals(UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE) == false) goto L26;
        return false;
    L26:
        if (app.isInstantApp() == false) goto L29;
        return false;
    L29:
        return !appIsDisabled(app);
    }

    public boolean isAppBackupAllowed(ApplicationInfo app) {
        boolean isDebuggable = false;
        if ((app.flags & 32768) == 0) goto L5;
        boolean allowBackup = true;
    L7:
        switch(this.mBackupDestination) {
            case 0: goto L50;
            case 1: goto L38;
            case 2: goto L10;
            default: goto L8;
        };
    L8:
        Slog.w(BackupManagerService.TAG, "Unknown operation type:" + this.mBackupDestination);
        return false;
    L10:
        String packageName = app.packageName;
        if (packageName != null) goto L15;
        Slog.w(BackupManagerService.TAG, "Invalid ApplicationInfo object");
        return false;
    L15:
        if (CompatChanges.isChangeEnabled(RESTRICT_ADB_BACKUP, packageName, UserHandle.of(this.mUserId)) == true) goto L18;
        return allowBackup;
    L18:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L21;
        return true;
    L21:
        if ((app.flags & 8) == 0) goto L23;
        boolean isPrivileged = true;
    L25:
        if ((app.flags & 2) == 0) goto L28;
        isDebuggable = true;
    L28:
        if (UserHandle.isCore(app.uid) == true) goto L51;
        if (isPrivileged == true) goto L51;
        return isDebuggable;
    L51:
        return this.mPackageManager.getPropertyAsUser("android.backup.ALLOW_ADB_BACKUP", packageName, null, this.mUserId).getBoolean();
    L35:
        Slog.w(BackupManagerService.TAG, "Failed to read allowAdbBackup property for + " + packageName);
        return allowBackup;
    L23:
        isPrivileged = false;
        goto L25
    L50:
        return allowBackup;
    L38:
        if ((app.flags & 1) == 0) goto L40;
        boolean isSystemApp = true;
    L41:
        if (isSystemApp == false) goto L43;
    L45:
        boolean ignoreAllowBackup = false;
    L46:
        if (ignoreAllowBackup == true) goto L49;
        if (allowBackup == true) goto L49;
        return false;
    L49:
        return true;
    L43:
        if (CompatChanges.isChangeEnabled(IGNORE_ALLOW_BACKUP_IN_D2D, app.packageName, UserHandle.of(this.mUserId)) == false) goto L45;
        ignoreAllowBackup = true;
        goto L46
    L40:
        isSystemApp = false;
        goto L41
    L5:
        allowBackup = false;
        goto L7
    }

    public boolean appIsRunningAndEligibleForBackupWithTransport(TransportConnection transportConnection, String packageName) {
        boolean r0 = false;
        PackageInfo packageInfo = this.mPackageManager.getPackageInfoAsUser(packageName, 134217728, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L16
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L16
        if (appIsEligibleForBackup(applicationInfo) == true) goto L6;
    L20:
        return false;
    L6:
        if (appIsStopped(applicationInfo) == true) goto L20;
        if (appIsDisabled(applicationInfo) == true) goto L20;
        if (transportConnection != null) goto L24;
        return true;
    L24:
        BackupTransportClient transport = transportConnection.connectOrThrow("AppBackupUtils.appIsRunningAndEligibleForBackupWithTransport");     // Catch: Exception -> L13
        r0 = transport.isAppEligibleForBackup(packageInfo, appGetsFullBackup(packageInfo));     // Catch: Exception -> L13
        return r0;
    L13:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Unable to ask about eligibility: " + e.getMessage());     // Catch: PackageManager.NameNotFoundException -> L16
        return true;
    L22:
        return r0;
    }

    public boolean isAppEligibleForRestore(ApplicationInfo app) {
        if (this.mSkipRestoreForLaunchedApps == true) goto L6;
        return true;
    L6:
        if (app.backupAgentName == null) goto L9;
        return true;
    L9:
        return !this.mPackageManagerInternal.wasPackageEverLaunched(app.packageName, this.mUserId);
    }

    boolean appIsDisabled(ApplicationInfo app) {
        int enabledSetting = this.mPackageManagerInternal.getApplicationEnabledState(app.packageName, this.mUserId);
        switch(enabledSetting) {
            case 0: goto L8;
            case 1: goto L4;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    L8:
        return true ^ app.enabled;
    }

    public boolean appIsStopped(ApplicationInfo app) {
        if ((app.flags & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean appGetsFullBackup(PackageInfo pkg) {
        if (pkg.applicationInfo.backupAgentName != null) goto L5;
        return true;
    L5:
        if ((pkg.applicationInfo.flags & 67108864) != 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean appIsKeyValueOnly(PackageInfo pkg) {
        return !appGetsFullBackup(pkg);
    }

    public boolean signaturesMatch(Signature[] storedSigs, PackageInfo target) {
        if (target != null) goto L5;
    L34:
        return false;
    L5:
        if (target.packageName == null) goto L34;
        if ((target.applicationInfo.flags & 1) == 0) goto L11;
        return true;
    L11:
        if (ArrayUtils.isEmpty(storedSigs) == false) goto L13;
        return false;
    L13:
        SigningInfo signingInfo = target.signingInfo;
        if (signingInfo != null) goto L17;
        Slog.w(BackupManagerService.TAG, "signingInfo is empty, app was either unsigned or the flag PackageManager#GET_SIGNING_CERTIFICATES was not specified");
        return false;
    L17:
        Slog.d(BackupManagerService.TAG, "signaturesMatch(): stored=" + Arrays.toString(storedSigs) + " device=" + Arrays.toString(signingInfo.getApkContentsSigners()));
        int nStored = storedSigs.length;
        if (nStored == 1) goto L20;
        Signature[] deviceSigs = signingInfo.getApkContentsSigners();
        int nDevice = deviceSigs.length;
        int i = 0;
    L22:
        if (i >= nStored) goto L33;
        boolean match = false;
        int j = 0;
    L24:
        if (j >= nDevice) goto L29;
        if (storedSigs[i].equals(deviceSigs[j]) == true) goto L27;
        j = j + 1;
        goto L24
    L27:
        match = true;
    L29:
        if (match == false) goto L30;
        i = i + 1;
        goto L22
    L30:
        return false;
    L33:
        return true;
    L20:
        return this.mPackageManagerInternal.isDataRestoreSafe(storedSigs[0], target.packageName);
    }

    public int getBackupDestination() {
        return this.mBackupDestination;
    }
}
