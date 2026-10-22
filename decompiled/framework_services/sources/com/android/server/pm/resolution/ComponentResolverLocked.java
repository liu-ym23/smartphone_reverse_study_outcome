package com.android.server.pm.resolution;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.server.pm.Computer;
import com.android.server.pm.DumpState;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.PackageManagerTracedLock;
import com.android.server.pm.UserManagerService;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ComponentResolverLocked extends ComponentResolverBase {
    protected final PackageManagerTracedLock mLock;

    protected ComponentResolverLocked(UserManagerService userManager) {
        super(userManager);
        this.mLock = new PackageManagerTracedLock();
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public boolean componentExists(ComponentName componentName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.componentExists(componentName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public ParsedActivity getActivity(ComponentName component) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ParsedActivity r1 = super.getActivity(component);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public ParsedProvider getProvider(ComponentName component) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ParsedProvider r1 = super.getProvider(component);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public ParsedActivity getReceiver(ComponentName component) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ParsedActivity r1 = super.getReceiver(component);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public ParsedService getService(ComponentName component) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ParsedService r1 = super.getService(component);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public boolean isActivityDefined(ComponentName component) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = super.isActivityDefined(component);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryActivities(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryActivities(computer, intent, resolvedType, flags, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryActivities(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedActivity> activities, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryActivities(computer, intent, resolvedType, flags, activities, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public ProviderInfo queryProvider(Computer computer, String authority, long flags, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        ProviderInfo r0 = super.queryProvider(computer, authority, flags, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryProviders(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryProviders(computer, intent, resolvedType, flags, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryProviders(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedProvider> providers, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryProviders(computer, intent, resolvedType, flags, providers, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ProviderInfo> queryProviders(Computer computer, String processName, String metaDataKey, int uid, long flags, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ProviderInfo> r0 = super.queryProviders(computer, processName, metaDataKey, uid, flags, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryReceivers(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryReceivers(computer, intent, resolvedType, flags, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryReceivers(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedActivity> receivers, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryReceivers(computer, intent, resolvedType, flags, receivers, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryServices(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryServices(computer, intent, resolvedType, flags, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryServices(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedService> services, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        List<ResolveInfo> r0 = super.queryServices(computer, intent, resolvedType, flags, services, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r0;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void querySyncProviders(Computer computer, List<String> outNames, List<ProviderInfo> outInfo, boolean safeMode, int userId) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        super.querySyncProviders(computer, outNames, outInfo, safeMode, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void dumpActivityResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpActivityResolvers(pw, dumpState, packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void dumpProviderResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpProviderResolvers(pw, dumpState, packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void dumpReceiverResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpReceiverResolvers(pw, dumpState, packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void dumpServiceResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpServiceResolvers(pw, dumpState, packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void dumpContentProviders(Computer computer, PrintWriter pw, DumpState dumpState, String packageName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpContentProviders(computer, pw, dumpState, packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverBase, com.android.server.pm.resolution.ComponentResolverApi
    public void dumpServicePermissions(PrintWriter pw, DumpState dumpState) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        super.dumpServicePermissions(pw, dumpState);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }
}
