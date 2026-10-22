package com.android.server.pm.dex;

import android.R;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackagePartitions;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import android.util.jar.StrictJarFile;
import com.android.server.pm.PackageDexOptimizer;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.PackageManagerServiceUtils;
import com.android.server.pm.Settings;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes2.dex */
public class DexManager {
    private static final boolean DEBUG = false;
    private static final int DEX_SEARCH_FOUND_PRIMARY = 1;
    private static final int DEX_SEARCH_FOUND_SECONDARY = 3;
    private static final int DEX_SEARCH_FOUND_SPLIT = 2;
    private static final int DEX_SEARCH_NOT_FOUND = 0;
    private static final String ISOLATED_PROCESS_PACKAGE_SUFFIX = "..isolated";
    private static final String SYSTEM_SERVER_COMPILER_FILTER = "verify";
    private static final String TAG = "DexManager";
    private BatteryManager mBatteryManager;
    private final Context mContext;
    private final int mCriticalBatteryLevel;
    private final DynamicCodeLogger mDynamicCodeLogger;
    private final Map<String, PackageCodeLocations> mPackageCodeLocationsCache;
    private final PackageDexOptimizer mPackageDexOptimizer;
    private final PackageDexUsage mPackageDexUsage;
    private IPackageManager mPackageManager;
    private PowerManager mPowerManager;

    private class DexSearchResult {
        private final int mOutcome;
        private final String mOwningPackageName;

