package com.android.server.locales;

import android.app.LocaleConfig;
import android.app.backup.BackupManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.LocaleList;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.ProcessList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class LocaleManagerBackupHelper {
    private static final String ARCHIVED_PACKAGES_PREFS = "ArchivedPackagesPrefs.xml";
    private static final String ATTR_DELEGATE_SELECTOR = "delegate_selector";
    private static final String ATTR_LOCALES = "locales";
    private static final String ATTR_PACKAGE_NAME = "name";
    private static final String KEY_STAGED_DATA_TIME = "staged_data_time";
    private static final String LOCALES_FROM_DELEGATE_PREFS = "LocalesFromDelegatePrefs.xml";
    private static final String LOCALES_STAGED_DATA_PREFS = "LocalesStagedDataPrefs.xml";
    private static final String LOCALES_XML_TAG = "locales";
    private static final String PACKAGE_XML_TAG = "package";
    private static final Duration STAGE_DATA_RETENTION_PERIOD = null;
    private static final String STRING_SPLIT = " s:";
    private static final String SYSTEM_BACKUP_PACKAGE_KEY = "android";
    private static final String TAG = "LocaleManagerBkpHelper";
    private final File mArchivedPackagesFile;
    private final Clock mClock;
    private final Context mContext;
    private final SharedPreferences mDelegateAppLocalePackages;
    private final LocaleManagerService mLocaleManagerService;
    private final PackageManager mPackageManager;
    private final SparseArray<File> mStagedDataFiles;
    private final Object mStagedDataLock;
    private final BroadcastReceiver mUserMonitor;

    static class LocalesInfo {
        final String mLocales;
        final boolean mSetFromDelegate;

        LocalesInfo(String locales, boolean setFromDelegate) {
            this.mLocales = locales;
            this.mSetFromDelegate = setFromDelegate;
        }
    }

    private final class UserMonitor extends BroadcastReceiver {
        final /* synthetic */ LocaleManagerBackupHelper this$0;

        /* synthetic */ UserMonitor(LocaleManagerBackupHelper r1, LocaleManagerBackupHelperIA r2) {
            this(r1);
        }

        private UserMonitor(LocaleManagerBackupHelper r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();     // Catch: Exception -> L12
            if (action.equals("android.intent.action.USER_REMOVED") == false) goto L20;
            int userId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);     // Catch: Exception -> L12
            Object r2 = LocaleManagerBackupHelper.m5105$$Nest$fgetmStagedDataLock(this.this$0);     // Catch: Exception -> L12
            monitor-enter(r2);     // Catch: Exception -> L12
            this.this$0.deleteStagedDataLocked(userId);     // Catch: Throwable -> L9
            LocaleManagerBackupHelper.m5107$$Nest$mremoveProfileFromPersistedInfo(this.this$0, userId);     // Catch: Throwable -> L9
            LocaleManagerBackupHelper.m5106$$Nest$mremoveArchivedPackagesForUser(this.this$0, userId);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
        L21:
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Exception -> L12
        L20:
            return;
        L12:
            e = move-exception;
            Slog.e(LocaleManagerBackupHelper.TAG, "Exception in user monitor.", e);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStagedDataLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5105$$Nest$fgetmStagedDataLock(LocaleManagerBackupHelper r0) {
        return r0.mStagedDataLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveArchivedPackagesForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5106$$Nest$mremoveArchivedPackagesForUser(LocaleManagerBackupHelper r0, int r1) {
        r0.removeArchivedPackagesForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveProfileFromPersistedInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5107$$Nest$mremoveProfileFromPersistedInfo(LocaleManagerBackupHelper r0, int r1) {
        r0.removeProfileFromPersistedInfo(r1);
    }

    static {
        STAGE_DATA_RETENTION_PERIOD = Duration.ofDays(3);
    }

    LocaleManagerBackupHelper(LocaleManagerService localeManagerService, PackageManager packageManager, HandlerThread broadcastHandlerThread) {
        this(localeManagerService.mContext, localeManagerService, packageManager, Clock.systemUTC(), broadcastHandlerThread, null, null, null);
    }

    LocaleManagerBackupHelper(Context context, LocaleManagerService localeManagerService, PackageManager packageManager, Clock clock, HandlerThread broadcastHandlerThread, SparseArray<File> stagedDataFiles, File archivedPackagesFile, SharedPreferences delegateAppLocalePackages) {
        this.mStagedDataLock = new Object();
        this.mContext = context;
        this.mLocaleManagerService = localeManagerService;
        this.mPackageManager = packageManager;
        this.mClock = clock;
        if (delegateAppLocalePackages == null) goto L5;
        SharedPreferences r0 = delegateAppLocalePackages;
    L6:
        this.mDelegateAppLocalePackages = r0;
        this.mArchivedPackagesFile = archivedPackagesFile;
        this.mStagedDataFiles = stagedDataFiles;
        this.mUserMonitor = new UserMonitor(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_REMOVED");
        context.registerReceiverAsUser(this.mUserMonitor, UserHandle.ALL, filter, null, broadcastHandlerThread.getThreadHandler());
        return;
    L5:
        r0 = createPersistedInfo();
        goto L6
    }

    BroadcastReceiver getUserMonitor() {
        return this.mUserMonitor;
    }

    public byte[] getBackupPayload(int userId) {
        Object r0 = this.mStagedDataLock;
        monitor-enter(r0);
        cleanStagedDataForOldEntriesLocked(userId);     // Catch: Throwable -> L31
        monitor-exit(r0);     // Catch: Throwable -> L31
        HashMap<String, LocalesInfo> pkgStates = new HashMap();
        Iterator r1 = this.mPackageManager.getInstalledApplicationsAsUser(PackageManager.ApplicationInfoFlags.of(0), userId).iterator();
    L8:
        if (r1.hasNext() == false) goto L22;
        ApplicationInfo appInfo = (ApplicationInfo) r1.next();
        LocaleList appLocales = this.mLocaleManagerService.getApplicationLocales(appInfo.packageName, userId);     // Catch: Throwable -> L15
        if (appLocales.isEmpty() == true) goto L8;
        boolean localeSetFromDelegate = false;
        if (this.mDelegateAppLocalePackages == null) goto L17;
        localeSetFromDelegate = this.mDelegateAppLocalePackages.getStringSet(Integer.toString(userId), Collections.emptySet()).contains(appInfo.packageName);     // Catch: Throwable -> L15
    L17:
        LocalesInfo localesInfo = new LocalesInfo(appLocales.toLanguageTags(), localeSetFromDelegate);     // Catch: Throwable -> L15
        pkgStates.put(appInfo.packageName, localesInfo);     // Catch: Throwable -> L15
    L15:
        e = move-exception;
        Slog.e(TAG, "Exception when getting locales for package: " + appInfo.packageName, e);
        goto L8
    L22:
        if (pkgStates.isEmpty() == false) goto L24;
        return null;
    L24:
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        writeToXml(out, pkgStates);     // Catch: IOException -> L28
        return out.toByteArray();
    L28:
        e = move-exception;
        Slog.e(TAG, "Could not write to xml for backup ", e);
        return null;
    L31:
        th = move-exception;
        throw th;
    }

    private void cleanStagedDataForOldEntriesLocked(int userId) {
        Long created_time = Long.valueOf(getStagedDataSp(userId).getLong(KEY_STAGED_DATA_TIME, -1));
        if (created_time.longValue() != (-1)) goto L5;
        return;
    L5:
        if (created_time.longValue() >= (this.mClock.millis() - STAGE_DATA_RETENTION_PERIOD.toMillis())) goto L9;
        deleteStagedDataLocked(userId);
        return;
    }

    public void stageAndApplyRestoredPayload(byte[] payload, int userId) {
        if (payload != null) goto L5;
        Slog.e(TAG, "stageAndApplyRestoredPayload: no payload to restore for user " + userId);
        return;
    L5:
        ByteArrayInputStream inputStream = new ByteArrayInputStream(payload);
        TypedXmlPullParser parser = Xml.newFastPullParser();     // Catch: Throwable -> L26
        parser.setInput(inputStream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L26
        XmlUtils.beginDocument(parser, "locales");     // Catch: Throwable -> L26
        HashMap<String, LocalesInfo> pkgStates = readFromXml(parser);     // Catch: Throwable -> L26
        Object r1 = this.mStagedDataLock;
        monitor-enter(r1);
        Iterator<String> r3 = pkgStates.keySet().iterator();     // Catch: Throwable -> L15
    L11:
        if (r3.hasNext() == false) goto L20;
        String pkgName = r3.next();     // Catch: Throwable -> L15
        LocalesInfo localesInfo = pkgStates.get(pkgName);     // Catch: Throwable -> L15
        if (isPackageInstalledForUser(pkgName, userId) == false) goto L17;
        removeFromArchivedPackagesInfo(userId, pkgName);     // Catch: Throwable -> L15
        checkExistingLocalesAndApplyRestore(pkgName, localesInfo, userId);     // Catch: Throwable -> L15
        goto L11
    L17:
        storeStagedDataInfo(userId, pkgName, localesInfo);     // Catch: Throwable -> L15
        goto L11
    L20:
        if (getStagedDataSp(userId).getAll().isEmpty() == true) goto L22;
        storeStagedDataCreatedTime(userId);     // Catch: Throwable -> L15
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L26:
        e = move-exception;
        Slog.e(TAG, "Could not parse payload ", e);
    }

    public void notifyBackupManager() {
        BackupManager.dataChanged("android");
    }

    void onPackageAddedWithExtras(String packageName, int uid, Bundle extras) {
        int userId = UserHandle.getUserId(uid);
        if (extras == null) goto L7;
        boolean archived = extras.getBoolean("android.intent.extra.ARCHIVAL", false);
        if (archived == false) goto L7;
        addInArchivedPackagesInfo(userId, packageName);
    L7:
        checkStageDataAndApplyRestore(packageName, userId);
    }

    void onPackageUpdateFinished(String packageName, int uid) {
        int userId = UserHandle.getUserId(uid);
        String user = Integer.toString(userId);
        File file = getArchivedPackagesFile();
        if (file.exists() == false) goto L18;
        SharedPreferences sp = getArchivedPackagesSp(file);
        Set<String> packageNames = new ArraySet(sp.getStringSet(user, new ArraySet()));
        if (packageNames.remove(packageName) == false) goto L18;
        SharedPreferences.Editor editor = sp.edit();
        if (packageNames.isEmpty() == false) goto L15;
        if (editor.remove(user).commit() == true) goto L12;
        Slog.e(TAG, "Failed to remove the user");
    L12:
        if (sp.getAll().isEmpty() == false) goto L17;
        file.delete();
    L17:
        checkStageDataAndApplyRestore(packageName, userId);
        goto L18
    L15:
        if (editor.putStringSet(user, packageNames).commit() == true) goto L17;
        Slog.e(TAG, "failed to remove the package");
    L18:
        cleanApplicationLocalesIfNeeded(packageName, userId);
    }

    void onPackageDataCleared(String packageName, int uid) {
        notifyBackupManager();     // Catch: Exception -> L4
        int userId = UserHandle.getUserId(uid);     // Catch: Exception -> L4
        removePackageFromPersistedInfo(packageName, userId);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Exception in onPackageDataCleared.", e);
    }

    void onPackageRemoved(String packageName, int uid) {
        notifyBackupManager();     // Catch: Exception -> L4
        int userId = UserHandle.getUserId(uid);     // Catch: Exception -> L4
        removePackageFromPersistedInfo(packageName, userId);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Exception in onPackageRemoved.", e);
    }

    private void checkStageDataAndApplyRestore(String packageName, int userId) {
        Object r0 = this.mStagedDataLock;     // Catch: Exception -> L13
        monitor-enter(r0);     // Catch: Exception -> L13
        cleanStagedDataForOldEntriesLocked(userId);     // Catch: Throwable -> L7
        if (getStagedDataSp(userId).getString(packageName, "").isEmpty() == true) goto L9;
        removeFromArchivedPackagesInfo(userId, packageName);     // Catch: Throwable -> L7
        doLazyRestoreLocked(packageName, userId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    L20:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Exception in onPackageAdded.", e);
    }

    private boolean isPackageInstalledForUser(String packageName, int userId) {
        PackageInfo pkgInfo = null;
        pkgInfo = this.mContext.getPackageManager().getPackageInfoAsUser(packageName, 0, userId);     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (pkgInfo == null) goto L11;
        return true;
    L11:
        return false;
    }

    private void checkExistingLocalesAndApplyRestore(String pkgName, LocalesInfo localesInfo, int userId) {
        if (localesInfo != null) goto L22;
        Slog.w(TAG, "No locales info for " + pkgName);
        return;
    L22:
        LocaleList currLocales = this.mLocaleManagerService.getApplicationLocales(pkgName, userId);     // Catch: Throwable -> L10
        if (currLocales.isEmpty() == true) goto L24;
        return;
    L24:
        String pkgName2 = pkgName;
        this.mLocaleManagerService.setApplicationLocales(pkgName2, userId, LocaleList.forLanguageTags(localesInfo.mLocales), localesInfo.mSetFromDelegate, 3);     // Catch: Throwable -> L16
        return;
    L16:
        e = move-exception;
        Exception e = e;
    L20:
        Slog.e(TAG, "Could not restore locales for " + pkgName2, e);
        return;
    L18:
        e = move-exception;
        pkgName2 = pkgName;
        e = e;
    L10:
        e = move-exception;
        Slog.e(TAG, "Could not check for current locales before restoring", e);
        goto L24
    }

    void deleteStagedDataLocked(int userId) {
        File stagedFile = getStagedDataFile(userId);
        SharedPreferences sp = getStagedDataSp(stagedFile);
        if (sp.edit().clear().commit() == true) goto L6;
        Slog.e(TAG, "Failed to commit data!");
    L6:
        if (stagedFile.exists() == false) goto L9;
        stagedFile.delete();
        return;
    }

    private HashMap<String, LocalesInfo> readFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        HashMap<String, LocalesInfo> packageStates = new HashMap();
        int depth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L13;
        if (parser.getName().equals("package") == false) goto L4;
        String packageName = parser.getAttributeValue(null, "name");
        String languageTags = parser.getAttributeValue(null, "locales");
        boolean delegateSelector = parser.getAttributeBoolean(null, ATTR_DELEGATE_SELECTOR, false);
        if (TextUtils.isEmpty(packageName) == true) goto L4;
        if (TextUtils.isEmpty(languageTags) == true) goto L4;
        LocalesInfo localesInfo = new LocalesInfo(languageTags, delegateSelector);
        packageStates.put(packageName, localesInfo);
        goto L4
    L13:
        return packageStates;
    }

    private static void writeToXml(OutputStream stream, HashMap<String, LocalesInfo> pkgStates) throws IOException {
        if (pkgStates.isEmpty() == false) goto L5;
        return;
    L5:
        TypedXmlSerializer out = Xml.newFastSerializer();
        out.setOutput(stream, StandardCharsets.UTF_8.name());
        out.startDocument(null, true);
        out.startTag(null, "locales");
        Iterator<String> r3 = pkgStates.keySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        String pkg = r3.next();
        out.startTag(null, "package");
        out.attribute(null, "name", pkg);
        out.attribute(null, "locales", pkgStates.get(pkg).mLocales);
        out.attributeBoolean(null, ATTR_DELEGATE_SELECTOR, pkgStates.get(pkg).mSetFromDelegate);
        out.endTag(null, "package");
        goto L7
    L9:
        out.endTag(null, "locales");
        out.endDocument();
    }

    private void doLazyRestoreLocked(String packageName, int userId) {
        if (isPackageInstalledForUser(packageName, userId) == true) goto L6;
        Slog.e(TAG, packageName + " not installed for user " + userId + ". Could not restore locales from stage data");
        return;
    L6:
        SharedPreferences sp = getStagedDataSp(userId);
        String value = sp.getString(packageName, "");
        if (value.isEmpty() == true) goto L19;
        String[] info = value.split(STRING_SPLIT);
        if (info != null) goto L11;
    L16:
        Slog.e(TAG, "Failed to restore data");
        return;
    L11:
        if (info.length != 2) goto L16;
        LocalesInfo localesInfo = new LocalesInfo(info[0], Boolean.parseBoolean(info[1]));
        checkExistingLocalesAndApplyRestore(packageName, localesInfo, userId);
        if (sp.edit().remove(packageName).commit() == true) goto L19;
        Slog.e(TAG, "Failed to commit data!");
    L19:
        if (sp.getAll().size() == 1) goto L21;
        return;
    L21:
        if (sp.getLong(KEY_STAGED_DATA_TIME, -1) == (-1)) goto L25;
        deleteStagedDataLocked(userId);
        return;
    }

    private File getStagedDataFile(int userId) {
        if (this.mStagedDataFiles != null) goto L6;
        return new File(Environment.getDataSystemDeDirectory(userId), LOCALES_STAGED_DATA_PREFS);
    L6:
        return this.mStagedDataFiles.get(userId);
    }

    private SharedPreferences getStagedDataSp(File file) {
        if (this.mStagedDataFiles != null) goto L6;
        return this.mContext.createDeviceProtectedStorageContext().getSharedPreferences(file, 0);
    L6:
        return this.mContext.getSharedPreferences(file, 0);
    }

    private SharedPreferences getStagedDataSp(int userId) {
        if (this.mStagedDataFiles != null) goto L6;
        return this.mContext.createDeviceProtectedStorageContext().getSharedPreferences(getStagedDataFile(userId), 0);
    L6:
        return this.mContext.getSharedPreferences(this.mStagedDataFiles.get(userId), 0);
    }

    private void storeStagedDataInfo(int userId, String packageName, LocalesInfo localesInfo) {
        String info = localesInfo.mLocales + STRING_SPLIT + String.valueOf(localesInfo.mSetFromDelegate);
        SharedPreferences sp = getStagedDataSp(userId);
        if (sp.edit().putString(packageName, info).commit() == true) goto L6;
        Slog.e(TAG, "Failed to commit data!");
        return;
    }

    private void storeStagedDataCreatedTime(int userId) {
        SharedPreferences sp = getStagedDataSp(userId);
        if (sp.edit().putLong(KEY_STAGED_DATA_TIME, this.mClock.millis()).commit() == true) goto L6;
        Slog.e(TAG, "Failed to commit data!");
        return;
    }

    private File getArchivedPackagesFile() {
        if (this.mArchivedPackagesFile != null) goto L6;
        return new File(Environment.getDataSystemDeDirectory(0), ARCHIVED_PACKAGES_PREFS);
    L6:
        return this.mArchivedPackagesFile;
    }

    private SharedPreferences getArchivedPackagesSp(File file) {
        if (this.mArchivedPackagesFile != null) goto L6;
        return this.mContext.createDeviceProtectedStorageContext().getSharedPreferences(file, 0);
    L6:
        return this.mContext.getSharedPreferences(file, 0);
    }

    private void addInArchivedPackagesInfo(int userId, String packageName) {
        String user = Integer.toString(userId);
        SharedPreferences sp = getArchivedPackagesSp(getArchivedPackagesFile());
        Set<String> packageNames = new ArraySet(sp.getStringSet(user, new ArraySet()));
        if (packageNames.add(packageName) == true) goto L5;
        return;
    L5:
        if (sp.edit().putStringSet(user, packageNames).commit() == true) goto L9;
        Slog.e(TAG, "failed to add the package");
        return;
    }

    private void removeFromArchivedPackagesInfo(int userId, String packageName) {
        File file = getArchivedPackagesFile();
        if (file.exists() == false) goto L18;
        String user = Integer.toString(userId);
        SharedPreferences sp = getArchivedPackagesSp(getArchivedPackagesFile());
        Set<String> packageNames = new ArraySet(sp.getStringSet(user, new ArraySet()));
        if (packageNames.remove(packageName) == false) goto L19;
        SharedPreferences.Editor editor = sp.edit();
        if (packageNames.isEmpty() == false) goto L15;
        if (editor.remove(user).commit() == true) goto L12;
        Slog.e(TAG, "Failed to remove user");
    L12:
        if (sp.getAll().isEmpty() == false) goto L20;
        file.delete();
        return;
    L20:
        return;
    L15:
        if (editor.putStringSet(user, packageNames).commit() == true) goto L22;
        Slog.e(TAG, "failed to remove the package");
        return;
    L22:
        return;
    L19:
        return;
    }

    private void removeArchivedPackagesForUser(int userId) {
        String user = Integer.toString(userId);
        File file = getArchivedPackagesFile();
        SharedPreferences sp = getArchivedPackagesSp(file);
        if (sp != null) goto L5;
    L16:
        Slog.w(TAG, "The profile is not existed in the archived package info");
        return;
    L5:
        if (sp.contains(user) == false) goto L16;
        if (sp.edit().remove(user).commit() == true) goto L11;
        Slog.e(TAG, "Failed to remove user");
    L11:
        if (sp.getAll().isEmpty() == true) goto L13;
        return;
    L13:
        if (file.exists() == false) goto L19;
        file.delete();
        return;
    }

    SharedPreferences createPersistedInfo() {
        File prefsFile = new File(Environment.getDataSystemDeDirectory(0), LOCALES_FROM_DELEGATE_PREFS);
        return this.mContext.createDeviceProtectedStorageContext().getSharedPreferences(prefsFile, 0);
    }

    public SharedPreferences getPersistedInfo() {
        return this.mDelegateAppLocalePackages;
    }

    private void removePackageFromPersistedInfo(String packageName, int userId) {
        if (this.mDelegateAppLocalePackages != null) goto L6;
        Slog.w(TAG, "Failed to persist data into the shared preference!");
        return;
    L6:
        String key = Integer.toString(userId);
        Set<String> packageNames = new ArraySet(this.mDelegateAppLocalePackages.getStringSet(key, new ArraySet()));
        if (packageNames.contains(packageName) == false) goto L12;
        packageNames.remove(packageName);
        SharedPreferences.Editor editor = this.mDelegateAppLocalePackages.edit();
        editor.putStringSet(key, packageNames);
        if (editor.commit() == true) goto L13;
        Slog.e(TAG, "Failed to commit data!");
        return;
    L13:
        return;
    }

    private void removeProfileFromPersistedInfo(int userId) {
        String key = Integer.toString(userId);
        if (this.mDelegateAppLocalePackages != null) goto L5;
    L11:
        Slog.w(TAG, "The profile is not existed in the persisted info");
        return;
    L5:
        if (this.mDelegateAppLocalePackages.contains(key) == false) goto L11;
        if (this.mDelegateAppLocalePackages.edit().remove(key).commit() == true) goto L13;
        Slog.e(TAG, "Failed to commit data!");
        return;
    }

    void persistLocalesModificationInfo(int userId, String packageName, boolean fromDelegate, boolean emptyLocales) {
        if (this.mDelegateAppLocalePackages != null) goto L6;
        Slog.w(TAG, "Failed to persist data into the shared preference!");
        return;
    L6:
        SharedPreferences.Editor editor = this.mDelegateAppLocalePackages.edit();
        String user = Integer.toString(userId);
        Set<String> packageNames = new ArraySet(this.mDelegateAppLocalePackages.getStringSet(user, new ArraySet()));
        if (fromDelegate == false) goto L13;
        if (emptyLocales == true) goto L13;
        if (packageNames.contains(packageName) == true) goto L16;
        packageNames.add(packageName);
        editor.putStringSet(user, packageNames);
    L16:
        if (editor.commit() == true) goto L19;
        Slog.e(TAG, "failed to commit locale setter info");
        return;
    L19:
        return;
    L13:
        if (packageNames.contains(packageName) == false) goto L16;
        packageNames.remove(packageName);
        editor.putStringSet(user, packageNames);
        goto L16
    }

    boolean areLocalesSetFromDelegate(int userId, String packageName) {
        if (this.mDelegateAppLocalePackages != null) goto L6;
        Slog.w(TAG, "Failed to persist data into the shared preference!");
        return false;
    L6:
        String user = Integer.toString(userId);
        Set<String> packageNames = new ArraySet(this.mDelegateAppLocalePackages.getStringSet(user, new ArraySet()));
        return packageNames.contains(packageName);
    }

    private void cleanApplicationLocalesIfNeeded(String packageName, int userId) {
        if (this.mDelegateAppLocalePackages != null) goto L6;
        Slog.w(TAG, "Failed to persist data into the shared preference!");
        return;
    L6:
        String user = Integer.toString(userId);
        Set<String> packageNames = new ArraySet(this.mDelegateAppLocalePackages.getStringSet(user, new ArraySet()));
        LocaleList appLocales = this.mLocaleManagerService.getApplicationLocales(packageName, userId);     // Catch: Throwable -> L18
        if (appLocales.isEmpty() == true) goto L20;
        if (packageNames.contains(packageName) == false) goto L28;
        LocaleConfig localeConfig = new LocaleConfig(this.mContext.createPackageContextAsUser(packageName, 0, UserHandle.of(userId)));     // Catch: PackageManager.NameNotFoundException -> L15
        this.mLocaleManagerService.removeUnsupportedAppLocales(packageName, userId, localeConfig, 4);     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L15:
        e = move-exception;
        Slog.e(TAG, "Can not found the package name : " + packageName + " / " + e);
        return;
    L28:
        return;
    L20:
        return;
    L18:
        e = move-exception;
        Slog.e(TAG, "Exception when getting locales for " + packageName, e);
    }
}
