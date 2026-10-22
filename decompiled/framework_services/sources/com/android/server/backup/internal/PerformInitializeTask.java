package com.android.server.backup.internal;

import android.app.backup.IBackupObserver;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.EventLog;
import android.util.Slog;
import com.android.server.EventLogTags;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.TransportManager;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PerformInitializeTask implements Runnable {
    private final UserBackupManagerService mBackupManagerService;
    private final File mBaseStateDir;
    private final OnTaskFinishedListener mListener;
    private IBackupObserver mObserver;
    private final String[] mQueue;
    private final TransportManager mTransportManager;

    public PerformInitializeTask(UserBackupManagerService backupManagerService, String[] transportNames, IBackupObserver observer, OnTaskFinishedListener listener) {
        this(backupManagerService, backupManagerService.getTransportManager(), transportNames, observer, listener, backupManagerService.getBaseStateDir());
    }

    PerformInitializeTask(UserBackupManagerService backupManagerService, TransportManager transportManager, String[] transportNames, IBackupObserver observer, OnTaskFinishedListener listener, File baseStateDir) {
        this.mBackupManagerService = backupManagerService;
        this.mTransportManager = transportManager;
        this.mQueue = transportNames;
        this.mObserver = observer;
        this.mListener = listener;
        this.mBaseStateDir = baseStateDir;
    }

    private void notifyResult(String target, int status) {
        if (this.mObserver == null) goto L13;
        this.mObserver.onResult(target, status);     // Catch: RemoteException -> L6
        return;
    L13:
        return;
    L9:
        this.mObserver = null;
    }

    private void notifyFinished(int status) {
        if (this.mObserver == null) goto L13;
        this.mObserver.backupFinished(status);     // Catch: RemoteException -> L6
        return;
    L13:
        return;
    L9:
        this.mObserver = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<TransportConnection> transportClientsToDisposeOf = new ArrayList(this.mQueue.length);
        int result = 0;
        String[] r0 = this.mQueue;     // Catch: Throwable -> L46 Exception -> L48
        int r6 = r0.length;     // Catch: Throwable -> L46 Exception -> L48
        int r8 = 0;
    L4:
        if (r8 >= r6) goto L50;
        String transportName = r0[r8];     // Catch: Throwable -> L46 Exception -> L48
        TransportConnection transportConnection = this.mTransportManager.getTransportClient(transportName, "PerformInitializeTask.run()");     // Catch: Throwable -> L46 Exception -> L48
        if (transportConnection == null) goto L77;
        transportClientsToDisposeOf.add(transportConnection);     // Catch: Throwable -> L46 Exception -> L48
        Slog.i(BackupManagerService.TAG, "Initializing (wiping) backup transport storage: " + transportName);     // Catch: Throwable -> L46 Exception -> L48
        String transportDirName = this.mTransportManager.getTransportDirName(transportConnection.getTransportComponent());     // Catch: Throwable -> L46 Exception -> L48
        EventLog.writeEvent(EventLogTags.BACKUP_START, transportDirName);     // Catch: Throwable -> L46 Exception -> L48
        long startRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L46 Exception -> L48
        BackupTransportClient transport = transportConnection.connectOrThrow("PerformInitializeTask.run()");     // Catch: Throwable -> L46 Exception -> L48
        int status = transport.initializeDevice();     // Catch: Throwable -> L46 Exception -> L48
        if (status == 0) goto L18;
        Slog.e(BackupManagerService.TAG, "Transport error in initializeDevice()");     // Catch: Throwable -> L9 Exception -> L11
    L21:
        if (status != 0) goto L24;
        Slog.i(BackupManagerService.TAG, "Device init successful");     // Catch: Throwable -> L9 Exception -> L11
        int millis = (int) (SystemClock.elapsedRealtime() - startRealtime);     // Catch: Throwable -> L9 Exception -> L11
        EventLog.writeEvent(EventLogTags.BACKUP_INITIALIZE, new Object[0]);     // Catch: Throwable -> L9 Exception -> L11
        File stateFileDir = new File(this.mBaseStateDir, transportDirName);     // Catch: Throwable -> L9 Exception -> L11
        this.mBackupManagerService.resetBackupState(stateFileDir);     // Catch: Throwable -> L9 Exception -> L11
        EventLog.writeEvent(EventLogTags.BACKUP_SUCCESS, new Object[]{0, Integer.valueOf(millis)});     // Catch: Throwable -> L9 Exception -> L11
        this.mBackupManagerService.recordInitPending(false, transportName, transportDirName);     // Catch: Throwable -> L9 Exception -> L11
        notifyResult(transportName, 0);     // Catch: Throwable -> L9 Exception -> L11
    L23:
        List<TransportConnection> transportClientsToDisposeOf2 = transportClientsToDisposeOf;
    L33:
        r8 = r8 + 1;
        r0 = r0;
        transportClientsToDisposeOf = transportClientsToDisposeOf2;
        r6 = r6;
        goto L4
    L24:
        r0 = r0;
        r6 = r6;
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_FAILURE, "(initialize)");     // Catch: Throwable -> L46 Exception -> L48
        this.mBackupManagerService.recordInitPending(true, transportName, transportDirName);     // Catch: Throwable -> L46 Exception -> L48
        notifyResult(transportName, status);     // Catch: Throwable -> L46 Exception -> L48
        result = status;
        long delay = transport.requestBackupTime();     // Catch: Throwable -> L42 Exception -> L44
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L42 Exception -> L44
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
        r1.append("Init failed on ");     // Catch: Throwable -> L38 Exception -> L40
        r1.append(transportName);     // Catch: Throwable -> L38 Exception -> L40
        r1.append(" resched in ");     // Catch: Throwable -> L38 Exception -> L40
        r1.append(delay);     // Catch: Throwable -> L38 Exception -> L40
        Slog.w(BackupManagerService.TAG, r1.toString());     // Catch: Throwable -> L38 Exception -> L40
    L75:
        this.mBackupManagerService.getAlarmManager().set(0, System.currentTimeMillis() + delay, this.mBackupManagerService.getRunInitIntent());     // Catch: Throwable -> L34 Exception -> L36
        result = result;
        goto L33
    L36:
        e = e;
        result = result;
    L69:
        Slog.e(BackupManagerService.TAG, "Unexpected error performing init", e);     // Catch: Throwable -> L62
        result = -1000;
        Iterator<TransportConnection> r2 = transportClientsToDisposeOf2.iterator();
    L59:
        if (r2.hasNext() == false) goto L54;
        TransportConnection transportConnection2 = r2.next();
        this.mTransportManager.disposeOfTransportClient(transportConnection2, "PerformInitializeTask.run()");
    L54:
        notifyFinished(result);
        this.mListener.onFinished("PerformInitializeTask.run()");
        return;
    L62:
        th = th;
    L63:
        Iterator<TransportConnection> r3 = transportClientsToDisposeOf2.iterator();
    L65:
        if (r3.hasNext() == false) goto L67;
        TransportConnection transportConnection3 = r3.next();
        this.mTransportManager.disposeOfTransportClient(transportConnection3, "PerformInitializeTask.run()");
        goto L65
    L67:
        notifyFinished(result);
        this.mListener.onFinished("PerformInitializeTask.run()");
        throw th;
    L34:
        th = th;
        result = result;
    L40:
        e = e;
    L38:
        th = th;
        goto L63
    L44:
        e = e;
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
    L42:
        th = th;
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
        goto L63
    L18:
        status = transport.finishBackup();     // Catch: Throwable -> L46 Exception -> L48
        if (status == 0) goto L21;
        Slog.e(BackupManagerService.TAG, "Transport error in finishBackup()");     // Catch: Throwable -> L9 Exception -> L11
        goto L21
    L77:
        Slog.e(BackupManagerService.TAG, "Requested init for " + transportName + " but not found");     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = e;
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
    L9:
        th = th;
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
        goto L63
    L50:
        Iterator<TransportConnection> r4 = transportClientsToDisposeOf.iterator();
    L52:
        if (r4.hasNext() == false) goto L54;
        TransportConnection transportConnection4 = r4.next();
        this.mTransportManager.disposeOfTransportClient(transportConnection4, "PerformInitializeTask.run()");
    L48:
        e = e;
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
    L46:
        th = th;
        transportClientsToDisposeOf2 = transportClientsToDisposeOf;
        goto L63
    }
}
