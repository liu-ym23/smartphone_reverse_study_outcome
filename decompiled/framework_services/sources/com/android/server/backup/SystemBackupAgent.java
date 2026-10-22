package com.android.server.backup;

import android.app.IWallpaperManager;
import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupHelperWithLogger;
import android.app.backup.BackupRestoreEventLogger;
import android.app.backup.FullBackup;
import android.app.backup.FullBackupDataOutput;
import android.app.backup.WallpaperBackupHelper;
import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Slog;
import com.android.server.display.DisplayBackupHelper;
import com.android.server.notification.NotificationBackupHelper;
import com.android.server.wm.ActivityTaskManagerService;
import com.google.android.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SystemBackupAgent extends BackupAgentHelper {
    private static final String ACCOUNT_MANAGER_HELPER = "account_manager";
    private static final String APP_GENDER_HELPER = "app_gender";
    private static final String APP_LOCALES_HELPER = "app_locales";
    private static final String COMPANION_HELPER = "companion";
    private static final String DISPLAY_HELPER = "display";
    private static final String INPUT_HELPER = "input";
    private static final String NOTIFICATION_HELPER = "notifications";
    private static final String PEOPLE_HELPER = "people";
    private static final String PERMISSION_HELPER = "permissions";
    private static final String PREFERRED_HELPER = "preferred_activities";
    private static final String SHORTCUT_MANAGER_HELPER = "shortcut_manager";
    private static final String SLICES_HELPER = "slices";
    private static final String SYNC_SETTINGS_HELPER = "account_sync_settings";
    private static final String SYSTEM_GENDER_HELPER = "system_gender";
    private static final String TAG = "SystemBackupAgent";
    private static final String USAGE_STATS_HELPER = "usage_stats";
    private static final String WALLPAPER_HELPER = "wallpaper";
    public static final String WALLPAPER_IMAGE = null;
    private static final String WALLPAPER_IMAGE_DIR = null;
    private static final String WALLPAPER_IMAGE_FILENAME = "wallpaper";
    private static final String WALLPAPER_IMAGE_KEY = "/data/data/com.android.settings/files/wallpaper";
    public static final String WALLPAPER_INFO = null;
    private static final String WALLPAPER_INFO_DIR = null;
    private static final String WALLPAPER_INFO_FILENAME = "wallpaper_info.xml";
    private static final String WEAR_BACKUP_HELPER = "wear";
    private static final Set<String> sEligibleHelpersForNonSystemUser = null;
    private static final Set<String> sEligibleHelpersForProfileUser = null;
    private boolean mIsProfileUser;
    private BackupRestoreEventLogger mLogger;
    private int mUserId;

    public SystemBackupAgent() {
        this.mUserId = 0;
        this.mIsProfileUser = false;
    }

    static {
        WALLPAPER_IMAGE_DIR = Environment.getUserSystemDirectory(0).getAbsolutePath();
        WALLPAPER_IMAGE = new File(Environment.getUserSystemDirectory(0), "wallpaper").getAbsolutePath();
        WALLPAPER_INFO_DIR = Environment.getUserSystemDirectory(0).getAbsolutePath();
        WALLPAPER_INFO = new File(Environment.getUserSystemDirectory(0), WALLPAPER_INFO_FILENAME).getAbsolutePath();
        sEligibleHelpersForProfileUser = Sets.newArraySet(new String[]{PERMISSION_HELPER, NOTIFICATION_HELPER, SYNC_SETTINGS_HELPER, APP_LOCALES_HELPER, COMPANION_HELPER, APP_GENDER_HELPER, SYSTEM_GENDER_HELPER, DISPLAY_HELPER});
        sEligibleHelpersForNonSystemUser = SetUtils.union(sEligibleHelpersForProfileUser, Sets.newArraySet(new String[]{ACCOUNT_MANAGER_HELPER, USAGE_STATS_HELPER, PREFERRED_HELPER, SHORTCUT_MANAGER_HELPER, INPUT_HELPER, WEAR_BACKUP_HELPER}));
    }

    public void onCreate(UserHandle user, int backupDestination) {
        super.onCreate(user, backupDestination);
        this.mLogger = getBackupRestoreEventLogger();
        this.mUserId = user.getIdentifier();
        if (this.mUserId == 0) goto L5;
        Context context = createContextAsUser(user, 0);
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        this.mIsProfileUser = userManager.isProfile();
    L5:
        addHelperIfEligibleForUser(SYNC_SETTINGS_HELPER, new AccountSyncSettingsBackupHelper(this, this.mUserId));
        addHelperIfEligibleForUser(PREFERRED_HELPER, new PreferredActivityBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(NOTIFICATION_HELPER, new NotificationBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(PERMISSION_HELPER, new PermissionBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(USAGE_STATS_HELPER, new UsageStatsBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(SHORTCUT_MANAGER_HELPER, new ShortcutBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(ACCOUNT_MANAGER_HELPER, new AccountManagerBackupHelper(this.mUserId));
        if (getPackageManager().hasSystemFeature("android.software.slices_disabled") == true) goto L8;
        addHelperIfEligibleForUser(SLICES_HELPER, new SliceBackupHelper(this));
    L8:
        addHelperIfEligibleForUser(PEOPLE_HELPER, new PeopleBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(APP_LOCALES_HELPER, new AppSpecificLocalesBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(APP_GENDER_HELPER, new AppGrammaticalGenderBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(COMPANION_HELPER, new CompanionBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(SYSTEM_GENDER_HELPER, new SystemGrammaticalGenderBackupHelper(this.mUserId));
        addHelperIfEligibleForUser(DISPLAY_HELPER, new DisplayBackupHelper(this.mUserId));
        if (getPackageManager().hasSystemFeature("android.hardware.type.watch") == false) goto L12;
        addHelperIfEligibleForUser(WEAR_BACKUP_HELPER, new WearBackupHelper());
        return;
    }

    @Override // android.app.backup.BackupAgent
    public void onFullBackup(FullBackupDataOutput data) throws IOException {
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        addHelper("wallpaper", new WallpaperBackupHelper(this, new String[]{WALLPAPER_IMAGE_KEY}));
        addHelper("system_files", new WallpaperBackupHelper(this, new String[]{WALLPAPER_IMAGE_KEY}));
        super.onRestore(data, appVersionCode, newState);
    }

    public void onRestoreFile(ParcelFileDescriptor data, long size, int type, String domain, String path, long mode, long mtime) throws IOException {
        Slog.i(TAG, "Restoring file domain=" + domain + " path=" + path);
        if (domain.equals(ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD) == true) goto L5;
    L10:
        File outFile = null;
        boolean restoredWallpaper = false;
    L11:
        if (outFile == null) goto L31;
    L15:
        FullBackup.restoreFile(data, size, type, mode, mtime, outFile);     // Catch: IOException -> L13
        if (restoredWallpaper == false) goto L35;
        IWallpaperManager wallpaper = ServiceManager.getService("wallpaper");     // Catch: IOException -> L13
        if (wallpaper == null) goto L36;
        wallpaper.settingsRestored();     // Catch: IOException -> L13 RemoteException -> L22
        goto L26
    L37:
        return;
    L22:
        re = move-exception;
        Slog.e(TAG, "Couldn't restore settings\n" + re);     // Catch: IOException -> L13
        return;
    L26:
        if (restoredWallpaper == false) goto L33;
        new File(WALLPAPER_IMAGE).delete();
        new File(WALLPAPER_INFO).delete();
        return;
    L33:
        return;
    L36:
        return;
    L35:
        return;
    L31:
        Slog.w(TAG, "Skipping unrecognized system file: [ " + domain + " : " + path + " ]");     // Catch: IOException -> L13
        goto L15
    L5:
        if (path.equals(WALLPAPER_INFO_FILENAME) == false) goto L8;
        File outFile2 = new File(WALLPAPER_INFO);
        outFile = outFile2;
        restoredWallpaper = true;
        goto L11
    L8:
        if (path.equals("wallpaper") == false) goto L10;
        File outFile3 = new File(WALLPAPER_IMAGE);
        outFile = outFile3;
        restoredWallpaper = true;
        goto L11
    }

    private void addHelperIfEligibleForUser(String keyPrefix, BackupHelperWithLogger helper) {
        if (isHelperEligibleForUser(keyPrefix) == false) goto L6;
        addHelper(keyPrefix, helper);
        helper.setLogger(this.mLogger);
        return;
    }

    private boolean isHelperEligibleForUser(String keyPrefix) {
        if (this.mUserId != 0) goto L7;
        return true;
    L7:
        if (this.mIsProfileUser == false) goto L11;
        return sEligibleHelpersForProfileUser.contains(keyPrefix);
    L11:
        return sEligibleHelpersForNonSystemUser.contains(keyPrefix);
    }
}
