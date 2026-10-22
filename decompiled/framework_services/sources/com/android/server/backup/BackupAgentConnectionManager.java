package com.android.server.backup;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.IActivityManager;
import android.app.IBackupAgent;
import android.app.compat.CompatChanges;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.backup.internal.LifecycleOperationStorage;
import com.android.server.job.controllers.JobStatus;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BackupAgentConnectionManager {
    public static final long OS_DECIDES_BACKUP_RESTRICTED_MODE = 376661510;
    private final IActivityManager mActivityManager;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final Object mAgentConnectLock;
    private final ArraySet<String> mBackupNoRestrictedModePackages;
    private BackupAgentConnection mCurrentConnection;
    private final LifecycleOperationStorage mOperationStorage;
    private final PackageManager mPackageManager;
    private final ArraySet<String> mRestoreNoRestrictedModePackages;
    private final UserBackupManagerService mUserBackupManagerService;
    private final int mUserId;
    private final String mUserIdMsg;

    private static final class BackupAgentConnection {
        public final ApplicationInfo appInfo;
        public IBackupAgent backupAgent;
        public final int backupMode;
        public boolean connecting;
        public final boolean inRestrictedMode;

        /* synthetic */ BackupAgentConnection(ApplicationInfo r1, int r2, boolean r3, BackupAgentConnectionManagerIA r4) {
            this(r1, r2, r3);
        }

        private BackupAgentConnection(ApplicationInfo appInfo, int backupMode, boolean inRestrictedMode) {
            this.connecting = true;
            this.appInfo = appInfo;
            this.backupMode = backupMode;
            this.inRestrictedMode = inRestrictedMode;
        }
    }

    public static /* synthetic */ void $r8$lambda$SSE5nMYZnChmUtr7p3MsiQIx0L0(BackupAgentConnectionManager r0, String r1) {
        r0.lambda$agentDisconnected$0(r1);
    }

    BackupAgentConnectionManager(LifecycleOperationStorage operationStorage, PackageManager packageManager, UserBackupManagerService userBackupManagerService, int userId) {
        this.mAgentConnectLock = new Object();
        this.mRestoreNoRestrictedModePackages = new ArraySet();
        this.mBackupNoRestrictedModePackages = new ArraySet();
        this.mActivityManager = ActivityManager.getService();
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mOperationStorage = operationStorage;
        this.mPackageManager = packageManager;
        this.mUserBackupManagerService = userBackupManagerService;
        this.mUserId = userId;
        this.mUserIdMsg = "[UserID:" + userId + "] ";
    }

    public IBackupAgent bindToAgentSynchronous(ApplicationInfo app, int backupMode, int backupDestination) {
        BackupAgentConnectionManagerIA r1 = null;
        if (app != null) goto L6;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "bindToAgentSynchronous for null app");
        return null;
    L6:
        Object r2 = this.mAgentConnectLock;
        monitor-enter(r2);
        boolean useRestrictedMode = shouldUseRestrictedBackupModeForPackage(backupMode, app.packageName);     // Catch: Throwable -> L24
        if (this.mCurrentConnection != null) goto L61;
    L14:
        this.mCurrentConnection = new BackupAgentConnection(app, backupMode, useRestrictedMode, r1);     // Catch: Throwable -> L24
        boolean startedBindSuccessfully = false;
        goto L28
    L59:
        startedBindSuccessfully = this.mActivityManager.bindBackupAgent(app.packageName, backupMode, this.mUserId, backupDestination, useRestrictedMode);     // Catch: Throwable -> L20 RemoteException -> L22
    L20:
        th = th;
    L53:
        monitor-exit(r2);     // Catch: Throwable -> L20
        throw th;
    L28:
        if (startedBindSuccessfully == true) goto L30;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "bind request failed for " + app.packageName);     // Catch: Throwable -> L20
        this.mCurrentConnection = null;     // Catch: Throwable -> L20
    L43:
        if (this.mCurrentConnection != null) goto L45;
    L50:
        this.mActivityManagerInternal.clearPendingBackup(this.mUserId);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return null;
    L45:
        if (this.mCurrentConnection.connecting == true) goto L49;
        IBackupAgent r12 = this.mCurrentConnection.backupAgent;     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return r12;
    L49:
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "Timeout waiting for agent " + app);     // Catch: Throwable -> L20
        this.mCurrentConnection = null;     // Catch: Throwable -> L20
        goto L50
    L30:
        Slog.d(BackupManagerService.TAG, this.mUserIdMsg + "awaiting agent for " + app.packageName);     // Catch: Throwable -> L20
        long timeoutMark = System.currentTimeMillis() + JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;     // Catch: Throwable -> L20
    L32:
        if (this.mCurrentConnection == null) goto L43;
        if (this.mCurrentConnection.connecting == false) goto L43;
        if (System.currentTimeMillis() >= timeoutMark) goto L43;
        this.mAgentConnectLock.wait(5000);     // Catch: Throwable -> L20 InterruptedException -> L40
    L40:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "Interrupted: " + e);     // Catch: Throwable -> L20
        this.mCurrentConnection = null;     // Catch: Throwable -> L20
        goto L32
    L61:
        Slog.e(BackupManagerService.TAG, this.mUserIdMsg + "binding to new agent before unbinding from old one: " + this.mCurrentConnection.appInfo.packageName);     // Catch: Throwable -> L12
    L12:
        th = th;
    L24:
        th = th;
        goto L53
    }

    public void unbindAgent(ApplicationInfo app, boolean allowKill) {
        if (app != null) goto L5;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "unbindAgent for null app");
        return;
    L5:
        Object r0 = this.mAgentConnectLock;
        monitor-enter(r0);
        this.mActivityManager.unbindBackupAgent(app);     // Catch: Throwable -> L12 RemoteException -> L14
        if (allowKill == true) goto L10;
    L16:
        boolean willKill = false;
    L18:
        if (this.mCurrentConnection != null) goto L21;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "unbindAgent but no current connection");     // Catch: Throwable -> L12 RemoteException -> L14
    L24:
        if (willKill == false) goto L27;
        Slog.i(BackupManagerService.TAG, this.mUserIdMsg + "Killing agent host process");     // Catch: Throwable -> L12 RemoteException -> L14
        this.mActivityManager.killApplicationProcess(app.processName, app.uid);     // Catch: Throwable -> L12 RemoteException -> L14
        goto L27
    L21:
        if (this.mCurrentConnection.appInfo.packageName.equals(app.packageName) == true) goto L23;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "unbindAgent for unexpected package: " + app.packageName + " expected: " + this.mCurrentConnection.appInfo.packageName);     // Catch: Throwable -> L12 RemoteException -> L14
        goto L24
    L23:
        this.mCurrentConnection = null;     // Catch: Throwable -> L12 RemoteException -> L14
        goto L24
    L10:
        if (shouldKillAppOnUnbind(app) == false) goto L16;
        willKill = true;
    L12:
        th = move-exception;
        throw th;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private boolean shouldKillAppOnUnbind(ApplicationInfo app) {
        if (UserHandle.isCore(app.uid) == false) goto L6;
        return false;
    L6:
        if (this.mCurrentConnection != null) goto L8;
    L16:
        return true;
    L8:
        if (this.mCurrentConnection.inRestrictedMode == true) goto L16;
        if (isBackupModeRestore(this.mCurrentConnection.backupMode) == true) goto L13;
        return false;
    L13:
        if ((app.flags & 65536) != 0) goto L15;
        return false;
    L15:
        return true;
    }

    public void agentConnected(String packageName, IBinder agentBinder) {
        Object r0 = this.mAgentConnectLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (getCallingUid() == 1000) goto L11;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "Non-system process uid=" + getCallingUid() + " claiming agent connected");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(BackupManagerService.TAG, this.mUserIdMsg + "agentConnected pkg=" + packageName + " agent=" + agentBinder);     // Catch: Throwable -> L9
        if (this.mCurrentConnection != null) goto L15;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "was not expecting connection");     // Catch: Throwable -> L9
    L18:
        this.mAgentConnectLock.notifyAll();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        if (this.mCurrentConnection.appInfo.packageName.equals(packageName) == true) goto L17;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "got agent for unexpected package=" + packageName);     // Catch: Throwable -> L9
        goto L18
    L17:
        this.mCurrentConnection.backupAgent = IBackupAgent.Stub.asInterface(agentBinder);     // Catch: Throwable -> L9
        this.mCurrentConnection.connecting = false;     // Catch: Throwable -> L9
        goto L18
    }

    public void agentDisconnected(final String packageName) {
        Object r0 = this.mAgentConnectLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (getCallingUid() == 1000) goto L11;
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "Non-system process uid=" + getCallingUid() + " claiming agent disconnected");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.w(BackupManagerService.TAG, this.mUserIdMsg + "agentDisconnected: the backup agent for " + packageName + " died: cancel current operations");     // Catch: Throwable -> L9
        if (this.mCurrentConnection != null) goto L14;
    L16:
        Runnable cancellationRunnable = new BackupAgentConnectionManager$$ExternalSyntheticLambda0(this, packageName);     // Catch: Throwable -> L9
        getThreadForCancellation(cancellationRunnable).start();     // Catch: Throwable -> L9
        this.mAgentConnectLock.notifyAll();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        if (this.mCurrentConnection.appInfo.packageName.equals(packageName) == false) goto L16;
        this.mCurrentConnection = null;     // Catch: Throwable -> L9
        goto L16
    }

    private /* synthetic */ void lambda$agentDisconnected$0(String packageName) {
        Iterator<Integer> r0 = this.mOperationStorage.operationTokensForPackage(packageName).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int token = r0.next().intValue();
        this.mUserBackupManagerService.handleCancel(token, 1);
        goto L4
    }

    public void setNoRestrictedModePackages(Set<String> packageNames, int opType) {
        Object r0 = this.mAgentConnectLock;
        monitor-enter(r0);
        if (opType != 0) goto L9;
        this.mBackupNoRestrictedModePackages.clear();     // Catch: Throwable -> L6
        this.mBackupNoRestrictedModePackages.addAll(packageNames);     // Catch: Throwable -> L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L9:
        if (opType != 1) goto L14;
        this.mRestoreNoRestrictedModePackages.clear();     // Catch: Throwable -> L6
        this.mRestoreNoRestrictedModePackages.addAll(packageNames);     // Catch: Throwable -> L6
        goto L11
    L14:
        throw new IllegalArgumentException("opType must be BACKUP or RESTORE");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void clearNoRestrictedModePackages() {
        Object r0 = this.mAgentConnectLock;
        monitor-enter(r0);
        this.mBackupNoRestrictedModePackages.clear();     // Catch: Throwable -> L7
        this.mRestoreNoRestrictedModePackages.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean shouldUseRestrictedBackupModeForPackage(int mode, String packageName) {
        if (mode != 0) goto L5;
    L29:
        return false;
    L5:
        if (mode == 2) goto L29;
        PackageManager.Property property = this.mPackageManager.getPropertyAsUser("android.app.backup.PROPERTY_USE_RESTRICTED_BACKUP_MODE", packageName, null, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L12
        if (property.isBoolean() == true) goto L11;
        Slog.w(BackupManagerService.TAG, "android.app.backup.PROPERTY_USE_RESTRICTED_BACKUP_MODEmust be a boolean.");     // Catch: PackageManager.NameNotFoundException -> L12
        goto L16
    L11:
        return property.getBoolean();
    L16:
        if (CompatChanges.isChangeEnabled(OS_DECIDES_BACKUP_RESTRICTED_MODE, packageName, UserHandle.of(this.mUserId)) == true) goto L19;
        return true;
    L19:
        if (mode != 1) goto L23;
        if (this.mBackupNoRestrictedModePackages.contains(packageName) == false) goto L23;
    L26:
        Slog.d(BackupManagerService.TAG, "Transport requested no restricted mode for: " + packageName);
        return false;
    L23:
        if (mode == 3) goto L25;
    L28:
        return true;
    L25:
        if (this.mRestoreNoRestrictedModePackages.contains(packageName) == false) goto L28;
        goto L26
    }

    private static boolean isBackupModeRestore(int backupMode) {
        if (backupMode != 2) goto L5;
    L8:
        return true;
    L5:
        if (backupMode == 3) goto L8;
        return false;
    }

    Thread getThreadForCancellation(Runnable operation) {
        return new Thread(operation, "agent-disconnected");
    }

    int getCallingUid() {
        return Binder.getCallingUid();
    }
}
