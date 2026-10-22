package com.android.server.backup;

import android.app.backup.BackupManagerInternal;
import android.app.backup.BackupRestoreEventLogger;
import android.app.backup.IBackupManager;
import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IBackupObserver;
import android.app.backup.IFullBackupRestoreObserver;
import android.app.backup.IRestoreSession;
import android.app.backup.ISelectBackupTransportCallback;
import android.app.compat.CompatChanges;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.FileUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.backup.utils.RandomAccessFileUtils;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BackupManagerService extends IBackupManager.Stub implements BackupManagerInternal {
    private static final String BACKUP_ACTIVATED_FILENAME = "backup-activated";
    private static final String BACKUP_DISABLE_PROPERTY = "ro.backup.disable";
    private static final String BACKUP_SUPPRESS_FILENAME = "backup-suppress";
    private static final String BACKUP_THREAD = "backup";
    public static final boolean DEBUG = false;
    static final String DUMP_RUNNING_USERS_MESSAGE = "Backup Manager is running for users:";
    private static final String REMEMBER_ACTIVATED_FILENAME = "backup-remember-activated";
    public static final String TAG = "BackupManagerService";
    static BackupManagerService sInstance;
    private final Context mContext;
    private int mDefaultBackupUserId;
    private final boolean mGlobalDisable;
    private final Handler mHandler;
    private boolean mHasFirstUserUnlockedSinceBoot;
    private final Object mStateLock;
    private final Set<ComponentName> mTransportWhitelist;
    private final UserManager mUserManager;
    private final BroadcastReceiver mUserRemovedReceiver;
    private final SparseArray<UserBackupManagerService> mUserServices;

    /* JADX INFO: renamed from: com.android.server.backup.BackupManagerService$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ BackupManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$-S5QMtscauAOp22BTub2cVMGVYQ, reason: not valid java name */
        public static /* synthetic */ void m2473$r8$lambda$S5QMtscauAOp22BTub2cVMGVYQ(AnonymousClass1 r0, int r1) {
            r0.lambda$onReceive$0(r1);
        }

        AnonymousClass1(BackupManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_REMOVED".equals(intent.getAction()) == false) goto L8;
            final int userId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
            if (userId <= 0) goto L9;
            BackupManagerService.m2469$$Nest$fgetmHandler(this.this$0).post(new BackupManagerService$1$$ExternalSyntheticLambda0(this, userId));
            return;
        L9:
            return;
        }

        private /* synthetic */ void lambda$onReceive$0(int userId) {
            BackupManagerService.m2471$$Nest$monRemovedNonSystemUser(this.this$0, userId);
        }
    }

    public static class Lifecycle extends SystemService {
        private final BackupManagerService mBackupManagerService;

        /* JADX INFO: renamed from: $r8$lambda$gdbi4zlGZGic5yYpC6rnH2b-N7A, reason: not valid java name */
        public static /* synthetic */ void m2474$r8$lambda$gdbi4zlGZGic5yYpC6rnH2bN7A(Lifecycle r0, SystemService.TargetUser r1) {
            r0.lambda$onUserUnlocking$0(r1);
        }

        public Lifecycle(Context context) {
            this(context, new BackupManagerService(context));
        }

        Lifecycle(Context context, BackupManagerService backupManagerService) {
            super(context);
            this.mBackupManagerService = backupManagerService;
            BackupManagerService.sInstance = backupManagerService;
            LocalServices.addService(BackupManagerInternal.class, this.mBackupManagerService);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishService("backup", this.mBackupManagerService);
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(final SystemService.TargetUser user) {
            this.mBackupManagerService.postToHandler(new BackupManagerService$Lifecycle$$ExternalSyntheticLambda0(this, user));
        }

        private /* synthetic */ void lambda$onUserUnlocking$0(SystemService.TargetUser user) {
            BackupManagerService.m2472$$Nest$mupdateDefaultBackupUserIdIfNeeded(this.mBackupManagerService);
            this.mBackupManagerService.startServiceForUser(user.getUserIdentifier());
            BackupManagerService.m2470$$Nest$fputmHasFirstUserUnlockedSinceBoot(this.mBackupManagerService, true);
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            this.mBackupManagerService.onStopUser(user.getUserIdentifier());
        }

        void publishService(String name, IBinder service) {
            publishBinderService(name, service);
        }
    }

    public static /* synthetic */ void $r8$lambda$V80FPZ5wqif8yKHR2AZ4_2Tr31I(BackupManagerService r0, int r1) {
        r0.lambda$onStopUser$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2469$$Nest$fgetmHandler(BackupManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasFirstUserUnlockedSinceBoot, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2470$$Nest$fputmHasFirstUserUnlockedSinceBoot(BackupManagerService r0, boolean r1) {
        r0.mHasFirstUserUnlockedSinceBoot = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$monRemovedNonSystemUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2471$$Nest$monRemovedNonSystemUser(BackupManagerService r0, int r1) {
        r0.onRemovedNonSystemUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDefaultBackupUserIdIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2472$$Nest$mupdateDefaultBackupUserIdIfNeeded(BackupManagerService r0) {
        r0.updateDefaultBackupUserIdIfNeeded();
    }

    static BackupManagerService getInstance() {
        BackupManagerService r0 = sInstance;
        r0.getClass();
        return r0;
    }

    public BackupManagerService(Context context) {
        this.mStateLock = new Object();
        this.mUserRemovedReceiver = new AnonymousClass1(this);
        int r0 = 0;
        this.mHasFirstUserUnlockedSinceBoot = false;
        this.mContext = context;
        this.mGlobalDisable = isBackupDisabled();
        HandlerThread handlerThread = new HandlerThread("backup", 10);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mUserManager = UserManager.get(context);
        this.mUserServices = new SparseArray();
        Set<ComponentName> transportWhitelist = SystemConfig.getInstance().getBackupTransportWhitelist();
        if (transportWhitelist != null) goto L5;
        Set<ComponentName> r3 = Collections.emptySet();
    L6:
        this.mTransportWhitelist = r3;
        this.mContext.registerReceiver(this.mUserRemovedReceiver, new IntentFilter("android.intent.action.USER_REMOVED"));
        UserHandle mainUser = getUserManager().getMainUser();
        if (mainUser == null) goto L10;
        r0 = mainUser.getIdentifier();
    L10:
        this.mDefaultBackupUserId = r0;
        Slog.d(TAG, "Default backup user id = " + this.mDefaultBackupUserId);
        return;
    L5:
        r3 = transportWhitelist;
        goto L6
    }

    Handler getBackupHandler() {
        return this.mHandler;
    }

    protected boolean isBackupDisabled() {
        return SystemProperties.getBoolean(BACKUP_DISABLE_PROPERTY, false);
    }

    protected int binderGetCallingUserId() {
        return Binder.getCallingUserHandle().getIdentifier();
    }

    protected int binderGetCallingUid() {
        return Binder.getCallingUid();
    }

    protected File getSuppressFileForUser(int userId) {
        return new File(UserBackupManagerFiles.getBaseStateDir(userId), BACKUP_SUPPRESS_FILENAME);
    }

    protected File getRememberActivatedFileForNonSystemUser(int userId) {
        return UserBackupManagerFiles.getStateFileInSystemDir(REMEMBER_ACTIVATED_FILENAME, userId);
    }

    protected File getActivatedFileForUser(int userId) {
        return UserBackupManagerFiles.getStateFileInSystemDir(BACKUP_ACTIVATED_FILENAME, userId);
    }

    private void onRemovedNonSystemUser(int userId) {
        Slog.i(TAG, "Removing state for non system user " + userId);
        File dir = UserBackupManagerFiles.getStateDirInSystemDir(userId);
        if (FileUtils.deleteContentsAndDir(dir) == true) goto L6;
        Slog.w(TAG, "Failed to delete state dir for removed user: " + userId);
        return;
    }

    private void createFile(File file) throws IOException {
        if (file.exists() == false) goto L5;
        return;
    L5:
        file.getParentFile().mkdirs();
        if (file.createNewFile() == true) goto L9;
        Slog.w(TAG, "Failed to create file " + file.getPath());
        return;
    }

    private void deleteFile(File file) {
        if (file.exists() == true) goto L6;
        return;
    L6:
        if (file.delete() == true) goto L9;
        Slog.w(TAG, "Failed to delete file " + file.getPath());
        return;
    }

    private void deactivateBackupForUserLocked(int userId) throws IOException {
        if (userId != 0) goto L4;
    L7:
        createFile(getSuppressFileForUser(userId));
        return;
    L4:
        if (userId == this.mDefaultBackupUserId) goto L7;
        deleteFile(getActivatedFileForUser(userId));
    }

    private void activateBackupForUserLocked(int userId) throws IOException {
        if (userId != 0) goto L4;
    L7:
        deleteFile(getSuppressFileForUser(userId));
        return;
    L4:
        if (userId == this.mDefaultBackupUserId) goto L7;
        createFile(getActivatedFileForUser(userId));
    }

    public boolean isUserReadyForBackup(int userId) {
        enforceCallingPermissionOnUserId(userId, "isUserReadyForBackup()");
        if (this.mUserServices.get(userId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isBackupActivatedForUser(int userId) {
        if (getSuppressFileForUser(0).exists() == false) goto L6;
        return false;
    L6:
        if (userId != this.mDefaultBackupUserId) goto L8;
        boolean isDefaultUser = true;
    L9:
        if (userId != 0) goto L12;
        if (isDefaultUser == true) goto L12;
        return false;
    L12:
        if (isDefaultUser == true) goto L14;
    L16:
        if (isDefaultUser == true) goto L20;
        if (getActivatedFileForUser(userId).exists() == true) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (getSuppressFileForUser(userId).exists() == false) goto L16;
        return false;
    L8:
        isDefaultUser = false;
        goto L9
    }

    protected Context getContext() {
        return this.mContext;
    }

    protected UserManager getUserManager() {
        return this.mUserManager;
    }

    protected void postToHandler(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    void startServiceForUser(int userId) {
        if (this.mGlobalDisable == false) goto L7;
        Slog.i(TAG, "Backup service not supported");
        return;
    L7:
        if (isBackupActivatedForUser(userId) == true) goto L11;
        Slog.i(TAG, "Backup not activated for user " + userId);
        return;
    L11:
        if (this.mUserServices.get(userId) == null) goto L14;
        Slog.i(TAG, "userId " + userId + " already started, so not starting again");
        return;
    L14:
        Slog.i(TAG, "Starting service for user: " + userId);
        UserBackupManagerService userBackupManagerService = UserBackupManagerService.createAndInitializeService(userId, this.mContext, this, this.mTransportWhitelist);
        startServiceForUser(userId, userBackupManagerService);
    }

    void startServiceForUser(int userId, UserBackupManagerService userBackupManagerService) {
        this.mUserServices.put(userId, userBackupManagerService);
        Trace.traceBegin(64, "backup enable");
        userBackupManagerService.initializeBackupEnableState();
        Trace.traceEnd(64);
    }

    protected void stopServiceForUser(int userId) {
        UserBackupManagerService userBackupManagerService = (UserBackupManagerService) this.mUserServices.removeReturnOld(userId);
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.tearDownService();
        KeyValueBackupJob.cancel(userId, this.mContext);
        FullBackupJob.cancel(userId, this.mContext);
        return;
    }

    SparseArray<UserBackupManagerService> getUserServices() {
        return this.mUserServices;
    }

    void onStopUser(final int userId) {
        postToHandler(new BackupManagerService$$ExternalSyntheticLambda0(this, userId));
    }

    private /* synthetic */ void lambda$onStopUser$0(int userId) {
        if (this.mGlobalDisable == true) goto L6;
        Slog.i(TAG, "Stopping service for user: " + userId);
        stopServiceForUser(userId);
        return;
    }

    public UserBackupManagerService getUserService(int userId) {
        return this.mUserServices.get(userId);
    }

    private void enforcePermissionsOnUser(int userId) throws SecurityException {
        if (userId != 0) goto L4;
    L7:
        boolean isRestrictedUser = true;
    L9:
        if (isRestrictedUser == false) goto L17;
        int caller = binderGetCallingUid();
        if (caller == 1000) goto L19;
        if (caller != 0) goto L15;
        return;
    L15:
        throw new SecurityException("No permission to configure backup activity");
    L19:
        return;
    L17:
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "No permission to configure backup activity");
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "No permission to configure backup activity");
        return;
    L4:
        if (getUserManager().getUserInfo(userId).isManagedProfile() == true) goto L7;
        isRestrictedUser = false;
        goto L9
    }

    public void setBackupServiceActive(int userId, boolean makeActive) {
        enforcePermissionsOnUser(userId);
        if (userId == 0) goto L9;
        File rememberFile = getRememberActivatedFileForNonSystemUser(userId);     // Catch: IOException -> L6
        createFile(rememberFile);     // Catch: IOException -> L6
        RandomAccessFileUtils.writeBoolean(rememberFile, makeActive);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Unable to persist backup service activity", e);
    L9:
        if (this.mGlobalDisable == false) goto L12;
        Slog.i(TAG, "Backup service not supported");
        return;
    L12:
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L17
        r2.append("Making backup ");     // Catch: Throwable -> L17
        if (makeActive == false) goto L19;
        String r3 = "";
    L20:
        r2.append(r3);     // Catch: Throwable -> L17
        r2.append(DomainVerificationPersistence.TAG_ACTIVE);     // Catch: Throwable -> L17
        Slog.i(TAG, r2.toString());     // Catch: Throwable -> L17
        if (makeActive == false) goto L50;
        activateBackupForUserLocked(userId);     // Catch: Throwable -> L17 IOException -> L24
    L27:
        if (getUserManager().isUserUnlocked(userId) == false) goto L39;
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        startServiceForUser(userId);     // Catch: Throwable -> L31
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L17
        goto L39
    L31:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L39:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L25:
        Slog.e(TAG, "Unable to persist backup service activity");     // Catch: Throwable -> L17
        goto L27
    L50:
        deactivateBackupForUserLocked(userId);     // Catch: Throwable -> L17 IOException -> L36
    L38:
        onStopUser(userId);     // Catch: Throwable -> L17
        goto L39
    L37:
        Slog.e(TAG, "Unable to persist backup service inactivity");     // Catch: Throwable -> L17
        goto L38
    L19:
        r3 = "in";
    L17:
        th = move-exception;
        throw th;
    }

    public boolean isBackupServiceActive(int userId) {
        int callingUid = Binder.getCallingUid();
        if (CompatChanges.isChangeEnabled(158482162, callingUid) == false) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "isBackupServiceActive");
    L5:
        Object r1 = this.mStateLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mGlobalDisable == false) goto L10;
    L14:
        boolean r2 = false;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r2;
    L10:
        if (isBackupActivatedForUser(userId) == false) goto L14;
        r2 = true;
        goto L15
    }

    public void dataChangedForUser(int userId, String packageName) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        dataChanged(userId, packageName);
        return;
    }

    public void dataChanged(String packageName) throws RemoteException {
        dataChangedForUser(binderGetCallingUserId(), packageName);
    }

    public void dataChanged(int userId, String packageName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "dataChanged()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.dataChanged(packageName);
        return;
    }

    public void initializeTransportsForUser(int userId, String[] transportNames, IBackupObserver observer) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        initializeTransports(userId, transportNames, observer);
        return;
    }

    public void initializeTransports(int userId, String[] transportNames, IBackupObserver observer) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "initializeTransports()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.initializeTransports(transportNames, observer);
        return;
    }

    public void clearBackupDataForUser(int userId, String transportName, String packageName) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        clearBackupData(userId, transportName, packageName);
        return;
    }

    public void clearBackupData(int userId, String transportName, String packageName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "clearBackupData()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.clearBackupData(transportName, packageName);
        return;
    }

    public void clearBackupData(String transportName, String packageName) throws RemoteException {
        clearBackupDataForUser(binderGetCallingUserId(), transportName, packageName);
    }

    public void agentConnectedForUser(String packageName, int userId, IBinder agent) {
        if (isUserReadyForBackup(userId) == true) goto L5;
        return;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "agentConnected()");
        if (userBackupManagerService == null) goto L9;
        userBackupManagerService.getBackupAgentConnectionManager().agentConnected(packageName, agent);
        return;
    }

    public void agentDisconnectedForUser(String packageName, int userId) {
        if (isUserReadyForBackup(userId) == true) goto L5;
        return;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "agentDisconnected()");
        if (userBackupManagerService == null) goto L9;
        userBackupManagerService.getBackupAgentConnectionManager().agentDisconnected(packageName);
        return;
    }

    public void restoreAtInstallForUser(int userId, String packageName, int token) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        restoreAtInstall(userId, packageName, token);
        return;
    }

    public void restoreAtInstall(String packageName, int token) throws RemoteException {
        restoreAtInstallForUser(binderGetCallingUserId(), packageName, token);
    }

    public void restoreAtInstall(int userId, String packageName, int token) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "restoreAtInstall()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.restoreAtInstall(packageName, token);
        return;
    }

    public void setFrameworkSchedulingEnabledForUser(int userId, boolean isEnabled) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "setFrameworkSchedulingEnabledForUser()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.setFrameworkSchedulingEnabled(isEnabled);
        return;
    }

    public void setBackupEnabledForUser(int userId, boolean isEnabled) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        setBackupEnabled(userId, isEnabled);
        return;
    }

    public void setBackupEnabled(boolean isEnabled) throws RemoteException {
        setBackupEnabledForUser(binderGetCallingUserId(), isEnabled);
    }

    public void setBackupEnabled(int userId, boolean enable) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "setBackupEnabled()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.setBackupEnabled(enable);
        return;
    }

    public void setAutoRestoreForUser(int userId, boolean doAutoRestore) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        setAutoRestore(userId, doAutoRestore);
        return;
    }

    public void setAutoRestore(boolean doAutoRestore) throws RemoteException {
        setAutoRestoreForUser(binderGetCallingUserId(), doAutoRestore);
    }

    public void setAutoRestore(int userId, boolean autoRestore) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "setAutoRestore()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.setAutoRestore(autoRestore);
        return;
    }

    public boolean isBackupEnabledForUser(int userId) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L5;
    L7:
        return false;
    L5:
        if (isBackupEnabled(userId) == false) goto L7;
        return true;
    }

    public boolean isBackupEnabled() throws RemoteException {
        return isBackupEnabledForUser(binderGetCallingUserId());
    }

    public boolean isBackupEnabled(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "isBackupEnabled()");
        if (userBackupManagerService != null) goto L5;
    L7:
        return false;
    L5:
        if (userBackupManagerService.isBackupEnabled() == false) goto L7;
        return true;
    }

    public boolean setBackupPassword(String currentPassword, String newPassword) {
        int userId = binderGetCallingUserId();
        if (isUserReadyForBackup(userId) == true) goto L5;
        return false;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(0, "setBackupPassword()");
        if (userBackupManagerService != null) goto L8;
        return false;
    L8:
        if (userBackupManagerService.setBackupPassword(currentPassword, newPassword) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean hasBackupPassword() throws RemoteException {
        int userId = binderGetCallingUserId();
        if (isUserReadyForBackup(userId) == true) goto L5;
        return false;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(0, "hasBackupPassword()");
        if (userBackupManagerService != null) goto L8;
        return false;
    L8:
        if (userBackupManagerService.hasBackupPassword() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void backupNowForUser(int userId) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        backupNow(userId);
        return;
    }

    public void backupNow() throws RemoteException {
        backupNowForUser(binderGetCallingUserId());
    }

    public void backupNow(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "backupNow()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.backupNow();
        return;
    }

    public void adbBackup(int userId, ParcelFileDescriptor fd, boolean includeApks, boolean includeObbs, boolean includeShared, boolean doWidgets, boolean doAllApps, boolean includeSystem, boolean doCompress, boolean doKeyValue, String[] packageNames) {
        if (isUserReadyForBackup(userId) == true) goto L5;
        return;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "adbBackup()");
        if (userBackupManagerService == null) goto L9;
        userBackupManagerService.adbBackup(fd, includeApks, includeObbs, includeShared, doWidgets, doAllApps, includeSystem, doCompress, doKeyValue, packageNames);
        return;
    }

    public void fullTransportBackupForUser(int userId, String[] packageNames) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        fullTransportBackup(userId, packageNames);
        return;
    }

    public void fullTransportBackup(int userId, String[] packageNames) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "fullTransportBackup()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.fullTransportBackup(packageNames);
        return;
    }

    public void adbRestore(int userId, ParcelFileDescriptor fd) {
        if (isUserReadyForBackup(userId) == true) goto L5;
        return;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "adbRestore()");
        if (userBackupManagerService == null) goto L9;
        userBackupManagerService.adbRestore(fd);
        return;
    }

    public void acknowledgeFullBackupOrRestoreForUser(int userId, int token, boolean allow, String curPassword, String encryptionPassword, IFullBackupRestoreObserver observer) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        acknowledgeAdbBackupOrRestore(userId, token, allow, curPassword, encryptionPassword, observer);
        return;
    }

    public void acknowledgeAdbBackupOrRestore(int userId, int token, boolean allow, String currentPassword, String encryptionPassword, IFullBackupRestoreObserver observer) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "acknowledgeAdbBackupOrRestore()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.acknowledgeAdbBackupOrRestore(token, allow, currentPassword, encryptionPassword, observer);
        return;
    }

    public void acknowledgeFullBackupOrRestore(int token, boolean allow, String curPassword, String encryptionPassword, IFullBackupRestoreObserver observer) throws RemoteException {
        acknowledgeFullBackupOrRestoreForUser(binderGetCallingUserId(), token, allow, curPassword, encryptionPassword, observer);
    }

    public String getCurrentTransportForUser(int userId) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return getCurrentTransport(userId);
    }

    public String getCurrentTransport() throws RemoteException {
        return getCurrentTransportForUser(binderGetCallingUserId());
    }

    public String getCurrentTransport(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getCurrentTransport()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.getCurrentTransport();
    }

    public ComponentName getCurrentTransportComponentForUser(int userId) {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return getCurrentTransportComponent(userId);
    }

    public ComponentName getCurrentTransportComponent(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getCurrentTransportComponent()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.getCurrentTransportComponent();
    }

    public String[] listAllTransportsForUser(int userId) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return listAllTransports(userId);
    }

    public String[] listAllTransports(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "listAllTransports()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.listAllTransports();
    }

    public String[] listAllTransports() throws RemoteException {
        return listAllTransportsForUser(binderGetCallingUserId());
    }

    public ComponentName[] listAllTransportComponentsForUser(int userId) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return listAllTransportComponents(userId);
    }

    public ComponentName[] listAllTransportComponents(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "listAllTransportComponents()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.listAllTransportComponents();
    }

    public String[] getTransportWhitelist() {
        int userId = binderGetCallingUserId();
        if (isUserReadyForBackup(userId) == true) goto L6;
        return null;
    L6:
        String[] whitelistedTransports = new String[this.mTransportWhitelist.size()];
        int i = 0;
        Iterator<ComponentName> r3 = this.mTransportWhitelist.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ComponentName component = r3.next();
        whitelistedTransports[i] = component.flattenToShortString();
        i = i + 1;
        goto L8
    L10:
        return whitelistedTransports;
    }

    public void updateTransportAttributesForUser(int userId, ComponentName transportComponent, String name, Intent configurationIntent, String currentDestinationString, Intent dataManagementIntent, CharSequence dataManagementLabel) {
        if (isUserReadyForBackup(userId) == false) goto L6;
        updateTransportAttributes(userId, transportComponent, name, configurationIntent, currentDestinationString, dataManagementIntent, dataManagementLabel);
        return;
    }

    public void updateTransportAttributes(int userId, ComponentName transportComponent, String name, Intent configurationIntent, String currentDestinationString, Intent dataManagementIntent, CharSequence dataManagementLabel) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "updateTransportAttributes()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.updateTransportAttributes(transportComponent, name, configurationIntent, currentDestinationString, dataManagementIntent, dataManagementLabel);
        return;
    }

    public String selectBackupTransportForUser(int userId, String transport) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return selectBackupTransport(userId, transport);
    }

    public String selectBackupTransport(String transport) throws RemoteException {
        return selectBackupTransportForUser(binderGetCallingUserId(), transport);
    }

    @Deprecated
    public String selectBackupTransport(int userId, String transportName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "selectBackupTransport()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.selectBackupTransport(transportName);
    }

    public void selectBackupTransportAsyncForUser(int userId, ComponentName transport, ISelectBackupTransportCallback listener) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L5;
        selectBackupTransportAsync(userId, transport, listener);
        return;
    L5:
        if (listener != null) goto L11;
        return;
    L11:
        listener.onFailure(-2001);     // Catch: RemoteException -> L9
        return;
    }

    public void selectBackupTransportAsync(int userId, ComponentName transportComponent, ISelectBackupTransportCallback listener) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "selectBackupTransportAsync()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.selectBackupTransportAsync(transportComponent, listener);
        return;
    }

    public Intent getConfigurationIntentForUser(int userId, String transport) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return getConfigurationIntent(userId, transport);
    }

    public Intent getConfigurationIntent(String transport) throws RemoteException {
        return getConfigurationIntentForUser(binderGetCallingUserId(), transport);
    }

    public Intent getConfigurationIntent(int userId, String transportName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getConfigurationIntent()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.getConfigurationIntent(transportName);
    }

    public String getDestinationStringForUser(int userId, String transport) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return getDestinationString(userId, transport);
    }

    public String getDestinationString(String transport) throws RemoteException {
        return getDestinationStringForUser(binderGetCallingUserId(), transport);
    }

    public String getDestinationString(int userId, String transportName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getDestinationString()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.getDestinationString(transportName);
    }

    public Intent getDataManagementIntentForUser(int userId, String transport) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return getDataManagementIntent(userId, transport);
    }

    public Intent getDataManagementIntent(String transport) throws RemoteException {
        return getDataManagementIntentForUser(binderGetCallingUserId(), transport);
    }

    public Intent getDataManagementIntent(int userId, String transportName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getDataManagementIntent()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.getDataManagementIntent(transportName);
    }

    public CharSequence getDataManagementLabelForUser(int userId, String transport) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return getDataManagementLabel(userId, transport);
    }

    public CharSequence getDataManagementLabel(int userId, String transportName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getDataManagementLabel()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.getDataManagementLabel(transportName);
    }

    public IRestoreSession beginRestoreSessionForUser(int userId, String packageName, String transportID) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return beginRestoreSession(userId, packageName, transportID);
    }

    public IRestoreSession beginRestoreSession(int userId, String packageName, String transportName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "beginRestoreSession()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.beginRestoreSession(packageName, transportName);
    }

    public void opCompleteForUser(int userId, int token, long result) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        opComplete(userId, token, result);
        return;
    }

    public void opComplete(int token, long result) throws RemoteException {
        opCompleteForUser(binderGetCallingUserId(), token, result);
    }

    public void opComplete(int userId, int token, long result) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "opComplete()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.opComplete(token, result);
        return;
    }

    public long getAvailableRestoreTokenForUser(int userId, String packageName) {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return 0;
    L7:
        return getAvailableRestoreToken(userId, packageName);
    }

    public long getAvailableRestoreToken(int userId, String packageName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "getAvailableRestoreToken()");
        if (userBackupManagerService != null) goto L6;
        return 0;
    L6:
        return userBackupManagerService.getAvailableRestoreToken(packageName);
    }

    public boolean isAppEligibleForBackupForUser(int userId, String packageName) {
        if (isUserReadyForBackup(userId) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppEligibleForBackup(userId, packageName) == false) goto L7;
        return true;
    }

    public boolean isAppEligibleForBackup(int userId, String packageName) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "isAppEligibleForBackup()");
        if (userBackupManagerService != null) goto L5;
    L7:
        return false;
    L5:
        if (userBackupManagerService.isAppEligibleForBackup(packageName) == false) goto L7;
        return true;
    }

    public String[] filterAppsEligibleForBackupForUser(int userId, String[] packages) {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return null;
    L7:
        return filterAppsEligibleForBackup(userId, packages);
    }

    public String[] filterAppsEligibleForBackup(int userId, String[] packages) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "filterAppsEligibleForBackup()");
        if (userBackupManagerService != null) goto L6;
        return null;
    L6:
        return userBackupManagerService.filterAppsEligibleForBackup(packages);
    }

    public int requestBackupForUser(int userId, String[] packages, IBackupObserver observer, IBackupManagerMonitor monitor, int flags) throws RemoteException {
        if (isUserReadyForBackup(userId) == true) goto L7;
        return -2001;
    L7:
        return requestBackup(userId, packages, observer, monitor, flags);
    }

    public int requestBackup(String[] packages, IBackupObserver observer, IBackupManagerMonitor monitor, int flags) throws RemoteException {
        return requestBackup(binderGetCallingUserId(), packages, observer, monitor, flags);
    }

    public int requestBackup(int userId, String[] packages, IBackupObserver observer, IBackupManagerMonitor monitor, int flags) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "requestBackup()");
        if (userBackupManagerService != null) goto L6;
        return -2001;
    L6:
        return userBackupManagerService.requestBackup(packages, observer, monitor, flags);
    }

    public void cancelBackupsForUser(int userId) throws RemoteException {
        if (isUserReadyForBackup(userId) == false) goto L6;
        cancelBackups(userId);
        return;
    }

    public void cancelBackups() throws RemoteException {
        cancelBackupsForUser(binderGetCallingUserId());
    }

    public void cancelBackups(int userId) {
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "cancelBackups()");
        if (userBackupManagerService == null) goto L6;
        userBackupManagerService.cancelBackups();
        return;
    }

    public UserHandle getUserForAncestralSerialNumber(long ancestralSerialNumber) {
        if (this.mGlobalDisable == false) goto L5;
        return null;
    L5:
        int callingUserId = Binder.getCallingUserHandle().getIdentifier();
        long oldId = Binder.clearCallingIdentity();
        int r5 = 0;
        int[] userIds = getUserManager().getProfileIds(callingUserId, false);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(oldId);
        int r6 = userIds.length;
    L8:
        if (r5 >= r6) goto L16;
        int userId = userIds[r5];
        UserBackupManagerService userBackupManagerService = this.mUserServices.get(userId);
        if (userBackupManagerService == null) goto L15;
        if (userBackupManagerService.getAncestralSerialNumber() != ancestralSerialNumber) goto L15;
        return UserHandle.of(userId);
    L15:
        r5 = r5 + 1;
        goto L8
    L16:
        return null;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    public void setAncestralSerialNumber(long ancestralSerialNumber) {
        if (this.mGlobalDisable == false) goto L5;
        return;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(Binder.getCallingUserHandle().getIdentifier(), "setAncestralSerialNumber()");
        if (userBackupManagerService == null) goto L9;
        userBackupManagerService.setAncestralSerialNumber(ancestralSerialNumber);
        return;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        String op = nextArg(args, 0);
        int argIndex = 0 + 1;
        if ("--help".equals(op) == false) goto L8;
    L40:
        showDumpUsage(pw);
        return;
    L8:
        if ("-h".equals(op) == true) goto L40;
        if (DatabaseHelper.SoundModelContract.KEY_USERS.equals(op) == false) goto L22;
        pw.print(DUMP_RUNNING_USERS_MESSAGE);
        int i = 0;
    L14:
        if (i >= this.mUserServices.size()) goto L19;
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(this.mUserServices.keyAt(i), "dump()");
        if (userBackupManagerService == null) goto L18;
        pw.print(" " + userBackupManagerService.getUserId());
    L18:
        i = i + 1;
        goto L14
    L19:
        pw.println();
        return;
    L22:
        if ("--user".equals(op) == false) goto L31;
        String userArg = nextArg(args, argIndex);
        int r0 = argIndex + 1;
        if (userArg != null) goto L27;
        showDumpUsage(pw);
        return;
    L27:
        int userId = UserHandle.parseUserArg(userArg);
        UserBackupManagerService userBackupManagerService2 = getServiceForUserIfCallerHasPermission(userId, "dump()");
        if (userBackupManagerService2 == null) goto L48;
        userBackupManagerService2.dump(fd, pw, args);
        return;
    L48:
        return;
    L31:
        int i2 = 0;
    L33:
        if (i2 >= this.mUserServices.size()) goto L39;
        UserBackupManagerService userBackupManagerService3 = getServiceForUserIfCallerHasPermission(this.mUserServices.keyAt(i2), "dump()");
        if (userBackupManagerService3 == null) goto L37;
        userBackupManagerService3.dump(fd, pw, args);
    L37:
        i2 = i2 + 1;
        goto L33
    }

    private String nextArg(String[] args, int argIndex) {
        if (argIndex < args.length) goto L7;
        return null;
    L7:
        return args[argIndex];
    }

    private static void showDumpUsage(PrintWriter pw) {
        pw.println("'dumpsys backup' optional arguments:");
        pw.println("  --help    : this help text");
        pw.println("  a[gents] : dump information about defined backup agents");
        pw.println("  transportclients : dump information about transport clients");
        pw.println("  transportstats : dump transport stats");
        pw.println("  users    : dump the list of users for which backup service is running");
        pw.println("  --user <userId> : dump information for user userId");
    }

    public boolean beginFullBackup(int userId, FullBackupJob scheduledJob) {
        if (isUserReadyForBackup(userId) == true) goto L5;
        return false;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "beginFullBackup()");
        if (userBackupManagerService != null) goto L8;
        return false;
    L8:
        if (userBackupManagerService.beginFullBackup(scheduledJob) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public void endFullBackup(int userId) {
        if (isUserReadyForBackup(userId) == true) goto L5;
        return;
    L5:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "endFullBackup()");
        if (userBackupManagerService == null) goto L9;
        userBackupManagerService.endFullBackup();
        return;
    }

    public void excludeKeysFromRestore(String packageName, List<String> keys) {
        int userId = Binder.getCallingUserHandle().getIdentifier();
        if (isUserReadyForBackup(userId) == true) goto L6;
        Slog.w(TAG, "Returning from excludeKeysFromRestore as backup for user" + userId + " is not initialized yet");
        return;
    L6:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "excludeKeysFromRestore()");
        if (userBackupManagerService == null) goto L10;
        userBackupManagerService.excludeKeysFromRestore(packageName, keys);
        return;
    }

    public void reportDelayedRestoreResult(String packageName, List<BackupRestoreEventLogger.DataTypeResult> results) {
        int userId = Binder.getCallingUserHandle().getIdentifier();
        if (isUserReadyForBackup(userId) == true) goto L6;
        Slog.w(TAG, "Returning from reportDelayedRestoreResult as backup for user" + userId + " is not initialized yet");
        return;
    L6:
        UserBackupManagerService userBackupManagerService = getServiceForUserIfCallerHasPermission(userId, "reportDelayedRestoreResult()");
        if (userBackupManagerService == null) goto L14;
        long oldId = Binder.clearCallingIdentity();
        userBackupManagerService.reportDelayedRestoreResult(packageName, results);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(oldId);
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    UserBackupManagerService getServiceForUserIfCallerHasPermission(int userId, String caller) {
        enforceCallingPermissionOnUserId(userId, caller);
        UserBackupManagerService userBackupManagerService = this.mUserServices.get(userId);
        if (userBackupManagerService != null) goto L5;
        Slog.w(TAG, "Called " + caller + " for unknown user: " + userId);
    L5:
        return userBackupManagerService;
    }

    private void enforceCallingPermissionOnUserId(int userId, String message) {
        if (binderGetCallingUserId() == userId) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", message);
        return;
    }

    private void updateDefaultBackupUserIdIfNeeded() {
        if (this.mHasFirstUserUnlockedSinceBoot == false) goto L5;
        return;
    L5:
        if (this.mDefaultBackupUserId != 0) goto L19;
        UserHandle mainUser = getUserManager().getMainUser();
        if (mainUser != null) goto L11;
        return;
    L11:
        if (this.mDefaultBackupUserId == mainUser.getIdentifier()) goto L18;
        int oldDefaultBackupUserId = this.mDefaultBackupUserId;
        this.mDefaultBackupUserId = mainUser.getIdentifier();
        if (isBackupActivatedForUser(oldDefaultBackupUserId) == true) goto L15;
        stopServiceForUser(oldDefaultBackupUserId);
    L15:
        Slog.i(TAG, "Default backup user changed from " + oldDefaultBackupUserId + " to " + this.mDefaultBackupUserId);
        return;
    L18:
        return;
    }
}
