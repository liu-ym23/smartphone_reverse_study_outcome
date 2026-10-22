package com.android.server.pm;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.dex.ArtManager;
import android.content.pm.dex.DexMetadataHelper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.WorkSource;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.content.F2fsUtils;
import com.android.server.apphibernation.AppHibernationManagerInternal;
import com.android.server.pm.dex.ArtManagerService;
import com.android.server.pm.dex.ArtStatsLogUtils;
import com.android.server.pm.dex.DexoptOptions;
import com.android.server.pm.dex.DexoptUtils;
import com.android.server.pm.dex.PackageDexUsage;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class PackageDexOptimizer {
    public static final int DEX_OPT_CANCELLED = 2;
    public static final int DEX_OPT_FAILED = -1;
    public static final int DEX_OPT_PERFORMED = 1;
    public static final int DEX_OPT_SKIPPED = 0;
    static final String OAT_DIR_NAME = "oat";
    private static final String TAG = "PackageDexOptimizer";
    private static final long WAKELOCK_TIMEOUT_MS = 660000;
    private static final Random sRandom = null;
    private final ArtStatsLogUtils.ArtStatsLogger mArtStatsLogger;
    private final Context mContext;
    private final PowerManager.WakeLock mDexoptWakeLock;
    private final Injector mInjector;
    private final PackageManagerTracedLock mInstallLock;
    private final Installer mInstaller;
    private volatile boolean mSystemReady;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DexOptResult {
    }

    public static class ForcedUpdatePackageDexOptimizer extends PackageDexOptimizer {
        public ForcedUpdatePackageDexOptimizer(Installer installer, PackageManagerTracedLock installLock, Context context, String wakeLockTag) {
            super(installer, installLock, context, wakeLockTag);
        }

        public ForcedUpdatePackageDexOptimizer(PackageDexOptimizer from) {
            super(from);
        }

        @Override // com.android.server.pm.PackageDexOptimizer
        protected int adjustDexoptNeeded(int dexoptNeeded) {
            if (dexoptNeeded != 0) goto L5;
            return -3;
        L5:
            return dexoptNeeded;
        }

        @Override // com.android.server.pm.PackageDexOptimizer
        protected int adjustDexoptFlags(int flags) {
            return flags | 64;
        }
    }

    interface Injector {
        AppHibernationManagerInternal getAppHibernationManagerInternal();

        PowerManager getPowerManager(Context r1);
    }

    static {
        sRandom = new Random();
    }

    PackageDexOptimizer(Installer installer, PackageManagerTracedLock installLock, Context context, String wakeLockTag) {
        this(new AnonymousClass1(), installer, installLock, context, wakeLockTag);
    }

    protected PackageDexOptimizer(PackageDexOptimizer from) {
        this.mArtStatsLogger = new ArtStatsLogUtils.ArtStatsLogger();
        this.mContext = from.mContext;
        this.mInstaller = from.mInstaller;
        this.mInstallLock = from.mInstallLock;
        this.mDexoptWakeLock = from.mDexoptWakeLock;
        this.mSystemReady = from.mSystemReady;
        this.mInjector = from.mInjector;
    }

    PackageDexOptimizer(Injector injector, Installer installer, PackageManagerTracedLock installLock, Context context, String wakeLockTag) {
        this.mArtStatsLogger = new ArtStatsLogUtils.ArtStatsLogger();
        this.mContext = context;
        this.mInstaller = installer;
        this.mInstallLock = installLock;
        PowerManager powerManager = injector.getPowerManager(context);
        this.mDexoptWakeLock = powerManager.newWakeLock(1, wakeLockTag);
        this.mInjector = injector;
    }

    boolean canOptimizePackage(AndroidPackage pkg) {
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(pkg.getPackageName()) == false) goto L6;
        return false;
    L6:
        if (pkg.isDeclaredHavingCode() == true) goto L9;
        return false;
    L9:
        if (pkg.isApex() == false) goto L11;
        return false;
    L11:
        AppHibernationManagerInternal ahm = this.mInjector.getAppHibernationManagerInternal();
        if (ahm != null) goto L14;
        return true;
    L14:
        if (ahm.isHibernatingGlobally(pkg.getPackageName()) == true) goto L16;
        return true;
    L16:
        if (ahm.isOatArtifactDeletionEnabled() == false) goto L21;
        return false;
    L21:
        return true;
    }

    int performDexOpt(AndroidPackage pkg, PackageStateInternal pkgSetting, String[] instructionSets, CompilerStats.PackageStats packageStats, PackageDexUsage.PackageUseInfo packageUseInfo, DexoptOptions options) throws Installer.LegacyDexoptDisabledException {
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(pkg.getPackageName()) == true) goto L35;
        if (pkg.getUid() == (-1)) goto L33;
        if (canOptimizePackage(pkg) == true) goto L10;
        return 0;
    L10:
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();
        long acquireTime = acquireWakeLockLI(pkg.getUid());     // Catch: Throwable -> L24
        int r0 = performDexOptLI(pkg, pkgSetting, instructionSets, packageStats, packageUseInfo, options);     // Catch: Throwable -> L20
    L14:
        releaseWakeLockLI(acquireTime);     // Catch: Throwable -> L18
        if (installLock == null) goto L17;
        installLock.close();
    L17:
        return r0;
    L20:
        th = move-exception;
        releaseWakeLockLI(acquireTime);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Throwable r2 = th;
    L26:
        if (installLock == null) goto L42;
        installLock.close();     // Catch: Throwable -> L29
        throw r2;
    L29:
        th = move-exception;
        r2.addSuppressed(th);
        throw r2;
    L42:
        throw r2;
    L24:
        th = move-exception;
        r2 = th;
        goto L26
    L33:
        throw new IllegalArgumentException("Dexopt for " + pkg.getPackageName() + " has invalid uid.");
    L35:
        throw new IllegalArgumentException("System server dexopting should be done via odrefresh");
    }

    private int performDexOptLI(AndroidPackage pkg, PackageStateInternal pkgSetting, String[] targetInstructionSets, CompilerStats.PackageStats packageStats, PackageDexUsage.PackageUseInfo packageUseInfo, DexoptOptions options) throws Installer.LegacyDexoptDisabledException {
        PackageDexOptimizer r1 = this;
        AndroidPackage r2 = pkg;
        List<SharedLibraryInfo> sharedLibraries = pkgSetting.getTransientState().getNonNativeUsesLibraryInfos();
        if (targetInstructionSets == null) goto L5;
        String[] r0 = targetInstructionSets;
    L6:
        String[] instructionSets = r0;
        String[] dexCodeInstructionSets = InstructionSets.getDexCodeInstructionSets(instructionSets);
        List<String> paths = AndroidPackageUtils.getAllCodePaths(r2);
        int sharedGid = UserHandle.getSharedAppGid(r2.getUid());
        int sharedGid2 = -1;
        if (sharedGid != (-1)) goto L9;
        Slog.wtf(TAG, "Well this is awkward; package " + r2.getPackageName() + " had UID " + r2.getUid(), new Throwable());
        int sharedGid3 = 9999;
    L10:
        boolean[] pathsWithCode = new boolean[paths.size()];
        pathsWithCode[0] = r2.isDeclaredHavingCode();
        int i = 1;
    L11:
        boolean r18 = true;
        if (i >= paths.size()) goto L18;
        if ((r2.getSplitFlags()[i - 1] & 4) != 0) goto L17;
        r18 = false;
    L17:
        pathsWithCode[i] = r18;
        i = i + 1;
        goto L11
    L18:
        String[] classLoaderContexts = DexoptUtils.getClassLoaderContexts(r2, sharedLibraries, pathsWithCode);
        if (paths.size() == classLoaderContexts.length) goto L26;
        String[] splitCodePaths = r2.getSplitCodePaths();
        StringBuilder r4 = new StringBuilder();
        r4.append("Inconsistent information between AndroidPackage and its ApplicationInfo. pkg.getAllCodePaths=");
        r4.append(paths);
        r4.append(" pkg.getBaseCodePath=");
        r4.append(r2.getBaseApkPath());
        r4.append(" pkg.getSplitCodePaths=");
        if (splitCodePaths != null) goto L23;
        String r5 = "null";
    L24:
        r4.append(r5);
        throw new IllegalStateException(r4.toString());
    L23:
        r5 = Arrays.toString(splitCodePaths);
        goto L24
    L26:
        int result = 0;
        int i2 = 0;
    L27:
        int result2 = paths.size();
        if (i2 >= result2) goto L164;
        if (pathsWithCode[i2] == true) goto L33;
    L38:
        List<SharedLibraryInfo> sharedLibraries2 = sharedLibraries;
        String[] dexCodeInstructionSets2 = dexCodeInstructionSets;
        List<String> paths2 = paths;
        int r3 = sharedGid2;
        int sharedGid4 = sharedGid3;
        boolean[] pathsWithCode2 = pathsWithCode;
        String[] classLoaderContexts2 = classLoaderContexts;
        int i3 = i2;
    L150:
        i2 = i3 + 1;
        r2 = pkg;
        sharedGid3 = sharedGid4;
        sharedLibraries = sharedLibraries2;
        dexCodeInstructionSets = dexCodeInstructionSets2;
        paths = paths2;
        pathsWithCode = pathsWithCode2;
        classLoaderContexts = classLoaderContexts2;
        sharedGid2 = r3;
        goto L27
    L33:
        if (classLoaderContexts[i2] == null) goto L161;
        String path = paths.get(i2);
        if (options.getSplitName() != null) goto L37;
    L39:
        if (i2 != 0) goto L41;
        String r6 = null;
    L42:
        String profileName = ArtManager.getProfileName(r6);
        if (options.isDexoptAsSharedLibrary() == false) goto L45;
        boolean isUsedByOtherApps = true;
    L46:
        String compilerFilter = r1.getRealCompilerFilter(r2, options.getCompilerFilter());
        if (DexFile.isProfileGuidedCompilerFilter(compilerFilter) == false) goto L52;
        if (isUsedByOtherApps == false) goto L52;
        if (options.getCompilationReason() == 3) goto L52;
        boolean r7 = true;
    L53:
        boolean useCloudProfile = r7;
        if (options.isDexoptInstallWithDexMetadata() == true) goto L58;
        if (useCloudProfile == true) goto L58;
        String dexMetadataPath = null;
    L64:
        if (options.isCheckForProfileUpdates() == false) goto L66;
        int profileAnalysisResult = r1.analyseProfiles(r2, sharedGid3, profileName, compilerFilter);
        int profileAnalysisResult2 = profileAnalysisResult;
    L67:
        String cloudProfileName = null;
        if (useCloudProfile == true) goto L175;
        String cloudProfileName2 = null;
        int profileAnalysisResult3 = profileAnalysisResult2;
        String profileName2 = profileName;
        String profileName3 = compilerFilter;
    L86:
        String path2 = path;
        int dexoptFlags = r1.getDexFlags(r2, pkgSetting, profileName3, useCloudProfile, options);     // Catch: Throwable -> L155
        int r8 = dexCodeInstructionSets.length;     // Catch: Throwable -> L153
        int newResult = 0;
    L91:
        if (newResult >= r8) goto L148;
        String dexCodeIsa = dexCodeInstructionSets[newResult];     // Catch: Throwable -> L146
        String[] dexCodeInstructionSets3 = dexCodeInstructionSets;
        String r9 = classLoaderContexts[i2];     // Catch: Throwable -> L144
        boolean[] pathsWithCode3 = pathsWithCode;
        boolean r12 = options.isDowngrade();     // Catch: Throwable -> L142
        int i4 = i2;
        int i5 = options.getCompilationReason();     // Catch: Throwable -> L140
        int r38 = r8;
        int r42 = newResult;
        List<String> paths3 = paths;
        String[] classLoaderContexts3 = classLoaderContexts;
        int result3 = result;
        String profileName4 = profileName2;
        List<SharedLibraryInfo> sharedLibraries3 = sharedLibraries;
        int dexoptFlags2 = dexoptFlags;
        String compilerFilter2 = profileName3;
        String dexMetadataPath2 = dexMetadataPath;
        int sharedGid5 = sharedGid3;
        String compilerFilter3 = path2;
        int newResult2 = dexOptPath(pkg, pkgSetting, compilerFilter3, dexCodeIsa, compilerFilter2, profileAnalysisResult3, r9, dexoptFlags2, sharedGid5, packageStats, r12, profileName4, dexMetadataPath2, i5);     // Catch: Throwable -> L138
        if (packageStats != null) goto L179;
        path2 = compilerFilter3;
        profileName3 = compilerFilter2;
    L121:
        if (newResult2 == 2) goto L123;
        result = result3;
        if (result == (-1)) goto L137;
        if (newResult2 == 0) goto L137;
        result = newResult2;
    L137:
        newResult = r42 + 1;
        dexoptFlags = dexoptFlags2;
        sharedGid3 = sharedGid5;
        profileName2 = profileName4;
        dexMetadataPath = dexMetadataPath2;
        sharedLibraries = sharedLibraries3;
        dexCodeInstructionSets = dexCodeInstructionSets3;
        paths = paths3;
        r8 = r38;
        pathsWithCode = pathsWithCode3;
        classLoaderContexts = classLoaderContexts3;
        i2 = i4;
        goto L91
    L123:
        if (result3 != (-1)) goto L129;
        if (cloudProfileName2 != null) goto L127;
        return result3;
    L127:
        throw new Installer.LegacyDexoptDisabledException();
    L129:
        if (cloudProfileName2 != null) goto L132;
        return newResult2;
    L132:
        throw new Installer.LegacyDexoptDisabledException();
    L179:
        Trace.traceBegin(16384, "dex2oat-metrics");     // Catch: Throwable -> L117
        long sessionId = sRandom.nextLong();     // Catch: Throwable -> L113
        path2 = compilerFilter3;
        ArtStatsLogUtils.writeStatsLog(this.mArtStatsLogger, sessionId, compilerFilter2, pkg.getUid(), packageStats.getCompileTime(compilerFilter3), dexMetadataPath2, options.getCompilationReason(), newResult2, ArtStatsLogUtils.getApkType(compilerFilter3, pkg.getBaseApkPath(), pkg.getSplitCodePaths()), dexCodeIsa, path2);     // Catch: Throwable -> L111
        profileName3 = compilerFilter2;
        Trace.traceEnd(16384);     // Catch: Throwable -> L109
    L109:
        th = th;
        cloudProfileName = cloudProfileName2;
    L157:
        if (cloudProfileName != null) goto L159;
        throw th;
    L159:
        throw new Installer.LegacyDexoptDisabledException();
    L111:
        th = th;
        profileName3 = compilerFilter2;
    L115:
        Trace.traceEnd(16384);     // Catch: Throwable -> L109
        throw th;     // Catch: Throwable -> L109
    L113:
        th = th;
        profileName3 = compilerFilter2;
    L117:
        th = th;
        cloudProfileName = cloudProfileName2;
    L138:
        th = th;
        cloudProfileName = cloudProfileName2;
    L140:
        th = th;
        cloudProfileName = cloudProfileName2;
    L142:
        th = th;
        cloudProfileName = cloudProfileName2;
    L144:
        th = th;
        cloudProfileName = cloudProfileName2;
    L146:
        th = th;
        cloudProfileName = cloudProfileName2;
        goto L157
    L148:
        dexCodeInstructionSets2 = dexCodeInstructionSets;
        paths2 = paths;
        sharedGid4 = sharedGid3;
        pathsWithCode2 = pathsWithCode;
        classLoaderContexts2 = classLoaderContexts;
        i3 = i2;
        sharedLibraries2 = sharedLibraries;
        r3 = -1;
        r1 = this;
        if (cloudProfileName2 == null) goto L150;
        throw new Installer.LegacyDexoptDisabledException();
    L153:
        th = th;
        cloudProfileName = cloudProfileName2;
    L155:
        th = th;
        cloudProfileName = cloudProfileName2;
        goto L157
    L175:
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L83
        r10.append("cloud-");     // Catch: Throwable -> L81
        r10.append(profileName);     // Catch: Throwable -> L81
        String cloudProfileName3 = r10.toString();     // Catch: Throwable -> L81
    L79:
        th = th;
        cloudProfileName = cloudProfileName3;
        goto L157
    L74:
        if (r1.prepareCloudProfile(r2, cloudProfileName3, path, dexMetadataPath) == false) goto L76;
        String profileName5 = cloudProfileName3;
        String compilerFilter4 = compilerFilter;
    L78:
        cloudProfileName2 = cloudProfileName3;
        profileAnalysisResult3 = 2;
        profileName2 = profileName5;
        profileName3 = compilerFilter4;
        goto L86
    L76:
        compilerFilter4 = PackageManagerServiceCompilerMapping.getCompilerFilterForReason(14);     // Catch: Throwable -> L79
        profileName5 = null;
    L81:
        th = th;
    L83:
        th = th;
        goto L157
    L66:
        profileAnalysisResult2 = 2;
    L58:
        File dexMetadataFile = DexMetadataHelper.findDexMetadataForFile(new File(path));
        if (dexMetadataFile != null) goto L61;
        String r19 = null;
    L62:
        String dexMetadataPath3 = r19;
        dexMetadataPath = dexMetadataPath3;
        goto L64
    L61:
        r19 = dexMetadataFile.getAbsolutePath();
    L52:
        r7 = false;
        goto L53
    L45:
        isUsedByOtherApps = false;
        goto L46
    L41:
        r6 = r2.getSplitNames()[i2 - 1];
        goto L42
    L37:
        if (options.getSplitName().equals(new File(path).getName()) == true) goto L39;
    L161:
        int i6 = i2;
        throw new IllegalStateException("Inconsistent information in the package structure. A split is marked to contain code but has no dependency listed. Index=" + i6 + " path=" + paths.get(i6));
    L164:
        return result;
    L9:
        sharedGid3 = sharedGid;
        goto L10
    L5:
        r0 = InstructionSets.getAppDexInstructionSets(pkgSetting.getPrimaryCpuAbi(), pkgSetting.getSecondaryCpuAbi());
        goto L6
    }

    private boolean prepareCloudProfile(AndroidPackage pkg, String profileName, String path, String dexMetadataPath) throws Installer.LegacyDexoptDisabledException {
        if (dexMetadataPath != null) goto L4;
        return false;
    L4:
        if (this.mInstaller.isIsolated() == false) goto L8;
        return true;
    L8:
        throw new Installer.LegacyDexoptDisabledException();
    }

    private int dexOptPath(AndroidPackage pkg, PackageStateInternal pkgSetting, String path, String isa, String compilerFilter, int profileAnalysisResult, String classLoaderContext, int dexoptFlags, int uid, CompilerStats.PackageStats packageStats, boolean downgrade, String profileName, String dexMetadataPath, int compilationReason) throws Installer.LegacyDexoptDisabledException {
        String oatDir = getPackageOatDirIfSupported(pkgSetting, pkg);
        int dexoptNeeded = getDexoptNeeded(pkg.getPackageName(), path, isa, compilerFilter, classLoaderContext, profileAnalysisResult, downgrade, dexoptFlags, oatDir);
        boolean r4 = false;
        if (Math.abs(dexoptNeeded) != 0) goto L5;
        return 0;
    L5:
        Log.i(TAG, "Running dexopt (dexoptNeeded=" + dexoptNeeded + ") on: " + path + " pkg=" + pkg.getPackageName() + " isa=" + isa + " dexoptFlags=" + printDexoptFlags(dexoptFlags) + " targetFilter=" + compilerFilter + " oatDir=" + oatDir + " classLoaderContext=" + classLoaderContext);
        long startTime = System.currentTimeMillis();     // Catch: Installer.InstallerException -> L32
        String seInfo = pkgSetting.getSeInfo();     // Catch: Installer.InstallerException -> L32
        Installer r2 = getInstallerLI();     // Catch: Installer.InstallerException -> L30
        String r5 = pkg.getPackageName();     // Catch: Installer.InstallerException -> L30
        String r11 = pkg.getVolumeUuid();     // Catch: Installer.InstallerException -> L30
        int r15 = pkg.getTargetSdkVersion();     // Catch: Installer.InstallerException -> L30
        if (dexMetadataPath == null) goto L11;
        r4 = true;
    L11:
        String r18 = getAugmentedReasonName(compilationReason, r4);     // Catch: Installer.InstallerException -> L30
        String r21 = TAG;
        boolean completed = r2.dexopt(path, uid, r5, isa, dexoptNeeded, oatDir, dexoptFlags, compilerFilter, r11, classLoaderContext, seInfo, false, r15, profileName, dexMetadataPath, r18);     // Catch: Installer.InstallerException -> L20
        if (completed == true) goto L17;
        return 2;
    L17:
        if (packageStats == null) goto L22;
        long endTime = System.currentTimeMillis();     // Catch: Installer.InstallerException -> L20
        packageStats.setCompileTime(path, (int) (endTime - startTime));     // Catch: Installer.InstallerException -> L20
    L22:
        if (oatDir == null) goto L29;
        ContentResolver resolver = this.mContext.getContentResolver();     // Catch: Installer.InstallerException -> L26
        F2fsUtils.releaseCompressedBlocks(resolver, new File(oatDir));     // Catch: Installer.InstallerException -> L26
    L26:
        e = e;
    L34:
        Slog.w(r21, "Failed to dexopt", e);
        return -1;
    L29:
        return 1;
    L20:
        e = e;
    L30:
        e = e;
        r21 = TAG;
    L32:
        e = e;
        r21 = TAG;
        goto L34
    }

    private String getAugmentedReasonName(int compilationReason, boolean useDexMetadata) {
        if (useDexMetadata == false) goto L4;
        String annotation = ArtManagerService.DEXOPT_REASON_WITH_DEX_METADATA_ANNOTATION;
    L6:
        return PackageManagerServiceCompilerMapping.getReasonName(compilationReason) + annotation;
    L4:
        annotation = "";
        goto L6
    }

    private long acquireWakeLockLI(int uid) {
        if (this.mSystemReady == true) goto L6;
        return -1;
    L6:
        this.mDexoptWakeLock.setWorkSource(new WorkSource(uid));
        this.mDexoptWakeLock.acquire(WAKELOCK_TIMEOUT_MS);
        return SystemClock.elapsedRealtime();
    }

    private void releaseWakeLockLI(long acquireTime) {
        if (acquireTime >= 0) goto L16;
        return;
    L16:
    L8:
        e = move-exception;
        Slog.wtf(TAG, "Error while releasing " + this.mDexoptWakeLock.getTag() + " lock", e);
        return;
    L6:
        if (this.mDexoptWakeLock.isHeld() == false) goto L10;
        this.mDexoptWakeLock.release();     // Catch: RuntimeException -> L8
    L10:
        long duration = SystemClock.elapsedRealtime() - acquireTime;     // Catch: RuntimeException -> L8
        if (duration < WAKELOCK_TIMEOUT_MS) goto L19;
        Slog.wtf(TAG, "WakeLock " + this.mDexoptWakeLock.getTag() + " time out. Operation took " + duration + " ms. Thread: " + Thread.currentThread().getName());     // Catch: RuntimeException -> L8
        return;
    }

    protected int adjustDexoptNeeded(int dexoptNeeded) {
        return dexoptNeeded;
    }

    protected int adjustDexoptFlags(int dexoptFlags) {
        return dexoptFlags;
    }

    private String getRealCompilerFilter(ApplicationInfo info, String targetCompilerFilter, boolean isUsedByOtherApps) {
        if (info.isEmbeddedDexUsed() == false) goto L10;
        if (DexFile.isOptimizedCompilerFilter(targetCompilerFilter) == false) goto L8;
        return "verify";
    L8:
        return targetCompilerFilter;
    L10:
        if ((info.flags & 16384) == 0) goto L12;
    L15:
        boolean vmSafeModeOrDebuggable = true;
    L16:
        if (vmSafeModeOrDebuggable == false) goto L20;
        return DexFile.getSafeModeCompilerFilter(targetCompilerFilter);
    L20:
        if (DexFile.isProfileGuidedCompilerFilter(targetCompilerFilter) == false) goto L24;
        if (isUsedByOtherApps == false) goto L24;
        return PackageManagerServiceCompilerMapping.getCompilerFilterForReason(14);
    L24:
        return targetCompilerFilter;
    L12:
        if ((info.flags & 2) != 0) goto L15;
        vmSafeModeOrDebuggable = false;
        goto L16
    }

    private String getRealCompilerFilter(AndroidPackage pkg, String targetCompilerFilter) {
        if (pkg.isUseEmbeddedDex() == false) goto L10;
        if (DexFile.isOptimizedCompilerFilter(targetCompilerFilter) == false) goto L8;
        return "verify";
    L8:
        return targetCompilerFilter;
    L10:
        if (pkg.isVmSafeMode() == false) goto L12;
    L15:
        boolean vmSafeModeOrDebuggable = true;
    L16:
        if (vmSafeModeOrDebuggable == true) goto L18;
        return targetCompilerFilter;
    L18:
        return DexFile.getSafeModeCompilerFilter(targetCompilerFilter);
    L12:
        if (pkg.isDebuggable() == true) goto L15;
        vmSafeModeOrDebuggable = false;
        goto L16
    }

    private boolean isAppImageEnabled() {
        if (SystemProperties.get("dalvik.vm.appimageformat", "").length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int getDexFlags(ApplicationInfo info, String compilerFilter, DexoptOptions options) {
        if ((info.flags & 2) == 0) goto L6;
        boolean r0 = true;
    L5:
        boolean r2 = r0;
        return getDexFlags(r2, info.getHiddenApiEnforcementPolicy(), info.splitDependencies, info.requestsIsolatedSplitLoading(), compilerFilter, false, options);
    L6:
        r0 = false;
        goto L5
    }

    private int getDexFlags(AndroidPackage pkg, PackageStateInternal pkgSetting, String compilerFilter, boolean useCloudProfile, DexoptOptions options) {
        return getDexFlags(pkg.isDebuggable(), AndroidPackageUtils.getHiddenApiEnforcementPolicy(pkg, pkgSetting), pkg.getSplitDependencies(), pkg.isIsolatedSplitLoading(), compilerFilter, useCloudProfile, options);
    }

    private int getDexFlags(boolean debuggable, int hiddenApiEnforcementPolicy, SparseArray<int[]> splitDependencies, boolean requestsIsolatedSplitLoading, String compilerFilter, boolean useCloudProfile, DexoptOptions options) {
        boolean isProfileGuidedFilter = DexFile.isProfileGuidedCompilerFilter(compilerFilter);
        boolean generateAppImage = true;
        int r2 = 0;
        if (isProfileGuidedFilter == true) goto L5;
    L9:
        boolean isPublic = true;
    L10:
        if (isProfileGuidedFilter == false) goto L12;
        int profileFlag = 16;
    L13:
        if (hiddenApiEnforcementPolicy != 0) goto L15;
        int hiddenApiFlag = 0;
    L16:
        int compilationReason = options.getCompilationReason();
        boolean generateCompactDex = true;
        switch(compilationReason) {
            case 0: goto L19;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            default: goto L20;
        };
    L19:
        generateCompactDex = false;
    L20:
        if (isProfileGuidedFilter == false) goto L26;
        if (splitDependencies == null) goto L24;
        if (requestsIsolatedSplitLoading == true) goto L26;
    L24:
        if (isAppImageEnabled() == false) goto L26;
    L28:
        if (isPublic == false) goto L30;
        int r8 = 2;
    L31:
        if (debuggable == false) goto L33;
        int r9 = 4;
    L34:
        int r10 = (r8 | r9) | profileFlag;
        if (options.isBootComplete() == false) goto L37;
        int r11 = 8;
    L38:
        int r12 = r10 | r11;
        if (options.isDexoptIdleBackgroundJob() == false) goto L41;
        int r13 = 512;
    L42:
        int r14 = r12 | r13;
        if (generateCompactDex == false) goto L45;
        int r15 = 2048;
    L46:
        int r16 = r14 | r15;
        if (generateAppImage == false) goto L49;
        int r17 = 4096;
    L50:
        int r18 = r16 | r17;
        if (options.isDexoptInstallForRestore() == false) goto L53;
        r2 = 8192;
    L53:
        int dexFlags = (r2 | r18) | hiddenApiFlag;
        return adjustDexoptFlags(dexFlags);
    L49:
        r17 = 0;
        goto L50
    L45:
        r15 = 0;
        goto L46
    L41:
        r13 = 0;
        goto L42
    L37:
        r11 = 0;
        goto L38
    L33:
        r9 = 0;
        goto L34
    L30:
        r8 = 0;
    L26:
        generateAppImage = false;
        goto L28
    L15:
        hiddenApiFlag = 1024;
        goto L16
    L12:
        profileFlag = 0;
        goto L13
    L5:
        if (options.isDexoptInstallWithDexMetadata() == true) goto L9;
        if (useCloudProfile == true) goto L9;
        isPublic = false;
        goto L10
    }

    private int getDexoptNeeded(String packageName, String path, String isa, String compilerFilter, String classLoaderContext, int profileAnalysisResult, boolean downgrade, int dexoptFlags, String oatDir) throws Installer.LegacyDexoptDisabledException {
        if (this.mInstaller.isIsolated() == false) goto L42;
        boolean newProfile = false;
        if ((dexoptFlags & 2) == 0) goto L7;
        boolean r0 = true;
    L8:
        boolean shouldBePublic = r0;
        if ((dexoptFlags & 16) == 0) goto L11;
        boolean r1 = true;
    L12:
        boolean isProfileGuidedFilter = r1;
        if (profileAnalysisResult != 1) goto L15;
        newProfile = true;
    L15:
        if (newProfile == true) goto L21;
        if (isProfileGuidedFilter == false) goto L21;
        if (shouldBePublic == false) goto L21;
        String r3 = isa;
        if (isOdexPrivate(packageName, path, r3, oatDir) == false) goto L22;
        boolean newProfile2 = true;
    L43:
    L31:
        ioe = move-exception;
        Slog.w(TAG, "IOException reading apk: " + path, ioe);
        return -1;
    L29:
        e = move-exception;
        Slog.wtf(TAG, "Unexpected exception when calling dexoptNeeded on " + path, e);
        return -1;
    L25:
        if (compilerFilterDependsOnProfiles(compilerFilter) == true) goto L27;
    L33:
        String actualCompilerFilter = compilerFilter;
    L34:
        int dexoptNeeded = DexFile.getDexOptNeeded(path, r3, actualCompilerFilter, classLoaderContext, newProfile2, downgrade);     // Catch: RuntimeException -> L29 IOException -> L31
    L36:
        return adjustDexoptNeeded(dexoptNeeded);
    L27:
        if (profileAnalysisResult != 3) goto L33;
        actualCompilerFilter = "verify";
    L22:
        newProfile2 = newProfile;
    L21:
        r3 = isa;
        goto L22
    L11:
        r1 = false;
        goto L12
    L7:
        r0 = false;
        goto L8
    L42:
        throw new Installer.LegacyDexoptDisabledException();
    }

    private boolean compilerFilterDependsOnProfiles(String compilerFilter) {
        return compilerFilter.endsWith("-profile");
    }

    private boolean isOdexPrivate(String packageName, String path, String isa, String oatDir) throws Installer.LegacyDexoptDisabledException {
        throw new Installer.LegacyDexoptDisabledException();
    }

    private int analyseProfiles(AndroidPackage pkg, int uid, String profileName, String compilerFilter) throws Installer.LegacyDexoptDisabledException {
        throw new Installer.LegacyDexoptDisabledException();
    }

    private String getPackageOatDirIfSupported(PackageState packageState, AndroidPackage pkg) {
        if (AndroidPackageUtils.canHaveOatDir(packageState, pkg) == true) goto L5;
        return null;
    L5:
        File codePath = new File(pkg.getPath());
        if (codePath.isDirectory() == true) goto L9;
        return null;
    L9:
        return getOatDir(codePath).getAbsolutePath();
    }

    public static File getOatDir(File codePath) {
        return new File(codePath, OAT_DIR_NAME);
    }

    void systemReady() {
        this.mSystemReady = true;
    }

    private String printDexoptFlags(int flags) {
        ArrayList<String> flagsList = new ArrayList();
        if ((flags & 8) != 8) goto L6;
        flagsList.add("boot_complete");
    L6:
        if ((flags & 4) != 4) goto L9;
        flagsList.add("debuggable");
    L9:
        if ((flags & 16) != 16) goto L12;
        flagsList.add("profile_guided");
    L12:
        if ((flags & 2) != 2) goto L15;
        flagsList.add("public");
    L15:
        if ((flags & 32) != 32) goto L18;
        flagsList.add("secondary");
    L18:
        if ((flags & 64) != 64) goto L21;
        flagsList.add("force");
    L21:
        if ((flags & 128) != 128) goto L24;
        flagsList.add("storage_ce");
    L24:
        if ((flags & 256) != 256) goto L27;
        flagsList.add("storage_de");
    L27:
        if ((flags & 512) != 512) goto L30;
        flagsList.add("idle_background_job");
    L30:
        if ((flags & 1024) != 1024) goto L33;
        flagsList.add("enable_hidden_api_checks");
    L33:
        return String.join(",", flagsList);
    }

    private Installer getInstallerLI() {
        return this.mInstaller;
    }
}
