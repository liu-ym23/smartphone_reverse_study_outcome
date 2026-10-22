package com.android.server.storage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.ParcelableException;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.storage.StorageManagerInternal;
import android.os.storage.StorageVolume;
import android.service.storage.IExternalStorageService;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class StorageUserConnection {
    private static final int DEFAULT_REMOTE_TIMEOUT_SECONDS = 20;
    private static final String TAG = "StorageUserConnection";
    private final ActiveConnection mActiveConnection;
    private final Context mContext;
    private final HandlerThread mHandlerThread;
    private final StorageSessionController mSessionController;
    private final Map<String, Session> mSessions;
    private final Object mSessionsLock;
    private final StorageManagerInternal mSmInternal;
    private final SparseArray<Integer> mUidsBlockedOnIo;
    private final int mUserId;

    private final class ActiveConnection implements AutoCloseable {
        private final Object mLock;
        private final ArrayList<CompletableFuture<Void>> mOutstandingOps;
        private CompletableFuture<IExternalStorageService> mRemoteFuture;
        private ServiceConnection mServiceConnection;
        final /* synthetic */ StorageUserConnection this$0;

        public static /* synthetic */ void $r8$lambda$04dA9DGkZc4GQtJeTWg5WQvjt7Y(String r0, int r1, int r2, int r3, IExternalStorageService r4) {
            lambda$notifyAnrDelayStarted$6(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ CompletionStage $r8$lambda$FmJboNYjokBfJEVj67KD2wZpm14(AsyncStorageServiceCall r0, RemoteCallback r1, CompletableFuture r2, IExternalStorageService r3) {
            return lambda$waitForAsync$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$GXIyazwVX_rUkeKdlCrCHRfXRB8(ActiveConnection r0, CompletableFuture r1, Bundle r2) {
            r0.lambda$waitForAsyncVoid$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$Pl45RFKLY3W6fdtLXyL-TJ8dUpo, reason: not valid java name */
        public static /* synthetic */ void m8438$r8$lambda$Pl45RFKLY3W6fdtLXyLTJ8dUpo(Session r0, IExternalStorageService r1, RemoteCallback r2) {
            lambda$endSession$3(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$ZUID6_fjlmkWslb1Z-5VMQs3jZA, reason: not valid java name */
        public static /* synthetic */ void m8439$r8$lambda$ZUID6_fjlmkWslb1Z5VMQs3jZA(Session r0, ParcelFileDescriptor r1, IExternalStorageService r2, RemoteCallback r3) {
            lambda$startSession$2(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$aiyAMsuUyqAtzW9JiGlGmzYO5Ms(String r0, StorageVolume r1, IExternalStorageService r2, RemoteCallback r3) {
            lambda$notifyVolumeStateChanged$4(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$xwYn-Ri2OokPDwcXbBZFVWZ9zE0, reason: not valid java name */
        public static /* synthetic */ void m8440$r8$lambda$xwYnRi2OokPDwcXbBZFVWZ9zE0(String r0, String r1, long r2, IExternalStorageService r4, RemoteCallback r5) {
            lambda$freeCache$5(r0, r1, r2, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m8441$$Nest$fgetmLock(ActiveConnection r0) {
            return r0.mLock;
        }

        /* synthetic */ ActiveConnection(StorageUserConnection r1, StorageUserConnectionIA r2) {
            this(r1);
        }

        private ActiveConnection(StorageUserConnection r1) {
            this.this$0 = r1;
            this.mLock = new Object();
            this.mOutstandingOps = new ArrayList();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            Object r1 = this.mLock;
            monitor-enter(r1);
            Slog.i(StorageUserConnection.TAG, "Closing connection for user " + StorageUserConnection.m8437$$Nest$fgetmUserId(this.this$0));     // Catch: Throwable -> L7
            ServiceConnection oldConnection = this.mServiceConnection;     // Catch: Throwable -> L7
            this.mServiceConnection = null;     // Catch: Throwable -> L7
            if (this.mRemoteFuture == null) goto L9;
            this.mRemoteFuture.cancel(true);     // Catch: Throwable -> L7
            this.mRemoteFuture = null;     // Catch: Throwable -> L7
        L9:
            Iterator<CompletableFuture<Void>> r2 = this.mOutstandingOps.iterator();     // Catch: Throwable -> L7
        L11:
            if (r2.hasNext() == false) goto L13;
            CompletableFuture<Void> op = r2.next();     // Catch: Throwable -> L7
            op.cancel(true);     // Catch: Throwable -> L7
            goto L11
        L13:
            this.mOutstandingOps.clear();     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (oldConnection == null) goto L28;
            StorageUserConnection.m8434$$Nest$fgetmContext(this.this$0).unbindService(oldConnection);     // Catch: Exception -> L18
            return;
        L18:
            e = move-exception;
            Slog.w(StorageUserConnection.TAG, "Failed to unbind service", e);
            return;
        L28:
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void asyncBestEffort(Consumer<IExternalStorageService> consumer) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mRemoteFuture != null) goto L11;
            Slog.w(StorageUserConnection.TAG, "Dropping async request service is not bound");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            IExternalStorageService service = this.mRemoteFuture.getNow(null);     // Catch: Throwable -> L9
            if (service != null) goto L16;
            Slog.w(StorageUserConnection.TAG, "Dropping async request service is not connected");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            consumer.accept(service);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        private void waitForAsyncVoid(AsyncStorageServiceCall asyncCall) throws Exception {
            waitForAsyncVoid(asyncCall, true, 20);
        }

        private void waitForAsyncVoid(AsyncStorageServiceCall asyncCall, boolean bindIfNotConnected, int timeoutSeconds) throws Exception {
            final CompletableFuture<Void> opFuture = new CompletableFuture();
            RemoteCallback callback = new RemoteCallback(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda5(this, opFuture));
            waitForAsync(asyncCall, callback, opFuture, this.mOutstandingOps, bindIfNotConnected, timeoutSeconds);
        }

        private /* synthetic */ void lambda$waitForAsyncVoid$0(CompletableFuture opFuture, Bundle result) {
            setResult(result, opFuture);
        }

        private <T> T waitForAsync(final AsyncStorageServiceCall r5, final RemoteCallback r6, final CompletableFuture<T> r7, ArrayList<CompletableFuture<T>> r8, boolean r9, long r10) throws Exception {
            if (r9 == false) goto L4;
            CompletableFuture<IExternalStorageService> r1 = connectIfNeeded();
        L51:
            Object r0 = this.mLock;     // Catch: Throwable -> L26
            monitor-enter(r0);     // Catch: Throwable -> L26
            r8.add(r7);     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            T r2 = (T) r1.thenCompose(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda1(r5, r6, r7)).get(r10, TimeUnit.SECONDS);
            Object r3 = this.mLock;
            monitor-enter(r3);
            r8.remove(r7);     // Catch: Throwable -> L23
            monitor-exit(r3);     // Catch: Throwable -> L23
            return r2;
        L23:
            th = move-exception;
            throw th;
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            monitor-enter(this.mLock);
            r8.remove(r7);     // Catch: Throwable -> L36
            throw th;
        L36:
            th = move-exception;
            throw th;
        L4:
            Object r4 = this.mLock;
            monitor-enter(r4);
        L39:
            th = move-exception;
            throw th;
        L7:
            if (this.mRemoteFuture == null) goto L41;
            if (this.mRemoteFuture.getNow(null) == null) goto L41;
            r1 = this.mRemoteFuture;     // Catch: Throwable -> L39
            monitor-exit(r4);     // Catch: Throwable -> L39
        L41:
            Slog.w(StorageUserConnection.TAG, "Dropping async request as service is not connectedand request doesn't require connecting");     // Catch: Throwable -> L39
            monitor-exit(r4);     // Catch: Throwable -> L39
            return null;
        }

        private static /* synthetic */ CompletionStage lambda$waitForAsync$1(AsyncStorageServiceCall asyncCall, RemoteCallback callback, CompletableFuture opFuture, IExternalStorageService service) {
            asyncCall.run(service, callback);     // Catch: RemoteException -> L4
        L6:
            return opFuture;
        L4:
            e = move-exception;
            opFuture.completeExceptionally(e);
            goto L6
        }

        private static /* synthetic */ void lambda$startSession$2(Session session, ParcelFileDescriptor fd, IExternalStorageService service, RemoteCallback callback) throws RemoteException {
            service.startSession(session.sessionId, 3, fd, session.upperPath, session.lowerPath, callback);
        }

        public void startSession(final Session session, final ParcelFileDescriptor fd) throws StorageSessionController.ExternalStorageServiceException {
            waitForAsyncVoid(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda4(session, fd));     // Catch: Throwable -> L7 Exception -> L9
            fd.close();     // Catch: IOException -> L5
            return;
        L6:
            return;
        L9:
            e = move-exception;
            throw new StorageSessionController.ExternalStorageServiceException("Failed to start session: " + session, e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            fd.close();     // Catch: IOException -> L14
        L15:
            throw th;
        }

        public void endSession(final Session session) throws StorageSessionController.ExternalStorageServiceException {
            waitForAsyncVoid(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda6(session), false, 10);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new StorageSessionController.ExternalStorageServiceException("Failed to end session: " + session, e);
        }

        private static /* synthetic */ void lambda$endSession$3(Session session, IExternalStorageService service, RemoteCallback callback) throws RemoteException {
            service.endSession(session.sessionId, callback);
        }

        public void notifyVolumeStateChanged(final String sessionId, final StorageVolume vol) throws StorageSessionController.ExternalStorageServiceException {
            waitForAsyncVoid(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda3(sessionId, vol), false, 10);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new StorageSessionController.ExternalStorageServiceException("Failed to notify volume state changed for vol : " + vol, e);
        }

        private static /* synthetic */ void lambda$notifyVolumeStateChanged$4(String sessionId, StorageVolume vol, IExternalStorageService service, RemoteCallback callback) throws RemoteException {
            service.notifyVolumeStateChanged(sessionId, vol, callback);
        }

        public void freeCache(final String sessionId, final String volumeUuid, final long bytes) throws StorageSessionController.ExternalStorageServiceException {
            waitForAsyncVoid(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda0(sessionId, volumeUuid, bytes));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new StorageSessionController.ExternalStorageServiceException("Failed to free " + bytes + " bytes for volumeUuid : " + volumeUuid, e);
        }

        private static /* synthetic */ void lambda$freeCache$5(String sessionId, String volumeUuid, long bytes, IExternalStorageService service, RemoteCallback callback) throws RemoteException {
            service.freeCache(sessionId, volumeUuid, bytes, callback);
        }

        public void notifyAnrDelayStarted(final String packgeName, final int uid, final int tid, final int reason) throws StorageSessionController.ExternalStorageServiceException {
            asyncBestEffort(new StorageUserConnection$ActiveConnection$$ExternalSyntheticLambda2(packgeName, uid, tid, reason));
        }

        private static /* synthetic */ void lambda$notifyAnrDelayStarted$6(String packgeName, int uid, int tid, int reason, IExternalStorageService service) {
            service.notifyAnrDelayStarted(packgeName, uid, tid, reason);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(StorageUserConnection.TAG, "Failed to notify ANR delay started", e);
        }

        private void setResult(Bundle result, CompletableFuture<Void> future) {
            ParcelableException ex = (ParcelableException) result.getParcelable("android.service.storage.extra.error", ParcelableException.class);
            if (ex == null) goto L5;
            future.completeExceptionally(ex);
            return;
        L5:
            future.complete(null);
        }

        private CompletableFuture<IExternalStorageService> connectIfNeeded() throws StorageSessionController.ExternalStorageServiceException {
            ComponentName name = StorageUserConnection.m8436$$Nest$fgetmSessionController(this.this$0).getExternalStorageServiceComponentName();
            if (name == null) goto L23;
            Object r2 = this.mLock;
            monitor-enter(r2);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.mRemoteFuture == null) goto L13;
            CompletableFuture<IExternalStorageService> r0 = this.mRemoteFuture;     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return r0;
        L13:
            final CompletableFuture<IExternalStorageService> future = new CompletableFuture();     // Catch: Throwable -> L11
            this.mServiceConnection = new AnonymousClass1(this, future);     // Catch: Throwable -> L11
            Slog.i(StorageUserConnection.TAG, "Binding to the ExternalStorageService for user " + StorageUserConnection.m8437$$Nest$fgetmUserId(this.this$0));     // Catch: Throwable -> L11
            if (StorageUserConnection.m8434$$Nest$fgetmContext(this.this$0).bindServiceAsUser(new Intent().setComponent(name), this.mServiceConnection, 65, StorageUserConnection.m8435$$Nest$fgetmHandlerThread(this.this$0).getThreadHandler(), UserHandle.of(StorageUserConnection.m8437$$Nest$fgetmUserId(this.this$0))) == false) goto L19;
            Slog.i(StorageUserConnection.TAG, "Bound to the ExternalStorageService for user " + StorageUserConnection.m8437$$Nest$fgetmUserId(this.this$0));     // Catch: Throwable -> L11
            this.mRemoteFuture = future;     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return future;
        L19:
            throw new StorageSessionController.ExternalStorageServiceException("Failed to bind to the ExternalStorageService for user " + StorageUserConnection.m8437$$Nest$fgetmUserId(this.this$0));     // Catch: Throwable -> L11
        L23:
            throw new StorageSessionController.ExternalStorageServiceException("Not ready to bind to the ExternalStorageService for user " + StorageUserConnection.m8437$$Nest$fgetmUserId(this.this$0));
        }
    }

    @FunctionalInterface
    interface AsyncStorageServiceCall {
        void run(IExternalStorageService r1, RemoteCallback r2) throws RemoteException;
    }

    private static final class Session {
        public final String lowerPath;
        public final String sessionId;
        public final String upperPath;

        Session(String sessionId, String upperPath, String lowerPath) {
            this.sessionId = sessionId;
            this.upperPath = upperPath;
            this.lowerPath = lowerPath;
        }

        public String toString() {
            return "[SessionId: " + this.sessionId + ". UpperPath: " + this.upperPath + ". LowerPath: " + this.lowerPath + "]";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8434$$Nest$fgetmContext(StorageUserConnection r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandlerThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ HandlerThread m8435$$Nest$fgetmHandlerThread(StorageUserConnection r0) {
        return r0.mHandlerThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionController, reason: not valid java name */
    static /* bridge */ /* synthetic */ StorageSessionController m8436$$Nest$fgetmSessionController(StorageUserConnection r0) {
        return r0.mSessionController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8437$$Nest$fgetmUserId(StorageUserConnection r0) {
        return r0.mUserId;
    }

    public StorageUserConnection(Context context, int userId, StorageSessionController controller) {
        this.mSessionsLock = new Object();
        this.mActiveConnection = new ActiveConnection(this, null);
        this.mSessions = new HashMap();
        this.mUidsBlockedOnIo = new SparseArray();
        context.getClass();
        this.mContext = context;
        this.mUserId = Preconditions.checkArgumentNonnegative(userId);
        this.mSessionController = controller;
        this.mSmInternal = (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);
        this.mHandlerThread = new HandlerThread("StorageUserConnectionThread-" + this.mUserId);
        this.mHandlerThread.start();
    }

    public void startSession(String sessionId, ParcelFileDescriptor pfd, String upperPath, String lowerPath) throws StorageSessionController.ExternalStorageServiceException {
        sessionId.getClass();
        pfd.getClass();
        upperPath.getClass();
        lowerPath.getClass();
        Session session = new Session(sessionId, upperPath, lowerPath);
        Object r1 = this.mSessionsLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessions.containsKey(sessionId) == true) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkArgument(r2);     // Catch: Throwable -> L12
        this.mSessions.put(sessionId, session);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        this.mActiveConnection.startSession(session, pfd);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public void notifyVolumeStateChanged(String sessionId, StorageVolume vol) throws StorageSessionController.ExternalStorageServiceException {
        sessionId.getClass();
        vol.getClass();
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessions.containsKey(sessionId) == true) goto L11;
        Slog.i(TAG, "No session found for sessionId: " + sessionId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mActiveConnection.notifyVolumeStateChanged(sessionId, vol);
    }

    public void freeCache(String volumeUuid, long bytes) throws StorageSessionController.ExternalStorageServiceException {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        Iterator<String> r1 = this.mSessions.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        String sessionId = r1.next();     // Catch: Throwable -> L8
        this.mActiveConnection.freeCache(sessionId, volumeUuid, bytes);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void notifyAnrDelayStarted(String packageName, int uid, int tid, int reason) throws StorageSessionController.ExternalStorageServiceException {
        List<String> primarySessionIds = this.mSmInternal.getPrimaryVolumeIds();
        Object r1 = this.mSessionsLock;
        monitor-enter(r1);
        Iterator<String> r2 = this.mSessions.keySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L15;
        String sessionId = r2.next();     // Catch: Throwable -> L12
        if (primarySessionIds.contains(sessionId) == false) goto L6;
        this.mActiveConnection.notifyAnrDelayStarted(packageName, uid, tid, reason);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public Session removeSession(String sessionId) {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        this.mUidsBlockedOnIo.clear();     // Catch: Throwable -> L7
        Session r1 = this.mSessions.remove(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeSessionAndWait(String sessionId) throws StorageSessionController.ExternalStorageServiceException {
        Session session = removeSession(sessionId);
        if (session != null) goto L6;
        Slog.i(TAG, "No session found for id: " + sessionId);
        return;
    L6:
        Slog.i(TAG, "Waiting for session end " + session + " ...");
        this.mActiveConnection.endSession(session);
    }

    public void resetUserSessions() {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessions.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mSmInternal.resetUser(this.mUserId);
    }

    public void removeAllSessions() {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        Slog.i(TAG, "Removing  " + this.mSessions.size() + " sessions for user: " + this.mUserId + "...");     // Catch: Throwable -> L7
        this.mSessions.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void close() {
        this.mActiveConnection.close();
        this.mHandlerThread.quit();
    }

    public Set<String> getAllSessionIds() {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        HashSet r1 = new HashSet(this.mSessions.keySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyAppIoBlocked(String volumeUuid, int uid, int tid, int reason) {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        int ioBlockedCounter = this.mUidsBlockedOnIo.get(uid, 0).intValue();     // Catch: Throwable -> L7
        this.mUidsBlockedOnIo.put(uid, Integer.valueOf(ioBlockedCounter + 1));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyAppIoResumed(String volumeUuid, int uid, int tid, int reason) {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        int ioBlockedCounter = this.mUidsBlockedOnIo.get(uid, 0).intValue();     // Catch: Throwable -> L7
        if (ioBlockedCounter != 0) goto L10;
        Slog.w(TAG, "Unexpected app IO resumption for uid: " + uid);     // Catch: Throwable -> L7
    L10:
        if (ioBlockedCounter > 1) goto L12;
        this.mUidsBlockedOnIo.remove(uid);     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L12:
        this.mUidsBlockedOnIo.put(uid, Integer.valueOf(ioBlockedCounter - 1));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAppIoBlocked(int uid) {
        Object r0 = this.mSessionsLock;
        monitor-enter(r0);
        boolean r1 = this.mUidsBlockedOnIo.contains(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
