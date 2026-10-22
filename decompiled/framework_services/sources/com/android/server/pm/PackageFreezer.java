package com.android.server.pm;

import dalvik.system.CloseGuard;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class PackageFreezer implements AutoCloseable {
    private final CloseGuard mCloseGuard;
    private final AtomicBoolean mClosed;
    private InstallRequest mInstallRequest;
    private final String mPackageName;
    private final PackageManagerService mPm;

    PackageFreezer(PackageManagerService pm, InstallRequest request) {
        this.mClosed = new AtomicBoolean();
        this.mCloseGuard = CloseGuard.get();
        this.mPm = pm;
        this.mPackageName = null;
        this.mClosed.set(true);
        this.mCloseGuard.open("close");
        this.mInstallRequest = request;
        if (this.mInstallRequest == null) goto L6;
        this.mInstallRequest.onFreezeStarted();
        return;
    }

    PackageFreezer(String packageName, int userId, String killReason, PackageManagerService pm, int exitInfoReason, InstallRequest request) {
        this(packageName, userId, killReason, pm, exitInfoReason, request, false);
    }

    PackageFreezer(String packageName, int userId, String killReason, PackageManagerService pm, int exitInfoReason, InstallRequest request, boolean waitAppKilled) {
        this.mClosed = new AtomicBoolean();
        this.mCloseGuard = CloseGuard.get();
        this.mPm = pm;
        this.mPackageName = packageName;
        this.mInstallRequest = request;
        if (this.mInstallRequest == null) goto L5;
        this.mInstallRequest.onFreezeStarted();
    L5:
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        int refCounts = this.mPm.mFrozenPackages.getOrDefault(this.mPackageName, 0).intValue() + 1;     // Catch: Throwable -> L16
        this.mPm.mFrozenPackages.put(this.mPackageName, Integer.valueOf(refCounts));     // Catch: Throwable -> L16
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(this.mPackageName);     // Catch: Throwable -> L16
        monitor-exit(r5);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (ps == null) goto L14;
        if (waitAppKilled == false) goto L13;
        this.mPm.killApplicationSync(ps.getPackageName(), ps.getAppId(), userId, killReason, exitInfoReason);
        goto L14
    L13:
        this.mPm.killApplication(ps.getPackageName(), ps.getAppId(), userId, killReason, exitInfoReason);
    L14:
        this.mCloseGuard.open("close");
        return;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    protected void finalize() throws Throwable {
        this.mCloseGuard.warnIfOpen();     // Catch: Throwable -> L5
        close();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mCloseGuard.close();
        if (this.mClosed.compareAndSet(false, true) == false) goto L18;
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int refCounts = this.mPm.mFrozenPackages.getOrDefault(this.mPackageName, 0).intValue() - 1;     // Catch: Throwable -> L9
        if (refCounts <= 0) goto L11;
        this.mPm.mFrozenPackages.put(this.mPackageName, Integer.valueOf(refCounts));     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L18
    L11:
        this.mPm.mFrozenPackages.remove(this.mPackageName);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L18:
        if (this.mInstallRequest == null) goto L23;
        this.mInstallRequest.onFreezeCompleted();
        this.mInstallRequest = null;
        return;
    }
}
