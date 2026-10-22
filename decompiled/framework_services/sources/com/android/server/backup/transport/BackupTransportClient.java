package com.android.server.backup.transport;

import android.app.backup.IBackupManagerMonitor;
import android.app.backup.RestoreDescription;
import android.app.backup.RestoreSet;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.backup.IBackupTransport;
import com.android.internal.infra.AndroidFuture;
import com.android.server.backup.BackupAndRestoreFeatureFlags;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class BackupTransportClient {
    private static final String TAG = "BackupTransportClient";
    private final TransportStatusCallbackPool mCallbackPool;
    private final IBackupTransport mTransportBinder;
    private final TransportFutures mTransportFutures;

    private static class TransportFutures {
        private final Set<AndroidFuture<?>> mActiveFutures;
        private final Object mActiveFuturesLock;

        /* synthetic */ TransportFutures(BackupTransportClientIA r1) {
            this();
        }

        private TransportFutures() {
            this.mActiveFuturesLock = new Object();
            this.mActiveFutures = new HashSet();
        }

        <T> AndroidFuture<T> newFuture() {
            AndroidFuture<T> future = new AndroidFuture();
            Object r1 = this.mActiveFuturesLock;
            monitor-enter(r1);
            this.mActiveFutures.add(future);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return future;
        L7:
            th = move-exception;
            throw th;
        }

        <T> void remove(AndroidFuture<T> future) {
            Object r0 = this.mActiveFuturesLock;
            monitor-enter(r0);
            this.mActiveFutures.remove(future);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void cancelActiveFutures() {
            Object r0 = this.mActiveFuturesLock;
            monitor-enter(r0);
            Iterator<AndroidFuture<?>> r1 = this.mActiveFutures.iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L15;
            AndroidFuture<?> future = r1.next();     // Catch: Throwable -> L11
            future.cancel(true);     // Catch: Throwable -> L11 CancellationException -> L13
            goto L6
        L15:
            this.mActiveFutures.clear();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    private static class TransportStatusCallbackPool {
        private static final int MAX_POOL_SIZE = 100;
        private final Set<TransportStatusCallback> mActiveCallbacks;
        private final Queue<TransportStatusCallback> mCallbackPool;
        private final Object mPoolLock;

        /* synthetic */ TransportStatusCallbackPool(BackupTransportClientIA r1) {
            this();
        }

        private TransportStatusCallbackPool() {
            this.mPoolLock = new Object();
            this.mCallbackPool = new ArrayDeque();
            this.mActiveCallbacks = new HashSet();
        }

        TransportStatusCallback acquire() {
            Object r0 = this.mPoolLock;
            monitor-enter(r0);
            TransportStatusCallback callback = this.mCallbackPool.poll();     // Catch: Throwable -> L7
            if (callback != null) goto L9;
            callback = new TransportStatusCallback();     // Catch: Throwable -> L7
        L9:
            callback.reset();     // Catch: Throwable -> L7
            this.mActiveCallbacks.add(callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return callback;
        L7:
            th = move-exception;
            throw th;
        }

        void recycle(TransportStatusCallback callback) {
            Object r0 = this.mPoolLock;
            monitor-enter(r0);
            this.mActiveCallbacks.remove(callback);     // Catch: Throwable -> L9
            if (this.mCallbackPool.size() <= 100) goto L11;
            Slog.d(BackupTransportClient.TAG, "TransportStatusCallback pool size exceeded");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            this.mCallbackPool.add(callback);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        void cancelActiveCallbacks() {
            Object r0 = this.mPoolLock;
            monitor-enter(r0);
            Iterator<TransportStatusCallback> r1 = this.mActiveCallbacks.iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L18;
            TransportStatusCallback callback = r1.next();     // Catch: Throwable -> L11
            callback.onOperationCompleteWithStatus(-1000);     // Catch: Throwable -> L11 RemoteException -> L13
            callback.getOperationStatus();     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            if (this.mCallbackPool.size() >= 100) goto L6;
            this.mCallbackPool.add(callback);     // Catch: Throwable -> L11
            goto L6
        L18:
            this.mActiveCallbacks.clear();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    BackupTransportClient(IBackupTransport transportBinder) {
        this.mTransportBinder = transportBinder;
        BackupTransportClientIA r1 = null;
        this.mCallbackPool = new TransportStatusCallbackPool(r1);
        this.mTransportFutures = new TransportFutures(r1);
    }

    public String name() throws RemoteException {
        AndroidFuture<String> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.name(resultFuture);
        return (String) getFutureResult(resultFuture);
    }

    public Intent configurationIntent() throws RemoteException {
        AndroidFuture<Intent> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.configurationIntent(resultFuture);
        return (Intent) getFutureResult(resultFuture);
    }

    public String currentDestinationString() throws RemoteException {
        AndroidFuture<String> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.currentDestinationString(resultFuture);
        return (String) getFutureResult(resultFuture);
    }

    public Intent dataManagementIntent() throws RemoteException {
        AndroidFuture<Intent> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.dataManagementIntent(resultFuture);
        return (Intent) getFutureResult(resultFuture);
    }

    public CharSequence dataManagementIntentLabel() throws RemoteException {
        AndroidFuture<CharSequence> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.dataManagementIntentLabel(resultFuture);
        return (CharSequence) getFutureResult(resultFuture);
    }

    public String transportDirName() throws RemoteException {
        AndroidFuture<String> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.transportDirName(resultFuture);
        return (String) getFutureResult(resultFuture);
    }

    public int initializeDevice() throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.initializeDevice(callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public int clearBackupData(PackageInfo packageInfo) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.clearBackupData(packageInfo, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public int finishBackup() throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.finishBackup(callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public long requestBackupTime() throws RemoteException {
        AndroidFuture<Long> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.requestBackupTime(resultFuture);
        Long result = (Long) getFutureResult(resultFuture);
        if (result != null) goto L6;
        return -1000;
    L6:
        return result.longValue();
    }

    public int performBackup(PackageInfo packageInfo, ParcelFileDescriptor inFd, int flags) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.performBackup(packageInfo, inFd, flags, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public List<RestoreSet> getAvailableRestoreSets() throws RemoteException {
        AndroidFuture<List<RestoreSet>> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.getAvailableRestoreSets(resultFuture);
        List<RestoreSet> result = (List) getFutureResult(resultFuture);
        return result;
    }

    public long getCurrentRestoreSet() throws RemoteException {
        AndroidFuture<Long> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.getCurrentRestoreSet(resultFuture);
        Long result = (Long) getFutureResult(resultFuture);
        if (result != null) goto L6;
        return -1000;
    L6:
        return result.longValue();
    }

    public int startRestore(long token, PackageInfo[] packages) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.startRestore(token, packages, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public RestoreDescription nextRestorePackage() throws RemoteException {
        AndroidFuture<RestoreDescription> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.nextRestorePackage(resultFuture);
        return (RestoreDescription) getFutureResult(resultFuture);
    }

    public int getRestoreData(ParcelFileDescriptor outFd) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.getRestoreData(outFd, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public void finishRestore() throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.finishRestore(callback);     // Catch: Throwable -> L6
        callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public long requestFullBackupTime() throws RemoteException {
        AndroidFuture<Long> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.requestFullBackupTime(resultFuture);
        Long result = (Long) getFutureResult(resultFuture);
        if (result != null) goto L6;
        return -1000;
    L6:
        return result.longValue();
    }

    public int performFullBackup(PackageInfo targetPackage, ParcelFileDescriptor socket, int flags) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.performFullBackup(targetPackage, socket, flags, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public int checkFullBackupSize(long size) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.checkFullBackupSize(size, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public int sendBackupData(int numBytes) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.sendBackupData(numBytes, callback);
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public void cancelFullBackup() throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.cancelFullBackup(callback);     // Catch: Throwable -> L6
        callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public boolean isAppEligibleForBackup(PackageInfo targetPackage, boolean isFullBackup) throws RemoteException {
        AndroidFuture<Boolean> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.isAppEligibleForBackup(targetPackage, isFullBackup, resultFuture);
        Boolean result = (Boolean) getFutureResult(resultFuture);
        if (result != null) goto L5;
    L7:
        return false;
    L5:
        if (result.booleanValue() == false) goto L7;
        return true;
    }

    public long getBackupQuota(String packageName, boolean isFullBackup) throws RemoteException {
        AndroidFuture<Long> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.getBackupQuota(packageName, isFullBackup, resultFuture);
        Long result = (Long) getFutureResult(resultFuture);
        if (result != null) goto L6;
        return -1000;
    L6:
        return result.longValue();
    }

    public int getNextFullRestoreDataChunk(ParcelFileDescriptor socket) throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.getNextFullRestoreDataChunk(socket, callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public int abortFullRestore() throws RemoteException {
        TransportStatusCallback callback = this.mCallbackPool.acquire();
        this.mTransportBinder.abortFullRestore(callback);     // Catch: Throwable -> L6
        int r1 = callback.getOperationStatus();     // Catch: Throwable -> L6
        this.mCallbackPool.recycle(callback);
        return r1;
    L6:
        th = move-exception;
        this.mCallbackPool.recycle(callback);
        throw th;
    }

    public int getTransportFlags() throws RemoteException {
        AndroidFuture<Integer> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.getTransportFlags(resultFuture);
        Integer result = (Integer) getFutureResult(resultFuture);
        if (result != null) goto L6;
        return -1000;
    L6:
        return result.intValue();
    }

    public IBackupManagerMonitor getBackupManagerMonitor() throws RemoteException {
        AndroidFuture<IBackupManagerMonitor> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.getBackupManagerMonitor(resultFuture);
        return IBackupManagerMonitor.Stub.asInterface((IBinder) getFutureResult(resultFuture));
    }

    public Set<String> getPackagesThatShouldNotUseRestrictedMode(Set<String> packageNames, int operationType) throws RemoteException {
        AndroidFuture<List<String>> resultFuture = this.mTransportFutures.newFuture();
        this.mTransportBinder.getPackagesThatShouldNotUseRestrictedMode(List.copyOf(packageNames), operationType, resultFuture);
        Collection<? extends String> resultList = (List) getFutureResult(resultFuture);
        Set<String> set = new ArraySet();
        if (resultList != null) goto L5;
        return set;
    L5:
        set.addAll(resultList);
        return set;
    }

    void onBecomingUnusable() {
        this.mCallbackPool.cancelActiveCallbacks();
        this.mTransportFutures.cancelActiveFutures();
    }

    private <T> T getFutureResult(AndroidFuture<T> r4) {
        T r0 = (T) r4.get(BackupAndRestoreFeatureFlags.getBackupTransportFutureTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.mTransportFutures.remove(r4);
        return r0;
    L5:
        th = move-exception;
        this.mTransportFutures.remove(r4);
        throw th;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to get result from transport:", e);     // Catch: Throwable -> L5
        this.mTransportFutures.remove(r4);
        return null;
    }
}
