package com.android.server.devicepolicy;

import android.content.pm.IPackageDeleteObserver;
import android.util.Log;
import android.util.Slog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class NonRequiredPackageDeleteObserver extends IPackageDeleteObserver.Stub {
    private static final int PACKAGE_DELETE_TIMEOUT_SEC = 30;
    private boolean mFailed;
    private final CountDownLatch mLatch;

    NonRequiredPackageDeleteObserver(int packageCount) {
        this.mFailed = false;
        this.mLatch = new CountDownLatch(packageCount);
    }

    public void packageDeleted(String packageName, int returnCode) {
        if (returnCode == 1) goto L5;
        Slog.e("DevicePolicyManager", "Failed to delete package: " + packageName);
        this.mFailed = true;
    L5:
        this.mLatch.countDown();
    }

    public boolean awaitPackagesDeletion() {
    L8:
        e = move-exception;
        Log.w("DevicePolicyManager", "Interrupted while waiting for package deletion", e);
        Thread.currentThread().interrupt();
        return false;
    L4:
        if (this.mLatch.await(30, TimeUnit.SECONDS) == true) goto L6;
        Slog.i("DevicePolicyManager", "Waiting time elapsed before all package deletion finished");     // Catch: InterruptedException -> L8
        return false;
    L6:
        if (this.mFailed == true) goto L11;
        Slog.i("DevicePolicyManager", "All non-required system apps with launcher icon, and all disallowed apps have been uninstalled.");     // Catch: InterruptedException -> L8
    L11:
        return !this.mFailed;
    }
}
