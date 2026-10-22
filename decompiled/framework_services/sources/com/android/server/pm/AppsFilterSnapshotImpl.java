package com.android.server.pm;

import com.android.server.utils.SnapshotCache;
import com.android.server.utils.WatchedSparseBooleanMatrix;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class AppsFilterSnapshotImpl extends AppsFilterBase {
    AppsFilterSnapshotImpl(AppsFilterImpl orig) {
        PackageManagerTracedLock r0 = orig.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mImplicitlyQueryable = orig.mImplicitQueryableSnapshot.snapshot();     // Catch: Throwable -> L68
        this.mRetainedImplicitlyQueryable = orig.mRetainedImplicitlyQueryableSnapshot.snapshot();     // Catch: Throwable -> L68
        monitor-exit(r0);     // Catch: Throwable -> L68
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mImplicitQueryableSnapshot = new SnapshotCache.Sealed();
        this.mRetainedImplicitlyQueryableSnapshot = new SnapshotCache.Sealed();
        PackageManagerTracedLock r1 = orig.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mQueriesViaPackage = orig.mQueriesViaPackageSnapshot.snapshot();     // Catch: Throwable -> L64
        monitor-exit(r1);     // Catch: Throwable -> L64
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mQueriesViaPackageSnapshot = new SnapshotCache.Sealed();
        PackageManagerTracedLock r2 = orig.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        this.mQueriesViaComponent = orig.mQueriesViaComponentSnapshot.snapshot();     // Catch: Throwable -> L60
        monitor-exit(r2);     // Catch: Throwable -> L60
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mQueriesViaComponentSnapshot = new SnapshotCache.Sealed();
        PackageManagerTracedLock r3 = orig.mQueryableViaUsesLibraryLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        this.mQueryableViaUsesLibrary = orig.mQueryableViaUsesLibrarySnapshot.snapshot();     // Catch: Throwable -> L56
        monitor-exit(r3);     // Catch: Throwable -> L56
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mQueryableViaUsesLibrarySnapshot = new SnapshotCache.Sealed();
        PackageManagerTracedLock r4 = orig.mQueryableViaUsesPermissionLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        this.mQueryableViaUsesPermission = orig.mQueryableViaUsesPermissionSnapshot.snapshot();     // Catch: Throwable -> L52
        monitor-exit(r4);     // Catch: Throwable -> L52
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mQueryableViaUsesPermissionSnapshot = new SnapshotCache.Sealed();
        PackageManagerTracedLock r5 = orig.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        this.mForceQueryable = orig.mForceQueryableSnapshot.snapshot();     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mForceQueryableSnapshot = new SnapshotCache.Sealed();
        PackageManagerTracedLock r6 = orig.mProtectedBroadcastsLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        this.mProtectedBroadcasts = orig.mProtectedBroadcastsSnapshot.snapshot();     // Catch: Throwable -> L44
        monitor-exit(r6);     // Catch: Throwable -> L44
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mProtectedBroadcastsSnapshot = new SnapshotCache.Sealed();
        this.mQueriesViaComponentRequireRecompute = orig.mQueriesViaComponentRequireRecompute;
        this.mForceQueryableByDevicePackageNames = (String[]) Arrays.copyOf(orig.mForceQueryableByDevicePackageNames, orig.mForceQueryableByDevicePackageNames.length);
        this.mSystemAppsQueryable = orig.mSystemAppsQueryable;
        this.mFeatureConfig = orig.mFeatureConfig.snapshot();
        this.mOverlayReferenceMapper = orig.mOverlayReferenceMapper;
        this.mSystemSigningDetails = orig.mSystemSigningDetails;
        this.mCacheReady = orig.mCacheReady;
        if (this.mCacheReady == false) goto L41;
        PackageManagerTracedLock r7 = orig.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        this.mShouldFilterCache = orig.mShouldFilterCacheSnapshot.snapshot();     // Catch: Throwable -> L37
        monitor-exit(r7);     // Catch: Throwable -> L37
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L42:
        this.mCacheEnabled = orig.mCacheEnabled;
        this.mShouldFilterCacheSnapshot = new SnapshotCache.Sealed();
        this.mHandler = null;
        return;
    L37:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L41:
        this.mShouldFilterCache = new WatchedSparseBooleanMatrix();
    L44:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L48:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L52:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L56:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L60:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L64:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L68:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }
}
