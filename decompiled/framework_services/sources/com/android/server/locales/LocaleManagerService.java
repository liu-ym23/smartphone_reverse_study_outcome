package com.android.server.locales;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ILocaleManager;
import android.app.LocaleConfig;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.LocaleList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.content.PackageMonitor;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.voiceinteraction.DatabaseHelper;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleManagerService extends SystemService {
    private static final String ATTR_NAME = "name";
    public static final boolean DEBUG = false;
    private static final String LOCALE_CONFIGS = "locale_configs";
    private static final String PROP_ALLOW_IME_QUERY_APP_LOCALE = "i18n.feature.allow_ime_query_app_locale";
    private static final String PROP_DYNAMIC_LOCALES_CHANGE = "i18n.feature.dynamic_locales_change";
    private static final String SUFFIX_FILE_NAME = ".xml";
    private static final String TAG = "LocaleManagerService";
    private ActivityManagerInternal mActivityManagerInternal;
    private ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private LocaleManagerBackupHelper mBackupHelper;
    private final LocaleManagerBinderService mBinderService;
    final Context mContext;
    private PackageManager mPackageManager;
    private final PackageMonitor mPackageMonitor;
    private final Object mWriteLock;

    private final class LocaleManagerBinderService extends ILocaleManager.Stub {
        final /* synthetic */ LocaleManagerService this$0;

        /* synthetic */ LocaleManagerBinderService(LocaleManagerService r1, LocaleManagerServiceIA r2) {
            this(r1);
        }

        private LocaleManagerBinderService(LocaleManagerService r1) {
            this.this$0 = r1;
        }

        public void setApplicationLocales(String appPackageName, int userId, LocaleList locales, boolean fromDelegate) throws RemoteException {
            if (fromDelegate == false) goto L4;
            int r0 = 1;
        L5:
            int caller = r0;
            this.this$0.setApplicationLocales(appPackageName, userId, locales, fromDelegate, caller);
            return;
        L4:
            r0 = 2;
            goto L5
        }

        public LocaleList getApplicationLocales(String appPackageName, int userId) throws RemoteException {
            return this.this$0.getApplicationLocales(appPackageName, userId);
        }

        public LocaleList getSystemLocales() throws RemoteException {
            return this.this$0.getSystemLocales();
        }

        public void setOverrideLocaleConfig(String appPackageName, int userId, LocaleConfig localeConfig) throws RemoteException {
            this.this$0.setOverrideLocaleConfig(appPackageName, userId, localeConfig);
        }

        public LocaleConfig getOverrideLocaleConfig(String appPackageName, int userId) {
            return this.this$0.getOverrideLocaleConfig(appPackageName, userId);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new LocaleManagerShellCommand(LocaleManagerService.m5109$$Nest$fgetmBinderService(this.this$0), this.this$0.mContext).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    private final class LocaleManagerInternalImpl extends LocaleManagerInternal {
        final /* synthetic */ LocaleManagerService this$0;

        /* synthetic */ LocaleManagerInternalImpl(LocaleManagerService r1, LocaleManagerServiceIA r2) {
            this(r1);
        }

        private LocaleManagerInternalImpl(LocaleManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.locales.LocaleManagerInternal
        public byte[] getBackupPayload(int userId) {
            checkCallerIsSystem();
            return LocaleManagerService.m5108$$Nest$fgetmBackupHelper(this.this$0).getBackupPayload(userId);
        }

        @Override // com.android.server.locales.LocaleManagerInternal
        public void stageAndApplyRestoredPayload(byte[] payload, int userId) {
            LocaleManagerService.m5108$$Nest$fgetmBackupHelper(this.this$0).stageAndApplyRestoredPayload(payload, userId);
        }

        private void checkCallerIsSystem() {
            if (Binder.getCallingUid() != 1000) goto L6;
            return;
        L6:
            throw new SecurityException("Caller is not system.");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocaleManagerBackupHelper m5108$$Nest$fgetmBackupHelper(LocaleManagerService r0) {
        return r0.mBackupHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinderService, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocaleManagerBinderService m5109$$Nest$fgetmBinderService(LocaleManagerService r0) {
        return r0.mBinderService;
    }

    public LocaleManagerService(Context context) {
        super(context);
        this.mWriteLock = new Object();
        this.mContext = context;
        this.mBinderService = new LocaleManagerBinderService(this, null);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mPackageManager = this.mContext.getPackageManager();
        HandlerThread broadcastHandlerThread = new HandlerThread(TAG, 10);
        broadcastHandlerThread.start();
        final SystemAppUpdateTracker systemAppUpdateTracker = new SystemAppUpdateTracker(this);
        broadcastHandlerThread.getThreadHandler().postAtFrontOfQueue(new AnonymousClass1(this, systemAppUpdateTracker));
        this.mBackupHelper = new LocaleManagerBackupHelper(this, this.mPackageManager, broadcastHandlerThread);
        this.mPackageMonitor = new LocaleManagerServicePackageMonitor(this.mBackupHelper, systemAppUpdateTracker, this);
        this.mPackageMonitor.register(context, broadcastHandlerThread.getLooper(), UserHandle.ALL, true);
    }

    LocaleManagerService(Context context, ActivityTaskManagerInternal activityTaskManagerInternal, ActivityManagerInternal activityManagerInternal, PackageManager packageManager, LocaleManagerBackupHelper localeManagerBackupHelper, PackageMonitor packageMonitor) {
        super(context);
        this.mWriteLock = new Object();
        this.mContext = context;
        this.mBinderService = new LocaleManagerBinderService(this, null);
        this.mActivityTaskManagerInternal = activityTaskManagerInternal;
        this.mActivityManagerInternal = activityManagerInternal;
        this.mPackageManager = packageManager;
        this.mBackupHelper = localeManagerBackupHelper;
        this.mPackageMonitor = packageMonitor;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService(DatabaseHelper.SoundModelContract.KEY_LOCALE, this.mBinderService);
        LocalServices.addService(LocaleManagerInternal.class, new LocaleManagerInternalImpl(this, null));
    }

    public void setApplicationLocales(String appPackageName, int userId, LocaleList locales, boolean fromDelegate, int caller) throws RemoteException, IllegalArgumentException {
        AppLocaleChangedAtomRecord atomRecordForMetrics = new AppLocaleChangedAtomRecord(Binder.getCallingUid());
        appPackageName.getClass();     // Catch: Throwable -> L22
        locales.getClass();     // Catch: Throwable -> L22
        atomRecordForMetrics.setCaller(caller);     // Catch: Throwable -> L22
        atomRecordForMetrics.setNewLocales(locales.toLanguageTags());     // Catch: Throwable -> L22
        int userId2 = this.mActivityManagerInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 0, "setApplicationLocales", null);     // Catch: Throwable -> L20
        boolean isCallerOwner = isPackageOwnedByCaller(appPackageName, userId2, atomRecordForMetrics, null);     // Catch: Throwable -> L10
        if (isCallerOwner == true) goto L12;
        enforceChangeConfigurationPermission(atomRecordForMetrics);     // Catch: Throwable -> L10
    L12:
        this.mBackupHelper.persistLocalesModificationInfo(userId2, appPackageName, fromDelegate, locales.isEmpty());     // Catch: Throwable -> L10
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        setApplicationLocalesUnchecked(appPackageName, userId2, locales, atomRecordForMetrics);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L10
        logAppLocalesMetric(atomRecordForMetrics);
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = th;
    L24:
        logAppLocalesMetric(atomRecordForMetrics);
        throw th;
    L20:
        th = th;
    L22:
        th = th;
        goto L24
    }

    private void setApplicationLocalesUnchecked(String appPackageName, int userId, LocaleList locales, AppLocaleChangedAtomRecord atomRecordForMetrics) {
        atomRecordForMetrics.setPrevLocales(getApplicationLocalesUnchecked(appPackageName, userId).toLanguageTags());
        ActivityTaskManagerInternal.PackageConfigurationUpdater updater = this.mActivityTaskManagerInternal.createPackageConfigurationUpdater(appPackageName, userId);
        boolean isConfigChanged = updater.setLocales(locales).commit();
        if (isConfigChanged == false) goto L5;
        notifyAppWhoseLocaleChanged(appPackageName, userId, locales);
        notifyInstallerOfAppWhoseLocaleChanged(appPackageName, userId, locales);
        notifyRegisteredReceivers(appPackageName, userId, locales);
        this.mBackupHelper.notifyBackupManager();
        atomRecordForMetrics.setStatus(1);
        return;
    L5:
        atomRecordForMetrics.setStatus(2);
    }

    private void notifyRegisteredReceivers(String appPackageName, int userId, LocaleList locales) {
        Intent intent = createBaseIntent("android.intent.action.APPLICATION_LOCALE_CHANGED", appPackageName, locales);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId), "android.permission.READ_APP_SPECIFIC_LOCALES");
    }

    void notifyInstallerOfAppWhoseLocaleChanged(String appPackageName, int userId, LocaleList locales) {
        String installingPackageName = getInstallingPackageName(appPackageName, userId);
        if (installingPackageName == null) goto L6;
        Intent intent = createBaseIntent("android.intent.action.APPLICATION_LOCALE_CHANGED", appPackageName, locales);
        intent.setPackage(installingPackageName);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId));
        return;
    }

    private void notifyAppWhoseLocaleChanged(String appPackageName, int userId, LocaleList locales) {
        Intent intent = createBaseIntent("android.intent.action.LOCALE_CHANGED", appPackageName, locales);
        intent.setPackage(appPackageName);
        intent.addFlags(2097152);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId));
    }

    static Intent createBaseIntent(String intentAction, String appPackageName, LocaleList locales) {
        return new Intent(intentAction).putExtra("android.intent.extra.PACKAGE_NAME", appPackageName).putExtra("android.intent.extra.LOCALE_LIST", locales).addFlags(AudioFormat.EVRCB);
    }

    private boolean isPackageOwnedByCaller(String appPackageName, int userId, AppLocaleChangedAtomRecord atomRecordForMetrics, AppSupportedLocalesChangedAtomRecord appSupportedLocalesChangedAtomRecord) {
        int uid = getPackageUid(appPackageName, userId);
        if (uid >= 0) goto L11;
        Slog.w(TAG, "Unknown package " + appPackageName + " for user " + userId);
        if (atomRecordForMetrics != null) goto L8;
        if (appSupportedLocalesChangedAtomRecord == null) goto L10;
        appSupportedLocalesChangedAtomRecord.setStatus(3);
    L10:
        throw new IllegalArgumentException("Unknown package: " + appPackageName + " for user " + userId);
    L8:
        atomRecordForMetrics.setStatus(3);
        goto L10
    L11:
        if (atomRecordForMetrics == null) goto L13;
        atomRecordForMetrics.setTargetUid(uid);
    L16:
        return UserHandle.isSameApp(Binder.getCallingUid(), uid);
    L13:
        if (appSupportedLocalesChangedAtomRecord == null) goto L16;
        appSupportedLocalesChangedAtomRecord.setTargetUid(uid);
        goto L16
    }

    private void enforceChangeConfigurationPermission(AppLocaleChangedAtomRecord atomRecordForMetrics) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CHANGE_CONFIGURATION", "setApplicationLocales");     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        atomRecordForMetrics.setStatus(4);
        throw e;
    }

    public LocaleList getApplicationLocales(String appPackageName, int userId) throws RemoteException, IllegalArgumentException {
        appPackageName.getClass();
        int userId2 = this.mActivityManagerInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 0, "getApplicationLocales", null);
        if (isPackageOwnedByCaller(appPackageName, userId2, null, null) == false) goto L5;
    L11:
        long token = Binder.clearCallingIdentity();
        LocaleList r0 = getApplicationLocalesUnchecked(appPackageName, userId2);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return r0;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        if (isCallerInstaller(appPackageName, userId2) == true) goto L11;
        if (isCallerFromCurrentInputMethod(userId2) == true) goto L9;
    L10:
        enforceReadAppSpecificLocalesPermission();
        goto L11
    L9:
        if (this.mActivityManagerInternal.isAppForeground(getPackageUid(appPackageName, userId2)) == true) goto L11;
        goto L10
    }

    private LocaleList getApplicationLocalesUnchecked(String appPackageName, int userId) {
        ActivityTaskManagerInternal.PackageConfig appConfig = this.mActivityTaskManagerInternal.getApplicationConfig(appPackageName, userId);
        if (appConfig == null) goto L5;
        LocaleList locales = appConfig.mLocales;
        if (locales == null) goto L10;
        return locales;
    L10:
        return LocaleList.getEmptyLocaleList();
    L5:
        return LocaleList.getEmptyLocaleList();
    }

    private boolean isCallerInstaller(String appPackageName, int userId) {
        String installingPackageName = getInstallingPackageName(appPackageName, userId);
        if (installingPackageName == null) goto L10;
        int installerUid = getPackageUid(installingPackageName, userId);
        if (installerUid >= 0) goto L7;
        return false;
    L7:
        if (UserHandle.isSameApp(Binder.getCallingUid(), installerUid) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private boolean isCallerFromCurrentInputMethod(int userId) {
        if (SystemProperties.getBoolean(PROP_ALLOW_IME_QUERY_APP_LOCALE, true) == true) goto L5;
        return false;
    L5:
        String currentInputMethod = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "default_input_method", userId);
        if (TextUtils.isEmpty(currentInputMethod) == true) goto L18;
        ComponentName componentName = ComponentName.unflattenFromString(currentInputMethod);
        if (componentName != null) goto L11;
        Slog.d(TAG, "inValid input method");
        return false;
    L11:
        String inputMethodPkgName = componentName.getPackageName();
        int inputMethodUid = getPackageUid(inputMethodPkgName, userId);
        if (inputMethodUid < 0) goto L17;
        if (UserHandle.isSameApp(Binder.getCallingUid(), inputMethodUid) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    private void enforceReadAppSpecificLocalesPermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_APP_SPECIFIC_LOCALES", "getApplicationLocales");
    }

    private int getPackageUid(String appPackageName, int userId) {
        return this.mPackageManager.getPackageUidAsUser(appPackageName, PackageManager.PackageInfoFlags.of(0), userId);
    L5:
        return -1;
    }

    String getInstallingPackageName(String packageName, int userId) {
        return this.mContext.createContextAsUser(UserHandle.of(userId), 0).getPackageManager().getInstallSourceInfo(packageName).getInstallingPackageName();
    L5:
        Slog.w(TAG, "Package not found " + packageName);
        return null;
    }

    public LocaleList getSystemLocales() throws RemoteException {
        long token = Binder.clearCallingIdentity();
        LocaleList r2 = getSystemLocalesUnchecked();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private LocaleList getSystemLocalesUnchecked() throws RemoteException {
        LocaleList systemLocales = null;
        Configuration conf = ActivityManager.getService().getConfiguration();
        if (conf == null) goto L5;
        systemLocales = conf.getLocales();
    L5:
        if (systemLocales != null) goto L8;
        LocaleList systemLocales2 = LocaleList.getEmptyLocaleList();
        return systemLocales2;
    L8:
        return systemLocales;
    }

    private void logAppLocalesMetric(AppLocaleChangedAtomRecord atomRecordForMetrics) {
        FrameworkStatsLog.write(412, atomRecordForMetrics.mCallingUid, atomRecordForMetrics.mTargetUid, atomRecordForMetrics.mNewLocales, atomRecordForMetrics.mPrevLocales, atomRecordForMetrics.mStatus, atomRecordForMetrics.mCaller);
    }

    public void setOverrideLocaleConfig(String appPackageName, int userId, LocaleConfig localeConfig) throws IllegalArgumentException {
        if (SystemProperties.getBoolean(PROP_DYNAMIC_LOCALES_CHANGE, true) == true) goto L5;
        return;
    L5:
        AppSupportedLocalesChangedAtomRecord atomRecord = new AppSupportedLocalesChangedAtomRecord(Binder.getCallingUid());
        appPackageName.getClass();     // Catch: Throwable -> L25
        int userId2 = this.mActivityManagerInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 0, "setOverrideLocaleConfig", null);     // Catch: Throwable -> L23
    L13:
        th = th;
    L27:
        logAppSupportedLocalesChangedMetric(atomRecord);
        throw th;
    L11:
        if (isPackageOwnedByCaller(appPackageName, userId2, null, atomRecord) == true) goto L15;
        enforceSetAppSpecificLocaleConfigPermission(atomRecord);     // Catch: Throwable -> L13
    L15:
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        setOverrideLocaleConfigUnchecked(appPackageName, userId2, localeConfig, atomRecord);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L13
        logAppSupportedLocalesChangedMetric(atomRecord);
        return;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L23:
        th = th;
    L25:
        th = th;
        goto L27
    }

    private void setOverrideLocaleConfigUnchecked(String appPackageName, int userId, LocaleConfig overrideLocaleConfig, AppSupportedLocalesChangedAtomRecord atomRecord) {
        Object r0 = this.mWriteLock;
        monitor-enter(r0);
        LocaleConfig resLocaleConfig = LocaleConfig.fromContextIgnoringOverride(this.mContext.createPackageContextAsUser(appPackageName, 0, UserHandle.of(userId)));     // Catch: Throwable -> L11 PackageManager.NameNotFoundException -> L40
        File file = getXmlFileNameForUser(appPackageName, userId);     // Catch: Throwable -> L11
        if (overrideLocaleConfig != null) goto L17;
        if (file.exists() == false) goto L13;
        Slog.d(TAG, "remove the override LocaleConfig");     // Catch: Throwable -> L11
        file.delete();     // Catch: Throwable -> L11
    L13:
        removeUnsupportedAppLocales(appPackageName, userId, resLocaleConfig, 5);     // Catch: Throwable -> L11
        atomRecord.setOverrideRemoved(true);     // Catch: Throwable -> L11
        atomRecord.setStatus(1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L17:
        if (overrideLocaleConfig.isSameLocaleConfig(getOverrideLocaleConfig(appPackageName, userId)) == false) goto L21;
        Slog.d(TAG, "the same override, ignore it");     // Catch: Throwable -> L11
        atomRecord.setSameAsPrevConfig(true);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L21:
        LocaleList localeList = overrideLocaleConfig.getSupportedLocales();     // Catch: Throwable -> L11
        if (localeList != null) goto L24;
        localeList = LocaleList.getEmptyLocaleList();     // Catch: Throwable -> L11
    L24:
        atomRecord.setNumLocales(localeList.size());     // Catch: Throwable -> L11
        AtomicFile atomicFile = new AtomicFile(file);     // Catch: Throwable -> L11
        FileOutputStream stream = null;
        stream = atomicFile.startWrite();     // Catch: Throwable -> L11 Exception -> L33
        stream.write(toXmlByteArray(localeList));     // Catch: Throwable -> L11 Exception -> L33
        atomicFile.finishWrite(stream);     // Catch: Throwable -> L11
        removeUnsupportedAppLocales(appPackageName, userId, overrideLocaleConfig, 5);     // Catch: Throwable -> L11
        if (overrideLocaleConfig.isSameLocaleConfig(resLocaleConfig) == false) goto L30;
        Slog.d(TAG, "setOverrideLocaleConfig, same as the app's LocaleConfig");     // Catch: Throwable -> L11
        atomRecord.setSameAsResConfig(true);     // Catch: Throwable -> L11
    L30:
        atomRecord.setStatus(1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L33:
        e = move-exception;
        Slog.e(TAG, "Failed to write file " + atomicFile, e);     // Catch: Throwable -> L11
        if (stream == null) goto L37;
        atomicFile.failWrite(stream);     // Catch: Throwable -> L11
    L37:
        atomRecord.setStatus(2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L41:
        Slog.e(TAG, "Unknown package name " + appPackageName + " for user " + userId);     // Catch: Throwable -> L11
    }

    void removeUnsupportedAppLocales(String appPackageName, int userId, LocaleConfig localeConfig, int caller) {
        LocaleList appLocales = getApplicationLocalesUnchecked(appPackageName, userId);
        boolean resetAppLocales = false;
        List<Locale> newAppLocales = new ArrayList();
        if (localeConfig != null) goto L5;
        Slog.i(TAG, "There is no LocaleConfig, reset app locales");
        boolean resetAppLocales2 = true;
    L14:
        if (resetAppLocales2 == false) goto L26;
        Locale[] locales = new Locale[newAppLocales.size()];
        setApplicationLocales(appPackageName, userId, new LocaleList((Locale[]) newAppLocales.toArray(locales)), this.mBackupHelper.areLocalesSetFromDelegate(userId, appPackageName), caller);     // Catch: Throwable -> L18
        return;
    L18:
        e = move-exception;
        Slog.e(TAG, "Could not set locales for " + appPackageName, e);
        return;
    L26:
        return;
    L5:
        int i = 0;
    L7:
        if (i >= appLocales.size()) goto L13;
        if (localeConfig.containsLocale(appLocales.get(i)) == true) goto L11;
        Slog.i(TAG, "Missing from the LocaleConfig, reset app locales");
        resetAppLocales = true;
    L12:
        i = i + 1;
        goto L7
    L11:
        newAppLocales.add(appLocales.get(i));
        goto L12
    L13:
        resetAppLocales2 = resetAppLocales;
        goto L14
    }

    private void enforceSetAppSpecificLocaleConfigPermission(AppSupportedLocalesChangedAtomRecord atomRecord) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.SET_APP_SPECIFIC_LOCALECONFIG", "setOverrideLocaleConfig");     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        atomRecord.setStatus(4);
        throw e;
    }

    public LocaleConfig getOverrideLocaleConfig(String appPackageName, int userId) {
        if (SystemProperties.getBoolean(PROP_DYNAMIC_LOCALES_CHANGE, true) == true) goto L5;
        return null;
    L5:
        appPackageName.getClass();
        File file = getXmlFileNameForUser(appPackageName, this.mActivityManagerInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 0, "getOverrideLocaleConfig", null));
        if (file.exists() == true) goto L26;
        return null;
    L26:
        InputStream in = new FileInputStream(file);     // Catch: Throwable -> L13
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L15
        List<String> overrideLocales = loadFromXml(parser);     // Catch: Throwable -> L15
        LocaleConfig storedLocaleConfig = new LocaleConfig(LocaleList.forLanguageTags(String.join(",", overrideLocales)));     // Catch: Throwable -> L15
        in.close();     // Catch: Throwable -> L13 Throwable -> L13
        return storedLocaleConfig;
    L15:
        th = move-exception;
        in.close();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L13 Throwable -> L13
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13 Throwable -> L13
        throw th;     // Catch: Throwable -> L13 Throwable -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to parse XML configuration from " + file, e);
        return null;
    }

    void deleteOverrideLocaleConfig(String appPackageName, int userId) {
        File file = getXmlFileNameForUser(appPackageName, userId);
        if (file.exists() == false) goto L6;
        Slog.d(TAG, "Delete the override LocaleConfig.");
        file.delete();
        return;
    }

    private byte[] toXmlByteArray(LocaleList localeList) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();     // Catch: IOException -> L13
        TypedXmlSerializer out = Xml.newFastSerializer();     // Catch: Throwable -> L8
        out.setOutput(os, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L8
        out.startDocument(null, true);     // Catch: Throwable -> L8
        out.startTag(null, "locale-config");     // Catch: Throwable -> L8
        List<String> locales = new ArrayList(Arrays.asList(localeList.toLanguageTags().split(",")));     // Catch: Throwable -> L8
        Iterator<String> r6 = locales.iterator();     // Catch: Throwable -> L8
    L6:
        if (r6.hasNext() == false) goto L10;
        String locale = r6.next();     // Catch: Throwable -> L8
        out.startTag(null, DatabaseHelper.SoundModelContract.KEY_LOCALE);     // Catch: Throwable -> L8
        out.attribute(null, "name", locale);     // Catch: Throwable -> L8
        out.endTag(null, DatabaseHelper.SoundModelContract.KEY_LOCALE);     // Catch: Throwable -> L8
        goto L6
    L10:
        out.endTag(null, "locale-config");     // Catch: Throwable -> L8
        out.endDocument();     // Catch: Throwable -> L8
        byte[] r0 = os.toByteArray();     // Catch: Throwable -> L8
        os.close();     // Catch: IOException -> L13
        return r0;
    L8:
        th = move-exception;
        os.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L13
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L21:
        return null;
    }

    private List<String> loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        List<String> localeList = new ArrayList();
        XmlUtils.beginDocument(parser, "locale-config");
        int depth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L10;
        String tagName = parser.getName();
        if (DatabaseHelper.SoundModelContract.KEY_LOCALE.equals(tagName) == true) goto L7;
        Slog.w(TAG, "Unexpected tag name: " + tagName);
        XmlUtils.skipCurrentTag(parser);
        goto L4
    L7:
        String locale = parser.getAttributeValue(null, "name");
        localeList.add(locale);
        goto L4
    L10:
        return localeList;
    }

    private File getXmlFileNameForUser(String appPackageName, int userId) {
        File dir = new File(Environment.getDataSystemCeDirectory(userId), LOCALE_CONFIGS);
        return new File(dir, appPackageName + SUFFIX_FILE_NAME);
    }

    private void logAppSupportedLocalesChangedMetric(AppSupportedLocalesChangedAtomRecord atomRecord) {
        FrameworkStatsLog.write(FrameworkStatsLog.APP_SUPPORTED_LOCALES_CHANGED, atomRecord.mCallingUid, atomRecord.mTargetUid, atomRecord.mNumLocales, atomRecord.mOverrideRemoved, atomRecord.mSameAsResConfig, atomRecord.mSameAsPrevConfig, atomRecord.mStatus);
    }
}
