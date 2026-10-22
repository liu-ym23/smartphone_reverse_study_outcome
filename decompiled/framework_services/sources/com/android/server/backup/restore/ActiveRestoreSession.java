package com.android.server.backup.restore;

import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IRestoreObserver;
import android.app.backup.IRestoreSession;
import android.app.backup.RestoreSet;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.util.Slog;
import com.android.server.backup.BackupWakeLock;
import com.android.server.backup.TransportManager;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.internal.OnTaskFinishedListener;
import com.android.server.backup.params.RestoreGetSetsParams;
import com.android.server.backup.params.RestoreParams;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.backup.utils.BackupEligibilityRules;
import java.util.List;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes.dex */
public class ActiveRestoreSession extends IRestoreSession.Stub {
    private static final String DEVICE_NAME_FOR_D2D_SET = "D2D";
    private static final String TAG = "RestoreSession";
    private final BackupEligibilityRules mBackupEligibilityRules;
    private final UserBackupManagerService mBackupManagerService;
    boolean mEnded;
    private final String mPackageName;
    public List<RestoreSet> mRestoreSets;
    boolean mTimedOut;
    private final TransportManager mTransportManager;
    private final String mTransportName;
    private final int mUserId;

    public class EndRestoreRunnable implements Runnable {
        UserBackupManagerService mBackupManager;
        ActiveRestoreSession mSession;

