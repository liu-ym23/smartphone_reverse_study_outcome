package com.android.server.storage;

import android.os.FileUtils;
import android.os.ParcelFileDescriptor;
import android.util.SparseArray;
import com.android.internal.os.FuseUnavailableMountException;
import com.android.internal.util.Preconditions;
import com.android.server.AppFuseMountException;
import java.util.concurrent.CountDownLatch;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AppFuseBridge implements Runnable {
    private static final String APPFUSE_MOUNT_NAME_TEMPLATE = "/mnt/appfuse/%d_%d";
    public static final String TAG = "AppFuseBridge";
    private long mNativeLoop;
    private final SparseArray<MountScope> mScopes;

    public static abstract class MountScope implements AutoCloseable {
        private boolean mMountResult;
        private final CountDownLatch mMounted;
        public final int mountId;
        public final int uid;

        public abstract ParcelFileDescriptor open() throws AppFuseMountException;

        public abstract ParcelFileDescriptor openFile(int r1, int r2, int r3) throws AppFuseMountException;

        public MountScope(int uid, int mountId) {
            this.mMounted = new CountDownLatch(1);
            this.mMountResult = false;
            this.uid = uid;
            this.mountId = mountId;
        }

        void setMountResultLocked(boolean result) {
            if (this.mMounted.getCount() != 0) goto L5;
            return;
        L5:
            this.mMountResult = result;
            this.mMounted.countDown();
        }

        boolean waitForMount() throws InterruptedException {
            this.mMounted.await();
            return this.mMountResult;
        }
    }

    private native int native_add_bridge(long r1, int r3, int r4);

    private native void native_delete(long r1);

    private native void native_lock();

    private native long native_new();

    private native void native_start_loop(long r1);

    private native void native_unlock();

    public AppFuseBridge() {
        this.mScopes = new SparseArray();
        this.mNativeLoop = native_new();
    }

    public ParcelFileDescriptor addBridge(MountScope mountScope) throws FuseUnavailableMountException, AppFuseMountException {
        native_lock();
        monitor-enter(this);     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L5:
        if (this.mScopes.indexOfKey(mountScope.mountId) >= 0) goto L7;
        boolean r0 = true;
    L8:
        Preconditions.checkArgument(r0);     // Catch: Throwable -> L16
        if (this.mNativeLoop == 0) goto L21;
        int fd = native_add_bridge(this.mNativeLoop, mountScope.mountId, mountScope.open().detachFd());     // Catch: Throwable -> L16
        if (fd == (-1)) goto L19;
        ParcelFileDescriptor result = ParcelFileDescriptor.adoptFd(fd);     // Catch: Throwable -> L16
        this.mScopes.put(mountScope.mountId, mountScope);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        native_unlock();
        IoUtils.closeQuietly(null);
        return result;
    L19:
        throw new FuseUnavailableMountException(mountScope.mountId);     // Catch: Throwable -> L16
    L21:
        throw new FuseUnavailableMountException(mountScope.mountId);     // Catch: Throwable -> L16
    L7:
        r0 = false;
    L24:
        th = move-exception;
        native_unlock();
        IoUtils.closeQuietly(mountScope);
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        native_start_loop(this.mNativeLoop);
        monitor-enter(this);
        native_delete(this.mNativeLoop);     // Catch: Throwable -> L7
        this.mNativeLoop = 0;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ParcelFileDescriptor openFile(int mountId, int fileId, int mode) throws FuseUnavailableMountException, InterruptedException {
        monitor-enter(this);
        MountScope scope = this.mScopes.get(mountId);     // Catch: Throwable -> L15
        if (scope == null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L15
        boolean result = scope.waitForMount();
        if (result == false) goto L14;
        int flags = FileUtils.translateModePfdToPosix(mode);     // Catch: AppFuseMountException -> L10
        return scope.openFile(mountId, fileId, flags);
    L12:
        throw new FuseUnavailableMountException(mountId);
    L14:
        throw new FuseUnavailableMountException(mountId);
    L18:
        throw new FuseUnavailableMountException(mountId);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private synchronized void onMount(int mountId) {
        monitor-enter(this);
        MountScope scope = this.mScopes.get(mountId);     // Catch: Throwable -> L7
        if (scope == null) goto L9;
        scope.setMountResultLocked(true);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void onClosed(int mountId) {
        monitor-enter(this);
        MountScope scope = this.mScopes.get(mountId);     // Catch: Throwable -> L7
        if (scope == null) goto L9;
        scope.setMountResultLocked(false);     // Catch: Throwable -> L7
        IoUtils.closeQuietly(scope);     // Catch: Throwable -> L7
        this.mScopes.remove(mountId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
