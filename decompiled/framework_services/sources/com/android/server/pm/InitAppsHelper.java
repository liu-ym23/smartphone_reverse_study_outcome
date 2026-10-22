package com.android.server.pm;

import android.app.SysMonitorFwBridge;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.os.Trace;
import android.system.ErrnoException;
import android.system.Os;
import android.util.ArrayMap;
import android.util.EventLog;
import android.util.Slog;
import com.android.internal.content.om.OverlayConfig;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.TriConsumer;
import com.android.server.EventLogTags;
import com.android.server.SysOptBridge;
import com.android.server.pm.parsing.PackageCacher;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.utils.WatchedArrayMap;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
final class InitAppsHelper {
    private final ApexManager mApexManager;
    private int mCachedSystemApps;
    private final List<ScanPartition> mDirsToScanAsSystem;
    private final ExecutorService mExecutorService;
    private final ArrayMap<String, File> mExpectingBetter;
    private final InstallPackageHelper mInstallPackageHelper;
    private final boolean mIsDeviceUpgrading;
    private final PackageManagerService mPm;
    private final List<String> mPossiblyDeletedUpdatedSystemApps;
    private final int mScanFlags;
    private final List<String> mStubSystemApps;
    private int mSystemPackagesCount;
    private final int mSystemParseFlags;
    private final List<ScanPartition> mSystemPartitions;
    private final int mSystemScanFlags;
    private long mSystemScanTime;

