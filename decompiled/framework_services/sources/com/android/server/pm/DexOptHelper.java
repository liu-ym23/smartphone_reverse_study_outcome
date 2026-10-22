package com.android.server.pm;

import android.app.AppGlobals;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApexStagedEvent;
import android.content.pm.IPackageManagerNative;
import android.content.pm.IStagedApexObserver;
import android.content.pm.ResolveInfo;
import android.content.pm.StagedApexInfo;
import android.os.Binder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.incremental.IncrementalManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.art.ArtManagerLocal;
import com.android.server.art.DexUseManagerLocal;
import com.android.server.art.model.DexoptParams;
import com.android.server.art.model.DexoptResult;
import com.android.server.pinner.PinnerService;
import com.android.server.pm.dex.DexManager;
import com.android.server.pm.dex.DexoptOptions;
import com.android.server.pm.local.PackageManagerLocalImpl;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class DexOptHelper {
    private static final long SEVEN_DAYS_IN_MILLISECONDS = 604800000;
    private static boolean sArtManagerLocalIsInitialized;
    private static final ThreadPoolExecutor sDexoptExecutor = null;
    private volatile long mBootDexoptStartTime;
    private final PackageManagerService mPm;

    private class DexoptDoneHandler implements ArtManagerLocal.DexoptDoneCallback {
        final /* synthetic */ DexOptHelper this$0;

        /* synthetic */ DexoptDoneHandler(DexOptHelper r1, DexOptHelperIA r2) {
            this(r1);
        }

        private DexoptDoneHandler(DexOptHelper r1) {
            this.this$0 = r1;
        }

        public void onDexoptDone(DexoptResult result) {
            String r0 = result.getReason();
            switch(r0.hashCode()) {
                case -1205769507: goto L12;
                case -587828592: goto L9;
                case -207505425: goto L6;
                default: goto L14;
            };
        L14:
            byte r1 = -1;
        L15:
            switch(r1) {
                case 0: goto L17;
                case 1: goto L17;
                case 2: goto L17;
                default: goto L28;
            };
        L17:
            Iterator r5 = result.getPackageDexoptResults().iterator();
            int numDexopted = 0;
            int numSkipped = 0;
            int numFailed = 0;
        L19:
            if (r5.hasNext() == false) goto L27;
            switch(((DexoptResult.PackageDexoptResult) r5.next()).getStatus()) {
                case 10: goto L25;
                case 20: goto L24;
                case 30: goto L23;
                default: goto L19;
            };
        L23:
            numFailed = numFailed + 1;
            goto L19
        L24:
            numDexopted = numDexopted + 1;
            goto L19
        L25:
            numSkipped = numSkipped + 1;
            goto L19
        L27:
            DexOptHelper.m6638$$Nest$mreportBootDexopt(this.this$0, DexOptHelper.m6636$$Nest$fgetmBootDexoptStartTime(this.this$0), numDexopted, numSkipped, numFailed);
        L28:
            Iterator r2 = result.getPackageDexoptResults().iterator();
        L30:
            if (r2.hasNext() == false) goto L36;
            DexoptResult.PackageDexoptResult pkgRes = (DexoptResult.PackageDexoptResult) r2.next();
            CompilerStats.PackageStats stats = DexOptHelper.m6637$$Nest$fgetmPm(this.this$0).getOrCreateCompilerPackageStats(pkgRes.getPackageName());
            Iterator r6 = pkgRes.getDexContainerFileDexoptResults().iterator();
        L33:
            if (r6.hasNext() == false) goto L30;
            DexoptResult.DexContainerFileDexoptResult dexRes = (DexoptResult.DexContainerFileDexoptResult) r6.next();
            stats.setCompileTime(dexRes.getDexContainerFile(), dexRes.getDex2oatWallTimeMillis());
            goto L33
        L36:
            PackageManagerTracedLock r3 = DexOptHelper.m6637$$Nest$fgetmPm(this.this$0).mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r3);
            DexOptHelper.m6637$$Nest$fgetmPm(this.this$0).getPackageUsage().maybeWriteAsync(DexOptHelper.m6637$$Nest$fgetmPm(this.this$0).mSettings.getPackagesLocked());     // Catch: Throwable -> L64
            DexOptHelper.m6637$$Nest$fgetmPm(this.this$0).mCompilerStats.maybeWriteAsync();     // Catch: Throwable -> L64
            monitor-exit(r3);     // Catch: Throwable -> L64
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            if (result.getReason().equals("inactive") == false) goto L53;
            Iterator r4 = result.getPackageDexoptResults().iterator();
        L44:
            if (r4.hasNext() == false) goto L53;
            DexoptResult.PackageDexoptResult pkgRes2 = (DexoptResult.PackageDexoptResult) r4.next();
            if (pkgRes2.getStatus() != 20) goto L44;
            Iterator r8 = pkgRes2.getDexContainerFileDexoptResults().iterator();
            long pkgSizeBytes = 0;
            long pkgSizeBeforeBytes = 0;
        L49:
            if (r8.hasNext() == false) goto L51;
            DexoptResult.DexContainerFileDexoptResult dexRes2 = (DexoptResult.DexContainerFileDexoptResult) r8.next();
            long dexContainerSize = new File(dexRes2.getDexContainerFile()).length();
            pkgSizeBytes = pkgSizeBytes + (dexRes2.getSizeBytes() + dexContainerSize);
            pkgSizeBeforeBytes = pkgSizeBeforeBytes + (dexRes2.getSizeBeforeBytes() + dexContainerSize);
            goto L49
        L51:
            FrameworkStatsLog.write(128, pkgRes2.getPackageName(), pkgSizeBeforeBytes, pkgSizeBytes, false);
        L53:
            ArraySet<String> updatedPackages = new ArraySet();
            Iterator r7 = result.getPackageDexoptResults().iterator();
        L55:
            if (r7.hasNext() == false) goto L61;
            DexoptResult.PackageDexoptResult pkgRes3 = (DexoptResult.PackageDexoptResult) r7.next();
            if (pkgRes3.hasUpdatedArtifacts() == false) goto L55;
            updatedPackages.add(pkgRes3.getPackageName());
            goto L55
        L61:
            if (updatedPackages.isEmpty() == true) goto L92;
            ((PinnerService) LocalServices.getService(PinnerService.class)).update(updatedPackages, false);
            return;
        L92:
            return;
        L64:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        L6:
            if (r0.equals("first-boot") == false) goto L14;
            r1 = 0;
            goto L15
        L9:
            if (r0.equals("boot-after-ota") == false) goto L14;
            r1 = 1;
            goto L15
        L12:
            if (r0.equals("boot-after-mainline-update") == false) goto L14;
            r1 = 2;
            goto L15
        }
    }

    private static class StagedApexObserver extends IStagedApexObserver.Stub {
        private final ArtManagerLocal mArtManager;

        public static /* synthetic */ String[] $r8$lambda$55crVKefZOQZZBXm7sxbxA0uhOs(int r0) {
            return lambda$onApexStaged$1(r0);
        }

        public static /* synthetic */ String $r8$lambda$rIDkxthGd_RrWXNoIn67o_0lSDo(StagedApexInfo r0) {
            return lambda$onApexStaged$0(r0);
        }

        static void registerForStagedApexUpdates(ArtManagerLocal artManager) {
            IPackageManagerNative packageNative = IPackageManagerNative.Stub.asInterface(ServiceManager.getService("package_native"));
            if (packageNative != null) goto L11;
            Log.e(PackageManagerServiceMonitorEx.TAG, "No IPackageManagerNative");
            return;
        L11:
            packageNative.registerStagedApexObserver(new StagedApexObserver(artManager));     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Log.e(PackageManagerServiceMonitorEx.TAG, "Failed to register staged apex observer", e);
        }

        private StagedApexObserver(ArtManagerLocal artManager) {
            this.mArtManager = artManager;
        }

        public void onApexStaged(ApexStagedEvent event) {
            this.mArtManager.onApexStaged((String[]) Arrays.stream(event.stagedApexInfos).map(new DexOptHelper$StagedApexObserver$$ExternalSyntheticLambda0()).toArray(new DexOptHelper$StagedApexObserver$$ExternalSyntheticLambda1()));
        }

        private static /* synthetic */ String lambda$onApexStaged$0(StagedApexInfo info) {
            return info.moduleName;
        }

        private static /* synthetic */ String[] lambda$onApexStaged$1(int x$0) {
            return new String[x$0];
        }
    }

    public static /* synthetic */ boolean $r8$lambda$1ulR6od7HPmkmkGf1oIaUnk5E3U(PackageStateInternal r0) {
        return lambda$getPackagesForDexopt$8(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$2F6YtrwGCEQWQ4RZrcgHLF4J0no(PackageStateInternal r0) {
        return lambda$getPackagesForDexopt$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$4SWSs9x0PT-mD8zydR8Im9RCrHY, reason: not valid java name */
    public static /* synthetic */ void m6631$r8$lambda$4SWSs9x0PTmD8zydR8Im9RCrHY(InstallRequest r0, DexManager r1) {
        lambda$performDexoptIfNeededAsync$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$EtcyBGgvzmbSnrfVtgFVNd0oBwQ(DexOptHelper r0, ArrayList r1, PackageStateInternal r2) {
        r0.lambda$getOptimizablePackages$0(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$fMSY9l5PvLIU8AgaF7Ue4mVJzB0(long r0, PackageStateInternal r2) {
        return lambda$getPackagesForDexopt$5(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hQXwrxoRjMK0EdU-leJREv9JLGs, reason: not valid java name */
    public static /* synthetic */ boolean m6632$r8$lambda$hQXwrxoRjMK0EdUleJREv9JLGs(ArraySet r0, PackageStateInternal r1) {
        return lambda$getPackagesForDexopt$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$i33vGE2w6m1nxvjfq5mv1de7K-4, reason: not valid java name */
    public static /* synthetic */ boolean m6633$r8$lambda$i33vGE2w6m1nxvjfq5mv1de7K4(PackageStateInternal r0) {
        return lambda$getPackagesForDexopt$7(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$lyz-CsrlBKlbT8_RHpXIMvb-TvY, reason: not valid java name */
    public static /* synthetic */ boolean m6634$r8$lambda$lyzCsrlBKlbT8_RHpXIMvbTvY(PackageStateInternal r0) {
        return lambda$getPackagesForDexopt$6(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$mxejipSC6cGO1AhQNhnD961dbLE(DexManager r0, PackageStateInternal r1) {
        return lambda$getPackagesForDexopt$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$trfEC7vqylEJjtXvm-xdbY7JzUY, reason: not valid java name */
    public static /* synthetic */ long m6635$r8$lambda$trfEC7vqylEJjtXvmxdbY7JzUY(PackageStateInternal r2) {
        return lambda$getPackagesForDexopt$4(r2);
    }

    public static /* synthetic */ Void $r8$lambda$vJ7p4vjM5o_eSsAzU3pI3Qf6f5s(Throwable r0) {
        return lambda$performDexoptIfNeededAsync$11(r0);
    }

    public static /* synthetic */ int $r8$lambda$y9BHHrAP5kMkSDjqImGQQv8nBGs(PackageStateInternal r0, PackageStateInternal r1) {
        return lambda$sortPackagesByUsageDate$9(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootDexoptStartTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6636$$Nest$fgetmBootDexoptStartTime(DexOptHelper r2) {
        return r2.mBootDexoptStartTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPm, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerService m6637$$Nest$fgetmPm(DexOptHelper r0) {
        return r0.mPm;
    }

    /* JADX INFO: renamed from: -$$Nest$mreportBootDexopt, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6638$$Nest$mreportBootDexopt(DexOptHelper r0, long r1, int r3, int r4, int r5) {
        r0.reportBootDexopt(r1, r3, r4, r5);
    }

    static {
        sDexoptExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        sArtManagerLocalIsInitialized = false;
        sDexoptExecutor.allowsCoreThreadTimeOut();
    }

    DexOptHelper(PackageManagerService pm) {
        this.mPm = pm;
    }

    private static String getPrebuildProfilePath(AndroidPackage pkg) {
        return pkg.getBaseApkPath() + ".prof";
    }

    public void performPackageDexOptUpgradeIfNeeded() {
        PackageManagerServiceUtils.enforceSystemOrRoot("Only the system can request package update");
        if (this.mPm.isFirstBoot() == false) goto L6;
        int reason = 0;
    L11:
        Log.i(PackageManagerServiceMonitorEx.TAG, "Starting boot dexopt for reason " + DexoptOptions.convertToArtServiceDexoptReason(reason));
        long startTime = System.nanoTime();
        this.mBootDexoptStartTime = startTime;
        getArtManagerLocal().onBoot(DexoptOptions.convertToArtServiceDexoptReason(reason), null, null);
        return;
    L6:
        if (this.mPm.isDeviceUpgrading() == false) goto L9;
        reason = 1;
        goto L11
    L9:
        if (hasBcpApexesChanged() == false) goto L13;
        reason = 13;
        goto L11
    }

    private void reportBootDexopt(long startTime, int numDexopted, int numSkipped, int numFailed) {
        int elapsedTimeSeconds = (int) TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
        Computer newSnapshot = this.mPm.snapshotComputer();
        MetricsLogger.histogram(this.mPm.mContext, "opt_dialog_num_dexopted", numDexopted);
        MetricsLogger.histogram(this.mPm.mContext, "opt_dialog_num_skipped", numSkipped);
        MetricsLogger.histogram(this.mPm.mContext, "opt_dialog_num_failed", numFailed);
        MetricsLogger.histogram(this.mPm.mContext, "opt_dialog_num_total", getOptimizablePackages(newSnapshot).size());
        MetricsLogger.histogram(this.mPm.mContext, "opt_dialog_time_s", elapsedTimeSeconds);
    }

    public List<String> getOptimizablePackages(Computer snapshot) {
        final ArrayList<String> pkgs = new ArrayList();
        this.mPm.forEachPackageState(snapshot, new DexOptHelper$$ExternalSyntheticLambda10(this, pkgs));
        return pkgs;
    }

    private /* synthetic */ void lambda$getOptimizablePackages$0(ArrayList pkgs, PackageStateInternal packageState) {
        AndroidPackage pkg = packageState.getPkg();
        if (pkg != null) goto L5;
        return;
    L5:
        if (this.mPm.mPackageDexOptimizer.canOptimizePackage(pkg) == false) goto L9;
        pkgs.add(packageState.getPackageName());
        return;
    }

    boolean performDexOpt(DexoptOptions options) {
        Computer snapshot = this.mPm.snapshotComputer();
        if (snapshot.getInstantAppPackageName(Binder.getCallingUid()) == null) goto L6;
        return false;
    L6:
        if (snapshot.isInstantApp(options.getPackageName(), UserHandle.getCallingUserId()) == false) goto L8;
        return false;
    L8:
        AndroidPackage pkg = snapshot.getPackage(options.getPackageName());
        if (pkg == null) goto L14;
        if (pkg.isApex() == false) goto L14;
        return true;
    L14:
        if (options.isDexoptOnlySecondaryDex() == false) goto L16;
        int dexoptStatus = performDexOptWithArtService(options, 0);
    L18:
        if (dexoptStatus != (-1)) goto L20;
        return false;
    L20:
        return true;
    L16:
        dexoptStatus = performDexOptWithStatus(options);
        goto L18
    }

    int performDexOptWithStatus(DexoptOptions options) {
        return performDexOptTraced(options);
    }

    private int performDexOptTraced(DexoptOptions options) {
        Trace.traceBegin(16384, "dexopt");
        int r0 = performDexOptInternal(options);     // Catch: Throwable -> L6
        Trace.traceEnd(16384);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(16384);
        throw th;
    }

    private int performDexOptInternal(DexoptOptions options) {
        return performDexOptWithArtService(options, 4);
    }

    private int performDexOptWithArtService(DexoptOptions options, int extraFlags) {
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();
        PackageState ops = snapshot.getPackageState(options.getPackageName());     // Catch: Throwable -> L15
        if (ops != null) goto L8;
        snapshot.close();
        return -1;
    L8:
        AndroidPackage oap = ops.getAndroidPackage();     // Catch: Throwable -> L15
        if (oap != null) goto L12;
        snapshot.close();
        return -1;
    L12:
        DexoptParams params = options.convertToDexoptParams(extraFlags);     // Catch: Throwable -> L15
        DexoptResult result = getArtManagerLocal().dexoptPackage(snapshot, options.getPackageName(), params);     // Catch: Throwable -> L15
        int r5 = convertToDexOptResult(result);     // Catch: Throwable -> L15
        snapshot.close();
        return r5;
    L15:
        th = move-exception;
        if (snapshot != null) goto L22;
    L21:
        throw th;
    L22:
        snapshot.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    }

    public boolean performDexOptMode(Computer snapshot, String packageName, String targetCompilerFilter, boolean force, boolean bootComplete, String splitName) {
        if (PackageManagerServiceUtils.isSystemOrRootOrShell() == true) goto L10;
        if (isCallerInstallerForPackage(snapshot, packageName) == true) goto L10;
        throw new SecurityException("performDexOptMode");
    L10:
        return this.mPm.getSmtEx().performDexOptModeSmt(packageName, true, targetCompilerFilter, force, bootComplete, splitName, false);
    }

    private boolean isCallerInstallerForPackage(Computer snapshot, String packageName) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState != null) goto L5;
        return false;
    L5:
        InstallSource installSource = packageState.getInstallSource();
        PackageStateInternal installerPackageState = snapshot.getPackageStateInternal(installSource.mInstallerPackageName);
        if (installerPackageState != null) goto L9;
        return false;
    L9:
        if (installerPackageState.getPkg().getUid() != Binder.getCallingUid()) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean performDexOptSecondary(String packageName, String compilerFilter, boolean force) {
        if (force == false) goto L4;
        int r0 = 2;
    L5:
        int flags = r0 | 13;
        return performDexOpt(new DexoptOptions(packageName, 12, compilerFilter, null, flags));
    L4:
        r0 = 0;
        goto L5
    }

    public static List<PackageStateInternal> getPackagesForDexopt(Collection<? extends PackageStateInternal> packages, PackageManagerService packageManagerService) {
        return getPackagesForDexopt(packages, packageManagerService, false);
    }

    public static List<PackageStateInternal> getPackagesForDexopt(Collection<? extends PackageStateInternal> pkgSettings, PackageManagerService packageManagerService, boolean debug) {
        List<PackageStateInternal> result = new ArrayList();
        ArrayList<PackageStateInternal> remainingPkgSettings = new ArrayList(pkgSettings);
        remainingPkgSettings.removeIf(PackageManagerServiceUtils.REMOVE_IF_NULL_PKG);
        remainingPkgSettings.removeIf(PackageManagerServiceUtils.REMOVE_IF_APEX_PKG);
        ArrayList<PackageStateInternal> sortTemp = new ArrayList(remainingPkgSettings.size());
        Computer snapshot = packageManagerService.snapshotComputer();
        applyPackageFilter(snapshot, new DexOptHelper$$ExternalSyntheticLambda0(), result, remainingPkgSettings, sortTemp, packageManagerService);
        Intent intent = new Intent("android.intent.action.PRE_BOOT_COMPLETED");
        final ArraySet<String> pkgNames = getPackageNamesForIntent(intent, 0);
        applyPackageFilter(snapshot, new DexOptHelper$$ExternalSyntheticLambda1(pkgNames), result, remainingPkgSettings, sortTemp, packageManagerService);
        final DexManager dexManager = packageManagerService.getDexManager();
        applyPackageFilter(snapshot, new DexOptHelper$$ExternalSyntheticLambda2(dexManager), result, remainingPkgSettings, sortTemp, packageManagerService);
        if (remainingPkgSettings.isEmpty() == false) goto L5;
    L16:
        Predicate<PackageStateInternal> remainingPredicate = new DexOptHelper$$ExternalSyntheticLambda6();
    L17:
        applyPackageFilter(snapshot, remainingPredicate, result, remainingPkgSettings, sortTemp, packageManagerService);
        result.removeIf(new DexOptHelper$$ExternalSyntheticLambda7());
        if (debug == false) goto L20;
        Log.i(PackageManagerServiceMonitorEx.TAG, "Packages to be dexopted: " + packagesToString(result));
        Log.i(PackageManagerServiceMonitorEx.TAG, "Packages skipped from dexopt: " + packagesToString(remainingPkgSettings));
    L20:
        return result;
    L5:
        if (packageManagerService.isHistoricalPackageUsageAvailable() == false) goto L16;
        if (debug == false) goto L8;
        Log.i(PackageManagerServiceMonitorEx.TAG, "Looking at historical package use");
    L8:
        PackageStateInternal lastUsed = (PackageStateInternal) Collections.max(remainingPkgSettings, Comparator.comparingLong(new DexOptHelper$$ExternalSyntheticLambda3()));
        if (debug == false) goto L11;
        Log.i(PackageManagerServiceMonitorEx.TAG, "Taking package " + lastUsed.getPackageName() + " as reference in time use");
    L11:
        long estimatedPreviousSystemUseTime = lastUsed.getTransientState().getLatestForegroundPackageUseTimeInMills();
        if (estimatedPreviousSystemUseTime == 0) goto L14;
        final long cutoffTime = estimatedPreviousSystemUseTime - 604800000;
        Predicate<PackageStateInternal> remainingPredicate2 = new DexOptHelper$$ExternalSyntheticLambda4(cutoffTime);
    L15:
        sortPackagesByUsageDate(remainingPkgSettings, packageManagerService);
        remainingPredicate = remainingPredicate2;
        goto L17
    L14:
        remainingPredicate2 = new DexOptHelper$$ExternalSyntheticLambda5();
        goto L15
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$1(PackageStateInternal pkgSetting) {
        return pkgSetting.getPkg().isCoreApp();
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$2(ArraySet pkgNames, PackageStateInternal pkgSetting) {
        return pkgNames.contains(pkgSetting.getPackageName());
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$3(DexManager dexManager, PackageStateInternal pkgSetting) {
        return dexManager.getPackageUseInfoOrDefault(pkgSetting.getPackageName()).isAnyCodePathUsedByOtherApps();
    }

    private static /* synthetic */ long lambda$getPackagesForDexopt$4(PackageStateInternal pkgSetting) {
        return pkgSetting.getTransientState().getLatestForegroundPackageUseTimeInMills();
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$5(long cutoffTime, PackageStateInternal pkgSetting) {
        if (pkgSetting.getTransientState().getLatestForegroundPackageUseTimeInMills() < cutoffTime) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$6(PackageStateInternal pkgSetting) {
        return true;
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$7(PackageStateInternal pkgSetting) {
        return true;
    }

    private static /* synthetic */ boolean lambda$getPackagesForDexopt$8(PackageStateInternal pkgSetting) {
        return PackageManagerService.PLATFORM_PACKAGE_NAME.equals(pkgSetting.getPackageName());
    }

    private static void applyPackageFilter(Computer snapshot, Predicate<PackageStateInternal> filter, Collection<PackageStateInternal> result, Collection<PackageStateInternal> packages, List<PackageStateInternal> sortTemp, PackageManagerService packageManagerService) {
        Iterator<PackageStateInternal> r0 = packages.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        PackageStateInternal pkgSetting = r0.next();
        if (filter.test(pkgSetting) == false) goto L4;
        sortTemp.add(pkgSetting);
        goto L4
    L9:
        sortPackagesByUsageDate(sortTemp, packageManagerService);
        packages.removeAll(sortTemp);
        Iterator<PackageStateInternal> r1 = sortTemp.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        PackageStateInternal pkgSetting2 = r1.next();
        result.add(pkgSetting2);
        List<PackageStateInternal> deps = snapshot.findSharedNonSystemLibraries(pkgSetting2);
        if (deps.isEmpty() == true) goto L11;
        deps.removeAll(result);
        result.addAll(deps);
        packages.removeAll(deps);
        goto L11
    L16:
        sortTemp.clear();
    }

    private static void sortPackagesByUsageDate(List<PackageStateInternal> pkgSettings, PackageManagerService packageManagerService) {
        if (packageManagerService.isHistoricalPackageUsageAvailable() == true) goto L5;
        return;
    L5:
        Collections.sort(pkgSettings, new DexOptHelper$$ExternalSyntheticLambda11());
    }

    private static /* synthetic */ int lambda$sortPackagesByUsageDate$9(PackageStateInternal pkgSetting1, PackageStateInternal pkgSetting2) {
        return Long.compare(pkgSetting2.getTransientState().getLatestForegroundPackageUseTimeInMills(), pkgSetting1.getTransientState().getLatestForegroundPackageUseTimeInMills());
    }

    private static ArraySet<String> getPackageNamesForIntent(Intent intent, int userId) {
        List<ResolveInfo> ris = null;
        ris = AppGlobals.getPackageManager().queryIntentReceivers(intent, null, 0, userId).getList();     // Catch: RemoteException -> L7
    L11:
        ArraySet<String> pkgNames = new ArraySet();
        if (ris == null) goto L17;
        Iterator<ResolveInfo> r9 = ris.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        ResolveInfo ri = r9.next();
        pkgNames.add(ri.activityInfo.packageName);
    L17:
        return pkgNames;
    }

    public static String packagesToString(List<PackageStateInternal> pkgSettings) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
    L4:
        if (index >= pkgSettings.size()) goto L10;
        if (sb.length() <= 0) goto L8;
        sb.append(", ");
    L8:
        sb.append(pkgSettings.get(index).getPackageName());
        index = index + 1;
        goto L4
    L10:
        return sb.toString();
    }

    public static void requestCopyPreoptedFiles() {
        if (SystemProperties.getInt("ro.cp_system_other_odex", 0) != 1) goto L21;
        SystemProperties.set("sys.cppreopt", "requested");
        long timeStart = SystemClock.uptimeMillis();
        long timeEnd = 100000 + timeStart;
        long timeNow = timeStart;
    L6:
        if (SystemProperties.get("sys.cppreopt").equals("finished") == true) goto L14;
        Thread.sleep(100);     // Catch: InterruptedException -> L10
    L11:
        timeNow = SystemClock.uptimeMillis();
        if (timeNow <= timeEnd) goto L6;
        SystemProperties.set("sys.cppreopt", "timed-out");
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "cppreopt did not finish!");
    L14:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "cppreopts took " + (timeNow - timeStart) + " ms");
        return;
    }

    public static void dumpDexoptState(IndentingPrintWriter ipw, String packageName) {
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();
        if (packageName != null) goto L20;
        getArtManagerLocal().dump(ipw, snapshot);     // Catch: Throwable -> L6
    L11:
        if (snapshot == null) goto L26;
        snapshot.close();
        return;
    L26:
        return;
    L20:
        getArtManagerLocal().dumpPackage(ipw, snapshot, packageName);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
    L8:
        e = move-exception;
        ipw.println(e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (snapshot != null) goto L24;
    L19:
        throw th;
    L24:
        snapshot.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    private static List<String> getBcpApexes() {
        String bcp = System.getenv("BOOTCLASSPATH");
        if (TextUtils.isEmpty(bcp) == false) goto L6;
        Log.e(PackageManagerServiceMonitorEx.TAG, "Unable to get BOOTCLASSPATH");
        return List.of();
    L6:
        ArrayList<String> bcpApexes = new ArrayList();
        String[] r2 = bcp.split(":");
        int r3 = r2.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L14;
        String pathStr = r2[r5];
        Path path = Paths.get(pathStr, new String[0]);
        if (path.getNameCount() < 2) goto L13;
        if (path.getName(0).toString().equals("apex") == false) goto L13;
        bcpApexes.add(path.getName(1).toString());
    L13:
        r5 = r5 + 1;
        goto L7
    L14:
        return bcpApexes;
    }

    private static boolean hasBcpApexesChanged() {
        Set<String> bcpApexes = new HashSet(getBcpApexes());
        ApexManager apexManager = ApexManager.getInstance();
        Iterator<ApexManager.ActiveApexInfo> r2 = apexManager.getActiveApexInfos().iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        ApexManager.ActiveApexInfo apexInfo = r2.next();
        if (bcpApexes.contains(apexInfo.apexModuleName) == false) goto L4;
        if (apexInfo.activeApexChanged == false) goto L4;
        return true;
    L12:
        return false;
    }

    public static DexUseManagerLocal getDexUseManagerLocal() {
        return (DexUseManagerLocal) LocalManagerRegistry.getManagerOrThrow(DexUseManagerLocal.class);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void initializeArtManagerLocal(final Context systemContext, final PackageManagerService pm) {
        final ArtManagerLocal artManager = new ArtManagerLocal(systemContext);
        SystemServerInitThreadPool$$ExternalSyntheticLambda0 r1 = new SystemServerInitThreadPool$$ExternalSyntheticLambda0();
        DexOptHelper r3 = pm.getDexOptHelper();
        r3.getClass();
        artManager.addDexoptDoneCallback(false, r1, new DexoptDoneHandler(r3, null));
        LocalManagerRegistry.addManager(ArtManagerLocal.class, artManager);
        sArtManagerLocalIsInitialized = true;
        systemContext.registerReceiver(new AnonymousClass1(systemContext, artManager, pm), new IntentFilter("android.intent.action.LOCKED_BOOT_COMPLETED"));
        StagedApexObserver.registerForStagedApexUpdates(artManager);
    }

    public static boolean artManagerLocalIsInitialized() {
        return sArtManagerLocalIsInitialized;
    }

    public static ArtManagerLocal getArtManagerLocal() {
        return (ArtManagerLocal) LocalManagerRegistry.getManagerOrThrow(ArtManagerLocal.class);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static int convertToDexOptResult(DexoptResult result) {
        int status = result.getFinalStatus();
        switch(status) {
            case 10: goto L12;
            case 20: goto L10;
            case 30: goto L8;
            case 40: goto L6;
            default: goto L5;
        };
    L6:
        return 2;
    L8:
        return -1;
    L10:
        return 1;
    L12:
        return 0;
    L5:
        throw new IllegalArgumentException("DexoptResult for " + ((DexoptResult.PackageDexoptResult) result.getPackageDexoptResults().get(0)).getPackageName() + " has unsupported status " + status);
    }

    private static DexoptOptions getDexoptOptionsByInstallRequest(InstallRequest installRequest, DexManager dexManager) {
        PackageSetting ps = installRequest.getScannedPackageSetting();
        String packageName = ps.getPackageName();
        int r4 = 0;
        if (installRequest.getInstallReason() != 2) goto L5;
    L8:
        boolean isBackupOrRestore = true;
    L10:
        if (isBackupOrRestore == false) goto L12;
        r4 = 2048;
    L12:
        int dexoptFlags = r4 | 1029;
        int compilationReason = dexManager.getCompilationReasonForInstallScenario(installRequest.getInstallScenario());
        ps.getPkg();
        DexoptOptions options = new DexoptOptions(packageName, compilationReason, dexoptFlags);
        if (installRequest.getDexoptCompilerFilter() == null) goto L16;
        return options.overrideCompilerFilter(installRequest.getDexoptCompilerFilter());
    L16:
        if (shouldSkipDexopt(installRequest) == true) goto L18;
        return options;
    L18:
        return options.overrideCompilerFilter("skip");
    L5:
        if (installRequest.getInstallReason() == 3) goto L8;
        isBackupOrRestore = false;
        goto L10
    }

    static void performDexoptIfNeeded(InstallRequest installRequest, DexManager dexManager, PackageManagerTracedLock.RawLock installLock) {
        if (shouldCallArtService(installRequest) == true) goto L5;
        return;
    L5:
        if (installLock == null) goto L18;
        installLock.unlock();
    L18:
        Trace.traceBegin(262144, "dexopt");     // Catch: Throwable -> L13
        DexoptOptions dexoptOptions = getDexoptOptionsByInstallRequest(installRequest, dexManager);     // Catch: Throwable -> L13
        DexoptResult dexOptResult = dexoptPackageUsingArtService(installRequest, dexoptOptions);     // Catch: Throwable -> L13
        installRequest.onDexoptFinished(dexOptResult);     // Catch: Throwable -> L13
        Trace.traceEnd(262144);
        if (installLock == null) goto L20;
        installLock.lock();
        return;
    L20:
        return;
    L13:
        th = move-exception;
        Trace.traceEnd(262144);
        if (installLock == null) goto L17;
        installLock.lock();
    L17:
        throw th;
    }

    static CompletableFuture<Void> performDexoptIfNeededAsync(final InstallRequest installRequest, final DexManager dexManager) {
        if (shouldCallArtService(installRequest) == true) goto L7;
        return CompletableFuture.completedFuture(null);
    L7:
        return CompletableFuture.runAsync(new DexOptHelper$$ExternalSyntheticLambda8(installRequest, dexManager), sDexoptExecutor).exceptionally(new DexOptHelper$$ExternalSyntheticLambda9());
    }

    private static /* synthetic */ void lambda$performDexoptIfNeededAsync$10(InstallRequest installRequest, DexManager dexManager) {
        Trace.traceBegin(262144, "dexopt");     // Catch: Throwable -> L6
        DexoptOptions dexoptOptions = getDexoptOptionsByInstallRequest(installRequest, dexManager);     // Catch: Throwable -> L6
        DexoptResult dexOptResult = dexoptPackageUsingArtService(installRequest, dexoptOptions);     // Catch: Throwable -> L6
        installRequest.onDexoptFinished(dexOptResult);     // Catch: Throwable -> L6
        Trace.traceEnd(262144);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    }

    private static /* synthetic */ Void lambda$performDexoptIfNeededAsync$11(Throwable t) {
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Dexopt encountered a fatal error", t);
        return null;
    }

    static DexoptResult dexoptPackageUsingArtService(InstallRequest installRequest, DexoptOptions dexoptOptions) {
        PackageSetting ps = installRequest.getScannedPackageSetting();
        String packageName = ps.getPackageName();
        PackageManagerLocal packageManagerLocal = (PackageManagerLocal) LocalManagerRegistry.getManager(PackageManagerLocal.class);
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerLocalImpl.withFilteredSnapshot(packageManagerLocal, ps);
        int extraFlags = 0;
        if ((installRequest.getInstallFlags() & 268435456) == 0) goto L6;
        boolean ignoreDexoptProfile = true;
    L7:
        if (ignoreDexoptProfile == false) goto L9;
        extraFlags = 128;
    L9:
        DexoptParams params = dexoptOptions.convertToDexoptParams(extraFlags);     // Catch: Throwable -> L13
        DexoptResult dexOptResult = getArtManagerLocal().dexoptPackage(snapshot, packageName, params);     // Catch: Throwable -> L13
        if (snapshot == null) goto L12;
        snapshot.close();
    L12:
        return dexOptResult;
    L6:
        ignoreDexoptProfile = false;
    L13:
        th = move-exception;
        if (snapshot != null) goto L20;
    L19:
        throw th;
    L20:
        snapshot.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    private static boolean shouldSkipDexopt(InstallRequest installRequest) {
        PackageSetting ps = installRequest.getScannedPackageSetting();
        AndroidPackageInternal r1 = ps.getPkg();
        boolean onIncremental = IncrementalManager.isIncrementalPath(ps.getPathString());
        if (r1 != null) goto L5;
    L9:
        return true;
    L5:
        if (r1.isDebuggable() == true) goto L9;
        if (onIncremental == true) goto L9;
        return false;
    }

    private static boolean shouldCallArtService(InstallRequest installRequest) {
        if ((installRequest.getScanFlags() & 67108864) == 0) goto L5;
        boolean isApex = true;
    L7:
        if ((installRequest.getScanFlags() & 8192) == 0) goto L9;
        boolean instantApp = true;
    L10:
        PackageSetting ps = installRequest.getScannedPackageSetting();
        AndroidPackageInternal r5 = ps.getPkg();
        if (installRequest.isRollback() == true) goto L13;
    L16:
        boolean performDexOptForRollback = true;
    L18:
        if (instantApp == true) goto L24;
        if (r5 == null) goto L25;
        if (isApex == true) goto L26;
        if (performDexOptForRollback == true) goto L23;
        return false;
    L23:
        return true;
    L26:
        return false;
    L25:
        return false;
    L24:
        return false;
    L13:
        if (installRequest.getInstallSource().mInitiatingPackageName.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L16;
        performDexOptForRollback = false;
        goto L18
    L9:
        instantApp = false;
        goto L10
    L5:
        isApex = false;
        goto L7
    }
}
