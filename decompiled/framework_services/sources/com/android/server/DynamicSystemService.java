package com.android.server;

import android.content.Context;
import android.gsi.AvbPublicKey;
import android.gsi.GsiProgress;
import android.gsi.IGsiService;
import android.gsi.IGsiServiceCallback;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.image.IDynamicSystemService;
import android.os.storage.DiskInfo;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.util.Slog;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DynamicSystemService extends IDynamicSystemService.Stub {
    private static final int GSID_ROUGH_TIMEOUT_MS = 8192;
    private static final long MINIMUM_SD_MB = 30720;
    private static final String PATH_DEFAULT = "/data/gsi/dsu/";
    private static final String TAG = "DynamicSystemService";
    private Context mContext;
    private String mDsuSlot;
    private volatile IGsiService mGsiService;
    private String mInstallPath;

    class GsiServiceCallback extends IGsiServiceCallback.Stub {
        private int mResult;

        GsiServiceCallback(DynamicSystemService this$0) {
            this.mResult = -1;
        }

        @Override // android.gsi.IGsiServiceCallback
        public synchronized void onResult(int result) {
            monitor-enter(this);
            this.mResult = result;     // Catch: Throwable -> L6
            notify();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public int getResult() {
            return this.mResult;
        }
    }

    DynamicSystemService(Context context) {
        this.mContext = context;
    }

    private IGsiService getGsiService() {
        if (this.mGsiService == null) goto L7;
        return this.mGsiService;
    L7:
        return IGsiService.Stub.asInterface(ServiceManager.waitForService("gsiservice"));
    }

    public boolean startInstallation(String dsuSlot) throws RemoteException {
        super.startInstallation_enforcePermission();
        IGsiService service = getGsiService();
        this.mGsiService = service;
        String path = SystemProperties.get("os.aot.path");
        if (path.isEmpty() == false) goto L27;
        int userId = UserHandle.myUserId();
        StorageManager sm = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        Iterator r5 = sm.getVolumes().iterator();
    L6:
        if (r5.hasNext() == false) goto L24;
        VolumeInfo volume = (VolumeInfo) r5.next();
        if (volume.getType() != 0) goto L6;
        if (volume.isMountedWritable() == false) goto L6;
        if ("vfat".equalsIgnoreCase(volume.fsType) == false) goto L6;
        DiskInfo disk = volume.getDisk();
        long mega = disk.size >> 20;
        Slog.i(TAG, volume.getPath() + ": " + mega + " MB");
        if (mega < MINIMUM_SD_MB) goto L18;
        File sd_internal = volume.getInternalPathForUser(userId);
        if (sd_internal == null) goto L6;
        path = new File(sd_internal, dsuSlot).getPath();
        goto L6
    L18:
        Slog.i(TAG, volume.getPath() + ": insufficient storage");
        goto L6
    L24:
        if (path.isEmpty() == false) goto L26;
        path = PATH_DEFAULT + dsuSlot;
    L26:
        Slog.i(TAG, "startInstallation -> " + path);
    L27:
        this.mInstallPath = path;
        this.mDsuSlot = dsuSlot;
        if (service.openInstall(path) == 0) goto L31;
        Slog.i(TAG, "Failed to open " + path);
        return false;
    L31:
        return true;
    }

    public int createPartition(String name, long size, boolean readOnly) throws RemoteException {
        super.createPartition_enforcePermission();
        IGsiService service = getGsiService();
        int status = service.createPartition(name, size, readOnly);
        if (status == 0) goto L5;
        Slog.i(TAG, "Failed to create partition: " + name);
    L5:
        return status;
    }

    public boolean closePartition() throws RemoteException {
        super.closePartition_enforcePermission();
        IGsiService service = getGsiService();
        if (service.closePartition() == 0) goto L6;
        Slog.i(TAG, "Partition installation completes with error");
        return false;
    L6:
        return true;
    }

    public boolean finishInstallation() throws RemoteException {
        super.finishInstallation_enforcePermission();
        IGsiService service = getGsiService();
        if (service.closeInstall() == 0) goto L6;
        Slog.i(TAG, "Failed to finish installation");
        return false;
    L6:
        return true;
    }

    public GsiProgress getInstallationProgress() throws RemoteException {
        super.getInstallationProgress_enforcePermission();
        return getGsiService().getInstallProgress();
    }

    public boolean abort() throws RemoteException {
        super.abort_enforcePermission();
        return getGsiService().cancelGsiInstall();
    }

    public boolean isInUse() {
        return SystemProperties.getBoolean("ro.gsid.image_running", false);
    }

    public boolean isInstalled() {
        boolean installed = SystemProperties.getBoolean("gsid.image_installed", false);
        Slog.i(TAG, "isInstalled(): " + installed);
        return installed;
    }

    public boolean isEnabled() throws RemoteException {
        super.isEnabled_enforcePermission();
        return getGsiService().isGsiEnabled();
    }

    public boolean remove() throws RemoteException {
        super.remove_enforcePermission();
        GsiServiceCallback callback = new GsiServiceCallback(this);     // Catch: InterruptedException -> L11
        monitor-enter(callback);     // Catch: InterruptedException -> L11
        getGsiService().removeGsiAsync(callback);     // Catch: Throwable -> L13
        callback.wait(8192);     // Catch: Throwable -> L13
        monitor-exit(callback);     // Catch: Throwable -> L13
        goto L16
    L8:
        if (callback.getResult() != 0) goto L21;
        return true;
    L21:
        return false;
    L13:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L11
    L16:
        Slog.e(TAG, "remove() was interrupted");
        return false;
    }

    public boolean setEnable(boolean enable, boolean oneShot) throws RemoteException {
        super.setEnable_enforcePermission();
        IGsiService gsiService = getGsiService();
        if (enable == false) goto L21;
        getActiveDsuSlot();     // Catch: InterruptedException -> L13
        GsiServiceCallback callback = new GsiServiceCallback(this);     // Catch: InterruptedException -> L13
        monitor-enter(callback);     // Catch: InterruptedException -> L13
        gsiService.enableGsiAsync(oneShot, this.mDsuSlot, callback);     // Catch: Throwable -> L15
        callback.wait(8192);     // Catch: Throwable -> L15
        monitor-exit(callback);     // Catch: Throwable -> L15
        goto L18
    L10:
        if (callback.getResult() != 0) goto L25;
        return true;
    L25:
        return false;
    L15:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L13
    L18:
        Slog.e(TAG, "setEnable() was interrupted");
        return false;
    L21:
        return gsiService.disableGsi();
    }

    public boolean setAshmem(ParcelFileDescriptor ashmem, long size) {
        super.setAshmem_enforcePermission();
        return getGsiService().setGsiAshmem(ashmem, size);
    L5:
        e = move-exception;
        throw new RuntimeException(e.toString());
    }

    public boolean submitFromAshmem(long size) {
        super.submitFromAshmem_enforcePermission();
        return getGsiService().commitGsiChunkFromAshmem(size);
    L5:
        e = move-exception;
        throw new RuntimeException(e.toString());
    }

    public boolean getAvbPublicKey(AvbPublicKey dst) {
        super.getAvbPublicKey_enforcePermission();
        if (getGsiService().getAvbPublicKey(dst) != 0) goto L6;
        return true;
    L6:
        return false;
    L8:
        e = move-exception;
        throw new RuntimeException(e.toString());
    }

    public long suggestScratchSize() throws RemoteException {
        super.suggestScratchSize_enforcePermission();
        return getGsiService().suggestScratchSize();
    }

    public String getActiveDsuSlot() throws RemoteException {
        super.getActiveDsuSlot_enforcePermission();
        if (this.mDsuSlot != null) goto L6;
        this.mDsuSlot = getGsiService().getActiveDsuSlot();
    L6:
        return this.mDsuSlot;
    }
}
