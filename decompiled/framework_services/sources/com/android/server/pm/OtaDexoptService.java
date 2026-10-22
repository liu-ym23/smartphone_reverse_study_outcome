package com.android.server.pm;

import android.content.Context;
import android.content.pm.IOtaDexopt;
import android.content.pm.PackageManagerInternal;
import android.os.Environment;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.storage.StorageManager;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.server.LocalServices;
import com.android.server.pm.dex.DexoptOptions;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class OtaDexoptService extends IOtaDexopt.Stub {
    private static final long BULK_DELETE_THRESHOLD = 1073741824;
    private static final boolean DEBUG_DEXOPT = true;
    private static final String TAG = "OTADexopt";
    private long availableSpaceAfterBulkDelete;
    private long availableSpaceAfterDexopt;
    private long availableSpaceBefore;
    private int completeSize;
    private int dexoptCommandCountExecuted;
    private int dexoptCommandCountTotal;
    private int importantPackageCount;
    private final Context mContext;
    private List<String> mDexoptCommands;
    private final PackageManagerService mPackageManagerService;
    private final MetricsLogger metricsLogger;
    private long otaDexoptTimeStart;
    private int otherPackageCount;

    private static class OTADexoptPackageDexOptimizer extends PackageDexOptimizer.ForcedUpdatePackageDexOptimizer {
        OTADexoptPackageDexOptimizer(Installer installer, PackageManagerTracedLock installLock, Context context) {
            super(installer, installLock, context, "*otadexopt*");
        }
    }

    public static /* synthetic */ long $r8$lambda$ShJ1ZQvtPUOjonCWBRh0LwxXMfk(PackageStateInternal r2) {
        return lambda$prepare$1(r2);
    }

    public static /* synthetic */ boolean $r8$lambda$yvePCxmjcSjYe1V_IdlomlLLA2M(PackageStateInternal r0) {
        return lambda$prepare$0(r0);
    }

    public OtaDexoptService(Context context, PackageManagerService packageManagerService) {
        this.mContext = context;
        this.mPackageManagerService = packageManagerService;
        this.metricsLogger = new MetricsLogger();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.IBinder, com.android.server.pm.OtaDexoptService] */
    public static OtaDexoptService main(Context context, PackageManagerService packageManagerService) {
        ?? r0 = new OtaDexoptService(context, packageManagerService);
        ServiceManager.addService("otadexopt", r0);
        r0.moveAbArtifacts(packageManagerService.mInstaller);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new OtaDexoptShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    public synchronized void prepare() throws RemoteException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mDexoptCommands != null) goto L38;
        Predicate<? super PackageStateInternal> isPlatformPackage = new OtaDexoptService$$ExternalSyntheticLambda0();     // Catch: Throwable -> L10
        Computer snapshot = this.mPackageManagerService.snapshotComputer();     // Catch: Throwable -> L10
        Collection<? extends PackageStateInternal> allPackageStates = snapshot.getPackageStates().values();     // Catch: Throwable -> L10
        List<PackageStateInternal> important = DexOptHelper.getPackagesForDexopt(allPackageStates, this.mPackageManagerService, true);     // Catch: Throwable -> L10
        important.removeIf(isPlatformPackage);     // Catch: Throwable -> L10
        List<PackageStateInternal> others = new ArrayList(allPackageStates);     // Catch: Throwable -> L10
        others.removeAll(important);     // Catch: Throwable -> L10
        others.removeIf(PackageManagerServiceUtils.REMOVE_IF_NULL_PKG);     // Catch: Throwable -> L10
        others.removeIf(PackageManagerServiceUtils.REMOVE_IF_APEX_PKG);     // Catch: Throwable -> L10
        others.removeIf(isPlatformPackage);     // Catch: Throwable -> L10
        this.mDexoptCommands = new ArrayList((allPackageStates.size() * 3) / 2);     // Catch: Throwable -> L10
        Iterator<PackageStateInternal> r0 = important.iterator();     // Catch: Throwable -> L10
    L8:
        if (r0.hasNext() == false) goto L12;
        PackageStateInternal pkgSetting = r0.next();     // Catch: Throwable -> L10
        this.mDexoptCommands.addAll(generatePackageDexopts(pkgSetting.getPkg(), pkgSetting, 10));     // Catch: Throwable -> L10
        goto L8
    L12:
        Iterator<PackageStateInternal> r1 = others.iterator();     // Catch: Throwable -> L10
    L14:
        if (r1.hasNext() == false) goto L20;
        PackageStateInternal pkgSetting2 = r1.next();     // Catch: Throwable -> L10
        if (pkgSetting2.getPkg().isCoreApp() == true) goto L19;
        this.mDexoptCommands.addAll(generatePackageDexopts(pkgSetting2.getPkg(), pkgSetting2, 0));     // Catch: Throwable -> L10
        goto L14
    L19:
        throw new IllegalStateException("Found a core app that's not important");     // Catch: Throwable -> L10
    L20:
        this.completeSize = this.mDexoptCommands.size();     // Catch: Throwable -> L10
        long spaceAvailable = getAvailableSpace();     // Catch: Throwable -> L10
        if (spaceAvailable >= 1073741824) goto L26;
        Log.i(TAG, "Low on space, deleting oat files in an attempt to free up space: " + DexOptHelper.packagesToString(others));     // Catch: Throwable -> L10
        Iterator<PackageStateInternal> r2 = others.iterator();     // Catch: Throwable -> L10
    L24:
        if (r2.hasNext() == false) goto L26;
        PackageStateInternal pkg = r2.next();     // Catch: Throwable -> L10
        this.mPackageManagerService.deleteOatArtifactsOfPackage(snapshot, pkg.getPackageName());     // Catch: Throwable -> L10
    L26:
        long spaceAvailableNow = getAvailableSpace();     // Catch: Throwable -> L10
        prepareMetricsLogging(important.size(), others.size(), spaceAvailable, spaceAvailableNow);     // Catch: Throwable -> L10
        PackageStateInternal lastUsed = (PackageStateInternal) Collections.max(important, Comparator.comparingLong(new OtaDexoptService$$ExternalSyntheticLambda1()));     // Catch: Throwable -> L10 RuntimeException -> L32
        Log.d(TAG, "A/B OTA: lastUsed time = " + lastUsed.getTransientState().getLatestForegroundPackageUseTimeInMills());     // Catch: Throwable -> L10 RuntimeException -> L32
        Log.d(TAG, "A/B OTA: deprioritized packages:");     // Catch: Throwable -> L10 RuntimeException -> L32
        Iterator<PackageStateInternal> r3 = others.iterator();     // Catch: Throwable -> L10 RuntimeException -> L32
    L29:
        if (r3.hasNext() == false) goto L35;
        PackageStateInternal pkgSetting3 = r3.next();     // Catch: Throwable -> L10 RuntimeException -> L32
        Log.d(TAG, "  " + pkgSetting3.getPackageName() + " - " + pkgSetting3.getTransientState().getLatestForegroundPackageUseTimeInMills());     // Catch: Throwable -> L10 RuntimeException -> L32
    L35:
        monitor-exit(this);
        return;
    L38:
        throw new IllegalStateException("already called prepare()");     // Catch: Throwable -> L10
    }

    private static /* synthetic */ boolean lambda$prepare$0(PackageStateInternal pkgSetting) {
        return PackageManagerService.PLATFORM_PACKAGE_NAME.equals(pkgSetting.getPkg().getPackageName());
    }

    private static /* synthetic */ long lambda$prepare$1(PackageStateInternal pkgSetting) {
        return pkgSetting.getTransientState().getLatestForegroundPackageUseTimeInMills();
    }

    public synchronized void cleanup() throws RemoteException {
        monitor-enter(this);
        Log.i(TAG, "Cleaning up OTA Dexopt state.");     // Catch: Throwable -> L6
        this.mDexoptCommands = null;     // Catch: Throwable -> L6
        this.availableSpaceAfterDexopt = getAvailableSpace();     // Catch: Throwable -> L6
        performMetricsLogging();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isDone() throws RemoteException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mDexoptCommands == null) goto L11;
        boolean r0 = this.mDexoptCommands.isEmpty();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L11:
        throw new IllegalStateException("done() called before prepare()");     // Catch: Throwable -> L8
    }

    public synchronized float getProgress() throws RemoteException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.completeSize != 0) goto L8;
        monitor-exit(this);
        return 1.0f;
    L8:
        int commandsLeft = this.mDexoptCommands.size();     // Catch: Throwable -> L12
        float r1 = (this.completeSize - commandsLeft) / this.completeSize;
        monitor-exit(this);
        return r1;
    }

    public synchronized String nextDexoptCommand() throws RemoteException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mDexoptCommands == null) goto L21;
        if (this.mDexoptCommands.isEmpty() == true) goto L8;
        String next = this.mDexoptCommands.remove(0);     // Catch: Throwable -> L10
        if (getAvailableSpace() <= 0) goto L17;
        this.dexoptCommandCountExecuted++;     // Catch: Throwable -> L10
        Log.d(TAG, "Next command: " + next);     // Catch: Throwable -> L10
        monitor-exit(this);
        return next;
    L17:
        Log.w(TAG, "Not enough space for OTA dexopt, stopping with " + (this.mDexoptCommands.size() + 1) + " commands left.");     // Catch: Throwable -> L10
        this.mDexoptCommands.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return "(no free space)";
    L8:
        monitor-exit(this);
        return "(all done)";
    L21:
        throw new IllegalStateException("dexoptNextPackage() called before prepare()");     // Catch: Throwable -> L10
    }

    private long getMainLowSpaceThreshold() {
        File dataDir = Environment.getDataDirectory();
        long lowThreshold = StorageManager.from(this.mContext).getStorageLowBytes(dataDir);
        if (lowThreshold == 0) goto L6;
        return lowThreshold;
    L6:
        throw new IllegalStateException("Invalid low memory threshold");
    }

    private long getAvailableSpace() {
        long lowThreshold = getMainLowSpaceThreshold();
        File dataDir = Environment.getDataDirectory();
        long usableSpace = dataDir.getUsableSpace();
        return usableSpace - lowThreshold;
    }

    private synchronized List<String> generatePackageDexopts(AndroidPackage pkg, PackageStateInternal pkgSetting, int compilationReason) {
        monitor-enter(this);
        final List<String> commands = new ArrayList();     // Catch: Throwable -> L9
        final Context r2 = this.mContext;     // Catch: Throwable -> L9
        final boolean r3 = true;
        Installer collectingInstaller = new AnonymousClass1(this, r2, r3, commands);     // Catch: Throwable -> L9
        PackageDexOptimizer optimizer = new OTADexoptPackageDexOptimizer(collectingInstaller, this.mPackageManagerService.mInstallLock, this.mContext);     // Catch: Throwable -> L9
        optimizer.performDexOpt(pkg, pkgSetting, null, null, this.mPackageManagerService.getDexManager().getPackageUseInfoOrDefault(pkg.getPackageName()), new DexoptOptions(pkg.getPackageName(), compilationReason, 4));     // Catch: Throwable -> L9 Installer.LegacyDexoptDisabledException -> L11
    L17:
        monitor-exit(this);
        return commands;
    L11:
        e = move-exception;
        Installer.LegacyDexoptDisabledException e = e;
    L16:
        Slog.wtf(TAG, e);     // Catch: Throwable -> L9
    L13:
        e = move-exception;
        e = e;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void dexoptNextPackage() throws RemoteException {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new UnsupportedOperationException();     // Catch: Throwable -> L5
    }

    private void moveAbArtifacts(Installer installer) {
        OtaDexoptService r1 = this;
        if (r1.mDexoptCommands != null) goto L48;
        if (r1.mPackageManagerService.isDeviceUpgrading() == true) goto L8;
        Slog.d(TAG, "No upgrade, skipping A/B artifacts check.");
        return;
    L8:
        ArrayMap<String, ? extends PackageStateInternal> packageStates = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageStates();
        int packagePaths = 0;
        int pathsSuccessful = 0;
        int index = 0;
    L10:
        if (index >= packageStates.size()) goto L45;
        PackageStateInternal packageState = packageStates.valueAt(index);
        AndroidPackage pkg = packageState.getPkg();
        if (pkg == null) goto L44;
        if (r1.mPackageManagerService.mPackageDexOptimizer.canOptimizePackage(pkg) == false) goto L44;
        if (pkg.getPath() != null) goto L21;
        Slog.w(TAG, "Package " + pkg + " can be optimized but has null codePath");
        goto L44
    L21:
        if (pkg.getPath().startsWith("/system") == true) goto L44;
        if (pkg.getPath().startsWith("/vendor") == true) goto L44;
        if (pkg.getPath().startsWith("/product") == true) goto L44;
        if (pkg.getPath().startsWith("/system_ext") == true) goto L44;
        String[] instructionSets = InstructionSets.getAppDexInstructionSets(packageState.getPrimaryCpuAbi(), packageState.getSecondaryCpuAbi());
        List<String> paths = AndroidPackageUtils.getAllCodePathsExcludingResourceOnly(pkg);
        String[] dexCodeInstructionSets = InstructionSets.getDexCodeInstructionSets(instructionSets);
        String packageName = pkg.getPackageName();
        int r12 = dexCodeInstructionSets.length;
        int r13 = 0;
    L30:
        if (r13 >= r12) goto L44;
        String dexCodeInstructionSet = dexCodeInstructionSets[r13];
        Iterator<String> r15 = paths.iterator();
    L33:
        if (r15.hasNext() == false) goto L39;
        String path = r15.next();
        ArrayMap<String, ? extends PackageStateInternal> packageStates2 = packageStates;
        String oatDir = PackageDexOptimizer.getOatDir(new File(pkg.getPath())).getAbsolutePath();
        int packagePaths2 = packagePaths + 1;
        int index2 = index;
        installer.moveAb(packageName, path, dexCodeInstructionSet, oatDir);     // Catch: Installer.InstallerException -> L37
        pathsSuccessful = pathsSuccessful + 1;
    L38:
        packagePaths = packagePaths2;
        packageStates = packageStates2;
        index = index2;
        goto L33
    L39:
        r13 = r13 + 1;
        index = index;
    L44:
        index = index + 1;
        packageStates = packageStates;
        r1 = this;
        goto L10
    L45:
        Slog.i(TAG, "Moved " + pathsSuccessful + SliceClientPermissions.SliceAuthority.DELIMITER + packagePaths);
        return;
    L48:
        throw new IllegalStateException("Should not be ota-dexopting when trying to move.");
    }

    private void prepareMetricsLogging(int important, int others, long spaceBegin, long spaceBulk) {
        this.availableSpaceBefore = spaceBegin;
        this.availableSpaceAfterBulkDelete = spaceBulk;
        this.availableSpaceAfterDexopt = 0;
        this.importantPackageCount = important;
        this.otherPackageCount = others;
        this.dexoptCommandCountTotal = this.mDexoptCommands.size();
        this.dexoptCommandCountExecuted = 0;
        this.otaDexoptTimeStart = System.nanoTime();
    }

    private static int inMegabytes(long value) {
        long in_mega_bytes = value / DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES;
        if (in_mega_bytes <= 2147483647L) goto L7;
        Log.w(TAG, "Recording " + in_mega_bytes + "MB of free space, overflowing range");
        return Integer.MAX_VALUE;
    L7:
        return (int) in_mega_bytes;
    }

    private void performMetricsLogging() {
        long finalTime = System.nanoTime();
        this.metricsLogger.histogram("ota_dexopt_available_space_before_mb", inMegabytes(this.availableSpaceBefore));
        this.metricsLogger.histogram("ota_dexopt_available_space_after_bulk_delete_mb", inMegabytes(this.availableSpaceAfterBulkDelete));
        this.metricsLogger.histogram("ota_dexopt_available_space_after_dexopt_mb", inMegabytes(this.availableSpaceAfterDexopt));
        this.metricsLogger.histogram("ota_dexopt_num_important_packages", this.importantPackageCount);
        this.metricsLogger.histogram("ota_dexopt_num_other_packages", this.otherPackageCount);
        this.metricsLogger.histogram("ota_dexopt_num_commands", this.dexoptCommandCountTotal);
        this.metricsLogger.histogram("ota_dexopt_num_commands_executed", this.dexoptCommandCountExecuted);
        int elapsedTimeSeconds = (int) TimeUnit.NANOSECONDS.toSeconds(finalTime - this.otaDexoptTimeStart);
        this.metricsLogger.histogram("ota_dexopt_time_s", elapsedTimeSeconds);
    }
}
