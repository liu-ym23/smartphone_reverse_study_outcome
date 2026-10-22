package com.android.server.backup.transport;

import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.backup.ITransportStatusCallback;
import com.android.server.backup.BackupAndRestoreFeatureFlags;

/* JADX INFO: loaded from: classes.dex */
public class TransportStatusCallback extends ITransportStatusCallback.Stub {
    private static final int OPERATION_STATUS_DEFAULT = 0;
    private static final String TAG = "TransportStatusCallback";
    private boolean mHasCompletedOperation;
    private int mOperationStatus;
    private final long mOperationTimeout;

    public TransportStatusCallback() {
        this.mOperationStatus = 0;
        this.mHasCompletedOperation = false;
        this.mOperationTimeout = BackupAndRestoreFeatureFlags.getBackupTransportCallbackTimeoutMillis();
    }

    TransportStatusCallback(int operationTimeout) {
        this.mOperationStatus = 0;
        this.mHasCompletedOperation = false;
        this.mOperationTimeout = operationTimeout;
    }

    public synchronized void onOperationCompleteWithStatus(int status) throws RemoteException {
        monitor-enter(this);
        this.mHasCompletedOperation = true;     // Catch: Throwable -> L7
        this.mOperationStatus = status;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void onOperationComplete() throws RemoteException {
        monitor-enter(this);
        onOperationCompleteWithStatus(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized int getOperationStatus() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasCompletedOperation == false) goto L10;
        int r0 = this.mOperationStatus;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        long timeoutLeft = this.mOperationTimeout;     // Catch: Throwable -> L8
    L32:
    L20:
        e = move-exception;
        Slog.w(TAG, "Couldn't get operation status from transport: ", e);     // Catch: Throwable -> L8
    L27:
        monitor-exit(this);
        return -1000;
    L12:
        if (this.mHasCompletedOperation == true) goto L23;
        if (timeoutLeft <= 0) goto L23;
        long waitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L8 InterruptedException -> L20
        wait(timeoutLeft);     // Catch: Throwable -> L8 InterruptedException -> L20
        if (this.mHasCompletedOperation == true) goto L17;
        timeoutLeft = timeoutLeft - (System.currentTimeMillis() - waitStartTime);     // Catch: Throwable -> L8 InterruptedException -> L20
        goto L32
    L17:
        int r4 = this.mOperationStatus;     // Catch: Throwable -> L8 InterruptedException -> L20
        monitor-exit(this);
        return r4;
    L23:
        Slog.w(TAG, "Couldn't get operation status from transport");     // Catch: Throwable -> L8 InterruptedException -> L20
        goto L27
    }

    synchronized void reset() {
        monitor-enter(this);
        this.mHasCompletedOperation = false;     // Catch: Throwable -> L7
        this.mOperationStatus = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
