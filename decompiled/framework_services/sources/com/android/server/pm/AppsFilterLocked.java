package com.android.server.pm;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
abstract class AppsFilterLocked extends AppsFilterBase {
    protected final PackageManagerTracedLock mCacheLock;
    protected final PackageManagerTracedLock mForceQueryableLock;
    protected final PackageManagerTracedLock mImplicitlyQueryableLock;
    protected final PackageManagerTracedLock mProtectedBroadcastsLock;
    protected final PackageManagerTracedLock mQueriesViaComponentLock;
    protected final PackageManagerTracedLock mQueriesViaPackageLock;
    protected final PackageManagerTracedLock mQueryableViaUsesLibraryLock;
    protected final PackageManagerTracedLock mQueryableViaUsesPermissionLock;

    AppsFilterLocked() {
        this.mForceQueryableLock = new PackageManagerTracedLock();
        this.mQueriesViaPackageLock = new PackageManagerTracedLock();
        this.mQueriesViaComponentLock = new PackageManagerTracedLock();
        this.mImplicitlyQueryableLock = new PackageManagerTracedLock();
        this.mQueryableViaUsesLibraryLock = new PackageManagerTracedLock();
        this.mProtectedBroadcastsLock = new PackageManagerTracedLock();
        this.mQueryableViaUsesPermissionLock = new PackageManagerTracedLock();
        this.mCacheLock = new PackageManagerTracedLock();
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isForceQueryable(int appId) {
        PackageManagerTracedLock r0 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isForceQueryable(appId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isQueryableViaPackage(int callingAppId, int targetAppId) {
        PackageManagerTracedLock r0 = this.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isQueryableViaPackage(callingAppId, targetAppId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isQueryableViaComponent(int callingAppId, int targetAppId) {
        PackageManagerTracedLock r0 = this.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isQueryableViaComponent(callingAppId, targetAppId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isImplicitlyQueryable(int callingUid, int targetUid) {
        PackageManagerTracedLock r0 = this.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isImplicitlyQueryable(callingUid, targetUid);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isRetainedImplicitlyQueryable(int callingUid, int targetUid) {
        PackageManagerTracedLock r0 = this.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isRetainedImplicitlyQueryable(callingUid, targetUid);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isQueryableViaUsesLibrary(int callingAppId, int targetAppId) {
        PackageManagerTracedLock r0 = this.mQueryableViaUsesLibraryLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isQueryableViaUsesLibrary(callingAppId, targetAppId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isQueryableViaUsesPermission(int callingAppId, int targetAppId) {
        PackageManagerTracedLock r0 = this.mQueryableViaUsesPermissionLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isQueryableViaUsesPermission(callingAppId, targetAppId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean shouldFilterApplicationUsingCache(int callingUid, int appId, int userId) {
        PackageManagerTracedLock r0 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.shouldFilterApplicationUsingCache(callingUid, appId, userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected void dumpForceQueryable(PrintWriter pw, Integer filteringAppId, AppsFilterBase.ToString<Integer> expandPackages) {
        PackageManagerTracedLock r0 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpForceQueryable(pw, filteringAppId, expandPackages);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected void dumpQueriesViaPackage(PrintWriter pw, Integer filteringAppId, AppsFilterBase.ToString<Integer> expandPackages) {
        PackageManagerTracedLock r0 = this.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpQueriesViaPackage(pw, filteringAppId, expandPackages);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected void dumpQueriesViaComponent(PrintWriter pw, Integer filteringAppId, AppsFilterBase.ToString<Integer> expandPackages) {
        PackageManagerTracedLock r0 = this.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpQueriesViaComponent(pw, filteringAppId, expandPackages);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected void dumpQueriesViaImplicitlyQueryable(PrintWriter pw, Integer filteringAppId, int[] users, AppsFilterBase.ToString<Integer> expandPackages) {
        PackageManagerTracedLock r0 = this.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpQueriesViaImplicitlyQueryable(pw, filteringAppId, users, expandPackages);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected void dumpQueriesViaUsesLibrary(PrintWriter pw, Integer filteringAppId, AppsFilterBase.ToString<Integer> expandPackages) {
        PackageManagerTracedLock r0 = this.mQueryableViaUsesLibraryLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpQueriesViaUsesLibrary(pw, filteringAppId, expandPackages);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }
}
