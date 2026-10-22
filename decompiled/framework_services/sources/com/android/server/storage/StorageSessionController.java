package com.android.server.storage;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.IVold;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Slog;
import android.util.SparseArray;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class StorageSessionController {
    private static final String TAG = "StorageSessionController";
    private final SparseArray<StorageUserConnection> mConnections;
    private final Context mContext;
    private volatile int mExternalStorageServiceAppId;
    private volatile ComponentName mExternalStorageServiceComponent;
    private volatile String mExternalStorageServicePackageName;
    private volatile boolean mIsResetting;
    private final Object mLock;
    private final UserManager mUserManager;

    public static class ExternalStorageServiceException extends Exception {
        public ExternalStorageServiceException(Throwable cause) {
            super(cause);
        }

        public ExternalStorageServiceException(String message) {
            super(message);
        }

        public ExternalStorageServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public StorageSessionController(Context context) {
        this.mLock = new Object();
        this.mConnections = new SparseArray();
        context.getClass();
        this.mContext = context;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
    }

    public int getConnectionUserIdForVolume(ImmutableVolumeInfo vol) {
        Context volumeUserContext = this.mContext.createContextAsUser(UserHandle.of(vol.getMountUserId()), 0);
        boolean isMediaSharedWithParent = ((UserManager) volumeUserContext.getSystemService(UserManager.class)).isMediaSharedWithParent();
        UserInfo userInfo = this.mUserManager.getUserInfo(vol.getMountUserId());
        if (userInfo == null) goto L8;
        if (isMediaSharedWithParent == false) goto L8;
        return userInfo.profileGroupId;
    L8:
        return vol.getMountUserId();
    }

    public void onVolumeMount(ParcelFileDescriptor deviceFd, ImmutableVolumeInfo vol) throws ExternalStorageServiceException {
        if (shouldHandle(vol) == true) goto L5;
        return;
    L5:
        Slog.i(TAG, "On volume mount " + vol);
        String sessionId = vol.getId();
        int userId = getConnectionUserIdForVolume(vol);
        ensureExternalStorageServiceComponentInitialized(userId);
        Object r3 = this.mLock;
        monitor-enter(r3);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L10
        if (connection != null) goto L12;
        Slog.i(TAG, "Creating connection for user: " + userId);     // Catch: Throwable -> L10
        connection = new StorageUserConnection(this.mContext, userId, this);     // Catch: Throwable -> L10
        this.mConnections.put(userId, connection);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r3);     // Catch: Throwable -> L10
        Slog.i(TAG, "Creating and starting session with id: " + sessionId);
        connection.startSession(sessionId, deviceFd, vol.getPath().getPath(), vol.getInternalPath().getPath());
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void notifyVolumeStateChanged(ImmutableVolumeInfo vol) throws ExternalStorageServiceException {
        if (shouldHandle(vol) == true) goto L5;
        return;
    L5:
        String sessionId = vol.getId();
        int connectionUserId = getConnectionUserIdForVolume(vol);
        Object r3 = this.mLock;
        monitor-enter(r3);
        StorageUserConnection connection = this.mConnections.get(connectionUserId);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        if (connection == null) goto L11;
        Slog.i(TAG, "Notifying volume state changed for session with id: " + sessionId);
        connection.notifyVolumeStateChanged(sessionId, vol.buildStorageVolume(this.mContext, vol.getMountUserId(), false));
        return;
    L11:
        Slog.w(TAG, "No available storage user connection for userId : " + connectionUserId);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void freeCache(String volumeUuid, long bytes) throws ExternalStorageServiceException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mConnections.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= size) goto L13;
        int key = this.mConnections.keyAt(i);     // Catch: Throwable -> L9
        StorageUserConnection connection = this.mConnections.get(key);     // Catch: Throwable -> L9
        if (connection == null) goto L11;
        connection.freeCache(volumeUuid, bytes);     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void notifyAnrDelayStarted(String packageName, int uid, int tid, int reason) throws ExternalStorageServiceException {
        int userId = UserHandle.getUserId(uid);
        Object r1 = this.mLock;
        monitor-enter(r1);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (connection == null) goto L14;
        connection.notifyAnrDelayStarted(packageName, uid, tid, reason);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public StorageUserConnection onVolumeRemove(ImmutableVolumeInfo vol) {
        if (shouldHandle(vol) == true) goto L5;
        return null;
    L5:
        Slog.i(TAG, "On volume remove " + vol);
        String sessionId = vol.getId();
        int userId = getConnectionUserIdForVolume(vol);
        Object r4 = this.mLock;
        monitor-enter(r4);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        if (connection == null) goto L12;
        Slog.i(TAG, "Removed session for vol with id: " + sessionId);
        connection.removeSession(sessionId);
        return connection;
    L12:
        Slog.w(TAG, "Session already removed for vol with id: " + sessionId);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public void onVolumeUnmount(ImmutableVolumeInfo vol) {
        String sessionId = vol.getId();
        long token = Binder.clearCallingIdentity();
        StorageUserConnection connection = onVolumeRemove(vol);     // Catch: Throwable -> L7 ExternalStorageServiceException -> L9
        Slog.i(TAG, "On volume unmount " + vol);     // Catch: Throwable -> L7 ExternalStorageServiceException -> L9
        if (connection == null) goto L12;
        connection.removeSessionAndWait(sessionId);     // Catch: Throwable -> L7 ExternalStorageServiceException -> L9
    L12:
        Binder.restoreCallingIdentity(token);
        return;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to end session for vol with id: " + sessionId, e);     // Catch: Throwable -> L7
        goto L12
    }

    private void ensureExternalStorageServiceComponentInitialized(int userId) throws ExternalStorageServiceException {
        if (userId == 0) goto L4;
        return;
    L4:
        if (this.mExternalStorageServiceComponent != null) goto L9;
        Slog.i(TAG, "ExternalStorageService component not ready for user " + userId + ", initializing on demand");
        initExternalStorageServiceComponent();
        return;
    }

    public void onUnlockUser(int userId) throws ExternalStorageServiceException {
        Slog.i(TAG, "On user unlock " + userId);
        ensureExternalStorageServiceComponentInitialized(userId);
    }

    public void onUserStopping(int userId) {
        if (shouldHandle(null) == true) goto L5;
        return;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (connection == null) goto L11;
        Slog.i(TAG, "Removing all sessions for user: " + userId);
        connection.removeAllSessions();
        return;
    L11:
        Slog.w(TAG, "No connection found for user: " + userId);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void onReset(IVold vold, Runnable resetHandlerRunnable) {
        if (shouldHandle(null) == true) goto L5;
        return;
    L5:
        SparseArray<StorageUserConnection> connections = new SparseArray();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mIsResetting = true;     // Catch: Throwable -> L12
        Slog.i(TAG, "Started resetting external storage service...");     // Catch: Throwable -> L12
        int i = 0;
    L10:
        if (i >= this.mConnections.size()) goto L15;
        connections.put(this.mConnections.keyAt(i), this.mConnections.valueAt(i));     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L10
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L12
        int i2 = 0;
    L18:
        if (i2 >= connections.size()) goto L32;
        StorageUserConnection connection = connections.valueAt(i2);
        Iterator<String> r3 = connection.getAllSessionIds().iterator();
    L21:
        if (r3.hasNext() == false) goto L31;
        String sessionId = r3.next();
        Slog.i(TAG, "Unmounting " + sessionId);     // Catch: Throwable -> L25
        vold.unmount(sessionId);     // Catch: Throwable -> L25
        Slog.i(TAG, "Unmounted " + sessionId);     // Catch: Throwable -> L25
    L46:
        Slog.i(TAG, "Exiting " + sessionId);     // Catch: Throwable -> L29
        connection.removeSessionAndWait(sessionId);     // Catch: Throwable -> L29
        Slog.i(TAG, "Exited " + sessionId);     // Catch: Throwable -> L29
    L29:
        e = move-exception;
        Slog.e(TAG, "Failed to exit session: " + sessionId + ". Killing MediaProvider...", e);
        killExternalStorageService(connections.keyAt(i2));
    L25:
        e = move-exception;
        Slog.e(TAG, "Failed to unmount volume: " + sessionId, e);
    L31:
        connection.close();
        i2 = i2 + 1;
        goto L18
    L32:
        resetHandlerRunnable.run();
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mConnections.clear();     // Catch: Throwable -> L37
        this.mIsResetting = false;     // Catch: Throwable -> L37
        Slog.i(TAG, "Finished resetting external storage service");     // Catch: Throwable -> L37
        monitor-exit(r2);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        throw th;
    }

    private void initExternalStorageServiceComponent() throws ExternalStorageServiceException {
        Slog.i(TAG, "Initialialising...");
        ProviderInfo provider = this.mContext.getPackageManager().resolveContentProvider("media", 1835008);
        if (provider == null) goto L15;
        this.mExternalStorageServicePackageName = provider.applicationInfo.packageName;
        this.mExternalStorageServiceAppId = UserHandle.getAppId(provider.applicationInfo.uid);
        ServiceInfo serviceInfo = resolveExternalStorageServiceAsUser(0);
        if (serviceInfo == null) goto L13;
        ComponentName name = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        if ("android.permission.BIND_EXTERNAL_STORAGE_SERVICE".equals(serviceInfo.permission) == false) goto L11;
        this.mExternalStorageServiceComponent = name;
        return;
    L11:
        throw new ExternalStorageServiceException(name.flattenToShortString() + " does not require permission android.permission.BIND_EXTERNAL_STORAGE_SERVICE");
    L13:
        throw new ExternalStorageServiceException("No valid ExternalStorageService component found");
    L15:
        throw new ExternalStorageServiceException("No valid MediaStore provider found");
    }

    public ComponentName getExternalStorageServiceComponentName() {
        return this.mExternalStorageServiceComponent;
    }

    public void notifyAppIoBlocked(String volumeUuid, int uid, int tid, int reason) {
        int userId = UserHandle.getUserId(uid);
        Object r1 = this.mLock;
        monitor-enter(r1);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (connection == null) goto L14;
        connection.notifyAppIoBlocked(volumeUuid, uid, tid, reason);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void notifyAppIoResumed(String volumeUuid, int uid, int tid, int reason) {
        int userId = UserHandle.getUserId(uid);
        Object r1 = this.mLock;
        monitor-enter(r1);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (connection == null) goto L14;
        connection.notifyAppIoResumed(volumeUuid, uid, tid, reason);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAppIoBlocked(int uid) {
        int userId = UserHandle.getUserId(uid);
        Object r1 = this.mLock;
        monitor-enter(r1);
        StorageUserConnection connection = this.mConnections.get(userId);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (connection != null) goto L8;
        return false;
    L8:
        return connection.isAppIoBlocked(uid);
    L11:
        th = move-exception;
        throw th;
    }

    private void killExternalStorageService(int userId) {
        IActivityManager am = ActivityManager.getService();
        int userId2 = userId;
        am.killApplication(this.mExternalStorageServicePackageName, this.mExternalStorageServiceAppId, userId2, "storage_session_controller reset", 13);     // Catch: RemoteException -> L7
        return;
    L11:
        Slog.i(TAG, "Failed to kill the ExtenalStorageService for user " + userId2);
        return;
    L10:
        userId2 = userId;
        goto L11
    }

    public static boolean isEmulatedOrPublic(ImmutableVolumeInfo vol) {
        if (vol.getType() != 2) goto L5;
    L10:
        return true;
    L5:
        if (vol.getType() == 0) goto L7;
    L9:
        return false;
    L7:
        if (vol.isVisible() == false) goto L9;
        goto L9
    }

    private static boolean isSupportedVolume(ImmutableVolumeInfo vol) {
        if (isEmulatedOrPublic(vol) == false) goto L5;
    L8:
        return true;
    L5:
        if (vol.getType() == 5) goto L8;
        return false;
    }

    private boolean shouldHandle(ImmutableVolumeInfo vol) {
        if (this.mIsResetting == true) goto L8;
        if (vol != null) goto L6;
    L7:
        return true;
    L6:
        if (isSupportedVolume(vol) == true) goto L7;
    L8:
        return false;
    }

    public boolean supportsExternalStorage(int userId) {
        if (resolveExternalStorageServiceAsUser(userId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private ServiceInfo resolveExternalStorageServiceAsUser(int userId) {
        Intent intent = new Intent("android.service.storage.ExternalStorageService");
        intent.setPackage(this.mExternalStorageServicePackageName);
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveServiceAsUser(intent, 132, userId);
        if (resolveInfo != null) goto L7;
        return null;
    L7:
        return resolveInfo.serviceInfo;
    }
}
