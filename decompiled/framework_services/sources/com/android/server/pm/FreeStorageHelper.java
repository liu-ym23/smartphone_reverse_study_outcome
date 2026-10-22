package com.android.server.pm;

import android.content.Context;
import android.content.pm.PackageInfoLite;
import android.content.pm.parsing.PackageLite;
import android.os.Environment;
import android.os.FileUtils;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.storage.IStorageManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.util.Slog;
import com.android.internal.content.InstallLocationUtils;
import com.android.server.usage.UnixCalendar;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class FreeStorageHelper {
    private static final long DEFAULT_MANDATORY_FSTRIM_INTERVAL = 259200000;
    private static final long FREE_STORAGE_UNUSED_STATIC_SHARED_LIB_MIN_CACHE_PERIOD = 0;
    private final Context mContext;
    private final boolean mEnableFreeCacheV2;
    private final PackageManagerServiceInjector mInjector;
    private final PackageManagerService mPm;

    static {
        FREE_STORAGE_UNUSED_STATIC_SHARED_LIB_MIN_CACHE_PERIOD = TimeUnit.HOURS.toMillis(2);
    }

    FreeStorageHelper(PackageManagerService pm, PackageManagerServiceInjector injector, Context context, boolean enableFreeCacheV2) {
        this.mPm = pm;
        this.mInjector = injector;
        this.mContext = context;
        this.mEnableFreeCacheV2 = enableFreeCacheV2;
    }

    FreeStorageHelper(PackageManagerService pm) {
        this(pm, pm.mInjector, pm.mContext, SystemProperties.getBoolean("fw.free_cache_v2", true));
    }

    void freeStorage(String volumeUuid, long bytes, int flags) throws IOException {
        long r5 = bytes;
        StorageManager storage = (StorageManager) this.mInjector.getSystemService(StorageManager.class);
        File file = storage.findPathForUuid(volumeUuid);
        if (file.getUsableSpace() < r5) goto L6;
        return;
    L6:
        if (this.mEnableFreeCacheV2 == false) goto L123;
        boolean internalVolume = Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, volumeUuid);
        if ((flags & 1) == 0) goto L10;
        boolean r0 = true;
    L11:
        boolean aggressive = r0;
        if (internalVolume == false) goto L19;
        if (aggressive == false) goto L15;
    L16:
        this.mPm.deletePreloadsFileCache();
        if (file.getUsableSpace() < r5) goto L19;
        return;
    L15:
        if (SystemProperties.getBoolean("persist.sys.preloads.file_cache_expired", false) == true) goto L16;
    L19:
        if (internalVolume == false) goto L120;
        if (aggressive == false) goto L120;
        FileUtils.deleteContents(this.mPm.getCacheDir());
        if (file.getUsableSpace() < r5) goto L120;
        return;
    L120:
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L30
        this.mPm.mInstaller.freeCache(volumeUuid, r5, 256);     // Catch: Throwable -> L33
        if (installLock == null) goto L43;
        installLock.close();     // Catch: Installer.InstallerException -> L30
        goto L43
    L33:
        th = move-exception;
        if (installLock == null) goto L124;
        installLock.close();     // Catch: Throwable -> L38
        goto L43
    L125:
        throw th;     // Catch: Installer.InstallerException -> L30
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Installer.InstallerException -> L30
        throw th;     // Catch: Installer.InstallerException -> L30
    L124:
        throw th;     // Catch: Installer.InstallerException -> L30
    L43:
        if (file.getUsableSpace() < r5) goto L45;
        return;
    L45:
        Computer computer = this.mPm.snapshotComputer();
        SharedLibrariesImpl sharedLibraries = this.mPm.mInjector.getSharedLibrariesImpl();
        if (internalVolume == false) goto L52;
        if (sharedLibraries.pruneUnusedStaticSharedLibraries(computer, r5, android.provider.Settings.Global.getLong(this.mContext.getContentResolver(), "unused_static_shared_lib_min_cache_period", FREE_STORAGE_UNUSED_STATIC_SHARED_LIB_MIN_CACHE_PERIOD)) == false) goto L52;
        return;
    L52:
        if (internalVolume == false) goto L56;
        r5 = bytes;
        if (this.mPm.mInstantAppRegistry.pruneInstalledInstantApps(computer, r5, android.provider.Settings.Global.getLong(this.mContext.getContentResolver(), "installed_instant_app_min_cache_period", UnixCalendar.WEEK_IN_MILLIS)) == false) goto L113;
        return;
    L113:
        PackageManagerTracedLock installLock2 = this.mPm.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L63
        this.mPm.mInstaller.freeCache(volumeUuid, r5, 768);     // Catch: Throwable -> L66
        if (installLock2 == null) goto L76;
        installLock2.close();     // Catch: Installer.InstallerException -> L63
        goto L76
    L66:
        th = move-exception;
        if (installLock2 == null) goto L126;
        installLock2.close();     // Catch: Throwable -> L71
        goto L76
    L127:
        throw th;     // Catch: Installer.InstallerException -> L63
    L71:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Installer.InstallerException -> L63
        throw th;     // Catch: Installer.InstallerException -> L63
    L126:
        throw th;     // Catch: Installer.InstallerException -> L63
    L76:
        if (file.getUsableSpace() < r5) goto L78;
        return;
    L78:
        if (internalVolume == true) goto L80;
    L82:
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mInjector.getLocalService(StorageManagerInternal.class);
        long freeBytesRequired = r5 - file.getUsableSpace();
        if (freeBytesRequired <= 0) goto L85;
        smInternal.freeCache(volumeUuid, freeBytesRequired);
    L85:
        this.mPm.mInstallerService.freeStageDirs(volumeUuid);
    L105:
        if (file.getUsableSpace() < r5) goto L108;
        return;
    L108:
        throw new IOException("Failed to free " + r5 + " on storage device at " + file);
    L80:
        if (this.mPm.mInstantAppRegistry.pruneUninstalledInstantApps(computer, r5, android.provider.Settings.Global.getLong(this.mContext.getContentResolver(), "uninstalled_instant_app_min_cache_period", UnixCalendar.WEEK_IN_MILLIS)) == false) goto L82;
        return;
    L56:
        r5 = bytes;
        goto L113
    L10:
        r0 = false;
        goto L11
    L123:
        PackageManagerTracedLock installLock3 = this.mPm.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L92
        this.mPm.mInstaller.freeCache(volumeUuid, r5, 0);     // Catch: Throwable -> L95
        if (installLock3 == null) goto L105;
        installLock3.close();     // Catch: Installer.InstallerException -> L92
        goto L105
    L95:
        th = move-exception;
        if (installLock3 == null) goto L128;
        installLock3.close();     // Catch: Throwable -> L100
        goto L105
    L129:
        throw th;     // Catch: Installer.InstallerException -> L92
    L100:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Installer.InstallerException -> L92
        throw th;     // Catch: Installer.InstallerException -> L92
    L128:
        throw th;     // Catch: Installer.InstallerException -> L92
    }

    int freeCacheForInstallation(int recommendedInstallLocation, PackageLite pkgLite, String resolvedPath, String mPackageAbiOverride, int installFlags) {
        StorageManager storage = StorageManager.from(this.mContext);
        long lowThreshold = storage.getStorageLowBytes(Environment.getDataDirectory());
        long sizeBytes = PackageManagerServiceUtils.calculateInstalledSize(resolvedPath, mPackageAbiOverride);
        if (sizeBytes < 0) goto L33;
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L29
        this.mPm.mInstaller.freeCache(null, sizeBytes + lowThreshold, 0);     // Catch: Throwable -> L20
        PackageInfoLite pkgInfoLite = PackageManagerServiceUtils.getMinimalPackageInfo(this.mContext, pkgLite, resolvedPath, installFlags, mPackageAbiOverride);     // Catch: Throwable -> L11
        if (pkgInfoLite.recommendedInstallLocation != (-6)) goto L13;
        pkgInfoLite.recommendedInstallLocation = -1;     // Catch: Throwable -> L11
    L13:
        int r10 = pkgInfoLite.recommendedInstallLocation;     // Catch: Throwable -> L11
        if (installLock == null) goto L19;
        installLock.close();     // Catch: Installer.InstallerException -> L17
    L19:
        return r10;
    L11:
        th = th;
    L12:
        Throwable r11 = th;
        if (installLock == null) goto L42;
        installLock.close();     // Catch: Throwable -> L25
    L43:
        throw r11;     // Catch: Installer.InstallerException -> L17
    L25:
        th = move-exception;
        r11.addSuppressed(th);     // Catch: Installer.InstallerException -> L17
        throw r11;     // Catch: Installer.InstallerException -> L17
    L42:
        throw r11;     // Catch: Installer.InstallerException -> L17
    L17:
        e = e;
    L31:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to free cache", e);
    L20:
        th = th;
    L29:
        e = e;
    L33:
        return recommendedInstallLocation;
    }

    void performFstrimIfNeeded() {
        PackageManagerServiceUtils.enforceSystemOrRoot("Only the system can request fstrim");
        IStorageManager sm = InstallLocationUtils.getStorageManager();     // Catch: RemoteException -> L12
        if (sm == null) goto L17;
        boolean doTrim = false;
        long interval = android.provider.Settings.Global.getLong(this.mContext.getContentResolver(), "fstrim_mandatory_interval", DEFAULT_MANDATORY_FSTRIM_INTERVAL);     // Catch: RemoteException -> L12
        if (interval <= 0) goto L14;
        long timeSinceLast = System.currentTimeMillis() - sm.lastMaintenance();     // Catch: RemoteException -> L12
        if (timeSinceLast <= interval) goto L14;
        doTrim = true;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "No disk maintenance in " + timeSinceLast + "; running immediately");     // Catch: RemoteException -> L12
    L14:
        if (doTrim == false) goto L22;
        sm.runMaintenance();     // Catch: RemoteException -> L12
    L22:
        return;
    L17:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "storageManager service unavailable!");     // Catch: RemoteException -> L12
        return;
    }
}