        /* JADX INFO: renamed from: -$$Nest$fgetmOutcome, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7043$$Nest$fgetmOutcome(DexSearchResult r0) {
            return r0.mOutcome;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOwningPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m7044$$Nest$fgetmOwningPackageName(DexSearchResult r0) {
            return r0.mOwningPackageName;
        }

        public DexSearchResult(DexManager r1, String owningPackageName, int outcome) {
            this.mOwningPackageName = owningPackageName;
            this.mOutcome = outcome;
        }

        public String toString() {
            return this.mOwningPackageName + "-" + this.mOutcome;
        }
    }

    private static class PackageCodeLocations {
        private final Map<Integer, Set<String>> mAppDataDirs;
        private String mBaseCodePath;
        private final String mPackageName;
        private final Set<String> mSplitCodePaths;

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m7045$$Nest$fgetmPackageName(PackageCodeLocations r0) {
            return r0.mPackageName;
        }

        public PackageCodeLocations(ApplicationInfo ai, int userId) {
            this(ai.packageName, ai.sourceDir, ai.splitSourceDirs);
            mergeAppDataDirs(ai.dataDir, userId);
        }

        public PackageCodeLocations(String packageName, String baseCodePath, String[] splitCodePaths) {
            this.mPackageName = packageName;
            this.mSplitCodePaths = new HashSet();
            this.mAppDataDirs = new HashMap();
            updateCodeLocation(baseCodePath, splitCodePaths);
        }

        public void updateCodeLocation(String baseCodePath, String[] splitCodePaths) {
            this.mBaseCodePath = baseCodePath;
            this.mSplitCodePaths.clear();
            if (splitCodePaths == null) goto L8;
            int r0 = splitCodePaths.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L10;
            String split = splitCodePaths[r1];
            this.mSplitCodePaths.add(split);
            r1 = r1 + 1;
            goto L6
        L10:
            return;
        }

        public void mergeAppDataDirs(String dataDir, int userId) {
            Set<String> dataDirs = (Set) DexManager.m7042$$Nest$smputIfAbsent(this.mAppDataDirs, Integer.valueOf(userId), new HashSet());
            dataDirs.add(dataDir);
        }

        public int searchDex(String dexPath, int userId) {
            Set<String> userDataDirs = this.mAppDataDirs.get(Integer.valueOf(userId));
            if (userDataDirs != null) goto L6;
            return 0;
        L6:
            if (this.mBaseCodePath.equals(dexPath) == false) goto L10;
            return 1;
        L10:
            if (this.mSplitCodePaths.contains(dexPath) == false) goto L13;
            return 2;
        L13:
            Iterator<String> r2 = userDataDirs.iterator();
        L15:
            if (r2.hasNext() == false) goto L21;
            String dataDir = r2.next();
            if (dexPath.startsWith(dataDir) == false) goto L15;
            return 3;
        L21:
            return 0;
        }
    }

    public static class RegisterDexModuleResult {
        public final String message;
        public final boolean success;

        public RegisterDexModuleResult() {
            this(false, null);
        }

        public RegisterDexModuleResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smputIfAbsent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7042$$Nest$smputIfAbsent(Map r0, Object r1, Object r2) {
        return putIfAbsent(r0, r1, r2);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public DexManager(Context context, PackageDexOptimizer pdo, DynamicCodeLogger dynamicCodeLogger) {
        this(context, pdo, dynamicCodeLogger, null);
    }

    public DexManager(Context context, PackageDexOptimizer pdo, DynamicCodeLogger dynamicCodeLogger, IPackageManager packageManager) {
        this.mBatteryManager = null;
        this.mPowerManager = null;
        this.mContext = context;
        this.mPackageCodeLocationsCache = new HashMap();
        this.mPackageDexUsage = new PackageDexUsage();
        this.mPackageDexOptimizer = pdo;
        this.mDynamicCodeLogger = dynamicCodeLogger;
        this.mPackageManager = packageManager;
        if (this.mContext == null) goto L8;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        if (this.mPowerManager != null) goto L7;
        Slog.wtf(TAG, "Power Manager is unavailable at time of Dex Manager start");
    L7:
        this.mCriticalBatteryLevel = this.mContext.getResources().getInteger(R.integer.config_defaultAlarmVibrationIntensity);
        return;
    L8:
        this.mCriticalBatteryLevel = 0;
    }

    private IPackageManager getPackageManager() {
        if (this.mPackageManager != null) goto L6;
        this.mPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService(Settings.ATTR_PACKAGE));
    L6:
        return this.mPackageManager;
    }

    public void notifyDexLoad(ApplicationInfo loadingAppInfo, Map<String, String> classLoaderContextMap, String loaderIsa, int loaderUserId, boolean loaderIsIsolatedProcess) {
        notifyDexLoadInternal(loadingAppInfo, classLoaderContextMap, loaderIsa, loaderUserId, loaderIsIsolatedProcess);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Exception while notifying dex load for package " + loadingAppInfo.packageName, e);
    }

    void notifyDexLoadInternal(ApplicationInfo loadingAppInfo, Map<String, String> classLoaderContextMap, String loaderIsa, int loaderUserId, boolean loaderIsIsolatedProcess) {
        int r5 = loaderUserId;
        if (classLoaderContextMap != null) goto L6;
        return;
    L6:
        if (classLoaderContextMap.isEmpty() == false) goto L10;
        Slog.wtf(TAG, "Bad call to notifyDexLoad: class loaders list is empty");
        return;
    L10:
        if (PackageManagerServiceUtils.checkISA(loaderIsa) == true) goto L13;
        Slog.w(TAG, "Loading dex files " + classLoaderContextMap.keySet() + " in unsupported ISA: " + loaderIsa + "?");
        return;
    L13:
        String r6 = loaderIsa;
        String loadingPackageAmendedName = loadingAppInfo.packageName;
        if (loaderIsIsolatedProcess == false) goto L16;
        String loadingPackageAmendedName2 = loadingPackageAmendedName + ISOLATED_PROCESS_PACKAGE_SUFFIX;
    L17:
        Iterator<Map.Entry<String, String>> r12 = classLoaderContextMap.entrySet().iterator();
    L19:
        if (r12.hasNext() == false) goto L51;
        Map.Entry<String, String> mapping = r12.next();
        String dexPath = mapping.getKey();
        DexSearchResult searchResult = getDexPackage(loadingAppInfo, dexPath, r5);
        if (DEBUG == false) goto L24;
        Slog.i(TAG, loadingPackageAmendedName2 + " loads from " + searchResult + " : " + r5 + " : " + dexPath);
    L24:
        if (DexSearchResult.m7043$$Nest$fgetmOutcome(searchResult) == 0) goto L48;
        boolean r3 = true;
        boolean isUsedByOtherApps = !loadingPackageAmendedName2.equals(DexSearchResult.m7044$$Nest$fgetmOwningPackageName(searchResult));
        if (DexSearchResult.m7043$$Nest$fgetmOutcome(searchResult) != 1) goto L28;
    L31:
        boolean primaryOrSplit = r3;
        if (primaryOrSplit == false) goto L37;
        if (isUsedByOtherApps == true) goto L37;
        if (isPlatformPackage(DexSearchResult.m7044$$Nest$fgetmOwningPackageName(searchResult)) == false) goto L19;
    L37:
        if (primaryOrSplit == true) goto L39;
        this.mDynamicCodeLogger.recordDex(r5, dexPath, DexSearchResult.m7044$$Nest$fgetmOwningPackageName(searchResult), loadingAppInfo.packageName);
    L39:
        String classLoaderContext = mapping.getValue();
        boolean overwriteCLC = isPlatformPackage(DexSearchResult.m7044$$Nest$fgetmOwningPackageName(searchResult));
        if (classLoaderContext != null) goto L42;
    L50:
        r6 = loaderIsa;
        r5 = loaderUserId;
        goto L19
    L42:
        if (VMRuntime.isValidClassLoaderContext(classLoaderContext) == false) goto L50;
        if (this.mPackageDexUsage.record(DexSearchResult.m7044$$Nest$fgetmOwningPackageName(searchResult), dexPath, r5, r6, primaryOrSplit, loadingPackageAmendedName2, classLoaderContext, overwriteCLC) == false) goto L50;
        this.mPackageDexUsage.maybeWriteAsync();
        goto L50
    L28:
        if (DexSearchResult.m7043$$Nest$fgetmOutcome(searchResult) == 2) goto L31;
        r3 = false;
        goto L31
    L48:
        if (DEBUG == false) goto L50;
        Slog.i(TAG, "Could not find owning package for dex file: " + dexPath);
        goto L50
    L51:
        return;
    L16:
        loadingPackageAmendedName2 = loadingPackageAmendedName;
        goto L17
    }

    private boolean isSystemServerDexPathSupportedForOdex(String dexPath) {
        ArrayList<PackagePartitions.SystemPartition> partitions = PackagePartitions.getOrderedPartitions(Function.identity());
        if (dexPath.startsWith("/apex/") == false) goto L5;
        return true;
    L5:
        int i = 0;
    L7:
        if (i >= partitions.size()) goto L12;
        if (partitions.get(i).containsPath(dexPath) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    }

    public void load(Map<Integer, List<PackageInfo>> existingPackages) {
        loadInternal(existingPackages);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        this.mPackageDexUsage.clear();
        Slog.w(TAG, "Exception while loading. Starting with a fresh state.", e);
    }

    public void notifyPackageInstalled(PackageInfo pi, int userId) {
        if (userId == (-1)) goto L7;
        cachePackageInfo(pi, userId);
        return;
    L7:
        throw new IllegalArgumentException("notifyPackageInstalled called with USER_ALL");
    }

    public void notifyPackageUpdated(String packageName, String baseCodePath, String[] splitCodePaths) {
        cachePackageCodeLocation(packageName, baseCodePath, splitCodePaths, null, -1);
        if (this.mPackageDexUsage.clearUsedByOtherApps(packageName) == false) goto L6;
        this.mPackageDexUsage.maybeWriteAsync();
        return;
    }

    public void notifyPackageDataDestroyed(String packageName, int userId) {
        if (userId != (-1)) goto L8;
        if (this.mPackageDexUsage.removePackage(packageName) == false) goto L11;
        this.mPackageDexUsage.maybeWriteAsync();
        return;
    L11:
        return;
    L8:
        if (this.mPackageDexUsage.removeUserPackage(packageName, userId) == false) goto L13;
        this.mPackageDexUsage.maybeWriteAsync();
        return;
    }

    private void cachePackageInfo(PackageInfo pi, int userId) {
        ApplicationInfo ai = pi.applicationInfo;
        String[] dataDirs = {ai.dataDir, ai.deviceProtectedDataDir, ai.credentialProtectedDataDir};
        cachePackageCodeLocation(pi.packageName, ai.sourceDir, ai.splitSourceDirs, dataDirs, userId);
    }

    private void cachePackageCodeLocation(String packageName, String baseCodePath, String[] splitCodePaths, String[] dataDirs, int userId) {
        Map<String, PackageCodeLocations> r0 = this.mPackageCodeLocationsCache;
        monitor-enter(r0);
        PackageCodeLocations pcl = (PackageCodeLocations) putIfAbsent(this.mPackageCodeLocationsCache, packageName, new PackageCodeLocations(packageName, baseCodePath, splitCodePaths));     // Catch: Throwable -> L11
        pcl.updateCodeLocation(baseCodePath, splitCodePaths);     // Catch: Throwable -> L11
        if (dataDirs == null) goto L14;
        int r2 = dataDirs.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L14;
        String dataDir = dataDirs[r3];     // Catch: Throwable -> L11
        if (dataDir == null) goto L13;
        pcl.mergeAppDataDirs(dataDir, userId);     // Catch: Throwable -> L11
    L13:
        r3 = r3 + 1;     // Catch: Throwable -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void loadInternal(Map<Integer, List<PackageInfo>> existingPackages) {
        Map<String, Set<Integer>> packageToUsersMap = new HashMap();
        Map<String, Set<String>> packageToCodePaths = new HashMap();
        Iterator<Map.Entry<Integer, List<PackageInfo>>> r2 = existingPackages.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<Integer, List<PackageInfo>> entry = r2.next();
        List<PackageInfo> packageInfoList = entry.getValue();
        int userId = entry.getKey().intValue();
        Iterator<PackageInfo> r6 = packageInfoList.iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        PackageInfo pi = r6.next();
        cachePackageInfo(pi, userId);
        Set<Integer> users = (Set) putIfAbsent(packageToUsersMap, pi.packageName, new HashSet());
        users.add(Integer.valueOf(userId));
        Set<String> codePaths = (Set) putIfAbsent(packageToCodePaths, pi.packageName, new HashSet());
        codePaths.add(pi.applicationInfo.sourceDir);
        if (pi.applicationInfo.splitSourceDirs == null) goto L7;
        Collections.addAll(codePaths, pi.applicationInfo.splitSourceDirs);
        goto L7
    L18:
        this.mPackageDexUsage.read();     // Catch: RuntimeException -> L15
        List<String> packagesToKeepDataAbout = new ArrayList();     // Catch: RuntimeException -> L15
        this.mPackageDexUsage.syncData(packageToUsersMap, packageToCodePaths, packagesToKeepDataAbout);     // Catch: RuntimeException -> L15
        return;
    L15:
        e = move-exception;
        this.mPackageDexUsage.clear();
        Slog.w(TAG, "Exception while loading package dex usage. Starting with a fresh state.", e);
    }

    public PackageDexUsage.PackageUseInfo getPackageUseInfoOrDefault(String packageName) {
        PackageDexUsage.PackageUseInfo useInfo = this.mPackageDexUsage.getPackageUseInfo(packageName);
        if (useInfo != null) goto L6;
        return new PackageDexUsage.PackageUseInfo(packageName);
    L6:
        return useInfo;
    }

    boolean hasInfoOnPackage(String packageName) {
        if (this.mPackageDexUsage.getPackageUseInfo(packageName) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private PackageDexOptimizer getPackageDexOptimizer(DexoptOptions options) {
        if (options.isForce() == false) goto L6;
        return new PackageDexOptimizer.ForcedUpdatePackageDexOptimizer(this.mPackageDexOptimizer);
    L6:
        return this.mPackageDexOptimizer;
    }

    public Set<String> getAllPackagesWithSecondaryDexFiles() {
        return this.mPackageDexUsage.getAllPackagesWithSecondaryDexFiles();
    }

    private DexSearchResult getDexPackage(ApplicationInfo loadingAppInfo, String dexPath, int userId) {
        PackageCodeLocations loadingPackageCodeLocations = new PackageCodeLocations(loadingAppInfo, userId);
        int outcome = loadingPackageCodeLocations.searchDex(dexPath, userId);
        if (outcome != 0) goto L5;
        Map<String, PackageCodeLocations> r2 = this.mPackageCodeLocationsCache;
        monitor-enter(r2);
        Iterator<PackageCodeLocations> r3 = this.mPackageCodeLocationsCache.values().iterator();     // Catch: Throwable -> L16
    L10:
        if (r3.hasNext() == false) goto L19;
        PackageCodeLocations pcl = r3.next();     // Catch: Throwable -> L16
        int outcome2 = pcl.searchDex(dexPath, userId);     // Catch: Throwable -> L16
        if (outcome2 == 0) goto L10;
        DexSearchResult r4 = new DexSearchResult(this, PackageCodeLocations.m7045$$Nest$fgetmPackageName(pcl), outcome2);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return r4;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L16
        if (isPlatformPackage(loadingAppInfo.packageName) == false) goto L28;
        if (isSystemServerDexPathSupportedForOdex(dexPath) == true) goto L25;
        Slog.wtf(TAG, "System server loads dex files outside paths supported for odex: " + dexPath);
        goto L28
    L25:
        return new DexSearchResult(this, PackageManagerService.PLATFORM_PACKAGE_NAME, 3);
    L28:
        if (DEBUG == false) goto L37;
        String dexPathReal = PackageManagerServiceUtils.realpath(new File(dexPath));     // Catch: IOException -> L33
        if (dexPath.equals(dexPathReal) == true) goto L37;
        Slog.d(TAG, "Dex loaded with symlink. dexPath=" + dexPath + " dexPathReal=" + dexPathReal);     // Catch: IOException -> L33
    L37:
        return new DexSearchResult(this, null, 0);
    L16:
        th = move-exception;
        throw th;
    L5:
        return new DexSearchResult(this, PackageCodeLocations.m7045$$Nest$fgetmPackageName(loadingPackageCodeLocations), outcome);
    }

    private static boolean isPlatformPackage(String packageName) {
        return PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName);
    }

    private static <K, V> V putIfAbsent(Map<K, V> map, K key, V newValue) {
        V existingValue = map.putIfAbsent(key, newValue);
        if (existingValue != null) goto L6;
        return newValue;
    L6:
        return existingValue;
    }

    public void writePackageDexUsageNow() {
        this.mPackageDexUsage.writeNow();
    }

    public static boolean auditUncompressedDexInApk(String fileName) {
        StrictJarFile jarFile = null;
        jarFile = new StrictJarFile(fileName, false, false);     // Catch: Throwable -> L13 IOException -> L15
        Iterator<ZipEntry> it = jarFile.iterator();     // Catch: Throwable -> L13 IOException -> L15
        boolean allCorrect = true;
    L4:
        if (it.hasNext() == false) goto L43;
        ZipEntry entry = it.next();     // Catch: Throwable -> L13 IOException -> L15
        if (entry.getName().endsWith(".dex") == false) goto L4;
        if (entry.getMethod() != 0) goto L11;
        if ((entry.getDataOffset() & 3) == 0) goto L4;
        allCorrect = false;
        Slog.w(TAG, "APK " + fileName + " has unaligned dex code " + entry.getName());     // Catch: Throwable -> L13 IOException -> L15
        goto L4
    L11:
        allCorrect = false;
        Slog.w(TAG, "APK " + fileName + " has compressed dex code " + entry.getName());     // Catch: Throwable -> L13 IOException -> L15
        goto L4
    L43:
        jarFile.close();     // Catch: IOException -> L24
    L26:
        return allCorrect;
    L13:
        th = move-exception;
        if (jarFile != null) goto L47;
    L40:
        throw th;
    L47:
        jarFile.close();     // Catch: IOException -> L38
    L28:
        Slog.wtf(TAG, "Error when parsing APK " + fileName);     // Catch: Throwable -> L13
        if (jarFile != null) goto L41;
    L34:
        return false;
    L41:
        jarFile.close();     // Catch: IOException -> L32
        goto L34
    }

    public int getCompilationReasonForInstallScenario(int installScenario) {
        boolean resourcesAreCritical = areBatteryThermalOrMemoryCritical();
        switch(installScenario) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L11;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        if (resourcesAreCritical == false) goto L9;
        return 8;
    L9:
        return 6;
    L11:
        if (resourcesAreCritical == false) goto L14;
        return 7;
    L14:
        return 5;
    L16:
        return 4;
    L18:
        return 3;
    L5:
        throw new IllegalArgumentException("Invalid installation scenario");
    }

    private BatteryManager getBatteryManager() {
        if (this.mBatteryManager != null) goto L8;
        if (this.mContext == null) goto L8;
        this.mBatteryManager = (BatteryManager) this.mContext.getSystemService(BatteryManager.class);
    L8:
        return this.mBatteryManager;
    }

    private boolean areBatteryThermalOrMemoryCritical() {
        BatteryManager batteryManager = getBatteryManager();
        if (batteryManager == null) goto L9;
        if (batteryManager.getIntProperty(6) != 3) goto L9;
        if (batteryManager.getIntProperty(4) > this.mCriticalBatteryLevel) goto L9;
    L12:
        return true;
    L9:
        if (this.mPowerManager != null) goto L11;
    L13:
        return false;
    L11:
        if (this.mPowerManager.getCurrentThermalStatus() < 3) goto L13;
        goto L12
    }
}
