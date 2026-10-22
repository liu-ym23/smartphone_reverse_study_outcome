package com.android.server.backup.internal;

import android.app.backup.IBackupManagerMonitor;
import android.app.backup.RestoreSet;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import android.util.EventLog;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.EventLogTags;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.DataChangedJournal;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.TransportManager;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.fullbackup.PerformAdbBackupTask;
import com.android.server.backup.keyvalue.BackupRequest;
import com.android.server.backup.keyvalue.KeyValueBackupTask;
import com.android.server.backup.params.AdbBackupParams;
import com.android.server.backup.params.AdbParams;
import com.android.server.backup.params.AdbRestoreParams;
import com.android.server.backup.params.BackupParams;
import com.android.server.backup.params.ClearParams;
import com.android.server.backup.params.ClearRetryParams;
import com.android.server.backup.params.RestoreGetSetsParams;
import com.android.server.backup.params.RestoreParams;
import com.android.server.backup.restore.ActiveRestoreSession;
import com.android.server.backup.restore.PerformAdbRestoreTask;
import com.android.server.backup.restore.PerformUnifiedRestoreTask;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class BackupHandler extends Handler {
    public static final int MSG_BACKUP_OPERATION_TIMEOUT = 17;
    public static final int MSG_BACKUP_RESTORE_STEP = 20;
    public static final int MSG_FULL_CONFIRMATION_TIMEOUT = 9;
    public static final int MSG_OP_COMPLETE = 21;
    public static final int MSG_REQUEST_BACKUP = 15;
    public static final int MSG_RESTORE_OPERATION_TIMEOUT = 18;
    public static final int MSG_RESTORE_SESSION_TIMEOUT = 8;
    public static final int MSG_RETRY_CLEAR = 12;
    public static final int MSG_RUN_ADB_BACKUP = 2;
    public static final int MSG_RUN_ADB_RESTORE = 10;
    public static final int MSG_RUN_BACKUP = 1;
    public static final int MSG_RUN_CLEAR = 4;
    public static final int MSG_RUN_GET_RESTORE_SETS = 6;
    public static final int MSG_RUN_RESTORE = 3;
    public static final int MSG_SCHEDULE_BACKUP_PACKAGE = 16;
    public static final int MSG_STOP = 22;
    private final UserBackupManagerService backupManagerService;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private final HandlerThread mBackupThread;
    volatile boolean mIsStopping;
    private final OperationStorage mOperationStorage;

    /* JADX INFO: renamed from: $r8$lambda$QzpgMAn6jqRSL2t0QYc7xFry-Ro, reason: not valid java name */
    public static /* synthetic */ void m2530$r8$lambda$QzpgMAn6jqRSL2t0QYc7xFryRo(TransportManager r0, TransportConnection r1, String r2) {
        lambda$handleMessage$0(r0, r1, r2);
    }

    public BackupHandler(UserBackupManagerService backupManagerService, OperationStorage operationStorage, HandlerThread backupThread) {
        super(backupThread.getLooper());
        this.mIsStopping = false;
        this.mBackupThread = backupThread;
        this.backupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
    }

    public void stop() {
        this.mIsStopping = true;
        sendMessage(obtainMessage(22));
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        dispatchMessageInternal(message);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if (this.mIsStopping == false) goto L8;
        return;
    L8:
        throw e;
    }

    void dispatchMessageInternal(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        if (msg.what != 22) goto L6;
        Slog.d(BackupManagerService.TAG, "Stopping backup handler");
        this.backupManagerService.getWakeLock().quit();
        this.mBackupThread.quitSafely();
    L6:
        if (this.mIsStopping == false) goto L8;
        return;
    L8:
        final TransportManager transportManager = this.backupManagerService.getTransportManager();
        switch(msg.what) {
            case 1: goto L124;
            case 2: goto L123;
            case 3: goto L111;
            case 4: goto L110;
            case 5: goto L220;
            case 6: goto L52;
            case 7: goto L220;
            case 8: goto L41;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L220;
            case 12: goto L22;
            case 13: goto L220;
            case 14: goto L220;
            case 15: goto L21;
            case 16: goto L20;
            case 17: goto L19;
            case 18: goto L19;
            case 19: goto L220;
            case 20: goto L179;
            case 21: goto L187;
            default: goto L220;
        };
    L19:
        Slog.d(BackupManagerService.TAG, "Timeout for token=" + Integer.toHexString(msg.arg1));
        this.backupManagerService.handleCancel(msg.arg1, 0);
        return;
    L20:
        String pkgName = (String) msg.obj;
        this.backupManagerService.dataChangedImpl(pkgName);
        return;
    L21:
        BackupParams params = (BackupParams) msg.obj;
        this.backupManagerService.setBackupRunning(true);
        this.backupManagerService.getWakeLock().acquire();
        KeyValueBackupTask.start(this.backupManagerService, this.mOperationStorage, params.mTransportConnection, params.dirName, params.kvPackages, null, params.observer, params.monitor, params.listener, params.fullPackages, true, params.nonIncrementalBackup, params.mBackupEligibilityRules);
        return;
    L22:
        ClearRetryParams params2 = (ClearRetryParams) msg.obj;
        this.backupManagerService.clearBackupData(params2.transportName, params2.packageName);
        return;
    L23:
        AdbRestoreParams params3 = (AdbRestoreParams) msg.obj;
        PerformAdbRestoreTask task = new PerformAdbRestoreTask(this.backupManagerService, this.mOperationStorage, params3.fd, params3.curPassword, params3.encryptPassword, params3.observer, params3.latch);
        new Thread(task, "adb-restore").start();
        return;
    L24:
        SparseArray<AdbParams> r4 = this.backupManagerService.getAdbBackupRestoreConfirmations();
        monitor-enter(r4);
        AdbParams params4 = this.backupManagerService.getAdbBackupRestoreConfirmations().get(msg.arg1);     // Catch: Throwable -> L32
        if (params4 == null) goto L36;
        Slog.i(BackupManagerService.TAG, "Full backup/restore timed out waiting for user confirmation");     // Catch: Throwable -> L32
        this.backupManagerService.signalAdbBackupRestoreCompletion(params4);     // Catch: Throwable -> L32
        this.backupManagerService.getAdbBackupRestoreConfirmations().delete(msg.arg1);     // Catch: Throwable -> L32
        if (params4.observer != null) goto L193;
    L37:
        monitor-exit(r4);     // Catch: Throwable -> L32
        return;
    L193:
        params4.observer.onTimeout();     // Catch: Throwable -> L32 RemoteException -> L34
        goto L37
    L36:
        Slog.d(BackupManagerService.TAG, "couldn't find params for token " + msg.arg1);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L41:
        UserBackupManagerService r5 = this.backupManagerService;
        monitor-enter(r5);
    L46:
        th = move-exception;
        throw th;
    L44:
        if (this.backupManagerService.getActiveRestoreSession() == null) goto L48;
        Slog.w(BackupManagerService.TAG, "Restore session timed out; aborting");     // Catch: Throwable -> L46
        this.backupManagerService.getActiveRestoreSession().markTimedOut();     // Catch: Throwable -> L46
        ActiveRestoreSession r6 = this.backupManagerService.getActiveRestoreSession();     // Catch: Throwable -> L46
        r6.getClass();     // Catch: Throwable -> L46
        post(new ActiveRestoreSession.EndRestoreRunnable(r6, this.backupManagerService, this.backupManagerService.getActiveRestoreSession()));     // Catch: Throwable -> L46
    L48:
        monitor-exit(r5);     // Catch: Throwable -> L46
        return;
    L52:
        List<RestoreSet> sets = null;
        RestoreGetSetsParams params5 = (RestoreGetSetsParams) msg.obj;
        List<RestoreSet> sets2 = params5.mTransportConnection.connectOrThrow("BH/MSG_RUN_GET_RESTORE_SETS").getAvailableRestoreSets();     // Catch: Throwable -> L60 Exception -> L62
        ActiveRestoreSession r11 = params5.session;     // Catch: Throwable -> L60 Exception -> L62
        monitor-enter(r11);     // Catch: Throwable -> L60 Exception -> L62
        params5.session.setRestoreSets(sets2);     // Catch: Throwable -> L78
        monitor-exit(r11);     // Catch: Throwable -> L78
        if (sets2 != null) goto L65;
        EventLog.writeEvent(EventLogTags.RESTORE_TRANSPORT_FAILURE, new Object[0]);     // Catch: Throwable -> L60 Exception -> L62
    L65:
        if (params5.observer == null) goto L77;
        if (sets2 != null) goto L72;
        params5.observer.restoreSetsAvailable(null);     // Catch: Exception -> L68 RemoteException -> L70
    L196:
        goto L76
    L72:
        params5.observer.restoreSetsAvailable((RestoreSet[]) sets2.toArray(new RestoreSet[0]));     // Catch: Exception -> L68 RemoteException -> L70
    L68:
        e = e;
        String r7 = BackupManagerService.TAG;
        StringBuilder r8 = new StringBuilder();
    L75:
        r8.append("Restore observer threw: ");
        r8.append(e.getMessage());
        Slog.e(r7, r8.toString());
    L76:
        Slog.e(BackupManagerService.TAG, "Unable to report listing to observer");
    L77:
        removeMessages(8);
        sendEmptyMessageDelayed(8, this.mAgentTimeoutParameters.getRestoreSessionTimeoutMillis());
        params5.listener.onFinished("BH/MSG_RUN_GET_RESTORE_SETS");
        return;
    L78:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60 Exception -> L62
    L60:
        th = move-exception;
        if (params5.observer != null) goto L200;
    L108:
        removeMessages(8);
        sendEmptyMessageDelayed(8, this.mAgentTimeoutParameters.getRestoreSessionTimeoutMillis());
        params5.listener.onFinished("BH/MSG_RUN_GET_RESTORE_SETS");
        throw th;
    L200:
        if (0 != 0) goto L104;
        params5.observer.restoreSetsAvailable(null);     // Catch: Exception -> L100 RemoteException -> L102
    L199:
        goto L107
    L104:
        params5.observer.restoreSetsAvailable((RestoreSet[]) sets.toArray(new RestoreSet[0]));     // Catch: Exception -> L100 RemoteException -> L102
    L100:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Restore observer threw: " + e.getMessage());
    L107:
        Slog.e(BackupManagerService.TAG, "Unable to report listing to observer");
    L62:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Error from transport getting set list: " + e.getMessage());     // Catch: Throwable -> L60
        if (params5.observer == null) goto L77;
        if (0 != 0) goto L91;
        params5.observer.restoreSetsAvailable(null);     // Catch: Exception -> L87 RemoteException -> L89
    L202:
        goto L94
    L91:
        params5.observer.restoreSetsAvailable((RestoreSet[]) sets.toArray(new RestoreSet[0]));     // Catch: Exception -> L87 RemoteException -> L89
    L87:
        e = e;
        r7 = BackupManagerService.TAG;
        r8 = new StringBuilder();
    L94:
        Slog.e(BackupManagerService.TAG, "Unable to report listing to observer");
        goto L77
    L110:
        ClearParams params6 = (ClearParams) msg.obj;
        Runnable task2 = new PerformClearTask(this.backupManagerService, params6.mTransportConnection, params6.packageInfo, params6.listener);
        task2.run();
        return;
    L111:
        RestoreParams params7 = (RestoreParams) msg.obj;
        Slog.d(BackupManagerService.TAG, "MSG_RUN_RESTORE observer=" + params7.observer);
        PerformUnifiedRestoreTask task3 = new PerformUnifiedRestoreTask(this.backupManagerService, this.mOperationStorage, params7.mTransportConnection, params7.observer, params7.monitor, params7.token, params7.packageInfo, params7.pmToken, params7.isSystemRestore, params7.filterSet, params7.listener, params7.backupEligibilityRules);
        Queue<PerformUnifiedRestoreTask> r9 = this.backupManagerService.getPendingRestores();
        monitor-enter(r9);
    L116:
        th = move-exception;
        throw th;
    L114:
        if (this.backupManagerService.isRestoreInProgress() == false) goto L118;
        Slog.d(BackupManagerService.TAG, "Restore in progress, queueing.");     // Catch: Throwable -> L116
        this.backupManagerService.getPendingRestores().add(task3);     // Catch: Throwable -> L116
    L119:
        monitor-exit(r9);     // Catch: Throwable -> L116
        return;
    L118:
        Slog.d(BackupManagerService.TAG, "Starting restore.");     // Catch: Throwable -> L116
        this.backupManagerService.setRestoreInProgress(true);     // Catch: Throwable -> L116
        Message restoreMsg = obtainMessage(20, task3);     // Catch: Throwable -> L116
        sendMessage(restoreMsg);     // Catch: Throwable -> L116
        goto L119
    L123:
        AdbBackupParams params8 = (AdbBackupParams) msg.obj;
        PerformAdbBackupTask task4 = new PerformAdbBackupTask(this.backupManagerService, this.mOperationStorage, params8.fd, params8.observer, params8.includeApks, params8.includeObbs, params8.includeShared, params8.doWidgets, params8.curPassword, params8.encryptPassword, params8.allApps, params8.includeSystem, params8.doCompress, params8.includeKeyValue, params8.packages, params8.latch, params8.backupEligibilityRules);
        new Thread(task4, "adb-backup").start();
        return;
    L124:
        this.backupManagerService.setLastBackupPass(System.currentTimeMillis());
        final TransportConnection transportConnection = transportManager.getCurrentTransportClient("BH/MSG_RUN_BACKUP");
        if (transportConnection == null) goto L127;
        BackupTransportClient r0 = transportConnection.connect("BH/MSG_RUN_BACKUP");
    L128:
        BackupTransportClient transport = r0;
        if (transport != null) goto L133;
        if (transportConnection == null) goto L132;
        transportManager.disposeOfTransportClient(transportConnection, "BH/MSG_RUN_BACKUP");
    L132:
        Slog.d(BackupManagerService.TAG, "Backup requested but no transport available");
        return;
    L133:
        List<String> queue = new ArrayList();
        DataChangedJournal oldJournal = this.backupManagerService.getJournal();
        Object r10 = this.backupManagerService.getQueueLock();
        monitor-enter(r10);
    L140:
        th = move-exception;
        throw th;
    L136:
        if (this.backupManagerService.isBackupRunning() == false) goto L142;
        Slog.i(BackupManagerService.TAG, "Backup time but one already running");     // Catch: Throwable -> L140
        monitor-exit(r10);     // Catch: Throwable -> L140
        return;
    L142:
        Slog.d(BackupManagerService.TAG, "Running a backup pass");     // Catch: Throwable -> L140
        this.backupManagerService.setBackupRunning(true);     // Catch: Throwable -> L140
        this.backupManagerService.getWakeLock().acquire();     // Catch: Throwable -> L140
        if (this.backupManagerService.getPendingBackups().size() <= 0) goto L149;
        Iterator<BackupRequest> r1 = this.backupManagerService.getPendingBackups().values().iterator();     // Catch: Throwable -> L140
    L146:
        if (r1.hasNext() == false) goto L148;
        BackupRequest b = r1.next();     // Catch: Throwable -> L140
        queue.add(b.packageName);     // Catch: Throwable -> L140
        goto L146
    L148:
        Slog.d(BackupManagerService.TAG, "clearing pending backups");     // Catch: Throwable -> L140
        this.backupManagerService.getPendingBackups().clear();     // Catch: Throwable -> L140
        this.backupManagerService.setJournal(null);     // Catch: Throwable -> L140
    L149:
        monitor-exit(r10);     // Catch: Throwable -> L140
        IBackupManagerMonitor monitor = transport.getBackupManagerMonitor();     // Catch: RemoteException -> L153
        IBackupManagerMonitor monitor2 = monitor;
    L155:
        boolean staged = true;
        if (queue.size() > 0) goto L183;
        Slog.d(BackupManagerService.TAG, "Backup requested but nothing pending");
        staged = false;
    L162:
        if (staged == true) goto L218;
        transportManager.disposeOfTransportClient(transportConnection, "BH/MSG_RUN_BACKUP");
        Object r12 = this.backupManagerService.getQueueLock();
        monitor-enter(r12);
        this.backupManagerService.setBackupRunning(false);     // Catch: Throwable -> L168
        monitor-exit(r12);     // Catch: Throwable -> L168
        this.backupManagerService.getWakeLock().release();
        return;
    L168:
        th = move-exception;
        throw th;
    L218:
        return;
    L183:
        OnTaskFinishedListener listener = new BackupHandler$$ExternalSyntheticLambda0(transportManager, transportConnection);     // Catch: Exception -> L159
        KeyValueBackupTask.start(this.backupManagerService, this.mOperationStorage, transportConnection, transport.transportDirName(), queue, oldJournal, null, monitor2, listener, Collections.emptyList(), false, false, this.backupManagerService.getEligibilityRulesForOperation(0));     // Catch: Exception -> L159
    L159:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Transport became unavailable attempting backup or error initializing backup task", e);
        staged = false;
    L154:
        Slog.i(BackupManagerService.TAG, "Failed to retrieve monitor from transport");
        monitor2 = null;
        goto L155
    L127:
        r0 = null;
        goto L128
    L179:
        BackupRestoreTask task5 = (BackupRestoreTask) msg.obj;     // Catch: ClassCastException -> L17
        task5.execute();     // Catch: ClassCastException -> L17
        return;
    L18:
        Slog.e(BackupManagerService.TAG, "Invalid backup/restore task in flight, obj=" + msg.obj);
        return;
    L187:
        Pair<BackupRestoreTask, Long> taskWithResult = (Pair) msg.obj;     // Catch: ClassCastException -> L13
        ((BackupRestoreTask) taskWithResult.first).operationComplete(((Long) taskWithResult.second).longValue());     // Catch: ClassCastException -> L13
        return;
    L14:
        Slog.e(BackupManagerService.TAG, "Invalid completion in flight, obj=" + msg.obj);
        return;
    }

    private static /* synthetic */ void lambda$handleMessage$0(TransportManager transportManager, TransportConnection transportConnection, String caller) {
        transportManager.disposeOfTransportClient(transportConnection, caller);
    }
}