        public EndRestoreRunnable(ActiveRestoreSession this$0, UserBackupManagerService manager, ActiveRestoreSession session) {
            this.mBackupManager = manager;
            this.mSession = session;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActiveRestoreSession r0 = this.mSession;
            monitor-enter(r0);
            this.mSession.mEnded = true;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.mBackupManager.clearRestoreSession(this.mSession);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1HV4wO7-2nC990pSsmeoP38eq9g, reason: not valid java name */
    public static /* synthetic */ RestoreParams m2533$r8$lambda$1HV4wO72nC990pSsmeoP38eq9g(ActiveRestoreSession r0, IRestoreObserver r1, IBackupManagerMonitor r2, long r3, PackageInfo r5, TransportConnection r6, OnTaskFinishedListener r7) {
        return r0.lambda$restorePackage$3(r1, r2, r3, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$59AkZHWtRZjcGCBJBBnbvCxY_b8(TransportManager r0, TransportConnection r1, BackupWakeLock r2, String r3) {
        lambda$sendRestoreToHandlerLocked$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ RestoreParams $r8$lambda$C4hb9MjwnGRdnaqhzNfGBVOEcME(ActiveRestoreSession r0, IRestoreObserver r1, IBackupManagerMonitor r2, long r3, String[] r5, RestoreSet r6, TransportConnection r7, OnTaskFinishedListener r8) {
        return r0.lambda$restorePackages$2(r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$Su90J8vJDnmK5AHEKyPmta70SUE(TransportManager r0, TransportConnection r1, BackupWakeLock r2, String r3) {
        lambda$getAvailableRestoreSets$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$tdA_scdZK-1CvSHRspb9YvbhZPY, reason: not valid java name */
    public static /* synthetic */ RestoreParams m2534$r8$lambda$tdA_scdZK1CvSHRspb9YvbhZPY(ActiveRestoreSession r0, IRestoreObserver r1, IBackupManagerMonitor r2, long r3, RestoreSet r5, TransportConnection r6, OnTaskFinishedListener r7) {
        return r0.lambda$restoreAll$1(r1, r2, r3, r5, r6, r7);
    }

    public ActiveRestoreSession(UserBackupManagerService backupManagerService, String packageName, String transportName, BackupEligibilityRules backupEligibilityRules) {
        this.mRestoreSets = null;
        this.mEnded = false;
        this.mTimedOut = false;
        this.mBackupManagerService = backupManagerService;
        this.mPackageName = packageName;
        this.mTransportManager = backupManagerService.getTransportManager();
        this.mTransportName = transportName;
        this.mUserId = backupManagerService.getUserId();
        this.mBackupEligibilityRules = backupEligibilityRules;
    }

    public void markTimedOut() {
        this.mTimedOut = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [long] */
    public synchronized int getAvailableRestoreSets(IRestoreObserver observer, IBackupManagerMonitor monitor) {
        monitor-enter(this);
        long r2 = "getAvailableRestoreSets";
        this.mBackupManagerService.getContext().enforceCallingOrSelfPermission("android.permission.BACKUP", "getAvailableRestoreSets");     // Catch: Throwable -> L51
        if (observer == null) goto L56;
        if (this.mEnded == true) goto L54;
        if (this.mTimedOut == false) goto L61;
        Slog.i(TAG, "Session already timed out");     // Catch: Throwable -> L13
        monitor-exit(this);
        return -1;
    L61:
        r2 = Binder.clearCallingIdentity();     // Catch: Throwable -> L51
        final TransportConnection transportConnection = this.mTransportManager.getTransportClient(this.mTransportName, "RestoreSession.getAvailableRestoreSets()");     // Catch: Throwable -> L40 Exception -> L42
        if (transportConnection == null) goto L65;
        this.mBackupManagerService.getBackupHandler().removeMessages(8);     // Catch: Throwable -> L40 Exception -> L42
        final BackupWakeLock wakelock = this.mBackupManagerService.getWakeLock();     // Catch: Throwable -> L40 Exception -> L42
        wakelock.acquire();     // Catch: Throwable -> L40 Exception -> L42
        final TransportManager transportManager = this.mTransportManager;     // Catch: Throwable -> L40 Exception -> L42
        OnTaskFinishedListener listener = new ActiveRestoreSession$$ExternalSyntheticLambda1(transportManager, transportConnection, wakelock);     // Catch: Throwable -> L40 Exception -> L42
        Handler r11 = this.mBackupManagerService.getBackupHandler();     // Catch: Throwable -> L40 Exception -> L42
    L63:
        Message msg = r11.obtainMessage(6, new RestoreGetSetsParams(transportConnection, this, observer, monitor, listener));     // Catch: Throwable -> L36 Exception -> L38
        this.mBackupManagerService.getBackupHandler().sendMessage(msg);     // Catch: Throwable -> L36 Exception -> L38
        Binder.restoreCallingIdentity(r2);     // Catch: Throwable -> L34
        monitor-exit(this);
        return 0;
    L38:
        e = e;
    L45:
        Slog.e(TAG, "Error in getAvailableRestoreSets", e);     // Catch: Throwable -> L36
        Binder.restoreCallingIdentity(r2);     // Catch: Throwable -> L34
        monitor-exit(this);
        return -1;
    L65:
        Slog.w(TAG, "Null transport client getting restore sets");     // Catch: Throwable -> L23 Exception -> L25
        Binder.restoreCallingIdentity(r2);     // Catch: Throwable -> L13
        monitor-exit(this);
        return -1;
    L25:
        e = e;
    L23:
        e = th;
    L49:
        Binder.restoreCallingIdentity(r2);     // Catch: Throwable -> L34
        throw e;     // Catch: Throwable -> L34
    L42:
        e = e;
    L40:
        e = th;
    L36:
        e = th;
    L13:
        th = move-exception;
        Throwable r13 = th;
    L57:
        monitor-exit(this);     // Catch: Throwable -> L34
        throw r13;
    L54:
        throw new IllegalStateException("Restore session already ended");     // Catch: Throwable -> L34
    L56:
        throw new IllegalArgumentException("Observer must not be null");     // Catch: Throwable -> L34
    L34:
        th = th;
    L35:
        r13 = th;
    L51:
        th = th;
        goto L35
    }

    private static /* synthetic */ void lambda$getAvailableRestoreSets$0(TransportManager transportManager, TransportConnection transportConnection, BackupWakeLock wakelock, String caller) {
        transportManager.disposeOfTransportClient(transportConnection, caller);
        wakelock.release();
    }

    public synchronized int restoreAll(final long token, final IRestoreObserver observer, final IBackupManagerMonitor monitor) {
        monitor-enter(this);
        this.mBackupManagerService.getContext().enforceCallingOrSelfPermission("android.permission.BACKUP", "performRestore");     // Catch: Throwable -> L10
        Slog.d(TAG, "restoreAll token=" + Long.toHexString(token) + " observer=" + observer);     // Catch: Throwable -> L10
        if (this.mEnded == true) goto L55;
        if (this.mTimedOut == false) goto L13;
        Slog.i(TAG, "Session already timed out");     // Catch: Throwable -> L10
        monitor-exit(this);
        return -1;
    L13:
        if (this.mRestoreSets != null) goto L18;
        Slog.e(TAG, "Ignoring restoreAll() with no restore set");     // Catch: Throwable -> L10
        monitor-exit(this);
        return -1;
    L18:
        if (this.mPackageName == null) goto L23;
        Slog.e(TAG, "Ignoring restoreAll() on single-package session");     // Catch: Throwable -> L10
        monitor-exit(this);
        return -1;
    L23:
        if (this.mTransportManager.isTransportRegistered(this.mTransportName) == true) goto L27;
        Slog.e(TAG, "Transport " + this.mTransportName + " not registered");     // Catch: Throwable -> L10
        monitor-exit(this);
        return -1;
    L27:
        Object r7 = this.mBackupManagerService.getQueueLock();     // Catch: Throwable -> L10
        monitor-enter(r7);     // Catch: Throwable -> L10
        int i = 0;
    L59:
    L51:
        th = th;
    L52:
        monitor-exit(r7);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L10
    L31:
        if (i >= this.mRestoreSets.size()) goto L47;
    L40:
        th = th;
        goto L52
    L33:
        if (token == this.mRestoreSets.get(i).token) goto L34;
        i = i + 1;
        goto L59
    L34:
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L40
        final RestoreSet restoreSet = this.mRestoreSets.get(i);     // Catch: Throwable -> L40
        int r0 = sendRestoreToHandlerLocked(new ActiveRestoreSession$$ExternalSyntheticLambda3(this, observer, monitor, token, restoreSet), "RestoreSession.restoreAll()");     // Catch: Throwable -> L42
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L40
        monitor-exit(r7);     // Catch: Throwable -> L40
        monitor-exit(this);
        return r0;
    L42:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L47:
        monitor-exit(r7);     // Catch: Throwable -> L51
        Slog.w(TAG, "Restore token " + Long.toHexString(token) + " not found");     // Catch: Throwable -> L10
        monitor-exit(this);
        return -1;
    L55:
        throw new IllegalStateException("Restore session already ended");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ RestoreParams lambda$restoreAll$1(IRestoreObserver observer, IBackupManagerMonitor monitor, long token, RestoreSet restoreSet, TransportConnection transportClient, OnTaskFinishedListener listener) {
        return RestoreParams.createForRestoreAll(transportClient, observer, monitor, token, listener, getBackupEligibilityRules(restoreSet));
    }

    public synchronized int restorePackages(final long token, final IRestoreObserver observer, final String[] packages, final IBackupManagerMonitor monitor) {
        monitor-enter(this);
        this.mBackupManagerService.getContext().enforceCallingOrSelfPermission("android.permission.BACKUP", "performRestore");     // Catch: Throwable -> L7
        StringBuilder b = new StringBuilder(128);     // Catch: Throwable -> L7
        b.append("restorePackages token=");     // Catch: Throwable -> L7
        b.append(Long.toHexString(token));     // Catch: Throwable -> L7
        b.append(" observer=");     // Catch: Throwable -> L7
        if (observer != null) goto L9;
        b.append("null");     // Catch: Throwable -> L7
    L10:
        b.append(" monitor=");     // Catch: Throwable -> L7
        if (monitor != null) goto L13;
        b.append("null");     // Catch: Throwable -> L7
    L14:
        b.append(" packages=");     // Catch: Throwable -> L7
        if (packages != null) goto L17;
        b.append("null");     // Catch: Throwable -> L7
    L25:
        Slog.d(TAG, b.toString());     // Catch: Throwable -> L7
        if (this.mEnded == true) goto L75;
        if (this.mTimedOut == false) goto L33;
        Slog.i(TAG, "Session already timed out");     // Catch: Throwable -> L7
        monitor-exit(this);
        return -1;
    L33:
        if (this.mRestoreSets != null) goto L38;
        Slog.e(TAG, "Ignoring restoreAll() with no restore set");     // Catch: Throwable -> L7
        monitor-exit(this);
        return -1;
    L38:
        if (this.mPackageName == null) goto L43;
        Slog.e(TAG, "Ignoring restoreAll() on single-package session");     // Catch: Throwable -> L7
        monitor-exit(this);
        return -1;
    L43:
        if (this.mTransportManager.isTransportRegistered(this.mTransportName) == true) goto L47;
        Slog.e(TAG, "Transport " + this.mTransportName + " not registered");     // Catch: Throwable -> L7
        monitor-exit(this);
        return -1;
    L47:
        Object r9 = this.mBackupManagerService.getQueueLock();     // Catch: Throwable -> L7
        monitor-enter(r9);     // Catch: Throwable -> L7
        int i = 0;
    L79:
    L71:
        th = th;
    L72:
        monitor-exit(r9);     // Catch: Throwable -> L71
        throw th;     // Catch: Throwable -> L7
    L51:
        if (i >= this.mRestoreSets.size()) goto L67;
    L60:
        th = th;
        goto L72
    L53:
        if (token == this.mRestoreSets.get(i).token) goto L54;
        i = i + 1;
        goto L79
    L54:
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L60
        final RestoreSet restoreSet = this.mRestoreSets.get(i);     // Catch: Throwable -> L60
        int r0 = sendRestoreToHandlerLocked(new ActiveRestoreSession$$ExternalSyntheticLambda2(this, observer, monitor, token, packages, restoreSet), "RestoreSession.restorePackages(" + packages.length + " packages)");     // Catch: Throwable -> L62
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L60
        monitor-exit(r9);     // Catch: Throwable -> L60
        monitor-exit(this);
        return r0;
    L62:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L67:
        monitor-exit(r9);     // Catch: Throwable -> L71
        Slog.w(TAG, "Restore token " + Long.toHexString(token) + " not found");     // Catch: Throwable -> L7
        monitor-exit(this);
        return -1;
    L75:
        throw new IllegalStateException("Restore session already ended");     // Catch: Throwable -> L7
    L17:
        b.append('{');     // Catch: Throwable -> L7
        boolean first = true;
        int r1 = packages.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L24;
        String s = packages[r2];     // Catch: Throwable -> L7
        if (first == true) goto L22;
        b.append(", ");     // Catch: Throwable -> L7
    L23:
        b.append(s);     // Catch: Throwable -> L7
        r2 = r2 + 1;     // Catch: Throwable -> L7
        goto L18
    L22:
        first = false;
        goto L23
    L24:
        b.append('}');     // Catch: Throwable -> L7
        goto L25
    L13:
        b.append(monitor.toString());     // Catch: Throwable -> L7
        goto L14
    L9:
        b.append(observer.toString());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ RestoreParams lambda$restorePackages$2(IRestoreObserver observer, IBackupManagerMonitor monitor, long token, String[] packages, RestoreSet restoreSet, TransportConnection transportClient, OnTaskFinishedListener listener) {
        boolean r1 = true;
        if (packages.length <= 1) goto L5;
    L4:
        boolean r6 = r1;
        return RestoreParams.createForRestorePackages(transportClient, observer, monitor, token, packages, r6, listener, getBackupEligibilityRules(restoreSet));
    L5:
        r1 = false;
        goto L4
    }

    BackupEligibilityRules getBackupEligibilityRules(RestoreSet restoreSet) {
        if (DEVICE_NAME_FOR_D2D_SET.equals(restoreSet.device) == false) goto L5;
        int backupDestination = 1;
    L7:
        return this.mBackupManagerService.getEligibilityRulesForOperation(backupDestination);
    L5:
        backupDestination = 0;
        goto L7
    }

    public synchronized int restorePackage(String packageName, final IRestoreObserver observer, final IBackupManagerMonitor monitor) {
        monitor-enter(this);
        Slog.d(TAG, "restorePackage pkg=" + packageName + " obs=" + observer + "monitor=" + monitor);     // Catch: Throwable -> L60
        if (this.mEnded == true) goto L68;
        if (this.mTimedOut == false) goto L14;
        Slog.i(TAG, "Session already timed out");     // Catch: Throwable -> L11
        monitor-exit(this);
        return -1;
    L14:
        if (this.mPackageName != null) goto L16;
    L78:
        final PackageInfo app = this.mBackupManagerService.getPackageManager().getPackageInfoAsUser(packageName, 0, this.mUserId);     // Catch: Throwable -> L60 PackageManager.NameNotFoundException -> L62
        goto L63
    L22:
        int perm = this.mBackupManagerService.getContext().checkPermission("android.permission.BACKUP", Binder.getCallingPid(), Binder.getCallingUid());     // Catch: Throwable -> L60
        if (perm != (-1)) goto L31;
        if (app.applicationInfo.uid == Binder.getCallingUid()) goto L31;
        Slog.w(TAG, "restorePackage: bad packageName=" + packageName + " or calling uid=" + Binder.getCallingUid());     // Catch: Throwable -> L11
        throw new SecurityException("No permission to restore other packages");     // Catch: Throwable -> L11
    L31:
        if (this.mTransportManager.isTransportRegistered(this.mTransportName) == true) goto L35;
        Slog.e(TAG, "Transport " + this.mTransportName + " not registered");     // Catch: Throwable -> L11
        monitor-exit(this);
        return -1;
    L35:
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L60
        final long token = this.mBackupManagerService.getAvailableRestoreToken(packageName);     // Catch: Throwable -> L56
        Slog.d(TAG, "restorePackage pkg=" + packageName + " token=" + Long.toHexString(token));     // Catch: Throwable -> L56
        if (token == 0) goto L74;
        int r14 = sendRestoreToHandlerLocked(new ActiveRestoreSession$$ExternalSyntheticLambda4(this, observer, monitor, token, app), "RestoreSession.restorePackage(" + packageName + ")");     // Catch: Throwable -> L54
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L52
        monitor-exit(this);
        return r14;
    L54:
        th = th;
    L58:
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L74:
        Slog.w(TAG, "No data available for this package; not restoring");     // Catch: Throwable -> L44
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L11
        monitor-exit(this);
        return -1;
    L44:
        th = th;
    L56:
        th = th;
    L63:
        Slog.w(TAG, "Asked to restore nonexistent pkg " + packageName);     // Catch: Throwable -> L52
        return -1;
    L16:
        if (this.mPackageName.equals(packageName) == true) goto L78;
        Slog.e(TAG, "Ignoring attempt to restore pkg=" + packageName + " on session for package " + this.mPackageName);     // Catch: Throwable -> L11
        monitor-exit(this);
        return -1;
    L11:
        th = move-exception;
        Throwable r13 = th;
    L69:
        monitor-exit(this);     // Catch: Throwable -> L52
        throw r13;
    L68:
        throw new IllegalStateException("Restore session already ended");     // Catch: Throwable -> L52
    L52:
        th = th;
    L53:
        r13 = th;
    L60:
        th = th;
        goto L53
    }

    private /* synthetic */ RestoreParams lambda$restorePackage$3(IRestoreObserver observer, IBackupManagerMonitor monitor, long token, PackageInfo app, TransportConnection transportClient, OnTaskFinishedListener listener) {
        return RestoreParams.createForSinglePackage(transportClient, observer, monitor, token, app, listener, this.mBackupEligibilityRules);
    }

    public void setRestoreSets(List<RestoreSet> restoreSets) {
        this.mRestoreSets = restoreSets;
    }

    private int sendRestoreToHandlerLocked(BiFunction<TransportConnection, OnTaskFinishedListener, RestoreParams> restoreParamsBuilder, String callerLogString) {
        final TransportConnection transportConnection = this.mTransportManager.getTransportClient(this.mTransportName, callerLogString);
        if (transportConnection != null) goto L6;
        Slog.e(TAG, "Transport " + this.mTransportName + " got unregistered");
        return -1;
    L6:
        Handler backupHandler = this.mBackupManagerService.getBackupHandler();
        backupHandler.removeMessages(8);
        final BackupWakeLock wakelock = this.mBackupManagerService.getWakeLock();
        wakelock.acquire();
        final TransportManager transportManager = this.mTransportManager;
        OnTaskFinishedListener listener = new ActiveRestoreSession$$ExternalSyntheticLambda0(transportManager, transportConnection, wakelock);
        Message msg = backupHandler.obtainMessage(3);
        msg.obj = restoreParamsBuilder.apply(transportConnection, listener);
        backupHandler.sendMessage(msg);
        return 0;
    }

    private static /* synthetic */ void lambda$sendRestoreToHandlerLocked$4(TransportManager transportManager, TransportConnection transportConnection, BackupWakeLock wakelock, String caller) {
        transportManager.disposeOfTransportClient(transportConnection, caller);
        wakelock.release();
    }

    public synchronized void endRestoreSession() {
        monitor-enter(this);
        Slog.d(TAG, "endRestoreSession");     // Catch: Throwable -> L8
        if (this.mTimedOut == false) goto L11;
        Slog.i(TAG, "Session already timed out");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.mEnded == true) goto L16;
        this.mBackupManagerService.getBackupHandler().post(new EndRestoreRunnable(this, this.mBackupManagerService, this));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L16:
        throw new IllegalStateException("Restore session already ended");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