    /* JADX INFO: renamed from: $r8$lambda$VJZW-c31uI8Yaywv2gsqfy0KEng, reason: not valid java name */
    public static /* synthetic */ void m6653$r8$lambda$VJZWc31uI8Yaywv2gsqfy0KEng(TriConsumer r0, ArrayMap r1, PackageStateInternal r2) {
        lambda$initSystemApps$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$VWF6nFCGGoc9b6Gi7rkF04KUDnc(InitAppsHelper r0, ArrayMap r1, TriConsumer r2) {
        r0.lambda$initSystemApps$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$WUjG5T2nXa8xdZKlIPYCIIcrmg4(Path r0) {
        lambda$fixInstalledAppDirMode$2(r0);
    }

    InitAppsHelper(PackageManagerService pm, ApexManager apexManager, InstallPackageHelper installPackageHelper, List<ScanPartition> systemPartitions) {
        this.mExpectingBetter = new ArrayMap();
        this.mPossiblyDeletedUpdatedSystemApps = new ArrayList();
        this.mStubSystemApps = new ArrayList();
        this.mPm = pm;
        this.mApexManager = apexManager;
        this.mInstallPackageHelper = installPackageHelper;
        this.mSystemPartitions = systemPartitions;
        this.mDirsToScanAsSystem = getSystemScanPartitions();
        this.mIsDeviceUpgrading = this.mPm.isDeviceUpgrading();
        if (this.mIsDeviceUpgrading == false) goto L5;
    L8:
        this.mScanFlags = 528 | 4096;
    L9:
        this.mSystemParseFlags = this.mPm.getDefParseFlags() | 16;
        this.mSystemScanFlags = this.mScanFlags | 65536;
        this.mExecutorService = ParallelPackageParser.makeExecutorService();
        return;
    L5:
        if (this.mPm.isFirstBoot() == true) goto L8;
        this.mScanFlags = FrameworkStatsLog.EXPRESS_EVENT_REPORTED;
        goto L9
    }

    private List<ScanPartition> getSystemScanPartitions() {
        List<ScanPartition> scanPartitions = new ArrayList();
        scanPartitions.addAll(this.mSystemPartitions);
        scanPartitions.addAll(getApexScanPartitions());
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Directories scanned as system partitions: " + scanPartitions);
        return scanPartitions;
    }

    private List<ScanPartition> getApexScanPartitions() {
        List<ScanPartition> scanPartitions = new ArrayList();
        List<ApexManager.ActiveApexInfo> activeApexInfos = this.mApexManager.getActiveApexInfos();
        int i = 0;
    L4:
        if (i >= activeApexInfos.size()) goto L10;
        ScanPartition scanPartition = resolveApexToScanPartition(activeApexInfos.get(i));
        if (scanPartition == null) goto L8;
        scanPartitions.add(scanPartition);
    L8:
        i = i + 1;
        goto L4
    L10:
        return scanPartitions;
    }

    private static ScanPartition resolveApexToScanPartition(ApexManager.ActiveApexInfo apexInfo) {
        int i = 0;
        int size = PackageManagerService.SYSTEM_PARTITIONS.size();
    L3:
        if (i >= size) goto L12;
        ScanPartition sp = PackageManagerService.SYSTEM_PARTITIONS.get(i);
        if (apexInfo.preInstalledApexPath.getAbsolutePath().equals(sp.getFolder().getAbsolutePath()) == true) goto L11;
        if (apexInfo.preInstalledApexPath.getAbsolutePath().startsWith(sp.getFolder().getAbsolutePath() + File.separator) == true) goto L11;
        i = i + 1;
    L11:
        return new ScanPartition(apexInfo.apexDirectory, sp, apexInfo);
    L12:
        return null;
    }

    private List<ApexManager.ScanResult> scanApexPackagesTraced(PackageParser2 packageParser) {
        Trace.traceBegin(262144, "scanApexPackages");
        List<ApexManager.ScanResult> r10 = this.mInstallPackageHelper.scanApexPackages(this.mApexManager.getAllApexInfos(), this.mSystemParseFlags, this.mSystemScanFlags, packageParser, this.mExecutorService);     // Catch: Throwable -> L8
        Trace.traceEnd(262144);
        return r10;
    L8:
        th = move-exception;
        Throwable r11 = th;
    L12:
        Trace.traceEnd(262144);
        throw r11;
    L10:
        th = move-exception;
        r11 = th;
        goto L12
    }

    public OverlayConfig initSystemApps(PackageParser2 packageParser, WatchedArrayMap<String, PackageSetting> packageSettings, int[] userIds, long startTime) {
        if (Build.isDebuggable() == false) goto L5;
        SysMonitorFwBridge.getFactory().getCustomLeakCanaryUtils().parseCustomLeakCanary(packageParser, this.mExecutorService);
    L5:
        List<ApexManager.ScanResult> apexScanResults = scanApexPackagesTraced(packageParser);
        this.mApexManager.notifyScanResult(apexScanResults);
        scanSystemDirs(packageParser, this.mExecutorService);
        final ArrayMap<String, File> apkInApexPreInstalledPaths = new ArrayMap();
        Iterator<ApexManager.ActiveApexInfo> r2 = this.mApexManager.getActiveApexInfos().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        ApexManager.ActiveApexInfo apexInfo = r2.next();
        String apexPackageName = this.mApexManager.getActivePackageNameForApexModuleName(apexInfo.apexModuleName);
        Iterator<String> r5 = this.mApexManager.getApksInApex(apexPackageName).iterator();
    L10:
        if (r5.hasNext() == false) goto L7;
        String packageName = r5.next();
        apkInApexPreInstalledPaths.put(packageName, apexInfo.preInstalledApexPath);
        goto L10
    L13:
        OverlayConfig overlayConfig = OverlayConfig.initializeSystemInstance(new InitAppsHelper$$ExternalSyntheticLambda1(this, apkInApexPreInstalledPaths));
        updateStubSystemAppsList(this.mStubSystemApps);
        this.mInstallPackageHelper.prepareSystemPackageCleanUp(packageSettings, this.mPossiblyDeletedUpdatedSystemApps, this.mExpectingBetter, userIds);
        logSystemAppsScanningTime(startTime);
        return overlayConfig;
    }

    private /* synthetic */ void lambda$initSystemApps$1(final ArrayMap apkInApexPreInstalledPaths, final TriConsumer consumer) {
        this.mPm.forEachPackageState(this.mPm.snapshotComputer(), new InitAppsHelper$$ExternalSyntheticLambda2(consumer, apkInApexPreInstalledPaths));
    }

    private static /* synthetic */ void lambda$initSystemApps$0(TriConsumer consumer, ArrayMap apkInApexPreInstalledPaths, PackageStateInternal packageState) {
        AndroidPackageInternal pkg = packageState.getPkg();
        if (pkg == null) goto L6;
        consumer.accept(pkg, Boolean.valueOf(packageState.isSystem()), (File) apkInApexPreInstalledPaths.get(pkg.getPackageName()));
        return;
    }

    private void logSystemAppsScanningTime(long startTime) {
        this.mCachedSystemApps = PackageCacher.sCachedPackageReadCount.get();
        this.mPm.mSettings.pruneSharedUsersLPw();
        this.mSystemScanTime = SystemClock.uptimeMillis() - startTime;
        this.mSystemPackagesCount = this.mPm.mPackages.size();
        StringBuilder r0 = new StringBuilder();
        r0.append("Finished scanning system apps. Time: ");
        r0.append(this.mSystemScanTime);
        r0.append(" ms, packageCount: ");
        r0.append(this.mSystemPackagesCount);
        r0.append(" , timePerPackage: ");
        if (this.mSystemPackagesCount != 0) goto L5;
        long r1 = 0;
    L6:
        r0.append(r1);
        r0.append(" , cached: ");
        r0.append(this.mCachedSystemApps);
        Slog.i(PackageManagerServiceMonitorEx.TAG, r0.toString());
        if (this.mIsDeviceUpgrading == true) goto L9;
    L11:
        SysOptBridge.getFactory().getBootEventStat().setSystemPackagesCount(this.mSystemPackagesCount);
        return;
    L9:
        if (this.mSystemPackagesCount <= 0) goto L11;
        FrameworkStatsLog.write(239, 15, this.mSystemScanTime / ((long) this.mSystemPackagesCount));
        goto L11
    L5:
        r1 = this.mSystemScanTime / ((long) this.mSystemPackagesCount);
        goto L6
    }

    void fixInstalledAppDirMode() {
        DirectoryStream<Path> files = Files.newDirectoryStream(this.mPm.getAppInstallDir().toPath());     // Catch: Exception -> L6
        files.forEach(new InitAppsHelper$$ExternalSyntheticLambda0());     // Catch: Throwable -> L8
        files.close();     // Catch: Exception -> L6
        return;
    L8:
        th = move-exception;
        if (files != null) goto L18;
    L15:
        throw th;     // Catch: Exception -> L6
    L18:
        files.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to walk the app install directory to fix the modes", e);
    }

    private static /* synthetic */ void lambda$fixInstalledAppDirMode$2(Path dir) {
        Os.chmod(dir.toString(), 505);     // Catch: ErrnoException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to fix an installed app dir mode", e);
    }

    public void initNonSystemApps(PackageParser2 packageParser, int[] userIds, long startTime) {
        EventLog.writeEvent(EventLogTags.BOOT_PROGRESS_PMS_DATA_SCAN_START, SystemClock.uptimeMillis());
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_pms_data_scan_start", SystemClock.elapsedRealtime());
        if ((this.mScanFlags & 4096) != 4096) goto L5;
        fixInstalledAppDirMode();
    L5:
        scanDirTracedLI(this.mPm.getAppInstallDir(), 0, this.mScanFlags | 128, packageParser, this.mExecutorService, null);
        List<Runnable> unfinishedTasks = this.mExecutorService.shutdownNow();
        if (unfinishedTasks.isEmpty() == false) goto L10;
        fixSystemPackages(userIds);
        logNonSystemAppScanningTime(startTime);
        this.mExpectingBetter.clear();
        this.mPm.mSettings.pruneRenamedPackagesLPw();
        return;
    L10:
        throw new IllegalStateException("Not all tasks finished before calling close: " + unfinishedTasks);
    }

    private void fixSystemPackages(int[] userIds) {
        this.mInstallPackageHelper.cleanupDisabledPackageSettings(this.mPossiblyDeletedUpdatedSystemApps, userIds, this.mScanFlags);
        this.mInstallPackageHelper.checkExistingBetterPackages(this.mExpectingBetter, this.mStubSystemApps, this.mSystemScanFlags, this.mSystemParseFlags);
        this.mInstallPackageHelper.installSystemStubPackages(this.mStubSystemApps, this.mScanFlags);
    }

    private void logNonSystemAppScanningTime(long startTime) {
        int cachedNonSystemApps = PackageCacher.sCachedPackageReadCount.get() - this.mCachedSystemApps;
        long dataScanTime = (SystemClock.uptimeMillis() - this.mSystemScanTime) - startTime;
        int dataPackagesCount = this.mPm.mPackages.size() - this.mSystemPackagesCount;
        StringBuilder r4 = new StringBuilder();
        r4.append("Finished scanning non-system apps. Time: ");
        r4.append(dataScanTime);
        r4.append(" ms, packageCount: ");
        r4.append(dataPackagesCount);
        r4.append(" , timePerPackage: ");
        if (dataPackagesCount != 0) goto L5;
        long r5 = 0;
    L6:
        r4.append(r5);
        r4.append(" , cached: ");
        r4.append(cachedNonSystemApps);
        Slog.i(PackageManagerServiceMonitorEx.TAG, r4.toString());
        if (this.mIsDeviceUpgrading == false) goto L10;
        if (dataPackagesCount <= 0) goto L10;
        FrameworkStatsLog.write(239, 14, dataScanTime / ((long) dataPackagesCount));
    L10:
        SysOptBridge.getFactory().getBootEventStat().setDataPackagesCount(dataPackagesCount);
        return;
    L5:
        r5 = dataScanTime / ((long) dataPackagesCount);
        goto L6
    }

    private void scanSystemDirs(PackageParser2 packageParser, ExecutorService executorService) {
        File frameworkDir = new File(Environment.getRootDirectory(), "framework");
        int i = this.mDirsToScanAsSystem.size() - 1;
    L3:
        if (i < 0) goto L9;
        ScanPartition partition = this.mDirsToScanAsSystem.get(i);
        if (partition.getOverlayFolder() == null) goto L8;
        scanDirTracedLI(partition.getOverlayFolder(), this.mSystemParseFlags, this.mSystemScanFlags | partition.scanFlag, packageParser, executorService, partition.apexInfo);
    L8:
        i = i - 1;
        goto L3
    L9:
        scanDirTracedLI(frameworkDir, this.mSystemParseFlags, (this.mSystemScanFlags | 1) | 131072, packageParser, executorService, null);
        if (this.mPm.mPackages.containsKey(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L20;
        int size = this.mDirsToScanAsSystem.size();
        int i2 = 0;
    L12:
        if (i2 >= size) goto L18;
        ScanPartition partition2 = this.mDirsToScanAsSystem.get(i2);
        if (partition2.getPrivAppFolder() == null) goto L16;
        scanDirTracedLI(partition2.getPrivAppFolder(), this.mSystemParseFlags, (this.mSystemScanFlags | 131072) | partition2.scanFlag, packageParser, executorService, partition2.apexInfo);
    L16:
        scanDirTracedLI(partition2.getAppFolder(), this.mSystemParseFlags, this.mSystemScanFlags | partition2.scanFlag, packageParser, executorService, partition2.apexInfo);
        i2 = i2 + 1;
        goto L12
    L18:
        return;
    L20:
        throw new IllegalStateException("Failed to load frameworks package; check log for warnings");
    }

    private void updateStubSystemAppsList(List<String> stubSystemApps) {
        int numPackages = this.mPm.mPackages.size();
        int index = 0;
    L3:
        if (index >= numPackages) goto L9;
        AndroidPackage pkg = this.mPm.mPackages.valueAt(index);
        if (pkg.isStub() == false) goto L7;
        stubSystemApps.add(pkg.getPackageName());
    L7:
        index = index + 1;
        goto L3
    }

    private void scanDirTracedLI(File scanDir, int parseFlags, int scanFlags, PackageParser2 packageParser, ExecutorService executorService, ApexManager.ActiveApexInfo apexInfo) {
        Trace.traceBegin(262144, "scanDir [" + scanDir.getAbsolutePath() + "]");
        if ((8388608 & scanFlags) == 0) goto L5;
        int parseFlags2 = parseFlags | 512;
    L12:
        this.mInstallPackageHelper.installPackagesFromDir(scanDir, parseFlags2, scanFlags, packageParser, executorService, apexInfo);     // Catch: Throwable -> L9
        Trace.traceEnd(262144);
        return;
    L9:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    L5:
        parseFlags2 = parseFlags;
        goto L12
    }

    public boolean isExpectingBetter(String packageName) {
        return this.mExpectingBetter.containsKey(packageName);
    }

    public List<ScanPartition> getDirsToScanAsSystem() {
        return this.mDirsToScanAsSystem;
    }

    public int getSystemScanFlags() {
        return this.mSystemScanFlags;
    }
}
