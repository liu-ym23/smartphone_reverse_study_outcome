package com.android.server.pm;

import android.content.pm.IPackageLoadingProgressCallback;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.mutate.PackageStateWrite;

/* JADX INFO: loaded from: classes2.dex */
final class IncrementalProgressListener extends IPackageLoadingProgressCallback.Stub {
    private final String mPackageName;
    private final PackageManagerService mPm;

    /* JADX INFO: renamed from: $r8$lambda$80wbVasJAg-6djgfSbqwc5Iu174, reason: not valid java name */
    public static /* synthetic */ void m6651$r8$lambda$80wbVasJAg6djgfSbqwc5Iu174(PackageStateWrite r0) {
        lambda$onPackageLoadingProgressChanged$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$TBlJWevp6b4-644RO3Jd9wp4X-4, reason: not valid java name */
    public static /* synthetic */ void m6652$r8$lambda$TBlJWevp6b4644RO3Jd9wp4X4(float r0, PackageStateWrite r1) {
        lambda$onPackageLoadingProgressChanged$0(r0, r1);
    }

    IncrementalProgressListener(String packageName, PackageManagerService pm) {
        this.mPackageName = packageName;
        this.mPm = pm;
    }

    public void onPackageLoadingProgressChanged(final float progress) {
        PackageStateInternal packageState = this.mPm.snapshotComputer().getPackageStateInternal(this.mPackageName);
        if (packageState != null) goto L5;
        return;
    L5:
        boolean wasLoading = packageState.isLoading();
        if (wasLoading == false) goto L11;
        this.mPm.commitPackageStateMutation(null, this.mPackageName, new IncrementalProgressListener$$ExternalSyntheticLambda0(progress));
        if (Math.abs(1.0f - progress) >= 1.0E-8f) goto L12;
        this.mPm.commitPackageStateMutation(null, this.mPackageName, new IncrementalProgressListener$$ExternalSyntheticLambda1());
        this.mPm.mIncrementalManager.unregisterLoadingProgressCallbacks(packageState.getPathString());
        this.mPm.scheduleWriteSettings();
        return;
    L12:
        return;
    }

    private static /* synthetic */ void lambda$onPackageLoadingProgressChanged$0(float progress, PackageStateWrite state) {
        state.setLoadingProgress(progress);
    }

    private static /* synthetic */ void lambda$onPackageLoadingProgressChanged$1(PackageStateWrite state) {
        state.setLoadingCompletedTime(System.currentTimeMillis());
    }
}
